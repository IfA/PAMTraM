/**
 */
package pamtram.structure.source;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import pamtram.structure.generic.VirtualAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Virtual Source Section Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.source.VirtualSourceSectionAttribute#getDerivation <em>Derivation</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.source.SourcePackage#getVirtualSourceSectionAttribute()
 * @model
 * @generated
 */
public interface VirtualSourceSectionAttribute extends SourceSectionAttribute, VirtualAttribute<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> {
	/**
	 * Returns the value of the '<em><b>Derivation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derivation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derivation</em>' attribute.
	 * @see #setDerivation(String)
	 * @see pamtram.structure.source.SourcePackage#getVirtualSourceSectionAttribute_Derivation()
	 * @model required="true"
	 * @generated
	 */
	String getDerivation();

	/**
	 * Sets the value of the '{@link pamtram.structure.source.VirtualSourceSectionAttribute#getDerivation <em>Derivation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Derivation</em>' attribute.
	 * @see #getDerivation()
	 * @generated
	 */
	void setDerivation(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif (this.getDerivation() == null || this.getDerivation().isEmpty()\r\n\t\t|| !(this.eContainer() instanceof SourceSectionClass)\r\n\t\t|| ((<%pamtram.structure.source.SourceSectionClass%>) this.eContainer()).getEClass() == null) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = true;\r\nString parserException = \"\";\r\n\r\ntry {\r\n\t<%de.mfreund.pamtram.util.OCLUtil%>.validateQuery(this.getDerivation(), ((SourceSectionClass) this.eContainer()).getEClass());\r\n} catch (<%org.eclipse.ocl.ParserException%> e) {\r\n\tresult = false;\r\n\tparserException = e.getMessage();\r\n\te.printStackTrace();\r\n}\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The specified derivation is not valid! The following error was provided: \" + parserException;\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.structure.source.util.SourceValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tSourceValidator.VIRTUAL_SOURCE_SECTION_ATTRIBUTE__VALIDATE_DERIVATION,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.source.SourcePackage%>.Literals.VIRTUAL_SOURCE_SECTION_ATTRIBUTE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateDerivation(DiagnosticChain diagnostics, Map<?, ?> context);

} // VirtualSourceSectionAttribute
