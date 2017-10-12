package de.mfreund.gentrans.transformation.logging;

import java.io.OutputStream;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

/**
 * A {@link StreamHandler} that uses the {@link GenTransLogFormatter} to print logged messages to an
 * {@link OutputStream}.
 *
 * @author mfreund
 */
public class GenTransStreamHandler extends StreamHandler {

	/**
	 * This creates an instance.
	 *
	 * @param stream
	 *            The {@link OutputStream} to which logged messages will be printed.
	 */
	public GenTransStreamHandler(OutputStream stream) {

		super(stream, GenTransLogFormatter.getInstance());
	}

	@Override
	public void publish(LogRecord record) {

		super.publish(record);

		// It seems that we need to call 'flush()' manually after a new
		// record is published. Otherwise, no messages seem to appear on the
		// console.
		//
		this.flush();
	}
}