/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 *
 */
package pamtram.contentadapter;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.part.FileEditorInput;

import de.mfreund.pamtram.properties.PropertySupplier;
import de.tud.et.ifa.agtele.genlibrary.LibraryImplementationRegistry;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryContext;
import de.tud.et.ifa.agtele.ui.util.UIHelper;
import pamtram.PamtramPackage;
import pamtram.TargetSectionModel;

/**
 * A {@link PamtramChildContentAdapter} that automatically assigns the 'PAMTraM
 * Library Nature' to a project if the user creates a {@link TargetSectionModel}
 * with an {@link EPackage} for which a GenLibrary implementation is registered
 * in the {@link LibraryImplementationRegistry}. Additionally, a {@link Control}
 * may be passed that shall be made {@link Control#setVisible(boolean)} when the
 * nature is assigned.
 *
 * @author mfreund
 */
public class LibraryNatureListenerAdapter extends PamtramChildContentAdapter {

	/**
	 * The {@link Control} that shall be made
	 * {@link Control#setVisible(boolean)} when the nature is assigned.
	 */
	protected Control controlToShow;

	/**
	 * This create an instance.
	 *
	 * @param parentAdapter
	 *            The parent {@link PamtramContentAdapter} that will manage this
	 *            as one of its child adapters.
	 */
	public LibraryNatureListenerAdapter(PamtramContentAdapter parentAdapter) {
		this(parentAdapter, null);
	}

	/**
	 * This create an instance.
	 *
	 * @param parentAdapter
	 *            The parent {@link PamtramContentAdapter} that will manage this
	 *            as one of its child adapters.
	 * @param controlToShow
	 *            The {@link Control} that shall be made
	 *            {@link Control#setVisible(boolean)} when the nature is
	 *            assigned.
	 */
	public LibraryNatureListenerAdapter(PamtramContentAdapter parentAdapter, Control controlToShow) {
		super(parentAdapter);
		this.controlToShow = controlToShow;
	}

	@Override
	public void notifyChanged(Notification n) {

		if (n.getFeature().equals(PamtramPackage.Literals.SECTION_MODEL__META_MODEL_PACKAGE)
				&& n.getEventType() == Notification.SET && n.getNewValue() instanceof EPackage
				&& this.parentAdapter.getEditor().getEditorInput() instanceof FileEditorInput) {

			try {
				IProject project = ((FileEditorInput) this.parentAdapter.getEditor().getEditorInput()).getFile()
						.getProject();
				IProjectDescription projectDescription = project == null ? null : project.getDescription();

				if (project == null || projectDescription == null
						|| !projectDescription.hasNature("de.mfreund.pamtram.pamtramNature")
						|| projectDescription.hasNature("de.mfreund.pamtram.pamtramLibraryNature")) {
					return;
				}

				// Check if there is an registered GenLibrary implementation
				// for the namespaceURI of the new EPackage
				//
				EPackage p = (EPackage) n.getNewValue();
				LibraryContext libraryContextImplementation = LibraryImplementationRegistry.getInstance()
						.getLibraryContextImplementation(p.getNsURI());

				if (libraryContextImplementation != null) {

					// Ask the user if he wants to assign the 'PAMTraM Library
					// Nature'
					//
					boolean assignNature = MessageDialog.openQuestion(UIHelper.getShell(),
							"Assign PAMTraM Library Nature",
							"There is a registered GenLibrary implementation for this EPackage. Do you want to "
									+ "assign the 'PAMTraM Library Nature' to this project? Choosing 'Yes' allows "
									+ "you to use LibraryEntries as TargetSections for Mappings. You can change "
									+ "this setting manually later on via the PAMTraM property settings...");

					if (!assignNature) {
						return;
					}

					// Add the nature to the project
					//
					PropertySupplier.setResourceProperty(PropertySupplier.PROP_HAS_LIBRARY_NATURE, String.valueOf(true),
							project);

					// Make the 'controlToShow' visible
					//
					if (this.controlToShow != null) {
						this.controlToShow.setVisible(true);
					}
				}

			} catch (CoreException e) {
				e.printStackTrace();
				return;
			}
		}
	}
}
