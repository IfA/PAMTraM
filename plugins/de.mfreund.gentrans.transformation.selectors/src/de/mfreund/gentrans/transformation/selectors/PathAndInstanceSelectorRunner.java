package de.mfreund.gentrans.transformation.selectors;

import java.util.List;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class PathAndInstanceSelectorRunner implements Runnable {
	private  String path, instance,message;
	private List<String> paths;
	private List<List<String>>  instances;
	
	public  String getPath() {
		return path;
	}

	public  String getInstance() {
		return instance;
	}
	
	public boolean wasTransformationStopRequested() {
		return transformationStopRequested;
	}	

	private boolean transformationStopRequested;

	public PathAndInstanceSelectorRunner(String message, List<String> paths, List<List<String>>  instances){
		this.path="";
		this.instance="";
		this.transformationStopRequested=false;
		this.paths=paths;
		this.instances=instances;
		this.message=message;
	};
	
	@Override
	public void run() {
		Display display= Display.getDefault();
		Shell shell=new Shell(display);
		PathAndInstanceSelectorDialog d=new PathAndInstanceSelectorDialog(shell,message, paths,instances);

		d.open();
		path=d.getPath();
		instance=d.getInstance();	
		transformationStopRequested=d.isTransformationStopRequested();
	};
	

}
