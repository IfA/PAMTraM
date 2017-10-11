package pamtram.util;

import java.io.File;
import java.util.ArrayList;
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
import org.eclipse.core.resources.ResourcesPlugin;
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
import de.tud.et.ifa.agtele.resources.ResourceHelper;
import pamtram.PAMTraM;
import pamtram.SectionModel;
import pamtram.provider.PamtramEditPlugin;

/**
 * A utility class that allows can check if {@link EPackage EPackages} referenced in a {@link PAMTraM} model are already
 * registered and, if not, can register them on-the-fly.
 *
 * @author mfreund
 */
public interface PamtramModelUtil extends EPackageHelper {

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
		Resource pamtramResource = resourceSet.getResource(ResourceHelper.getURIForPathString(
				project.getName() + File.separator + PamtramEditPlugin.INSTANCE.getString("PAMTRAM_FOLDER_NAME")
						+ File.separator + pamtramFile.getName()),
				true);
		EList<EObject> contents = pamtramResource.getContents();
		if (contents == null || contents.isEmpty() || !(contents.get(0) instanceof PAMTraM)) {
			return EPackageCheck.ERROR_PAMTRAM_NOT_FOUND;
		}
		pamtram = (PAMTraM) contents.get(0);

		return PamtramModelUtil.checkInvolvedEPackages(pamtram, project, registry);
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
				.concat(Stream.concat(pamtram.getSourceSectionModels().stream(),
						pamtram.getSharedSourceSectionModels().stream()),
						Stream.concat(pamtram.getTargetSectionModels().stream(),
								pamtram.getSharedTargetSectionModels().stream()))
				.map(SectionModel::getMetaModelPackage).collect(Collectors.toSet());

		// collect the nsUris of all ePackages that are proxies (which means
		// they have not been
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

		// try to register the remaining ePackages manually by searching for the
		// metamodels
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
		ePackagesToRegister = PamtramModelUtil.searchMetamodelsForPackages(nsUrisToRegister, Arrays.asList(members));

		// register all found ePackages
		//
		registry.putAll(ePackagesToRegister);

		return nsUrisToRegister.isEmpty()
				? EPackageCheck.OK_PACKAGES_REGISTERED
						.withRegisteredPackages(new HashSet<>(ePackagesToRegister.values()))
				: EPackageCheck.ERROR_PACKAGE_NOT_FOUND;
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

				// Register all EPackages defined in the given resource because
				// they probably require each other
				//
				if (ePackages.keySet().stream().anyMatch(nsUris::contains)) {
					ePackagesToRegister.putAll(ePackages);
					nsUris.removeAll(ePackages.keySet());
				}

				if (nsUris.isEmpty()) {
					break;
				}

			}
		}

		return ePackagesToRegister;
	}

	/**
	 * This describes the result of checking references {@link EPackage EPackages} involved in a {@link PAMTraM} model.
	 *
	 * @author mfreund
	 */
	public enum EPackageCheck {

		/**
		 * Indicates that the check was successful and no packages needed to be registered.
		 */
		OK_NOTHING_REGISTERED,
		/**
		 * Indicates that the check was successful and that packages needed to be registered.
		 */
		OK_PACKAGES_REGISTERED,
		/**
		 * Indicates that the check was not successful because one or multiple packages referenced in a pamtram model
		 * could not be found.
		 */
		ERROR_PACKAGE_NOT_FOUND,
		/**
		 * Indicates that the check was not successful because the pamtram instance could not be determined.
		 */
		ERROR_PAMTRAM_NOT_FOUND,
		/**
		 * Indicates that the check was not successful because the metamodel folder of the pamtram project containing
		 * the pamtram model could not be determined.
		 */
		ERROR_METAMODEL_FOLDER_NOT_FOUND;

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

	/**
	 * This loads multiple {@link PAMTraM} models. If necessary, additional {@link EPackage EPackages} that are
	 * referenced in the model(s) are registered so that no errors occur during the transformation.
	 *
	 * @see #loadPamtramModel(ResourceSet, String, boolean)
	 *
	 * @param resourceSet
	 *            The resource set to be used to load the resource.
	 * @param pamtramPaths
	 *            The paths of the {@link PAMTraM} models to load in the form 'project-name/path'.
	 * @param registerPackagesGlobally
	 *            If this is set to '<em>true</em>', new {@link EPackage EPackages} will be registered to the global
	 *            {@link org.eclipse.emf.ecore.EPackage.Registry} (so they are also available for other tools,
	 *            frameworks, etc.); otherwise, they will be registered to the local registry of the given
	 *            {@link ResourceSet#getPackageRegistry() ResourceSet}.
	 * @return The loaded {@link PAMTraM} models or an empty list if no model was loaded.
	 * @throws ModelLoadException
	 *             If an error occurs during loading one of a PAMTraM model.
	 */
	public static List<PAMTraM> loadPamtramModels(ResourceSet resourceSet, Set<String> pamtramPaths,
			boolean registerPackagesGlobally) throws ModelLoadException {

		List<PAMTraM> pamtramModels = new ArrayList<>();

		for (String pamtramPath : pamtramPaths) {

			pamtramModels.add(PamtramModelUtil.loadPamtramModel(resourceSet, pamtramPath, registerPackagesGlobally));
		}

		return pamtramModels;
	}

	/**
	 * This loads a single {@link PAMTraM} model. If necessary, additional {@link EPackage EPackages} that are
	 * referenced in the model(s) are registered so that no errors occur during the transformation.
	 *
	 * @see #loadPamtramModels(ResourceSet, Set, boolean)
	 *
	 * @param resourceSet
	 *            The resource set to be used to load the resource.
	 * @param pamtramPath
	 *            The path of the {@link PAMTraM} model to load. The path must either be absolute or relative to the
	 *            workspace root (of the form '<em>/project-name/path</em>').
	 * @param registerPackagesGlobally
	 *            If this is set to '<em>true</em>', new {@link EPackage EPackages} will be registered to the global
	 *            {@link org.eclipse.emf.ecore.EPackage.Registry} (so they are also available for other tools,
	 *            frameworks, etc.); otherwise, they will be registered to the local registry of the given
	 *            {@link ResourceSet#getPackageRegistry() ResourceSet}.
	 * @return The loaded {@link PAMTraM} model; '<em><b>null</b></em>' if the model could not be loaded.
	 * @throws ModelLoadException
	 *             If an error occurs during loading one of a PAMTraM model.
	 */
	public static PAMTraM loadPamtramModel(ResourceSet resourceSet, String pamtramPath,
			boolean registerPackagesGlobally) throws ModelLoadException {

		// the URI of the pamtram resource
		final URI pamtramUri = ResourceHelper.getURIForPathString(pamtramPath);

		return PamtramModelUtil.loadPamtramModel(resourceSet, pamtramUri, registerPackagesGlobally);

	}

	/**
	 * This loads a single {@link PAMTraM} model. If necessary, additional {@link EPackage EPackages} that are
	 * referenced in the model(s) are registered so that no errors occur during the transformation.
	 *
	 * @see #loadPamtramModels(ResourceSet, Set, boolean)
	 *
	 * @param resourceSet
	 *            The resource set to be used to load the resource.
	 * @param pamtramUri
	 *            The absolute, platform {@link URI} of the {@link PAMTraM} model to load in the form
	 *            'project-name/path'.
	 * @param registerPackagesGlobally
	 *            If this is set to '<em>true</em>', new {@link EPackage EPackages} will be registered to the global
	 *            {@link org.eclipse.emf.ecore.EPackage.Registry} (so they are also available for other tools,
	 *            frameworks, etc.); otherwise, they will be registered to the local registry of the given
	 *            {@link ResourceSet#getPackageRegistry() ResourceSet}.
	 * @return The loaded {@link PAMTraM} model; '<em><b>null</b></em>' if the model could not be loaded.
	 * @throws ModelLoadException
	 *             If an error occurs during loading one of a PAMTraM model.
	 */
	public static PAMTraM loadPamtramModel(ResourceSet resourceSet, URI pamtramUri, boolean registerPackagesGlobally)
			throws ModelLoadException {

		// The ePackage registry to which we will on-the-fly-register new
		// packages.
		//
		EPackage.Registry ePackageRegistry = registerPackagesGlobally ? EPackage.Registry.INSTANCE
				: resourceSet.getPackageRegistry();

		// a temporary resource set that we will use to load the PAMTraM
		// model; this allows us to safely load resources even if
		// packages are not yet registered because errors won't show up in
		// the original resource set
		//
		ResourceSet tempResourceSet = new ResourceSetImpl();
		tempResourceSet.setPackageRegistry(resourceSet.getPackageRegistry());

		// load the pamtram model
		Resource pamtramResource = tempResourceSet.getResource(pamtramUri, true);
		if (!(pamtramResource.getContents().get(0) instanceof PAMTraM)) {
			throw new ModelLoadException("The pamtram file does not seem to contain a pamtram instance. Aborting...");
		}

		PAMTraM pamtramModel = (PAMTraM) pamtramResource.getContents().get(0);

		// try to register the ePackages involved in the pamtram model (if
		// not already done)
		//
		EPackageCheck result = PamtramModelUtil.checkInvolvedEPackages(pamtramModel,
				ResourcesPlugin.getWorkspace().getRoot().findMember(pamtramUri.toPlatformString(true)).getProject(),
				ePackageRegistry);
		switch (result) {
			case ERROR_PACKAGE_NOT_FOUND:
				throw new ModelLoadException("One or more EPackages are not loaded correctly. Aborting...");
			case ERROR_METAMODEL_FOLDER_NOT_FOUND:
			case ERROR_PAMTRAM_NOT_FOUND:
				throw new ModelLoadException("Internal error during EPackage check. Aborting...");
			case OK_PACKAGES_REGISTERED:
				// if packages have been registered, we reload the model with
				// the original resource set; otherwise, proxy resolving does
				// not seem to work correctly
				pamtramModel.eResource().unload();
				pamtramResource = resourceSet.getResource(pamtramUri, true);
				pamtramModel = (PAMTraM) pamtramResource.getContents().get(0);
				break;
			case OK_NOTHING_REGISTERED:
				// if nothing needed to be registered, we can simply add the
				// loaded resource(s) to the original resource set
				resourceSet.getResources().addAll(tempResourceSet.getResources());
				break;
			default:
				break;
		}

		return pamtramModel;
	}

	/**
	 * An exception indicating that an error occurred during the loading of a PAMTraM model.
	 *
	 * @author mfreund
	 */
	public class ModelLoadException extends Exception {

		/**
		 */
		private static final long serialVersionUID = 7579535732138640478L;

		/**
		 * Constructs a new exception with the specified detail message.
		 *
		 * @param message
		 */
		public ModelLoadException(String message) {

			super(message);
		}

		/**
		 * Constructs a new exception with the specified cause.
		 *
		 * @param cause
		 */
		public ModelLoadException(Throwable cause) {

			super(cause);
		}

		/**
		 * Constructs a new exception with the specified message and cause.
		 *
		 * @param message
		 * @param cause
		 */
		public ModelLoadException(String message, Throwable cause) {

			super(message, cause);
		}

	}
}
