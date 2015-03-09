package de.mfreund.pamtram.preferences;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is responsible for the definition of preferences for the PAMTraM plug-ins and default 
 * values for these preferences.
 * 
 * @author mfreund
 */
public class PreferenceSupplier {

	/*
	 * This preference is used to enable/disable the automatic setting/updating
	 * of element names if a relevant feature is set/changed.
	 */
	public static final String PREF_AUTO_SET_NAMES = "AUTO-SET-NAMES";
	public static final boolean DEFAULT_AUTO_SET_NAMES = true;
	
	/**
	 * This returns a map of preferences and default values for the PAMTraM plug-ins.
	 * 
	 * @return The map of preferences (keys) and default values (values).
	 */
	public static Map<String, String> getInitializationEntries() {
		Map<String, String> entries = new HashMap<>();
		
		entries.put(PREF_AUTO_SET_NAMES, Boolean.toString(DEFAULT_AUTO_SET_NAMES));
		
		return entries;
	}
}
