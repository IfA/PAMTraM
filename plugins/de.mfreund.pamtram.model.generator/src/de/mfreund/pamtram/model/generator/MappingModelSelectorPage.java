package de.mfreund.pamtram.model.generator;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class MappingModelSelectorPage extends WizardPage {
	
	private Composite container;
	private WizardData wizardData;
	private Button sourceButton, targetButton;
	
	final private ResourceSet rs = new ResourceSetImpl();

	public MappingModelSelectorPage(WizardData wizardData) {
		super("Select Mapping Model");
		setTitle("Select Mapping Model");
		setDescription("Select the instance of the mapping model where the metamodel section shall be stored...");
		
		this.wizardData = wizardData;
	}

	@Override
	public void createControl(Composite parent) {
		
		GridLayout gl;
		GridData gd;
		
		// container to host the file selector
		container = new Composite(parent, SWT.NONE);

		// define a grid layout
		gl = new GridLayout();
		int numColumns = 2;
		gl.numColumns = numColumns;
		container.setLayout(gl);
		
		// create a file selector
		FileFieldEditor fileFieldEditor; 
		fileFieldEditor = new FileFieldEditor("fileSelect", "Select file...", container);
		// restrict the file extension
		fileFieldEditor.setFileExtensions(new String[] {"*.pamtram"});
		// set the initial browse path
		fileFieldEditor.setFilterPath(
				wizardData.getSourceModelPath().removeLastSegments(1).toFile());
		
		// set listener that is triggered when the user has selected a file
		fileFieldEditor.setPropertyChangeListener(new IPropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent event) {
				// reset the UI
				setErrorMessage(null);
				setPageComplete(false);
				
				// get the selected file
				Object file = event.getNewValue();
				
				if(file instanceof String && ((String) file).endsWith(".pamtram")) {
					try {
						// delete the old model
						wizardData.getEolExecutor().disposeModels();
						
						// set the resource of the new model
						setResource((String) file);
						// load the new model
						loadModel();
						checkPackage();

						// activate the finish button if necessary
						if(wizardData.getSectionType() == SectionType.SOURCE || wizardData.getSectionType() == SectionType.TARGET) {
							setPageComplete(true);
						}
						
						updateSectionTypeButtons();
					} catch (Exception e) {
						setErrorMessage(e.getMessage());
					}
					
				}
				
			}
		});
		
		// separator
		Label separator = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = numColumns + 1;
		separator.setLayoutData(gd);
		
		Label sectionTypeLabel = new Label(container, SWT.NONE);
		sectionTypeLabel.setText("Type of metamodel section to be created");
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = numColumns + 1;
		sectionTypeLabel.setLayoutData(gd);
		
		// radio button for selecting 'source' as section type
		sourceButton = new Button(container, SWT.RADIO);
		sourceButton.setText("Source");
		sourceButton.setEnabled(false);
		sourceButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				wizardData.setSectionType(SectionType.SOURCE);
				setPageComplete(true);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				widgetSelected(arg0);
			}
		});
		
		// radio button for selecting 'target' as section type
		targetButton = new Button(container, SWT.RADIO);
		targetButton.setText("Target");
		targetButton.setEnabled(false);
		targetButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				wizardData.setSectionType(SectionType.TARGET);		
				setPageComplete(true);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				widgetSelected(arg0);
				
			}
		});
		
		// fill the wizard page
		setControl(container);
		setPageComplete(false);

	}
	

	/* get the target resource based on its resource path;
	 * if no resource exists, create a new one
	 */
	private void setResource(String resourcePath) throws Exception {
		
		Resource targetModelResource;
		// get the target resource (if the resource does not exist, create a new one first)
		try {
			targetModelResource = rs.getResource(URI.createFileURI(resourcePath), true);			
		} catch (Exception e) {
			targetModelResource = rs.createResource(URI.createFileURI(resourcePath));
		}
		// return without performing the action if the resource is null
		if (targetModelResource == null) {
			throw new RuntimeException("Resource could not be created!");
		}
		
		// save the (newly created) resource so that it can be loaded 
		try {
			targetModelResource.save(null);
		} catch (IOException e1) {
			throw new RuntimeException(e1);
		}
		
		wizardData.setTargetModelResource(targetModelResource);
	}

	// load the target model (the PAMTraM instance)
	private void loadModel() throws Exception {
		
		String modelPath = wizardData.getTargetModelResource().getURI().toFileString();
		
		wizardData.getEolExecutor().loadModel(
				"Pamtram", 
				"http://mfreund.de/pamtram", 
				modelPath, 
				true, 
				false);
	}

	
	
	/* check the packages declared in the PAMTraM instance and whether the
	 * metamodel section to be generated can be used as source or target
	 */
	private void checkPackage() throws RuntimeException {
		
		EPackage ePackage = wizardData.getePackage();
		
		URL fileURL = wizardData.getBundle().getEntry("templates/checkPackage.eol");
		
		// create the hashmap containing the parameters to be passed to the eol file
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("ePackage", ePackage);
		
		// load and execute the eol file
		int ret = (int) wizardData.getEolExecutor().executeEol(fileURL, params);
		
		switch (ret) {
			case -1:
				wizardData.getEolExecutor().disposeModels();
				wizardData.setSectionType(SectionType.NONE);
				throw new RuntimeException("The selected target PAMTraM instance can not be used for the selected EObject due to an ePackage discrepancy!");			
			case 0:
				wizardData.setSectionType(SectionType.BOTH); break;
			case 1:
				wizardData.setSectionType(SectionType.SOURCE); break;
			case 2:
				wizardData.setSectionType(SectionType.TARGET); break;
			default:
				throw new RuntimeException("EOL program returned with unsupported value!");
		}
	}
	
	private void updateSectionTypeButtons() {
		// configure the radio buttons
		switch (wizardData.getSectionType()) {
			case NONE:
				sourceButton.setEnabled(false);
				sourceButton.setSelection(false);
				targetButton.setEnabled(false);
				targetButton.setSelection(false);
				break;
			case BOTH:
				sourceButton.setEnabled(true);
				sourceButton.setSelection(false);
				targetButton.setEnabled(true);
				targetButton.setSelection(false);
				break;
			case SOURCE:
				sourceButton.setEnabled(false);
				sourceButton.setSelection(true);
				targetButton.setEnabled(false);
				targetButton.setSelection(false);
				break;
			case TARGET:
				sourceButton.setEnabled(false);
				sourceButton.setSelection(false);
				targetButton.setEnabled(false);
				targetButton.setSelection(true);
				break;
			default:
				break;
		}
	}
}
