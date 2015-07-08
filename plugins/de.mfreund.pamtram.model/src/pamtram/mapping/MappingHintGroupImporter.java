/**
 */
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;

import pamtram.NamedElement;
import pamtram.metamodel.TargetSectionClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hint Group Importer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.MappingHintGroupImporter#getHintGroup <em>Hint Group</em>}</li>
 *   <li>{@link pamtram.mapping.MappingHintGroupImporter#getContainer <em>Container</em>}</li>
 *   <li>{@link pamtram.mapping.MappingHintGroupImporter#getMappingHints <em>Mapping Hints</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getMappingHintGroupImporter()
 * @model
 * @generated
 */
public interface MappingHintGroupImporter extends NamedElement, InstantiableMappingHintGroup {
	/**
	 * Returns the value of the '<em><b>Hint Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hint Group</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hint Group</em>' reference.
	 * @see #setHintGroup(ExportedMappingHintGroup)
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroupImporter_HintGroup()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!MappingHintGroupImporter!hintGroup'"
	 * @generated
	 */
	ExportedMappingHintGroup getHintGroup();

	/**
	 * Sets the value of the '{@link pamtram.mapping.MappingHintGroupImporter#getHintGroup <em>Hint Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hint Group</em>' reference.
	 * @see #getHintGroup()
	 * @generated
	 */
	void setHintGroup(ExportedMappingHintGroup value);

	/**
	 * Returns the value of the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' reference.
	 * @see #isSetContainer()
	 * @see #unsetContainer()
	 * @see #setContainer(TargetSectionClass)
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroupImporter_Container()
	 * @model unsettable="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!MappingHintGroupImporter!container'"
	 * @generated
	 */
	TargetSectionClass getContainer();

	/**
	 * Sets the value of the '{@link pamtram.mapping.MappingHintGroupImporter#getContainer <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' reference.
	 * @see #isSetContainer()
	 * @see #unsetContainer()
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(TargetSectionClass value);

	/**
	 * Unsets the value of the '{@link pamtram.mapping.MappingHintGroupImporter#getContainer <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetContainer()
	 * @see #getContainer()
	 * @see #setContainer(TargetSectionClass)
	 * @generated
	 */
	void unsetContainer();

	/**
	 * Returns whether the value of the '{@link pamtram.mapping.MappingHintGroupImporter#getContainer <em>Container</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Container</em>' reference is set.
	 * @see #unsetContainer()
	 * @see #getContainer()
	 * @see #setContainer(TargetSectionClass)
	 * @generated
	 */
	boolean isSetContainer();

	/**
	 * Returns the value of the '<em><b>Mapping Hints</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.MappingHintType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Hints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Hints</em>' containment reference list.
	 * @see #isSetMappingHints()
	 * @see #unsetMappingHints()
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroupImporter_MappingHints()
	 * @model containment="true" unsettable="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!MappingHintGroupImporter!mappingHints'"
	 * @generated
	 */
	EList<MappingHintType> getMappingHints();

	/**
	 * Unsets the value of the '{@link pamtram.mapping.MappingHintGroupImporter#getMappingHints <em>Mapping Hints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMappingHints()
	 * @see #getMappingHints()
	 * @generated
	 */
	void unsetMappingHints();

	/**
	 * Returns whether the value of the '{@link pamtram.mapping.MappingHintGroupImporter#getMappingHints <em>Mapping Hints</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Mapping Hints</em>' containment reference list is set.
	 * @see #unsetMappingHints()
	 * @see #getMappingHints()
	 * @generated
	 */
	boolean isSetMappingHints();

} // MappingHintGroupImporter
