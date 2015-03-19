package de.mfreund.gentrans.transformation;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;
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
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.AttributeMatcher;
import pamtram.mapping.AttributeMatcherSourceInterface;
import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.ExternalMappedAttributeValuePrepender;
import pamtram.mapping.GlobalAttributeImporter;
import pamtram.mapping.GlobalValue;
import pamtram.mapping.MappedAttributeValueExpander;
import pamtram.mapping.MappedAttributeValueExpanderType;
import pamtram.mapping.MappedAttributeValuePrepender;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingHintType;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.ModelConnectionHint;
import pamtram.mapping.ModelConnectionHintSourceInterface;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.TargetSectionClass;
import pamtram.util.EPackageHelper;
import pamtram.util.EPackageHelper.EPackageCheck;
import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.tud.et.ifa.agtele.genlibrary.LibraryContextDescriptor;

/**
 * Main Class for running the generic transformation for a PAMTraM model.
 *
 * @author Sascha Steffen, Matthias Freund
 * @version 1.0
 */
public class GenericTransformationRunner {
	/**
	 * List of objects to cancel
	 */
	private final List<CancellationListener> objectsToCancel;

	/**
	 * File path of the source Model
	 */
	private final String sourceFilePath;
	
	/**
	 * The source model
	 */
	private EObject sourceModel;
	
	/**
	 * Path to the transformation model
	 */
	private final String pamtramPath;
	
	/**
	 * The transformation model
	 */
	private PAMTraM pamtramModel;

	/**
	 * File path to the transformation target
	 */
	private final String targetFilePath;
	
	/**
	 * The target model resource
	 */
	private XMIResource targetModel;
	
	/**
	 * Message output stream (Console view)
	 */
	private final MessageConsoleStream consoleStream;
	/**
	 * Maximum length for connection paths maxPathLength<0 == unbounded Standard
	 * value = -1
	 */
	private int maxPathLength;
	/**
	 * Determines wether the user should be asked every time an ambiguous
	 * mapping was deteced, or if we should reuse user decisions. standard value
	 * = true
	 */
	private boolean onlyAskOnceOnAmbiguousMappings;
	private boolean isCancelled;
	
	/**
	 * This keeps track of the descriptor for the target library context to be used during the transformation.
	 */
	private LibraryContextDescriptor targetLibraryContextDescriptor;
	
	/**
	 * This is the {@link TargetSectionInstantiator} that can be used to create new target sections.
	 */
	private TargetSectionInstantiator targetSectionInstantiator;
	
	/**
	 * This is the Getter for the {@link #targetSectionInstantiator}.
	 * @return The {@link #targetSectionInstantiator} used by the transformation runner.
	 */
	public TargetSectionInstantiator getTargetSectionInstantiator() {
		return targetSectionInstantiator;
	}
	
	/**
	 * This is the {@link TargetSectionConnector} that can be used to connect target sections that
	 * have been created with the help of the {@link #targetSectionInstantiator}.
	 */
	private TargetSectionConnector targetSectionConnector;

	/**
	 * This is the Getter for the {@link #targetSectionConnector}.
	 * @return The {@link #targetSectionConnector} used by the transformation runner.
	 */
	public TargetSectionConnector getTargetSectionConnector() {
		return targetSectionConnector;
	}
	
	/**
	 * This is the {@link TargetSectionRegistry} that registers target sections.
	 */
	private TargetSectionRegistry targetSectionRegistry;
	
	/**
	 * This is the Getter for the {@link #targetSectionRegistry}.
	 * @return The {@link #targetSectionRegistry} used by the transformation runner.
	 */
	public TargetSectionRegistry getTargetSectionRegistry() {
		return targetSectionRegistry;
	}

	/**
	 * Private constructor that is called from all other constructors.
	 * 
	 * @param sourceFilePath
	 *            File path of the source Model
	 * @param pamtramPath
	 *            Path to the transformation model
	 * @param targetFilePath
	 *            File path to the transformation target
	 * @param maxPathLength
	 * 			  Maximum length of connection paths between target sections.
	 * @param onlyAskOnceOnAmbiguousMappings
	 * 			  Whether ambiguities shall only be resolved once or for every instance.
	 * @param targetLibraryContextDescriptor
	 * 			  The descriptor for the target library context to be used during the transformation.
	 */
	private GenericTransformationRunner(final String sourceFilePath,
			final String pamtramPath, final String targetFilePath, int maxPathLength,
			boolean onlyAskOnceOnAmbiguousMappings, LibraryContextDescriptor targetLibraryContextDescriptor) {
		super();
		isCancelled = false;
		this.sourceFilePath = sourceFilePath;
		this.pamtramPath = pamtramPath;
		this.targetFilePath = targetFilePath;
		this.maxPathLength = maxPathLength;
		this.onlyAskOnceOnAmbiguousMappings = onlyAskOnceOnAmbiguousMappings;
		this.targetLibraryContextDescriptor = targetLibraryContextDescriptor;
		consoleStream = findConsole(
				"de.mfreund.gentrans.transformation_" + hashCode())
				.newMessageStream();
		objectsToCancel = new LinkedList<CancellationListener>();
		// brings the console view to the front
		showConsole();
	}
	
	/**
	 * Constructor
	 *
	 * @param sourceFilePath
	 *            File path of the source Model
	 * @param pamtramPath
	 *            Path to the transformation model
	 * @param targetFilePath
	 *            File path to the transformation target
	 * @param targetLibraryContextDescriptor
	 * 			  The descriptor for the target library context to be used during the transformation.
	 */
	public GenericTransformationRunner(final String sourceFilePath,
			final String pamtramPath, final String targetFilePath, LibraryContextDescriptor targetLibraryContextDescriptor) {
		this(sourceFilePath, pamtramPath, targetFilePath, -1, true, targetLibraryContextDescriptor);
	}
	
	/**
	 * Constructor
	 *
	 * @param sourceFilePath
	 *            File path of the source Model
	 * @param pamtramModel
	 *            The transformation model
	 * @param targetFilePath
	 *            File path to the transformation target
	 * @param targetLibraryContextDescriptor
	 * 			  The descriptor for the target library context to be used during the transformation.
	 */
	public GenericTransformationRunner(final String sourceFilePath,
			final PAMTraM pamtramModel, final String targetFilePath, LibraryContextDescriptor targetLibraryContextDescriptor) {
		this(sourceFilePath, null, targetFilePath, -1, true, targetLibraryContextDescriptor);
		this.pamtramModel = pamtramModel;
	}
	
	/**
	 * Constructor
	 *
	 * @param sourceModel
	 *            The source Model
	 * @param pamtramModel
	 *            The transformation model
	 * @param targetFilePath
	 *            File path to the transformation target
	 * @param targetLibraryContextDescriptor
	 * 			  The descriptor for the target library context to be used during the transformation.
	 */
	public GenericTransformationRunner(final EObject sourceModel,
			final PAMTraM pamtramModel, final String targetFilePath, LibraryContextDescriptor targetLibraryContextDescriptor) {
		this(null, null, targetFilePath, -1, true, targetLibraryContextDescriptor);
		this.pamtramModel = pamtramModel;
		this.sourceModel = sourceModel;
	}

	/**
	 * Cancels any running (or future) transformations
	 */
	public void cancel() {
		isCancelled = true;
		for (final CancellationListener l : objectsToCancel) {
			l.cancel();
		}
	}

	/**
	 * This performs the actual execution of the transformation. In the course of this method,
	 * the four main steps of the transformation get executed.
	 * 
	 * @param targetModel
	 * @param pamtramModel
	 * @param suitableMappings
	 * @param monitor
	 * @return true on success
	 */
	private boolean executeMappings(final XMIResource targetModel, final EObject sourceModel,
			final PAMTraM pamtramModel, final List<Mapping> suitableMappings,
			final IProgressMonitor monitor) {
		// generate storage objects and generators
		final AttributeValueModifierExecutor attributeValueModifier = new AttributeValueModifierExecutor(
				consoleStream);
		final SourceSectionMapper sourceSectionMapper = new SourceSectionMapper(
				suitableMappings, attributeValueModifier, consoleStream);
		final AttributeValueRegistry attrValueRegistry = new AttributeValueRegistry();

		objectsToCancel.add(sourceSectionMapper);

		/*
		 * create a list of all the containment references in the source model
		 */
		writePamtramMessage("Analysing source model");
		monitor.subTask("Selecting Mappings for source model elements");

		// list of all unmapped nodes. obtained by iterating over all of the
		// srcModels containment refs
		final List<EObject> contRefsToMap = sourceSectionMapper
				.buildContainmentTree(sourceModel);

		/*
		 * now start mapping each one of the references. We automatically start
		 * at the sourceModel root node
		 */
		final LinkedList<MappingInstanceStorage> selectedMappings = new LinkedList<MappingInstanceStorage>();
		final LinkedHashMap<Mapping, LinkedList<MappingInstanceStorage>> selectedMappingsByMapping = new LinkedHashMap<Mapping, LinkedList<MappingInstanceStorage>>();
		writePamtramMessage("Selecting Mappings for source model elements");

		final int numSrcModelElements = contRefsToMap.size();
		int lastIterNumSrcElements = numSrcModelElements;
		final double workUnit = 250.0 / numSrcModelElements;
		double accumulatedWork = 0;
		int unmapped = 0;
		while (contRefsToMap.size() > 0 && !isCancelled) {
			// find mapping
			// remove(0) automatically selects element highest in the hierarchy
			// we currently try to map

			final MappingInstanceStorage selectedMapping = sourceSectionMapper
					.findMapping(contRefsToMap, onlyAskOnceOnAmbiguousMappings);
			if (sourceSectionMapper.isCancelled()) {
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

			accumulatedWork += workUnit
					* (lastIterNumSrcElements - contRefsToMap.size());
			lastIterNumSrcElements = contRefsToMap.size();
			if (accumulatedWork >= 1) {
				monitor.worked((int) Math.floor(accumulatedWork));
				accumulatedWork -= Math.floor(accumulatedWork);
			}
		}

		if (isCancelled)
			return false;

		consoleStream.println("Used srcModel elements: "
				+ (numSrcModelElements - unmapped));

		/*
		 * Now write MappingHint values of Hints of ExportedMappingHintGroups to
		 * a separate storage, and remove the values from the
		 * MappingInstanceStorages.
		 * 
		 * Also add values of GlobalVariables to ComplexAttributeMapping's Hints
		 */
		final Map<MappingHint, LinkedList<Object>> exportedMappingHints = handleGlobalVarsAndExportedMappings(
				sourceSectionMapper, selectedMappings);

		if (isCancelled)
			return false;

		/*
		 * Instantiate TargetSectionRegistry, analyzes target-metamodel
		 */
		monitor.subTask("Instantiating targetModelSections for selected mappings. First pass");
		writePamtramMessage("Analyzing target metamodel");
		targetSectionRegistry = new TargetSectionRegistry(
				consoleStream, attrValueRegistry, pamtramModel
						.getTargetSectionModel().getMetaModelPackage());
		objectsToCancel.add(targetSectionRegistry);

		/*
		 * Instantiate all Target-Sections (containment refs and attributes)
		 */
		writePamtramMessage("Instantiating targetModelSections for selected mappings. First pass");
		runInstantiationFirstPass(
				sourceSectionMapper, targetSectionRegistry, attrValueRegistry,
				selectedMappings, exportedMappingHints, pamtramModel
						.getMappingModel().getGlobalValues(), monitor,
				attributeValueModifier);

		objectsToCancel.add(targetSectionInstantiator);

		if (isCancelled)
			return false;

		/*
		 * creating missing links/containers for target model (joining)
		 */
		writePamtramMessage("Linking targetModelSections");
		monitor.subTask("Linking targetModelSections");

		if (!linkTargetSections(targetModel, suitableMappings,
				targetSectionRegistry, attrValueRegistry,
				attributeValueModifier, selectedMappingsByMapping, monitor)) {
			return false;
		}

		if (isCancelled)
			return false;

		/*
		 * creating target Model second pass (non-containment references -> linking)
		 */
		writePamtramMessage("Instantiating targetModelSections for selected mappings. Second pass");
		monitor.subTask("Instantiating targetModelSections for selected mappings. Second pass");
		if(!runInstantiationSecondPass(selectedMappings,
				targetSectionInstantiator, monitor)) {
			return false;
		}
		
		/*
		 * Finally, instantiate the collected library entries in the target model. 
		 */
		writePamtramMessage("Instantiating libraryEntries for selected mappings.");
		monitor.subTask("Instantiating libraryEntries for selected mappings.");
		return runInstantiationLibraryEntries(
				targetSectionInstantiator, targetModel.getContents().get(0));
	}

	/**
	 * Get the output Console. Copied from: @see <a href=
	 * "http://wiki.eclipse.org/FAQ_How_do_I_write_to_the_console_from_a_plug-in%3F"
	 * >Eclipse FAQ</a>
	 *
	 * @param consoleName
	 * @return MessageConsole object
	 */
	private MessageConsole findConsole(final String consoleName) {
		final ConsolePlugin plugin = ConsolePlugin.getDefault();
		final IConsoleManager conMan = plugin.getConsoleManager();
		final IConsole[] existing = conMan.getConsoles();
		for (final IConsole element : existing)
			if (consoleName.equals(element.getName()))
				return (MessageConsole) element;
		// no console found, so create a new one
		final MessageConsole myConsole = new MessageConsole(consoleName, null);
		conMan.addConsoles(new IConsole[] { myConsole });
		return myConsole;
	}

	/**
	 * @return the maxPathLength
	 */
	public int getMaxPathLength() {
		return maxPathLength;
	}

	/**
	 * Write MappingHint values of Hints of ExportedMappingHintGroups to a
	 * separate storage, and remove the values from the MappingInstanceStorages.
	 *
	 * Also add values of GlobalVariables to ComplexAttributeMapping's Hints
	 *
	 * @param sourceSectionMapper
	 * @param selectedMappings
	 * @return
	 */
	private Map<MappingHint, LinkedList<Object>> handleGlobalVarsAndExportedMappings(
			final SourceSectionMapper sourceSectionMapper,
			final LinkedList<MappingInstanceStorage> selectedMappings) {
		consoleStream
		.println("Getting hint values of exported hint groups, checking MappingHintImporters, adding global variables to hints");
		final Map<MappingHint, LinkedList<Object>> exportedMappingHints = new LinkedHashMap<MappingHint, LinkedList<Object>>();
		for (final MappingInstanceStorage selMap : selectedMappings) {
			/*
			 * import hint values
			 */
			for (final MappingHintGroupType g : selMap.getMapping()
					.getMappingHintGroups()) {
				if (g instanceof ExportedMappingHintGroup) {
					for (final MappingHint h : g.getMappingHints()) {
						if (!exportedMappingHints.containsKey(h)) {
							exportedMappingHints.put(h,
									new LinkedList<Object>());
						}
						/*
						 * this works because the SourceSectionMapper guarantees
						 * that a key exists for each MappingHint of the Mapping
						 */
						exportedMappingHints.get(h).addAll(
								selMap.getHintValues().remove(h));

					}
				}

				/*
				 * add global attributes
				 */

				for (final MappingHint h : g.getMappingHints()) {

					if (h instanceof AttributeMapping) {
						for (final AttributeMappingSourceInterface i : ((AttributeMapping) h)
								.getSourceAttributeMappings()) {
							if (i instanceof GlobalAttributeImporter) {
								if (sourceSectionMapper.getGlobalVarValues()
										.containsKey(
												((GlobalAttributeImporter) i)
												.getGlobalAttribute())) {
									final String gVal = sourceSectionMapper
											.getGlobalVarValues()
											.get(((GlobalAttributeImporter) i)
													.getGlobalAttribute());
									for (final Object m : selMap
											.getHintValues().get(h)) {
										@SuppressWarnings("unchecked")
										final Map<AttributeMappingSourceInterface, String> map = (Map<AttributeMappingSourceInterface, String>) m;
										map.put(i, gVal);
									}
								}
							}
						}
					} else if (h instanceof MappingInstanceSelector) {
						if (((MappingInstanceSelector) h).getMatcher() instanceof AttributeMatcher) {
							final AttributeMatcher m = (AttributeMatcher) ((MappingInstanceSelector) h)
									.getMatcher();
							for (final AttributeMatcherSourceInterface i : m
									.getSourceAttributes()) {
								if (i instanceof GlobalAttributeImporter) {
									if (sourceSectionMapper
											.getGlobalVarValues()
											.containsKey(
													((GlobalAttributeImporter) i)
													.getGlobalAttribute())) {
										final String gVal = sourceSectionMapper
												.getGlobalVarValues()
												.get(((GlobalAttributeImporter) i)
														.getGlobalAttribute());
										for (final Object o : selMap
												.getHintValues().get(h)) {
											@SuppressWarnings("unchecked")
											final Map<AttributeMatcherSourceInterface, String> map = (Map<AttributeMatcherSourceInterface, String>) o;
											map.put(i, gVal);
										}
									}
								}
							}
						}
					}
				}

				/*
				 * global attributes for ModelConnectionHints
				 */
				if (g instanceof MappingHintGroup) {
					if (((MappingHintGroup) g).getModelConnectionMatcher() instanceof ModelConnectionHint) {
						final ModelConnectionHint h = ((MappingHintGroup) g)
								.getModelConnectionMatcher();
						for (final ModelConnectionHintSourceInterface i : h
								.getSourceElements()) {
							if (i instanceof GlobalAttributeImporter) {
								if (sourceSectionMapper.getGlobalVarValues()
										.containsKey(
												((GlobalAttributeImporter) i)
												.getGlobalAttribute())) {
									final String gVal = sourceSectionMapper
											.getGlobalVarValues()
											.get(((GlobalAttributeImporter) i)
													.getGlobalAttribute());
									for (final Object o : selMap
											.getModelConnectionHintValues()
											.get(h)) {
										@SuppressWarnings("unchecked")
										final Map<ModelConnectionHintSourceInterface, String> map = (Map<ModelConnectionHintSourceInterface, String>) o;
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
			for (final MappingHintGroupImporter g : selMap.getMapping()
					.getImportedMappingHintGroups()) {
				for (final MappingHintType h : g.getMappingHints()) {

					if (h instanceof AttributeMapping) {
						for (final AttributeMappingSourceInterface i : ((AttributeMapping) h)
								.getSourceAttributeMappings()) {
							if (i instanceof GlobalAttributeImporter) {
								if (sourceSectionMapper.getGlobalVarValues()
										.containsKey(
												((GlobalAttributeImporter) i)
												.getGlobalAttribute())) {
									final String gVal = sourceSectionMapper
											.getGlobalVarValues()
											.get(((GlobalAttributeImporter) i)
													.getGlobalAttribute());
									for (final Object m : selMap
											.getHintValues().get(h)) {
										@SuppressWarnings("unchecked")
										final Map<AttributeMappingSourceInterface, String> map = (Map<AttributeMappingSourceInterface, String>) m;
										map.put(i, gVal);
									}
								}
							}
						}
					} else if (h instanceof MappingInstanceSelector) {
						if (((MappingInstanceSelector) h).getMatcher() instanceof AttributeMatcher) {
							final AttributeMatcher m = (AttributeMatcher) ((MappingInstanceSelector) h)
									.getMatcher();
							for (final AttributeMatcherSourceInterface i : m
									.getSourceAttributes()) {
								if (i instanceof GlobalAttributeImporter) {
									if (sourceSectionMapper
											.getGlobalVarValues()
											.containsKey(
													((GlobalAttributeImporter) i)
													.getGlobalAttribute())) {
										final String gVal = sourceSectionMapper
												.getGlobalVarValues()
												.get(((GlobalAttributeImporter) i)
														.getGlobalAttribute());
										for (final Object o : selMap
												.getHintValues().get(h)) {
											@SuppressWarnings("unchecked")
											final Map<AttributeMatcherSourceInterface, String> map = (Map<AttributeMatcherSourceInterface, String>) o;
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
			 * additional MappingHints for HintImporters are necessary but must
			 * be restricted to a cardinality of 0..1
			 */
			for (final MappingHintGroupImporter g : selMap.getMapping()
					.getImportedMappingHintGroups()) {
				for (final MappingHintType h : g.getMappingHints()) {
					if (selMap.getHintValues().get(h).size() > 1) {
						consoleStream
						.println("The MappingHint "
								+ h.getName()
								+ " of the HintImporter "
								+ g.getName()
								+ " in Mapping "
								+ selMap.getMapping().getName()
								+ " picked up more than one HintValue. This is not allowed.");
						/*
						 * TODO OCL? (possible? => Even sections with card. type
						 * of ONE can have more than one hint value if they are
						 * part of a vc-section. However, we cannot restrict the
						 * parent sections to non-vc, argh...can we?)
						 */
						selMap.getHintValues().put(h, new LinkedList<Object>());
					}
				}
			}
		}
		return exportedMappingHints;
	}

	/**
	 * @return the onlyAskOnceOnAmbiguousMappings
	 */
	public boolean isOnlyAskOnceOnAmbiguousMappings() {
		return onlyAskOnceOnAmbiguousMappings;
	}

	/**
	 * @param targetModel
	 * @param suitableMappings
	 * @param targetSectionRegistry
	 * @param attrValueRegistry
	 * @param selectedMappingsByMapping
	 * @param monitor
	 * @return
	 */
	private boolean linkTargetSections(
			final XMIResource targetModel,
			final List<Mapping> suitableMappings,
			final TargetSectionRegistry targetSectionRegistry,
			final AttributeValueRegistry attrValueRegistry,
			final AttributeValueModifierExecutor attributeValueModifier,
			final LinkedHashMap<Mapping, LinkedList<MappingInstanceStorage>> selectedMappingsByMapping,
			final IProgressMonitor monitor) {
		
		/*
		 * Initialize the TargetSectionConnector
		 */
		targetSectionConnector = new TargetSectionConnector(
				attrValueRegistry, targetSectionRegistry,
				attributeValueModifier, targetModel, maxPathLength,
				consoleStream);
		objectsToCancel.add(targetSectionConnector);
		final double workUnit = 250.0 / suitableMappings.size();
		double accumulatedWork = 0;
		
		/*
		 * Connect all target sections
		 */
		for (final Mapping m : suitableMappings) {
			for (final MappingHintGroupType g : m.getMappingHintGroups()) {

				if (g.getTargetMMSection() != null
						&& g instanceof MappingHintGroup) {// targetSection
					// exists?
					final TargetSectionClass section = g.getTargetMMSection();
					if (targetSectionRegistry.getPamtramClassInstances(section)
							.keySet().size() > 0) {// instances of section
						// exist?
						if (targetSectionRegistry.getPamtramClassInstances(
								section).get(g) != null) {// ..also of specific
							// group
							if (((MappingHintGroup) g)
									.getModelConnectionMatcher() != null) {// link
								// using
								// matcher
								for (final MappingInstanceStorage selMap : selectedMappingsByMapping
										.get(m)) {
									if (selMap.getInstances(
											(MappingHintGroup) g, section) != null) {
										if (isCancelled)
											return false;

										targetSectionConnector
												.linkToTargetModelUsingModelConnectionHint(
														section.getEClass(),
														new LinkedList<EObjectTransformationHelper>(
																selMap.getInstances(
																		(MappingHintGroup) g,
																		section)),
														section,
														m.getName(),
														g.getName(),
														((MappingHintGroup) g)
																.getModelConnectionMatcher(),
														selMap.getModelConnectionHintValues(((MappingHintGroup) g)
																.getModelConnectionMatcher()),
														maxPathLength);
										if (targetSectionConnector
												.isCancelled()) {
											writePamtramMessage("Transformation aborted.");
											return false;
										}
									}
								}
							} else {// link using container attribute or nothing
								final LinkedList<EObjectTransformationHelper> containerInstances = targetSectionRegistry
										.getFlattenedPamtramClassInstances(section
												.getContainer());
								final LinkedList<EObjectTransformationHelper> rootInstances = targetSectionRegistry
										.getPamtramClassInstances(section).get(
												g); // fetch ALL instances
								// created by the MH-Group
								// in question
								// => less user input and possibly shorter
								// processing time
								containerInstances.removeAll(rootInstances);// we
								/*
								 * do not want the root instances to contain
								 * themselves
								 */
								final Set<EClass> containerClasses = new HashSet<EClass>();
								if (section.getContainer() != null) {
									containerClasses.add(section.getContainer()
											.getEClass());
								}
								targetSectionConnector
										.linkToTargetModelNoConnectionHint(
												rootInstances, section,
												m.getName(), g.getName(),
												section.getContainer() != null,
												containerClasses,
												containerInstances);
								if (targetSectionConnector.isCancelled()) {
									writePamtramMessage("Transformation aborted.");
									return false;
								}
							}
						}
					}
				}
			}

			for (final MappingHintGroupImporter i : m
					.getImportedMappingHintGroups()) {
				final ExportedMappingHintGroup g = i.getHintGroup();
				if (g.getTargetMMSection() != null) {
					/*
					 * ImportedMAppingHintGroups with containers specified will
					 * be linked to a section that was created by the same
					 * mapping Instance
					 */
					if (i.getContainer() != null) {
						for (final MappingInstanceStorage selMap : selectedMappingsByMapping
								.get(m)) {
							final LinkedList<EObjectTransformationHelper> rootInstances = selMap
									.getInstances(i, g.getTargetMMSection());
							if (rootInstances.size() > 0) {
								final LinkedList<EObjectTransformationHelper> containerInstances = new LinkedList<EObjectTransformationHelper>();
								final Set<EClass> containerClasses = new HashSet<EClass>();

								containerClasses.add(i.getContainer()
										.getEClass());
								// get container instances created by this
								// mapping instance
								for (final MappingHintGroupType group : m
										.getMappingHintGroups()) {
									if (isCancelled)
										return false;

									if (group instanceof MappingHintGroup) {
										final LinkedList<EObjectTransformationHelper> insts = selMap
												.getInstances(
														(MappingHintGroup) group,
														i.getContainer());
										if (insts != null) {
											containerInstances.addAll(insts);
										}

									}
								}
								// link
								targetSectionConnector
										.linkToTargetModelNoConnectionHint(
												rootInstances,
												g.getTargetMMSection(),
												m.getName(), g.getName(), true,
												containerClasses,
												containerInstances);
								if (targetSectionConnector.isCancelled()) {
									writePamtramMessage("Transformation aborted.");
									return false;
								}
							}
						}

						// use container attribute of targetSection if one is
						// specified
						// (target section container == global instance search)
					} else {
						final LinkedList<EObjectTransformationHelper> containerInstances = new LinkedList<EObjectTransformationHelper>();
						final LinkedList<EObjectTransformationHelper> rootInstances = targetSectionRegistry
								.getPamtramClassInstances(
										g.getTargetMMSection()).get(i);
						final Set<EClass> containerClasses = new HashSet<EClass>();
						if (g.getTargetMMSection().getContainer() != null) {
							containerClasses.add(g.getTargetMMSection()
									.getContainer().getEClass());
							containerInstances.addAll(targetSectionRegistry
									.getFlattenedPamtramClassInstances(g
											.getTargetMMSection()
											.getContainer()));

						}

						if (rootInstances != null) {
							if (rootInstances.size() > 0) {
								// link
								targetSectionConnector
										.linkToTargetModelNoConnectionHint(
												rootInstances,
												g.getTargetMMSection(),
												m.getName(), g.getName(),
												containerClasses.size() > 0,
												containerClasses,
												containerInstances);
								if (targetSectionConnector.isCancelled()) {
									writePamtramMessage("Transformation aborted.");
									return false;
								}
							}
						}
					}

				}
			}

			accumulatedWork += workUnit;
			if (accumulatedWork >= 1) {
				monitor.worked((int) Math.floor(accumulatedWork));
				accumulatedWork -= Math.floor(accumulatedWork);
			}
		}

		targetSectionConnector.combineUnlinkedSectionsWithTargetModelRoot();
		if (targetSectionConnector.isCancelled()) {
			writePamtramMessage("Transformation aborted.");
			return false;
		} else
			return true;

	}

	/**
	 * This is a temporary method that is called by the 'source section matcher
	 * page' in order to get the matched sections for a sample source model.
	 * Therefore, it performs half a transformation and then returns the matched
	 * section. This should be changed in the future e.g. by using the
	 * 'transformation model'.
	 *
	 * @author mfreund
	 * @return
	 */
	public LinkedHashMap<SourceSectionClass, Set<EObject>> mapSections() {

		if(pamtramModel == null || sourceModel == null) {
			return null;
		}

		// find and resolve ambiguous mappings as far as possible without user
		// input
		final List<Mapping> suitableMappings = pamtramModel.getMappingModel()
				.getMapping();// TODO apply context Model

		// generate storage objects and generators
		final AttributeValueModifierExecutor attributeValueModifier = new AttributeValueModifierExecutor(
				consoleStream);
		final SourceSectionMapper sourceSectionMapper = new SourceSectionMapper(
				suitableMappings, attributeValueModifier, consoleStream);

		/*
		 * create a list of all the containment references in the source model
		 */
		writePamtramMessage("Analysing srcModel containment references");

		// list of all unmapped nodes. obtained by iterating over all of the
		// srcModels containment refs
		final List<EObject> contRefsToMap = sourceSectionMapper
				.buildContainmentTree(sourceModel);

		/*
		 * now start mapping each one of the references. We automatically start
		 * at the sourceModel root node
		 */
		writePamtramMessage("Selecting Mappings for source model elements");

		final int numSrcModelElements = contRefsToMap.size();
		int unmapped = 0;
		while (contRefsToMap.size() > 0) {
			// find mapping
			// remove(0) automatically selects element highest in the hierarchy
			// we currently try to map

			final MappingInstanceStorage selectedMapping = sourceSectionMapper
					.findMapping(contRefsToMap, onlyAskOnceOnAmbiguousMappings);
			if (sourceSectionMapper.isCancelled()) {
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

	/**
	 * This performs the first step of the transformation:
	 * The target sections (excluding those that are defined by {@link LibraryEntry}s)
	 * are instantiated (only containment references and attributes but no non-containment
	 * references).
	 *
	 * @param sourceSectionMapper
	 * @param targetSectionRegistry
	 * @param attrValueRegistry
	 * @param selectedMappings
	 * @param exportedMappingHints
	 * @param globalValues
	 * @param monitor
	 * @param attributeValuemodifier
	 */
	private void runInstantiationFirstPass(
			final SourceSectionMapper sourceSectionMapper,
			final TargetSectionRegistry targetSectionRegistry,
			final AttributeValueRegistry attrValueRegistry,
			final LinkedList<MappingInstanceStorage> selectedMappings,
			final Map<MappingHint, LinkedList<Object>> exportedMappingHints,
			final List<GlobalValue> globalValues,
			final IProgressMonitor monitor,
			final AttributeValueModifierExecutor attributeValuemodifier) {
		
		/*
		 * Initialize the TargetSectionInstantiator
		 */
		targetSectionInstantiator = new TargetSectionInstantiator(
				targetSectionRegistry, attrValueRegistry,
				sourceSectionMapper.getGlobalVarValues(),
				attributeValuemodifier, globalValues, consoleStream, this);
		
		/*
		 * Used to update the monitor.
		 */
		final double workUnit = 250.0 / selectedMappings.size();
		double accumulatedWork = 0;
		
		/*
		 * Iterate over all selected mappings
		 */
		for (final MappingInstanceStorage selMap : selectedMappings) {
			
			/*
			 * Iterate over all mapping hint group (except empty ones)
			 */
			for (final MappingHintGroupType g : selMap.getMapping()
					.getMappingHintGroups()) {
				if (g.getTargetMMSection() != null
						&& g instanceof MappingHintGroup) {

					/*
					 * Instantiate the target section.
					 */
					final LinkedHashMap<TargetSectionClass, LinkedList<EObjectTransformationHelper>> instancesBySection = 
							targetSectionInstantiator.instantiateTargetSectionFirstPass(
									g.getTargetMMSection(),
									(MappingHintGroup) g, g.getMappingHints(),
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
						for (final TargetSectionClass section : instancesBySection
								.keySet()) {
							/*
							 * Store the created instance(s).
							 */
							selMap.addInstances((MappingHintGroup) g, section,
									instancesBySection.get(section));
						}
					}
				}

			}

			for (final MappingHintGroupImporter g : selMap.getMapping()
					.getImportedMappingHintGroups()) {
				final ExportedMappingHintGroup expGrp = g.getHintGroup();
				if (expGrp != null) {
					// import Hints
					for (final MappingHint h : expGrp.getMappingHints()) {
						selMap.getHintValues().put(h, new LinkedList<Object>());
						if (exportedMappingHints.containsKey(h)) {
							selMap.getHintValues().get(h)
							.addAll(exportedMappingHints.get(h));
						}
					}
					// start instantiating
					if (expGrp.getTargetMMSection() != null) {

						final List<MappingHint> hints = new LinkedList<MappingHint>();
						hints.addAll(expGrp.getMappingHints());
						for (final MappingHintType h : g.getMappingHints()) {
							if (h instanceof MappingHint) {
								hints.add((MappingHint) h);
							} else if (h instanceof MappedAttributeValueExpanderType) {
								if (selMap.getHintValues().get(h).size() == 1) {
									final String hintVal = (String) selMap
											.getHintValues().get(h).getFirst();
									/*
									 * of course this works only because the
									 * only other option is the Appender
									 */
									final boolean prepend = h instanceof MappedAttributeValuePrepender
											|| h instanceof ExternalMappedAttributeValuePrepender;

									for (final MappingHint realHint : g
											.getHintGroup().getMappingHints()) {
										if (realHint instanceof AttributeMapping) {
											if (((MappedAttributeValueExpander) h)
													.getHintsToExpand()
													.contains(realHint)) {
												if (realHint instanceof AttributeMapping && 
														((AttributeMapping) realHint).getExpression() == null ||
														((AttributeMapping) realHint).getExpression().isEmpty()) {// ComplexAttributeMapping
													
													final LinkedList<Object> vals = new LinkedList<Object>();
													final List<AttributeMappingSourceInterface> sources = ((AttributeMapping) realHint)
															.getSourceAttributeMappings();
													
													if (sources.size() > 0) {
														// determine the one of possibly multiple source elements of the
														// attribute mapping to be expanded
														AttributeMappingSourceInterface element;
														if (prepend) {
															element = sources
																	.get(0);
														} else {
															element = sources
																	.get(sources
																			.size() - 1);
														}

														for (final Object m : selMap
																.getHintValues()
																.get(realHint)) {

															// create a cloned copy of the map holding the source elements and values
															// of complex attribute mapping that we are expanding
															@SuppressWarnings("unchecked")
															final LinkedHashMap<AttributeMappingSourceInterface, String> clonedMap = 
																new LinkedHashMap<>((LinkedHashMap<AttributeMappingSourceInterface, String>)m);
															
															// expand either the first or last value source element and let all other
															// values untouched
															if (clonedMap.containsKey(element)) {
																if (prepend) {
																	clonedMap.put(element,
																			hintVal
																					+ clonedMap.get(element));
																} else {
																	clonedMap.put(element,
																			clonedMap.get(element)
																					+ hintVal);
																}
															}
															
															// add the new map to the list holding all hint values
															vals.add(clonedMap);
														}
														
														// update the hint value list for the real hint
														selMap.setHintValueList(
																realHint, vals);
													}
												} else if (realHint instanceof AttributeMapping) {// CalculatorMapping
													final List<AttributeMappingSourceInterface> sources = ((AttributeMapping) realHint)
															.getSourceAttributeMappings();
													if (sources.size() > 0) {
														try {
															final Calculable calc = new ExpressionBuilder(
																	hintVal)
																	.build();
															final double variableVal = calc
																	.calculate();
															/*
															 * parseDouble
															 * doesn't support
															 * Scientific
															 * notation, like:
															 * 0.42e2 == 4200e-2
															 * == 42,
															 */
															final String varName = ((MappedAttributeValueExpanderType) h)
																	.getSourceAttribute()
																	.getName();
															for (final Object m : selMap
																	.getHintValues()
																	.get(realHint)) {
																@SuppressWarnings("unchecked")
																final Map<String, Double> map = (Map<String, Double>) m;
																map.put(varName,
																		variableVal);
															}
														} catch (final Exception e) {
															consoleStream
																	.println("Couldn't convert variable "
																			+ ((MappedAttributeValueExpanderType) h)
																					.getSourceAttribute()
																					.getName()
																			+ " of "
																			+ h.getClass()
																					.getName()
																			+ " "
																			+ h.getName()
																			+ " from String to double. The problematic source element's attribute value was: "
																			+ hintVal);
														}
													}
												}// TODO add any remaining
													// hintValue changes here

											}
										} else if (realHint instanceof MappingInstanceSelector) {
											if (((MappingInstanceSelector) realHint)
													.getMatcher() instanceof AttributeMatcher) {
												final AttributeMatcher matcher = (AttributeMatcher) ((MappingInstanceSelector) realHint)
														.getMatcher();

												if (((MappedAttributeValueExpander) h)
														.getHintsToExpand()
														.contains(matcher)) {
													if (matcher instanceof AttributeMatcher) {// ComplexAttributeMatcher
														final List<AttributeMatcherSourceInterface> sources = matcher
																.getSourceAttributes();
														if (sources.size() > 0) {
															AttributeMatcherSourceInterface element;
															if (prepend) {
																element = sources
																		.get(0);
															} else {
																element = sources
																		.get(sources
																				.size() - 1);
															}

															for (final Object m : selMap
																	.getHintValues()
																	.get(realHint)) {
																@SuppressWarnings("unchecked")
																final Map<AttributeMatcherSourceInterface, String> map = (Map<AttributeMatcherSourceInterface, String>) m;
																if (map.containsKey(element)) {
																	if (prepend) {
																		map.put(element,
																				hintVal
																						+ map.get(element));
																	} else {
																		map.put(element,
																				map.get(element)
																						+ hintVal);
																	}
																}
															}
														}
													}// TODO add any remaining
														// hitValue changes here

												}
											}
										}
									}
								} // else TODO maybe add something here when we
									// know how to handle/control cardinality of
									// ImportedMappingHints
							}
						}
						final LinkedHashMap<TargetSectionClass, LinkedList<EObjectTransformationHelper>> instancesBySection = targetSectionInstantiator
								.instantiateTargetSectionFirstPass(
										expGrp.getTargetMMSection(), g, hints,
										selMap.getHintValues(),
										selMap.getModelConnectionHintValues(),
										selMap.getMapping().getName());
						if (instancesBySection == null) {
							if (expGrp.getTargetMMSection().getCardinality() != CardinalityType.ZERO_INFINITY) {// Error
								consoleStream
										.println("Error instantiating target section '"
												+ expGrp.getTargetMMSection()
														.getName()
												+ "' using mapping rule '"
												+ selMap.getMapping().getName()
												+ "'");
							}
						} else {
							for (final TargetSectionClass section : instancesBySection
									.keySet()) {
								selMap.addInstances(g, section,
										instancesBySection.get(section));
							}
						}
					}

				}
			}

			accumulatedWork += workUnit;
			if (accumulatedWork >= 1) {
				monitor.worked((int) Math.floor(accumulatedWork));
				accumulatedWork -= Math.floor(accumulatedWork);
			}
		}
	}

	/**
	 * @param selectedMappings
	 * @param targetSectionInstantiator
	 * @param monitor
	 * @return
	 */
	private boolean runInstantiationSecondPass(
			final LinkedList<MappingInstanceStorage> selectedMappings,
			final TargetSectionInstantiator targetSectionInstantiator,
			final IProgressMonitor monitor) {
		final double workUnit = 250.0 / selectedMappings.size();
		double accumulatedWork = 0;
		for (final MappingInstanceStorage selMap : selectedMappings) {
			for (final MappingHintGroupType g : selMap.getMapping()
					.getMappingHintGroups()) {
				if (isCancelled)
					return false;

				if (g.getTargetMMSection() != null
						&& g instanceof MappingHintGroup) {
					if (selMap.getInstancesBySection((MappingHintGroup) g) != null) {
						targetSectionInstantiator
								.instantiateTargetSectionSecondPass(
										g.getTargetMMSection(),
										selMap.getMapping().getName(),
										(MappingHintGroup) g,
										g.getTargetMMSection(),
										g.getMappingHints(),
										selMap.getHintValues(),
										selMap.getInstancesBySection((MappingHintGroup) g));
						if (targetSectionInstantiator.isCancelled()) {
							writePamtramMessage("Transformation aborted.");
							return false;
						}
					}
				}
			}

			for (final MappingHintGroupImporter g : selMap.getMapping()
					.getImportedMappingHintGroups()) {
				final ExportedMappingHintGroup expGrp = g.getHintGroup();
				if (expGrp.getTargetMMSection() != null) {
					if (selMap.getInstancesBySection(g) != null) {
						final List<MappingHint> hints = new LinkedList<MappingHint>();
						hints.addAll(expGrp.getMappingHints());
						for (final MappingHintType h : g.getMappingHints()) {
							if (isCancelled)
								return false;

							if (h instanceof MappingHint) {
								hints.add((MappingHint) h);
							}// TODO else if ...??-> should have already been
								// done during 1st pass
						}

						targetSectionInstantiator
								.instantiateTargetSectionSecondPass(expGrp
										.getTargetMMSection(), selMap
										.getMapping().getName(), g, expGrp
										.getTargetMMSection(), hints, selMap
										.getHintValues(), selMap
										.getInstancesBySection(g));
						if (targetSectionInstantiator.isCancelled()) {
							writePamtramMessage("Transformation aborted.");
							return false;
						}
					}
				}
			}

			accumulatedWork += workUnit;
			if (accumulatedWork >= 1) {
				monitor.worked((int) Math.floor(accumulatedWork));
				accumulatedWork -= Math.floor(accumulatedWork);
			}
		}

		return true;
	}

	/**
	 * This performs the final step of the transformation:
	 * The stored library entries are finally instantiated in the target model.
	 * 
	 * @param targetSectionInstantiator The {@link TargetSectionInstantiator} that holds the
	 * 			{@link LibraryEntry}s to be instantiated.
	 * @param targetModel The targetModel in which the library entries are to be instantiated.
	 * @return <em>true</em> if everything went well, <em>false</em> otherwise.
	 */
	private boolean runInstantiationLibraryEntries(
			final TargetSectionInstantiator targetSectionInstantiator, EObject targetModel) {
		
		return targetSectionInstantiator.instantiateLibraryEntries(targetModel, targetLibraryContextDescriptor);
	}

	/**
	 * Starts the transformation.
	 *
	 * @param monitor
	 */
	public void runTransformation(final IProgressMonitor monitor) {
		final long startTime = System.nanoTime();

		monitor.beginTask("GenTrans", 1000);

		// Create a resource set.
		ResourceSet resourceSet = new ResourceSetImpl();
		
		// load the mapping model
		if(pamtramModel == null && !loadPamtram(resourceSet)) {
				return;
		}
		
		// load the source model
		loadSourceModel(resourceSet);
		
		// create the target model
		if(!createTargetModel(resourceSet)) {
			return;
		}

		// find and resolve ambiguous mappings as far as possible without user
		// input
		final List<Mapping> suitableMappings = pamtramModel.getMappingModel()
				.getMapping();// TODO apply contextModel

		if (executeMappings(targetModel, sourceModel, pamtramModel, suitableMappings,
				monitor) && !isCancelled) {
			// save targetModel
			try {
				// try to save the xmi resource
				// xmiResource.save(Collections.EMPTY_MAP);
				final Map<Object, Object> options = new LinkedHashMap<Object, Object>();
				options.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);
				options.put(XMLResource.OPTION_SAVE_TYPE_INFORMATION,
						Boolean.TRUE);
				targetModel.save(Collections.EMPTY_MAP);
				final long endTime = System.nanoTime();
				writePamtramMessage("Transformation done. Time: "
						+ Math.ceil((endTime - startTime) / 100000000L) / 10.0
						+ "s");
			} catch (final Exception e) {
				MessageDialog.openError(PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell(), "Error",
						"The XMI resource could not be saved.");
				e.printStackTrace();
				return;
			}

		}

	}

	/**
	 * This loads the pamtram model from an XMI file.
	 * 
	 * @param rs The resource set to be used to load the resource.
	 * @return true if the model has successfully been loaded, false otherwise.
	 */
	private boolean loadPamtram(ResourceSet rs) {
		
		ResourceSet resourceSet = rs;
		
		// the URI of the pamtram resource
		final URI pamtramUri = URI.createPlatformResourceURI(pamtramPath, true);
		
		// load the pamtram model
		XMIResource pamtramResource = 
				(XMIResource) resourceSet.getResource(pamtramUri, true);
		if(!(pamtramResource.getContents().get(0) instanceof PAMTraM)) {
			writePamtramMessage("The pamtram file does not seem to contain a pamtram instance. Aborting...");
			return false;
		}
		pamtramModel = (PAMTraM) pamtramResource.getContents()
				.get(0);
		
		// try to register the ePackages involved in the pamtram model (if not already done)
		EPackageCheck result = EPackageHelper.checkInvolvedEPackages(
				pamtramModel,
				ResourcesPlugin.getWorkspace().getRoot().findMember(sourceFilePath).getProject(),
				EPackage.Registry.INSTANCE);
		switch (result) {
			case ERROR_PACKAGE_NOT_FOUND:
				writePamtramMessage("One or more EPackages are not loaded correctly. Aborting...");
				return false;
			case ERROR_METAMODEL_FOLDER_NOT_FOUND:
			case ERROR_PAMTRAM_NOT_FOUND:
				writePamtramMessage("Internal error during EPackage check. Aborting...");
				return false;
			case OK_PACKAGES_REGISTERED:
				// if packages have been registered, a new resource set has to be created; otherwise,
				// proxy resolving does not seem to work correctly
				resourceSet = new ResourceSetImpl();
				pamtramResource = (XMIResource) resourceSet.getResource(pamtramUri,
						true);
				pamtramModel = (PAMTraM) pamtramResource.getContents().get(0);
				break;
			case OK_NOTHING_REGISTERED:
			default:
				break;
		}
		
		return true;
	}

	/**
	 * This loads the source model from an XMI or XML file.
	 * 
	 * @param rs The resource set to be used to load the resource.
	 */
	private void loadSourceModel(ResourceSet resourceSet) {
		
		// the URI of the source resource
		final URI sourceUri = URI.createPlatformResourceURI(sourceFilePath, true);
		
		if(sourceFilePath.endsWith(".xml")) {
			// add file extension to registry
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"xml", new GenericXMLResourceFactoryImpl());
		}
		
		// try to load source model
		Resource sourceResource = 
				resourceSet.getResource(sourceUri, true);

		sourceModel = sourceResource.getContents().get(0);
	}

	/**
	 * This creates the resource to hold the target model created by the
	 * transformation.
	 * 
	 * @param resourceSet The resource set used to create the resource.
	 * @return true if the resource has successfully been created, false otherwise.
	 */
	private boolean createTargetModel(ResourceSet resourceSet) {

		final XMIResourceFactoryImpl resFactory = new XMIResourceFactoryImpl();
		
		// the URI of the target resource
		final URI targetFileUri = URI.createPlatformResourceURI(targetFilePath, true);
		
		try {
			targetModel = (XMIResource) resFactory
					.createResource(targetFileUri);
			targetModel.setEncoding("UTF-8");

		} catch (final Exception e) {
			MessageDialog
					.openError(PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getShell(), "Error",
							"The XMI resource for the targetModel output could not be created.");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	/**
	 * @param maxPathLength
	 *            the maxPathLength to set (value must be larger or equal -1)
	 */
	public void setMaxPathLength(final int maxPathLength) {
		this.maxPathLength = maxPathLength >= 0 ? maxPathLength : -1;
	}

	/**
	 * @param onlyAskOnceOnAmbiguousMappings
	 *            the onlyAskOnceOnAmbiguousMappings to set
	 */
	public void setOnlyAskOnceOnAmbiguousMappings(
			final boolean onlyAskOnceOnAmbiguousMappings) {
		this.onlyAskOnceOnAmbiguousMappings = onlyAskOnceOnAmbiguousMappings;
	}

	/**
	 * Brings the console view to the foreground. If the view is closed, it will
	 * be opened.
	 */
	private void showConsole() {
		// as the transformation runs in a non-UI thread, we have to use
		// a UIJob to find the console viw
		final UIJob job = new UIJob("Show Console View") {
			@Override
			public IStatus runInUIThread(final IProgressMonitor monitor) {
				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow()
							.getActivePage()
							.showView("org.eclipse.ui.console.ConsoleView");
				} catch (final PartInitException e) {
					e.printStackTrace();
					return Status.CANCEL_STATUS;
				}
				return Status.OK_STATUS;
			}
		};
		job.schedule();
	}

	/**
	 * Writes a message on the console that helps to divide the transformation
	 * output into different stages of the transformation
	 *
	 * @param msg
	 */
	private void writePamtramMessage(final String msg) {
		consoleStream.println("\n################# " + msg
				+ " #################\n");
	}
}
