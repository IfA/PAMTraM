package de.mfreund.gentrans.transformation.library;

import de.tud.et.ifa.agtele.genlibrary.processor.impl.LibraryPluginImpl;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryContext;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPlugin;

/**
 * This class is responsible for creating, initializing, and (if necessary) updating
 * an instance of the genlibrary {@link LibraryPluginImpl} to be used during the generic
 * transformation. Furthermore, other necessary elements like a {@link LibraryContext} is
 * managed as well.
 * 
 * @author mfreund
 */
class GenLibraryManager {
	
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
	 */
	public GenLibraryManager() {}
}
