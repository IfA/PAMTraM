/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 */
package pamtram.structure.target;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This specifies the model resp. file to which the target model structure(s) created based on this TargetSection will be persisted.
 * <br /><br />
 * This can be used to statically or dynamically specify the target models/model files to be created in the course of a transformation. For example, this can be used to persist each instance of a TargetSection in its own file (if the 'value' of this attribute is set dynamically for each instance).
 * <!-- end-model-doc -->
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
	 * <!-- begin-model-doc -->
	 * The type of the model/file to be created.
	 * <!-- end-model-doc -->
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
