/**
 */
package pamtram.mapping.impl;

import org.eclipse.emf.ecore.EClass;

import pamtram.mapping.AttributeMappingSourceElement;
import pamtram.mapping.MappingPackage;
import pamtram.structure.impl.LocalModifiedAttributeElementTypeImpl;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Attribute Mapping Source Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class AttributeMappingSourceElementImpl extends
		LocalModifiedAttributeElementTypeImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>
		implements AttributeMappingSourceElement {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AttributeMappingSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return MappingPackage.Literals.ATTRIBUTE_MAPPING_SOURCE_ELEMENT;
	}

} // AttributeMappingSourceElementImpl
