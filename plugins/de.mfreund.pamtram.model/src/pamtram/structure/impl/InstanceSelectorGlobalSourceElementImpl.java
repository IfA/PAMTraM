/**
 */
package pamtram.structure.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import pamtram.structure.InstanceSelectorGlobalSourceElement;
import pamtram.structure.SourceInstanceSelector;
import pamtram.structure.StructurePackage;

import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance Selector Global Source Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class InstanceSelectorGlobalSourceElementImpl extends GlobalDynamicSourceElementImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute, SourceInstanceSelector> implements InstanceSelectorGlobalSourceElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstanceSelectorGlobalSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructurePackage.Literals.INSTANCE_SELECTOR_GLOBAL_SOURCE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific element type known in this context.
	 * @generated
	 */
	@Override
	public EList<SourceInstanceSelector> getInstanceSelectors() {
		if (instanceSelectors == null) {
			instanceSelectors = new EObjectContainmentEList<SourceInstanceSelector>(SourceInstanceSelector.class, this, StructurePackage.INSTANCE_SELECTOR_GLOBAL_SOURCE_ELEMENT__INSTANCE_SELECTORS);
		}
		return instanceSelectors;
	}

} //InstanceSelectorGlobalSourceElementImpl
