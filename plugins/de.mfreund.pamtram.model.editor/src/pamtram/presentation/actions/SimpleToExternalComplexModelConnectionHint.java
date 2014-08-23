package pamtram.presentation.actions;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.action.Action;

import pamtram.mapping.ComplexModelConnectionHint;
import pamtram.mapping.ComplexModelConnectionHintExternalSourceElement;
import pamtram.mapping.ConnectionHintTargetAttribute;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.SimpleModelConnectionHint;

public class SimpleToExternalComplexModelConnectionHint extends Action {

	SimpleModelConnectionHint oldHint;


	public SimpleToExternalComplexModelConnectionHint(SimpleModelConnectionHint h) {
		super("convert to ComplexModelConnectionHint (external source)");
		oldHint=h;
	}

	@Override
	public void run() {
		EPackage ePackage = oldHint.eClass().getEPackage();
		ComplexModelConnectionHint m=(ComplexModelConnectionHint) ePackage.getEFactoryInstance().create((EClass) ePackage.getEClassifier("ComplexModelConnectionHint"));
		
		if(oldHint.getName() != null){
			m.setName(oldHint.getName());
		}
		
		ComplexModelConnectionHintExternalSourceElement source= (ComplexModelConnectionHintExternalSourceElement) ePackage.getEFactoryInstance().create((EClass) ePackage.getEClassifier("ComplexModelConnectionHintExternalSourceElement"));
	
		/*
		 * Set source
		 */
		LinkedList<EObject> childEObjects = new LinkedList<EObject>();
		childEObjects.add(source);
		m.eSet(m.eClass().getEStructuralFeature(MappingPackage.COMPLEX_MODEL_CONNECTION_HINT__SOURCE_ELEMENTS), childEObjects);
		
		
		if(oldHint.getSource() != null){
			source.setSource(oldHint.getSource());
			if(oldHint.getSource().getName() != null){
				source.setName(oldHint.getSource().getName());
			}
		}
		
		if(oldHint.getModifier() != null){
			source.eSet(source.eClass().getEStructuralFeature(MappingPackage.COMPLEX_MODEL_CONNECTION_HINT_EXTERNAL_SOURCE_ELEMENT__MODIFIER), oldHint.getModifier());
		}
		
		/*
		 * Set targets
		 */
		List<ConnectionHintTargetAttribute>  targets= new LinkedList<ConnectionHintTargetAttribute>();
		if(oldHint.getTargetAttributes() != null){
			targets.addAll(oldHint.getTargetAttributes());
		}
		m.eSet(m.eClass().getEStructuralFeature(MappingPackage.COMPLEX_MODEL_CONNECTION_HINT__TARGET_ATTRIBUTES), targets);
		
		/*
		 * Connect to model
		 */
		
		EObject group=oldHint.eContainer();
		
		if(group instanceof MappingHintGroup){
			((MappingHintGroup) group).setModelConnectionMatcher(m);
		}
	
	}

}
