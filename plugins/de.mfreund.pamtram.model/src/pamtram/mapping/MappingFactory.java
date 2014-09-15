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
	 * Returns a new object of class '<em>Instantiable Mapping Hint Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instantiable Mapping Hint Group</em>'.
	 * @generated
	 */
	InstantiableMappingHintGroup createInstantiableMappingHintGroup();

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
	 * Returns a new object of class '<em>Connection Hint Target Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connection Hint Target Attribute</em>'.
	 * @generated
	 */
	ConnectionHintTargetAttribute createConnectionHintTargetAttribute();

	/**
	 * Returns a new object of class '<em>Simple Attribute Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Attribute Mapping</em>'.
	 * @generated
	 */
	SimpleAttributeMapping createSimpleAttributeMapping();

	/**
	 * Returns a new object of class '<em>Complex Attribute Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complex Attribute Mapping</em>'.
	 * @generated
	 */
	ComplexAttributeMapping createComplexAttributeMapping();

	/**
	 * Returns a new object of class '<em>Complex Attribute Mapping Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complex Attribute Mapping Source Element</em>'.
	 * @generated
	 */
	ComplexAttributeMappingSourceElement createComplexAttributeMappingSourceElement();

	/**
	 * Returns a new object of class '<em>Calculator Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Calculator Mapping</em>'.
	 * @generated
	 */
	CalculatorMapping createCalculatorMapping();

	/**
	 * Returns a new object of class '<em>Expression Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression Variable</em>'.
	 * @generated
	 */
	ExpressionVariable createExpressionVariable();

	/**
	 * Returns a new object of class '<em>Complex Attribute Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complex Attribute Matcher</em>'.
	 * @generated
	 */
	ComplexAttributeMatcher createComplexAttributeMatcher();

	/**
	 * Returns a new object of class '<em>Simple Attribute Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Attribute Matcher</em>'.
	 * @generated
	 */
	SimpleAttributeMatcher createSimpleAttributeMatcher();

	/**
	 * Returns a new object of class '<em>Complex Attribute Matcher Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complex Attribute Matcher Source Element</em>'.
	 * @generated
	 */
	ComplexAttributeMatcherSourceElement createComplexAttributeMatcherSourceElement();

	/**
	 * Returns a new object of class '<em>Simple Model Connection Hint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Model Connection Hint</em>'.
	 * @generated
	 */
	SimpleModelConnectionHint createSimpleModelConnectionHint();

	/**
	 * Returns a new object of class '<em>Complex Model Connection Hint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complex Model Connection Hint</em>'.
	 * @generated
	 */
	ComplexModelConnectionHint createComplexModelConnectionHint();

	/**
	 * Returns a new object of class '<em>Complex Model Connection Hint Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complex Model Connection Hint Source Element</em>'.
	 * @generated
	 */
	ComplexModelConnectionHintSourceElement createComplexModelConnectionHintSourceElement();

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
	 * Returns a new object of class '<em>Global Variable Importer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Global Variable Importer</em>'.
	 * @generated
	 */
	GlobalVariableImporter createGlobalVariableImporter();

	/**
	 * Returns a new object of class '<em>Complex Attribute Mapping External Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complex Attribute Mapping External Source Element</em>'.
	 * @generated
	 */
	ComplexAttributeMappingExternalSourceElement createComplexAttributeMappingExternalSourceElement();

	/**
	 * Returns a new object of class '<em>Complex Model Connection Hint External Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complex Model Connection Hint External Source Element</em>'.
	 * @generated
	 */
	ComplexModelConnectionHintExternalSourceElement createComplexModelConnectionHintExternalSourceElement();

	/**
	 * Returns a new object of class '<em>External Expression Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Expression Variable</em>'.
	 * @generated
	 */
	ExternalExpressionVariable createExternalExpressionVariable();

	/**
	 * Returns a new object of class '<em>Complex Attribute Matcher External Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complex Attribute Matcher External Source Element</em>'.
	 * @generated
	 */
	ComplexAttributeMatcherExternalSourceElement createComplexAttributeMatcherExternalSourceElement();

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
	 * Returns a new object of class '<em>Global Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Global Value</em>'.
	 * @generated
	 */
	GlobalValue createGlobalValue();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MappingPackage getMappingPackage();

} //MappingFactory