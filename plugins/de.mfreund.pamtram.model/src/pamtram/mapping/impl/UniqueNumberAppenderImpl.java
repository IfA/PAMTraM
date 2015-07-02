/**
 */
package pamtram.mapping.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import pamtram.impl.NamedElementImpl;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.UniqueNumberAppender;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unique Number Appender</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class UniqueNumberAppenderImpl extends NamedElementImpl implements UniqueNumberAppender {
	private static long uniqueNumber=0;
	public static long getUniqueNumber() {
		if(uniqueNumber < Long.MAX_VALUE){
			uniqueNumber++;
		} else {
			uniqueNumber=0; //TODO maybe throw error
		}
		
		return uniqueNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UniqueNumberAppenderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.UNIQUE_NUMBER_APPENDER;
	}

	@Override
	public String modifyValue(String value) {
		return value+getUniqueNumber();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MappingPackage.UNIQUE_NUMBER_APPENDER___MODIFY_VALUE__STRING:
				return modifyValue((String)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //UniqueNumberAppenderImpl
