/**
 */
package pamtram.structure.target.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import pamtram.structure.target.ActualTargetSectionAttribute;
import pamtram.structure.target.FileAttribute;
import pamtram.structure.target.FileType;
import pamtram.structure.target.TargetFactory;
import pamtram.structure.target.TargetPackage;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionCompositeReference;
import pamtram.structure.target.TargetSectionCrossReference;
import pamtram.structure.target.VirtualTargetSectionAttribute;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class TargetFactoryImpl extends EFactoryImpl implements TargetFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static TargetFactory init() {
		try {
			TargetFactory theTargetFactory = (TargetFactory)EPackage.Registry.INSTANCE.getEFactory(TargetPackage.eNS_URI);
			if (theTargetFactory != null) {
				return theTargetFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TargetFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public TargetFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TargetPackage.TARGET_SECTION: return createTargetSection();
			case TargetPackage.FILE_ATTRIBUTE: return createFileAttribute();
			case TargetPackage.TARGET_SECTION_CLASS: return createTargetSectionClass();
			case TargetPackage.TARGET_SECTION_COMPOSITE_REFERENCE: return createTargetSectionCompositeReference();
			case TargetPackage.TARGET_SECTION_CROSS_REFERENCE: return createTargetSectionCrossReference();
			case TargetPackage.ACTUAL_TARGET_SECTION_ATTRIBUTE: return createActualTargetSectionAttribute();
			case TargetPackage.VIRTUAL_TARGET_SECTION_ATTRIBUTE: return createVirtualTargetSectionAttribute();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case TargetPackage.FILE_TYPE:
				return createFileTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case TargetPackage.FILE_TYPE:
				return convertFileTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TargetSection createTargetSection() {
		TargetSectionImpl targetSection = new TargetSectionImpl();
		return targetSection;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FileAttribute createFileAttribute() {
		FileAttributeImpl fileAttribute = new FileAttributeImpl();
		return fileAttribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TargetSectionClass createTargetSectionClass() {
		TargetSectionClassImpl targetSectionClass = new TargetSectionClassImpl();
		return targetSectionClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TargetSectionCompositeReference createTargetSectionCompositeReference() {
		TargetSectionCompositeReferenceImpl targetSectionCompositeReference = new TargetSectionCompositeReferenceImpl();
		return targetSectionCompositeReference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TargetSectionCrossReference createTargetSectionCrossReference() {
		TargetSectionCrossReferenceImpl targetSectionCrossReference = new TargetSectionCrossReferenceImpl();
		return targetSectionCrossReference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ActualTargetSectionAttribute createActualTargetSectionAttribute() {
		ActualTargetSectionAttributeImpl actualTargetSectionAttribute = new ActualTargetSectionAttributeImpl();
		return actualTargetSectionAttribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VirtualTargetSectionAttribute createVirtualTargetSectionAttribute() {
		VirtualTargetSectionAttributeImpl virtualTargetSectionAttribute = new VirtualTargetSectionAttributeImpl();
		return virtualTargetSectionAttribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FileType createFileTypeFromString(EDataType eDataType, String initialValue) {
		FileType result = FileType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFileTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TargetPackage getTargetPackage() {
		return (TargetPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TargetPackage getPackage() {
		return TargetPackage.eINSTANCE;
	}

} // TargetFactoryImpl
