package de.mfreund.pamtram;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class PamtramPerspectiveFactory implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {
		defineActions(layout);
		defineLayout(layout);
	}
	
	private void defineActions(IPageLayout layout) {
		layout.addNewWizardShortcut("pamtram.presentation.PamtramModelWizardID");
		layout.addNewWizardShortcut("de.mfreund.pamtram.newProjectWizard");
		
		layout.addShowViewShortcut("org.eclipse.ui.views.ProblemView");
		layout.addShowViewShortcut("org.eclipse.ui.console.ConsoleView");
		layout.addShowViewShortcut(IPageLayout.ID_PROP_SHEET);
		
	}

	private void defineLayout(IPageLayout layout) {
        
		String editorArea = layout.getEditorArea();

        IFolderLayout left = layout.createFolder(
        		"left", IPageLayout.LEFT, (float) 0.2, editorArea);
        left.addView("org.eclipse.jdt.ui.PackageExplorer");
        
        IFolderLayout bottom = layout.createFolder(
        		"bottom", IPageLayout.BOTTOM, (float) 0.7, editorArea);
        bottom.addView("org.eclipse.ui.views.ProblemView");
        bottom.addView("org.eclipse.ui.console.ConsoleView");
        bottom.addView(IPageLayout.ID_PROP_SHEET);
	}

}
