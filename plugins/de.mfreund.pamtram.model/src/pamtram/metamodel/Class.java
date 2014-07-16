/**
 */
package pamtram.metamodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.metamodel.Class#getEClass <em>EClass</em>}</li>
 *   <li>{@link pamtram.metamodel.Class#getCardinality <em>Cardinality</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.metamodel.MetamodelPackage#getClass_()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='eClassMatchesParentEReference\r\nvariableCardinalityIsValid'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL eClassMatchesParentEReference='if metamodel::Reference.oclAsType(ecore::EClass).isSuperTypeOf(self.oclAsType(ecore::EObject).eContainer().eClass()) then self.oclAsType(ecore::EObject).eContainer().oclAsType(metamodel::Reference).eReference.oclAsType(ecore::\r\nEReference).eReferenceType.isSuperTypeOf(self.eClass.oclAsType(ecore::EClass)) else true endif' cardinalityIsValid='if metamodel::Reference.oclAsType(ecore::EClass).isSuperTypeOf(self.oclAsType(ecore::EObject).eContainer().eClass()) then not ((self.cardinality <> 0) and (self.oclAsType(ecore::EObject).eContainer().oclAsType(metamodel::Reference).eReference.oclAsType(ecore::EReference).upperBound <= 1)) else true endif'"
 * @generated
 */
public interface Class extends MetaModelElement {
	/**
	 * Returns the value of the '<em><b>EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EClass</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EClass</em>' reference.
	 * @see #setEClass(EClass)
	 * @see pamtram.metamodel.MetamodelPackage#getClass_EClass()
	 * @model required="true"
	 * @generated
	 */
	EClass getEClass();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.Class#getEClass <em>EClass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EClass</em>' reference.
	 * @see #getEClass()
	 * @generated
	 */
	void setEClass(EClass value);

	/**
	 * Returns the value of the '<em><b>Cardinality</b></em>' attribute.
	 * The default value is <code>"ONE"</code>.
	 * The literals are from the enumeration {@link pamtram.metamodel.CardinalityType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cardinality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cardinality</em>' attribute.
	 * @see pamtram.metamodel.CardinalityType
	 * @see #setCardinality(CardinalityType)
	 * @see pamtram.metamodel.MetamodelPackage#getClass_Cardinality()
	 * @model default="ONE" required="true"
	 * @generated
	 */
	CardinalityType getCardinality();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.Class#getCardinality <em>Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cardinality</em>' attribute.
	 * @see pamtram.metamodel.CardinalityType
	 * @see #getCardinality()
	 * @generated
	 */
	void setCardinality(CardinalityType value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<Reference> refs= new org.eclipse.emf.common.util.BasicEList<Reference>();\nif(this instanceof SourceSectionClass){\n refs.addAll(((SourceSectionClass) this).getReferences());\n\n} else if(this instanceof TargetSectionClass){\n refs.addAll(((TargetSectionClass) this).getReferences());\n}\nreturn refs;'"
	 * @generated
	 */
	EList<Reference> getReferencesGeneric();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<Attribute> attrs= new org.eclipse.emf.common.util.BasicEList<Attribute>();\nif(this instanceof SourceSectionClass){\n attrs.addAll(((SourceSectionClass) this).getAttributes());\n\n} else if(this instanceof TargetSectionClass){\n attrs.addAll(((TargetSectionClass) this).getAttributes());\n}\nreturn attrs;'"
	 * @generated
	 */
	EList<Attribute> getAttributesGeneric();

} // Class
