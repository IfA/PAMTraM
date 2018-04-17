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
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.PamtramPackage;
import pamtram.TargetSectionModel;
import pamtram.structure.library.LibraryEntry;
import pamtram.util.LibraryHelper;

/**
 * This command can be used to remove a {@link LibraryEntry} from the {@link TargetSectionModel}. The command
 * automatically handles the deletion of the {@link LibraryEntry} that is stored in a separate resource. This resource
 * is re-created when the command is undone and deleted when the command is redone.
 * 
 * @author mfreund
 *
 */
public class DeleteLibraryEntryCommand extends RemoveCommand {

	/**
	 * This is the {@link URI} that holds the original
	 * {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry} contained in the {@link LibraryEntry}.
	 */
	private URI libraryEntryUri;

	/**
	 * This creates an instance.
	 *
	 * @param domain
	 *            The {@link EditingDomain} on which to execute the command.
	 * @param owner
	 *            The {@link TargetSectionModel} that holds the {@link LibraryEntry} to be deleted.
	 * @param libraryEntry
	 *            The {@link LibraryEntry} to be deleted.
	 */
	public DeleteLibraryEntryCommand(EditingDomain domain, TargetSectionModel owner, LibraryEntry libraryEntry) {
		super(domain, owner, PamtramPackage.Literals.TARGET_SECTION_MODEL__LIBRARY_ELEMENTS, libraryEntry);
		this.domain = domain;
		this.libraryEntryUri = libraryEntry.getOriginalLibraryEntry().eResource().getURI();
	}

	@Override
	public void doExecute() {

		// first, default execute the command
		super.doExecute();

		// the resource that belongs to the original library entry to be deleted
		Resource resource = ((LibraryEntry) this.collection.iterator().next()).getOriginalLibraryEntry().eResource();
		// get the absolute path of the resource
		IPath resourcePath = ResourcesPlugin.getWorkspace().getRoot()
				.getFile(new Path(resource.getURI().toPlatformString(true))).getLocation();
		// this is the parent file of the resource (this should be a directory)
		File parent = resourcePath.toFile().getParentFile();
		try {
			// delete the resource (and thus remove it from the resource set)
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
	public void doUndo() {

		try {
			// store the original library entry in its own resource
			de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry originalLibraryEntry = ((LibraryEntry) this.collection
					.iterator().next()).getOriginalLibraryEntry();
			LibraryHelper.storeLibraryEntry(originalLibraryEntry, this.libraryEntryUri, this.domain.getResourceSet());

			// now, default redo the command
			super.doUndo();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doRedo() {

		// first, default undo the command
		super.doRedo();

		// the resource that belongs to the original library entry to be deleted
		Resource resource = ((LibraryEntry) this.collection.iterator().next()).getOriginalLibraryEntry().eResource();
		// get the absolute path of the resource
		IPath resourcePath = ResourcesPlugin.getWorkspace().getRoot()
				.getFile(new Path(resource.getURI().toPlatformString(true))).getLocation();
		// this is the parent file of the resource (this should be a directory)
		File parent = resourcePath.toFile().getParentFile();
		try {
			// delete the resource (and thus remove it from the resource set)
			new ResourceSetImpl().getResources().add(resource);
			resource.delete(null);
			System.out.println(this.domain.getResourceSet().getResources());
			// now check if we need to delete an empty directory
			if (parent.isDirectory() && parent.listFiles().length == 0) {
				parent.delete();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
