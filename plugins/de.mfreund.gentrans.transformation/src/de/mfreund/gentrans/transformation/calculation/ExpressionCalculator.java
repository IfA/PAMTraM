package de.mfreund.gentrans.transformation.calculation;

import java.util.Map;

import org.eclipse.ui.console.MessageConsoleStream;

import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.InvalidCustomFunctionException;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;
import de.mfreund.gentrans.transformation.calculation.MaxFunction;
import de.mfreund.gentrans.transformation.calculation.MinFunction;
import de.mfreund.gentrans.transformation.calculation.RoundFunction;
import pamtram.mapping.GlobalAttribute;
import pamtram.metamodel.AttributeValueConstraint;
import pamtram.metamodel.TargetSectionAttribute;

/**
 * This class can be used to handle and calculate general expressions.
 * 
 * @author gkoltun
 */
public class ExpressionCalculator {
	
	/**
	 * RoundFunction instance, maybe needed when inside of an expression defined
	 */
	private RoundFunction round;
	
	/**
	 * MaxFunction instance, maybe needed when inside of an expression defined
	 */
	private MaxFunction max;
	
	/**
	 * MinFunction instance, maybe needed when inside of an expression defined
	 */
	private MinFunction min;
	/**
	 * The console stream to be used to print messages.
	 */
	private MessageConsoleStream consoleStream;
	
	public ExpressionCalculator() {
		
		// initialize the custom calculator functions
		try {
			round = new RoundFunction();
			max = new MaxFunction();
			min = new MinFunction();
		} catch (InvalidCustomFunctionException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This calculates the value for a given expression, e.g. may be used in {@link AttributeValueConstraint}s or in {@link TargetSectionAttribute}s.
	 * It represents only the general calculation rule.
	 * @param expression for which the value have to be calculated or <em>null</em> 
	 * @param vars contains all {@link GlobalValue}s or {@link GlobalAttribute}s which are interpretable as double values.
	 * @return The calculated expression value or <em>null</em> if no value could be calculated.
	 */
	public String calculateExpression(String expression, Map<String, Double> vars){
	
		String expResult = "";
		// make calculation
		try{
			expResult = String.valueOf(new ExpressionBuilder(expression)
				.withCustomFunction(round)
				.withCustomFunction(max)
				.withCustomFunction(min)
				.withVariables(vars).build()
				.calculate());
		} catch (final Exception e) {
		// TODO need we this??
			expResult = null;
		// TODO this will lead to a lot of error output if it fails
		consoleStream.println("Message:\n" + e.getMessage());
		}
		
		return expResult;
	}
}