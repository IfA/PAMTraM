/**
 */
package pamtram.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import pamtram.PamtramPackage;
import pamtram.SourceSectionModel;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source Section Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class SourceSectionModelImpl extends SectionModelImpl<SourceSectionClass, SourceSectionReference, SourceSectionAttribute> implements SourceSectionModel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceSectionModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PamtramPackage.Literals.SOURCE_SECTION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific element type known in this context.
	 * @generated
	 */
	@Override
	public EList<SourceSectionClass> getMetaModelSections() {
		if (metaModelSections == null) {
			metaModelSections = new EObjectContainmentEList<SourceSectionClass>(SourceSectionClass.class, this, PamtramPackage.SOURCE_SECTION_MODEL__META_MODEL_SECTIONS);
		}
		return metaModelSections;
	}

} //SourceSectionModelImpl
