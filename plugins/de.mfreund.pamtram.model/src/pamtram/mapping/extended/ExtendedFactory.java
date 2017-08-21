/**
 */
package pamtram.mapping.extended;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * 
 * @see pamtram.mapping.extended.ExtendedPackage
 * @generated
 */
public interface ExtendedFactory extends EFactory {

	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	ExtendedFactory eINSTANCE = pamtram.mapping.extended.impl.ExtendedFactoryImpl.init();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExtendedPackage getExtendedPackage();

	/**
	 * Returns a new object of class '<em>Attribute Mapping</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Attribute Mapping</em>'.
	 * @generated
	 */
	AttributeMapping createAttributeMapping();

	/**
	 * Returns a new object of class '<em>Attribute Mapping</em>' that already contains a source element.
	 * 
	 * @return a new object of class '<em>Attribute Mapping</em>'.
	 */
	AttributeMapping createAttributeMappingWithSource();

	/**
	 * Returns a new object of class '<em>Attribute Mapping Source Element</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Attribute Mapping Source Element</em>'.
	 * @generated
	 */
	AttributeMappingSourceElement createAttributeMappingSourceElement();

	/**
	 * Returns a new object of class '<em>Attribute Mapping External Source Element</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Attribute Mapping External Source Element</em>'.
	 * @generated
	 */
	AttributeMappingExternalSourceElement createAttributeMappingExternalSourceElement();

	/**
	 * Returns a new object of class '<em>Attribute Mapping Global Source Element</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Attribute Mapping Global Source Element</em>'.
	 * @generated
	 */
	AttributeMappingGlobalSourceElement createAttributeMappingGlobalSourceElement();

	/**
	 * Returns a new object of class '<em>Cardinality Mapping</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Cardinality Mapping</em>'.
	 * @generated
	 */
	CardinalityMapping createCardinalityMapping();

	/**
	 * Returns a new object of class '<em>Cardinality Mapping Source Element</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Cardinality Mapping Source Element</em>'.
	 * @generated
	 */
	CardinalityMappingSourceElement createCardinalityMappingSourceElement();

	/**
	 * Returns a new object of class '<em>Cardinality Mapping External Source Element</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Cardinality Mapping External Source Element</em>'.
	 * @generated
	 */
	CardinalityMappingExternalSourceElement createCardinalityMappingExternalSourceElement();

	/**
	 * Returns a new object of class '<em>Cardinality Mapping Global Source Element</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Cardinality Mapping Global Source Element</em>'.
	 * @generated
	 */
	CardinalityMappingGlobalSourceElement createCardinalityMappingGlobalSourceElement();

	/**
	 * Returns a new object of class '<em>Reference Target Selector</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Reference Target Selector</em>'.
	 * @generated
	 */
	ReferenceTargetSelector createReferenceTargetSelector();

	/**
	 * Returns a new object of class '<em>Instance Selector</em>' that already contains a class matcher.
	 * 
	 * @return a new object of class '<em>Instance Selector</em>'.
	 */
	ReferenceTargetSelector createMappingInstanceSelectorWithClassMatcher();

	/**
	 * Returns a new object of class '<em>Instance Selector</em>' that already contains an attribute matcher.
	 * 
	 * @return a new object of class '<em>Instance Selector</em>'.
	 */
	ReferenceTargetSelector createMappingInstanceSelectorWithAttributeMatcher();

	/**
	 * Returns a new object of class '<em>Attribute Matcher</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Attribute Matcher</em>'.
	 * @generated
	 */
	AttributeMatcher createAttributeMatcher();

	/**
	 * Returns a new object of class '<em>Attribute Matcher</em>' that already contains a source element. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Attribute Matcher</em>'.
	 */
	AttributeMatcher createAttributeMatcherWithSource();

	/**
	 * Returns a new object of class '<em>Class Matcher</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Class Matcher</em>'.
	 * @generated
	 */
	ClassMatcher createClassMatcher();

	/**
	 * Returns a new object of class '<em>Container Selector</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Container Selector</em>'.
	 * @generated
	 */
	ContainerSelector createContainerSelector();

	/**
	 * Returns a new object of class '<em>Model Connection Hint</em>' that already contains a source element and a
	 * target attribute.
	 * 
	 * @return a new object of class '<em>Model Connection Hint</em>'.
	 */
	ContainerSelector createContainerSelectorWithSource();

	/**
	 * Returns a new object of class '<em>Mapped Attribute Value Prepender</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Mapped Attribute Value Prepender</em>'.
	 * @generated
	 */
	MappedAttributeValuePrepender createMappedAttributeValuePrepender();

	/**
	 * Returns a new object of class '<em>Mapped Attribute Value Appender</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Mapped Attribute Value Appender</em>'.
	 * @generated
	 */
	MappedAttributeValueAppender createMappedAttributeValueAppender();

	/**
	 * Returns a new object of class '<em>External Mapped Attribute Value Prepender</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>External Mapped Attribute Value Prepender</em>'.
	 * @generated
	 */
	ExternalMappedAttributeValuePrepender createExternalMappedAttributeValuePrepender();

	/**
	 * Returns a new object of class '<em>External Mapped Attribute Value Appender</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>External Mapped Attribute Value Appender</em>'.
	 * @generated
	 */
	ExternalMappedAttributeValueAppender createExternalMappedAttributeValueAppender();

	/**
	 * Returns a new object of class '<em>Global Attribute Importer</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Global Attribute Importer</em>'.
	 * @generated
	 */
	GlobalAttributeImporter createGlobalAttributeImporter();

} // ExtendedFactory
