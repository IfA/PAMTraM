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
package de.mfreund.pamtram.pages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import de.tud.et.ifa.agtele.genlibrary.util.impl.FileParserImpl;
import de.tud.et.ifa.agtele.genlibrary.util.interfaces.FileParser;
import de.tud.et.ifa.agtele.genlibrary.util.interfaces.LibraryFileEntry;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import pamtram.MappingModel;
import pamtram.PAMTraM;
import pamtram.TargetSectionModel;
import pamtram.mapping.Mapping;
import pamtram.structure.library.LibraryEntry;
import pamtram.structure.target.TargetSection;

/**
 * This page allows to specify (1) a library (represented by a Zip file) and (2) one or multiple items from the library
 * that shall be imported into a pamtram model.
 *
 * @author mfreund
 */
public class ImportLibraryElementWizardMainPage extends WizardPage {

	/**
	 * A file parser for libraries.
	 */
	private FileParser fileParser;

	/**
	 * This specifies the file containing a library specified by the user.
	 */
	private String libraryFile;

	/**
	 * This is the map of library entries in the library file.
	 */
	private Map<String, LibraryFileEntry> libEntryMap;

	/**
	 * This is the list of library entries to import from the library.
	 */
	private List<LibraryFileEntry> libEntriesToImport = new ArrayList<>();

	/**
	 * This is the {@link FileFieldEditor} that contains the list of {@link LibraryEntry}s.
	 */
	private FileFieldEditor libraryFileFieldEditor;

	/**
	 * This is the listener that reacts to changes in the {@link #libraryFileFieldEditor}
	 */
	private IPropertyChangeListener libraryFileFieldListener;

	/**
	 * This is the {@link TargetSectionModel} into that the LibraryEntry shall be imported.
	 */
	private TargetSectionModel targetSectionModel;

	/**
	 * This is the {@link MappingModel} into that the {@link Mapping} for the LibraryEntry shall be imported.
	 */
	private MappingModel mappingModel;

	/**
	 * The wizard page.
	 */
	private final ImportLibraryElementWizardMainPage page;

	/**
	 * This is the list displaying the entries in the currently selected library.
	 */
	private org.eclipse.swt.widgets.List list;

	/**
	 * This is the check box that controls automatic generation of mappings.
	 */
	private Button createMappingButton;

	/**
	 * This is the listener that listens on the {@link #createMappingButton}.
	 */
	private SelectionListener2 createMappingButtonListener;

	/**
	 * Whether mappings shall be created for each created {@link TargetSection}.
	 */
	private boolean createMappings = true;

	/**
	 * This is the list displaying the possible MappingModels where Mapping for the LibraryEntry shall be instantiated.
	 */
	private org.eclipse.swt.widgets.List mappingModelSelectionList;

	/**
	 * This is the {@link PAMTraM} instance into that the LibraryEntry shall be imported.
	 */
	private PAMTraM pamtram;

	/**
	 * This creates an instance.
	 *
	 * @param pamtram
	 *            The {@link PAMTraM} instance into which the library entries shall be imported.
	 */
	public ImportLibraryElementWizardMainPage(PAMTraM pamtram) {
		super("Import Library Elements");
		this.setMessage("Please specify the library elements to import...");
		this.fileParser = new FileParserImpl();
		this.pamtram = pamtram;
		this.page = this;
	}

	/**
	 * This return the path to the library file from which the entries shall be imported.
	 *
	 * @return The path to the library file.
	 */
	public String getLibraryFile() {

		return this.libraryFile;
	}

	/**
	 * This returns the list of library entries that shall be imported from the library.
	 *
	 * @return The list of library entries to be imported from the library.
	 */
	public List<LibraryFileEntry> getLibEntriesToImport() {

		return this.libEntriesToImport;
	}

	/**
	 * This returns the {@link TargetSectionModel} into that the LibraryEntry shall be imported.
	 *
	 * @return The {@link TargetSectionModel} into that the LibraryEntry shall be imported.
	 */
	public TargetSectionModel getTargetSectionModel() {

		return this.targetSectionModel;
	}

	/**
	 * This returns the {@link MappingModel} into that the {@link Mapping} for the LibraryEntry shall be imported.
	 *
	 * @return The {@link MappingModel} into that the {@link Mapping} for the LibraryEntry shall be imported.
	 */
	public MappingModel getMappingModel() {

		return this.mappingModel;
	}

	/**
	 * This is the getter for the {@link #createMappings}.
	 *
	 * @return Whether mappings shall be created for each created {@link TargetSection}.
	 */
	public boolean isCreateMappings() {

		return this.createMappings;
	}

	/**
	 * The setter for the {@link #createMappings}.
	 *
	 * @param createMappings
	 *            Whether mappings shall be created for each created {@link TargetSection}.
	 */
	public void setCreateMappings(boolean createMappings) {

		this.createMappings = createMappings;
		this.mappingModelSelectionList.setEnabled(createMappings);
		this.getContainer().updateButtons();
	}

	@Override
	public void createControl(Composite parent) {

		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(3, false));
		container.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

		// create a file selector for the source file
		this.libraryFileFieldEditor = new FileFieldEditor("libFileSelect", "", container);
		this.libraryFileFieldEditor.setLabelText("Library File:");
		// set the allowed file extensions
		this.libraryFileFieldEditor.setFileExtensions(new String[] { "*.zip", "*.jar" });
		// create the listener that updates the buttons
		this.libraryFileFieldListener = event -> {

			ImportLibraryElementWizardMainPage.this.libraryFile = ImportLibraryElementWizardMainPage.this.libraryFileFieldEditor
					.getStringValue();

			// reset the UI
			ImportLibraryElementWizardMainPage.this.libEntryMap = new HashMap<>();
			ImportLibraryElementWizardMainPage.this.page.setErrorMessage(null);

			try {
				if (!ImportLibraryElementWizardMainPage.this.libraryFile.isEmpty()) {
					List<LibraryFileEntry> entries = ImportLibraryElementWizardMainPage.this.fileParser
							.parseFile(new File(ImportLibraryElementWizardMainPage.this.libraryFile).toPath());
					for (LibraryFileEntry libraryFileEntry : entries) {
						ImportLibraryElementWizardMainPage.this.libEntryMap.put(libraryFileEntry.getKey(),
								libraryFileEntry);
					}
				}

			} catch (IOException e) {
				ImportLibraryElementWizardMainPage.this.page.setErrorMessage(e.getMessage());
				e.printStackTrace();
			} finally {

				// clear the list of entries selected by the user
				ImportLibraryElementWizardMainPage.this.libEntriesToImport.clear();

				// update the list of entries
				ImportLibraryElementWizardMainPage.this.updateEntryList();

				ImportLibraryElementWizardMainPage.this.getContainer().updateButtons();
			}
		};

		// create the list that will display the library entries
		this.list = new org.eclipse.swt.widgets.List(container, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		this.list.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true, 1, 1));
		this.list.setEnabled(false);
		GridDataFactory.swtDefaults().span(3, 1).grab(true, true).align(SWT.FILL, SWT.FILL).applyTo(this.list);

		// this listener updates the list of selected library entries
		this.list.addListener(SWT.Selection, e -> {

			String[] selection = ImportLibraryElementWizardMainPage.this.list.getSelection();
			ImportLibraryElementWizardMainPage.this.libEntriesToImport = new ArrayList<>();
			for (String element : selection) {
				ImportLibraryElementWizardMainPage.this.libEntriesToImport
						.add(ImportLibraryElementWizardMainPage.this.libEntryMap.get(element));
			}

			ImportLibraryElementWizardMainPage.this.getContainer().updateButtons();
		});

		// create the check box that enables automatic generation of mappings for library entries
		this.createMappingButton = new Button(container, SWT.CHECK);
		this.createMappingButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		this.createMappingButton.setSelection(true);
		GridDataFactory.swtDefaults().span(3, 1).align(GridData.FILL, GridData.BEGINNING);
		this.createMappingButton.setText("Create Mapping(s)");
		this.createMappingButton.setToolTipText(
				"If activated, a mapping will be automatically created for every selected library entry...");

		// create the listener for the check box
		this.createMappingButtonListener = e -> ImportLibraryElementWizardMainPage.this
				.setCreateMappings(ImportLibraryElementWizardMainPage.this.createMappingButton.getSelection());

		// separator
		Label separator = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 3;
		separator.setLayoutData(gd);

		Label targetModelSelectionLabel = new Label(container, SWT.NONE);
		targetModelSelectionLabel.setText("Target TargetSectionModel:");
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		targetModelSelectionLabel.setLayoutData(gd);

		Label mappingModelSelectionLabel = new Label(container, SWT.NONE);
		mappingModelSelectionLabel.setText("Target MappingModel:");
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 1;
		mappingModelSelectionLabel.setLayoutData(gd);

		// list for selecting the target argetSectionModel
		org.eclipse.swt.widgets.List targetModelSelectionList = new org.eclipse.swt.widgets.List(container,
				SWT.BORDER | SWT.V_SCROLL);
		targetModelSelectionList
				.setToolTipText("Please specify the TargetSectionModel into that the LibraryEntry shall be added...");
		GridData gd1 = new GridData(GridData.FILL_HORIZONTAL);
		gd1.verticalAlignment = SWT.FILL;
		gd1.grabExcessVerticalSpace = true;
		gd1.horizontalSpan = 2;
		targetModelSelectionList.setLayoutData(gd1);

		if (this.pamtram != null) {
			this.pamtram.getTargetSectionModels().stream().forEach(model -> targetModelSelectionList
					.add("TargetSectionModel " + (model.getName() != null ? model.getName() : "")));
		}

		targetModelSelectionList.addSelectionListener((SelectionListener2) e -> {
			if (ImportLibraryElementWizardMainPage.this.pamtram == null) {
				ImportLibraryElementWizardMainPage.this.targetSectionModel = null;
			} else {
				ImportLibraryElementWizardMainPage.this.targetSectionModel = ImportLibraryElementWizardMainPage.this.pamtram
						.getTargetSectionModels().get(targetModelSelectionList.getSelectionIndex());

			}
			ImportLibraryElementWizardMainPage.this.getContainer().updateButtons();
		});

		// list for selecting the target MappingModel
		this.mappingModelSelectionList = new org.eclipse.swt.widgets.List(container, SWT.BORDER | SWT.V_SCROLL);
		this.mappingModelSelectionList.setToolTipText(
				"Please specify the MappingModel into that the generated Mapping for the LibraryEntry shall be added...");
		GridData gd2 = new GridData(GridData.FILL_HORIZONTAL);
		gd2.grabExcessVerticalSpace = true;
		gd2.verticalAlignment = SWT.FILL;
		gd2.horizontalSpan = 1;
		this.mappingModelSelectionList.setLayoutData(gd2);

		if (this.pamtram != null) {
			this.pamtram.getMappingModels().stream().forEach(model -> this.mappingModelSelectionList
					.add("MappingModel " + (model.getName() != null ? model.getName() : "")));
		}

		this.mappingModelSelectionList.addSelectionListener((SelectionListener2) e -> {
			if (ImportLibraryElementWizardMainPage.this.pamtram == null) {
				ImportLibraryElementWizardMainPage.this.mappingModel = null;
			} else {
				ImportLibraryElementWizardMainPage.this.mappingModel = ImportLibraryElementWizardMainPage.this.pamtram
						.getMappingModels()
						.get(ImportLibraryElementWizardMainPage.this.mappingModelSelectionList.getSelectionIndex());

			}
			ImportLibraryElementWizardMainPage.this.getContainer().updateButtons();
		});

		this.setControl(container);
		this.setPageComplete(false);
	}

	/**
	 * This updates the list displaying the entries in the selected library.
	 */
	private void updateEntryList() {

		// clear the list
		this.list.removeAll();
		this.list.setEnabled(false);

		if (this.libEntryMap == null) {
			return;
		}

		// add the new entries to the list
		for (String libraryFileEntry : this.libEntryMap.keySet()) {
			this.list.add(libraryFileEntry);
		}
		this.list.setEnabled(true);
	}

	@Override
	public void setVisible(boolean visible) {

		super.setVisible(visible);
		if (visible) {
			// add necessary listeners
			this.libraryFileFieldEditor.setPropertyChangeListener(this.libraryFileFieldListener);
			this.createMappingButton.addSelectionListener(this.createMappingButtonListener);
		} else {
			// remove all listeners
			this.libraryFileFieldEditor.setPropertyChangeListener(null);
			this.createMappingButton.removeSelectionListener(this.createMappingButtonListener);
		}
	}

	@Override
	public boolean isPageComplete() {

		return !this.libEntriesToImport.isEmpty() && this.targetSectionModel != null
				&& !(this.isCreateMappings() && this.mappingModel == null);
	}

}
