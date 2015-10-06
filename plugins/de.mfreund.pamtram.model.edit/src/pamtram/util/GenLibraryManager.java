package pamtram.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.tud.et.ifa.agtele.genlibrary.LibraryContextDescriptor;
import de.tud.et.ifa.agtele.genlibrary.processor.impl.LibraryPluginImpl;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryContext;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPathParser;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPlugin;
import pamtram.metamodel.LibraryEntry;

/**
 * This class is responsible for creating, initializing, and (if necessary) updating
 * an instance of the genlibrary {@link LibraryPluginImpl} to be used during the generic
 * transformation. Furthermore, other necessary elements like a {@link LibraryContext} is
 * managed as well.
 * 
 * @author mfreund
 */
public class GenLibraryManager {

	/**
	 * This holds the single instance of the {@link LibraryPlugin} that is used for
	 * retrieving and instantiating library entries.</br></br>
	 * <b>This should only be accessed via the {@link #getLibraryPlugin()} method!</b>
	 */
	static private LibraryPlugin libraryPlugin;

	/**
	 * This returns the single instance of the {@link LibraryPlugin} that is used for
	 * retrieving and instantiating library entries.
	 * 
	 * @return The instance.
	 */
	private LibraryPlugin getLibraryPlugin() {
		if(libraryPlugin == null) {
			libraryPlugin = new LibraryPluginImpl();
		}
		return libraryPlugin;
	}

	/**
	 * This constructs an instance.
	 * @param libraryContextDescriptor The {@link LibraryContextDescriptor} to be used by this manager. 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public GenLibraryManager(LibraryContextDescriptor libraryContextDescriptor) throws InstantiationException, IllegalAccessException {
		LibraryContext context = libraryContextDescriptor.getLibraryContextClass().newInstance();
		LibraryPathParser parser = 
				libraryContextDescriptor.getLibraryPathParserClass() != null ? libraryContextDescriptor.getLibraryPathParserClass().newInstance() : null;
				getLibraryPlugin().init(libraryContextDescriptor.getLibraryPath(), context, parser);
	}

	/**
	 * This returns the {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry} for a given classpath.
	 * If <em>useHigher</em> is set to '<em><b>true</b></em>', a more abstract library entry will be returned if
	 * no entry can be determined for the given path.
	 * 
	 * @param classPath The classPath that is used to retrieve the LibraryEntry.
	 * @param useHigher Whether a more abstract LibraryEntry may be used.
	 * @return The retrieved LibraryEntry.
	 */
	public de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry getLibraryEntry(String classPath, boolean useHigher) {
		return getLibraryPlugin().getElement(classPath, useHigher);
	}

	/**
	 * This returns the {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry} for a given classpath.
	 * Before the entry is retrieved, a new library path is set in the target library.</br></br>
	 * <b>Attention: This has side-effects
	 * for subsequent calls to {@link #getLibraryEntry(String, boolean)} because the library path is permanently changed!</b></br></br>
	 * If <em>useHigher</em> is set to '<em><b>true</b></em>', a more abstract library entry will be returned if
	 * no entry can be determined for the given path.
	 * 
	 * @param libPath The path to the library to be used to retrieve the LibraryEntry.
	 * @param classPath The classPath that is used to retrieve the LibraryEntry.
	 * @param useHigher Whether a more abstract LibraryEntry may be used.
	 * @return The retrieved LibraryEntry.
	 */
	public de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry getLibraryEntry(String libPath, String classPath, boolean useHigher) {
		getLibraryPlugin().setLibPath(libPath);
		return getLibraryPlugin().getElement(classPath, useHigher);
	}

	/**
	 * This inserts the given library item into the given target model while
	 * taking the given Parameters into account. This is done by calling the
	 * function {@link LibraryPlugin#insertIntoTargetModel(EObject, de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry, String)}.
	 * 
	 * @param targetModel
	 *            The target model into that the given library item shall be
	 *            inserted.
	 * @param libraryEntry
	 *            The {@link LibraryEntry} to be inserted
	 *            into the target model.
	 */
	public void insertIntoTargetModel(EObject targetModel, LibraryEntry libraryEntry) {

		/*
		 * We need to create a self-contained copy of the library entry and pass it to the
		 * LibraryPlugin. Otherwise, the same instance (just with new parameters values) 
		 * might be inserted multiple times in case of cardinalities > 1 if the caller would
		 * not handle this by himself. This would lead to strange behavior. 
		 */
		de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry originalLibraryEntry = 
				EcoreUtil.copy(libraryEntry.getOriginalLibraryEntry());

		getLibraryPlugin().insertIntoTargetModel(
				targetModel, 
				originalLibraryEntry, 
				libraryEntry.getPath().getValue());
	}

	/**
	 * This inserts the given library item into the given target model while
	 * taking the given Parameters into account. This is done by calling the
	 * function {@link LibraryPlugin#insertIntoTargetModel(EObject, de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry, String)}.
	 * 
	 * @param targetModel
	 *            The target model into that the given library item shall be
	 *            inserted.
	 * @param libraryEntry
	 *            The {@link LibraryEntry} to be inserted
	 *            into the target model.
	 * @param path The classpath of the '<em>libraryEntry</em>' to be inserted.
	 */
	public void insertIntoTargetModel(EObject targetModel, de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry libraryEntry, String path) {

		/*
		 * We need to create a self-contained copy of the library entry and pass it to the
		 * LibraryPlugin. Otherwise, the same instance (just with new parameters values) 
		 * might be inserted multiple times in case of cardinalities > 1 if the caller would
		 * not handle this by himself. This would lead to strange behavior. 
		 */
		de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry originalLibraryEntry = 
				EcoreUtil.copy(libraryEntry);

		getLibraryPlugin().insertIntoTargetModel(
				targetModel, 
				originalLibraryEntry, 
				path);
	}

}