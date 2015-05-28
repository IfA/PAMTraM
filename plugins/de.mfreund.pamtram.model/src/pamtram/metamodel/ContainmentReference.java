/**
 */
package pamtram.metamodel;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Containment Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.metamodel.ContainmentReference#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.metamodel.MetamodelPackage#getContainmentReference()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='eReferenceIsContainment'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot eReferenceIsContainment='self.eReference.containment=true'"
 * @generated
 */
public interface ContainmentReference<V extends pamtram.metamodel.Class<?, ?, ?>> extends Reference<V> {

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getContainmentReference_Value()
	 * @model containment="true"
	 * @generated
	 */
	EList<V> getValue();

} // ContainmentReference
