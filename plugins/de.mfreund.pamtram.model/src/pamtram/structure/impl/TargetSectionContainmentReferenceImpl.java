/**
 */
package pamtram.structure.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

import pamtram.structure.StructurePackage;
import pamtram.structure.TargetSection;
import pamtram.structure.TargetSectionAttribute;
import pamtram.structure.TargetSectionClass;
import pamtram.structure.TargetSectionContainmentReference;
import pamtram.structure.TargetSectionReference;
import pamtram.structure.generic.impl.ContainmentReferenceImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Target Section Containment Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class TargetSectionContainmentReferenceImpl extends
		ContainmentReferenceImpl<TargetSection, TargetSectionClass, TargetSectionReference, TargetSectionAttribute>
		implements TargetSectionContainmentReference {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetSectionContainmentReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructurePackage.Literals.TARGET_SECTION_CONTAINMENT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> This is specialized for the more specific element type known in
	 * this context.
	 *
	 * @generated
	 */
	@Override
	public EList<TargetSectionClass> getValue() {
		if (value == null) {
			value = new EObjectContainmentEList<TargetSectionClass>(TargetSectionClass.class, this, StructurePackage.TARGET_SECTION_CONTAINMENT_REFERENCE__VALUE);
		}
		return value;
	}

	@Override
	public void addValuesGeneric(EList<TargetSectionClass> values) {

		this.getValue().addAll(values);

	}

	@Override
	public EList<TargetSectionClass> getValuesGeneric() {

		return this.getValue();
	}

} // TargetSectionContainmentReferenceImpl
