/**
 */
package pamtram.mapping;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hint Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.MappingHintGroup#getContainerSelector <em>Container Selector</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getMappingHintGroup()
 * @model
 * @generated
 */
public interface MappingHintGroup extends MappingHintGroupType, InstantiableMappingHintGroup {
	/**
	 * Returns the value of the '<em><b>Container Selector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Connection Matcher</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container Selector</em>' containment reference.
	 * @see #setContainerSelector(ContainerSelector)
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroup_ContainerSelector()
	 * @model containment="true"
	 * @generated
	 */
	ContainerSelector getContainerSelector();

	/**
	 * Sets the value of the '{@link pamtram.mapping.MappingHintGroup#getContainerSelector <em>Container Selector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container Selector</em>' containment reference.
	 * @see #getContainerSelector()
	 * @generated
	 */
	void setContainerSelector(ContainerSelector value);

} // MappingHintGroup
