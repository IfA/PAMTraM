/**
 */
package pamtram.mapping.impl;

import org.eclipse.emf.ecore.EClass;
import pamtram.mapping.LocalModifiedAttributeElementType;
import pamtram.mapping.MappingPackage;
import pamtram.metamodel.SourceSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Local Modified Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class LocalModifiedAttributeElementTypeImpl<AttributeType extends SourceSectionAttribute> extends ModifiedAttributeElementTypeImpl<AttributeType> implements LocalModifiedAttributeElementType<AttributeType> {
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific type known in this context.
	 * @generated
	 */
	@Override
	public void setSource(AttributeType newSource) {
		super.setSource(newSource);
	}

} //LocalModifiedAttributeElementTypeImpl
