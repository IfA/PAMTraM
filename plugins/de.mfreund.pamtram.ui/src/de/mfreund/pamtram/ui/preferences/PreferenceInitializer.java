package de.mfreund.pamtram.ui.preferences;

import java.util.Map;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import de.mfreund.pamtram.preferences.PreferenceSupplier;
import de.mfreund.pamtram.ui.PamtramUIPlugin;

/**
 * An {@link AbstractPreferenceInitializer} that initializes the PAMTraM preferences with default values
 *
 * @author mfreund
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * The default preferences are initialized by contacting the {@link PreferenceSupplier} class
	 * from the '<em><b>de.mfreund.pamtram</b></em>' plug-in.
	 */
	@Override
	public void initializeDefaultPreferences() {

		IPreferenceStore store = PamtramUIPlugin.getPlugin().getPreferenceStore();
		Map<String, String> initializationEntries = PreferenceSupplier.getInitializationEntries();
		for (Map.Entry<String, String> entry : initializationEntries.entrySet()) {
			store.setDefault(entry.getKey(), entry.getValue());
		}
	}

}
