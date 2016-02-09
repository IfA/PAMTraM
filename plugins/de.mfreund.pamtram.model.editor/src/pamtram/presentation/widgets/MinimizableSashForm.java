package pamtram.presentation.widgets;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Sash;

/**
 * A {@link SashForm} that supports minimizing of controls. Currently, this only supports a single
 * minimized child control.
 * 
 * @author mfreund
 */
public class MinimizableSashForm extends SashForm {
	
	/**
	 * The default height of minimized controls.
	 */
	private int defaultMinHeight = 18;
	
	/**
	 * The currently minimized {@link Control} in this sash form or '<em>null</em>' if no control is minimized.
	 */
	private Control minimizedControl;
	
	/**
	 * The listener that adjusts the weights if the sash form is resized.
	 */
	private Listener resizeListener;
	
	/**
	 * A listener that restores default behavior (no child is minimized) by removing the {@link #resizeListener}.
	 */
	private Listener removeResizeListenerListener;

	public MinimizableSashForm(Composite parent, int style) {
		super(parent, style);
		this.minimizedControl = null;
		this.resizeListener = null;
		this.removeResizeListenerListener = null;
	}
		
	/**
	 * Minimizes the given '<em>control</em>'.
	 *  
	 * @param control The {@link Control} to be minimized. If this is '<em>null</em>', the method will return
	 * without doing anything.
	 */
	public void minimizeControl(final Control control) {
		
		if(control == null || (this.minimizedControl != null && this.minimizedControl.equals(control))) {
			return;
		}
		
		// minimize the control
		setWeights(calculateWeights(control));
		
		// ensure that the control stays minimized even when the sash form is resized
		resizeListener = new Listener () {
			@Override
		    public void handleEvent (Event e) {
		    	setWeights(calculateWeights(control));
		    	System.out.println(getWeights());
		    }
		};
		addListener(SWT.Resize, resizeListener);
		
		// ensure that above listener is removed when the user manually moves the sash
		removeResizeListenerListener = new Listener() {
			@Override
			public void handleEvent(Event event) {
				if(resizeListener != null) {
					removeListener(SWT.Resize, resizeListener);					
				}
				if(removeResizeListenerListener != null) {
					control.removeListener(SWT.Resize, removeResizeListenerListener);
				}
				minimizedControl = null;
				resizeListener = null;
				removeResizeListenerListener = null;
			}
		};
		control.addListener(SWT.Resize, removeResizeListenerListener);
	}
	
	/**
	 * Restores the layout (no control is minimized).
	 */
	public void restoreLayout() {
		setWeights(calculateWeights(null));
	}

	/**
	 * Calculate the weights so that the given '<em>controlToBeMinimized</em>' is minimized.
	 * If 'controlToBeMinimized' is '<em>null</em>', default weights will be returned to generate
	 * a non-minimized layout.
	 * 
	 * @param controlToBeMinimized The control to be minimized or '<em>null</em>' if no control
	 * shall be minimized so that the default layout is restored.
	 * @return The calculated weights.
	 */
	private int[] calculateWeights(Control controlToBeMinimized) {
		
		/*
		 * determine the 'real' children (excluding sashes) that have to be considered when
		 * the weights are calculated
		 */
		ArrayList<Control> realChildren = new ArrayList<>();
		for (Control child : getChildren()) {
			if(!(child instanceof Sash)) {
				realChildren.add(child);
			}
		}
		
		if(realChildren == null || realChildren.isEmpty()) {
			return getWeights();
		}
		
		int[] weights = new int[realChildren.size()];
		if(controlToBeMinimized == null || !realChildren.contains(controlToBeMinimized)) {
			// use a default layout
			for (int i = 0; i < realChildren.size(); i++) {
				weights[i] = 1;
			}
			
		} else {
			// determine the weights so that height of the 'minimizedControl' will be 'defaultMinHeight'
			for (int i = 0; i < realChildren.size(); i++) {
				Control child = realChildren.get(i);
				
				if(controlToBeMinimized.equals(child)) {
					weights[i] = (controlToBeMinimized instanceof IMinimizedHeightProvider ? 
							((IMinimizedHeightProvider) controlToBeMinimized).getMinimizedHeight() : defaultMinHeight);
				} else {
					weights[i] = (getClientArea().height - defaultMinHeight)/(realChildren.size() - 1);
				}
				
			}
		}
		
		
		return weights;
	}

}
