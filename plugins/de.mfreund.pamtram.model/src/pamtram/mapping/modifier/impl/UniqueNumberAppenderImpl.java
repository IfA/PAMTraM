/**
 */
package pamtram.mapping.modifier.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import pamtram.impl.NamedElementImpl;
import pamtram.mapping.modifier.ModifierPackage;
import pamtram.mapping.modifier.UniqueNumberAppender;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Unique Number Appender</b></em>'. <!--
 * end-user-doc -->
 *
 * @generated
 */
public class UniqueNumberAppenderImpl extends NamedElementImpl implements UniqueNumberAppender {

	private static long uniqueNumber = 0;

	public static long getUniqueNumber() {

		if (UniqueNumberAppenderImpl.uniqueNumber < Long.MAX_VALUE) {
			UniqueNumberAppenderImpl.uniqueNumber++;
		} else {
			UniqueNumberAppenderImpl.uniqueNumber = 0; // TODO maybe throw error
		}

		return UniqueNumberAppenderImpl.uniqueNumber;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected UniqueNumberAppenderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifierPackage.Literals.UNIQUE_NUMBER_APPENDER;
	}

	@Override
	public String modifyValue(String value) {

		return value + UniqueNumberAppenderImpl.getUniqueNumber();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ModifierPackage.UNIQUE_NUMBER_APPENDER___MODIFY_VALUE__STRING:
				return modifyValue((String)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} // UniqueNumberAppenderImpl
