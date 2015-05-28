/**
 */
package pamtram.metamodel;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Section Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.metamodel.SourceSectionReference#getOwningClass <em>Owning Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.metamodel.MetamodelPackage#getSourceSectionReference()
 * @model abstract="true"
 * @generated
 */
public interface SourceSectionReference extends Reference<SourceSectionClass> {
	/**
	 * Returns the value of the '<em><b>Owning Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Class</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Class</em>' reference.
	 * @see pamtram.metamodel.MetamodelPackage#getSourceSectionReference_OwningClass()
	 * @model required="true" changeable="false"
	 * @generated
	 */
	SourceSectionClass getOwningClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\t\t\t\tEList<SourceSectionClass> secs= new org.eclipse.emf.common.util.BasicEList<SourceSectionClass>();\n\t\t\t\tif(this instanceof SourceSectionContainmentReference){\n\t\t\t\t secs.addAll(((SourceSectionContainmentReference) this).getValue());\n\t\t\t\t\n\t\t\t\t} else if(this instanceof MetaModelSectionReference){\n\t\t\t\t secs.addAll(((MetaModelSectionReference) this).getValue());\n\t\t\t\t}\n\t\t\t\treturn secs;'"
	 * @generated
	 */
	EList<SourceSectionClass> getValuesGeneric();

} // SourceSectionReference
