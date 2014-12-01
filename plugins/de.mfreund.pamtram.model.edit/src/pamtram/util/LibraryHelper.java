package pamtram.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import pamtram.metamodel.LibraryElement;
import pamtram.metamodel.impl.MetamodelFactoryImpl;
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
	 * This method converts a LibraryEntry represented by a given path to the library file and a 
	 * relative path inside the library file to a pamtram LibraryElement. Therefore, it iterates
	 * through the library entry and generates TargetSectionClasses, -References and -Attributes
	 * for every model element it encounters if its type is represented in the target model.
	 * Consequently, no Classes, References or Attributes are created for the 'library' types like
	 * 'MetaData', 'Resource' and so on.
	 * 
	 * @param libraryFile The path to a library file (Zip or Jar).
	 * @param path The path of the library entry inside the library (e.g. 'my.path').
	 * @return The generated LibraryElement.
	 * @throws IOException If something goes wrong during loading the libraryFile or the XMI file inside
	 * the library file representing the LibraryEntry. 
	 */
	public static LibraryElement convertToLibraryElement(String libraryFile, String path) throws IOException {
		
		LibraryFileEntry libFileEntry = getLibraryFileEntry(libraryFile, path);
		
		return convertToLibraryElement(libFileEntry);
	}
	
	/**
	 * This method converts a LibraryEntry to a pamtram LibraryElement. Therefore, it iterates
	 * through the library entry and generates TargetSectionClasses, -References and -Attributes
	 * for every model element it encounters if its type is represented in the target model.
	 * Consequently, no Classes, References or Attributes are created for the 'library' types like
	 * 'MetaData', 'Resource' and so on.
	 * 
	 * @param libFileEntry The LibraryEntry to be converted into a LibraryElement.
	 * @return The generated LibraryElement.
	 * @throws IOException If something goes wrong during loading the libraryFile. 
	 */
	public static LibraryElement convertToLibraryElement(LibraryFileEntry libFileEntry) throws IOException {
		
		LibraryEntry libEntry = getLibraryEntry(libFileEntry);
		
		LibraryElement libElement = MetamodelFactoryImpl.eINSTANCE.createLibraryElement();
		
		// set the path, version, etc.
		libElement.setVersion(libEntry.getVersion());
		libElement.setPath(libFileEntry.getKey());
		libElement.setLibraryFile(libFileEntry.getXMIFileAsInputStream().toString()); //TODO check this
		
		// TODO create the rest of the library element
		
		return libElement;
	}

	/**
	 * This determines the LibraryFileEntry identified by a given combination of a library file and a path
	 * inside the library file.
	 * 
	 * @param libraryFile The path to a library file (Zip or Jar).
	 * @param path The path of the library entry inside the library (e.g. 'my.path').
	 * @return The LibraryFileEntry identified by the given combination of libraryFile and path; null
	 * if the LibraryFileEntry could not be determined.
	 * @throws IOException If something goes wrong during loading the libraryFile. 
	 */
	public static LibraryFileEntry getLibraryFileEntry(String libraryFile, String path) throws IOException {
		
		// get the library elements in the specified library file
		List<LibraryFileEntry> entries = (new FileParserImpl()).parseFile((new File(libraryFile)).toPath());
		
		// iterate over the entries to find the one that matches the given path
		for (LibraryFileEntry libraryFileEntry : entries) {
			if(libraryFileEntry.getKey().equals(path)) {
				return libraryFileEntry;
			}
		}
		return null;
	}

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
	public static LibraryEntry getLibraryEntry(LibraryFileEntry entry) throws IOException {
		
		if(entry == null) {
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
