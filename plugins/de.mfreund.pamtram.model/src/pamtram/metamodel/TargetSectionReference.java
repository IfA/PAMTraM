/**
 */
package pamtram.metamodel;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Section Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see pamtram.metamodel.MetamodelPackage#getTargetSectionReference()
 * @model abstract="true"
 * @generated
 */
public interface TargetSectionReference extends Reference<TargetSectionClass, TargetSectionReference, TargetSectionAttribute> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<TargetSectionClass> secs= new org.eclipse.emf.common.util.BasicEList<TargetSectionClass>();\nif(this instanceof TargetSectionContainmentReference){\n secs.addAll(((TargetSectionContainmentReference) this).getValue());\n\n} else if(this instanceof TargetSectionNonContainmentReference){\n secs.addAll(((TargetSectionNonContainmentReference) this).getValue());\n}\nreturn secs;'"
	 * @generated
	 */
	EList<TargetSectionClass> getValuesGeneric();

} // TargetSectionReference
