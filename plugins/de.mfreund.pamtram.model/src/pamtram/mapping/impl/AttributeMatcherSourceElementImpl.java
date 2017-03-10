/**
 */
package pamtram.mapping.impl;

import org.eclipse.emf.ecore.EClass;

import pamtram.mapping.AttributeMatcherSourceElement;
import pamtram.mapping.MappingPackage;
import pamtram.structure.impl.LocalModifiedAttributeElementTypeImpl;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Attribute Matcher Source Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class AttributeMatcherSourceElementImpl extends
		LocalModifiedAttributeElementTypeImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>
		implements AttributeMatcherSourceElement {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AttributeMatcherSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return MappingPackage.Literals.ATTRIBUTE_MATCHER_SOURCE_ELEMENT;
	}

} // AttributeMatcherSourceElementImpl
