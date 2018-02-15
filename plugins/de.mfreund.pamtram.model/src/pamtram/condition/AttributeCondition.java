/**
 */
package pamtram.condition;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import pamtram.MatchSpecElement;
import pamtram.structure.constraint.ValueConstraint;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This condition can be used to check the value of an Attribute.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.AttributeCondition#getValueConstraints <em>Value Constraints</em>}</li>
 * </ul>
 *
 * @see pamtram.condition.ConditionPackage#getAttributeCondition()
 * @model
 * @generated
 */
public interface AttributeCondition extends Condition<SourceSectionAttribute>, MatchSpecElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> {
	/**
	 * Returns the value of the '<em><b>Value Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.structure.constraint.ValueConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Constraint</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A list of ValueConstraints that specify a single reference value or a list/range of reference values which the value of the 'target' Attribute must or must not satisfy.
	 * <br /><br />
	 * A certain attribute (value) in a source model will only match against the specified 'target' Attribute if all specified constraints are met.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value Constraints</em>' containment reference list.
	 * @see pamtram.condition.ConditionPackage#getAttributeCondition_ValueConstraints()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ValueConstraint> getValueConstraints();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif (this.target == null || !this.isMappingCondition()\r\n\t\t|| ((&lt;%pamtram.mapping.Mapping%&gt;) this.getRootCondition().eContainer()).getSourceSection() == null\r\n\t\t|| this.followExternalReferences) {\r\n\treturn true;\r\n}\r\n\r\n&lt;%pamtram.structure.source.SourceSection%&gt; sourceSection = ((Mapping) this.getRootCondition().eContainer()).getSourceSection();\r\n\r\nboolean result = true;\r\nString errorMessage = \"\";\r\n\r\nif (this.isLocalCondition() &amp;&amp; !sourceSection.equals(this.target.getContainingSection())\r\n\t\t&amp;&amp; !sourceSection.getAllExtend().contains(this.target.getContainingSection())) {\r\n\r\n\tresult = false;\r\n\terrorMessage = \"The target Attribute is not part of the SourceSection specified by this Mapping. This is not allowed unless \'followExternalReferences\' is set to \'true\'.\";\r\n\r\n} else if (this.getReferenceMatchSpec().parallelStream()\r\n\t\t.anyMatch(r -&gt; !r.getContainingSection().equals(sourceSection))) {\r\n\r\n\tresult = false;\r\n\terrorMessage = \"The specified Reference Match Spec contains Cross References. This is not allowed unless \'followExternalReferences\' is set to \'true\'.\";\r\n\r\n}\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tdiagnostics.add(new BasicDiagnostic(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR, &lt;%pamtram.condition.util.ConditionValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\tConditionValidator.ATTRIBUTE_CONDITION__VALIDATE_FOLLOW_EXTERNAL_REFERENCES_TRUE_IF_REQUIRED,\r\n\t\t\terrorMessage, new Object[] { this, &lt;%pamtram.condition.ConditionPackage%&gt;.Literals.CONDITION__TARGET }));\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateFollowExternalReferencesTrueIfRequired(DiagnosticChain diagnostics, Map<?, ?> context);

} // AttributeCondition
