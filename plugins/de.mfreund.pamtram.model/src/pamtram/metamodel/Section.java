/**
 */
package pamtram.metamodel;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.Section#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link pamtram.metamodel.Section#getExtend <em>Extend</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getSection()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='extendsValidSections containerMatchesExtendContainer'"
 * @generated
 */
public interface Section<S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends pamtram.metamodel.Class<S, C, R, A> {

	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see #setAbstract(boolean)
	 * @see pamtram.metamodel.MetamodelPackage#getSection_Abstract()
	 * @model default="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!Section{S,C,R,A}!abstract'"
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.Section#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Extend</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extend</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extend</em>' reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getSection_Extend()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!Section{S,C,R,A}!extend'"
	 * @generated
	 */
	EList<S> getExtend();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if(this.getEClass() == null) {\r\n\treturn true;\r\n}\r\n\r\nfor (S extend : this.getExtend()) {\r\n\tif(!extend.isAbstract() || extend.getEClass() != null && !(this.getEClass() == extend.getEClass()) && !(this.getEClass().getEAllSuperTypes().contains(extend.getEClass()))) {\r\n\t\treturn false;\r\n\t}\r\n}\r\n\r\nreturn true;'"
	 * @generated
	 */
	boolean extendsOnlyValidSections();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if(this.getContainer() == null) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = this.getExtend().parallelStream().allMatch(\r\n\t\te -> e.getContainer() == null || e.getContainer() == this.getContainer());\r\n\r\nif (!result && diagnostics != null) {\r\n\t\r\n\tString errorMessage = \"The section extends a section that specifies a different container!\";\r\n\t\r\n\tdiagnostics.add\r\n\t\t(new BasicDiagnostic\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t <%pamtram.metamodel.util.MetamodelValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\tMetamodelValidator.SECTION__VALIDATE_CONTAINER_MATCHES_EXTEND_CONTAINER,\r\n\t\t\t errorMessage,\r\n\t\t\t new Object [] { this, <%pamtram.metamodel.MetamodelPackage%>.Literals.SECTION__EXTEND }));\r\n\t}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateContainerMatchesExtendContainer(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv extendsValidSections:\n *   let severity : Integer[1] = 4\n *   in\n *     let status : OclAny[?] = self.extendsOnlyValidSections()\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'The section extends a section that is either not abstract or that references an EClass of a different (super-)type!\'\n *         else null\n *         endif\n *       in\n *         \'Section::extendsValidSections\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Executor%> executor = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getExecutor(this);\n/*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    final /*@Thrown\052/ boolean status = this.extendsOnlyValidSections();\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    message_0 = <%pamtram.metamodel.MetamodelTables%>.STR_The_32_section_32_extends_32_a_32_section_32_that_32_is_32_either_32_not_32_abstract_32_or_32_tha;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(executor, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.metamodel.MetamodelTables%>.STR_Section_c_c_extendsValidSections, this, null, diagnostics, context, message_0, <%pamtram.metamodel.MetamodelTables%>.INT_4, CAUGHT_status, <%pamtram.metamodel.MetamodelTables%>.INT_0).booleanValue();\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean extendsValidSections(DiagnosticChain diagnostics, Map<Object, Object> context);
} // Section
