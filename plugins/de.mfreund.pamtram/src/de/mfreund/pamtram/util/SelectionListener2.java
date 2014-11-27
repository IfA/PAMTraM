package de.mfreund.pamtram.util;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

/**
 * This interface extends the standard SWT 'SelectionListener' interface
 * in a way that it prevents a default implementation for the
 * 'widgetDefaultSelected' method that does nothing. Thus the user only
 * has to implement the 'widgetSelected' method.
 * 
 * @author mfreund
 */
public interface SelectionListener2 extends SelectionListener {

	@Override
	default public void widgetDefaultSelected(SelectionEvent e) {
		// do nothing on default selection
	}
}
