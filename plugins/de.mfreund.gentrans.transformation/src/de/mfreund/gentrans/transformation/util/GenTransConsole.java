package de.mfreund.gentrans.transformation.util;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

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

	/**
	 * This keeps track of the list of {@link GenTransConsoleStreamHandler
	 * GenTransConsoleStreamHandlers} that are responsible for printing logged
	 * messages.
	 */
	private List<GenTransConsoleStreamHandler> handlers;

	/**
	 * The {@link Logger} of which the console shall print messages.
	 */
	private Logger logger;

	/**
	 * This creates an instance that will print message of any {@link Level}.
	 * 
	 * @see #GenTransConsole(Logger, Level)
	 * 
	 * @param logger
	 *            The logger of which the console shall print messages.
	 */
	public GenTransConsole(Logger logger) {
		this(logger, Level.ALL);
	}

	/**
	 * This creates an instance.
	 * 
	 * @param logger
	 *            The logger of which the console shall print messages.
	 * @param level
	 *            The minimum {@link Level} a logged messages must represent to
	 *            be printed to this instance. Use {@link Level#ALL} to ensure
	 *            logging of all messages and {@link Level#OFF} to prevent any
	 *            logging.
	 */
	@SuppressWarnings("resource")
	public GenTransConsole(Logger logger, Level level) {

		super(CONSOLE_NAME_PREFIX + " " + DateFormat.getDateTimeInstance().format(new Date()), null, true);

		this.logger = logger;
		this.handlers = new ArrayList<>();

		if (level.intValue() <= Level.FINE.intValue()) {

			// Initialize the logging of 'finest', 'finer' and 'fine' messages
			//
			IOConsoleOutputStream fineStream = newOutputStream();
			fineStream.setColor(new Color(Display.getCurrent(), new RGB(0, 0, 0)));
			GenTransConsoleStreamHandler fineHandler = new GenTransConsoleStreamHandler(fineStream);
			fineHandler.setFilter((LogRecord record) -> record.getLevel().intValue() <= Level.FINE.intValue());
			this.handlers.add(fineHandler);
		}

		if (level.intValue() <= Level.INFO.intValue()) {

			// Initialize the logging of 'config' and 'info' messages
			//
			IOConsoleOutputStream infoStream = newOutputStream();
			infoStream.setColor(new Color(Display.getCurrent(), new RGB(0, 0, 0)));
			GenTransConsoleStreamHandler infoHandler = new GenTransConsoleStreamHandler(infoStream);
			infoHandler.setFilter((LogRecord record) -> record.getLevel().intValue() > Level.FINE.intValue()
					&& record.getLevel().intValue() <= Level.INFO.intValue());
			this.handlers.add(infoHandler);

		}

		if (level.intValue() <= Level.WARNING.intValue()) {

			// Initialize the logging of 'warning' messages
			//
			IOConsoleOutputStream warningStream = newOutputStream();
			warningStream.setColor(new Color(Display.getCurrent(), new RGB(250, 100, 0)));
			GenTransConsoleStreamHandler warningHandler = new GenTransConsoleStreamHandler(warningStream);
			warningHandler.setFilter((LogRecord record) -> record.getLevel().equals(Level.WARNING));
			this.handlers.add(warningHandler);
		}

		if (level.intValue() <= Level.SEVERE.intValue()) {

			// Initialize the logging of 'severe' messages
			//
			IOConsoleOutputStream errorStream = newOutputStream();
			errorStream.setColor(new Color(Display.getCurrent(), new RGB(255, 0, 0)));
			GenTransConsoleStreamHandler errorHandler = new GenTransConsoleStreamHandler(errorStream);
			errorHandler.setFilter((LogRecord record) -> record.getLevel().equals(Level.SEVERE));
			this.handlers.add(errorHandler);
		}

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
