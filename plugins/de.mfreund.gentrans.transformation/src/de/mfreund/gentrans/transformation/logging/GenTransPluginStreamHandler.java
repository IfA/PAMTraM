package de.mfreund.gentrans.transformation.logging;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import de.mfreund.gentrans.transformation.Activator;

/**
 * A {@link Handler} that prints log messages that are based on a thrown {@link Exception} to the internal
 * {@link Activator#log(Exception) logging facilities} of the {@link Activator gentrans.transformation} plugin.
 *
 * @author mfreund
 */
public class GenTransPluginStreamHandler extends Handler {

	/**
	 * This creates an instance.
	 */
	public GenTransPluginStreamHandler() {

		super();

		// Log only severe messages that result from a thrown exception
		//
		this.setLevel(Level.SEVERE);
		this.setFilter((LogRecord record) -> record.getThrown() instanceof Exception
				&& record.getLevel().equals(Level.SEVERE));
	}

	@Override
	public void publish(LogRecord record) {

		// Log the message via the internal logging facilities of the 'gentrans.transformation' plugin
		//
		if (record.getThrown() instanceof Exception) {
			Activator.log((Exception) record.getThrown());
		}
	}

	@Override
	public void close() {

		// Nothing to be done
		//

	}

	@Override
	public void flush() {

		// Nothing to be done
		//

	}
}