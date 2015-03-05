package de.mfreund.pamtram.wizards;

import java.io.IOException;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.wizard.Wizard;

import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingFactory;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.commands.CreateLibraryEntryCommand;
import pamtram.metamodel.ContainerParameter;
import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.LibraryParameter;
import pamtram.util.LibraryHelper;
import de.mfreund.pamtram.pages.ImportLibraryElementWizardMainPage;
import de.tud.et.ifa.agtele.genlibrary.util.interfaces.LibraryFileEntry;

/**
 * This wizard allows to import one or multiple library elements from a 
 * library (represented by a Zip file) into a pamtram model.
 * 
 * @author mfreund
 */
public class ImportLibraryElementWizard extends Wizard {

	final private ImportLibraryElementWizardMainPage one;
	
	/**
	 * This is the pamtram instance into that the library elements shall be 
	 * imported.
	 */
	final private PAMTraM pamtram;
	
	/**
	 * This is the editing domain to be used to perform model changes.
	 */
	final private EditingDomain editingDomain;
	
	/**
	 * This constructs an instance of the wizard.
	 * 
	 * @param pamtram The pamtram instance into that the library elements shall
	 * be imported.
	 * @param editingDomain The editing domain to be used to perform model changes.
	 */
	public ImportLibraryElementWizard(PAMTraM pamtram, EditingDomain editingDomain) {
		super();
		setNeedsProgressMonitor(true);
		this.pamtram = pamtram;
		this.editingDomain = editingDomain;
		one = new ImportLibraryElementWizardMainPage();
	}
	
	@Override
	public void addPages() {
		addPage(one);
	}
	
	@Override
	public boolean performFinish() {
		
		CompoundCommand compoundCommand = new CompoundCommand();

		// now, we import the selected library elements to the pamtram model
		for (LibraryFileEntry entry : one.getLibEntriesToImport()) {
			try {
				
				// first, create the library element
				LibraryEntry libElement = 
						LibraryHelper.convertToLibraryElement(
								one.getLibraryFile(), 
								entry.getKey(), 
								pamtram.getTargetSectionModel().getMetaModelPackage(), 
								pamtram.eResource().getURI().trimSegments(1).appendSegment("lib"),
								editingDomain.getResourceSet());
				
				// second, create a command to import it to the pamtram model 
				Command createLibraryEntryCommand = new CreateLibraryEntryCommand(
						editingDomain, 
						pamtram.getTargetSectionModel(), 
						libElement, pamtram.eResource().getURI().trimSegments(1).appendSegment("lib").appendSegment(entry.getKey()).appendSegment("data.xmi"));
				compoundCommand.append(createLibraryEntryCommand);					
				
				if(one.isCreateMappings()) {
					// first, create a mapping that points to the library entry
					Mapping mapping = MappingFactory.eINSTANCE.createMapping();
					for (LibraryParameter parameter : libElement.getParameters()) {
						// create a mapping hint group for every container parameter
						if((parameter instanceof ContainerParameter)) {
							MappingHintGroup hintGroup = MappingFactory.eINSTANCE.createMappingHintGroup();
							hintGroup.setTargetMMSection(((ContainerParameter) parameter).getClass_());
							hintGroup.setName(((ContainerParameter) parameter).getClass_().getName());
							mapping.getMappingHintGroups().add(hintGroup);
						}
						//TODO handle the other parameters
					}
					// second, create a command to import it to the pamtram model
					Command createMappingCommand = new CreateChildCommand(
							editingDomain, 
							pamtram.getMappingModel(), 
							PamtramPackage.Literals.MAPPING_MODEL__MAPPING, 
							mapping, 
							null);
					compoundCommand.append(createMappingCommand);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		// execute the command to import all library items at once
		editingDomain.getCommandStack().execute(compoundCommand);
		
		return true;
	}
	
}
