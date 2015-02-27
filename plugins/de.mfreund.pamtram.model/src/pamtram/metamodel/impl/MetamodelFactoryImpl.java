/**
 */
package pamtram.metamodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import pamtram.metamodel.ActualAttribute;
import pamtram.metamodel.AttributeParameter;
import pamtram.metamodel.AttributeValueConstraintType;
import pamtram.metamodel.BeginningMatcher;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.ContainerParameter;
import pamtram.metamodel.EndingMatcher;
import pamtram.metamodel.EqualityMatcher;
import pamtram.metamodel.ExternalReferenceParameter;
import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.MetamodelFactory;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.RegExMatcher;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionContainmentReference;
import pamtram.metamodel.SubstringMatcher;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionContainmentReference;
import pamtram.metamodel.TargetSectionNonContainmentReference;
import pamtram.metamodel.VirtualAttribute;

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
			case MetamodelPackage.SOURCE_SECTION_CLASS: return createSourceSectionClass();
			case MetamodelPackage.TARGET_SECTION_CLASS: return createTargetSectionClass();
			case MetamodelPackage.ATTRIBUTE_PARAMETER: return createAttributeParameter();
			case MetamodelPackage.CONTAINER_PARAMETER: return createContainerParameter();
			case MetamodelPackage.EXTERNAL_REFERENCE_PARAMETER: return createExternalReferenceParameter();
			case MetamodelPackage.LIBRARY_ENTRY: return createLibraryEntry();
			case MetamodelPackage.TARGET_SECTION_CONTAINMENT_REFERENCE: return createTargetSectionContainmentReference();
			case MetamodelPackage.TARGET_SECTION_NON_CONTAINMENT_REFERENCE: return createTargetSectionNonContainmentReference();
			case MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE: return createSourceSectionContainmentReference();
			case MetamodelPackage.META_MODEL_SECTION_REFERENCE: return createMetaModelSectionReference();
			case MetamodelPackage.SOURCE_SECTION_ATTRIBUTE: return createSourceSectionAttribute();
			case MetamodelPackage.ACTUAL_ATTRIBUTE: return createActualAttribute();
			case MetamodelPackage.VIRTUAL_ATTRIBUTE: return createVirtualAttribute();
			case MetamodelPackage.EQUALITY_MATCHER: return createEqualityMatcher();
			case MetamodelPackage.SUBSTRING_MATCHER: return createSubstringMatcher();
			case MetamodelPackage.BEGINNING_MATCHER: return createBeginningMatcher();
			case MetamodelPackage.ENDING_MATCHER: return createEndingMatcher();
			case MetamodelPackage.REG_EX_MATCHER: return createRegExMatcher();
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
			case MetamodelPackage.ATTRIBUTE_VALUE_CONSTRAINT_TYPE:
				return createAttributeValueConstraintTypeFromString(eDataType, initialValue);
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
			case MetamodelPackage.ATTRIBUTE_VALUE_CONSTRAINT_TYPE:
				return convertAttributeValueConstraintTypeToString(eDataType, instanceValue);
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
	public SourceSectionAttribute createSourceSectionAttribute() {
		SourceSectionAttributeImpl sourceSectionAttribute = new SourceSectionAttributeImpl();
		return sourceSectionAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActualAttribute createActualAttribute() {
		ActualAttributeImpl actualAttribute = new ActualAttributeImpl();
		return actualAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualAttribute createVirtualAttribute() {
		VirtualAttributeImpl virtualAttribute = new VirtualAttributeImpl();
		return virtualAttribute;
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
	public AttributeValueConstraintType createAttributeValueConstraintTypeFromString(EDataType eDataType, String initialValue) {
		AttributeValueConstraintType result = AttributeValueConstraintType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAttributeValueConstraintTypeToString(EDataType eDataType, Object instanceValue) {
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
