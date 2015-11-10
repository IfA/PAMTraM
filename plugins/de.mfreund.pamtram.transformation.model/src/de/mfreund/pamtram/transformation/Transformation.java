/**
 */
package de.mfreund.pamtram.transformation;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import pamtram.PAMTraM;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.mfreund.pamtram.transformation.Transformation#getExecutionDate <em>Execution Date</em>}</li>
 *   <li>{@link de.mfreund.pamtram.transformation.Transformation#getName <em>Name</em>}</li>
 *   <li>{@link de.mfreund.pamtram.transformation.Transformation#getId <em>Id</em>}</li>
 *   <li>{@link de.mfreund.pamtram.transformation.Transformation#getPamtramInstance <em>Pamtram Instance</em>}</li>
 *   <li>{@link de.mfreund.pamtram.transformation.Transformation#getSourceModels <em>Source Models</em>}</li>
 *   <li>{@link de.mfreund.pamtram.transformation.Transformation#getTargetModels <em>Target Models</em>}</li>
 *   <li>{@link de.mfreund.pamtram.transformation.Transformation#getTransformationMappings <em>Transformation Mappings</em>}</li>
 *   <li>{@link de.mfreund.pamtram.transformation.Transformation#getTransformationHintGroups <em>Transformation Hint Groups</em>}</li>
 * </ul>
 *
 * @see de.mfreund.pamtram.transformation.TransformationPackage#getTransformation()
 * @model
 * @generated
 */
public interface Transformation extends EObject {
	/**
	 * Returns the value of the '<em><b>Execution Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Execution Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution Date</em>' attribute.
	 * @see #setExecutionDate(Date)
	 * @see de.mfreund.pamtram.transformation.TransformationPackage#getTransformation_ExecutionDate()
	 * @model required="true"
	 * @generated
	 */
	Date getExecutionDate();

	/**
	 * Sets the value of the '{@link de.mfreund.pamtram.transformation.Transformation#getExecutionDate <em>Execution Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execution Date</em>' attribute.
	 * @see #getExecutionDate()
	 * @generated
	 */
	void setExecutionDate(Date value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.mfreund.pamtram.transformation.TransformationPackage#getTransformation_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.mfreund.pamtram.transformation.Transformation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see de.mfreund.pamtram.transformation.TransformationPackage#getTransformation_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link de.mfreund.pamtram.transformation.Transformation#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Pamtram Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pamtram Instance</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pamtram Instance</em>' containment reference.
	 * @see #setPamtramInstance(PAMTraM)
	 * @see de.mfreund.pamtram.transformation.TransformationPackage#getTransformation_PamtramInstance()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PAMTraM getPamtramInstance();

	/**
	 * Sets the value of the '{@link de.mfreund.pamtram.transformation.Transformation#getPamtramInstance <em>Pamtram Instance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pamtram Instance</em>' containment reference.
	 * @see #getPamtramInstance()
	 * @generated
	 */
	void setPamtramInstance(PAMTraM value);

	/**
	 * Returns the value of the '<em><b>Source Models</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Models</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Models</em>' containment reference list.
	 * @see de.mfreund.pamtram.transformation.TransformationPackage#getTransformation_SourceModels()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<EObject> getSourceModels();

	/**
	 * Returns the value of the '<em><b>Target Models</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Models</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Models</em>' containment reference list.
	 * @see de.mfreund.pamtram.transformation.TransformationPackage#getTransformation_TargetModels()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<EObject> getTargetModels();

	/**
	 * Returns the value of the '<em><b>Transformation Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link de.mfreund.pamtram.transformation.TransformationMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation Mappings</em>' containment reference list.
	 * @see de.mfreund.pamtram.transformation.TransformationPackage#getTransformation_TransformationMappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<TransformationMapping> getTransformationMappings();

	/**
	 * Returns the value of the '<em><b>Transformation Hint Groups</b></em>' containment reference list.
	 * The list contents are of type {@link de.mfreund.pamtram.transformation.TransformationMappingHintGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation Hint Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation Hint Groups</em>' containment reference list.
	 * @see de.mfreund.pamtram.transformation.TransformationPackage#getTransformation_TransformationHintGroups()
	 * @model containment="true"
	 * @generated
	 */
	EList<TransformationMappingHintGroup> getTransformationHintGroups();

} // Transformation
