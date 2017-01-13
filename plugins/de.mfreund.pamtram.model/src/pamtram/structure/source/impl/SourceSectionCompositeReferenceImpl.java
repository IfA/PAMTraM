/**
 */
package pamtram.structure.source.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import pamtram.structure.generic.impl.CompositeReferenceImpl;
import pamtram.structure.source.SourcePackage;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionCompositeReference;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Source Section Containment Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class SourceSectionCompositeReferenceImpl extends
		CompositeReferenceImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>
		implements SourceSectionCompositeReference {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceSectionCompositeReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SourcePackage.Literals.SOURCE_SECTION_COMPOSITE_REFERENCE;
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
			value = new EObjectContainmentEList<SourceSectionClass>(SourceSectionClass.class, this, SourcePackage.SOURCE_SECTION_COMPOSITE_REFERENCE__VALUE);
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

} // SourceSectionCompositeReferenceImpl
