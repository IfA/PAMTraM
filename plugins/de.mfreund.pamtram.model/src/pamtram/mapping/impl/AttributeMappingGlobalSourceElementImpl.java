/**
 */
package pamtram.mapping.impl;

import org.eclipse.emf.ecore.EClass;

import pamtram.mapping.AttributeMappingGlobalSourceElement;
import pamtram.mapping.MappingPackage;
import pamtram.structure.impl.GlobalDynamicSourceElementImpl;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Attribute Mapping Global Source
 * Element</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public class AttributeMappingGlobalSourceElementImpl extends
		GlobalDynamicSourceElementImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>
		implements AttributeMappingGlobalSourceElement {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeMappingGlobalSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT;
	}

} // AttributeMappingGlobalSourceElementImpl
