package pamtram.util;

import de.congrace.exp4j.CustomFunction;
import de.congrace.exp4j.InvalidCustomFunctionException;

/**
 * Provides a max(a,b) Function for exp4j
 *
 * @author Sascha Steffen
 * @version 1.0
 *
 */
public class MaxFunction extends CustomFunction {

	/**
	 * Takes 2 args. Returns the greater value (java.lang.Math.max).
	 *
	 * @throws InvalidCustomFunctionException
	 */
	public MaxFunction() throws InvalidCustomFunctionException {
		super("max", 2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.congrace.exp4j.CustomFunction#applyFunction(double[])
	 */
	@Override
	public double applyFunction(final double... args) {
		return java.lang.Math.max(args[0], args[1]);
	}

}
