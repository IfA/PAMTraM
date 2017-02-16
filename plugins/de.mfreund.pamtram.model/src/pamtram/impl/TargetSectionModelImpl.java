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
import pamtram.structure.LibraryEntry;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target Section Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.impl.TargetSectionModelImpl#getLibraryElements <em>Library Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TargetSectionModelImpl extends SectionModelImpl<TargetSection, TargetSectionClass, TargetSectionReference, TargetSectionAttribute> implements TargetSectionModel {
	/**
	 * The cached value of the '{@link #getLibraryElements() <em>Library Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibraryElements()
	 * @generated
	 * @ordered
	 */
	protected EList<LibraryEntry> libraryElements;

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
	 * This is specialized for the more specific element type known in this context.
	 * @generated
	 */
	@Override
	public EList<TargetSection> getSections() {
		if (metaModelSections == null) {
			metaModelSections = new EObjectContainmentEList<TargetSection>(TargetSection.class, this, PamtramPackage.TARGET_SECTION_MODEL__SECTIONS);
		}
		return metaModelSections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LibraryEntry> getLibraryElements() {
		if (libraryElements == null) {
			libraryElements = new EObjectContainmentEList<LibraryEntry>(LibraryEntry.class, this, PamtramPackage.TARGET_SECTION_MODEL__LIBRARY_ELEMENTS);
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
			case PamtramPackage.TARGET_SECTION_MODEL__LIBRARY_ELEMENTS:
				getLibraryElements().clear();
				getLibraryElements().addAll((Collection<? extends LibraryEntry>)newValue);
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
			case PamtramPackage.TARGET_SECTION_MODEL__LIBRARY_ELEMENTS:
				return libraryElements != null && !libraryElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TargetSectionModelImpl
