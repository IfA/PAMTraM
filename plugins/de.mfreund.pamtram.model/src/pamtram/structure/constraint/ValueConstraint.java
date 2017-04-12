/**
 */
package pamtram.structure.constraint;

import pamtram.NamedElement;


/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Value Constraint</b></em>'. <!-- end-user-doc
 * -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link pamtram.structure.constraint.ValueConstraint#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.StructurePackage#getAttributeValueConstraint()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ValueConstraint extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"REQUIRED"</code>.
	 * The literals are from the enumeration {@link pamtram.structure.constraint.ValueConstraintType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see pamtram.structure.constraint.ValueConstraintType
	 * @see #setType(ValueConstraintType)
	 * @see pamtram.structure.constraint.ConstraintPackage#getValueConstraint_Type()
	 * @model default="REQUIRED" required="true"
	 * @generated
	 */
	ValueConstraintType getType();

	/**
	 * Sets the value of the '{@link pamtram.structure.constraint.ValueConstraint#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see pamtram.structure.constraint.ValueConstraintType
	 * @see #getType()
	 * @generated
	 */
	void setType(ValueConstraintType value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this instanceof <%pamtram.structure.constraint.ChoiceConstraint%>) {\r\n\treturn ((ChoiceConstraint) this).getChoices().stream().allMatch(<%pamtram.structure.constraint.ValueConstraint%>::isLocalConstraint);\r\n}\r\n\r\nif (<%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%>.hasAncestorOfKind(this, <%pamtram.structure.source.SourcePackage%>.Literals.ACTUAL_SOURCE_SECTION_ATTRIBUTE)) {\r\n\treturn true;\r\n}\r\n\r\nif (!(this instanceof <%pamtram.structure.constraint.SingleReferenceValueConstraint%>)\r\n\t\t|| !AgteleEcoreUtil.hasAncestorOfKind(this, <%pamtram.condition.ConditionPackage%>.Literals.ATTRIBUTE_CONDITION)) {\r\n\tthrow new UnsupportedOperationException();\r\n}\r\n\r\n<%org.eclipse.emf.ecore.EObject%> container = this;\r\n\r\nwhile (!(container instanceof <%pamtram.mapping.Mapping%>)) {\r\n\tif (container == null) {\r\n\t\treturn false;\r\n\t}\r\n\tcontainer = container.eContainer();\r\n}\r\n\r\n// The SourceSection of the Mapping that contains the constraint\r\n//\r\nSourceSection localSection = ((Mapping) container).getSourceSection();\r\n\r\nif (((SingleReferenceValueConstraint) this).getSourceElements().parallelStream()\r\n\t\t.allMatch(s -> s instanceof <%pamtram.FixedValue%> || s instanceof <%pamtram.mapping.extended.GlobalAttributeImporter%>\r\n\t\t\t\t|| s instanceof <%pamtram.structure.constraint.ValueConstraintSourceElement%> && ((ValueConstraintSourceElement) s).getSource()\r\n\t\t\t\t\t\t.getContainingSection().equals(localSection)\r\n\t\t\t\t|| s instanceof <%pamtram.structure.constraint.ValueConstraintExternalSourceElement%>\r\n\t\t\t\t\t\t&& ((ValueConstraintExternalSourceElement) s).getSource().getContainingSection()\r\n\t\t\t\t\t\t\t\t.isContainerFor(localSection))) {\r\n\treturn true;\r\n}\r\n\r\n// A constraint is also \'local\' if an InstancePointer with local or external SourceAttributes exist\r\n//\r\nreturn ((SingleReferenceValueConstraint) this).getInstanceSelectors()\r\n\t\t.parallelStream()\r\n\t\t.flatMap(instanceSelector -> instanceSelector.getSourceElements().parallelStream()\r\n\t\t\t\t.filter(s -> s instanceof <%pamtram.structure.InstanceSelectorSourceElement%>\r\n\t\t\t\t\t\t|| s instanceof <%pamtram.structure.InstanceSelectorExternalSourceElement%>))\r\n\t\t.findAny().isPresent();'"
	 * @generated
	 */
	boolean isLocalConstraint();

} // AttributeValueConstraint
