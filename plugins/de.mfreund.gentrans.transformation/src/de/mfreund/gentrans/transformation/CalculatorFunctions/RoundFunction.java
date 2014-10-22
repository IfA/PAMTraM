package de.mfreund.gentrans.transformation.CalculatorFunctions;

import de.congrace.exp4j.CustomFunction;
import de.congrace.exp4j.InvalidCustomFunctionException;

/**
 * "round" function extending Functionality of the ClaculatorMapping
 * 
 * @author Sascha Steffen
 * @version 1.0
 *
 */
public class RoundFunction extends CustomFunction {

	/**
	 * Constructor (java.lang.Math.round)
	 * 
	 * @throws InvalidCustomFunctionException
	 */
	public RoundFunction() throws InvalidCustomFunctionException {
		super("round");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.congrace.exp4j.CustomFunction#applyFunction(double[])
	 */
	@Override
	public double applyFunction(final double... args) {
		return Math.round(args[0]);
	}

}
