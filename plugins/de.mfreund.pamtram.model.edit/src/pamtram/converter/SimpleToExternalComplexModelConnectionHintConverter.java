package pamtram.converter;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import pamtram.mapping.ComplexModelConnectionHint;
import pamtram.mapping.ComplexModelConnectionHintExternalSourceElement;
import pamtram.mapping.ConnectionHintTargetAttribute;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.SimpleModelConnectionHint;
import pamtram.mapping.commands.GenericConvertCommand.IConverter;

public class SimpleToExternalComplexModelConnectionHintConverter implements
		IConverter<SimpleModelConnectionHint, ComplexModelConnectionHint> {
	@Override
	public ComplexModelConnectionHint convert(
			SimpleModelConnectionHint source) {
		
		EPackage ePackage = source.eClass().getEPackage();
		ComplexModelConnectionHint target =
				(ComplexModelConnectionHint) ePackage.getEFactoryInstance().create((EClass) ePackage.getEClassifier("ComplexModelConnectionHint"));
		
		if(source.getName() != null){
			target.setName(source.getName());
		}
		
		ComplexModelConnectionHintExternalSourceElement sourceElement= (ComplexModelConnectionHintExternalSourceElement) ePackage.getEFactoryInstance().create((EClass) ePackage.getEClassifier("ComplexModelConnectionHintExternalSourceElement"));
	
		/*
		 * Set source
		 */
		LinkedList<EObject> childEObjects = new LinkedList<EObject>();
		childEObjects.add(sourceElement);
		target.eSet(target.eClass().getEStructuralFeature(MappingPackage.COMPLEX_MODEL_CONNECTION_HINT__SOURCE_ELEMENTS), childEObjects);
		
		
		if(source.getSource() != null){
			sourceElement.setSource(source.getSource());
			if(source.getSource().getName() != null){
				sourceElement.setName(source.getSource().getName());
			}
		}
		
		if(source.getModifier() != null){
			sourceElement.eSet(sourceElement.eClass().getEStructuralFeature(MappingPackage.COMPLEX_MODEL_CONNECTION_HINT_EXTERNAL_SOURCE_ELEMENT__MODIFIER), source.getModifier());
		}
		
		/*
		 * Set targets
		 */
		List<ConnectionHintTargetAttribute>  targets= new LinkedList<ConnectionHintTargetAttribute>();
		if(source.getTargetAttributes() != null){
			targets.addAll(source.getTargetAttributes());
		}
		target.eSet(target.eClass().getEStructuralFeature(MappingPackage.COMPLEX_MODEL_CONNECTION_HINT__TARGET_ATTRIBUTES), targets);
		
		
		return target;
	}
}