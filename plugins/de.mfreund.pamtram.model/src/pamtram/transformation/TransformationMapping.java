/**
 */
package pamtram.transformation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import pamtram.mapping.MappingType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.transformation.TransformationMapping#getSourceMElement <em>Source MElement</em>}</li>
 *   <li>{@link pamtram.transformation.TransformationMapping#getTargetMElement <em>Target MElement</em>}</li>
 * </ul>
 *
 * @see pamtram.transformation.TransformationPackage#getTransformationMapping()
 * @model
 * @generated
 */
public interface TransformationMapping extends MappingType {
	/**
	 * Returns the value of the '<em><b>Source MElement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source MElement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source MElement</em>' reference.
	 * @see #setSourceMElement(EObject)
	 * @see pamtram.transformation.TransformationPackage#getTransformationMapping_SourceMElement()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/transformation!TransformationMapping!sourceMElement'"
	 * @generated
	 */
	EObject getSourceMElement();

	/**
	 * Sets the value of the '{@link pamtram.transformation.TransformationMapping#getSourceMElement <em>Source MElement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source MElement</em>' reference.
	 * @see #getSourceMElement()
	 * @generated
	 */
	void setSourceMElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Target MElement</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target MElement</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target MElement</em>' reference list.
	 * @see pamtram.transformation.TransformationPackage#getTransformationMapping_TargetMElement()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/transformation!TransformationMapping!targetMElement'"
	 * @generated
	 */
	EList<EObject> getTargetMElement();

} // TransformationMapping
