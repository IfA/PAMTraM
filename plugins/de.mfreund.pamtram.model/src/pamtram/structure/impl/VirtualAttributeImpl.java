/**
 */
package pamtram.structure.impl;

import org.eclipse.emf.ecore.EClass;

import pamtram.structure.Attribute;
import pamtram.structure.MetamodelPackage;
import pamtram.structure.Reference;
import pamtram.structure.Section;
import pamtram.structure.VirtualAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Virtual Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class VirtualAttributeImpl<S extends Section<S, C, R, A>, C extends pamtram.structure.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends AttributeImpl<S, C, R, A> implements VirtualAttribute<S, C, R, A> {
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
		return MetamodelPackage.Literals.VIRTUAL_ATTRIBUTE;
	}

} //VirtualAttributeImpl
