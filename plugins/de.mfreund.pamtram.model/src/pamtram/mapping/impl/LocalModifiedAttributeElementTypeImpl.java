/**
 */
package pamtram.mapping.impl;

import org.eclipse.emf.ecore.EClass;
import pamtram.mapping.LocalModifiedAttributeElementType;
import pamtram.mapping.MappingPackage;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.Reference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Local Modified Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class LocalModifiedAttributeElementTypeImpl<C extends pamtram.metamodel.Class<C, R, A>, R extends Reference<C, R, A>, A extends Attribute<C, R, A>> extends ModifiedAttributeElementTypeImpl<C, R, A> implements LocalModifiedAttributeElementType<C, R, A> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocalModifiedAttributeElementTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE;
	}

} //LocalModifiedAttributeElementTypeImpl
