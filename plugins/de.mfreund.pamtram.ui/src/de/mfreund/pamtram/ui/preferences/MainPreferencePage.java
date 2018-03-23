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

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import de.mfreund.pamtram.preferences.PreferenceSupplier;
import de.mfreund.pamtram.ui.PamtramUIPlugin;

/**
 * A {@link PreferencePage} to display the main preferences for the PAMTraM plug-ins.
 *
 * @author mfreund
 */
public class MainPreferencePage extends FieldEditorPreferencePage implements
IWorkbenchPreferencePage {

	@Override
	public void init(IWorkbench workbench) {

		// Set the PreferenceStore used to store the preferences
		//
		this.setPreferenceStore(PamtramUIPlugin.getPlugin().getPreferenceStore());

		this.setDescription("General PAMTraM settings:");
	}

	@Override
	protected void createFieldEditors() {

		// A field to control the auto-setting/updating of element names based on
		// relevant structural features
		//
		this.addField(new BooleanFieldEditor(PreferenceSupplier.PREF_AUTO_SET_NAMES,
				"Automatically set/update element names", this.getFieldEditorParent()));

		// A field to control the persisting of type information for references
		//
		this.addField(new BooleanFieldEditor(PreferenceSupplier.PREF_SERIALIZE_ALL_TYPE_INFO,
				"Persist type information for every reference type", this.getFieldEditorParent()));

		// A field to control whether 'create child texts' are displayed in an enhanced form ('referenceName ->
		// createChildText' instead of only 'createChildText')
		//
		this.addField(new BooleanFieldEditor(PreferenceSupplier.PREF_ENHANCED_CREATE_CHILD_TEXTS,
				"Enhance 'create child texts' by prepending them with the corresponding feature name",
				this.getFieldEditorParent()));

	}

}
