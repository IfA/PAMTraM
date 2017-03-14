/**
 */
package pamtram.mapping.impl;

import org.eclipse.emf.ecore.EClass;

import pamtram.mapping.CardinalityMappingSourceElement;
import pamtram.mapping.MappingPackage;
import pamtram.structure.impl.LocalDynamicSourceElementImpl;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Cardinality Mapping Source Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class CardinalityMappingSourceElementImpl extends
		LocalDynamicSourceElementImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>
		implements CardinalityMappingSourceElement {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CardinalityMappingSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.CARDINALITY_MAPPING_SOURCE_ELEMENT;
	}

} // CardinalityMappingSourceElementImpl
