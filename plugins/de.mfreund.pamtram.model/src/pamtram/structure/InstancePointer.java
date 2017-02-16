/**
 */
package pamtram.structure;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import pamtram.mapping.ExpressionElement;
import pamtram.mapping.ModifiableElement;
import pamtram.structure.source.ActualSourceSectionAttribute;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Instance Pointer</b></em>'. <!-- end-user-doc
 * -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link pamtram.structure.InstancePointer#getTarget <em>Attribute Pointer</em>}</li>
 * <li>{@link pamtram.structure.InstancePointer#getSourceAttributes <em>Source Attributes</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.StructurePackage#getInstancePointer()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore
 *        constraints='noModifiedAttributeElementTypesInConditionModelConditions'"
 * @generated
 */
public interface InstancePointer extends ExpressionElement, ModifiableElement {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Pointer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(ActualSourceSectionAttribute)
	 * @see pamtram.structure.StructurePackage#getInstancePointer_Target()
	 * @model required="true"
	 * @generated
	 */
	ActualSourceSectionAttribute getTarget();

	/**
	 * Sets the value of the '{@link pamtram.structure.InstancePointer#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(ActualSourceSectionAttribute value);

	/**
	 * Returns the value of the '<em><b>Source Elements</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.structure.InstancePointerSourceInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Elements</em>' containment reference list.
	 * @see pamtram.structure.StructurePackage#getInstancePointer_SourceElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<InstancePointerSourceInterface> getSourceElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this.eContainer() instanceof <%pamtram.condition.ComplexCondition%> && ((ComplexCondition) this.eContainer()).isConditionModelCondition() ? this.getSourceElements().parallelStream().noneMatch(s -> s instanceof pamtram.mapping.ModifiedAttributeElementType) : true;\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"ModifiedAttributeElementTypes are not allowed as part of ConditionModelConditions!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.structure.util.StructureValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tStructureValidator.INSTANCE_POINTER__VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.StructurePackage%>.Literals.INSTANCE_POINTER__SOURCE_ELEMENTS }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateNoModifiedAttributeElementTypesInConditionModelConditions(DiagnosticChain diagnostics, Map<?, ?> context);

} // InstancePointer
