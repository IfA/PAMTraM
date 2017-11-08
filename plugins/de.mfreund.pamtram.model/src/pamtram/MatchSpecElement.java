/**
 */
package pamtram;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Match Spec Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A MatchSpecElement can be equipped with a 'referenceMatchSpec' consisting of a list of References. The 'referenceMatchSpec' restricts the application of matched elements by specifiy an additional path (based on references).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.MatchSpecElement#getReferenceMatchSpec <em>Reference Match Spec</em>}</li>
 * </ul>
 *
 * @see pamtram.PamtramPackage#getMatchSpecElement()
 * @model abstract="true"
 * @generated
 */
public interface MatchSpecElement<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends EObject {
	/**
	 * Returns the value of the '<em><b>Reference Match Spec</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * In case of SourceSections referencing itself via a CrossReference, it may be necessary to further restrict the determined values that are used for calculation (e.g. do not use the 'own' attribute value but only attribute values of 'referenced' elements. Therefore, this allows to specify a list of References describing a path how to get to the relevant instances based on the root element of the Section.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Reference Match Spec</em>' reference list.
	 * @see pamtram.PamtramPackage#getMatchSpecElement_ReferenceMatchSpec()
	 * @model
	 * @generated
	 */
	EList<R> getReferenceMatchSpec();

} // MatchSpecElement
