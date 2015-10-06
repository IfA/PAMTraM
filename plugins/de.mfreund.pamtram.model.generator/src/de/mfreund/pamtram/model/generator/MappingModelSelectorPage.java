package de.mfreund.pamtram.model.generator;

import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
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
import org.eclipse.swt.widgets.List;

import de.mfreund.pamtram.util.SelectionListener2;
import pamtram.PAMTraM;
import pamtram.SectionModel;
import pamtram.presentation.PamtramEditor;

public class MappingModelSelectorPage extends WizardPage {

	private Composite container;
	private WizardData wizardData;
	private Button sourceButton, targetButton;
	private List modelSelectionList;

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
						if(wizardData.getEditor() == null && wizardData.getPamtram() != null) {
							wizardData.getPamtram().eResource().unload();
							wizardData.setPamtram(null);
						} else {
							wizardData.setEditor(null);
						}

						PamtramEditor editor = PamtramEditor.getEditor((String) file);

						// we may use an exising editor and its editing domain for our work 
						if(editor != null) {
							wizardData.setEditor(editor);
							wizardData.setPamtram(editor.getPamtram());

							// we have to load everything by ourselves
						} else {

							// set the resource of the new model
							setResource((String) file);
							// load the new model
							loadModel();
						}
						checkPackage();							

						updateSectionTypeButtons();
					} catch (Exception e) {
						setErrorMessage(e.getMessage());
						e.printStackTrace();
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
		sectionTypeLabel.setText("Type of metamodel section to be created:");
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
				updateSectionModelList();
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
				updateSectionModelList();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				widgetSelected(arg0);

			}
		});

		// separator
		Label separator2 = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = numColumns + 1;
		separator2.setLayoutData(gd);

		Label modelSelectionLabel = new Label(container, SWT.NONE);
		modelSelectionLabel.setText("Target Source/TargetSectionModel:");
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = numColumns + 1;
		modelSelectionLabel.setLayoutData(gd);

		// list for selecting the target Source/TargetSectionModel
		modelSelectionList = new List(container, SWT.NONE);
		modelSelectionList.setToolTipText("Please specify the Source/TargetSectionModel into that the generated section(s) shall be added..."); 
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = numColumns + 1;
		modelSelectionList.setLayoutData(gd);
		modelSelectionList.addSelectionListener(new SelectionListener2() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				PAMTraM pamtram = wizardData.getPamtram();
				if(pamtram == null || wizardData.getSectionType() == SectionType.NONE || wizardData.getSectionType() == SectionType.BOTH) {
					wizardData.setSectionModel(null);
				} else {
					wizardData.setSectionModel(wizardData.getSectionType() == SectionType.SOURCE ? 
							wizardData.getPamtram().getSourceSectionModel().get(modelSelectionList.getSelectionIndex()) :
								wizardData.getPamtram().getTargetSectionModel().get(modelSelectionList.getSelectionIndex()));


				}
				getContainer().updateButtons();
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

		ResourceSet resourceSet = rs;

		// the URI of the pamtram resource
		final URI pamtramUri = URI.createFileURI(modelPath);

		// load the pamtram model
		XMIResource pamtramResource = 
				(XMIResource) resourceSet.getResource(pamtramUri, true);
		if(!(pamtramResource.getContents().get(0) instanceof PAMTraM)) {
			throw new RuntimeException("The pamtram file does not seem to contain a pamtram instance. Aborting...");
		}
		wizardData.setPamtram((PAMTraM) pamtramResource.getContents().get(0));
	}



	/* check the packages declared in the PAMTraM instance and whether the
	 * metamodel section to be generated can be used as source or target
	 */
	private void checkPackage() throws RuntimeException {

		EPackage ePackage = wizardData.getePackage();

		PAMTraM pamtram = wizardData.getPamtram();

		//TODO do not simply/only check the first source and target section model
		if(pamtram.getSourceSectionModel() == null || pamtram.getSourceSectionModel().isEmpty()) {
			throw new RuntimeException("The selected target PAMTraM instance does not contain a SourceSectionModel!");
		} else if(pamtram.getTargetSectionModel() == null || pamtram.getTargetSectionModel().isEmpty()) {
			throw new RuntimeException("The selected target PAMTraM instance does not contain a TargetSectionModel!");
		} else if(pamtram.getSourceSectionModel().get(0).getMetaModelPackage() == null) {
			throw new RuntimeException("The selected target PAMTraM instance does not specify an EPackage for the SourceSectionModel!");
		} else if(pamtram.getTargetSectionModel().get(0).getMetaModelPackage() == null) {
			throw new RuntimeException("The selected target PAMTraM instance does not specify an EPackage for the TargetSectionModel!");
		}

		// get the source package
		EPackage sourcePackage = pamtram.getSourceSectionModel().get(0).getMetaModelPackage();
		// get the target package
		EPackage targetPackage = pamtram.getTargetSectionModel().get(0).getMetaModelPackage();

		if(sourcePackage.getNsURI().equals(ePackage.getNsURI())) {
			if(targetPackage.getNsURI().equals(ePackage.getNsURI())) {
				// ePackage can be used as both source and target
				wizardData.setSectionType(SectionType.BOTH);
			} else {
				// ePackage can be used only as source
				wizardData.setSectionType(SectionType.SOURCE);
			}
		} else {
			if(targetPackage.getNsURI().equals(ePackage.getNsURI())) {
				// ePackage can be used only as target
				wizardData.setSectionType(SectionType.TARGET);
			} else {
				// ePacakge can be used neither as source nor as target
				wizardData.setSectionType(SectionType.NONE);
			}
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
		updateSectionModelList();
	}

	private void updateSectionModelList() {

		modelSelectionList.setItems(new String[]{});

		// update the list of section models to choose

		PAMTraM pamtram = wizardData.getPamtram();
		if(pamtram == null || wizardData.getSectionType() == SectionType.NONE || wizardData.getSectionType() == SectionType.BOTH) {
			return;
		}

		@SuppressWarnings("unchecked")
		EList<SectionModel<?, ?, ?, ?>> sectionModels = (EList<SectionModel<?, ?, ?, ?>>) (wizardData.getSectionType() == SectionType.SOURCE ? wizardData.getPamtram().getSourceSectionModel() : wizardData.getPamtram().getTargetSectionModel());
		String prefix = (wizardData.getSectionType() == SectionType.SOURCE ? "SourceSectionModel " : "TargetSectionModel ");
		for (SectionModel<?, ?, ?, ?> sectionModel : sectionModels) {
			modelSelectionList.add(prefix + (sectionModel.getName() != null ? sectionModel.getName() : ""));
		}
	}

	@Override
	public boolean isPageComplete() {
		return wizardData.getPamtram() != null && wizardData.getSectionType() != SectionType.NONE &&
				wizardData.getSectionType() != SectionType.BOTH && wizardData.getSectionModel() != null;
	}
}
