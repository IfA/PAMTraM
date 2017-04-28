/**
 */
package pamtram.condition.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import pamtram.condition.CardinalityCondition;
import pamtram.condition.ConditionPackage;
import pamtram.mapping.Mapping;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionClass;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Section
 * Condition</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public class CardinalityConditionImpl extends ConditionImpl<SourceSectionClass> implements CardinalityCondition {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CardinalityConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConditionPackage.Literals.CARDINALITY_CONDITION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> This is specialized for the
	 * more specific type known in this context.
	 *
	 * @generated
	 */
	@Override
	public void setTarget(SourceSectionClass newTarget) {
		super.setTarget(newTarget);
	}

	@Override
	public boolean isLocalCondition() {

		if (this.getTarget() == null) {
			return false;
		}

		// The SourceSection that the condition references
		//
		SourceSection referencedSection = this.getTarget().getContainingSection();

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
		// A condition is also local if it is based on a container section of
		// the section referenced by the mapping
		//
		//
		if (referencedSection.equals(localSection) || referencedSection.getAllContainer().contains(localSection)
				|| localSection.getAllContainer().contains(referencedSection)) {
			return true;
		}

		// A condition is also 'local' if an InstanceSelector with local or
		// external SourceAttributes exist
		//
		return this.getInstanceSelectors().parallelStream()
				.flatMap(instancePointer -> instancePointer.getSourceElements().parallelStream()
						.filter(s -> s instanceof pamtram.structure.InstanceSelectorSourceElement
								|| s instanceof pamtram.structure.InstanceSelectorExternalSourceElement))
				.findAny().isPresent();
	}

} // SectionConditionImpl
