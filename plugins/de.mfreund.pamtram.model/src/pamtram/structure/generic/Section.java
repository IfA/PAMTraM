/**
 */
package pamtram.structure.generic;

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
 *   <li>{@link pamtram.structure.generic.Section#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link pamtram.structure.generic.Section#getExtend <em>Extend</em>}</li>
 *   <li>{@link pamtram.structure.generic.Section#getAllExtend <em>All Extend</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.generic.GenericPackage#getSection()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='extendsValidSections containerMatchesExtendContainer'"
 * @generated
 */
public interface Section<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends pamtram.structure.generic.Class<S, C, R, A> {

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
	 * @see pamtram.structure.generic.GenericPackage#getSection_Abstract()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link pamtram.structure.generic.Section#isAbstract <em>Abstract</em>}' attribute.
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
	 * @see pamtram.structure.generic.GenericPackage#getSection_Extend()
	 * @model
	 * @generated
	 */
	EList<S> getExtend();

	/**
	 * Returns the value of the '<em><b>All Extend</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Extend</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Extend</em>' reference list.
	 * @see pamtram.structure.generic.GenericPackage#getSection_AllExtend()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%java.util.List%><Object> ret = new <%java.util.ArrayList%><>(this.getExtend());\r\n\r\nret.addAll(this.getExtend().stream().flatMap(s -> s.getAllExtend().stream()).collect(<%java.util.stream.Collectors%>.toList()));\r\n\r\nret = ret.stream().distinct().collect(Collectors.toList());\r\n\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.structure.generic.GenericPackage%>.Literals.SECTION__ALL_EXTEND,\r\n\t\tret.size(), ret.toArray());'"
	 * @generated
	 */
	EList<S> getAllExtend();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if(this.getContainer() == null) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = this.getExtend().parallelStream().allMatch(\r\n\t\te -> e.getContainer() == null || e.getContainer() == this.getContainer());\r\n\r\nif (!result && diagnostics != null) {\r\n\t\r\n\tString errorMessage = \"The section extends a section that specifies a different container!\";\r\n\t\r\n\tdiagnostics.add\r\n\t\t(new BasicDiagnostic\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t <%pamtram.structure.generic.util.GenericValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\tGenericValidator.SECTION__VALIDATE_CONTAINER_MATCHES_EXTEND_CONTAINER,\r\n\t\t\t errorMessage,\r\n\t\t\t new Object [] { this, <%pamtram.structure.generic.GenericPackage%>.Literals.SECTION__EXTEND }));\r\n\t}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateContainerMatchesExtendContainer(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif(this.getEClass() == null) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = this.getExtend().parallelStream().noneMatch(e -> !e.isAbstract() || e.getEClass() != null\r\n\t\t&& this.getEClass() != e.getEClass() && !this.getEClass().getEAllSuperTypes().contains(e.getEClass()));\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The section extends a section that is either not abstract or that references an EClass of a different (super-)type!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.structure.generic.util.GenericValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tGenericValidator.SECTION__VALIDATE_EXTENDS_VALID_SECTIONS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.generic.GenericPackage%>.Literals.SECTION__EXTEND }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateExtendsValidSections(DiagnosticChain diagnostics, Map<?, ?> context);
} // Section
