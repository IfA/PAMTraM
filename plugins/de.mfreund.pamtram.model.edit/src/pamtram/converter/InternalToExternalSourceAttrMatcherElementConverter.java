package pamtram.converter;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import pamtram.commands.GenericConvertCommand.IConverter;
import pamtram.mapping.AttributeMatcherExternalSourceElement;
import pamtram.mapping.AttributeMatcherSourceElement;
import pamtram.mapping.MappingPackage;

public class InternalToExternalSourceAttrMatcherElementConverter
		implements
		IConverter<AttributeMatcherSourceElement, AttributeMatcherExternalSourceElement> {
	@Override
	public AttributeMatcherExternalSourceElement convert(
			AttributeMatcherSourceElement source) {
		
		EPackage ePackage = source.eClass().getEPackage();
		AttributeMatcherExternalSourceElement target =
				(AttributeMatcherExternalSourceElement) ePackage.getEFactoryInstance().create((EClass) ePackage.getEClassifier("ComplexAttributeMatcherExternalSourceElement"));
		
		if(source.getName() != null){
			target.setName(source.getName());
		}
		
		if(source.getSource() != null){
			target.setSource(source.getSource());
		}
		
		
		if(source.getModifier() != null){
			target.eSet(target.eClass().getEStructuralFeature(MappingPackage.ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT__MODIFIER), source.getModifier());
		}
		
		return target;
	}
}