/**
 */
package pamtram.structure.impl;

import org.eclipse.emf.ecore.EClass;

import pamtram.structure.StructurePackage;
import pamtram.structure.TargetInstanceSelector;

import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target Instance Selector</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class TargetInstanceSelectorImpl extends InstanceSelectorImpl<TargetSection, TargetSectionClass, TargetSectionReference, TargetSectionAttribute> implements TargetInstanceSelector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetInstanceSelectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructurePackage.Literals.TARGET_INSTANCE_SELECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific type known in this context.
	 * @generated
	 */
	@Override
	public void setTarget(TargetSectionAttribute newTarget) {
		super.setTarget(newTarget);
	}

} //TargetInstanceSelectorImpl
