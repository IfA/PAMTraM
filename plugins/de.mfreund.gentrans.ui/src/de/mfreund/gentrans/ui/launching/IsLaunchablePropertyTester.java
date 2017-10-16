package de.mfreund.gentrans.ui.launching;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;

import de.tud.et.ifa.agtele.ui.util.UIHelper;
import pamtram.provider.PamtramEditPlugin;

/**
 * A {@link PropertyTester} that can be used to test if the 'Run as -> Gentrans'
 * menu item should be currently active.
 *
 * @author mfreund
 */
public class IsLaunchablePropertyTester extends PropertyTester {

	/**
	 * The namespace for the properties provided by this tester.
	 */
	public static final String PROPERTY_NAMESPACE = "de.mfreund.gentrans.ui.launching";

	/**
	 * The id for the 'isLaunchable' property.
	 */
	public static final String PROPERTY_IS_LAUNCHABLE = "isLaunchable";

	/**
	 */
	public IsLaunchablePropertyTester() {
	}

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {

		if (IsLaunchablePropertyTester.PROPERTY_IS_LAUNCHABLE.equals(property)) {
			return this.testIsLaunchableSelection() || this.testIsLaunchableEditor();
		}

		return false;
	}

	/**
	 * Test if the current selection is suitable to be launched as a GenTrans
	 * transformation.
	 *
	 * @return '<em>True</em>' if the selection is either a suitable pamtram
	 *         project, a suitable pamtram file, or a suitable source file;
	 *         '<em>false</em>' otherwise.
	 */
	private boolean testIsLaunchableSelection() {

		if (!(UIHelper.getCurrentSelection() instanceof StructuredSelection)
				|| ((StructuredSelection) UIHelper.getCurrentSelection()).size() > 1) {
			return false;
		}

		Object selection = UIHelper.getFirstSelection();

		if (selection instanceof IProject) {

			return IsLaunchablePropertyTester.isLaunchablePamtramProject((IProject) selection);

		} else if (selection instanceof IFile) {

			return IsLaunchablePropertyTester.isLaunchablePamtramFile((IFile) selection)
					|| IsLaunchablePropertyTester.isLaunchableSourceFile((IFile) selection);
		}

		return false;
	}

	/**
	 * Test if the current active editor (respectively the edited file) is
	 * suitable to be launched as a GenTrans transformation.
	 *
	 * @return '<em>True</em>' if the edited file is a suitable pamtram file or
	 *         a suitable source file; '<em>false</em>' otherwise.
	 */
	private boolean testIsLaunchableEditor() {

		if (UIHelper.getCurrentEditor() == null || !UIHelper.getCurrentEditor().equals(UIHelper.getCurrentPart())) {
			// Return false if the current editor is not 'active', i.e. the
			// current selection is not made in this editor
			//
			return false;
		}

		IEditorInput editorInput = UIHelper.getCurrentEditorInput();

		if (editorInput instanceof IFileEditorInput) {

			IFile file = ((IFileEditorInput) editorInput).getFile();

			return IsLaunchablePropertyTester.isLaunchablePamtramFile(file)
					|| IsLaunchablePropertyTester.isLaunchableSourceFile(file);
		}

		return false;

	}

	/**
	 * The if the given {@link IFile} is an xml/xmi file located in the source
	 * folder of a pamtram project.
	 *
	 * @param file
	 * @return If the given {@link IFile} is an xml/xmi file located in the
	 *         source folder of a pamtram project.
	 */
	public static boolean isLaunchableSourceFile(IFile file) {

		// The file is launchable if it is an xml/xmi
		// file and if it is located in a launchable pamtram project
		//
		return (file.getName().endsWith(".xmi") || file.getName().endsWith(".xml"))
				&& file.getParent().getName().equals(PamtramEditPlugin.INSTANCE.getString("SOURCE_FOLDER_NAME"))
				&& IsLaunchablePropertyTester.isLaunchablePamtramProject(file.getProject());
	}

	/**
	 * The if the given {@link IFile} is a pamtram file.
	 *
	 * @param file
	 * @return If the given {@link IFile} is a pamtram file.
	 */
	public static boolean isLaunchablePamtramFile(IFile file) {

		// The file is launchable if it is a 'pamtram'
		// file and if it is located in a launchable pamtram project
		//
		return file.getName().endsWith(PamtramEditPlugin.INSTANCE.getString("PAMTRAM_MODEL_FILE_ENDING"))
				&& file.getParent().getName().equals(PamtramEditPlugin.INSTANCE.getString("PAMTRAM_FOLDER_NAME"))
				&& IsLaunchablePropertyTester.isLaunchablePamtramProject(file.getProject());
	}

	/**
	 * The if the given {@link IProject} is a pamtram project.
	 *
	 * @param project
	 * @return If the given {@link IProject} is a pamtram project.
	 */
	public static boolean isLaunchablePamtramProject(IProject project) {
		try {
			// The project is launchable if it is equipped with the pamtram
			// nature
			//
			return project.hasNature("de.mfreund.pamtram.pamtramNature");
		} catch (CoreException e) {
			e.printStackTrace();
			return false;
		}
	}

}
