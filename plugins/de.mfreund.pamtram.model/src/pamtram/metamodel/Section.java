/**
 */
package pamtram.metamodel;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.Section#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link pamtram.metamodel.Section#getExtend <em>Extend</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getSection()
 * @model abstract="true"
 * @generated
 */
public interface Section<S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends pamtram.metamodel.Class<S, C, R, A> {

	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see #setAbstract(boolean)
	 * @see pamtram.metamodel.MetamodelPackage#getSection_Abstract()
	 * @model default="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!Section{S,C,R,A}!abstract'"
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.Section#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Extend</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extend</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extend</em>' reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getSection_Extend()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!Section{S,C,R,A}!extend'"
	 * @generated
	 */
	EList<S> getExtend();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if(this.getEClass() == null) {\r\n\treturn true;\r\n}\r\n\r\nfor (S extend : this.getExtend()) {\r\n\tif(!extend.isAbstract() || extend.getEClass() != null && !(this.getEClass() == extend.getEClass()) && !(this.getEClass().getEAllSuperTypes().contains(extend.getEClass()))) {\r\n\t\treturn false;\r\n\t}\r\n}\r\n\r\nreturn true;'"
	 * @generated
	 */
	boolean extendsOnlyValidSections();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv extendsValidSections:\n *   let severity : Integer[1] = 4\n *   in\n *     let status : OclAny[?] = self.extendsOnlyValidSections()\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'The section extends a section that is either not abstract or that references an EClass of a different (super-)type!\'\n *         else null\n *         endif\n *       in\n *         \'Section::extendsValidSections\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Executor%> executor = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getExecutor(this);\n/*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    final /*@Thrown\052/ boolean status = this.extendsOnlyValidSections();\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    message_0 = <%pamtram.metamodel.MetamodelTables%>.STR_The_32_section_32_extends_32_a_32_section_32_that_32_is_32_either_32_not_32_abstract_32_or_32_tha;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(executor, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.metamodel.MetamodelTables%>.STR_Section_c_c_extendsValidSections, this, null, diagnostics, context, message_0, <%pamtram.metamodel.MetamodelTables%>.INT_4, CAUGHT_status, <%pamtram.metamodel.MetamodelTables%>.INT_0).booleanValue();\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean extendsValidSections(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv containerMatchesExtendContainer:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[?] = if\n *         self.oclAsType(Class(S, C, R, A))\n *         .container.oclType() = OclVoid\n *       then true\n *       else\n *         self.extend->forAll(e |\n *           e.oclAsType(Class(S, C, R, A))\n *           .container.oclType() = OclVoid or\n *           e.oclAsType(Class(S, C, R, A)).container =\n *           self.oclAsType(Class(S, C, R, A)).container)\n *       endif\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'The section extends a section that specifies a different container!\'\n *         else null\n *         endif\n *       in\n *         \'Section::containerMatchesExtendContainer\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Executor%> executor = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getExecutor(this);\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = executor.getIdResolver();\n/*@Caught\052/ /*@Nullable\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_OclVoid_0 = idResolver.getClass(<%org.eclipse.ocl.pivot.ids.TypeId%>.OCL_VOID, null);\n    final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_Class_o_S_44_C_44_R_44_A_e = idResolver.getClass(<%pamtram.metamodel.MetamodelTables%>.CLSSid_Class, null);\n    final /*@Thrown\052/ <%pamtram.metamodel.Class%> oclAsType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, this, TYP_pamtram_c_c_metamodel_c_c_Class_o_S_44_C_44_R_44_A_e));\n    final /*@Thrown\052/ <%java.lang.Object%> container = oclAsType.getContainer();\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType = (<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(executor, container);\n    final /*@Thrown\052/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();\n    /*@Thrown\052/ <%java.lang.Boolean%> status;\n    if (eq) {\n        status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n    }\n    else {\n        final /*@Thrown\052/ <%java.util.List%><<%java.lang.Object%>> extend = this.getExtend();\n        final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_extend = idResolver.createOrderedSetOfAll(<%pamtram.metamodel.MetamodelTables%>.ORD_TMPLid__1, extend);\n        /*@Thrown\052/ <%java.lang.Object%> accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n        /*@NonNull\052/ <%java.util.Iterator%><<%java.lang.Object%>> ITERATOR_e_0 = BOXED_extend.iterator();\n        /*@Thrown\052/ <%java.lang.Boolean%> forAll;\n        while (true) {\n            if (!ITERATOR_e_0.hasNext()) {\n                if (accumulator == null) {\n                    forAll = null;\n                }\n                else if (accumulator == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE) {\n                    forAll = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n                }\n                else {\n                    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)accumulator;\n                }\n                break;\n            }\n            /*@NonInvalid\052/ <%java.lang.Object%> e_0 = (<%java.lang.Object%>)ITERATOR_e_0.next();\n            /**\n             * \n             * e.oclAsType(Class(S, C, R, A))\n             * .container.oclType() = OclVoid or\n             * e.oclAsType(Class(S, C, R, A)).container =\n             * self.oclAsType(Class(S, C, R, A)).container\n             \052/\n            /*@Caught\052/ /*@Nullable\052/ <%java.lang.Object%> CAUGHT_or;\n            try {\n                /*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_eq_0;\n                try {\n                    final /*@Thrown\052/ <%pamtram.metamodel.Class%> oclAsType_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, e_0, TYP_pamtram_c_c_metamodel_c_c_Class_o_S_44_C_44_R_44_A_e));\n                    final /*@Thrown\052/ <%java.lang.Object%> container_0 = oclAsType_0.getContainer();\n                    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType_0 = (<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(executor, container_0);\n                    final /*@Thrown\052/ boolean eq_0 = oclType_0.getTypeId() == TYP_OclVoid_0.getTypeId();\n                    CAUGHT_eq_0 = eq_0;\n                }\n                catch (<%java.lang.Exception%> e) {\n                    CAUGHT_eq_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n                }\n                /*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_eq_1;\n                try {\n                    final /*@Thrown\052/ <%pamtram.metamodel.Class%> oclAsType_1 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, e_0, TYP_pamtram_c_c_metamodel_c_c_Class_o_S_44_C_44_R_44_A_e));\n                    final /*@Thrown\052/ <%java.lang.Object%> container_1 = oclAsType_1.getContainer();\n                    final /*@Thrown\052/ boolean eq_1 = (container_1 != null) ? container_1.equals(container) : (container == null);\n                    CAUGHT_eq_1 = eq_1;\n                }\n                catch (<%java.lang.Exception%> e) {\n                    CAUGHT_eq_1 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n                }\n                final /*@Thrown\052/ <%java.lang.Boolean%> or = <%org.eclipse.ocl.pivot.library.logical.BooleanOrOperation%>.INSTANCE.evaluate(CAUGHT_eq_0, CAUGHT_eq_1);\n                CAUGHT_or = or;\n            }\n            catch (<%java.lang.Exception%> e) {\n                CAUGHT_or = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n            }\n            //\n            if (CAUGHT_or == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE) {\t\t\t\t\t// Normal unsuccessful body evaluation result\n                forAll = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE;\n                break;\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Stop immediately \n            }\n            else if (CAUGHT_or == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE) {\t\t\t\t// Normal successful body evaluation result\n                ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Carry on\n            }\n            else if (CAUGHT_or == null) {\t\t\t\t\t\t\t\t// Abnormal null body evaluation result\n                if (accumulator == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE) {\n                    accumulator = null;\t\t\t\t\t\t\t\t\t\t// Cache a null failure\n                }\n            }\n            else if (CAUGHT_or instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\t\t// Abnormal exception evaluation result\n                accumulator = CAUGHT_or;\t\t\t\t\t\t\t\t\t// Cache an exception failure\n            }\n            else {\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Impossible badly typed result\n                accumulator = new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(<%org.eclipse.ocl.pivot.messages.PivotMessages%>.NonBooleanBody, \"forAll\");\n            }\n        }\n        status = forAll;\n    }\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    message_0 = <%pamtram.metamodel.MetamodelTables%>.STR_The_32_section_32_extends_32_a_32_section_32_that_32_specifies_32_a_32_different_32_contain;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(executor, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.metamodel.MetamodelTables%>.STR_Section_c_c_containerMatchesExtendContainer, this, null, diagnostics, context, message_0, <%pamtram.metamodel.MetamodelTables%>.INT_4, CAUGHT_status, <%pamtram.metamodel.MetamodelTables%>.INT_0).booleanValue();\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean containerMatchesExtendContainer(DiagnosticChain diagnostics, Map<Object, Object> context);
} // Section
