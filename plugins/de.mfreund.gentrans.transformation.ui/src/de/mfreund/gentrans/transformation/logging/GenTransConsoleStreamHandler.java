package de.mfreund.gentrans.transformation.logging;

import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

import org.eclipse.ui.console.IOConsoleOutputStream;

/**
 * A {@link StreamHandler} that uses the {@link GenTransLogFormatter} to
 * print logged messages to an {@link IOConsoleOutputStream}.
 * 
 * @author mfreund
 */
class GenTransConsoleStreamHandler extends StreamHandler {

	/**
	 * This creates an instance.
	 * 
	 * @param stream
	 *            The {@link IOConsoleOutputStream} to which logged messages
	 *            will be printed.
	 */
	public GenTransConsoleStreamHandler(IOConsoleOutputStream stream) {
		super(stream, GenTransLogFormatter.getInstance());
	}

	@Override
	public void publish(LogRecord record) {
		super.publish(record);

		// It seems that we need to call 'flush()' manually after a new
		// record is published. Otherwise, no messages seem to appear on the
		// console.
		//
		flush();
	}
}