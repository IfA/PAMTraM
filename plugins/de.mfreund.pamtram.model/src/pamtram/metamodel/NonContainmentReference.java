/**
 */
package pamtram.metamodel;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Non Containment Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.NonContainmentReference#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getNonContainmentReference()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='eReferenceIsNonContainment'"
 * @generated
 */
public interface NonContainmentReference<C extends pamtram.metamodel.Class<C, R, A>, R extends Reference<C, R, A>, A extends Attribute<C, R, A>> extends Reference<C, R, A> {

	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getNonContainmentReference_Value()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!NonContainmentReference{C,R,A}!value'"
	 * @generated
	 */
	EList<C> getValue();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv eReferenceIsNonContainment:\n *   let\n *     severity : Integer[1] = \'NonContainmentReference::eReferenceIsNonContainment\'.getSeverity()\n *   in\n *     if severity <= 0\n *     then true\n *     else\n *       let status : OclAny[1] = self.eReference.containment = false\n *       in\n *         \'NonContainmentReference::eReferenceIsNonContainment\'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)\n *     endif\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> severity_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%>.INSTANCE.evaluate(evaluator, <%pamtram.metamodel.MetamodelTables%>.STR_NonContainmentReference_c_c_eReferenceIsNonContainment));\nfinal /*@NonInvalid\052/ boolean le = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%>.INSTANCE.evaluate(evaluator, severity_0, <%pamtram.metamodel.MetamodelTables%>.INT_0).booleanValue());\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n    symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n}\nelse {\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\n    try {\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EReference%> eReference = this.getEReference();\n        final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> containment = eReference.isContainment();\n        final /*@Thrown\052/ boolean status = !containment;\n        CAUGHT_status = status;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.metamodel.MetamodelTables%>.STR_NonContainmentReference_c_c_eReferenceIsNonContainment, this, null, diagnostics, context, null, severity_0, CAUGHT_status, <%pamtram.metamodel.MetamodelTables%>.INT_0).booleanValue());\n    symbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean eReferenceIsNonContainment(DiagnosticChain diagnostics, Map<Object, Object> context);

} // NonContainmentReference
