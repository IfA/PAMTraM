/**
 */
package pamtram.mapping.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import pamtram.mapping.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MappingFactoryImpl extends EFactoryImpl implements MappingFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MappingFactory init() {
		try {
			MappingFactory theMappingFactory = (MappingFactory)EPackage.Registry.INSTANCE.getEFactory(MappingPackage.eNS_URI);
			if (theMappingFactory != null) {
				return theMappingFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MappingFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MappingPackage.MAPPING: return createMapping();
			case MappingPackage.MAPPING_HINT_GROUP: return createMappingHintGroup();
			case MappingPackage.ATTRIBUTE_MAPPING: return createAttributeMapping();
			case MappingPackage.CARDINALITY_MAPPING: return createCardinalityMapping();
			case MappingPackage.REFERENCE_TARGET_SELECTOR: return createReferenceTargetSelector();
			case MappingPackage.ATTRIBUTE_MATCHER: return createAttributeMatcher();
			case MappingPackage.ATTRIBUTE_MATCHER_SOURCE_ELEMENT: return createAttributeMatcherSourceElement();
			case MappingPackage.CLASS_MATCHER: return createClassMatcher();
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER: return createMappingHintGroupImporter();
			case MappingPackage.EXPORTED_MAPPING_HINT_GROUP: return createExportedMappingHintGroup();
			case MappingPackage.CONTAINER_SELECTOR: return createContainerSelector();
			case MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT: return createAttributeMappingSourceElement();
			case MappingPackage.CONTAINER_SELECTOR_SOURCE_ELEMENT: return createContainerSelectorSourceElement();
			case MappingPackage.CONTAINER_SELECTOR_TARGET_ATTRIBUTE: return createContainerSelectorTargetAttribute();
			case MappingPackage.LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER: return createLocalMappedAttributeValueExpander();
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_PREPENDER: return createMappedAttributeValuePrepender();
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_APPENDER: return createMappedAttributeValueAppender();
			case MappingPackage.FIXED_VALUE: return createFixedValue();
			case MappingPackage.GLOBAL_ATTRIBUTE: return createGlobalAttribute();
			case MappingPackage.GLOBAL_ATTRIBUTE_IMPORTER: return createGlobalAttributeImporter();
			case MappingPackage.ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT: return createAttributeMappingExternalSourceElement();
			case MappingPackage.CONTAINER_SELECTOR_EXTERNAL_SOURCE_ELEMENT: return createContainerSelectorExternalSourceElement();
			case MappingPackage.ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT: return createAttributeMatcherExternalSourceElement();
			case MappingPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER: return createExternalMappedAttributeValuePrepender();
			case MappingPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER: return createExternalMappedAttributeValueAppender();
			case MappingPackage.ATTRIBUTE_MATCHER_GLOBAL_SOURCE_ELEMENT: return createAttributeMatcherGlobalSourceElement();
			case MappingPackage.ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT: return createAttributeMappingGlobalSourceElement();
			case MappingPackage.CONTAINER_SELECTOR_GLOBAL_SOURCE_ELEMENT: return createContainerSelectorGlobalSourceElement();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping createMapping() {
		MappingImpl mapping = new MappingImpl();
		return mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeMapping createAttributeMapping() {
		AttributeMappingImpl attributeMapping = new AttributeMappingImpl();
		return attributeMapping;
	}
	
	/**
	 */
	public AttributeMapping createAttributeMappingWithSource() {
		AttributeMapping attributeMapping = createAttributeMapping();
		attributeMapping.getSourceElements().add(
				new AttributeMappingSourceElementImpl());
		return attributeMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CardinalityMapping createCardinalityMapping() {
		CardinalityMappingImpl cardinalityMapping = new CardinalityMappingImpl();
		return cardinalityMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceTargetSelector createReferenceTargetSelector() {
		ReferenceTargetSelectorImpl referenceTargetSelector = new ReferenceTargetSelectorImpl();
		return referenceTargetSelector;
	}
	
	/**
	 */
	@Override
	public ReferenceTargetSelector createMappingInstanceSelectorWithClassMatcher() {
		ReferenceTargetSelector mappingInstanceSelector = createReferenceTargetSelector();
		mappingInstanceSelector.setMatcher(createClassMatcher());
		return mappingInstanceSelector;
	}
	
	@Override
	public ReferenceTargetSelector createMappingInstanceSelectorWithAttributeMatcher() {
		ReferenceTargetSelector mappingInstanceSelector = createReferenceTargetSelector();
		mappingInstanceSelector.setMatcher(createAttributeMatcherWithSource());
		return mappingInstanceSelector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeMatcher createAttributeMatcher() {
		AttributeMatcherImpl attributeMatcher = new AttributeMatcherImpl();
		return attributeMatcher;
	}
	
	/**
	 */
	@Override
	public AttributeMatcher createAttributeMatcherWithSource() {
		AttributeMatcher attributeMatcher = createAttributeMatcher();
		attributeMatcher.getSourceElements().add(
				new AttributeMatcherSourceElementImpl());
		return attributeMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeMatcherSourceElement createAttributeMatcherSourceElement() {
		AttributeMatcherSourceElementImpl attributeMatcherSourceElement = new AttributeMatcherSourceElementImpl();
		return attributeMatcherSourceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassMatcher createClassMatcher() {
		ClassMatcherImpl classMatcher = new ClassMatcherImpl();
		return classMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingHintGroup createMappingHintGroup() {
		MappingHintGroupImpl mappingHintGroup = new MappingHintGroupImpl();
		return mappingHintGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingHintGroupImporter createMappingHintGroupImporter() {
		MappingHintGroupImporterImpl mappingHintGroupImporter = new MappingHintGroupImporterImpl();
		return mappingHintGroupImporter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExportedMappingHintGroup createExportedMappingHintGroup() {
		ExportedMappingHintGroupImpl exportedMappingHintGroup = new ExportedMappingHintGroupImpl();
		return exportedMappingHintGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainerSelector createContainerSelector() {
		ContainerSelectorImpl containerSelector = new ContainerSelectorImpl();
		return containerSelector;
	}
	
	/**
	 */
	public ContainerSelector createContainerSelectorWithSourceAndTarget() {
		ContainerSelector modelConnectionHint = createContainerSelector();
		modelConnectionHint.getTargetAttributes().add(
				new ContainerSelectorTargetAttributeImpl());
		modelConnectionHint.getSourceElements().add(
				new ContainerSelectorSourceElementImpl());
		return modelConnectionHint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeMappingSourceElement createAttributeMappingSourceElement() {
		AttributeMappingSourceElementImpl attributeMappingSourceElement = new AttributeMappingSourceElementImpl();
		return attributeMappingSourceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainerSelectorSourceElement createContainerSelectorSourceElement() {
		ContainerSelectorSourceElementImpl containerSelectorSourceElement = new ContainerSelectorSourceElementImpl();
		return containerSelectorSourceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainerSelectorTargetAttribute createContainerSelectorTargetAttribute() {
		ContainerSelectorTargetAttributeImpl containerSelectorTargetAttribute = new ContainerSelectorTargetAttributeImpl();
		return containerSelectorTargetAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalMappedAttributeValueExpander createLocalMappedAttributeValueExpander() {
		LocalMappedAttributeValueExpanderImpl localMappedAttributeValueExpander = new LocalMappedAttributeValueExpanderImpl();
		return localMappedAttributeValueExpander;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappedAttributeValuePrepender createMappedAttributeValuePrepender() {
		MappedAttributeValuePrependerImpl mappedAttributeValuePrepender = new MappedAttributeValuePrependerImpl();
		return mappedAttributeValuePrepender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappedAttributeValueAppender createMappedAttributeValueAppender() {
		MappedAttributeValueAppenderImpl mappedAttributeValueAppender = new MappedAttributeValueAppenderImpl();
		return mappedAttributeValueAppender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FixedValue createFixedValue() {
		FixedValueImpl fixedValue = new FixedValueImpl();
		return fixedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalAttribute createGlobalAttribute() {
		GlobalAttributeImpl globalAttribute = new GlobalAttributeImpl();
		return globalAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalAttributeImporter createGlobalAttributeImporter() {
		GlobalAttributeImporterImpl globalAttributeImporter = new GlobalAttributeImporterImpl();
		return globalAttributeImporter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeMappingExternalSourceElement createAttributeMappingExternalSourceElement() {
		AttributeMappingExternalSourceElementImpl attributeMappingExternalSourceElement = new AttributeMappingExternalSourceElementImpl();
		return attributeMappingExternalSourceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainerSelectorExternalSourceElement createContainerSelectorExternalSourceElement() {
		ContainerSelectorExternalSourceElementImpl containerSelectorExternalSourceElement = new ContainerSelectorExternalSourceElementImpl();
		return containerSelectorExternalSourceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeMatcherExternalSourceElement createAttributeMatcherExternalSourceElement() {
		AttributeMatcherExternalSourceElementImpl attributeMatcherExternalSourceElement = new AttributeMatcherExternalSourceElementImpl();
		return attributeMatcherExternalSourceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalMappedAttributeValuePrepender createExternalMappedAttributeValuePrepender() {
		ExternalMappedAttributeValuePrependerImpl externalMappedAttributeValuePrepender = new ExternalMappedAttributeValuePrependerImpl();
		return externalMappedAttributeValuePrepender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalMappedAttributeValueAppender createExternalMappedAttributeValueAppender() {
		ExternalMappedAttributeValueAppenderImpl externalMappedAttributeValueAppender = new ExternalMappedAttributeValueAppenderImpl();
		return externalMappedAttributeValueAppender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeMatcherGlobalSourceElement createAttributeMatcherGlobalSourceElement() {
		AttributeMatcherGlobalSourceElementImpl attributeMatcherGlobalSourceElement = new AttributeMatcherGlobalSourceElementImpl();
		return attributeMatcherGlobalSourceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeMappingGlobalSourceElement createAttributeMappingGlobalSourceElement() {
		AttributeMappingGlobalSourceElementImpl attributeMappingGlobalSourceElement = new AttributeMappingGlobalSourceElementImpl();
		return attributeMappingGlobalSourceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainerSelectorGlobalSourceElement createContainerSelectorGlobalSourceElement() {
		ContainerSelectorGlobalSourceElementImpl containerSelectorGlobalSourceElement = new ContainerSelectorGlobalSourceElementImpl();
		return containerSelectorGlobalSourceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingPackage getMappingPackage() {
		return (MappingPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MappingPackage getPackage() {
		return MappingPackage.eINSTANCE;
	}

} //MappingFactoryImpl
