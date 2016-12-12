/**
 */
package pamtram.provider;


import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry;
import pamtram.PamtramPackage;
import pamtram.TargetSectionModel;
import pamtram.commands.DeleteLibraryEntryCommand;
import pamtram.commands.ReplacingDragAndDropAddCommand;
import pamtram.structure.StructureFactory;
import pamtram.structure.TargetSection;
import pamtram.structure.TargetSectionClass;

/**
 * This is the item provider adapter for a {@link pamtram.TargetSectionModel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TargetSectionModelItemProvider
extends SectionModelItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionModelItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT call 'super.getPropertyDescriptors' every time to add/hide the
	 *            'SectionModelFilePropertyDescriptor' based on the currently selected object
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {

		this.itemPropertyDescriptors = null;
		super.getPropertyDescriptors(object);
		return this.itemPropertyDescriptors;
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
			childrenFeatures.add(PamtramPackage.Literals.TARGET_SECTION_MODEL__LIBRARY_ELEMENTS);
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
	 * This returns TargetSectionModel.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/TargetSectionModel"));
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
		return super.getStyledText(object);
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(TargetSectionModel.class)) {
			case PamtramPackage.TARGET_SECTION_MODEL__LIBRARY_ELEMENTS:
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
	 * If one or more library entries are to be deleted, this does not use the default command but instead
	 * the custom {@link DeleteLibraryEntryCommand} that also removes the resource that holds the
	 * original {@link LibraryEntry}.
	 */
	@Override
	protected Command createRemoveCommand(EditingDomain domain, EObject owner,
			EStructuralFeature feature, Collection<?> collection) {
		if(feature.equals(PamtramPackage.Literals.TARGET_SECTION_MODEL__LIBRARY_ELEMENTS)) {
			// we need a compound command in case multiple entries are to be deleted
			CompoundCommand compoundCommand = new CompoundCommand();
			for (Object object : collection) {
				if(!(object instanceof pamtram.structure.LibraryEntry)) {
					throw new RuntimeException("Internal Error! This can only delete LibraryEntries...");
				} else {
					// create a DeleteLibraryEntryCommand for every entry to be deleted
					compoundCommand.append(new DeleteLibraryEntryCommand(domain, (TargetSectionModel) owner, (pamtram.structure.LibraryEntry) object));
				}
			}
			return compoundCommand;
		} else {
			return super.createRemoveCommand(domain, owner, feature, collection);
		}
	}

	@Override
	protected Command createDragAndDropCommand(EditingDomain domain, Object owner, float location, int operations,
			int operation, Collection<?> collection) {

		/*
		 *  Allow to drop Classes onto this SectionModel.
		 */

		if(collection.isEmpty()) {
			return UnexecutableCommand.INSTANCE;
		}

		HashMap<EObject, EObject> targetSectionClassMap = new HashMap<>();

		for (Object object : collection) {

			if(object instanceof TargetSectionClass) {
				if(object instanceof TargetSection) {
					targetSectionClassMap.put((TargetSectionClass) object, (TargetSectionClass) object);
				} else {
					targetSectionClassMap.put((TargetSectionClass) object, StructureFactory.eINSTANCE.createTargetSection());
				}
			} else {
				return UnexecutableCommand.INSTANCE;
			}
		}

		return  new ReplacingDragAndDropAddCommand(domain, (EObject) owner, PamtramPackage.Literals.SECTION_MODEL__META_MODEL_SECTIONS,
				(Collection<EObject>) targetSectionClassMap.keySet(), targetSectionClassMap.values());

	}
}
