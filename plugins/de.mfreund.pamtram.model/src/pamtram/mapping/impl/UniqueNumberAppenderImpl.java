/**
 */
package pamtram.mapping.impl;

import org.eclipse.emf.ecore.EClass;

import pamtram.mapping.MappingPackage;
import pamtram.mapping.UniqueNumberAppender;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unique Number Appender</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class UniqueNumberAppenderImpl extends AttributeValueModifierImpl implements UniqueNumberAppender {
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
	protected String modifyValue(String value) {
		return value+getUniqueNumber();
	}

} //UniqueNumberAppenderImpl
