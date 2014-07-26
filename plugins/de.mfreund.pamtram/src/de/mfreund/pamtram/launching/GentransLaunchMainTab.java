package de.mfreund.pamtram.launching;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;

public class GentransLaunchMainTab extends AbstractLaunchConfigurationTab {

	private FileFieldEditor srcFileFieldEditor;
	private FileFieldEditor pamtramFileFieldEditor;
	private FileFieldEditor targetFileFieldEditor;

	@Override
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		setControl(comp);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(getControl(), getHelpContextId());
		comp.setLayout(new GridLayout(3, true));
		comp.setFont(parent.getFont());
		
		// create a file selector for the source file
		srcFileFieldEditor = new FileFieldEditor("srcFileSelect", "", comp);
		srcFileFieldEditor.setLabelText("Source File:");
		// set the allowed file extensions
		srcFileFieldEditor.setFileExtensions(new String[]{"*.xmi"});
		// set a listener
		srcFileFieldEditor.setPropertyChangeListener(new IPropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent event) {
				
				// TODO
			}
		});
		
		// create a file selector for the pamtram file
		pamtramFileFieldEditor = new FileFieldEditor("pamtramFileSelect", "", comp);
		pamtramFileFieldEditor.setLabelText("Pamtram File:");
		// set the allowed file extensions
		pamtramFileFieldEditor.setFileExtensions(new String[]{"*.pamtram"});
		// set a listener
		pamtramFileFieldEditor.setPropertyChangeListener(new IPropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent event) {
				
				// TODO
			}
		});
		
		// create a file selector for the target file
		targetFileFieldEditor = new FileFieldEditor("srcFileSelect", "", comp);
		targetFileFieldEditor.setLabelText("Target File:");
		// set the allowed file extensions
		targetFileFieldEditor.setFileExtensions(new String[]{"*.xmi"});
		// set a listener
		targetFileFieldEditor.setPropertyChangeListener(new IPropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent event) {
				
				// TODO
			}
		});
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub

	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		return "Main";
	}

}
