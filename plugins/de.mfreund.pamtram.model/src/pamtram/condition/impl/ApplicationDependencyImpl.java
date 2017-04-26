/**
 */
package pamtram.condition.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import pamtram.ConditionalElement;
import pamtram.condition.ApplicationDependency;
import pamtram.condition.ConditionPackage;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.extended.MappingHint;
import pamtram.structure.source.SourceSection;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Application Dependency</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public class ApplicationDependencyImpl extends ConditionImpl<ConditionalElement> implements ApplicationDependency {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ApplicationDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConditionPackage.Literals.APPLICATION_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> This is specialized for the
	 * more specific type known in this context.
	 * 
	 * @generated
	 */
	@Override
	public void setTarget(ConditionalElement newTarget) {
		super.setTarget(newTarget);
	}

	@Override
	public boolean isLocalCondition() {

		Mapping mapping = null;
		if (this.getTarget() instanceof Mapping) {
			mapping = (Mapping) this.getTarget();
		} else if (this.getTarget() instanceof InstantiableMappingHintGroup) {
			mapping = (Mapping) this.getTarget().eContainer();
		} else if (this.getTarget() instanceof MappingHint) {
			mapping = (Mapping) this.getTarget().eContainer().eContainer();
		} else {
			throw new RuntimeException(
					"Unknown type of ConditionalElement '" + this.getTarget().eClass().getName() + "' found!");
		}

		SourceSection sourceSection = mapping.getSourceSection();

		if (sourceSection == null) {
			return false;
		}

		// The SourceSection that the condition references
		//
		SourceSection referencedSection = sourceSection.getContainingSection();

		EObject container = this;

		while (!(container instanceof Mapping)) {
			if (container == null) {
				return false;
			}
			container = container.eContainer();
		}

		// The SourceSection of the Mapping that contains the condition
		//
		SourceSection localSection = ((Mapping) container).getSourceSection();

		// A condition is local if it is based on the same section as the
		// containing mapping or if this section that is a direct or indirect
		// container section of the section referenced by the condition
		//
		do {
			if (referencedSection.equals(localSection)) {
				return true;
			}
		} while (referencedSection.getContainer() != null
				&& (referencedSection = referencedSection.getContainer().getContainingSection()) != null);

		// A condition is also 'local' if an InstanceSelector with local or
		// external SourceAttributes exist
		//
		return this.getInstanceSelectors().parallelStream()
				.flatMap(instancePointer -> instancePointer.getSourceElements().parallelStream()
						.filter(s -> s instanceof pamtram.structure.InstanceSelectorSourceElement
								|| s instanceof pamtram.structure.InstanceSelectorExternalSourceElement))
				.findAny().isPresent();
	}

} // ApplicationDependencyImpl
