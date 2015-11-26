/**
 */
package de.mfreund.pamtram.transformation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import pamtram.mapping.InstantiableMappingHintGroup;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Hint Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.mfreund.pamtram.transformation.TransformationMappingHintGroup#getTargetElements <em>Target Elements</em>}</li>
 *   <li>{@link de.mfreund.pamtram.transformation.TransformationMappingHintGroup#getAssociatedMappingHintGroup <em>Associated Mapping Hint Group</em>}</li>
 * </ul>
 *
 * @see de.mfreund.pamtram.transformation.TransformationPackage#getTransformationMappingHintGroup()
 * @model
 * @generated
 */
public interface TransformationMappingHintGroup extends EObject {
	/**
	 * Returns the value of the '<em><b>Target Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Elements</em>' reference list.
	 * @see de.mfreund.pamtram.transformation.TransformationPackage#getTransformationMappingHintGroup_TargetElements()
	 * @model required="true"
	 * @generated
	 */
	EList<EObject> getTargetElements();

	/**
	 * Returns the value of the '<em><b>Associated Mapping Hint Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associated Mapping Hint Group</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associated Mapping Hint Group</em>' reference.
	 * @see #setAssociatedMappingHintGroup(InstantiableMappingHintGroup)
	 * @see de.mfreund.pamtram.transformation.TransformationPackage#getTransformationMappingHintGroup_AssociatedMappingHintGroup()
	 * @model required="true"
	 * @generated
	 */
	InstantiableMappingHintGroup getAssociatedMappingHintGroup();

	/**
	 * Sets the value of the '{@link de.mfreund.pamtram.transformation.TransformationMappingHintGroup#getAssociatedMappingHintGroup <em>Associated Mapping Hint Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Associated Mapping Hint Group</em>' reference.
	 * @see #getAssociatedMappingHintGroup()
	 * @generated
	 */
	void setAssociatedMappingHintGroup(InstantiableMappingHintGroup value);

} // TransformationMappingHintGroup
