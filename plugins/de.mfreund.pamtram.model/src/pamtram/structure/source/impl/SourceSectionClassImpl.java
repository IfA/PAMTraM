/**
 */
package pamtram.structure.source.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;

import pamtram.structure.StructurePackage;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.impl.ClassImpl;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Source Section Class</b></em>'. <!--
 * end-user-doc -->
 *
 * @generated
 */
public class SourceSectionClassImpl
		extends ClassImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>
		implements SourceSectionClass {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SourceSectionClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return StructurePackage.Literals.SOURCE_SECTION_CLASS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> This is specialized for the more specific element type known in
	 * this context.
	 * 
	 * @generated
	 */
	@Override
	public EList<SourceSectionReference> getReferences() {

		if (this.references == null) {
			this.references = new EObjectContainmentWithInverseEList<SourceSectionReference>(
					SourceSectionReference.class, this, StructurePackage.SOURCE_SECTION_CLASS__REFERENCES,
					GenericPackage.REFERENCE__OWNING_CLASS) {

				private static final long serialVersionUID = 1L;

				@Override
				public Class<?> getInverseFeatureClass() {

					return Reference.class;
				}
			};
		}
		return this.references;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> This is specialized for the more specific type known in this
	 * context.
	 * 
	 * @generated
	 */
	@Override
	public void setContainer(SourceSectionClass newContainer) {

		super.setContainer(newContainer);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> This is specialized for the more specific element type known in
	 * this context.
	 * 
	 * @generated
	 */
	@Override
	public EList<SourceSectionAttribute> getAttributes() {

		if (this.attributes == null) {
			this.attributes = new EObjectContainmentWithInverseEList<SourceSectionAttribute>(
					SourceSectionAttribute.class, this, StructurePackage.SOURCE_SECTION_CLASS__ATTRIBUTES,
					GenericPackage.ATTRIBUTE__OWNING_CLASS) {

				private static final long serialVersionUID = 1L;

				@Override
				public Class<?> getInverseFeatureClass() {

					return Attribute.class;
				}
			};
		}
		return this.attributes;
	}

} // SourceSectionClassImpl
