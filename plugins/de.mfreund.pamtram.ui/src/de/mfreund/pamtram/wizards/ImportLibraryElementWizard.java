/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.pamtram.wizards;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import de.mfreund.pamtram.pages.ImportLibraryElementWizardMainPage;
import de.tud.et.ifa.agtele.genlibrary.util.interfaces.LibraryFileEntry;
import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.commands.CreateLibraryEntryCommand;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingFactory;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.extended.AttributeMapping;
import pamtram.mapping.extended.ExtendedFactory;
import pamtram.mapping.extended.MappingHint;
import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.structure.library.AttributeParameter;
import pamtram.structure.library.ContainerParameter;
import pamtram.structure.library.ExternalReferenceParameter;
import pamtram.structure.library.LibraryEntry;
import pamtram.structure.library.LibraryParameter;
import pamtram.util.GenLibraryManager;
import pamtram.util.LibraryHelper;

/**
 * This {@link AbstractImportElementWizard} allows to import one or multiple
 * library elements from a library (represented by a Zip file) into a pamtram
 * model. Additionally, the user can choose to create a {@link Mapping} for each
 * imported entry.
 *
 * @author mfreund
 */
public class ImportLibraryElementWizard extends AbstractImportElementWizard {

	private final ImportLibraryElementWizardMainPage one;

	/**
	 * The {@link Viewer} where the created {@link Mapping Mappings} will be
	 * shown and selected.
	 */
	private Viewer mappingViewer;

	/**
	 * This constructs an instance of the wizard.
	 *
	 * @param pamtram
	 *            The pamtram instance into that the library elements shall be
	 *            imported.
	 * @param editingDomain
	 *            The editing domain to be used to perform model changes.
	 * @param libraryElementViewer
	 *            The {@link Viewer} where the imported {@link LibraryEntry
	 *            LibraryEntries} will be shown and selected.
	 * @param mappingViewer
	 *            The {@link Viewer} where the created {@link Mapping Mappings}
	 *            will be shown and selected.
	 */
	public ImportLibraryElementWizard(PAMTraM pamtram, EditingDomain editingDomain, Viewer libraryElementViewer,
			Viewer mappingViewer) {
		super(pamtram, editingDomain, libraryElementViewer);

		this.one = new ImportLibraryElementWizardMainPage(pamtram);
		this.mappingViewer = mappingViewer;
	}

	@Override
	public void addPages() {

		this.addPage(this.one);
	}

	@Override
	protected void createImportElementsCommand() {

		final List<EObject> createdElements = new ArrayList<>();

		CompoundCommand compoundCommand = new CompoundCommand() {
			@Override
			public Collection<?> getAffectedObjects() {
				return createdElements;
			}
		};

		// now, we import the selected library elements to the pamtram model
		for (LibraryFileEntry entry : this.one.getLibEntriesToImport()) {
			try {

				GenLibraryManager manager = new GenLibraryManager(null);

				// We simply use the parent of the chosen library file as
				// library location
				//
				String libraryLocation = new File(this.one.getLibraryFile()).getParent();
				manager.addLibPath(libraryLocation);

				// first, create the library element
				LibraryEntry libElement = LibraryHelper.convertToLibraryElement(manager,
						this.one.getTargetSectionModel().getMetaModelPackage().getNsURI(), entry.getKey());
				libElement.setLibraryFile(this.one.getLibraryFile());
				createdElements.add(libElement);

				// second, create a command to import it to the pamtram model
				Command createLibraryEntryCommand = new CreateLibraryEntryCommand(this.editingDomain,
						this.one.getTargetSectionModel(), libElement,
						this.pamtram.eResource().getURI().trimSegments(1).appendSegment("lib").appendSegment("target")
								.appendSegment(entry.getKey()).appendSegment("data.xmi"));
				compoundCommand.append(createLibraryEntryCommand);

				if (this.one.isCreateMappings()) {
					// first, create a mapping that points to the library entry
					Mapping mapping = MappingFactory.eINSTANCE.createMapping();
					createdElements.add(mapping);
					ArrayList<MappingHintGroup> mappingHintGroups = new ArrayList<>();
					ArrayList<MappingHint> mappingHints = new ArrayList<>();
					for (LibraryParameter<?> parameter : libElement.getParameters()) {
						// create a mapping hint group for every container
						// parameter
						if (parameter instanceof ContainerParameter) {
							MappingHintGroup hintGroup = MappingFactory.eINSTANCE.createMappingHintGroup();
							mappingHintGroups.add(hintGroup);
							// add the mapping hint group to the mapping
							compoundCommand.append(new CreateChildCommand(this.editingDomain, mapping,
									MappingPackage.Literals.MAPPING__MAPPING_HINT_GROUPS, hintGroup, null));
							// set the target metamodel section of the hint
							// group
							compoundCommand.append(new SetCommand(this.editingDomain, hintGroup,
									MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__TARGET_SECTION,
									((ContainerParameter) parameter).getClass_()));
						} else if (parameter instanceof ExternalReferenceParameter) {
							ReferenceTargetSelector selector = ExtendedFactory.eINSTANCE
									.createReferenceTargetSelector();
							mappingHints.add(selector);
							// set the affected reference of the mapping
							// instance selector
							selector.setAffectedReference(((ExternalReferenceParameter) parameter).getReference());
						} else if (parameter instanceof AttributeParameter) {
							AttributeMapping attMapping = ExtendedFactory.eINSTANCE.createAttributeMapping();
							mappingHints.add(attMapping);
							// set the target attribute of the attribute mapping
							attMapping.setTarget(((AttributeParameter) parameter).getAttribute());
						}
					}
					// now, we add all mapping hints to the first hint group
					// TODO if there are multiple groups, choose the right one
					// for each hint
					for (MappingHint mappingHint : mappingHints) {
						compoundCommand.append(new CreateChildCommand(this.editingDomain, mappingHintGroups.get(0),
								MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS, mappingHint, null));
					}

					// second, create a command to import it to the pamtram
					// model
					Command createMappingCommand = new CreateChildCommand(this.editingDomain,
							this.one.getMappingModel(), PamtramPackage.Literals.MAPPING_MODEL__MAPPINGS, mapping, null);
					compoundCommand.append(createMappingCommand);
				}

			} catch (IOException | RuntimeException e) {
				e.printStackTrace();
				createdElements.clear();
				this.importCommand = null;
			}
		}

		this.importCommand = compoundCommand;
	}

	@Override
	protected void selectImportedElementsInViewer() {
		super.selectImportedElementsInViewer();

		// Also select and expand created mappings
		//
		if (this.mappingViewer != null) {
			this.mappingViewer.setSelection(new StructuredSelection(this.getImportedElements()), true);
			if (this.mappingViewer instanceof TreeViewer) {
				List<Object> expanded = new ArrayList<>(
						Arrays.asList(((TreeViewer) this.mappingViewer).getExpandedElements()));
				expanded.addAll(this.getImportedElements());
				((TreeViewer) this.mappingViewer).setExpandedElements(expanded.toArray());
			}
		}
	}
}
