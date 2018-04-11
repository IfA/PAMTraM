/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package pamtram.converter;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import pamtram.commands.GenericConvertCommand.IConverter;
import pamtram.structure.InstanceSelectorExternalSourceElement;
import pamtram.structure.InstanceSelectorSourceElement;
import pamtram.structure.StructurePackage;

/**
 * An {@link IConverter} that is able to convert a normal {@link InstanceSelectorSourceElement} to an
 * {@link InstanceSelectorExternalSourceElement}.
 *
 * @author mfreund
 */
public class InternalToExternalInstanceSelectorSourceElementConverter
		implements IConverter<InstanceSelectorSourceElement, InstanceSelectorExternalSourceElement> {

	@Override
	public InstanceSelectorExternalSourceElement convert(InstanceSelectorSourceElement source) {

		EPackage ePackage = source.eClass().getEPackage();
		InstanceSelectorExternalSourceElement target = (InstanceSelectorExternalSourceElement) ePackage
				.getEFactoryInstance()
				.create((EClass) ePackage.getEClassifier("InstanceSelectorExternalSourceElement"));

		if (source.getName() != null) {
			target.setName(source.getName());
		}

		if (source.getSource() != null) {
			target.setSource(source.getSource());
		}

		if (source.getModifiers() != null) {
			target.eSet(
					target.eClass().getEStructuralFeature(
							StructurePackage.INSTANCE_SELECTOR_EXTERNAL_SOURCE_ELEMENT__MODIFIERS),
					source.getModifiers());
		}

		return target;
	}
}
