/**
 */
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;
import pamtram.metamodel.ActualSourceSectionAttribute;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Connection Hint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.ModelConnectionHint#getTargetAttributes <em>Target Attributes</em>}</li>
 *   <li>{@link pamtram.mapping.ModelConnectionHint#getSourceElements <em>Source Elements</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getModelConnectionHint()
 * @model
 * @generated
 */
public interface ModelConnectionHint extends MappingHintBaseType {

	/**
	 * Returns the value of the '<em><b>Target Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.ModelConnectionHintTargetAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Attributes</em>' containment reference list.
	 * @see pamtram.mapping.MappingPackage#getModelConnectionHint_TargetAttributes()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!ModelConnectionHint!targetAttributes'"
	 * @generated
	 */
	EList<ModelConnectionHintTargetAttribute> getTargetAttributes();

	/**
	 * Returns the value of the '<em><b>Source Elements</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.ModelConnectionHintSourceInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Elements</em>' containment reference list.
	 * @see pamtram.mapping.MappingPackage#getModelConnectionHint_SourceElements()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!ModelConnectionHint!sourceElements'"
	 * @generated
	 */
	EList<ModelConnectionHintSourceInterface> getSourceElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!ModelConnectionHint!getSourceAttributes()'"
	 * @generated
	 */
	EList<ActualSourceSectionAttribute> getSourceAttributes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\t\tEList<ModelConnectionHintSourceElement> elements= new org.eclipse.emf.common.util.BasicEList<ModelConnectionHintSourceElement>();\r\n\t\t\r\n\t\tfor(ModelConnectionHintSourceInterface i : this.getSourceElements()){\r\n\t\t\tif(i instanceof ModelConnectionHintSourceElement){\r\n\t\t\t\telements.add((ModelConnectionHintSourceElement) i);\r\n\t\t\t}\r\n\t\t}\r\n\t\t\r\n\t\treturn elements;'"
	 * @generated
	 */
	EList<ModelConnectionHintSourceElement> getLocalSourceElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<ModelConnectionHintExternalSourceElement> elements= new org.eclipse.emf.common.util.BasicEList<>();\r\n\r\nfor(ModelConnectionHintSourceInterface i : this.getSourceElements()){\r\n\tif(i instanceof ModelConnectionHintExternalSourceElement){\r\n\t\telements.add((ModelConnectionHintExternalSourceElement) i);\r\n\t}\r\n}\r\n\r\nreturn elements;'"
	 * @generated
	 */
	EList<ModelConnectionHintExternalSourceElement> getExternalSourceElements();

} // ModelConnectionHint
