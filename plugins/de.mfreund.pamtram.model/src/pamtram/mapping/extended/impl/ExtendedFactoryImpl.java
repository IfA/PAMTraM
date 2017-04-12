/**
 */
package pamtram.mapping.extended.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import pamtram.mapping.extended.*;
import pamtram.structure.StructureFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExtendedFactoryImpl extends EFactoryImpl implements ExtendedFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExtendedFactory init() {
		try {
			ExtendedFactory theExtendedFactory = (ExtendedFactory)EPackage.Registry.INSTANCE.getEFactory(ExtendedPackage.eNS_URI);
			if (theExtendedFactory != null) {
				return theExtendedFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExtendedFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedFactoryImpl() {
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
			case ExtendedPackage.ATTRIBUTE_MAPPING: return createAttributeMapping();
			case ExtendedPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT: return createAttributeMappingSourceElement();
			case ExtendedPackage.ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT: return createAttributeMappingExternalSourceElement();
			case ExtendedPackage.ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT: return createAttributeMappingGlobalSourceElement();
			case ExtendedPackage.CARDINALITY_MAPPING: return createCardinalityMapping();
			case ExtendedPackage.CARDINALITY_MAPPING_SOURCE_ELEMENT: return createCardinalityMappingSourceElement();
			case ExtendedPackage.CARDINALITY_MAPPING_EXTERNAL_SOURCE_ELEMENT: return createCardinalityMappingExternalSourceElement();
			case ExtendedPackage.CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT: return createCardinalityMappingGlobalSourceElement();
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR: return createReferenceTargetSelector();
			case ExtendedPackage.CLASS_MATCHER: return createClassMatcher();
			case ExtendedPackage.ATTRIBUTE_MATCHER: return createAttributeMatcher();
			case ExtendedPackage.CONTAINER_SELECTOR: return createContainerSelector();
			case ExtendedPackage.CONTAINER_SELECTOR_TARGET_ATTRIBUTE: return createContainerSelectorTargetAttribute();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedPackage getExtendedPackage() {
		return (ExtendedPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * @generated
	 */
	@Override
	public AttributeMappingSourceElement createAttributeMappingSourceElement() {
		AttributeMappingSourceElementImpl attributeMappingSourceElement = new AttributeMappingSourceElementImpl();
		return attributeMappingSourceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AttributeMappingExternalSourceElement createAttributeMappingExternalSourceElement() {
		AttributeMappingExternalSourceElementImpl attributeMappingExternalSourceElement = new AttributeMappingExternalSourceElementImpl();
		return attributeMappingExternalSourceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AttributeMappingGlobalSourceElement createAttributeMappingGlobalSourceElement() {
		AttributeMappingGlobalSourceElementImpl attributeMappingGlobalSourceElement = new AttributeMappingGlobalSourceElementImpl();
		return attributeMappingGlobalSourceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CardinalityMapping createCardinalityMapping() {
		CardinalityMappingImpl cardinalityMapping = new CardinalityMappingImpl();
		return cardinalityMapping;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CardinalityMappingSourceElement createCardinalityMappingSourceElement() {
		CardinalityMappingSourceElementImpl cardinalityMappingSourceElement = new CardinalityMappingSourceElementImpl();
		return cardinalityMappingSourceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CardinalityMappingExternalSourceElement createCardinalityMappingExternalSourceElement() {
		CardinalityMappingExternalSourceElementImpl cardinalityMappingExternalSourceElement = new CardinalityMappingExternalSourceElementImpl();
		return cardinalityMappingExternalSourceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CardinalityMappingGlobalSourceElement createCardinalityMappingGlobalSourceElement() {
		CardinalityMappingGlobalSourceElementImpl cardinalityMappingGlobalSourceElement = new CardinalityMappingGlobalSourceElementImpl();
		return cardinalityMappingGlobalSourceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * @generated
	 */
	@Override
	public ClassMatcher createClassMatcher() {
		ClassMatcherImpl classMatcher = new ClassMatcherImpl();
		return classMatcher;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
		modelConnectionHint.getSourceElements().add(StructureFactory.eINSTANCE.createInstanceSelectorSourceElement());
		return modelConnectionHint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ContainerSelectorTargetAttribute createContainerSelectorTargetAttribute() {
		ContainerSelectorTargetAttributeImpl containerSelectorTargetAttribute = new ContainerSelectorTargetAttributeImpl();
		return containerSelectorTargetAttribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LocalMappedAttributeValueExpander createLocalMappedAttributeValueExpander() {
		LocalMappedAttributeValueExpanderImpl localMappedAttributeValueExpander = new LocalMappedAttributeValueExpanderImpl();
		return localMappedAttributeValueExpander;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappedAttributeValuePrepender createMappedAttributeValuePrepender() {
		MappedAttributeValuePrependerImpl mappedAttributeValuePrepender = new MappedAttributeValuePrependerImpl();
		return mappedAttributeValuePrepender;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappedAttributeValueAppender createMappedAttributeValueAppender() {
		MappedAttributeValueAppenderImpl mappedAttributeValueAppender = new MappedAttributeValueAppenderImpl();
		return mappedAttributeValueAppender;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExternalMappedAttributeValuePrepender createExternalMappedAttributeValuePrepender() {
		ExternalMappedAttributeValuePrependerImpl externalMappedAttributeValuePrepender = new ExternalMappedAttributeValuePrependerImpl();
		return externalMappedAttributeValuePrepender;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExternalMappedAttributeValueAppender createExternalMappedAttributeValueAppender() {
		ExternalMappedAttributeValueAppenderImpl externalMappedAttributeValueAppender = new ExternalMappedAttributeValueAppenderImpl();
		return externalMappedAttributeValueAppender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExtendedPackage getPackage() {
		return ExtendedPackage.eINSTANCE;
	}

} //ExtendedFactoryImpl
