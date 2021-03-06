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

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

import pamtram.ConditionModel;
import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.condition.ComplexCondition;

/**
 * A content provider for a viewer that displays the {@link ConditionModel
 * ConditionModels} and the contained {@link ComplexCondition conditions}.
 *
 * @author mfreund
 */
public class ConditionContentProvider extends AdapterFactoryContentProvider implements IFeatureValidator {

	/**
	 * This creates an instance.
	 *
	 * @param adapterFactory
	 */
	public ConditionContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object[] getElements(Object object) {

		if (object instanceof PAMTraM) {
			return Stream
					.concat(((PAMTraM) object).getConditionModels().stream(),
							((PAMTraM) object).getSharedConditionModels().stream())
					.collect(Collectors.toList()).toArray();
		}
		return super.getElements(object);
	}

	@Override
	public boolean isValidFeature(EStructuralFeature feature) {

		if (feature.equals(PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTION_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__MAPPING_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__TARGET_SECTION_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_SOURCE_SECTION_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_TARGET_SECTION_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_MAPPING_MODELS)) {
			return false;
		}

		return true;
	}
}
