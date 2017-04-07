/**
 */
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;

import pamtram.structure.InstanceSelector;


/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>ContainerSelector</b></em>'. <!-- end-user-doc
 * -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link pamtram.mapping.ContainerSelector#getTargetAttributes <em>Target Attributes</em>}</li>
 * <li>{@link pamtram.mapping.ContainerSelector#getSourceElements <em>Source Elements</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getContainerSelector()
 * @model
 * @generated
 */
public interface ContainerSelector extends MappingHint, InstanceSelector {

	/**
	 * Returns the value of the '<em><b>Target Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.ContainerSelectorTargetAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Attributes</em>' containment reference list.
	 * @see pamtram.mapping.MappingPackage#getContainerSelector_TargetAttributes()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ContainerSelectorTargetAttribute> getTargetAttributes();

} // ModelConnectionHint
