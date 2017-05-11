/**
 */
package de.mfreund.pamtram.transformation;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry;
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
 *   <li>{@link de.mfreund.pamtram.transformation.Transformation#getStartDate <em>Start Date</em>}</li>
 *   <li>{@link de.mfreund.pamtram.transformation.Transformation#getEndDate <em>End Date</em>}</li>
 *   <li>{@link de.mfreund.pamtram.transformation.Transformation#getName <em>Name</em>}</li>
 *   <li>{@link de.mfreund.pamtram.transformation.Transformation#getId <em>Id</em>}</li>
 *   <li>{@link de.mfreund.pamtram.transformation.Transformation#getPamtramInstances <em>Pamtram Instances</em>}</li>
 *   <li>{@link de.mfreund.pamtram.transformation.Transformation#getLibraryEntries <em>Library Entries</em>}</li>
 *   <li>{@link de.mfreund.pamtram.transformation.Transformation#getSourceModels <em>Source Models</em>}</li>
 *   <li>{@link de.mfreund.pamtram.transformation.Transformation#getTargetModels <em>Target Models</em>}</li>
 *   <li>{@link de.mfreund.pamtram.transformation.Transformation#getTransformationMappings <em>Transformation Mappings</em>}</li>
 * </ul>
 *
 * @see de.mfreund.pamtram.transformation.TransformationPackage#getTransformation()
 * @model
 * @generated
 */
public interface Transformation extends EObject {
	/**
	 * Returns the value of the '<em><b>Start Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Date</em>' attribute.
	 * @see #setStartDate(Date)
	 * @see de.mfreund.pamtram.transformation.TransformationPackage#getTransformation_StartDate()
	 * @model required="true"
	 * @generated
	 */
	Date getStartDate();

	/**
	 * Sets the value of the '{@link de.mfreund.pamtram.transformation.Transformation#getStartDate <em>Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Date</em>' attribute.
	 * @see #getStartDate()
	 * @generated
	 */
	void setStartDate(Date value);

	/**
	 * Returns the value of the '<em><b>End Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Date</em>' attribute.
	 * @see #setEndDate(Date)
	 * @see de.mfreund.pamtram.transformation.TransformationPackage#getTransformation_EndDate()
	 * @model required="true"
	 * @generated
	 */
	Date getEndDate();

	/**
	 * Sets the value of the '{@link de.mfreund.pamtram.transformation.Transformation#getEndDate <em>End Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Date</em>' attribute.
	 * @see #getEndDate()
	 * @generated
	 */
	void setEndDate(Date value);

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
	 * Returns the value of the '<em><b>Pamtram Instances</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.PAMTraM}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pamtram Instances</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pamtram Instances</em>' containment reference list.
	 * @see de.mfreund.pamtram.transformation.TransformationPackage#getTransformation_PamtramInstances()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	EList<PAMTraM> getPamtramInstances();

	/**
	 * Returns the value of the '<em><b>Library Entries</b></em>' containment reference list.
	 * The list contents are of type {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Library Entries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Library Entries</em>' containment reference list.
	 * @see de.mfreund.pamtram.transformation.TransformationPackage#getTransformation_LibraryEntries()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<LibraryEntry> getLibraryEntries();

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
	 * @model containment="true" resolveProxies="true" required="true"
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
	 * @model containment="true" resolveProxies="true" required="true"
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
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<TransformationMapping> getTransformationMappings();

} // Transformation
