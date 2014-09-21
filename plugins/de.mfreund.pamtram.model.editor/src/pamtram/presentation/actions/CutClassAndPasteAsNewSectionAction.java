package pamtram.presentation.actions;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;

import pamtram.PamtramPackage;
import pamtram.SourceSectionModel;
import pamtram.TargetSectionModel;
import pamtram.metamodel.Class;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.SourceSectionContainmentReference;
import pamtram.metamodel.TargetSectionContainmentReference;

public class CutClassAndPasteAsNewSectionAction extends Action {
	
	Class oldElement;


	public CutClassAndPasteAsNewSectionAction(Class m) {
		super("cut and paste as new section");
		oldElement=m;
	}

	@Override
	public void run() {
		
		if(!oldElement.getContainingSection().equals(oldElement)){
			List<EObject> objectsOldContainer=new LinkedList<EObject>();
			List<EObject> objectsNewContainer=new LinkedList<EObject>();

			if(oldElement.getContainingSection().eContainer() instanceof TargetSectionModel){
				TargetSectionModel model=(TargetSectionModel) oldElement.getContainingSection().eContainer();
				TargetSectionContainmentReference ref=(TargetSectionContainmentReference) oldElement.eContainer();
				objectsOldContainer.addAll(ref.getValue());
				objectsOldContainer.remove(oldElement);
				
				ref.eSet(ref.eClass().getEStructuralFeature(MetamodelPackage.TARGET_SECTION_CONTAINMENT_REFERENCE__VALUE), objectsOldContainer);
				
				objectsNewContainer.addAll(model.getMetaModelSections());
				objectsNewContainer.add(oldElement);
				model.eSet(model.eClass().getEStructuralFeature(PamtramPackage.TARGET_SECTION_MODEL__META_MODEL_SECTIONS), objectsNewContainer);
			
			} else if(oldElement.getContainingSection().eContainer() instanceof SourceSectionModel){
				SourceSectionModel model=(SourceSectionModel) oldElement.getContainingSection().eContainer();
				SourceSectionContainmentReference ref=(SourceSectionContainmentReference) oldElement.eContainer();
				objectsOldContainer.addAll(ref.getValue());
				objectsOldContainer.remove(oldElement);
				
				ref.eSet(ref.eClass().getEStructuralFeature(MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE__VALUE), objectsOldContainer);
				
				objectsNewContainer.addAll(model.getMetaModelSections());
				objectsNewContainer.add(oldElement);
				model.eSet(model.eClass().getEStructuralFeature(PamtramPackage.SOURCE_SECTION_MODEL__META_MODEL_SECTIONS), objectsNewContainer);				
			}
		}
	
	}
	

}
