/**
 */
package pamtram.mapping.extended;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import pamtram.ExpressionElement;
import pamtram.ModifiableElement;
import pamtram.structure.target.TargetSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A MappingHint that tells the transformation algorithm how determine the value of a TargetSectionAttribute in the course of a transformation.
 * <br /><br />
 * The value is thereby determined based on the list of specified 'sourceElements' and an optional (mathematical) 'expression'.
 * <br />
 * If the expression is not present, the values of all specified source elements are treated as Strings and simply concatenated.
 * <br />
 * If an expression is present, this will be used to calculate the value. The expression may thereby reference the (numeric) values of the specified source elements via their name. For example, if a source element named 'x' is specified, a valid expression to double the value of this element would be "2*x".
 * <br /><br />
 * Note: As SourceSectionAttributes may be matched multiple times in a single source model excerpt, an AttributeMapping based on such a source element may result in multiple determined values. If this is the case, the specified 'target' attribute (and if necessary the containing TargetSectionClass) will be instantiated multiple times.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.extended.AttributeMapping#getTarget <em>Target</em>}</li>
 *   <li>{@link pamtram.mapping.extended.AttributeMapping#getSourceElements <em>Source Elements</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.extended.ExtendedPackage#getAttributeMapping()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='targetAttributeMatchesSection'"
 * @generated
 */
public interface AttributeMapping extends MappingHint, ExpressionElement, ModifiableElement, ExpandableHint {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The TargetSectionAttribute whose value is determined by this AttributeMapping.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(TargetSectionAttribute)
	 * @see pamtram.mapping.extended.ExtendedPackage#getAttributeMapping_Target()
	 * @model required="true"
	 * @generated
	 */
	TargetSectionAttribute getTarget();

	/**
	 * Sets the value of the '{@link pamtram.mapping.extended.AttributeMapping#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(TargetSectionAttribute value);

	/**
	 * Returns the value of the '<em><b>Source Elements</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.extended.AttributeMappingSourceInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Attribute Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of 'sourceElements' based on which the value of the 'target' Attribute is determined.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source Elements</em>' containment reference list.
	 * @see pamtram.mapping.extended.ExtendedPackage#getAttributeMapping_SourceElements()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<AttributeMappingSourceInterface> getSourceElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\t\tEList&lt;AttributeMappingSourceElement&gt; elements= new org.eclipse.emf.common.util.BasicEList&lt;AttributeMappingSourceElement&gt;();\r\n\t\t\r\n\t\tfor(AttributeMappingSourceInterface i : this.getSourceElements()){\r\n\t\t\tif(i instanceof AttributeMappingSourceElement){\r\n\t\t\t\telements.add((AttributeMappingSourceElement) i);\r\n\t\t\t}\r\n\t\t}\r\n\t\t\r\n\t\treturn elements;'"
	 * @generated
	 */
	EList<AttributeMappingSourceElement> getLocalSourceElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList&lt;AttributeMappingExternalSourceElement&gt; elements= new org.eclipse.emf.common.util.BasicEList&lt;AttributeMappingExternalSourceElement&gt;();\r\n\r\nfor(AttributeMappingSourceInterface i : this.getSourceElements()){\r\n\tif(i instanceof AttributeMappingExternalSourceElement){\r\n\t\telements.add((AttributeMappingExternalSourceElement) i);\r\n\t}\r\n}\r\n\r\nreturn elements;'"
	 * @generated
	 */
	EList<AttributeMappingExternalSourceElement> getExternalSourceElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif(this.getTarget() == null || !(this.eContainer() instanceof &lt;%pamtram.mapping.MappingHintGroupType%&gt;) || ((MappingHintGroupType) this.eContainer()).getTargetSection() == null) {\r\n\treturn true;\r\n}\r\n\r\nMappingHintGroupType containingHintGroup = ((MappingHintGroupType) this.eContainer());\r\n\r\nboolean result = this.getTarget().getContainingSection() == containingHintGroup.getTargetSection() || containingHintGroup.getTargetSection().getExtend().contains(this.getTarget().getContainingSection());\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"The target attribute \'\" + this.getTarget().getName() + \"\' is not part of the target section referenced by parent hint group \" + ((MappingHintGroupType) this.eContainer()).getName() + \"!\";\r\n\r\n\tdiagnostics.add(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR,\r\n\t\t\t&lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tExtendedValidator.ATTRIBUTE_MAPPING__VALIDATE_TARGET_ATTRIBUTE_MATCHES_SECTION,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.mapping.extended.ExtendedPackage%&gt;.Literals.ATTRIBUTE_MAPPING__TARGET }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateTargetAttributeMatchesSection(DiagnosticChain diagnostics, Map<?, ?> context);

} // AttributeMapping
