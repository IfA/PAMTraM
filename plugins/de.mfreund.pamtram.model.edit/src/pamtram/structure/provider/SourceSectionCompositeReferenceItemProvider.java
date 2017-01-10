/**
 */
package pamtram.structure.provider;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;

import pamtram.commands.ReplacingDragAndDropAddCommand;
import pamtram.provider.PamtramEditPlugin;
import pamtram.structure.SourceSection;
import pamtram.structure.SourceSectionClass;
import pamtram.structure.StructureFactory;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.provider.CompositeReferenceItemProvider;

/**
 * This is the item provider adapter for a {@link pamtram.structure.SourceSectionContainmentReference} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class SourceSectionCompositeReferenceItemProvider extends CompositeReferenceItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionCompositeReferenceItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This returns SourceSectionCompositeReference.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SourceSectionCompositeReference"));
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

		return super.getStyledText(object);
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached children and by creating
	 * a viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);
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

	@Override
	protected Command createDragAndDropCommand(EditingDomain domain, Object owner, float location, int operations,
			int operation, Collection<?> collection) {

		/*
		 * Allow to drop Sections onto this CompositeReference.
		 */

		if (collection.isEmpty()) {
			return UnexecutableCommand.INSTANCE;
		}

		HashMap<EObject, EObject> sourceSectionClassMap = new HashMap<>();

		for (Object object : collection) {

			if (object instanceof SourceSectionClass) {
				if (object instanceof SourceSection) {
					sourceSectionClassMap.put((SourceSectionClass) object,
							StructureFactory.eINSTANCE.createSourceSectionClass());
				} else {
					sourceSectionClassMap.put((SourceSectionClass) object, (SourceSectionClass) object);
				}
			} else {
				return UnexecutableCommand.INSTANCE;
			}
		}

		return new ReplacingDragAndDropAddCommand(domain, (EObject) owner,
				GenericPackage.Literals.COMPOSITE_REFERENCE__VALUE,
				(Collection<EObject>) sourceSectionClassMap.keySet(), sourceSectionClassMap.values());

	}

}
