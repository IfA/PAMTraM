/**
 */
package pamtram;

import org.eclipse.emf.common.util.EList;

import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.Mapping;
import pamtram.mapping.modifier.ValueModifierSet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.MappingModel#getMappings <em>Mappings</em>}</li>
 *   <li>{@link pamtram.MappingModel#getModifierSets <em>Modifier Sets</em>}</li>
 *   <li>{@link pamtram.MappingModel#getGlobalValues <em>Global Values</em>}</li>
 *   <li>{@link pamtram.MappingModel#getActiveMappings <em>Active Mappings</em>}</li>
 *   <li>{@link pamtram.MappingModel#getGlobalAttributes <em>Global Attributes</em>}</li>
 * </ul>
 *
 * @see pamtram.PamtramPackage#getMappingModel()
 * @model
 * @generated
 */
public interface MappingModel extends NamedElement, DeactivatableElement, ConditionalElement {
	/**
	 * Returns the value of the '<em><b>Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.Mapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mappings</em>' containment reference list.
	 * @see pamtram.PamtramPackage#getMappingModel_Mappings()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Mapping> getMappings();

	/**
	 * Returns the value of the '<em><b>Modifier Sets</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.modifier.ValueModifierSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modifier Sets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modifier Sets</em>' containment reference list.
	 * @see pamtram.PamtramPackage#getMappingModel_ModifierSets()
	 * @model containment="true"
	 * @generated
	 */
	EList<ValueModifierSet> getModifierSets();

	/**
	 * Returns the value of the '<em><b>Global Values</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.FixedValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Values</em>' containment reference list.
	 * @see pamtram.PamtramPackage#getMappingModel_GlobalValues()
	 * @model containment="true"
	 * @generated
	 */
	EList<FixedValue> getGlobalValues();

	/**
	 * Returns the value of the '<em><b>Active Mappings</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.Mapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active Mappings</em>' reference list.
	 * @see pamtram.PamtramPackage#getMappingModel_ActiveMappings()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%java.util.List%><Mapping> mappings = this.getMappings().stream().filter(m -> !m.isDeactivated() && !m.isAbstract()).collect(<%java.util.stream.Collectors%>.toList());\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.PamtramPackage%>.Literals.MAPPING_MODEL__ACTIVE_MAPPINGS,\r\n\t\tmappings.size(), mappings.toArray());'"
	 * @generated
	 */
	EList<Mapping> getActiveMappings();

	/**
	 * Returns the value of the '<em><b>Global Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.GlobalAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Attributes</em>' containment reference list.
	 * @see pamtram.PamtramPackage#getMappingModel_GlobalAttributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<GlobalAttribute> getGlobalAttributes();

} // MappingModel
