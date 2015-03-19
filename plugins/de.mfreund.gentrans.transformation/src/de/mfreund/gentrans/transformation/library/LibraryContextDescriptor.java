package de.mfreund.gentrans.transformation.library;

import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryContext;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPathParser;

/**
 * This class represents a POJO for the description of a library context.
 * 
 * @author mfreund
 *
 */
public class LibraryContextDescriptor {

	/**
	 * This keeps track of the full path to the folder that holds the library to
	 * be used.
	 */
	private final String libraryPath;
	
	/**
	 * This is the public getter for the {@link #libraryPath} field.
	 * @return The {@link #libraryPath}.
	 */
	public String getLibraryPath() {
		return libraryPath;
	}
	
	/**
	 * This keeps track of the concrete implementation of {@link LibraryContext} that shall be
	 * used to instantiate library entries.
	 */
	private final Class<LibraryContext> libraryContextClass;
	
	/**
	 * This is the public getter for the {@link #libraryContextClass} field.
	 * @return The {@link #libraryContextClass}.
	 */
	public Class<LibraryContext> getLibraryContextClass() {
		return this.libraryContextClass;
	}
	
	/**
	 * This keeps track of the concrete implementation of {@link LibraryPathParser} that shall be
	 * used to parse classpaths of the library.
	 */
	private final Class<LibraryPathParser> libraryPathParserClass;
	
	/**
	 * This is the public getter for the {@link #libraryPathParserClass} field.
	 * @return The {@link #libraryPathParserClass}.
	 */
	public Class<LibraryPathParser> getLibraryPathParserClass() {
		return this.libraryPathParserClass;
	}
	
	/**
	 * This is the public constructor for the library context.
	 * 
	 * @param libraryPath The full path to the folder that holds the library to
	 * be used.
	 * @param libraryContextClass The concrete implementation of {@link LibraryContext} that shall be
	 * used to instantiate library entries.
	 * @param libraryPathParserClass The concrete implementation of {@link LibraryPathParser} that shall be
	 * used to parse classpaths of the library.
	 */
	public LibraryContextDescriptor(
			String libraryPath,
			Class<LibraryContext> libraryContextClass,
			Class<LibraryPathParser> libraryPathParserClass) {
		
		this.libraryPath = libraryPath;
		this.libraryContextClass = libraryContextClass;
		this.libraryPathParserClass = libraryPathParserClass;
	}
}
