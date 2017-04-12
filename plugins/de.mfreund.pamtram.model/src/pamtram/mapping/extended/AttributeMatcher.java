/**
 */
package pamtram.mapping.extended;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;

import pamtram.mapping.ExpandableHint;
import pamtram.mapping.MappingPackage;
import pamtram.structure.InstanceSelector;
import pamtram.structure.target.TargetSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Matcher</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.extended.AttributeMatcher#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getAttributeMatcher()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='targetMatchesAffectedReferenceType'"
 * @generated
 */
public interface AttributeMatcher extends Matcher, ExpandableHint, InstanceSelector {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(TargetSectionAttribute)
	 * @see pamtram.mapping.MappingPackage#getAttributeMatcher_Target()
	 * @model required="true"
	 * @generated
	 */
	TargetSectionAttribute getTarget();

	/**
	 * Sets the value of the '{@link pamtram.mapping.extended.AttributeMatcher#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(TargetSectionAttribute value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif(!(this.eContainer() instanceof <%pamtram.mapping.ReferenceTargetSelector%>) || ((ReferenceTargetSelector) this.eContainer()).getAffectedReference() == null || ((ReferenceTargetSelector) this.eContainer()).getAffectedReference().getEReference() == null || this.getTarget() == null || !(this.getTarget().eContainer() instanceof pamtram.structure.generic.Class<?, ?, ?, ?>)) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = ((ReferenceTargetSelector) this.eContainer()).getAffectedReference().getEReference().getEReferenceType().isSuperTypeOf(((pamtram.structure.generic.Class<?, ?, ?, ?>) this.getTarget().eContainer()).getEClass());\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The type of the class containing the target attribute (\'\" + \r\n\t\t\t((pamtram.structure.generic.Class<?, ?, ?, ?>) this.getTarget().eContainer()).getEClass().getName() + \"\') is not allowed by the affected reference of the parent ReferenceTargetSelector that \" +\r\n\t\t\t\"requires a (sub-)type of \'\" + ((pamtram.mapping.ReferenceTargetSelector) this.eContainer()).getAffectedReference().getEReference().getEReferenceType().getName() + \"\'!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.util.MappingValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMappingValidator.ATTRIBUTE_MATCHER__VALIDATE_TARGET_MATCHES_AFFECTED_REFERENCE_TYPE,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.MappingPackage%>.Literals.ATTRIBUTE_MATCHER__TARGET }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateTargetMatchesAffectedReferenceType(DiagnosticChain diagnostics, Map<?, ?> context);

} // AttributeMatcher
