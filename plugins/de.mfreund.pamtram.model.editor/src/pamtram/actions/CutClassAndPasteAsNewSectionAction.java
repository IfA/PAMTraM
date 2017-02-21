package pamtram.actions;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;

import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.SectionModel;
import pamtram.SourceSectionModel;
import pamtram.TargetSectionModel;
import pamtram.structure.generic.Class;
import pamtram.structure.generic.Section;
import pamtram.structure.source.SourcePackage;
import pamtram.structure.source.SourceSectionCompositeReference;
import pamtram.structure.target.TargetPackage;
import pamtram.structure.target.TargetSectionCompositeReference;

/**
 * An {@link Action} that allows to cut a {@link Class} from a modeled {@link Section}, convert it to a {@link Section}
 * itself, and then add it to a {@link SectionModel} of a {@link PAMTraM} model.
 *
 * @author mfreund
 */
public class CutClassAndPasteAsNewSectionAction extends Action {

	/**
	 * The {@link Class} to be cut.
	 */
	Class<?, ?, ?, ?> oldElement;

	/**
	 * This creates an instance.
	 *
	 * @param classToCut
	 *            The {@link Class} to be cut and converted to a {@link Section}.
	 */
	public CutClassAndPasteAsNewSectionAction(Class<?, ?, ?, ?> classToCut) {
		super("cut and paste as new section");
		this.oldElement = classToCut;
	}

	@Override
	public void run() {

		if (!this.oldElement.getContainingSection().equals(this.oldElement)) {
			List<EObject> objectsOldContainer = new LinkedList<>();
			List<EObject> objectsNewContainer = new LinkedList<>();

			if (this.oldElement.getContainingSection().eContainer() instanceof TargetSectionModel) {
				TargetSectionModel model = (TargetSectionModel) this.oldElement.getContainingSection().eContainer();
				TargetSectionCompositeReference ref = (TargetSectionCompositeReference) this.oldElement.eContainer();
				objectsOldContainer.addAll(ref.getValue());
				objectsOldContainer.remove(this.oldElement);

				ref.eSet(ref.eClass().getEStructuralFeature(TargetPackage.TARGET_SECTION_COMPOSITE_REFERENCE__VALUE),
						objectsOldContainer);

				objectsNewContainer.addAll(model.getSections());
				objectsNewContainer.add(this.oldElement);
				model.eSet(
						model.eClass().getEStructuralFeature(PamtramPackage.TARGET_SECTION_MODEL__SECTIONS),
						objectsNewContainer);

			} else if (this.oldElement.getContainingSection().eContainer() instanceof SourceSectionModel) {
				SourceSectionModel model = (SourceSectionModel) this.oldElement.getContainingSection().eContainer();
				SourceSectionCompositeReference ref = (SourceSectionCompositeReference) this.oldElement.eContainer();
				objectsOldContainer.addAll(ref.getValue());
				objectsOldContainer.remove(this.oldElement);

				ref.eSet(ref.eClass().getEStructuralFeature(SourcePackage.SOURCE_SECTION_COMPOSITE_REFERENCE__VALUE),
						objectsOldContainer);

				objectsNewContainer.addAll(model.getSections());
				objectsNewContainer.add(this.oldElement);
				model.eSet(
						model.eClass().getEStructuralFeature(PamtramPackage.SOURCE_SECTION_MODEL__SECTIONS),
						objectsNewContainer);
			}
		}

	}

}
