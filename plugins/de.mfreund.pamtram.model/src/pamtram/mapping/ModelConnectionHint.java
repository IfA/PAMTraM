/**
 */
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;
import pamtram.NamedElement;
import pamtram.metamodel.Attribute;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Connection Hint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.mapping.ModelConnectionHint#getSourceAttribute <em>Source Attribute</em>}</li>
 *   <li>{@link pamtram.mapping.ModelConnectionHint#getTargetAttributes <em>Target Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.mapping.MappingPackage#getModelConnectionHint()
 * @model
 * @generated
 */
public interface ModelConnectionHint extends NamedElement {

	/**
	 * Returns the value of the '<em><b>Source Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Attribute</em>' reference.
	 * @see #setSourceAttribute(Attribute)
	 * @see pamtram.mapping.MappingPackage#getModelConnectionHint_SourceAttribute()
	 * @model required="true"
	 * @generated
	 */
	Attribute getSourceAttribute();

	/**
	 * Sets the value of the '{@link pamtram.mapping.ModelConnectionHint#getSourceAttribute <em>Source Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Attribute</em>' reference.
	 * @see #getSourceAttribute()
	 * @generated
	 */
	void setSourceAttribute(Attribute value);

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

} // ModelConnectionHint
