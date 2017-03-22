package de.mfreund.pamtram.pages;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.PackageNotFoundException;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

import de.tud.et.ifa.agtele.resources.BundleContentHelper;
import de.tud.et.ifa.agtele.ui.listeners.KeyPressedListener;
import de.tud.et.ifa.agtele.ui.listeners.KeyReleasedListener;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import pamtram.PAMTraM;
import pamtram.provider.PamtramEditPlugin;

/**
 * This {@link WizardPage} allows create a new {@link PAMTraM} model.
 *
 * @author mfreund
 */
public class PamtramFileSpecificationPage extends WizardPage {

	private static final String BUNDLE_ID = "de.mfreund.pamtram.ui";

	private IWizardContainer wizContainer;

	private String pamtramFile = "my" + PamtramEditPlugin.INSTANCE.getString("PAMTRAM_MODEL_FILE_ENDING");

	private Text pamtramFileTextfield;

	private String srcFile = "";

	private FileFieldEditor srcFileFieldEditor;

	/*
	 * A list that stores all known namespace URIs (value) for the specified source files (key).
	 */
	private HashMap<String, String> nsUris = new HashMap<>();

	private List srcFileList;

	/**
	 * This creates an instance.
	 *
	 * @param pageName
	 *            The name of the wizard page to be created.
	 */
	public PamtramFileSpecificationPage(String pageName) {
		super(pageName);
	}

	/**
	 * This returns the namespace URI(s) of the source file(s).
	 *
	 * @return The namespace URI(s) of the source file(s).
	 */
	public Collection<String> getNsUris() {

		HashSet<String> ret = new HashSet<>();
		for (String nsUri : this.nsUris.values()) {
			if (nsUri != null && !nsUri.isEmpty()) {
				ret.add(nsUri);
			}
		}
		return ret;
	}

	@Override
	public void createControl(Composite parent) {

		// set the wizard container that can be used e.g. to update the buttons
		this.wizContainer = this.getWizard().getContainer();

		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(4, false));
		container.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

		// create a label for the pamtram file
		Label pamtramFileLabel = new Label(container, SWT.NONE);
		pamtramFileLabel.setText("PAMTraM File:");

		// create a text field for the pamtram file
		this.pamtramFileTextfield = new Text(container, SWT.BORDER);
		this.pamtramFileTextfield.setText(this.pamtramFile);
		this.pamtramFileTextfield.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		this.pamtramFileTextfield.setMessage("The name of the PAMTraM file to be created...");
		// set a listener that updates the buttons
		this.pamtramFileTextfield.addKeyListener((KeyReleasedListener) e -> {

			PamtramFileSpecificationPage.this.pamtramFile = PamtramFileSpecificationPage.this.pamtramFileTextfield
					.getText();
			PamtramFileSpecificationPage.this.wizContainer.updateButtons();
		});

		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 3, 1));

		// create a file selector for the source file
		this.srcFileFieldEditor = new FileFieldEditor("srcFileSelect", "", composite);
		this.srcFileFieldEditor.setLabelText("Source File:");
		// set the allowed file extensions
		this.srcFileFieldEditor.setFileExtensions(new String[] { "*.xmi", "*.xml" });
		// set a listener that updates the buttons
		this.srcFileFieldEditor.setPropertyChangeListener(event -> {

			PamtramFileSpecificationPage.this.srcFile = PamtramFileSpecificationPage.this.srcFileFieldEditor
					.getStringValue();

			try {
				Resource resource;
				EObject object = null;

				// Create a resource set.
				ResourceSet rs = new ResourceSetImpl();

				if (PamtramFileSpecificationPage.this.srcFile.endsWith(".xml")) {
					Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xml",
							new GenericXMLResourceFactoryImpl());
				}

				// Create a File URI
				URI sourceUri = URI
						.createFileURI(new java.io.File(PamtramFileSpecificationPage.this.srcFile).toString());

				// Load the resource
				resource = rs.getResource(sourceUri, true);
				resource.load(null);

				// Get the first object in the resource
				object = resource.getContents().get(0);

				// Get the namespace Uri
				PamtramFileSpecificationPage.this.nsUris.put(PamtramFileSpecificationPage.this.srcFile,
						object.eClass().getEPackage().getNsURI());
			} catch (Exception e) {
				if (e.getCause() instanceof PackageNotFoundException) {
					PamtramFileSpecificationPage.this.nsUris.put(PamtramFileSpecificationPage.this.srcFile, null);
				} else {
					e.printStackTrace();
				}
			}

			PamtramFileSpecificationPage.this.wizContainer.updateButtons();
		});

		// create a button that allows specifying another source model
		Button addButton = new Button(container, SWT.NONE);
		addButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false, 1, 1));
		addButton.setToolTipText("Add another source model...");
		addButton.setImage(
				BundleContentHelper.getBundleImage(PamtramFileSpecificationPage.BUNDLE_ID, "icons/add_obj.gif"));
		addButton.addSelectionListener((SelectionListener2) e -> {
			// TODO prevent duplicate entries as this should not make any sense
			if (PamtramFileSpecificationPage.this.isSrcFileValid()) {
				// add the item to the list and clear the value of the FileFieldEditor
				PamtramFileSpecificationPage.this.srcFileList
						.add(PamtramFileSpecificationPage.this.srcFileFieldEditor.getStringValue());
				PamtramFileSpecificationPage.this.srcFileFieldEditor.setStringValue(null);
			}
		});

		this.srcFileList = new List(container, SWT.NONE);
		this.srcFileList.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1));
		this.srcFileList.addKeyListener((KeyPressedListener) e -> {

			if (e.keyCode == SWT.DEL && PamtramFileSpecificationPage.this.srcFileList.getSelectionIndex() != -1) {
				PamtramFileSpecificationPage.this.nsUris.remove(PamtramFileSpecificationPage.this.srcFileList
						.getItem(PamtramFileSpecificationPage.this.srcFileList.getSelectionIndex()));
				PamtramFileSpecificationPage.this.srcFileList
						.remove(PamtramFileSpecificationPage.this.srcFileList.getSelectionIndex());
			}
		});

		this.setControl(container);
		this.setPageComplete(true);
	}

	/**
	 * Returns the name of the pamtram file to be created (including the file extension '.pamtram'
	 *
	 * @return the pamtram file
	 */
	public String getPamtramFile() {

		if (this.pamtramFile.endsWith(PamtramEditPlugin.INSTANCE.getString("PAMTRAM_MODEL_FILE_ENDING"))) {
			return this.pamtramFile;
		} else {
			return this.pamtramFile + PamtramEditPlugin.INSTANCE.getString("PAMTRAM_MODEL_FILE_ENDING");
		}
	}

	/**
	 * Return the full paths of the srcFiles to be copied to the project.
	 *
	 * @return the paths of the src files
	 */
	public Set<String> getSrcFiles() {

		return this.nsUris.keySet().stream().filter(s -> s != null).collect(Collectors.toSet());

	}

	@Override
	public boolean isPageComplete() {

		// has a pamtram file been specified?
		boolean pamtramFileIsValid = this.pamtramFileTextfield.getText() != null
				&& this.pamtramFileTextfield.getText() != "";
		// if a source file has been specified, check the file ending and if
		// the file exists
		boolean srcFileIsValid = this.srcFileFieldEditor.getStringValue() == "" || this.isSrcFileValid();

		return pamtramFileIsValid && srcFileIsValid;
	}

	private boolean isSrcFileValid() {

		return (this.srcFileFieldEditor.getStringValue().endsWith(".xmi")
				|| this.srcFileFieldEditor.getStringValue().endsWith(".xml"))
				&& new File(this.srcFileFieldEditor.getStringValue()).exists();
	}
}