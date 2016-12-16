/**
 */
package pamtram.structure.impl;

import org.eclipse.emf.ecore.EClass;

import pamtram.structure.StructurePackage;
import pamtram.structure.generic.impl.ReferenceImpl;
import pamtram.structure.SourceSection;
import pamtram.structure.SourceSectionAttribute;
import pamtram.structure.SourceSectionClass;
import pamtram.structure.SourceSectionReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Source Section Reference</b></em>'. <!--
 * end-user-doc -->
 *
 * @generated
 */
public abstract class SourceSectionReferenceImpl
		extends ReferenceImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>
		implements SourceSectionReference {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceSectionReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructurePackage.Literals.SOURCE_SECTION_REFERENCE;
	}

} // SourceSectionReferenceImpl
