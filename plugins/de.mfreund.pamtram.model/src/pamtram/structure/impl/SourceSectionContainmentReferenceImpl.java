/**
 */
package pamtram.structure.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

import pamtram.structure.StructurePackage;
import pamtram.structure.generic.impl.ContainmentReferenceImpl;
import pamtram.structure.SourceSection;
import pamtram.structure.SourceSectionAttribute;
import pamtram.structure.SourceSectionClass;
import pamtram.structure.SourceSectionContainmentReference;
import pamtram.structure.SourceSectionReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Source Section Containment Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class SourceSectionContainmentReferenceImpl extends
		ContainmentReferenceImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>
		implements SourceSectionContainmentReference {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceSectionContainmentReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructurePackage.Literals.SOURCE_SECTION_CONTAINMENT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> This is specialized for the more specific element type known in
	 * this context.
	 *
	 * @generated
	 */
	@Override
	public EList<SourceSectionClass> getValue() {
		if (value == null) {
			value = new EObjectContainmentEList<SourceSectionClass>(SourceSectionClass.class, this, StructurePackage.SOURCE_SECTION_CONTAINMENT_REFERENCE__VALUE);
		}
		return value;
	}

	@Override
	public void addValuesGeneric(EList<SourceSectionClass> values) {

		this.getValue().addAll(values);

	}

	@Override
	public EList<SourceSectionClass> getValuesGeneric() {

		return this.getValue();
	}

} // SourceSectionContainmentReferenceImpl
