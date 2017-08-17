/**
 */
package pamtram.mapping.extended;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import pamtram.ConditionalElement;
import pamtram.DeactivatableElement;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An abstract super-type for all MappingHints that can be used in MappingHintGroups.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.extended.MappingHint#getOverwrite <em>Overwrite</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.extended.ExtendedPackage#getMappingHint()
 * @model abstract="true"
 * @generated
 */
public interface MappingHint extends MappingHintType, ConditionalElement, DeactivatableElement {

	/**
	 * Returns the value of the '<em><b>Overwrite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A MappingHint from an extended MappingHintGroup that shall not be added to this MappingHintGroup but be overwritten instead.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Overwrite</em>' reference.
	 * @see #setOverwrite(MappingHint)
	 * @see pamtram.mapping.extended.ExtendedPackage#getMappingHint_Overwrite()
	 * @model
	 * @generated
	 */
	MappingHint getOverwrite();

	/**
	 * Sets the value of the '{@link pamtram.mapping.extended.MappingHint#getOverwrite <em>Overwrite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overwrite</em>' reference.
	 * @see #getOverwrite()
	 * @generated
	 */
	void setOverwrite(MappingHint value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this.overwrite == null) {\r\n\t\t\treturn true;\r\n\t\t}\r\n\r\tboolean ret = true;\r\n\t\tString message = \"\";\r\n\r\tif (this.eClass() != this.overwrite.eClass()) {\r\n\t\t\tret = false;\r\n\t\t\tmessage = \"MappingHints must only overwrite MappingHints of the same type!\";\r\n\t\t}\r\n\r\tif (((&lt;%pamtram.mapping.MappingHintGroupType%&gt;) this.eContainer()).getExtend().isEmpty()\r\n\t\t\t\t|| ((&lt;%pamtram.mapping.MappingHintGroupType%&gt;) this.eContainer()).getExtend().stream()\r\n\t\t\t\t\t\t.noneMatch(hg -&gt; hg.getMappingHints().contains(this.overwrite))) {\r\n\t\t\tret = false;\r\n\t\t\tmessage = \"The overwritten &lt;%pamtram.mapping.extended.MappingHint%&gt; is not part of a MappingHintGroup that is extended by the HintGroup containing this MappingHint!\";\r\n\t\t}\r\n\r\tif (this instanceof &lt;%pamtram.mapping.extended.AttributeMapping%&gt;\r\n\t\t\t\t&amp;&amp; ((&lt;%pamtram.mapping.extended.AttributeMapping%&gt;) this).getTarget() != ((&lt;%pamtram.mapping.extended.AttributeMapping%&gt;) this.overwrite).getTarget()) {\r\n\t\t\tret = false;\r\n\t\t\tmessage = \"An &lt;%pamtram.mapping.extended.AttributeMapping%&gt; must only overwrite another &lt;%pamtram.mapping.extended.AttributeMapping%&gt; pointing to the same TargetSectionAttribute!\";\r\n\t\t} else if (this instanceof &lt;%pamtram.mapping.extended.CardinalityMapping%&gt;\r\n\t\t\t\t&amp;&amp; ((&lt;%pamtram.mapping.extended.CardinalityMapping%&gt;) this).getTarget() != ((&lt;%pamtram.mapping.extended.CardinalityMapping%&gt;) this.overwrite).getTarget()) {\r\n\t\t\tret = false;\r\n\t\t\tmessage = \"A &lt;%pamtram.mapping.extended.CardinalityMapping%&gt; must only overwrite another &lt;%pamtram.mapping.extended.CardinalityMapping%&gt; pointing to the same TargetSectionClass!\";\r\n\t\t} else if (this instanceof &lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt; &amp;&amp; ((&lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt;) this)\r\n\t\t\t\t.getAffectedReference() != ((&lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt;) this.overwrite).getAffectedReference()) {\r\n\t\t\tret = false;\r\n\t\t\tmessage = \"A &lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt; must only overwrite another &lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt; pointing to the same TargetSectionReference!\";\r\n\t\t}\r\n\r\tif (!ret &amp;&amp; diagnostics != null) {\r\n\t\t\tdiagnostics.add(new BasicDiagnostic(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR, &lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t&lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.MAPPING_HINT__VALIDATE_OVERWRITES_VALID_MAPPING_HINT, message,\r\n\t\t\t\t\tnew Object[] { this, &lt;%pamtram.mapping.extended.ExtendedPackage%&gt;.Literals.MAPPING_HINT__OVERWRITE }));\r\n\t\t}\r\n\r\treturn ret;'"
	 * @generated
	 */
	boolean validateOverwritesValidMappingHint(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (!(this.eContainer instanceof &lt;%pamtram.mapping.MappingHintGroupType%&gt;) || this.overwrite != null) {\r\n\t\t\treturn true;\r\n\t\t}\r\n\r\tList&lt;&lt;%pamtram.mapping.extended.MappingHint%&gt;&gt; hintsOfExtendedHintGroups = ((&lt;%pamtram.mapping.MappingHintGroupType%&gt;) this.eContainer()).getExtend().stream()\r\n\t\t\t\t.flatMap(hg -&gt; hg.getMappingHints().stream()).collect(&lt;%java.util.stream.Collectors%&gt;.toList());\r\n\r\tif (hintsOfExtendedHintGroups.isEmpty()) {\r\n\t\t\treturn true;\r\n\t\t}\r\n\r\tOptional&lt;&lt;%pamtram.mapping.extended.MappingHint%&gt;&gt; hintToConsider = &lt;%java.util.Optional%&gt;.empty();\r\n\r\tif (this instanceof &lt;%pamtram.mapping.extended.AttributeMapping%&gt; &amp;&amp; ((&lt;%pamtram.mapping.extended.AttributeMapping%&gt;) this).getTarget() != null) {\r\n\r\t\thintToConsider = hintsOfExtendedHintGroups.stream().filter(h -&gt; h instanceof &lt;%pamtram.mapping.extended.AttributeMapping%&gt;)\r\n\t\t\t\t\t.filter(h -&gt; ((&lt;%pamtram.mapping.extended.AttributeMapping%&gt;) this).getTarget().equals(((&lt;%pamtram.mapping.extended.AttributeMapping%&gt;) h).getTarget()))\r\n\t\t\t\t\t.findAny();\r\n\r\t} else if (this instanceof &lt;%pamtram.mapping.extended.CardinalityMapping%&gt; &amp;&amp; ((&lt;%pamtram.mapping.extended.CardinalityMapping%&gt;) this).getTarget() != null) {\r\n\r\t\thintToConsider = hintsOfExtendedHintGroups.stream().filter(h -&gt; h instanceof &lt;%pamtram.mapping.extended.CardinalityMapping%&gt;)\r\n\t\t\t\t\t.filter(h -&gt; ((&lt;%pamtram.mapping.extended.CardinalityMapping%&gt;) this).getTarget().equals(((&lt;%pamtram.mapping.extended.CardinalityMapping%&gt;) h).getTarget()))\r\n\t\t\t\t\t.findAny();\r\n\r\t} else if (this instanceof &lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt;\r\n\t\t\t\t&amp;&amp; ((&lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt;) this).getAffectedReference() != null) {\r\n\r\t\thintToConsider = hintsOfExtendedHintGroups.stream().filter(h -&gt; h instanceof &lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt;)\r\n\t\t\t\t\t.filter(h -&gt; ((&lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt;) this).getAffectedReference()\r\n\t\t\t\t\t\t\t.equals(((&lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt;) h).getAffectedReference()))\r\n\t\t\t\t\t.findAny();\r\n\t\t}\r\n\r\tif (!hintToConsider.isPresent()) {\r\n\t\t\treturn true;\r\n\t\t}\r\n\r\tString message = \"The hint \'\" + hintToConsider.get().getName() + \"\' of the extended MappingHintGroup \"\r\n\t\t\t\t+ (hintToConsider.get().eContainer() instanceof &lt;%pamtram.mapping.MappingHintGroupType%&gt;\r\n\t\t\t\t\t\t? \"\'\" + ((&lt;%pamtram.mapping.MappingHintGroupType%&gt;) hintToConsider.get().eContainer()).getName() + \"\' \"\r\n\t\t\t\t\t\t: \"\")\r\n\t\t\t\t+ \"affects the same target element. Consider overwriting this hint instead of providing additional hint values...\";\r\n\r\tif (diagnostics != null) {\r\n\t\t\tdiagnostics.add(new BasicDiagnostic(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.WARNING, &lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t&lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.MAPPING_HINT__VALIDATE_CONSIDER_OVERWRITING_HINT, message,\r\n\t\t\t\t\tnew Object[] { this, &lt;%pamtram.mapping.extended.ExtendedPackage%&gt;.Literals.MAPPING_HINT__OVERWRITE }));\r\n\t\t}\r\n\r\treturn false;'"
	 * @generated
	 */
	boolean validateConsiderOverwritingHint(DiagnosticChain diagnostics, Map<?, ?> context);
} // MappingHint
