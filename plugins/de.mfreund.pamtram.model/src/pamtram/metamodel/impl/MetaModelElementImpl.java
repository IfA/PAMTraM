/**
 */
package pamtram.metamodel.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import pamtram.SectionModel;
import pamtram.impl.NamedElementImpl;
import pamtram.metamodel.AttributeParameter;
import pamtram.metamodel.Class;
import pamtram.metamodel.ContainerParameter;
import pamtram.metamodel.ExternalReferenceParameter;
import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.LibraryParameter;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionNonContainmentReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Meta Model Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class MetaModelElementImpl<C extends pamtram.metamodel.Class<?, ?>> extends NamedElementImpl implements MetaModelElement<C> {
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
	@SuppressWarnings("unchecked")
	@Override
	public C getContainingSection() {
		MetaModelElement<C> element = this;
				
		// move upwards in the hierarchy
		while(element.eContainer() instanceof MetaModelElement) {
			element = (MetaModelElement<C>) element.eContainer();
		}
		
		if(element instanceof pamtram.metamodel.Class &&
				(element.eContainer() instanceof SectionModel || element.eContainer() instanceof ContainerParameter)) {
			// we have found the section
			return (C) element;
		} else if((element instanceof TargetSectionAttribute && element.eContainer() instanceof AttributeParameter) || 
				(element instanceof TargetSectionNonContainmentReference) && element.eContainer() instanceof ExternalReferenceParameter) {
			LibraryEntry libEntry = (LibraryEntry) element.eContainer().eContainer();
			for (LibraryParameter param : libEntry.getParameters()) {
				//TODO if multiple container parameters exist, there might need to be additional logic
				if(param instanceof ContainerParameter) {
					return (C) ((ContainerParameter) param).getClass_();
				}
			}
			return null;
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
	public SectionModel getContainingSectionModel() {
		Class section = this.getContainingSection();
		
		EObject container = section.eContainer();
		while(!(container instanceof SectionModel)) {
			// we have reached the root element
			if(container == null) {
				return null;
			}
			container = container.eContainer();
		}
		return (SectionModel) container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns <em>true</em> if the meta-model element is part of a {@link LibraryEntry}, <em>false</em> if
	 * it is part of a normal section.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isLibraryEntry() {
		return (this.getContainingSection().eContainer() instanceof ContainerParameter);
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
			case MetamodelPackage.META_MODEL_ELEMENT___GET_CONTAINING_SECTION_MODEL:
				return getContainingSectionModel();
			case MetamodelPackage.META_MODEL_ELEMENT___IS_LIBRARY_ENTRY:
				return isLibraryEntry();
		}
		return super.eInvoke(operationID, arguments);
	}

} //MetaModelElementImpl
