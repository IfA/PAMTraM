package pamtram.contentadapter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.jface.viewers.TreeViewer;

import pamtram.DeactivatableElement;
import pamtram.PamtramPackage;

/**
 * This content adapter refreshes a given viewer when the status of the '<em><b>activate</b></em>'
 * attribute of a {@link DeactivatableElement} changes. That way, the viewer will e.g. refresh colors.
 * 
 * @author mfreund
 *
 */
public class DeactivationListenerAdapter extends PamtramChildContentAdapter {

	/**
	 * This is the viewer that will get refreshed when an element is (de-)activated.
	 */
	TreeViewer viewer;
	
	/**
	 * This constructs an instance.
	 * 
	 * @param parentAdapter The parent {@link PamtramContentAdapter} to which this adapter
	 * will be added.
	 * @param viewer This is the viewer that will get refreshed when an element is (de-)activated.
	 */
	public DeactivationListenerAdapter(PamtramContentAdapter parentAdapter, TreeViewer viewer) {
		super(parentAdapter);
		this.viewer = viewer;
	}

	@Override
	public void notifyChanged(Notification n) {

		if(n.getFeature().equals(PamtramPackage.Literals.DEACTIVATABLE_ELEMENT__DEACTIVATED) && 
				n.getEventType() == Notification.SET) {
			/*
			 * Refresh the given viewer.
			 */
			if(viewer != null) {
				viewer.refresh();
			}
		}
	}
}
