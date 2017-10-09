package de.mfreund.gentrans.transformation.logging;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * A custom {@link Formatter} for log messages that simply prints the logged message but no additional details like
 * time, level, etc.
 *
 * @author mfreund
 */
class GenTransLogFormatter extends Formatter {

	public static final String LINE_SEPARATOR = "\n";

	/**
	 * This keeps track of the single instance of this formatter.
	 */
	private static GenTransLogFormatter eInstance;

	/**
	 * This creates an instance.
	 */
	private GenTransLogFormatter() {

		super();
	}

	/**
	 * Returns the single {@link #eInstance} of this formatter.
	 *
	 * @return The {@link #eInstance}.
	 */
	public static Formatter getInstance() {

		if (GenTransLogFormatter.eInstance == null) {
			GenTransLogFormatter.eInstance = new GenTransLogFormatter();
		}
		return GenTransLogFormatter.eInstance;
	}

	@Override
	public String format(LogRecord record) {

		StringBuilder builder = new StringBuilder();
		builder.append(record.getMessage());
		builder.append(GenTransLogFormatter.LINE_SEPARATOR);

		// Do not print any stack trace to the console
		//
		//
		// // If a Throwable is passed, print the strack trace.
		// //
		// if (record.getThrown() != null) {
		// try {
		// StringWriter sw = new StringWriter();
		// PrintWriter pw = new PrintWriter(sw);
		// record.getThrown().printStackTrace(pw);
		// pw.close();
		// builder.append(sw.toString());
		// builder.append(LINE_SEPARATOR);
		// } catch (Exception ex) {
		// }
		// }

		return builder.toString();
	}
}