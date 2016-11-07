/**
 */
package pamtram.metamodel;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import pamtram.mapping.MappingHintGroupType;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.TargetSection#getReferencingMappingHintGroups <em>Referencing Mapping Hint Groups</em>}</li>
 *   <li>{@link pamtram.metamodel.TargetSection#getFile <em>File</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getTargetSection()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='isReferencedByMappingHintGroup'"
 * @generated
 */
public interface TargetSection extends TargetSectionClass, Section<TargetSection, TargetSectionClass, TargetSectionReference, TargetSectionAttribute> {

	/**
	 * Returns the value of the '<em><b>Referencing Mapping Hint Groups</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.MappingHintGroupType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referencing Mapping Hint Groups</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referencing Mapping Hint Groups</em>' reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getTargetSection_ReferencingMappingHintGroups()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='\r\nList<<%pamtram.mapping.Mapping%>> mappings = new <%java.util.ArrayList%><>();\r\n\r\nif (this.eResource() != null) {\r\n\r\n\tmappings = this.eResource().getResourceSet().getResources().stream()\r\n\t\t\t.filter(r -> r.getContents().get(0) instanceof pamtram.PAMTraM)\r\n\t\t\t.flatMap(r -> ((pamtram.PAMTraM) r.getContents().get(0)).getMappings().parallelStream())\r\n\t\t\t.collect(<%java.util.stream.Collectors%>.toList());\r\n}\r\n\r\nList<MappingHintGroupType> referencingHintGroups = mappings.parallelStream().flatMap(m -> m.getMappingHintGroups().parallelStream()).filter(m -> this.equals(m.getTargetSection())).collect(Collectors.toList());\r\n\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList.UnmodifiableEList%><>(this, <%pamtram.metamodel.MetamodelPackage%>.Literals.TARGET_SECTION__REFERENCING_MAPPING_HINT_GROUPS,\r\n\t\treferencingHintGroups.size(), referencingHintGroups.toArray());'"
	 * @generated
	 */
	EList<MappingHintGroupType> getReferencingMappingHintGroups();

	/**
	 * Returns the value of the '<em><b>File</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' reference.
	 * @see #setFile(FileAttribute)
	 * @see pamtram.metamodel.MetamodelPackage#getTargetSection_File()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!TargetSection!file'"
	 * @generated
	 */
	FileAttribute getFile();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.TargetSection#getFile <em>File</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' reference.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(FileAttribute value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv isReferencedByMappingHintGroup:\n *   let severity : Integer[1] = 2\n *   in\n *     let status : OclAny[1] = self.referencingMappingHintGroups->size() > 0\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'The section is not referenced by any hint group and will not be instantiated!\'\n *         else null\n *         endif\n *       in\n *         \'TargetSection::isReferencedByMappingHintGroup\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Executor%> executor = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getExecutor(this);\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = executor.getIdResolver();\n/*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    final /*@Thrown\052/ <%java.util.List%><<%pamtram.mapping.MappingHintGroupType%>> referencingMappingHintGroups = this.getReferencingMappingHintGroups();\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_referencingMappingHintGroups = idResolver.createOrderedSetOfAll(<%pamtram.metamodel.MetamodelTables%>.ORD_CLSSid_MappingHintGroupType, referencingMappingHintGroups);\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> size = <%org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(BOXED_referencingMappingHintGroups);\n    final /*@Thrown\052/ boolean status = <%org.eclipse.ocl.pivot.library.oclany.OclComparableGreaterThanOperation%>.INSTANCE.evaluate(executor, size, <%pamtram.metamodel.MetamodelTables%>.INT_0).booleanValue();\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    message_0 = <%pamtram.metamodel.MetamodelTables%>.STR_The_32_section_32_is_32_not_32_referenced_32_by_32_any_32_hint_32_group_32_and_32_will_32_not_32_be_32;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(executor, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.metamodel.MetamodelTables%>.STR_TargetSection_c_c_isReferencedByMappingHintGroup, this, null, diagnostics, context, message_0, <%pamtram.metamodel.MetamodelTables%>.INT_2, CAUGHT_status, <%pamtram.metamodel.MetamodelTables%>.INT_0).booleanValue();\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean isReferencedByMappingHintGroup(DiagnosticChain diagnostics, Map<Object, Object> context);
} // TargetSection
