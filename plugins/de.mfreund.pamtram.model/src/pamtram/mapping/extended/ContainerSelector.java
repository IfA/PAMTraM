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

} // ModelConnectionHint
