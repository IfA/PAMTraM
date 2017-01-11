package de.mfreund.gentrans.transformation.calculation;

import java.util.Map;
import java.util.logging.Logger;

import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.InvalidCustomFunctionException;
import pamtram.mapping.FixedValue;
import pamtram.mapping.GlobalAttribute;
import pamtram.structure.SourceSectionAttribute;
import pamtram.structure.TargetSectionAttribute;
import pamtram.structure.constraint.ValueConstraint;

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
	 * This creates an instance and initializes the {@link #round},
	 * {@link #max}, and {@link #min} functions.
	 * 
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages to the
	 *            user.
	 */
	public ExpressionCalculator(Logger logger) {

		this.logger = logger;

		// initialize the custom calculator functions
		try {
			round = new RoundFunction();
			max = new MaxFunction();
			min = new MinFunction();
		} catch (InvalidCustomFunctionException e) {
			e.printStackTrace();
			logger.severe("Internal Error: Failed to initialize ExpressionCalculator!");
		}
	}

	/**
	 * This calculates the value for a given expression, e.g. may be used in {@link ValueConstraint}s or in {@link TargetSectionAttribute}s.
	 * It represents only the general calculation rule.
	 * 
	 * @param expression The expression for which the value shall be calculated or <em>null</em> 
	 * @param vars Contains all {@link FixedValue}s and {@link GlobalAttribute}s as well as values of 
	 * {@link SourceSectionAttribute SourceSectionAttributes} which are interpretable as double values.
	 * @return The calculated expression value or <em>null</em> if no value could be calculated.
	 */
	public String calculateExpression(String expression, Map<String, Double> vars){

		try{
			// make calculation
			//
			return String.valueOf(new ExpressionBuilder(expression)
					.withCustomFunction(round)
					.withCustomFunction(max)
					.withCustomFunction(min)
					.withVariables(vars)
					.build()
					.calculate());

		} catch (final Exception e) {

			logger.warning("Message:\n" + e.getMessage() + "\n nothing calculated!");
			return expression;

		}
	}
}