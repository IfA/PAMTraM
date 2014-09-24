/**
 */
package pamtram.metamodel;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Section Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.metamodel.SourceSectionClass#getReferences <em>References</em>}</li>
 *   <li>{@link pamtram.metamodel.SourceSectionClass#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link pamtram.metamodel.SourceSectionClass#getContainer <em>Container</em>}</li>
 *   <li>{@link pamtram.metamodel.SourceSectionClass#getOwningContainmentReference <em>Owning Containment Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.metamodel.MetamodelPackage#getSourceSectionClass()
 * @model
 * @generated
 */
public interface SourceSectionClass extends pamtram.metamodel.Class {

	/**
	 * Returns the value of the '<em><b>References</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.metamodel.SourceSectionReference}.
	 * It is bidirectional and its opposite is '{@link pamtram.metamodel.SourceSectionReference#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' containment reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getSourceSectionClass_References()
	 * @see pamtram.metamodel.SourceSectionReference#getOwningClass
	 * @model opposite="owningClass" containment="true"
	 * @generated
	 */
	EList<SourceSectionReference> getReferences();

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.metamodel.SourceSectionAttribute}.
	 * It is bidirectional and its opposite is '{@link pamtram.metamodel.SourceSectionAttribute#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getSourceSectionClass_Attributes()
	 * @see pamtram.metamodel.SourceSectionAttribute#getOwningClass
	 * @model opposite="owningClass" containment="true"
	 * @generated
	 */
	EList<SourceSectionAttribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' reference.
	 * @see #setContainer(SourceSectionClass)
	 * @see pamtram.metamodel.MetamodelPackage#getSourceSectionClass_Container()
	 * @model
	 * @generated
	 */
	SourceSectionClass getContainer();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.SourceSectionClass#getContainer <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(SourceSectionClass value);

	/**
	 * Returns the value of the '<em><b>Owning Containment Reference</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link pamtram.metamodel.SourceSectionContainmentReference#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Containment Reference</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Containment Reference</em>' container reference.
	 * @see #setOwningContainmentReference(SourceSectionContainmentReference)
	 * @see pamtram.metamodel.MetamodelPackage#getSourceSectionClass_OwningContainmentReference()
	 * @see pamtram.metamodel.SourceSectionContainmentReference#getValue
	 * @model opposite="value" transient="false"
	 * @generated
	 */
	SourceSectionContainmentReference getOwningContainmentReference();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.SourceSectionClass#getOwningContainmentReference <em>Owning Containment Reference</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Containment Reference</em>' container reference.
	 * @see #getOwningContainmentReference()
	 * @generated
	 */
	void setOwningContainmentReference(SourceSectionContainmentReference value);
	
	
} // SourceSectionClass
