package pamtram.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import de.tud.et.ifa.agtele.movisa.library.model.Library.LibraryEntry;
import de.tud.et.ifa.agtele.movisa.library.utilities.impl.FileParserImpl;
import de.tud.et.ifa.agtele.movisa.library.utilities.interfaces.LibraryFileEntry;


/**
 * This class provides convenience functions to work with library items.
 * 
 * @author mfreund
 */
public class LibraryHelper {

	/**
	 * This determines the LibraryEntry identified by a given combination of a library file and a path
	 * inside the library file.
	 * 
	 * @param libraryFile The path to a library file (Zip or Jar).
	 * @param path The path of the library entry inside the library (e.g. 'my.path').
	 * @return The LibraryEntry identified by the given combination of libraryFile and path; null
	 * if the LibraryEntry could not be determined.
	 * @throws IOException If something goes wrong during loading the libraryFile or the XMI file inside
	 * the library file representing the LibraryEntry. 
	 */
	public static LibraryEntry getLibraryEntry(String libraryFile, String path) throws IOException {
		
		// get the library elements in the specified library file
		List<LibraryFileEntry> entries = (new FileParserImpl()).parseFile((new File(libraryFile)).toPath());
		LibraryFileEntry entry = null;
		
		// iterate over the entries to find the one that matches the given path
		for (LibraryFileEntry libraryFileEntry : entries) {
			if(libraryFileEntry.getKey().equals(path)) {
				entry = libraryFileEntry;
				break;
			}
		}
		
		if(entry == null) {
			// no entry has been found
			return null;
		}
		
		// try to load the resource
		InputStream inputStream = entry.getXMIFileAsInputStream();
		Resource resource = new XMIResourceImpl();
		resource.load(inputStream, null);
		
		// get the library entry from the resource contents and return it
		if(!(resource.getContents() == null) && !resource.getContents().isEmpty() &&
				resource.getContents().get(0) instanceof LibraryEntry) {
			return (LibraryEntry) resource.getContents().get(0);
		}
		
		return null;
	}
}
