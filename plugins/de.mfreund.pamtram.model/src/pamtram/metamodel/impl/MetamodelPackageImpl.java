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
import pamtram.metamodel.Attribute;
import pamtram.metamodel.AttributeParameter;
import pamtram.metamodel.AttributeValueConstraint;
import pamtram.metamodel.AttributeValueConstraintType;
import pamtram.metamodel.BeginningMatcher;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.CaseSensitiveConstraint;
import pamtram.metamodel.ContainerParameter;
import pamtram.metamodel.ContainmentReference;
import pamtram.metamodel.EndingMatcher;
import pamtram.metamodel.EqualityMatcher;
import pamtram.metamodel.ExternalReferenceParameter;
import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.LibraryParameter;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.MetamodelFactory;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.NonContainmentReference;
import pamtram.metamodel.Reference;
import pamtram.metamodel.RegExMatcher;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionContainmentReference;
import pamtram.metamodel.SourceSectionReference;
import pamtram.metamodel.SubstringMatcher;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionContainmentReference;
import pamtram.metamodel.TargetSectionNonContainmentReference;
import pamtram.metamodel.TargetSectionReference;
import pamtram.metamodel.VirtualAttribute;
import pamtram.metamodel.util.MetamodelValidator;
import pamtram.transformation.TransformationPackage;
import pamtram.transformation.impl.TransformationPackageImpl;

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
		TransformationPackageImpl theTransformationPackage = (TransformationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TransformationPackage.eNS_URI) instanceof TransformationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TransformationPackage.eNS_URI) : TransformationPackage.eINSTANCE);
		MappingPackageImpl theMappingPackage = (MappingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) instanceof MappingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) : MappingPackage.eINSTANCE);

		// Create package meta-data objects
		theMetamodelPackage.createPackageContents();
		thePamtramPackage.createPackageContents();
		theConditionPackage.createPackageContents();
		theTransformationPackage.createPackageContents();
		theMappingPackage.createPackageContents();

		// Initialize created meta-data
		theMetamodelPackage.initializePackageContents();
		thePamtramPackage.initializePackageContents();
		theConditionPackage.initializePackageContents();
		theTransformationPackage.initializePackageContents();
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
	public EOperation getClass__IsSection() {
		return classEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsContainedIn__Class() {
		return classEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__GetOwningContainmentReference() {
		return classEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsReferencedBy__Class_EList() {
		return classEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__ContainerIsValid__DiagnosticChain_Map() {
		return classEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__CardinalityIsValid__DiagnosticChain_Map() {
		return classEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__EClassMatchesParentEReference__DiagnosticChain_Map() {
		return classEClass.getEOperations().get(7);
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
	public EReference getSourceSectionClass_ReferencingMappings() {
		return (EReference)sourceSectionClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSourceSectionClass__IsReferencedByMapping__DiagnosticChain_Map() {
		return sourceSectionClassEClass.getEOperations().get(0);
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
	public EReference getTargetSectionClass_ReferencingMappingHintGroups() {
		return (EReference)targetSectionClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTargetSectionClass__IsReferencedByMappingHintGroup__DiagnosticChain_Map() {
		return targetSectionClassEClass.getEOperations().get(0);
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
	public EOperation getReference__EReferenceMatchesParentEClass__DiagnosticChain_Map() {
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
	public EOperation getContainmentReference__EReferenceIsContainment__DiagnosticChain_Map() {
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
	public EOperation getNonContainmentReference__EReferenceIsNonContainment__DiagnosticChain_Map() {
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
	public EOperation getMetaModelSectionReference__ValuesMatchReferenceType__DiagnosticChain_Map() {
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
	public EClass getSourceSectionAttribute() {
		return sourceSectionAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSourceSectionAttribute_Attribute() {
		return (EReference)sourceSectionAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSourceSectionAttribute_ValueConstraint() {
		return (EReference)sourceSectionAttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSourceSectionAttribute__AttributeMatchesParentEClass__DiagnosticChain_Map() {
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
	public EAttribute getAttributeValueConstraint_Value() {
		return (EAttribute)attributeValueConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttributeValueConstraint__CheckConstraint__String() {
		return attributeValueConstraintEClass.getEOperations().get(0);
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
		createEOperation(classEClass, CLASS___IS_SECTION);
		createEOperation(classEClass, CLASS___IS_CONTAINED_IN__CLASS);
		createEOperation(classEClass, CLASS___GET_OWNING_CONTAINMENT_REFERENCE);
		createEOperation(classEClass, CLASS___IS_REFERENCED_BY__CLASS_ELIST);
		createEOperation(classEClass, CLASS___CONTAINER_IS_VALID__DIAGNOSTICCHAIN_MAP);
		createEOperation(classEClass, CLASS___CARDINALITY_IS_VALID__DIAGNOSTICCHAIN_MAP);
		createEOperation(classEClass, CLASS___ECLASS_MATCHES_PARENT_EREFERENCE__DIAGNOSTICCHAIN_MAP);

		sourceSectionClassEClass = createEClass(SOURCE_SECTION_CLASS);
		createEReference(sourceSectionClassEClass, SOURCE_SECTION_CLASS__REFERENCING_MAPPINGS);
		createEOperation(sourceSectionClassEClass, SOURCE_SECTION_CLASS___IS_REFERENCED_BY_MAPPING__DIAGNOSTICCHAIN_MAP);

		targetSectionClassEClass = createEClass(TARGET_SECTION_CLASS);
		createEReference(targetSectionClassEClass, TARGET_SECTION_CLASS__REFERENCING_MAPPING_HINT_GROUPS);
		createEOperation(targetSectionClassEClass, TARGET_SECTION_CLASS___IS_REFERENCED_BY_MAPPING_HINT_GROUP__DIAGNOSTICCHAIN_MAP);

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

		referenceEClass = createEClass(REFERENCE);
		createEReference(referenceEClass, REFERENCE__EREFERENCE);
		createEReference(referenceEClass, REFERENCE__OWNING_CLASS);
		createEOperation(referenceEClass, REFERENCE___EREFERENCE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP);

		containmentReferenceEClass = createEClass(CONTAINMENT_REFERENCE);
		createEReference(containmentReferenceEClass, CONTAINMENT_REFERENCE__VALUE);
		createEOperation(containmentReferenceEClass, CONTAINMENT_REFERENCE___EREFERENCE_IS_CONTAINMENT__DIAGNOSTICCHAIN_MAP);

		nonContainmentReferenceEClass = createEClass(NON_CONTAINMENT_REFERENCE);
		createEReference(nonContainmentReferenceEClass, NON_CONTAINMENT_REFERENCE__VALUE);
		createEOperation(nonContainmentReferenceEClass, NON_CONTAINMENT_REFERENCE___EREFERENCE_IS_NON_CONTAINMENT__DIAGNOSTICCHAIN_MAP);

		sourceSectionReferenceEClass = createEClass(SOURCE_SECTION_REFERENCE);
		createEOperation(sourceSectionReferenceEClass, SOURCE_SECTION_REFERENCE___GET_VALUES_GENERIC);

		targetSectionReferenceEClass = createEClass(TARGET_SECTION_REFERENCE);
		createEOperation(targetSectionReferenceEClass, TARGET_SECTION_REFERENCE___GET_VALUES_GENERIC);

		targetSectionContainmentReferenceEClass = createEClass(TARGET_SECTION_CONTAINMENT_REFERENCE);

		targetSectionNonContainmentReferenceEClass = createEClass(TARGET_SECTION_NON_CONTAINMENT_REFERENCE);

		sourceSectionContainmentReferenceEClass = createEClass(SOURCE_SECTION_CONTAINMENT_REFERENCE);

		metaModelSectionReferenceEClass = createEClass(META_MODEL_SECTION_REFERENCE);
		createEReference(metaModelSectionReferenceEClass, META_MODEL_SECTION_REFERENCE__VALUE);
		createEOperation(metaModelSectionReferenceEClass, META_MODEL_SECTION_REFERENCE___VALUES_MATCH_REFERENCE_TYPE__DIAGNOSTICCHAIN_MAP);

		attributeEClass = createEClass(ATTRIBUTE);
		createEReference(attributeEClass, ATTRIBUTE__OWNING_CLASS);

		sourceSectionAttributeEClass = createEClass(SOURCE_SECTION_ATTRIBUTE);
		createEReference(sourceSectionAttributeEClass, SOURCE_SECTION_ATTRIBUTE__ATTRIBUTE);
		createEReference(sourceSectionAttributeEClass, SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINT);
		createEOperation(sourceSectionAttributeEClass, SOURCE_SECTION_ATTRIBUTE___ATTRIBUTE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP);

		targetSectionAttributeEClass = createEClass(TARGET_SECTION_ATTRIBUTE);
		createEAttribute(targetSectionAttributeEClass, TARGET_SECTION_ATTRIBUTE__UNIQUE);
		createEAttribute(targetSectionAttributeEClass, TARGET_SECTION_ATTRIBUTE__VALUE);

		actualAttributeEClass = createEClass(ACTUAL_ATTRIBUTE);
		createEReference(actualAttributeEClass, ACTUAL_ATTRIBUTE__ATTRIBUTE);
		createEOperation(actualAttributeEClass, ACTUAL_ATTRIBUTE___ATTRIBUTE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP);

		virtualAttributeEClass = createEClass(VIRTUAL_ATTRIBUTE);

		equalityMatcherEClass = createEClass(EQUALITY_MATCHER);

		attributeValueConstraintEClass = createEClass(ATTRIBUTE_VALUE_CONSTRAINT);
		createEAttribute(attributeValueConstraintEClass, ATTRIBUTE_VALUE_CONSTRAINT__TYPE);
		createEAttribute(attributeValueConstraintEClass, ATTRIBUTE_VALUE_CONSTRAINT__VALUE);
		createEOperation(attributeValueConstraintEClass, ATTRIBUTE_VALUE_CONSTRAINT___CHECK_CONSTRAINT__STRING);

		substringMatcherEClass = createEClass(SUBSTRING_MATCHER);

		beginningMatcherEClass = createEClass(BEGINNING_MATCHER);

		endingMatcherEClass = createEClass(ENDING_MATCHER);

		regExMatcherEClass = createEClass(REG_EX_MATCHER);

		caseSensitiveConstraintEClass = createEClass(CASE_SENSITIVE_CONSTRAINT);
		createEAttribute(caseSensitiveConstraintEClass, CASE_SENSITIVE_CONSTRAINT__CASE_SENSITIVE);

		// Create enums
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
		ETypeParameter metaModelElementEClass_C = addETypeParameter(metaModelElementEClass, "C");
		ETypeParameter metaModelElementEClass_R = addETypeParameter(metaModelElementEClass, "R");
		ETypeParameter metaModelElementEClass_A = addETypeParameter(metaModelElementEClass, "A");
		ETypeParameter classEClass_C = addETypeParameter(classEClass, "C");
		ETypeParameter classEClass_R = addETypeParameter(classEClass, "R");
		ETypeParameter classEClass_A = addETypeParameter(classEClass, "A");
		ETypeParameter libraryParameterEClass_ParameterType = addETypeParameter(libraryParameterEClass, "ParameterType");
		ETypeParameter referenceEClass_C = addETypeParameter(referenceEClass, "C");
		ETypeParameter referenceEClass_R = addETypeParameter(referenceEClass, "R");
		ETypeParameter referenceEClass_A = addETypeParameter(referenceEClass, "A");
		ETypeParameter containmentReferenceEClass_C = addETypeParameter(containmentReferenceEClass, "C");
		ETypeParameter containmentReferenceEClass_R = addETypeParameter(containmentReferenceEClass, "R");
		ETypeParameter containmentReferenceEClass_A = addETypeParameter(containmentReferenceEClass, "A");
		ETypeParameter nonContainmentReferenceEClass_C = addETypeParameter(nonContainmentReferenceEClass, "C");
		ETypeParameter nonContainmentReferenceEClass_R = addETypeParameter(nonContainmentReferenceEClass, "R");
		ETypeParameter nonContainmentReferenceEClass_A = addETypeParameter(nonContainmentReferenceEClass, "A");
		ETypeParameter attributeEClass_C = addETypeParameter(attributeEClass, "C");
		ETypeParameter attributeEClass_R = addETypeParameter(attributeEClass, "R");
		ETypeParameter attributeEClass_A = addETypeParameter(attributeEClass, "A");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(this.getClass_());
		EGenericType g2 = createEGenericType(metaModelElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_A);
		g1.getETypeArguments().add(g2);
		metaModelElementEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(metaModelElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_A);
		g1.getETypeArguments().add(g2);
		metaModelElementEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(metaModelElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_A);
		g1.getETypeArguments().add(g2);
		metaModelElementEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(classEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_A);
		g1.getETypeArguments().add(g2);
		classEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(classEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_A);
		g1.getETypeArguments().add(g2);
		classEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(classEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_A);
		g1.getETypeArguments().add(g2);
		classEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(referenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_A);
		g1.getETypeArguments().add(g2);
		referenceEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(referenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_A);
		g1.getETypeArguments().add(g2);
		referenceEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(referenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_A);
		g1.getETypeArguments().add(g2);
		referenceEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(containmentReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		containmentReferenceEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(containmentReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		containmentReferenceEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(containmentReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		containmentReferenceEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(nonContainmentReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		nonContainmentReferenceEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(nonContainmentReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		nonContainmentReferenceEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(nonContainmentReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		nonContainmentReferenceEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(attributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_A);
		g1.getETypeArguments().add(g2);
		attributeEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(attributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_A);
		g1.getETypeArguments().add(g2);
		attributeEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(attributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_A);
		g1.getETypeArguments().add(g2);
		attributeEClass_A.getEBounds().add(g1);

		// Add supertypes to classes
		metaModelElementEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		g1 = createEGenericType(this.getMetaModelElement());
		g2 = createEGenericType(classEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_A);
		g1.getETypeArguments().add(g2);
		classEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		sourceSectionClassEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getClass_());
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
		g2 = createEGenericType(referenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_A);
		g1.getETypeArguments().add(g2);
		referenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(containmentReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		containmentReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(nonContainmentReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		nonContainmentReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		sourceSectionReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(this.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		targetSectionReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContainmentReference());
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
		g2 = createEGenericType(attributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_A);
		g1.getETypeArguments().add(g2);
		attributeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		sourceSectionAttributeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(this.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		targetSectionAttributeEClass.getEGenericSuperTypes().add(g1);
		actualAttributeEClass.getESuperTypes().add(this.getTargetSectionAttribute());
		virtualAttributeEClass.getESuperTypes().add(this.getTargetSectionAttribute());
		equalityMatcherEClass.getESuperTypes().add(this.getCaseSensitiveConstraint());
		attributeValueConstraintEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		substringMatcherEClass.getESuperTypes().add(this.getCaseSensitiveConstraint());
		beginningMatcherEClass.getESuperTypes().add(this.getCaseSensitiveConstraint());
		endingMatcherEClass.getESuperTypes().add(this.getCaseSensitiveConstraint());
		regExMatcherEClass.getESuperTypes().add(this.getAttributeValueConstraint());
		caseSensitiveConstraintEClass.getESuperTypes().add(this.getAttributeValueConstraint());

		// Initialize classes, features, and operations; add parameters
		initEClass(metaModelElementEClass, MetaModelElement.class, "MetaModelElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = initEOperation(getMetaModelElement__GetContainingSection(), null, "getContainingSection", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(metaModelElementEClass_C);
		initEOperation(op, g1);

		op = initEOperation(getMetaModelElement__GetContainingSectionModel(), null, "getContainingSectionModel", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(thePamtramPackage.getSectionModel());
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

		initEOperation(getClass__IsSection(), ecorePackage.getEBoolean(), "isSection", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClass__IsContainedIn__Class(), ecorePackage.getEBoolean(), "isContainedIn", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(classEClass_C);
		addEParameter(op, g1, "containerClass", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClass__GetOwningContainmentReference(), null, "getOwningContainmentReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getContainmentReference());
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

		op = initEOperation(getClass__ContainerIsValid__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "containerIsValid", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClass__CardinalityIsValid__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "cardinalityIsValid", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClass__EClassMatchesParentEReference__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "eClassMatchesParentEReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sourceSectionClassEClass, SourceSectionClass.class, "SourceSectionClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSourceSectionClass_ReferencingMappings(), theMappingPackage.getMappingType(), null, "referencingMappings", null, 0, -1, SourceSectionClass.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = initEOperation(getSourceSectionClass__IsReferencedByMapping__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "isReferencedByMapping", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(targetSectionClassEClass, TargetSectionClass.class, "TargetSectionClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTargetSectionClass_ReferencingMappingHintGroups(), theMappingPackage.getMappingHintGroupType(), null, "referencingMappingHintGroups", null, 0, -1, TargetSectionClass.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = initEOperation(getTargetSectionClass__IsReferencedByMappingHintGroup__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "isReferencedByMappingHintGroup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(libraryParameterEClass, LibraryParameter.class, "LibraryParameter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLibraryParameter_Source(), ecorePackage.getEObject(), null, "source", null, 1, 1, LibraryParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(libraryParameterEClass_ParameterType);
		initEReference(getLibraryParameter_OriginalParameter(), g1, null, "originalParameter", null, 1, 1, LibraryParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeParameterEClass, AttributeParameter.class, "AttributeParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeParameter_Attribute(), this.getActualAttribute(), null, "attribute", null, 1, 1, AttributeParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(containerParameterEClass, ContainerParameter.class, "ContainerParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContainerParameter_Class(), this.getTargetSectionClass(), null, "class", null, 1, 1, ContainerParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(externalReferenceParameterEClass, ExternalReferenceParameter.class, "ExternalReferenceParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExternalReferenceParameter_Reference(), this.getTargetSectionNonContainmentReference(), null, "reference", null, 1, 1, ExternalReferenceParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(libraryEntryEClass, LibraryEntry.class, "LibraryEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getLibraryParameter());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEReference(getLibraryEntry_Parameters(), g1, null, "parameters", null, 1, -1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLibraryEntry_LibraryFile(), ecorePackage.getEString(), "libraryFile", null, 1, 1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibraryEntry_OriginalLibraryEntry(), theGenLibraryPackage.getLibraryEntry(), null, "originalLibraryEntry", null, 1, 1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibraryEntry_Path(), this.getVirtualAttribute(), null, "path", null, 1, 1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceEClass, Reference.class, "Reference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReference_EReference(), ecorePackage.getEReference(), null, "eReference", null, 1, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(referenceEClass_C);
		initEReference(getReference_OwningClass(), g1, this.getClass_References(), "owningClass", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getReference__EReferenceMatchesParentEClass__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "eReferenceMatchesParentEClass", 0, 1, IS_UNIQUE, IS_ORDERED);
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

		op = initEOperation(getContainmentReference__EReferenceIsContainment__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "eReferenceIsContainment", 0, 1, IS_UNIQUE, IS_ORDERED);
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

		op = initEOperation(getNonContainmentReference__EReferenceIsNonContainment__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "eReferenceIsNonContainment", 0, 1, IS_UNIQUE, IS_ORDERED);
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

		op = initEOperation(getMetaModelSectionReference__ValuesMatchReferenceType__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "valuesMatchReferenceType", 0, 1, IS_UNIQUE, IS_ORDERED);
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

		initEClass(sourceSectionAttributeEClass, SourceSectionAttribute.class, "SourceSectionAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSourceSectionAttribute_Attribute(), ecorePackage.getEAttribute(), null, "attribute", null, 1, 1, SourceSectionAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSourceSectionAttribute_ValueConstraint(), this.getAttributeValueConstraint(), null, "valueConstraint", null, 0, -1, SourceSectionAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getSourceSectionAttribute__AttributeMatchesParentEClass__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "attributeMatchesParentEClass", 0, 1, IS_UNIQUE, IS_ORDERED);
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

		initEClass(actualAttributeEClass, ActualAttribute.class, "ActualAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActualAttribute_Attribute(), ecorePackage.getEAttribute(), null, "attribute", null, 1, 1, ActualAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getActualAttribute__AttributeMatchesParentEClass__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "attributeMatchesParentEClass", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(virtualAttributeEClass, VirtualAttribute.class, "VirtualAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(equalityMatcherEClass, EqualityMatcher.class, "EqualityMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeValueConstraintEClass, AttributeValueConstraint.class, "AttributeValueConstraint", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttributeValueConstraint_Type(), this.getAttributeValueConstraintType(), "type", "INCLUSION", 1, 1, AttributeValueConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributeValueConstraint_Value(), ecorePackage.getEString(), "value", null, 1, 1, AttributeValueConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getAttributeValueConstraint__CheckConstraint__String(), ecorePackage.getEBoolean(), "checkConstraint", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "attrValue", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(substringMatcherEClass, SubstringMatcher.class, "SubstringMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(beginningMatcherEClass, BeginningMatcher.class, "BeginningMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(endingMatcherEClass, EndingMatcher.class, "EndingMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(regExMatcherEClass, RegExMatcher.class, "RegExMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(caseSensitiveConstraintEClass, CaseSensitiveConstraint.class, "CaseSensitiveConstraint", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCaseSensitiveConstraint_CaseSensitive(), ecorePackage.getEBoolean(), "caseSensitive", "true", 1, 1, CaseSensitiveConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
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
		  (sourceSectionClassEClass, 
		   source, 
		   new String[] {
			 "constraints", "isReferencedByMapping"
		   });	
		addAnnotation
		  (targetSectionClassEClass, 
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
		  (sourceSectionAttributeEClass, 
		   source, 
		   new String[] {
			 "constraints", "attributeMatchesParentEClass"
		   });	
		addAnnotation
		  (actualAttributeEClass, 
		   source, 
		   new String[] {
			 "constraints", "attributeMatchesParentEClass"
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
