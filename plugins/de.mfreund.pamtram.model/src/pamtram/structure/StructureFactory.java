/**
 */
package pamtram.structure;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see pamtram.structure.StructurePackage
 * @generated
 */
public interface StructureFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StructureFactory eINSTANCE = pamtram.structure.impl.StructureFactoryImpl.init();

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
	 * Returns a new object of class '<em>Resource Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Parameter</em>'.
	 * @generated
	 */
	ResourceParameter createResourceParameter();

	/**
	 * Returns a new object of class '<em>Library Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Library Entry</em>'.
	 * @generated
	 */
	LibraryEntry createLibraryEntry();

	/**
	 * Returns a new object of class '<em>Target Section Composite Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Target Section Composite Reference</em>'.
	 * @generated
	 */
	TargetSectionCompositeReference createTargetSectionCompositeReference();

	/**
	 * Returns a new object of class '<em>Target Section Cross Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Target Section Cross Reference</em>'.
	 * @generated
	 */
	TargetSectionCrossReference createTargetSectionCrossReference();

	/**
	 * Returns a new object of class '<em>Source Section Composite Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source Section Composite Reference</em>'.
	 * @generated
	 */
	SourceSectionCompositeReference createSourceSectionCompositeReference();

	/**
	 * Returns a new object of class '<em>Source Section Cross Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source Section Cross Reference</em>'.
	 * @generated
	 */
	SourceSectionCrossReference createSourceSectionCrossReference();

	/**
	 * Returns a new object of class '<em>Actual Source Section Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Actual Source Section Attribute</em>'.
	 * @generated
	 */
	ActualSourceSectionAttribute createActualSourceSectionAttribute();

	/**
	 * Returns a new object of class '<em>Actual Target Section Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Actual Target Section Attribute</em>'.
	 * @generated
	 */
	ActualTargetSectionAttribute createActualTargetSectionAttribute();

	/**
	 * Returns a new object of class '<em>Virtual Target Section Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Target Section Attribute</em>'.
	 * @generated
	 */
	VirtualTargetSectionAttribute createVirtualTargetSectionAttribute();

	/**
	 * Returns a new object of class '<em>Instance Pointer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Pointer</em>'.
	 * @generated
	 */
	InstancePointer createInstancePointer();

	/**
	 * Returns a new object of class '<em>Instance Pointer Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Pointer Source Element</em>'.
	 * @generated
	 */
	InstancePointerSourceElement createInstancePointerSourceElement();

	/**
	 * Returns a new object of class '<em>Instance Pointer External Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Pointer External Source Element</em>'.
	 * @generated
	 */
	InstancePointerExternalSourceElement createInstancePointerExternalSourceElement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StructurePackage getStructurePackage();



} //StructureFactory
