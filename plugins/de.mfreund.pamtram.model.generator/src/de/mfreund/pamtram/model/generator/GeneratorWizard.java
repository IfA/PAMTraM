package de.mfreund.pamtram.model.generator;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.metamodel.Class;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.Section;

/**
 * A {@link Wizard} that allows to create new {@link Section Sections} in a {@link PAMTraM} model based on a set of
 * selected {@link EObject EObjects}.
 *
 * @author mfreund
 */
public class GeneratorWizard extends Wizard {

	/**
	 * The {@link WizardPage} that allows the user to select a target {@link PAMTraM} model.
	 */
	protected MappingModelSelectorPage one;

	/**
	 * The {@link WizardPage} that allows the user to preview and customize the created Section(s).
	 */
	protected PreviewPage two;

	/**
	 * The {@link WizardData} that contains the necessary information to be used throughout the wizard.
	 */
	protected WizardData wizardData;

	/**
	 * This creates an instance.
	 *
	 * @param wizardData
	 *            The {@link WizardData} that contains the necessary information to be used throughout the wizard.
	 */
	public GeneratorWizard(WizardData wizardData) {
		super();
		this.setNeedsProgressMonitor(true);
		this.wizardData = wizardData;
	}

	@Override
	public void addPages() {
		this.one = new MappingModelSelectorPage(this.wizardData);
		this.addPage(this.one);
		this.two = new PreviewPage(this.wizardData);
		this.addPage(this.two);
	}


	@SuppressWarnings("unchecked")
	@Override
	public boolean performFinish() {

		// Delete all elements that have been excluded by the user in the 'PreviewPage'
		//
		for(MetaModelElement<?, ?, ?, ?> element : this.two.getElementsToExclude()) {

			Collection<Setting> crossReferences = EcoreUtil.UsageCrossReferencer.find(element, this.wizardData.getCreatedSections());
			for (Setting setting : crossReferences) {
				if(setting.getEStructuralFeature().isMany()) {
					List<EObject> values = new BasicEList<>(
							(List<EObject>) setting.getEObject().eGet(setting.getEStructuralFeature()));
					values.remove(element);
					setting.getEObject().eSet(setting.getEStructuralFeature(), values);

				} else {
					setting.getEObject().eUnset(setting.getEStructuralFeature());
				}
			}

			this.wizardData.getCreatedSections().remove(element);
			EcoreUtil.remove(element);
		}

		// merge duplicate items
		//
		List<Section<?, ?, ?, ?>> sectionsToAdd =
				this.wizardData.getGenerator().mergeDuplicates(this.wizardData.getCreatedSections());


		/*
		 * If there is an open editor for our pamtram instance, we may use the editing domain of the editor
		 * to add the new elements. That way, undo/redo and other things will be possible.
		 * If there is no open editor, we just add the pamtram model manually and save the resource that contains it.
		 */
		if(this.wizardData.getEditor() != null) {

			EditingDomain editingDomain = this.wizardData.getEditor().getEditingDomain();

			// now that we now which of the sections are unique, we can add those to the pamtram model
			//
			AddCommand addGeneratedSections = new AddCommand(editingDomain, this.wizardData.getSectionModel(),
					PamtramPackage.Literals.SECTION_MODEL__META_MODEL_SECTIONS, sectionsToAdd);

			editingDomain.getCommandStack().execute(addGeneratedSections);

			// bring the editor to the top to show the changes to the user
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().bringToTop(this.wizardData.getEditor());
		} else {

			// now that we now which of the sections are unique, we can add those to the pamtram model
			((EList<Class<?, ?, ?, ?>>) this.wizardData.getSectionModel().getMetaModelSections()).addAll(sectionsToAdd);

			// finally, we save the model
			try {
				this.wizardData.getPamtram().eResource().save(null);
			} catch (IOException e) {
				MessageDialog.openError(new Shell(),
						"Error", "Error while trying to save the PAMTraM model!");
				e.printStackTrace();
				return false;
			}
		}

		MessageDialog.openInformation(new Shell(), "Export Result",
				sectionsToAdd.size() + " sections have been added to the PAMTraM model. There were " +
						(this.wizardData.getCreatedSections().size() - sectionsToAdd.size()) + " sections that have been identified as duplicates of " +
				"existing sections. Those have not added but merged with the existing ones.");

		return true;
	}

	@Override
	public boolean canFinish() {

		// the wizard can finish if the eobjects to be created are set
		// (this is necessary to disable the finish button on the first page)
		List<Section<?, ?, ?, ?>> createdEObjects = this.wizardData.getCreatedSections();
		return createdEObjects != null && !createdEObjects.isEmpty();
	}

	@Override
	public boolean performCancel() {
		if(this.wizardData.getTargetModelResource() != null) {
			this.wizardData.getTargetModelResource().unload();
		}
		return super.performCancel();
	}

}
