/**
 */
package pamtram.structure.generic.impl;

import org.eclipse.emf.ecore.EClass;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;
import pamtram.structure.generic.VirtualAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Virtual Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class VirtualAttributeImpl<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends AttributeImpl<S, C, R, A> implements VirtualAttribute<S, C, R, A> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenericPackage.Literals.VIRTUAL_ATTRIBUTE;
	}

} //VirtualAttributeImpl
