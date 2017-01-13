/**
 */
package pamtram.structure.target;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;

import pamtram.structure.StructurePackage;
import pamtram.structure.generic.CrossReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Section Non Containment Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see pamtram.structure.StructurePackage#getTargetSectionCrossReference()
 * @model
 * @generated
 */
public interface TargetSectionCrossReference extends CrossReference<TargetSection, TargetSectionClass, TargetSectionReference, TargetSectionAttribute>, TargetSectionReference {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this.getEReference() == null ? true : !this.getEReference().isContainment();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The eReference \'\" + this.getEReference().getName() + \"\' is no non-containment reference! CrossReferences based on ContainmentReferences are not yet supported...\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.structure.util.StructureValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tStructureValidator.TARGET_SECTION_CROSS_REFERENCE__VALIDATE_EREFERENCE_IS_NON_CONTAINMENT,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.generic.GenericPackage%>.Literals.REFERENCE__EREFERENCE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateEReferenceIsNonContainment(DiagnosticChain diagnostics, Map<?, ?> context);
} // TargetSectionNonContainmentReference
