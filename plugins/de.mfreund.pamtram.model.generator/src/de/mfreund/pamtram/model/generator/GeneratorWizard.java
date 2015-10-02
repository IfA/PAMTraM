package de.mfreund.pamtram.model.generator;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import pamtram.PamtramPackage;
import pamtram.metamodel.Class;
import pamtram.metamodel.MetaModelElement;

public class GeneratorWizard extends Wizard {

	protected MappingModelSelectorPage one;
	protected PreviewPage two;
	protected WizardData wizardData;

	public GeneratorWizard(WizardData wizardData) {
		super();
		setNeedsProgressMonitor(true);
		this.wizardData = wizardData;
	}

	@Override
	public void addPages() {
		one = new MappingModelSelectorPage(wizardData);
		addPage(one);
		two = new PreviewPage(wizardData);
		addPage(two);
	}


	@SuppressWarnings("unchecked")
	@Override
	public boolean performFinish() {

		for(MetaModelElement<?, ?, ?> element : two.getElementsToExclude()) {

			Collection<Setting> crossReferences = EcoreUtil.UsageCrossReferencer.find(element, wizardData.getCreatedEObjects());
			for (Setting setting : crossReferences) {
				if(setting.getEStructuralFeature().isMany()) {
					EList<EObject> values = (EList<EObject>) setting.getEObject().eGet(setting.getEStructuralFeature());
					values.remove(element);
					setting.getEObject().eSet(setting.getEStructuralFeature(), values);

				} else {
					setting.getEObject().eUnset(setting.getEStructuralFeature());
				}
			}

			wizardData.getCreatedEObjects().remove(element);
			EcoreUtil.remove(element);
		}

		// merge duplicate items
		LinkedList<Class<?, ?, ?>> sectionsToAdd = 
				wizardData.getGenerator().mergeDuplicates(wizardData.getCreatedEObjects());


		/*
		 * If there is an open editor for our pamtram instance, we may use the editing domain of the editor
		 * to add the new elements. That way, undo/redo and other things will be possible.
		 * If there is no open editor, we just add the pamtram model manually and save the resource that contains it.
		 */
		if(wizardData.getEditor() != null) {

			EditingDomain editingDomain = wizardData.getEditor().getEditingDomain();

			AddCommand addGeneratedSections = null;
			// now that we now which of the sections are unique, we can add those to the pamtram model
			addGeneratedSections = new AddCommand(editingDomain, wizardData.getSectionModel(), PamtramPackage.Literals.SECTION_MODEL__META_MODEL_SECTIONS, sectionsToAdd);

			editingDomain.getCommandStack().execute(addGeneratedSections);

			// bring the editor to the top to show the changes to the user
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().bringToTop(wizardData.getEditor());
		} else {

			// now that we now which of the sections are unique, we can add those to the pamtram model
			((EList<Class<?, ?, ?>>) wizardData.getSectionModel().getMetaModelSections()).addAll(sectionsToAdd);

			// finally, we save the model
			try {
				wizardData.getPamtram().eResource().save(null);
			} catch (IOException e) {
				MessageDialog.openError(new Shell(), 
						"Error", "Error while trying to save the PAMTraM model!");
				e.printStackTrace();
				return false;
			}
		}

		MessageDialog.openInformation(new Shell(), "Export Result", 
				sectionsToAdd.size() + " sections have been added to the PAMTraM model. There were " +
						(wizardData.getCreatedEObjects().size() - sectionsToAdd.size()) + " sections that have been identified as duplicates of " +
				"existing sections. Those have not added but merged with the existing ones.");

		return true;
	}

	@Override
	public boolean canFinish() {
		// the wizard can finish if the eobjects to be created are set
		// (this is necessary to disable the finish button on the first page)
		LinkedList<Class<?, ?, ?>> createdEObjects = this.wizardData.getCreatedEObjects();
		return (createdEObjects != null && createdEObjects.size() > 0);
	}

	@Override
	public boolean performCancel() {
		if(wizardData.getTargetModelResource() != null) {
			wizardData.getTargetModelResource().unload();
		}
		return super.performCancel();
	}

}
