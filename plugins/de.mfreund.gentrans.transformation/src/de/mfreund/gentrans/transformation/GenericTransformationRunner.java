package de.mfreund.gentrans.transformation;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

import pamtram.PAMTraM;
import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.TargetSectionClass;

/**
 * Main Class for running the generic transformation for a PAMTraM model.
 * @author Sascha Steffen
 * @version 0.8
 */
public class GenericTransformationRunner {

	/**
	 * Constructor
	 * @param sourceModel Root EObject of the source Model
	 * @param pamtramPath Path to the transformation model
	 * @param targetFilePath File path to the transformation target
	 */
	public GenericTransformationRunner(EObject sourceModel,
			String pamtramPath, String targetFilePath) {
		super();
		this.sourceModel = sourceModel;
		this.pamtramPath = pamtramPath;
		this.targetFilePath=targetFilePath;
		consoleStream=findConsole("de.mfreund.gentrans.transformation_" + this.hashCode()).newMessageStream();

	}
	
	/**
	 * Writes a message on the console that helps to divide the transformation output into different stages of the transformation
	 * @param msg
	 */
	private void writePamtramMessage(String msg){
		consoleStream.println(
				"\n################# "
				+ msg
				+ " #################\n");
	}

	/**
	 * Root EObject of the source Model
	 */
	private EObject sourceModel;
	
	/**
	 * Path to the transformation model
	 */
	private String pamtramPath;
	/**
	 * File path to the transformation target
	 */
	private String targetFilePath;
	/**
	 * Message output stream (Console view)
	 */
	private MessageConsoleStream consoleStream;
	
	
	/**
	 * Get the output Console. Copied from: @see <a href="http://wiki.eclipse.org/FAQ_How_do_I_write_to_the_console_from_a_plug-in%3F">Eclipse FAQ</a>
	 * @param consoleName
	 * @return MessageConsole object
	 */
	private MessageConsole findConsole(String consoleName) {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager conMan = plugin.getConsoleManager();
		IConsole[] existing = conMan.getConsoles();
		for (int i = 0; i < existing.length; i++)
			if (consoleName.equals(existing[i].getName()))
				return (MessageConsole) existing[i];
		// no console found, so create a new one
		MessageConsole myConsole = new MessageConsole(consoleName, null);
		conMan.addConsoles(new IConsole[] { myConsole });
		return myConsole;
	}


	/**
	 * Starts the transformation.
	 */
	@SuppressWarnings("unchecked")
	public void runTransformation() {
		XMIResource targetModel, pamtramResource;
		
		XMIResourceFactoryImpl resFactory = new XMIResourceFactoryImpl();
		
		// Create a resource set. 
		ResourceSet resourceSet = new ResourceSetImpl(); 

		 // the selected resource (IMPORTANT: needs to be represented as absolute URI with "file://" scheme; 
		// if other schemes are used, the relative paths to the wprops and other model files are not set correct!)
		URI pamtramUri = URI.createFileURI(new java.io.File(pamtramPath).toString());

		//try to load pamtram model
		 pamtramResource = (XMIResource) resourceSet.getResource(pamtramUri, true);
		 
		 try {
			pamtramResource.load(Collections.EMPTY_MAP);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		 PAMTraM pamtramModel= (PAMTraM) pamtramResource.getContents().get(0);
		 
		

		// TODO check if the xmi resource already exists
		try {
			// try to create the xmi resource
			URI targetFileUri = URI.createFileURI(new java.io.File(targetFilePath).toString());
			targetModel = (XMIResource) resFactory
					.createResource(targetFileUri);
			targetModel.setEncoding("UTF-8");


		} catch (Exception e) {
			MessageDialog
					.openError(PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getShell(), "Error",
							"The XMI resource for thhe targetModel output could not be created.");
			e.printStackTrace();
			return;
		}
		
		// find and resolve ambiguous mappings as far as possible without user
		// input
		List<Mapping> suitableMappings = pamtramModel.getMappingModel()
				.getMapping();// TODO apply contextModel

		// generate storage objects and generators
		SourceSectionMapper sourceSectionMapper = new SourceSectionMapper(suitableMappings, consoleStream);
		TargetSectionRegistry targetSectionRegistry = new TargetSectionRegistry(consoleStream);
		AttributeValueRegistry attrValueRegistry = new AttributeValueRegistry();
		TargetSectionConnector connectionHelpers = new TargetSectionConnector(
				attrValueRegistry, targetSectionRegistry, targetModel, consoleStream);
		TargetSectionInstantiator targetSectionInstantiator = new TargetSectionInstantiator(
				targetSectionRegistry, attrValueRegistry, consoleStream);

		/*
		 * create a list of all the containment references in the source model
		 */
		writePamtramMessage("Analysing srcModel containment references...");

		// list of all unmapped nodes. obtained by iterating over all of the
		// srcModels containment refs
		List<EObject> contRefsToMap = SourceSectionMapper
				.buildContainmentTree(sourceModel);

		/*
		 * now start mapping each one of the references. We automatically start
		 * at the sourceModel root node
		 */
		LinkedList<MappingInstanceStorage> selectedMappings = new LinkedList<MappingInstanceStorage>();
		LinkedHashMap<Mapping, LinkedList<MappingInstanceStorage>> selectedMappingsByMapping = new LinkedHashMap<Mapping, LinkedList<MappingInstanceStorage>>();
		writePamtramMessage("Selecting Mappings for source model elements...");

		int numSrcModelElements = contRefsToMap.size();
		int unmapped=0;
		while (contRefsToMap.size() > 0) {
			// find mapping
			// remove(0) automatically selects element highest in the hierarchy
			// we currently try to map

			MappingInstanceStorage selectedMapping = sourceSectionMapper
					.findMapping(contRefsToMap);
			if(sourceSectionMapper.isTransformationAborted()){
				writePamtramMessage("Transformation aborted.");
				return;
			}
			if (selectedMapping != null) {
				selectedMappings.add(selectedMapping);
				if (!selectedMappingsByMapping.containsKey(selectedMapping
						.getMapping())) {
					selectedMappingsByMapping.put(selectedMapping.getMapping(),
							new LinkedList<MappingInstanceStorage>());
				}
				selectedMappingsByMapping.get(selectedMapping.getMapping())
						.add(selectedMapping);

			} else {
				unmapped++;
			}

		}
		consoleStream.println("Used srcModel elements: "
				+ (numSrcModelElements - unmapped));
		targetSectionRegistry.analyseTargetMetaModel(pamtramModel.getTargetSectionModel().getMetaModelPackage());

		
		/*
		 * Now write MappingHint values of Hints of ExportedMappingHintGroups to a separate storage,
		 * and remove the values from the MappingInstanceStorages
		 */
		consoleStream.println("Getting hint values of exported hint groups");//TODO remove if it works
		Map<MappingHint, List<Object>> exportedMappingHints=new LinkedHashMap<MappingHint, List<Object>>();
		for(MappingInstanceStorage selMap : selectedMappings){
			for(MappingHintGroupType g : selMap.getMapping().getMappingHintGroups()){
				if(g instanceof ExportedMappingHintGroup){
					for(MappingHint h : g.getMappingHints()){
						if(!exportedMappingHints.containsKey(h)){
							exportedMappingHints.put(h, new LinkedList<Object>());
						}
						exportedMappingHints.get(h).addAll(selMap.getHintValues().remove(h));//this works because the SourceSectionMapper guarantees that a key exists 
																						     //for each MappingHint of the Mapping
					}
				}
			}
		}

		writePamtramMessage("Instantiating targetModelSections for selected mappings. First pass...");
		for (MappingInstanceStorage selMap : selectedMappings) {
			for (MappingHintGroupType g : selMap.getMapping().getMappingHintGroups()) {
				if (g.getTargetMMSection() != null && g instanceof MappingHintGroup) {

					LinkedHashMap<TargetSectionClass, LinkedList<EObjectTransformationHelper>> instancesBySection = targetSectionInstantiator
							.instantiateTargetSectionFirstPass(
									g.getTargetMMSection(), (MappingHintGroup) g,
									selMap.getHintValues(),
									selMap.getModelConnectionHintValues(),
									selMap.getMapping());
					if (instancesBySection == null) {
						if (g.getTargetMMSection().getCardinality() != CardinalityType.ZERO_INFINITY) {// Error
							consoleStream
									.println("Error instantiating target section '"
											+ g.getTargetMMSection().getName()
											+ "' using mapping rule '"
											+ selMap.getMapping().getName()
											+ "'");
						}
					} else {
						for (TargetSectionClass section : instancesBySection.keySet()) {
							selMap.addInstances((MappingHintGroup) g, section,
									instancesBySection.get(section));
						}
					}
				}

			}
			
			
		}

		// creating missing links/containers for target model
		writePamtramMessage("Linking targetModelSections...");

		for (Mapping m : suitableMappings) {
			for (MappingHintGroupType g : m.getMappingHintGroups()) {
				if (g.getTargetMMSection() != null && g instanceof MappingHintGroup) {// targetSection exists?
					TargetSectionClass section = g.getTargetMMSection();
					if (targetSectionRegistry.getPamtramClassInstances(section)
							.keySet().size() > 0) {// instances of section
													// exist?
						if (targetSectionRegistry.getPamtramClassInstances(
								section).get(g) != null) {// ..also of specific
															// group
							if (((MappingHintGroup)g).getModelConnectionMatcher() != null) {// link
																		// using
																		// matcher
								for (MappingInstanceStorage selMap : selectedMappingsByMapping
										.get(m)) {
									if (selMap.getInstances((MappingHintGroup) g, section) != null) {
										connectionHelpers
												.linkToTargetModelUsingModelConnectionHint(
														section.getEClass(),
														(List<EObjectTransformationHelper>) selMap
																.getInstances(
																		(MappingHintGroup) g,
																		section)
																.clone(),
														section,
														m.getName(),
														g.getName(),
														((MappingHintGroup) g).getModelConnectionMatcher(),
														selMap.getModelConnectionHintValues(((MappingHintGroup) g)
																.getModelConnectionMatcher()));
										if(connectionHelpers.isTransformationAborted()){
											writePamtramMessage("Transformation aborted.");
											return;
										}
									}
								}
							} else {// link using container attribute or nothing
								LinkedList<EObjectTransformationHelper> containerInstances = targetSectionRegistry.getFlattenedPamtramClassInstances(section.getContainer());
								LinkedList<EObjectTransformationHelper> rootInstances = targetSectionRegistry.getPamtramClassInstances(section).get(g);		
								containerInstances.removeAll(rootInstances);//we do not want the rootinstances to contain themselves
								
								connectionHelpers.linkToTargetModelNoConnectionHint(
										section.getEClass(),
										rootInstances,
										section, m.getName(), g.getName(),
										section.getContainer() != null,
										containerInstances
								);
								if(connectionHelpers.isTransformationAborted()){
									writePamtramMessage("Transformation aborted.");
									return;
								}
							}
						}
					}
				}
			}
			
			for(MappingHintGroupImporter i : m.getImportedMappingHintGroups()){
				ExportedMappingHintGroup g=i.getHintGroup();
				if(g.getTargetMMSection() != null){
						for(MappingInstanceStorage selMap: selectedMappingsByMapping.get(m)){
							LinkedList<EObjectTransformationHelper> rootInstances=selMap.getInstances(i, g.getTargetMMSection());
							if(rootInstances.size()> 0){
								LinkedList<EObjectTransformationHelper> containerInstances = new LinkedList<EObjectTransformationHelper>();
								if(i.getContainer() != null){
									//get container instances created by this mapping instance
									for(MappingHintGroupType group : m.getMappingHintGroups()){
										if(group instanceof MappingHintGroup){
											LinkedList<EObjectTransformationHelper> insts=selMap.getInstances((MappingHintGroup) group, i.getContainer());
											if(insts != null){
												containerInstances.addAll(insts);
											}
											
										}
									}
								}
								//link
								connectionHelpers.linkToTargetModelNoConnectionHint(
										g.getTargetMMSection().getEClass(),
										rootInstances,
										g.getTargetMMSection(), m.getName(), g.getName(),
										i.getContainer() != null,
										containerInstances
								);
								if(connectionHelpers.isTransformationAborted()){
									writePamtramMessage("Transformation aborted.");
									return;
								}						
							}
						}
						
					}
			}
		}

		// creating target Model second pass (non-containment references)
		consoleStream
				.println("Instantiating targetModelSections for selected mappings. Second pass...");
		for (MappingInstanceStorage selMap : selectedMappings) {
			for (MappingHintGroupType g : selMap.getMapping().getMappingHintGroups()) {
				if (g.getTargetMMSection() != null && g instanceof MappingHintGroup) {
					if (selMap.getInstancesBySection((MappingHintGroup) g) != null) {
						targetSectionInstantiator
								.instantiateTargetSectionSecondPass(
										g.getTargetMMSection(),
										selMap.getMapping(), (MappingHintGroup) g,
										g.getMappingHints(),
										selMap.getHintValues(),
										selMap.getInstancesBySection((MappingHintGroup) g));
						if(targetSectionInstantiator.isTransformationAborted()){
							writePamtramMessage("Transformation aborted.");
							return;
						}
					}
				}
			}

		}
		
		//save targetModel
		try {
			// try to save the xmi resource
//			xmiResource.save(Collections.EMPTY_MAP);
			Map<Object, Object> options = new LinkedHashMap<Object, Object>();
			options.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);
			options.put(XMIResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.TRUE);
			targetModel.save(Collections.EMPTY_MAP);
			writePamtramMessage("Transformation done");
		} catch (Exception e) {
			MessageDialog.openError(
					PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getShell(), "Error", "The XMI resource could not be saved.");
			e.printStackTrace();
			return;
		}

	}
}
