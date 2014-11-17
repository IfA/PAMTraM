package pamtram.converter;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import pamtram.mapping.AttributeMatcherSourceElement;
import pamtram.mapping.ComplexAttributeMatcherExternalSourceElement;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.commands.GenericConvertCommand.IConverter;

public class InternalToExternalSourceAttrMatcherElementConverter
		implements
		IConverter<AttributeMatcherSourceElement, ComplexAttributeMatcherExternalSourceElement> {
	@Override
	public ComplexAttributeMatcherExternalSourceElement convert(
			AttributeMatcherSourceElement source) {
		
		EPackage ePackage = source.eClass().getEPackage();
		ComplexAttributeMatcherExternalSourceElement target =
				(ComplexAttributeMatcherExternalSourceElement) ePackage.getEFactoryInstance().create((EClass) ePackage.getEClassifier("ComplexAttributeMatcherExternalSourceElement"));
		
		if(source.getName() != null){
			target.setName(source.getName());
		}
		
		if(source.getSource() != null){
			target.setSource(source.getSource());
		}
		
		
		if(source.getModifier() != null){
			target.eSet(target.eClass().getEStructuralFeature(MappingPackage.COMPLEX_ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT__MODIFIER), source.getModifier());
		}
		
		return target;
	}
}