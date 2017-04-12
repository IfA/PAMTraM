/**
 */
package pamtram.mapping.extended;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.common.util.EList;
import pamtram.ExpressionElement;
import pamtram.ModifiableElement;
import pamtram.structure.generic.MetaModelElement;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;
import pamtram.structure.target.TargetSectionClass;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cardinality Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.extended.CardinalityMapping#getSource <em>Source</em>}</li>
 *   <li>{@link pamtram.mapping.extended.CardinalityMapping#getTarget <em>Target</em>}</li>
 *   <li>{@link pamtram.mapping.extended.CardinalityMapping#getSourceElements <em>Source Elements</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.extended.ExtendedPackage#getCardinalityMapping()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='sourceClassMatchesSection sourceClassIsVariableCardinality targetClassMatchesSection targetClassIsVariableCardinality noCardinalityMappingForSourceSectionRoot'"
 * @generated
 */
public interface CardinalityMapping extends MappingHint, ExpressionElement, ModifiableElement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(MetaModelElement)
	 * @see pamtram.mapping.extended.ExtendedPackage#getCardinalityMapping_Source()
	 * @model
	 * @generated
	 */
	MetaModelElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> getSource();

	/**
	 * Sets the value of the '{@link pamtram.mapping.extended.CardinalityMapping#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(MetaModelElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(TargetSectionClass)
	 * @see pamtram.mapping.extended.ExtendedPackage#getCardinalityMapping_Target()
	 * @model required="true"
	 * @generated
	 */
	TargetSectionClass getTarget();

	/**
	 * Sets the value of the '{@link pamtram.mapping.extended.CardinalityMapping#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(TargetSectionClass value);

	/**
	 * Returns the value of the '<em><b>Source Elements</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.extended.CardinalityMappingSourceInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Elements</em>' containment reference list.
	 * @see pamtram.mapping.extended.ExtendedPackage#getCardinalityMapping_SourceElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<CardinalityMappingSourceInterface> getSourceElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif(this.getSource() == null || !(this.eContainer().eContainer() instanceof <%pamtram.mapping.Mapping%>) || ((Mapping) this.eContainer().eContainer()).getSourceSection() == null) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = this.getSource().getContainingSection() == ((Mapping) this.eContainer().eContainer()).getSourceSection();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The source element \'\" + this.getSource().getName() + \"\' is not part of the source section referenced by parent mapping \'\" + ((pamtram.mapping.Mapping) this.eContainer().eContainer()).getName() + \"\'!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tExtendedValidator.CARDINALITY_MAPPING__VALIDATE_SOURCE_ELEMENT_MATCHES_SECTION,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.extended.ExtendedPackage%>.Literals.CARDINALITY_MAPPING__SOURCE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateSourceElementMatchesSection(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif(this.getTarget() == null || !(this.eContainer() instanceof <%pamtram.mapping.MappingHintGroupType%>) || ((MappingHintGroupType) this.eContainer()).getTargetSection() == null) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = this.getTarget().getContainingSection() == ((MappingHintGroupType) this.eContainer()).getTargetSection();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The target class \'\" + this.getTarget().getName() + \"\' is not part of the target section referenced by parent hint group \'\" + ((MappingHintGroupType) this.eContainer()).getName() + \"\'!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tExtendedValidator.CARDINALITY_MAPPING__VALIDATE_TARGET_CLASS_MATCHES_SECTION,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.extended.ExtendedPackage%>.Literals.CARDINALITY_MAPPING__TARGET }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateTargetClassMatchesSection(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this.getSource() == null || !(this.getSource() instanceof SourceSectionClass) ? true : ((SourceSectionClass) this.getSource()).getCardinality() != CardinalityType.ONE;\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"Cardinality mappings may only be defined for source classes with a specified cardinality distinct from \'CardinalityType::ONE\'!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tExtendedValidator.CARDINALITY_MAPPING__VALIDATE_SOURCE_CLASS_IS_VARIABLE_CARDINALITY,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.extended.ExtendedPackage%>.Literals.CARDINALITY_MAPPING__SOURCE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateSourceClassIsVariableCardinality(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this.getTarget() == null ? true : this.getTarget().getCardinality() != <%pamtram.structure.generic.CardinalityType%>.ONE;\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"Cardinality mappings may only be defined for target classes with a specified cardinality distinct from \'CardinalityType::ONE\'!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tExtendedValidator.CARDINALITY_MAPPING__VALIDATE_TARGET_CLASS_IS_VARIABLE_CARDINALITY,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.extended.ExtendedPackage%>.Literals.CARDINALITY_MAPPING__TARGET }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateTargetClassIsVariableCardinality(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this.getSource() == null ? true : this.getSource() != this.getSource().getContainingSection();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"Cardinality mappings must not be defined for SourceSection root classes!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tExtendedValidator.CARDINALITY_MAPPING__VALIDATE_NO_CARDINALITY_MAPPING_FOR_SOURCE_SECTION_ROOT,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.extended.ExtendedPackage%>.Literals.CARDINALITY_MAPPING__SOURCE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateNoCardinalityMappingForSourceSectionRoot(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this.getSource() == null || this.getSourceElements() == null || this.getSourceElements().isEmpty();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"A CardinalityMapping must not specify both a \'source\' and a set of \'sourceElements\'!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tExtendedValidator.CARDINALITY_MAPPING__VALIDATE_ONLY_SOURCE_OR_SOURCE_ELEMENTS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.extended.ExtendedPackage%>.Literals.CARDINALITY_MAPPING }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateOnlySourceOrSourceElements(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = !this.getSourceElements().isEmpty() || this.expression.isEmpty();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"A CardinalityMapping must only specify an \'expression\' if it also specifies a set of \'sourceElements\'!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tExtendedValidator.CARDINALITY_MAPPING__VALIDATE_EXPRESSION_ONLY_FOR_SOURCE_ELEMENTS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.extended.ExtendedPackage%>.Literals.CARDINALITY_MAPPING }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateExpressionOnlyForSourceElements(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = !this.getSourceElements().isEmpty() || this.getModifiers().isEmpty();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"A CardinalityMapping must only specify \'modifiers\' if it also specifies a set of \'sourceElements\'!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tExtendedValidator.CARDINALITY_MAPPING__VALIDATE_MODIFIERS_ONLY_FOR_SOURCE_ELEMENTS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.extended.ExtendedPackage%>.Literals.CARDINALITY_MAPPING }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateModifiersOnlyForSourceElements(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return new <%org.eclipse.emf.common.util.BasicEList%><>(this.getSourceElements().stream().filter(s -> s instanceof CardinalityMappingSourceElement).map(s -> (CardinalityMappingSourceElement) s).collect(<%java.util.stream.Collectors%>.toList()));'"
	 * @generated
	 */
	EList<CardinalityMappingSourceElement> getLocalSourceElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return new <%org.eclipse.emf.common.util.BasicEList%><>(this.getSourceElements().stream().filter(s -> s instanceof CardinalityMappingExternalSourceElement).map(s -> (CardinalityMappingExternalSourceElement) s).collect(<%java.util.stream.Collectors%>.toList()));'"
	 * @generated
	 */
	EList<CardinalityMappingExternalSourceElement> getExternalSourceElements();

} // CardinalityMapping
