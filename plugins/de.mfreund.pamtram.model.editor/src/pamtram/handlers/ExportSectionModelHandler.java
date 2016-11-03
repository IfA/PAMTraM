package pamtram.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.FileEditorInput;

import de.tud.et.ifa.agtele.ui.util.UIHelper;
import pamtram.PAMTraM;
import pamtram.SectionModel;
import pamtram.SourceSectionModel;
import pamtram.TargetSectionModel;
import pamtram.commands.ExportSectionModelCommand;
import pamtram.presentation.PamtramEditor;

/**
 * An {@link AbstractHandler} that allows to export {@link SectionModel SectionModels} from a {@link PAMTraM} model to
 * their own file so that they can be reused for multiple PAMTraM models.
 *
 * @author mfreund
 */
public class ExportSectionModelHandler extends AbstractHandler {

	private static final String SOURCE_FILE_ENDING = ".pamtram.source";

	private static final String TARGET_FILE_ENDING = ".pamtram.target";

	@Override
	public Object execute(ExecutionEvent event) {

		// The SectionModel that shall be exported
		//
		SectionModel<?, ?, ?, ?> sectionModel = (SectionModel<?, ?, ?, ?>) UIHelper.getFirstSelection();

		if (!(UIHelper.getCurrentEditorInput() instanceof FileEditorInput)) {
			return null;
		}

		IPath newPath = ((FileEditorInput) UIHelper.getCurrentEditorInput()).getPath().removeLastSegments(1)
				.append(sectionModel.getName() + (sectionModel instanceof SourceSectionModel
						? ExportSectionModelHandler.SOURCE_FILE_ENDING : ExportSectionModelHandler.TARGET_FILE_ENDING));
		IFile newFile = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(newPath);

		// Ask the user for the new location of the exported SectionModel
		//
		SaveAsDialog dialog = new SaveAsDialog(UIHelper.getShell());
		dialog.setOriginalFile(newFile);
		dialog.create();
		dialog.setTitle("Export SectionModel");
		if (sectionModel instanceof SourceSectionModel) {
			dialog.setMessage("Specify the location for the exported SourceSectionModel (*"
					+ ExportSectionModelHandler.SOURCE_FILE_ENDING + ")");
		} else {
			dialog.setMessage("Specify the location for the exported TargetSectionModel (*"
					+ ExportSectionModelHandler.TARGET_FILE_ENDING + ")");
		}
		dialog.setBlockOnOpen(true);
		dialog.open();
		newPath = dialog.getResult();

		if (newPath == null) {
			return null;
		}

		// Validate the file name
		//
		if (sectionModel instanceof SourceSectionModel
				&& !newPath.toString().endsWith(ExportSectionModelHandler.SOURCE_FILE_ENDING)) {
			this.showError("Please specify a valid file name (*" + ExportSectionModelHandler.SOURCE_FILE_ENDING + ")");
			return null;
		} else if (sectionModel instanceof TargetSectionModel
				&& !newPath.toString().endsWith(ExportSectionModelHandler.TARGET_FILE_ENDING)) {
			this.showError("Please specify a valid file name (*" + ExportSectionModelHandler.TARGET_FILE_ENDING + ")");
			return null;
		}

		URI sectionModelResourceURI = URI.createPlatformResourceURI(newPath.toString(), true);

		// Determine the editing domain on which to execute the command that will perform the actual exporting
		//
		IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (!(editorPart instanceof PamtramEditor)) {
			return null;
		}
		EditingDomain domain = ((PamtramEditor) editorPart).getEditingDomain();

		ExportSectionModelCommand command = new ExportSectionModelCommand(domain, (PAMTraM) sectionModel.eContainer(),
				sectionModel, sectionModelResourceURI);

		// Finally, execute the command
		//
		domain.getCommandStack().execute(command);

		return null;
	}

	@Override
	public boolean isEnabled() {

		if (!(UIHelper.getCurrentEditorInput() instanceof FileEditorInput)) {
			return false;
		}

		if (!(UIHelper.getCurrentSelection() instanceof StructuredSelection)
				|| ((StructuredSelection) UIHelper.getCurrentSelection()).size() != 1) {
			return false;
		}

		Object selection = UIHelper.getFirstSelection();

		if (!(selection instanceof SourceSectionModel || selection instanceof TargetSectionModel)) {
			return false;
		}

		SectionModel<?, ?, ?, ?> sectionModel = (SectionModel<?, ?, ?, ?>) UIHelper.getFirstSelection();

		// Check if the section model has already been exported/is not part of the resource
		// holding he PAMTraM model
		//
		if (!sectionModel.eResource().equals(sectionModel.eContainer().eResource())) {
			return false;
		}

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
}
