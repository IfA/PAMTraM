/**
 */
package pamtram.metamodel;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import pamtram.ReferenceableElement;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Section Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.SourceSectionAttribute#getValueConstraint <em>Value Constraint</em>}</li>
 *   <li>{@link pamtram.metamodel.SourceSectionAttribute#getAttribute <em>Attribute</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getSourceSectionAttribute()
 * @model
 * @generated
 */
public interface SourceSectionAttribute extends Attribute<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>, ReferenceableElement {
	/**
	 * Returns the value of the '<em><b>Value Constraint</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.metamodel.AttributeValueConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Constraint</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Constraint</em>' containment reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getSourceSectionAttribute_ValueConstraint()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!SourceSectionAttribute!valueConstraint'"
	 * @generated
	 */
	EList<AttributeValueConstraint> getValueConstraint();

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' reference.
	 * @see #setAttribute(EAttribute)
	 * @see pamtram.metamodel.MetamodelPackage#getSourceSectionAttribute_Attribute()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!SourceSectionAttribute!attribute'"
	 * @generated
	 */
	EAttribute getAttribute();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.SourceSectionAttribute#getAttribute <em>Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' reference.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(EAttribute value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv attributeMatchesParentEClass:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[1] = if\n *         self.isLibraryEntry() or\n *         self.attribute.oclType() = OclVoid\n *       then true\n *       else\n *         let\n *           parentEClass : ecore::EClass[1] = self.oclContainer()\n *           .oclAsType(Class(S, C, R, A)).eClass\n *         in\n *           if parentEClass.oclType() = OclVoid\n *           then true\n *           else\n *             parentEClass.oclAsType(ecore::EClass)\n *             .eAllAttributes->includes(self.attribute)\n *           endif\n *       endif\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'The eAttribute \\\'\' + self.attribute.name + \'\\\' is not allowed by the containing Class!\'\n *         else null\n *         endif\n *       in\n *         \'SourceSectionAttribute::attributeMatchesParentEClass\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Executor%> executor = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getExecutor(this);\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = executor.getIdResolver();\n/*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    /*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_isLibraryEntry;\n    try {\n        final /*@Thrown\052/ boolean isLibraryEntry = ((<%pamtram.metamodel.MetaModelElement%>)this).isLibraryEntry();\n        CAUGHT_isLibraryEntry = isLibraryEntry;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_isLibraryEntry = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    /*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_eq;\n    try {\n        final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_OclVoid_0 = idResolver.getClass(<%org.eclipse.ocl.pivot.ids.TypeId%>.OCL_VOID, null);\n        final /*@Thrown\052/ <%org.eclipse.emf.ecore.EAttribute%> attribute = this.getAttribute();\n        final /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType = (<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(executor, attribute);\n        final /*@Thrown\052/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();\n        CAUGHT_eq = eq;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_eq = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@Thrown\052/ <%java.lang.Boolean%> or = <%org.eclipse.ocl.pivot.library.logical.BooleanOrOperation%>.INSTANCE.evaluate(CAUGHT_isLibraryEntry, CAUGHT_eq);\n    if (or == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null if condition\");\n    }\n    /*@Thrown\052/ boolean status;\n    if (or) {\n        status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n    }\n    else {\n        final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_Class_o_S_44_C_44_R_44_A_e_0 = idResolver.getClass(<%pamtram.metamodel.MetamodelTables%>.CLSSid_Class, null);\n        final /*@NonInvalid\052/ <%java.lang.Object%> oclContainer = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(executor, this);\n        final /*@Thrown\052/ <%pamtram.metamodel.Class%> oclAsType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, oclContainer, TYP_pamtram_c_c_metamodel_c_c_Class_o_S_44_C_44_R_44_A_e_0));\n        final /*@Thrown\052/ <%org.eclipse.emf.ecore.EClass%> parentEClass = oclAsType.getEClass();\n        final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_OclVoid_1 = idResolver.getClass(<%org.eclipse.ocl.pivot.ids.TypeId%>.OCL_VOID, null);\n        final /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType_0 = (<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(executor, parentEClass);\n        final /*@Thrown\052/ boolean eq_0 = oclType_0.getTypeId() == TYP_OclVoid_1.getTypeId();\n        /*@Thrown\052/ boolean symbol_0;\n        if (eq_0) {\n            symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n        }\n        else {\n            final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_ecore_c_c_EClass_0 = idResolver.getClass(<%pamtram.metamodel.MetamodelTables%>.CLSSid_EClass, null);\n            final /*@Thrown\052/ <%org.eclipse.emf.ecore.EClass%> oclAsType_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%org.eclipse.emf.ecore.EClass%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, parentEClass, TYP_ecore_c_c_EClass_0));\n            final /*@Thrown\052/ <%java.util.List%><<%org.eclipse.emf.ecore.EAttribute%>> eAllAttributes = oclAsType_0.getEAllAttributes();\n            final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_eAllAttributes = idResolver.createOrderedSetOfAll(<%pamtram.metamodel.MetamodelTables%>.ORD_CLSSid_EAttribute, eAllAttributes);\n            final /*@Thrown\052/ <%org.eclipse.emf.ecore.EAttribute%> attribute_0 = this.getAttribute();\n            final /*@Thrown\052/ boolean includes = <%org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation%>.INSTANCE.evaluate(BOXED_eAllAttributes, attribute_0).booleanValue();\n            symbol_0 = includes;\n        }\n        status = symbol_0;\n    }\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    final /*@Thrown\052/ <%org.eclipse.emf.ecore.EAttribute%> attribute_1 = this.getAttribute();\n    final /*@Thrown\052/ <%java.lang.String%> name = attribute_1.getName();\n    final /*@NonInvalid\052/ <%java.lang.String%> sum = <%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(<%pamtram.metamodel.MetamodelTables%>.STR_The_32_eAttribute_32_39, name);\n    final /*@NonInvalid\052/ <%java.lang.String%> sum_0 = <%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(sum, <%pamtram.metamodel.MetamodelTables%>.STR__39_32_is_32_not_32_allowed_32_by_32_the_32_containing_32_Class_33);\n    message_0 = sum_0;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(executor, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.metamodel.MetamodelTables%>.STR_SourceSectionAttribute_c_c_attributeMatchesParentEClass, this, null, diagnostics, context, message_0, <%pamtram.metamodel.MetamodelTables%>.INT_4, CAUGHT_status, <%pamtram.metamodel.MetamodelTables%>.INT_0).booleanValue();\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean attributeMatchesParentEClass(DiagnosticChain diagnostics, Map<Object, Object> context);

} // SourceSectionAttribute
