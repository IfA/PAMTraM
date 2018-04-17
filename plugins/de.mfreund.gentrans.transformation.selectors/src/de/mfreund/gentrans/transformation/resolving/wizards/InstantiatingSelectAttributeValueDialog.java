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
package de.mfreund.gentrans.transformation.resolving.wizards;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.structure.target.ActualTargetSectionAttribute;
import pamtram.structure.target.TargetSectionAttribute;

/**
 * A {@link ValueSpecificationDialog} that allows the user to enter a single value for an attribute.
 *
 * @author mfreund
 */
public class InstantiatingSelectAttributeValueDialog extends ValueSpecificationDialog {

	/**
	 * The target {@link EObject element} for that the option shall be chosen.
	 */
	protected EObject element;

	/**
	 * The {@link TargetSectionAttribute} for that a value shall be entered.
	 */
	protected TargetSectionAttribute attribute;

	/**
	 * The {@link InstantiableMappingHintGroup mapping hint group} based on which the attribute was created.
	 */
	protected InstantiableMappingHintGroup mappingHintGroup;

	/**
	 * Create the dialog.
	 * @param attribute
	 *            The {@link TargetSectionAttribute} for that a value shall be entered.
	 * @param element
	 *            The target {@link EObject element} for that the option shall be chosen.
	 * @param mappingHintGroup
	 *            The {@link InstantiableMappingHintGroup mapping hint group} based on which the attribute was created.
	 * @param enhanceMappingModelListener
	 *            An optional {@link SelectionListener2} that will be called when the <em>EnhanceMappingModelButton</em>
	 *            is clicked. If no listener is given, the button will be grayed out.
	 */
	public InstantiatingSelectAttributeValueDialog(TargetSectionAttribute attribute, EObject element, InstantiableMappingHintGroup mappingHintGroup,
			Optional<SelectionListener2> enhanceMappingModelListener) {

		super("Unspecified attribute value found for an element of the target model!",
				attribute instanceof ActualTargetSectionAttribute
						? ((ActualTargetSectionAttribute) attribute).getAttribute().getEAttributeType()
						: EcorePackage.Literals.ESTRING,
				enhanceMappingModelListener);

		this.attribute = attribute;
		this.element = element;
		this.mappingHintGroup = mappingHintGroup;
	}

	@Override
	protected void createInnerContents(Composite container) {

		Group group = new Group(container, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).minSize(200, 200).applyTo(group);
		group.setText("Source of the Ambiguity:");
		GridLayoutFactory.fillDefaults().margins(5, 5).applyTo(group);

		// A label providing information about the element
		//
		Label label = new Label(group, SWT.WRAP);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(label);
		label.setText("The ambiguity occurred while setting the value of the TargetSectionAttribute '"
				+ this.attribute.getOwningClass().getName() + "." + this.attribute.getName()
				+ "' for the following element of the target model:\n\n" + EObjectWrapper.asString(this.element));

		// A link that allows jumping to the pamtram model and selecting the attribute
		//
		this.createLinkToPamtramModel(group, "-> Show TargetSectionAttribute in PAMTraM Model...", this.attribute);

		// A link that allows jumping to the pamtram model and selecting the mappingHintGroup
		//
		this.createLinkToPamtramModel(group, this.mappingHintGroup);

		super.createInnerContents(container);

	}

	/**
	 * Get the value specified by the user after the dialog has finished.
	 *
	 * @return The specified value as String.
	 */
	@Override
	public String getValue() {

		return this.retValue;
	}

}
