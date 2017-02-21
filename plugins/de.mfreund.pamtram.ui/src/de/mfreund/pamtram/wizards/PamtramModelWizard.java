/**
 */
package de.mfreund.pamtram.wizards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.StringTokenizer;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

import de.mfreund.pamtram.pages.EPackageSpecificationPage;
import de.mfreund.pamtram.ui.PamtramUIPlugin;
import pamtram.PAMTraM;
import pamtram.PamtramFactory;
import pamtram.PamtramPackage;
import pamtram.SourceSectionModel;
import pamtram.TargetSectionModel;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingFactory;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingPackage;
import pamtram.provider.PamtramEditPlugin;
import pamtram.structure.StructureFactory;
import pamtram.structure.StructurePackage;
import pamtram.structure.source.SourceFactory;
import pamtram.structure.source.SourcePackage;
import pamtram.structure.source.SourceSection;
import pamtram.structure.target.TargetFactory;
import pamtram.structure.target.TargetPackage;
import pamtram.structure.target.TargetSection;

/**
 * This is a simple wizard for creating a new model file. <!-- begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class PamtramModelWizard extends Wizard implements INewWizard {

	/**
	 * The supported extensions for created files. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final List<String> FILE_EXTENSIONS = Collections.unmodifiableList(Arrays
			.asList(PamtramUIPlugin.INSTANCE.getString("_UI_PamtramEditorFilenameExtensions").split("\\s*,\\s*")));

	/**
	 * A formatted list of supported file extensions, suitable for display. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	public static final String FORMATTED_FILE_EXTENSIONS = PamtramUIPlugin.INSTANCE
			.getString("_UI_PamtramEditorFilenameExtensions").replaceAll("\\s*,\\s*", ", ");

	/**
	 * This caches an instance of the model package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected PamtramPackage pamtramPackage = PamtramPackage.eINSTANCE;

	/**
	 * This caches an instance of the model factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected PamtramFactory pamtramFactory = this.pamtramPackage.getPamtramFactory();

	/**
	 * This caches an instance of the 'structure' model sub-package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	protected StructurePackage structurePackage = StructurePackage.eINSTANCE;

	/**
	 * This caches an instance of the 'structure' model factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	protected StructureFactory structureFactory = this.structurePackage.getStructureFactory();

	/**
	 * This caches an instance of the 'source' model sub-package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	protected SourcePackage sourcePackage = SourcePackage.eINSTANCE;

	/**
	 * This caches an instance of the 'source' model factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	protected SourceFactory sourceFactory = this.sourcePackage.getSourceFactory();

	/**
	 * This caches an instance of the 'target' model sub-package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	protected TargetPackage targetPackage = TargetPackage.eINSTANCE;

	/**
	 * This caches an instance of the 'target' model factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	protected TargetFactory targetFactory = this.targetPackage.getTargetFactory();

	/**
	 * This caches an instance of the 'mapping' model sub-package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	protected MappingPackage mappingPackage = MappingPackage.eINSTANCE;

	/**
	 * This caches an instance of the 'mapping' model factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	protected MappingFactory mappingFactory = this.mappingPackage.getMappingFactory();

	/**
	 * This is the file creation page. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected PamtramModelWizardNewFileCreationPage newFileCreationPage;

	/**
	 * This is the initial object creation page. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected PamtramModelWizardInitialObjectCreationPage initialObjectCreationPage;

	/**
	 * The wizard page that allows to specify the EPackages for the SourceSectionModel.
	 */
	protected EPackageSpecificationPage sourceEPackageSpecificationPage;

	/**
	 * The wizard page that allows to specify the EPackages for the TargetSectionModel.
	 */
	protected EPackageSpecificationPage targetEPackageSpecificationPage;

	/**
	 * Remember the selection during initialization for populating the default container. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	protected IStructuredSelection selection;

	/**
	 * Remember the workbench during initialization. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected IWorkbench workbench;

	/**
	 * Caches the names of the types that can be created as the root object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	protected List<String> initialObjectNames;

	/**
	 * This just records the information. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {

		this.workbench = workbench;
		this.selection = selection;
		this.setWindowTitle(PamtramUIPlugin.INSTANCE.getString("_UI_Wizard_label"));
		this.setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE
				.getImageDescriptor(PamtramUIPlugin.INSTANCE.getImage("full/wizban/NewPamtram")));
	}

	/**
	 * Returns the names of the types that can be created as the root object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	protected Collection<String> getInitialObjectNames() {

		if (this.initialObjectNames == null) {
			this.initialObjectNames = new ArrayList<>();
			for (EClassifier eClassifier : this.pamtramPackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass) eClassifier;
					if (!eClass.isAbstract()) {
						this.initialObjectNames.add(eClass.getName());
					}
				}
			}
			Collections.sort(this.initialObjectNames, CommonPlugin.INSTANCE.getComparator());
		}
		return this.initialObjectNames;
	}

	/**
	 * Create a new model. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected EObject createInitialModelGen() {

		EClass eClass = (EClass) this.pamtramPackage
				.getEClassifier(this.initialObjectCreationPage.getInitialObjectName());
		EObject rootObject = this.pamtramFactory.create(eClass);
		return rootObject;
	}

	/**
	 * Create a new model. <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	protected EObject createInitialModel() {

		// generate a Pamtram instance
		PAMTraM pamtram = this.pamtramFactory.createPAMTraM();

		// add a source section model for every source ePackage
		EPackage.Registry sourceRegistry = this.sourceEPackageSpecificationPage.getRegistry();
		if (sourceRegistry.values().isEmpty()) {
			pamtram.getSourceSectionModels().add(this.pamtramFactory.createSourceSectionModel());
		} else {
			for (Object ePackage : sourceRegistry.values()) {
				if (!(ePackage instanceof EPackage)) {
					continue;
				}
				SourceSectionModel ssm = this.pamtramFactory.createSourceSectionModel();
				// set the ePackage of the source section model
				ssm.setMetaModelPackage((EPackage) ePackage);
				ssm.setName(((EPackage) ePackage).getName());
				pamtram.getSourceSectionModels().add(ssm);
			}
		}
		for (SourceSectionModel ssm : pamtram.getSourceSectionModels()) {
			// add an empty source section to each source section model
			SourceSection sourceSection = this.sourceFactory.createSourceSection();
			sourceSection.setName("source");
			ssm.getSections().add(sourceSection);
		}

		// add a condition model
		pamtram.getConditionModels().add(this.pamtramFactory.createConditionModel());

		// add a target section model for every target ePackage
		EPackage.Registry targetRegistry = this.targetEPackageSpecificationPage.getRegistry();
		if (targetRegistry.values().isEmpty()) {
			pamtram.getTargetSectionModels().add(this.pamtramFactory.createTargetSectionModel());
		} else {
			for (Object ePackage : targetRegistry.values()) {
				if (!(ePackage instanceof EPackage)) {
					continue;
				}
				TargetSectionModel tsm = this.pamtramFactory.createTargetSectionModel();
				// set the ePackage of the source section model
				tsm.setMetaModelPackage((EPackage) ePackage);
				tsm.setName(((EPackage) ePackage).getName());
				pamtram.getTargetSectionModels().add(tsm);
			}
		}
		// add an empty target section to each target section model
		for (TargetSectionModel tsm : pamtram.getTargetSectionModels()) {
			MappingHintGroup mappingHintGroup = this.mappingFactory.createMappingHintGroup();
			TargetSection targetSection = this.targetFactory.createTargetSection();
			targetSection.setName("target");
			pamtram.getTargetSectionModels().get(0).getSections().add(targetSection);
		}

		// add a mapping model
		pamtram.getMappingModels().add(this.pamtramFactory.createMappingModel());
		// add a simple mapping to the mapping model
		Mapping mapping = this.mappingFactory.createMapping();
		MappingHintGroup mappingHintGroup = this.mappingFactory.createMappingHintGroup();
		mapping.setSourceSection(pamtram.getSourceSectionModels().get(0).getSections().get(0));
		mapping.getMappingHintGroups().add(mappingHintGroup);
		mappingHintGroup.setTargetSection(pamtram.getTargetSectionModels().get(0).getSections().get(0));
		pamtram.getMappingModels().get(0).getMappings().add(mapping);

		return pamtram;
	}

	/**
	 * Do the work after everything is specified. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean performFinishGen() {

		try {
			// Remember the file.
			//
			final IFile modelFile = this.getModelFile();

			// Do the work within an operation.
			//
			WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {

				@Override
				protected void execute(IProgressMonitor progressMonitor) {

					try {
						// Create a resource set
						//
						ResourceSet resourceSet = new ResourceSetImpl();

						// Get the URI of the model file.
						//
						URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);

						// Create a resource for this file.
						//
						Resource resource = resourceSet.createResource(fileURI);

						// Add the initial model object to the contents.
						//
						EObject rootObject = PamtramModelWizard.this.createInitialModel();
						if (rootObject != null) {
							resource.getContents().add(rootObject);
						}

						// Save the contents of the resource to the file system.
						//
						Map<Object, Object> options = new HashMap<>();
						options.put(XMLResource.OPTION_ENCODING,
								PamtramModelWizard.this.initialObjectCreationPage.getEncoding());
						resource.save(options);
					} catch (Exception exception) {
						PamtramUIPlugin.INSTANCE.log(exception);
					} finally {
						progressMonitor.done();
					}
				}
			};

			this.getContainer().run(false, false, operation);

			// Select the new file resource in the current view.
			//
			IWorkbenchWindow workbenchWindow = this.workbench.getActiveWorkbenchWindow();
			IWorkbenchPage page = workbenchWindow.getActivePage();
			final IWorkbenchPart activePart = page.getActivePart();
			if (activePart instanceof ISetSelectionTarget) {
				final ISelection targetSelection = new StructuredSelection(modelFile);
				this.getShell().getDisplay()
						.asyncExec(() -> ((ISetSelectionTarget) activePart).selectReveal(targetSelection));
			}

			// Open an editor on the new file.
			//
			try {
				page.openEditor(new FileEditorInput(modelFile), this.workbench.getEditorRegistry()
						.getDefaultEditor(modelFile.getFullPath().toString()).getId());
			} catch (PartInitException exception) {
				MessageDialog.openError(workbenchWindow.getShell(),
						PamtramUIPlugin.INSTANCE.getString("_UI_OpenEditorError_label"), exception.getMessage());
				return false;
			}

			return true;
		} catch (Exception exception) {
			PamtramUIPlugin.INSTANCE.log(exception);
			return false;
		}
	}

	/**
	 * Do the work after everything is specified. <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	@Override
	public boolean performFinish() {

		try {
			// Remember the file.
			//
			final IFile modelFile = this.getModelFile();

			// Do the work within an operation.
			//
			WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {

				@Override
				protected void execute(IProgressMonitor progressMonitor) {

					try {
						// Create a resource set
						//
						ResourceSet resourceSet = new ResourceSetImpl();

						// Get the URI of the model file.
						//
						URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);

						// Create a resource for this file.
						//
						Resource resource = resourceSet.createResource(fileURI);

						// Add the initial model object to the contents.
						//
						EObject rootObject = PamtramModelWizard.this.createInitialModel();
						if (rootObject != null) {
							resource.getContents().add(rootObject);
						}

						// Save the contents of the resource to the file system.
						//
						Map<Object, Object> options = new HashMap<>();
						options.put(XMLResource.OPTION_ENCODING, "UTF-8");
						resource.save(options);
					} catch (Exception exception) {
						PamtramUIPlugin.INSTANCE.log(exception);
					} finally {
						progressMonitor.done();
					}
				}
			};

			this.getContainer().run(false, false, operation);

			// Select the new file resource in the current view.
			//
			IWorkbenchWindow workbenchWindow = this.workbench.getActiveWorkbenchWindow();
			IWorkbenchPage page = workbenchWindow.getActivePage();
			final IWorkbenchPart activePart = page.getActivePart();
			if (activePart instanceof ISetSelectionTarget) {
				final ISelection targetSelection = new StructuredSelection(modelFile);
				this.getShell().getDisplay()
						.asyncExec(() -> ((ISetSelectionTarget) activePart).selectReveal(targetSelection));
			}

			// Open an editor on the new file.
			//
			try {
				page.openEditor(new FileEditorInput(modelFile), this.workbench.getEditorRegistry()
						.getDefaultEditor(modelFile.getFullPath().toString()).getId());
			} catch (PartInitException exception) {
				MessageDialog.openError(workbenchWindow.getShell(),
						PamtramUIPlugin.INSTANCE.getString("_UI_OpenEditorError_label"), exception.getMessage());
				return false;
			}

			return true;
		} catch (Exception exception) {
			PamtramUIPlugin.INSTANCE.log(exception);
			return false;
		}
	}

	/**
	 * This is the one page of the wizard. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public class PamtramModelWizardNewFileCreationPage extends WizardNewFileCreationPage {

		/**
		 * Pass in the selection. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		public PamtramModelWizardNewFileCreationPage(String pageId, IStructuredSelection selection) {
			super(pageId, selection);
		}

		/**
		 * The framework calls this to see if the file is correct. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		@Override
		protected boolean validatePage() {

			if (super.validatePage()) {
				String extension = new Path(this.getFileName()).getFileExtension();
				if (extension == null || !PamtramModelWizard.FILE_EXTENSIONS.contains(extension)) {
					String key = PamtramModelWizard.FILE_EXTENSIONS.size() > 1 ? "_WARN_FilenameExtensions"
							: "_WARN_FilenameExtension";
					this.setErrorMessage(PamtramUIPlugin.INSTANCE.getString(key,
							new Object[] { PamtramModelWizard.FORMATTED_FILE_EXTENSIONS }));
					return false;
				}
				return true;
			}
			return false;
		}

		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		public IFile getModelFile() {

			return ResourcesPlugin.getWorkspace().getRoot()
					.getFile(this.getContainerFullPath().append(this.getFileName()));
		}
	}

	/**
	 * This is the page where the type of object to create is selected. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public class PamtramModelWizardInitialObjectCreationPage extends WizardPage {

		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		protected Combo initialObjectField;

		/**
		 * @generated <!-- begin-user-doc --> <!-- end-user-doc -->
		 */
		protected List<String> encodings;

		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		protected Combo encodingField;

		/**
		 * Pass in the selection. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		public PamtramModelWizardInitialObjectCreationPage(String pageId) {
			super(pageId);
		}

		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		@Override
		public void createControl(Composite parent) {

			Composite composite = new Composite(parent, SWT.NONE);
			{
				GridLayout layout = new GridLayout();
				layout.numColumns = 1;
				layout.verticalSpacing = 12;
				composite.setLayout(layout);

				GridData data = new GridData();
				data.verticalAlignment = GridData.FILL;
				data.grabExcessVerticalSpace = true;
				data.horizontalAlignment = GridData.FILL;
				composite.setLayoutData(data);
			}

			Label containerLabel = new Label(composite, SWT.LEFT);
			{
				containerLabel.setText(PamtramUIPlugin.INSTANCE.getString("_UI_ModelObject"));

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				containerLabel.setLayoutData(data);
			}

			this.initialObjectField = new Combo(composite, SWT.BORDER);
			{
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.grabExcessHorizontalSpace = true;
				this.initialObjectField.setLayoutData(data);
			}

			for (String objectName : PamtramModelWizard.this.getInitialObjectNames()) {
				this.initialObjectField.add(this.getLabel(objectName));
			}

			if (this.initialObjectField.getItemCount() == 1) {
				this.initialObjectField.select(0);
			}
			this.initialObjectField.addModifyListener(this.validator);

			Label encodingLabel = new Label(composite, SWT.LEFT);
			{
				encodingLabel.setText(PamtramUIPlugin.INSTANCE.getString("_UI_XMLEncoding"));

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				encodingLabel.setLayoutData(data);
			}
			this.encodingField = new Combo(composite, SWT.BORDER);
			{
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.grabExcessHorizontalSpace = true;
				this.encodingField.setLayoutData(data);
			}

			for (String encoding : this.getEncodings()) {
				this.encodingField.add(encoding);
			}

			this.encodingField.select(0);
			this.encodingField.addModifyListener(this.validator);

			this.setPageComplete(this.validatePage());
			this.setControl(composite);
		}

		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		protected ModifyListener validator = e -> PamtramModelWizardInitialObjectCreationPage.this
				.setPageComplete(PamtramModelWizardInitialObjectCreationPage.this.validatePage());

		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		protected boolean validatePage() {

			return this.getInitialObjectName() != null && this.getEncodings().contains(this.encodingField.getText());
		}

		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		@Override
		public void setVisible(boolean visible) {

			super.setVisible(visible);
			if (visible) {
				if (this.initialObjectField.getItemCount() == 1) {
					this.initialObjectField.clearSelection();
					this.encodingField.setFocus();
				} else {
					this.encodingField.clearSelection();
					this.initialObjectField.setFocus();
				}
			}
		}

		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		public String getInitialObjectName() {

			String label = this.initialObjectField.getText();

			for (String name : PamtramModelWizard.this.getInitialObjectNames()) {
				if (this.getLabel(name).equals(label)) {
					return name;
				}
			}
			return null;
		}

		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		public String getEncoding() {

			return this.encodingField.getText();
		}

		/**
		 * Returns the label for the specified type name. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		protected String getLabel(String typeName) {

			try {
				return PamtramEditPlugin.INSTANCE.getString("_UI_" + typeName + "_type");
			} catch (MissingResourceException mre) {
				PamtramUIPlugin.INSTANCE.log(mre);
			}
			return typeName;
		}

		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		protected Collection<String> getEncodings() {

			if (this.encodings == null) {
				this.encodings = new ArrayList<>();
				for (StringTokenizer stringTokenizer = new StringTokenizer(
						PamtramUIPlugin.INSTANCE.getString("_UI_XMLEncodingChoices")); stringTokenizer
								.hasMoreTokens();) {
					this.encodings.add(stringTokenizer.nextToken());
				}
			}
			return this.encodings;
		}
	}

	/**
	 * The framework calls this to create the contents of the wizard. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void addPagesGen() {

		// Create a page, set the title, and the initial model file name.
		//
		this.newFileCreationPage = new PamtramModelWizardNewFileCreationPage("Whatever", this.selection);
		this.newFileCreationPage.setTitle(PamtramUIPlugin.INSTANCE.getString("_UI_PamtramModelWizard_label"));
		this.newFileCreationPage
				.setDescription(PamtramUIPlugin.INSTANCE.getString("_UI_PamtramModelWizard_description"));
		this.newFileCreationPage.setFileName(PamtramUIPlugin.INSTANCE.getString("_UI_PamtramEditorFilenameDefaultBase")
				+ "." + PamtramModelWizard.FILE_EXTENSIONS.get(0));
		this.addPage(this.newFileCreationPage);

		// Try and get the resource selection to determine a current directory for the file dialog.
		//
		if (this.selection != null && !this.selection.isEmpty()) {
			// Get the resource...
			//
			Object selectedElement = this.selection.iterator().next();
			if (selectedElement instanceof IResource) {
				// Get the resource parent, if its a file.
				//
				IResource selectedResource = (IResource) selectedElement;
				if (selectedResource.getType() == IResource.FILE) {
					selectedResource = selectedResource.getParent();
				}

				// This gives us a directory...
				//
				if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
					// Set this for the container.
					//
					this.newFileCreationPage.setContainerFullPath(selectedResource.getFullPath());

					// Make up a unique new name here.
					//
					String defaultModelBaseFilename = PamtramUIPlugin.INSTANCE
							.getString("_UI_PamtramEditorFilenameDefaultBase");
					String defaultModelFilenameExtension = PamtramModelWizard.FILE_EXTENSIONS.get(0);
					String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
					for (int i = 1; ((IContainer) selectedResource).findMember(modelFilename) != null; ++i) {
						modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
					}
					this.newFileCreationPage.setFileName(modelFilename);
				}
			}
		}
		this.initialObjectCreationPage = new PamtramModelWizardInitialObjectCreationPage("Whatever2");
		this.initialObjectCreationPage.setTitle(PamtramUIPlugin.INSTANCE.getString("_UI_PamtramModelWizard_label"));
		this.initialObjectCreationPage
				.setDescription(PamtramUIPlugin.INSTANCE.getString("_UI_Wizard_initial_object_description"));
		this.addPage(this.initialObjectCreationPage);
	}

	/**
	 * The framework calls this to create the contents of the wizard. <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	@Override
	public void addPages() {

		// Create a page, set the title, and the initial model file name.
		//
		this.newFileCreationPage = new PamtramModelWizardNewFileCreationPage("Whatever", this.selection);
		this.newFileCreationPage.setTitle(PamtramUIPlugin.INSTANCE.getString("_UI_PamtramModelWizard_label"));
		this.newFileCreationPage
				.setDescription(PamtramUIPlugin.INSTANCE.getString("_UI_PamtramModelWizard_description"));
		this.newFileCreationPage.setFileName(PamtramUIPlugin.INSTANCE.getString("_UI_PamtramEditorFilenameDefaultBase")
				+ "." + PamtramModelWizard.FILE_EXTENSIONS.get(0));
		this.addPage(this.newFileCreationPage);

		// Try and get the resource selection to determine a current directory for the file dialog.
		//
		if (this.selection != null && !this.selection.isEmpty()) {
			// Get the resource...
			//
			Object selectedElement = this.selection.iterator().next();
			if (selectedElement instanceof IResource) {
				// Get the resource parent, if its a file.
				//
				IResource selectedResource = (IResource) selectedElement;
				if (selectedResource.getType() == IResource.FILE) {
					selectedResource = selectedResource.getParent();
				}

				// This gives us a directory...
				//
				if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
					// Set this for the container.
					//
					this.newFileCreationPage.setContainerFullPath(selectedResource.getFullPath());

					// Make up a unique new name here.
					//
					String defaultModelBaseFilename = PamtramUIPlugin.INSTANCE
							.getString("_UI_PamtramEditorFilenameDefaultBase");
					String defaultModelFilenameExtension = PamtramModelWizard.FILE_EXTENSIONS.get(0);
					String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
					for (int i = 1; ((IContainer) selectedResource).findMember(modelFilename) != null; ++i) {
						modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
					}
					this.newFileCreationPage.setFileName(modelFilename);
				}
			}
		}

		this.sourceEPackageSpecificationPage = new EPackageSpecificationPage("Whatever3",
				"Source EPackage specification", "Specify the ePackages of the source sections.", null);
		this.addPage(this.sourceEPackageSpecificationPage);
		this.targetEPackageSpecificationPage = new EPackageSpecificationPage("Whatever3",
				"Target EPackage specification", "Specify the ePackages of the target sections.", null);
		this.addPage(this.targetEPackageSpecificationPage);
	}

	/**
	 * Get the file from the page. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public IFile getModelFile() {

		return this.newFileCreationPage.getModelFile();
	}

}
