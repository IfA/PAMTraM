package de.mfreund.pamtram.ui;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * An {@link IPerspectiveFactory} that generates the layout and initializes actions for the <em>PAMTraM</em>
 * perspective.
 *
 * @author mfreund
 */
public class PamtramPerspectiveFactory implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {

		this.defineActions(layout);
		this.defineLayout(layout);
	}

	/**
	 * Customize the <em>new wizard</em> and <em>show view</em> actions available for the PAMTraM perspective.
	 *
	 * @param layout
	 *            The {@link IPageLayout} to which the actions are added.
	 */
	private void defineActions(IPageLayout layout) {

		layout.addNewWizardShortcut("pamtram.presentation.PamtramModelWizardID");
		layout.addNewWizardShortcut("de.mfreund.pamtram.newProjectWizard");

		layout.addShowViewShortcut("org.eclipse.ui.views.ProblemView");
		layout.addShowViewShortcut("org.eclipse.pde.runtime.LogView");
		layout.addShowViewShortcut("org.eclipse.ui.console.ConsoleView");
		layout.addShowViewShortcut("de.mfreund.pamtram.ui.views.PamtramReferencesView");
		layout.addShowViewShortcut("de.tud.et.ifa.agtele.ui.views.EMFModelHelpView");
		layout.addShowViewShortcut(IPageLayout.ID_PROP_SHEET);

	}

	/**
	 * Customize the layout for the PAMTraM perspective.
	 *
	 * @param layout
	 *            The {@link IPageLayout} that shall be customized..
	 */
	private void defineLayout(IPageLayout layout) {

		String editorArea = layout.getEditorArea();

		// Show the PackageExplorer to the left
		//
		IFolderLayout left = layout.createFolder("left", IPageLayout.LEFT, (float) 0.2, editorArea);
		left.addView("org.eclipse.jdt.ui.PackageExplorer");

		// Show the ProblemView and ConsoleView to the bottom
		//
		IFolderLayout bottom = layout.createFolder("bottom", IPageLayout.BOTTOM, (float) 0.7, editorArea);
		bottom.addView(IPageLayout.ID_PROP_SHEET);
		bottom.addView("org.eclipse.ui.views.ProblemView");
		bottom.addView("org.eclipse.pde.runtime.LogView");
		bottom.addView("org.eclipse.ui.console.ConsoleView");
		bottom.addView("de.mfreund.pamtram.ui.views.PamtramReferencesView");
		bottom.addView("de.tud.et.ifa.agtele.ui.views.EMFModelHelpView");
	}

}
