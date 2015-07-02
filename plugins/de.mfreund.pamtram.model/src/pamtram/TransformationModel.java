/**
 */
package pamtram;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import pamtram.transformation.Transformation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.TransformationModel#getTransformation <em>Transformation</em>}</li>
 * </ul>
 *
 * @see pamtram.PamtramPackage#getTransformationModel()
 * @model
 * @generated
 */
public interface TransformationModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Transformation</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.transformation.Transformation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation</em>' containment reference list.
	 * @see pamtram.PamtramPackage#getTransformationModel_Transformation()
	 * @model containment="true"
	 * @generated
	 */
	EList<Transformation> getTransformation();

} // TransformationModel
