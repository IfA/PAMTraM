/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package pamtram.converter;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import pamtram.commands.GenericConvertCommand.IConverter;
import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingPackage;

/**
 * An {@link IConverter} that is able to convert a normal {@link MappingHintGroup} to an
 * {@link ExportedMappingHintGroup}.
 *
 * @author mfreund
 */
public class HintGroupToExportedHintGroupConverter implements IConverter<MappingHintGroup, ExportedMappingHintGroup> {

	@Override
	public ExportedMappingHintGroup convert(MappingHintGroup source) {

		EPackage ePackage = source.eClass().getEPackage();
		ExportedMappingHintGroup target = (ExportedMappingHintGroup) ePackage.getEFactoryInstance()
				.create((EClass) ePackage.getEClassifier("ExportedMappingHintGroup"));

		if (source.getName() != null) {
			target.setName(source.getName());
		}

		if (source.getTargetSection() != null) {
			target.setTargetSection(source.getTargetSection());
		}

		if (source.getMappingHints() != null) {
			target.eSet(target.eClass().getEStructuralFeature(MappingPackage.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS),
					EcoreUtil.copyAll(source.getMappingHints()));
		}

		return target;
	}

}
