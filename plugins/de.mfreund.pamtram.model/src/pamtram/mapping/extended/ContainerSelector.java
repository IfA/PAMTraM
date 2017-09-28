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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (!(this.eContainer() instanceof &lt;%pamtram.mapping.MappingHintGroupType%&gt;) || this.getTargetClass() == null) {\r\n\t\t\treturn true;\r\n\t\t}\r\n\r\t&lt;%pamtram.structure.target.TargetSection%&gt; targetSection = ((&lt;%pamtram.mapping.MappingHintGroupType%&gt;) this.eContainer()).getTargetSection();\r\n\r\tboolean result = targetSection == null || targetSection.getEClass() == null ? true\r\n\t\t\t\t: this.getTargetClass().getEClass().getEAllContainments().parallelStream()\r\n\t\t\t\t\t\t.anyMatch(r -&gt; r.getEReferenceType().isSuperTypeOf(targetSection.getEClass()));\r\n\r\tif (!result &amp;&amp; diagnostics != null) {\r\n\r\t\tString errorMessage = \"The type of the parent hint group\'s target section (\'\"\r\n\t\t\t\t\t+ targetSection.getEClass().getName()\r\n\t\t\t\t\t+ \"\') cannot be connected to (contained in) the specified target class (\'\"\r\n\t\t\t\t\t+ this.getTargetClass().getName() + \"\')!\";\r\n\r\t\tdiagnostics.add(new BasicDiagnostic(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR, &lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t&lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.CONTAINER_SELECTOR__VALIDATE_TARGET_CLASS_MATCHES_POSSIBLE_CONTAINER_TYPE,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\t\t\tnew Object[] { this, &lt;%pamtram.structure.StructurePackage%&gt;.Literals.TARGET_INSTANCE_SELECTOR__TARGET_CLASS }));\r\n\r\t}\r\n\r\treturn result;'"
	 * @generated
	 */
	boolean validateTargetClassMatchesPossibleContainerType(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (!(this.eContainer() instanceof &lt;%pamtram.mapping.MappingHintGroupType%&gt;) || this.getTargetClass() == null) {\r\n\treturn true;\r\n}\r\n\r\n&lt;%pamtram.structure.target.TargetSection%&gt; targetSection = ((&lt;%pamtram.mapping.MappingHintGroupType%&gt;) this.eContainer()).getTargetSection();\r\nboolean result = targetSection == null || targetSection.getEClass() == null ? true\r\n\t\t: this.getTargetClass().getEClass().getEAllContainments().parallelStream()\r\n\t\t\t\t.anyMatch(r -&gt; r.getEReferenceType().isSuperTypeOf(targetSection.getEClass()));\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\tString errorMessage = \"The type of the parent hint group\'s target section (\'\"\r\n\t\t\t+ targetSection.getEClass().getName()\r\n\t\t\t+ \"\') cannot be connected to (contained in) the specified target class (\'\"\r\n\t\t\t+ this.getTargetClass().getName() + \"\')!\";\r\n\tdiagnostics.add(new BasicDiagnostic(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR, &lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t&lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.CONTAINER_SELECTOR__VALIDATE_TARGET_CLASS_MATCHES_POSSIBLE_CONTAINER_TYPE,\r\n\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.structure.StructurePackage%&gt;.Literals.TARGET_INSTANCE_SELECTOR__TARGET_CLASS }));\r\n\r}\r\n\r\r\nreturn result;'"
	 * @generated
	 */
	boolean validateReferenceAttribute(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this.referenceAttribute == null || this.targetClass == null\r\n\t\t\t\t|| this.targetClass.getContainingSection() == null) {\r\n\t\t\treturn true;\r\n\t\t}\r\n\r\t// If a \'targetClass\' has already been set for this \'TargetInstanceSelector\', allow only \'referenceAttributes\'\r\n\t\t// that are part of the same &lt;%pamtram.structure.target.TargetSection%&gt; as the specified \'targetClass\' (or of one of the extended\r\n\t\t// sections).\r\n\t\t//\r\n\r\t&lt;%pamtram.structure.target.TargetSection%&gt; section = this.targetClass.getContainingSection();\r\n\r\tList&lt;&lt;%pamtram.structure.target.TargetSection%&gt;&gt; allowedSections = new ArrayList&lt;&gt;(&lt;%java.util.Arrays%&gt;.asList(section));\r\n\t\tallowedSections.addAll(section.getAllExtend());\r\n\r\tboolean result = allowedSections.contains(this.referenceAttribute.getContainingSection());\r\n\r\tif (!result &amp;&amp; diagnostics != null) {\r\n\r\t\tString errorMessage = \"The \'referenceAttribute\' must be contained in the same &lt;%pamtram.structure.target.TargetSection%&gt; (or an extended section) as the \'targetClass\'!\";\r\n\r\t\tdiagnostics.add(new BasicDiagnostic(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR, &lt;%pamtram.structure.util.StructureValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t&lt;%pamtram.structure.util.StructureValidator%&gt;.TARGET_INSTANCE_SELECTOR__VALIDATE_REFERENCE_ATTRIBUTE_IS_VALID, errorMessage,\r\n\t\t\t\t\tnew Object[] { this, &lt;%pamtram.structure.StructurePackage%&gt;.Literals.TARGET_INSTANCE_SELECTOR__REFERENCE_ATTRIBUTE }));\r\n\r\t}\r\n\r\treturn result;'"
	 * @generated
	 */
	boolean validateReferenceAttributeIsValid(DiagnosticChain diagnostics, Map<?, ?> context);

} // ModelConnectionHint
