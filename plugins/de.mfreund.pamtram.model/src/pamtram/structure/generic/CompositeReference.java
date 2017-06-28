/**
 */
package pamtram.structure.generic;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Containment Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This represents a reference of an element structure. CompositeReferences can be used to describe the tree that is the basis of an element structure.
 * <br />
 * In order to allow for the description of complex element structures, target elements (Classes) can be specified for References via the 'value' reference.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.generic.CompositeReference#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.generic.GenericPackage#getCompositeReference()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='eReferenceIsContainment'"
 * @generated
 */
public interface CompositeReference<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends Reference<S, C, R, A> {

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of elements (Classes) further describing the element structure.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value</em>' containment reference list.
	 * @see pamtram.structure.generic.GenericPackage#getCompositeReference_Value()
	 * @model containment="true"
	 * @generated
	 */
	EList<C> getValue();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n<%org.eclipse.emf.ecore.EReference%> reference = this instanceof <%pamtram.structure.generic.ActualReference%> ? ((ActualReference<?, ?, ?, ?>) this).getEReference() : null;\r\n\r\nboolean result = reference == null || reference.isContainment();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The eReference \'\" + reference.getName() + \"\' is no containment reference!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.structure.generic.util.GenericValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tGenericValidator.COMPOSITE_REFERENCE__VALIDATE_EREFERENCE_IS_CONTAINMENT,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.generic.GenericPackage%>.Literals.ACTUAL_REFERENCE__EREFERENCE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateEReferenceIsContainment(DiagnosticChain diagnostics, Map<?, ?> context);

} // CompositeReference
