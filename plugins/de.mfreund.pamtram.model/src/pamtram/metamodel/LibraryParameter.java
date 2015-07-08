/**
 */
package pamtram.metamodel;

import org.eclipse.emf.ecore.EObject;
import pamtram.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Library Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.LibraryParameter#getSource <em>Source</em>}</li>
 *   <li>{@link pamtram.metamodel.LibraryParameter#getOriginalParameter <em>Original Parameter</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getLibraryParameter()
 * @model abstract="true"
 * @generated
 */
public interface LibraryParameter<ParameterType> extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(EObject)
	 * @see pamtram.metamodel.MetamodelPackage#getLibraryParameter_Source()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!LibraryParameter{ParameterType}!source'"
	 * @generated
	 */
	EObject getSource();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.LibraryParameter#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(EObject value);

	/**
	 * Returns the value of the '<em><b>Original Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Parameter</em>' reference.
	 * @see #setOriginalParameter(Object)
	 * @see pamtram.metamodel.MetamodelPackage#getLibraryParameter_OriginalParameter()
	 * @model kind="reference" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!LibraryParameter{ParameterType}!originalParameter'"
	 * @generated
	 */
	ParameterType getOriginalParameter();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.LibraryParameter#getOriginalParameter <em>Original Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Parameter</em>' reference.
	 * @see #getOriginalParameter()
	 * @generated
	 */
	void setOriginalParameter(ParameterType value);

} // LibraryParameter
