/**
 */
package pamtram.mapping.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import pamtram.mapping.CardinalityMappingGlobalSourceElement;
import pamtram.mapping.MappingPackage;
import pamtram.structure.SourceInstanceSelector;
import pamtram.structure.impl.GlobalDynamicSourceElementImpl;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Cardinality Mapping Global Source
 * Element</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public class CardinalityMappingGlobalSourceElementImpl extends
		GlobalDynamicSourceElementImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute, SourceInstanceSelector>
		implements CardinalityMappingGlobalSourceElement {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CardinalityMappingGlobalSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT;
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
			instanceSelectors = new EObjectContainmentEList<SourceInstanceSelector>(SourceInstanceSelector.class, this, MappingPackage.CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT__INSTANCE_SELECTORS);
		}
		return instanceSelectors;
	}

} // CardinalityMappingGlobalSourceElementImpl
