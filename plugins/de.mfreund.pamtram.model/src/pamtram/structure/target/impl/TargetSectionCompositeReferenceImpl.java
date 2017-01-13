/**
 */
package pamtram.structure.target.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

import pamtram.structure.StructurePackage;
import pamtram.structure.generic.impl.CompositeReferenceImpl;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionCompositeReference;
import pamtram.structure.target.TargetSectionReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Target Section Containment Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class TargetSectionCompositeReferenceImpl extends
		CompositeReferenceImpl<TargetSection, TargetSectionClass, TargetSectionReference, TargetSectionAttribute>
		implements TargetSectionCompositeReference {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TargetSectionCompositeReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return StructurePackage.Literals.TARGET_SECTION_COMPOSITE_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> This is specialized for the more specific element type known in
	 * this context.
	 *
	 * @generated
	 */
	@Override
	public EList<TargetSectionClass> getValue() {

		if (this.value == null) {
			this.value = new EObjectContainmentEList<>(TargetSectionClass.class, this,
					StructurePackage.TARGET_SECTION_COMPOSITE_REFERENCE__VALUE);
		}
		return this.value;
	}

	@Override
	public void addValuesGeneric(EList<TargetSectionClass> values) {

		this.getValue().addAll(values);

	}

	@Override
	public EList<TargetSectionClass> getValuesGeneric() {

		return this.getValue();
	}

} // TargetSectionCompositeReferenceImpl
