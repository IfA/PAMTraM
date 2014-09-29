package pamtram.converter;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import pamtram.mapping.ComplexAttributeMappingExternalSourceElement;
import pamtram.mapping.ComplexAttributeMappingSourceElement;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.commands.GenericConvertCommand.IConverter;

public class SimpleToExternalComplexAttributeMatcherConverter
		implements
		IConverter<ComplexAttributeMappingSourceElement, ComplexAttributeMappingExternalSourceElement> {
	@Override
	public ComplexAttributeMappingExternalSourceElement convert(
			ComplexAttributeMappingSourceElement source) {
		
		EPackage ePackage = source.eClass().getEPackage();
		ComplexAttributeMappingExternalSourceElement target =
				(ComplexAttributeMappingExternalSourceElement) ePackage.getEFactoryInstance().create((EClass) ePackage.getEClassifier("ComplexAttributeMappingExternalSourceElement"));
		
		if(source.getName() != null){
			target.setName(source.getName());
		}
		
		if(source.getSource() != null){
			target.setSource(source.getSource());
		}
		
		
		if(source.getModifier() != null){
			target.eSet(target.eClass().getEStructuralFeature(MappingPackage.COMPLEX_ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT__MODIFIER), source.getModifier());
		}
				
		
		return target;
	}
}