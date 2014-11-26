/**
 */
package pamtram.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pamtram.PamtramPackage;
import pamtram.TargetSectionModel;
import pamtram.metamodel.LibraryElement;
import pamtram.metamodel.TargetSectionClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target Section Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pamtram.impl.TargetSectionModelImpl#getMetaModelSections <em>Meta Model Sections</em>}</li>
 *   <li>{@link pamtram.impl.TargetSectionModelImpl#getLibraryElements <em>Library Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TargetSectionModelImpl extends SectionModelImpl implements TargetSectionModel {
	/**
	 * The cached value of the '{@link #getMetaModelSections() <em>Meta Model Sections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaModelSections()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetSectionClass> metaModelSections;

	/**
	 * The cached value of the '{@link #getLibraryElements() <em>Library Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibraryElements()
	 * @generated
	 * @ordered
	 */
	protected EList<LibraryElement> libraryElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetSectionModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PamtramPackage.Literals.TARGET_SECTION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TargetSectionClass> getMetaModelSections() {
		if (metaModelSections == null) {
			metaModelSections = new EObjectContainmentEList<TargetSectionClass>(TargetSectionClass.class, this, PamtramPackage.TARGET_SECTION_MODEL__META_MODEL_SECTIONS);
		}
		return metaModelSections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LibraryElement> getLibraryElements() {
		if (libraryElements == null) {
			libraryElements = new EObjectContainmentEList<LibraryElement>(LibraryElement.class, this, PamtramPackage.TARGET_SECTION_MODEL__LIBRARY_ELEMENTS);
		}
		return libraryElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PamtramPackage.TARGET_SECTION_MODEL__META_MODEL_SECTIONS:
				return ((InternalEList<?>)getMetaModelSections()).basicRemove(otherEnd, msgs);
			case PamtramPackage.TARGET_SECTION_MODEL__LIBRARY_ELEMENTS:
				return ((InternalEList<?>)getLibraryElements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PamtramPackage.TARGET_SECTION_MODEL__META_MODEL_SECTIONS:
				return getMetaModelSections();
			case PamtramPackage.TARGET_SECTION_MODEL__LIBRARY_ELEMENTS:
				return getLibraryElements();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PamtramPackage.TARGET_SECTION_MODEL__META_MODEL_SECTIONS:
				getMetaModelSections().clear();
				getMetaModelSections().addAll((Collection<? extends TargetSectionClass>)newValue);
				return;
			case PamtramPackage.TARGET_SECTION_MODEL__LIBRARY_ELEMENTS:
				getLibraryElements().clear();
				getLibraryElements().addAll((Collection<? extends LibraryElement>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PamtramPackage.TARGET_SECTION_MODEL__META_MODEL_SECTIONS:
				getMetaModelSections().clear();
				return;
			case PamtramPackage.TARGET_SECTION_MODEL__LIBRARY_ELEMENTS:
				getLibraryElements().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PamtramPackage.TARGET_SECTION_MODEL__META_MODEL_SECTIONS:
				return metaModelSections != null && !metaModelSections.isEmpty();
			case PamtramPackage.TARGET_SECTION_MODEL__LIBRARY_ELEMENTS:
				return libraryElements != null && !libraryElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TargetSectionModelImpl
