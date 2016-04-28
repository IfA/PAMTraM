/**
 */
package pamtram.provider;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import de.tud.et.ifa.agtele.emf.EPackageHelper;
import de.tud.et.ifa.agtele.resources.ResourceHelper;
import de.tud.et.ifa.agtele.ui.util.UIHelper;
import pamtram.PamtramPackage;
import pamtram.SectionModel;
import pamtram.metamodel.MetamodelFactory;

/**
 * This is the item provider adapter for a {@link pamtram.SectionModel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SectionModelItemProvider extends NamedElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SectionModelItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addMetaModelPackagePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Meta Model Package feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addMetaModelPackagePropertyDescriptor(Object object) {
		
		// Use a custom item property descriptor that allows importing new EPackages from meta-model files
		//
		itemPropertyDescriptors.add
			(new MetaModelPackageItemPropertyDescriptor(
					((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), 
					getResourceLocator(), 
					getString("_UI_SectionModel_metaModelPackage_feature"), 
					getString("_UI_PropertyDescriptor_description", "_UI_SectionModel_metaModelPackage_feature", "_UI_SectionModel_type"), 
					PamtramPackage.Literals.SECTION_MODEL__META_MODEL_PACKAGE,
					true, false, true, null, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(PamtramPackage.Literals.SECTION_MODEL__META_MODEL_SECTIONS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return ((StyledString)getStyledText(object)).getString();
	}

	/**
	 * This returns the label styled text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getStyledText(Object object) {
		String label = ((SectionModel<?, ?, ?, ?>)object).getName();
		StyledString styledLabel = new StyledString();
		if (label != null && label.length() > 0) {
			styledLabel.append(" " + label);
		}

		if(((SectionModel<?, ?, ?, ?>)object).getMetaModelPackage() != null) {
			styledLabel.append(" (" + ((SectionModel<?, ?, ?, ?>)object).getMetaModelPackage().getNsPrefix() + ")", StyledString.Style.QUALIFIER_STYLER);
		}

		return styledLabel;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(SectionModel.class)) {
			case PamtramPackage.SECTION_MODEL__META_MODEL_SECTIONS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
			case PamtramPackage.SECTION_MODEL__META_MODEL_PACKAGE:
				// adapt the uri of the ePackage resource if necessary to force a namespace- instead of a file-based
				// serialization
				if(notification.getNewValue() instanceof EPackage) {
					EPackage ePackage = (EPackage) notification.getNewValue();
					if(ePackage.eResource() != null && (ePackage.eResource().getURI().isFile() ||
							ePackage.eResource().getURI().isPlatform())) {
						// we need to adapt
						EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);
						ePackage.eResource().setURI(URI.createURI(ePackage.getNsURI()));										
					}
				}
				
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(PamtramPackage.Literals.SECTION_MODEL__META_MODEL_SECTIONS,
				 MetamodelFactory.eINSTANCE.createSourceSection()));

		newChildDescriptors.add
			(createChildParameter
				(PamtramPackage.Literals.SECTION_MODEL__META_MODEL_SECTIONS,
				 MetamodelFactory.eINSTANCE.createTargetSection()));
	}

	/**
	 * A custom {@link ItemPropertyDescriptor} that allows to import new {@link EPackage EPackages} on the fly.
	 * 
	 * @author mfreund
	 */
	private final class MetaModelPackageItemPropertyDescriptor extends ItemPropertyDescriptor {
		// This keeps track of the fact if a dialog is currently presented to the user to specify an EPackage to add
		//
		private boolean isDialogActive = false;
	
		private MetaModelPackageItemPropertyDescriptor(AdapterFactory adapterFactory, ResourceLocator resourceLocator,
				String displayName, String description, EStructuralFeature feature, boolean isSettable,
				boolean multiLine, boolean sortChoices, Object staticImage, String category, String[] filterFlags) {
			super(adapterFactory, resourceLocator, displayName, description, feature, isSettable, multiLine,
					sortChoices, staticImage, category, filterFlags);
		}
	
		@Override
		public Collection<?> getChoiceOfValues(Object object) {
			Collection<Object> choices = new ArrayList<>();
			choices.add("... add missing EPackage from meta-model file");
			choices.addAll(super.getChoiceOfValues(object));
			return choices;
		}
	
		@Override
		public void setPropertyValue(Object object, Object value) {
			
			// The user chose to register a new EPackage
			//
			if(object instanceof SectionModel<?,?,?,?> && value instanceof String && 
						value.equals("... add missing EPackage from meta-model file")) {
				
				// As 'setPropertyValue' might get called multiple times, we make sure that the selection dialog is presented to the user
				// only once
				//
				if(!isDialogActive) {
					isDialogActive = true;
					
					FileDialog fileDialog = new FileDialog(UIHelper.getShell(), SWT.OPEN);
					fileDialog.setText("Select Meta-model File...");
					
					IEditorInput editorInput = UIHelper.getCurrentEditorInput();
					if(editorInput == null || !(editorInput instanceof FileEditorInput)) {
						fileDialog.setFilterPath(null);								
					} else {
						fileDialog.setFilterPath(new File(((FileEditorInput) editorInput).getURI().getPath()).getParentFile().getParentFile().toString()); 
					}
					
					String[] filterExt = { "*.ecore", "*.xsd"};
					fileDialog.setFilterExtensions(filterExt);
					
					// Wait for the user to specify a file
					//
					String selected = fileDialog.open();
	
					// Check if there are EPackages specified in the file
					//
					HashMap<String, EPackage> packages = EPackageHelper.getEPackages(selected, false, false);
					
					EPackage packageToSet = null;
					boolean newResourceCreated = false;
					String newMetamodelFileName = "";
					if(packages != null) {
						
						try {
							// Copy the contents of the file to the 'metamodel' folder of the current project (if necessary)
							//
							Resource pamtramResource = ((EObject) object).eResource();
							newMetamodelFileName = (selected.endsWith(".ecore") ? new File(selected).getName() : new File(selected).getName() + ".ecore");
							URI newMetamodelResourceURI = pamtramResource.getURI().trimSegments(2).appendSegment("metamodel").appendSegment(newMetamodelFileName);
							Resource newMetamodelResource = null;
							try {
								newMetamodelResource = (new ResourceSetImpl()).getResource(newMetamodelResourceURI, true);
							} catch (Exception e) {
								newResourceCreated = true;
								newMetamodelResource = (new ResourceSetImpl()).createResource(newMetamodelResourceURI);
								newMetamodelResource.getContents().add(AgteleEcoreUtil.getRootEPackage(packages.values().iterator().next()));
								newMetamodelResource.save(Collections.EMPTY_MAP);										
							}
							
							// Determine the root package
							//
							if(newMetamodelResource != null && newMetamodelResource.getContents().get(0) instanceof EPackage) {
								packageToSet = (EPackage) newMetamodelResource.getContents().get(0);
							}
						} catch(Exception e) {
							e.printStackTrace();
						}
						
					}
					
					// Set the package
					//
					if(packageToSet != null) {
						super.setPropertyValue(object, packageToSet);
						MessageDialog.openInformation(
								UIHelper.getShell(),
								"Import EPackage from meta-model file",
								"Successfully imported EPackage '" + packageToSet.getName() + "'!" + 
								(newResourceCreated ? " The meta-model has been copied to the 'metamodel' folder of your project ('" + packageToSet.eResource().getURI().lastSegment() +
										"." + packageToSet.eResource().getURI().fileExtension() + "')..." : ""));
					} else {
						MessageDialog.openError(
								UIHelper.getShell(),
								"Import EPackage from meta-model file",
								"An error occurred while importing an EPackage from the following file: '"
								+ (new File(selected)).getPath() + "'!");
					}
					isDialogActive = false;
				}
					
			} else {
				super.setPropertyValue(object, value);
			}
		}
	}

}
