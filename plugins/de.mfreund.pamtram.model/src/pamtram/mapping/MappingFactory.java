/**
 */
package pamtram.mapping;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see pamtram.mapping.MappingPackage
 * @generated
 */
public interface MappingFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MappingFactory eINSTANCE = pamtram.mapping.impl.MappingFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping</em>'.
	 * @generated
	 */
	Mapping createMapping();

	/**
	 * Returns a new object of class '<em>Reference Target Selector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Target Selector</em>'.
	 * @generated
	 */
	ReferenceTargetSelector createReferenceTargetSelector();

	/**
	 * Returns a new object of class '<em>Instance Selector</em>' that
	 * already contains a class matcher.
	 * @return a new object of class '<em>Instance Selector</em>'.
	 */
	ReferenceTargetSelector createMappingInstanceSelectorWithClassMatcher();

	/**
	 * Returns a new object of class '<em>Instance Selector</em>' that
	 * already contains an attribute matcher.
	 * @return a new object of class '<em>Instance Selector</em>'.
	 */
	ReferenceTargetSelector createMappingInstanceSelectorWithAttributeMatcher();

	/**
	 * Returns a new object of class '<em>Attribute Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Matcher</em>'.
	 * @generated
	 */
	AttributeMatcher createAttributeMatcher();

	/**
	 * Returns a new object of class '<em>Attribute Matcher</em>' that
	 * already contains a source element.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Matcher</em>'.
	 */
	AttributeMatcher createAttributeMatcherWithSource();

	/**
	 * Returns a new object of class '<em>Class Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Matcher</em>'.
	 * @generated
	 */
	ClassMatcher createClassMatcher();

	/**
	 * Returns a new object of class '<em>Hint Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hint Group</em>'.
	 * @generated
	 */
	MappingHintGroup createMappingHintGroup();

	/**
	 * Returns a new object of class '<em>Hint Group Importer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hint Group Importer</em>'.
	 * @generated
	 */
	MappingHintGroupImporter createMappingHintGroupImporter();

	/**
	 * Returns a new object of class '<em>Exported Mapping Hint Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exported Mapping Hint Group</em>'.
	 * @generated
	 */
	ExportedMappingHintGroup createExportedMappingHintGroup();

	/**
	 * Returns a new object of class '<em>Container Selector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Container Selector</em>'.
	 * @generated
	 */
	ContainerSelector createContainerSelector();

	/**
	 * Returns a new object of class '<em>Model Connection Hint</em>' that
	 * already contains a source element and a target attribute.
	 * @return a new object of class '<em>Model Connection Hint</em>'.
	 */
	ContainerSelector createContainerSelectorWithSourceAndTarget();

	/**
	 * Returns a new object of class '<em>Container Selector Target Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Container Selector Target Attribute</em>'.
	 * @generated
	 */
	ContainerSelectorTargetAttribute createContainerSelectorTargetAttribute();

	/**
	 * Returns a new object of class '<em>Local Mapped Attribute Value Expander</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Local Mapped Attribute Value Expander</em>'.
	 * @generated
	 */
	LocalMappedAttributeValueExpander createLocalMappedAttributeValueExpander();

	/**
	 * Returns a new object of class '<em>Mapped Attribute Value Prepender</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapped Attribute Value Prepender</em>'.
	 * @generated
	 */
	MappedAttributeValuePrepender createMappedAttributeValuePrepender();

	/**
	 * Returns a new object of class '<em>Mapped Attribute Value Appender</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapped Attribute Value Appender</em>'.
	 * @generated
	 */
	MappedAttributeValueAppender createMappedAttributeValueAppender();

	/**
	 * Returns a new object of class '<em>Global Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Global Attribute</em>'.
	 * @generated
	 */
	GlobalAttribute createGlobalAttribute();

	/**
	 * Returns a new object of class '<em>Global Attribute Importer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Global Attribute Importer</em>'.
	 * @generated
	 */
	GlobalAttributeImporter createGlobalAttributeImporter();

	/**
	 * Returns a new object of class '<em>External Mapped Attribute Value Prepender</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Mapped Attribute Value Prepender</em>'.
	 * @generated
	 */
	ExternalMappedAttributeValuePrepender createExternalMappedAttributeValuePrepender();

	/**
	 * Returns a new object of class '<em>External Mapped Attribute Value Appender</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Mapped Attribute Value Appender</em>'.
	 * @generated
	 */
	ExternalMappedAttributeValueAppender createExternalMappedAttributeValueAppender();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MappingPackage getMappingPackage();

} //MappingFactory
