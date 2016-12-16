/**
 */
package pamtram.mapping;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import pamtram.structure.TargetSectionNonContainmentReference;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>ReferenceTargetSelector</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.ReferenceTargetSelector#getAffectedReference <em>Affected Reference</em>}</li>
 *   <li>{@link pamtram.mapping.ReferenceTargetSelector#getMatcher <em>Matcher</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getReferenceTargetSelector()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='affectedReferenceIsNonContainment affectedReferenceMatchesSection'"
 * @generated
 */
public interface ReferenceTargetSelector extends MappingHint {
	/**
	 * Returns the value of the '<em><b>Affected Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Affected Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Affected Reference</em>' reference.
	 * @see #setAffectedReference(TargetSectionNonContainmentReference)
	 * @see pamtram.mapping.MappingPackage#getReferenceTargetSelector_AffectedReference()
	 * @model required="true"
	 * @generated
	 */
	TargetSectionNonContainmentReference getAffectedReference();

	/**
	 * Sets the value of the '{@link pamtram.mapping.ReferenceTargetSelector#getAffectedReference <em>Affected Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Affected Reference</em>' reference.
	 * @see #getAffectedReference()
	 * @generated
	 */
	void setAffectedReference(TargetSectionNonContainmentReference value);

	/**
	 * Returns the value of the '<em><b>Matcher</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matcher</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matcher</em>' containment reference.
	 * @see #setMatcher(Matcher)
	 * @see pamtram.mapping.MappingPackage#getReferenceTargetSelector_Matcher()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Matcher getMatcher();

	/**
	 * Sets the value of the '{@link pamtram.mapping.ReferenceTargetSelector#getMatcher <em>Matcher</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Matcher</em>' containment reference.
	 * @see #getMatcher()
	 * @generated
	 */
	void setMatcher(Matcher value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this.getAffectedReference() == null || this.getAffectedReference().getEReference() == null ? true : !this.getAffectedReference().getEReference().isContainment();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The affected reference \'\" + this.getAffectedReference().getName() + \"\' is no non-containment reference!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.util.MappingValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMappingValidator.REFERENCE_TARGET_SELECTOR__VALIDATE_AFFECTED_REFERENCE_IS_NON_CONTAINMENT,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.MappingPackage%>.Literals.REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateAffectedReferenceIsNonContainment(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif(this.getAffectedReference() == null) {\r\n\treturn true;\r\n}\r\n\r\n<%pamtram.structure.TargetSection%> targetSection = this.eContainer() instanceof <%pamtram.mapping.MappingHintGroupType%> ? ((MappingHintGroupType) this.eContainer()).getTargetSection() : ((<%pamtram.mapping.MappingHintGroupImporter%>) this.eContainer()).getHintGroup().getTargetSection();\r\n\r\nboolean result = targetSection == null ? true : this.getAffectedReference().getContainingSection() == targetSection || targetSection.getExtend().contains(this.getAffectedReference().getContainingSection());\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString hintGroupName = this.eContainer() instanceof MappingHintGroupType ? ((MappingHintGroupType) this.eContainer()).getName() : ((MappingHintGroupImporter) this.eContainer()).getHintGroup().getName();\r\n\tString errorMessage = \"The affected reference \'\" + this.getAffectedReference().getName() + \"\' is not part of the target section referenced by parent hint group \'\" + hintGroupName + \"\'!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.util.MappingValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMappingValidator.REFERENCE_TARGET_SELECTOR__VALIDATE_AFFECTED_REFERENCE_MATCHES_SECTION,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.MappingPackage%>.Literals.REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateAffectedReferenceMatchesSection(DiagnosticChain diagnostics, Map<?, ?> context);

} // MappingInstanceSelector
