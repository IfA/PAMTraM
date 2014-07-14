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
import pamtram.metamodel.AttributeValueConstraintType;
import pamtram.metamodel.AttributeValueSpecification;
import pamtram.metamodel.BeginningMatcher;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.ContainmentReference;
import pamtram.metamodel.EndingMatcher;
import pamtram.metamodel.EqualityMatcher;
import pamtram.metamodel.MetamodelFactory;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.NonContainmentReference;
import pamtram.metamodel.RegExMatcher;
import pamtram.metamodel.SubstringMatcher;
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
			case MetamodelPackage.CLASS: return createClass();
			case MetamodelPackage.CONTAINMENT_REFERENCE: return createContainmentReference();
			case MetamodelPackage.NON_CONTAINMENT_REFERENCE: return createNonContainmentReference();
			case MetamodelPackage.ACTUAL_ATTRIBUTE: return createActualAttribute();
			case MetamodelPackage.VIRTUAL_ATTRIBUTE: return createVirtualAttribute();
			case MetamodelPackage.ATTRIBUTE_VALUE_SPECIFICATION: return createAttributeValueSpecification();
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
	public pamtram.metamodel.Class createClass() {
		ClassImpl class_ = new ClassImpl();
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainmentReference createContainmentReference() {
		ContainmentReferenceImpl containmentReference = new ContainmentReferenceImpl();
		return containmentReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NonContainmentReference createNonContainmentReference() {
		NonContainmentReferenceImpl nonContainmentReference = new NonContainmentReferenceImpl();
		return nonContainmentReference;
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
	public AttributeValueSpecification createAttributeValueSpecification() {
		AttributeValueSpecificationImpl attributeValueSpecification = new AttributeValueSpecificationImpl();
		return attributeValueSpecification;
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
