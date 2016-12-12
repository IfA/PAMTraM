package de.mfreund.pamtram.model.generator.handler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
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
import org.eclipse.ui.IWorkbenchWindow;

import de.mfreund.pamtram.model.generator.GeneratorWizard;
import de.mfreund.pamtram.model.generator.WizardData;
import de.tud.et.ifa.agtele.ui.util.UIHelper;
import pamtram.structure.generic.Section;

/**
 * An {@link AbstractHandler} that uses a {@link GeneratorWizard} to create {@link Section Sections} based on one or
 * multiple {@link EObject EObjects} selected by the user.
 *
 * @author mfreund
 */
public class ExportMetaModelSectionHandler extends AbstractHandler {

	private IWorkbenchWindow workbenchWindow;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// Get the selected element(s) from the current editor window
		//
		IStructuredSelection selection = (IStructuredSelection) UIHelper.getCurrentSelection();

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

		// Get the package that the eObject belongs to
		//
		EPackage ePackage = (EPackage) EcoreUtil.getRootContainer(selected.get(0).eClass());

		// Whether cross references shall be regarded in the creation process
		//
		boolean includeCrossReferences = false;
		try {
			includeCrossReferences = Integer.parseInt(event.getParameter(
					"de.mfreund.pamtram.model.generator.exportMetaModelSection.includeCrossReferencesParameter")) == 1;
		} catch (NumberFormatException e) {
		}

		// Initialize the data used for the wizard
		//
		WizardData wizardData = new WizardData().setSourceElements(selected).setEPackage(ePackage)
				.setIncludeCrossReferences(includeCrossReferences);

		// Create the wizard
		//
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