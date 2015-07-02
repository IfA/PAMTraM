/**
 */
package pamtram.mapping.impl;

import org.eclipse.emf.ecore.EClass;
import pamtram.mapping.ExternalModifiedAttributeElementType;
import pamtram.mapping.MappingPackage;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.Reference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Modified Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ExternalModifiedAttributeElementTypeImpl<C extends pamtram.metamodel.Class<C, R, A>, R extends Reference<C, R, A>, A extends Attribute<C, R, A>> extends ModifiedAttributeElementTypeImpl<C, R, A> implements ExternalModifiedAttributeElementType<C, R, A> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalModifiedAttributeElementTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE;
	}

} //ExternalModifiedAttributeElementTypeImpl
