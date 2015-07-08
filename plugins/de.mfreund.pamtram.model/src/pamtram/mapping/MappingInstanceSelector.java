/**
 */
package pamtram.mapping;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import pamtram.metamodel.TargetSectionNonContainmentReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance Selector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.MappingInstanceSelector#getAffectedReference <em>Affected Reference</em>}</li>
 *   <li>{@link pamtram.mapping.MappingInstanceSelector#getMatcher <em>Matcher</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getMappingInstanceSelector()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='affectedReferenceIsNonContainment affectedReferenceMatchesSection'"
 * @generated
 */
public interface MappingInstanceSelector extends MappingHint {
	/**
	 * Returns the value of the '<em><b>Affected Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Affected Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Affected Reference</em>' reference.
	 * @see #setAffectedReference(TargetSectionNonContainmentReference)
	 * @see pamtram.mapping.MappingPackage#getMappingInstanceSelector_AffectedReference()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!MappingInstanceSelector!affectedReference'"
	 * @generated
	 */
	TargetSectionNonContainmentReference getAffectedReference();

	/**
	 * Sets the value of the '{@link pamtram.mapping.MappingInstanceSelector#getAffectedReference <em>Affected Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Affected Reference</em>' reference.
	 * @see #getAffectedReference()
	 * @generated
	 */
	void setAffectedReference(TargetSectionNonContainmentReference value);

	/**
	 * Returns the value of the '<em><b>Matcher</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matcher</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matcher</em>' containment reference.
	 * @see #setMatcher(Matcher)
	 * @see pamtram.mapping.MappingPackage#getMappingInstanceSelector_Matcher()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!MappingInstanceSelector!matcher'"
	 * @generated
	 */
	Matcher getMatcher();

	/**
	 * Sets the value of the '{@link pamtram.mapping.MappingInstanceSelector#getMatcher <em>Matcher</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Matcher</em>' containment reference.
	 * @see #getMatcher()
	 * @generated
	 */
	void setMatcher(Matcher value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv affectedReferenceMatchesSection:\n *   let\n *     severity : Integer[1] = \'MappingInstanceSelector::affectedReferenceMatchesSection\'.getSeverity()\n *   in\n *     if severity <= 0\n *     then true\n *     else\n *       let\n *         status : OclAny[1] = if\n *           self.oclContainer()\n *           .oclIsKindOf(MappingHintGroupType)\n *         then\n *           self.affectedReference.getContainingSection() =\n *           self.oclContainer()\n *           .oclAsType(MappingHintGroupType).targetMMSection\n *         else\n *           self.affectedReference.getContainingSection() =\n *           self.oclContainer()\n *           .oclAsType(MappingHintGroupImporter).hintGroup.targetMMSection\n *         endif\n *       in\n *         \'MappingInstanceSelector::affectedReferenceMatchesSection\'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)\n *     endif\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> severity_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%>.INSTANCE.evaluate(evaluator, <%pamtram.mapping.MappingTables%>.STR_MappingInstanceSelector_c_c_affectedReferenceMatchesSection));\nfinal /*@NonInvalid\052/ boolean le = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%>.INSTANCE.evaluate(evaluator, severity_0, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue());\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n    symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n}\nelse {\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\n    try {\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_MappingHintGroupType, null);\n        final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.TargetSectionNonContainmentReference%> affectedReference_0 = this.getAffectedReference();\n        final /*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.Object%> oclContainer = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, this);\n        final /*@NonNull\052/ /*@Thrown\052/ <%java.lang.Object%> getContainingSection_0 = ((<%pamtram.metamodel.MetaModelElement%>)affectedReference_0).getContainingSection();\n        final /*@Thrown\052/ boolean oclIsKindOf = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation%>.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0).booleanValue());\n        /*@Thrown\052/ boolean status;\n        if (oclIsKindOf) {\n            final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.mapping.MappingHintGroupType%> oclAsType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.mapping.MappingHintGroupType%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0));\n            final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.TargetSectionClass%> targetMMSection = oclAsType.getTargetMMSection();\n            final /*@Thrown\052/ boolean eq = getContainingSection_0.equals(targetMMSection);\n            status = eq;\n        }\n        else {\n            final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_MappingHintGroupImporter = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_MappingHintGroupImporter, null);\n            final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.mapping.MappingHintGroupImporter%> oclAsType_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.mapping.MappingHintGroupImporter%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupImporter));\n            final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.mapping.ExportedMappingHintGroup%> hintGroup = oclAsType_0.getHintGroup();\n            final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.TargetSectionClass%> targetMMSection_0 = hintGroup.getTargetMMSection();\n            final /*@Thrown\052/ boolean eq_0 = getContainingSection_0.equals(targetMMSection_0);\n            status = eq_0;\n        }\n        CAUGHT_status = status;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.mapping.MappingTables%>.STR_MappingInstanceSelector_c_c_affectedReferenceMatchesSection, this, null, diagnostics, context, null, severity_0, CAUGHT_status, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue());\n    symbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean affectedReferenceMatchesSection(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv affectedReferenceIsNonContainment:\n *   let\n *     severity : Integer[1] = \'MappingInstanceSelector::affectedReferenceIsNonContainment\'.getSeverity()\n *   in\n *     if severity <= 0\n *     then true\n *     else\n *       let\n *         status : OclAny[?] = not self.affectedReference.eReference.oclAsType(ecore::EReference).containment\n *       in\n *         \'MappingInstanceSelector::affectedReferenceIsNonContainment\'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)\n *     endif\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> severity_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%>.INSTANCE.evaluate(evaluator, <%pamtram.mapping.MappingTables%>.STR_MappingInstanceSelector_c_c_affectedReferenceIsNonContainment));\nfinal /*@NonInvalid\052/ boolean le = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%>.INSTANCE.evaluate(evaluator, severity_0, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue());\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n    symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n}\nelse {\n    /*@Nullable\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\n    try {\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_ecore_c_c_EReference = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_EReference, null);\n        final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.TargetSectionNonContainmentReference%> affectedReference = this.getAffectedReference();\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EReference%> eReference = affectedReference.getEReference();\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EReference%> oclAsType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%org.eclipse.emf.ecore.EReference%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, eReference, TYP_ecore_c_c_EReference));\n        final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> containment = oclAsType.isContainment();\n        final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> status = <%org.eclipse.ocl.pivot.library.logical.BooleanNotOperation%>.INSTANCE.evaluate(containment);\n        CAUGHT_status = status;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.mapping.MappingTables%>.STR_MappingInstanceSelector_c_c_affectedReferenceIsNonContainment, this, null, diagnostics, context, null, severity_0, CAUGHT_status, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue());\n    symbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean affectedReferenceIsNonContainment(DiagnosticChain diagnostics, Map<Object, Object> context);

} // MappingInstanceSelector
