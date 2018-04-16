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
package de.mfreund.pamtram.ui.properties;

import java.io.File;
import java.util.Arrays;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.dialogs.PropertyPage;
import org.eclipse.wb.swt.SWTResourceManager;

import de.mfreund.pamtram.properties.PropertySupplier;
import de.tud.et.ifa.agtele.ui.listeners.KeyPressedListener;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;

/**
 * A {@link PropertyPage} to display the properties for a PAMTraM project.
 *
 * @author mfreund
 */
public class PropertiesPage extends PropertyPage implements IWorkbenchPropertyPage {

	/**
	 * The {@link FileFieldEditor} that allows the user to select new library locations.
	 */
	private DirectoryFieldEditor libraryPathSelector;

	/**
	 * This displays all selected library paths to the user.
	 */
	private List libraryPathList;

	protected Button libNatureButton;

	private Group libraryPathsGroup;

	private Composite directoryEditorComposite;

	private Button delSourceFileButton;

	private Button upSourceFileButton;

	private Button downSourceFileButton;

	private ScrolledComposite scrolledComposite;

	private Composite comp;

	@Override
	protected Control createContents(Composite parent) {

		// a composite to host all other controls
		//
		this.comp = new Composite(parent, SWT.NONE);
		GridLayoutFactory.swtDefaults().numColumns(2).equalWidth(true).applyTo(this.comp);
		this.comp.setFont(parent.getFont());

		this.libNatureButton = new Button(this.comp, SWT.CHECK);
		this.libNatureButton.setEnabled(true);
		this.libNatureButton.setText("Enable PAMTraM Library Nature");
		this.libNatureButton.setToolTipText(
				"Enable the Library Nature to be able to use LibraryEntries as TargetSections for Mappings.");
		this.libNatureButton.addSelectionListener((SelectionListener2) e -> PropertiesPage.this.updateApplyButton());

		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).span(2, 1)
				.applyTo(this.libNatureButton);

		// a group to configure all libraries that are to be used
		//
		this.libraryPathsGroup = new Group(this.comp, SWT.NONE);
		this.libraryPathsGroup.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		this.libraryPathsGroup.setText("Library Location(s)");
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).span(2, 1)
				.applyTo(this.libraryPathsGroup);
		GridLayoutFactory.swtDefaults().numColumns(3).applyTo(this.libraryPathsGroup);

		this.directoryEditorComposite = new Composite(this.libraryPathsGroup, SWT.NONE);
		this.directoryEditorComposite.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).span(3, 1)
				.applyTo(this.directoryEditorComposite);
		GridLayoutFactory.swtDefaults().numColumns(3).applyTo(this.directoryEditorComposite);

		// create drop-down list for the source file selection (based on the
		// project)
		//
		this.libraryPathSelector = new DirectoryFieldEditor("libraryPathSelect", "Add Library Location:",
				this.directoryEditorComposite);
		this.libraryPathSelector.setPropertyChangeListener(e -> this.handleAddLibrarySelected());

		// a composite to display the selected source files as well as buttons
		// to add/remove/reorder files
		//
		this.scrolledComposite = new ScrolledComposite(this.libraryPathsGroup, SWT.V_SCROLL);
		this.scrolledComposite.setExpandHorizontal(true);
		this.scrolledComposite.setExpandVertical(true);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).span(2, 3)
				.applyTo(this.scrolledComposite);

		// a list to display the selected source files
		//
		this.libraryPathList = new List(this.scrolledComposite, SWT.BORDER | SWT.V_SCROLL | SWT.MULTI);
		this.libraryPathList.addKeyListener((KeyPressedListener) e -> {
			if (e.keyCode == SWT.DEL && this.libraryPathList.getSelectionIndex() != -1) {

				this.handleDelLibraryButtonPressed();
			}
		});
		this.scrolledComposite.setContent(this.libraryPathList);
		this.scrolledComposite.setMinSize(this.libraryPathList.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		// a button that allows to delete elements from the 'sourceFileList'
		//
		this.delSourceFileButton = new Button(this.libraryPathsGroup, SWT.NONE);
		this.delSourceFileButton.setText("Del...");
		this.delSourceFileButton.addSelectionListener((SelectionListener2) e -> this.handleDelLibraryButtonPressed());
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).applyTo(this.delSourceFileButton);

		// a button that allows to move elements up in the 'sourceFileList'
		//
		this.upSourceFileButton = new Button(this.libraryPathsGroup, SWT.NONE);
		this.upSourceFileButton.setText("Up...");
		this.upSourceFileButton.addSelectionListener((SelectionListener2) e -> this.handleUpLibraryButtonPressed());
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).applyTo(this.upSourceFileButton);

		// a button that allows to move elements down in the 'sourceFileList'
		//
		this.downSourceFileButton = new Button(this.libraryPathsGroup, SWT.NONE);
		this.downSourceFileButton.setText("Down...");
		this.downSourceFileButton.addSelectionListener((SelectionListener2) e -> this.handleDownLibraryButtonPressed());
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).applyTo(this.downSourceFileButton);

		// Finally, initialize all properties.
		//
		this.initializeValues();
		this.initDataBindings();

		return this.comp;
	}

	@Override
	public boolean performOk() {

		if (this.isValid()) {
			return super.performOk() && this.storeValues();
		} else {
			return false;
		}
	}

	/**
	 * This persists the specified properties.
	 *
	 * @return <em>True</em> if everything went well, <em>false</em> otherwise.
	 */
	private boolean storeValues() {

		IProject project = (IProject) this.getElement();

		try {
			// Add/Remove the 'PAMTram Library Nature'
			PropertySupplier.setResourceProperty(PropertySupplier.PROP_HAS_LIBRARY_NATURE,
					String.valueOf(this.libNatureButton.getSelection()), project);

			// Set the library paths
			//
			PropertySupplier.setResourceProperty(PropertySupplier.PROP_LIBRARY_PATHS,
					String.join(";", this.libraryPathList.getItems()), project);

		} catch (CoreException e) {
			this.setErrorMessage(e.getMessage());
			return false;
		}

		this.updateApplyButton();

		return true;
	}

	@Override
	protected void performDefaults() {

		super.performDefaults();

		/*
		 * Initialize the text fields with the default values.
		 */
		this.libraryPathList.setItems(PropertySupplier.DEFAULT_LIBRARY_PATHS.split(";"));
	}

	/**
	 * This initializes the properties page from the persisted properties.
	 *
	 * @return <em>True</em> if everything went well, <em>false</em> otherwise.
	 */
	private boolean initializeValues() {

		IProject project = ((IResource) this.getElement()).getProject();

		try {
			this.libNatureButton.setSelection(Boolean.parseBoolean(
					PropertySupplier.getResourceProperty(PropertySupplier.PROP_HAS_LIBRARY_NATURE, project)));
			if (!PropertySupplier.getResourceProperty(PropertySupplier.PROP_LIBRARY_PATHS, project).isEmpty()) {
				this.libraryPathList.setItems(
						PropertySupplier.getResourceProperty(PropertySupplier.PROP_LIBRARY_PATHS, project).split(";"));
			}
		} catch (CoreException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * This validates the properties page.
	 *
	 * @return <em>True</em> if everything went well, <em>false</em> otherwise.
	 */
	@Override
	public boolean isValid() {

		this.setErrorMessage(null);

		// validate the specified library paths
		//
		java.util.List<String> libraryPaths = Arrays.asList(this.libraryPathList.getItems());

		if (!this.libNatureButton.getSelection() || libraryPaths.isEmpty()) {
			// do nothing as this is not necessary if no library entries are
			// used
			return true;
		}

		for (String libraryPath : libraryPaths) {

			if (!new File(libraryPath).exists()) {
				this.setErrorMessage("Library path '" + libraryPath + "' does not exist!");
				return false;
			} else if (!new File(libraryPath).isDirectory()) {
				this.setErrorMessage("Library path '" + libraryPath + "' does not represent a folder!");
				return false;
			}
		}

		return true;
	}

	/**
	 * Add the file specified in the {@link #libraryPathSelector} to the {@link #libraryPathList}.
	 */
	private void handleAddLibrarySelected() {

		if (this.libraryPathSelector.getStringValue().isEmpty()) {
			return;
		}

		this.libraryPathList.add(this.libraryPathSelector.getStringValue());
		this.libraryPathList.deselectAll();
		this.libraryPathList.select(this.libraryPathList.getItemCount() - 1);
		this.libraryPathSelector.setStringValue(null);

		this.updateApplyButton();
	}

	/**
	 * Delete all elements that are selected in the {@link #libraryPathList}.
	 */
	private void handleDelLibraryButtonPressed() {

		int selected = this.libraryPathList.getSelectionIndex();
		this.libraryPathList.remove(this.libraryPathList.getSelectionIndices());
		this.libraryPathList
				.select(selected > this.libraryPathList.getItemCount() - 1 ? this.libraryPathList.getItemCount() - 1
						: selected);

		this.updateApplyButton();
	}

	/**
	 * Move all elements that are selected in the {@link #libraryPathList} up.
	 */
	private void handleUpLibraryButtonPressed() {

		for (int selected : this.libraryPathList.getSelectionIndices()) {
			if (selected == 0) {
				return;
			}
			String[] items = this.libraryPathList.getItems();
			String prevItem = this.libraryPathList.getItem(selected - 1);
			items[selected - 1] = this.libraryPathList.getItem(selected);
			items[selected] = prevItem;
			int[] currentSel = this.libraryPathList.getSelectionIndices();
			this.libraryPathList.setItems(items);
			this.libraryPathList.select(currentSel);
			this.libraryPathList.deselect(selected);
			this.libraryPathList.select(selected - 1);
		}

		this.updateApplyButton();

	}

	/**
	 * Move all elements that are selected in the {@link #libraryPathList} down.
	 */
	private void handleDownLibraryButtonPressed() {

		int[] selections = this.libraryPathList.getSelectionIndices();
		for (int i = selections.length - 1; i >= 0; i--) {
			int sel = selections[i];
			if (sel == this.libraryPathList.getItemCount() - 1) {
				return;
			}
			String[] items = this.libraryPathList.getItems();
			String nextItem = this.libraryPathList.getItem(sel + 1);
			items[sel + 1] = this.libraryPathList.getItem(sel);
			items[sel] = nextItem;
			int[] currentSel = this.libraryPathList.getSelectionIndices();
			this.libraryPathList.setItems(items);
			this.libraryPathList.select(currentSel);
			this.libraryPathList.deselect(sel);
			this.libraryPathList.select(sel + 1);
		}

		this.updateApplyButton();

	}

	protected DataBindingContext initDataBindings() {

		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue<?> observeEnabledDirectoryEditorCompositeObserveWidget = WidgetProperties.enabled()
				.observe(this.directoryEditorComposite);
		IObservableValue<?> observeSelectionLibNatureButtonObserveWidget = WidgetProperties.selection()
				.observe(this.libNatureButton);
		bindingContext.bindValue(observeEnabledDirectoryEditorCompositeObserveWidget,
				observeSelectionLibNatureButtonObserveWidget, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER),
				null);
		//
		IObservableValue<?> observeEnabledDelSourceFileButtonObserveWidget = WidgetProperties.enabled()
				.observe(this.delSourceFileButton);
		IObservableValue<?> observeSelectionLibNatureButtonObserveWidget_1 = WidgetProperties.selection()
				.observe(this.libNatureButton);
		bindingContext.bindValue(observeEnabledDelSourceFileButtonObserveWidget,
				observeSelectionLibNatureButtonObserveWidget_1,
				new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue<?> observeSelectionUpSourceFileButtonObserveWidget = WidgetProperties.enabled()
				.observe(this.upSourceFileButton);
		IObservableValue<?> observeSelectionLibNatureButtonObserveWidget_2 = WidgetProperties.selection()
				.observe(this.libNatureButton);
		bindingContext.bindValue(observeSelectionUpSourceFileButtonObserveWidget,
				observeSelectionLibNatureButtonObserveWidget_2,
				new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue<?> observeSelectionDownSourceFileButtonObserveWidget = WidgetProperties.enabled()
				.observe(this.downSourceFileButton);
		IObservableValue<?> observeSelectionLibNatureButtonObserveWidget_3 = WidgetProperties.selection()
				.observe(this.libNatureButton);
		bindingContext.bindValue(observeSelectionDownSourceFileButtonObserveWidget,
				observeSelectionLibNatureButtonObserveWidget_3,
				new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue<?> observeEnabledScrolledCompositeObserveWidget = WidgetProperties.enabled()
				.observe(this.scrolledComposite);
		IObservableValue<?> observeSelectionLibNatureButtonObserveWidget_4 = WidgetProperties.selection()
				.observe(this.libNatureButton);
		bindingContext.bindValue(observeEnabledScrolledCompositeObserveWidget,
				observeSelectionLibNatureButtonObserveWidget_4,
				new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue<?> observeEnabledCompObserveWidget = WidgetProperties.enabled()
				.observe(this.libraryPathsGroup);
		IObservableValue<?> selectionLibNatureButtonObserveValue = WidgetProperties.selection()
				.observe(this.libNatureButton);
		bindingContext.bindValue(observeEnabledCompObserveWidget, selectionLibNatureButtonObserveValue,
				new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		return bindingContext;
	}
}
