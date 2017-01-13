/**
 */
package pamtram.structure.target.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import pamtram.structure.target.FileAttribute;
import pamtram.structure.target.FileTypeEnum;
import pamtram.structure.target.TargetPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>File Attribute</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.target.impl.FileAttributeImpl#getFileType <em>File Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FileAttributeImpl extends VirtualTargetSectionAttributeImpl implements FileAttribute {

	/**
	 * The default value of the '{@link #getFileType() <em>File Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getFileType()
	 * @generated
	 * @ordered
	 */
	protected static final FileTypeEnum FILE_TYPE_EDEFAULT = FileTypeEnum.XMI;

	/**
	 * The cached value of the '{@link #getFileType() <em>File Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getFileType()
	 * @generated
	 * @ordered
	 */
	protected FileTypeEnum fileType = FILE_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected FileAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetPackage.Literals.FILE_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FileTypeEnum getFileType() {
		return fileType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFileType(FileTypeEnum newFileType) {
		FileTypeEnum oldFileType = fileType;
		fileType = newFileType == null ? FILE_TYPE_EDEFAULT : newFileType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPackage.FILE_ATTRIBUTE__FILE_TYPE, oldFileType, fileType));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TargetPackage.FILE_ATTRIBUTE__FILE_TYPE:
				return getFileType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TargetPackage.FILE_ATTRIBUTE__FILE_TYPE:
				setFileType((FileTypeEnum)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TargetPackage.FILE_ATTRIBUTE__FILE_TYPE:
				setFileType(FILE_TYPE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TargetPackage.FILE_ATTRIBUTE__FILE_TYPE:
				return fileType != FILE_TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (fileType: ");
		result.append(fileType);
		result.append(')');
		return result.toString();
	}

} // FileAttributeImpl
