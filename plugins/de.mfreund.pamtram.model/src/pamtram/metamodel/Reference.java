/**
 */
package pamtram.metamodel;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.Reference#getEReference <em>EReference</em>}</li>
 *   <li>{@link pamtram.metamodel.Reference#getOwningClass <em>Owning Class</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getReference()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='eReferenceMatchesParentEClass'"
 * @generated
 */
public interface Reference<S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends MetaModelElement<S, C, R, A> {
	/**
	 * Returns the value of the '<em><b>EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EReference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EReference</em>' reference.
	 * @see #setEReference(EReference)
	 * @see pamtram.metamodel.MetamodelPackage#getReference_EReference()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!Reference{S,C,R,A}!eReference'"
	 * @generated
	 */
	EReference getEReference();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.Reference#getEReference <em>EReference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EReference</em>' reference.
	 * @see #getEReference()
	 * @generated
	 */
	void setEReference(EReference value);

	/**
	 * Returns the value of the '<em><b>Owning Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link pamtram.metamodel.Class#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Class</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Class</em>' container reference.
	 * @see pamtram.metamodel.MetamodelPackage#getReference_OwningClass()
	 * @see pamtram.metamodel.Class#getReferences
	 * @model opposite="references" transient="false" changeable="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!Reference{S,C,R,A}!owningClass'"
	 * @generated
	 */
	C getOwningClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv eReferenceMatchesParentEClass:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[1] = if\n *         self.isLibraryEntry() or\n *         self.eReference.oclType() = OclVoid\n *       then true\n *       else\n *         let\n *           parentEClass : ecore::EClass[1] = self.oclContainer()\n *           .oclAsType(Class(S, C, R, A)).eClass\n *         in\n *           if parentEClass.oclType() = OclVoid\n *           then true\n *           else\n *             parentEClass.oclAsType(ecore::EClass)\n *             .eAllReferences->includes(self.eReference)\n *           endif\n *       endif\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'The eReference \\\'\' + self.eReference.name + \'\\\' is not allowed by the containing Class!\'\n *         else null\n *         endif\n *       in\n *         \'Reference::eReferenceMatchesParentEClass\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\n/*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_isLibraryEntry;\n    try {\n        final /*@Thrown\052/ boolean isLibraryEntry = ((<%pamtram.metamodel.MetaModelElement%>)this).isLibraryEntry();\n        CAUGHT_isLibraryEntry = isLibraryEntry;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_isLibraryEntry = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_eq;\n    try {\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_OclVoid_0 = idResolver.getClass(<%org.eclipse.ocl.pivot.ids.TypeId%>.OCL_VOID, null);\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EReference%> eReference = this.getEReference();\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(evaluator, eReference));\n        final /*@Thrown\052/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();\n        CAUGHT_eq = eq;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_eq = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> or = <%org.eclipse.ocl.pivot.library.logical.BooleanOrOperation%>.INSTANCE.evaluate(CAUGHT_isLibraryEntry, CAUGHT_eq);\n    if (or == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null if condition\");\n    }\n    /*@Thrown\052/ boolean status;\n    if (or) {\n        status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n    }\n    else {\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_Class_o_S_44_C_44_R_44_A_e_0 = idResolver.getClass(<%pamtram.metamodel.MetamodelTables%>.CLSSid_Class, null);\n        final /*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.Object%> oclContainer = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, this);\n        final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.Class%> oclAsType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_metamodel_c_c_Class_o_S_44_C_44_R_44_A_e_0));\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EClass%> parentEClass = oclAsType.getEClass();\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_OclVoid_1 = idResolver.getClass(<%org.eclipse.ocl.pivot.ids.TypeId%>.OCL_VOID, null);\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(evaluator, parentEClass));\n        final /*@Thrown\052/ boolean eq_0 = oclType_0.getTypeId() == TYP_OclVoid_1.getTypeId();\n        /*@Thrown\052/ boolean symbol_0;\n        if (eq_0) {\n            symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n        }\n        else {\n            final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_ecore_c_c_EClass_0 = idResolver.getClass(<%pamtram.metamodel.MetamodelTables%>.CLSSid_EClass, null);\n            final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EClass%> oclAsType_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%org.eclipse.emf.ecore.EClass%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, parentEClass, TYP_ecore_c_c_EClass_0));\n            @SuppressWarnings(\"null\")\n            final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%org.eclipse.emf.ecore.EReference%>> eAllReferences = oclAsType_0.getEAllReferences();\n            final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_eAllReferences = idResolver.createOrderedSetOfAll(<%pamtram.metamodel.MetamodelTables%>.ORD_CLSSid_EReference, eAllReferences);\n            final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EReference%> eReference_0 = this.getEReference();\n            final /*@Thrown\052/ boolean includes = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation%>.INSTANCE.evaluate(BOXED_eAllReferences, eReference_0).booleanValue());\n            symbol_0 = includes;\n        }\n        status = symbol_0;\n    }\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EReference%> eReference_1 = this.getEReference();\n    final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.String%> name = eReference_1.getName();\n    final /*@NonNull\052/ /*@NonInvalid\052/ <%java.lang.String%> sum = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(<%pamtram.metamodel.MetamodelTables%>.STR_The_32_eReference_32_39, name));\n    final /*@NonNull\052/ /*@NonInvalid\052/ <%java.lang.String%> sum_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(sum, <%pamtram.metamodel.MetamodelTables%>.STR__39_32_is_32_not_32_allowed_32_by_32_the_32_containing_32_Class_33));\n    message_0 = sum_0;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.metamodel.MetamodelTables%>.STR_Reference_c_c_eReferenceMatchesParentEClass, this, null, diagnostics, context, message_0, <%pamtram.metamodel.MetamodelTables%>.INT_4, CAUGHT_status, <%pamtram.metamodel.MetamodelTables%>.INT_0).booleanValue());\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean eReferenceMatchesParentEClass(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Reference
