/**
 */
package pamtram.metamodel.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionContainmentReference;
import pamtram.metamodel.TargetSectionNonContainmentReference;
import pamtram.metamodel.TargetSectionReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target Section Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class TargetSectionReferenceImpl extends ReferenceImpl<TargetSectionClass> implements TargetSectionReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetSectionReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.TARGET_SECTION_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TargetSectionClass> getValuesGeneric() {
		EList<TargetSectionClass> secs= new org.eclipse.emf.common.util.BasicEList<TargetSectionClass>();
		if(this instanceof TargetSectionContainmentReference){
		 secs.addAll(((TargetSectionContainmentReference) this).getValue());
		
		} else if(this instanceof TargetSectionNonContainmentReference){
		 secs.addAll(((TargetSectionNonContainmentReference) this).getValue());
		}
		return secs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MetamodelPackage.TARGET_SECTION_REFERENCE___GET_VALUES_GENERIC:
				return getValuesGeneric();
		}
		return super.eInvoke(operationID, arguments);
	}

} //TargetSectionReferenceImpl
