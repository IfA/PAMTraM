/**
 */
package pamtram.metamodel.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionContainmentReference;
import pamtram.metamodel.SourceSectionReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source Section Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class SourceSectionReferenceImpl extends ReferenceImpl<SourceSectionClass> implements SourceSectionReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceSectionReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.SOURCE_SECTION_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MetamodelPackage.SOURCE_SECTION_REFERENCE___GET_VALUES_GENERIC:
				return getValuesGeneric();
		}
		return super.eInvoke(operationID, arguments);
	}

} //SourceSectionReferenceImpl
