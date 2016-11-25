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
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='extendsValidSections containerMatchesExtendContainer'"
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
	 * @model
	 * @generated
	 */
	EList<S> getExtend();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if(this.getContainer() == null) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = this.getExtend().parallelStream().allMatch(\r\n\t\te -> e.getContainer() == null || e.getContainer() == this.getContainer());\r\n\r\nif (!result && diagnostics != null) {\r\n\t\r\n\tString errorMessage = \"The section extends a section that specifies a different container!\";\r\n\t\r\n\tdiagnostics.add\r\n\t\t(new BasicDiagnostic\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t <%pamtram.metamodel.util.MetamodelValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\tMetamodelValidator.SECTION__VALIDATE_CONTAINER_MATCHES_EXTEND_CONTAINER,\r\n\t\t\t errorMessage,\r\n\t\t\t new Object [] { this, <%pamtram.metamodel.MetamodelPackage%>.Literals.SECTION__EXTEND }));\r\n\t}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateContainerMatchesExtendContainer(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif(this.getEClass() == null) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = this.getExtend().parallelStream().noneMatch(e -> !e.isAbstract() || e.getEClass() != null\r\n\t\t&& this.getEClass() != e.getEClass() && !this.getEClass().getEAllSuperTypes().contains(e.getEClass()));\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The section extends a section that is either not abstract or that references an EClass of a different (super-)type!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.metamodel.util.MetamodelValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMetamodelValidator.SECTION__VALIDATE_EXTENDS_VALID_SECTIONS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.metamodel.MetamodelPackage%>.Literals.SECTION__EXTEND }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateExtendsValidSections(DiagnosticChain diagnostics, Map<?, ?> context);
} // Section
