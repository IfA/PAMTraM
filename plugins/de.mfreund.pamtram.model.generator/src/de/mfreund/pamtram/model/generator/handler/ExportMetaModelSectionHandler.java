package de.mfreund.pamtram.model.generator.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl.ContainmentUpdatingFeatureMapEntry;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.FeatureMapEntryWrapperItemProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
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

public class ExportMetaModelSectionHandler extends AbstractHandler {
	
	private IWorkbenchWindow workbenchWindow;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		// get the active workbench window
		workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		
		// get the selection service (necessary for determining the selected element)
		ISelectionService service = workbenchWindow.getSelectionService();
		
		// get the selected element from the current editor window
		IStructuredSelection selection = (IStructuredSelection) service.getSelection();
		
		if(selection == null || selection.isEmpty()){
			throw new RuntimeException("Nothing seems to be selected!");
		}
		
		if(!(selection.getFirstElement() instanceof EObject) && !(selection.getFirstElement() instanceof FeatureMapEntryWrapperItemProvider)) {
			throw new RuntimeException("The selected element is of no supported type!");
		}
		
		EObject eObject = null;
		
		// get the selected eObject (the root object of the metamodel section)
		// depending on the type of selection
		if(selection.getFirstElement() instanceof EObject) {
			eObject = (EObject) selection.getFirstElement();
		} else {
			FeatureMapEntryWrapperItemProvider provider = 
					((FeatureMapEntryWrapperItemProvider) selection.getFirstElement());
			if(!(provider.getValue() instanceof ContainmentUpdatingFeatureMapEntry)) {
				throw new RuntimeException("The selected element is of no supported type!");
			}
			
			Object object = ((ContainmentUpdatingFeatureMapEntry) provider.getValue()).getValue();
			if(!(object instanceof EObject)) {
				throw new RuntimeException("The selected element is of no supported type!");
			}
			eObject = (EObject) object;
		}
		
		// get the package that the eObject belongs to
		EPackage ePackage = (EPackage) EcoreUtil.getRootContainer(eObject.eClass());
		
		// get the active editor
		IEditorPart editor = workbenchWindow.getActivePage().getActiveEditor();
		IEditorInput editorInput = editor.getEditorInput();
		
		// get the path of the open file
		IPath sourcepath = ((FileEditorInput) editorInput).getPath();
		
		// initialize the data used for the wizard
		WizardData wizardData = new WizardData()
				.seteObject(eObject)
				.setePackage(ePackage)
				.setSourceModelPath(sourcepath);
		
		// create the wizard
		WizardDialog wizardDialog = new WizardDialog(
				new Shell(), 
				new GeneratorWizard(wizardData));
		wizardDialog.create();
		wizardDialog.open();
		
		return null;
	}
	
}
