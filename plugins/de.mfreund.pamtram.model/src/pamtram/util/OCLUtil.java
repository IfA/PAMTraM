/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 *
 */
package pamtram.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Query;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.OCLHelper;

/**
 * A utility class to simplify the evaluation of {@link OCL} queries.
 *
 * @author mfreund
 */
public class OCLUtil {

	/**
	 * The singleton instance of {@link OCL} that is used to create and evaluate queries.
	 */
	private static OCL oclInstance;

	private OCLUtil() {

	}

	/**
	 * Return the single {@link #oclInstance}. If necessary, create it first.
	 *
	 * @return The single {@link #oclInstance}.
	 */
	private static OCL getOclInstance() {

		if (OCLUtil.oclInstance == null) {
			OCLUtil.oclInstance = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);
		}
		return OCLUtil.oclInstance;
	}

	/**
	 * This evaluates the {@link OCLExpression} represented by the given <em>expression</em> on the given
	 * <em>contextElement</em>.
	 *
	 * @param expression
	 *            A String representing the {@link OCLExpression} to be evaluated.
	 * @param contextElement
	 *            The {@link EObject} for which the <em>expression</em> shall be evaluated.
	 * @return The result of the evaluation.
	 * @throws ParserException
	 *             If the given <em>expression</em> was no valid {@link OCLExpression}.
	 */
	public static synchronized Object evaluteQuery(String expression, EObject contextElement) throws ParserException {

		OCLHelper<EClassifier, ?, ?, Constraint> helper = OCLUtil.getOclInstance().createOCLHelper();
		helper.setContext(contextElement.eClass());
		OCLExpression<EClassifier> oclExpression = helper.createQuery(expression);
		Query query = OCLUtil.getOclInstance().createQuery(oclExpression);
		return query.evaluate(contextElement);
	}

	/**
	 * This validates the {@link OCLExpression} represented by the given <em>expression</em>. If the expression is not
	 * valid, this will throw a {@link ParserException} that contains more information - otherwise, the method will just
	 * return normally.
	 *
	 * @param expression
	 *            A String representing the {@link OCLExpression} to be validated.
	 * @param contextClass
	 *            The {@link EClass} representing the context of the <em>expression</em>.
	 * @throws ParserException
	 *             If the given <em>expression</em> was no valid {@link OCLExpression}.
	 */
	public static synchronized void validateQuery(String expression, EClass contextClass) throws ParserException {

		OCLHelper<EClassifier, ?, ?, Constraint> helper = OCLUtil.getOclInstance().createOCLHelper();
		helper.setContext(contextClass);
		helper.createQuery(expression);
	}

}
