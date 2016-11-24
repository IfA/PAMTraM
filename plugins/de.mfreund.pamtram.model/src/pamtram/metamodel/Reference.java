/**
 */
package pamtram.metamodel;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.Reference#getEReference <em>EReference</em>}</li>
 *   <li>{@link pamtram.metamodel.Reference#getOwningClass <em>Owning Class</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getReference()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='eReferenceMatchesParentEClass'"
 * @generated
 */
public interface Reference<S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends MetaModelElement<S, C, R, A> {
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
	 * @see pamtram.metamodel.MetamodelPackage#getReference_EReference()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!Reference{S,C,R,A}!eReference'"
	 * @generated
	 */
	EReference getEReference();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.Reference#getEReference <em>EReference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EReference</em>' reference.
	 * @see #getEReference()
	 * @generated
	 */
	void setEReference(EReference value);

	/**
	 * Returns the value of the '<em><b>Owning Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link pamtram.metamodel.Class#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Class</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Class</em>' container reference.
	 * @see pamtram.metamodel.MetamodelPackage#getReference_OwningClass()
	 * @see pamtram.metamodel.Class#getReferences
	 * @model opposite="references" transient="false" changeable="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!Reference{S,C,R,A}!owningClass'"
	 * @generated
	 */
	C getOwningClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif(this.isLibraryEntry() || this.getEReference() == null || !(this.eContainer() instanceof <%pamtram.metamodel.Class%>)) {\r\n\treturn true;\r\n}\r\n\r\n<%org.eclipse.emf.ecore.EClass%> parentEClass = ((Class<?, ?, ?, ?>) this.eContainer()).eClass();\r\n\r\nboolean result = parentEClass == null ? true : parentEClass.getEAllReferences().contains(this.getEReference());\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The eReference \'\" + this.getEReference().getName() + \"\' is not allowed by the containing Class!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.metamodel.util.MetamodelValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMetamodelValidator.REFERENCE__VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.metamodel.MetamodelPackage%>.Literals.REFERENCE__EREFERENCE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateEReferenceMatchesParentEClass(DiagnosticChain diagnostics, Map<?, ?> context);

} // Reference
