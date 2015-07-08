/**
 */
package pamtram.mapping;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.TargetSectionClass;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cardinality Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.CardinalityMapping#getSource <em>Source</em>}</li>
 *   <li>{@link pamtram.mapping.CardinalityMapping#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getCardinalityMapping()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='sourceClassMatchesSection sourceClassIsVariableCardinality targetClassMatchesSection targetClassIsVariableCardinality noCardinalityMappingForSourceSectionRoot'"
 * @generated
 */
public interface CardinalityMapping extends MappingHint {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(SourceSectionClass)
	 * @see pamtram.mapping.MappingPackage#getCardinalityMapping_Source()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!CardinalityMapping!source'"
	 * @generated
	 */
	SourceSectionClass getSource();

	/**
	 * Sets the value of the '{@link pamtram.mapping.CardinalityMapping#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(SourceSectionClass value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(TargetSectionClass)
	 * @see pamtram.mapping.MappingPackage#getCardinalityMapping_Target()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!CardinalityMapping!target'"
	 * @generated
	 */
	TargetSectionClass getTarget();

	/**
	 * Sets the value of the '{@link pamtram.mapping.CardinalityMapping#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(TargetSectionClass value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv noCardinalityMappingForSourceSectionRoot:\n *   let\n *     severity : Integer[1] = \'CardinalityMapping::noCardinalityMappingForSourceSectionRoot\'.getSeverity()\n *   in\n *     if severity <= 0\n *     then true\n *     else\n *       let status : OclAny[1] = self.source <>\n *         self.source.getContainingSection()\n *       in\n *         \'CardinalityMapping::noCardinalityMappingForSourceSectionRoot\'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)\n *     endif\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> severity_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%>.INSTANCE.evaluate(evaluator, <%pamtram.mapping.MappingTables%>.STR_CardinalityMapping_c_c_noCardinalityMappingForSourceSectionRoot));\nfinal /*@NonInvalid\052/ boolean le = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%>.INSTANCE.evaluate(evaluator, severity_0, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue());\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n    symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n}\nelse {\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\n    try {\n        final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.SourceSectionClass%> source = this.getSource();\n        final /*@NonNull\052/ /*@Thrown\052/ <%java.lang.Object%> getContainingSection = ((<%pamtram.metamodel.MetaModelElement%>)source).getContainingSection();\n        final /*@Thrown\052/ boolean status = !source.equals(getContainingSection);\n        CAUGHT_status = status;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.mapping.MappingTables%>.STR_CardinalityMapping_c_c_noCardinalityMappingForSourceSectionRoot, this, null, diagnostics, context, null, severity_0, CAUGHT_status, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue());\n    symbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean noCardinalityMappingForSourceSectionRoot(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv sourceClassMatchesSection:\n *   let\n *     severity : Integer[1] = \'CardinalityMapping::sourceClassMatchesSection\'.getSeverity()\n *   in\n *     if severity <= 0\n *     then true\n *     else\n *       let\n *         status : OclAny[1] = self.source.getContainingSection() =\n *         self.oclContainer()\n *         .oclContainer()\n *         .oclAsType(Mapping).sourceMMSection\n *       in\n *         \'CardinalityMapping::sourceClassMatchesSection\'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)\n *     endif\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> severity_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%>.INSTANCE.evaluate(evaluator, <%pamtram.mapping.MappingTables%>.STR_CardinalityMapping_c_c_sourceClassMatchesSection));\nfinal /*@NonInvalid\052/ boolean le = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%>.INSTANCE.evaluate(evaluator, severity_0, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue());\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n    symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n}\nelse {\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\n    try {\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_Mapping = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_Mapping, null);\n        final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.SourceSectionClass%> source = this.getSource();\n        final /*@NonNull\052/ /*@Thrown\052/ <%java.lang.Object%> getContainingSection = ((<%pamtram.metamodel.MetaModelElement%>)source).getContainingSection();\n        final /*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.Object%> oclContainer = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, this);\n        final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Object%> oclContainer_0 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, oclContainer);\n        final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.mapping.Mapping%> oclAsType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.mapping.Mapping%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, oclContainer_0, TYP_pamtram_c_c_mapping_c_c_Mapping));\n        final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.SourceSectionClass%> sourceMMSection = oclAsType.getSourceMMSection();\n        final /*@Thrown\052/ boolean status = getContainingSection.equals(sourceMMSection);\n        CAUGHT_status = status;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.mapping.MappingTables%>.STR_CardinalityMapping_c_c_sourceClassMatchesSection, this, null, diagnostics, context, null, severity_0, CAUGHT_status, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue());\n    symbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean sourceClassMatchesSection(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv targetClassMatchesSection:\n *   let\n *     severity : Integer[1] = \'CardinalityMapping::targetClassMatchesSection\'.getSeverity()\n *   in\n *     if severity <= 0\n *     then true\n *     else\n *       let\n *         status : OclAny[1] = self.target.getContainingSection() =\n *         self.oclContainer()\n *         .oclAsType(MappingHintGroupType).targetMMSection\n *       in\n *         \'CardinalityMapping::targetClassMatchesSection\'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)\n *     endif\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> severity_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%>.INSTANCE.evaluate(evaluator, <%pamtram.mapping.MappingTables%>.STR_CardinalityMapping_c_c_targetClassMatchesSection));\nfinal /*@NonInvalid\052/ boolean le = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%>.INSTANCE.evaluate(evaluator, severity_0, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue());\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n    symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n}\nelse {\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\n    try {\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_MappingHintGroupType, null);\n        final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.TargetSectionClass%> target = this.getTarget();\n        final /*@NonNull\052/ /*@Thrown\052/ <%java.lang.Object%> getContainingSection = ((<%pamtram.metamodel.MetaModelElement%>)target).getContainingSection();\n        final /*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.Object%> oclContainer = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, this);\n        final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.mapping.MappingHintGroupType%> oclAsType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.mapping.MappingHintGroupType%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0));\n        final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.TargetSectionClass%> targetMMSection = oclAsType.getTargetMMSection();\n        final /*@Thrown\052/ boolean status = getContainingSection.equals(targetMMSection);\n        CAUGHT_status = status;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.mapping.MappingTables%>.STR_CardinalityMapping_c_c_targetClassMatchesSection, this, null, diagnostics, context, null, severity_0, CAUGHT_status, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue());\n    symbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean targetClassMatchesSection(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv targetClassIsVariableCardinality:\n *   let\n *     severity : Integer[1] = \'CardinalityMapping::targetClassIsVariableCardinality\'.getSeverity()\n *   in\n *     if severity <= 0\n *     then true\n *     else\n *       let status : OclAny[1] = self.target.cardinality <> metamodel::CardinalityType::ONE\n *       in\n *         \'CardinalityMapping::targetClassIsVariableCardinality\'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)\n *     endif\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> severity_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%>.INSTANCE.evaluate(evaluator, <%pamtram.mapping.MappingTables%>.STR_CardinalityMapping_c_c_targetClassIsVariableCardinality));\nfinal /*@NonInvalid\052/ boolean le = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%>.INSTANCE.evaluate(evaluator, severity_0, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue());\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n    symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n}\nelse {\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\n    try {\n        final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.TargetSectionClass%> target = this.getTarget();\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.common.util.Enumerator%> cardinality = target.getCardinality();\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.ids.EnumerationLiteralId%> BOXED_cardinality = <%pamtram.mapping.MappingTables%>.ENUMid_CardinalityType.getEnumerationLiteralId(<%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(cardinality.getName()));\n        final /*@Thrown\052/ boolean status = BOXED_cardinality != <%pamtram.mapping.MappingTables%>.ELITid_ONE;\n        CAUGHT_status = status;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.mapping.MappingTables%>.STR_CardinalityMapping_c_c_targetClassIsVariableCardinality, this, null, diagnostics, context, null, severity_0, CAUGHT_status, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue());\n    symbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean targetClassIsVariableCardinality(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv sourceClassIsVariableCardinality:\n *   let\n *     severity : Integer[1] = \'CardinalityMapping::sourceClassIsVariableCardinality\'.getSeverity()\n *   in\n *     if severity <= 0\n *     then true\n *     else\n *       let status : OclAny[1] = self.source.cardinality <> metamodel::CardinalityType::ONE\n *       in\n *         \'CardinalityMapping::sourceClassIsVariableCardinality\'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)\n *     endif\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> severity_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%>.INSTANCE.evaluate(evaluator, <%pamtram.mapping.MappingTables%>.STR_CardinalityMapping_c_c_sourceClassIsVariableCardinality));\nfinal /*@NonInvalid\052/ boolean le = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%>.INSTANCE.evaluate(evaluator, severity_0, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue());\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n    symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n}\nelse {\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\n    try {\n        final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.SourceSectionClass%> source = this.getSource();\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.common.util.Enumerator%> cardinality = source.getCardinality();\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.ids.EnumerationLiteralId%> BOXED_cardinality = <%pamtram.mapping.MappingTables%>.ENUMid_CardinalityType.getEnumerationLiteralId(<%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(cardinality.getName()));\n        final /*@Thrown\052/ boolean status = BOXED_cardinality != <%pamtram.mapping.MappingTables%>.ELITid_ONE;\n        CAUGHT_status = status;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.mapping.MappingTables%>.STR_CardinalityMapping_c_c_sourceClassIsVariableCardinality, this, null, diagnostics, context, null, severity_0, CAUGHT_status, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue());\n    symbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean sourceClassIsVariableCardinality(DiagnosticChain diagnostics, Map<Object, Object> context);

} // CardinalityMapping
