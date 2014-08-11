/**
 */
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;

import pamtram.NamedElement;
import pamtram.metamodel.SourceSectionAttribute;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Connection Hint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.mapping.ModelConnectionHint#getTargetAttributes <em>Target Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.mapping.MappingPackage#getModelConnectionHint()
 * @model abstract="true"
 * @generated
 */
public interface ModelConnectionHint extends NamedElement {

	/**
	 * Returns the value of the '<em><b>Target Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.ConnectionHintTargetAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Attributes</em>' containment reference list.
	 * @see pamtram.mapping.MappingPackage#getModelConnectionHint_TargetAttributes()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ConnectionHintTargetAttribute> getTargetAttributes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	EList<SourceSectionAttribute> getSourceAttributes();

} // ModelConnectionHint
