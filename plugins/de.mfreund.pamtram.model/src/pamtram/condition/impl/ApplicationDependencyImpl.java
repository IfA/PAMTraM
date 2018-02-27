/**
 */
package pamtram.condition.impl;

import org.eclipse.emf.ecore.EClass;

import pamtram.ConditionalElement;
import pamtram.condition.ApplicationDependency;
import pamtram.condition.ConditionPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Application Dependency</b></em>'. <!--
 * end-user-doc -->
 *
 * @generated
 */
public class ApplicationDependencyImpl extends ConditionImpl<ConditionalElement> implements ApplicationDependency {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplicationDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConditionPackage.Literals.APPLICATION_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> This is specialized for the more specific type known in this
	 * context.
	 *
	 * @generated
	 */
	@Override
	public void setTarget(ConditionalElement newTarget) {
		super.setTarget(newTarget);
	}

} // ApplicationDependencyImpl
