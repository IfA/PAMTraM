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
package de.mfreund.gentrans.transformation.resolving.wizards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPath;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import pamtram.structure.target.TargetSection;

/**
 * A {@link GenericSelectionDialog} that enables the user to select a 'class' (of type <em>T</em>) as well as an
 * '{@link EObjectWrapper instance}' to be used.
 * <p />
 * This is used during step 3 and 4 of the generic transformation when multiple possible {@link EClassConnectionPath
 * ModelConnectionPaths}/{@link TargetSection TargetSections} and corresponding instances exist.
 *
 * @param <T>
 *            The 'class' of the elements that will be returned by the dialog after the user's selection.
 */
public class ClassAndInstanceSelectorDialog<T> extends GenericSelectionDialog<T> {

	/**
	 * This keeps track of the instances the can be selected for each of the possible {@link #options}.
	 */
	protected final Map<T, List<EObjectWrapper>> instanceOptions;

	/**
	 * The instances that have been selected by the user.
	 */
	protected List<EObjectWrapper> selectedInstances;

	/**
	 * Create the dialog.
	 *
	 * @param message
	 *            The message that shall be displayed in the dialog.
	 * @param options
	 *            A map that describes the options that can be chosen by the user.
	 * @param multiSelectionAllowed
	 *            Whether multi-selection shall be allowed in the dialog.
	 * @param enhanceMappingModelListener
	 *            An optional {@link SelectionListener2} that will be called when the <em>EnhanceMappingModelButton</em>
	 *            is clicked. If no listener is given, the button will be grayed out.
	 */
	public ClassAndInstanceSelectorDialog(String message, Map<T, List<EObjectWrapper>> options,
			boolean multiSelectionAllowed, Optional<SelectionListener2> enhanceMappingModelListener) {

		super(message, new ArrayList<>(options.keySet()), multiSelectionAllowed, enhanceMappingModelListener);

		this.instanceOptions = options;

		this.selectedInstances = Arrays.asList(options.entrySet().iterator().next().getValue().get(0));
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void createInnerContents(Composite container) {

		// Create the sash form that will contain the two lists for paths and instances
		//
		SashForm sashForm = new SashForm(container, SWT.NONE);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).minSize(400, 200).applyTo(sashForm);

		// Create the list viewer for the list of types
		//
		ListViewer pathListViewer = this.createListViewer(sashForm, this.getGroupText(), false);

		// Create the list viewer for the list of instances
		//
		ListViewer instanceListViewer = this.createListViewer(sashForm, this.getInstanceGroupText(),
				this.multiSelectionAllowed);

		pathListViewer.addSelectionChangedListener(event -> {
			T selectedType = (T) pathListViewer.getStructuredSelection().getFirstElement();
			this.selectedItems = Arrays.asList(selectedType);
			List<EObjectWrapper> newInstancesToSelectFrom = this.instanceOptions.get(selectedType);
			instanceListViewer.setInput(newInstancesToSelectFrom);
		});

		pathListViewer.setInput(this.instanceOptions.keySet());

		instanceListViewer.addDoubleClickListener((IDoubleClickListener) e -> {
			this.setReturnCode(IDialogConstants.OK_ID);
			this.close();
		});

		instanceListViewer.addSelectionChangedListener(
				event -> this.selectedInstances = instanceListViewer.getStructuredSelection().toList());

		instanceListViewer.setInput(this.instanceOptions.entrySet().iterator().next().getValue());

		sashForm.setWeights(new int[] { 50, 50 });
	}

	/**
	 * Get the single selected instance after the dialog has been closed.
	 * <p />
	 * Note: This will return the first selected instance in case {@link GenericSelectionDialog#multiSelectionAllowed
	 * multi-selection} was allowed and the user selected multiple instances.
	 *
	 * @return selected instance
	 */
	public EObjectWrapper getSingleInstance() {

		return this.selectedInstances == null || this.selectedInstances.isEmpty() ? null
				: this.selectedInstances.iterator().next();

	}

	/**
	 * Get the selected instances after the dialog has been closed.
	 *
	 * @return The instances that have been selected by the user.
	 */
	public List<EObjectWrapper> getInstances() {

		return this.selectedInstances;
	}

	/**
	 * Return the group text for the {@link #createListViewer(Composite, Optional, boolean) instance list viewer}
	 * created as part of {@link #createInnerContents(Composite)}.
	 *
	 * @return The group text or an empty optional if no {@link Group} shall be created.
	 */
	protected Optional<String> getInstanceGroupText() {

		return Optional.of("Possible Instances:");
	}

}
