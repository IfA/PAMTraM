/**
 *
 */
package de.mfreund.gentrans.transformation.resolving.enhancing;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;

import de.mfreund.gentrans.transformation.resolving.UserDecisionResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.wizards.GenericSelectionDialogRunner;
import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingFactory;
import pamtram.mapping.MappingHintGroup;
import pamtram.metamodel.MetamodelFactory;
import pamtram.metamodel.TargetSection;
import pamtram.presentation.PamtramEditor;

/**
 * A concrete {@link MappingModelEnhancer} that can be used during
 * {@link UserDecisionResolvingStrategy#joiningSelectRootElement(List) joiningSelectRootElement} ambiguities.
 *
 * @author mfreund
 */
public class JoiningSelectRootElementMappingModelEnhancer extends MappingModelEnhancer<GenericSelectionDialogRunner<EClass>> {

	/**
	 * This creates an instance.
	 *
	 * @param pamtramModel
	 */
	public JoiningSelectRootElementMappingModelEnhancer(PAMTraM pamtramModel) {
		super(pamtramModel);
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		// The TargetSection for the root element
		//
		TargetSection rootSection = MetamodelFactory.eINSTANCE.createTargetSection();
		rootSection.setEClass(this.dialogRunner.getSingleSelection());
		rootSection.setName(this.dialogRunner.getSingleSelection().getName() + " (Root)");

		// The mapping for the root element TargetSection
		//
		Mapping mapping = MappingFactory.eINSTANCE.createMapping();
		mapping.setName("RootMapping");
		MappingHintGroup hintGroup = MappingFactory.eINSTANCE.createMappingHintGroup();
		hintGroup.setName(rootSection.getName());
		hintGroup.setTargetSection(rootSection);
		mapping.getMappingHintGroups().add(hintGroup);

		PamtramEditor editor = this.getEditor();

		if (editor == null) {

			// Use the 'classic' way to add the new elements as we can not use any command stack
			//
			this.pamtramModel.getTargetSectionModel().get(0).getMetaModelSections().add(rootSection);
			this.pamtramModel.getMappingModel().get(0).getMapping().add(mapping);

			// finally, we save the model
			try {
				this.pamtramModel.eResource().save(null);
			} catch (IOException e1) {
				MessageDialog.openError(new Shell(), "Error", "Error while trying to save the PAMTraM model!");
				e1.printStackTrace();
			}
		} else {

			// Use a command to add the new elements
			//
			CompoundCommand addCommand = new CompoundCommand();
			addCommand.append(new AddCommand(editor.getEditingDomain(), editor.getPamtram().getMappingModel().get(0),
					PamtramPackage.Literals.MAPPING_MODEL__MAPPING, mapping));
			addCommand.append(
					new AddCommand(editor.getEditingDomain(), editor.getPamtram().getTargetSectionModel().get(0),
							PamtramPackage.Literals.SECTION_MODEL__META_MODEL_SECTIONS, rootSection));
			editor.getEditingDomain().getCommandStack().execute(addCommand);
		}

	}

}