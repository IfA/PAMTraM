package de.mfreund.gentrans.transformation.CalculatorFunctions;

import de.congrace.exp4j.CustomFunction;
import de.congrace.exp4j.InvalidCustomFunctionException;

/**
 * Provides a min(a,b) Function for exp4j
 * 
 * @author Sascha Steffen
 * @version 1.0
 *
 */
public class MinFunction extends CustomFunction {

	/**
	 * Takes 2 args. Returns the smaller value (java.lang.Math.min).
	 *
	 * @throws InvalidCustomFunctionException
	 */
	public MinFunction() throws InvalidCustomFunctionException {
		super("min", 2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.congrace.exp4j.CustomFunction#applyFunction(double[])
	 */
	@Override
	public double applyFunction(final double... args) {
		return java.lang.Math.min(args[0], args[1]);
	}

}
