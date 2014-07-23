package de.mfreund.gentrans.transformation.selectors;

import java.util.List;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class PathAndInstanceSelectorRunner {
	private static String path, instance;
	public static String getPath() {
		return path;
	}

	public static String getInstance() {
		return instance;
	}

	public PathAndInstanceSelectorRunner(){};
	
	public static void run(final String message, final List<String> paths, final List<List<String>>  instances){
		Display.getDefault().syncExec(new Runnable(){
			public void run(){
				Display display= Display.getDefault();
				Shell shell=new Shell(display);
				PathAndInstanceSelectorDialog d=new PathAndInstanceSelectorDialog(shell,message, paths,instances);

				d.open();
				path=d.getPath();
				instance=d.getInstance();
			};
		});
		

	};
	

}
