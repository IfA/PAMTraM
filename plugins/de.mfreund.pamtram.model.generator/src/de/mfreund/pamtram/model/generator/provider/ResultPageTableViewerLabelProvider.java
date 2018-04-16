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
package de.mfreund.pamtram.model.generator.provider;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import pamtram.structure.constraint.SingleReferenceValueConstraint;
import pamtram.structure.generic.Attribute;
import pamtram.structure.source.ActualSourceSectionAttribute;
import pamtram.structure.target.TargetSectionAttribute;

/**
 * A simple {@link ITableLabelProvider} that displays names and values of {@link Attribute Attributes}.
 *
 * @author mfreund
 */
public class ResultPageTableViewerLabelProvider implements ITableLabelProvider {

	@Override
	public void addListener(ILabelProviderListener listener) {

		// nothing to be done
		//
	}

	@Override
	public void dispose() {

		// nothing to be done
		//
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {

		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {

		// nothing to be done
		//
	}

	@Override
	public Image getColumnImage(Object element, int columnIndex) {

		// do not use any images
		//
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {

		if (!(element instanceof Attribute)) {
			return "";
		}

		Attribute<?, ?, ?, ?> att = (Attribute<?, ?, ?, ?>) element;

		switch (columnIndex) {
			case 0:
				return att.getName();
			case 1:
				return this.getValue(att);
			default:
				return "";
		}
	}

	/**
	 * Returns the <em>value</em> to display for the given {@link Attribute} based on its concrete type.
	 *
	 * @param att
	 *            The {@link Attribute}.
	 * @return The value to display.
	 */
	protected String getValue(Attribute<?, ?, ?, ?> att) {

		if (att instanceof ActualSourceSectionAttribute) {
			if (!((ActualSourceSectionAttribute) att).getValueConstraints().isEmpty()
					&& ((ActualSourceSectionAttribute) att).getValueConstraints()
					.get(0) instanceof SingleReferenceValueConstraint) {
				return ((SingleReferenceValueConstraint) ((ActualSourceSectionAttribute) att)
						.getValueConstraints().get(0)).getExpression();
			} else {
				return "";
			}
		} else if (att instanceof TargetSectionAttribute) {
			return ((TargetSectionAttribute) att).getValue();
		} else {
			return "";
		}
	}

}
