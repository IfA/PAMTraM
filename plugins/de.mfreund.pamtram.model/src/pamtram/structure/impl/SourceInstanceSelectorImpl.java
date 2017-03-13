/**
 */
package pamtram.structure.impl;

import org.eclipse.emf.ecore.EClass;

import pamtram.structure.SourceInstanceSelector;
import pamtram.structure.StructurePackage;

import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source Instance Selector</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class SourceInstanceSelectorImpl extends InstanceSelectorImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> implements SourceInstanceSelector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceInstanceSelectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructurePackage.Literals.SOURCE_INSTANCE_SELECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific type known in this context.
	 * @generated
	 */
	@Override
	public void setTarget(SourceSectionAttribute newTarget) {
		super.setTarget(newTarget);
	}

} //SourceInstanceSelectorImpl
