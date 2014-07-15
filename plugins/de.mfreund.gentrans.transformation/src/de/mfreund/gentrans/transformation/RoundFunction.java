package de.mfreund.gentrans.transformation;

import de.congrace.exp4j.CustomFunction;
import de.congrace.exp4j.InvalidCustomFunctionException;

public class RoundFunction extends CustomFunction {

	public RoundFunction() throws InvalidCustomFunctionException {
		super("round");
	}

	@Override
	public double applyFunction(double... args) {
		return Math.round(args[0]);
	}

}
