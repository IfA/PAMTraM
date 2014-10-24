package pamtram.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
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
	 * @return EPackageCheck
	 */
	public static EPackageCheck checkInvolvedEPackages(IFile pamtramFile, Registry registry) {

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
				return EPackageCheck.ERROR_PAMTRAM_NOT_FOUND;
			}
			pamtram = (PAMTraM) contents.get(0);
		}
		
		return checkInvolvedEPackages(pamtram, project, registry);
	}
	
	/**
	 * This determines the various ePackages involved in a PAMTraM model (source, target and context
	 * packages) and checks if they are already registered. If this is not the case - this may usually
	 * only happen if the ePackage is only backed by an ecore model and not by generated Java code - 
	 * this function browses through the ecore models in the 'metamodel' folder of the project (if there
	 * is any) and manually registers the ePackages if suitable ecore models are found.
	 * 
	 * @param pamtram the pamtram model to be checked.
	 * @param project the project that holds the pamtram model.
	 * @param registry the registry that the ePackages will be registered to; this could be the registry of a
	 * 			resource set or the global package registry.
	 * 
	 * @return EPackageCheck
	 */
	public static EPackageCheck checkInvolvedEPackages(PAMTraM pamtram, IProject project, Registry registry) {
		
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
			return EPackageCheck.OK_NOTHING_REGISTERED;
		}
		
		// try to register the remaining ePackages manually by searching for the metamodels
		// in the 'metamodel' folder of the project
		IFolder metamodelFolder = project.getFolder("metamodel");
		if(!metamodelFolder.exists()) {
			return EPackageCheck.ERROR_METAMODEL_FOLDER_NOT_FOUND;
		}
		try {
			for(IResource res : metamodelFolder.members()) {
				if(res instanceof IFile && ((IFile) res).getName().endsWith(".ecore")) {
					try {
						HashMap<String, EPackage> ePackages = getEPackages(res.getRawLocation().toString(), true, false);
						for (String nsUri : ePackages.keySet()) {
							if(nsUrisToRegister.contains(nsUri)) {
								// register all ePackages defined in the ecore model
								for (String nsUriToRegister : ePackages.keySet()) {
									registry.put(nsUriToRegister, ePackages.get(nsUriToRegister));		
									nsUrisToRegister.remove(nsUriToRegister);
								}
								if(nsUrisToRegister.isEmpty()) {
									return EPackageCheck.OK_PACKAGES_REGISTERED;
								}
							}
						}
					} catch (Exception e) {
						continue;
					}
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		return EPackageCheck.ERROR_PACKAGE_NOT_FOUND;
	}
	
	/**
	 * This tries to determine the ePackages defined in an ecore model. Therefore,
	 * the resource is loaded and the ePackages are extracted.
	 * 
	 * @param absolutePathToEcoreModel the absolute path to the ecore model to be analyzed.
	 * @param adaptResourceUri if true, the uri of the resource that contains the ePackage will be set to the
	 * namespace uri of the ePackage. That way, this namespace uri is used for references to the package during 
	 * serialization of resources, otherwise there will be file-based references 
	 * @param register if the packages shall be registered to the global ePackage registry.
	 * @return a map of nsUris and corresponding ePackages found in the ecore model, null if any error occurs.
	 */
	public static HashMap<String, EPackage> getEPackages(String absolutePathToEcoreModel, boolean adaptResourceUri, boolean register) {
		
		HashMap<String, EPackage> ePackages = new HashMap<>();
		
		// try to load the resource
		Resource metamodel = null;
		
		try {
			metamodel = (new ResourceSetImpl()).getResource(
					URI.createFileURI(absolutePathToEcoreModel), true);
		} catch (Exception e) {
			return null;
		}
		
		if(metamodel == null) {
			return null;
		}
		
		// get the contents of the resource
		EList<EObject> contents = metamodel.getContents();
		if(contents == null || contents.isEmpty() || !(contents.get(0) instanceof EPackage)) {
			return null;
		}
		
		// the ePackage defined by the metamodel
		EPackage root = (EPackage) contents.get(0);
		
		HashSet<EPackage> ePackageSet = collectEPackages(root);
		
		for (EPackage ePackage : ePackageSet) {
			
			if(adaptResourceUri) {
				// adapt the uri of the resource
				ePackage.eResource().setURI(URI.createURI(ePackage.getNsURI()));				
			}

			ePackages.put(ePackage.getNsURI(), ePackage);
			
			if(register) {
				// register the packages to the global package registry
				EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);
			}
		}
		
		return ePackages;
	}
	
	/**
	 * Recursively collects the sub-packages of an ePackage and returns them as a 
	 * set (including the root package itself).
	 *  
	 * @param ePackage the root ePackage
	 * @return a set of sub-ePackages including the root ePackage itself
	 */
	private static HashSet<EPackage> collectEPackages(EPackage ePackage) {
		HashSet<EPackage> ePackages = new HashSet<>();
		ePackages.add(ePackage);
		for (EPackage child : ePackage.getESubpackages()) {
			ePackages.addAll(collectEPackages(child));
		}
		return ePackages;
	}
	
	public enum EPackageCheck {
		OK_NOTHING_REGISTERED, OK_PACKAGES_REGISTERED, ERROR_PACKAGE_NOT_FOUND, ERROR_PAMTRAM_NOT_FOUND, ERROR_METAMODEL_FOLDER_NOT_FOUND;
	}
}
