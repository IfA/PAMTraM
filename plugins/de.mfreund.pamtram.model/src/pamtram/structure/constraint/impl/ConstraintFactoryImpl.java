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
import pamtram.structure.constraint.BeginningConstraint;
import pamtram.structure.constraint.ChoiceConstraint;
import pamtram.structure.constraint.ConstraintFactory;
import pamtram.structure.constraint.ConstraintPackage;
import pamtram.structure.constraint.EndingConstraint;
import pamtram.structure.constraint.EqualityConstraint;
import pamtram.structure.constraint.NumericConstraint;
import pamtram.structure.constraint.NumericConstraintOperatorType;
import pamtram.structure.constraint.RangeBound;
import pamtram.structure.constraint.RangeConstraint;
import pamtram.structure.constraint.RegExConstraint;
import pamtram.structure.constraint.SubstringConstraint;
import pamtram.structure.constraint.ValueConstraintExternalSourceElement;
import pamtram.structure.constraint.ValueConstraintSourceElement;
import pamtram.structure.constraint.ValueConstraintType;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class ConstraintFactoryImpl extends EFactoryImpl implements ConstraintFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ConstraintPackage.EQUALITY_CONSTRAINT: return createEqualityConstraint();
			case ConstraintPackage.CHOICE_CONSTRAINT: return createChoiceConstraint();
			case ConstraintPackage.NUMERIC_CONSTRAINT: return createNumericConstraint();
			case ConstraintPackage.STRING_CONSTRAINT: return createStringConstraint();
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ConstraintPackage.VALUE_CONSTRAINT_TYPE:
				return createValueConstraintTypeFromString(eDataType, initialValue);
			case ConstraintPackage.NUMERIC_CONSTRAINT_OPERATOR_TYPE:
				return createNumericConstraintOperatorTypeFromString(eDataType, initialValue);
			case ConstraintPackage.STRING_CONSTRAINT_OPERATOR_TYPE:
				return createStringConstraintOperatorTypeFromString(eDataType, initialValue);
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
			case ConstraintPackage.VALUE_CONSTRAINT_TYPE:
				return convertValueConstraintTypeToString(eDataType, instanceValue);
			case ConstraintPackage.NUMERIC_CONSTRAINT_OPERATOR_TYPE:
				return convertNumericConstraintOperatorTypeToString(eDataType, instanceValue);
			case ConstraintPackage.STRING_CONSTRAINT_OPERATOR_TYPE:
				return convertStringConstraintOperatorTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EqualityConstraint createEqualityConstraint() {
		EqualityConstraintImpl equalityConstraint = new EqualityConstraintImpl();
		return equalityConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ChoiceConstraint createChoiceConstraint() {
		ChoiceConstraintImpl choiceConstraint = new ChoiceConstraintImpl();
		return choiceConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NumericConstraint createNumericConstraint() {
		NumericConstraintImpl numericConstraint = new NumericConstraintImpl();
		return numericConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringConstraint createStringConstraint() {
		StringConstraintImpl stringConstraint = new StringConstraintImpl();
		return stringConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubstringConstraint createSubstringConstraint() {
		SubstringConstraintImpl substringConstraint = new SubstringConstraintImpl();
		return substringConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BeginningConstraint createBeginningConstraint() {
		BeginningConstraintImpl beginningConstraint = new BeginningConstraintImpl();
		return beginningConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EndingConstraint createEndingConstraint() {
		EndingConstraintImpl endingConstraint = new EndingConstraintImpl();
		return endingConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RegExConstraint createRegExConstraint() {
		RegExConstraintImpl regExConstraint = new RegExConstraintImpl();
		return regExConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RangeConstraint createRangeConstraint() {
		RangeConstraintImpl rangeConstraint = new RangeConstraintImpl();
		return rangeConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ValueConstraintSourceElement createValueConstraintSourceElement() {
		ValueConstraintSourceElementImpl valueConstraintSourceElement = new ValueConstraintSourceElementImpl();
		return valueConstraintSourceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ValueConstraintExternalSourceElement createValueConstraintExternalSourceElement() {
		ValueConstraintExternalSourceElementImpl valueConstraintExternalSourceElement = new ValueConstraintExternalSourceElementImpl();
		return valueConstraintExternalSourceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RangeBound createRangeBound() {
		RangeBoundImpl rangeBound = new RangeBoundImpl();
		return rangeBound;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ValueConstraintType createValueConstraintTypeFromString(EDataType eDataType, String initialValue) {
		ValueConstraintType result = ValueConstraintType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertValueConstraintTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NumericConstraintOperatorType createNumericConstraintOperatorTypeFromString(EDataType eDataType,
			String initialValue) {
		NumericConstraintOperatorType result = NumericConstraintOperatorType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNumericConstraintOperatorTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringConstraintOperatorType createStringConstraintOperatorTypeFromString(EDataType eDataType, String initialValue) {
		StringConstraintOperatorType result = StringConstraintOperatorType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStringConstraintOperatorTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConstraintPackage getConstraintPackage() {
		return (ConstraintPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ConstraintPackage getPackage() {
		return ConstraintPackage.eINSTANCE;
	}

} // ConstraintFactoryImpl
