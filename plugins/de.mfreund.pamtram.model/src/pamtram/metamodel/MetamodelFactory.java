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
	 * Returns a new object of class '<em>Source Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source Section</em>'.
	 * @generated
	 */
	SourceSection createSourceSection();

	/**
	 * Returns a new object of class '<em>Target Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Target Section</em>'.
	 * @generated
	 */
	TargetSection createTargetSection();

	/**
	 * Returns a new object of class '<em>File Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File Attribute</em>'.
	 * @generated
	 */
	FileAttribute createFileAttribute();

	/**
	 * Returns a new object of class '<em>Source Section Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source Section Class</em>'.
	 * @generated
	 */
	SourceSectionClass createSourceSectionClass();

	/**
	 * Returns a new object of class '<em>Target Section Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Target Section Class</em>'.
	 * @generated
	 */
	TargetSectionClass createTargetSectionClass();

	/**
	 * Returns a new object of class '<em>Attribute Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Parameter</em>'.
	 * @generated
	 */
	AttributeParameter createAttributeParameter();

	/**
	 * Returns a new object of class '<em>Container Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Container Parameter</em>'.
	 * @generated
	 */
	ContainerParameter createContainerParameter();

	/**
	 * Returns a new object of class '<em>External Reference Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Reference Parameter</em>'.
	 * @generated
	 */
	ExternalReferenceParameter createExternalReferenceParameter();

	/**
	 * Returns a new object of class '<em>Library Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Library Entry</em>'.
	 * @generated
	 */
	LibraryEntry createLibraryEntry();

	/**
	 * Returns a new object of class '<em>Target Section Containment Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Target Section Containment Reference</em>'.
	 * @generated
	 */
	TargetSectionContainmentReference createTargetSectionContainmentReference();

	/**
	 * Returns a new object of class '<em>Target Section Non Containment Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Target Section Non Containment Reference</em>'.
	 * @generated
	 */
	TargetSectionNonContainmentReference createTargetSectionNonContainmentReference();

	/**
	 * Returns a new object of class '<em>Source Section Containment Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source Section Containment Reference</em>'.
	 * @generated
	 */
	SourceSectionContainmentReference createSourceSectionContainmentReference();

	/**
	 * Returns a new object of class '<em>Meta Model Section Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Meta Model Section Reference</em>'.
	 * @generated
	 */
	MetaModelSectionReference createMetaModelSectionReference();

	/**
	 * Returns a new object of class '<em>Source Section Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source Section Attribute</em>'.
	 * @generated
	 */
	SourceSectionAttribute createSourceSectionAttribute();

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
	 * Returns a new object of class '<em>Range Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Range Constraint</em>'.
	 * @generated
	 */
	RangeConstraint createRangeConstraint();

	/**
	 * Returns a new object of class '<em>Instance Pointer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Pointer</em>'.
	 * @generated
	 */
	InstancePointer createInstancePointer();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MetamodelPackage getMetamodelPackage();



} //MetamodelFactory
