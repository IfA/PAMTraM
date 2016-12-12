/**
 */
package pamtram.structure;

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
 *   <li>{@link pamtram.structure.MetaModelSectionReference#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.StructurePackage#getMetaModelSectionReference()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='valuesMatchReferenceType'"
 * @generated
 */
public interface MetaModelSectionReference extends SourceSectionReference {

	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference list.
	 * The list contents are of type {@link pamtram.structure.SourceSectionClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference list.
	 * @see pamtram.structure.StructurePackage#getMetaModelSectionReference_Value()
	 * @model
	 * @generated
	 */
	EList<SourceSectionClass> getValue();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this.getEReference() == null ? true : this.getValue().parallelStream().allMatch(c -> this.getEReference().getEReferenceType().isSuperTypeOf(c.getEClass()));\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = this.getValue().parallelStream()\r\n\t\t.filter(c -> !this.getEReference().getEReferenceType().isSuperTypeOf(c.getEClass())).count()\r\n\t\t+ \" of the selected target Classes (Value) are not allowed by the selected eReference \'\"\r\n\t\t+ this.getEReference().getName() + \"\'!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.structure.util.StructureValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMetamodelValidator.META_MODEL_SECTION_REFERENCE__VALIDATE_VALUES_MATCH_REFERENCE_TYPE,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.StructurePackage%>.Literals.META_MODEL_SECTION_REFERENCE__VALUE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateValuesMatchReferenceType(DiagnosticChain diagnostics, Map<?, ?> context);

} // MetaModelSectionReference
