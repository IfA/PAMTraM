package de.mfreund.gentrans.transformation;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.progress.UIJob;

import pamtram.PAMTraM;
import pamtram.mapping.AttributeMapping;
import pamtram.mapping.ComplexAttributeMapping;
import pamtram.mapping.ComplexAttributeMappingSourceInterface;
import pamtram.mapping.ComplexAttributeMatcher;
import pamtram.mapping.ComplexAttributeMatcherSourceInterface;
import pamtram.mapping.ComplexModelConnectionHint;
import pamtram.mapping.ComplexModelConnectionHintSourceInterface;
import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.ExternalMappedAttributeValuePrepender;
import pamtram.mapping.GlobalVariableImporter;
import pamtram.mapping.MappedAttributeValueExpanderType;
import pamtram.mapping.MappedAttributeValuePrepender;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingHintType;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.SimpleAttributeMapping;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.TargetSectionClass;

/**
 * Main Class for running the generic transformation for a PAMTraM model.
 * @author Sascha Steffen, Matthias Freund
 * @version 0.9
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
		
		// brings the console view to the front
		showConsole();
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
	 * Brings the console view to the foreground. If the view is
	 * closed, it will be opened.
	 */
	private void showConsole() {
		// as the transformation runs in a non-UI thread, we have to use
		// a UIJob to find the console viw
		UIJob job = new UIJob("Show Console View") {
			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().
						getActivePage().showView("org.eclipse.ui.console.ConsoleView");
				} catch (PartInitException e) {
					e.printStackTrace();
					return Status.CANCEL_STATUS;
				}
				return Status.OK_STATUS;
			}
		};
		job.schedule();
	}


	/**
	 * Starts the transformation.
	 */
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

		if(executeMappings(targetModel, pamtramModel, suitableMappings)){
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

	/**
	 * @param targetModel
	 * @param pamtramModel
	 * @param suitableMappings
	 */
	private boolean executeMappings(XMIResource targetModel, PAMTraM pamtramModel,
			List<Mapping> suitableMappings) {
		// generate storage objects and generators
		SourceSectionMapper sourceSectionMapper = new SourceSectionMapper(suitableMappings, consoleStream);
		TargetSectionRegistry targetSectionRegistry = new TargetSectionRegistry(consoleStream);
		AttributeValueRegistry attrValueRegistry = new AttributeValueRegistry();

		/*
		 * create a list of all the containment references in the source model
		 */
		writePamtramMessage("Analysing srcModel containment references");

		// list of all unmapped nodes. obtained by iterating over all of the
		// srcModels containment refs
		List<EObject> contRefsToMap = SourceSectionMapper.buildContainmentTree(sourceModel);

		/*
		 * now start mapping each one of the references. We automatically start
		 * at the sourceModel root node
		 */
		LinkedList<MappingInstanceStorage> selectedMappings = new LinkedList<MappingInstanceStorage>();
		LinkedHashMap<Mapping, LinkedList<MappingInstanceStorage>> selectedMappingsByMapping = new LinkedHashMap<Mapping, LinkedList<MappingInstanceStorage>>();
		writePamtramMessage("Selecting Mappings for source model elements");

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
				return false;
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
		 * and remove the values from the MappingInstanceStorages.
		 * 
		 * Also add values of GlobalVariables to ComplexAttributeMapping's Hints
		 */
		Map<MappingHint, LinkedList<Object>> exportedMappingHints = handleGlobalVarsAndExportedMappings(
				sourceSectionMapper, selectedMappings);

		/*
		 * Instantiate all Target-Sections (containment refs and attributes)
		 */	
		writePamtramMessage("Instantiating targetModelSections for selected mappings. First pass");
		TargetSectionInstantiator targetSectionInstantiator = runInstantiationFirstPass(
				sourceSectionMapper, targetSectionRegistry, attrValueRegistry,
				selectedMappings, exportedMappingHints);

		// creating missing links/containers for target model
		writePamtramMessage("Linking targetModelSections");
		if(!linkTargetSections(targetModel, suitableMappings,targetSectionRegistry, attrValueRegistry,selectedMappingsByMapping)){
			return false;
		}

		// creating target Model second pass (non-containment references)
		writePamtramMessage("Instantiating targetModelSections for selected mappings. Second pass");
		return runInstantiationSecondPass(selectedMappings, targetSectionInstantiator);
	}

	/**
	 * @param selectedMappings
	 * @param targetSectionInstantiator
	 * @return
	 */
	private boolean runInstantiationSecondPass(
			LinkedList<MappingInstanceStorage> selectedMappings,
			TargetSectionInstantiator targetSectionInstantiator) {
		for (MappingInstanceStorage selMap : selectedMappings) {
			for (MappingHintGroupType g : selMap.getMapping().getMappingHintGroups()) {
				if (g.getTargetMMSection() != null && g instanceof MappingHintGroup) {
					if (selMap.getInstancesBySection((MappingHintGroup) g) != null) {
						targetSectionInstantiator
								.instantiateTargetSectionSecondPass(
										g.getTargetMMSection(),
										selMap.getMapping().getName(), (MappingHintGroup) g,
										g.getTargetMMSection(),
										g.getMappingHints(),
										selMap.getHintValues(),
										selMap.getInstancesBySection((MappingHintGroup) g)
							);
						if(targetSectionInstantiator.isTransformationAborted()){
							writePamtramMessage("Transformation aborted.");
							return false;
						}
					}
				}
			}
			
			for(MappingHintGroupImporter g : selMap.getMapping().getImportedMappingHintGroups()){
				ExportedMappingHintGroup expGrp= g.getHintGroup();
				if (expGrp.getTargetMMSection() != null) {
					if (selMap.getInstancesBySection(g) != null) {
						List<MappingHint> hints=new LinkedList<MappingHint>();
						hints.addAll(expGrp.getMappingHints());
						for(MappingHintType h : g.getMappingHints()){
							if(h instanceof MappingHint){
								hints.add((MappingHint) h);
							}//TODO else if ...??-> should have already been done during 1st pass 
						}
						
						targetSectionInstantiator
								.instantiateTargetSectionSecondPass(
										expGrp.getTargetMMSection(),
										selMap.getMapping().getName(), g,
										expGrp.getTargetMMSection(),
										hints,
										selMap.getHintValues(),
										selMap.getInstancesBySection(g)
						);
						if(targetSectionInstantiator.isTransformationAborted()){
							writePamtramMessage("Transformation aborted.");
							return false;
						}
					}
				}
			}

		}
		
		return true;
	}

	/**
	 * @param targetModel
	 * @param suitableMappings
	 * @param targetSectionRegistry
	 * @param attrValueRegistry
	 * @param selectedMappingsByMapping
	 * @return
	 */
	private boolean linkTargetSections(
			XMIResource targetModel,
			List<Mapping> suitableMappings,
			TargetSectionRegistry targetSectionRegistry,
			AttributeValueRegistry attrValueRegistry,
			LinkedHashMap<Mapping, LinkedList<MappingInstanceStorage>> selectedMappingsByMapping) {
		TargetSectionConnector connectionHelpers = new TargetSectionConnector(
				attrValueRegistry, targetSectionRegistry, targetModel, consoleStream);
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
								for (MappingInstanceStorage selMap : selectedMappingsByMapping.get(m)) {
									if (selMap.getInstances((MappingHintGroup) g, section) != null) {
										connectionHelpers.linkToTargetModelUsingModelConnectionHint(
												section.getEClass(),
												new LinkedList<EObjectTransformationHelper>( selMap.getInstances((MappingHintGroup) g,section)),
												section,
												m.getName(),
												g.getName(),
												((MappingHintGroup) g).getModelConnectionMatcher(),
												selMap.getModelConnectionHintValues(((MappingHintGroup) g).getModelConnectionMatcher()));
										if(connectionHelpers.isTransformationAborted()){
											writePamtramMessage("Transformation aborted.");
											return false;
										}
									}
								}
							} else {// link using container attribute or nothing
								LinkedList<EObjectTransformationHelper> containerInstances = targetSectionRegistry.getFlattenedPamtramClassInstances(section.getContainer());
								LinkedList<EObjectTransformationHelper> rootInstances = targetSectionRegistry.getPamtramClassInstances(section).get(g);		
								containerInstances.removeAll(rootInstances);//we do not want the rootinstances to contain themselves
								Set<EClass> containerClasses=new HashSet<EClass>();
								if(section.getContainer() != null){
									containerClasses.add(section.getContainer().getEClass());
								}
								connectionHelpers.linkToTargetModelNoConnectionHint(
										section.getEClass(),
										rootInstances,
										section, m.getName(), g.getName(),
										section.getContainer() != null,
										containerClasses,
										containerInstances
										);
								if(connectionHelpers.isTransformationAborted()){
									writePamtramMessage("Transformation aborted.");
									return false;
								}
							}
						}
					}
				}
			}

			for(MappingHintGroupImporter i : m.getImportedMappingHintGroups()){
				ExportedMappingHintGroup g=i.getHintGroup();
				if(g.getTargetMMSection() != null){
					/*
					 * ImportedMAppingHintGroups with containers specified will be linked 
					 * to a section that was created by the same mapping Instance
					 */
					if(i.getContainer() != null){
						for(MappingInstanceStorage selMap: selectedMappingsByMapping.get(m)){
							LinkedList<EObjectTransformationHelper> rootInstances=selMap.getInstances(i, g.getTargetMMSection());
							if(rootInstances.size()> 0){
								LinkedList<EObjectTransformationHelper> containerInstances = new LinkedList<EObjectTransformationHelper>();
								Set<EClass> containerClasses=new HashSet<EClass>();

								containerClasses.add(i.getContainer().getEClass());
								//get container instances created by this mapping instance
								for(MappingHintGroupType group : m.getMappingHintGroups()){
									if(group instanceof MappingHintGroup){
										LinkedList<EObjectTransformationHelper> insts=selMap.getInstances((MappingHintGroup) group, i.getContainer());
										if(insts != null){
											containerInstances.addAll(insts);
										}

									}
								}
								//link
								connectionHelpers.linkToTargetModelNoConnectionHint(
										g.getTargetMMSection().getEClass(),
										rootInstances,
										g.getTargetMMSection(), m.getName(), g.getName(),
										true,
										containerClasses,										
										containerInstances
										);
								if(connectionHelpers.isTransformationAborted()){
									writePamtramMessage("Transformation aborted.");
									return false;
								}						
							}
						}

						//use container attribute of targetSection if one is specified
						//(target section container == global instance search)
					} else {
						LinkedList<EObjectTransformationHelper> containerInstances = new LinkedList<EObjectTransformationHelper>();
						LinkedList<EObjectTransformationHelper> rootInstances=targetSectionRegistry.getPamtramClassInstances(g.getTargetMMSection()).get(i);
						Set<EClass> containerClasses=new HashSet<EClass>();
						if (g.getTargetMMSection().getContainer() != null){
							containerClasses.add(g.getTargetMMSection().getContainer().getEClass());
							containerInstances.addAll(targetSectionRegistry.getFlattenedPamtramClassInstances(g.getTargetMMSection().getContainer()));

						}
						
						if(rootInstances.size() > 0){
							//link
							connectionHelpers.linkToTargetModelNoConnectionHint(
									g.getTargetMMSection().getEClass(),
									rootInstances,
									g.getTargetMMSection(), m.getName(), g.getName(),
									containerClasses.size() > 0,
									containerClasses,										
									containerInstances
									);
							if(connectionHelpers.isTransformationAborted()){
								writePamtramMessage("Transformation aborted.");
								return false;
							}
						}
					}

				}
			}
		}
		return true;
	}

	/**
	 * Instantiates the containment Refs of the target sections
	 * @param sourceSectionMapper
	 * @param targetSectionRegistry
	 * @param attrValueRegistry
	 * @param selectedMappings
	 * @param exportedMappingHints
	 * @return
	 */
	private TargetSectionInstantiator runInstantiationFirstPass(
			SourceSectionMapper sourceSectionMapper,
			TargetSectionRegistry targetSectionRegistry,
			AttributeValueRegistry attrValueRegistry,
			LinkedList<MappingInstanceStorage> selectedMappings,
			Map<MappingHint, LinkedList<Object>> exportedMappingHints) {
		TargetSectionInstantiator targetSectionInstantiator = new TargetSectionInstantiator(
				targetSectionRegistry, attrValueRegistry,sourceSectionMapper.getGlobalVarValues(),consoleStream);			
		for (MappingInstanceStorage selMap : selectedMappings) {
			for (MappingHintGroupType g : selMap.getMapping().getMappingHintGroups()) {
				if (g.getTargetMMSection() != null && g instanceof MappingHintGroup) {

					LinkedHashMap<TargetSectionClass, LinkedList<EObjectTransformationHelper>> instancesBySection = targetSectionInstantiator
							.instantiateTargetSectionFirstPass(
									g.getTargetMMSection(), (MappingHintGroup) g,
									g.getMappingHints(),
									selMap.getHintValues(),
									selMap.getModelConnectionHintValues(),
									selMap.getMapping().getName());
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
			
			for(MappingHintGroupImporter g : selMap.getMapping().getImportedMappingHintGroups()){
				ExportedMappingHintGroup expGrp=g.getHintGroup();
				if(expGrp != null){
					//import Hints
					for(MappingHint h : expGrp.getMappingHints()){
						selMap.getHintValues().put(h, new LinkedList<Object>(exportedMappingHints.get(h)));
					}
					//start instantiating
					if(expGrp.getTargetMMSection() != null){

						List<MappingHint> hints=new LinkedList<MappingHint>();
						hints.addAll(expGrp.getMappingHints());
						for(MappingHintType h : g.getMappingHints()){
							if(h instanceof MappingHint){
								hints.add((MappingHint) h);
							} else if(h instanceof MappedAttributeValueExpanderType){
								if(selMap.getHintValues().get(h).size() == 1){
									String hintVal=(String) selMap.getHintValues().get(h).getFirst();
									boolean prepend=h instanceof MappedAttributeValuePrepender || h instanceof ExternalMappedAttributeValuePrepender;//of course this works only because the only other option is the Appender
									for(MappingHint realHint : g.getHintGroup().getMappingHints()){
										if(realHint instanceof AttributeMapping){
											if(((AttributeMapping) realHint).getTarget().equals(((MappedAttributeValueExpanderType) h).getTargetAttribute())){
												if(realHint instanceof SimpleAttributeMapping){//SimpleAttributeMapping
													LinkedList<Object> vals=new LinkedList<Object>();
													if(prepend){
														for(Object s : selMap.getHintValues().get(realHint)){
															vals.add(hintVal+((String)s));
														}
													} else {
														for(Object s : selMap.getHintValues().get(realHint)){
															vals.add(((String)s)+hintVal);
														}														
													}
													selMap.setHintValueList(realHint, vals);
												} else if(realHint instanceof ComplexAttributeMapping){//ComplexAttributeMapping
													List<ComplexAttributeMappingSourceInterface> sources=((ComplexAttributeMapping) realHint).getSourceAttributeMappings();
													if(sources.size() > 0){
														ComplexAttributeMappingSourceInterface element;
														if(prepend){
															element=sources.get(0);
														} else {
															element=sources.get(sources.size()-1);
														}

														for(Object m : selMap.getHintValues().get(realHint)){
															@SuppressWarnings("unchecked")
															Map<ComplexAttributeMappingSourceInterface,String> map=(Map<ComplexAttributeMappingSourceInterface,String>) m;
															if(map.containsKey(element)){
																if(prepend){
																	map.put(element, hintVal+map.get(element));
																} else {
																	map.put(element, map.get(element)+hintVal);
																}
															}
														}
													}
												}//TODO add any remaining hitValue changes here
	
											}
										}
									}
								} //else TODO maybe add something here when we know how to handle/control cardinality of ImportedMappingHints 
							}
						}
						LinkedHashMap<TargetSectionClass, LinkedList<EObjectTransformationHelper>> instancesBySection = targetSectionInstantiator
								.instantiateTargetSectionFirstPass(
										expGrp.getTargetMMSection(),  g,
										hints,
										selMap.getHintValues(),
										selMap.getModelConnectionHintValues(),
										selMap.getMapping().getName());
						if (instancesBySection == null) {
							if (expGrp.getTargetMMSection().getCardinality() != CardinalityType.ZERO_INFINITY) {// Error
								consoleStream
										.println("Error instantiating target section '"
												+ expGrp.getTargetMMSection().getName()
												+ "' using mapping rule '"
												+ selMap.getMapping().getName()
												+ "'");
							}
						} else {
							for (TargetSectionClass section : instancesBySection.keySet()) {
								selMap.addInstances(g, section,
										instancesBySection.get(section));
							}
						}						
					}
					
				}
			}
			
			
		}
		return targetSectionInstantiator;
	}

	/**
	 *Write MappingHint values of Hints of ExportedMappingHintGroups to a separate storage,
	 * and remove the values from the MappingInstanceStorages.
	 * 
	 * Also add values of GlobalVariables to ComplexAttributeMapping's Hints
	 * @param sourceSectionMapper
	 * @param selectedMappings
	 * @return
	 */
	private Map<MappingHint, LinkedList<Object>> handleGlobalVarsAndExportedMappings(
			SourceSectionMapper sourceSectionMapper,
			LinkedList<MappingInstanceStorage> selectedMappings) {
		consoleStream.println("Getting hint values of exported hint groups, checking MappingHintImporters, adding global variables to hints");
		Map<MappingHint, LinkedList<Object>> exportedMappingHints=new LinkedHashMap<MappingHint, LinkedList<Object>>();
		for(MappingInstanceStorage selMap : selectedMappings){
			/*
			 * import hint values
			 */
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
				/*
				 * add global values
				 */

				for(MappingHint h : g.getMappingHints()){

					if(h instanceof ComplexAttributeMapping){
						for(ComplexAttributeMappingSourceInterface i : ((ComplexAttributeMapping) h).getSourceAttributeMappings()){
							if(i instanceof GlobalVariableImporter){
								if(sourceSectionMapper.getGlobalVarValues().containsKey(((GlobalVariableImporter) i).getGlobalVariable())){
									String gVal=sourceSectionMapper.getGlobalVarValues().get(((GlobalVariableImporter) i).getGlobalVariable());
									for(Object m : selMap.getHintValues().get(h)){
										@SuppressWarnings("unchecked")
										Map<ComplexAttributeMappingSourceInterface,String> map=(Map<ComplexAttributeMappingSourceInterface,String>) m;
										map.put(i, gVal);
									}
								}
							}
						}
					} else if(h instanceof MappingInstanceSelector){
						if(((MappingInstanceSelector) h).getMatcher() instanceof ComplexAttributeMatcher){
							ComplexAttributeMatcher m = (ComplexAttributeMatcher) ((MappingInstanceSelector) h).getMatcher();
							for(ComplexAttributeMatcherSourceInterface i : m.getSourceAttributes()){
								if(i instanceof GlobalVariableImporter){
									if(sourceSectionMapper.getGlobalVarValues().containsKey(((GlobalVariableImporter) i).getGlobalVariable())){
										String gVal=sourceSectionMapper.getGlobalVarValues().get(((GlobalVariableImporter) i).getGlobalVariable());
										for(Object o : selMap.getHintValues().get(h)){
											@SuppressWarnings("unchecked")
											Map<ComplexAttributeMatcherSourceInterface,String> map=(Map<ComplexAttributeMatcherSourceInterface,String>) o;
											map.put(i, gVal);
										}										
									}
								}
							}
						}
					}
				}
				
				/*
				 * global vars for ModelConnectionHints
				 */
				if(g instanceof MappingHintGroup){
					if(((MappingHintGroup) g).getModelConnectionMatcher() instanceof ComplexModelConnectionHint){
						ComplexModelConnectionHint h=(ComplexModelConnectionHint) ((MappingHintGroup) g).getModelConnectionMatcher();
						for(ComplexModelConnectionHintSourceInterface i : h.getSourceElements()){
							if(i instanceof GlobalVariableImporter){
								if(sourceSectionMapper.getGlobalVarValues().containsKey(((GlobalVariableImporter) i).getGlobalVariable())){
									String gVal=sourceSectionMapper.getGlobalVarValues().get(((GlobalVariableImporter) i).getGlobalVariable());
									for(Object o : selMap.getModelConnectionHintValues().get(h)){
										@SuppressWarnings("unchecked")
										Map<ComplexModelConnectionHintSourceInterface,String> map=(Map<ComplexModelConnectionHintSourceInterface,String>) o;
										map.put(i, gVal);
									}										
								}
							}							
						}
					}
				}
				
			}

			
			/*
			 * global vals for ImportedMappingHintGroups
			 */
			for(MappingHintGroupImporter g : selMap.getMapping().getImportedMappingHintGroups()){
				for(MappingHintType h : g.getMappingHints()){
					
					if(h instanceof ComplexAttributeMapping){
						for(ComplexAttributeMappingSourceInterface i : ((ComplexAttributeMapping) h).getSourceAttributeMappings()){
							if(i instanceof GlobalVariableImporter){
								if(sourceSectionMapper.getGlobalVarValues().containsKey(((GlobalVariableImporter) i).getGlobalVariable())){
									String gVal=sourceSectionMapper.getGlobalVarValues().get(((GlobalVariableImporter) i).getGlobalVariable());
									for(Object m : selMap.getHintValues().get(h)){
										@SuppressWarnings("unchecked")
										Map<ComplexAttributeMappingSourceInterface,String> map=(Map<ComplexAttributeMappingSourceInterface,String>) m;
										map.put(i, gVal);
									}
								}
							}
						}
					} else if(h instanceof MappingInstanceSelector){
						if(((MappingInstanceSelector) h).getMatcher() instanceof ComplexAttributeMatcher){
							ComplexAttributeMatcher m = (ComplexAttributeMatcher) ((MappingInstanceSelector) h).getMatcher();
							for(ComplexAttributeMatcherSourceInterface i : m.getSourceAttributes()){
								if(i instanceof GlobalVariableImporter){
									if(sourceSectionMapper.getGlobalVarValues().containsKey(((GlobalVariableImporter) i).getGlobalVariable())){
										String gVal=sourceSectionMapper.getGlobalVarValues().get(((GlobalVariableImporter) i).getGlobalVariable());
										for(Object o : selMap.getHintValues().get(h)){
											@SuppressWarnings("unchecked")
											Map<ComplexAttributeMatcherSourceInterface,String> map=(Map<ComplexAttributeMatcherSourceInterface,String>) o;
											map.put(i, gVal);
										}										
									}
								}
							}
						}
					}
				}
			}
			/*
			 * additional MappingHints for HintImporters are necessary but must be restricted to a cardinality of 0..1
			 */
			for(MappingHintGroupImporter g : selMap.getMapping().getImportedMappingHintGroups()){
				for(MappingHintType h : g.getMappingHints()){
					if(selMap.getHintValues().get(h).size() > 1){
						consoleStream.println("The MappingHint " + h.getName() + " of the HintImporter " +
								g.getName() + " in Mapping " + selMap.getMapping().getName() +
								" picked up more than one HintValue. This is not allowed."
						);//TODO OCL? (possible? => Even sections with card. type of ONE can have more than one hint value if they are part of a 
						  // vc-section. However, we cannot restrict the parent sections to non-vc, argh...can we?)
						selMap.getHintValues().put(h,new LinkedList<Object>());
					}
				}
			}
		}
		return exportedMappingHints;
	}
	
	/**
	 * This is a temporary method that is called by the 'source section matcher
	 * page' in order to get the matched sections for a sample source model. 
	 * Therefore, it performs half a transformation and then returns the matched 
	 * section. 
	 * This should be changed in the future e.g. by using the 
	 * 'transformation model'.
	 * @author mfreund
	 * @return 
	 */
	public LinkedHashMap<SourceSectionClass, Set<EObject>> mapSections() {
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
			return null;
		}
		
		// find and resolve ambiguous mappings as far as possible without user
		// input
		List<Mapping> suitableMappings = pamtramModel.getMappingModel()
				.getMapping();// TODO apply contextModel

		// generate storage objects and generators
		SourceSectionMapper sourceSectionMapper = new SourceSectionMapper(suitableMappings, consoleStream);

		/*
		 * create a list of all the containment references in the source model
		 */
		writePamtramMessage("Analysing srcModel containment references");

		// list of all unmapped nodes. obtained by iterating over all of the
		// srcModels containment refs
		List<EObject> contRefsToMap = SourceSectionMapper.buildContainmentTree(sourceModel);

		/*
		 * now start mapping each one of the references. We automatically start
		 * at the sourceModel root node
		 */
		writePamtramMessage("Selecting Mappings for source model elements");

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
				return null;
			}
			if (selectedMapping == null) {
				unmapped++;
			}

		}
		consoleStream.println("Used srcModel elements: "
				+ (numSrcModelElements - unmapped));
		
		return sourceSectionMapper.getMappedSections();

	}
}
