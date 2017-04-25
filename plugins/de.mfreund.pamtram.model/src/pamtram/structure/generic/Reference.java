/**
 */
package pamtram.structure.generic;

import java.util.List;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Reference</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.generic.Reference#getOwningClass <em>Owning Class</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.generic.GenericPackage#getReference()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='eReferenceMatchesParentEClass'"
 * @generated
 */
public interface Reference<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>>
		extends MetaModelElement<S, C, R, A> {

	/**
	 * Returns the value of the '<em><b>Owning Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link pamtram.structure.generic.Class#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Class</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Class</em>' container reference.
	 * @see pamtram.structure.generic.GenericPackage#getReference_OwningClass()
	 * @see pamtram.structure.generic.Class#getReferences
	 * @model opposite="references" transient="false" changeable="false"
	 * @generated
	 */
	C getOwningClass();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<C> getValuesGeneric();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model valuesMany="true"
	 * @generated
	 */
	void addValuesGeneric(EList<C> values);

	void addValuesGeneric(List<C> values);

} // Reference
