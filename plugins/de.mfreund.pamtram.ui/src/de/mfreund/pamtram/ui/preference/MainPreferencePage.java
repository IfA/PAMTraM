package de.mfreund.pamtram.ui.preference;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import de.mfreund.pamtram.ui.PamtramUIPlugin;

/**
 * A page to display the main preferences for the PAMTraM plug-ins.
 * 
 * @author mfreund
 */
public class MainPreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	public MainPreferencePage() {
		super(GRID);
	}

	public MainPreferencePage(String title, ImageDescriptor image, int style) {
		super(title, image, style);
	}

	@Override
	public void init(IWorkbench workbench) {
		 setPreferenceStore(PamtramUIPlugin.getPlugin().getPreferenceStore());
		 setDescription("General PAMTraM settings:");
	}

	@Override
	protected void createFieldEditors() {
		
		/*
		 * a field to control the auto-setting/updating of element names based on
		 * relevant structural features
		 */
		addField(new BooleanFieldEditor("AUTO-SET-NAMES",
		        "Automatically set/update element names", getFieldEditorParent()));

	}

}
