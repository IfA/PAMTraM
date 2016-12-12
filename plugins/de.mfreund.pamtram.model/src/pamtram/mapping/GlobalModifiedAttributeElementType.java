/**
 */
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;

import pamtram.structure.Attribute;
import pamtram.structure.InstancePointer;
import pamtram.structure.Reference;
import pamtram.structure.Section;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Global Modified Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.GlobalModifiedAttributeElementType#getInstanceSelector <em>Instance Selector</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getGlobalModifiedAttributeElementType()
 * @model abstract="true"
 * @generated
 */
public interface GlobalModifiedAttributeElementType<S extends Section<S, C, R, A>, C extends pamtram.structure.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends ModifiedAttributeElementType<S, C, R, A> {

	/**
	 * Returns the value of the '<em><b>Instance Selector</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.structure.InstancePointer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Selector</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Selector</em>' containment reference list.
	 * @see pamtram.mapping.MappingPackage#getGlobalModifiedAttributeElementType_InstanceSelector()
	 * @model containment="true"
	 * @generated
	 */
	EList<InstancePointer> getInstanceSelector();
} // GlobalModifiedAttributeElementType
