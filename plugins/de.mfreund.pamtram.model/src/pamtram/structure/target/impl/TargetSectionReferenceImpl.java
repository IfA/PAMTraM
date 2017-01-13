/**
 */
package pamtram.structure.target.impl;

import org.eclipse.emf.ecore.EClass;
import pamtram.structure.generic.impl.ReferenceImpl;
import pamtram.structure.target.TargetPackage;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target Section Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class TargetSectionReferenceImpl extends ReferenceImpl<TargetSection, TargetSectionClass, TargetSectionReference, TargetSectionAttribute> implements TargetSectionReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetSectionReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetPackage.Literals.TARGET_SECTION_REFERENCE;
	}

} //TargetSectionReferenceImpl
