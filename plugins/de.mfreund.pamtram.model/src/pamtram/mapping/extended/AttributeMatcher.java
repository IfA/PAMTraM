/**
 */
package pamtram.mapping.extended;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;

import pamtram.structure.InstanceSelector;
import pamtram.structure.target.TargetSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Matcher</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An AttributeMatcher can be used to determine the target instance(s) for a ReferenceTargetSelector.
 * <br />
 * Thereby, a certain subset of the elements that have been created based on the specified 'target' Attribute (resp. the containing TargetSectionClass) is used as target instances.
 * <br />
 * The selection process is based on the comparison of the value of a the 'target' attribute of the created instance with a reference value. The reference value is thereby calculated based on the list of specified 'sourceElements'.
 * <br /><br />
 * Note: In cases where all instances created based on the denoted 'target' Attribute (resp. the containing TargetSectionClass) shall be used, a simple ClassMatcher can be used instead.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.extended.AttributeMatcher#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.extended.ExtendedPackage#getAttributeMatcher()
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
	 * <!-- begin-model-doc -->
	 * The specific attribute of the created TargetSections whose value is compared with the reference value used by this matcher.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(TargetSectionAttribute)
	 * @see pamtram.mapping.extended.ExtendedPackage#getAttributeMatcher_Target()
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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (!(this.eContainer() instanceof &lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt;)\r\n\t\t\t\t|| ((&lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt;) this.eContainer()).getAffectedReference() == null\r\n\t\t\t\t|| ((&lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt;) this.eContainer()).getAffectedReference().getEReference() == null\r\n\t\t\t\t|| this.getTarget() == null\r\n\t\t\t\t|| !(this.getTarget().eContainer() instanceof pamtram.structure.generic.Class&lt;?, ?, ?, ?&gt;)) {\r\n\t\t\treturn true;\r\n\t\t}\r\n\r\tboolean result = true;\r\n\t\tString errorMessage = \"\";\r\n\r\tif (!this.getTarget().getContainingSection().isAbstract()) {\r\n\t\t\tresult = ((&lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt;) this.eContainer()).getAffectedReference().getEReference()\r\n\t\t\t\t\t.getEReferenceType().isSuperTypeOf(\r\n\t\t\t\t\t\t\t((pamtram.structure.generic.Class&lt;?, ?, ?, ?&gt;) this.getTarget().eContainer()).getEClass());\r\n\t\t\terrorMessage = \"The type of the class containing the target attribute (\'\"\r\n\t\t\t\t\t+ ((pamtram.structure.generic.Class&lt;?, ?, ?, ?&gt;) this.getTarget().eContainer()).getEClass()\r\n\t\t\t\t\t\t\t.getName()\r\n\t\t\t\t\t+ \"\') is not allowed by the affected reference of the parent &lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt; that \"\r\n\t\t\t\t\t+ \"requires a (sub-)type of \'\"\r\n\t\t\t\t\t+ ((pamtram.mapping.extended.ReferenceTargetSelector) this.eContainer()).getAffectedReference()\r\n\t\t\t\t\t\t\t.getEReference().getEReferenceType().getName()\r\n\t\t\t\t\t+ \"\'!\";\r\n\t\t} else {\r\n\t\t\t&lt;%pamtram.PAMTraM%&gt; pamtram = (&lt;%pamtram.PAMTraM%&gt;) &lt;%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%&gt;.getAncestorOfType(this, &lt;%pamtram.PamtramPackage%&gt;.Literals.PAM_TRA_M);\r\n\t\t\tList&lt;&lt;%pamtram.structure.target.TargetSection%&gt;&gt; concreteSections = pamtram.getTargetSections().stream()\r\n\t\t\t\t\t.filter(t -&gt; t.getAllExtend().contains(this.getTarget().getContainingSection()))\r\n\t\t\t\t\t.collect(&lt;%java.util.stream.Collectors%&gt;.toList());\r\n\r\t\tif (((pamtram.mapping.extended.ReferenceTargetSelector) this.eContainer()).getAffectedReference().getValue()\r\n\t\t\t\t\t.size() &gt; 1) {\r\n\t\t\t\tresult = false;\r\n\t\t\t\terrorMessage = \"If AttributeMatchers are defined based on a target attribute in an abstract TargetSection, only one possible target value for the affected reference of the containing &lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt; must be specified!\";\r\n\t\t\t} else if (((pamtram.mapping.extended.ReferenceTargetSelector) this.eContainer()).getAffectedReference()\r\n\t\t\t\t\t.getValue().isEmpty()) {\r\n\t\t\t\tif (!(this.target.eContainer() instanceof &lt;%pamtram.structure.target.TargetSection%&gt;)) {\r\n\t\t\t\t\tresult = false;\r\n\t\t\t\t\terrorMessage = \"If AttributeMatchers are defined based on a target attribute in an abstract &lt;%pamtram.structure.target.TargetSection%&gt; and no target value is specified for the affected reference of the containing ReferenceTargetSelector, the target attribute needs to be a direct child of this TargetSection!\";\r\n\t\t\t\t} else {\r\n\t\t\t\t\tlong possibleRedirectionTargets = concreteSections.stream()\r\n\t\t\t\t\t\t\t.filter(c -&gt; ((pamtram.mapping.extended.ReferenceTargetSelector) this.eContainer())\r\n\t\t\t\t\t\t\t\t\t.getAffectedReference().getEReference().getEReferenceType()\r\n\t\t\t\t\t\t\t\t\t.isSuperTypeOf(c.getEClass()))\r\n\t\t\t\t\t\t\t.count();\r\n\t\t\t\t\tif (possibleRedirectionTargets &gt; 1) {\r\n\t\t\t\t\t\tresult = false;\r\n\t\t\t\t\t\terrorMessage = \"If AttributeMatchers are defined based on a target attribute in an abstract &lt;%pamtram.structure.target.TargetSection%&gt; and there are multiple possible concrete (extending) TargetSections suitable for the affected reference of the containing ReferenceTargetSelector, a target value for the affected reference needs to be specified!\";\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\t\t\t}\r\n\r\t}\r\n\r\tif (!result &amp;&amp; diagnostics != null) {\r\n\r\t\tdiagnostics.add(new BasicDiagnostic(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR, &lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t&lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.ATTRIBUTE_MATCHER__VALIDATE_TARGET_MATCHES_AFFECTED_REFERENCE_TYPE, errorMessage,\r\n\t\t\t\t\tnew Object[] { this, &lt;%pamtram.mapping.extended.ExtendedPackage%&gt;.Literals.ATTRIBUTE_MATCHER__TARGET }));\r\n\r\t}\r\n\r\treturn result;'"
	 * @generated
	 */
	boolean validateTargetMatchesAffectedReferenceType(DiagnosticChain diagnostics, Map<?, ?> context);

} // AttributeMatcher
