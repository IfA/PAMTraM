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
package pamtram.commands;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.PamtramPackage;
import pamtram.TargetSectionModel;
import pamtram.structure.library.LibraryEntry;
import pamtram.util.LibraryHelper;

/**
 * This command can be used to create a {@link LibraryEntry} as child of the {@link TargetSectionModel}. The command
 * automatically handles the persisting of the {@link LibraryEntry} in a separate resource. This resource is deleted
 * when the command is undone and re-created when the command is redone.
 * 
 * @author mfreund
 *
 */
public class CreateLibraryEntryCommand extends CreateChildCommand {

	/**
	 * This is the {@link URI} that shall be used to store the original
	 * {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry} contained in the {@link LibraryEntry}.
	 */
	private URI libraryEntryUri;

	/**
	 * This creates an instance.
	 *
	 * @param domain
	 *            The {@link EditingDomain} on which to execute the command.
	 * @param owner
	 *            The {@link TargetSectionModel} to which the {@link LibraryEntry} shall be added.
	 * @param libraryEntry
	 *            The {@link LibraryEntry} to be created.
	 * @param libraryEntryUri
	 *            The {@link URI} that shall be used to store the original
	 *            {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry} contained in the
	 *            {@link LibraryEntry}.
	 */
	public CreateLibraryEntryCommand(EditingDomain domain, TargetSectionModel owner, LibraryEntry libraryEntry,
			URI libraryEntryUri) {
		super(domain, owner, PamtramPackage.Literals.TARGET_SECTION_MODEL__LIBRARY_ELEMENTS, libraryEntry, null);
		this.domain = domain;
		this.libraryEntryUri = libraryEntryUri;
	}

	@Override
	public void execute() {

		try {
			// store the original library entry in its own resource
			de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry originalLibraryEntry = ((LibraryEntry) this.child)
					.getOriginalLibraryEntry();
			LibraryHelper.storeLibraryEntry(originalLibraryEntry, this.libraryEntryUri, this.domain.getResourceSet());

			// now, default execute the command
			super.execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void undo() {

		// first, default undo the command
		super.undo();

		// the resource that belongs to the original library entry to be deleted
		Resource resource = ((LibraryEntry) this.child).getOriginalLibraryEntry().eResource();
		// get the absolute path of the resource
		IPath resourcePath = ResourcesPlugin.getWorkspace().getRoot()
				.getFile(new Path(resource.getURI().toPlatformString(true))).getLocation();
		// this is the parent file of the resource (this should be a directory)
		File parent = resourcePath.toFile().getParentFile();
		try {
			// delete the resource (and thus remove it from the resource set)
			new ResourceSetImpl().getResources().add(resource);
			resource.delete(null);
			// now check if we need to delete an empty directory
			if (parent.isDirectory() && parent.listFiles().length == 0) {
				parent.delete();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void redo() {

		try {
			// store the original library entry in its own resource
			de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry originalLibraryEntry = ((LibraryEntry) this.child)
					.getOriginalLibraryEntry();
			LibraryHelper.storeLibraryEntry(originalLibraryEntry, this.libraryEntryUri, this.domain.getResourceSet());

			// now, default redo the command
			super.redo();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
