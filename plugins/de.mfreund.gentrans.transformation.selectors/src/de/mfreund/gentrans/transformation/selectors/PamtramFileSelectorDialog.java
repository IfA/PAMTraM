package de.mfreund.gentrans.transformation.selectors;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class PamtramFileSelectorDialog extends Object {
	private static String file="";
	public static String run(final String startPath){
		Display.getDefault().syncExec(new Runnable(){
			public void run(){
				Display display= Display.getDefault();
				Shell shell=new Shell(display);
				FileDialog d=new FileDialog(shell, SWT.APPLICATION_MODAL);
				d.setText("Select a PAMTraM Model to transform this XML model");
				d.setFilterPath(startPath);
				d.setFilterExtensions(new String[]{"*.pamtram"});
				file=d.open();
				
			};
		});
		return file;
	};	


}
