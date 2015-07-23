package de.mfreund.pamtram.model.generator;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;

import pamtram.metamodel.Class;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.TargetSectionClass;

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

		// now that we now which of the sections are unique, we can add those to the pamtram model
		if(wizardData.getSectionType() == SectionType.SOURCE) {
			wizardData.getPamtram().getSourceSectionModel().getMetaModelSections().addAll((Collection<? extends SourceSectionClass>) sectionsToAdd);
		} else {
			wizardData.getPamtram().getTargetSectionModel().getMetaModelSections().addAll((Collection<? extends TargetSectionClass>) sectionsToAdd);
		}

		// finally, we save the model
		try {
			wizardData.getPamtram().eResource().save(null);
		} catch (IOException e) {
			MessageDialog.openError(new Shell(), 
					"Error", "Error while trying to save the PAMTraM model!");
			e.printStackTrace();
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
		wizardData.getTargetModelResource().unload();
		return super.performCancel();
	}
}
