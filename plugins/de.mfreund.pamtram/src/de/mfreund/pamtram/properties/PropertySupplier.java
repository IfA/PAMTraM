package de.mfreund.pamtram.properties;


/**
 * This class is responsible for the definition of properties for the PAMTraM plug-ins and default 
 * values for these properties.
 * 
 * @author mfreund
 */
public class PropertySupplier {

	/**
	 * This property is used to specify the bundle (plug-in) that holds the LibraryContext
	 * and LibraryPathParser that is used to instantiate target library entries.
	 */
	public static final String PROP_LIBRARY_TARGET_BUNDLE = "LIBRARY-TARGET-BUNDLE";
	public static final String DEFAULT_LIBRARY_TARGET_BUNDLE = "";
	/**
	 * This property is used to specify the concrete LibraryContext
	 * that is used to instantiate target library entries.
	 */
	public static final String PROP_LIBRARY_TARGET_CONTEXT = "LIBRARY-TARGET-CONTEXT";
	public static final String DEFAULT_LIBRARY_TARGET_CONTEXT = "";
	/**
	 * This property is used to specify the concrete LibraryPathParser 
	 * that is used to parser classpaths of the target library.
	 */
	public static final String PROP_LIBRARY_TARGET_PARSER = "LIBRARY-TARGET-PARSER";
	public static final String DEFAULT_LIBRARY_TARGET_PARSER = "";
	/*
	 * More properties can be defined here...
	 */
	// public static final ...
	// public static final ...
	
	/**
	 * This is the id of the bundle that identifies the properties.
	 */
	public static final String PROPERTY_QUALIFIER = "de.mfreund.pamtram";
	
}
