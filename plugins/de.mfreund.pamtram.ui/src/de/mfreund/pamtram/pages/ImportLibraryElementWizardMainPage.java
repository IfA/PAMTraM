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
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;

import de.mfreund.pamtram.util.SelectionListener2;
import de.tud.et.ifa.agtele.genlibrary.util.impl.FileParserImpl;
import de.tud.et.ifa.agtele.genlibrary.util.interfaces.FileParser;
import de.tud.et.ifa.agtele.genlibrary.util.interfaces.LibraryFileEntry;
import pamtram.MappingModel;
import pamtram.PAMTraM;
import pamtram.TargetSectionModel;
import pamtram.mapping.Mapping;
import pamtram.metamodel.LibraryEntry;

/**
 * This page allows to specify (1) a library (represented by a Zip file) and
 * (2) one or multiple items from the library that shall be imported into a 
 * pamtram model.
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
	 * This return the path to the library file from which the entries shall
	 * be imported.
	 * @return The path to the library file.
	 */
	public String getLibraryFile() {
		return libraryFile;
	}

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
	 * This returns the list of library entries that shall be imported from the
	 * library.
	 * @return The list of library entries to be imported from the library.
	 */
	public List<LibraryFileEntry> getLibEntriesToImport() {
		return libEntriesToImport;
	}

	/**
	 * This is the {@link TargetSectionModel} into that the LibraryEntry shall be imported.
	 */
	private TargetSectionModel targetSectionModel;

	/**
	 * This returns the {@link TargetSectionModel} into that the LibraryEntry shall be imported.
	 * @return The {@link TargetSectionModel} into that the LibraryEntry shall be imported.
	 */
	public TargetSectionModel getTargetSectionModel() {
		return this.targetSectionModel;
	}

	/**
	 * This is the {@link MappingModel} into that the {@link Mapping} for the LibraryEntry shall be imported.
	 */
	private MappingModel mappingModel;

	/**
	 * This returns the {@link MappingModel} into that the {@link Mapping} for the LibraryEntry shall be imported.
	 * @return The {@link MappingModel} into that the {@link Mapping} for the LibraryEntry shall be imported.
	 */
	public MappingModel getMappingModel() {
		return this.mappingModel;
	}

	/**
	 * The wizard page.
	 */
	final private ImportLibraryElementWizardMainPage page;

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

	private boolean createMappings = true;

	/**
	 * This is the list displaying the possible TargetSectionModels where the LibraryEntry shall be instantiated.
	 */
	private org.eclipse.swt.widgets.List targetModelSelectionList;

	/**
	 * This is the list displaying the possible MappingModels where Mapping for the LibraryEntry shall be instantiated.
	 */
	private org.eclipse.swt.widgets.List mappingModelSelectionList;

	/**
	 * This is the {@link PAMTraM} instance into that the LibraryEntry shall be imported.
	 */
	private PAMTraM pamtram;

	public boolean isCreateMappings() {
		return createMappings;
	}

	public void setCreateMappings(boolean createMappings) {
		this.createMappings = createMappings;
		mappingModelSelectionList.setEnabled(createMappings);
		getContainer().updateButtons();
	}

	public ImportLibraryElementWizardMainPage(PAMTraM pamtram) {
		super("Import Library Elements");
		this.setMessage("Please specify the library elements to import...");
		this.fileParser = new FileParserImpl();
		this.pamtram = pamtram;
		this.page = this;
	}

	@Override
	public void createControl(Composite parent) {

		Composite container = new Composite (parent, SWT.NONE);
		container.setLayout (new GridLayout (3, false));
		container.setLayoutData (new GridData (GridData.HORIZONTAL_ALIGN_FILL));

		// create a file selector for the source file
		libraryFileFieldEditor = 
				new FileFieldEditor("libFileSelect", "", container);
		libraryFileFieldEditor.setLabelText("Library File:");
		// set the allowed file extensions
		libraryFileFieldEditor.setFileExtensions(new String[]{"*.zip", "*.jar"});
		// create the listener that updates the buttons
		libraryFileFieldListener = new IPropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent event) {

				libraryFile = libraryFileFieldEditor.getStringValue();

				// reset the UI
				libEntryMap = new HashMap<>();
				page.setErrorMessage(null);

				try {
					if(!libraryFile.isEmpty()) {
						List<LibraryFileEntry> entries = fileParser.parseFile((new File(libraryFile)).toPath());
						for (LibraryFileEntry libraryFileEntry : entries) {
							libEntryMap.put(libraryFileEntry.getKey(), libraryFileEntry);
						}
					}

				} catch (IOException e) {
					page.setErrorMessage(e.getMessage());
					e.printStackTrace();
				} finally {

					// clear the list of entries selected by the user
					libEntriesToImport.clear();

					// update the list of entries
					updateEntryList();

					getContainer().updateButtons();
				}
			}
		};

		// create the list that will display the library entries
		list = new org.eclipse.swt.widgets.List (container, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		list.setEnabled(false);
		GridDataFactory.swtDefaults().span(3, 1).grab(true, true).align(SWT.FILL, SWT.FILL).applyTo(list);

		// this listener updates the list of selected library entries
		list.addListener (SWT.Selection, new Listener () {
			@Override
			public void handleEvent (Event e) {

				String[] selection = list.getSelection();
				libEntriesToImport = new ArrayList<>();
				for (String element : selection) {
					libEntriesToImport.add(libEntryMap.get(element));
				}

				getContainer().updateButtons();
			}
		});

		// create the check box that enables automatic generation of mappings for library entries
		createMappingButton = new Button(container, SWT.CHECK);
		createMappingButton.setSelection(true);
		GridDataFactory.swtDefaults().span(3, 1).align(GridData.FILL, GridData.BEGINNING);
		createMappingButton.setText("Create Mapping(s)");
		createMappingButton.setToolTipText("If activated, a mapping will be automatically created for every selected library entry...");

		// create the listener for the check box
		createMappingButtonListener = new SelectionListener2() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setCreateMappings(createMappingButton.getSelection());
			}
		};

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
		targetModelSelectionList = new org.eclipse.swt.widgets.List(container, SWT.NONE);
		targetModelSelectionList.setToolTipText("Please specify the TargetSectionModel into that the LibraryEntry shall be added..."); 
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		targetModelSelectionList.setLayoutData(gd);
		if(pamtram != null) {
			for (TargetSectionModel targetSectionModel : pamtram.getTargetSectionModel()) {
				targetModelSelectionList.add("TargetSectionModel " + (targetSectionModel.getName() != null ? targetSectionModel.getName() : ""));
			}
		}
		targetModelSelectionList.addSelectionListener(new SelectionListener2() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if(pamtram == null) {
					targetSectionModel = null;
				} else {
					targetSectionModel = pamtram.getTargetSectionModel().get(targetModelSelectionList.getSelectionIndex());


				}
				getContainer().updateButtons();
			}
		});


		// list for selecting the target MappingModel
		mappingModelSelectionList = new org.eclipse.swt.widgets.List(container, SWT.NONE);
		mappingModelSelectionList.setToolTipText("Please specify the MappingModel into that the generated Mapping for the LibraryEntry shall be added..."); 
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 1;
		mappingModelSelectionList.setLayoutData(gd);
		if(pamtram != null) {
			for (MappingModel mappingModel : pamtram.getMappingModel()) {
				mappingModelSelectionList.add("MappingModel " + (mappingModel.getName() != null ? mappingModel.getName() : ""));
			}
		}
		mappingModelSelectionList.addSelectionListener(new SelectionListener2() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if(pamtram == null) {
					mappingModel = null;
				} else {
					mappingModel = pamtram.getMappingModel().get(mappingModelSelectionList.getSelectionIndex());


				}
				getContainer().updateButtons();
			}
		});

		setControl(container);
		setPageComplete(false);
	}

	/**
	 * This updates the list displaying the entries in the selected library.
	 */
	private void updateEntryList() {

		// clear the list
		list.removeAll();
		list.setEnabled(false);

		if(libEntryMap == null) {
			return;
		}

		// add the new entries to the list
		for (String libraryFileEntry : libEntryMap.keySet()) {
			list.add(libraryFileEntry);
		}
		list.setEnabled(true);
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if(visible) {
			// add necessary listeners
			libraryFileFieldEditor.setPropertyChangeListener(libraryFileFieldListener);
			createMappingButton.addSelectionListener(createMappingButtonListener);
		} else {
			// remove all listeners
			libraryFileFieldEditor.setPropertyChangeListener(null);
			createMappingButton.removeSelectionListener(createMappingButtonListener);
		}
	}

	@Override
	public boolean isPageComplete() {
		return !libEntriesToImport.isEmpty() && targetSectionModel != null && !(isCreateMappings() && mappingModel == null);
	}

}
