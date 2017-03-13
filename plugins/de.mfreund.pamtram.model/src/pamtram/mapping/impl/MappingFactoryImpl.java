/**
 */
package pamtram.mapping.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingExternalSourceElement;
import pamtram.mapping.AttributeMappingGlobalSourceElement;
import pamtram.mapping.AttributeMappingSourceElement;
import pamtram.mapping.AttributeMatcher;
import pamtram.mapping.CardinalityMapping;
import pamtram.mapping.CardinalityMappingExternalSourceElement;
import pamtram.mapping.CardinalityMappingGlobalSourceElement;
import pamtram.mapping.CardinalityMappingSourceElement;
import pamtram.mapping.ClassMatcher;
import pamtram.mapping.ContainerSelector;
import pamtram.mapping.ContainerSelectorExternalSourceElement;
import pamtram.mapping.ContainerSelectorGlobalSourceElement;
import pamtram.mapping.ContainerSelectorSourceElement;
import pamtram.mapping.ContainerSelectorTargetAttribute;
import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.ExternalMappedAttributeValueAppender;
import pamtram.mapping.ExternalMappedAttributeValuePrepender;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.GlobalAttributeImporter;
import pamtram.mapping.LocalMappedAttributeValueExpander;
import pamtram.mapping.MappedAttributeValueAppender;
import pamtram.mapping.MappedAttributeValuePrepender;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingFactory;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.ReferenceTargetSelector;
import pamtram.structure.StructureFactory;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class MappingFactoryImpl extends EFactoryImpl implements MappingFactory {

	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static MappingFactory init() {

		try {
			MappingFactory theMappingFactory = (MappingFactory) EPackage.Registry.INSTANCE
					.getEFactory(MappingPackage.eNS_URI);
			if (theMappingFactory != null) {
				return theMappingFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MappingFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public MappingFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {

		switch (eClass.getClassifierID()) {
			case MappingPackage.MAPPING:
				return this.createMapping();
			case MappingPackage.MAPPING_HINT_GROUP:
				return this.createMappingHintGroup();
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER:
				return this.createMappingHintGroupImporter();
			case MappingPackage.EXPORTED_MAPPING_HINT_GROUP:
				return this.createExportedMappingHintGroup();
			case MappingPackage.ATTRIBUTE_MAPPING:
				return this.createAttributeMapping();
			case MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT:
				return this.createAttributeMappingSourceElement();
			case MappingPackage.ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT:
				return this.createAttributeMappingExternalSourceElement();
			case MappingPackage.ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT:
				return this.createAttributeMappingGlobalSourceElement();
			case MappingPackage.CARDINALITY_MAPPING:
				return this.createCardinalityMapping();
			case MappingPackage.CARDINALITY_MAPPING_SOURCE_ELEMENT:
				return this.createCardinalityMappingSourceElement();
			case MappingPackage.CARDINALITY_MAPPING_EXTERNAL_SOURCE_ELEMENT:
				return this.createCardinalityMappingExternalSourceElement();
			case MappingPackage.CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT:
				return this.createCardinalityMappingGlobalSourceElement();
			case MappingPackage.REFERENCE_TARGET_SELECTOR:
				return this.createReferenceTargetSelector();
			case MappingPackage.CLASS_MATCHER:
				return this.createClassMatcher();
			case MappingPackage.ATTRIBUTE_MATCHER:
				return this.createAttributeMatcher();
			case MappingPackage.CONTAINER_SELECTOR:
				return this.createContainerSelector();
			case MappingPackage.CONTAINER_SELECTOR_SOURCE_ELEMENT:
				return this.createContainerSelectorSourceElement();
			case MappingPackage.CONTAINER_SELECTOR_TARGET_ATTRIBUTE:
				return this.createContainerSelectorTargetAttribute();
			case MappingPackage.CONTAINER_SELECTOR_EXTERNAL_SOURCE_ELEMENT:
				return this.createContainerSelectorExternalSourceElement();
			case MappingPackage.CONTAINER_SELECTOR_GLOBAL_SOURCE_ELEMENT:
				return this.createContainerSelectorGlobalSourceElement();
			case MappingPackage.LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER:
				return this.createLocalMappedAttributeValueExpander();
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_PREPENDER:
				return this.createMappedAttributeValuePrepender();
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_APPENDER:
				return this.createMappedAttributeValueAppender();
			case MappingPackage.GLOBAL_ATTRIBUTE:
				return this.createGlobalAttribute();
			case MappingPackage.GLOBAL_ATTRIBUTE_IMPORTER:
				return this.createGlobalAttributeImporter();
			case MappingPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER:
				return this.createExternalMappedAttributeValuePrepender();
			case MappingPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER:
				return this.createExternalMappedAttributeValueAppender();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Mapping createMapping() {

		MappingImpl mapping = new MappingImpl();
		return mapping;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public AttributeMapping createAttributeMapping() {

		AttributeMappingImpl attributeMapping = new AttributeMappingImpl();
		return attributeMapping;
	}

	/**
	 */
	@Override
	public AttributeMapping createAttributeMappingWithSource() {

		AttributeMapping attributeMapping = this.createAttributeMapping();
		attributeMapping.getSourceElements().add(new AttributeMappingSourceElementImpl());
		return attributeMapping;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public CardinalityMapping createCardinalityMapping() {

		CardinalityMappingImpl cardinalityMapping = new CardinalityMappingImpl();
		return cardinalityMapping;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ReferenceTargetSelector createReferenceTargetSelector() {

		ReferenceTargetSelectorImpl referenceTargetSelector = new ReferenceTargetSelectorImpl();
		return referenceTargetSelector;
	}

	/**
	 */
	@Override
	public ReferenceTargetSelector createMappingInstanceSelectorWithClassMatcher() {

		ReferenceTargetSelector mappingInstanceSelector = this.createReferenceTargetSelector();
		mappingInstanceSelector.setMatcher(this.createClassMatcher());
		return mappingInstanceSelector;
	}

	@Override
	public ReferenceTargetSelector createMappingInstanceSelectorWithAttributeMatcher() {

		ReferenceTargetSelector mappingInstanceSelector = this.createReferenceTargetSelector();
		mappingInstanceSelector.setMatcher(this.createAttributeMatcherWithSource());
		return mappingInstanceSelector;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public AttributeMatcher createAttributeMatcher() {

		AttributeMatcherImpl attributeMatcher = new AttributeMatcherImpl();
		return attributeMatcher;
	}

	/**
	 */
	@Override
	public AttributeMatcher createAttributeMatcherWithSource() {

		AttributeMatcher attributeMatcher = this.createAttributeMatcher();
		attributeMatcher.getSourceElements().add(StructureFactory.eINSTANCE.createInstanceSelectorSourceElement());
		return attributeMatcher;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ClassMatcher createClassMatcher() {

		ClassMatcherImpl classMatcher = new ClassMatcherImpl();
		return classMatcher;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MappingHintGroup createMappingHintGroup() {

		MappingHintGroupImpl mappingHintGroup = new MappingHintGroupImpl();
		return mappingHintGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MappingHintGroupImporter createMappingHintGroupImporter() {

		MappingHintGroupImporterImpl mappingHintGroupImporter = new MappingHintGroupImporterImpl();
		return mappingHintGroupImporter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ExportedMappingHintGroup createExportedMappingHintGroup() {

		ExportedMappingHintGroupImpl exportedMappingHintGroup = new ExportedMappingHintGroupImpl();
		return exportedMappingHintGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ContainerSelector createContainerSelector() {

		ContainerSelectorImpl containerSelector = new ContainerSelectorImpl();
		return containerSelector;
	}

	/**
	 */
	@Override
	public ContainerSelector createContainerSelectorWithSourceAndTarget() {

		ContainerSelector modelConnectionHint = this.createContainerSelector();
		modelConnectionHint.getTargetAttributes().add(new ContainerSelectorTargetAttributeImpl());
		modelConnectionHint.getSourceElements().add(new ContainerSelectorSourceElementImpl());
		return modelConnectionHint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public AttributeMappingSourceElement createAttributeMappingSourceElement() {

		AttributeMappingSourceElementImpl attributeMappingSourceElement = new AttributeMappingSourceElementImpl();
		return attributeMappingSourceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ContainerSelectorSourceElement createContainerSelectorSourceElement() {

		ContainerSelectorSourceElementImpl containerSelectorSourceElement = new ContainerSelectorSourceElementImpl();
		return containerSelectorSourceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ContainerSelectorTargetAttribute createContainerSelectorTargetAttribute() {

		ContainerSelectorTargetAttributeImpl containerSelectorTargetAttribute = new ContainerSelectorTargetAttributeImpl();
		return containerSelectorTargetAttribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public LocalMappedAttributeValueExpander createLocalMappedAttributeValueExpander() {

		LocalMappedAttributeValueExpanderImpl localMappedAttributeValueExpander = new LocalMappedAttributeValueExpanderImpl();
		return localMappedAttributeValueExpander;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MappedAttributeValuePrepender createMappedAttributeValuePrepender() {

		MappedAttributeValuePrependerImpl mappedAttributeValuePrepender = new MappedAttributeValuePrependerImpl();
		return mappedAttributeValuePrepender;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MappedAttributeValueAppender createMappedAttributeValueAppender() {

		MappedAttributeValueAppenderImpl mappedAttributeValueAppender = new MappedAttributeValueAppenderImpl();
		return mappedAttributeValueAppender;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public GlobalAttribute createGlobalAttribute() {

		GlobalAttributeImpl globalAttribute = new GlobalAttributeImpl();
		return globalAttribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public GlobalAttributeImporter createGlobalAttributeImporter() {

		GlobalAttributeImporterImpl globalAttributeImporter = new GlobalAttributeImporterImpl();
		return globalAttributeImporter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public AttributeMappingExternalSourceElement createAttributeMappingExternalSourceElement() {

		AttributeMappingExternalSourceElementImpl attributeMappingExternalSourceElement = new AttributeMappingExternalSourceElementImpl();
		return attributeMappingExternalSourceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ContainerSelectorExternalSourceElement createContainerSelectorExternalSourceElement() {

		ContainerSelectorExternalSourceElementImpl containerSelectorExternalSourceElement = new ContainerSelectorExternalSourceElementImpl();
		return containerSelectorExternalSourceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ExternalMappedAttributeValuePrepender createExternalMappedAttributeValuePrepender() {

		ExternalMappedAttributeValuePrependerImpl externalMappedAttributeValuePrepender = new ExternalMappedAttributeValuePrependerImpl();
		return externalMappedAttributeValuePrepender;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ExternalMappedAttributeValueAppender createExternalMappedAttributeValueAppender() {

		ExternalMappedAttributeValueAppenderImpl externalMappedAttributeValueAppender = new ExternalMappedAttributeValueAppenderImpl();
		return externalMappedAttributeValueAppender;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public AttributeMappingGlobalSourceElement createAttributeMappingGlobalSourceElement() {

		AttributeMappingGlobalSourceElementImpl attributeMappingGlobalSourceElement = new AttributeMappingGlobalSourceElementImpl();
		return attributeMappingGlobalSourceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ContainerSelectorGlobalSourceElement createContainerSelectorGlobalSourceElement() {

		ContainerSelectorGlobalSourceElementImpl containerSelectorGlobalSourceElement = new ContainerSelectorGlobalSourceElementImpl();
		return containerSelectorGlobalSourceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public CardinalityMappingSourceElement createCardinalityMappingSourceElement() {

		CardinalityMappingSourceElementImpl cardinalityMappingSourceElement = new CardinalityMappingSourceElementImpl();
		return cardinalityMappingSourceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public CardinalityMappingExternalSourceElement createCardinalityMappingExternalSourceElement() {

		CardinalityMappingExternalSourceElementImpl cardinalityMappingExternalSourceElement = new CardinalityMappingExternalSourceElementImpl();
		return cardinalityMappingExternalSourceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public CardinalityMappingGlobalSourceElement createCardinalityMappingGlobalSourceElement() {

		CardinalityMappingGlobalSourceElementImpl cardinalityMappingGlobalSourceElement = new CardinalityMappingGlobalSourceElementImpl();
		return cardinalityMappingGlobalSourceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MappingPackage getMappingPackage() {

		return (MappingPackage) this.getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MappingPackage getPackage() {

		return MappingPackage.eINSTANCE;
	}

} // MappingFactoryImpl
