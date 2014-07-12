package de.mfreund.gentrans.transformation.selectors;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class PamtramFileSelectorDialog extends Object {
	private static String pamtramFile="";
	private static String targetFile="";
	public static String getPamtramFile() {
		return pamtramFile;
	}
	public static String getTargetFile() {
		return targetFile;
	}
	public static String run(final String startPath){
		Display.getDefault().syncExec(new Runnable(){
			public void run(){
				Display display= Display.getDefault();
				Shell shell=new Shell(display);
				FileDialog d=new FileDialog(shell, SWT.APPLICATION_MODAL | SWT.OPEN);
				d.setText("Select a PAMTraM Model to transform this XML model");
				d.setFilterPath(startPath);
				d.setFilterExtensions(new String[]{"*.pamtram"});
				pamtramFile=d.open();
				
				d=new FileDialog(shell, SWT.APPLICATION_MODAL | SWT.SAVE);
				d.setText("Where should the target Model be saved?");
				d.setFilterPath(startPath);
				d.setFilterExtensions(new String[]{"*.xmi"});				
				d.setOverwrite(true);
				
				targetFile = d.open();
				System.out.println(targetFile);
				
				
			};
		});
		return pamtramFile;
	};	


}
