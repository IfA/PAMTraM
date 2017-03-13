/**
 */
package pamtram.mapping.impl;

import org.eclipse.emf.ecore.EClass;

import pamtram.mapping.ContainerSelectorExternalSourceElement;
import pamtram.mapping.MappingPackage;
import pamtram.structure.impl.ExternalModifiedAttributeElementTypeImpl;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Model Connection Hint External Source
 * Element</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public class ContainerSelectorExternalSourceElementImpl extends
		ExternalModifiedAttributeElementTypeImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>
		implements ContainerSelectorExternalSourceElement {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainerSelectorExternalSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.CONTAINER_SELECTOR_EXTERNAL_SOURCE_ELEMENT;
	}

} // ModelConnectionHintExternalSourceElementImpl
