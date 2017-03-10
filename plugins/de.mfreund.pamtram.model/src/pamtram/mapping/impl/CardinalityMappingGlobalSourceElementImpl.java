/**
 */
package pamtram.mapping.impl;

import org.eclipse.emf.ecore.EClass;

import pamtram.mapping.CardinalityMappingGlobalSourceElement;
import pamtram.mapping.MappingPackage;
import pamtram.structure.impl.GlobalModifiedAttributeElementTypeImpl;
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
		GlobalModifiedAttributeElementTypeImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>
		implements CardinalityMappingGlobalSourceElement {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CardinalityMappingGlobalSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return MappingPackage.Literals.CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT;
	}

} // CardinalityMappingGlobalSourceElementImpl
