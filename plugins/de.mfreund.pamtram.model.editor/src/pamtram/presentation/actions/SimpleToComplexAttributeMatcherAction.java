package pamtram.presentation.actions;

import java.util.LinkedList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.action.Action;

import pamtram.mapping.ComplexAttributeMatcher;
import pamtram.mapping.ComplexAttributeMatcherSourceElement;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.SimpleAttributeMatcher;

public class SimpleToComplexAttributeMatcherAction extends Action{

	SimpleAttributeMatcher oldMatcher;


	public SimpleToComplexAttributeMatcherAction(SimpleAttributeMatcher m) {
		super("convert to ComplexAttributeMatcher");
		oldMatcher=m;
	}

	@Override
	public void run() {
		EPackage ePackage = oldMatcher.eClass().getEPackage();
		ComplexAttributeMatcher m=(ComplexAttributeMatcher) ePackage.getEFactoryInstance().create((EClass) ePackage.getEClassifier("ComplexAttributeMatcher"));
		
		if(oldMatcher.getTargetAttribute() != null){
			m.setTargetAttribute(oldMatcher.getTargetAttribute());
		}
		
		ComplexAttributeMatcherSourceElement source= (ComplexAttributeMatcherSourceElement) ePackage.getEFactoryInstance().create((EClass) ePackage.getEClassifier("ComplexAttributeMatcherSourceElement"));		
		
		LinkedList<EObject> childEObjects = new LinkedList<EObject>();
		childEObjects.add(source);
		m.eSet(source.eClass().getEStructuralFeature(MappingPackage.COMPLEX_ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTES), childEObjects);
		
		if(oldMatcher.getSource() != null){
			source.setSource(oldMatcher.getSource());
			if(oldMatcher.getSource().getName() != null){
				source.setName(oldMatcher.getSource().getName());
			}
		}
		
		if(oldMatcher.getModifier() != null){
			source.eSet(source.eClass().getEStructuralFeature(MappingPackage.COMPLEX_ATTRIBUTE_MATCHER_SOURCE_ELEMENT__MODIFIER), oldMatcher.getModifier());
		}
		
		MappingInstanceSelector selector=(MappingInstanceSelector)oldMatcher.eContainer();
		selector.setMatcher(m);
	
	}

}
