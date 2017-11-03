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
 * <!-- begin-model-doc -->
 * This represents an attribute of a source model element structure. In contrast to 'actual' Attributes, 'virtual' Attributes do not represent an actual metamodel element (EAttribtue) but can be used to create additional (virtual) attributes.
 * <br />
 *  As the Attribute is not based on an actual EAttribute, the actual values held by this Attribute need to be specified manually. Therefore, a 'derivation' specification has to be given by the modeler.
 * <!-- end-model-doc -->
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
	 * <!-- begin-model-doc -->
	 * An OCL expression describing the derivation of the actual value(s) of this attribute.
	 * <!-- end-model-doc -->
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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif (this.getDerivation() == null || this.getDerivation().isEmpty()\r\n\t\t|| !(this.eContainer() instanceof SourceSectionClass)\r\n\t\t|| ((&lt;%pamtram.structure.source.SourceSectionClass%&gt;) this.eContainer()).getEClass() == null) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = true;\r\nString parserException = \"\";\r\n\r\ntry {\r\n\t&lt;%pamtram.util.OCLUtil%&gt;.validateQuery(this.getDerivation(), ((SourceSectionClass) this.eContainer()).getEClass());\r\n} catch (&lt;%org.eclipse.ocl.ParserException%&gt; e) {\r\n\tresult = false;\r\n\tparserException = e.getMessage();\r\n\te.printStackTrace();\r\n}\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"The specified derivation is not valid! The following error was provided: \" + parserException;\r\n\r\n\tdiagnostics.add(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR,\r\n\t\t\t&lt;%pamtram.structure.source.util.SourceValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tSourceValidator.VIRTUAL_SOURCE_SECTION_ATTRIBUTE__VALIDATE_DERIVATION,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.structure.source.SourcePackage%&gt;.Literals.VIRTUAL_SOURCE_SECTION_ATTRIBUTE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateDerivation(DiagnosticChain diagnostics, Map<?, ?> context);

} // VirtualSourceSectionAttribute
