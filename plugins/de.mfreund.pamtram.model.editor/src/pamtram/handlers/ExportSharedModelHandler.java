package pamtram.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.FileEditorInput;

import de.tud.et.ifa.agtele.ui.util.UIHelper;
import pamtram.ConditionModel;
import pamtram.MappingModel;
import pamtram.NamedElement;
import pamtram.PAMTraM;
import pamtram.SourceSectionModel;
import pamtram.TargetSectionModel;
import pamtram.commands.ExportSharedModelCommand;
import pamtram.presentation.PamtramEditor;
import pamtram.util.SharedModelUtil;

/**
 * An {@link AbstractHandler} that allows to export a shared {@link SourceSectionModel}, {@link TargetSectionModel},
 * {@link MappingModel}, or {@link ConditionModel} from a {@link PAMTraM} model to their own file so that they can be
 * reused for multiple PAMTraM models.
 *
 * @author mfreund
 */
public class ExportSharedModelHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) {

		// The element that shall be exported
		//
		EObject sharedModelRoot = (EObject) UIHelper.getFirstSelection();

		if (!(UIHelper.getCurrentEditorInput() instanceof FileEditorInput)) {
			return null;
		}

		String fileEnding = SharedModelUtil.getFileEndingBySharedModelRoot(sharedModelRoot);

		IPath newPath = ((FileEditorInput) UIHelper.getCurrentEditorInput()).getPath().removeLastSegments(1)
				.append(((NamedElement) sharedModelRoot).getName() + fileEnding);
		IFile newFile = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(newPath);

		// Ask the user for the new location of the exported SectionModel
		//
		SaveAsDialog dialog = new SaveAsDialog(UIHelper.getShell());
		dialog.setOriginalFile(newFile);
		dialog.create();
		dialog.setTitle("Export Shared Model");
		dialog.setMessage("Specify the location for the exported " + sharedModelRoot.eClass().getName() + " (*"
				+ fileEnding + ")");

		dialog.setBlockOnOpen(true);
		dialog.open();
		newPath = dialog.getResult();

		if (newPath == null) {
			return null;
		}

		// Validate the file name
		//
		if (!newPath.toString().endsWith(fileEnding)) {
			this.showError("Please specify a valid file name (*" + fileEnding + ")");
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

		ExportSharedModelCommand command = new ExportSharedModelCommand(domain, (PAMTraM) sharedModelRoot.eContainer(),
				sharedModelRoot, sectionModelResourceURI);

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

		if (!(selection instanceof SourceSectionModel || selection instanceof TargetSectionModel
				|| selection instanceof MappingModel || selection instanceof ConditionModel)) {
			return false;
		}

		EObject sharedModelRoot = (EObject) UIHelper.getFirstSelection();

		// Check if the section model has already been exported/is not part of the resource
		// holding he PAMTraM model
		//
		if (!sharedModelRoot.eResource().equals(sharedModelRoot.eContainer().eResource())) {
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
