package de.mfreund.pamtram.ui.properties;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.dialogs.PropertyPage;
import org.osgi.framework.Bundle;

import de.mfreund.pamtram.properties.PropertySupplier;

public class PropertiesPage extends PropertyPage implements
		IWorkbenchPropertyPage {

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
	
	public PropertiesPage() {
		super();
	}

	@Override
	protected Control createContents(Composite parent) {
		// a composite to host all other controls
		Composite comp = new Composite(parent, SWT.NONE);
		GridLayoutFactory.swtDefaults().numColumns(2).equalWidth(true).applyTo(comp);
		comp.setFont(parent.getFont());
		
		// a group to host all library related settings
		Group libraryGroup = new Group(comp, SWT.NONE);
		libraryGroup.setText("Library Properties");
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).span(2, 1).applyTo(libraryGroup);
		GridLayoutFactory.swtDefaults().numColumns(2).applyTo(libraryGroup);
		
		// a group to host all target related settings
		Group targetGroup = new Group(libraryGroup, SWT.NONE);
		targetGroup.setText("Target");
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).span(2, 1).applyTo(targetGroup);
		GridLayoutFactory.swtDefaults().numColumns(2).applyTo(targetGroup);
		
		// create a label for the specification of the bundle that represents the specific target library 
		Label targetBundleLabel = new Label(targetGroup, SWT.NONE);
		targetBundleLabel.setText("Bundle ID:");
		GridDataFactory.swtDefaults().applyTo(targetBundleLabel);
		
		// create a text field for the specification of the bundle that represents the specific target library 
		targetBundleText = new Text(targetGroup, SWT.NONE);
		targetBundleText.setMessage("Bundle identifier of the plug-in hosting the concrete LibraryContext and PathParser");
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).applyTo(targetBundleText);
		targetBundleText.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				isValid();
			}
		});
		
		// create a label for the specification of the concrete library context of the specific target library
		Label targetLibContextLabel = new Label(targetGroup, SWT.NONE);
		targetLibContextLabel.setText("Library Context ID:");
		GridDataFactory.swtDefaults().applyTo(targetLibContextLabel);
		
		// create a text field for the specification of the concrete library context of the specific target library
		targetLibContextText = new Text(targetGroup, SWT.NONE);
		targetLibContextText.setMessage("Fully qualified name of the concrete LibraryContext");
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).applyTo(targetLibContextText);
		targetLibContextText.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				isValid();
			}
		});
		
		// create a label for the specification of the concrete library path parser of the specific target library
		Label targetLibParserLabel = new Label(targetGroup, SWT.NONE);
		targetLibParserLabel.setText("Library Path Parser ID:");
		GridDataFactory.swtDefaults().applyTo(targetLibParserLabel);
		
		// create a text field for the specification of the concrete library path parser of the specific target library 
		targetLibParserText = new Text(targetGroup, SWT.NONE);
		targetLibParserText.setMessage("Fully qualified name of the concrete PathParser (Leave empty to use default parser...)");
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).applyTo(targetLibParserText);
		targetLibParserText.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				isValid();
			}
		});
		
		// Finally, initialize all properties.
		initializeValues();
		
		return comp;
	}
	
	@Override
	public boolean performOk() {
		boolean isValid = isValid();
		if(isValid) {
			return super.performOk() && storeValues();
		} else {
			return false;			
		}
	}
	
	/**
	 * This persists the specified properties.
	 * @return <em>True</em> if everything went well, <em>false</em> otherwise.
	 */
	private boolean storeValues() {
		IResource resource = (IResource) getElement();
		try {
			resource.setPersistentProperty(
					new QualifiedName(PropertySupplier.PROPERTY_QUALIFIER, PropertySupplier.PROP_LIBRARY_TARGET_BUNDLE), 
					targetBundleText.getText());
			resource.setPersistentProperty(
					new QualifiedName(PropertySupplier.PROPERTY_QUALIFIER, PropertySupplier.PROP_LIBRARY_TARGET_CONTEXT), 
					targetLibContextText.getText());
			resource.setPersistentProperty(
					new QualifiedName(PropertySupplier.PROPERTY_QUALIFIER, PropertySupplier.PROP_LIBRARY_TARGET_PARSER), 
					targetLibParserText.getText());
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
		targetBundleText.setText(PropertySupplier.DEFAULT_LIBRARY_TARGET_BUNDLE);
		targetLibContextText.setText(PropertySupplier.DEFAULT_LIBRARY_TARGET_CONTEXT);
		targetLibParserText.setText(PropertySupplier.DEFAULT_LIBRARY_TARGET_PARSER); 
	}
	
	/**
	 * This initializes the properties page from the persisted properties.
	 * @return <em>True</em> if everything went well, <em>false</em> otherwise.
	 */
	private boolean initializeValues() {
		IResource resource = (IResource) getElement();

		try {
			String targetBundle = resource.getPersistentProperty(
					new QualifiedName(PropertySupplier.PROPERTY_QUALIFIER, PropertySupplier.PROP_LIBRARY_TARGET_BUNDLE));
			targetBundleText.setText(targetBundle != null ? targetBundle : PropertySupplier.DEFAULT_LIBRARY_TARGET_BUNDLE);
			String targetLibContext = resource.getPersistentProperty(
					new QualifiedName(PropertySupplier.PROPERTY_QUALIFIER, PropertySupplier.PROP_LIBRARY_TARGET_CONTEXT));
			targetLibContextText.setText(targetLibContext != null ? targetLibContext : PropertySupplier.DEFAULT_LIBRARY_TARGET_CONTEXT);
			String targetLibParser = resource.getPersistentProperty(
					new QualifiedName(PropertySupplier.PROPERTY_QUALIFIER, PropertySupplier.PROP_LIBRARY_TARGET_PARSER));
			targetLibParserText.setText(targetLibParser != null ? targetLibParser : PropertySupplier.DEFAULT_LIBRARY_TARGET_PARSER); 
		} catch (CoreException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * This validates the properties page.
	 * @return <em>True</em> if everything went well, <em>false</em> otherwise.
	 */
	@Override
	public boolean isValid() {
		
		setErrorMessage(null);
		try {
			String targetLibBundle = targetBundleText.getText();
			Bundle bundle;
			if(!targetLibBundle.isEmpty()) {
				if((bundle = Platform.getBundle(targetLibBundle)) == null) {
					setErrorMessage("Bundle '" + targetLibBundle + "' cannot be resolved!" );
					return false;
				}
				String targetLibContext = targetLibContextText.getText();
				if(targetLibContext.isEmpty()) {
					setErrorMessage("No target library context has been specified!");
					return false;
				} else {
					try {
						bundle.loadClass(targetLibContext);
					} catch (NoClassDefFoundError e) {
						setErrorMessage("The target library context could not be resolved!");
						return false;
					}
				}
				String targetLibParser = targetLibParserText.getText();
				if(!targetLibParser.isEmpty()) {
					try {
						bundle.loadClass(targetLibParser);
					} catch (NoClassDefFoundError e) {
						setErrorMessage("The target library parser could not be resolved!");
						return false;
					}
				}
			} else {
				setErrorMessage("No target library bundle has been specified!");
				return false;
			}
		} catch(Exception e) {
			setErrorMessage(e.getMessage());
			return false;
		}
		return true;
	}
}
