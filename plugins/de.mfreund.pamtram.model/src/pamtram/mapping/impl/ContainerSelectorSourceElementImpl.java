/**
 */
package pamtram.mapping.impl;

import org.eclipse.emf.ecore.EClass;

import pamtram.mapping.ContainerSelectorSourceElement;
import pamtram.mapping.MappingPackage;
import pamtram.structure.impl.LocalModifiedAttributeElementTypeImpl;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Model Connection Hint Source Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ContainerSelectorSourceElementImpl extends
		LocalModifiedAttributeElementTypeImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>
		implements ContainerSelectorSourceElement {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainerSelectorSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.CONTAINER_SELECTOR_SOURCE_ELEMENT;
	}

} // ModelConnectionHintSourceElementImpl
