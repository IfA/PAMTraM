/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package pamtram.util;

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
