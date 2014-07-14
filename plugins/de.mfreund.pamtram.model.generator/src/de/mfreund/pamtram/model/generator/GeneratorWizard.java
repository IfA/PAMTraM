package de.mfreund.pamtram.model.generator;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.types.EolOrderedSet;
import org.eclipse.jface.wizard.Wizard;

import pamtram.metamodel.Attribute;

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
		
		// remove the attributes that have been unchecked in the preview page
		IModel model = (IModel) this.wizardData.getEolExecutor().getModels().values().toArray()[0];
		ArrayList<Attribute> attributesToExclude = new ArrayList<Attribute>();
		// therefore, collect the attributes to be excluded
		for(Attribute att : two.getAttributesToInclude().keySet()) {
			if(two.getAttributesToInclude().get(att) == false) {
				attributesToExclude.add(att);
			}
		}
		// now, delete the attributes
		for(Attribute att : attributesToExclude) {
			try {
				model.deleteElement(att);
			} catch (EolRuntimeException e) {
				e.printStackTrace();
			}
		}
		
		// merge duplicate items
		mergeDuplicateItems();
		
		// save the model manually as save-on-disposal is set to false
		wizardData.getEolExecutor().getModels().
			get(wizardData.getTargetModelResource().getURI().toFileString()).store();
		
		
		// delete the models as they are no longer used
		// (thereby, the target model is automatically saved on disposal)
		wizardData.getEolExecutor().disposeModels();

		return true;
	}
	
	/* check if this wizard has created 'class' objects that are equal to
	 * existing ones; if so, merge both (that means delete one and redirect
	 * referencing non-containment references)
	 */
	private void mergeDuplicateItems() {
		URL fileURL = wizardData.getBundle().getEntry("templates/mergeDuplicateItems.eol");

		// create the hashmap containing the parameters to be passed to the eol file
		HashMap<String, Object> params = new HashMap<String, Object>();
		// convert the list of created objects to an eol set
		pamtram.metamodel.Class[] createdObjects = wizardData.getCreatedEObjects();
		EolOrderedSet<pamtram.metamodel.Class> set = 
				new EolOrderedSet<pamtram.metamodel.Class>();
		for(int i=0; i<createdObjects.length; i++) {
			set.add(createdObjects[i]);
		}
		// put the set to the hashmap
		params.put("createdObjects", set); // the root object for the metamodel section
		// tell the eol script whether source or target items shall be merged
		params.put("isSource", (wizardData.getSectionType() == SectionType.SOURCE) ? true : false);
		
		// execute the eol file
		wizardData.getEolExecutor().executeEol(fileURL, params);
	}

	@Override
	public boolean canFinish() {
		// the wizard can finish if the eobjects to be created are set
		// (this is necessary to disable the finish button on the first page)
		EObject[] createdEObjects = this.wizardData.getCreatedEObjects();
		return (createdEObjects != null && createdEObjects.length > 0);
	}

}
