package pamtram.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import pamtram.PAMTraM;

public class EPackageHelper {

	/**
	 * This determines the various ePackages involved in a PAMTraM model (source, target and context
	 * packages) and checks if they are already registered. If this is not the case - this may usually
	 * only happen if the ePackage is only backed by an ecore model and not by generated Java code - 
	 * this function browses through the ecore models in the 'metamodel' folder of the project (if there
	 * is any) and manually registers the ePackages if suitable ecore models are found.
	 * 
	 * @param pamtramFile an IFile containing the pamtram model to be checked.
	 * @param registry the registry that the ePackages will be registered to; this could be the registry of a
	 * 			resource set or the global package registry.
	 * 
	 * @return true if all involved packages have been registered, false otherwise or in case of an error.
	 */
	public static boolean checkInvolvedEPackages(IFile pamtramFile, Registry registry) {

		// A resource set used to load the diverse resources
		ResourceSet resourceSet = new ResourceSetImpl();
		
		// the active project
		IProject project = pamtramFile.getProject();
		
		// the active pamtram model
		PAMTraM pamtram = null;
		{
			/* load the pamtramResource;
			 * Note: A distinct resource set is used for loading the resource so that potential errors resulting
			 * from unregistered packages are not reflected in the 'main' resource set (and are thus not displayed
			 * e.g. in an editor)!
			 */
			Resource pamtramResource = resourceSet.getResource(URI.createPlatformResourceURI(
					project.getName() + File.separator + "Pamtram" + File.separator + pamtramFile.getName(), true), true);
			EList<EObject> contents = pamtramResource.getContents();
			if(contents == null || contents.isEmpty() || !(contents.get(0) instanceof PAMTraM)) {
				return false;
			}
			pamtram = (PAMTraM) contents.get(0);
		}
		
		// a list that holds all ePackages that need to be checked
		ArrayList<EPackage> ePackagesToCheck = new ArrayList<>();
		ePackagesToCheck.add(pamtram.getSourceSectionModel().getMetaModelPackage());
		ePackagesToCheck.add(pamtram.getTargetSectionModel().getMetaModelPackage());
		ePackagesToCheck.addAll(pamtram.getContextMetaModelPackage());
		
		// collect the nsUris of all ePackages that are proxies (which means they have not been
		// registered) and that thus need to be registered manually
		HashSet<String> nsUrisToRegister = new HashSet<>();
		for (EPackage ePackage : ePackagesToCheck) {
			if(ePackage != null && ePackage.eIsProxy()) {
				URI proxyUri = ((EPackageImpl) ePackage).eProxyURI();
				nsUrisToRegister.add(proxyUri.hasFragment() ? 
						proxyUri.trimFragment().toString() : proxyUri.toString());
			}
		}
		
		// all ePackages are already registered
		if(nsUrisToRegister.isEmpty()) {
			return true;
		}
		
		// try to register the remaining ePackages manually by searching for the metamodels
		// in the 'metamodel' folder of the project
		IFolder metamodelFolder = project.getFolder("metamodel");
		if(!metamodelFolder.exists()) {
			return false;
		}
		try {
			for(IResource res : metamodelFolder.members()) {
				if(res instanceof IFile && ((IFile) res).getName().endsWith(".ecore")) {
					Resource metamodel = resourceSet.getResource(
							URI.createPlatformResourceURI(project.getName() + File.separator + "metamodel" + File.separator + res.getName(), true), true);
					EList<EObject> contents = metamodel.getContents();
					if(contents == null || contents.isEmpty() || !(contents.get(0) instanceof EPackage)) {
						continue;
					}
					EPackage ePackage = (EPackage) contents.get(0);
					if(ePackage instanceof EPackage && nsUrisToRegister.contains(ePackage.getNsURI())) {
						registry.put(ePackage.getNsURI(), ePackage);
						nsUrisToRegister.remove(ePackage.getNsURI());
						if(nsUrisToRegister.isEmpty()) {
							return true;
						}
					}
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
