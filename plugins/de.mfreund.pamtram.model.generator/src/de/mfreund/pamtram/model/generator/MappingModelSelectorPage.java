package de.mfreund.pamtram.model.generator;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.jface.preference.FileFieldEditor;
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

import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import pamtram.PAMTraM;
import pamtram.SectionModel;
import pamtram.metamodel.Section;
import pamtram.presentation.PamtramEditor;

/**
 * A {@link WizardPage} that allows to select a {@link PAMTraM} model as well as an incorporated {@link SectionModel}.
 * This is used as part of the {@link GeneratorWizard} in order to select the SectionModel into which the generated
 * {@link Section} shall be stored.
 *
 * @author mfreund
 */
public class MappingModelSelectorPage extends WizardPage {

	/**
	 * The {@link WizardData} instance where all relevant data that is acquired throughout the wizard is stored.
	 */
	private WizardData wizardData;

	/**
	 * The radio button that allows to specify that a SourceSection shall be generated.
	 */
	private Button sourceButton;

	/**
	 * The radio button that allows to specify that a TargetSection shall be generated.
	 */
	private Button targetButton;

	/**
	 * The {@link List} that displays the possible SectionModels in which the generated Section shall be stored.
	 */
	private List modelSelectionList;

	/**
	 * The {@link java.util.List} of {@link SectionModel SectionModels} that backs up the {@link #modelSelectionList}.
	 */
	private java.util.List<SectionModel<?, ?, ?, ?>> sectionModels;

	/**
	 * The {@link ResourceSet} that is used by this wizard page to load resources.
	 */
	private final ResourceSet rs = new ResourceSetImpl();

	/**
	 * This creates an instance.
	 *
	 * @param wizardData
	 *            The {@link WizardData} instance where all relevant data that is acquired throughout the wizard is
	 *            stored.
	 */
	public MappingModelSelectorPage(WizardData wizardData) {
		super("Select Mapping Model");
		this.setTitle("Select Mapping Model");
		this.setDescription("Select the instance of the mapping model where the metamodel section shall be stored...");

		this.wizardData = wizardData;
	}

	@Override
	public void createControl(Composite parent) {

		GridLayout gl;
		GridData gd;

		// container to host the file selector
		Composite container = new Composite(parent, SWT.NONE);

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
				this.wizardData.getSourceModelPath().removeLastSegments(1).toFile());

		// set listener that is triggered when the user has selected a file
		fileFieldEditor.setPropertyChangeListener(event -> {
			// reset the UI
			MappingModelSelectorPage.this.setErrorMessage(null);
			MappingModelSelectorPage.this.setPageComplete(false);

			// get the selected file
			Object file = event.getNewValue();

			if(file instanceof String && ((String) file).endsWith(".pamtram")) {
				try {
					// delete the old model
					if(MappingModelSelectorPage.this.wizardData.getEditor() == null && MappingModelSelectorPage.this.wizardData.getPamtram() != null) {
						MappingModelSelectorPage.this.wizardData.getPamtram().eResource().unload();
						MappingModelSelectorPage.this.wizardData.setPamtram(null);
					} else {
						MappingModelSelectorPage.this.wizardData.setEditor(null);
					}

					PamtramEditor editor = PamtramEditor.getEditor((String) file, true);

					// we may use an exising editor and its editing domain for our work
					if(editor != null) {
						MappingModelSelectorPage.this.wizardData.setEditor(editor);
						MappingModelSelectorPage.this.wizardData.setPamtram(editor.getPamtram());

						// we have to load everything by ourselves
					} else {

						// set the resource of the new model
						MappingModelSelectorPage.this.setResource((String) file);
						// load the new model
						MappingModelSelectorPage.this.loadModel();
					}
					MappingModelSelectorPage.this.checkPackage();

					MappingModelSelectorPage.this.updateSectionTypeButtons();
				} catch (Exception e) {
					MappingModelSelectorPage.this.setErrorMessage(e.getMessage());
					e.printStackTrace();
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
		this.sourceButton = new Button(container, SWT.RADIO);
		this.sourceButton.setText("Source");
		this.sourceButton.setEnabled(false);
		this.sourceButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				MappingModelSelectorPage.this.wizardData.setSectionType(SectionType.SOURCE);
				MappingModelSelectorPage.this.updateSectionModelList();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				this.widgetSelected(arg0);
			}
		});

		// radio button for selecting 'target' as section type
		this.targetButton = new Button(container, SWT.RADIO);
		this.targetButton.setText("Target");
		this.targetButton.setEnabled(false);
		this.targetButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				MappingModelSelectorPage.this.wizardData.setSectionType(SectionType.TARGET);
				MappingModelSelectorPage.this.updateSectionModelList();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				this.widgetSelected(arg0);

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
		this.modelSelectionList = new List(container, SWT.NONE);
		this.modelSelectionList.setToolTipText("Please specify the Source/TargetSectionModel into that the generated section(s) shall be added...");
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = numColumns + 1;
		this.modelSelectionList.setLayoutData(gd);
		this.modelSelectionList.addSelectionListener((SelectionListener2) e -> {

			if (MappingModelSelectorPage.this.wizardData.getPamtram() == null
					|| MappingModelSelectorPage.this.wizardData.getSectionType() == SectionType.NONE
					|| MappingModelSelectorPage.this.wizardData.getSectionType() == SectionType.BOTH) {
				MappingModelSelectorPage.this.wizardData.setSectionModel(null);
			} else {
				MappingModelSelectorPage.this.wizardData.setSectionModel(
						this.sectionModels.get(MappingModelSelectorPage.this.modelSelectionList.getSelectionIndex()));

			}
			MappingModelSelectorPage.this.getContainer().updateButtons();
		});

		// fill the wizard page
		this.setControl(container);
		this.setPageComplete(false);

	}

	/**
	 * Get the target resource based on its resource path. If no resource exists, create a new one.
	 *
	 * @param resourcePath
	 *            The absolute path of the resource.
	 */
	private void setResource(String resourcePath) {

		Resource targetModelResource;
		// get the target resource (if the resource does not exist, create a new one first)
		try {
			targetModelResource = this.rs.getResource(URI.createFileURI(resourcePath), true);
		} catch (Exception e) {
			targetModelResource = this.rs.createResource(URI.createFileURI(resourcePath));
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

		this.wizardData.setTargetModelResource(targetModelResource);
	}

	// load the target model (the PAMTraM instance)
	private void loadModel() throws Exception {

		String modelPath = this.wizardData.getTargetModelResource().getURI().toFileString();

		ResourceSet resourceSet = this.rs;

		// the URI of the pamtram resource
		final URI pamtramUri = URI.createFileURI(modelPath);

		// load the pamtram model
		XMIResource pamtramResource =
				(XMIResource) resourceSet.getResource(pamtramUri, true);
		if(!(pamtramResource.getContents().get(0) instanceof PAMTraM)) {
			throw new RuntimeException("The pamtram file does not seem to contain a pamtram instance. Aborting...");
		}
		this.wizardData.setPamtram((PAMTraM) pamtramResource.getContents().get(0));
	}



	/**
	 * Check the packages declared in the {@link PAMTraM} instance and whether the metamodel section to be generated can
	 * be used as source or target section.
	 */
	private void checkPackage() {

		EPackage ePackage = this.wizardData.getePackage();

		PAMTraM pamtram = this.wizardData.getPamtram();

		// get the source packages
		Set<EPackage> sourcePackages = pamtram.getSourceSectionModel().stream().map(s -> s.getMetaModelPackage())
				.collect(Collectors.toSet());
		sourcePackages.addAll(pamtram.getSharedSourceSectionModel().stream().map(s -> s.getMetaModelPackage())
				.collect(Collectors.toSet()));
		// get the target packages
		Set<EPackage> targetPackages = pamtram.getTargetSectionModel().stream().map(s -> s.getMetaModelPackage())
				.collect(Collectors.toSet());
		targetPackages.addAll(pamtram.getSharedTargetSectionModel().stream().map(s -> s.getMetaModelPackage())
				.collect(Collectors.toSet()));

		boolean source = sourcePackages.parallelStream().anyMatch(s -> s.getNsURI().equals(ePackage.getNsURI()));
		boolean target = targetPackages.parallelStream().anyMatch(s -> s.getNsURI().equals(ePackage.getNsURI()));

		if (source) {
			if (target) {
				// ePackage can be used as both source and target
				this.wizardData.setSectionType(SectionType.BOTH);
			} else {
				// ePackage can be used only as source
				this.wizardData.setSectionType(SectionType.SOURCE);
			}
		} else {
			if (target) {
				// ePackage can be used only as target
				this.wizardData.setSectionType(SectionType.TARGET);
			} else {
				// ePacakge can be used neither as source nor as target
				this.wizardData.setSectionType(SectionType.NONE);
			}
		}
	}

	/**
	 * Update the <em>enabled</em> and <em>selected</em> state of the {@link #sourceButton} and {@link #targetButton}
	 * after a new {@link PAMTraM} resource has been specified as target model.
	 */
	private void updateSectionTypeButtons() {
		// configure the radio buttons
		switch (this.wizardData.getSectionType()) {
			case NONE:
				this.sourceButton.setEnabled(false);
				this.sourceButton.setSelection(false);
				this.targetButton.setEnabled(false);
				this.targetButton.setSelection(false);
				break;
			case BOTH:
				this.sourceButton.setEnabled(true);
				this.sourceButton.setSelection(false);
				this.targetButton.setEnabled(true);
				this.targetButton.setSelection(false);
				break;
			case SOURCE:
				this.sourceButton.setEnabled(false);
				this.sourceButton.setSelection(true);
				this.targetButton.setEnabled(false);
				this.targetButton.setSelection(false);
				break;
			case TARGET:
				this.sourceButton.setEnabled(false);
				this.sourceButton.setSelection(false);
				this.targetButton.setEnabled(false);
				this.targetButton.setSelection(true);
				break;
			default:
				break;
		}
		this.updateSectionModelList();
	}

	/**
	 * Update the {@link #modelSelectionList} after a new target model has been specified or after the user has made a
	 * change to the selection of the {@link #sourceButton} and {@link #targetButton}.
	 */
	private void updateSectionModelList() {

		this.modelSelectionList.setItems(new String[]{});

		// update the list of section models to choose

		PAMTraM pamtram = this.wizardData.getPamtram();
		if(pamtram == null || this.wizardData.getSectionType() == SectionType.NONE || this.wizardData.getSectionType() == SectionType.BOTH) {
			return;
		}

		Stream<SectionModel<?, ?, ?, ?>> sectionModelStream = this.wizardData.getSectionType() == SectionType.SOURCE
				? Stream.concat(this.wizardData.getPamtram().getSourceSectionModel().stream(),
						this.wizardData.getPamtram().getSharedSourceSectionModel().stream())
						: Stream.concat(this.wizardData.getPamtram().getTargetSectionModel().stream(),
								this.wizardData.getPamtram().getSharedTargetSectionModel().stream());

				this.sectionModels = sectionModelStream
						.filter(s -> this.wizardData.getePackage().equals(s.getMetaModelPackage()))
						.collect(Collectors.toList());

				String prefix = this.wizardData.getSectionType() == SectionType.SOURCE ? "SourceSectionModel "
						: "TargetSectionModel ";
				for (SectionModel<?, ?, ?, ?> sectionModel : this.sectionModels) {
					this.modelSelectionList.add(prefix + (sectionModel.getName() != null ? sectionModel.getName() : ""));
				}
	}

	@Override
	public boolean isPageComplete() {
		return this.wizardData.getPamtram() != null && this.wizardData.getSectionType() != SectionType.NONE &&
				this.wizardData.getSectionType() != SectionType.BOTH && this.wizardData.getSectionModel() != null;
	}
}
