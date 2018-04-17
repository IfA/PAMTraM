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
package pamtram.structure;

import org.eclipse.emf.common.util.EList;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Global Modified Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A GlobalDynamicSourceElement represents a certain value that can be used in various calculations.
 * <br /><br />
 * The dynamic value is thereby calculated based on the value of an attribute of a SourceSection (resp. the matched source model excerpt(s)) that is specified via the 'source' reference. As multiple source model excerpts can be matched against a single SourceSection (and thus against a single SourceSectionAttribute), a DynamicSourceElement may actually deliver many values that will be used by the calculation.
 * <br /><br />
 * For 'GlobalDynamicSourceElements', all instances of the specified 'source' attribute found in the source model are used.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.GlobalDynamicSourceElement#getInstanceSelectors <em>Instance Selectors</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.StructurePackage#getGlobalDynamicSourceElement()
 * @model abstract="true"
 * @generated
 */
public interface GlobalDynamicSourceElement<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>, InstanceSelectorType extends InstanceSelector> extends DynamicSourceElement<S, C, R, A> {

	/**
	 * Returns the value of the '<em><b>Instance Selectors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Selectors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A list of InstanceSelectors that can be used to select a certain subset of the list of matched SourceSectionAttributes that will be used to calculated the value(s) represented by this DynamicSourceElement.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Instance Selectors</em>' containment reference list.
	 * @see pamtram.structure.StructurePackage#getGlobalDynamicSourceElement_InstanceSelectors()
	 * @model containment="true"
	 * @generated
	 */
	EList<InstanceSelectorType> getInstanceSelectors();
} // GlobalDynamicSourceElement
