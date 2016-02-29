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
	 * Returns a new object of class '<em>Attribute Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Mapping</em>'.
	 * @generated
	 */
	AttributeMapping createAttributeMapping();
	
	/**
	 * Returns a new object of class '<em>Attribute Mapping</em>' that
	 * already contains a source element.
	 * @return a new object of class '<em>Attribute Mapping</em>'.
	 */
	AttributeMapping createAttributeMappingWithSource();

	/**
	 * Returns a new object of class '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cardinality Mapping</em>'.
	 * @generated
	 */
	CardinalityMapping createCardinalityMapping();

	/**
	 * Returns a new object of class '<em>Instance Selector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Selector</em>'.
	 * @generated
	 */
	MappingInstanceSelector createMappingInstanceSelector();
	
	/**
	 * Returns a new object of class '<em>Instance Selector</em>' that
	 * already contains a class matcher.
	 * @return a new object of class '<em>Instance Selector</em>'.
	 */
	MappingInstanceSelector createMappingInstanceSelectorWithClassMatcher();
	
	/**
	 * Returns a new object of class '<em>Instance Selector</em>' that
	 * already contains an attribute matcher.
	 * @return a new object of class '<em>Instance Selector</em>'.
	 */
	MappingInstanceSelector createMappingInstanceSelectorWithAttributeMatcher();

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
	 * Returns a new object of class '<em>Attribute Matcher Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Matcher Source Element</em>'.
	 * @generated
	 */
	AttributeMatcherSourceElement createAttributeMatcherSourceElement();

	/**
	 * Returns a new object of class '<em>Class Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Matcher</em>'.
	 * @generated
	 */
	ClassMatcher createClassMatcher();

	/**
	 * Returns a new object of class '<em>Substring Replacer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Substring Replacer</em>'.
	 * @generated
	 */
	SubstringReplacer createSubstringReplacer();

	/**
	 * Returns a new object of class '<em>String Appender</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Appender</em>'.
	 * @generated
	 */
	StringAppender createStringAppender();

	/**
	 * Returns a new object of class '<em>Unique Number Appender</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unique Number Appender</em>'.
	 * @generated
	 */
	UniqueNumberAppender createUniqueNumberAppender();

	/**
	 * Returns a new object of class '<em>String Prepender</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Prepender</em>'.
	 * @generated
	 */
	StringPrepender createStringPrepender();

	/**
	 * Returns a new object of class '<em>Attribute Value Modifier Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Value Modifier Set</em>'.
	 * @generated
	 */
	AttributeValueModifierSet createAttributeValueModifierSet();

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
	 * Returns a new object of class '<em>Model Connection Hint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Connection Hint</em>'.
	 * @generated
	 */
	ModelConnectionHint createModelConnectionHint();
	
	/**
	 * Returns a new object of class '<em>Model Connection Hint</em>' that
	 * already contains a source element and a target attribute.
	 * @return a new object of class '<em>Model Connection Hint</em>'.
	 */
	ModelConnectionHint createModelConnectionHintWithSourceAndTarget();

	/**
	 * Returns a new object of class '<em>Attribute Mapping Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Mapping Source Element</em>'.
	 * @generated
	 */
	AttributeMappingSourceElement createAttributeMappingSourceElement();

	/**
	 * Returns a new object of class '<em>Model Connection Hint Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Connection Hint Source Element</em>'.
	 * @generated
	 */
	ModelConnectionHintSourceElement createModelConnectionHintSourceElement();

	/**
	 * Returns a new object of class '<em>Model Connection Hint Target Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Connection Hint Target Attribute</em>'.
	 * @generated
	 */
	ModelConnectionHintTargetAttribute createModelConnectionHintTargetAttribute();

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
	 * Returns a new object of class '<em>Fixed Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fixed Value</em>'.
	 * @generated
	 */
	FixedValue createFixedValue();

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
	 * Returns a new object of class '<em>Attribute Mapping External Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Mapping External Source Element</em>'.
	 * @generated
	 */
	AttributeMappingExternalSourceElement createAttributeMappingExternalSourceElement();

	/**
	 * Returns a new object of class '<em>Model Connection Hint External Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Connection Hint External Source Element</em>'.
	 * @generated
	 */
	ModelConnectionHintExternalSourceElement createModelConnectionHintExternalSourceElement();

	/**
	 * Returns a new object of class '<em>Attribute Matcher External Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Matcher External Source Element</em>'.
	 * @generated
	 */
	AttributeMatcherExternalSourceElement createAttributeMatcherExternalSourceElement();

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
	 * Returns a new object of class '<em>Match To Lower Case Converter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Match To Lower Case Converter</em>'.
	 * @generated
	 */
	MatchToLowerCaseConverter createMatchToLowerCaseConverter();

	/**
	 * Returns a new object of class '<em>Match To Upper Case Converter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Match To Upper Case Converter</em>'.
	 * @generated
	 */
	MatchToUpperCaseConverter createMatchToUpperCaseConverter();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MappingPackage getMappingPackage();

} //MappingFactory
