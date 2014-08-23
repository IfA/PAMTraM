package pamtram.presentation.actions;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.action.Action;

import pamtram.mapping.ComplexAttributeMapping;
import pamtram.mapping.ComplexAttributeMappingSourceElement;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.SimpleAttributeMapping;

public class SimpleToComplexAttributeMappingAction extends Action {
	
	SimpleAttributeMapping oldMapping;


	public SimpleToComplexAttributeMappingAction(SimpleAttributeMapping m) {
		super("convert to ComplexAttributeMapping");
		oldMapping=m;
	}

	@Override
	public void run() {
		EPackage ePackage = oldMapping.eClass().getEPackage();
		ComplexAttributeMapping m=(ComplexAttributeMapping) ePackage.getEFactoryInstance().create((EClass) ePackage.getEClassifier("ComplexAttributeMapping"));
		
		if(oldMapping.getName() != null){
			m.setName(oldMapping.getName());
		}
		
		if(oldMapping.getTarget() != null){
			m.setTarget(oldMapping.getTarget());
		}
		
		ComplexAttributeMappingSourceElement source= (ComplexAttributeMappingSourceElement) ePackage.getEFactoryInstance().create((EClass) ePackage.getEClassifier("ComplexAttributeMappingSourceElement"));
	
		LinkedList<EObject> childEObjects = new LinkedList<EObject>();
		childEObjects.add(source);
		m.eSet(source.eClass().getEStructuralFeature(MappingPackage.COMPLEX_ATTRIBUTE_MAPPING__SOURCE_ATTRIBUTE_MAPPINGS), childEObjects);
		
		if(oldMapping.getSource() != null){
			source.setSource(oldMapping.getSource());
			if(oldMapping.getSource().getName() != null){
				source.setName(oldMapping.getSource().getName());
			}
		}
		
		if(oldMapping.getModifier() != null){
			source.eSet(source.eClass().getEStructuralFeature(MappingPackage.COMPLEX_ATTRIBUTE_MAPPING_SOURCE_ELEMENT__MODIFIER), oldMapping.getModifier());
		}
		
		EObject group=oldMapping.eContainer();
		
		List<EObject> objects=new LinkedList<EObject>();
		if(group instanceof MappingHintGroupType){
			MappingHintGroupType groupNew=(MappingHintGroupType) group;
			objects.addAll(groupNew.getMappingHints());
			objects.remove(oldMapping);
			objects.add(m);
			groupNew.eSet(groupNew.eClass().getEStructuralFeature(MappingPackage.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS),objects);
		} else if(group instanceof MappingHintGroupImporter){
			MappingHintGroupImporter groupNew=(MappingHintGroupImporter) group;
			objects.addAll(groupNew.getMappingHints());
			objects.remove(oldMapping);
			objects.add(m);
			groupNew.eSet(groupNew.eClass().getEStructuralFeature(MappingPackage.MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS),objects);
		}
	
	}
	

}
