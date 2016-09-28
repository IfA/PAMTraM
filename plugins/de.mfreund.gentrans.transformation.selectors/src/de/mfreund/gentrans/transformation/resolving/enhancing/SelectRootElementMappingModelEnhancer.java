/**
 *
 */
package de.mfreund.gentrans.transformation.resolving.enhancing;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;

import de.mfreund.gentrans.transformation.resolving.UserDecisionResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.wizards.GenericSelectionDialogRunner;
import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.metamodel.MetamodelFactory;
import pamtram.metamodel.TargetSection;
import pamtram.presentation.PamtramEditor;

/**
 * A concrete {@link MappingModelEnhancer} that can be used during
 * {@link UserDecisionResolvingStrategy#joiningSelectRootElement(List) joiningSelectRootElement} ambiguities.
 *
 * @author mfreund
 */
public class SelectRootElementMappingModelEnhancer extends MappingModelEnhancer<GenericSelectionDialogRunner<EClass>> {

	/**
	 * This creates an instance.
	 *
	 * @param pamtramModel
	 */
	public SelectRootElementMappingModelEnhancer(PAMTraM pamtramModel) {
		super(pamtramModel);
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		TargetSection rootSection = MetamodelFactory.eINSTANCE.createTargetSection();
		rootSection.setEClass(this.dialogRunner.getSingleSelection());
		rootSection.setName(this.dialogRunner.getSingleSelection().getName() + " (Root)");

		PamtramEditor editor = PamtramEditor.getEditor(this.pamtramModel, true);

		if (editor == null) {
			this.pamtramModel.getTargetSectionModel().get(0).getMetaModelSections().add(rootSection);

			// finally, we save the model
			try {
				this.pamtramModel.eResource().save(null);
			} catch (IOException e1) {
				MessageDialog.openError(new Shell(), "Error", "Error while trying to save the PAMTraM model!");
				e1.printStackTrace();
			}
		} else {
			editor.getEditingDomain().getCommandStack()
					.execute(new AddCommand(editor.getEditingDomain(),
							editor.getPamtram().getTargetSectionModel().get(0),
							PamtramPackage.Literals.SECTION_MODEL__META_MODEL_SECTIONS, rootSection));
		}

	}

}