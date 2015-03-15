package pamtram.util;

import java.io.File;

import org.eclipse.emf.ecore.EObject;

import pamtram.metamodel.LibraryEntry;
import de.tud.et.ifa.agtele.genlibrary.processor.impl.LibraryPluginImpl;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryContext;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPathParser;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPlugin;

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
	 * @param targetLibParserClass 
	 * @param targetLibContextClass 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public GenLibraryManager(Class<?> targetLibContextClass, Class<?> targetLibParserClass) throws InstantiationException, IllegalAccessException {
		/*TODO it would be desirable to somehow aquire an instance of the concrete library context and parser without
		 * actually knowing about the concrete language and without the user having to specify the bundle and class names; 
		 * this probably should be done via an extension point in the genlibrary plugin
		 */
		LibraryContext context = (LibraryContext) targetLibContextClass.newInstance();
		LibraryPathParser parser = targetLibParserClass != null ? (LibraryPathParser) targetLibParserClass.newInstance() : null;
		getLibraryPlugin().init(context, parser);
	}
	
	/**
	 * This inserts the given library item into the given target model while
	 * taking the given Parameters into account. This is done by calling the
	 * function {@link LibraryPlugin#insertIntoTargetModel(EObject, LibraryEntry, String)}.
	 * 
	 * @param targetModel
	 *            The target model into that the given library item shall be
	 *            inserted.
	 * @param libraryEntry
	 *            The {@link LibraryEntry} to be inserted
	 *            into the target model.
	 */
	public void insertIntoTargetModel(EObject targetModel, LibraryEntry libraryEntry) {
		
		getLibraryPlugin().setLibPath(new File(libraryEntry.getLibraryFile()).getParent());
		getLibraryPlugin().insertIntoTargetModel(
				targetModel, 
				libraryEntry.getOriginalLibraryEntry(), 
				libraryEntry.getPath());
	}
}
