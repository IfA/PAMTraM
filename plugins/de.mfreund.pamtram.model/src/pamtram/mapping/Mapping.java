/**
 */
package pamtram.mapping;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import pamtram.condition.ComplexCondition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.Mapping#getCondition <em>Condition</em>}</li>
 *   <li>{@link pamtram.mapping.Mapping#getMappingHintGroups <em>Mapping Hint Groups</em>}</li>
 *   <li>{@link pamtram.mapping.Mapping#getImportedMappingHintGroups <em>Imported Mapping Hint Groups</em>}</li>
 *   <li>{@link pamtram.mapping.Mapping#getGlobalVariables <em>Global Variables</em>}</li>
 *   <li>{@link pamtram.mapping.Mapping#isAbstract <em>Abstract</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getMapping()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='containsHintGroups containsDeactivatedHintGroups'"
 * @generated
 */
public interface Mapping extends MappingType {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(ComplexCondition)
	 * @see pamtram.mapping.MappingPackage#getMapping_Condition()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!Mapping!condition'"
	 * @generated
	 */
	ComplexCondition getCondition();

	/**
	 * Sets the value of the '{@link pamtram.mapping.Mapping#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(ComplexCondition value);

	/**
	 * Returns the value of the '<em><b>Mapping Hint Groups</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.MappingHintGroupType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Hint Groups</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Hint Groups</em>' containment reference list.
	 * @see pamtram.mapping.MappingPackage#getMapping_MappingHintGroups()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!Mapping!mappingHintGroups'"
	 * @generated
	 */
	EList<MappingHintGroupType> getMappingHintGroups();

	/**
	 * Returns the value of the '<em><b>Imported Mapping Hint Groups</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.MappingHintGroupImporter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Mapping Hint Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported Mapping Hint Groups</em>' containment reference list.
	 * @see pamtram.mapping.MappingPackage#getMapping_ImportedMappingHintGroups()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!Mapping!importedMappingHintGroups'"
	 * @generated
	 */
	EList<MappingHintGroupImporter> getImportedMappingHintGroups();

	/**
	 * Returns the value of the '<em><b>Global Variables</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.GlobalAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Variables</em>' containment reference list.
	 * @see pamtram.mapping.MappingPackage#getMapping_GlobalVariables()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!Mapping!globalVariables'"
	 * @generated
	 */
	EList<GlobalAttribute> getGlobalVariables();

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
	 * @see pamtram.mapping.MappingPackage#getMapping_Abstract()
	 * @model default="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!Mapping!abstract'"
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link pamtram.mapping.Mapping#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<MappingHintGroupType> hintGroups = getMappingHintGroups();\r\nEList<MappingHintGroupType> activeHintGroups = new BasicEList<>();\r\nfor (MappingHintGroupType hintGroup : hintGroups) {\r\n\tif(hintGroup instanceof InstantiableMappingHintGroup && \r\n\t\t\t((InstantiableMappingHintGroup) hintGroup).isDeactivated()) {\r\n\t\t// skip this one\r\n\t} else {\r\n\t\tactiveHintGroups.add(hintGroup);\r\n\t}\r\n}\r\nreturn activeHintGroups;'"
	 * @generated
	 */
	EList<MappingHintGroupType> getActiveMappingHintGroups();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<MappingHintGroupImporter> hintGroups = getImportedMappingHintGroups();\r\nEList<MappingHintGroupImporter> activeHintGroups = new BasicEList<>();\r\nfor (MappingHintGroupImporter hintGroup : hintGroups) {\r\n\tif(hintGroup.isDeactivated()) {\r\n\t\t// skip this one\r\n\t} else {\r\n\t\tactiveHintGroups.add(hintGroup);\r\n\t}\r\n}\r\nreturn activeHintGroups;'"
	 * @generated
	 */
	EList<MappingHintGroupImporter> getActiveImportedMappingHintGroups();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv containsHintGroups:\n *   let severity : Integer[1] = 2\n *   in\n *     let status : OclAny[?] = not self.mappingHintGroups->isEmpty()\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'The mapping does not contain any hint groups!\'\n *         else null\n *         endif\n *       in\n *         \'Mapping::containsHintGroups\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\n/*@Nullable\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%pamtram.mapping.MappingHintGroupType%>> mappingHintGroups = this.getMappingHintGroups();\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_mappingHintGroups = idResolver.createOrderedSetOfAll(<%pamtram.mapping.MappingTables%>.ORD_CLSSid_MappingHintGroupType, mappingHintGroups);\n    final /*@Thrown\052/ boolean isEmpty = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.collection.CollectionIsEmptyOperation%>.INSTANCE.evaluate(BOXED_mappingHintGroups).booleanValue());\n    final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> status = <%org.eclipse.ocl.pivot.library.logical.BooleanNotOperation%>.INSTANCE.evaluate(isEmpty);\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    message_0 = <%pamtram.mapping.MappingTables%>.STR_The_32_mapping_32_does_32_not_32_contain_32_any_32_hint_32_groups_33;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.mapping.MappingTables%>.STR_Mapping_c_c_containsHintGroups, this, null, diagnostics, context, message_0, <%pamtram.mapping.MappingTables%>.INT_2, CAUGHT_status, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue());\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean containsHintGroups(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv containsDeactivatedHintGroups:\n *   let severity : Integer[1] = 2\n *   in\n *     let\n *       status : OclAny[?] = if self.deactivated = false\n *       then\n *         self.mappingHintGroups->size() =\n *         self.getActiveMappingHintGroups()\n *         ->size() and\n *         self.importedMappingHintGroups->size() =\n *         self.getActiveImportedMappingHintGroups()\n *         ->size()\n *       else true\n *       endif\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'The mapping contains deactivated hint groups that will not be used in a transformation!\'\n *         else null\n *         endif\n *       in\n *         \'Mapping::containsDeactivatedHintGroups\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\n/*@Nullable\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    final /*@Thrown\052/ boolean deactivated = this.isDeactivated();\n    final /*@Thrown\052/ boolean eq = !deactivated;\n    /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> status;\n    if (eq) {\n        /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_eq_0;\n        try {\n            final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%pamtram.mapping.MappingHintGroupType%>> mappingHintGroups = this.getMappingHintGroups();\n            final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_mappingHintGroups = idResolver.createOrderedSetOfAll(<%pamtram.mapping.MappingTables%>.ORD_CLSSid_MappingHintGroupType, mappingHintGroups);\n            final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> size = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(BOXED_mappingHintGroups));\n            final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%pamtram.mapping.MappingHintGroupType%>> getActiveMappingHintGroups = this.getActiveMappingHintGroups();\n            final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_getActiveMappingHintGroups = idResolver.createOrderedSetOfAll(<%pamtram.mapping.MappingTables%>.ORD_CLSSid_MappingHintGroupType, getActiveMappingHintGroups);\n            final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> size_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(BOXED_getActiveMappingHintGroups));\n            final /*@Thrown\052/ boolean eq_0 = size.equals(size_0);\n            CAUGHT_eq_0 = eq_0;\n        }\n        catch (<%java.lang.Exception%> e) {\n            CAUGHT_eq_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n        }\n        /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_eq_1;\n        try {\n            final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%pamtram.mapping.MappingHintGroupImporter%>> importedMappingHintGroups = this.getImportedMappingHintGroups();\n            final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_importedMappingHintGroups = idResolver.createOrderedSetOfAll(<%pamtram.mapping.MappingTables%>.ORD_CLSSid_MappingHintGroupImporter, importedMappingHintGroups);\n            final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> size_1 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(BOXED_importedMappingHintGroups));\n            final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%pamtram.mapping.MappingHintGroupImporter%>> getActiveImportedMappingHintGroups = this.getActiveImportedMappingHintGroups();\n            final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_getActiveImportedMappingHintGroups = idResolver.createOrderedSetOfAll(<%pamtram.mapping.MappingTables%>.ORD_CLSSid_MappingHintGroupImporter, getActiveImportedMappingHintGroups);\n            final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> size_2 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(BOXED_getActiveImportedMappingHintGroups));\n            final /*@Thrown\052/ boolean eq_1 = size_1.equals(size_2);\n            CAUGHT_eq_1 = eq_1;\n        }\n        catch (<%java.lang.Exception%> e) {\n            CAUGHT_eq_1 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n        }\n        final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> and = <%org.eclipse.ocl.pivot.library.logical.BooleanAndOperation%>.INSTANCE.evaluate(CAUGHT_eq_0, CAUGHT_eq_1);\n        status = and;\n    }\n    else {\n        status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n    }\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    message_0 = <%pamtram.mapping.MappingTables%>.STR_The_32_mapping_32_contains_32_deactivated_32_hint_32_groups_32_that_32_will_32_not_32_be_32_us;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.mapping.MappingTables%>.STR_Mapping_c_c_containsDeactivatedHintGroups, this, null, diagnostics, context, message_0, <%pamtram.mapping.MappingTables%>.INT_2, CAUGHT_status, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue());\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean containsDeactivatedHintGroups(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Mapping
