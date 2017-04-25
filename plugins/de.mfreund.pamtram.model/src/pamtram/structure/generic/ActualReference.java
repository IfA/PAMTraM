/**
 */
package pamtram.structure.generic;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EReference;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actual Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.generic.ActualReference#getEReference <em>EReference</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.generic.GenericPackage#getActualReference()
 * @model abstract="true"
 * @generated
 */
public interface ActualReference<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends Reference<S, C, R, A> {

	/**
	 * Returns the value of the '<em><b>EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EReference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EReference</em>' reference.
	 * @see #setEReference(EReference)
	 * @see pamtram.structure.generic.GenericPackage#getActualReference_EReference()
	 * @model required="true"
	 * @generated
	 */
	EReference getEReference();

	/**
	 * Sets the value of the '{@link pamtram.structure.generic.ActualReference#getEReference <em>EReference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EReference</em>' reference.
	 * @see #getEReference()
	 * @generated
	 */
	void setEReference(EReference value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif(this.isLibraryEntry() || this.getEReference() == null || !(this.eContainer() instanceof <%pamtram.structure.generic.Class%>)) {\r\n\treturn true;\r\n}\r\n\r\n<%org.eclipse.emf.ecore.EClass%> parentEClass = ((<%pamtram.structure.generic.Class%><?, ?, ?, ?>) this.eContainer()).getEClass();\r\n\r\nboolean result = parentEClass == null ? true : parentEClass.getEAllReferences().contains(this.getEReference());\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The eReference \'\" + this.getEReference().getName() + \"\' is not allowed by the containing Class!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.structure.generic.util.GenericValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tGenericValidator.ACTUAL_REFERENCE__VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.generic.GenericPackage%>.Literals.ACTUAL_REFERENCE__EREFERENCE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateEReferenceMatchesParentEClass(DiagnosticChain diagnostics, Map<?, ?> context);
} // ActualReference
