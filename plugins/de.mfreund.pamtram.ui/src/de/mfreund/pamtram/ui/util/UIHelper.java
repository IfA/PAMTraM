package de.mfreund.pamtram.ui.util;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class UIHelper {

	/**
	 * Returns the current shell or creates a new one.
	 * 
	 * @return the current shell
	 */
	public static Shell getShell() {
		IWorkbench workbench = PlatformUI.getWorkbench(); 
		IWorkbenchWindow window = workbench.getActiveWorkbenchWindow(); 
		return (window != null && window.getShell() != null) 
				? window.getShell() : new Shell(); 
	}
}
