/**
 */
package pamtram.metamodel.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionContainmentReference;
import pamtram.metamodel.SourceSectionReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source Section Containment Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SourceSectionContainmentReferenceImpl extends ContainmentReferenceImpl<SourceSectionClass> implements SourceSectionContainmentReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceSectionContainmentReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.SOURCE_SECTION_CONTAINMENT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific element type known in this context.
	 * @generated
	 */
	@Override
	public EList<SourceSectionClass> getValue() {
		if (value == null) {
			value = new EObjectContainmentEList<SourceSectionClass>(SourceSectionClass.class, this, MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE__VALUE);
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SourceSectionClass> getValuesGeneric() {
						EList<SourceSectionClass> secs= new org.eclipse.emf.common.util.BasicEList<SourceSectionClass>();
						if(this instanceof SourceSectionContainmentReference){
						 secs.addAll(((SourceSectionContainmentReference) this).getValue());
						
						} else if(this instanceof MetaModelSectionReference){
						 secs.addAll(((MetaModelSectionReference) this).getValue());
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
		if (baseClass == SourceSectionReference.class) {
			switch (baseOperationID) {
				case MetamodelPackage.SOURCE_SECTION_REFERENCE___GET_VALUES_GENERIC: return MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE___GET_VALUES_GENERIC;
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
			case MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE___GET_VALUES_GENERIC:
				return getValuesGeneric();
		}
		return super.eInvoke(operationID, arguments);
	}

} //SourceSectionContainmentReferenceImpl
