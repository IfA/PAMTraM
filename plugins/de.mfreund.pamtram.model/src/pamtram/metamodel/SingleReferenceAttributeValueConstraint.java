/**
 */
package pamtram.metamodel;

import org.eclipse.emf.common.util.EList;
import pamtram.mapping.ExpressionHint;
import pamtram.mapping.ModifiableHint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Reference Attribute Value Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.SingleReferenceAttributeValueConstraint#getConstraintReferenceValueAdditionalSpecification <em>Constraint Reference Value Additional Specification</em>}</li>
 *   <li>{@link pamtram.metamodel.SingleReferenceAttributeValueConstraint#getSourceElements <em>Source Elements</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getSingleReferenceAttributeValueConstraint()
 * @model abstract="true"
 * @generated
 */
public interface SingleReferenceAttributeValueConstraint extends AttributeValueConstraint, ExpressionHint, ModifiableHint {
	/**
	 * Returns the value of the '<em><b>Constraint Reference Value Additional Specification</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.metamodel.InstancePointer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Reference Value Additional Specification</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Reference Value Additional Specification</em>' containment reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getSingleReferenceAttributeValueConstraint_ConstraintReferenceValueAdditionalSpecification()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!SingleReferenceAttributeValueConstraint!constraintReferenceValueAdditionalSpecification'"
	 * @generated
	 */
	EList<InstancePointer> getConstraintReferenceValueAdditionalSpecification();

	/**
	 * Returns the value of the '<em><b>Source Elements</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.metamodel.AttributeValueConstraintSourceInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Elements</em>' containment reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getSingleReferenceAttributeValueConstraint_SourceElements()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!SingleReferenceAttributeValueConstraint!sourceElements'"
	 * @generated
	 */
	EList<AttributeValueConstraintSourceInterface> getSourceElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" attrValueRequired="true" refValueRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!SingleReferenceAttributeValueConstraint!checkConstraint(String,String)'"
	 * @generated
	 */
	boolean checkConstraint(String attrValue, String refValue);

} // SingleReferenceAttributeValueConstraint
