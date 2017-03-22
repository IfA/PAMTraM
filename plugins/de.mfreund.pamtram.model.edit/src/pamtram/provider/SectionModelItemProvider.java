/**
 */
package pamtram.provider;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;

import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import de.tud.et.ifa.agtele.emf.EPackageHelper;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import de.tud.et.ifa.agtele.ui.util.UIHelper;
import pamtram.PamtramPackage;
import pamtram.SectionModel;
import pamtram.structure.source.SourceFactory;
import pamtram.structure.target.TargetFactory;

/**
 * This is the item provider adapter for a {@link pamtram.SectionModel} object. <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class SectionModelItemProvider extends NamedElementItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SectionModelItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List<IItemPropertyDescriptor> getPropertyDescriptorsGen(Object object) {

		if (this.itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			this.addMetaModelPackagePropertyDescriptor(object);
		}
		return this.itemPropertyDescriptors;
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 *
	 * <!-- begin-user-doc --> Re-initialize the property descriptors every time to add/hide the
	 * 'SectionModelFilePropertyDescriptor' based on the currently selected object <!-- end-user-doc -->
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {

		this.itemPropertyDescriptors = null;
		this.getPropertyDescriptorsGen(object);

		this.addSectionModelFilePropertyDescriptor(object);
		return this.itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Meta Model Package feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addMetaModelPackagePropertyDescriptor(Object object) {

		// Use a custom item property descriptor that allows importing new EPackages from meta-model files
		//
		this.itemPropertyDescriptors.add(new MetaModelPackageItemPropertyDescriptor(
				((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
				this.getString("_UI_SectionModel_metaModelPackage_feature"),
				this.getString("_UI_PropertyDescriptor_description", "_UI_SectionModel_metaModelPackage_feature",
						"_UI_SectionModel_type"),
				PamtramPackage.Literals.SECTION_MODEL__META_MODEL_PACKAGE, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for shared SectionModels that displays the path to the file containing the
	 * SectionModel.
	 */
	protected void addSectionModelFilePropertyDescriptor(Object object) {

		// We only need this property descriptor for shared SectionModels
		//
		if (!(object instanceof SectionModel<?, ?, ?, ?>) || ((SectionModel<?, ?, ?, ?>) object).eContainer() != null) {
			return;
		}

		// As the SectionModel file is not represented by an EStructuralFeature, we need to create our own
		// ItemPropertyDescriptor for a 'virtual' feature (see https://www.eclipse.org/forums/index.php/t/124870/)
		//
		EAttribute sectionModelFile = EcoreFactory.eINSTANCE.createEAttribute();
		sectionModelFile.setEType(EcorePackage.eINSTANCE.getEString());
		IItemPropertyDescriptor descriptor = new ItemPropertyDescriptor(this.adapterFactory, "SectionModel File",
				"The file containing this shared SectionModel", sectionModelFile, false) {

			@Override
			public Object getPropertyValue(Object object) {

				// Simply return the value of the containing resource as URI
				//
				return ((SectionModel<?, ?, ?, ?>) object).eResource().getURI();
			}

			@Override
			public String getId(Object object) {

				return "sectionModelFile";
			}
		};
		this.itemPropertyDescriptors.add(descriptor);
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {

		if (this.childrenFeatures == null) {
			super.getChildrenFeatures(object);
			this.childrenFeatures.add(PamtramPackage.Literals.SECTION_MODEL__SECTIONS);
		}
		return this.childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {

		return ((StyledString) this.getStyledText(object)).getString();
	}

	/**
	 * This returns the label styled text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Object getStyledText(Object object) {

		String label = ((SectionModel<?, ?, ?, ?>) object).getName();
		StyledString styledLabel = new StyledString();
		if (((SectionModel<?, ?, ?, ?>) object).eContainer() == null) {
			styledLabel.append("Shared", StyledString.Style.QUALIFIER_STYLER);
		}
		if (label != null && label.length() > 0) {
			if (!styledLabel.getString().isEmpty()) {
				styledLabel.append(" ");
			}
			styledLabel.append(label);
		}

		if (((SectionModel<?, ?, ?, ?>) object).getMetaModelPackage() != null) {
			if (!styledLabel.getString().isEmpty()) {
				styledLabel.append(" ");
			}
			styledLabel.append(" (" + ((SectionModel<?, ?, ?, ?>) object).getMetaModelPackage().getNsPrefix() + ")",
					StyledString.Style.QUALIFIER_STYLER);
		}

		return styledLabel;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached children and by creating
	 * a viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void notifyChanged(Notification notification) {

		this.updateChildren(notification);

		switch (notification.getFeatureID(SectionModel.class)) {
			case PamtramPackage.SECTION_MODEL__SECTIONS:
				this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
			case PamtramPackage.SECTION_MODEL__META_MODEL_PACKAGE:
				// adapt the uri of the ePackage resource if necessary to force a namespace- instead of a file-based
				// serialization
				if (notification.getNewValue() instanceof EPackage) {
					EPackage ePackage = (EPackage) notification.getNewValue();
					if (ePackage.eResource() != null
							&& (ePackage.eResource().getURI().isFile() || ePackage.eResource().getURI().isPlatform())) {
						// we need to adapt
						EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);
						ePackage.eResource().setURI(URI.createURI(ePackage.getNsURI()));
					}
				}

		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that can be created
	 * under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {

		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(this.createChildParameter(PamtramPackage.Literals.SECTION_MODEL__SECTIONS,
				SourceFactory.eINSTANCE.createSourceSection()));

		newChildDescriptors.add(this.createChildParameter(PamtramPackage.Literals.SECTION_MODEL__SECTIONS,
				TargetFactory.eINSTANCE.createTargetSection()));
	}

	/**
	 * A custom {@link ItemPropertyDescriptor} that allows to import new {@link EPackage EPackages} on the fly.
	 *
	 * @author mfreund
	 */
	protected final class MetaModelPackageItemPropertyDescriptor extends ItemPropertyDescriptor {

		/**
		 * This represents the option that is presented to the user which allows to import packages from the registry.
		 */
		protected static final String ADD_MISSING_E_PACKAGE_FROM_GLOBAL_E_PACKAGE_REGISTRY = "... add missing EPackage from global EPackage registry";

		/**
		 * This represents the option that is presented to the user which allows to import packages from a meta-model
		 * file.
		 */
		protected static final String ADD_MISSING_E_PACKAGE_FROM_META_MODEL_FILE = "... add missing EPackage from meta-model file";

		/**
		 * This keeps track of the fact if a dialog is currently presented to the user to specify an EPackage to add.
		 */
		protected boolean isDialogActive = false;

		protected MetaModelPackageItemPropertyDescriptor(AdapterFactory adapterFactory, ResourceLocator resourceLocator,
				String displayName, String description, EStructuralFeature feature, boolean isSettable,
				boolean multiLine, boolean sortChoices, Object staticImage, String category, String[] filterFlags) {

			super(adapterFactory, resourceLocator, displayName, description, feature, isSettable, multiLine,
					sortChoices, staticImage, category, filterFlags);
		}

		@Override
		public Collection<?> getChoiceOfValues(Object object) {

			Collection<Object> choices = new ArrayList<>();

			// This allows the user to import more EPackages
			//
			choices.add(MetaModelPackageItemPropertyDescriptor.ADD_MISSING_E_PACKAGE_FROM_META_MODEL_FILE);
			choices.add(MetaModelPackageItemPropertyDescriptor.ADD_MISSING_E_PACKAGE_FROM_GLOBAL_E_PACKAGE_REGISTRY);

			choices.addAll(super.getChoiceOfValues(object));
			return choices;
		}

		@Override
		public void setPropertyValue(Object object, Object value) {

			// The user chose to add a new EPackage
			//
			if (object instanceof SectionModel<?, ?, ?, ?> && value instanceof String && (value
					.equals(MetaModelPackageItemPropertyDescriptor.ADD_MISSING_E_PACKAGE_FROM_META_MODEL_FILE)
					|| value.equals(
							MetaModelPackageItemPropertyDescriptor.ADD_MISSING_E_PACKAGE_FROM_GLOBAL_E_PACKAGE_REGISTRY))) {

				// As 'setPropertyValue' might get called multiple times, we make sure that the selection dialog is
				// presented to the user
				// only once
				//
				if (!this.isDialogActive) {

					this.isDialogActive = true;

					EPackage packageToSet = null;

					// Open the dialog and let the user specify the desired meta-model file / EPackage
					//
					if (value.equals(
							MetaModelPackageItemPropertyDescriptor.ADD_MISSING_E_PACKAGE_FROM_META_MODEL_FILE)) {

						packageToSet = this.importPackageFromMetaModelFile((SectionModel<?, ?, ?, ?>) object);

					} else if (value.equals(
							MetaModelPackageItemPropertyDescriptor.ADD_MISSING_E_PACKAGE_FROM_GLOBAL_E_PACKAGE_REGISTRY)) {

						packageToSet = this.importPackageFromRegistry();

					}

					// If a valid package has been specified by the user, set it as new property value
					//
					if (packageToSet != null) {
						super.setPropertyValue(object, packageToSet);
					}

					this.isDialogActive = false;

					return;
				}
			}

			super.setPropertyValue(object, value);
		}

		/**
		 * This opens a dialog which allows the user to specify an EPackage from the global {@link EPackage.Registry}.
		 * The selected package will be returned.
		 *
		 * @return The selected {@link EPackage} to be imported.
		 */
		protected EPackage importPackageFromRegistry() {

			class SelectFromRegistryDialog extends Dialog {

				/**
				 * The EPackage specified by the user
				 */
				private EPackage result;

				/**
				 * This creates an instance.
				 */
				public SelectFromRegistryDialog() {
					super(UIHelper.getShell(), SWT.CLOSE | SWT.MODELESS | SWT.BORDER | SWT.TITLE);
					this.setText("Select EPackage to import");
				}

				/**
				 * This opens the dialog and returns the {@link EPackage} specified by the user when the dialog is
				 * closed again.
				 *
				 * @return The {@link EPackage} specified by the user or '<em>null</em>' if no valid package has been
				 *         specified.
				 */
				public EPackage open() {

					// The shell to on that the dialog will be displayed
					//
					Shell shell = new Shell(this.getParent(), SWT.DIALOG_TRIM | SWT.RESIZE);
					shell.setMinimumSize(new Point(200, 100));
					shell.setSize(600, 100);
					shell.setText(this.getText());

					final GridLayout gridLayout = new GridLayout(2, false);
					gridLayout.marginTop = 10;
					shell.setLayout(gridLayout);

					// The combo box to display the namespace URIs
					//
					Combo combo = new Combo(shell, SWT.NONE);
					combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
					String[] nsUris = new String[EPackage.Registry.INSTANCE.size()];
					nsUris = EPackage.Registry.INSTANCE.keySet().toArray(nsUris);
					combo.setItems(nsUris);

					// The 'OK' button
					//
					Button button = new Button(shell, SWT.PUSH);
					button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
					button.setText("OK");
					button.addSelectionListener((SelectionListener2) e -> {
						SelectFromRegistryDialog.this.result = EPackage.Registry.INSTANCE.getEPackage(combo.getText());
						shell.close();
					});

					shell.open();
					shell.layout();

					Display display = this.getParent().getDisplay();
					while (!shell.isDisposed()) {
						if (!display.readAndDispatch()) {
							display.sleep();
						}
					}

					// The specified EPackage or null in case the dialog was aborted/no valid
					// namespace URI was specified
					//
					return this.result;
				}
			}

			// Open the dialog and return the resulting EPackage
			//
			return new SelectFromRegistryDialog().open();

		}

		/**
		 * This opens a dialog which allows the user to specify a meta-model file (XSD or Ecore). If necessary, the
		 * EPackages contained in the specified file are copied to a new Ecore resource in the 'metamodel' folder of the
		 * current project. Finally, the root package contained in the meta-model file is returned.
		 *
		 * @param sectionModel
		 *            The {@link SectionModel} to that a new EPackage shall be imported. This will be used to determine
		 *            the current pamtram project and thus the 'metamodel' folder to that the meta-model file shall be
		 *            copied.
		 * @return The {@link EPackage} to be imported.
		 */
		protected EPackage importPackageFromMetaModelFile(SectionModel<?, ?, ?, ?> sectionModel) {

			FileDialog fileDialog = new FileDialog(UIHelper.getShell(), SWT.OPEN);
			fileDialog.setText("Select Meta-model File...");

			IEditorInput editorInput = UIHelper.getCurrentEditorInput();
			if (editorInput == null || !(editorInput instanceof FileEditorInput)) {
				fileDialog.setFilterPath(null);
			} else {
				fileDialog.setFilterPath(new File(((FileEditorInput) editorInput).getURI().getPath()).getParentFile()
						.getParentFile().toString());
			}

			String[] filterExt = { "*.ecore", "*.xsd" };
			fileDialog.setFilterExtensions(filterExt);

			// Wait for the user to specify a file
			//
			String selected = fileDialog.open();

			// Check if there are EPackages specified in the file
			//
			Map<String, EPackage> packages = EPackageHelper.getEPackages(selected, false, false);

			EPackage packageToSet = null;
			boolean newResourceCreated = false;
			String newMetamodelFileName = "";
			if (packages != null) {

				try {
					// Copy the contents of the file to the 'metamodel' folder of the current project (if necessary)
					//
					Resource pamtramResource = ((EObject) sectionModel).eResource();
					newMetamodelFileName = selected.endsWith(".ecore") ? new File(selected).getName()
							: new File(selected).getName() + ".ecore";
					URI newMetamodelResourceURI = pamtramResource.getURI().trimSegments(2)
							.appendSegment(PamtramEditPlugin.INSTANCE.getString("METAMODEL_FOLDER_NAME"))
							.appendSegment(newMetamodelFileName);
					Resource newMetamodelResource = null;
					try {
						newMetamodelResource = new ResourceSetImpl().getResource(newMetamodelResourceURI, true);
					} catch (Exception e) {
						newResourceCreated = true;
						newMetamodelResource = new ResourceSetImpl().createResource(newMetamodelResourceURI);
						newMetamodelResource.getContents().addAll(AgteleEcoreUtil.getRootEPackages(packages.values()));
						newMetamodelResource.save(Collections.EMPTY_MAP);
					}

					// Determine the root package
					//
					if (newMetamodelResource != null && newMetamodelResource.getContents().get(0) instanceof EPackage) {
						packageToSet = (EPackage) newMetamodelResource.getContents().get(0);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			// Set the package
			//
			if (packageToSet != null) {
				MessageDialog.openInformation(UIHelper.getShell(), "Import EPackage from meta-model file",
						"Successfully imported EPackage '" + packageToSet.getName() + "'!"
								+ (newResourceCreated
										? " The meta-model has been copied to the 'metamodel' folder of your project ('"
												+ newMetamodelFileName + "')..."
										: ""));
			} else {
				MessageDialog.openError(UIHelper.getShell(), "Import EPackage from meta-model file",
						"An error occurred while importing an EPackage from the following file: '"
								+ new File(selected).getPath() + "'!");
			}

			return packageToSet;
		}
	}

}
