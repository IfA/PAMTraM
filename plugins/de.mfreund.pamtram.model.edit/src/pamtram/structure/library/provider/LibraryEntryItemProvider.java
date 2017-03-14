/**
 */
package pamtram.structure.library.provider;

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
import org.eclipse.emf.edit.provider.IItemStyledLabelProvider;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptorDecorator;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage;
import pamtram.provider.PamtramEditPlugin;
import pamtram.structure.library.LibraryEntry;
import pamtram.structure.library.LibraryPackage;
import pamtram.util.PamtramItemProviderAdapter;

/**
 * This is the item provider adapter for a {@link pamtram.structure.library.LibraryEntry} object.
 * <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * @generated
 */
public class LibraryEntryItemProvider extends PamtramItemProviderAdapter
		implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource, IItemStyledLabelProvider {

	/**
	 * This keeps track of the children to be displayed. For this to work, the 'stateful' instead of the 'singleton'
	 * pattern needs to be specified in the GenModel.
	 */
	protected List<Object> children = null;

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LibraryEntryItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List<IItemPropertyDescriptor> getPropertyDescriptorsGen(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addLibraryFilePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds the property descriptors for the version, author and description properties of the
	 * {@link LibraryEntry#getOriginalLibraryEntry()} to the standard property descriptors.
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {

		if (this.itemPropertyDescriptors == null) {
			this.getPropertyDescriptorsGen(object);

			this.addVersionPropertyDescriptor(((LibraryEntry) object).getOriginalLibraryEntry());
			this.addAuthorPropertyDescriptor(((LibraryEntry) object).getOriginalLibraryEntry());
			this.addDescriptionPropertyDescriptor(((LibraryEntry) object).getOriginalLibraryEntry());
		}
		return this.itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Library File feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLibraryFilePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LibraryEntry_libraryFile_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LibraryEntry_libraryFile_feature", "_UI_LibraryEntry_type"),
				 LibraryPackage.Literals.LIBRARY_ENTRY__LIBRARY_FILE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the '<em><b>version</b></em>' feature of the
	 * {@link LibraryEntry#getOriginalLibraryEntry}.
	 */
	protected void addVersionPropertyDescriptor(de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry object) {

		de.tud.et.ifa.agtele.genlibrary.model.genlibrary.provider.LibraryEntryItemProvider libraryEntryItemProvider = (de.tud.et.ifa.agtele.genlibrary.model.genlibrary.provider.LibraryEntryItemProvider) ((ComposeableAdapterFactory) this.adapterFactory)
				.getRootAdapterFactory().adapt(object, IItemPropertySource.class);
		IItemPropertyDescriptor desc = libraryEntryItemProvider.getPropertyDescriptor(object,
				GenLibraryPackage.Literals.LIBRARY_ENTRY__VERSION);
		this.itemPropertyDescriptors.add(new ItemPropertyDescriptorDecorator(object, desc) {

			@Override
			public boolean canSetProperty(Object thisObject) {

				return false;
			}
		});
	}

	/**
	 * This adds a property descriptor for the '<em><b>author</b></em>' feature of the
	 * {@link LibraryEntry#getOriginalLibraryEntry}.
	 */
	protected void addAuthorPropertyDescriptor(de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry object) {

		de.tud.et.ifa.agtele.genlibrary.model.genlibrary.provider.LibraryEntryItemProvider libraryEntryItemProvider = (de.tud.et.ifa.agtele.genlibrary.model.genlibrary.provider.LibraryEntryItemProvider) ((ComposeableAdapterFactory) this.adapterFactory)
				.getRootAdapterFactory().adapt(object, IItemPropertySource.class);
		IItemPropertyDescriptor desc = libraryEntryItemProvider.getPropertyDescriptor(object,
				GenLibraryPackage.Literals.LIBRARY_ENTRY__AUTHOR);
		this.itemPropertyDescriptors.add(new ItemPropertyDescriptorDecorator(object, desc) {

			@Override
			public boolean canSetProperty(Object thisObject) {

				return false;
			}
		});
	}

	/**
	 * This adds a property descriptor for the '<em><b>description</b></em>' feature of the
	 * {@link LibraryEntry#getOriginalLibraryEntry}.
	 */
	protected void addDescriptionPropertyDescriptor(
			de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry object) {

		de.tud.et.ifa.agtele.genlibrary.model.genlibrary.provider.LibraryEntryItemProvider libraryEntryItemProvider = (de.tud.et.ifa.agtele.genlibrary.model.genlibrary.provider.LibraryEntryItemProvider) ((ComposeableAdapterFactory) this.adapterFactory)
				.getRootAdapterFactory().adapt(object, IItemPropertySource.class);
		IItemPropertyDescriptor desc = libraryEntryItemProvider.getPropertyDescriptor(object,
				GenLibraryPackage.Literals.LIBRARY_ENTRY__DESCRIPTION);
		this.itemPropertyDescriptors.add(new ItemPropertyDescriptorDecorator(object, desc) {

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
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(LibraryPackage.Literals.LIBRARY_ENTRY__PARAMETERS);
			childrenFeatures.add(LibraryPackage.Literals.LIBRARY_ENTRY__CLASSPATH);
			childrenFeatures.add(LibraryPackage.Literals.LIBRARY_ENTRY__ID);
			childrenFeatures.add(LibraryPackage.Literals.LIBRARY_ENTRY__RESOURCE_PARAMETERS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/LibraryEntry"));
	}

	/**
	 * Do not allow the parameters as direct children but instead allow the virtual
	 * '<em><b>ParameterDescription</b></em>'.
	 */
	@Override
	public Collection<?> getChildren(Object object) {

		if (this.children == null) {
			LibraryEntry libraryEntry = (LibraryEntry) object;
			this.children = new ArrayList<>();
			// add an ItemProvider for the Path
			this.children.add(this.wrap(libraryEntry, LibraryPackage.Literals.LIBRARY_ENTRY__CLASSPATH,
					libraryEntry.getClasspath(), CommandParameter.NO_INDEX));
			// add an ItemProvider for the ID
			this.children.add(this.wrap(libraryEntry, LibraryPackage.Literals.LIBRARY_ENTRY__ID, libraryEntry.getId(),
					CommandParameter.NO_INDEX));
			// add an ItemProvider for the virtual ParameterDescription
			this.children.add(new ParameterDescriptionItemProvider(this.adapterFactory, libraryEntry));
			// add an ItemProvider for the LibraryEntry (for some reason, the 'wrap(...)' method needs to be used
			this.children.add(this.wrap(libraryEntry, LibraryPackage.Literals.LIBRARY_ENTRY__ORIGINAL_LIBRARY_ENTRY,
					libraryEntry.getOriginalLibraryEntry(), CommandParameter.NO_INDEX));
		}
		return this.children;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return ((StyledString)getStyledText(object)).getString();
	}

	/**
	 * This returns the label styled text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Object getStyledText(Object object) {

		String label = ((LibraryEntry) object).getClasspath().getValue();
		StyledString styledLabel = new StyledString();
		if (label == null || label.length() == 0) {
			styledLabel.append(this.getString("_UI_LibraryEntry_type"), StyledString.Style.QUALIFIER_STYLER);
		} else {
			styledLabel.append(this.getString("_UI_LibraryEntry_type"), StyledString.Style.QUALIFIER_STYLER)
					.append(" " + label);
		}
		return styledLabel;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached children and by creating
	 * a viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 */
	@Override
	public void notifyChanged(Notification notification) {

		this.updateChildren(notification);

		/*
		 * Do not handle notifications that affect the virtual ParameterDescription.
		 */
		switch (notification.getFeatureID(LibraryEntry.class)) {
			case LibraryPackage.LIBRARY_ENTRY__LIBRARY_FILE:
			case LibraryPackage.LIBRARY_ENTRY__CLASSPATH:
			case LibraryPackage.LIBRARY_ENTRY__ID:
				this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case LibraryPackage.LIBRARY_ENTRY__ORIGINAL_LIBRARY_ENTRY:
				this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	protected Object createWrapper(EObject object, EStructuralFeature feature, Object value, int index) {

		if (feature.equals(LibraryPackage.Literals.LIBRARY_ENTRY__ORIGINAL_LIBRARY_ENTRY)) {
			// Instead of displaying the original LibrarEntry itself, we show only the LibraryItem inside the
			// LibraryEntry
			return new DelegatingWrapperItemProvider(
					((de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry) value).getLibraryItem(), object,
					GenLibraryPackage.Literals.LIBRARY_ENTRY__LIBRARY_ITEM, index, this.adapterFactory) {
			};
		} else {
			return value;
		}
	}

	/**
	 * This returns the {@link ParameterDescriptionItemProvider}s for this {@link LibraryEntry}
	 * 
	 * @return The {@link ParameterDescriptionItemProvider}s for this {@link LibraryEntry}
	 */
	public Object getParameters() {

		return this.children.get(2);
	}

	@Override
	public void dispose() {

		super.dispose();
		/*
		 * Also dispose the ParameterDescriptionItemProvider
		 */
		if (this.children != null) {
			((IDisposable) this.children.get(2)).dispose();
		}
	}

	/**
	 * This returns an {@link UnexecutableCommand} as we do not want to allow any manual adding, removing, etc.
	 */
	@Override
	public Command createCommand(Object object, EditingDomain domain, Class<? extends Command> commandClass,
			CommandParameter commandParameter) {

		return UnexecutableCommand.INSTANCE;
	}

}
