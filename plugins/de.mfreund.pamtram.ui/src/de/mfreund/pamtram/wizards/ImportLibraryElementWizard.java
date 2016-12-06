package de.mfreund.pamtram.wizards;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.wizard.Wizard;

import de.mfreund.pamtram.pages.ImportLibraryElementWizardMainPage;
import de.tud.et.ifa.agtele.genlibrary.util.interfaces.LibraryFileEntry;
import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.commands.CreateLibraryEntryCommand;
import pamtram.mapping.AttributeMapping;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingFactory;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.ReferenceTargetSelector;
import pamtram.metamodel.AttributeParameter;
import pamtram.metamodel.ContainerParameter;
import pamtram.metamodel.ExternalReferenceParameter;
import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.LibraryParameter;
import pamtram.util.GenLibraryManager;
import pamtram.util.LibraryHelper;

/**
 * This wizard allows to import one or multiple library elements from a library (represented by a Zip file) into a
 * pamtram model.
 *
 * @author mfreund
 */
public class ImportLibraryElementWizard extends Wizard {

	private final ImportLibraryElementWizardMainPage one;

	/**
	 * This is the pamtram instance into that the library elements shall be imported.
	 */
	private final PAMTraM pamtram;

	/**
	 * This is the editing domain to be used to perform model changes.
	 */
	private final EditingDomain editingDomain;

	/**
	 * This constructs an instance of the wizard.
	 *
	 * @param pamtram
	 *            The pamtram instance into that the library elements shall be imported.
	 * @param editingDomain
	 *            The editing domain to be used to perform model changes.
	 */
	public ImportLibraryElementWizard(PAMTraM pamtram, EditingDomain editingDomain) {
		super();
		this.setNeedsProgressMonitor(true);
		this.pamtram = pamtram;
		this.editingDomain = editingDomain;
		this.one = new ImportLibraryElementWizardMainPage(pamtram);
	}

	@Override
	public void addPages() {

		this.addPage(this.one);
	}

	@Override
	public boolean performFinish() {

		CompoundCommand compoundCommand = new CompoundCommand();

		// now, we import the selected library elements to the pamtram model
		for (LibraryFileEntry entry : this.one.getLibEntriesToImport()) {
			try {

				GenLibraryManager manager = new GenLibraryManager();

				// We simply use the parent of the chosen library file as library location
				//
				String libraryLocation = new File(this.one.getLibraryFile()).getParent();
				manager.addLibPath(libraryLocation);

				// first, create the library element
				LibraryEntry libElement = LibraryHelper.convertToLibraryElement(manager,
						this.one.getTargetSectionModel().getMetaModelPackage().getNsURI(), entry.getKey(),
						this.pamtram.eResource().getURI().trimSegments(1).appendSegment("lib"),
						this.editingDomain.getResourceSet());
				libElement.setLibraryFile(this.one.getLibraryFile());

				// second, create a command to import it to the pamtram model
				Command createLibraryEntryCommand = new CreateLibraryEntryCommand(this.editingDomain,
						this.one.getTargetSectionModel(), libElement,
						this.pamtram.eResource().getURI().trimSegments(1).appendSegment("lib").appendSegment("target")
								.appendSegment(entry.getKey()).appendSegment("data.xmi"));
				compoundCommand.append(createLibraryEntryCommand);

				if (this.one.isCreateMappings()) {
					// first, create a mapping that points to the library entry
					Mapping mapping = MappingFactory.eINSTANCE.createMapping();
					ArrayList<MappingHintGroup> mappingHintGroups = new ArrayList<>();
					ArrayList<MappingHint> mappingHints = new ArrayList<>();
					for (LibraryParameter<?> parameter : libElement.getParameters()) {
						// create a mapping hint group for every container parameter
						if (parameter instanceof ContainerParameter) {
							MappingHintGroup hintGroup = MappingFactory.eINSTANCE.createMappingHintGroup();
							mappingHintGroups.add(hintGroup);
							// add the mapping hint group to the mapping
							compoundCommand.append(new CreateChildCommand(this.editingDomain, mapping,
									MappingPackage.Literals.MAPPING__MAPPING_HINT_GROUPS, hintGroup, null));
							// set the target metamodel section of the hint group
							compoundCommand.append(new SetCommand(this.editingDomain, hintGroup,
									MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__TARGET_SECTION,
									((ContainerParameter) parameter).getClass_()));
						} else if (parameter instanceof ExternalReferenceParameter) {
							ReferenceTargetSelector selector = MappingFactory.eINSTANCE.createReferenceTargetSelector();
							mappingHints.add(selector);
							// set the affected reference of the mapping instance selector
							selector.setAffectedReference(((ExternalReferenceParameter) parameter).getReference());
						} else if (parameter instanceof AttributeParameter) {
							AttributeMapping attMapping = MappingFactory.eINSTANCE.createAttributeMapping();
							mappingHints.add(attMapping);
							// set the target attribute of the attribute mapping
							attMapping.setTarget(((AttributeParameter) parameter).getAttribute());
						}
					}
					// now, we add all mapping hints to the first hint group
					// TODO if there are multiple groups, choose the right one for each hint
					for (MappingHint mappingHint : mappingHints) {
						compoundCommand.append(new CreateChildCommand(this.editingDomain, mappingHintGroups.get(0),
								MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS, mappingHint, null));
					}

					// second, create a command to import it to the pamtram model
					Command createMappingCommand = new CreateChildCommand(this.editingDomain,
							this.one.getMappingModel(), PamtramPackage.Literals.MAPPING_MODEL__MAPPING, mapping, null);
					compoundCommand.append(createMappingCommand);
				}

			} catch (IOException | RuntimeException e) {
				e.printStackTrace();
				return false;
			}
		}

		// execute the command to import all library items at once
		this.editingDomain.getCommandStack().execute(compoundCommand);

		return true;
	}

}
