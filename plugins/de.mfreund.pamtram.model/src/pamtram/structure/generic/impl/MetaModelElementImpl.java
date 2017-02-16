/**
 */
package pamtram.structure.generic.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import pamtram.SectionModel;
import pamtram.impl.NamedElementImpl;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.MetaModelElement;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;
import pamtram.structure.library.AttributeParameter;
import pamtram.structure.library.ContainerParameter;
import pamtram.structure.library.ExternalReferenceParameter;
import pamtram.structure.library.LibraryEntry;
import pamtram.structure.library.LibraryParameter;
import pamtram.structure.library.ResourceParameter;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.target.TargetSectionCrossReference;
import pamtram.structure.target.VirtualTargetSectionAttribute;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Meta
 * Model Element</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class MetaModelElementImpl<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>>
		extends NamedElementImpl implements MetaModelElement<S, C, R, A> {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MetaModelElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenericPackage.Literals.META_MODEL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc --> This method returns the Section containing this
	 * MetaModelElement (or the element itself if this already is the Section).
	 * Thereby, a section is characterized by the following two conditions: 1.
	 * The Section is an element of type 'pamtram.structure.Class' 2. The parent
	 * element of the Section is of type 'SectionModel' or of type
	 * 'ContainerParameter' <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public S getContainingSection() {
		MetaModelElement<S,C,R,A> element = this;
		
		// move upwards in the hierarchy
		while(element.eContainer() instanceof MetaModelElement) {
			element = (MetaModelElement<S,C,R,A>) element.eContainer();
		}
		
		if(element instanceof Section || element.eContainer() instanceof ContainerParameter) {
			// we have found the section
			return (S) element;
		} else if((element instanceof TargetSectionAttribute && (element.eContainer() instanceof AttributeParameter || element.eContainer() instanceof ResourceParameter)) || 
				(element instanceof TargetSectionCrossReference) && element.eContainer() instanceof ExternalReferenceParameter) {
			LibraryEntry libEntry = (LibraryEntry) element.eContainer().eContainer();
			for (LibraryParameter<?> param : libEntry.getParameters()) {
				//TODO if multiple container parameters exist, there might need to be additional logic
				if(param instanceof ContainerParameter) {
					return (S) ((ContainerParameter) param).getClass_();
				}
			}
			return null;
		} else  if(element instanceof VirtualTargetSectionAttribute && element.eContainer() instanceof LibraryEntry) {
			LibraryEntry libEntry = (LibraryEntry) element.eContainer();
			for (LibraryParameter<?> param : libEntry.getParameters()) {
				//TODO if multiple container parameters exist, there might need to be additional logic
				if(param instanceof ContainerParameter) {
					return (S) ((ContainerParameter) param).getClass_();
				}
			}
			return null;
		} else {
			// something went wrong
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SectionModel<S, C, R, A> getContainingSectionModel() {
		S section = this.getContainingSection();
		
		EObject container = section.eContainer();
		while(!(container instanceof SectionModel)) {
			// we have reached the root element
			if(container == null) {
				return null;
			}
			container = container.eContainer();
		}
		return (SectionModel<S, C, R, A>) container;
	}

	/**
	 * <!-- begin-user-doc --> Returns <em>true</em> if the meta-model element
	 * is part of a {@link LibraryEntry}, <em>false</em> if it is part of a
	 * normal section. <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isLibraryEntry() {
		return (this.getContainingSection().eContainer() instanceof ContainerParameter);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case GenericPackage.META_MODEL_ELEMENT___GET_CONTAINING_SECTION:
				return getContainingSection();
			case GenericPackage.META_MODEL_ELEMENT___GET_CONTAINING_SECTION_MODEL:
				return getContainingSectionModel();
			case GenericPackage.META_MODEL_ELEMENT___IS_LIBRARY_ENTRY:
				return isLibraryEntry();
		}
		return super.eInvoke(operationID, arguments);
	}

} // MetaModelElementImpl
