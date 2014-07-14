/**
 */
package pamtram.mapping.impl;

import org.eclipse.emf.ecore.EClass;

import pamtram.impl.NamedElementImpl;
import pamtram.mapping.AttributeValueModifier;
import pamtram.mapping.MappingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Value Modifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class AttributeValueModifierImpl extends NamedElementImpl implements AttributeValueModifier {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeValueModifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.ATTRIBUTE_VALUE_MODIFIER;
	}
	
	protected abstract String modifyValue(String value);

	@Override
	public String modify(String value) {
		return modifyValue(value == null ? "" : value);
	}

} //AttributeValueModifierImpl
