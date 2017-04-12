/**
 */
package pamtram.mapping.extended;

import pamtram.mapping.MappingPackage;
import pamtram.structure.target.TargetSectionClass;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Matcher</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.extended.ClassMatcher#getTargetClass <em>Target Class</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getClassMatcher()
 * @model
 * @generated
 */
public interface ClassMatcher extends Matcher {
	/**
	 * Returns the value of the '<em><b>Target Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Class</em>' reference.
	 * @see #setTargetClass(TargetSectionClass)
	 * @see pamtram.mapping.MappingPackage#getClassMatcher_TargetClass()
	 * @model required="true"
	 * @generated
	 */
	TargetSectionClass getTargetClass();

	/**
	 * Sets the value of the '{@link pamtram.mapping.extended.ClassMatcher#getTargetClass <em>Target Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Class</em>' reference.
	 * @see #getTargetClass()
	 * @generated
	 */
	void setTargetClass(TargetSectionClass value);

} // ClassMatcher
