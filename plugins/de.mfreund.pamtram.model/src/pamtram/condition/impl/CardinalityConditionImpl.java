/**
 */
package pamtram.condition.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import pamtram.condition.ConditionPackage;
import pamtram.condition.CardinalityCondition;
import pamtram.mapping.Mapping;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Section Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class CardinalityConditionImpl extends ConditionImpl<SourceSectionClass> implements CardinalityCondition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CardinalityConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConditionPackage.Literals.CARDINALITY_CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific type known in this context.
	 * @generated
	 */
	@Override
	public void setTarget(SourceSectionClass newTarget) {
		super.setTarget(newTarget);
	}

	@Override
	public boolean isLocalCondition() {
		
		if(getTarget() == null) {
			return false;
		}
		
		// The SourceSection that the condition references
		//
		SourceSection referencedSection = getTarget().getContainingSection();
		
		EObject container = this;
		
		while(!(container instanceof Mapping)) {
			if(container == null) {
				return false;
			}
			container = container.eContainer();
		}
		
		// The SourceSection of the Mapping that contains the condition
		//
		SourceSection localSection = ((Mapping) container).getSourceSection();
		
		if(referencedSection.equals(localSection)) {
			return true;
		}
		
		// A condition is also 'local' if an InstanceSelector with local or external SourceAttributes exist
		//
		return getInstanceSelectors().parallelStream().flatMap(
				instancePointer -> instancePointer.getSourceElements().parallelStream().filter(
						s -> s instanceof pamtram.structure.InstanceSelectorSourceElement || 
						s instanceof pamtram.structure.InstanceSelectorExternalSourceElement)
				).findAny().isPresent();
	}

} //SectionConditionImpl
