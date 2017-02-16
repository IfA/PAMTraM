/**
 */
package pamtram.structure.library.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pamtram.structure.StructurePackage;
import pamtram.structure.library.LibraryEntry;
import pamtram.structure.library.LibraryParameter;
import pamtram.structure.library.ResourceParameter;
import pamtram.structure.target.VirtualTargetSectionAttribute;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Library Entry</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.structure.library.impl.LibraryEntryImpl#getParameters <em>Parameters</em>}</li>
 * <li>{@link pamtram.structure.library.impl.LibraryEntryImpl#getLibraryFile <em>Library File</em>}</li>
 * <li>{@link pamtram.structure.library.impl.LibraryEntryImpl#getOriginalLibraryEntry <em>Original Library
 * Entry</em>}</li>
 * <li>{@link pamtram.structure.library.impl.LibraryEntryImpl#getPath <em>Path</em>}</li>
 * <li>{@link pamtram.structure.library.impl.LibraryEntryImpl#getId <em>Id</em>}</li>
 * <li>{@link pamtram.structure.library.impl.LibraryEntryImpl#getResourceParameters <em>Resource Parameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LibraryEntryImpl extends MinimalEObjectImpl.Container implements LibraryEntry {

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<LibraryParameter<?>> parameters;

	/**
	 * The default value of the '{@link #getLibraryFile() <em>Library File</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLibraryFile()
	 * @generated
	 * @ordered
	 */
	protected static final String LIBRARY_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLibraryFile() <em>Library File</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getLibraryFile()
	 * @generated
	 * @ordered
	 */
	protected String libraryFile = LibraryEntryImpl.LIBRARY_FILE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOriginalLibraryEntry() <em>Original Library Entry</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOriginalLibraryEntry()
	 * @generated
	 * @ordered
	 */
	protected de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry originalLibraryEntry;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected VirtualTargetSectionAttribute path;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected VirtualTargetSectionAttribute id;

	/**
	 * The cached value of the '{@link #getResourceParameters() <em>Resource Parameters</em>}' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getResourceParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceParameter> resourceParameters;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LibraryEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return StructurePackage.Literals.LIBRARY_ENTRY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<LibraryParameter<?>> getParameters() {

		if (this.parameters == null) {
			this.parameters = new EObjectContainmentEList<>(LibraryParameter.class, this,
					StructurePackage.LIBRARY_ENTRY__PARAMETERS);
		}
		return this.parameters;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getLibraryFile() {

		return this.libraryFile;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setLibraryFile(String newLibraryFile) {

		String oldLibraryFile = this.libraryFile;
		this.libraryFile = newLibraryFile;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, StructurePackage.LIBRARY_ENTRY__LIBRARY_FILE,
					oldLibraryFile, this.libraryFile));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public VirtualTargetSectionAttribute getPath() {

		return this.path;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetPath(VirtualTargetSectionAttribute newPath, NotificationChain msgs) {

		VirtualTargetSectionAttribute oldPath = this.path;
		this.path = newPath;
		if (this.eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					StructurePackage.LIBRARY_ENTRY__PATH, oldPath, newPath);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setPath(VirtualTargetSectionAttribute newPath) {

		if (newPath != this.path) {
			NotificationChain msgs = null;
			if (this.path != null) {
				msgs = ((InternalEObject) this.path).eInverseRemove(this,
						InternalEObject.EOPPOSITE_FEATURE_BASE - StructurePackage.LIBRARY_ENTRY__PATH, null, msgs);
			}
			if (newPath != null) {
				msgs = ((InternalEObject) newPath).eInverseAdd(this,
						InternalEObject.EOPPOSITE_FEATURE_BASE - StructurePackage.LIBRARY_ENTRY__PATH, null, msgs);
			}
			msgs = this.basicSetPath(newPath, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, StructurePackage.LIBRARY_ENTRY__PATH, newPath,
					newPath));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public VirtualTargetSectionAttribute getId() {

		return this.id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetId(VirtualTargetSectionAttribute newId, NotificationChain msgs) {

		VirtualTargetSectionAttribute oldId = this.id;
		this.id = newId;
		if (this.eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					StructurePackage.LIBRARY_ENTRY__ID, oldId, newId);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setId(VirtualTargetSectionAttribute newId) {

		if (newId != this.id) {
			NotificationChain msgs = null;
			if (this.id != null) {
				msgs = ((InternalEObject) this.id).eInverseRemove(this,
						InternalEObject.EOPPOSITE_FEATURE_BASE - StructurePackage.LIBRARY_ENTRY__ID, null, msgs);
			}
			if (newId != null) {
				msgs = ((InternalEObject) newId).eInverseAdd(this,
						InternalEObject.EOPPOSITE_FEATURE_BASE - StructurePackage.LIBRARY_ENTRY__ID, null, msgs);
			}
			msgs = this.basicSetId(newId, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (this.eNotificationRequired()) {
			this.eNotify(
					new ENotificationImpl(this, Notification.SET, StructurePackage.LIBRARY_ENTRY__ID, newId, newId));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<ResourceParameter> getResourceParameters() {

		if (this.resourceParameters == null) {
			this.resourceParameters = new EObjectContainmentEList<>(ResourceParameter.class, this,
					StructurePackage.LIBRARY_ENTRY__RESOURCE_PARAMETERS);
		}
		return this.resourceParameters;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry getOriginalLibraryEntry() {

		if (this.originalLibraryEntry != null && this.originalLibraryEntry.eIsProxy()) {
			InternalEObject oldOriginalLibraryEntry = (InternalEObject) this.originalLibraryEntry;
			this.originalLibraryEntry = (de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry) this
					.eResolveProxy(oldOriginalLibraryEntry);
			if (this.originalLibraryEntry != oldOriginalLibraryEntry) {
				if (this.eNotificationRequired()) {
					this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							StructurePackage.LIBRARY_ENTRY__ORIGINAL_LIBRARY_ENTRY, oldOriginalLibraryEntry,
							this.originalLibraryEntry));
				}
			}
		}
		return this.originalLibraryEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry basicGetOriginalLibraryEntry() {

		return this.originalLibraryEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setOriginalLibraryEntry(
			de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry newOriginalLibraryEntry) {

		de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry oldOriginalLibraryEntry = this.originalLibraryEntry;
		this.originalLibraryEntry = newOriginalLibraryEntry;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET,
					StructurePackage.LIBRARY_ENTRY__ORIGINAL_LIBRARY_ENTRY, oldOriginalLibraryEntry,
					this.originalLibraryEntry));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {

		switch (featureID) {
			case StructurePackage.LIBRARY_ENTRY__PARAMETERS:
				return ((InternalEList<?>) this.getParameters()).basicRemove(otherEnd, msgs);
			case StructurePackage.LIBRARY_ENTRY__PATH:
				return this.basicSetPath(null, msgs);
			case StructurePackage.LIBRARY_ENTRY__ID:
				return this.basicSetId(null, msgs);
			case StructurePackage.LIBRARY_ENTRY__RESOURCE_PARAMETERS:
				return ((InternalEList<?>) this.getResourceParameters()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {

		switch (featureID) {
			case StructurePackage.LIBRARY_ENTRY__PARAMETERS:
				return this.getParameters();
			case StructurePackage.LIBRARY_ENTRY__LIBRARY_FILE:
				return this.getLibraryFile();
			case StructurePackage.LIBRARY_ENTRY__ORIGINAL_LIBRARY_ENTRY:
				if (resolve) {
					return this.getOriginalLibraryEntry();
				}
				return this.basicGetOriginalLibraryEntry();
			case StructurePackage.LIBRARY_ENTRY__PATH:
				return this.getPath();
			case StructurePackage.LIBRARY_ENTRY__ID:
				return this.getId();
			case StructurePackage.LIBRARY_ENTRY__RESOURCE_PARAMETERS:
				return this.getResourceParameters();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {

		switch (featureID) {
			case StructurePackage.LIBRARY_ENTRY__PARAMETERS:
				this.getParameters().clear();
				this.getParameters().addAll((Collection<? extends LibraryParameter<?>>) newValue);
				return;
			case StructurePackage.LIBRARY_ENTRY__LIBRARY_FILE:
				this.setLibraryFile((String) newValue);
				return;
			case StructurePackage.LIBRARY_ENTRY__ORIGINAL_LIBRARY_ENTRY:
				this.setOriginalLibraryEntry((de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry) newValue);
				return;
			case StructurePackage.LIBRARY_ENTRY__PATH:
				this.setPath((VirtualTargetSectionAttribute) newValue);
				return;
			case StructurePackage.LIBRARY_ENTRY__ID:
				this.setId((VirtualTargetSectionAttribute) newValue);
				return;
			case StructurePackage.LIBRARY_ENTRY__RESOURCE_PARAMETERS:
				this.getResourceParameters().clear();
				this.getResourceParameters().addAll((Collection<? extends ResourceParameter>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {

		switch (featureID) {
			case StructurePackage.LIBRARY_ENTRY__PARAMETERS:
				this.getParameters().clear();
				return;
			case StructurePackage.LIBRARY_ENTRY__LIBRARY_FILE:
				this.setLibraryFile(LibraryEntryImpl.LIBRARY_FILE_EDEFAULT);
				return;
			case StructurePackage.LIBRARY_ENTRY__ORIGINAL_LIBRARY_ENTRY:
				this.setOriginalLibraryEntry((de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry) null);
				return;
			case StructurePackage.LIBRARY_ENTRY__PATH:
				this.setPath((VirtualTargetSectionAttribute) null);
				return;
			case StructurePackage.LIBRARY_ENTRY__ID:
				this.setId((VirtualTargetSectionAttribute) null);
				return;
			case StructurePackage.LIBRARY_ENTRY__RESOURCE_PARAMETERS:
				this.getResourceParameters().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {

		switch (featureID) {
			case StructurePackage.LIBRARY_ENTRY__PARAMETERS:
				return this.parameters != null && !this.parameters.isEmpty();
			case StructurePackage.LIBRARY_ENTRY__LIBRARY_FILE:
				return LibraryEntryImpl.LIBRARY_FILE_EDEFAULT == null ? this.libraryFile != null
						: !LibraryEntryImpl.LIBRARY_FILE_EDEFAULT.equals(this.libraryFile);
			case StructurePackage.LIBRARY_ENTRY__ORIGINAL_LIBRARY_ENTRY:
				return this.originalLibraryEntry != null;
			case StructurePackage.LIBRARY_ENTRY__PATH:
				return this.path != null;
			case StructurePackage.LIBRARY_ENTRY__ID:
				return this.id != null;
			case StructurePackage.LIBRARY_ENTRY__RESOURCE_PARAMETERS:
				return this.resourceParameters != null && !this.resourceParameters.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {

		if (this.eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (libraryFile: ");
		result.append(this.libraryFile);
		result.append(')');
		return result.toString();
	}

} // LibraryEntryImpl
