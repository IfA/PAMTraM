package de.mfreund.pamtram.launching;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;

public class GentransLaunchingDelegate implements ILaunchConfigurationDelegate {

	@Override
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		System.out.println("launching via the delegate");
		System.out.println(configuration.getAttribute("project", ""));
		System.out.println(configuration.getAttribute("srcFile", ""));
		System.out.println(configuration.getAttribute("pamtramFile", ""));
		System.out.println(configuration.getAttribute("targetFile", ""));
	}

}
