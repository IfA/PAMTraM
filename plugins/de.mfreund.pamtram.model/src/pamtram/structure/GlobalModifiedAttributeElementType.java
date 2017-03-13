/**
 */
package pamtram.structure;

import org.eclipse.emf.common.util.EList;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Global Modified Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.GlobalModifiedAttributeElementType#getInstanceSelectors <em>Instance Selectors</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.StructurePackage#getGlobalModifiedAttributeElementType()
 * @model abstract="true"
 * @generated
 */
public interface GlobalModifiedAttributeElementType<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends ModifiedAttributeElementType<S, C, R, A> {

	/**
	 * Returns the value of the '<em><b>Instance Selectors</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.structure.SourceInstanceSelector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Selectors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Selectors</em>' containment reference list.
	 * @see pamtram.structure.StructurePackage#getGlobalModifiedAttributeElementType_InstanceSelectors()
	 * @model containment="true"
	 * @generated
	 */
	EList<SourceInstanceSelector> getInstanceSelectors();
} // GlobalModifiedAttributeElementType
