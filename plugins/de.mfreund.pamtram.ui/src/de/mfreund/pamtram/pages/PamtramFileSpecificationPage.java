package de.mfreund.pamtram.pages;

import java.io.File;

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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import pamtram.presentation.PamtramModelWizard;


public class PamtramFileSpecificationPage extends WizardPage {
	
	private IWizardContainer wizContainer;

	private Label pamtramFileLabel;

	private String pamtramFile = "my.pamtram";
	private Text pamtramFileTextfield;

	private String srcFile = "";
	private FileFieldEditor srcFileFieldEditor;

	public PamtramFileSpecificationPage(String pageName) {
		super(pageName);
	}

	@Override
	public void createControl(Composite parent) {
		
		// set the wizard container that can be used e.g. to update the buttons
		wizContainer = getWizard().getContainer();
		
		Composite container = new Composite (parent, SWT.NONE);
		container.setLayout (new GridLayout (3, false));
		container.setLayoutData (new GridData (GridData.HORIZONTAL_ALIGN_FILL));
		
		// create a label for the pamtram file
		pamtramFileLabel = new Label(container, SWT.NONE);
		pamtramFileLabel.setText("PAMTraM File:");
		pamtramFileLabel.setLayoutData(new GridData());
		
		// create a text field for the pamtram file
		pamtramFileTextfield = new Text(container, SWT.BORDER);
		pamtramFileTextfield.setText("my.pamtram");
		pamtramFileTextfield.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1)
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
	
		// create a file selector for the source file
		srcFileFieldEditor = new FileFieldEditor("srcFileSelect", "", container);
		srcFileFieldEditor.setLabelText("Source File:");
		// set the allowed file extensions
		srcFileFieldEditor.setFileExtensions(new String[]{"*.xmi", "*.xml"});
		// set a listener that updates the buttons
		srcFileFieldEditor.setPropertyChangeListener(new IPropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent event) {
				
				srcFile = srcFileFieldEditor.getStringValue();
				
				String nsUri = "";
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
					nsUri = object.eClass().getEPackage().getNsURI();
				} catch(Exception e) {
					if(e.getCause() instanceof PackageNotFoundException && getWizard() instanceof PamtramModelWizard) {
							// nothing needs to be done
					} else {
						e.printStackTrace();						
					}
				}
				
				if(getWizard() instanceof PamtramModelWizard) {
					// set the source ePackage to be used in the next wizard page
					((PamtramModelWizard) getWizard()).getePackageSpecificationPage().setSourceEPackage(nsUri);
				}
				
				wizContainer.updateButtons();
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
	 * Return the full path of the srcFile to be copied to the project.
	 * 
	 * @return the path of the src file
	 */
	public String getSrcFile() {
		return this.srcFile;
	}
	
    @Override
    public boolean isPageComplete() {
    	
    	// has a pamtram file been specified?
    	boolean pamtramFileIsValid = pamtramFileTextfield.getText() != null &&
    			pamtramFileTextfield.getText() != "";
    	// if a source file has been specified, check the file ending and if 
    	// the file exists
    	boolean srcFileIsValid = srcFileFieldEditor.getStringValue() == "" ||
    				((srcFileFieldEditor.getStringValue().endsWith(".xmi") || 
    						srcFileFieldEditor.getStringValue().endsWith(".xml")) &&
    						(new File(srcFileFieldEditor.getStringValue())).exists());
    	
    	return pamtramFileIsValid && srcFileIsValid;
    }
}