package de.mfreund.gentrans.transformation.runners;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

import de.mfreund.gentrans.transformation.selectors.ItemSelectorDialog;

public class GentransFromXMLSourceRunner {

	public GentransFromXMLSourceRunner() {
		

		// Create a resource set. 
		ResourceSet resourceSet = new ResourceSetImpl(); 

		// Register the default resource factory -- only needed for stand-alone! 
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put( 
		"ecore", new EcoreResourceFactoryImpl()); 

		// Register the package -- only needed for stand-alone! 
		EcorePackage ecorePackage = EcorePackage.eINSTANCE; 


		// Get the URI of the model file. 
		URI fileURI = URI.createFileURI(new File("/home/sascha/Dokumente/ss/da/workspace/de.mfreund.pamtram.casestudies.autoprobe/metamodel/movisa.ecore").getAbsolutePath()); 

		// Demand load the resource for this file. 
		Resource resource = resourceSet.getResource(fileURI, true); 
		
		EPackage pkg=(EPackage) resource.getContents().get(0);
		System.out.println(pkg.getNsURI());
		for(EPackage p: pkg.getESubpackages()){
			System.out.println(p.getNsPrefix());
		}

//		// Print the contents of the resource to System.out. 
//		try 
//		{ 
//		resource.save(System.out, Collections.EMPTY_MAP); 
//		} 
//		catch (IOException e) {} 
		
//		System.out.println(EPackage.Registry.INSTANCE.keySet());
//	//	ItemSelectorDialog.run("test", EPackage.Registry.INSTANCE.keySet(), "");
//		System.out.println(EPackage.Registry.INSTANCE.size());
	}
	public static void main(String [] args){
		new GentransFromXMLSourceRunner();
	}

}
