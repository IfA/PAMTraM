/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
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
