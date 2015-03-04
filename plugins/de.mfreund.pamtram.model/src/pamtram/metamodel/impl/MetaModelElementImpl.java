/**
 */
package pamtram.metamodel.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import pamtram.SectionModel;
import pamtram.impl.NamedElementImpl;
import pamtram.metamodel.ContainerParameter;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.MetamodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Meta Model Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class MetaModelElementImpl extends NamedElementImpl implements MetaModelElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetaModelElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.META_MODEL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * This method returns the Section containing this MetaModelElement (or 
	 * the element itself if this already is the Section).
	 * Thereby, a section is characterized by the following two conditions:
	 * 1. The Section is an element of type 'pamtram.metamodel.Class'
	 * 2. The parent element of the Section is of type 'SectionModel' or of type 'ContainerParameter'
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public pamtram.metamodel.Class getContainingSection() {
		MetaModelElement element = this;
				
		// move upwards in the hierarchy
		while(element.eContainer() instanceof MetaModelElement) {
			element = (MetaModelElement) element.eContainer();
		}
		
		if(element instanceof pamtram.metamodel.Class &&
				(element.eContainer() instanceof SectionModel || element.eContainer() instanceof ContainerParameter)) {
			// we have found the section
			return (pamtram.metamodel.Class) element;
		} else {
			// something went wrong
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MetamodelPackage.META_MODEL_ELEMENT___GET_CONTAINING_SECTION:
				return getContainingSection();
		}
		return super.eInvoke(operationID, arguments);
	}

} //MetaModelElementImpl
