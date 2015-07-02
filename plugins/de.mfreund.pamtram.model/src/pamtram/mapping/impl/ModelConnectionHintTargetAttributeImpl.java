/**
 */
package pamtram.mapping.impl;

import org.eclipse.emf.ecore.EClass;

import pamtram.mapping.MappingPackage;
import pamtram.mapping.ModelConnectionHintTargetAttribute;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Connection Hint Target Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ModelConnectionHintTargetAttributeImpl extends ModifiedAttributeElementTypeImpl<TargetSectionClass, TargetSectionReference, TargetSectionAttribute> implements ModelConnectionHintTargetAttribute {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelConnectionHintTargetAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.MODEL_CONNECTION_HINT_TARGET_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific type known in this context.
	 * @generated
	 */
	@Override
	public void setSource(TargetSectionAttribute newSource) {
		super.setSource(newSource);
	}

} //ModelConnectionHintTargetAttributeImpl
