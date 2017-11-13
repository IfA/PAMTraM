/**
 */
package pamtram.mapping;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import pamtram.NamedElement;
import pamtram.mapping.extended.AttributeMapping;
import pamtram.mapping.extended.CardinalityMapping;
import pamtram.mapping.extended.ContainerSelector;
import pamtram.mapping.extended.MappingHint;
import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.structure.target.TargetSection;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hint Group Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An abstract super-type for elements describing some kind of MappingHintGroup that will lead to the instantiation of a specified TargetSection.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.MappingHintGroupType#getTargetSection <em>Target Section</em>}</li>
 *   <li>{@link pamtram.mapping.MappingHintGroupType#getMappingHints <em>Mapping Hints</em>}</li>
 *   <li>{@link pamtram.mapping.MappingHintGroupType#getExtend <em>Extend</em>}</li>
 *   <li>{@link pamtram.mapping.MappingHintGroupType#getAttributeMappings <em>Attribute Mappings</em>}</li>
 *   <li>{@link pamtram.mapping.MappingHintGroupType#getCardinalityMappings <em>Cardinality Mappings</em>}</li>
 *   <li>{@link pamtram.mapping.MappingHintGroupType#getReferenceTargetSelectors <em>Reference Target Selectors</em>}</li>
 *   <li>{@link pamtram.mapping.MappingHintGroupType#getContainerSelectors <em>Container Selectors</em>}</li>
 *   <li>{@link pamtram.mapping.MappingHintGroupType#getAllMappingHints <em>All Mapping Hints</em>}</li>
 *   <li>{@link pamtram.mapping.MappingHintGroupType#getAllExtend <em>All Extend</em>}</li>
 *   <li>{@link pamtram.mapping.MappingHintGroupType#getAllExtending <em>All Extending</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getMappingHintGroupType()
 * @model abstract="true"
 * @generated
 */
public interface MappingHintGroupType extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Target Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target MM Section</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The TargetSection to be instantiated based on this MappingHintGroup.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target Section</em>' reference.
	 * @see #setTargetSection(TargetSection)
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroupType_TargetSection()
	 * @model required="true"
	 * @generated
	 */
	TargetSection getTargetSection();

	/**
	 * Sets the value of the '{@link pamtram.mapping.MappingHintGroupType#getTargetSection <em>Target Section</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Section</em>' reference.
	 * @see #getTargetSection()
	 * @generated
	 */
	void setTargetSection(TargetSection value);

	/**
	 * Returns the value of the '<em><b>Mapping Hints</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.extended.MappingHint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Hints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An optional list of MappingHints refining this Mapping resp. MappingHintGroup.
	 * <br /><br />
	 * MappingHints can be used to assist the transformation algorithm in the instantiation of TargetSections. For example, AttributeMappings can be added that specify how to set the values of the Attributes defined as part of the TargetSection.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mapping Hints</em>' containment reference list.
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroupType_MappingHints()
	 * @model containment="true"
	 * @generated
	 */
	EList<MappingHint> getMappingHints();

	/**
	 * Returns the value of the '<em><b>Extend</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.MappingHintGroupType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extend</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * One or multiple MappingHintGroups (that are part of an 'abstract' Mapping) which shall be extended by this MappingHintGroup.
	 * <br />
	 * All MappingHints that are defined in extended MappingHintGroups will be added to the MappingHints defined locally in this Group.
	 * <br /><br />
	 * Note: If an extended Group defines a MappingHint that is 'overwritten' by a MappingHint defined locally, it will not be added.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Extend</em>' reference list.
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroupType_Extend()
	 * @model
	 * @generated
	 */
	EList<MappingHintGroupType> getExtend();

	/**
	 * Returns the value of the '<em><b>Attribute Mappings</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.extended.AttributeMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Mappings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Mappings</em>' reference list.
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroupType_AttributeMappings()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='List&lt;&lt;%pamtram.mapping.extended.AttributeMapping%&gt;&gt; attributeMappings = this.getAllMappingHints().stream()\r\n\t\t\t\t.filter(hint -&gt; hint instanceof &lt;%pamtram.mapping.extended.AttributeMapping%&gt;).map(hint -&gt; (&lt;%pamtram.mapping.extended.AttributeMapping%&gt;) hint)\r\n\t\t\t\t.collect(&lt;%java.util.stream.Collectors%&gt;.toList());\r\nreturn new &lt;%org.eclipse.emf.ecore.util.EcoreEList%&gt;.UnmodifiableEList&lt;&gt;(this, &lt;%pamtram.mapping.MappingPackage%&gt;.Literals.MAPPING_HINT_GROUP_TYPE__ATTRIBUTE_MAPPINGS,\r\n\t\tattributeMappings.size(),attributeMappings.toArray());'"
	 * @generated
	 */
	EList<AttributeMapping> getAttributeMappings();

	/**
	 * Returns the value of the '<em><b>Cardinality Mappings</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.extended.CardinalityMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cardinality Mappings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cardinality Mappings</em>' reference list.
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroupType_CardinalityMappings()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='List&lt;&lt;%pamtram.mapping.extended.CardinalityMapping%&gt;&gt; cardinalityMappings = this.getAllMappingHints().stream()\r\n\t\t\t\t.filter(hint -&gt; hint instanceof &lt;%pamtram.mapping.extended.CardinalityMapping%&gt;).map(hint -&gt; (&lt;%pamtram.mapping.extended.CardinalityMapping%&gt;) hint)\r\n\t\t\t\t.collect(&lt;%java.util.stream.Collectors%&gt;.toList());\r\nreturn new &lt;%org.eclipse.emf.ecore.util.EcoreEList%&gt;.UnmodifiableEList&lt;&gt;(this, &lt;%pamtram.mapping.MappingPackage%&gt;.Literals.MAPPING_HINT_GROUP_TYPE__CARDINALITY_MAPPINGS,\r\n\t\tcardinalityMappings.size(),cardinalityMappings.toArray());'"
	 * @generated
	 */
	EList<CardinalityMapping> getCardinalityMappings();

	/**
	 * Returns the value of the '<em><b>Reference Target Selectors</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.extended.ReferenceTargetSelector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Target Selectors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Target Selectors</em>' reference list.
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroupType_ReferenceTargetSelectors()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='List&lt;&lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt;&gt; referenceTargetSelectors = this.getAllMappingHints().stream()\r\n\t\t\t\t.filter(hint -&gt; hint instanceof &lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt;).map(hint -&gt; (&lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt;) hint)\r\n\t\t\t\t.collect(&lt;%java.util.stream.Collectors%&gt;.toList());\r\nreturn new &lt;%org.eclipse.emf.ecore.util.EcoreEList%&gt;.UnmodifiableEList&lt;&gt;(this, &lt;%pamtram.mapping.MappingPackage%&gt;.Literals.MAPPING_HINT_GROUP_TYPE__REFERENCE_TARGET_SELECTORS,\r\n\t\treferenceTargetSelectors.size(),referenceTargetSelectors.toArray());'"
	 * @generated
	 */
	EList<ReferenceTargetSelector> getReferenceTargetSelectors();

	/**
	 * Returns the value of the '<em><b>Container Selectors</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.extended.ContainerSelector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container Selectors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container Selectors</em>' reference list.
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroupType_ContainerSelectors()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='List&lt;&lt;%pamtram.mapping.extended.ContainerSelector%&gt;&gt; containerSelectors = this.getAllMappingHints().stream()\r\n\t\t\t\t.filter(hint -&gt; hint instanceof &lt;%pamtram.mapping.extended.ContainerSelector%&gt;).map(hint -&gt; (&lt;%pamtram.mapping.extended.ContainerSelector%&gt;) hint)\r\n\t\t\t\t.collect(&lt;%java.util.stream.Collectors%&gt;.toList());\r\nreturn new &lt;%org.eclipse.emf.ecore.util.EcoreEList%&gt;.UnmodifiableEList&lt;&gt;(this, &lt;%pamtram.mapping.MappingPackage%&gt;.Literals.MAPPING_HINT_GROUP_TYPE__CONTAINER_SELECTORS,\r\n\t\tcontainerSelectors.size(),containerSelectors.toArray());'"
	 * @generated
	 */
	EList<ContainerSelector> getContainerSelectors();

	/**
	 * Returns the value of the '<em><b>All Mapping Hints</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.extended.MappingHint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Mapping Hints</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Mapping Hints</em>' reference list.
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroupType_AllMappingHints()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='Set&lt;&lt;%pamtram.mapping.extended.MappingHint%&gt;&gt; ret = new LinkedHashSet&lt;&gt;();\r\n\r\tret.addAll(this.getMappingHints());\r\n\r\tret.addAll(this.getAllExtend().stream().flatMap(s -&gt; s.getMappingHints().stream())\r\n\t\t\t\t\t.collect(&lt;%java.util.stream.Collectors%&gt;.toList()));\r\n\r\t// Filter those MappingHints that are overridden by more concrete hints\r\n\t\t//\r\n\t\tSet&lt;&lt;%pamtram.mapping.extended.MappingHint%&gt;&gt; overridenHints = ret.parallelStream().filter(h -&gt; h.getOverwrite() != null).map(MappingHint::getOverwrite).collect(&lt;%java.util.stream.Collectors%&gt;.toSet());\r\n\t\tret.removeAll(overridenHints);\r\n\r\t\treturn new &lt;%org.eclipse.emf.ecore.util.EcoreEList%&gt;.UnmodifiableEList&lt;&gt;(this,\r\n\t\t\t\t\t\t&lt;%pamtram.mapping.MappingPackage%&gt;.Literals.MAPPING_HINT_GROUP_TYPE__ALL_MAPPING_HINTS, ret.size(), ret.toArray());'"
	 * @generated
	 */
	EList<MappingHint> getAllMappingHints();

	/**
	 * Returns the value of the '<em><b>All Extend</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.MappingHintGroupType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Extend</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Extend</em>' reference list.
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroupType_AllExtend()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='Set&lt;Object&gt; ret = new HashSet&lt;&gt;();\r\n\r\nList&lt;&lt;%pamtram.mapping.MappingHintGroupType%&gt;&gt; toCheck = new ArrayList&lt;&gt;();\r\n\ttoCheck.add(this);\r\n\r\nwhile (!toCheck.isEmpty()) {\r\n\t&lt;%pamtram.mapping.MappingHintGroupType%&gt; next = toCheck.remove(0);\r\n\r\n\tList&lt;&lt;%pamtram.mapping.MappingHintGroupType%&gt;&gt; localToCheck = next.getExtend().stream().filter(e -&gt; !ret.contains(e))\r\n\t\t\t\t.collect(&lt;%java.util.stream.Collectors%&gt;.toList());\r\n\t\tret.addAll(localToCheck);\r\n\t\ttoCheck.addAll(localToCheck);\r\n\t}\r\n\r\nret.addAll(this.getExtend().stream().flatMap(s -&gt; s.getAllExtend().stream()).collect(&lt;%java.util.stream.Collectors%&gt;.toList()));\r\n\r\nreturn new &lt;%org.eclipse.emf.ecore.util.EcoreEList%&gt;.UnmodifiableEList&lt;&gt;(this, &lt;%pamtram.mapping.MappingPackage%&gt;.Literals.MAPPING_HINT_GROUP_TYPE__ALL_EXTEND, ret.size(),\r\n\t\t\tret.toArray());'"
	 * @generated
	 */
	EList<MappingHintGroupType> getAllExtend();

	/**
	 * Returns the value of the '<em><b>All Extending</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.MappingHintGroupType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Extending</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Extending</em>' reference list.
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroupType_AllExtending()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='Set&lt;Object&gt; extendingSections = new HashSet&lt;&gt;();\r\n\t\tIterator&lt;&lt;%org.eclipse.emf.common.notify.Notifier%&gt;&gt; it = this.eResource().getResourceSet().getAllContents();\r\n\t\twhile (it.hasNext()) {\r\n\t\t\t&lt;%org.eclipse.emf.common.notify.Notifier%&gt; next = it.next();\r\n\t\t\tif (next instanceof &lt;%pamtram.mapping.MappingHintGroupType%&gt; &amp;&amp; ((&lt;%pamtram.mapping.MappingHintGroupType%&gt;) next).getAllExtend().contains(this)) {\r\n\t\t\t\textendingSections.add(next);\r\n\t\t\t}\r\n\t\t}\r\n\r\treturn new &lt;%org.eclipse.emf.ecore.util.EcoreEList%&gt;.UnmodifiableEList&lt;&gt;(this, &lt;%pamtram.mapping.MappingPackage%&gt;.Literals.MAPPING_HINT_GROUP_TYPE__ALL_EXTENDING,\r\n\t\t\t\textendingSections.size(), extendingSections.toArray());'"
	 * @generated
	 */
	EList<MappingHintGroupType> getAllExtending();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n&lt;%pamtram.structure.source.SourceSection%&gt; sourceSection = ((&lt;%pamtram.mapping.Mapping%&gt;) this.eContainer()).getSourceSection();\r\n\r\nif (sourceSection == null) {\r\n\treturn true;\r\n}\r\n\r\n&lt;%java.util.List%&gt;&lt;SourceSection&gt; validExtends = new &lt;%java.util.ArrayList%&gt;&lt;&gt;();\r\nvalidExtends.add(sourceSection);\r\nvalidExtends.addAll(sourceSection.getAllExtend());\r\n\r\n&lt;%java.util.Optional%&gt;&lt;MappingHintGroupType&gt; result = this.getExtend().stream()\r\n\t\t.filter(hg -&gt; !validExtends.contains(((Mapping) hg.eContainer()).getSourceSection())).findFirst();\r\n\r\nif (result.isPresent() &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"The MappingHintGroup \'\" + result.get().getName() + \"\' may not be extended by this MappingHintGroup because the referenced SourceSections are not compatible!\";\r\n\r\n\tdiagnostics.add(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR,\r\n\t\t\t&lt;%pamtram.mapping.util.MappingValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMappingValidator.MAPPING_HINT_GROUP_TYPE__VALIDATE_EXTENDS_ONLY_VALID_HINT_GROUPS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.mapping.MappingPackage%&gt;.Literals.MAPPING_HINT_GROUP_TYPE__EXTEND }));\r\n\r\n}\r\n\r\nreturn !result.isPresent();'"
	 * @generated
	 */
	boolean validateExtendsOnlyValidHintGroups(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='Object[] hints = getAllMappingHints().stream().filter(h -&gt; !h.isDeactivated()).toArray();\r\nreturn new &lt;%org.eclipse.emf.common.util.BasicEList%&gt;.UnmodifiableEList&lt;&gt;(hints.length, hints);'"
	 * @generated
	 */
	EList<MappingHint> getActiveMappingHints();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this.getTargetSection() == null || !this.getTargetSection().isLibraryEntry()) {\r\n\treturn true;\r\n}\r\n\r\n// Check if the \'PAMTraM Library Nature\' is set for the project\r\n//\r\n&lt;%org.eclipse.core.resources.IFile%&gt; file = &lt;%de.tud.et.ifa.agtele.resources.ResourceHelper%&gt;.getFileForResource(this.eResource());\r\nif (file == null || file.getProject() == null) {\r\n\treturn true;\r\n}\r\n\r\nString errorMessage = \"The \'PAMTraM Library Nature\' is not activated for this project. Thus, LibraryEntries may not be used as TargetSections! You can activate the nature in the project properties...\";\r\n\r\ntry {\r\n\tif (!Boolean.parseBoolean(&lt;%de.mfreund.pamtram.properties.PropertySupplier%&gt;.getResourceProperty(&lt;%de.mfreund.pamtram.properties.PropertySupplier%&gt;.PROP_HAS_LIBRARY_NATURE,\r\n\t\t\tfile.getProject()))) {\r\n\t\tif (diagnostics != null) {\r\n\t\t\tdiagnostics.add(new BasicDiagnostic(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR, &lt;%pamtram.mapping.util.MappingValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t&lt;%pamtram.mapping.util.MappingValidator%&gt;.MAPPING_HINT_GROUP_TYPE__VALIDATE_DO_NOT_USE_LIBRARY_ELEMENTS_WITHOUT_LIBRARY_NATURE,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\t\t\tnew Object[] { this, &lt;%pamtram.mapping.MappingPackage%&gt;.Literals.MAPPING_HINT_GROUP_TYPE__TARGET_SECTION }));\r\n\t\t}\r\n\t\treturn false;\r\n\t}\r\n} catch (&lt;%org.eclipse.core.runtime.CoreException%&gt; e) {\r\n\te.printStackTrace();\r\n}\r\nreturn true;'"
	 * @generated
	 */
	boolean validateDoNotUseLibraryElementsWithoutLibraryNature(DiagnosticChain diagnostics, Map<?, ?> context);

} // MappingHintGroupType
