/**
 */
package pamtram.structure.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import pamtram.structure.StructurePackage;
import pamtram.structure.TargetSection;
import pamtram.structure.TargetSectionAttribute;
import pamtram.structure.TargetSectionClass;
import pamtram.structure.TargetSectionNonContainmentReference;
import pamtram.structure.TargetSectionReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Target Section Non Containment
 * Reference</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public class TargetSectionNonContainmentReferenceImpl extends
		NonContainmentReferenceImpl<TargetSection, TargetSectionClass, TargetSectionReference, TargetSectionAttribute>
		implements TargetSectionNonContainmentReference {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetSectionNonContainmentReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructurePackage.Literals.TARGET_SECTION_NON_CONTAINMENT_REFERENCE;
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
			value = new EObjectResolvingEList<TargetSectionClass>(TargetSectionClass.class, this, StructurePackage.TARGET_SECTION_NON_CONTAINMENT_REFERENCE__VALUE);
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

} // TargetSectionNonContainmentReferenceImpl
