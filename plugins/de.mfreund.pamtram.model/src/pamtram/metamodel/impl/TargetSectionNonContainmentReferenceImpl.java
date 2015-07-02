/**
 */
package pamtram.metamodel.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionContainmentReference;
import pamtram.metamodel.TargetSectionNonContainmentReference;
import pamtram.metamodel.TargetSectionReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target Section Non Containment Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class TargetSectionNonContainmentReferenceImpl extends NonContainmentReferenceImpl<TargetSectionClass, TargetSectionReference, TargetSectionAttribute> implements TargetSectionNonContainmentReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetSectionNonContainmentReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.TARGET_SECTION_NON_CONTAINMENT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific element type known in this context.
	 * @generated
	 */
	@Override
	public EList<TargetSectionClass> getValue() {
		if (value == null) {
			value = new EObjectResolvingEList<TargetSectionClass>(TargetSectionClass.class, this, MetamodelPackage.TARGET_SECTION_NON_CONTAINMENT_REFERENCE__VALUE);
		}
		return value;
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
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == TargetSectionReference.class) {
			switch (baseOperationID) {
				case MetamodelPackage.TARGET_SECTION_REFERENCE___GET_VALUES_GENERIC: return MetamodelPackage.TARGET_SECTION_NON_CONTAINMENT_REFERENCE___GET_VALUES_GENERIC;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MetamodelPackage.TARGET_SECTION_NON_CONTAINMENT_REFERENCE___GET_VALUES_GENERIC:
				return getValuesGeneric();
		}
		return super.eInvoke(operationID, arguments);
	}

} //TargetSectionNonContainmentReferenceImpl
