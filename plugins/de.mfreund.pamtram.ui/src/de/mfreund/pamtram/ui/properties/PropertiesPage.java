package de.mfreund.pamtram.ui.properties;

import java.io.File;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.dialogs.PropertyPage;

import de.mfreund.pamtram.properties.PropertySupplier;

/**
 * A {@link PropertyPage} to display the properties for a PAMTraM project.
 *
 * @author mfreund
 */
public class PropertiesPage extends PropertyPage implements IWorkbenchPropertyPage {

	/**
	 * A text field to specify the full path to the folder that holds the target library.
	 */
	private Text targetPathText;

	@Override
	protected Control createContents(Composite parent) {

		// a composite to host all other controls
		//
		Composite comp = new Composite(parent, SWT.NONE);
		GridLayoutFactory.swtDefaults().numColumns(2).equalWidth(true).applyTo(comp);
		comp.setFont(parent.getFont());

		// a group to host all library related settings
		//
		Group libraryGroup = new Group(comp, SWT.NONE);
		libraryGroup.setText("Library Properties");
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).span(2, 1).applyTo(libraryGroup);
		GridLayoutFactory.swtDefaults().numColumns(2).applyTo(libraryGroup);

		// a group to host all target related settings
		//
		Group targetGroup = new Group(libraryGroup, SWT.NONE);
		targetGroup.setText("Target");
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).span(2, 1).applyTo(targetGroup);
		GridLayoutFactory.swtDefaults().numColumns(2).applyTo(targetGroup);

		// create a label for the specification of the path to the folder that holds the target library
		//
		Label targetPathLabel = new Label(targetGroup, SWT.NONE);
		targetPathLabel.setText("Library folder path:");
		GridDataFactory.swtDefaults().applyTo(targetPathLabel);

		// create a text field for the specification of the path to the folder that holds the target library
		//
		this.targetPathText = new Text(targetGroup, SWT.NONE);
		this.targetPathText.setMessage("Full path to the folder that holds the target library");
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).applyTo(this.targetPathText);
		this.targetPathText.addModifyListener(e -> PropertiesPage.this.isValid());

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
					new QualifiedName(PropertySupplier.PROPERTY_QUALIFIER, PropertySupplier.PROP_LIBRARY_TARGET_PATH),
					this.targetPathText.getText());
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
		this.targetPathText.setText(PropertySupplier.DEFAULT_LIBRARY_TARGET_PATH);
	}

	/**
	 * This initializes the properties page from the persisted properties.
	 *
	 * @return <em>True</em> if everything went well, <em>false</em> otherwise.
	 */
	private boolean initializeValues() {

		IResource resource = (IResource) this.getElement();

		try {
			this.targetPathText
					.setText(PropertySupplier.getResourceProperty(PropertySupplier.PROP_LIBRARY_TARGET_PATH, resource));
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
		String targetLibPath = this.targetPathText.getText();
		if (targetLibPath.isEmpty()) {
			// nothing to be done
		} else if (!new File(targetLibPath).exists()) {
			this.setErrorMessage("Target library path does not exist!");
			return false;
		} else if (!new File(targetLibPath).isDirectory()) {
			this.setErrorMessage("Target library path does not represent a folder!");
			return false;
		}

		return true;
	}
}
