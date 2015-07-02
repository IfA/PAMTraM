/**
 */
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;

import pamtram.NamedElement;
import pamtram.metamodel.SourceSectionAttribute;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Global Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.GlobalAttribute#getSource <em>Source</em>}</li>
 *   <li>{@link pamtram.mapping.GlobalAttribute#getModifier <em>Modifier</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getGlobalAttribute()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='sourceAttributeHasUpperBoundOne'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot sourceAttributeHasUpperBoundOne='self.source.attribute.upperBound = 1'"
 * @generated
 */
public interface GlobalAttribute extends NamedElement {

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(SourceSectionAttribute)
	 * @see pamtram.mapping.MappingPackage#getGlobalAttribute_Source()
	 * @model required="true"
	 * @generated
	 */
	SourceSectionAttribute getSource();

	/**
	 * Sets the value of the '{@link pamtram.mapping.GlobalAttribute#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(SourceSectionAttribute value);

	/**
	 * Returns the value of the '<em><b>Modifier</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.AttributeValueModifierSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modifier</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modifier</em>' reference list.
	 * @see pamtram.mapping.MappingPackage#getGlobalAttribute_Modifier()
	 * @model
	 * @generated
	 */
	EList<AttributeValueModifierSet> getModifier();
} // GlobalVariable
