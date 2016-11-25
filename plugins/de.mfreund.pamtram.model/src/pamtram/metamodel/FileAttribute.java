/**
 */
package pamtram.metamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.FileAttribute#getFileType <em>File Type</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getFileAttribute()
 * @model
 * @generated
 */
public interface FileAttribute extends VirtualTargetSectionAttribute {

	/**
	 * Returns the value of the '<em><b>File Type</b></em>' attribute.
	 * The literals are from the enumeration {@link pamtram.metamodel.FileTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Type</em>' attribute.
	 * @see pamtram.metamodel.FileTypeEnum
	 * @see #setFileType(FileTypeEnum)
	 * @see pamtram.metamodel.MetamodelPackage#getFileAttribute_FileType()
	 * @model required="true"
	 * @generated
	 */
	FileTypeEnum getFileType();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.FileAttribute#getFileType <em>File Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Type</em>' attribute.
	 * @see pamtram.metamodel.FileTypeEnum
	 * @see #getFileType()
	 * @generated
	 */
	void setFileType(FileTypeEnum value);
} // FileAttribute
