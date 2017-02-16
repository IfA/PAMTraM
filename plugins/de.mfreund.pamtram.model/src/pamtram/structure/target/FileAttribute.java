/**
 */
package pamtram.structure.target;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.target.FileAttribute#getFileType <em>File Type</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.target.TargetPackage#getFileAttribute()
 * @model
 * @generated
 */
public interface FileAttribute extends VirtualTargetSectionAttribute {

	/**
	 * Returns the value of the '<em><b>File Type</b></em>' attribute.
	 * The literals are from the enumeration {@link pamtram.structure.target.FileType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Type</em>' attribute.
	 * @see pamtram.structure.target.FileType
	 * @see #setFileType(FileType)
	 * @see pamtram.structure.target.TargetPackage#getFileAttribute_FileType()
	 * @model required="true"
	 * @generated
	 */
	FileType getFileType();

	/**
	 * Sets the value of the '{@link pamtram.structure.target.FileAttribute#getFileType <em>File Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Type</em>' attribute.
	 * @see pamtram.structure.target.FileType
	 * @see #getFileType()
	 * @generated
	 */
	void setFileType(FileType value);
} // FileAttribute
