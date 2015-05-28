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
 *   <li>{@link pamtram.metamodel.Class#getReferences <em>References</em>}</li>
 *   <li>{@link pamtram.metamodel.Class#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.metamodel.MetamodelPackage#getClass_()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='eClassMatchesParentEReference variableCardinalityIsValid'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot eClassMatchesParentEReference='if self<>self.getContainingSection() then self.oclContainer().oclAsType(pamtram::metamodel::Reference).eReference.oclAsType(ecore::EReference).eReferenceType.isSuperTypeOf(self.eClass.oclAsType(ecore::EClass)) else true endif' cardinalityIsValid='if self<>self.getContainingSection() then not ((self.cardinality <> pamtram::metamodel::CardinalityType::ONE) and (self.oclContainer().oclAsType(pamtram::metamodel::Reference).eReference.oclAsType(ecore::EReference).upperBound <= 1)) else true endif'"
 * @generated
 */
public interface Class<C extends Class<C, R>, R extends Reference> extends MetaModelElement<C> {
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
	 * Returns the value of the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' containment reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getClass_References()
	 * @model containment="true"
	 * @generated
	 */
	EList<R> getReferences();

	/**
	 * Returns the value of the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' reference.
	 * @see #setContainer(Class)
	 * @see pamtram.metamodel.MetamodelPackage#getClass_Container()
	 * @model
	 * @generated
	 */
	C getContainer();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.Class#getContainer <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(C value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return getReferences(); //TODO delete this'"
	 * @generated
	 */
	EList<R> getReferencesGeneric();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<Attribute> attrs= new org.eclipse.emf.common.util.BasicEList<Attribute>();\nif(this instanceof SourceSectionClass){\n attrs.addAll(((SourceSectionClass) this).getAttributes());\n\n} else if(this instanceof TargetSectionClass){\n attrs.addAll(((TargetSectionClass) this).getAttributes());\n}\nreturn attrs;'"
	 * @generated
	 */
	EList<Attribute> getAttributesGeneric();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return getContainer(); //TODO delete this'"
	 * @generated
	 */
	C getContainerGeneric();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" containedClassRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='pamtram.metamodel.Class container = containedClass.getContainerGeneric();\r\n\t\t\r\n// this means that we have reached the top level container for the \'containedClass\'\r\nif(container == null) {\r\n\treturn false;\r\n// this is the container\r\n} else if(this.equals(container)) {\r\n\treturn true;\r\n// this was not the container, so iterate up in the containment hierarchy\r\n} else {\r\n\treturn isContainerForGeneric(containedClass.getContainerGeneric());\r\n}'"
	 * @generated
	 */
	boolean isContainerForGeneric(C containedClass);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.equals(this.getContainingSection());'"
	 * @generated
	 */
	boolean isSection();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" containerClassRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<C> containedClasses = new BasicEList<>();\r\n\r\n// collect all classes that are referenced by containment references\r\nfor (Reference ref : containerClass.getReferencesGeneric()) {\r\n\tif(!(ref.getEReference().isContainment())) {\r\n\t\tcontinue;\r\n\t}\r\n\tif(ref instanceof SourceSectionReference) {\r\n\t\tcontainedClasses.addAll((Collection<? extends C>) ((SourceSectionReference) ref).getValuesGeneric());\r\n\t} else if(ref instanceof TargetSectionReference) {\r\n\t\tcontainedClasses.addAll((Collection<? extends C>) ((TargetSectionReference) ref).getValuesGeneric());\r\n\t}\r\n}\r\n\r\n// recursively iterate over all contained classes\r\nboolean found = false;\r\nfor (C containedClass : containedClasses) {\r\n\tif(containedClass.equals(this) || isContainedInGeneric(containedClass)) {\r\n\t\tfound = true;\r\n\t\tbreak;\r\n\t}\r\n}\r\nreturn found;'"
	 * @generated
	 */
	boolean isContainedInGeneric(C containerClass);

} // Class
