package de.mfreund.gentrans.transformation.util;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IOConsoleOutputStream;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.progress.UIJob;

/**
 * A {@link MessageConsole} that provides various output streams.
 * 
 * @author mfreund
 */
public class GenTransConsole extends MessageConsole {

	private static final String CONSOLE_NAME_PREFIX = "GenTrans";
	private List<StreamHandler> handlers;
	private Logger logger;

	/**
	 * This creates an instance.
	 * 
	 * @param logger
	 *            The logger of which the console shall print messages.
	 */
	@SuppressWarnings("resource")
	public GenTransConsole(Logger logger) {

		super(CONSOLE_NAME_PREFIX + " " + DateFormat.getDateTimeInstance().format(new Date()), null, true);

		this.logger = logger;

		IOConsoleOutputStream fineStream = newOutputStream();
		IOConsoleOutputStream infoStream = newOutputStream();
		IOConsoleOutputStream warningStream = newOutputStream();
		IOConsoleOutputStream errorStream = newOutputStream();

		fineStream.setColor(new Color(Display.getCurrent(), new RGB(0, 0, 0)));
		infoStream.setColor(new Color(Display.getCurrent(), new RGB(0, 0, 0)));
		warningStream.setColor(new Color(Display.getCurrent(), new RGB(250, 100, 0)));
		errorStream.setColor(new Color(Display.getCurrent(), new RGB(255, 0, 0)));

		StreamHandler fineHandler = new StreamHandler(fineStream, new SimpleFormatter());
		fineHandler.setFilter((LogRecord record) -> record.getLevel().equals(Level.FINE));

		StreamHandler infoHandler = new StreamHandler(infoStream, new SimpleFormatter());
		infoHandler.setFilter((LogRecord record) -> record.getLevel().equals(Level.INFO));

		StreamHandler warningHandler = new StreamHandler(warningStream, new SimpleFormatter());
		warningHandler.setFilter((LogRecord record) -> record.getLevel().equals(Level.WARNING));

		StreamHandler errorHandler = new StreamHandler(errorStream, new SimpleFormatter());
		errorHandler.setFilter((LogRecord record) -> record.getLevel().equals(Level.SEVERE));

		this.handlers = Stream.of(infoHandler, warningHandler, errorHandler).collect(Collectors.toList());
		this.handlers.stream().forEach(logger::addHandler);

		final ConsolePlugin plugin = ConsolePlugin.getDefault();
		final IConsoleManager conMan = plugin.getConsoleManager();
		conMan.addConsoles(new IConsole[] { this });

		showConsole();
	}

	/**
	 * Brings the console view to the foreground. If the view is closed, it will
	 * be opened.
	 */
	private void showConsole() {
		// as the transformation runs in a non-UI thread, we have to use
		// a UIJob to find the console view
		final UIJob job = new UIJob("Show Console View") {
			@Override
			public IStatus runInUIThread(final IProgressMonitor monitor) {
				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
					.showView("org.eclipse.ui.console.ConsoleView");
				} catch (final PartInitException e) {
					e.printStackTrace();
					return Status.CANCEL_STATUS;
				}
				return Status.OK_STATUS;
			}
		};
		job.schedule();
	}

	@Override
	public void dispose() {

		if (logger != null) {
			this.handlers.stream().forEach(logger::removeHandler);
		}

		super.dispose();
	}
}
