package pamtram.converter;

import java.util.LinkedList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import pamtram.mapping.ComplexAttributeMatcher;
import pamtram.mapping.ComplexAttributeMatcherSourceElement;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.SimpleAttributeMatcher;
import pamtram.mapping.commands.GenericConvertCommand.IConverter;

public class SimpleToComplexAttributeMatcherConverter implements
		IConverter<SimpleAttributeMatcher, ComplexAttributeMatcher> {
	@Override
	public ComplexAttributeMatcher convert(
			SimpleAttributeMatcher source) {

		EPackage ePackage = source.eClass().getEPackage();
		ComplexAttributeMatcher target =
				(ComplexAttributeMatcher) ePackage.getEFactoryInstance().create((EClass) ePackage.getEClassifier("ComplexAttributeMatcher"));
		
		if(source.getTargetAttribute() != null){
			target.setTargetAttribute(source.getTargetAttribute());
		}
		
		ComplexAttributeMatcherSourceElement sourceElement = 
				(ComplexAttributeMatcherSourceElement) ePackage.getEFactoryInstance().create((EClass) ePackage.getEClassifier("ComplexAttributeMatcherSourceElement"));		
		
		LinkedList<EObject> childEObjects = new LinkedList<EObject>();
		childEObjects.add(sourceElement);
		target.eSet(sourceElement.eClass().getEStructuralFeature(MappingPackage.COMPLEX_ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTES), childEObjects);
		
		if(source.getSource() != null){
			sourceElement.setSource(source.getSource());
			if(source.getSource().getName() != null){
				sourceElement.setName(source.getSource().getName());
			}
		}
		
		if(source.getModifier() != null){
			sourceElement.eSet(sourceElement.eClass().getEStructuralFeature(MappingPackage.COMPLEX_ATTRIBUTE_MATCHER_SOURCE_ELEMENT__MODIFIER), source.getModifier());
		}
		
		return target;
	}
}