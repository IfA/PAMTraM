/**
 */
package pamtram.metamodel;




/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Section Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.TargetSectionAttribute#isUnique <em>Unique</em>}</li>
 *   <li>{@link pamtram.metamodel.TargetSectionAttribute#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getTargetSectionAttribute()
 * @model abstract="true"
 * @generated
 */
public interface TargetSectionAttribute extends Attribute<TargetSectionClass, TargetSectionReference, TargetSectionAttribute> {
	/**
	 * Returns the value of the '<em><b>Unique</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unique</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unique</em>' attribute.
	 * @see #setUnique(boolean)
	 * @see pamtram.metamodel.MetamodelPackage#getTargetSectionAttribute_Unique()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isUnique();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.TargetSectionAttribute#isUnique <em>Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unique</em>' attribute.
	 * @see #isUnique()
	 * @generated
	 */
	void setUnique(boolean value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see pamtram.metamodel.MetamodelPackage#getTargetSectionAttribute_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.TargetSectionAttribute#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // TargetSectionAttribute
