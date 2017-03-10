/**
 */
package pamtram.mapping.impl;

import org.eclipse.emf.ecore.EClass;

import pamtram.mapping.AttributeMatcherGlobalSourceElement;
import pamtram.mapping.MappingPackage;
import pamtram.structure.impl.GlobalModifiedAttributeElementTypeImpl;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Attribute Matcher Global Source
 * Element</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public class AttributeMatcherGlobalSourceElementImpl extends
		GlobalModifiedAttributeElementTypeImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>
		implements AttributeMatcherGlobalSourceElement {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AttributeMatcherGlobalSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return MappingPackage.Literals.ATTRIBUTE_MATCHER_GLOBAL_SOURCE_ELEMENT;
	}

} // AttributeMatcherGlobalSourceElementImpl
