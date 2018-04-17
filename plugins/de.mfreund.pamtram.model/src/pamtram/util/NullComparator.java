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
package pamtram.util;

/**
 * This class allows to compare two objects that may be '<em>null</em>'.
 * 
 * @author mfreund
 */
public interface NullComparator {
	
	/**
	 * This compares two objects that may be '<em>null</em>'.
	 * 
	 * @param object1 The first object to be compared.
	 * @param object2 The second object to be compared.
	 * @return '<em><b>true</b></em>' if both objects are equal (also if both are '<em>null</em>'), '<em><b>false</b></em>' otherwise
	 */
	public static boolean compare(Object object1, Object object2) {

		if(object1 == null && object2 == null) {
			return true;
		} else if(object1 == null || object2 == null) {
			return false;
		} else {
			return object1.equals(object2);
		}
	}
}
