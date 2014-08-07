package de.mfreund.gentrans.transformation;

import de.congrace.exp4j.CustomFunction;
import de.congrace.exp4j.InvalidCustomFunctionException;

/**
 * Provides a max(a,b) Function for exp4j
 * @author Sascha Steffen
 * @version 1.0
 *
 */
public class MaxFunction extends CustomFunction {

	/**
	 * @throws InvalidCustomFunctionException
	 */
	public MaxFunction()
			throws InvalidCustomFunctionException {
		super("max", 2);
	}

	/* (non-Javadoc)
	 * @see de.congrace.exp4j.CustomFunction#applyFunction(double[])
	 */
	@Override
	public double applyFunction(double... args) {
		return java.lang.Math.max(args[0], args[1]);
	}

}
