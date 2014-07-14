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
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='eReferenceIsContainment'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL eReferenceIsContainment='self.eReference.containment=true'"
 * @generated
 */
public interface ContainmentReference extends Reference {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.metamodel.Class}.
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
	EList<pamtram.metamodel.Class> getValue();

} // ContainmentReference
