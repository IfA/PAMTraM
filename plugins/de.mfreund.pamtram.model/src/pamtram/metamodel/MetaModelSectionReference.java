/**
 */
package pamtram.metamodel;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Meta Model Section Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.MetaModelSectionReference#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getMetaModelSectionReference()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='valuesMatchReferenceType'"
 * @generated
 */
public interface MetaModelSectionReference extends SourceSectionReference {

	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference list.
	 * The list contents are of type {@link pamtram.metamodel.SourceSectionClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getMetaModelSectionReference_Value()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!MetaModelSectionReference!value'"
	 * @generated
	 */
	EList<SourceSectionClass> getValue();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv valuesMatchReferenceType:\n *   let\n *     severity : Integer[1] = \'MetaModelSectionReference::valuesMatchReferenceType\'.getSeverity()\n *   in\n *     if severity <= 0\n *     then true\n *     else\n *       let\n *         status : OclAny[?] = self.value->forAll(c |\n *           self.eReference.eReferenceType.isSuperTypeOf(c.eClass))\n *       in\n *         \'MetaModelSectionReference::valuesMatchReferenceType\'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)\n *     endif\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> severity_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%>.INSTANCE.evaluate(evaluator, <%pamtram.metamodel.MetamodelTables%>.STR_MetaModelSectionReference_c_c_valuesMatchReferenceType));\nfinal /*@NonInvalid\052/ boolean le = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%>.INSTANCE.evaluate(evaluator, severity_0, <%pamtram.metamodel.MetamodelTables%>.INT_0).booleanValue());\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n    symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n}\nelse {\n    /*@Nullable\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\n    try {\n        final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%pamtram.metamodel.SourceSectionClass%>> value = this.getValue();\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_value = idResolver.createOrderedSetOfAll(<%pamtram.metamodel.MetamodelTables%>.ORD_CLSSid_SourceSectionClass, value);\n        /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Object%> accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n        /*@Nullable\052/ <%java.util.Iterator%><?> ITERATOR_c = BOXED_value.iterator();\n        /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> status;\n        while (true) {\n            if (!ITERATOR_c.hasNext()) {\n                if (accumulator == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE) {\n                    status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n                }\n                else {\n                    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)accumulator;\n                }\n                break;\n            }\n            /*@Nullable\052/ /*@NonInvalid\052/ <%pamtram.metamodel.SourceSectionClass%> c = (<%pamtram.metamodel.SourceSectionClass%>)ITERATOR_c.next();\n            /**\n             * self.eReference.eReferenceType.isSuperTypeOf(c.eClass)\n             \052/\n            /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_isSuperTypeOf;\n            try {\n                final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EReference%> eReference = this.getEReference();\n                @SuppressWarnings(\"null\")\n                final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EClass%> eReferenceType = eReference.getEReferenceType();\n                if (c == null) {\n                    throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null source for \\\'\\\'http://mfreund.de/pamtram/metamodel\\\'::Class::eClass\\\'\");\n                }\n                final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EClass%> eClass = c.getEClass();\n                final /*@Thrown\052/ boolean isSuperTypeOf = eReferenceType.isSuperTypeOf(eClass);\n                CAUGHT_isSuperTypeOf = isSuperTypeOf;\n            }\n            catch (<%java.lang.Exception%> e) {\n                CAUGHT_isSuperTypeOf = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n            }\n            //\n            if (CAUGHT_isSuperTypeOf == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE) {\t\t\t\t\t// Normal unsuccessful body evaluation result\n                status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE;\n                break;\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Stop immediately \n            }\n            else if (CAUGHT_isSuperTypeOf == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE) {\t\t\t\t// Normal successful body evaluation result\n                ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Carry on\n            }\n            else if (CAUGHT_isSuperTypeOf instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\t\t// Abnormal exception evaluation result\n                accumulator = CAUGHT_isSuperTypeOf;\t\t\t\t\t\t\t\t\t// Cache an exception failure\n            }\n            else {\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Impossible badly typed result\n                accumulator = new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(<%org.eclipse.ocl.pivot.messages.PivotMessages%>.NonBooleanBody, \"forAll\");\n            }\n        }\n        CAUGHT_status = status;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.metamodel.MetamodelTables%>.STR_MetaModelSectionReference_c_c_valuesMatchReferenceType, this, null, diagnostics, context, null, severity_0, CAUGHT_status, <%pamtram.metamodel.MetamodelTables%>.INT_0).booleanValue());\n    symbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean valuesMatchReferenceType(DiagnosticChain diagnostics, Map<Object, Object> context);

} // MetaModelSectionReference
