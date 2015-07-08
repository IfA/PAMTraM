/**
 */
package pamtram.metamodel;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actual Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.ActualAttribute#getAttribute <em>Attribute</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getActualAttribute()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='attributeMatchesParentEClass'"
 * @generated
 */
public interface ActualAttribute extends TargetSectionAttribute {
	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' reference.
	 * @see #setAttribute(EAttribute)
	 * @see pamtram.metamodel.MetamodelPackage#getActualAttribute_Attribute()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!ActualAttribute!attribute'"
	 * @generated
	 */
	EAttribute getAttribute();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.ActualAttribute#getAttribute <em>Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' reference.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(EAttribute value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv attributeMatchesParentEClass:\n *   let\n *     severity : Integer[1] = \'ActualAttribute::attributeMatchesParentEClass\'.getSeverity()\n *   in\n *     if severity <= 0\n *     then true\n *     else\n *       let\n *         status : OclAny[1] = if self.isLibraryEntry()\n *         then true\n *         else\n *           self.oclContainer()\n *           .oclAsType(Class(C, R, A))\n *           .eClass.eAllAttributes->includes(self.attribute)\n *         endif\n *       in\n *         \'ActualAttribute::attributeMatchesParentEClass\'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)\n *     endif\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> severity_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%>.INSTANCE.evaluate(evaluator, <%pamtram.metamodel.MetamodelTables%>.STR_ActualAttribute_c_c_attributeMatchesParentEClass));\nfinal /*@NonInvalid\052/ boolean le = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%>.INSTANCE.evaluate(evaluator, severity_0, <%pamtram.metamodel.MetamodelTables%>.INT_0).booleanValue());\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n    symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n}\nelse {\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\n    try {\n        final /*@Thrown\052/ boolean isLibraryEntry = ((<%pamtram.metamodel.MetaModelElement%>)this).isLibraryEntry();\n        /*@Thrown\052/ boolean status;\n        if (isLibraryEntry) {\n            status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n        }\n        else {\n            final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_Class_o_C_44_R_44_A_e_0 = idResolver.getClass(<%pamtram.metamodel.MetamodelTables%>.CLSSid_Class, null);\n            final /*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.Object%> oclContainer = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, this);\n            final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.Class%> oclAsType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_metamodel_c_c_Class_o_C_44_R_44_A_e_0));\n            final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EClass%> eClass = oclAsType.getEClass();\n            @SuppressWarnings(\"null\")\n            final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%org.eclipse.emf.ecore.EAttribute%>> eAllAttributes = eClass.getEAllAttributes();\n            final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_eAllAttributes = idResolver.createOrderedSetOfAll(<%pamtram.metamodel.MetamodelTables%>.ORD_CLSSid_EAttribute, eAllAttributes);\n            final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EAttribute%> attribute = this.getAttribute();\n            final /*@Thrown\052/ boolean includes = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation%>.INSTANCE.evaluate(BOXED_eAllAttributes, attribute).booleanValue());\n            status = includes;\n        }\n        CAUGHT_status = status;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.metamodel.MetamodelTables%>.STR_ActualAttribute_c_c_attributeMatchesParentEClass, this, null, diagnostics, context, null, severity_0, CAUGHT_status, <%pamtram.metamodel.MetamodelTables%>.INT_0).booleanValue());\n    symbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean attributeMatchesParentEClass(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ActualAttribute
