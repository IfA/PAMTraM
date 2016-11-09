package pamtram.converter;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import pamtram.commands.GenericConvertCommand.IConverter;
import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingPackage;

public class HintGroupToExportedHintGroupConverter implements
		IConverter<MappingHintGroup, ExportedMappingHintGroup> {

	@Override
	public ExportedMappingHintGroup convert(MappingHintGroup source) {
		
		EPackage ePackage = source.eClass().getEPackage();
		ExportedMappingHintGroup target =
				(ExportedMappingHintGroup) ePackage.getEFactoryInstance().create((EClass) ePackage.getEClassifier("ExportedMappingHintGroup"));
		
		if(source.getName() != null){
			target.setName(source.getName());
		}
		
		if(source.getTargetSection() != null){
			target.setTargetSection(source.getTargetSection());
		}
		
		
		if(source.getMappingHints() != null){
			target.eSet(target.eClass().getEStructuralFeature(MappingPackage.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS), EcoreUtil.copyAll(source.getMappingHints()));
		}
		
		return target;
	}

}
