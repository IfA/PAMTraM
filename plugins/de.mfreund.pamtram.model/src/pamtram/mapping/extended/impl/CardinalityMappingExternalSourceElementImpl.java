/**
 */
package pamtram.mapping.extended.impl;

import org.eclipse.emf.ecore.EClass;
import pamtram.mapping.extended.CardinalityMappingExternalSourceElement;
import pamtram.mapping.extended.ExtendedPackage;
import pamtram.structure.impl.ExternalDynamicSourceElementImpl;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Cardinality Mapping External Source
 * Element</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public class CardinalityMappingExternalSourceElementImpl extends
		ExternalDynamicSourceElementImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>
		implements CardinalityMappingExternalSourceElement {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CardinalityMappingExternalSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExtendedPackage.Literals.CARDINALITY_MAPPING_EXTERNAL_SOURCE_ELEMENT;
	}

} // CardinalityMappingExternalSourceElementImpl