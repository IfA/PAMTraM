package de.mfreund.gentrans.transformation;

import de.congrace.exp4j.CustomFunction;
import de.congrace.exp4j.InvalidCustomFunctionException;

/**
 * "round" function extending Functionality of the ClaculatorMapping
 * @author Sascha Steffen
 * @version 0.8
 *
 */
class RoundFunction extends CustomFunction {

	/**
	 * Constructor
	 * @throws InvalidCustomFunctionException
	 */
	public RoundFunction() throws InvalidCustomFunctionException {
		super("round");
	}

	/* (non-Javadoc)
	 * @see de.congrace.exp4j.CustomFunction#applyFunction(double[])
	 */
	@Override
	public double applyFunction(double... args) {
		return Math.round(args[0]);
	}

}
