package de.mfreund.pamtram.ui.properties;

import java.io.File;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
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
import org.osgi.framework.Bundle;

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

	/**
	 * A text field to specify the bundle that represents the specific target library.
	 */
	private Text targetBundleText;

	/**
	 * A text field to specify the concrete library context of the specific target library.
	 */
	private Text targetLibContextText;

	/**
	 * A text field to specify the concrete library path parser of the specific target library.
	 */
	private Text targetLibParserText;

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

		// create a label for the specification of the bundle that represents the specific target library
		//
		Label targetBundleLabel = new Label(targetGroup, SWT.NONE);
		targetBundleLabel.setText("Bundle ID:");
		GridDataFactory.swtDefaults().applyTo(targetBundleLabel);

		// create a text field for the specification of the bundle that represents the specific target library
		//
		this.targetBundleText = new Text(targetGroup, SWT.NONE);
		this.targetBundleText.setMessage("Bundle identifier of the plug-in hosting the concrete LibraryContext and PathParser");
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).applyTo(this.targetBundleText);
		this.targetBundleText.addModifyListener(e -> PropertiesPage.this.isValid());

		// create a label for the specification of the concrete library context of the specific target library
		//
		Label targetLibContextLabel = new Label(targetGroup, SWT.NONE);
		targetLibContextLabel.setText("Library Context ID:");
		GridDataFactory.swtDefaults().applyTo(targetLibContextLabel);

		// create a text field for the specification of the concrete library context of the specific target library
		//
		this.targetLibContextText = new Text(targetGroup, SWT.NONE);
		this.targetLibContextText.setMessage("Fully qualified name of the concrete LibraryContext");
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).applyTo(this.targetLibContextText);
		this.targetLibContextText.addModifyListener(e -> PropertiesPage.this.isValid());

		// create a label for the specification of the concrete library path parser of the specific target library
		//
		Label targetLibParserLabel = new Label(targetGroup, SWT.NONE);
		targetLibParserLabel.setText("Library Path Parser ID:");
		GridDataFactory.swtDefaults().applyTo(targetLibParserLabel);

		// create a text field for the specification of the concrete library path parser of the specific target library
		//
		this.targetLibParserText = new Text(targetGroup, SWT.NONE);
		this.targetLibParserText.setMessage("Fully qualified name of the concrete PathParser (Leave empty to use default parser...)");
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).applyTo(this.targetLibParserText);
		this.targetLibParserText.addModifyListener(e -> PropertiesPage.this.isValid());

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
			resource.setPersistentProperty(
					new QualifiedName(PropertySupplier.PROPERTY_QUALIFIER, PropertySupplier.PROP_LIBRARY_TARGET_BUNDLE),
					this.targetBundleText.getText());
			resource.setPersistentProperty(
					new QualifiedName(PropertySupplier.PROPERTY_QUALIFIER, PropertySupplier.PROP_LIBRARY_TARGET_CONTEXT),
					this.targetLibContextText.getText());
			resource.setPersistentProperty(
					new QualifiedName(PropertySupplier.PROPERTY_QUALIFIER, PropertySupplier.PROP_LIBRARY_TARGET_PARSER),
					this.targetLibParserText.getText());
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
		this.targetBundleText.setText(PropertySupplier.DEFAULT_LIBRARY_TARGET_BUNDLE);
		this.targetLibContextText.setText(PropertySupplier.DEFAULT_LIBRARY_TARGET_CONTEXT);
		this.targetLibParserText.setText(PropertySupplier.DEFAULT_LIBRARY_TARGET_PARSER);
	}

	/**
	 * This initializes the properties page from the persisted properties.
	 *
	 * @return <em>True</em> if everything went well, <em>false</em> otherwise.
	 */
	private boolean initializeValues() {
		IResource resource = (IResource) this.getElement();

		try {
			this.targetPathText.setText(
					PropertySupplier.getResourceProperty(PropertySupplier.PROP_LIBRARY_TARGET_PATH, resource));
			this.targetBundleText.setText(
					PropertySupplier.getResourceProperty(PropertySupplier.PROP_LIBRARY_TARGET_BUNDLE, resource));
			this.targetLibContextText.setText(
					PropertySupplier.getResourceProperty(PropertySupplier.PROP_LIBRARY_TARGET_CONTEXT, resource));
			this.targetLibParserText.setText(
					PropertySupplier.getResourceProperty(PropertySupplier.PROP_LIBRARY_TARGET_PARSER, resource));
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
		if(targetLibPath.isEmpty()) {
			// nothing to be done
		} else if(!new File(targetLibPath).exists()) {
			this.setErrorMessage("Target library path does not exist!");
			return false;
		} else if(!new File(targetLibPath).isDirectory()) {
			this.setErrorMessage("Target library path does not represent a folder!");
			return false;
		}
		try {

			String targetLibBundle = this.targetBundleText.getText();
			Bundle bundle;
			if(!targetLibBundle.isEmpty()) {
				if((bundle = Platform.getBundle(targetLibBundle)) == null) {
					this.setErrorMessage("Bundle '" + targetLibBundle + "' cannot be resolved!" );
					return false;
				}
				String targetLibContext = this.targetLibContextText.getText();
				if(targetLibContext.isEmpty()) {
					this.setErrorMessage("No target library context has been specified!");
					return false;
				} else {
					try {
						bundle.loadClass(targetLibContext);
					} catch (NoClassDefFoundError e) {
						this.setErrorMessage("The target library context could not be resolved!");
						return false;
					}
				}
				String targetLibParser = this.targetLibParserText.getText();
				if(!targetLibParser.isEmpty()) {
					try {
						bundle.loadClass(targetLibParser);
					} catch (NoClassDefFoundError e) {
						this.setErrorMessage("The target library parser could not be resolved!");
						return false;
					}
				}
			}
		} catch(Exception e) {
			this.setErrorMessage(e.getMessage());
			return false;
		}
		return true;
	}
}
