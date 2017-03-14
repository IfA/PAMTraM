/**
 *
 */
package de.mfreund.gentrans.transformation.resolving.enhancing;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;

import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.resolving.UserDecisionResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.wizards.GenericSelectionDialogRunner;
import de.tud.et.ifa.agtele.emf.compare.EMFCompareUtil;
import de.tud.et.ifa.agtele.ui.util.UIHelper;
import pamtram.PAMTraM;
import pamtram.mapping.ContainerSelector;
import pamtram.mapping.MappingFactory;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingPackage;
import pamtram.presentation.PamtramEditor;

/**
 * A concrete {@link MappingModelEnhancer} that can be used during
 * {@link UserDecisionResolvingStrategy#joiningSelectContainerInstance(List, List, pamtram.mapping.MappingHintGroupType, pamtram.mapping.ContainerSelector, String)
 * joiningSelectContainerInstance} ambiguities.
 *
 * @author mfreund
 */
public class JoiningSelectContainerInstanceMappingModelEnhancer
		extends MappingModelEnhancer<GenericSelectionDialogRunner<EObjectWrapper>> {

	/**
	 * The {@link MappingHintGroup} of which created target instances that shall be enhanced to the selected instance.
	 */
	private MappingHintGroup hintGroup;

	/**
	 * This creates an instance.
	 *
	 * @param pamtramModel
	 * @param hintGroup
	 *            The {@link MappingHintGroup} of which created target instances that shall be enhanced to the selected
	 *            instance.
	 */
	public JoiningSelectContainerInstanceMappingModelEnhancer(PAMTraM pamtramModel, MappingHintGroup hintGroup) {
		super(pamtramModel);
		this.hintGroup = hintGroup;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		PamtramEditor editor = this.getEditor();

		PAMTraM pamtramToEnhance = editor == null ? this.pamtramModel : editor.getPamtram();

		ContainerSelector selector = this.hintGroup.getContainerSelector();

		if (selector != null) {
			MessageDialog.openError(UIHelper.getShell(), "Error",
					"The MappingHintGroup that was responsible for instantiating the instances "
							+ "to to be connected already specifies a ContainerSelector.");
			return;
		}

		// The ContainerSelector that is used to enhance the MappingModel
		//
		selector = MappingFactory.eINSTANCE.createContainerSelectorWithSourceAndTarget();

		if (editor == null) {

			// Use the 'classic' way to add the new elements as we can not use any command stack
			//
			this.hintGroup.setContainerSelector(selector);

			// finally, we save the model
			try {
				this.pamtramModel.eResource().save(null);
			} catch (IOException e1) {
				MessageDialog.openError(new Shell(), "Error", "Error while trying to save the PAMTraM model!");
				e1.printStackTrace();
			}
		} else {

			MappingHintGroup hintGroupMatch = EMFCompareUtil.getMatchOfSameType(this.pamtramModel, pamtramToEnhance,
					this.hintGroup);

			if (hintGroupMatch == null) {
				return;
			}

			// Use a command to add the new elements
			//
			SetCommand setCommand = new SetCommand(editor.getEditingDomain(), hintGroupMatch,
					MappingPackage.Literals.MAPPING_HINT_GROUP__CONTAINER_SELECTOR, selector);
			editor.getEditingDomain().getCommandStack().execute(setCommand);

		}
	}

}
