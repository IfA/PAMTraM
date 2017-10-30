/**
 */
package dfd;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dfd.Process#getNumber <em>Number</em>}</li>
 * </ul>
 *
 * @see dfd.DfdPackage#getProcess()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='DummyConstraint'"
 * @generated
 */
public interface Process extends DFDElement, DFD {
	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see #setNumber(String)
	 * @see dfd.DfdPackage#getProcess_Number()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getNumber();

	/**
	 * Sets the value of the '{@link dfd.Process#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean result = this.number == null || this.number.matches(\"[0-9]+(\\\\.[0-9]+)*\");\n\nif (!result &amp;&amp; diagnostics != null) {\n\n\tString errorMessage = \"The number is not formatted correctly! Valid numbers are e.g. \'1\', \'1.10\', or \'1.10.8\'...\";\n\n\tdiagnostics.add(new BasicDiagnostic(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR, &lt;%dfd.util.DfdValidator%&gt;.DIAGNOSTIC_SOURCE,\n\t\t\t&lt;%dfd.util.DfdValidator%&gt;.PROCESS__VALIDATE_NUMBER_FORMAT_IS_CORRECT, errorMessage,\n\t\t\tnew Object[] { this, &lt;%dfd.DfdPackage%&gt;.Literals.PROCESS__NUMBER }));\n\n}\n\nreturn result;'"
	 * @generated
	 */
	boolean validateNumberFormatIsCorrect(DiagnosticChain diagnostics, Map<?, ?> context);

} // Process
