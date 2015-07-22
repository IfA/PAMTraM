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


	@Override
	public boolean performFinish() {

		for(MetaModelElement<?, ?, ?> element : two.getElementsToExclude()) {

			Collection<Setting> crossReferences = EcoreUtil.UsageCrossReferencer.find(element, wizardData.getCreatedEObjects());
			for (Setting setting : crossReferences) {
				if(setting.getEStructuralFeature().isMany()) {
					@SuppressWarnings("unchecked")
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
		wizardData.getGenerator().mergeDuplicates(wizardData.getCreatedEObjects());

		try {
			wizardData.getPamtram().eResource().save(null);
		} catch (IOException e) {
			MessageDialog.openError(new Shell(), 
					"Error", "Error while trying to save the PAMTraM model!");
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean canFinish() {
		// the wizard can finish if the eobjects to be created are set
		// (this is necessary to disable the finish button on the first page)
		LinkedList<Class<?, ?, ?>> createdEObjects = this.wizardData.getCreatedEObjects();
		return (createdEObjects != null && createdEObjects.size() > 0);
	}

}
