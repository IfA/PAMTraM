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
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.TargetSectionClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Library Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.LibraryEntryImpl#getMetaData <em>Meta Data</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.LibraryEntryImpl#getLibraryFile <em>Library File</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.LibraryEntryImpl#getPath <em>Path</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.LibraryEntryImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.LibraryEntryImpl#getLibraryItem <em>Library Item</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LibraryEntryImpl extends MinimalEObjectImpl.Container implements LibraryEntry {
	/**
	 * The cached value of the '{@link #getMetaData() <em>Meta Data</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaData()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetSectionClass> metaData;

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
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected String path = PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLibraryItem() <em>Library Item</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibraryItem()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetSectionClass> libraryItem;

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
	public EList<TargetSectionClass> getMetaData() {
		if (metaData == null) {
			metaData = new EObjectContainmentEList<TargetSectionClass>(TargetSectionClass.class, this, MetamodelPackage.LIBRARY_ENTRY__META_DATA);
		}
		return metaData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLibraryFile() {
		return libraryFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public String getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(String newPath) {
		String oldPath = path;
		path = newPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.LIBRARY_ENTRY__PATH, oldPath, path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.LIBRARY_ENTRY__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TargetSectionClass> getLibraryItem() {
		if (libraryItem == null) {
			libraryItem = new EObjectContainmentEList<TargetSectionClass>(TargetSectionClass.class, this, MetamodelPackage.LIBRARY_ENTRY__LIBRARY_ITEM);
		}
		return libraryItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.LIBRARY_ENTRY__META_DATA:
				return ((InternalEList<?>)getMetaData()).basicRemove(otherEnd, msgs);
			case MetamodelPackage.LIBRARY_ENTRY__LIBRARY_ITEM:
				return ((InternalEList<?>)getLibraryItem()).basicRemove(otherEnd, msgs);
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
			case MetamodelPackage.LIBRARY_ENTRY__META_DATA:
				return getMetaData();
			case MetamodelPackage.LIBRARY_ENTRY__LIBRARY_FILE:
				return getLibraryFile();
			case MetamodelPackage.LIBRARY_ENTRY__PATH:
				return getPath();
			case MetamodelPackage.LIBRARY_ENTRY__VERSION:
				return getVersion();
			case MetamodelPackage.LIBRARY_ENTRY__LIBRARY_ITEM:
				return getLibraryItem();
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
			case MetamodelPackage.LIBRARY_ENTRY__META_DATA:
				getMetaData().clear();
				getMetaData().addAll((Collection<? extends TargetSectionClass>)newValue);
				return;
			case MetamodelPackage.LIBRARY_ENTRY__LIBRARY_FILE:
				setLibraryFile((String)newValue);
				return;
			case MetamodelPackage.LIBRARY_ENTRY__PATH:
				setPath((String)newValue);
				return;
			case MetamodelPackage.LIBRARY_ENTRY__VERSION:
				setVersion((String)newValue);
				return;
			case MetamodelPackage.LIBRARY_ENTRY__LIBRARY_ITEM:
				getLibraryItem().clear();
				getLibraryItem().addAll((Collection<? extends TargetSectionClass>)newValue);
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
			case MetamodelPackage.LIBRARY_ENTRY__META_DATA:
				getMetaData().clear();
				return;
			case MetamodelPackage.LIBRARY_ENTRY__LIBRARY_FILE:
				setLibraryFile(LIBRARY_FILE_EDEFAULT);
				return;
			case MetamodelPackage.LIBRARY_ENTRY__PATH:
				setPath(PATH_EDEFAULT);
				return;
			case MetamodelPackage.LIBRARY_ENTRY__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case MetamodelPackage.LIBRARY_ENTRY__LIBRARY_ITEM:
				getLibraryItem().clear();
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
			case MetamodelPackage.LIBRARY_ENTRY__META_DATA:
				return metaData != null && !metaData.isEmpty();
			case MetamodelPackage.LIBRARY_ENTRY__LIBRARY_FILE:
				return LIBRARY_FILE_EDEFAULT == null ? libraryFile != null : !LIBRARY_FILE_EDEFAULT.equals(libraryFile);
			case MetamodelPackage.LIBRARY_ENTRY__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
			case MetamodelPackage.LIBRARY_ENTRY__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case MetamodelPackage.LIBRARY_ENTRY__LIBRARY_ITEM:
				return libraryItem != null && !libraryItem.isEmpty();
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
		result.append(", path: ");
		result.append(path);
		result.append(", version: ");
		result.append(version);
		result.append(')');
		return result.toString();
	}

} //LibraryEntryImpl
