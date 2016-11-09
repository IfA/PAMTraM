package de.mfreund.pamtram.ui.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import de.mfreund.pamtram.preferences.PreferenceSupplier;
import de.mfreund.pamtram.ui.PamtramUIPlugin;

/**
 * A page to display the main preferences for the PAMTraM plug-ins.
 *
 * @author mfreund
 */
public class MainPreferencePage extends FieldEditorPreferencePage implements
IWorkbenchPreferencePage {

	public MainPreferencePage() {
		super(FieldEditorPreferencePage.GRID);
	}

	public MainPreferencePage(String title, ImageDescriptor image, int style) {
		super(title, image, style);
	}

	@Override
	public void init(IWorkbench workbench) {
		// set the PreferenceStore where the preferences are to be stored
		this.setPreferenceStore(PamtramUIPlugin.getPlugin().getPreferenceStore());

		this.setDescription("General PAMTraM settings:");
	}

	@Override
	protected void createFieldEditors() {

		/*
		 * a field to control the auto-setting/updating of element names based on
		 * relevant structural features
		 */
		this.addField(new BooleanFieldEditor(PreferenceSupplier.PREF_AUTO_SET_NAMES,
				"Automatically set/update element names", this.getFieldEditorParent()));

		/*
		 * a field to control the persisting of type information for references
		 */
		this.addField(new BooleanFieldEditor(PreferenceSupplier.PREF_SERIALIZE_ALL_TYPE_INFO,
				"Persist type information for every reference type", this.getFieldEditorParent()));

		/*
		 * a field to control whether 'create child texts' are displayed in an enhanced form ('referenceName ->
		 * createChildText' instead of only 'createChildText')
		 */
		this.addField(new BooleanFieldEditor(PreferenceSupplier.PREF_ENHANCED_CREATE_CHILD_TEXTS,
				"Enhance 'create child texts' by prepending them with the corresponding feature name",
				this.getFieldEditorParent()));

	}

}
