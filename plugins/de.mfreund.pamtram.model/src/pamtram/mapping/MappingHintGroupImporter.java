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
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;

import pamtram.NamedElement;
import pamtram.mapping.extended.MappingHintType;
import pamtram.structure.target.TargetSectionClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hint Group Importer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A MappingHintGroupImporter does not specify its own TargetSection to be instantiated but 'imports' an existing (exported) MappingHintGroup instead.
 * <br />
 * Importing thereby means that all values that have been collected for the MappingHints defined in the exported MappingHintGroup are reused during the instantiation.
 * <br /><br />
 * Note: There is a difference between (1) 'extending' and (2) 'importing' MappingHintGroups:
 * <br />
 * (1) Extending a HintGroup means that all MappingHints defined in the extended HintGroup are added to the Extending HintGroup (before execution of the transformation).
 * (2) Importing a HintGroup means that the VALUES of all MappingHints defined in the exported HintGroup are used when instantiating the HintGroupImporter (during the execution of the transformation).
 * <br /><br />
 * In most cases, 'extending' HintGroups will be the desired behavior. Importing HintGroups is only necessary for a few special use cases.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.MappingHintGroupImporter#getHintGroup <em>Hint Group</em>}</li>
 *   <li>{@link pamtram.mapping.MappingHintGroupImporter#getContainer <em>Container</em>}</li>
 *   <li>{@link pamtram.mapping.MappingHintGroupImporter#getMappingHints <em>Mapping Hints</em>}</li>
 *   <li>{@link pamtram.mapping.MappingHintGroupImporter#getParentMapping <em>Parent Mapping</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getMappingHintGroupImporter()
 * @model
 * @generated
 */
public interface MappingHintGroupImporter extends NamedElement, InstantiableMappingHintGroup {
	/**
	 * Returns the value of the '<em><b>Hint Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hint Group</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The existing (exported) MappingHintGroup that is imported by this HintGroupImporter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Hint Group</em>' reference.
	 * @see #setHintGroup(ExportedMappingHintGroup)
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroupImporter_HintGroup()
	 * @model required="true"
	 * @generated
	 */
	ExportedMappingHintGroup getHintGroup();

	/**
	 * Sets the value of the '{@link pamtram.mapping.MappingHintGroupImporter#getHintGroup <em>Hint Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hint Group</em>' reference.
	 * @see #getHintGroup()
	 * @generated
	 */
	void setHintGroup(ExportedMappingHintGroup value);

	/**
	 * Returns the value of the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An optional TargetSectionClass that (resp. instances of that) will be used as container for the instances created based on the TargetSection denoted by the imported MappingHintGroup.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Container</em>' reference.
	 * @see #isSetContainer()
	 * @see #unsetContainer()
	 * @see #setContainer(TargetSectionClass)
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroupImporter_Container()
	 * @model unsettable="true"
	 * @generated
	 */
	TargetSectionClass getContainer();

	/**
	 * Sets the value of the '{@link pamtram.mapping.MappingHintGroupImporter#getContainer <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' reference.
	 * @see #isSetContainer()
	 * @see #unsetContainer()
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(TargetSectionClass value);

	/**
	 * Unsets the value of the '{@link pamtram.mapping.MappingHintGroupImporter#getContainer <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetContainer()
	 * @see #getContainer()
	 * @see #setContainer(TargetSectionClass)
	 * @generated
	 */
	void unsetContainer();

	/**
	 * Returns whether the value of the '{@link pamtram.mapping.MappingHintGroupImporter#getContainer <em>Container</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Container</em>' reference is set.
	 * @see #unsetContainer()
	 * @see #getContainer()
	 * @see #setContainer(TargetSectionClass)
	 * @generated
	 */
	boolean isSetContainer();

	/**
	 * Returns the value of the '<em><b>Mapping Hints</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.extended.MappingHintType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Hints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An optional list of MappingHints refining the imported MappingHintGroup. The specified MappingHints will be added to those already defined by the imported MappingHintGroup.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mapping Hints</em>' containment reference list.
	 * @see #isSetMappingHints()
	 * @see #unsetMappingHints()
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroupImporter_MappingHints()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
	EList<MappingHintType> getMappingHints();

	/**
	 * Unsets the value of the '{@link pamtram.mapping.MappingHintGroupImporter#getMappingHints <em>Mapping Hints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMappingHints()
	 * @see #getMappingHints()
	 * @generated
	 */
	void unsetMappingHints();

	/**
	 * Returns whether the value of the '{@link pamtram.mapping.MappingHintGroupImporter#getMappingHints <em>Mapping Hints</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Mapping Hints</em>' containment reference list is set.
	 * @see #unsetMappingHints()
	 * @see #getMappingHints()
	 * @generated
	 */
	boolean isSetMappingHints();

	/**
	 * Returns the value of the '<em><b>Parent Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Mapping</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Mapping</em>' reference.
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroupImporter_ParentMapping()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='\r\nreturn this.eContainer() instanceof &lt;%pamtram.mapping.Mapping%&gt; ? (Mapping) this.eContainer() : null;'"
	 * @generated
	 */
	Mapping getParentMapping();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='Object[] hints = getMappingHints().stream().filter(h -&gt; !(h instanceof DeactivatableElement) || !((&lt;%pamtram.DeactivatableElement%&gt;) h).isDeactivated()).toArray();\r\nreturn new &lt;%org.eclipse.emf.common.util.BasicEList%&gt;.UnmodifiableEList&lt;&gt;(hints.length, hints);'"
	 * @generated
	 */
	EList<MappingHintType> getActiveMappingHints();

} // MappingHintGroupImporter
