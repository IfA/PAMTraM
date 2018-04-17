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
package de.mfreund.gentrans.transformation.resolving.wizards;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.LabelProvider;

import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.resolving.UserDecisionResolvingStrategy;
import pamtram.mapping.Mapping;

/**
 * A {@link LabelProvider} that is used by the {@link GenericSelectionDialog} display the various options to the user.
 * <p />
 * Note: This LabelProvider handles all of the different element types presented to the user as part of the various
 * methods to resolve ambiguities that are implemented by the {@link UserDecisionResolvingStrategy}.
 *
 * @author mfreund
 */
public class UserDecisionStrategyLabelProvider extends LabelProvider {

	@Override
	public String getText(Object element) {

		if (element instanceof MatchedSectionDescriptor) {
			return ((MatchedSectionDescriptor) element).getAssociatedSourceSection().getName();
		} else if (element instanceof Mapping) {
			return ((Mapping) element).getName();
		} else if (element instanceof EClass) {
			return ((EClass) element).getName();
		}

		return super.getText(element);
	}

}
