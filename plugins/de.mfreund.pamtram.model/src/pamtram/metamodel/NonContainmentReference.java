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
 * <ul>
 *   <li>{@link pamtram.metamodel.NonContainmentReference#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.metamodel.MetamodelPackage#getNonContainmentReference()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='eReferenceIsNonContainment'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL eReferenceIsNonContainment='self.eReference.containment=false'"
 * @generated
 */
public interface NonContainmentReference extends Reference {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference list.
	 * The list contents are of type {@link pamtram.metamodel.Class}.
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
	EList<pamtram.metamodel.Class> getValue();

} // NonContainmentReference
