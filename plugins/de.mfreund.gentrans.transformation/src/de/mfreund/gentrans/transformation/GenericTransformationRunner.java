package de.mfreund.gentrans.transformation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;

import pamtram.PAMTraM;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroup;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.Class;

/**
 * @author Sascha Steffen
 *
 */
public class GenericTransformationRunner {

	public GenericTransformationRunner(XMIResource sourceModel,
			EPackage targetModelPackage, URI targetModelResourceURI,
			PAMTraM pamtramModel) {
		super();
		this.sourceModel = sourceModel;

		this.targetModelResourceURI = targetModelResourceURI;
		this.pamtramModel = pamtramModel;

		this.targetModelPackage = targetModelPackage;
	}

	private XMIResource sourceModel;
	private URI targetModelResourceURI;
	private PAMTraM pamtramModel;
	private EPackage targetModelPackage;

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void runTransformation() {
		XMIResource targetModel;

		// TODO check if the xmi resource already exists
		try {
			// try to create the xmi resource
			XMIResourceFactoryImpl resFactory = new XMIResourceFactoryImpl();
			targetModel = (XMIResource) resFactory
					.createResource(targetModelResourceURI);

		} catch (Exception e) {
			MessageDialog
					.openError(PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getShell(), "Error",
							"The XMI resource for thhe targetModel output could not be created.");
			e.printStackTrace();
			return;
		}

		// generate storage objects and generators
		SourceSectionMapper sourceSectionMapper = new SourceSectionMapper();
		TargetSectionRegistry targetSectionRegistry = new TargetSectionRegistry();
		AttributeValueRegistry attrValueRegistry = new AttributeValueRegistry();
		TargetSectionConnector connectionHelpers = new TargetSectionConnector(
				attrValueRegistry, targetSectionRegistry, targetModel);
		TargetSectionInstantiator targetSectionInstantiator = new TargetSectionInstantiator(
				targetSectionRegistry, attrValueRegistry, targetModel);

		/*
		 * create a list of all the containment references in the source model
		 */
		System.out.println("Analysing srcModel containment references...");

		// list of all unmapped nodes. obtained by iterating over all of the
		// srcModels containment refs
		List<EObject> contRefsToMap = SourceSectionMapper
				.buildContainmentTree(sourceModel.getContents().get(0));

		// find and resolve ambiguous mappings as far as possible without user
		// input
		List<Mapping> suitableMappings = pamtramModel.getMappingModel()
				.getMapping();// TODO apply contextModel

		/*
		 * now start mapping each one of the references. We automatically start
		 * at the sourceModel root node
		 */
		LinkedList<MappingInstanceStorage> selectedMappings = new LinkedList<MappingInstanceStorage>();
		HashMap<Mapping, LinkedList<MappingInstanceStorage>> selectedMappingsByMapping = new HashMap<Mapping, LinkedList<MappingInstanceStorage>>();
		System.out.println("Selecting Mappings for source model elements...");

		int numSrcModelElements = contRefsToMap.size();
		while (contRefsToMap.size() > 0) {
			// find mapping
			// remove(0) automatically selects element highest in the hierarchy
			// we currently try to map

			MappingInstanceStorage selectedMapping = sourceSectionMapper
					.findMapping(suitableMappings, contRefsToMap);
			if (selectedMapping != null) {
				selectedMappings.add(selectedMapping);
				if (!selectedMappingsByMapping.containsKey(selectedMapping
						.getMapping())) {
					selectedMappingsByMapping.put(selectedMapping.getMapping(),
							new LinkedList<MappingInstanceStorage>());
				}
				selectedMappingsByMapping.get(selectedMapping.getMapping())
						.add(selectedMapping);

			}
		}
		System.out.println("Used srcModel elements: "
				+ (numSrcModelElements - contRefsToMap.size()));
		targetSectionRegistry.analyseTargetMetaModel(targetModelPackage);

		// creating target Model first pass (containment references)
		System.out
				.println("Instantiating targetModelSections for selected mappings. First pass...");
		for (MappingInstanceStorage selMap : selectedMappings) {
			// selMap.get("mapping").name.println;
			List<MappingHintGroup> hintGroups = selMap.getMapping()
					.getMappingHintGroups();
			for (MappingHintGroup g : hintGroups) {
				if (g.getTargetMMSection() != null) {

					HashMap<Class, LinkedList<EObjectTransformationHelper>> instancesBySection = targetSectionInstantiator
							.instantiateTargetSectionFirstPass(
									g.getTargetMMSection(), g,
									selMap.getHintValues(),
									selMap.getModelConnectionHintValues(),
									selMap.getMapping());
					if (instancesBySection == null) {
						if (g.getTargetMMSection().getCardinality() != CardinalityType.ZERO_INFINITY) {// Error
							System.out
									.println("Error instantiating target section '"
											+ g.getTargetMMSection().getName()
											+ "' using mapping rule '"
											+ selMap.getMapping().getName()
											+ "'");
						}
					} else {
						for (Class section : instancesBySection.keySet()) {
							selMap.addInstances(g, section,
									instancesBySection.get(section));
						}
					}
				}

			}
		}

		// creating missing links/containers for target model
		System.out.println("Linking targetModelSections...");

		for (Mapping m : suitableMappings) {
			for (MappingHintGroup g : m.getMappingHintGroups()) {
				if (g.getTargetMMSection() != null) {// targetSection exists?
					Class section = g.getTargetMMSection();
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
												.linkToTargetModelUsingModelConnectionHints(
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
									}
								}
							} else {// link using container attribute or nothing
								connectionHelpers.linkToTargetModel(
										section.getEClass(),
										targetSectionRegistry
												.getPamtramClassInstances(
														section).get(g),
										section, m.getName(), g.getName());
							}
						}
					}
				}
			}
		}

		// creating target Model second pass (non-containment references)
		System.out
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
					}
				}
			}

		}

	}
}
