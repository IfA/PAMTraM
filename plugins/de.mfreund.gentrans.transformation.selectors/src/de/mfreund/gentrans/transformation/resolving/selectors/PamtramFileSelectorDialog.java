package de.mfreund.gentrans.transformation.resolving.selectors;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Sascha Steffen
 * @version 1.0
 *
 *
 *          Runs two dialogs for setting a target XMI-file and a PamTraM file
 */
public class PamtramFileSelectorDialog {
	/**
	 * @return PamTraM model file
	 */
	public static String getPamtramFile() {
		return pamtramFile;
	}

	/**
	 * @return selected file path for target model (to be generated) as String
	 */
	public static String getTargetFile() {
		return targetFile;
	}

	/**
	 * @param startPath
	 * @return selected file path for PamTraM model as String
	 */
	public static String run(final String startPath) {
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				final Display display = Display.getDefault();
				final Shell shell = new Shell(display);
				FileDialog d = new FileDialog(shell, SWT.APPLICATION_MODAL
						| SWT.OPEN);
				d.setText("Select a PAMTraM Model to transform this XML model");
				d.setFilterPath(startPath);
				d.setFilterExtensions(new String[] { "*.pamtram" });
				pamtramFile = d.open();

				d = new FileDialog(shell, SWT.APPLICATION_MODAL | SWT.SAVE);
				d.setText("Where should the target Model be saved?");
				d.setFilterPath(startPath);
				d.setFilterExtensions(new String[] { "*.xmi" });
				d.setOverwrite(true);

				targetFile = d.open();
				System.out.println(targetFile);

			};
		});
		return pamtramFile;
	}

	private static String pamtramFile = "";
	private static String targetFile = "";;

}
