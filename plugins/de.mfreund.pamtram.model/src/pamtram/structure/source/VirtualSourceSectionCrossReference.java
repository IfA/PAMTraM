/**
 */
package pamtram.structure.source;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import pamtram.structure.generic.CrossReference;
import pamtram.structure.generic.VirtualReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Virtual Source Section Cross Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This represents a reference of a source model element structure. CrossReferences can be used to describe references to other element structures or to other elements of this structure.
 * <br />
 * In order to allow for the description of complex element structures, target elements (Classes) can be specified for References via the 'value' reference.
 * <br /><br />
 * In contrast to 'actual' References, 'virtual' Reference do not represent an actual metamodel element (EReference) but can be used to create additional (virtual) references. As the Reference is not based on an actual EReference, the actual instances of the specified target Classes need to be specified manually. Therefore, a 'derivation' specification has to be given by the modeler.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.source.VirtualSourceSectionCrossReference#getDerivation <em>Derivation</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.source.SourcePackage#getVirtualSourceSectionCrossReference()
 * @model
 * @generated
 */
public interface VirtualSourceSectionCrossReference extends CrossReference<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>, SourceSectionReference, VirtualReference<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> {
	/**
	 * Returns the value of the '<em><b>Derivation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derivation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An OCL expression describing the derivation of the actual instances of the specified target Classes.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Derivation</em>' attribute.
	 * @see #setDerivation(String)
	 * @see pamtram.structure.source.SourcePackage#getVirtualSourceSectionCrossReference_Derivation()
	 * @model required="true"
	 * @generated
	 */
	String getDerivation();

	/**
	 * Sets the value of the '{@link pamtram.structure.source.VirtualSourceSectionCrossReference#getDerivation <em>Derivation</em>}' attribute.
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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif (this.getDerivation() == null || this.getDerivation().isEmpty()\r\n\t\t|| !(this.eContainer() instanceof SourceSectionClass)\r\n\t\t|| ((<%pamtram.structure.source.SourceSectionClass%>) this.eContainer()).getEClass() == null) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = true;\r\nString parserException = \"\";\r\n\r\ntry {\r\n\t<%de.mfreund.pamtram.util.OCLUtil%>.validateQuery(this.getDerivation(), ((SourceSectionClass) this.eContainer()).getEClass());\r\n} catch (<%org.eclipse.ocl.ParserException%> e) {\r\n\tresult = false;\r\n\tparserException = e.getMessage();\r\n\te.printStackTrace();\r\n}\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The specified derivation is not valid! The following error was provided: \" + parserException;\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.structure.source.util.SourceValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tSourceValidator.VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE__VALIDATE_DERIVATION,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.source.SourcePackage%>.Literals.VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateDerivation(DiagnosticChain diagnostics, Map<?, ?> context);

} // VirtualSourceSectionCrossReference
