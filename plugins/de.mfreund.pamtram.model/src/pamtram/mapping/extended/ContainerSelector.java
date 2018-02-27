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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (!(this.eContainer() instanceof &lt;%pamtram.mapping.MappingHintGroupType%&gt;) || this.getTargetClass() == null) {\r\n\t\t\treturn true;\r\n\t\t}\r\n\r\t&lt;%pamtram.structure.target.TargetSection%&gt; targetSection = ((&lt;%pamtram.mapping.MappingHintGroupType%&gt;) this.eContainer()).getTargetSection();\r\n\r\tif (targetSection == null || targetSection.getEClass() == null) {\r\n\t\t\treturn true;\r\n\t\t}\r\n\r\tboolean result = this.getTargetClass().getEClass().getEAllContainments().parallelStream()\r\n\t\t\t\t.anyMatch(r -&gt; r.getEReferenceType().isSuperTypeOf(targetSection.getEClass()));\r\n\r\tif (!result &amp;&amp; diagnostics != null) {\r\n\r\t\tint severity = &lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR;\r\n\t\t\tString errorMessage = \"The type of the parent hint group\'s target section (\'\"\r\n\t\t\t\t\t+ targetSection.getEClass().getName()\r\n\t\t\t\t\t+ \"\') cannot be connected to (contained in) the specified target class (\'\"\r\n\t\t\t\t\t+ this.getTargetClass().getName() + \"\')!\";\r\n\r\t\t// If the &lt;%pamtram.structure.target.TargetSection%&gt; is abstract, we need to check if there are some concrete sub-Sections that may act\r\n\t\t\t// as container\r\n\t\t\t//\r\n\t\t\tif (this.getTargetClass().getContainingSection().isAbstract()) {\r\n\r\t\t\tList&lt;&lt;%pamtram.structure.target.TargetSection%&gt;&gt; extendingSections = &lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;.UsageCrossReferencer\r\n\t\t\t\t\t\t.find(this.getTargetClass().getContainingSection(), this.eResource().getResourceSet())\r\n\t\t\t\t\t\t.parallelStream()\r\n\t\t\t\t\t\t.filter(s -&gt; pamtram.structure.generic.GenericPackage.Literals.SECTION__EXTEND.equals(s.getEStructuralFeature()))\r\n\t\t\t\t\t\t.map(s -&gt; (&lt;%pamtram.structure.target.TargetSection%&gt;) s.getEObject()).collect(&lt;%java.util.stream.Collectors%&gt;.toList());\r\n\r\t\t\tif (extendingSections.stream()\r\n\t\t\t\t\t\t.anyMatch(concreteSection -&gt; concreteSection.getEClass().getEAllContainments().parallelStream()\r\n\t\t\t\t\t\t\t\t.anyMatch(r -&gt; r.getEReferenceType().isSuperTypeOf(targetSection.getEClass())))) {\r\n\t\t\t\t\tseverity = &lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.WARNING;\r\n\t\t\t\t\terrorMessage = \"The type of the parent hint group\'s target section (\'\"\r\n\t\t\t\t\t\t\t+ targetSection.getEClass().getName()\r\n\t\t\t\t\t\t\t+ \"\') cannot be connected to (contained in) the specified target class (\'\"\r\n\t\t\t\t\t\t\t+ this.getTargetClass().getName()\r\n\t\t\t\t\t\t\t+ \"\'). However, there are some concrete sub-classes that are valid containers and will be used instead!\";\r\n\t\t\t\t}\r\n\t\t\t}\r\n\r\t\tdiagnostics.add(new BasicDiagnostic(severity, &lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t&lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.CONTAINER_SELECTOR__VALIDATE_TARGET_CLASS_MATCHES_POSSIBLE_CONTAINER_TYPE,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\t\t\tnew Object[] { this, &lt;%pamtram.structure.StructurePackage%&gt;.Literals.TARGET_INSTANCE_SELECTOR__TARGET_CLASS }));\r\n\r\t}\r\n\r\treturn result;'"
	 * @generated
	 */
	boolean validateTargetClassMatchesPossibleContainerType(DiagnosticChain diagnostics, Map<?, ?> context);

} // ModelConnectionHint
