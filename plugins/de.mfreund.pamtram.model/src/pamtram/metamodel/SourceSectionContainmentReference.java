/**
 */
package pamtram.metamodel;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Section Containment Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.metamodel.SourceSectionContainmentReference#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.metamodel.MetamodelPackage#getSourceSectionContainmentReference()
 * @model
 * @generated
 */
public interface SourceSectionContainmentReference extends ContainmentReference, SourceSectionReference {

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.metamodel.SourceSectionClass}.
	 * It is bidirectional and its opposite is '{@link pamtram.metamodel.SourceSectionClass#getOwningContainmentReference <em>Owning Containment Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getSourceSectionContainmentReference_Value()
	 * @see pamtram.metamodel.SourceSectionClass#getOwningContainmentReference
	 * @model opposite="owningContainmentReference" containment="true"
	 * @generated
	 */
	EList<SourceSectionClass> getValue();
} // SourceSectionContainmentReference
