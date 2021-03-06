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
package pamtram.contentprovider;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * This interface can be implemented to indicate that an object is able to <em>validate</em> an 
 * {@link EStructuralFeature}. The concrete meaning of the term <em>validate</em> is dependent
 * on the concrete use case. 
 * 
 * @author mfreund
 */
public interface IFeatureValidator {

	/**
	 * Whether the given <em>feature</em> is supported by/valid for this object. The default implementation
	 * simply returns <em>true</em> for any feature.
	 * 
	 * @param feature The {@link EStructuralFeature} to check.
	 * @return '<em><b>true</b></em>' if the feature is supported by this class, '<em><b>false</b></em>' otherwise.
	 */
	public default boolean isValidFeature(EStructuralFeature feature) {
		return true;
	}
}
