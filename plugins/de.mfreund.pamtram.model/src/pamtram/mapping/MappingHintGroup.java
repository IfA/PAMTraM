/**
 */
package pamtram.mapping;

import pamtram.mapping.extended.ContainerSelector;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Hint
 * Group</b></em>'. <!-- end-user-doc -->
 *
 *
 * @see pamtram.mapping.MappingPackage#getMappingHintGroup()
 * @model
 * @generated
 */
public interface MappingHintGroup extends MappingHintGroupType, InstantiableMappingHintGroup {

	/**
	 * This guarantees compatibility to legacy implementations.
	 *
	 * @return
	 * @deprecated {@link ContainerSelector} is now a full-fledged
	 *             {@link MappingHint} and should be accessed via
	 *             {@link MappingHintGroup#getMappingHints()}
	 */
	@Deprecated
	ContainerSelector getContainerSelector();

} // MappingHintGroup
