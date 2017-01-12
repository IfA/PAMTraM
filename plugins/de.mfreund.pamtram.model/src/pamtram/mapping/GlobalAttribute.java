/**
 */
package pamtram.mapping;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import pamtram.NamedElement;
import pamtram.mapping.modifier.ValueModifierSet;
import pamtram.structure.ActualSourceSectionAttribute;


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
	 * @see #setSource(ActualSourceSectionAttribute)
	 * @see pamtram.mapping.MappingPackage#getGlobalAttribute_Source()
	 * @model required="true"
	 * @generated
	 */
	ActualSourceSectionAttribute getSource();

	/**
	 * Sets the value of the '{@link pamtram.mapping.GlobalAttribute#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(ActualSourceSectionAttribute value);

	/**
	 * Returns the value of the '<em><b>Modifier</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.modifier.ValueModifierSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modifier</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modifier</em>' reference list.
	 * @see pamtram.mapping.MappingPackage#getGlobalAttribute_Modifier()
	 * @model
	 * @generated
	 */
	EList<ValueModifierSet> getModifier();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this.getSource() == null || this.getSource().getAttribute() == null ? true : this.getSource().getAttribute().getUpperBound() == 1;\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"Global attributes may only be defined for attributes that have an upper bound of 1!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.util.MappingValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMappingValidator.GLOBAL_ATTRIBUTE__VALIDATE_SOURCE_ATTRIBUTE_HAS_UPPER_BOUND_ONE,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.MappingPackage%>.Literals.GLOBAL_ATTRIBUTE__SOURCE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateSourceAttributeHasUpperBoundOne(DiagnosticChain diagnostics, Map<?, ?> context);
} // GlobalVariable
