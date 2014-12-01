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
import pamtram.metamodel.LibraryElement;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.TargetSectionClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Library Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.LibraryElementImpl#getTargetSectionClasses <em>Target Section Classes</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.LibraryElementImpl#getLibraryFile <em>Library File</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.LibraryElementImpl#getPath <em>Path</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.LibraryElementImpl#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LibraryElementImpl extends MinimalEObjectImpl.Container implements LibraryElement {
	/**
	 * The cached value of the '{@link #getTargetSectionClasses() <em>Target Section Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetSectionClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetSectionClass> targetSectionClasses;
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LibraryElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.LIBRARY_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TargetSectionClass> getTargetSectionClasses() {
		if (targetSectionClasses == null) {
			targetSectionClasses = new EObjectContainmentEList<TargetSectionClass>(TargetSectionClass.class, this, MetamodelPackage.LIBRARY_ELEMENT__TARGET_SECTION_CLASSES);
		}
		return targetSectionClasses;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.LIBRARY_ELEMENT__LIBRARY_FILE, oldLibraryFile, libraryFile));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.LIBRARY_ELEMENT__PATH, oldPath, path));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.LIBRARY_ELEMENT__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.LIBRARY_ELEMENT__TARGET_SECTION_CLASSES:
				return ((InternalEList<?>)getTargetSectionClasses()).basicRemove(otherEnd, msgs);
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
			case MetamodelPackage.LIBRARY_ELEMENT__TARGET_SECTION_CLASSES:
				return getTargetSectionClasses();
			case MetamodelPackage.LIBRARY_ELEMENT__LIBRARY_FILE:
				return getLibraryFile();
			case MetamodelPackage.LIBRARY_ELEMENT__PATH:
				return getPath();
			case MetamodelPackage.LIBRARY_ELEMENT__VERSION:
				return getVersion();
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
			case MetamodelPackage.LIBRARY_ELEMENT__TARGET_SECTION_CLASSES:
				getTargetSectionClasses().clear();
				getTargetSectionClasses().addAll((Collection<? extends TargetSectionClass>)newValue);
				return;
			case MetamodelPackage.LIBRARY_ELEMENT__LIBRARY_FILE:
				setLibraryFile((String)newValue);
				return;
			case MetamodelPackage.LIBRARY_ELEMENT__PATH:
				setPath((String)newValue);
				return;
			case MetamodelPackage.LIBRARY_ELEMENT__VERSION:
				setVersion((String)newValue);
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
			case MetamodelPackage.LIBRARY_ELEMENT__TARGET_SECTION_CLASSES:
				getTargetSectionClasses().clear();
				return;
			case MetamodelPackage.LIBRARY_ELEMENT__LIBRARY_FILE:
				setLibraryFile(LIBRARY_FILE_EDEFAULT);
				return;
			case MetamodelPackage.LIBRARY_ELEMENT__PATH:
				setPath(PATH_EDEFAULT);
				return;
			case MetamodelPackage.LIBRARY_ELEMENT__VERSION:
				setVersion(VERSION_EDEFAULT);
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
			case MetamodelPackage.LIBRARY_ELEMENT__TARGET_SECTION_CLASSES:
				return targetSectionClasses != null && !targetSectionClasses.isEmpty();
			case MetamodelPackage.LIBRARY_ELEMENT__LIBRARY_FILE:
				return LIBRARY_FILE_EDEFAULT == null ? libraryFile != null : !LIBRARY_FILE_EDEFAULT.equals(libraryFile);
			case MetamodelPackage.LIBRARY_ELEMENT__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
			case MetamodelPackage.LIBRARY_ELEMENT__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
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

} //LibraryElementImpl
