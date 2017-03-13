/**
 */
package pamtram.structure.constraint.impl;

import org.eclipse.emf.ecore.EClass;
import pamtram.structure.constraint.ConstraintPackage;
import pamtram.structure.constraint.ValueConstraintExternalSourceElement;
import pamtram.structure.impl.ExternalDynamicSourceElementImpl;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Value Constraint External Source
 * Element</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public class ValueConstraintExternalSourceElementImpl extends
		ExternalDynamicSourceElementImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>
		implements ValueConstraintExternalSourceElement {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ValueConstraintExternalSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConstraintPackage.Literals.VALUE_CONSTRAINT_EXTERNAL_SOURCE_ELEMENT;
	}

} // AttributeValueConstraintExternalSourceElementImpl
