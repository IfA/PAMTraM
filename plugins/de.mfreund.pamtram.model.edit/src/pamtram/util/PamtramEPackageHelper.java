package pamtram.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

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

import de.tud.et.ifa.agtele.emf.EPackageHelper;
import pamtram.PAMTraM;
import pamtram.SourceSectionModel;
import pamtram.TargetSectionModel;

public interface PamtramEPackageHelper extends EPackageHelper {

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
		for (SourceSectionModel	sourceSectionModel : pamtram.getSourceSectionModel()) {
			ePackagesToCheck.add(sourceSectionModel.getMetaModelPackage());
		}
		for (TargetSectionModel	targetSectionModel : pamtram.getTargetSectionModel()) {
			ePackagesToCheck.add(targetSectionModel.getMetaModelPackage());
		}
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
			HashSet<EPackage> registeredPackages = new HashSet<>();
			HashSet<String> usedMetamodelFiles = new HashSet<>();
			for(IResource res : metamodelFolder.members()) {
				if(res instanceof IFile && ((IFile) res).getName().endsWith(".ecore")) {
					try {
						Map<String, EPackage> ePackages = EPackageHelper.getEPackages(res.getRawLocation().toString(), true, false);
						for (String nsUri : ePackages.keySet()) {
							if(nsUrisToRegister.contains(nsUri)) {
								// register all ePackages defined in the ecore model
								for (String nsUriToRegister : ePackages.keySet()) {
									registry.put(nsUriToRegister, ePackages.get(nsUriToRegister));
									nsUrisToRegister.remove(nsUriToRegister);
									
									usedMetamodelFiles.add(res.getRawLocation().toString());
									registeredPackages.add(ePackages.get(nsUriToRegister));
								}
								if(nsUrisToRegister.isEmpty()) {
									return EPackageCheck.OK_PACKAGES_REGISTERED.
											withRegisteredPackages(registeredPackages);
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
	 * This describes the result of checking references packages involved in a pamtram model.
	 * 
	 * @author mfreund
	 */
	public enum EPackageCheck {
		OK_NOTHING_REGISTERED, OK_PACKAGES_REGISTERED, ERROR_PACKAGE_NOT_FOUND, ERROR_PAMTRAM_NOT_FOUND, ERROR_METAMODEL_FOLDER_NOT_FOUND;
		
		/**
		 * This stores the set of {@link EPackage EPackages} that have been registered during an 'EPackageCheck'.
		 */
		private HashSet<EPackage> registeredPackages;

		/**
		 * This is the getter for the the {@link #registeredPackages}.
		 * @return The set of {@link EPackage EPackages} that have been registered during an 'EPackageCheck'.
		 */
		public HashSet<EPackage> getRegisteredPackages() {
			return registeredPackages == null ? new HashSet<>() : registeredPackages;
		}
		
		/**
		 * This sets the set of {@link #registeredPackages} for this instance of 'EPackageCheck'.
		 * @param registeredPackages The set of {@link EPackage EPackages} to set as {@link #registeredPackages}.
		 * @return The instance of {@link EPackageCheck} after setting the registered packages.
		 */
		public EPackageCheck withRegisteredPackages(HashSet<EPackage> registeredPackages) {
			this.registeredPackages = registeredPackages;
			return this;
		}

	}
}
