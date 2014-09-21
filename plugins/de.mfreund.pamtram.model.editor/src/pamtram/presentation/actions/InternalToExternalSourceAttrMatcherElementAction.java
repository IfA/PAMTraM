package pamtram.presentation.actions;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.action.Action;

import pamtram.mapping.ComplexAttributeMatcher;
import pamtram.mapping.ComplexAttributeMatcherExternalSourceElement;
import pamtram.mapping.ComplexAttributeMatcherSourceElement;
import pamtram.mapping.MappingPackage;

public class InternalToExternalSourceAttrMatcherElementAction extends Action {
	
	ComplexAttributeMatcherSourceElement oldElement;


	public InternalToExternalSourceAttrMatcherElementAction(ComplexAttributeMatcherSourceElement descriptor) {
		super("convert to external source element");
		oldElement=descriptor;
	}

	@Override
	public void run() {
		EPackage ePackage = oldElement.eClass().getEPackage();
		ComplexAttributeMatcherExternalSourceElement m=(ComplexAttributeMatcherExternalSourceElement) ePackage.getEFactoryInstance().create((EClass) ePackage.getEClassifier("ComplexAttributeMatcherExternalSourceElement"));
		
		if(oldElement.getName() != null){
			m.setName(oldElement.getName());
		}
		
		if(oldElement.getSource() != null){
			m.setSource(oldElement.getSource());
		}
		
		
		if(oldElement.getModifier() != null){
			m.eSet(m.eClass().getEStructuralFeature(MappingPackage.COMPLEX_ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT__MODIFIER), oldElement.getModifier());
		}
		
		EObject group=oldElement.eContainer();
		
		List<EObject> objects=new LinkedList<EObject>();
		if(group instanceof ComplexAttributeMatcher){
			objects.addAll(((ComplexAttributeMatcher) group).getSourceAttributes());
			int index=objects.indexOf(oldElement);
			objects.remove(oldElement);
			objects.add(index, m);
			group.eSet(group.eClass().getEStructuralFeature(MappingPackage.COMPLEX_ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTES),objects);
		}
	
	}
	

}
