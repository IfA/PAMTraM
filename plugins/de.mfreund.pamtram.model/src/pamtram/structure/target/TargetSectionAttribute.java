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

import pamtram.structure.generic.Attribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Section Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This represents an attribute of an element structure to be created in a target model.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.target.TargetSectionAttribute#isUnique <em>Unique</em>}</li>
 *   <li>{@link pamtram.structure.target.TargetSectionAttribute#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.target.TargetPackage#getTargetSectionAttribute()
 * @model abstract="true"
 * @generated
 */
public interface TargetSectionAttribute extends Attribute<TargetSection, TargetSectionClass, TargetSectionReference, TargetSectionAttribute> {
	/**
	 * Returns the value of the '<em><b>Unique</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unique</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If this is set to 'true', no two element structures with the same value of this Attribute will be created in the course of a transformation.
	 * <br /><br />
	 * Currently, if a second element structure with the same attribute value would be created, this second structure is simply discarded. In the future, it might be useful to consider merging the two created structures.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Unique</em>' attribute.
	 * @see #setUnique(boolean)
	 * @see pamtram.structure.target.TargetPackage#getTargetSectionAttribute_Unique()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isUnique();

	/**
	 * Sets the value of the '{@link pamtram.structure.target.TargetSectionAttribute#isUnique <em>Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unique</em>' attribute.
	 * @see #isUnique()
	 * @generated
	 */
	void setUnique(boolean value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This can be used to specify a fixed value for this attribute that will be used for all created instances.
	 * <br /><br />
	 * Note: The specified value will be overriden in case an AttributeMapping is specified for this Attribute.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see pamtram.structure.target.TargetPackage#getTargetSectionAttribute_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link pamtram.structure.target.TargetSectionAttribute#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // TargetSectionAttribute
