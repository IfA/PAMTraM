/**
 */
package pamtram.metamodel.impl;

import org.eclipse.emf.ecore.EClass;

import pamtram.metamodel.Attribute;
import pamtram.metamodel.MetamodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class AttributeImpl<C extends pamtram.metamodel.Class<?, ?>> extends MetaModelElementImpl<C> implements Attribute<C> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.ATTRIBUTE;
	}

} //AttributeImpl
