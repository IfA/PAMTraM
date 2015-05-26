/**
 */
package pamtram.metamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Meta Model Section Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.metamodel.MetaModelSectionReference#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.metamodel.MetamodelPackage#getMetaModelSectionReference()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='valuesMatchReferenceType'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot valuesMatchReferenceType='self.value->forAll(c : SourceSectionClass | self.eReference.eReferenceType.isSuperTypeOf(c.eClass))'"
 * @generated
 */
public interface MetaModelSectionReference extends SourceSectionReference {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference list.
	 * The list contents are of type {@link pamtram.metamodel.SourceSectionClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getMetaModelSectionReference_Value()
	 * @model
	 * @generated
	 */
	EList<SourceSectionClass> getValue();

} // MetaModelSectionReference
