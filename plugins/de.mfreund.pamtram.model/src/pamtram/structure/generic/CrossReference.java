/**
 */
package pamtram.structure.generic;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Non
 * Containment Reference</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link pamtram.structure.generic.CrossReference#getValue
 * <em>Value</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.generic.GenericPackage#getNonContainmentReference()
 * @model abstract="true" annotation="http://www.eclipse.org/emf/2002/Ecore
 *        constraints='eReferenceIsNonContainment'"
 * @generated
 */
public interface CrossReference<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>>
		extends Reference<S, C, R, A> {

	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference list. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Value</em>' reference list.
	 * @see pamtram.structure.generic.GenericPackage#getNonContainmentReference_Value()
	 * @model
	 * @generated
	 */
	EList<C> getValue();

} // NonContainmentReference
