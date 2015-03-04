/**
 */
package pamtram.metamodel.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.DelegatingWrapperItemProvider;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptorDecorator;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.MetamodelPackage;
import pamtram.provider.PamtramEditPlugin;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage;

/**
 * This is the item provider adapter for a {@link pamtram.metamodel.LibraryEntry} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class LibraryEntryItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	
	/**
	 * This keeps track of the children to be displayed.
	 * For this to work, the 'stateful' instead of the 'singleton' pattern needs to be specified in the GenModel.
	 */
	protected List<Object> children = null;
	
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibraryEntryItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<IItemPropertyDescriptor> getPropertyDescriptorsGen(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addLibraryFilePropertyDescriptor(object);
			addPathPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}
	
	/**
	 * This adds the property descriptors for the version, author and description properties of the
	 * {@link LibraryEntry#getOriginalLibraryEntry()} to the standard property descriptors.
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			getPropertyDescriptorsGen(object);

			addVersionPropertyDescriptor(((LibraryEntry) object).getOriginalLibraryEntry());
			addAuthorPropertyDescriptor(((LibraryEntry) object).getOriginalLibraryEntry());
			addDescriptionPropertyDescriptor(((LibraryEntry) object).getOriginalLibraryEntry());
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Library File feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLibraryFilePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LibraryEntry_libraryFile_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LibraryEntry_libraryFile_feature", "_UI_LibraryEntry_type"),
				 MetamodelPackage.Literals.LIBRARY_ENTRY__LIBRARY_FILE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Path feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LibraryEntry_path_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LibraryEntry_path_feature", "_UI_LibraryEntry_type"),
				 MetamodelPackage.Literals.LIBRARY_ENTRY__PATH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}
	
	/**
	 * This adds a property descriptor for the '<em><b>version</b></em>' feature of the {@link LibraryEntry#getOriginalLibraryEntry}.
	 */
	protected void addVersionPropertyDescriptor(de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry object) {
		de.tud.et.ifa.agtele.genlibrary.model.genlibrary.provider.LibraryEntryItemProvider libraryEntryItemProvider = 
				(de.tud.et.ifa.agtele.genlibrary.model.genlibrary.provider.LibraryEntryItemProvider) ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory().adapt(object, IItemPropertySource.class);
		IItemPropertyDescriptor desc = libraryEntryItemProvider.getPropertyDescriptor(object, GenLibraryPackage.Literals.LIBRARY_ENTRY__VERSION);
		itemPropertyDescriptors.add(new ItemPropertyDescriptorDecorator(object, desc) {
			@Override
			public boolean canSetProperty(Object thisObject) {
				return false;
			}
		});
	}
	
	/**
	 * This adds a property descriptor for the '<em><b>author</b></em>' feature of the {@link LibraryEntry#getOriginalLibraryEntry}.
	 */
	protected void addAuthorPropertyDescriptor(de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry object) {
		de.tud.et.ifa.agtele.genlibrary.model.genlibrary.provider.LibraryEntryItemProvider libraryEntryItemProvider = 
				(de.tud.et.ifa.agtele.genlibrary.model.genlibrary.provider.LibraryEntryItemProvider) ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory().adapt(object, IItemPropertySource.class);
		IItemPropertyDescriptor desc = libraryEntryItemProvider.getPropertyDescriptor(object, GenLibraryPackage.Literals.LIBRARY_ENTRY__AUTHOR);
		itemPropertyDescriptors.add(new ItemPropertyDescriptorDecorator(object, desc) {
			@Override
			public boolean canSetProperty(Object thisObject) {
				return false;
			}
		});
	}
	
	/**
	 * This adds a property descriptor for the '<em><b>description</b></em>' feature of the {@link LibraryEntry#getOriginalLibraryEntry}.
	 */
	protected void addDescriptionPropertyDescriptor(de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry object) {
		de.tud.et.ifa.agtele.genlibrary.model.genlibrary.provider.LibraryEntryItemProvider libraryEntryItemProvider = 
				(de.tud.et.ifa.agtele.genlibrary.model.genlibrary.provider.LibraryEntryItemProvider) ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory().adapt(object, IItemPropertySource.class);
		IItemPropertyDescriptor desc = libraryEntryItemProvider.getPropertyDescriptor(object, GenLibraryPackage.Literals.LIBRARY_ENTRY__DESCRIPTION);
		itemPropertyDescriptors.add(new ItemPropertyDescriptorDecorator(object, desc) {
			@Override
			public boolean canSetProperty(Object thisObject) {
				return false;
			}
		});
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
			childrenFeatures.add(MetamodelPackage.Literals.LIBRARY_ENTRY__PARAMETERS);
			childrenFeatures.add(MetamodelPackage.Literals.LIBRARY_ENTRY__ORIGINAL_LIBRARY_ENTRY);
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
	 * This returns LibraryEntry.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/LibraryEntry"));
	}
	
	/**
	 * Do not allow the parameters as direct children but instead allow the virtual '<em><b>ParameterDescription</b></em>'.
	 */
	@Override
	public Collection<?> getChildren(Object object) {
		if(children == null) {
			LibraryEntry libraryEntry = (LibraryEntry) object;
			children = new ArrayList<>();
			// add an ItemProvider for the virtual ParameterDescription
			children.add(new ParameterDescriptionItemProvider(adapterFactory, libraryEntry));
			// add an ItemProvider for the LibraryEntry (for some reason, the 'wrap(...)' method needs to be used
			children.add(wrap(libraryEntry, MetamodelPackage.Literals.LIBRARY_ENTRY__ORIGINAL_LIBRARY_ENTRY, libraryEntry.getOriginalLibraryEntry(), CommandParameter.NO_INDEX));
		}
		return children;
	}
	
	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((LibraryEntry)object).getPath();
		return label == null || label.length() == 0 ?
			getString("_UI_LibraryEntry_type") :
			getString("_UI_LibraryEntry_type") + " " + label;
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		/*
		 * Do not handle notifications that affect the virtual ParameterDescription.
		 */
		switch (notification.getFeatureID(LibraryEntry.class)) {
			case MetamodelPackage.LIBRARY_ENTRY__LIBRARY_FILE:
			case MetamodelPackage.LIBRARY_ENTRY__PATH:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case MetamodelPackage.LIBRARY_ENTRY__ORIGINAL_LIBRARY_ENTRY:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
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
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return PamtramEditPlugin.INSTANCE;
	}
	
	/**
	 * Wrapping is needed because we want to display the target of the non-containment reference 
	 * {@link LibraryEntry#getOriginalLibraryEntry()} as child.
	 */
	@Override
	protected boolean isWrappingNeeded(Object object) {
		return true;
	}
	
	/**
	 * A special wrapper is needed for the {@link LibraryEntry#getOriginalLibraryEntry()} reference.
	 */
	@Override
	protected Object createWrapper(EObject object, EStructuralFeature feature,
			Object value, int index) {
		if(feature.equals(MetamodelPackage.Literals.LIBRARY_ENTRY__ORIGINAL_LIBRARY_ENTRY)) {
			// Instead of displaying the original LibrarEntry itself, we show only the LibraryItem inside the LibraryEntry
			return new DelegatingWrapperItemProvider(
					((de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry) value).getLibraryItem(), 
					object, 
					GenLibraryPackage.Literals.LIBRARY_ENTRY__LIBRARY_ITEM, 
					index, 
					adapterFactory) {};
		} else {
			return value;
		}
	}
	
	/**
	 * This returns the {@link ParameterDescriptionItemProvider}s for this {@link LibraryEntry}
	 * @return The {@link ParameterDescriptionItemProvider}s for this {@link LibraryEntry}
	 */
	public Object getParameters() {
		return children.get(0);
	}
	
	@Override
	public void dispose() {
		super.dispose();
		/*
		 * Also dispose the ParameterDescriptionItemProvider
		 */
		if(children != null) {
			((IDisposable) children.get(0)).dispose();
		}
	}
	
	/**
	 * This returns an {@link UnexecutableCommand} as we do not want to allow any manual adding, removing, etc.
	 */
	@Override
	public Command createCommand(Object object, EditingDomain domain,
			Class<? extends Command> commandClass,
			CommandParameter commandParameter) {
		return UnexecutableCommand.INSTANCE;
	}

}
