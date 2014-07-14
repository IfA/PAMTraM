/**
 */
package pamtram.metamodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see pamtram.metamodel.MetamodelPackage
 * @generated
 */
public interface MetamodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MetamodelFactory eINSTANCE = pamtram.metamodel.impl.MetamodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class</em>'.
	 * @generated
	 */
	Class createClass();

	/**
	 * Returns a new object of class '<em>Containment Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Containment Reference</em>'.
	 * @generated
	 */
	ContainmentReference createContainmentReference();

	/**
	 * Returns a new object of class '<em>Non Containment Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Non Containment Reference</em>'.
	 * @generated
	 */
	NonContainmentReference createNonContainmentReference();

	/**
	 * Returns a new object of class '<em>Actual Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Actual Attribute</em>'.
	 * @generated
	 */
	ActualAttribute createActualAttribute();

	/**
	 * Returns a new object of class '<em>Virtual Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Attribute</em>'.
	 * @generated
	 */
	VirtualAttribute createVirtualAttribute();

	/**
	 * Returns a new object of class '<em>Attribute Value Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Value Specification</em>'.
	 * @generated
	 */
	AttributeValueSpecification createAttributeValueSpecification();

	/**
	 * Returns a new object of class '<em>Equality Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equality Matcher</em>'.
	 * @generated
	 */
	EqualityMatcher createEqualityMatcher();

	/**
	 * Returns a new object of class '<em>Substring Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Substring Matcher</em>'.
	 * @generated
	 */
	SubstringMatcher createSubstringMatcher();

	/**
	 * Returns a new object of class '<em>Beginning Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Beginning Matcher</em>'.
	 * @generated
	 */
	BeginningMatcher createBeginningMatcher();

	/**
	 * Returns a new object of class '<em>Ending Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ending Matcher</em>'.
	 * @generated
	 */
	EndingMatcher createEndingMatcher();

	/**
	 * Returns a new object of class '<em>Reg Ex Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reg Ex Matcher</em>'.
	 * @generated
	 */
	RegExMatcher createRegExMatcher();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MetamodelPackage getMetamodelPackage();



} //MetamodelFactory
