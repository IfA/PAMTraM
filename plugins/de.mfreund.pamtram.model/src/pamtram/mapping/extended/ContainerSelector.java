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
package pamtram.mapping.extended;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import pamtram.structure.TargetInstanceSelector;


/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>ContainerSelector</b></em>'. <!-- end-user-doc
 * -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link pamtram.mapping.extended.ContainerSelector#getTargetAttributes <em>Target Attributes</em>}</li>
 * <li>{@link pamtram.mapping.extended.ContainerSelector#getSourceElements <em>Source Elements</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getContainerSelector()
 * @model
 * @generated
 */
public interface ContainerSelector extends MappingHint, TargetInstanceSelector {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif (!(eContainer() instanceof &lt;%pamtram.mapping.MappingHintGroupType%&gt;) || getTargetClass() == null) {\r\n\treturn true;\r\n}\r\n\r\n&lt;%pamtram.structure.target.TargetSection%&gt; targetSection = ((MappingHintGroupType) eContainer()).getTargetSection();\r\n\r\nif (targetSection == null || targetSection.getEClass() == null) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = pamtram.util.XSDAnyContentUtil\r\n\t\t.getEAllReferencesIncludingVirtualAnyContentReference(getTargetClass().getEClass(),\r\n\t\t\t\t&lt;%de.tud.et.ifa.agtele.emf.connecting.AllowedReferenceType%&gt;.CONTAINMENT)\r\n\t\t.parallelStream().anyMatch(r -&gt; r.getEReferenceType().isSuperTypeOf(targetSection.getEClass()));\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tint severity = &lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR;\r\n\tString errorMessage = \"The type of the parent hint group\'s target section (\'\"\r\n\t\t\t+ targetSection.getEClass().getName()\r\n\t\t\t+ \"\') cannot be connected to (contained in) the specified target class (\'\"\r\n\t\t\t+ getTargetClass().getName() + \"\')!\";\r\n\r\n\t// If the TargetSection is abstract, we need to check if there are some concrete sub-Sections that may act\r\n\t// as container\r\n\t//\r\n\tif (getTargetClass().getContainingSection().isAbstract()) {\r\n\r\n\t\t&lt;%java.util.List%&gt;&lt;TargetSection&gt; extendingSections = &lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;.UsageCrossReferencer\r\n\t\t\t\t.find(getTargetClass().getContainingSection(), eResource().getResourceSet()).parallelStream()\r\n\t\t\t\t.filter(s -&gt; pamtram.structure.generic.GenericPackage.Literals.SECTION__EXTEND\r\n\t\t\t\t\t\t.equals(s.getEStructuralFeature()))\r\n\t\t\t\t.map(s -&gt; (TargetSection) s.getEObject()).collect(&lt;%java.util.stream.Collectors%&gt;.toList());\r\n\r\n\t\tif (extendingSections.stream()\r\n\t\t\t\t.anyMatch(concreteSection -&gt; concreteSection.getEClass().getEAllContainments().parallelStream()\r\n\t\t\t\t\t\t.anyMatch(r -&gt; r.getEReferenceType().isSuperTypeOf(targetSection.getEClass())))) {\r\n\t\t\tseverity = Diagnostic.WARNING;\r\n\t\t\terrorMessage = \"The type of the parent hint group\'s target section (\'\"\r\n\t\t\t\t\t+ targetSection.getEClass().getName()\r\n\t\t\t\t\t+ \"\') cannot be connected to (contained in) the specified target class (\'\"\r\n\t\t\t\t\t+ getTargetClass().getName()\r\n\t\t\t\t\t+ \"\'). However, there are some concrete sub-classes that are valid containers and will be used instead!\";\r\n\t\t}\r\n\t}\r\n\r\n\tdiagnostics.add(new BasicDiagnostic(severity, &lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\tExtendedValidator.CONTAINER_SELECTOR__VALIDATE_TARGET_CLASS_MATCHES_POSSIBLE_CONTAINER_TYPE,\r\n\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.structure.StructurePackage%&gt;.Literals.TARGET_INSTANCE_SELECTOR__TARGET_CLASS }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateTargetClassMatchesPossibleContainerType(DiagnosticChain diagnostics, Map<?, ?> context);

} // ModelConnectionHint
