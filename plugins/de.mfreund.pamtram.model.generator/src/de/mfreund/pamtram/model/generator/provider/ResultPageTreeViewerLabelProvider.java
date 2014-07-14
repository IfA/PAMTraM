package de.mfreund.pamtram.model.generator.provider;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

import de.mfreund.pamtram.model.generator.ClassTreeItem;
import pamtram.metamodel.ContainmentReference;
import pamtram.metamodel.NonContainmentReference;
import pamtram.metamodel.Reference;

public class ResultPageTreeViewerLabelProvider extends StyledCellLabelProvider {
	
	private Image containmentRefImage, nonContainmentRefImage, rootElementImage;
	private Bundle bundle;
	
	public ResultPageTreeViewerLabelProvider(Bundle bundle) {
		super();
		
		this.bundle = bundle;
		// create the images used in the tree viewer
		createImages();
	}
	
    @Override
    public void update(ViewerCell cell) {
    	
    	StyledString text = new StyledString();

    	ClassTreeItem element = (ClassTreeItem) cell.getElement();
    	Reference ref = element.getReferenceObject();
    	
    	if(ref != null){
    		// add the reference name to the label
			text.append(
				ref.getName() + " : ");
    		if(ref instanceof ContainmentReference) {
    			// set the image
    			cell.setImage(containmentRefImage);
    		} else if(ref instanceof NonContainmentReference) {
    			//set the image
    			cell.setImage(nonContainmentRefImage);
    		}
    	} else {
    		// set the image
    		cell.setImage(rootElementImage);    		
		}
    	
    	// add the name of the class to the label
    	text.append(element.getClassObject().getName());

    	// set the label
    	cell.setText(text.toString());
    	cell.setStyleRanges(text.getStyleRanges());
    	super.update(cell);
    }
    
    @Override
    public void dispose() {
    	super.dispose();
    	this.containmentRefImage.dispose();
    	this.nonContainmentRefImage.dispose();
    	this.rootElementImage.dispose();
    }
    
    private void createImages() {
	    URL url = FileLocator.find(bundle, new Path("icons/containmentRef.png"), null);
	    ImageDescriptor imageDcr = ImageDescriptor.createFromURL(url);
	    this.containmentRefImage = imageDcr.createImage();
	    url = FileLocator.find(bundle, new Path("icons/nonContainmentRef.png"), null);
	    imageDcr = ImageDescriptor.createFromURL(url);
	    this.nonContainmentRefImage = imageDcr.createImage();
	    url = FileLocator.find(bundle, new Path("icons/rootElement.png"), null);
	    imageDcr = ImageDescriptor.createFromURL(url);
	    this.rootElementImage = imageDcr.createImage();
	}
    
}
