/**
 */
package pamtram;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PAM Tra M</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.PAMTraM#getContextMetaModelPackage <em>Context Meta Model Package</em>}</li>
 *   <li>{@link pamtram.PAMTraM#getSourceSectionModel <em>Source Section Model</em>}</li>
 *   <li>{@link pamtram.PAMTraM#getTargetSectionModel <em>Target Section Model</em>}</li>
 *   <li>{@link pamtram.PAMTraM#getMappingModel <em>Mapping Model</em>}</li>
 *   <li>{@link pamtram.PAMTraM#getTransformationModel <em>Transformation Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.PamtramPackage#getPAMTraM()
 * @model
 * @generated
 */
public interface PAMTraM extends EObject {
	/**
	 * Returns the value of the '<em><b>Context Meta Model Package</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EPackage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Meta Model Package</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Meta Model Package</em>' reference list.
	 * @see pamtram.PamtramPackage#getPAMTraM_ContextMetaModelPackage()
	 * @model
	 * @generated
	 */
	EList<EPackage> getContextMetaModelPackage();

	/**
	 * Returns the value of the '<em><b>Source Section Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Section Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Section Model</em>' containment reference.
	 * @see #setSourceSectionModel(SourceSectionModel)
	 * @see pamtram.PamtramPackage#getPAMTraM_SourceSectionModel()
	 * @model containment="true" required="true"
	 * @generated
	 */
	SourceSectionModel getSourceSectionModel();

	/**
	 * Sets the value of the '{@link pamtram.PAMTraM#getSourceSectionModel <em>Source Section Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Section Model</em>' containment reference.
	 * @see #getSourceSectionModel()
	 * @generated
	 */
	void setSourceSectionModel(SourceSectionModel value);

	/**
	 * Returns the value of the '<em><b>Target Section Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Section Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Section Model</em>' containment reference.
	 * @see #setTargetSectionModel(TargetSectionModel)
	 * @see pamtram.PamtramPackage#getPAMTraM_TargetSectionModel()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TargetSectionModel getTargetSectionModel();

	/**
	 * Sets the value of the '{@link pamtram.PAMTraM#getTargetSectionModel <em>Target Section Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Section Model</em>' containment reference.
	 * @see #getTargetSectionModel()
	 * @generated
	 */
	void setTargetSectionModel(TargetSectionModel value);

	/**
	 * Returns the value of the '<em><b>Mapping Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Model</em>' containment reference.
	 * @see #setMappingModel(MappingModel)
	 * @see pamtram.PamtramPackage#getPAMTraM_MappingModel()
	 * @model containment="true" required="true"
	 * @generated
	 */
	MappingModel getMappingModel();

	/**
	 * Sets the value of the '{@link pamtram.PAMTraM#getMappingModel <em>Mapping Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Model</em>' containment reference.
	 * @see #getMappingModel()
	 * @generated
	 */
	void setMappingModel(MappingModel value);

	/**
	 * Returns the value of the '<em><b>Transformation Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation Model</em>' containment reference.
	 * @see #setTransformationModel(TransformationModel)
	 * @see pamtram.PamtramPackage#getPAMTraM_TransformationModel()
	 * @model containment="true"
	 * @generated
	 */
	TransformationModel getTransformationModel();

	/**
	 * Sets the value of the '{@link pamtram.PAMTraM#getTransformationModel <em>Transformation Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transformation Model</em>' containment reference.
	 * @see #getTransformationModel()
	 * @generated
	 */
	void setTransformationModel(TransformationModel value);

} // PAMTraM
