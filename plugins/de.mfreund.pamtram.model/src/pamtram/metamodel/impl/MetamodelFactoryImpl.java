/**
 */
package pamtram.metamodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import pamtram.metamodel.ActualTargetSectionAttribute;
import pamtram.metamodel.AttributeParameter;
import pamtram.metamodel.ValueConstraintExternalSourceElement;
import pamtram.metamodel.ValueConstraintSourceElement;
import pamtram.metamodel.ValueConstraintType;
import pamtram.metamodel.BeginningMatcher;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.ContainerParameter;
import pamtram.metamodel.EndingMatcher;
import pamtram.metamodel.EqualityMatcher;
import pamtram.metamodel.ExternalReferenceParameter;
import pamtram.metamodel.FileAttribute;
import pamtram.metamodel.InstancePointer;
import pamtram.metamodel.InstancePointerExternalSourceElement;
import pamtram.metamodel.InstancePointerSourceElement;
import pamtram.metamodel.FileTypeEnum;
import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.MetamodelFactory;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.RangeBound;
import pamtram.metamodel.RangeConstraint;
import pamtram.metamodel.RegExMatcher;
import pamtram.metamodel.ResourceParameter;
import pamtram.metamodel.SourceSection;
import pamtram.metamodel.ActualSourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionContainmentReference;
import pamtram.metamodel.SubstringMatcher;
import pamtram.metamodel.TargetSection;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionContainmentReference;
import pamtram.metamodel.TargetSectionNonContainmentReference;
import pamtram.metamodel.VirtualTargetSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetamodelFactoryImpl extends EFactoryImpl implements MetamodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MetamodelFactory init() {
		try {
			MetamodelFactory theMetamodelFactory = (MetamodelFactory)EPackage.Registry.INSTANCE.getEFactory(MetamodelPackage.eNS_URI);
			if (theMetamodelFactory != null) {
				return theMetamodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MetamodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetamodelFactoryImpl() {
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
			case MetamodelPackage.SOURCE_SECTION: return createSourceSection();
			case MetamodelPackage.TARGET_SECTION: return createTargetSection();
			case MetamodelPackage.FILE_ATTRIBUTE: return createFileAttribute();
			case MetamodelPackage.SOURCE_SECTION_CLASS: return createSourceSectionClass();
			case MetamodelPackage.TARGET_SECTION_CLASS: return createTargetSectionClass();
			case MetamodelPackage.ATTRIBUTE_PARAMETER: return createAttributeParameter();
			case MetamodelPackage.CONTAINER_PARAMETER: return createContainerParameter();
			case MetamodelPackage.EXTERNAL_REFERENCE_PARAMETER: return createExternalReferenceParameter();
			case MetamodelPackage.RESOURCE_PARAMETER: return createResourceParameter();
			case MetamodelPackage.LIBRARY_ENTRY: return createLibraryEntry();
			case MetamodelPackage.TARGET_SECTION_CONTAINMENT_REFERENCE: return createTargetSectionContainmentReference();
			case MetamodelPackage.TARGET_SECTION_NON_CONTAINMENT_REFERENCE: return createTargetSectionNonContainmentReference();
			case MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE: return createSourceSectionContainmentReference();
			case MetamodelPackage.META_MODEL_SECTION_REFERENCE: return createMetaModelSectionReference();
			case MetamodelPackage.ACTUAL_SOURCE_SECTION_ATTRIBUTE: return createActualSourceSectionAttribute();
			case MetamodelPackage.ACTUAL_TARGET_SECTION_ATTRIBUTE: return createActualTargetSectionAttribute();
			case MetamodelPackage.VIRTUAL_TARGET_SECTION_ATTRIBUTE: return createVirtualTargetSectionAttribute();
			case MetamodelPackage.EQUALITY_MATCHER: return createEqualityMatcher();
			case MetamodelPackage.SUBSTRING_MATCHER: return createSubstringMatcher();
			case MetamodelPackage.BEGINNING_MATCHER: return createBeginningMatcher();
			case MetamodelPackage.ENDING_MATCHER: return createEndingMatcher();
			case MetamodelPackage.REG_EX_MATCHER: return createRegExMatcher();
			case MetamodelPackage.RANGE_CONSTRAINT: return createRangeConstraint();
			case MetamodelPackage.INSTANCE_POINTER: return createInstancePointer();
			case MetamodelPackage.INSTANCE_POINTER_SOURCE_ELEMENT: return createInstancePointerSourceElement();
			case MetamodelPackage.INSTANCE_POINTER_EXTERNAL_SOURCE_ELEMENT: return createInstancePointerExternalSourceElement();
			case MetamodelPackage.RANGE_BOUND: return createRangeBound();
			case MetamodelPackage.VALUE_CONSTRAINT_SOURCE_ELEMENT: return createValueConstraintSourceElement();
			case MetamodelPackage.VALUE_CONSTRAINT_EXTERNAL_SOURCE_ELEMENT: return createValueConstraintExternalSourceElement();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case MetamodelPackage.FILE_TYPE_ENUM:
				return createFileTypeEnumFromString(eDataType, initialValue);
			case MetamodelPackage.VALUE_CONSTRAINT_TYPE:
				return createValueConstraintTypeFromString(eDataType, initialValue);
			case MetamodelPackage.CARDINALITY_TYPE:
				return createCardinalityTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case MetamodelPackage.FILE_TYPE_ENUM:
				return convertFileTypeEnumToString(eDataType, instanceValue);
			case MetamodelPackage.VALUE_CONSTRAINT_TYPE:
				return convertValueConstraintTypeToString(eDataType, instanceValue);
			case MetamodelPackage.CARDINALITY_TYPE:
				return convertCardinalityTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
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
	public TargetSection createTargetSection() {
		TargetSectionImpl targetSection = new TargetSectionImpl();
		return targetSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileAttribute createFileAttribute() {
		FileAttributeImpl fileAttribute = new FileAttributeImpl();
		return fileAttribute;
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
	public TargetSectionClass createTargetSectionClass() {
		TargetSectionClassImpl targetSectionClass = new TargetSectionClassImpl();
		return targetSectionClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeParameter createAttributeParameter() {
		AttributeParameterImpl attributeParameter = new AttributeParameterImpl();
		return attributeParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainerParameter createContainerParameter() {
		ContainerParameterImpl containerParameter = new ContainerParameterImpl();
		return containerParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalReferenceParameter createExternalReferenceParameter() {
		ExternalReferenceParameterImpl externalReferenceParameter = new ExternalReferenceParameterImpl();
		return externalReferenceParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceParameter createResourceParameter() {
		ResourceParameterImpl resourceParameter = new ResourceParameterImpl();
		return resourceParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibraryEntry createLibraryEntry() {
		LibraryEntryImpl libraryEntry = new LibraryEntryImpl();
		return libraryEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionContainmentReference createTargetSectionContainmentReference() {
		TargetSectionContainmentReferenceImpl targetSectionContainmentReference = new TargetSectionContainmentReferenceImpl();
		return targetSectionContainmentReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionNonContainmentReference createTargetSectionNonContainmentReference() {
		TargetSectionNonContainmentReferenceImpl targetSectionNonContainmentReference = new TargetSectionNonContainmentReferenceImpl();
		return targetSectionNonContainmentReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionContainmentReference createSourceSectionContainmentReference() {
		SourceSectionContainmentReferenceImpl sourceSectionContainmentReference = new SourceSectionContainmentReferenceImpl();
		return sourceSectionContainmentReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaModelSectionReference createMetaModelSectionReference() {
		MetaModelSectionReferenceImpl metaModelSectionReference = new MetaModelSectionReferenceImpl();
		return metaModelSectionReference;
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
	public ActualTargetSectionAttribute createActualTargetSectionAttribute() {
		ActualTargetSectionAttributeImpl actualTargetSectionAttribute = new ActualTargetSectionAttributeImpl();
		return actualTargetSectionAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualTargetSectionAttribute createVirtualTargetSectionAttribute() {
		VirtualTargetSectionAttributeImpl virtualTargetSectionAttribute = new VirtualTargetSectionAttributeImpl();
		return virtualTargetSectionAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EqualityMatcher createEqualityMatcher() {
		EqualityMatcherImpl equalityMatcher = new EqualityMatcherImpl();
		return equalityMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubstringMatcher createSubstringMatcher() {
		SubstringMatcherImpl substringMatcher = new SubstringMatcherImpl();
		return substringMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BeginningMatcher createBeginningMatcher() {
		BeginningMatcherImpl beginningMatcher = new BeginningMatcherImpl();
		return beginningMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndingMatcher createEndingMatcher() {
		EndingMatcherImpl endingMatcher = new EndingMatcherImpl();
		return endingMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegExMatcher createRegExMatcher() {
		RegExMatcherImpl regExMatcher = new RegExMatcherImpl();
		return regExMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RangeConstraint createRangeConstraint() {
		RangeConstraintImpl rangeConstraint = new RangeConstraintImpl();
		return rangeConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstancePointer createInstancePointer() {
		InstancePointerImpl instancePointer = new InstancePointerImpl();
		return instancePointer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstancePointerSourceElement createInstancePointerSourceElement() {
		InstancePointerSourceElementImpl instancePointerSourceElement = new InstancePointerSourceElementImpl();
		return instancePointerSourceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstancePointerExternalSourceElement createInstancePointerExternalSourceElement() {
		InstancePointerExternalSourceElementImpl instancePointerExternalSourceElement = new InstancePointerExternalSourceElementImpl();
		return instancePointerExternalSourceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RangeBound createRangeBound() {
		RangeBoundImpl rangeBound = new RangeBoundImpl();
		return rangeBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueConstraintSourceElement createValueConstraintSourceElement() {
		ValueConstraintSourceElementImpl valueConstraintSourceElement = new ValueConstraintSourceElementImpl();
		return valueConstraintSourceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueConstraintExternalSourceElement createValueConstraintExternalSourceElement() {
		ValueConstraintExternalSourceElementImpl valueConstraintExternalSourceElement = new ValueConstraintExternalSourceElementImpl();
		return valueConstraintExternalSourceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileTypeEnum createFileTypeEnumFromString(EDataType eDataType, String initialValue) {
		FileTypeEnum result = FileTypeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFileTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueConstraintType createValueConstraintTypeFromString(EDataType eDataType, String initialValue) {
		ValueConstraintType result = ValueConstraintType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertValueConstraintTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CardinalityType createCardinalityTypeFromString(EDataType eDataType, String initialValue) {
		CardinalityType result = CardinalityType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCardinalityTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetamodelPackage getMetamodelPackage() {
		return (MetamodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MetamodelPackage getPackage() {
		return MetamodelPackage.eINSTANCE;
	}

} //MetamodelFactoryImpl
