/**
 */
package pamtram.mapping.extended;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import pamtram.ConditionalElement;
import pamtram.DeactivatableElement;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An abstract super-type for all MappingHints that can be used in MappingHintGroups.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.extended.MappingHint#getOverwrite <em>Overwrite</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.extended.ExtendedPackage#getMappingHint()
 * @model abstract="true"
 * @generated
 */
public interface MappingHint extends MappingHintType, ConditionalElement, DeactivatableElement {

	/**
	 * Returns the value of the '<em><b>Overwrite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A MappingHint from an extended MappingHintGroup that shall not be added to this MappingHintGroup but be overwritten instead.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Overwrite</em>' reference.
	 * @see #setOverwrite(MappingHint)
	 * @see pamtram.mapping.extended.ExtendedPackage#getMappingHint_Overwrite()
	 * @model
	 * @generated
	 */
	MappingHint getOverwrite();

	/**
	 * Sets the value of the '{@link pamtram.mapping.extended.MappingHint#getOverwrite <em>Overwrite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overwrite</em>' reference.
	 * @see #getOverwrite()
	 * @generated
	 */
	void setOverwrite(MappingHint value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel rename\040me\040to\040body='generate the model code first, insert the validation method body here'"
	 * @generated
	 */
	boolean validateOverwritesValidMappingHint(DiagnosticChain diagnostics, Map<?, ?> context);
} // MappingHint
