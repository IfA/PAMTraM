/**
 */
package pamtram.mapping;

import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.TargetSectionClass;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cardinality Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.mapping.CardinalityMapping#getSource <em>Source</em>}</li>
 *   <li>{@link pamtram.mapping.CardinalityMapping#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.mapping.MappingPackage#getCardinalityMapping()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='sourceClassMatchesSection\r\nsourceClassIsVariableCardinality\r\ntargetClassMatchesSection\r\ntargetClassIsVariableCardinality'"
 * @generated
 */
public interface CardinalityMapping extends MappingHint {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(SourceSectionClass)
	 * @see pamtram.mapping.MappingPackage#getCardinalityMapping_Source()
	 * @model required="true"
	 * @generated
	 */
	SourceSectionClass getSource();

	/**
	 * Sets the value of the '{@link pamtram.mapping.CardinalityMapping#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(SourceSectionClass value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(TargetSectionClass)
	 * @see pamtram.mapping.MappingPackage#getCardinalityMapping_Target()
	 * @model required="true"
	 * @generated
	 */
	TargetSectionClass getTarget();

	/**
	 * Sets the value of the '{@link pamtram.mapping.CardinalityMapping#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(TargetSectionClass value);

} // CardinalityMapping
