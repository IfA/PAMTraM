/**
 */
package pamtram.structure.generic.provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;

import de.tud.et.ifa.agtele.emf.edit.commands.BasicDragAndDropCompoundCommand;
import pamtram.provider.NamedElementItemProvider;
import pamtram.provider.PamtramEditPlugin;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.MetaModelElement;
import pamtram.structure.generic.Reference;
import pamtram.structure.target.FileAttribute;
import pamtram.structure.target.TargetPackage;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.provider.TargetSectionItemProvider;

/**
 * This is the item provider adapter for a {@link pamtram.structure.generic.MetaModelElement} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class MetaModelElementItemProvider extends NamedElementItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MetaModelElementItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {

		if (this.itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return this.itemPropertyDescriptors;
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
	 * @generated
	 */
	@Override
	public Object getStyledText(Object object) {

		String label = ((MetaModelElement<?, ?, ?, ?>) object).getName();
		StyledString styledLabel = new StyledString();
		if (label == null || label.length() == 0) {
			styledLabel.append(this.getString("_UI_MetaModelElement_type"), StyledString.Style.QUALIFIER_STYLER);
		} else {
			styledLabel.append(this.getString("_UI_MetaModelElement_type"), StyledString.Style.QUALIFIER_STYLER)
					.append(" " + label);
		}
		return styledLabel;
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

		this.updateChildren(notification);
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
	}

	/**
	 * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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
		 * If a 'FileAttribute' is dragged, we also need to remove the 'file' from the old owner and set the 'file'
		 * reference in the new owner..
		 */
		Collection<Object> collectionWithoutFile = new ArrayList<>();
		FileAttribute file = null;

		for (Object object : collection) {
			if (object instanceof FileAttribute) {
				file = (FileAttribute) object;
			} else {
				collectionWithoutFile.add(object);
			}
		}

		if (file == null || file == owner) {
			return super.createDragAndDropCommand(domain, owner, location, operations, operation, collection);
		}

		EObject targetSection = null;
		if (owner instanceof TargetSection) {
			targetSection = (EObject) owner;
		} else if (owner instanceof Class) {
			return UnexecutableCommand.INSTANCE;
		} else if (owner instanceof Attribute || owner instanceof Reference) {
			if (!(((EObject) owner).eContainer() instanceof TargetSection)
					|| ((TargetSection) ((EObject) owner).eContainer()).getFile() != null) {
				return UnexecutableCommand.INSTANCE;
			}
		}
		targetSection = ((EObject) owner).eContainer();

		// use the specialized remove/set methods from the TargetSectionItemProvider class
		TargetSectionItemProvider targetSectionItemProvider = (TargetSectionItemProvider) this.getAdapterFactory()
				.adapt(((EObject) owner).eContainer(), TargetSectionItemProvider.class);

		BasicDragAndDropCompoundCommand command = new BasicDragAndDropCompoundCommand();
		command.append(
				super.createDragAndDropCommand(domain, owner, location, operations, operation, collectionWithoutFile));
		command.append(targetSectionItemProvider.createRemoveCommand(domain, file.eContainer(),
				GenericPackage.Literals.CLASS__ATTRIBUTES, Arrays.asList(file)));
		domain.createCommand(SetCommand.class,
				new CommandParameter(targetSection, TargetPackage.Literals.TARGET_SECTION__FILE, file));
		return command;
	}
}
