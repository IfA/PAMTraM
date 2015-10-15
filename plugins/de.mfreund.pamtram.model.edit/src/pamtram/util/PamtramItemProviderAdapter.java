package pamtram.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ItemProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.NamedElement;
import pamtram.impl.PamtramPackageImpl;

/**
 * This {@link ItemProviderAdapter} adds the ability to define a list of '<em>labelRelatedChildrenFeatures</em>'. Changes
 * of the elements held by these features will trigger an update of the parent's label (similar to setting the 'Notify' property
 * in the genmodel to 'true'). If the children are of type {@link NamedElement}, a change of their {@link NamedElement#getName()} 
 * will also trigger an update of the parent's label - this cannot be realized with the genmodel setting 'Notify'.
 * 
 * @author mfreund
 */
public class PamtramItemProviderAdapter extends ItemProviderAdapter implements INamedElementChildrenChangeNotifier {

	public PamtramItemProviderAdapter(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This is used to store all the children features that have influence on the label of the parent element. 
	 * This should be a subset of {@link #childrenFeatures}. Derived classes should add features to this vector.
	 */
	protected List<EStructuralFeature> labelRelatedChildrenFeatures;

	/**
	 * This keeps track of the EObjects for that the NotifyChangedListeners for
	 * {@link #labelRelatedChildrenFeatures} have already been initialized.
	 */
	private List<EObject> initialized = new ArrayList<>();

	/**
	 * This is the getter for {@link #labelRelatedChildrenFeatures}. The default implementation returns an
	 * empty list but clients can override this.
	 * 
	 * @param object
	 * @return The collection of {@link #labelRelatedChildrenFeatures}.
	 */
	protected Collection<? extends EStructuralFeature> getLabelRelatedChildrenFeatures(Object object) {
		if (labelRelatedChildrenFeatures == null)
		{
			labelRelatedChildrenFeatures = new ArrayList<>();
		}
		return labelRelatedChildrenFeatures;
	}

	/**
	 * This needs to be called (at least) once for each parent element. It will register NotifiyChangedListeners for
	 * <b>existing</b> child elements as {@link #handleLabelRelatedChildrenFeatureChangeNotification(Notification)} only installs
	 * those handlers for <b>newly added</b> children after a respective notification is issued.
	 * <br /><br />
	 * <b>Note: </b> This should typically be called at the beginning of {@link ItemProvider#getText()} as this is called
	 * the first time that an item gets visible. 
	 * 
	 * @param object The {@link EObject} that shall be notified about changes of its children.
	 */
	@SuppressWarnings("unchecked")
	protected void initializeLabelRelatedChildrenFeatureNotifications(Object object) {
		/*
		 * Initialize the NotifyChangedListeners for existing children.
		 */
		if(object != null && object instanceof EObject && !initialized.contains(object)) {

			EObject parent = (EObject) object;
			for (EStructuralFeature childFeature : getLabelRelatedChildrenFeatures(parent)) {
				if(!(childFeature.getEType() instanceof EClass) || !((EClass) (childFeature.getEType())).getEAllSuperTypes().contains(PamtramPackageImpl.eINSTANCE.getNamedElement())) {
					continue;
				}
				if(childFeature.isMany()) {
					for (EObject child : (Collection<EObject>) parent.eGet(childFeature)) {
						registerNotifyChangedListener(parent, (NamedElement) child, adapterFactory);
					}
				} else {
					registerNotifyChangedListener(parent, (NamedElement) parent.eGet(childFeature), adapterFactory);
				}
			}
			initialized.add(parent);
		}

	}

	/**
	 * This checks if a notfication affects one of the {@link #labelRelatedChildrenFeatures} and updates the parent's label.
	 * Additionally, it installs NotifyChanged listeners on newly created children of type {@link NamedElement} so that future 
	 * changes of their names will be handled automatically.
	 * <br /><br />
	 * <b>Note: </b> This should typically be called at the beginning of {@link Adapter.Internal#notifyChanged(Notification)} 
	 * inside the involved {@link ItemProvider}. 
	 * 
	 * @param notification The {@link Notification} that might influence the element's label.
	 */
	protected void handleLabelRelatedChildrenFeatureChangeNotification(Notification notification) {

		if(getLabelRelatedChildrenFeatures(notification).contains(notification.getFeature())) {
			if(notification.getNotifier() != null && notification.getNotifier() instanceof EObject &&
					notification.getNewValue() != null && notification.getNewValue() instanceof NamedElement) {
				registerNotifyChangedListener((EObject) notification.getNotifier(), (NamedElement) notification.getNewValue(), adapterFactory);
			}
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, true));
			return;
		}
	}

}
