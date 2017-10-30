/**
 */
package dfd;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dfd.Flow#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link dfd.Flow#getOutgoing <em>Outgoing</em>}</li>
 * </ul>
 *
 * @see dfd.DfdPackage#getFlow()
 * @model abstract="true"
 * @generated
 */
public interface Flow extends EObject {
	/**
	 * Returns the value of the '<em><b>Incoming</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming</em>' reference.
	 * @see #setIncoming(DFDElement)
	 * @see dfd.DfdPackage#getFlow_Incoming()
	 * @model
	 * @generated
	 */
	DFDElement getIncoming();

	/**
	 * Sets the value of the '{@link dfd.Flow#getIncoming <em>Incoming</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Incoming</em>' reference.
	 * @see #getIncoming()
	 * @generated
	 */
	void setIncoming(DFDElement value);

	/**
	 * Returns the value of the '<em><b>Outgoing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing</em>' reference.
	 * @see #setOutgoing(DFDElement)
	 * @see dfd.DfdPackage#getFlow_Outgoing()
	 * @model
	 * @generated
	 */
	DFDElement getOutgoing();

	/**
	 * Sets the value of the '{@link dfd.Flow#getOutgoing <em>Outgoing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outgoing</em>' reference.
	 * @see #getOutgoing()
	 * @generated
	 */
	void setOutgoing(DFDElement value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean result = this.incoming == null || this.incoming.eContainer().equals(this.eContainer);\r\n\t\t\r\n\t\tif (!result &amp;&amp; diagnostics != null) {\r\n\t\t\t\r\n\t\t\tString errorMessage = \"The \'incoming\' element is not part of the same (Sub-)System!\";\r\n\t\t\r\n\t\t\tdiagnostics.add(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR,\r\n\t\t\t\t\t&lt;%dfd.util.DfdValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t&lt;%dfd.util.DfdValidator%&gt;.FLOW__VALIDATE_INCOMING_POINTS_TO_ELEMENT_OF_SAME_SYSTEM,\r\n\t\t\t\t\t\t\terrorMessage,\r\n\t\t\t\t\tnew Object[] { this, &lt;%dfd.DfdPackage%&gt;.Literals.FLOW__INCOMING}));\r\n\t\t\r\n\t\t}\r\n\r\treturn result;'"
	 * @generated
	 */
	boolean validateIncomingPointsToElementOfSameSystem(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean result = this.outgoing == null || this.outgoing.eContainer().equals(this.eContainer);\r\n\r\tif (!result &amp;&amp; diagnostics != null) {\r\n\r\t\tString errorMessage = \"The \'outgoing\' element of this &lt;%structuredAnalysis.Flow%&gt; is not part of the same (Sub-)System as this Flow!\";\r\n\r\t\tdiagnostics.add(new BasicDiagnostic(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR, &lt;%dfd.util.DfdValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t&lt;%dfd.util.DfdValidator%&gt;.FLOW__VALIDATE_OUTGOING_POINTS_TO_ELEMENT_OF_SAME_SYSTEM, errorMessage,\r\n\t\t\t\t\tnew Object[] { this, &lt;%dfd.DfdPackage%&gt;.Literals.FLOW__OUTGOING }));\r\n\r\t}\r\n\r\treturn result;'"
	 * @generated
	 */
	boolean validateOutgoingPointsToElementOfSameSystem(DiagnosticChain diagnostics, Map<?, ?> context);

} // Flow
