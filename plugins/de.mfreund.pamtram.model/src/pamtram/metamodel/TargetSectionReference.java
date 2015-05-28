/**
 */
package pamtram.metamodel;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Section Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.metamodel.TargetSectionReference#getOwningClass <em>Owning Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.metamodel.MetamodelPackage#getTargetSectionReference()
 * @model abstract="true"
 * @generated
 */
public interface TargetSectionReference extends Reference<TargetSectionClass> {
	/**
	 * Returns the value of the '<em><b>Owning Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Class</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Class</em>' reference.
	 * @see pamtram.metamodel.MetamodelPackage#getTargetSectionReference_OwningClass()
	 * @model changeable="false"
	 * @generated
	 */
	TargetSectionClass getOwningClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<TargetSectionClass> secs= new org.eclipse.emf.common.util.BasicEList<TargetSectionClass>();\nif(this instanceof TargetSectionContainmentReference){\n secs.addAll(((TargetSectionContainmentReference) this).getValue());\n\n} else if(this instanceof TargetSectionNonContainmentReference){\n secs.addAll(((TargetSectionNonContainmentReference) this).getValue());\n}\nreturn secs;'"
	 * @generated
	 */
	EList<TargetSectionClass> getValuesGeneric();

} // TargetSectionReference
