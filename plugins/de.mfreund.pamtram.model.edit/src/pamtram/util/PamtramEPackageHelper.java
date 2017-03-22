package pamtram.util;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
import pamtram.SectionModel;
import pamtram.provider.PamtramEditPlugin;

/**
 * A utility class that allows can check if {@link EPackage EPackages} referenced in a {@link PAMTraM} model are already
 * registered and, if not, can register them on-the-fly.
 *
 * @author mfreund
 */
public interface PamtramEPackageHelper extends EPackageHelper {

	/**
	 * This determines the various ePackages involved in a PAMTraM model (source, target and context packages) and
	 * checks if they are already registered. If this is not the case - this may usually only happen if the ePackage is
	 * only backed by an ecore model and not by generated Java code - this function browses through the ecore models in
	 * the 'metamodel' folder of the project (if there is any) and manually registers the ePackages if suitable ecore
	 * models are found.
	 *
	 * @param pamtramFile
	 *            an IFile containing the pamtram model to be checked.
	 * @param registry
	 *            the registry that the ePackages will be registered to; this could be the registry of a resource set or
	 *            the global package registry.
	 *
	 * @return EPackageCheck
	 */
	public static EPackageCheck checkInvolvedEPackages(IFile pamtramFile, Registry registry) {

		// A resource set used to load the diverse resources
		ResourceSet resourceSet = new ResourceSetImpl();

		// the active project
		IProject project = pamtramFile.getProject();

		// the active pamtram model
		PAMTraM pamtram;

		/*
		 * load the pamtramResource; Note: A distinct resource set is used for loading the resource so that potential
		 * errors resulting from unregistered packages are not reflected in the 'main' resource set (and are thus not
		 * displayed e.g. in an editor)!
		 */
		Resource pamtramResource = resourceSet.getResource(URI.createPlatformResourceURI(
				project.getName() + File.separator + PamtramEditPlugin.INSTANCE.getString("PAMTRAM_FOLDER_NAME")
						+ File.separator + pamtramFile.getName(),
				true), true);
		EList<EObject> contents = pamtramResource.getContents();
		if (contents == null || contents.isEmpty() || !(contents.get(0) instanceof PAMTraM)) {
			return EPackageCheck.ERROR_PAMTRAM_NOT_FOUND;
		}
		pamtram = (PAMTraM) contents.get(0);

		return PamtramEPackageHelper.checkInvolvedEPackages(pamtram, project, registry);
	}

	/**
	 * This determines the various ePackages involved in a PAMTraM model (source, target and context packages) and
	 * checks if they are already registered. If this is not the case - this may usually only happen if the ePackage is
	 * only backed by an ecore model and not by generated Java code - this function browses through the ecore models in
	 * the 'metamodel' folder of the project (if there is any) and manually registers the ePackages if suitable ecore
	 * models are found.
	 *
	 * @param pamtram
	 *            the pamtram model to be checked.
	 * @param project
	 *            the project that holds the pamtram model.
	 * @param registry
	 *            the registry that the ePackages will be registered to; this could be the registry of a resource set or
	 *            the global package registry.
	 *
	 * @return EPackageCheck
	 */
	public static EPackageCheck checkInvolvedEPackages(PAMTraM pamtram, IProject project, Registry registry) {

		// a list that holds all ePackages that need to be checked
		Set<EPackage> ePackagesToCheck = Stream
				.concat(pamtram.getSourceSectionModels().stream(), pamtram.getTargetSectionModels().stream())
				.map(SectionModel::getMetaModelPackage).collect(Collectors.toSet());

		// collect the nsUris of all ePackages that are proxies (which means they have not been
		// registered) and that thus need to be registered manually
		//
		Set<String> nsUrisToRegister = ePackagesToCheck.parallelStream()
				.filter(ePackage -> ePackage != null && ePackage.eIsProxy())
				.map(ePackage -> ((EPackageImpl) ePackage).eProxyURI())
				.map(proxyUri -> proxyUri.hasFragment() ? proxyUri.trimFragment().toString() : proxyUri.toString())
				.collect(Collectors.toSet());

		// all ePackages are already registered
		//
		if (nsUrisToRegister.isEmpty()) {
			return EPackageCheck.OK_NOTHING_REGISTERED;
		}

		// try to register the remaining ePackages manually by searching for the metamodels
		// in the 'metamodel' folder of the project
		//
		Map<String, EPackage> ePackagesToRegister;
		IFolder metamodelFolder = project.getFolder(PamtramEditPlugin.INSTANCE.getString("METAMODEL_FOLDER_NAME"));
		if (!metamodelFolder.exists()) {
			return EPackageCheck.ERROR_METAMODEL_FOLDER_NOT_FOUND;
		}
		IResource[] members;
		try {
			members = metamodelFolder.members();
		} catch (CoreException e) {
			e.printStackTrace();
			return EPackageCheck.ERROR_METAMODEL_FOLDER_NOT_FOUND;
		}
		ePackagesToRegister = PamtramEPackageHelper.searchMetamodelsForPackages(nsUrisToRegister,
				Arrays.asList(members));

		// register all found ePackages
		//
		registry.putAll(ePackagesToRegister);

		return nsUrisToRegister.isEmpty() ? EPackageCheck.OK_PACKAGES_REGISTERED.withRegisteredPackages(
				new HashSet<>(ePackagesToRegister.values())) : EPackageCheck.ERROR_PACKAGE_NOT_FOUND;
	}

	/**
	 * Searches the given list of {@link IResource resources} for metamodels that define {@link EPackage EPackages} for
	 * the given set of namespace URIs.
	 *
	 * @param nsUris
	 *            The list of namespace URIs for which EPackages shall be searched.
	 * @param iResources
	 *            The list of {@link IResource Resources} that shall be considered when searching for the required
	 *            EPackages.
	 * @return A map that links namespace URIs and found {@link EPackage EPackages}. The keySet of the map will contain
	 *         a sub-set of the given set of <em>nsURIs</em>.
	 */
	public static Map<String, EPackage> searchMetamodelsForPackages(Set<String> nsUris, List<IResource> iResources) {

		Map<String, EPackage> ePackagesToRegister = new HashMap<>();

		for (IResource res : iResources) {
			if (res instanceof IFile && ((IFile) res).getName().endsWith(".ecore")) {

				Map<String, EPackage> ePackages = EPackageHelper.getEPackages(res.getRawLocation().toString(), true,
						false);

				ePackages.entrySet().stream().filter(entry -> nsUris.contains(entry.getKey())).forEach(entry -> {
					ePackagesToRegister.put(entry.getKey(), entry.getValue());
					nsUris.remove(entry.getKey());
				});

				if (nsUris.isEmpty()) {
					break;
				}

			}
		}

		return ePackagesToRegister;
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
		private Set<EPackage> registeredPackages;

		/**
		 * This is the getter for the the {@link #registeredPackages}.
		 *
		 * @return The set of {@link EPackage EPackages} that have been registered during an 'EPackageCheck'.
		 */
		public Set<EPackage> getRegisteredPackages() {

			return this.registeredPackages == null ? new HashSet<>() : this.registeredPackages;
		}

		/**
		 * This sets the set of {@link #registeredPackages} for this instance of 'EPackageCheck'.
		 *
		 * @param registeredPackages
		 *            The set of {@link EPackage EPackages} to set as {@link #registeredPackages}.
		 * @return The instance of {@link EPackageCheck} after setting the registered packages.
		 */
		public EPackageCheck withRegisteredPackages(Set<EPackage> registeredPackages) {

			this.registeredPackages = registeredPackages;
			return this;
		}

	}
}
