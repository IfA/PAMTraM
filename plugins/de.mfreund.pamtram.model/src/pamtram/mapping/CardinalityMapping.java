/**
 */
package pamtram.mapping;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.TargetSectionClass;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cardinality Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.CardinalityMapping#getSource <em>Source</em>}</li>
 *   <li>{@link pamtram.mapping.CardinalityMapping#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getCardinalityMapping()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='sourceClassMatchesSection sourceClassIsVariableCardinality targetClassMatchesSection targetClassIsVariableCardinality noCardinalityMappingForSourceSectionRoot'"
 * @generated
 */
public interface CardinalityMapping extends MappingHint {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(SourceSectionClass)
	 * @see pamtram.mapping.MappingPackage#getCardinalityMapping_Source()
	 * @model required="true"
	 * @generated
	 */
	SourceSectionClass getSource();

	/**
	 * Sets the value of the '{@link pamtram.mapping.CardinalityMapping#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(SourceSectionClass value);

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
	 * @see pamtram.mapping.MappingPackage#getCardinalityMapping_Target()
	 * @model required="true"
	 * @generated
	 */
	TargetSectionClass getTarget();

	/**
	 * Sets the value of the '{@link pamtram.mapping.CardinalityMapping#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(TargetSectionClass value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif(this.getSource() == null || !(this.eContainer().eContainer() instanceof <%pamtram.mapping.Mapping%>) || ((Mapping) this.eContainer().eContainer()).getSourceSection() == null) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = this.getSource().getContainingSection() == ((Mapping) this.eContainer().eContainer()).getSourceSection();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The source class \'\" + this.getSource().getName() + \"\' is not part of the source section referenced by parent mapping \'\" + ((pamtram.mapping.Mapping) this.eContainer().eContainer()).getName() + \"\'!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.util.MappingValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMappingValidator.CARDINALITY_MAPPING__VALIDATE_SOURCE_CLASS_MATCHES_SECTION,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.MappingPackage%>.Literals.CARDINALITY_MAPPING__SOURCE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateSourceClassMatchesSection(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif(this.getTarget() == null || !(this.eContainer() instanceof <%pamtram.mapping.MappingHintGroupType%>) || ((MappingHintGroupType) this.eContainer()).getTargetSection() == null) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = this.getTarget().getContainingSection() == ((MappingHintGroupType) this.eContainer()).getTargetSection();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The target class \'\" + this.getTarget().getName() + \"\' is not part of the target section referenced by parent hint group \'\" + ((MappingHintGroupType) this.eContainer()).getName() + \"\'!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.util.MappingValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMappingValidator.CARDINALITY_MAPPING__VALIDATE_TARGET_CLASS_MATCHES_SECTION,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.MappingPackage%>.Literals.CARDINALITY_MAPPING__TARGET }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateTargetClassMatchesSection(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this.getSource() == null ? true : this.getSource().getCardinality() != <%pamtram.metamodel.CardinalityType%>.ONE;\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"Cardinality mappings may only be defined for source classes with a specified cardinality distinct from \'CardinalityType::ONE\'!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.util.MappingValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMappingValidator.CARDINALITY_MAPPING__VALIDATE_SOURCE_CLASS_IS_VARIABLE_CARDINALITY,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.MappingPackage%>.Literals.CARDINALITY_MAPPING__SOURCE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateSourceClassIsVariableCardinality(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this.getTarget() == null ? true : this.getTarget().getCardinality() != <%pamtram.metamodel.CardinalityType%>.ONE;\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"Cardinality mappings may only be defined for target classes with a specified cardinality distinct from \'CardinalityType::ONE\'!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.util.MappingValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMappingValidator.CARDINALITY_MAPPING__VALIDATE_TARGET_CLASS_IS_VARIABLE_CARDINALITY,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.MappingPackage%>.Literals.CARDINALITY_MAPPING__TARGET }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateTargetClassIsVariableCardinality(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this.getSource() == null ? true : this.getSource() != this.getSource().getContainingSection();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"Cardinality mappings must not be defined for SourceSection root classes!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.util.MappingValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMappingValidator.CARDINALITY_MAPPING__VALIDATE_NO_CARDINALITY_MAPPING_FOR_SOURCE_SECTION_ROOT,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.MappingPackage%>.Literals.CARDINALITY_MAPPING__SOURCE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateNoCardinalityMappingForSourceSectionRoot(DiagnosticChain diagnostics, Map<?, ?> context);

} // CardinalityMapping
