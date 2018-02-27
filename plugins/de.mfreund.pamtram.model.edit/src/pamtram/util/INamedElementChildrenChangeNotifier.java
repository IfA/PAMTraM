/**
 *
 */
package pamtram.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.ItemProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import pamtram.NamedElement;
import pamtram.provider.NamedElementItemProvider;

/**
 * Implementing this interface enables elements to be {@link #fireNotifyChanged(Notification) informed} about changes of
 * children of type {@link NamedElement}. Therefore, some '<em>ItemProvider magic</em>' is performed (see <a href=
 * "http://eclipsesource.com/blogs/2013/01/29/emf-itemprovider-magic/">http://eclipsesource.com/blogs/2013/01/29/emf-itemprovider-magic/</a>).
 * <br />
 * <br />
 * In order to get notified when the {@link NamedElement#getName() name} of a child changes,
 * {@link #registerNotifyChangedListener(EObject, NamedElement) registerNotifyChangedListener(...)} needs to be called
 * once for the child. This will typically be done in the {@link ItemProvider#getText() getText()} method of an
 * {@link ItemProvider}.
 *
 * @author mfreund
 */
public interface INamedElementChildrenChangeNotifier extends IChangeNotifier {

	/**
	 * This keeps track of the known associations between parent EObjects and children NamedElements in the changes of
	 * which the parents are interested.
	 */
	public Map<NamedElement, Set<EObject>> childrenToParentMap = new HashMap<>();

	/**
	 * This registers an {@link INotifyChangedListener} that notifies the given '<em>parent</em>' when the
	 * {@link NamedElement#getName() name} of the given '<em>child</em>' changes. <br />
	 * <br />
	 * <b>Note: </b> This method ensures that each listener is only registered once so that it is save to call this
	 * multiple times (e.g. in the {@link ItemProvider#getText() getText()} method of an {@link ItemProvider}).
	 *
	 * @param parent
	 *            The parent {@link EObject} that wants to get informed about changes of the child.
	 * @param child
	 *            The child {@link NamedElement} that shall notify the parent about changes of its
	 *            {@link NamedElement#getName() name}.
	 */
	public default void registerNotifyChangedListener(final EObject parent, final NamedElement child) {

		if (parent == null || child == null || parent == child) {
			return;
		}

		// we will add the INotifyChangedListener to this ItemProvider
		NamedElementItemProvider sourceItemItemprovider = AgteleEcoreUtil.adapt(child, NamedElementItemProvider.class);

		if (sourceItemItemprovider == null) {
			return;
		}

		// initialize the map if necessary
		if (!INamedElementChildrenChangeNotifier.childrenToParentMap.containsKey(child)) {
			INamedElementChildrenChangeNotifier.childrenToParentMap.put(child, new HashSet<EObject>());
		}

		// do not create the INotifyChangedListener twice
		if (!INamedElementChildrenChangeNotifier.childrenToParentMap.get(child).contains(parent)) {

			// create the INotifyChangedListener that informs the parent about the changes
			sourceItemItemprovider.addListener(notification -> {
				Object element;
				if (notification instanceof ViewerNotification) {
					element = ((ViewerNotification) notification).getElement();
				} else {
					element = notification.getNotifier();
				}

				if (element != null && element.equals(child)) {
					INamedElementChildrenChangeNotifier.this
							.fireNotifyChanged(new ViewerNotification(notification, parent, false, true));
				}
			});

			// keep track of the association we just created
			INamedElementChildrenChangeNotifier.childrenToParentMap.get(child).add(parent);
		}
	}

}
