package de.mfreund.gentrans.ui.launching;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

public class GentransLaunchConfigurationTabGroup extends
AbstractLaunchConfigurationTabGroup {

	public GentransLaunchConfigurationTabGroup() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
				new GentransLaunchMainTab(),
				new GentransLaunchAmbiguityTab(),
				new GentransLaunchLibraryTab(),
				new CommonTab()
		};
		setTabs(tabs);
	}

}
