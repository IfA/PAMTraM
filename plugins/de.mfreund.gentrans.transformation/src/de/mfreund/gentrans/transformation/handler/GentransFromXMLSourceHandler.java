package de.mfreund.gentrans.transformation.handler;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import de.mfreund.gentrans.transformation.GenericTransformationRunner;
import de.mfreund.gentrans.transformation.selectors.PamtramFileSelectorDialog;


public class GentransFromXMLSourceHandler extends AbstractHandler {


	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		// get the active selection
		ISelection sel = HandlerUtil.getActiveMenuSelection(event);
	    IStructuredSelection selection = (IStructuredSelection) sel;

	    // get the first element of the active selection
	    Object firstElement = selection.getFirstElement();
	    
	    if(!(firstElement instanceof IFile)) {
	    	throw new ExecutionException("Selected element is not a resource!");
	    }
	    IFile file = (IFile) firstElement;
	    
		// add file extension to registry
		// TODO check if necessary if standard xml extension is used
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
		    .put("xml", new GenericXMLResourceFactoryImpl());
		
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
//	    .put("pamtram", new XMIResourceFactoryImpl());

		// Create a resource set. 
		ResourceSet resourceSet = new ResourceSetImpl(); 

	    String pamtramFilePath=PamtramFileSelectorDialog.run(file.getLocation().removeLastSegments(1).toOSString());
	    
	    // the selected resource (IMPORTANT: needs to be represented as absolute URI with "file://" scheme; 
		// if other schemes are used, the relative paths to the wprops and other model files are not set correct!)
		URI resourceUri = URI.createFileURI(new java.io.File(file.getLocation().toString()).toString());
		// the source resource (xmi)
		
		Resource xmlResource=null;
		try {
			xmlResource = resourceSet.getResource(resourceUri, true);
			xmlResource.load(Collections.EMPTY_MAP);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		// get the root object of the xml resource

		EObject root = xmlResource.getContents().get(0).eContents().get(0);
		GenericTransformationRunner tr=new GenericTransformationRunner(root, xmlResource.getURI(),pamtramFilePath);
		tr.runTransformation();
	    
	    return null;
	}
	

}
