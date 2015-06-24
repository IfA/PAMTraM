/**
 */
package pamtram.metamodel.impl;

import java.lang.Class;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.Reference;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target Section Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class TargetSectionClassImpl extends ClassImpl<TargetSectionClass, TargetSectionReference, TargetSectionAttribute> implements TargetSectionClass {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetSectionClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.TARGET_SECTION_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific element type known in this context.
	 * @generated
	 */
	@Override
	public EList<TargetSectionReference> getReferences() {
		if (references == null) {
			references = new EObjectContainmentWithInverseEList<TargetSectionReference>(TargetSectionReference.class, this, MetamodelPackage.TARGET_SECTION_CLASS__REFERENCES, MetamodelPackage.REFERENCE__OWNING_CLASS) { private static final long serialVersionUID = 1L; @Override public Class<?> getInverseFeatureClass() { return Reference.class; } };
		}
		return references;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific type known in this context.
	 * @generated
	 */
	@Override
	public void setContainer(TargetSectionClass newContainer) {
		super.setContainer(newContainer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific element type known in this context.
	 * @generated
	 */
	@Override
	public EList<TargetSectionAttribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentWithInverseEList<TargetSectionAttribute>(TargetSectionAttribute.class, this, MetamodelPackage.TARGET_SECTION_CLASS__ATTRIBUTES, MetamodelPackage.ATTRIBUTE__OWNING_CLASS) { private static final long serialVersionUID = 1L; @Override public Class<?> getInverseFeatureClass() { return Attribute.class; } };
		}
		return attributes;
	}

} //TargetSectionClassImpl