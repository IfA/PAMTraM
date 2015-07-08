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
 *   <li>{@link pamtram.mapping.MappingHintGroup#getModelConnectionMatcher <em>Model Connection Matcher</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getMappingHintGroup()
 * @model
 * @generated
 */
public interface MappingHintGroup extends MappingHintGroupType, InstantiableMappingHintGroup {
	/**
	 * Returns the value of the '<em><b>Model Connection Matcher</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Connection Matcher</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Connection Matcher</em>' containment reference.
	 * @see #setModelConnectionMatcher(ModelConnectionHint)
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroup_ModelConnectionMatcher()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!MappingHintGroup!modelConnectionMatcher'"
	 * @generated
	 */
	ModelConnectionHint getModelConnectionMatcher();

	/**
	 * Sets the value of the '{@link pamtram.mapping.MappingHintGroup#getModelConnectionMatcher <em>Model Connection Matcher</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Connection Matcher</em>' containment reference.
	 * @see #getModelConnectionMatcher()
	 * @generated
	 */
	void setModelConnectionMatcher(ModelConnectionHint value);

} // MappingHintGroup
