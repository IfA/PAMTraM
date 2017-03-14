package de.mfreund.pamtram.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;

import de.mfreund.pamtram.pages.SharedSectionModelSelectionPage;
import de.tud.et.ifa.agtele.ui.util.UIHelper;
import pamtram.ConditionModel;
import pamtram.MappingModel;
import pamtram.PAMTraM;
import pamtram.SourceSectionModel;
import pamtram.TargetSectionModel;

/**
 * This wizard allows to import one or multiple library elements from a library (represented by a Zip file) into a
 * pamtram model.
 *
 * @author mfreund
 */
public class ImportSharedModelWizard extends Wizard {

	private final SharedSectionModelSelectionPage one;

	/**
	 * This is the pamtram instance into that the library elements shall be imported.
	 */
	private final PAMTraM pamtram;

	/**
	 * This is the editing domain to be used to perform model changes.
	 */
	private final EditingDomain editingDomain;

	/**
	 * The {@link SharedModelType} of SectionModel(s) to be imported.
	 */
	private SharedModelType type;

	/**
	 * This constructs an instance of the wizard.
	 *
	 * @param pamtram
	 *            The {@link PAMTraM} instance into that the library elements shall be imported.
	 * @param editingDomain
	 *            The editing domain to be used to perform model changes.
	 * @param type
	 *            The {@link SharedModelType} of SectionModel(s) to be imported.
	 */
	public ImportSharedModelWizard(PAMTraM pamtram, EditingDomain editingDomain, SharedModelType type) {
		super();
		this.setNeedsProgressMonitor(true);
		this.pamtram = pamtram;
		this.editingDomain = editingDomain;
		this.type = type;
		String fileEnding = "";
		if (type.equals(SharedModelType.SOURCE)) {
			fileEnding = ".pamtram.source";
		} else if (type.equals(SharedModelType.TARGET)) {
			fileEnding = ".pamtram.target";
		} else if (type.equals(SharedModelType.MAPPING)) {
			fileEnding = ".pamtram.mapping";
		} else if (type.equals(SharedModelType.CONDITION)) {
			fileEnding = ".pamtram.condition";
		}
		this.one = new SharedSectionModelSelectionPage("Select Shared Model", "Select a shared model to be imported",
				fileEnding, false);
	}

	@Override
	public void addPages() {

		this.addPage(this.one);
	}

	@Override
	public boolean performFinish() {

		IFile sharedModelFile = this.one.getSingleSelection();

		// Load the resource containing the SectionModel to be imported
		//
		EObject sharedModel;
		try {

			URI sharedModelURI = URI.createPlatformResourceURI(sharedModelFile.getFullPath().toString(), true);
			Resource sharednModelResource = this.pamtram.eResource().getResourceSet().getResource(sharedModelURI, true);

			EObject content = sharednModelResource.getContents().get(0);

			if (this.type.equals(SharedModelType.SOURCE) && !(content instanceof SourceSectionModel)
					|| this.type.equals(SharedModelType.TARGET) && !(content instanceof TargetSectionModel)
					|| this.type.equals(SharedModelType.MAPPING) && !(content instanceof MappingModel)
					|| this.type.equals(SharedModelType.CONDITION) && !(content instanceof ConditionModel)) {
				this.showError("The selected file does not contain a valid shared model!");
				return false;
			}

			sharedModel = content;

		} catch (Exception e) {
			this.showError("Error while loading the resource containing the shared model!");
			return false;
		}

		// if (this.type.equals(SharedModelType.SOURCE) &&
		// this.pamtram.getSharedSourceSectionModel().contains(sharedModel)
		// || this.type.equals(SharedModelType.TARGET)
		// && this.pamtram.getSharedTargetSectionModel().contains(sharedModel)) {
		// this.showError("The PAMTraM model already contains this shared SectionModel!");
		// return false;
		// }

		EList<?> list = null;
		if (this.type.equals(SharedModelType.SOURCE)) {
			list = this.pamtram.getSharedSourceSectionModels();
		} else if (this.type.equals(SharedModelType.TARGET)) {
			list = this.pamtram.getSharedTargetSectionModels();
		} else if (this.type.equals(SharedModelType.MAPPING)) {
			list = this.pamtram.getSharedMappingModels();
		} else if (this.type.equals(SharedModelType.CONDITION)) {
			list = this.pamtram.getSharedConditionModels();
		}

		AddCommand addCommand = new AddCommand(this.editingDomain, list, sharedModel);

		// Execute the command to import the section model
		//
		this.editingDomain.getCommandStack().execute(addCommand);

		return true;
	}

	/**
	 * Show an error to the user by opening a {@link MessageDialog}.
	 *
	 * @param errorMessage
	 *            The message to display to the user.
	 */
	protected void showError(String errorMessage) {

		Shell shell = UIHelper.getShell();
		MessageDialog.openError(shell, "ERROR", errorMessage);
	}

	/**
	 * An enum representing the types of shared models that can be imported.
	 *
	 * @author mfreund
	 */
	public enum SharedModelType {
		SOURCE, TARGET, MAPPING, CONDITION;
	}
}
