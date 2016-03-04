package de.mfreund.pamtram.pages;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.PackageNotFoundException;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

import de.tud.et.ifa.agtele.resources.BundleContentHelper;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;

public class PamtramFileSpecificationPage extends WizardPage {

	private static final String BUNDLE_ID = "de.mfreund.pamtram.ui";

	private IWizardContainer wizContainer;

	private Label pamtramFileLabel;

	private String pamtramFile = "my.pamtram";
	private Text pamtramFileTextfield;

	private String srcFile = "";
	private FileFieldEditor srcFileFieldEditor;
	/*
	 * A list that stores all known namespace URIs (value) for the specified source files (key).
	 */
	private HashMap<String, String> nsUris = new HashMap<>();

	private List srcFileList;

	/**
	 * This returns the namespace URI(s) of the source file(s).
	 * @return The namespace URI(s) of the source file(s).
	 */
	public Collection<String> getNsUris() {
		HashSet<String> ret = new HashSet<>();
		for (String nsUri : nsUris.values()) {
			if(nsUri != null && !nsUri.isEmpty()) {
				ret.add(nsUri);
			}
		}
		return ret;
	}

	public PamtramFileSpecificationPage(String pageName) {
		super(pageName);
	}

	@Override
	public void createControl(Composite parent) {

		// set the wizard container that can be used e.g. to update the buttons
		wizContainer = getWizard().getContainer();

		Composite container = new Composite (parent, SWT.NONE);
		container.setLayout (new GridLayout (4, false));
		container.setLayoutData (new GridData (GridData.HORIZONTAL_ALIGN_FILL));

		// create a label for the pamtram file
		pamtramFileLabel = new Label(container, SWT.NONE);
		pamtramFileLabel.setText("PAMTraM File:");

		// create a text field for the pamtram file
		pamtramFileTextfield = new Text(container, SWT.BORDER);
		pamtramFileTextfield.setText("my.pamtram");
		pamtramFileTextfield.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1)
				);
		pamtramFileTextfield.setMessage("The name of the PAMTraM file to be created...");
		// set a listener that updates the buttons
		pamtramFileTextfield.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				pamtramFile = pamtramFileTextfield.getText();
				wizContainer.updateButtons();
			}

			@Override
			public void keyPressed(KeyEvent e) {}
		});

		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 3, 1));

		// create a file selector for the source file
		srcFileFieldEditor = new FileFieldEditor("srcFileSelect", "", composite);
		srcFileFieldEditor.setLabelText("Source File:");
		// set the allowed file extensions
		srcFileFieldEditor.setFileExtensions(new String[]{"*.xmi", "*.xml"});
		// set a listener that updates the buttons
		srcFileFieldEditor.setPropertyChangeListener(new IPropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent event) {

				srcFile = srcFileFieldEditor.getStringValue();

				try {
					Resource resource;
					EObject object = null;

					// Create a resource set. 
					ResourceSet rs = new ResourceSetImpl();

					if(srcFile.endsWith(".xml")) {
						Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
						.put("xml", new GenericXMLResourceFactoryImpl());
					}

					// Create a File URI
					URI sourceUri = URI.createFileURI(new java.io.File(srcFile).toString());

					// Load the resource
					resource = rs.getResource(sourceUri, true);
					resource.load(null);

					// Get the first object in the resource
					object = resource.getContents().get(0);

					// Get the namespace Uri
					nsUris.put(srcFile, object.eClass().getEPackage().getNsURI());
				} catch(Exception e) {
					if(e.getCause() instanceof PackageNotFoundException) {
						nsUris.put(srcFile, null);
					} else {
						e.printStackTrace();						
					}
				}

				wizContainer.updateButtons();
			}
		});

		// create a button that allows specifying another source model
		Button addButton = new Button(container, SWT.NONE);
		addButton.setLayoutData(
				new GridData(SWT.FILL, SWT.TOP, false, false, 1, 1)
				);
		addButton.setToolTipText("Add another source model...");
		addButton.setImage(BundleContentHelper.getBundleImage(BUNDLE_ID, "icons/add_obj.gif"));
		addButton.addSelectionListener(new SelectionListener2() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				//TODO prevent duplicate entries as this should not make any sense
				if(isSrcFileValid()) {
					// add the item to the list and clear the value of the FileFieldEditor
					srcFileList.add(srcFileFieldEditor.getStringValue());
					srcFileFieldEditor.setStringValue(null);
				}
			}
		});

		srcFileList = new List(container, SWT.NONE);
		srcFileList.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1)
				);
		srcFileList.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.keyCode == SWT.DEL && srcFileList.getSelectionIndex() != -1) {
					nsUris.remove(srcFileList.getItem(srcFileList.getSelectionIndex()));
					srcFileList.remove(srcFileList.getSelectionIndex());
				}
			}
		});

		setControl(container);
		setPageComplete(true);
	}

	/**
	 * Returns the name of the pamtram file to be created (including
	 * the file extension '.pamtram'
	 * 
	 * @return the pamtram file
	 */
	public String getPamtramFile() {
		if(this.pamtramFile.endsWith(".pamtram")) {
			return this.pamtramFile;
		} else {
			return this.pamtramFile + ".pamtram";
		}
	}

	/**
	 * Return the full paths of the srcFiles to be copied to the project.
	 * 
	 * @return the paths of the src files
	 */
	public Set<String> getSrcFiles() {
		HashSet<String> ret = new HashSet<>();
		for (String srcFile : nsUris.keySet()) {
			if(srcFile != null) {
				ret.add(srcFile);
			}
		}
		return ret;
	}

	@Override
	public boolean isPageComplete() {

		// has a pamtram file been specified?
		boolean pamtramFileIsValid = pamtramFileTextfield.getText() != null &&
				pamtramFileTextfield.getText() != "";
		// if a source file has been specified, check the file ending and if 
		// the file exists
		boolean srcFileIsValid = srcFileFieldEditor.getStringValue() == "" || isSrcFileValid();

		return pamtramFileIsValid && srcFileIsValid;
	}

	private boolean isSrcFileValid() {
		return ((srcFileFieldEditor.getStringValue().endsWith(".xmi") || 
				srcFileFieldEditor.getStringValue().endsWith(".xml")) &&
				(new File(srcFileFieldEditor.getStringValue())).exists());
	}
}