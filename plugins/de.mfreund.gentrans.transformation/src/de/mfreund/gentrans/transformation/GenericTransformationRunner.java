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
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroup;
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
		consoleStream.println("Analysing srcModel containment references...");

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
		consoleStream.println("Selecting Mappings for source model elements...");

		int numSrcModelElements = contRefsToMap.size();
		int unmapped=0;
		while (contRefsToMap.size() > 0) {
			// find mapping
			// remove(0) automatically selects element highest in the hierarchy
			// we currently try to map

			MappingInstanceStorage selectedMapping = sourceSectionMapper
					.findMapping(contRefsToMap);
			if(sourceSectionMapper.isTransformationAborted()){
				consoleStream.println("Transformation aborted.");
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

		// creating target Model first pass (containment references)
		consoleStream
				.println("Instantiating targetModelSections for selected mappings. First pass...");
		for (MappingInstanceStorage selMap : selectedMappings) {
			// selMap.get("mapping").name.println;
			List<MappingHintGroup> hintGroups = selMap.getMapping()
					.getMappingHintGroups();
			for (MappingHintGroup g : hintGroups) {
				if (g.getTargetMMSection() != null) {

					LinkedHashMap<TargetSectionClass, LinkedList<EObjectTransformationHelper>> instancesBySection = targetSectionInstantiator
							.instantiateTargetSectionFirstPass(
									g.getTargetMMSection(), g,
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
							selMap.addInstances(g, section,
									instancesBySection.get(section));
						}
					}
				}

			}
		}

		// creating missing links/containers for target model
		consoleStream.println("Linking targetModelSections...");

		for (Mapping m : suitableMappings) {
			for (MappingHintGroup g : m.getMappingHintGroups()) {
				if (g.getTargetMMSection() != null) {// targetSection exists?
					TargetSectionClass section = g.getTargetMMSection();
					if (targetSectionRegistry.getPamtramClassInstances(section)
							.keySet().size() > 0) {// instances of section
													// exist?
						if (targetSectionRegistry.getPamtramClassInstances(
								section).get(g) != null) {// ..also of specific
															// group
							if (g.getModelConnectionMatcher() != null) {// link
																		// using
																		// matcher
								for (MappingInstanceStorage selMap : selectedMappingsByMapping
										.get(m)) {
									if (selMap.getInstances(g, section) != null) {
										connectionHelpers
												.linkToTargetModelUsingModelConnectionHint(
														section.getEClass(),
														(List<EObjectTransformationHelper>) selMap
																.getInstances(
																		g,
																		section)
																.clone(),
														section,
														m.getName(),
														g.getName(),
														g.getModelConnectionMatcher(),
														selMap.getModelConnectionHintValues(g
																.getModelConnectionMatcher()));
										if(connectionHelpers.isTransformationAborted()){
											consoleStream.println("Transformation aborted.");
											return;
										}
									}
								}
							} else {// link using container attribute or nothing
								connectionHelpers.linkToTargetModelNoConnectionHint(
										section.getEClass(),
										targetSectionRegistry
												.getPamtramClassInstances(
														section).get(g),
										section, m.getName(), g.getName());
								if(connectionHelpers.isTransformationAborted()){
									consoleStream.println("Transformation aborted.");
									return;
								}
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
			for (MappingHintGroup g : selMap.getMapping()
					.getMappingHintGroups()) {
				if (g.getTargetMMSection() != null) {
					if (selMap.getInstancesBySection(g) != null) {
						targetSectionInstantiator
								.instantiateTargetSectionSecondPass(
										g.getTargetMMSection(),
										selMap.getMapping(), g,
										g.getMappingHints(),
										selMap.getHintValues(),
										selMap.getInstancesBySection(g));
						if(targetSectionInstantiator.isTransformationAborted()){
							consoleStream.println("Transformation aborted.");
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
		} catch (Exception e) {
			MessageDialog.openError(
					PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getShell(), "Error", "The XMI resource could not be saved.");
			e.printStackTrace();
			return;
		}

	}
}
