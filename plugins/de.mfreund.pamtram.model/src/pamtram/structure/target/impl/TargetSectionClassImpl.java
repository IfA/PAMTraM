/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 */
package pamtram.structure.target.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.impl.ClassImpl;
import pamtram.structure.target.TargetPackage;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Target Section Class</b></em>'. <!--
 * end-user-doc -->
 *
 * @generated
 */
public class TargetSectionClassImpl
		extends ClassImpl<TargetSection, TargetSectionClass, TargetSectionReference, TargetSectionAttribute>
		implements TargetSectionClass {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetSectionClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetPackage.Literals.TARGET_SECTION_CLASS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> This is specialized for the more specific element type known in
	 * this context.
	 * 
	 * @generated
	 */
	@Override
	public EList<TargetSectionReference> getReferences() {
		if (references == null) {
			references = new EObjectContainmentWithInverseEList<TargetSectionReference>(TargetSectionReference.class, this, TargetPackage.TARGET_SECTION_CLASS__REFERENCES, GenericPackage.REFERENCE__OWNING_CLASS) { private static final long serialVersionUID = 1L; @Override public Class<?> getInverseFeatureClass() { return Reference.class; } };
		}
		return references;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> This is specialized for the more specific type known in this
	 * context.
	 * 
	 * @generated
	 */
	@Override
	public void setContainer(TargetSectionClass newContainer) {
		super.setContainer(newContainer);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> This is specialized for the more specific element type known in
	 * this context.
	 * 
	 * @generated
	 */
	@Override
	public EList<TargetSectionAttribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentWithInverseEList<TargetSectionAttribute>(TargetSectionAttribute.class, this, TargetPackage.TARGET_SECTION_CLASS__ATTRIBUTES, GenericPackage.ATTRIBUTE__OWNING_CLASS) { private static final long serialVersionUID = 1L; @Override public Class<?> getInverseFeatureClass() { return Attribute.class; } };
		}
		return attributes;
	}

} // TargetSectionClassImpl
