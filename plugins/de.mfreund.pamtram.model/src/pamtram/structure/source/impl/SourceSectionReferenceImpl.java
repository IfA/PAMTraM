/**
 */
package pamtram.structure.source.impl;

import org.eclipse.emf.ecore.EClass;
import pamtram.structure.generic.impl.ReferenceImpl;
import pamtram.structure.source.SourcePackage;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

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
		return SourcePackage.Literals.SOURCE_SECTION_REFERENCE;
	}

} // SourceSectionReferenceImpl
