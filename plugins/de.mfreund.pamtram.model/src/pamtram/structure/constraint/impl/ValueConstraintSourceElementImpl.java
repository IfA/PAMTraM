/**
 */
package pamtram.structure.constraint.impl;

import org.eclipse.emf.ecore.EClass;
import pamtram.structure.constraint.ConstraintPackage;
import pamtram.structure.constraint.ValueConstraintSourceElement;
import pamtram.structure.impl.LocalDynamicSourceElementImpl;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Value Constraint Source Element</b></em>'. <!--
 * end-user-doc -->
 *
 * @generated
 */
public class ValueConstraintSourceElementImpl extends
		LocalDynamicSourceElementImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>
		implements ValueConstraintSourceElement {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ValueConstraintSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConstraintPackage.Literals.VALUE_CONSTRAINT_SOURCE_ELEMENT;
	}

} // AttributeValueConstraintSourceElementImpl
