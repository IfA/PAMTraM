/**
 */
package pamtram.structure.impl;

import org.eclipse.emf.ecore.EClass;

import pamtram.structure.StructurePackage;
import pamtram.structure.TargetSection;
import pamtram.structure.TargetSectionAttribute;
import pamtram.structure.TargetSectionClass;
import pamtram.structure.TargetSectionReference;
import pamtram.structure.generic.impl.ReferenceImpl;

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
		return StructurePackage.Literals.TARGET_SECTION_REFERENCE;
	}

} //TargetSectionReferenceImpl
