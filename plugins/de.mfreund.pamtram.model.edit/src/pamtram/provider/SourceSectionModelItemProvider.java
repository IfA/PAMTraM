/**
 */
package pamtram.provider;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;

import pamtram.PamtramPackage;
import pamtram.commands.ReplacingDragAndDropAddCommand;
import pamtram.structure.source.SourceFactory;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionClass;

/**
 * This is the item provider adapter for a {@link pamtram.SourceSectionModel} object.
 * <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * @generated
 */
public class SourceSectionModelItemProvider extends SectionModelItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionModelItemProvider(AdapterFactory adapterFactory) {
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
	 * This returns SourceSectionModel.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SourceSectionModel"));
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

	@Override
	protected Command createDragAndDropCommand(EditingDomain domain, Object owner, float location, int operations,
			int operation, Collection<?> collection) {

		/*
		 * Allow to drop Classes onto this SectionModel.
		 */

		if (collection.isEmpty()) {
			return UnexecutableCommand.INSTANCE;
		}

		HashMap<EObject, EObject> sourceSectionClassMap = new HashMap<>();

		for (Object object : collection) {

			if (object instanceof SourceSectionClass) {
				if (object instanceof SourceSection) {
					sourceSectionClassMap.put((SourceSectionClass) object, (SourceSectionClass) object);
				} else {
					sourceSectionClassMap.put((SourceSectionClass) object,
							SourceFactory.eINSTANCE.createSourceSection());
				}
			} else {
				return UnexecutableCommand.INSTANCE;
			}
		}

		return new ReplacingDragAndDropAddCommand(domain, (EObject) owner,
				PamtramPackage.Literals.SECTION_MODEL__SECTIONS,
				(Collection<EObject>) sourceSectionClassMap.keySet(), sourceSectionClassMap.values());

	}

}
