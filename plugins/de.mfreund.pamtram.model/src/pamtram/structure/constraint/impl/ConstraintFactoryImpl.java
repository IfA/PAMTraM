/**
 */
package pamtram.structure.constraint.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import pamtram.structure.constraint.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConstraintFactoryImpl extends EFactoryImpl implements ConstraintFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConstraintFactory init() {
		try {
			ConstraintFactory theConstraintFactory = (ConstraintFactory)EPackage.Registry.INSTANCE.getEFactory(ConstraintPackage.eNS_URI);
			if (theConstraintFactory != null) {
				return theConstraintFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ConstraintFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintFactoryImpl() {
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
			case ConstraintPackage.EQUALITY_MATCHER: return createEqualityMatcher();
			case ConstraintPackage.SUBSTRING_MATCHER: return createSubstringMatcher();
			case ConstraintPackage.BEGINNING_MATCHER: return createBeginningMatcher();
			case ConstraintPackage.ENDING_MATCHER: return createEndingMatcher();
			case ConstraintPackage.REG_EX_MATCHER: return createRegExMatcher();
			case ConstraintPackage.RANGE_CONSTRAINT: return createRangeConstraint();
			case ConstraintPackage.VALUE_CONSTRAINT_SOURCE_ELEMENT: return createValueConstraintSourceElement();
			case ConstraintPackage.VALUE_CONSTRAINT_EXTERNAL_SOURCE_ELEMENT: return createValueConstraintExternalSourceElement();
			case ConstraintPackage.RANGE_BOUND: return createRangeBound();
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
			case ConstraintPackage.VALUE_CONSTRAINT_TYPE:
				return createValueConstraintTypeFromString(eDataType, initialValue);
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
			case ConstraintPackage.VALUE_CONSTRAINT_TYPE:
				return convertValueConstraintTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
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
	public RangeBound createRangeBound() {
		RangeBoundImpl rangeBound = new RangeBoundImpl();
		return rangeBound;
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
	public ConstraintPackage getConstraintPackage() {
		return (ConstraintPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ConstraintPackage getPackage() {
		return ConstraintPackage.eINSTANCE;
	}

} //ConstraintFactoryImpl
