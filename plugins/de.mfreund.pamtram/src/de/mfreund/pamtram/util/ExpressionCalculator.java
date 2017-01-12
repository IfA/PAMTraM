/**
 *
 */
package de.mfreund.pamtram.util;

import java.util.Map;
import java.util.logging.Logger;

import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.InvalidCustomFunctionException;

/**
 * This class can be used to handle and calculate general expressions.
 *
 */
public class ExpressionCalculator {

	/**
	 * {@link RoundFunction} instance, maybe needed when inside of an expression defined
	 */
	private RoundFunction round;

	/**
	 * {@link MaxFunction} instance, maybe needed when inside of an expression defined
	 */
	private MaxFunction max;

	/**
	 * {@link MinFunction} instance, maybe needed when inside of an expression defined
	 */
	private MinFunction min;

	/**
	 * The {@link Logger} to be used to print messages.
	 */
	private Logger logger;

	/**
	 * This creates an instance without a logger and initializes the {@link #round}, {@link #max}, and {@link #min}
	 * functions.
	 *
	 * @see #ExpressionCalculator(Logger)
	 *
	 */
	public ExpressionCalculator() {

		// initialize the custom calculator functions
		try {
			this.round = new RoundFunction();
			this.max = new MaxFunction();
			this.min = new MinFunction();
		} catch (InvalidCustomFunctionException e) {
			e.printStackTrace();
			this.logger.severe("Internal Error: Failed to initialize ExpressionCalculator!");
		}
	}

	/**
	 * This creates an instance with a logger and initializes the {@link #round}, {@link #max}, and {@link #min}
	 * functions.
	 *
	 * @see #ExpressionCalculator()
	 *
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages to the user.
	 */
	public ExpressionCalculator(Logger logger) {

		this.logger = logger;

		// initialize the custom calculator functions
		try {
			this.round = new RoundFunction();
			this.max = new MaxFunction();
			this.min = new MinFunction();
		} catch (InvalidCustomFunctionException e) {
			e.printStackTrace();
			logger.severe("Internal Error: Failed to initialize ExpressionCalculator!");
		}
	}

	/**
	 * This calculates the value for a given expression. It represents only the general calculation rule.
	 *
	 * @param expression
	 *            The expression for which the value shall be calculated or <em>null</em>
	 * @param vars
	 *            A map of variables (names and values) that can be used to calculate the expression.
	 * @return The calculated expression value or <em>null</em> if no value could be calculated.
	 */
	public String calculateExpression(String expression, Map<String, Double> vars) {

		try {
			// make calculation
			//
			return String.valueOf(new ExpressionBuilder(expression).withCustomFunction(this.round)
					.withCustomFunction(this.max).withCustomFunction(this.min).withVariables(vars).build().calculate());

		} catch (final Exception e) {

			if (this.logger != null) {
				this.logger.warning("Message:\n" + e.getMessage() + "\n nothing calculated!");
			} else {
				System.out.println("Message:\n" + e.getMessage() + "\n nothing calculated!");
			}
			return expression;

		}
	}
}