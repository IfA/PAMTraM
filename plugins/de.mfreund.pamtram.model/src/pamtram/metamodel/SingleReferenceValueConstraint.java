/**
 */
package pamtram.metamodel;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import pamtram.mapping.ExpressionHint;
import pamtram.mapping.ModifiableHint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Reference Attribute Value Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.SingleReferenceValueConstraint#getConstraintReferenceValueAdditionalSpecification <em>Constraint Reference Value Additional Specification</em>}</li>
 *   <li>{@link pamtram.metamodel.SingleReferenceValueConstraint#getSourceElements <em>Source Elements</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getSingleReferenceValueConstraint()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='onlyFixedValuesInSourceSections onlyFixedValuesOrGlobalAttributesInConditionModel'"
 * @generated
 */
public interface SingleReferenceValueConstraint extends ValueConstraint, ExpressionHint, ModifiableHint {
	/**
	 * Returns the value of the '<em><b>Constraint Reference Value Additional Specification</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.metamodel.InstancePointer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Reference Value Additional Specification</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Reference Value Additional Specification</em>' containment reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getSingleReferenceValueConstraint_ConstraintReferenceValueAdditionalSpecification()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!SingleReferenceValueConstraint!constraintReferenceValueAdditionalSpecification'"
	 * @generated
	 */
	EList<InstancePointer> getConstraintReferenceValueAdditionalSpecification();

	/**
	 * Returns the value of the '<em><b>Source Elements</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.metamodel.ValueConstraintSourceInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Elements</em>' containment reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getSingleReferenceValueConstraint_SourceElements()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!SingleReferenceValueConstraint!sourceElements'"
	 * @generated
	 */
	EList<ValueConstraintSourceInterface> getSourceElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" attrValueRequired="true" refValueRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!SingleReferenceValueConstraint!checkConstraint(String,String)'"
	 * @generated
	 */
	boolean checkConstraint(String attrValue, String refValue);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if(this.getSourceElements().isEmpty() || \r\n\t\t!<%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%>.hasAncestorOfKind(this, <%pamtram.metamodel.MetamodelPackage%>.eINSTANCE.getActualSourceSectionAttribute())) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = this.getSourceElements().parallelStream().allMatch(s -> s instanceof <%pamtram.mapping.FixedValue%>);\r\n\r\nif (!result && diagnostics != null) {\r\n\t\r\n\tString errorMessage = \"This ValueConstraint must only\"\r\n\t\t\t+ \" contain FixedValues as source elements as it is modeled as part of a SourceSection!\'\";\r\n\t\r\n\tdiagnostics.add\r\n\t\t(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t <%pamtram.metamodel.util.MetamodelValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t MetamodelValidator.SINGLE_REFERENCE_VALUE_CONSTRAINT__VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS,\r\n\t\t\t errorMessage,\r\n\t\t\t new Object [] { this,  <%pamtram.metamodel.MetamodelPackage%>.Literals.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS }));\r\n\t}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateOnlyFixedValuesInSourceSections(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if(this.getSourceElements().isEmpty() || \r\n\t\t!<%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%>.hasAncestorOfKind(this, <%pamtram.condition.ConditionPackage%>.eINSTANCE.getComplexCondition())) {\r\n\treturn true;\r\n}\r\n\r\n<%pamtram.condition.ComplexCondition%> condition = (ComplexCondition) AgteleEcoreUtil.getAncestorOfKind(this, <%pamtram.condition.ConditionPackage%>.eINSTANCE.getComplexCondition());\r\n\r\nif(!condition.isConditionModelCondition()) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = this.getSourceElements().parallelStream().allMatch(s -> s instanceof <%pamtram.mapping.FixedValue%> || s instanceof <%pamtram.mapping.GlobalAttributeImporter%>);\r\n\r\nif (!result && diagnostics != null) {\r\n\t\r\n\tString errorMessage = \"This ValueConstraint must only\"\r\n\t\t\t+ \" contain FixedValues or GlobalAttributeImporters as source elements as it is modeled as part of a condition inside a ConditionModel!\'\";\r\n\t\r\n\tdiagnostics.add\r\n\t\t(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t <%pamtram.metamodel.util.MetamodelValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t MetamodelValidator.SINGLE_REFERENCE_VALUE_CONSTRAINT__VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL,\r\n\t\t\t errorMessage,\r\n\t\t\t new Object [] { this,  <%pamtram.metamodel.MetamodelPackage%>.Literals.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS }));\r\n\t}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateOnlyFixedValuesOrGlobalAttributesInConditionModel(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if(this.eContainer() instanceof <%pamtram.metamodel.ActualSourceSectionAttribute%>) {\r\n\treturn true;\r\n}\r\n\r\nif(!(this.eContainer() instanceof <%pamtram.condition.AttributeCondition%>)) {\r\n\tthrow new UnsupportedOperationException();\r\n}\r\n\r\n<%org.eclipse.emf.ecore.EObject%> container = this;\r\n\r\nwhile(!(container instanceof <%pamtram.mapping.Mapping%>)) {\r\n\tif(container == null) {\r\n\t\treturn false;\r\n\t}\r\n\tcontainer = container.eContainer();\r\n}\r\n\r\n// The SourceSection of the Mapping that contains the constraint\r\n//\r\n<%pamtram.metamodel.SourceSection%> localSection = ((Mapping) container).getSourceMMSection();\r\n\r\nif(getSourceElements().parallelStream().allMatch(s -> s instanceof <%pamtram.mapping.FixedValue%> || s instanceof <%pamtram.mapping.GlobalAttributeImporter%> ||\r\n\t\t(s instanceof <%pamtram.metamodel.ValueConstraintSourceElement%> &&\r\n\t\t((ValueConstraintSourceElement) s).getSource().getContainingSection().equals(localSection)) ||\r\n\t\t(s instanceof <%pamtram.metamodel.ValueConstraintExternalSourceElement%> &&\r\n\t\t\t\t((ValueConstraintExternalSourceElement) s).getSource().getContainingSection().isContainerFor(localSection)))) {\r\n\treturn true;\r\n}\r\n\r\n// A constraint is also \'local\' if an InstancePointer with local or external SourceAttributes exist\r\n//\r\nreturn getConstraintReferenceValueAdditionalSpecification().parallelStream().flatMap(\r\n\t\tinstancePointer -> instancePointer.getSourceAttributes().parallelStream().filter(\r\n\t\t\t\ts -> s instanceof <%pamtram.metamodel.InstancePointerSourceElement%> || \r\n\t\t\t\ts instanceof <%pamtram.metamodel.InstancePointerExternalSourceElement%>)\r\n\t\t).findAny().isPresent();'"
	 * @generated
	 */
	boolean isLocalConstraint();

} // SingleReferenceAttributeValueConstraint
