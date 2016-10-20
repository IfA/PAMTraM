package de.mfreund.pamtram.preferences;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.core.runtime.preferences.InstanceScope;

/**
 * This class is responsible for the definition of preferences for the PAMTraM plug-ins and default
 * values for these preferences.
 *
 * @author mfreund
 */
public abstract class PreferenceSupplier {

	/**
	 * This preference is used to enable/disable the automatic setting/updating
	 * of element names if a relevant feature is set/changed.
	 */
	public static final String PREF_AUTO_SET_NAMES = "AUTO-SET-NAMES";

	/**
	 * The default value for the {@link #PREF_AUTO_SET_NAMES} preference.
	 */
	public static final boolean DEFAULT_AUTO_SET_NAMES = true;

	/**
	 * This preference is used to control whether type information
	 * (xsi:type/xmi:type=...) shall to be serialized for every reference type or only for
	 * those types where it is mandatory.
	 */
	public static final String PREF_SERIALIZE_ALL_TYPE_INFO = "SERIALIZE-ALL-TYPE-INFO";

	/**
	 * The default value for the {@link #DEFAULT_SERIALIZE_ALL_TYPE_INFO} preference.
	 */
	public static final boolean DEFAULT_SERIALIZE_ALL_TYPE_INFO = false;

	/**
	 * This preference is used to enable/disable the enhanced displaying of create child texts in the form
	 * 'referenceName -> createChildText' instead of only 'createChildText'.
	 */
	public static final String PREF_ENHANCED_CREATE_CHILD_TEXTS = "ENHANCED-CREATE-CHILD-TEXTS";

	/**
	 * The default value for the {@link #PREF_ENHANCED_CREATE_CHILD_TEXTS} preference.
	 */
	public static final boolean DEFAULT_ENHANCED_CREATE_CHILD_TEXTS = true;

	/*
	 * More preferences can be defined here...
	 */
	// public static final ...
	// public static final ...

	/**
	 * The scope to be used for the preferences.
	 */
	public static final IScopeContext SCOPE_CONTEXT = InstanceScope.INSTANCE;

	/**
	 * The preference node where the preferences are stored.
	 */
	public static final String PREFERENCE_NODE = "de.mfreund.pamtram.ui";

	/**
	 * Create an instance. This should not be necessary as we only declare static fields an methods.
	 */
	private PreferenceSupplier() {}

	/**
	 * This returns a map of preferences and default values for the PAMTraM plug-ins.
	 *
	 * @return The map of preferences (keys) and default values (values).
	 */
	public static Map<String, String> getInitializationEntries() {
		Map<String, String> entries = new HashMap<>();

		entries.put(PreferenceSupplier.PREF_AUTO_SET_NAMES, Boolean.toString(PreferenceSupplier.DEFAULT_AUTO_SET_NAMES));
		entries.put(PreferenceSupplier.PREF_SERIALIZE_ALL_TYPE_INFO, Boolean.toString(PreferenceSupplier.DEFAULT_SERIALIZE_ALL_TYPE_INFO));
		entries.put(PreferenceSupplier.PREF_ENHANCED_CREATE_CHILD_TEXTS,
				Boolean.toString(PreferenceSupplier.DEFAULT_ENHANCED_CREATE_CHILD_TEXTS));

		return entries;
	}

	/**
	 * This returns the preferences for the PAMTraM plug-ins.
	 *
	 * @return The preferences.
	 */
	public static IEclipsePreferences getPreferences() {

		return PreferenceSupplier.SCOPE_CONTEXT.getNode(PreferenceSupplier.PREFERENCE_NODE);
	}

	/**
	 * This is a convenience method to get the current value of the '<em><b>AUTO-SET-NAMES</b></em>' preference.
	 *
	 * @return The current value of the '<em><b>AUTO-SET-NAMES</b></em>' preference.
	 */
	public static boolean isAutoSetNames() {
		return PreferenceSupplier.getPreferences().getBoolean(PreferenceSupplier.PREF_AUTO_SET_NAMES, PreferenceSupplier.DEFAULT_AUTO_SET_NAMES);
	}

	/**
	 * This is a convenience method to get the current value of the '<em><b>SERIALIZE-ALL-TYPE-INFO</b></em>'
	 * preference.
	 *
	 * @return The current value of the '<em><b>SERIALIZE-ALL-TYPE-INFO</b></em>' preference.
	 */
	public static boolean isSerializeAllTypeInfo() {
		return PreferenceSupplier.getPreferences().getBoolean(PreferenceSupplier.PREF_SERIALIZE_ALL_TYPE_INFO, PreferenceSupplier.DEFAULT_SERIALIZE_ALL_TYPE_INFO);
	}

	/**
	 * This is a convenience method to get the current value of the '<em><b>ENHANCED-CREATE-CHILD-TEXTS</b></em>'
	 * preference.
	 *
	 * @return The current value of the '<em><b>ENHANCED-CREATE-CHILD-TEXTS</b></em>' preference.
	 */
	public static boolean isEnhancedCreateChildTexts() {

		return PreferenceSupplier.getPreferences().getBoolean(PreferenceSupplier.PREF_ENHANCED_CREATE_CHILD_TEXTS,
				PreferenceSupplier.DEFAULT_ENHANCED_CREATE_CHILD_TEXTS);
	}
}
