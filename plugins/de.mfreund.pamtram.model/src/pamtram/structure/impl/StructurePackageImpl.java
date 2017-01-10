/**
 */
package pamtram.structure.impl;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import pamtram.PamtramPackage;
import pamtram.condition.ConditionPackage;
import pamtram.condition.impl.ConditionPackageImpl;
import pamtram.impl.PamtramPackageImpl;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.impl.MappingPackageImpl;
import pamtram.structure.ActualSourceSectionAttribute;
import pamtram.structure.ActualTargetSectionAttribute;
import pamtram.structure.AttributeParameter;
import pamtram.structure.BeginningMatcher;
import pamtram.structure.CaseSensitiveConstraint;
import pamtram.structure.ContainerParameter;
import pamtram.structure.EndingMatcher;
import pamtram.structure.EqualityMatcher;
import pamtram.structure.ExternalReferenceParameter;
import pamtram.structure.FileAttribute;
import pamtram.structure.FileTypeEnum;
import pamtram.structure.InstancePointer;
import pamtram.structure.InstancePointerExternalSourceElement;
import pamtram.structure.InstancePointerSourceElement;
import pamtram.structure.InstancePointerSourceInterface;
import pamtram.structure.LibraryEntry;
import pamtram.structure.LibraryParameter;
import pamtram.structure.StructureFactory;
import pamtram.structure.StructurePackage;
import pamtram.structure.MultipleReferencesValueConstraint;
import pamtram.structure.RangeBound;
import pamtram.structure.RangeConstraint;
import pamtram.structure.RegExMatcher;
import pamtram.structure.ResourceParameter;
import pamtram.structure.SingleReferenceValueConstraint;
import pamtram.structure.SourceSection;
import pamtram.structure.SourceSectionAttribute;
import pamtram.structure.SourceSectionClass;
import pamtram.structure.SourceSectionContainmentReference;
import pamtram.structure.SourceSectionCrossReference;
import pamtram.structure.SourceSectionReference;
import pamtram.structure.SubstringMatcher;
import pamtram.structure.TargetSection;
import pamtram.structure.TargetSectionAttribute;
import pamtram.structure.TargetSectionClass;
import pamtram.structure.TargetSectionContainmentReference;
import pamtram.structure.TargetSectionCrossReference;
import pamtram.structure.TargetSectionReference;
import pamtram.structure.ValueConstraint;
import pamtram.structure.ValueConstraintExternalSourceElement;
import pamtram.structure.ValueConstraintSourceElement;
import pamtram.structure.ValueConstraintSourceInterface;
import pamtram.structure.ValueConstraintType;
import pamtram.structure.VirtualTargetSectionAttribute;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.impl.GenericPackageImpl;
import pamtram.structure.util.StructureValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StructurePackageImpl extends EPackageImpl implements StructurePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceSectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetSectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceSectionClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetSectionClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libraryParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containerParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalReferenceParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libraryEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceSectionReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetSectionReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetSectionCompositeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetSectionCrossReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceSectionCompositeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceSectionCrossReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceSectionAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actualSourceSectionAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetSectionAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actualTargetSectionAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualTargetSectionAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equalityMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass substringMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass beginningMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endingMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass regExMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass caseSensitiveConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rangeConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multipleReferencesValueConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instancePointerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instancePointerSourceInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instancePointerSourceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instancePointerExternalSourceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rangeBoundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singleReferenceValueConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueConstraintSourceInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueConstraintSourceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueConstraintExternalSourceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum fileTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum valueConstraintTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see pamtram.structure.StructurePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private StructurePackageImpl() {
		super(eNS_URI, StructureFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link StructurePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static StructurePackage init() {
		if (isInited) return (StructurePackage)EPackage.Registry.INSTANCE.getEPackage(StructurePackage.eNS_URI);

		// Obtain or create and register package
		StructurePackageImpl theStructurePackage = (StructurePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof StructurePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new StructurePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		GenLibraryPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		PamtramPackageImpl thePamtramPackage = (PamtramPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI) instanceof PamtramPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI) : PamtramPackage.eINSTANCE);
		GenericPackageImpl theGenericPackage = (GenericPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GenericPackage.eNS_URI) instanceof GenericPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GenericPackage.eNS_URI) : GenericPackage.eINSTANCE);
		ConditionPackageImpl theConditionPackage = (ConditionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) instanceof ConditionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) : ConditionPackage.eINSTANCE);
		MappingPackageImpl theMappingPackage = (MappingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) instanceof MappingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) : MappingPackage.eINSTANCE);

		// Create package meta-data objects
		theStructurePackage.createPackageContents();
		thePamtramPackage.createPackageContents();
		theGenericPackage.createPackageContents();
		theConditionPackage.createPackageContents();
		theMappingPackage.createPackageContents();

		// Initialize created meta-data
		theStructurePackage.initializePackageContents();
		thePamtramPackage.initializePackageContents();
		theGenericPackage.initializePackageContents();
		theConditionPackage.initializePackageContents();
		theMappingPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theStructurePackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return StructureValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theStructurePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(StructurePackage.eNS_URI, theStructurePackage);
		return theStructurePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceSection() {
		return sourceSectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSourceSection_ReferencingMappings() {
		return (EReference)sourceSectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSourceSection__ValidateIsReferencedByMapping__DiagnosticChain_Map() {
		return sourceSectionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetSection() {
		return targetSectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTargetSection_ReferencingMappingHintGroups() {
		return (EReference)targetSectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTargetSection_File() {
		return (EReference)targetSectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTargetSection__ValidateIsReferencedByMappingHintGroup__DiagnosticChain_Map() {
		return targetSectionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFileAttribute() {
		return fileAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileAttribute_FileType() {
		return (EAttribute)fileAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceSectionClass() {
		return sourceSectionClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetSectionClass() {
		return targetSectionClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibraryParameter() {
		return libraryParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibraryParameter_Source() {
		return (EReference)libraryParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibraryParameter_OriginalParameter() {
		return (EReference)libraryParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeParameter() {
		return attributeParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeParameter_Attribute() {
		return (EReference)attributeParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainerParameter() {
		return containerParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainerParameter_Class() {
		return (EReference)containerParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalReferenceParameter() {
		return externalReferenceParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExternalReferenceParameter_Reference() {
		return (EReference)externalReferenceParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceParameter() {
		return resourceParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceParameter_Attribute() {
		return (EReference)resourceParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceParameter_OriginalParameter() {
		return (EReference)resourceParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibraryEntry() {
		return libraryEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibraryEntry_Parameters() {
		return (EReference)libraryEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLibraryEntry_LibraryFile() {
		return (EAttribute)libraryEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibraryEntry_Path() {
		return (EReference)libraryEntryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibraryEntry_Id() {
		return (EReference)libraryEntryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibraryEntry_ResourceParameters() {
		return (EReference)libraryEntryEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibraryEntry_OriginalLibraryEntry() {
		return (EReference)libraryEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceSectionReference() {
		return sourceSectionReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetSectionReference() {
		return targetSectionReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetSectionCompositeReference() {
		return targetSectionCompositeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetSectionCrossReference() {
		return targetSectionCrossReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTargetSectionCrossReference__ValidateEReferenceIsNonContainment__DiagnosticChain_Map() {
		return targetSectionCrossReferenceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceSectionCompositeReference() {
		return sourceSectionCompositeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceSectionCrossReference() {
		return sourceSectionCrossReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceSectionAttribute() {
		return sourceSectionAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSourceSectionAttribute_ValueConstraint() {
		return (EReference)sourceSectionAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActualSourceSectionAttribute() {
		return actualSourceSectionAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetSectionAttribute() {
		return targetSectionAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTargetSectionAttribute_Unique() {
		return (EAttribute)targetSectionAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTargetSectionAttribute_Value() {
		return (EAttribute)targetSectionAttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActualTargetSectionAttribute() {
		return actualTargetSectionAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualTargetSectionAttribute() {
		return virtualTargetSectionAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEqualityMatcher() {
		return equalityMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueConstraint() {
		return valueConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValueConstraint_Type() {
		return (EAttribute)valueConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubstringMatcher() {
		return substringMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBeginningMatcher() {
		return beginningMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndingMatcher() {
		return endingMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegExMatcher() {
		return regExMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCaseSensitiveConstraint() {
		return caseSensitiveConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCaseSensitiveConstraint_CaseSensitive() {
		return (EAttribute)caseSensitiveConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRangeConstraint() {
		return rangeConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRangeConstraint_UpperBound() {
		return (EReference)rangeConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRangeConstraint_LowerBound() {
		return (EReference)rangeConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultipleReferencesValueConstraint() {
		return multipleReferencesValueConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMultipleReferencesValueConstraint__CheckConstraint__String_EList() {
		return multipleReferencesValueConstraintEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstancePointer() {
		return instancePointerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstancePointer_Target() {
		return (EReference)instancePointerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstancePointer_SourceElements() {
		return (EReference)instancePointerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstancePointer__ValidateNoModifiedAttributeElementTypesInConditionModelConditions__DiagnosticChain_Map() {
		return instancePointerEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstancePointerSourceInterface() {
		return instancePointerSourceInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstancePointerSourceElement() {
		return instancePointerSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstancePointerExternalSourceElement() {
		return instancePointerExternalSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRangeBound() {
		return rangeBoundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRangeBound_BoundType() {
		return (EAttribute)rangeBoundEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRangeBound_BoundReferenceValueAdditionalSpecification() {
		return (EReference)rangeBoundEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRangeBound_SourceElements() {
		return (EReference)rangeBoundEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRangeBound__ValidateOnlyFixedValuesInSourceSections__DiagnosticChain_Map() {
		return rangeBoundEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRangeBound__ValidateOnlyFixedValuesOrGlobalAttributesInConditionModel__DiagnosticChain_Map() {
		return rangeBoundEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRangeBound__IsLocalConstraint() {
		return rangeBoundEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSingleReferenceValueConstraint() {
		return singleReferenceValueConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingleReferenceValueConstraint_ConstraintReferenceValueAdditionalSpecification() {
		return (EReference)singleReferenceValueConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingleReferenceValueConstraint_SourceElements() {
		return (EReference)singleReferenceValueConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSingleReferenceValueConstraint__CheckConstraint__String_String() {
		return singleReferenceValueConstraintEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSingleReferenceValueConstraint__ValidateOnlyFixedValuesInSourceSections__DiagnosticChain_Map() {
		return singleReferenceValueConstraintEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSingleReferenceValueConstraint__ValidateOnlyFixedValuesOrGlobalAttributesInConditionModel__DiagnosticChain_Map() {
		return singleReferenceValueConstraintEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSingleReferenceValueConstraint__ValidateNoResultModifierInSourceSections__DiagnosticChain_Map() {
		return singleReferenceValueConstraintEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSingleReferenceValueConstraint__IsLocalConstraint() {
		return singleReferenceValueConstraintEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueConstraintSourceInterface() {
		return valueConstraintSourceInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueConstraintSourceElement() {
		return valueConstraintSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueConstraintExternalSourceElement() {
		return valueConstraintExternalSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFileTypeEnum() {
		return fileTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getValueConstraintType() {
		return valueConstraintTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructureFactory getStructureFactory() {
		return (StructureFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		sourceSectionEClass = createEClass(SOURCE_SECTION);
		createEReference(sourceSectionEClass, SOURCE_SECTION__REFERENCING_MAPPINGS);
		createEOperation(sourceSectionEClass, SOURCE_SECTION___VALIDATE_IS_REFERENCED_BY_MAPPING__DIAGNOSTICCHAIN_MAP);

		targetSectionEClass = createEClass(TARGET_SECTION);
		createEReference(targetSectionEClass, TARGET_SECTION__REFERENCING_MAPPING_HINT_GROUPS);
		createEReference(targetSectionEClass, TARGET_SECTION__FILE);
		createEOperation(targetSectionEClass, TARGET_SECTION___VALIDATE_IS_REFERENCED_BY_MAPPING_HINT_GROUP__DIAGNOSTICCHAIN_MAP);

		fileAttributeEClass = createEClass(FILE_ATTRIBUTE);
		createEAttribute(fileAttributeEClass, FILE_ATTRIBUTE__FILE_TYPE);

		sourceSectionClassEClass = createEClass(SOURCE_SECTION_CLASS);

		targetSectionClassEClass = createEClass(TARGET_SECTION_CLASS);

		libraryParameterEClass = createEClass(LIBRARY_PARAMETER);
		createEReference(libraryParameterEClass, LIBRARY_PARAMETER__SOURCE);
		createEReference(libraryParameterEClass, LIBRARY_PARAMETER__ORIGINAL_PARAMETER);

		attributeParameterEClass = createEClass(ATTRIBUTE_PARAMETER);
		createEReference(attributeParameterEClass, ATTRIBUTE_PARAMETER__ATTRIBUTE);

		containerParameterEClass = createEClass(CONTAINER_PARAMETER);
		createEReference(containerParameterEClass, CONTAINER_PARAMETER__CLASS);

		externalReferenceParameterEClass = createEClass(EXTERNAL_REFERENCE_PARAMETER);
		createEReference(externalReferenceParameterEClass, EXTERNAL_REFERENCE_PARAMETER__REFERENCE);

		resourceParameterEClass = createEClass(RESOURCE_PARAMETER);
		createEReference(resourceParameterEClass, RESOURCE_PARAMETER__ATTRIBUTE);
		createEReference(resourceParameterEClass, RESOURCE_PARAMETER__ORIGINAL_PARAMETER);

		libraryEntryEClass = createEClass(LIBRARY_ENTRY);
		createEReference(libraryEntryEClass, LIBRARY_ENTRY__PARAMETERS);
		createEAttribute(libraryEntryEClass, LIBRARY_ENTRY__LIBRARY_FILE);
		createEReference(libraryEntryEClass, LIBRARY_ENTRY__ORIGINAL_LIBRARY_ENTRY);
		createEReference(libraryEntryEClass, LIBRARY_ENTRY__PATH);
		createEReference(libraryEntryEClass, LIBRARY_ENTRY__ID);
		createEReference(libraryEntryEClass, LIBRARY_ENTRY__RESOURCE_PARAMETERS);

		sourceSectionReferenceEClass = createEClass(SOURCE_SECTION_REFERENCE);

		targetSectionReferenceEClass = createEClass(TARGET_SECTION_REFERENCE);

		targetSectionCompositeReferenceEClass = createEClass(TARGET_SECTION_CONTAINMENT_REFERENCE);

		targetSectionCrossReferenceEClass = createEClass(TARGET_SECTION_CROSS_REFERENCE);
		createEOperation(targetSectionCrossReferenceEClass, TARGET_SECTION_CROSS_REFERENCE___VALIDATE_EREFERENCE_IS_NON_CONTAINMENT__DIAGNOSTICCHAIN_MAP);

		sourceSectionCompositeReferenceEClass = createEClass(SOURCE_SECTION_CONTAINMENT_REFERENCE);

		sourceSectionCrossReferenceEClass = createEClass(SOURCE_SECTION_CROSS_REFERENCE);

		sourceSectionAttributeEClass = createEClass(SOURCE_SECTION_ATTRIBUTE);
		createEReference(sourceSectionAttributeEClass, SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINT);

		actualSourceSectionAttributeEClass = createEClass(ACTUAL_SOURCE_SECTION_ATTRIBUTE);

		targetSectionAttributeEClass = createEClass(TARGET_SECTION_ATTRIBUTE);
		createEAttribute(targetSectionAttributeEClass, TARGET_SECTION_ATTRIBUTE__UNIQUE);
		createEAttribute(targetSectionAttributeEClass, TARGET_SECTION_ATTRIBUTE__VALUE);

		actualTargetSectionAttributeEClass = createEClass(ACTUAL_TARGET_SECTION_ATTRIBUTE);

		virtualTargetSectionAttributeEClass = createEClass(VIRTUAL_TARGET_SECTION_ATTRIBUTE);

		equalityMatcherEClass = createEClass(EQUALITY_MATCHER);

		valueConstraintEClass = createEClass(VALUE_CONSTRAINT);
		createEAttribute(valueConstraintEClass, VALUE_CONSTRAINT__TYPE);

		substringMatcherEClass = createEClass(SUBSTRING_MATCHER);

		beginningMatcherEClass = createEClass(BEGINNING_MATCHER);

		endingMatcherEClass = createEClass(ENDING_MATCHER);

		regExMatcherEClass = createEClass(REG_EX_MATCHER);

		caseSensitiveConstraintEClass = createEClass(CASE_SENSITIVE_CONSTRAINT);
		createEAttribute(caseSensitiveConstraintEClass, CASE_SENSITIVE_CONSTRAINT__CASE_SENSITIVE);

		rangeConstraintEClass = createEClass(RANGE_CONSTRAINT);
		createEReference(rangeConstraintEClass, RANGE_CONSTRAINT__UPPER_BOUND);
		createEReference(rangeConstraintEClass, RANGE_CONSTRAINT__LOWER_BOUND);

		multipleReferencesValueConstraintEClass = createEClass(MULTIPLE_REFERENCES_VALUE_CONSTRAINT);
		createEOperation(multipleReferencesValueConstraintEClass, MULTIPLE_REFERENCES_VALUE_CONSTRAINT___CHECK_CONSTRAINT__STRING_ELIST);

		instancePointerEClass = createEClass(INSTANCE_POINTER);
		createEReference(instancePointerEClass, INSTANCE_POINTER__TARGET);
		createEReference(instancePointerEClass, INSTANCE_POINTER__SOURCE_ELEMENTS);
		createEOperation(instancePointerEClass, INSTANCE_POINTER___VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS__DIAGNOSTICCHAIN_MAP);

		instancePointerSourceInterfaceEClass = createEClass(INSTANCE_POINTER_SOURCE_INTERFACE);

		instancePointerSourceElementEClass = createEClass(INSTANCE_POINTER_SOURCE_ELEMENT);

		instancePointerExternalSourceElementEClass = createEClass(INSTANCE_POINTER_EXTERNAL_SOURCE_ELEMENT);

		rangeBoundEClass = createEClass(RANGE_BOUND);
		createEAttribute(rangeBoundEClass, RANGE_BOUND__BOUND_TYPE);
		createEReference(rangeBoundEClass, RANGE_BOUND__BOUND_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION);
		createEReference(rangeBoundEClass, RANGE_BOUND__SOURCE_ELEMENTS);
		createEOperation(rangeBoundEClass, RANGE_BOUND___VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP);
		createEOperation(rangeBoundEClass, RANGE_BOUND___VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP);
		createEOperation(rangeBoundEClass, RANGE_BOUND___IS_LOCAL_CONSTRAINT);

		singleReferenceValueConstraintEClass = createEClass(SINGLE_REFERENCE_VALUE_CONSTRAINT);
		createEReference(singleReferenceValueConstraintEClass, SINGLE_REFERENCE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION);
		createEReference(singleReferenceValueConstraintEClass, SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS);
		createEOperation(singleReferenceValueConstraintEClass, SINGLE_REFERENCE_VALUE_CONSTRAINT___CHECK_CONSTRAINT__STRING_STRING);
		createEOperation(singleReferenceValueConstraintEClass, SINGLE_REFERENCE_VALUE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP);
		createEOperation(singleReferenceValueConstraintEClass, SINGLE_REFERENCE_VALUE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP);
		createEOperation(singleReferenceValueConstraintEClass, SINGLE_REFERENCE_VALUE_CONSTRAINT___VALIDATE_NO_RESULT_MODIFIER_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP);
		createEOperation(singleReferenceValueConstraintEClass, SINGLE_REFERENCE_VALUE_CONSTRAINT___IS_LOCAL_CONSTRAINT);

		valueConstraintSourceInterfaceEClass = createEClass(VALUE_CONSTRAINT_SOURCE_INTERFACE);

		valueConstraintSourceElementEClass = createEClass(VALUE_CONSTRAINT_SOURCE_ELEMENT);

		valueConstraintExternalSourceElementEClass = createEClass(VALUE_CONSTRAINT_EXTERNAL_SOURCE_ELEMENT);

		// Create enums
		fileTypeEnumEEnum = createEEnum(FILE_TYPE_ENUM);
		valueConstraintTypeEEnum = createEEnum(VALUE_CONSTRAINT_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		GenericPackage theGenericPackage = (GenericPackage)EPackage.Registry.INSTANCE.getEPackage(GenericPackage.eNS_URI);
		MappingPackage theMappingPackage = (MappingPackage)EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI);
		PamtramPackage thePamtramPackage = (PamtramPackage)EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI);
		GenLibraryPackage theGenLibraryPackage = (GenLibraryPackage)EPackage.Registry.INSTANCE.getEPackage(GenLibraryPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theGenericPackage);

		// Create type parameters
		ETypeParameter libraryParameterEClass_ParameterType = addETypeParameter(libraryParameterEClass, "ParameterType");

		// Set bounds for type parameters

		// Add supertypes to classes
		EGenericType g1 = createEGenericType(this.getSourceSectionClass());
		sourceSectionEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getSection());
		EGenericType g2 = createEGenericType(this.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		sourceSectionEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTargetSectionClass());
		targetSectionEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getSection());
		g2 = createEGenericType(this.getTargetSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		targetSectionEClass.getEGenericSuperTypes().add(g1);
		fileAttributeEClass.getESuperTypes().add(this.getVirtualTargetSectionAttribute());
		g1 = createEGenericType(theGenericPackage.getClass_());
		g2 = createEGenericType(this.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		sourceSectionClassEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getClass_());
		g2 = createEGenericType(this.getTargetSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		targetSectionClassEClass.getEGenericSuperTypes().add(g1);
		libraryParameterEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		g1 = createEGenericType(this.getLibraryParameter());
		g2 = createEGenericType(theGenLibraryPackage.getAbstractAttributeParameter());
		g1.getETypeArguments().add(g2);
		EGenericType g3 = createEGenericType();
		g2.getETypeArguments().add(g3);
		attributeParameterEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getLibraryParameter());
		g2 = createEGenericType(theGenLibraryPackage.getAbstractContainerParameter());
		g1.getETypeArguments().add(g2);
		g3 = createEGenericType();
		g2.getETypeArguments().add(g3);
		g3 = createEGenericType();
		g2.getETypeArguments().add(g3);
		containerParameterEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getLibraryParameter());
		g2 = createEGenericType(theGenLibraryPackage.getAbstractExternalReferenceParameter());
		g1.getETypeArguments().add(g2);
		g3 = createEGenericType();
		g2.getETypeArguments().add(g3);
		g3 = createEGenericType();
		g2.getETypeArguments().add(g3);
		externalReferenceParameterEClass.getEGenericSuperTypes().add(g1);
		resourceParameterEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		g1 = createEGenericType(theGenericPackage.getReference());
		g2 = createEGenericType(this.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		sourceSectionReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getReference());
		g2 = createEGenericType(this.getTargetSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		targetSectionReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getCompositeReference());
		g2 = createEGenericType(this.getTargetSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		targetSectionCompositeReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTargetSectionReference());
		targetSectionCompositeReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getCrossReference());
		g2 = createEGenericType(this.getTargetSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		targetSectionCrossReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTargetSectionReference());
		targetSectionCrossReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getCompositeReference());
		g2 = createEGenericType(this.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		sourceSectionCompositeReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSourceSectionReference());
		sourceSectionCompositeReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getCrossReference());
		g2 = createEGenericType(this.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		sourceSectionCrossReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSourceSectionReference());
		sourceSectionCrossReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getAttribute());
		g2 = createEGenericType(this.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		sourceSectionAttributeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSourceSectionAttribute());
		actualSourceSectionAttributeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getActualAttribute());
		g2 = createEGenericType(this.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		actualSourceSectionAttributeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getAttribute());
		g2 = createEGenericType(this.getTargetSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		targetSectionAttributeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTargetSectionAttribute());
		actualTargetSectionAttributeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getActualAttribute());
		g2 = createEGenericType(this.getTargetSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		actualTargetSectionAttributeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTargetSectionAttribute());
		virtualTargetSectionAttributeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getVirtualAttribute());
		g2 = createEGenericType(this.getTargetSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		virtualTargetSectionAttributeEClass.getEGenericSuperTypes().add(g1);
		equalityMatcherEClass.getESuperTypes().add(this.getCaseSensitiveConstraint());
		valueConstraintEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		substringMatcherEClass.getESuperTypes().add(this.getCaseSensitiveConstraint());
		beginningMatcherEClass.getESuperTypes().add(this.getCaseSensitiveConstraint());
		endingMatcherEClass.getESuperTypes().add(this.getCaseSensitiveConstraint());
		regExMatcherEClass.getESuperTypes().add(this.getSingleReferenceValueConstraint());
		caseSensitiveConstraintEClass.getESuperTypes().add(this.getSingleReferenceValueConstraint());
		rangeConstraintEClass.getESuperTypes().add(this.getMultipleReferencesValueConstraint());
		multipleReferencesValueConstraintEClass.getESuperTypes().add(this.getValueConstraint());
		instancePointerEClass.getESuperTypes().add(theMappingPackage.getExpressionHint());
		instancePointerEClass.getESuperTypes().add(theMappingPackage.getModifiableHint());
		instancePointerSourceInterfaceEClass.getESuperTypes().add(theMappingPackage.getMappingHintSourceInterface());
		g1 = createEGenericType(theMappingPackage.getLocalModifiedAttributeElementType());
		g2 = createEGenericType(this.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		instancePointerSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getInstancePointerSourceInterface());
		instancePointerSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theMappingPackage.getExternalModifiedAttributeElementType());
		g2 = createEGenericType(this.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		instancePointerExternalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getInstancePointerSourceInterface());
		instancePointerExternalSourceElementEClass.getEGenericSuperTypes().add(g1);
		rangeBoundEClass.getESuperTypes().add(theMappingPackage.getExpressionHint());
		rangeBoundEClass.getESuperTypes().add(theMappingPackage.getModifiableHint());
		singleReferenceValueConstraintEClass.getESuperTypes().add(this.getValueConstraint());
		singleReferenceValueConstraintEClass.getESuperTypes().add(theMappingPackage.getExpressionHint());
		singleReferenceValueConstraintEClass.getESuperTypes().add(theMappingPackage.getModifiableHint());
		valueConstraintSourceInterfaceEClass.getESuperTypes().add(theMappingPackage.getMappingHintSourceInterface());
		g1 = createEGenericType(theMappingPackage.getLocalModifiedAttributeElementType());
		g2 = createEGenericType(this.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		valueConstraintSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getValueConstraintSourceInterface());
		valueConstraintSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theMappingPackage.getExternalModifiedAttributeElementType());
		g2 = createEGenericType(this.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		valueConstraintExternalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getValueConstraintSourceInterface());
		valueConstraintExternalSourceElementEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes, features, and operations; add parameters
		initEClass(sourceSectionEClass, SourceSection.class, "SourceSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSourceSection_ReferencingMappings(), theMappingPackage.getMappingType(), null, "referencingMappings", null, 0, -1, SourceSection.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getSourceSection__ValidateIsReferencedByMapping__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateIsReferencedByMapping", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(targetSectionEClass, TargetSection.class, "TargetSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTargetSection_ReferencingMappingHintGroups(), theMappingPackage.getMappingHintGroupType(), null, "referencingMappingHintGroups", null, 0, -1, TargetSection.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTargetSection_File(), this.getFileAttribute(), null, "file", null, 0, 1, TargetSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getTargetSection__ValidateIsReferencedByMappingHintGroup__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateIsReferencedByMappingHintGroup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(fileAttributeEClass, FileAttribute.class, "FileAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFileAttribute_FileType(), this.getFileTypeEnum(), "fileType", null, 1, 1, FileAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sourceSectionClassEClass, SourceSectionClass.class, "SourceSectionClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(targetSectionClassEClass, TargetSectionClass.class, "TargetSectionClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(libraryParameterEClass, LibraryParameter.class, "LibraryParameter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLibraryParameter_Source(), ecorePackage.getEObject(), null, "source", null, 1, 1, LibraryParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(libraryParameterEClass_ParameterType);
		initEReference(getLibraryParameter_OriginalParameter(), g1, null, "originalParameter", null, 1, 1, LibraryParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeParameterEClass, AttributeParameter.class, "AttributeParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeParameter_Attribute(), this.getActualTargetSectionAttribute(), null, "attribute", null, 1, 1, AttributeParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(containerParameterEClass, ContainerParameter.class, "ContainerParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContainerParameter_Class(), this.getTargetSection(), null, "class", null, 1, 1, ContainerParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(externalReferenceParameterEClass, ExternalReferenceParameter.class, "ExternalReferenceParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExternalReferenceParameter_Reference(), this.getTargetSectionCrossReference(), null, "reference", null, 1, 1, ExternalReferenceParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceParameterEClass, ResourceParameter.class, "ResourceParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceParameter_Attribute(), this.getVirtualTargetSectionAttribute(), null, "attribute", null, 1, 1, ResourceParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceParameter_OriginalParameter(), theGenLibraryPackage.getResourceParameter(), null, "originalParameter", null, 1, 1, ResourceParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(libraryEntryEClass, LibraryEntry.class, "LibraryEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getLibraryParameter());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEReference(getLibraryEntry_Parameters(), g1, null, "parameters", null, 1, -1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLibraryEntry_LibraryFile(), ecorePackage.getEString(), "libraryFile", null, 1, 1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibraryEntry_OriginalLibraryEntry(), theGenLibraryPackage.getLibraryEntry(), null, "originalLibraryEntry", null, 1, 1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibraryEntry_Path(), this.getVirtualTargetSectionAttribute(), null, "path", null, 1, 1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibraryEntry_Id(), this.getVirtualTargetSectionAttribute(), null, "id", null, 1, 1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibraryEntry_ResourceParameters(), this.getResourceParameter(), null, "resourceParameters", null, 0, -1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sourceSectionReferenceEClass, SourceSectionReference.class, "SourceSectionReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(targetSectionReferenceEClass, TargetSectionReference.class, "TargetSectionReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(targetSectionCompositeReferenceEClass, TargetSectionContainmentReference.class, "TargetSectionContainmentReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(targetSectionCrossReferenceEClass, TargetSectionCrossReference.class, "TargetSectionCrossReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getTargetSectionCrossReference__ValidateEReferenceIsNonContainment__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateEReferenceIsNonContainment", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sourceSectionCompositeReferenceEClass, SourceSectionContainmentReference.class, "SourceSectionContainmentReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sourceSectionCrossReferenceEClass, SourceSectionCrossReference.class, "SourceSectionCrossReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sourceSectionAttributeEClass, SourceSectionAttribute.class, "SourceSectionAttribute", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSourceSectionAttribute_ValueConstraint(), this.getValueConstraint(), null, "valueConstraint", null, 0, -1, SourceSectionAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actualSourceSectionAttributeEClass, ActualSourceSectionAttribute.class, "ActualSourceSectionAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(targetSectionAttributeEClass, TargetSectionAttribute.class, "TargetSectionAttribute", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTargetSectionAttribute_Unique(), ecorePackage.getEBoolean(), "unique", "false", 1, 1, TargetSectionAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTargetSectionAttribute_Value(), ecorePackage.getEString(), "value", null, 0, 1, TargetSectionAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actualTargetSectionAttributeEClass, ActualTargetSectionAttribute.class, "ActualTargetSectionAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(virtualTargetSectionAttributeEClass, VirtualTargetSectionAttribute.class, "VirtualTargetSectionAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(equalityMatcherEClass, EqualityMatcher.class, "EqualityMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(valueConstraintEClass, ValueConstraint.class, "ValueConstraint", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getValueConstraint_Type(), this.getValueConstraintType(), "type", "INCLUSION", 1, 1, ValueConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(substringMatcherEClass, SubstringMatcher.class, "SubstringMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(beginningMatcherEClass, BeginningMatcher.class, "BeginningMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(endingMatcherEClass, EndingMatcher.class, "EndingMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(regExMatcherEClass, RegExMatcher.class, "RegExMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(caseSensitiveConstraintEClass, CaseSensitiveConstraint.class, "CaseSensitiveConstraint", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCaseSensitiveConstraint_CaseSensitive(), ecorePackage.getEBoolean(), "caseSensitive", "true", 1, 1, CaseSensitiveConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rangeConstraintEClass, RangeConstraint.class, "RangeConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRangeConstraint_UpperBound(), this.getRangeBound(), null, "upperBound", null, 0, 1, RangeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRangeConstraint_LowerBound(), this.getRangeBound(), null, "lowerBound", null, 0, 1, RangeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multipleReferencesValueConstraintEClass, MultipleReferencesValueConstraint.class, "MultipleReferencesValueConstraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getMultipleReferencesValueConstraint__CheckConstraint__String_EList(), ecorePackage.getEBoolean(), "checkConstraint", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "attrValue", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "refValue", 1, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(instancePointerEClass, InstancePointer.class, "InstancePointer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstancePointer_Target(), this.getActualSourceSectionAttribute(), null, "target", null, 1, 1, InstancePointer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstancePointer_SourceElements(), this.getInstancePointerSourceInterface(), null, "sourceElements", null, 0, -1, InstancePointer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getInstancePointer__ValidateNoModifiedAttributeElementTypesInConditionModelConditions__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateNoModifiedAttributeElementTypesInConditionModelConditions", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(instancePointerSourceInterfaceEClass, InstancePointerSourceInterface.class, "InstancePointerSourceInterface", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(instancePointerSourceElementEClass, InstancePointerSourceElement.class, "InstancePointerSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(instancePointerExternalSourceElementEClass, InstancePointerExternalSourceElement.class, "InstancePointerExternalSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rangeBoundEClass, RangeBound.class, "RangeBound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRangeBound_BoundType(), this.getValueConstraintType(), "boundType", null, 0, 1, RangeBound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRangeBound_BoundReferenceValueAdditionalSpecification(), this.getInstancePointer(), null, "boundReferenceValueAdditionalSpecification", null, 0, -1, RangeBound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRangeBound_SourceElements(), this.getValueConstraintSourceInterface(), null, "sourceElements", null, 0, -1, RangeBound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getRangeBound__ValidateOnlyFixedValuesInSourceSections__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateOnlyFixedValuesInSourceSections", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getRangeBound__ValidateOnlyFixedValuesOrGlobalAttributesInConditionModel__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateOnlyFixedValuesOrGlobalAttributesInConditionModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getRangeBound__IsLocalConstraint(), ecorePackage.getEBoolean(), "isLocalConstraint", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(singleReferenceValueConstraintEClass, SingleReferenceValueConstraint.class, "SingleReferenceValueConstraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSingleReferenceValueConstraint_ConstraintReferenceValueAdditionalSpecification(), this.getInstancePointer(), null, "constraintReferenceValueAdditionalSpecification", null, 0, -1, SingleReferenceValueConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSingleReferenceValueConstraint_SourceElements(), this.getValueConstraintSourceInterface(), null, "sourceElements", null, 0, -1, SingleReferenceValueConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getSingleReferenceValueConstraint__CheckConstraint__String_String(), ecorePackage.getEBoolean(), "checkConstraint", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "attrValue", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "refValue", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getSingleReferenceValueConstraint__ValidateOnlyFixedValuesInSourceSections__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateOnlyFixedValuesInSourceSections", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getSingleReferenceValueConstraint__ValidateOnlyFixedValuesOrGlobalAttributesInConditionModel__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateOnlyFixedValuesOrGlobalAttributesInConditionModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getSingleReferenceValueConstraint__ValidateNoResultModifierInSourceSections__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateNoResultModifierInSourceSections", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getSingleReferenceValueConstraint__IsLocalConstraint(), ecorePackage.getEBoolean(), "isLocalConstraint", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(valueConstraintSourceInterfaceEClass, ValueConstraintSourceInterface.class, "ValueConstraintSourceInterface", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(valueConstraintSourceElementEClass, ValueConstraintSourceElement.class, "ValueConstraintSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(valueConstraintExternalSourceElementEClass, ValueConstraintExternalSourceElement.class, "ValueConstraintExternalSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(fileTypeEnumEEnum, FileTypeEnum.class, "FileTypeEnum");
		addEEnumLiteral(fileTypeEnumEEnum, FileTypeEnum.XMI);
		addEEnumLiteral(fileTypeEnumEEnum, FileTypeEnum.XML);

		initEEnum(valueConstraintTypeEEnum, ValueConstraintType.class, "ValueConstraintType");
		addEEnumLiteral(valueConstraintTypeEEnum, ValueConstraintType.INCLUSION);
		addEEnumLiteral(valueConstraintTypeEEnum, ValueConstraintType.EXCLUSION);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";	
		addAnnotation
		  (sourceSectionEClass, 
		   source, 
		   new String[] {
			 "constraints", "isReferencedByMapping"
		   });	
		addAnnotation
		  (targetSectionEClass, 
		   source, 
		   new String[] {
			 "constraints", "isReferencedByMappingHintGroup"
		   });	
		addAnnotation
		  (sourceSectionCrossReferenceEClass, 
		   source, 
		   new String[] {
			 "constraints", "valuesMatchReferenceType"
		   });	
		addAnnotation
		  (instancePointerEClass, 
		   source, 
		   new String[] {
			 "constraints", "noModifiedAttributeElementTypesInConditionModelConditions"
		   });	
		addAnnotation
		  (rangeBoundEClass, 
		   source, 
		   new String[] {
			 "constraints", "onlyFixedValuesInSourceSections onlyFixedValuesOrGlobalAttributesInConditionModel"
		   });	
		addAnnotation
		  (singleReferenceValueConstraintEClass, 
		   source, 
		   new String[] {
			 "constraints", "onlyFixedValuesInSourceSections onlyFixedValuesOrGlobalAttributesInConditionModel"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "ecore", "http://www.eclipse.org/emf/2002/Ecore",
			 "genlib", "http://www.et.tu-dresden.de/ifa/agtele/genlib"
		   });
	}

} //StructurePackageImpl
