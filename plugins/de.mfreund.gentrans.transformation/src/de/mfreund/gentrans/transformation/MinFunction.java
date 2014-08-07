package de.mfreund.gentrans.transformation;

import de.congrace.exp4j.CustomFunction;
import de.congrace.exp4j.InvalidCustomFunctionException;

/**
 * Provides a min(a,b) Function for exp4j
 * @author Sascha Steffen
 * @version 1.0
 *
 */
public class MinFunction extends CustomFunction {


	/**
	 * @throws InvalidCustomFunctionException
	 */
	public MinFunction()
			throws InvalidCustomFunctionException {
		super("min",2);
	}

	/* (non-Javadoc)
	 * @see de.congrace.exp4j.CustomFunction#applyFunction(double[])
	 */
	@Override
	public double applyFunction(double... args) {
		return java.lang.Math.min(args[0], args[1]);
	}

}
