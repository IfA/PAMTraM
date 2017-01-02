/**
 */
package pamtram.mapping.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.mapping.MappingFactory;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.ReferenceTargetSelector;
import pamtram.structure.TargetSectionClass;
import pamtram.structure.TargetSectionCrossReference;

/**
 * This is the item provider adapter for a {@link pamtram.mapping.ReferenceTargetSelector} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ReferenceTargetSelectorItemProvider
extends MappingHintItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceTargetSelectorItemProvider(AdapterFactory adapterFactory) {
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

			addAffectedReferencePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Affected Reference feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected void addAffectedReferencePropertyDescriptor(Object object) {
		this.itemPropertyDescriptors.add
		(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)this.adapterFactory).getRootAdapterFactory(),
						this.getResourceLocator(),
				this.getString("_UI_ReferenceTargetSelector_affectedReference_feature"),
				this.getString("_UI_PropertyDescriptor_description",
						"_UI_ReferenceTargetSelector_affectedReference_feature", "_UI_ReferenceTargetSelector_type"),
						MappingPackage.Literals.REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE,
						true,
						false,
						true,
						null,
						null,
						null){

			@Override
			public Collection<?> getChoiceOfValues(Object object) {
				TargetSectionClass target=null;
				if(((ReferenceTargetSelector)object).eContainer() instanceof MappingHintGroupType){
					target=((MappingHintGroupType) ((ReferenceTargetSelector)object).eContainer()).getTargetSection();
				} else if(((ReferenceTargetSelector)object).eContainer() instanceof MappingHintGroupImporter){
					target=((MappingHintGroupImporter) ((ReferenceTargetSelector)object).eContainer()).getHintGroup().getTargetSection();
				}

				TreeIterator<EObject> it =target.eAllContents();
				List<EObject> vals= new ArrayList<>();

				while(it.hasNext()){
					EObject next=it.next();
					if(next instanceof TargetSectionCrossReference){
						vals.add(next);
					}
				}

				return vals;
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
			childrenFeatures.add(MappingPackage.Literals.REFERENCE_TARGET_SELECTOR__MATCHER);
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
	 * This returns ReferenceTargetSelector.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ReferenceTargetSelector"));
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

		ReferenceTargetSelector mis = (ReferenceTargetSelector)object;
		StyledString styledLabel = new StyledString();

		String label = mis.getName();
		if((label == null || label.isEmpty()) && mis.getAffectedReference() != null) {
			label = mis.getAffectedReference().getName();
		}

		if(label != null) {
			styledLabel.append(label);
		}

		return styledLabel;
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

		switch (notification.getFeatureID(ReferenceTargetSelector.class)) {
			case MappingPackage.REFERENCE_TARGET_SELECTOR__MATCHER:
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

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.REFERENCE_TARGET_SELECTOR__MATCHER,
				 MappingFactory.eINSTANCE.createAttributeMatcher()));

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.REFERENCE_TARGET_SELECTOR__MATCHER,
				 MappingFactory.eINSTANCE.createClassMatcher()));
	}

}
