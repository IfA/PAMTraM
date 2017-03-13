/**
 */
package pamtram.mapping.impl;

import org.eclipse.emf.ecore.EClass;

import pamtram.mapping.ContainerSelectorGlobalSourceElement;
import pamtram.mapping.MappingPackage;
import pamtram.structure.impl.GlobalModifiedAttributeElementTypeImpl;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Model Connection Hint Global Source
 * Element</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public class ContainerSelectorGlobalSourceElementImpl extends
		GlobalModifiedAttributeElementTypeImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>
		implements ContainerSelectorGlobalSourceElement {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainerSelectorGlobalSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.CONTAINER_SELECTOR_GLOBAL_SOURCE_ELEMENT;
	}

} // ModelConnectionHintGlobalSourceElementImpl
