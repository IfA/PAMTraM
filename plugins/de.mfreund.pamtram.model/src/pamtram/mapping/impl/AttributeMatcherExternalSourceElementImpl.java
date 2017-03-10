/**
 */
package pamtram.mapping.impl;

import org.eclipse.emf.ecore.EClass;

import pamtram.mapping.AttributeMatcherExternalSourceElement;
import pamtram.mapping.MappingPackage;
import pamtram.structure.impl.ExternalModifiedAttributeElementTypeImpl;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Attribute Matcher External Source
 * Element</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public class AttributeMatcherExternalSourceElementImpl extends
		ExternalModifiedAttributeElementTypeImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>
		implements AttributeMatcherExternalSourceElement {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AttributeMatcherExternalSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return MappingPackage.Literals.ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT;
	}

} // AttributeMatcherExternalSourceElementImpl
