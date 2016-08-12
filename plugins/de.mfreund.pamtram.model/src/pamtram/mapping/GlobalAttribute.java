/**
 */
package pamtram.mapping;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import pamtram.NamedElement;
import pamtram.metamodel.SourceSectionAttribute;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Global Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.GlobalAttribute#getSource <em>Source</em>}</li>
 *   <li>{@link pamtram.mapping.GlobalAttribute#getModifier <em>Modifier</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getGlobalAttribute()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='sourceAttributeHasUpperBoundOne'"
 * @generated
 */
public interface GlobalAttribute extends NamedElement {

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(SourceSectionAttribute)
	 * @see pamtram.mapping.MappingPackage#getGlobalAttribute_Source()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!GlobalAttribute!source'"
	 * @generated
	 */
	SourceSectionAttribute getSource();

	/**
	 * Sets the value of the '{@link pamtram.mapping.GlobalAttribute#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(SourceSectionAttribute value);

	/**
	 * Returns the value of the '<em><b>Modifier</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.AttributeValueModifierSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modifier</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modifier</em>' reference list.
	 * @see pamtram.mapping.MappingPackage#getGlobalAttribute_Modifier()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!GlobalAttribute!modifier'"
	 * @generated
	 */
	EList<AttributeValueModifierSet> getModifier();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv sourceAttributeHasUpperBoundOne:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[1] = if self.source.oclType() = OclVoid\n *       then true\n *       else self.source.attribute.upperBound = 1\n *       endif\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'Global attributes may only be defined for attributes that have an upper bound of 1!\'\n *         else null\n *         endif\n *       in\n *         \'GlobalAttribute::sourceAttributeHasUpperBoundOne\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Executor%> executor = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getExecutor(this);\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = executor.getIdResolver();\n/*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_OclVoid_0 = idResolver.getClass(<%org.eclipse.ocl.pivot.ids.TypeId%>.OCL_VOID, null);\n    final /*@Thrown\052/ <%pamtram.metamodel.SourceSectionAttribute%> source = this.getSource();\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType = (<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(executor, source);\n    final /*@Thrown\052/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();\n    /*@Thrown\052/ boolean status;\n    if (eq) {\n        status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n    }\n    else {\n        final /*@Thrown\052/ <%org.eclipse.emf.ecore.EAttribute%> attribute = source.getAttribute();\n        final /*@Thrown\052/ int upperBound = attribute.getUpperBound();\n        final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> BOXED_upperBound = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.integerValueOf(upperBound);\n        final /*@Thrown\052/ boolean eq_0 = <%pamtram.mapping.MappingTables%>.INT_1.equals(BOXED_upperBound);\n        status = eq_0;\n    }\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    message_0 = <%pamtram.mapping.MappingTables%>.STR_Global_32_attributes_32_may_32_only_32_be_32_defined_32_for_32_attributes_32_that_32_have_32_a;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(executor, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.mapping.MappingTables%>.STR_GlobalAttribute_c_c_sourceAttributeHasUpperBoundOne, this, null, diagnostics, context, message_0, <%pamtram.mapping.MappingTables%>.INT_4, CAUGHT_status, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue();\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean sourceAttributeHasUpperBoundOne(DiagnosticChain diagnostics, Map<Object, Object> context);
} // GlobalVariable
