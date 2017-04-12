package de.mfreund.pamtram.ui.properties;

import java.io.File;
import java.util.Arrays;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
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
	 * The {@link FileFieldEditor} that allows the user to select new library
	 * locations.
	 */
	private DirectoryFieldEditor libraryPathSelector;

	/**
	 * This displays all selected library paths to the user.
	 */
	private List libraryPathList;

	@Override
	protected Control createContents(Composite parent) {

		// a composite to host all other controls
		//
		Composite comp = new Composite(parent, SWT.NONE);
		GridLayoutFactory.swtDefaults().numColumns(2).equalWidth(true).applyTo(comp);
		comp.setFont(parent.getFont());

		// a group to confiure all libraries that are to be used
		//
		Group libraryPathsGroup = new Group(comp, SWT.NONE);
		libraryPathsGroup.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		libraryPathsGroup.setText("Library Location(s)");
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).span(2, 1)
				.applyTo(libraryPathsGroup);
		GridLayoutFactory.swtDefaults().numColumns(3).applyTo(libraryPathsGroup);

		Composite directoryEditorComposite = new Composite(libraryPathsGroup, SWT.NONE);
		directoryEditorComposite.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).span(3, 1)
				.applyTo(directoryEditorComposite);
		GridLayoutFactory.swtDefaults().numColumns(3).applyTo(directoryEditorComposite);

		// create drop-down list for the source file selection (based on the
		// project)
		//
		this.libraryPathSelector = new DirectoryFieldEditor("libraryPathSelect", "Add Library Location:",
				directoryEditorComposite);
		this.libraryPathSelector.setPropertyChangeListener(e -> this.handleAddLibrarySelected());

		// a composite to display the selected source files as well as buttons
		// to add/remove/reorder files
		//
		ScrolledComposite scrolledComposite = new ScrolledComposite(libraryPathsGroup, SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).span(2, 3).applyTo(scrolledComposite);

		// a list to display the selected source files
		//
		this.libraryPathList = new List(scrolledComposite, SWT.BORDER | SWT.V_SCROLL | SWT.MULTI);
		this.libraryPathList.addKeyListener((KeyPressedListener) e -> {
			if (e.keyCode == SWT.DEL && this.libraryPathList.getSelectionIndex() != -1) {

				this.handleDelLibraryButtonPressed();
			}
		});
		scrolledComposite.setContent(this.libraryPathList);
		scrolledComposite.setMinSize(this.libraryPathList.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		// a button that allows to delete elements from the 'sourceFileList'
		//
		Button delSourceFileButton = new Button(libraryPathsGroup, SWT.NONE);
		delSourceFileButton.setText("Del...");
		delSourceFileButton.addSelectionListener((SelectionListener2) e -> this.handleDelLibraryButtonPressed());
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).applyTo(delSourceFileButton);

		// a button that allows to move elements up in the 'sourceFileList'
		//
		Button upSourceFileButton = new Button(libraryPathsGroup, SWT.NONE);
		upSourceFileButton.setText("Up...");
		upSourceFileButton.addSelectionListener((SelectionListener2) e -> this.handleUpLibraryButtonPressed());
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).applyTo(upSourceFileButton);

		// a button that allows to move elements down in the 'sourceFileList'
		//
		Button downSourceFileButton = new Button(libraryPathsGroup, SWT.NONE);
		downSourceFileButton.setText("Down...");
		downSourceFileButton.addSelectionListener((SelectionListener2) e -> this.handleDownLibraryButtonPressed());
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).applyTo(downSourceFileButton);

		// Finally, initialize all properties.
		//
		this.initializeValues();

		return comp;
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

		IResource resource = (IResource) this.getElement();
		try {
			resource.setPersistentProperty(
					new QualifiedName(PropertySupplier.PROPERTY_QUALIFIER, PropertySupplier.PROP_LIBRARY_PATHS),
					String.join(";", this.libraryPathList.getItems()));
		} catch (CoreException e) {
			e.printStackTrace();
			return false;
		}
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

		IResource resource = (IResource) this.getElement();

		try {
			this.libraryPathList.setItems(
					PropertySupplier.getResourceProperty(PropertySupplier.PROP_LIBRARY_PATHS, resource).split(";"));
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

		if (libraryPaths.isEmpty()) {
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
	 * Add the file specified in the {@link #libraryPathSelector} to the
	 * {@link #libraryPathList}.
	 */
	private void handleAddLibrarySelected() {

		if (this.libraryPathSelector.getStringValue().isEmpty()) {
			return;
		}

		this.libraryPathList.add(this.libraryPathSelector.getStringValue());
		this.libraryPathList.deselectAll();
		this.libraryPathList.select(this.libraryPathList.getItemCount() - 1);
		this.libraryPathSelector.setStringValue(null);
	}

	/**
	 * Delete all elements that are selected in the {@link #libraryPathList}.
	 */
	private void handleDelLibraryButtonPressed() {

		int selected = this.libraryPathList.getSelectionIndex();
		this.libraryPathList.remove(this.libraryPathList.getSelectionIndices());
		this.libraryPathList.select(selected > this.libraryPathList.getItemCount() - 1
				? this.libraryPathList.getItemCount() - 1 : selected);
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

	}
}
