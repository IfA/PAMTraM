package de.mfreund.pamtram.model.generator;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;

import de.tud.et.ifa.agtele.resources.ResourceHelper;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import pamtram.PAMTraM;
import pamtram.SectionModel;
import pamtram.SourceSectionModel;
import pamtram.TargetSectionModel;
import pamtram.presentation.PamtramEditor;
import pamtram.provider.PamtramEditPlugin;
import pamtram.structure.generic.Section;

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

		// container to host the file selector
		Composite container = new Composite(parent, SWT.NONE);

		// define a grid layout
		GridLayoutFactory.swtDefaults().numColumns(3).applyTo(container);

		// create a file selector
		FileFieldEditor fileFieldEditor;
		fileFieldEditor = new FileFieldEditor("fileSelect", "Select file...", container);
		fileFieldEditor.setFileExtensions(
				new String[] { "*" + PamtramEditPlugin.INSTANCE.getString("PAMTRAM_MODEL_FILE_ENDING") });

		// set the initial browse path
		if (this.wizardData.getSourceElements() != null && !this.wizardData.getSourceElements().isEmpty()
				&& this.wizardData.getSourceElements().get(0).eResource() != null) {

			Resource resource = this.wizardData.getSourceElements().get(0).eResource();
			File initialBrowsePath = new File(ResourceHelper
					.convertPlatformToFileURI(resource.getURI().trimSegments(2)
							.appendSegment(PamtramEditPlugin.INSTANCE.getString("PAMTRAM_FOLDER_NAME")))
					.toFileString());
			if (!initialBrowsePath.exists()) {
				initialBrowsePath = new File(ResourcesPlugin.getWorkspace().getRoot().getLocationURI());
			}
			fileFieldEditor.setFilterPath(initialBrowsePath);
		}

		// set listener that is triggered when the user has selected a file
		//
		fileFieldEditor.setPropertyChangeListener(event -> {

			// reset the UI
			//
			MappingModelSelectorPage.this.setErrorMessage(null);
			MappingModelSelectorPage.this.setPageComplete(false);

			// update the modelSelectionList
			//
			if (event.getNewValue() instanceof String) {
				this.mappingModelSelectionChanged((String) event.getNewValue());

			}

		});

		// Create a separator
		//
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).span(3, 1)
				.applyTo(new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL));

		Label sectionTypeLabel = new Label(container, SWT.NONE);
		sectionTypeLabel.setText("Type of metamodel section to be created:");
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).span(3, 1).applyTo(sectionTypeLabel);

		// radio button for selecting 'source' as section type
		//
		this.sourceButton = new Button(container, SWT.RADIO);
		this.sourceButton.setText("Source");
		this.sourceButton.setEnabled(false);
		this.sourceButton.addSelectionListener((SelectionListener2) e -> {
			MappingModelSelectorPage.this.wizardData.setSectionType(SectionType.SOURCE);
			MappingModelSelectorPage.this.updateSectionModelList();
		});

		// radio button for selecting 'target' as section type
		this.targetButton = new Button(container, SWT.RADIO);
		this.targetButton.setText("Target");
		this.targetButton.setEnabled(false);
		this.targetButton.addSelectionListener((SelectionListener2) e -> {
			MappingModelSelectorPage.this.wizardData.setSectionType(SectionType.TARGET);
			MappingModelSelectorPage.this.updateSectionModelList();
		});

		// Create a separator
		//
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).span(3, 1)
				.applyTo(new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL));

		Label modelSelectionLabel = new Label(container, SWT.NONE);
		modelSelectionLabel.setText("Target Source/TargetSectionModel:");
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).span(3, 1).applyTo(modelSelectionLabel);

		// list for selecting the target Source/TargetSectionModel
		//
		this.modelSelectionList = new List(container, SWT.NONE);
		this.modelSelectionList.setToolTipText(
				"Please specify the Source/TargetSectionModel into that the generated section(s) shall be added...");
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).span(3, 1).applyTo(this.modelSelectionList);

		this.modelSelectionList.addSelectionListener((SelectionListener2) e -> this.sectionModelSelectionChanged());

		// fill the wizard page
		this.setControl(container);
		this.setPageComplete(false);

	}

	/**
	 * This is called whenever the user selects a new {@link PAMTraM} model as target for the created sections. It
	 * updates the {@link #wizardData} as well as the list of available {@link #modelSelectionList}.
	 *
	 * @param pamtramPath
	 *            The absolute full path to the {@link PAMTraM} model selected by the user.
	 */
	private void mappingModelSelectionChanged(String pamtramPath) {

		if (!pamtramPath.endsWith("pamtram")) {
			return;
		}

		try {
			// delete the old model
			if (MappingModelSelectorPage.this.wizardData.getEditor() == null
					&& MappingModelSelectorPage.this.wizardData.getPamtram() != null) {
				MappingModelSelectorPage.this.wizardData.getPamtram().eResource().unload();
				MappingModelSelectorPage.this.wizardData.setPamtram(null);
			} else {
				MappingModelSelectorPage.this.wizardData.setEditor(null);
			}

			PamtramEditor editor = PamtramEditor.getEditor(pamtramPath, true);

			// we may use an exising editor and its editing domain for our work
			if (editor != null) {
				MappingModelSelectorPage.this.wizardData.setEditor(editor);
				MappingModelSelectorPage.this.wizardData.setPamtram(editor.getPamtram());

				// we have to load everything by ourselves
			} else {

				// set the resource of the new model
				MappingModelSelectorPage.this.setResource(pamtramPath);
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

	/**
	 * This is called whenever the user changed the selection in the {@link #modelSelectionList}. It updates the
	 * {@link #wizardData} as well as the <em>canFinish</em> state of the dialog.
	 *
	 */
	private void sectionModelSelectionChanged() {

		if (MappingModelSelectorPage.this.wizardData.getPamtram() == null
				|| MappingModelSelectorPage.this.wizardData.getSectionType() == SectionType.NONE
				|| MappingModelSelectorPage.this.wizardData.getSectionType() == SectionType.BOTH) {
			MappingModelSelectorPage.this.wizardData.setSectionModel(null);
		} else {
			MappingModelSelectorPage.this.wizardData.setSectionModel(
					this.sectionModels.get(MappingModelSelectorPage.this.modelSelectionList.getSelectionIndex()));

		}
		MappingModelSelectorPage.this.getContainer().updateButtons();
	}

	/**
	 * Get the target resource based on its resource path. If no resource exists, create a new one.
	 *
	 * @param resourcePath
	 *            The absolute path of the resource.
	 * @throws IOException
	 *             If the specified resource could not be created.
	 */
	private void setResource(String resourcePath) throws IOException {

		Resource targetModelResource;
		// get the target resource (if the resource does not exist, create a new one first)
		try {
			targetModelResource = this.rs.getResource(URI.createFileURI(resourcePath), true);
		} catch (Exception e) {
			targetModelResource = this.rs.createResource(URI.createFileURI(resourcePath));
		}
		// return without performing the action if the resource is null
		if (targetModelResource == null) {
			throw new IOException("Resource could not be created!");
		}

		// save the (newly created) resource so that it can be loaded
		targetModelResource.save(null);

		this.wizardData.setTargetModelResource(targetModelResource);
	}

	/**
	 * Load the target model (the PAMTraM instance).
	 *
	 * @throws IOException
	 *             If the {@link WizardData#getTargetModelResource() target model resource} does not contain a
	 *             {@link PAMTraM} model.
	 */
	private void loadModel() throws IOException {

		String modelPath = this.wizardData.getTargetModelResource().getURI().toFileString();

		ResourceSet resourceSet = this.rs;

		// the URI of the pamtram resource
		final URI pamtramUri = URI.createFileURI(modelPath);

		// load the pamtram model
		XMIResource pamtramResource = (XMIResource) resourceSet.getResource(pamtramUri, true);
		if (!(pamtramResource.getContents().get(0) instanceof PAMTraM)) {
			throw new IOException("The pamtram file does not seem to contain a pamtram instance. Aborting...");
		}
		this.wizardData.setPamtram((PAMTraM) pamtramResource.getContents().get(0));
	}

	/**
	 * Check the packages declared in the {@link PAMTraM} instance and whether the metamodel section to be generated can
	 * be used as source or target section.
	 */
	private void checkPackage() {

		EPackage ePackage = this.wizardData.getEPackage();

		PAMTraM pamtram = this.wizardData.getPamtram();

		// get the source packages
		Set<EPackage> sourcePackages = pamtram.getSourceSectionModels().stream()
				.map(SourceSectionModel::getMetaModelPackage).collect(Collectors.toSet());
		sourcePackages.addAll(pamtram.getSharedSourceSectionModels().stream()
				.map(SourceSectionModel::getMetaModelPackage).collect(Collectors.toSet()));
		// get the target packages
		Set<EPackage> targetPackages = pamtram.getTargetSectionModels().stream()
				.map(TargetSectionModel::getMetaModelPackage).collect(Collectors.toSet());
		targetPackages.addAll(pamtram.getSharedTargetSectionModels().stream()
				.map(TargetSectionModel::getMetaModelPackage).collect(Collectors.toSet()));

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
		//
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

		this.modelSelectionList.setItems(new String[] {});

		// update the list of section models to choose
		//
		PAMTraM pamtram = this.wizardData.getPamtram();
		if (pamtram == null || this.wizardData.getSectionType() == SectionType.NONE
				|| this.wizardData.getSectionType() == SectionType.BOTH) {
			return;
		}

		// Collect a SectionModels from the PAMTraM instance
		//
		Stream<SectionModel<?, ?, ?, ?>> sectionModelStream = this.wizardData.getSectionType() == SectionType.SOURCE
				? Stream.concat(this.wizardData.getPamtram().getSourceSectionModels().stream(),
						this.wizardData.getPamtram().getSharedSourceSectionModels().stream())
				: Stream.concat(this.wizardData.getPamtram().getTargetSectionModels().stream(),
						this.wizardData.getPamtram().getSharedTargetSectionModels().stream());

		// Filter those packages with the correct MetaModelPackage
		//
		this.sectionModels = sectionModelStream
				.filter(s -> this.wizardData.getEPackage().equals(s.getMetaModelPackage()))
				.collect(Collectors.toList());

		// Update the list
		//
		String prefix = this.wizardData.getSectionType() == SectionType.SOURCE ? "SourceSectionModel "
				: "TargetSectionModel ";
		this.sectionModels.stream().forEach(sectionModel -> this.modelSelectionList
				.add(prefix + (sectionModel.getName() != null ? sectionModel.getName() : "")));

		// Select the first entry
		//
		this.modelSelectionList.select(0);
		this.sectionModelSelectionChanged();
	}

	@Override
	public boolean isPageComplete() {

		return this.wizardData.getPamtram() != null && this.wizardData.getSectionType() != SectionType.NONE
				&& this.wizardData.getSectionType() != SectionType.BOTH && this.wizardData.getSectionModel() != null;
	}
}
