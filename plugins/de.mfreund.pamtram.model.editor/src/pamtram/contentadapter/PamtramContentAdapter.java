package pamtram.contentadapter;

import java.util.ArrayList;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import pamtram.presentation.PamtramEditor;

/**
 * A singleton content adapter that listens for changes in a pamtram instance
 * and tries to automatically determine attribute values or reference
 * targets based on the changed object.
 * 
 * @author mfreund
 */
public class PamtramContentAdapter extends EContentAdapter {
	
	// The single instance.
	private static PamtramContentAdapter INSTANCE = null;
	
	// The editor that this content adapter works on.
	private PamtramEditor editor = null;
	
	public PamtramEditor getEditor() {
		return editor;
	}
	
	/**
	 * This initializes the content adapter by setting the
	 * editor that it is associated with.
	 * 
	 * @param editor The editor that this adapter works on.
	 * @return true if the content adapter was initialized correctly, false 
	 * if it was already initialized
	 */
	public boolean init(PamtramEditor editor) {
		if(PamtramContentAdapter.getInstance().editor != null) {
			return false;
		}
		PamtramContentAdapter.getInstance().editor = editor;
		return true;
	}
	
	/**
	 * This returns the single instance of this content adapter. If no instance
	 * exists, a new one will be created.
	 */
	public static PamtramContentAdapter getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new PamtramContentAdapter();
		}
		return INSTANCE;
	}
	
	/**
	 * A list of EContentAdapters that act as children of this adapter
	 * and will be notified of any changes when this adapter is notified. 
	 * With this structure, a better separation should be possible but we can
	 * still manage to work with one single content adapter for everything.
	 */
	ArrayList<EContentAdapter> subAdapters =
			new ArrayList<>();
	
	private PamtramContentAdapter() {

		// populate the list of child content adapters
		subAdapters.add(nameSettingAdapter);
		subAdapters.add(attValModifierSetHandlerAdapter);
		
	}
	
	@Override
	public void notifyChanged(Notification notification) {
		
		// notify every child adapter
		for (EContentAdapter eContentAdapter : subAdapters) {
			eContentAdapter.notifyChanged(notification);
		}
	}
	
	/**
	 * A content adapter that will automatically set/change names of 
	 * elements when an important structural feature changes.
	 */
	final EContentAdapter nameSettingAdapter = 
			new NameSettingAdapter();
	
	/**
	 * A content adapter that will present a dialog to the user when
	 * he changes a set of AttributeValueModifierSets referenced by an
	 * element. The user will be asked if other elements referencing
	 * a similar set should also be updated automatically.
	 */
	final EContentAdapter attValModifierSetHandlerAdapter = 
			new AttValModifierSetHandlerAdapter();


}
