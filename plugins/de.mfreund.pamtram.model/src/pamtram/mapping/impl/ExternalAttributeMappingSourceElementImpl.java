/**
 */
package pamtram.mapping.impl;

import org.eclipse.emf.ecore.EClass;
import pamtram.mapping.ExternalAttributeMappingSourceElement;
import pamtram.mapping.MappingPackage;
import pamtram.metamodel.SourceSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Attribute Mapping Source Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class ExternalAttributeMappingSourceElementImpl extends ModifiedAttributeElementTypeImpl<SourceSectionAttribute> implements ExternalAttributeMappingSourceElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalAttributeMappingSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific type known in this context.
	 * @generated
	 */
	@Override
	public void setSource(SourceSectionAttribute newSource) {
		super.setSource(newSource);
	}

} //ExternalAttributeMappingSourceElementImpl
