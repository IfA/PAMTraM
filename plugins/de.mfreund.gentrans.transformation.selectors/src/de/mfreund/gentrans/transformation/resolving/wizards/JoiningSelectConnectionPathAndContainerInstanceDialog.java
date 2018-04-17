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
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPath;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import pamtram.mapping.MappingHintGroupType;

/**
 *
 * @author mfreund
 */
public class JoiningSelectConnectionPathAndContainerInstanceDialog
		extends ClassAndInstanceSelectorDialog<EClassConnectionPath> {

	/**
	 * The {@link MappingHintGroupType} that was responsible for instantiating the given 'sectionInstances'.
	 */
	private MappingHintGroupType hintGroup;

	/**
	 * The list of {@link EObjectWrapper instances} of the given 'section' that need to be connected.
	 */
	private List<EObjectWrapper> sectionInstances;

	/**
	 * This creates an instance.
	 *
	 * @param options
	 *            The options that the user can choose from.
	 * @param hintGroup
	 *            The {@link MappingHintGroupType} that was responsible for instantiating the given 'sectionInstances'.
	 * @param sectionInstances
	 *            The list of {@link EObjectWrapper instances} of the given 'section' that need to be connected.
	 * @param enhanceMappingModelListener
	 *            An optional {@link SelectionListener2} that will be called when the <em>EnhanceMappingModelButton</em>
	 *            is clicked. If no listener is given, the button will be grayed out.
	 */
	public JoiningSelectConnectionPathAndContainerInstanceDialog(
			Map<EClassConnectionPath, List<EObjectWrapper>> options, MappingHintGroupType hintGroup,
			List<EObjectWrapper> sectionInstances, Optional<SelectionListener2> enhanceMappingModelListener) {

		super("Multiple possible paths and container instances found to join elements of the target model!", options,
				false, enhanceMappingModelListener);
		this.hintGroup = hintGroup;
		this.sectionInstances = sectionInstances;
	}

	@Override
	protected Optional<String> getGroupText() {

		return Optional.of("Possible Connection Paths:");
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

		StringBuilder message = new StringBuilder().append("The ambiguity occurred while joining ")
				.append(this.sectionInstances.size())
				.append(this.sectionInstances.size() == 1 ? " instance" : "instances").append(" of the TargetSection '")
				.append(this.hintGroup.getTargetSection().getName()).append("' created by the MappingHintGroup '")
				.append(this.hintGroup.getName()).append("'.\n\n");

		Group group = new Group(newContainer, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).minSize(150, 200).applyTo(group);
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

		super.createInnerContents(newContainer);

	}
}
