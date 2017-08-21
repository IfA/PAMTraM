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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif(!(this.eContainer().eContainer() instanceof &lt;%pamtram.mapping.MappingHintGroupType%&gt;) || this.getSource() == null || !(this.getSource().eContainer() instanceof pamtram.structure.generic.Class&lt;?, ?, ?, ?&gt;)) {\r\n\treturn true;\r\n}\r\n\r\n&lt;%pamtram.structure.target.TargetSection%&gt; targetSection = ((MappingHintGroupType) this.eContainer().eContainer()).getTargetSection();\r\n\r\nboolean result = this.getSource() == null || targetSection == null ? true : ((pamtram.structure.generic.Class&lt;?, ?, ?, ?&gt;) this.getSource().eContainer()).getEClass().getEAllContainments().parallelStream().anyMatch(r -&gt; r.getEReferenceType().isSuperTypeOf(targetSection.getEClass()));\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"The type of the parent hint group\'s target section (\'\" + \r\n\t\t((MappingHintGroupType) this.eContainer().eContainer()).getTargetSection().getEClass().getName() + \r\n\t\t\"\') cannot be connected to (contained in) the type of the class containing the target attribute (\'\" + \r\n\t\t((pamtram.structure.generic.Class&lt;?, ?, ?, ?&gt;) this.getSource().eContainer()).getName() + \"\')!\";\r\n\r\n\tdiagnostics.add(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR,\r\n\t\t\t&lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tExtendedValidator.CONTAINER_SELECTOR_TARGET_ATTRIBUTE__VALIDATE_SOURCE_MATCHES_POSSIBLE_CONTAINER_TYPE,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.structure.StructurePackage%&gt;.Literals.DYNAMIC_SOURCE_ELEMENT__SOURCE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateTargetClassMatchesPossibleContainerType(DiagnosticChain diagnostics, Map<?, ?> context);

} // ModelConnectionHint
