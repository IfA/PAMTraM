/**
 */
package pamtram.mapping;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import pamtram.metamodel.TargetSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.AttributeMapping#getTarget <em>Target</em>}</li>
 *   <li>{@link pamtram.mapping.AttributeMapping#getSourceElements <em>Source Elements</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getAttributeMapping()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='targetAttributeMatchesSection'"
 * @generated
 */
public interface AttributeMapping extends MappingHint, ExpressionHint, ModifiableHint, ExpandableHint {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(TargetSectionAttribute)
	 * @see pamtram.mapping.MappingPackage#getAttributeMapping_Target()
	 * @model required="true"
	 * @generated
	 */
	TargetSectionAttribute getTarget();

	/**
	 * Sets the value of the '{@link pamtram.mapping.AttributeMapping#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(TargetSectionAttribute value);

	/**
	 * Returns the value of the '<em><b>Source Elements</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.AttributeMappingSourceInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Attribute Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Elements</em>' containment reference list.
	 * @see pamtram.mapping.MappingPackage#getAttributeMapping_SourceElements()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<AttributeMappingSourceInterface> getSourceElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\t\tEList<AttributeMappingSourceElement> elements= new org.eclipse.emf.common.util.BasicEList<AttributeMappingSourceElement>();\r\n\t\t\r\n\t\tfor(AttributeMappingSourceInterface i : this.getSourceElements()){\r\n\t\t\tif(i instanceof AttributeMappingSourceElement){\r\n\t\t\t\telements.add((AttributeMappingSourceElement) i);\r\n\t\t\t}\r\n\t\t}\r\n\t\t\r\n\t\treturn elements;'"
	 * @generated
	 */
	EList<AttributeMappingSourceElement> getLocalSourceElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<AttributeMappingExternalSourceElement> elements= new org.eclipse.emf.common.util.BasicEList<AttributeMappingExternalSourceElement>();\r\n\r\nfor(AttributeMappingSourceInterface i : this.getSourceElements()){\r\n\tif(i instanceof AttributeMappingExternalSourceElement){\r\n\t\telements.add((AttributeMappingExternalSourceElement) i);\r\n\t}\r\n}\r\n\r\nreturn elements;'"
	 * @generated
	 */
	EList<AttributeMappingExternalSourceElement> getExternalSourceElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif(this.getTarget() == null || !(this.eContainer() instanceof <%pamtram.mapping.MappingHintGroupType%>) || ((MappingHintGroupType) this.eContainer()).getTargetSection() == null) {\r\n\treturn true;\r\n}\r\n\r\nMappingHintGroupType containingHintGroup = ((MappingHintGroupType) this.eContainer());\r\n\r\nboolean result = this.getTarget().getContainingSection() == containingHintGroup.getTargetSection() || containingHintGroup.getTargetSection().getExtend().contains(this.getTarget().getContainingSection());\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The target attribute \'\" + this.getTarget().getName() + \"\' is not part of the target section referenced by parent hint group \" + ((MappingHintGroupType) this.eContainer()).getName() + \"!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.util.MappingValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMappingValidator.ATTRIBUTE_MAPPING__VALIDATE_TARGET_ATTRIBUTE_MATCHES_SECTION,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.MappingPackage%>.Literals.ATTRIBUTE_MAPPING__TARGET }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateTargetAttributeMatchesSection(DiagnosticChain diagnostics, Map<?, ?> context);

} // AttributeMapping
