/**
 */
package pamtram.structure;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Reference</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link pamtram.structure.Reference#getEReference <em>EReference</em>}</li>
 * <li>{@link pamtram.structure.Reference#getOwningClass <em>Owning Class</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.MetamodelPackage#getReference()
 * @model abstract="true" annotation="http://www.eclipse.org/emf/2002/Ecore constraints='eReferenceMatchesParentEClass'"
 * @generated
 */
public interface Reference<S extends Section<S, C, R, A>, C extends pamtram.structure.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>>
		extends MetaModelElement<S, C, R, A> {

	/**
	 * Returns the value of the '<em><b>EReference</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EReference</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>EReference</em>' reference.
	 * @see #setEReference(EReference)
	 * @see pamtram.structure.MetamodelPackage#getReference_EReference()
	 * @model required="true"
	 * @generated
	 */
	EReference getEReference();

	/**
	 * Sets the value of the '{@link pamtram.structure.Reference#getEReference <em>EReference</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>EReference</em>' reference.
	 * @see #getEReference()
	 * @generated
	 */
	void setEReference(EReference value);

	/**
	 * Returns the value of the '<em><b>Owning Class</b></em>' container reference. It is bidirectional and its opposite
	 * is '{@link pamtram.structure.Class#getReferences <em>References</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Class</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Owning Class</em>' container reference.
	 * @see pamtram.structure.MetamodelPackage#getReference_OwningClass()
	 * @see pamtram.structure.Class#getReferences
	 * @model opposite="references" transient="false" changeable="false"
	 * @generated
	 */
	C getOwningClass();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif(this.isLibraryEntry() ||
	 *        this.getEReference() == null || !(this.eContainer() instanceof <%pamtram.structure.Class%>)) {\r\n\treturn
	 *        true;\r\n}\r\n\r\n<%org.eclipse.emf.ecore.EClass%> parentEClass = ((Class<?, ?, ?, ?>)
	 *        this.eContainer()).getEClass();\r\n\r\nboolean result = parentEClass == null ? true :
	 *        parentEClass.getEAllReferences().contains(this.getEReference());\r\n\r\nif (!result && diagnostics !=
	 *        null) {\r\n\r\n\tString errorMessage = \"The eReference \'\" + this.getEReference().getName() + \"\' is
	 *        not allowed by the containing Class!\";\r\n\r\n\tdiagnostics.add(new
	 *        <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.structure.util.StructureValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMetamodelValidator.REFERENCE__VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew
	 *        Object[] { this, <%pamtram.structure.MetamodelPackage%>.Literals.REFERENCE__EREFERENCE
	 *        }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateEReferenceMatchesParentEClass(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @model kind="operation"
	 * @generated
	 */
	EList<C> getValuesGeneric();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @model valuesMany="true"
	 * @generated
	 */
	void addValuesGeneric(EList<C> values);

	void addValuesGeneric(List<C> values);

} // Reference
