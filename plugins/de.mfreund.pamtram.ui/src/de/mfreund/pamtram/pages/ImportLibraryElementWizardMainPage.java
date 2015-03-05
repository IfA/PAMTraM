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
import org.eclipse.swt.widgets.Listener;

import pamtram.metamodel.LibraryEntry;
import de.mfreund.pamtram.util.SelectionListener2;
import de.tud.et.ifa.agtele.genlibrary.util.impl.FileParserImpl;
import de.tud.et.ifa.agtele.genlibrary.util.interfaces.FileParser;
import de.tud.et.ifa.agtele.genlibrary.util.interfaces.LibraryFileEntry;

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
	
	public boolean isCreateMappings() {
		return createMappings;
	}

	public void setCreateMappings(boolean createMappings) {
		this.createMappings = createMappings;
	}

	public ImportLibraryElementWizardMainPage() {
		super("Import Library Elements");
		this.setMessage("Please specify the library elements to import...");
		this.fileParser = new FileParserImpl();
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
		return !libEntriesToImport.isEmpty();
	}

}
