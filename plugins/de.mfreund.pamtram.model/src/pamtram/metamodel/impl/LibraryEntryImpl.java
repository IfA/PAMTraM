/**
 */
package pamtram.metamodel.impl;

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

import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.LibraryParameter;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.ResourceParameter;
import pamtram.metamodel.VirtualTargetSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Library Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.LibraryEntryImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.LibraryEntryImpl#getLibraryFile <em>Library File</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.LibraryEntryImpl#getOriginalLibraryEntry <em>Original Library Entry</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.LibraryEntryImpl#getPath <em>Path</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.LibraryEntryImpl#getId <em>Id</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.LibraryEntryImpl#getResourceParameters <em>Resource Parameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LibraryEntryImpl extends MinimalEObjectImpl.Container implements LibraryEntry {
	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<LibraryParameter<?>> parameters;

	/**
	 * The default value of the '{@link #getLibraryFile() <em>Library File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibraryFile()
	 * @generated
	 * @ordered
	 */
	protected static final String LIBRARY_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLibraryFile() <em>Library File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibraryFile()
	 * @generated
	 * @ordered
	 */
	protected String libraryFile = LIBRARY_FILE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOriginalLibraryEntry() <em>Original Library Entry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalLibraryEntry()
	 * @generated
	 * @ordered
	 */
	protected de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry originalLibraryEntry;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected VirtualTargetSectionAttribute path;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected VirtualTargetSectionAttribute id;

	/**
	 * The cached value of the '{@link #getResourceParameters() <em>Resource Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceParameter> resourceParameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LibraryEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.LIBRARY_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<LibraryParameter<?>> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<LibraryParameter<?>>(LibraryParameter.class, this, MetamodelPackage.LIBRARY_ENTRY__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLibraryFile() {
		return libraryFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLibraryFile(String newLibraryFile) {
		String oldLibraryFile = libraryFile;
		libraryFile = newLibraryFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.LIBRARY_ENTRY__LIBRARY_FILE, oldLibraryFile, libraryFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VirtualTargetSectionAttribute getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPath(VirtualTargetSectionAttribute newPath, NotificationChain msgs) {
		VirtualTargetSectionAttribute oldPath = path;
		path = newPath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetamodelPackage.LIBRARY_ENTRY__PATH, oldPath, newPath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(VirtualTargetSectionAttribute newPath) {
		if (newPath != path) {
			NotificationChain msgs = null;
			if (path != null)
				msgs = ((InternalEObject)path).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetamodelPackage.LIBRARY_ENTRY__PATH, null, msgs);
			if (newPath != null)
				msgs = ((InternalEObject)newPath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetamodelPackage.LIBRARY_ENTRY__PATH, null, msgs);
			msgs = basicSetPath(newPath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.LIBRARY_ENTRY__PATH, newPath, newPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualTargetSectionAttribute getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetId(VirtualTargetSectionAttribute newId, NotificationChain msgs) {
		VirtualTargetSectionAttribute oldId = id;
		id = newId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetamodelPackage.LIBRARY_ENTRY__ID, oldId, newId);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(VirtualTargetSectionAttribute newId) {
		if (newId != id) {
			NotificationChain msgs = null;
			if (id != null)
				msgs = ((InternalEObject)id).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetamodelPackage.LIBRARY_ENTRY__ID, null, msgs);
			if (newId != null)
				msgs = ((InternalEObject)newId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetamodelPackage.LIBRARY_ENTRY__ID, null, msgs);
			msgs = basicSetId(newId, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.LIBRARY_ENTRY__ID, newId, newId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceParameter> getResourceParameters() {
		if (resourceParameters == null) {
			resourceParameters = new EObjectContainmentEList<ResourceParameter>(ResourceParameter.class, this, MetamodelPackage.LIBRARY_ENTRY__RESOURCE_PARAMETERS);
		}
		return resourceParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry getOriginalLibraryEntry() {
		if (originalLibraryEntry != null && originalLibraryEntry.eIsProxy()) {
			InternalEObject oldOriginalLibraryEntry = (InternalEObject)originalLibraryEntry;
			originalLibraryEntry = (de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry)eResolveProxy(oldOriginalLibraryEntry);
			if (originalLibraryEntry != oldOriginalLibraryEntry) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.LIBRARY_ENTRY__ORIGINAL_LIBRARY_ENTRY, oldOriginalLibraryEntry, originalLibraryEntry));
			}
		}
		return originalLibraryEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry basicGetOriginalLibraryEntry() {
		return originalLibraryEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOriginalLibraryEntry(de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry newOriginalLibraryEntry) {
		de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry oldOriginalLibraryEntry = originalLibraryEntry;
		originalLibraryEntry = newOriginalLibraryEntry;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.LIBRARY_ENTRY__ORIGINAL_LIBRARY_ENTRY, oldOriginalLibraryEntry, originalLibraryEntry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.LIBRARY_ENTRY__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case MetamodelPackage.LIBRARY_ENTRY__PATH:
				return basicSetPath(null, msgs);
			case MetamodelPackage.LIBRARY_ENTRY__ID:
				return basicSetId(null, msgs);
			case MetamodelPackage.LIBRARY_ENTRY__RESOURCE_PARAMETERS:
				return ((InternalEList<?>)getResourceParameters()).basicRemove(otherEnd, msgs);
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
			case MetamodelPackage.LIBRARY_ENTRY__PARAMETERS:
				return getParameters();
			case MetamodelPackage.LIBRARY_ENTRY__LIBRARY_FILE:
				return getLibraryFile();
			case MetamodelPackage.LIBRARY_ENTRY__ORIGINAL_LIBRARY_ENTRY:
				if (resolve) return getOriginalLibraryEntry();
				return basicGetOriginalLibraryEntry();
			case MetamodelPackage.LIBRARY_ENTRY__PATH:
				return getPath();
			case MetamodelPackage.LIBRARY_ENTRY__ID:
				return getId();
			case MetamodelPackage.LIBRARY_ENTRY__RESOURCE_PARAMETERS:
				return getResourceParameters();
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
			case MetamodelPackage.LIBRARY_ENTRY__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends LibraryParameter<?>>)newValue);
				return;
			case MetamodelPackage.LIBRARY_ENTRY__LIBRARY_FILE:
				setLibraryFile((String)newValue);
				return;
			case MetamodelPackage.LIBRARY_ENTRY__ORIGINAL_LIBRARY_ENTRY:
				setOriginalLibraryEntry((de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry)newValue);
				return;
			case MetamodelPackage.LIBRARY_ENTRY__PATH:
				setPath((VirtualTargetSectionAttribute)newValue);
				return;
			case MetamodelPackage.LIBRARY_ENTRY__ID:
				setId((VirtualTargetSectionAttribute)newValue);
				return;
			case MetamodelPackage.LIBRARY_ENTRY__RESOURCE_PARAMETERS:
				getResourceParameters().clear();
				getResourceParameters().addAll((Collection<? extends ResourceParameter>)newValue);
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
			case MetamodelPackage.LIBRARY_ENTRY__PARAMETERS:
				getParameters().clear();
				return;
			case MetamodelPackage.LIBRARY_ENTRY__LIBRARY_FILE:
				setLibraryFile(LIBRARY_FILE_EDEFAULT);
				return;
			case MetamodelPackage.LIBRARY_ENTRY__ORIGINAL_LIBRARY_ENTRY:
				setOriginalLibraryEntry((de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry)null);
				return;
			case MetamodelPackage.LIBRARY_ENTRY__PATH:
				setPath((VirtualTargetSectionAttribute)null);
				return;
			case MetamodelPackage.LIBRARY_ENTRY__ID:
				setId((VirtualTargetSectionAttribute)null);
				return;
			case MetamodelPackage.LIBRARY_ENTRY__RESOURCE_PARAMETERS:
				getResourceParameters().clear();
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
			case MetamodelPackage.LIBRARY_ENTRY__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case MetamodelPackage.LIBRARY_ENTRY__LIBRARY_FILE:
				return LIBRARY_FILE_EDEFAULT == null ? libraryFile != null : !LIBRARY_FILE_EDEFAULT.equals(libraryFile);
			case MetamodelPackage.LIBRARY_ENTRY__ORIGINAL_LIBRARY_ENTRY:
				return originalLibraryEntry != null;
			case MetamodelPackage.LIBRARY_ENTRY__PATH:
				return path != null;
			case MetamodelPackage.LIBRARY_ENTRY__ID:
				return id != null;
			case MetamodelPackage.LIBRARY_ENTRY__RESOURCE_PARAMETERS:
				return resourceParameters != null && !resourceParameters.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (libraryFile: ");
		result.append(libraryFile);
		result.append(')');
		return result.toString();
	}

} //LibraryEntryImpl
