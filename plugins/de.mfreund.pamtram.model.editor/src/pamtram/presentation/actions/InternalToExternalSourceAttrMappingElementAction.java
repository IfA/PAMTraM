package pamtram.presentation.actions;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.action.Action;

import pamtram.mapping.ComplexAttributeMapping;
import pamtram.mapping.ComplexAttributeMappingExternalSourceElement;
import pamtram.mapping.ComplexAttributeMappingSourceElement;
import pamtram.mapping.MappingPackage;

public class InternalToExternalSourceAttrMappingElementAction extends Action {
	
	ComplexAttributeMappingSourceElement oldElement;


	public InternalToExternalSourceAttrMappingElementAction(ComplexAttributeMappingSourceElement m) {
		super("convert to external source element");
		oldElement=m;
	}

	@Override
	public void run() {
		EPackage ePackage = oldElement.eClass().getEPackage();
		ComplexAttributeMappingExternalSourceElement m=(ComplexAttributeMappingExternalSourceElement) ePackage.getEFactoryInstance().create((EClass) ePackage.getEClassifier("ComplexAttributeMappingExternalSourceElement"));
		
		if(oldElement.getName() != null){
			m.setName(oldElement.getName());
		}
		
		if(oldElement.getSource() != null){
			m.setSource(oldElement.getSource());
		}
		
		
		if(oldElement.getModifier() != null){
			m.eSet(m.eClass().getEStructuralFeature(MappingPackage.COMPLEX_ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT__MODIFIER), oldElement.getModifier());
		}
		
		EObject group=oldElement.eContainer();
		
		List<EObject> objects=new LinkedList<EObject>();
		if(group instanceof ComplexAttributeMapping){
			objects.addAll(((ComplexAttributeMapping) group).getSourceAttributeMappings());
			int index=objects.indexOf(oldElement);
			objects.remove(oldElement);
			objects.add(index, m);
			group.eSet(group.eClass().getEStructuralFeature(MappingPackage.COMPLEX_ATTRIBUTE_MAPPING__SOURCE_ATTRIBUTE_MAPPINGS),objects);
		}
	
	}
	

}
