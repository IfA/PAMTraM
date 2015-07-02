/**
 */
package pamtram.metamodel;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Non Containment Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.NonContainmentReference#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getNonContainmentReference()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='eReferenceIsNonContainment'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot eReferenceIsNonContainment='self.eReference.containment=false'"
 * @generated
 */
public interface NonContainmentReference<C extends pamtram.metamodel.Class<C, R, A>, R extends Reference<C, R, A>, A extends Attribute<C, R, A>> extends Reference<C, R, A> {

	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getNonContainmentReference_Value()
	 * @model
	 * @generated
	 */
	EList<C> getValue();

} // NonContainmentReference
