package de.mfreund.pamtram.model.generator.handler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import de.mfreund.pamtram.model.generator.GeneratorWizard;
import de.mfreund.pamtram.model.generator.WizardData;
import de.tud.et.ifa.agtele.ui.util.UIHelper;

public class ExportMetaModelSectionHandler extends AbstractHandler {

	private IWorkbenchWindow workbenchWindow;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		boolean includeCrossReferences = Integer.parseInt(event.getParameter(
				"de.mfreund.pamtram.model.generator.exportMetaModelSection.includeCrossReferencesParameter")) == 1;

		// get the active workbench window
		this.workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

		// get the selection service (necessary for determining the selected element)
		ISelectionService service = this.workbenchWindow.getSelectionService();

		// get the selected element from the current editor window
		IStructuredSelection selection = (IStructuredSelection) service.getSelection();

		// First, we unwrap the selection to get rid of all the 'WrappedItemProvider' stuff that may be returned by
		// 'getSelection()'; cf. https://www.eclipse.org/forums/index.php/t/803088/
		//
		List<EObject> selected = Arrays.asList(((StructuredSelection) selection).toArray()).stream()
				.map(AdapterFactoryEditingDomain::unwrap).map(o -> (EObject) o).collect(Collectors.toList());

		if (selected.stream().map(EcoreUtil::getRootContainer).collect(Collectors.toSet()).size() > 1) {
			MessageDialog.openError(this.workbenchWindow.getShell(), "Error",
					"Please select only elements that belong to the same root EPackage!");
			return null;
		}

		// get the package that the eObject belongs to
		EPackage ePackage = (EPackage) EcoreUtil.getRootContainer(selected.get(0).eClass());

		// get the active editor
		IEditorPart editor = this.workbenchWindow.getActivePage().getActiveEditor();
		IEditorInput editorInput = editor.getEditorInput();

		// get the path of the open file
		IPath sourcepath = ((FileEditorInput) editorInput).getPath();

		// initialize the data used for the wizard
		WizardData wizardData = new WizardData().setEObjects(selected).setePackage(ePackage)
				.setSourceModelPath(sourcepath).setIncludeCrossReferences(includeCrossReferences);

		// create the wizard
		WizardDialog wizardDialog = new WizardDialog(
				new Shell(),
				new GeneratorWizard(wizardData));
		wizardDialog.create();
		wizardDialog.open();

		return null;
	}

	@Override
	public boolean isEnabled() {

		ISelection selection = UIHelper.getCurrentSelection();

		if (!(selection instanceof StructuredSelection) || selection.isEmpty()) {
			return false;
		}

		if (Arrays.asList(((StructuredSelection) selection).toArray()).stream()
				.anyMatch(o -> !(AdapterFactoryEditingDomain.unwrap(o) instanceof EObject))) {
			return false;

		}


		return super.isEnabled();

	}
}