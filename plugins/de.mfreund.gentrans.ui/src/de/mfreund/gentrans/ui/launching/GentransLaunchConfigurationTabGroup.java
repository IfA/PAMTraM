package de.mfreund.gentrans.ui.launching;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

/**
 * An {@link AbstractLaunchConfigurationTabGroup} to host the various {@link ILaunchConfigurationTab tabs} necessary to
 * customize a GenTrans transformation.
 * <p />
 * This will host a {@link GentransLaunchMainTab}, a {@link GentransLaunchAmbiguityTab}, a
 * {@link GentransLaunchLibraryTab} and a {@link CommonTab}.
 *
 * @author mfreund
 */
public class GentransLaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup {

	/**
	 * This creates an instance.
	 *
	 */
	public GentransLaunchConfigurationTabGroup() {
		// nothing to be done here
	}

	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		GentransLaunchContext context = new GentransLaunchContext();
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
				new GentransLaunchMainTab(context),
				new GentransLaunchAmbiguityTab(context),
				new GentransLaunchLibraryTab(context),
				new CommonTab()
		};
		this.setTabs(tabs);
	}

}
