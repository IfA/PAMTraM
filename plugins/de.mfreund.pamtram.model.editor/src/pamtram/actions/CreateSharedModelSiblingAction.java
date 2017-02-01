/**
 *
 */
package pamtram.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.ui.action.CreateSiblingAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.FileEditorInput;

import de.tud.et.ifa.agtele.ui.util.UIHelper;
import pamtram.PamtramPackage;
import pamtram.SectionModel;
import pamtram.commands.CreateSharedModelCommand;

/**
 * A special {@link CreateSiblingAction} that allows to create shared {@link SectionModel SectionModels}. Before the
 * action is executed, the user is asked to specify a location for the new shared section model to be created via a
 * {@link SaveAsDialog}.
 *
 * @author mfreund
 */
public class CreateSharedModelSiblingAction extends CreateSiblingAction {

	private static final String SOURCE_FILE_ENDING = ".pamtram.source";

	private static final String TARGET_FILE_ENDING = ".pamtram.target";

	private static final String MAPPING_FILE_ENDING = ".pamtram.mapping";

	private static final String CONDITION_FILE_ENDING = ".pamtram.condition";

	/**
	 * This creates an instance.
	 *
	 * @param editorPart
	 * @param selection
	 * @param descriptor
	 */
	public CreateSharedModelSiblingAction(IEditorPart editorPart, ISelection selection, Object descriptor) {
		super(editorPart, selection, descriptor);
	}

	@Override
	public void run() {

		if (!(this.descriptor instanceof CommandParameter)
				|| !(((CommandParameter) this.descriptor).getFeature() instanceof EStructuralFeature)
				|| !(this.command instanceof CreateSharedModelCommand)) {
			this.showError("Internal error while executing the action!");
			return;
		}

		EStructuralFeature feature = (EStructuralFeature) ((CommandParameter) this.descriptor).getFeature();

		if (!(feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_SOURCE_SECTION_MODEL)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_TARGET_SECTION_MODEL)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_MAPPING_MODEL)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_CONDITION_MODEL))) {
			this.showError("Internal error while executing the action!");
			return;
		}

		String fileEnding = "";
		if (feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_SOURCE_SECTION_MODEL)) {
			fileEnding = CreateSharedModelSiblingAction.SOURCE_FILE_ENDING;
		} else if (feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_TARGET_SECTION_MODEL)) {
			fileEnding = CreateSharedModelSiblingAction.TARGET_FILE_ENDING;
		} else if (feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_MAPPING_MODEL)) {
			fileEnding = CreateSharedModelSiblingAction.MAPPING_FILE_ENDING;
		} else if (feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_CONDITION_MODEL)) {
			fileEnding = CreateSharedModelSiblingAction.CONDITION_FILE_ENDING;
		}
		IPath newPath = ((FileEditorInput) UIHelper.getCurrentEditorInput()).getPath().removeLastSegments(1)
				.append(fileEnding);
		IFile newFile = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(newPath);

		// Ask the user for the new location of the exported SectionModel
		//
		SaveAsDialog dialog = new SaveAsDialog(UIHelper.getShell());
		dialog.setOriginalFile(newFile);
		dialog.create();
		dialog.setTitle("Export SectionModel");
		if (feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_SOURCE_SECTION_MODEL)) {
			dialog.setMessage("Specify the location for the shared SourceSectionModel (*"
					+ CreateSharedModelSiblingAction.SOURCE_FILE_ENDING + ")");
		} else if (feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_TARGET_SECTION_MODEL)) {
			dialog.setMessage("Specify the location for the shared TargetSectionModel (*"
					+ CreateSharedModelSiblingAction.TARGET_FILE_ENDING + ")");
		} else if (feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_MAPPING_MODEL)) {
			dialog.setMessage("Specify the location for the shared MapingModel (*"
					+ CreateSharedModelSiblingAction.MAPPING_FILE_ENDING + ")");
		} else if (feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_CONDITION_MODEL)) {
			dialog.setMessage("Specify the location for the shared ConditionModel (*"
					+ CreateSharedModelSiblingAction.CONDITION_FILE_ENDING + ")");
		}
		dialog.setBlockOnOpen(true);
		dialog.open();
		newPath = dialog.getResult();

		if (newPath == null) {
			return;
		}

		// Validate the file name
		//
		if (feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_SOURCE_SECTION_MODEL)
				&& !newPath.toString().endsWith(CreateSharedModelSiblingAction.SOURCE_FILE_ENDING)) {
			this.showError("Please specify a valid file name (*"
					+ CreateSharedModelSiblingAction.SOURCE_FILE_ENDING + ")");
			return;
		} else if (feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_TARGET_SECTION_MODEL)
				&& !newPath.toString().endsWith(CreateSharedModelSiblingAction.TARGET_FILE_ENDING)) {
			this.showError("Please specify a valid file name (*"
					+ CreateSharedModelSiblingAction.TARGET_FILE_ENDING + ")");
			return;
		} else if (feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_MAPPING_MODEL)
				&& !newPath.toString().endsWith(CreateSharedModelSiblingAction.MAPPING_FILE_ENDING)) {
			this.showError("Please specify a valid file name (*"
					+ CreateSharedModelSiblingAction.MAPPING_FILE_ENDING + ")");
			return;
		} else if (feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_CONDITION_MODEL)
				&& !newPath.toString().endsWith(CreateSharedModelSiblingAction.CONDITION_FILE_ENDING)) {
			this.showError("Please specify a valid file name (*"
					+ CreateSharedModelSiblingAction.CONDITION_FILE_ENDING + ")");
			return;
		}

		URI sectionModelResourceURI = URI.createPlatformResourceURI(newPath.toString(), true);

		((CreateSharedModelCommand) this.command).setModelURI(sectionModelResourceURI);

		super.run();
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

}
