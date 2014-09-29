package pamtram.converter;

import java.util.LinkedList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import pamtram.mapping.ComplexAttributeMapping;
import pamtram.mapping.ComplexAttributeMappingExternalSourceElement;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.SimpleAttributeMapping;
import pamtram.mapping.commands.GenericConvertCommand.IConverter;

public class SimpleToExternalComplexAttributeMappingConverter implements
		IConverter<SimpleAttributeMapping, ComplexAttributeMapping> {
	@Override
	public ComplexAttributeMapping convert(
			SimpleAttributeMapping source) {
		
		EPackage ePackage = source.eClass().getEPackage();
		ComplexAttributeMapping target = 
				(ComplexAttributeMapping) ePackage.getEFactoryInstance().create((EClass) ePackage.getEClassifier("ComplexAttributeMapping"));
		
		if(source.getName() != null){
			target.setName(source.getName());
		}
		
		if(source.getTarget() != null){
			target.setTarget(source.getTarget());
		}
		
		ComplexAttributeMappingExternalSourceElement sourceElement = 
				(ComplexAttributeMappingExternalSourceElement) ePackage.getEFactoryInstance().create((EClass) ePackage.getEClassifier("ComplexAttributeMappingExternalSourceElement"));
	
		LinkedList<EObject> childEObjects = new LinkedList<EObject>();
		childEObjects.add(sourceElement);
		target.eSet(sourceElement.eClass().getEStructuralFeature(MappingPackage.COMPLEX_ATTRIBUTE_MAPPING__SOURCE_ATTRIBUTE_MAPPINGS), childEObjects);
		
		if(source.getSource() != null){
			sourceElement.setSource(source.getSource());
			if(source.getSource().getName() != null){
				sourceElement.setName(source.getSource().getName());
			}
		}
		
		if(source.getModifier() != null){
			sourceElement.eSet(sourceElement.eClass().getEStructuralFeature(MappingPackage.COMPLEX_ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT__MODIFIER), source.getModifier());
		}
		
		return target;
	}
}