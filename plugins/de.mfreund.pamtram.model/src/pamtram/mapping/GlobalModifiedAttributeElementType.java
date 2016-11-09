/**
 */
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.InstancePointer;
import pamtram.metamodel.Reference;
import pamtram.metamodel.Section;

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
public interface GlobalModifiedAttributeElementType<S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends ModifiedAttributeElementType<S, C, R, A> {

	/**
	 * Returns the value of the '<em><b>Instance Selector</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.metamodel.InstancePointer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Selector</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Selector</em>' containment reference list.
	 * @see pamtram.mapping.MappingPackage#getGlobalModifiedAttributeElementType_InstanceSelector()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!GlobalModifiedAttributeElementType{S,C,R,A}!instanceSelector'"
	 * @generated
	 */
	EList<InstancePointer> getInstanceSelector();
} // GlobalModifiedAttributeElementType
