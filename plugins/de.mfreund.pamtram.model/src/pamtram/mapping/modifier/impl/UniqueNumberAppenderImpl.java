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
 */
package pamtram.mapping.modifier.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;

import pamtram.PAMTraM;
import pamtram.impl.NamedElementImpl;
import pamtram.mapping.modifier.ModifierPackage;
import pamtram.mapping.modifier.UniqueNumberAppender;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Unique
 * Number Appender</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public class UniqueNumberAppenderImpl extends NamedElementImpl implements UniqueNumberAppender {

	/**
	 * A map that stores the hash codes of PAMTraM {@link Resource Resource} as
	 * key and the current associated 'unique number' as value.
	 * <p />
	 * By using this approach for management of unique numbers, we can assure 1.
	 * unique numbers per {@link PAMTraM} instance that are 2. consistent
	 * between multiple runs of the same transformation (because the PAMTraM
	 * model will usually be reloaded).
	 */
	private static Map<Integer, Long> uniqueNumberByAppenderMap = new HashMap<>();

	/**
	 * Get a new unique number for the this {@link UniqueNumberAppender}. The
	 * returned number will be 1. unique per {@link PAMTraM} instance and 2.
	 * consistent between multiple runs of the same transformation if the
	 * PAMTraM model is reloaded in between.
	 *
	 * @return A unique number.
	 */
	private long getUniqueNumber() {

		// The hash code of the resource that we will use to retrieve a unique
		// number from the 'uniqueNumberByAppenderMap'
		int hashCode = this.eResource().hashCode();

		Long uniqueNumber = UniqueNumberAppenderImpl.uniqueNumberByAppenderMap.containsKey(hashCode)
				? UniqueNumberAppenderImpl.uniqueNumberByAppenderMap.get(hashCode) + 1 : 1;

		UniqueNumberAppenderImpl.uniqueNumberByAppenderMap.put(hashCode, uniqueNumber);

		return uniqueNumber;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected UniqueNumberAppenderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifierPackage.Literals.UNIQUE_NUMBER_APPENDER;
	}

	@Override
	public String modifyValue(String value) {

		return value + this.getUniqueNumber();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ModifierPackage.UNIQUE_NUMBER_APPENDER___MODIFY_VALUE__STRING:
				return modifyValue((String)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} // UniqueNumberAppenderImpl
