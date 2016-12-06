package pamtram.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.tud.et.ifa.agtele.genlibrary.LibraryImplementationRegistry;
import de.tud.et.ifa.agtele.genlibrary.processor.impl.LibraryPluginImpl;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryContext;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPlugin;
import pamtram.metamodel.LibraryEntry;

/**
 * This class is responsible for creating, initializing, and (if necessary) updating an instance of the genlibrary
 * {@link LibraryPluginImpl} to be used during the generic transformation. Furthermore, other necessary elements like a
 * {@link LibraryContext} is managed as well.
 *
 * @author mfreund
 */
public class GenLibraryManager {

	/**
	 * This holds the instances of {@link LibraryPlugin} that are used for retrieving and instantiating library entries
	 * sorted by their associated ePackage URIs.
	 * <p />
	 * <b>This should only be accessed via the {@link #getLibraryPlugin()} method!</b>
	 */
	private Map<String, LibraryPlugin> libraryPlugins;

	/**
	 * This creates an instance.
	 */
	public GenLibraryManager() {
		this.libraryPlugins = new HashMap<>();
	}

	/**
	 * This returns the instance of {@link LibraryPlugin} that is used for retrieving and instantiating library entries
	 * for the given <em>ePackageURI</em>.
	 *
	 * @param ePackageURI
	 *            The namespace URI of the {@link EPackage} for which the associated {@link LibraryPlugin} shall be
	 *            returned.
	 * @return The instance.
	 */
	private LibraryPlugin getLibraryPlugin(String ePackageURI) {

		if (!this.libraryPlugins.containsKey(ePackageURI)) {
			this.libraryPlugins.put(ePackageURI,
					LibraryImplementationRegistry.getInstance().createLibraryPlugin(ePackageURI));
		}
		return this.libraryPlugins.get(ePackageURI);
	}

	/**
	 * This returns the {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry} for a given classpath. If
	 * <em>useHigher</em> is set to '<em><b>true</b></em>', a more abstract library entry will be returned if no entry
	 * can be determined for the given path.
	 *
	 * @param ePackageURI
	 *            The namespace URI of the {@link EPackage} for that a LibraryEntry shall be returned.
	 * @param classPath
	 *            The classPath that is used to retrieve the LibraryEntry.
	 * @param useHigher
	 *            Whether a more abstract LibraryEntry may be used.
	 * @return The retrieved LibraryEntry.
	 */
	public de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry getLibraryEntry(String ePackageURI,
			String classPath, boolean useHigher) {

		LibraryPlugin plugin = this.getLibraryPlugin(ePackageURI);
		return plugin != null ? this.getLibraryPlugin(ePackageURI).getElement(classPath, useHigher) : null;
	}

	/**
	 * This returns the {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry} for a given classpath.
	 * Before the entry is retrieved, a new library path is set in the target library.</br>
	 * </br>
	 * <b>Attention: This has side-effects for subsequent calls to {@link #getLibraryEntry(String, String, boolean)}
	 * because the library path is permanently changed!</b></br>
	 * </br>
	 * If <em>useHigher</em> is set to '<em><b>true</b></em>', a more abstract library entry will be returned if no
	 * entry can be determined for the given path.
	 *
	 * @param ePackageURI
	 *            The namespace URI of the {@link EPackage} for that a LibraryEntry shall be returned.
	 * @param libPath
	 *            The path to the library to be used to retrieve the LibraryEntry.
	 * @param classPath
	 *            The classPath that is used to retrieve the LibraryEntry.
	 * @param useHigher
	 *            Whether a more abstract LibraryEntry may be used.
	 * @return The retrieved LibraryEntry.
	 */
	public de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry getLibraryEntry(String ePackageURI,
			String libPath, String classPath, boolean useHigher) {

		LibraryPlugin plugin = this.getLibraryPlugin(ePackageURI);
		if (plugin == null) {
			return null;
		}
		plugin.setLibPath(libPath);
		return plugin.getElement(classPath, useHigher);
	}

	/**
	 * This inserts the given library item into the given target model while taking the given Parameters into account.
	 * This is done by calling the function
	 * {@link LibraryPlugin#insertIntoTargetModel(EObject, de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry, String)}.
	 *
	 * @param targetModel
	 *            The target model into that the given library item shall be inserted.
	 * @param libraryEntry
	 *            The {@link LibraryEntry} to be inserted into the target model.
	 * @param libPath
	 *            The path to the library to be used to retrieve the LibraryEntry.
	 * @return The {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry} that has been inserted in the
	 *         target model.
	 */
	public de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry insertIntoTargetModel(EObject targetModel,
			LibraryEntry libraryEntry, String libPath) {

		/*
		 * We need to create a self-contained copy of the library entry and pass it to the LibraryPlugin. Otherwise, the
		 * same instance (just with new parameters values) might be inserted multiple times in case of cardinalities > 1
		 * if the caller would not handle this by himself. This would lead to strange behavior.
		 */
		de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry originalLibraryEntry = EcoreUtil
				.copy(libraryEntry.getOriginalLibraryEntry());

		EObject rootPackage = EcoreUtil.getRootContainer(targetModel.eClass());

		if (!(rootPackage instanceof EPackage)) {
			return null;
		}

		LibraryPlugin plugin = this.getLibraryPlugin(((EPackage) rootPackage).getNsURI());

		if (plugin == null) {
			return null;
		}

		plugin.setLibPath(libPath);
		plugin.insertIntoTargetModel(targetModel, originalLibraryEntry, libraryEntry.getPath().getValue());

		return originalLibraryEntry;
	}

	/**
	 * This inserts the given library item into the given target model while taking the given Parameters into account.
	 * This is done by calling the function
	 * {@link LibraryPlugin#insertIntoTargetModel(EObject, de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry, String)}.
	 *
	 * @param targetModel
	 *            The target model into that the given library item shall be inserted.
	 * @param libraryEntry
	 *            The {@link LibraryEntry} to be inserted into the target model.
	 * @param libPath
	 *            The path to the library to be used to retrieve the LibraryEntry.
	 * @param path
	 *            The classpath of the '<em>libraryEntry</em>' to be inserted.
	 * @return The {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry} that has been inserted in the
	 *         target model.
	 */
	public de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry insertIntoTargetModel(EObject targetModel,
			de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry libraryEntry, String libPath, String path) {

		/*
		 * We need to create a self-contained copy of the library entry and pass it to the LibraryPlugin. Otherwise, the
		 * same instance (just with new parameters values) might be inserted multiple times in case of cardinalities > 1
		 * if the caller would not handle this by himself. This would lead to strange behavior.
		 */
		de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry originalLibraryEntry = EcoreUtil
				.copy(libraryEntry);

		EObject rootPackage = EcoreUtil.getRootContainer(targetModel.eClass());

		if (!(rootPackage instanceof EPackage)) {
			return null;
		}

		LibraryPlugin plugin = this.getLibraryPlugin(((EPackage) rootPackage).getNsURI());

		if (plugin == null) {
			return null;
		}

		plugin.setLibPath(libPath);
		plugin.insertIntoTargetModel(targetModel, originalLibraryEntry, path);

		return originalLibraryEntry;
	}

}
