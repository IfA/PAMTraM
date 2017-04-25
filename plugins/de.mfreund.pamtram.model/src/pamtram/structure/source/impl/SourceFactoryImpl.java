/**
 */
package pamtram.structure.source.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import pamtram.structure.source.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SourceFactoryImpl extends EFactoryImpl implements SourceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SourceFactory init() {
		try {
			SourceFactory theSourceFactory = (SourceFactory)EPackage.Registry.INSTANCE.getEFactory(SourcePackage.eNS_URI);
			if (theSourceFactory != null) {
				return theSourceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SourceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SourcePackage.SOURCE_SECTION: return createSourceSection();
			case SourcePackage.SOURCE_SECTION_CLASS: return createSourceSectionClass();
			case SourcePackage.SOURCE_SECTION_COMPOSITE_REFERENCE: return createSourceSectionCompositeReference();
			case SourcePackage.SOURCE_SECTION_CROSS_REFERENCE: return createSourceSectionCrossReference();
			case SourcePackage.VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE: return createVirtualSourceSectionCrossReference();
			case SourcePackage.ACTUAL_SOURCE_SECTION_ATTRIBUTE: return createActualSourceSectionAttribute();
			case SourcePackage.VIRTUAL_SOURCE_SECTION_ATTRIBUTE: return createVirtualSourceSectionAttribute();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSection createSourceSection() {
		SourceSectionImpl sourceSection = new SourceSectionImpl();
		return sourceSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionClass createSourceSectionClass() {
		SourceSectionClassImpl sourceSectionClass = new SourceSectionClassImpl();
		return sourceSectionClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionCompositeReference createSourceSectionCompositeReference() {
		SourceSectionCompositeReferenceImpl sourceSectionCompositeReference = new SourceSectionCompositeReferenceImpl();
		return sourceSectionCompositeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionCrossReference createSourceSectionCrossReference() {
		SourceSectionCrossReferenceImpl sourceSectionCrossReference = new SourceSectionCrossReferenceImpl();
		return sourceSectionCrossReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualSourceSectionCrossReference createVirtualSourceSectionCrossReference() {
		VirtualSourceSectionCrossReferenceImpl virtualSourceSectionCrossReference = new VirtualSourceSectionCrossReferenceImpl();
		return virtualSourceSectionCrossReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActualSourceSectionAttribute createActualSourceSectionAttribute() {
		ActualSourceSectionAttributeImpl actualSourceSectionAttribute = new ActualSourceSectionAttributeImpl();
		return actualSourceSectionAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualSourceSectionAttribute createVirtualSourceSectionAttribute() {
		VirtualSourceSectionAttributeImpl virtualSourceSectionAttribute = new VirtualSourceSectionAttributeImpl();
		return virtualSourceSectionAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourcePackage getSourcePackage() {
		return (SourcePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SourcePackage getPackage() {
		return SourcePackage.eINSTANCE;
	}

} //SourceFactoryImpl
