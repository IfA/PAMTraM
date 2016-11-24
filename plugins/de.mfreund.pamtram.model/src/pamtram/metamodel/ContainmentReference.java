/**
 */
package pamtram.metamodel;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Containment Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.ContainmentReference#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getContainmentReference()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='eReferenceIsContainment'"
 * @generated
 */
public interface ContainmentReference<S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends Reference<S, C, R, A> {

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getContainmentReference_Value()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!ContainmentReference{S,C,R,A}!value'"
	 * @generated
	 */
	EList<C> getValue();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this.getEReference() == null ? true : this.getEReference().isContainment();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The eReference \'\" + this.getEReference().getName() + \"\' is no containment reference!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.metamodel.util.MetamodelValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMetamodelValidator.CONTAINMENT_REFERENCE__VALIDATE_EREFERENCE_IS_CONTAINMENT,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.metamodel.MetamodelPackage%>.Literals.REFERENCE__EREFERENCE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateEReferenceIsContainment(DiagnosticChain diagnostics, Map<?, ?> context);

} // ContainmentReference
