/**
 */
package pamtram.mapping.extended.impl;

import org.eclipse.emf.ecore.EClass;
import pamtram.mapping.extended.AttributeMappingExternalSourceElement;
import pamtram.mapping.extended.ExtendedPackage;
import pamtram.structure.impl.ExternalDynamicSourceElementImpl;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Attribute Mapping External Source
 * Element</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public class AttributeMappingExternalSourceElementImpl extends
		ExternalDynamicSourceElementImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>
		implements AttributeMappingExternalSourceElement {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeMappingExternalSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExtendedPackage.Literals.ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT;
	}

} // AttributeMappingExternalSourceElementImpl