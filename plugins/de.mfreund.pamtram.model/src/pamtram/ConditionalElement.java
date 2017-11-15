/**
 */
package pamtram;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import pamtram.condition.ComplexCondition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A ConditionalElement is an element that can be attached with a Condition which restrains its applicability during the course of a transformation. This can e.g. be used to specify a platform condition which ensures that the element will only be evaluated if a certain scree size is available.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.ConditionalElement#getLocalCondition <em>Local Condition</em>}</li>
 *   <li>{@link pamtram.ConditionalElement#getSharedCondition <em>Shared Condition</em>}</li>
 *   <li>{@link pamtram.ConditionalElement#getAllConditions <em>All Conditions</em>}</li>
 * </ul>
 *
 * @see pamtram.PamtramPackage#getConditionalElement()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='eitherModelOrReferCondition referenceOnlyConditionsFromConditionModel'"
 * @generated
 */
public interface ConditionalElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The (locally defined) Condition which restrains the applicability of this element during the course of a transformation.
	 * <br />
	 * This can e.g. be used to specify a platform condition which ensures that the element will only be evaluated if a certain scree size is available.
	 * <br />
	 * Note: Only one of 'localCondition' or 'sharedCondition' may be set for each element!
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Local Condition</em>' containment reference.
	 * @see #setLocalCondition(ComplexCondition)
	 * @see pamtram.PamtramPackage#getConditionalElement_LocalCondition()
	 * @model containment="true"
	 * @generated
	 */
	ComplexCondition getLocalCondition();

	/**
	 * Sets the value of the '{@link pamtram.ConditionalElement#getLocalCondition <em>Local Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Condition</em>' containment reference.
	 * @see #getLocalCondition()
	 * @generated
	 */
	void setLocalCondition(ComplexCondition value);

	/**
	 * Returns the value of the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The (globally defined) referenced Condition which restrains the applicability of this element during the course of a transformation.
	 * <br />
	 * This can e.g. be used to specify a platform condition which ensures that the element will only be evaluated if a certain scree size is available.
	 * <br />
	 * Note: Only one of 'localCondition' or 'sharedCondition' may be set for each element!
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Shared Condition</em>' reference.
	 * @see #setSharedCondition(ComplexCondition)
	 * @see pamtram.PamtramPackage#getConditionalElement_SharedCondition()
	 * @model
	 * @generated
	 */
	ComplexCondition getSharedCondition();

	/**
	 * Sets the value of the '{@link pamtram.ConditionalElement#getSharedCondition <em>Shared Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shared Condition</em>' reference.
	 * @see #getSharedCondition()
	 * @generated
	 */
	void setSharedCondition(ComplexCondition value);

	/**
	 * Returns the value of the '<em><b>All Conditions</b></em>' reference list.
	 * The list contents are of type {@link pamtram.condition.ComplexCondition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Conditions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Conditions</em>' reference list.
	 * @see pamtram.PamtramPackage#getConditionalElement_AllConditions()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='java.util.Set&lt;Object&gt; ret = new java.util.LinkedHashSet&lt;&gt;();\r\n\r\n\tif (this.getLocalCondition() != null) {\r\n\t\t\tret.add(this.getLocalCondition());\r\n\t\t}\r\n\t\tif (this.getSharedCondition() != null) {\r\n\t\t\tret.add(this.getSharedCondition());\r\n\t\t}\r\n\r\n\tif (this instanceof &lt;%pamtram.mapping.MappingHintGroup%&gt;) {\r\n\t\t\t// Add Conditions of the Mappings of extended MappingHintGroups\r\n\t\t\t//\r\n\t\t\tret.addAll(((&lt;%pamtram.mapping.MappingHintGroup%&gt;) this).getExtend().stream().filter(hg -&gt; hg.eContainer() instanceof pamtram.mapping.Mapping).flatMap(hg -&gt; ((pamtram.mapping.Mapping) hg.eContainer()).getAllConditions().stream()).collect(&lt;%java.util.stream.Collectors%&gt;.toSet()));\r\n\t\t\t// Add Conditions of extended MappingHintGroups\r\n\t\t\t//\r\n\t\t\tret.addAll(((&lt;%pamtram.mapping.MappingHintGroup%&gt;) this).getExtend().stream().filter(mhg -&gt; mhg instanceof &lt;%pamtram.ConditionalElement%&gt;)\r\n\t\t\t\t\t.flatMap(mhg -&gt; ((&lt;%pamtram.ConditionalElement%&gt;) mhg).getAllConditions().stream())\r\n\t\t\t\t\t.collect(&lt;%java.util.stream.Collectors%&gt;.toSet()));\r\n\t\t}\r\n\r\n\treturn new &lt;%org.eclipse.emf.ecore.util.EcoreEList%&gt;.UnmodifiableEList&lt;&gt;(this, &lt;%pamtram.PamtramPackage%&gt;.Literals.CONDITIONAL_ELEMENT__ALL_CONDITIONS,\r\n\t\t\t\tret.size(), ret.toArray());'"
	 * @generated
	 */
	EList<ComplexCondition> getAllConditions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this.getSharedCondition() == null || this.getSharedCondition().eContainer() instanceof &lt;%pamtram.ConditionModel%&gt;;\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"It is only allowed to reference shared conditions that are model inside the ConditionModel!\";\r\n\r\n\tdiagnostics.add(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR,\r\n\t\t\tPamtramValidator.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t&lt;%pamtram.util.PamtramValidator%&gt;.CONDITIONAL_ELEMENT__VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, PamtramPackage.Literals.CONDITIONAL_ELEMENT__SHARED_CONDITION }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateReferenceOnlyConditionsFromConditionModel(DiagnosticChain diagnostics, Map<?, ?> context);

} // ConditionalElement
