/**
 */
package pamtram;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Section Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.SectionModel#getMetaModelPackage <em>Meta Model Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.PamtramPackage#getSectionModel()
 * @model abstract="true"
 * @generated
 */
public interface SectionModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Meta Model Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Model Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Model Package</em>' reference.
	 * @see #setMetaModelPackage(EPackage)
	 * @see pamtram.PamtramPackage#getSectionModel_MetaModelPackage()
	 * @model required="true"
	 * @generated
	 */
	EPackage getMetaModelPackage();

	/**
	 * Sets the value of the '{@link pamtram.SectionModel#getMetaModelPackage <em>Meta Model Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Model Package</em>' reference.
	 * @see #getMetaModelPackage()
	 * @generated
	 */
	void setMetaModelPackage(EPackage value);

} // SectionModel