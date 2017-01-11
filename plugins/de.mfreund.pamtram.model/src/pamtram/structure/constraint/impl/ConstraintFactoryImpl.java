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
			case ConstraintPackage.EQUALITY_CONSTRAINT: return createEqualityConstraint();
			case ConstraintPackage.SUBSTRING_CONSTRAINT: return createSubstringConstraint();
			case ConstraintPackage.BEGINNING_CONSTRAINT: return createBeginningConstraint();
			case ConstraintPackage.ENDING_CONSTRAINT: return createEndingConstraint();
			case ConstraintPackage.REG_EX_CONSTRAINT: return createRegExConstraint();
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
	public EqualityConstraint createEqualityConstraint() {
		EqualityConstraintImpl equalityConstraint = new EqualityConstraintImpl();
		return equalityConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubstringConstraint createSubstringConstraint() {
		SubstringConstraintImpl substringConstraint = new SubstringConstraintImpl();
		return substringConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BeginningConstraint createBeginningConstraint() {
		BeginningConstraintImpl beginningConstraint = new BeginningConstraintImpl();
		return beginningConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndingConstraint createEndingConstraint() {
		EndingConstraintImpl endingConstraint = new EndingConstraintImpl();
		return endingConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegExConstraint createRegExConstraint() {
		RegExConstraintImpl regExConstraint = new RegExConstraintImpl();
		return regExConstraint;
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
