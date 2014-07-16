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
public interface SourceSectionReference extends Reference {
	/**
	 * Returns the value of the '<em><b>Owning Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link pamtram.metamodel.SourceSectionClass#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Class</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Class</em>' container reference.
	 * @see pamtram.metamodel.MetamodelPackage#getSourceSectionReference_OwningClass()
	 * @see pamtram.metamodel.SourceSectionClass#getReferences
	 * @model opposite="references" required="true" transient="false" changeable="false"
	 * @generated
	 */
	SourceSectionClass getOwningClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<SourceSectionClass> secs= new org.eclipse.emf.common.util.BasicEList<SourceSectionClass>();\nif(this instanceof SourceSectionContainmentReference){\n secs.addAll(((SourceSectionContainmentReference) this).getValue());\n\n} else if(this instanceof SourceSectionNonContainmentReference){\n secs.addAll(((SourceSectionNonContainmentReference) this).getValue());\n}\nreturn secs;'"
	 * @generated
	 */
	EList<SourceSectionClass> getValuesGeneric();

} // SourceSectionReference
