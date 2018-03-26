/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 *
 */
package de.mfreund.gentrans.transformation.resolving.wizards;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import pamtram.mapping.MappingHintGroupType;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionCrossReference;

/**
 *
 * @author mfreund
 */
public class LinkingSelectTargetSectionAndInstanceDialog extends ClassAndInstanceSelectorDialog<TargetSectionClass> {

	/**
	 * The {@link TargetSectionCrossReference} whose target shall be set.
	 */
	private TargetSectionCrossReference reference;

	/**
	 * The {@link MappingHintGroupType} based on which the elements to link were created.
	 */
	private MappingHintGroupType hintGroup;

	/**
	 * This creates an instance.
	 * @param options
	 *            The options that the user can choose from.
	 * @param enhanceMappingModelListener
	 *            An optional {@link SelectionListener2} that will be called when the <em>EnhanceMappingModelButton</em>
	 *            is clicked. If no listener is given, the button will be grayed out.
	 * @param reference
	 *            The {@link TargetSectionCrossReference} whose target shall be set.
	 * @param hintGroup
	 *            The {@link MappingHintGroupType} based on which the elements to link were created.
	 */
	public LinkingSelectTargetSectionAndInstanceDialog(Map<TargetSectionClass, List<EObjectWrapper>> options,
			Optional<SelectionListener2> enhanceMappingModelListener,
			TargetSectionCrossReference reference, MappingHintGroupType hintGroup) {

		super("Multiple possible target sections and instances found to link elements of the target model!", options,
				false, enhanceMappingModelListener);
		this.reference = reference;
		this.hintGroup = hintGroup;
	}

	@Override
	protected Optional<String> getGroupText() {

		return Optional.of("Possible Target Section Classes:");
	}

	@Override
	protected void createInnerContents(Composite container) {

		Composite newContainer = new Composite(container, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).span(2, 1).applyTo(newContainer);
		GridLayout layout = new GridLayout(3, false);
		layout.verticalSpacing = 5;
		layout.marginRight = 0;
		layout.marginLeft = 0;
		newContainer.setLayout(layout);

		StringBuilder message = new StringBuilder().append(
				"The ambiguity occurred while setting the target element(s) for the TargetSectionCrossReference '")
				.append(this.reference.getName()).append("' of the TargetSection '")
				.append(this.hintGroup.getTargetSection().getName()).append("' created by the MappingHintGroup '")
				.append(this.hintGroup.getName()).append("'.\n\n");

		Group group = new Group(container, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).minSize(300, 200).applyTo(group);
		group.setText("Source of the Ambiguity:");
		GridLayoutFactory.fillDefaults().margins(5, 5).applyTo(group);

		// A label providing information about the element
		//
		Label label = new Label(group, SWT.WRAP);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(label);
		label.setText(message.toString());

		// A link that allows jumping to the pamtram model and selecting the targetSection
		//
		this.createLinkToPamtramModel(group, this.hintGroup.getTargetSection());

		// A link that allows jumping to the pamtram model and selecting the mappingHintGroup
		//
		this.createLinkToPamtramModel(group, this.hintGroup);

		super.createInnerContents(container);

	}
}
