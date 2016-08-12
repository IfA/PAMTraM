/**
 */
package pamtram.metamodel.impl;

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
import pamtram.metamodel.ActualAttribute;
import pamtram.metamodel.ActualTargetSectionAttribute;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.AttributeParameter;
import pamtram.metamodel.AttributeValueConstraint;
import pamtram.metamodel.AttributeValueConstraintExternalSourceElement;
import pamtram.metamodel.AttributeValueConstraintSourceElement;
import pamtram.metamodel.AttributeValueConstraintSourceInterface;
import pamtram.metamodel.AttributeValueConstraintType;
import pamtram.metamodel.BeginningMatcher;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.CaseSensitiveConstraint;
import pamtram.metamodel.ContainerParameter;
import pamtram.metamodel.ContainmentReference;
import pamtram.metamodel.EndingMatcher;
import pamtram.metamodel.EqualityMatcher;
import pamtram.metamodel.ExternalReferenceParameter;
import pamtram.metamodel.FileAttribute;
import pamtram.metamodel.InstancePointer;
import pamtram.metamodel.InstancePointerExternalSourceElement;
import pamtram.metamodel.InstancePointerSourceElement;
import pamtram.metamodel.InstancePointerSourceInterface;
import pamtram.metamodel.FileTypeEnum;
import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.LibraryParameter;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.MetamodelFactory;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.MultipleReferencesAttributeValueConstraint;
import pamtram.metamodel.NonContainmentReference;
import pamtram.metamodel.RangeBound;
import pamtram.metamodel.RangeConstraint;
import pamtram.metamodel.Reference;
import pamtram.metamodel.RegExMatcher;
import pamtram.metamodel.Section;
import pamtram.metamodel.SingleReferenceAttributeValueConstraint;
import pamtram.metamodel.SourceSection;
import pamtram.metamodel.ActualSourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionContainmentReference;
import pamtram.metamodel.SourceSectionReference;
import pamtram.metamodel.SubstringMatcher;
import pamtram.metamodel.TargetSection;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionContainmentReference;
import pamtram.metamodel.TargetSectionNonContainmentReference;
import pamtram.metamodel.TargetSectionReference;
import pamtram.metamodel.VirtualAttribute;
import pamtram.metamodel.VirtualTargetSectionAttribute;
import pamtram.metamodel.util.MetamodelValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetamodelPackageImpl extends EPackageImpl implements MetamodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metaModelElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sectionEClass = null;

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
	private EClass libraryEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containmentReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nonContainmentReferenceEClass = null;

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
	private EClass targetSectionContainmentReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetSectionNonContainmentReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceSectionContainmentReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metaModelSectionReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actualAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualAttributeEClass = null;

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
	private EClass attributeValueConstraintEClass = null;

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
	private EClass multipleReferencesAttributeValueConstraintEClass = null;

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
	private EClass singleReferenceAttributeValueConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeValueConstraintSourceInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeValueConstraintSourceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeValueConstraintExternalSourceElementEClass = null;

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
	private EEnum attributeValueConstraintTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum cardinalityTypeEEnum = null;

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
	 * @see pamtram.metamodel.MetamodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MetamodelPackageImpl() {
		super(eNS_URI, MetamodelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link MetamodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MetamodelPackage init() {
		if (isInited) return (MetamodelPackage)EPackage.Registry.INSTANCE.getEPackage(MetamodelPackage.eNS_URI);

		// Obtain or create and register package
		MetamodelPackageImpl theMetamodelPackage = (MetamodelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MetamodelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MetamodelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		GenLibraryPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		PamtramPackageImpl thePamtramPackage = (PamtramPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI) instanceof PamtramPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI) : PamtramPackage.eINSTANCE);
		ConditionPackageImpl theConditionPackage = (ConditionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) instanceof ConditionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) : ConditionPackage.eINSTANCE);
		MappingPackageImpl theMappingPackage = (MappingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) instanceof MappingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) : MappingPackage.eINSTANCE);

		// Create package meta-data objects
		theMetamodelPackage.createPackageContents();
		thePamtramPackage.createPackageContents();
		theConditionPackage.createPackageContents();
		theMappingPackage.createPackageContents();

		// Initialize created meta-data
		theMetamodelPackage.initializePackageContents();
		thePamtramPackage.initializePackageContents();
		theConditionPackage.initializePackageContents();
		theMappingPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theMetamodelPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return MetamodelValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theMetamodelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MetamodelPackage.eNS_URI, theMetamodelPackage);
		return theMetamodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetaModelElement() {
		return metaModelElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMetaModelElement__GetContainingSection() {
		return metaModelElementEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMetaModelElement__GetContainingSectionModel() {
		return metaModelElementEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMetaModelElement__IsLibraryEntry() {
		return metaModelElementEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClass_() {
		return classEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_EClass() {
		return (EReference)classEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClass_Cardinality() {
		return (EAttribute)classEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_References() {
		return (EReference)classEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_Container() {
		return (EReference)classEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_Attributes() {
		return (EReference)classEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsContainerFor__Class() {
		return classEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsContainedIn__Class() {
		return classEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__GetOwningContainmentReference() {
		return classEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsReferencedBy__Class_EList() {
		return classEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__ContainerIsValid__DiagnosticChain_Map_1() {
		return classEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__CardinalityIsValid__DiagnosticChain_Map_1() {
		return classEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__EClassMatchesParentEReference__DiagnosticChain_Map_1() {
		return classEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSection() {
		return sectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSection_Abstract() {
		return (EAttribute)sectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSection_Extend() {
		return (EReference)sectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSection__ExtendsOnlyValidSections() {
		return sectionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSection__ValidateContainerMatchesExtendContainer__DiagnosticChain_Map() {
		return sectionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSection__ExtendsValidSections__DiagnosticChain_Map_1() {
		return sectionEClass.getEOperations().get(2);
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
	public EOperation getSourceSection__IsReferencedByMapping__DiagnosticChain_Map_1() {
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
	public EOperation getTargetSection__IsReferencedByMappingHintGroup__DiagnosticChain_Map_1() {
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
	public EReference getLibraryEntry_OriginalLibraryEntry() {
		return (EReference)libraryEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReference() {
		return referenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReference_EReference() {
		return (EReference)referenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReference_OwningClass() {
		return (EReference)referenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReference__EReferenceMatchesParentEClass__DiagnosticChain_Map_1() {
		return referenceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainmentReference() {
		return containmentReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainmentReference_Value() {
		return (EReference)containmentReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContainmentReference__EReferenceIsContainment__DiagnosticChain_Map_1() {
		return containmentReferenceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNonContainmentReference() {
		return nonContainmentReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNonContainmentReference_Value() {
		return (EReference)nonContainmentReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNonContainmentReference__EReferenceIsNonContainment__DiagnosticChain_Map_1() {
		return nonContainmentReferenceEClass.getEOperations().get(0);
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
	public EOperation getSourceSectionReference__GetValuesGeneric() {
		return sourceSectionReferenceEClass.getEOperations().get(0);
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
	public EOperation getTargetSectionReference__GetValuesGeneric() {
		return targetSectionReferenceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetSectionContainmentReference() {
		return targetSectionContainmentReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetSectionNonContainmentReference() {
		return targetSectionNonContainmentReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceSectionContainmentReference() {
		return sourceSectionContainmentReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetaModelSectionReference() {
		return metaModelSectionReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetaModelSectionReference_Value() {
		return (EReference)metaModelSectionReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMetaModelSectionReference__ValuesMatchReferenceType__DiagnosticChain_Map_1() {
		return metaModelSectionReferenceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttribute() {
		return attributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttribute_OwningClass() {
		return (EReference)attributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActualAttribute() {
		return actualAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActualAttribute_Attribute() {
		return (EReference)actualAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getActualAttribute__AttributeMatchesParentEClass__DiagnosticChain_Map() {
		return actualAttributeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualAttribute() {
		return virtualAttributeEClass;
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
	public EReference getSourceSectionAttribute_Attribute() {
		return (EReference)sourceSectionAttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSourceSectionAttribute__AttributeMatchesParentEClass__DiagnosticChain_Map_1() {
		return sourceSectionAttributeEClass.getEOperations().get(0);
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
	public EClass getAttributeValueConstraint() {
		return attributeValueConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeValueConstraint_Type() {
		return (EAttribute)attributeValueConstraintEClass.getEStructuralFeatures().get(0);
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
	public EClass getMultipleReferencesAttributeValueConstraint() {
		return multipleReferencesAttributeValueConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMultipleReferencesAttributeValueConstraint__CheckConstraint__String_EList() {
		return multipleReferencesAttributeValueConstraintEClass.getEOperations().get(0);
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
	public EReference getInstancePointer_AttributePointer() {
		return (EReference)instancePointerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstancePointer_Value() {
		return (EAttribute)instancePointerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstancePointer_SourceAttributes() {
		return (EReference)instancePointerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstancePointer__NoModifiedAttributeElementTypesInConditionModelConditions__DiagnosticChain_Map_1() {
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
	public EClass getSingleReferenceAttributeValueConstraint() {
		return singleReferenceAttributeValueConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingleReferenceAttributeValueConstraint_ConstraintReferenceValueAdditionalSpecification() {
		return (EReference)singleReferenceAttributeValueConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingleReferenceAttributeValueConstraint_SourceElements() {
		return (EReference)singleReferenceAttributeValueConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSingleReferenceAttributeValueConstraint__CheckConstraint__String_String() {
		return singleReferenceAttributeValueConstraintEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSingleReferenceAttributeValueConstraint__ValidateOnlyFixedValuesInSourceSections__DiagnosticChain_Map() {
		return singleReferenceAttributeValueConstraintEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSingleReferenceAttributeValueConstraint__ValidateOnlyFixedValuesOrGlobalAttributesInConditionModel__DiagnosticChain_Map() {
		return singleReferenceAttributeValueConstraintEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSingleReferenceAttributeValueConstraint__IsLocalConstraint() {
		return singleReferenceAttributeValueConstraintEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeValueConstraintSourceInterface() {
		return attributeValueConstraintSourceInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeValueConstraintSourceElement() {
		return attributeValueConstraintSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeValueConstraintExternalSourceElement() {
		return attributeValueConstraintExternalSourceElementEClass;
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
	public EEnum getAttributeValueConstraintType() {
		return attributeValueConstraintTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCardinalityType() {
		return cardinalityTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetamodelFactory getMetamodelFactory() {
		return (MetamodelFactory)getEFactoryInstance();
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
		metaModelElementEClass = createEClass(META_MODEL_ELEMENT);
		createEOperation(metaModelElementEClass, META_MODEL_ELEMENT___GET_CONTAINING_SECTION);
		createEOperation(metaModelElementEClass, META_MODEL_ELEMENT___GET_CONTAINING_SECTION_MODEL);
		createEOperation(metaModelElementEClass, META_MODEL_ELEMENT___IS_LIBRARY_ENTRY);

		classEClass = createEClass(CLASS);
		createEReference(classEClass, CLASS__ECLASS);
		createEAttribute(classEClass, CLASS__CARDINALITY);
		createEReference(classEClass, CLASS__REFERENCES);
		createEReference(classEClass, CLASS__CONTAINER);
		createEReference(classEClass, CLASS__ATTRIBUTES);
		createEOperation(classEClass, CLASS___IS_CONTAINER_FOR__CLASS);
		createEOperation(classEClass, CLASS___IS_CONTAINED_IN__CLASS);
		createEOperation(classEClass, CLASS___GET_OWNING_CONTAINMENT_REFERENCE);
		createEOperation(classEClass, CLASS___IS_REFERENCED_BY__CLASS_ELIST);
		createEOperation(classEClass, CLASS___CONTAINER_IS_VALID__DIAGNOSTICCHAIN_MAP_1);
		createEOperation(classEClass, CLASS___CARDINALITY_IS_VALID__DIAGNOSTICCHAIN_MAP_1);
		createEOperation(classEClass, CLASS___ECLASS_MATCHES_PARENT_EREFERENCE__DIAGNOSTICCHAIN_MAP_1);

		sectionEClass = createEClass(SECTION);
		createEAttribute(sectionEClass, SECTION__ABSTRACT);
		createEReference(sectionEClass, SECTION__EXTEND);
		createEOperation(sectionEClass, SECTION___EXTENDS_ONLY_VALID_SECTIONS);
		createEOperation(sectionEClass, SECTION___VALIDATE_CONTAINER_MATCHES_EXTEND_CONTAINER__DIAGNOSTICCHAIN_MAP);
		createEOperation(sectionEClass, SECTION___EXTENDS_VALID_SECTIONS__DIAGNOSTICCHAIN_MAP_1);

		sourceSectionEClass = createEClass(SOURCE_SECTION);
		createEReference(sourceSectionEClass, SOURCE_SECTION__REFERENCING_MAPPINGS);
		createEOperation(sourceSectionEClass, SOURCE_SECTION___IS_REFERENCED_BY_MAPPING__DIAGNOSTICCHAIN_MAP_1);

		targetSectionEClass = createEClass(TARGET_SECTION);
		createEReference(targetSectionEClass, TARGET_SECTION__REFERENCING_MAPPING_HINT_GROUPS);
		createEReference(targetSectionEClass, TARGET_SECTION__FILE);
		createEOperation(targetSectionEClass, TARGET_SECTION___IS_REFERENCED_BY_MAPPING_HINT_GROUP__DIAGNOSTICCHAIN_MAP_1);

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

		libraryEntryEClass = createEClass(LIBRARY_ENTRY);
		createEReference(libraryEntryEClass, LIBRARY_ENTRY__PARAMETERS);
		createEAttribute(libraryEntryEClass, LIBRARY_ENTRY__LIBRARY_FILE);
		createEReference(libraryEntryEClass, LIBRARY_ENTRY__ORIGINAL_LIBRARY_ENTRY);
		createEReference(libraryEntryEClass, LIBRARY_ENTRY__PATH);
		createEReference(libraryEntryEClass, LIBRARY_ENTRY__ID);

		referenceEClass = createEClass(REFERENCE);
		createEReference(referenceEClass, REFERENCE__EREFERENCE);
		createEReference(referenceEClass, REFERENCE__OWNING_CLASS);
		createEOperation(referenceEClass, REFERENCE___EREFERENCE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP_1);

		containmentReferenceEClass = createEClass(CONTAINMENT_REFERENCE);
		createEReference(containmentReferenceEClass, CONTAINMENT_REFERENCE__VALUE);
		createEOperation(containmentReferenceEClass, CONTAINMENT_REFERENCE___EREFERENCE_IS_CONTAINMENT__DIAGNOSTICCHAIN_MAP_1);

		nonContainmentReferenceEClass = createEClass(NON_CONTAINMENT_REFERENCE);
		createEReference(nonContainmentReferenceEClass, NON_CONTAINMENT_REFERENCE__VALUE);
		createEOperation(nonContainmentReferenceEClass, NON_CONTAINMENT_REFERENCE___EREFERENCE_IS_NON_CONTAINMENT__DIAGNOSTICCHAIN_MAP_1);

		sourceSectionReferenceEClass = createEClass(SOURCE_SECTION_REFERENCE);
		createEOperation(sourceSectionReferenceEClass, SOURCE_SECTION_REFERENCE___GET_VALUES_GENERIC);

		targetSectionReferenceEClass = createEClass(TARGET_SECTION_REFERENCE);
		createEOperation(targetSectionReferenceEClass, TARGET_SECTION_REFERENCE___GET_VALUES_GENERIC);

		targetSectionContainmentReferenceEClass = createEClass(TARGET_SECTION_CONTAINMENT_REFERENCE);

		targetSectionNonContainmentReferenceEClass = createEClass(TARGET_SECTION_NON_CONTAINMENT_REFERENCE);

		sourceSectionContainmentReferenceEClass = createEClass(SOURCE_SECTION_CONTAINMENT_REFERENCE);

		metaModelSectionReferenceEClass = createEClass(META_MODEL_SECTION_REFERENCE);
		createEReference(metaModelSectionReferenceEClass, META_MODEL_SECTION_REFERENCE__VALUE);
		createEOperation(metaModelSectionReferenceEClass, META_MODEL_SECTION_REFERENCE___VALUES_MATCH_REFERENCE_TYPE__DIAGNOSTICCHAIN_MAP_1);

		attributeEClass = createEClass(ATTRIBUTE);
		createEReference(attributeEClass, ATTRIBUTE__OWNING_CLASS);

		actualAttributeEClass = createEClass(ACTUAL_ATTRIBUTE);
		createEReference(actualAttributeEClass, ACTUAL_ATTRIBUTE__ATTRIBUTE);
		createEOperation(actualAttributeEClass, ACTUAL_ATTRIBUTE___ATTRIBUTE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP);

		virtualAttributeEClass = createEClass(VIRTUAL_ATTRIBUTE);

		sourceSectionAttributeEClass = createEClass(SOURCE_SECTION_ATTRIBUTE);
		createEReference(sourceSectionAttributeEClass, SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINT);
		createEReference(sourceSectionAttributeEClass, SOURCE_SECTION_ATTRIBUTE__ATTRIBUTE);
		createEOperation(sourceSectionAttributeEClass, SOURCE_SECTION_ATTRIBUTE___ATTRIBUTE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP_1);

		targetSectionAttributeEClass = createEClass(TARGET_SECTION_ATTRIBUTE);
		createEAttribute(targetSectionAttributeEClass, TARGET_SECTION_ATTRIBUTE__UNIQUE);
		createEAttribute(targetSectionAttributeEClass, TARGET_SECTION_ATTRIBUTE__VALUE);

		actualTargetSectionAttributeEClass = createEClass(ACTUAL_TARGET_SECTION_ATTRIBUTE);

		virtualTargetSectionAttributeEClass = createEClass(VIRTUAL_TARGET_SECTION_ATTRIBUTE);

		equalityMatcherEClass = createEClass(EQUALITY_MATCHER);

		attributeValueConstraintEClass = createEClass(ATTRIBUTE_VALUE_CONSTRAINT);
		createEAttribute(attributeValueConstraintEClass, ATTRIBUTE_VALUE_CONSTRAINT__TYPE);

		substringMatcherEClass = createEClass(SUBSTRING_MATCHER);

		beginningMatcherEClass = createEClass(BEGINNING_MATCHER);

		endingMatcherEClass = createEClass(ENDING_MATCHER);

		regExMatcherEClass = createEClass(REG_EX_MATCHER);

		caseSensitiveConstraintEClass = createEClass(CASE_SENSITIVE_CONSTRAINT);
		createEAttribute(caseSensitiveConstraintEClass, CASE_SENSITIVE_CONSTRAINT__CASE_SENSITIVE);

		rangeConstraintEClass = createEClass(RANGE_CONSTRAINT);
		createEReference(rangeConstraintEClass, RANGE_CONSTRAINT__UPPER_BOUND);
		createEReference(rangeConstraintEClass, RANGE_CONSTRAINT__LOWER_BOUND);

		multipleReferencesAttributeValueConstraintEClass = createEClass(MULTIPLE_REFERENCES_ATTRIBUTE_VALUE_CONSTRAINT);
		createEOperation(multipleReferencesAttributeValueConstraintEClass, MULTIPLE_REFERENCES_ATTRIBUTE_VALUE_CONSTRAINT___CHECK_CONSTRAINT__STRING_ELIST);

		instancePointerEClass = createEClass(INSTANCE_POINTER);
		createEReference(instancePointerEClass, INSTANCE_POINTER__ATTRIBUTE_POINTER);
		createEAttribute(instancePointerEClass, INSTANCE_POINTER__VALUE);
		createEReference(instancePointerEClass, INSTANCE_POINTER__SOURCE_ATTRIBUTES);
		createEOperation(instancePointerEClass, INSTANCE_POINTER___NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS__DIAGNOSTICCHAIN_MAP_1);

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

		singleReferenceAttributeValueConstraintEClass = createEClass(SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT);
		createEReference(singleReferenceAttributeValueConstraintEClass, SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION);
		createEReference(singleReferenceAttributeValueConstraintEClass, SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__SOURCE_ELEMENTS);
		createEOperation(singleReferenceAttributeValueConstraintEClass, SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT___CHECK_CONSTRAINT__STRING_STRING);
		createEOperation(singleReferenceAttributeValueConstraintEClass, SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP);
		createEOperation(singleReferenceAttributeValueConstraintEClass, SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP);
		createEOperation(singleReferenceAttributeValueConstraintEClass, SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT___IS_LOCAL_CONSTRAINT);

		attributeValueConstraintSourceInterfaceEClass = createEClass(ATTRIBUTE_VALUE_CONSTRAINT_SOURCE_INTERFACE);

		attributeValueConstraintSourceElementEClass = createEClass(ATTRIBUTE_VALUE_CONSTRAINT_SOURCE_ELEMENT);

		attributeValueConstraintExternalSourceElementEClass = createEClass(ATTRIBUTE_VALUE_CONSTRAINT_EXTERNAL_SOURCE_ELEMENT);

		// Create enums
		fileTypeEnumEEnum = createEEnum(FILE_TYPE_ENUM);
		attributeValueConstraintTypeEEnum = createEEnum(ATTRIBUTE_VALUE_CONSTRAINT_TYPE);
		cardinalityTypeEEnum = createEEnum(CARDINALITY_TYPE);
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
		PamtramPackage thePamtramPackage = (PamtramPackage)EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI);
		MappingPackage theMappingPackage = (MappingPackage)EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI);
		GenLibraryPackage theGenLibraryPackage = (GenLibraryPackage)EPackage.Registry.INSTANCE.getEPackage(GenLibraryPackage.eNS_URI);

		// Create type parameters
		ETypeParameter metaModelElementEClass_S = addETypeParameter(metaModelElementEClass, "S");
		ETypeParameter metaModelElementEClass_C = addETypeParameter(metaModelElementEClass, "C");
		ETypeParameter metaModelElementEClass_R = addETypeParameter(metaModelElementEClass, "R");
		ETypeParameter metaModelElementEClass_A = addETypeParameter(metaModelElementEClass, "A");
		ETypeParameter classEClass_S = addETypeParameter(classEClass, "S");
		ETypeParameter classEClass_C = addETypeParameter(classEClass, "C");
		ETypeParameter classEClass_R = addETypeParameter(classEClass, "R");
		ETypeParameter classEClass_A = addETypeParameter(classEClass, "A");
		ETypeParameter sectionEClass_S = addETypeParameter(sectionEClass, "S");
		ETypeParameter sectionEClass_C = addETypeParameter(sectionEClass, "C");
		ETypeParameter sectionEClass_R = addETypeParameter(sectionEClass, "R");
		ETypeParameter sectionEClass_A = addETypeParameter(sectionEClass, "A");
		ETypeParameter libraryParameterEClass_ParameterType = addETypeParameter(libraryParameterEClass, "ParameterType");
		ETypeParameter referenceEClass_S = addETypeParameter(referenceEClass, "S");
		ETypeParameter referenceEClass_C = addETypeParameter(referenceEClass, "C");
		ETypeParameter referenceEClass_R = addETypeParameter(referenceEClass, "R");
		ETypeParameter referenceEClass_A = addETypeParameter(referenceEClass, "A");
		ETypeParameter containmentReferenceEClass_S = addETypeParameter(containmentReferenceEClass, "S");
		ETypeParameter containmentReferenceEClass_C = addETypeParameter(containmentReferenceEClass, "C");
		ETypeParameter containmentReferenceEClass_R = addETypeParameter(containmentReferenceEClass, "R");
		ETypeParameter containmentReferenceEClass_A = addETypeParameter(containmentReferenceEClass, "A");
		ETypeParameter nonContainmentReferenceEClass_S = addETypeParameter(nonContainmentReferenceEClass, "S");
		ETypeParameter nonContainmentReferenceEClass_C = addETypeParameter(nonContainmentReferenceEClass, "C");
		ETypeParameter nonContainmentReferenceEClass_R = addETypeParameter(nonContainmentReferenceEClass, "R");
		ETypeParameter nonContainmentReferenceEClass_A = addETypeParameter(nonContainmentReferenceEClass, "A");
		ETypeParameter attributeEClass_S = addETypeParameter(attributeEClass, "S");
		ETypeParameter attributeEClass_C = addETypeParameter(attributeEClass, "C");
		ETypeParameter attributeEClass_R = addETypeParameter(attributeEClass, "R");
		ETypeParameter attributeEClass_A = addETypeParameter(attributeEClass, "A");
		ETypeParameter actualAttributeEClass_S = addETypeParameter(actualAttributeEClass, "S");
		ETypeParameter actualAttributeEClass_C = addETypeParameter(actualAttributeEClass, "C");
		ETypeParameter actualAttributeEClass_R = addETypeParameter(actualAttributeEClass, "R");
		ETypeParameter actualAttributeEClass_A = addETypeParameter(actualAttributeEClass, "A");
		ETypeParameter virtualAttributeEClass_S = addETypeParameter(virtualAttributeEClass, "S");
		ETypeParameter virtualAttributeEClass_C = addETypeParameter(virtualAttributeEClass, "C");
		ETypeParameter virtualAttributeEClass_R = addETypeParameter(virtualAttributeEClass, "R");
		ETypeParameter virtualAttributeEClass_A = addETypeParameter(virtualAttributeEClass, "A");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(this.getSection());
		EGenericType g2 = createEGenericType(metaModelElementEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_A);
		g1.getETypeArguments().add(g2);
		metaModelElementEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(metaModelElementEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_A);
		g1.getETypeArguments().add(g2);
		metaModelElementEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(metaModelElementEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_A);
		g1.getETypeArguments().add(g2);
		metaModelElementEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(metaModelElementEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_A);
		g1.getETypeArguments().add(g2);
		metaModelElementEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(this.getSection());
		g2 = createEGenericType(classEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_A);
		g1.getETypeArguments().add(g2);
		classEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(classEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_A);
		g1.getETypeArguments().add(g2);
		classEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(classEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_A);
		g1.getETypeArguments().add(g2);
		classEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(classEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_A);
		g1.getETypeArguments().add(g2);
		classEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(this.getSection());
		g2 = createEGenericType(sectionEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_A);
		g1.getETypeArguments().add(g2);
		sectionEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(sectionEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_A);
		g1.getETypeArguments().add(g2);
		sectionEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(sectionEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_A);
		g1.getETypeArguments().add(g2);
		sectionEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(sectionEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_A);
		g1.getETypeArguments().add(g2);
		sectionEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(this.getSection());
		g2 = createEGenericType(referenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_A);
		g1.getETypeArguments().add(g2);
		referenceEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(referenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_A);
		g1.getETypeArguments().add(g2);
		referenceEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(referenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_A);
		g1.getETypeArguments().add(g2);
		referenceEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(referenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_A);
		g1.getETypeArguments().add(g2);
		referenceEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(this.getSection());
		g2 = createEGenericType(containmentReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		containmentReferenceEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(containmentReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		containmentReferenceEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(containmentReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		containmentReferenceEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(containmentReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		containmentReferenceEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(this.getSection());
		g2 = createEGenericType(nonContainmentReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		nonContainmentReferenceEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(nonContainmentReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		nonContainmentReferenceEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(nonContainmentReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		nonContainmentReferenceEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(nonContainmentReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		nonContainmentReferenceEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(this.getSection());
		g2 = createEGenericType(attributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_A);
		g1.getETypeArguments().add(g2);
		attributeEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(attributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_A);
		g1.getETypeArguments().add(g2);
		attributeEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(attributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_A);
		g1.getETypeArguments().add(g2);
		attributeEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(attributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_A);
		g1.getETypeArguments().add(g2);
		attributeEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(this.getSection());
		g2 = createEGenericType(actualAttributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_A);
		g1.getETypeArguments().add(g2);
		actualAttributeEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(actualAttributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_A);
		g1.getETypeArguments().add(g2);
		actualAttributeEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(actualAttributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_A);
		g1.getETypeArguments().add(g2);
		actualAttributeEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(actualAttributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_A);
		g1.getETypeArguments().add(g2);
		actualAttributeEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(this.getSection());
		g2 = createEGenericType(virtualAttributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_A);
		g1.getETypeArguments().add(g2);
		virtualAttributeEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(virtualAttributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_A);
		g1.getETypeArguments().add(g2);
		virtualAttributeEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(virtualAttributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_A);
		g1.getETypeArguments().add(g2);
		virtualAttributeEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(virtualAttributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_A);
		g1.getETypeArguments().add(g2);
		virtualAttributeEClass_A.getEBounds().add(g1);

		// Add supertypes to classes
		metaModelElementEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		g1 = createEGenericType(this.getMetaModelElement());
		g2 = createEGenericType(classEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_A);
		g1.getETypeArguments().add(g2);
		classEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(sectionEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_A);
		g1.getETypeArguments().add(g2);
		sectionEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSourceSectionClass());
		sourceSectionEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSection());
		g2 = createEGenericType(this.getSourceSection());
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
		g1 = createEGenericType(this.getSection());
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
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(this.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		sourceSectionClassEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getClass_());
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
		g1 = createEGenericType(this.getMetaModelElement());
		g2 = createEGenericType(referenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_A);
		g1.getETypeArguments().add(g2);
		referenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(containmentReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		containmentReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(nonContainmentReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		nonContainmentReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(this.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		sourceSectionReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(this.getTargetSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		targetSectionReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContainmentReference());
		g2 = createEGenericType(this.getTargetSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		targetSectionContainmentReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTargetSectionReference());
		targetSectionContainmentReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getNonContainmentReference());
		g2 = createEGenericType(this.getTargetSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		targetSectionNonContainmentReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTargetSectionReference());
		targetSectionNonContainmentReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContainmentReference());
		g2 = createEGenericType(this.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		sourceSectionContainmentReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSourceSectionReference());
		sourceSectionContainmentReferenceEClass.getEGenericSuperTypes().add(g1);
		metaModelSectionReferenceEClass.getESuperTypes().add(this.getSourceSectionReference());
		g1 = createEGenericType(this.getMetaModelElement());
		g2 = createEGenericType(attributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_A);
		g1.getETypeArguments().add(g2);
		attributeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(actualAttributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_A);
		g1.getETypeArguments().add(g2);
		actualAttributeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(virtualAttributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_A);
		g1.getETypeArguments().add(g2);
		virtualAttributeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(this.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		sourceSectionAttributeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAttribute());
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
		g1 = createEGenericType(this.getActualAttribute());
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
		g1 = createEGenericType(this.getVirtualAttribute());
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
		attributeValueConstraintEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		substringMatcherEClass.getESuperTypes().add(this.getCaseSensitiveConstraint());
		beginningMatcherEClass.getESuperTypes().add(this.getCaseSensitiveConstraint());
		endingMatcherEClass.getESuperTypes().add(this.getCaseSensitiveConstraint());
		regExMatcherEClass.getESuperTypes().add(this.getSingleReferenceAttributeValueConstraint());
		caseSensitiveConstraintEClass.getESuperTypes().add(this.getSingleReferenceAttributeValueConstraint());
		rangeConstraintEClass.getESuperTypes().add(this.getMultipleReferencesAttributeValueConstraint());
		multipleReferencesAttributeValueConstraintEClass.getESuperTypes().add(this.getAttributeValueConstraint());
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
		singleReferenceAttributeValueConstraintEClass.getESuperTypes().add(this.getAttributeValueConstraint());
		singleReferenceAttributeValueConstraintEClass.getESuperTypes().add(theMappingPackage.getExpressionHint());
		singleReferenceAttributeValueConstraintEClass.getESuperTypes().add(theMappingPackage.getModifiableHint());
		attributeValueConstraintSourceInterfaceEClass.getESuperTypes().add(theMappingPackage.getMappingHintSourceInterface());
		g1 = createEGenericType(theMappingPackage.getLocalModifiedAttributeElementType());
		g2 = createEGenericType(this.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		attributeValueConstraintSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAttributeValueConstraintSourceInterface());
		attributeValueConstraintSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theMappingPackage.getExternalModifiedAttributeElementType());
		g2 = createEGenericType(this.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		attributeValueConstraintExternalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAttributeValueConstraintSourceInterface());
		attributeValueConstraintExternalSourceElementEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes, features, and operations; add parameters
		initEClass(metaModelElementEClass, MetaModelElement.class, "MetaModelElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = initEOperation(getMetaModelElement__GetContainingSection(), null, "getContainingSection", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(metaModelElementEClass_S);
		initEOperation(op, g1);

		op = initEOperation(getMetaModelElement__GetContainingSectionModel(), null, "getContainingSectionModel", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(thePamtramPackage.getSectionModel());
		g2 = createEGenericType(metaModelElementEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_A);
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEOperation(getMetaModelElement__IsLibraryEntry(), ecorePackage.getEBoolean(), "isLibraryEntry", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(classEClass, pamtram.metamodel.Class.class, "Class", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClass_EClass(), ecorePackage.getEClass(), null, "eClass", null, 1, 1, pamtram.metamodel.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClass_Cardinality(), this.getCardinalityType(), "cardinality", "ONE", 1, 1, pamtram.metamodel.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(classEClass_R);
		initEReference(getClass_References(), g1, this.getReference_OwningClass(), "references", null, 0, -1, pamtram.metamodel.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(classEClass_C);
		initEReference(getClass_Container(), g1, null, "container", null, 0, 1, pamtram.metamodel.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(classEClass_A);
		initEReference(getClass_Attributes(), g1, this.getAttribute_OwningClass(), "attributes", null, 0, -1, pamtram.metamodel.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getClass__IsContainerFor__Class(), ecorePackage.getEBoolean(), "isContainerFor", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(classEClass_C);
		addEParameter(op, g1, "containedClass", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClass__IsContainedIn__Class(), ecorePackage.getEBoolean(), "isContainedIn", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(classEClass_C);
		addEParameter(op, g1, "containerClass", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClass__GetOwningContainmentReference(), null, "getOwningContainmentReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getContainmentReference());
		g2 = createEGenericType(classEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_A);
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = initEOperation(getClass__IsReferencedBy__Class_EList(), ecorePackage.getEBoolean(), "isReferencedBy", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(classEClass_C);
		addEParameter(op, g1, "referencingClass", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(classEClass_C);
		addEParameter(op, g1, "referencedClasses", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClass__ContainerIsValid__DiagnosticChain_Map_1(), ecorePackage.getEBoolean(), "containerIsValid", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClass__CardinalityIsValid__DiagnosticChain_Map_1(), ecorePackage.getEBoolean(), "cardinalityIsValid", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClass__EClassMatchesParentEReference__DiagnosticChain_Map_1(), ecorePackage.getEBoolean(), "eClassMatchesParentEReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sectionEClass, Section.class, "Section", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSection_Abstract(), ecorePackage.getEBoolean(), "abstract", "false", 1, 1, Section.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(sectionEClass_S);
		initEReference(getSection_Extend(), g1, null, "extend", null, 0, -1, Section.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getSection__ExtendsOnlyValidSections(), ecorePackage.getEBoolean(), "extendsOnlyValidSections", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getSection__ValidateContainerMatchesExtendContainer__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateContainerMatchesExtendContainer", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getSection__ExtendsValidSections__DiagnosticChain_Map_1(), ecorePackage.getEBoolean(), "extendsValidSections", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sourceSectionEClass, SourceSection.class, "SourceSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSourceSection_ReferencingMappings(), theMappingPackage.getMappingType(), null, "referencingMappings", null, 0, -1, SourceSection.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = initEOperation(getSourceSection__IsReferencedByMapping__DiagnosticChain_Map_1(), ecorePackage.getEBoolean(), "isReferencedByMapping", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(targetSectionEClass, TargetSection.class, "TargetSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTargetSection_ReferencingMappingHintGroups(), theMappingPackage.getMappingHintGroupType(), null, "referencingMappingHintGroups", null, 0, -1, TargetSection.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTargetSection_File(), this.getFileAttribute(), null, "file", null, 0, 1, TargetSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getTargetSection__IsReferencedByMappingHintGroup__DiagnosticChain_Map_1(), ecorePackage.getEBoolean(), "isReferencedByMappingHintGroup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
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
		initEReference(getExternalReferenceParameter_Reference(), this.getTargetSectionNonContainmentReference(), null, "reference", null, 1, 1, ExternalReferenceParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(libraryEntryEClass, LibraryEntry.class, "LibraryEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getLibraryParameter());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEReference(getLibraryEntry_Parameters(), g1, null, "parameters", null, 1, -1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLibraryEntry_LibraryFile(), ecorePackage.getEString(), "libraryFile", null, 1, 1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibraryEntry_OriginalLibraryEntry(), theGenLibraryPackage.getLibraryEntry(), null, "originalLibraryEntry", null, 1, 1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibraryEntry_Path(), this.getVirtualTargetSectionAttribute(), null, "path", null, 1, 1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibraryEntry_Id(), this.getVirtualTargetSectionAttribute(), null, "id", null, 1, 1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceEClass, Reference.class, "Reference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReference_EReference(), ecorePackage.getEReference(), null, "eReference", null, 1, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(referenceEClass_C);
		initEReference(getReference_OwningClass(), g1, this.getClass_References(), "owningClass", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getReference__EReferenceMatchesParentEClass__DiagnosticChain_Map_1(), ecorePackage.getEBoolean(), "eReferenceMatchesParentEClass", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(containmentReferenceEClass, ContainmentReference.class, "ContainmentReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(containmentReferenceEClass_C);
		initEReference(getContainmentReference_Value(), g1, null, "value", null, 0, -1, ContainmentReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getContainmentReference__EReferenceIsContainment__DiagnosticChain_Map_1(), ecorePackage.getEBoolean(), "eReferenceIsContainment", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(nonContainmentReferenceEClass, NonContainmentReference.class, "NonContainmentReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(nonContainmentReferenceEClass_C);
		initEReference(getNonContainmentReference_Value(), g1, null, "value", null, 0, -1, NonContainmentReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getNonContainmentReference__EReferenceIsNonContainment__DiagnosticChain_Map_1(), ecorePackage.getEBoolean(), "eReferenceIsNonContainment", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sourceSectionReferenceEClass, SourceSectionReference.class, "SourceSectionReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getSourceSectionReference__GetValuesGeneric(), this.getSourceSectionClass(), "getValuesGeneric", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(targetSectionReferenceEClass, TargetSectionReference.class, "TargetSectionReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getTargetSectionReference__GetValuesGeneric(), this.getTargetSectionClass(), "getValuesGeneric", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(targetSectionContainmentReferenceEClass, TargetSectionContainmentReference.class, "TargetSectionContainmentReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(targetSectionNonContainmentReferenceEClass, TargetSectionNonContainmentReference.class, "TargetSectionNonContainmentReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sourceSectionContainmentReferenceEClass, SourceSectionContainmentReference.class, "SourceSectionContainmentReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(metaModelSectionReferenceEClass, MetaModelSectionReference.class, "MetaModelSectionReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMetaModelSectionReference_Value(), this.getSourceSectionClass(), null, "value", null, 0, -1, MetaModelSectionReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getMetaModelSectionReference__ValuesMatchReferenceType__DiagnosticChain_Map_1(), ecorePackage.getEBoolean(), "valuesMatchReferenceType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(attributeEClass, Attribute.class, "Attribute", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(attributeEClass_C);
		initEReference(getAttribute_OwningClass(), g1, this.getClass_Attributes(), "owningClass", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actualAttributeEClass, ActualAttribute.class, "ActualAttribute", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActualAttribute_Attribute(), ecorePackage.getEAttribute(), null, "attribute", null, 1, 1, ActualAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getActualAttribute__AttributeMatchesParentEClass__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "attributeMatchesParentEClass", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(virtualAttributeEClass, VirtualAttribute.class, "VirtualAttribute", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sourceSectionAttributeEClass, ActualSourceSectionAttribute.class, "SourceSectionAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSourceSectionAttribute_ValueConstraint(), this.getAttributeValueConstraint(), null, "valueConstraint", null, 0, -1, ActualSourceSectionAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSourceSectionAttribute_Attribute(), ecorePackage.getEAttribute(), null, "attribute", null, 1, 1, ActualSourceSectionAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getSourceSectionAttribute__AttributeMatchesParentEClass__DiagnosticChain_Map_1(), ecorePackage.getEBoolean(), "attributeMatchesParentEClass", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(targetSectionAttributeEClass, TargetSectionAttribute.class, "TargetSectionAttribute", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTargetSectionAttribute_Unique(), ecorePackage.getEBoolean(), "unique", "false", 1, 1, TargetSectionAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTargetSectionAttribute_Value(), ecorePackage.getEString(), "value", null, 0, 1, TargetSectionAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actualTargetSectionAttributeEClass, ActualTargetSectionAttribute.class, "ActualTargetSectionAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(virtualTargetSectionAttributeEClass, VirtualTargetSectionAttribute.class, "VirtualTargetSectionAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(equalityMatcherEClass, EqualityMatcher.class, "EqualityMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeValueConstraintEClass, AttributeValueConstraint.class, "AttributeValueConstraint", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttributeValueConstraint_Type(), this.getAttributeValueConstraintType(), "type", "INCLUSION", 1, 1, AttributeValueConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(substringMatcherEClass, SubstringMatcher.class, "SubstringMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(beginningMatcherEClass, BeginningMatcher.class, "BeginningMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(endingMatcherEClass, EndingMatcher.class, "EndingMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(regExMatcherEClass, RegExMatcher.class, "RegExMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(caseSensitiveConstraintEClass, CaseSensitiveConstraint.class, "CaseSensitiveConstraint", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCaseSensitiveConstraint_CaseSensitive(), ecorePackage.getEBoolean(), "caseSensitive", "true", 1, 1, CaseSensitiveConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rangeConstraintEClass, RangeConstraint.class, "RangeConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRangeConstraint_UpperBound(), this.getRangeBound(), null, "upperBound", null, 0, 1, RangeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRangeConstraint_LowerBound(), this.getRangeBound(), null, "lowerBound", null, 0, 1, RangeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multipleReferencesAttributeValueConstraintEClass, MultipleReferencesAttributeValueConstraint.class, "MultipleReferencesAttributeValueConstraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getMultipleReferencesAttributeValueConstraint__CheckConstraint__String_EList(), ecorePackage.getEBoolean(), "checkConstraint", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "attrValue", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "refValue", 1, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(instancePointerEClass, InstancePointer.class, "InstancePointer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstancePointer_AttributePointer(), this.getSourceSectionAttribute(), null, "attributePointer", null, 1, 1, InstancePointer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInstancePointer_Value(), ecorePackage.getEString(), "value", null, 0, 1, InstancePointer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstancePointer_SourceAttributes(), this.getInstancePointerSourceInterface(), null, "sourceAttributes", null, 1, -1, InstancePointer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getInstancePointer__NoModifiedAttributeElementTypesInConditionModelConditions__DiagnosticChain_Map_1(), ecorePackage.getEBoolean(), "noModifiedAttributeElementTypesInConditionModelConditions", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(instancePointerSourceInterfaceEClass, InstancePointerSourceInterface.class, "InstancePointerSourceInterface", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(instancePointerSourceElementEClass, InstancePointerSourceElement.class, "InstancePointerSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(instancePointerExternalSourceElementEClass, InstancePointerExternalSourceElement.class, "InstancePointerExternalSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rangeBoundEClass, RangeBound.class, "RangeBound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRangeBound_BoundType(), this.getAttributeValueConstraintType(), "boundType", null, 0, 1, RangeBound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRangeBound_BoundReferenceValueAdditionalSpecification(), this.getInstancePointer(), null, "boundReferenceValueAdditionalSpecification", null, 0, -1, RangeBound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRangeBound_SourceElements(), this.getAttributeValueConstraintSourceInterface(), null, "sourceElements", null, 0, -1, RangeBound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

		initEClass(singleReferenceAttributeValueConstraintEClass, SingleReferenceAttributeValueConstraint.class, "SingleReferenceAttributeValueConstraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSingleReferenceAttributeValueConstraint_ConstraintReferenceValueAdditionalSpecification(), this.getInstancePointer(), null, "constraintReferenceValueAdditionalSpecification", null, 0, -1, SingleReferenceAttributeValueConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSingleReferenceAttributeValueConstraint_SourceElements(), this.getAttributeValueConstraintSourceInterface(), null, "sourceElements", null, 0, -1, SingleReferenceAttributeValueConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getSingleReferenceAttributeValueConstraint__CheckConstraint__String_String(), ecorePackage.getEBoolean(), "checkConstraint", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "attrValue", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "refValue", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getSingleReferenceAttributeValueConstraint__ValidateOnlyFixedValuesInSourceSections__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateOnlyFixedValuesInSourceSections", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getSingleReferenceAttributeValueConstraint__ValidateOnlyFixedValuesOrGlobalAttributesInConditionModel__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateOnlyFixedValuesOrGlobalAttributesInConditionModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getSingleReferenceAttributeValueConstraint__IsLocalConstraint(), ecorePackage.getEBoolean(), "isLocalConstraint", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(attributeValueConstraintSourceInterfaceEClass, AttributeValueConstraintSourceInterface.class, "AttributeValueConstraintSourceInterface", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeValueConstraintSourceElementEClass, AttributeValueConstraintSourceElement.class, "AttributeValueConstraintSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeValueConstraintExternalSourceElementEClass, AttributeValueConstraintExternalSourceElement.class, "AttributeValueConstraintExternalSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(fileTypeEnumEEnum, FileTypeEnum.class, "FileTypeEnum");
		addEEnumLiteral(fileTypeEnumEEnum, FileTypeEnum.XMI);
		addEEnumLiteral(fileTypeEnumEEnum, FileTypeEnum.XML);

		initEEnum(attributeValueConstraintTypeEEnum, AttributeValueConstraintType.class, "AttributeValueConstraintType");
		addEEnumLiteral(attributeValueConstraintTypeEEnum, AttributeValueConstraintType.INCLUSION);
		addEEnumLiteral(attributeValueConstraintTypeEEnum, AttributeValueConstraintType.EXCLUSION);

		initEEnum(cardinalityTypeEEnum, CardinalityType.class, "CardinalityType");
		addEEnumLiteral(cardinalityTypeEEnum, CardinalityType.ONE);
		addEEnumLiteral(cardinalityTypeEEnum, CardinalityType.ONE_INFINITY);
		addEEnumLiteral(cardinalityTypeEEnum, CardinalityType.ZERO_INFINITY);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
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
		  (this, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (classEClass, 
		   source, 
		   new String[] {
			 "constraints", "eClassMatchesParentEReference variableCardinalityIsValid containerIsValid"
		   });	
		addAnnotation
		  (sectionEClass, 
		   source, 
		   new String[] {
			 "constraints", "extendsValidSections containerMatchesExtendContainer"
		   });	
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
		  (referenceEClass, 
		   source, 
		   new String[] {
			 "constraints", "eReferenceMatchesParentEClass"
		   });	
		addAnnotation
		  (containmentReferenceEClass, 
		   source, 
		   new String[] {
			 "constraints", "eReferenceIsContainment"
		   });	
		addAnnotation
		  (nonContainmentReferenceEClass, 
		   source, 
		   new String[] {
			 "constraints", "eReferenceIsNonContainment"
		   });	
		addAnnotation
		  (metaModelSectionReferenceEClass, 
		   source, 
		   new String[] {
			 "constraints", "valuesMatchReferenceType"
		   });	
		addAnnotation
		  (actualAttributeEClass, 
		   source, 
		   new String[] {
			 "constraints", "attributeMatchesParentEClass"
		   });	
		addAnnotation
		  (sourceSectionAttributeEClass, 
		   source, 
		   new String[] {
			 "constraints", "attributeMatchesParentEClass"
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
		  (singleReferenceAttributeValueConstraintEClass, 
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

} //MetamodelPackageImpl
