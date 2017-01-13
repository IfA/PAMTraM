/**
 */
package pamtram.structure.target.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import pamtram.structure.StructurePackage;
import pamtram.structure.target.FileAttribute;
import pamtram.structure.target.FileTypeEnum;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>File Attribute</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.structure.target.impl.FileAttributeImpl#getFileType <em>File Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FileAttributeImpl extends VirtualTargetSectionAttributeImpl implements FileAttribute {

	/**
	 * The default value of the '{@link #getFileType() <em>File Type</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getFileType()
	 * @generated
	 * @ordered
	 */
	protected static final FileTypeEnum FILE_TYPE_EDEFAULT = FileTypeEnum.XMI;

	/**
	 * The cached value of the '{@link #getFileType() <em>File Type</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getFileType()
	 * @generated
	 * @ordered
	 */
	protected FileTypeEnum fileType = FileAttributeImpl.FILE_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FileAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return StructurePackage.Literals.FILE_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public FileTypeEnum getFileType() {

		return this.fileType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setFileType(FileTypeEnum newFileType) {

		FileTypeEnum oldFileType = this.fileType;
		this.fileType = newFileType == null ? FileAttributeImpl.FILE_TYPE_EDEFAULT : newFileType;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, StructurePackage.FILE_ATTRIBUTE__FILE_TYPE,
					oldFileType, this.fileType));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {

		switch (featureID) {
			case StructurePackage.FILE_ATTRIBUTE__FILE_TYPE:
				return this.getFileType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {

		switch (featureID) {
			case StructurePackage.FILE_ATTRIBUTE__FILE_TYPE:
				this.setFileType((FileTypeEnum) newValue);
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
			case StructurePackage.FILE_ATTRIBUTE__FILE_TYPE:
				this.setFileType(FileAttributeImpl.FILE_TYPE_EDEFAULT);
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
			case StructurePackage.FILE_ATTRIBUTE__FILE_TYPE:
				return this.fileType != FileAttributeImpl.FILE_TYPE_EDEFAULT;
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
		result.append(" (fileType: ");
		result.append(this.fileType);
		result.append(')');
		return result.toString();
	}

} // FileAttributeImpl
