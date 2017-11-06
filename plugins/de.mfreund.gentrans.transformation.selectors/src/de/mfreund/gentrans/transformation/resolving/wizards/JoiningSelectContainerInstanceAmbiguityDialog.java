/**
 *
 */
package de.mfreund.gentrans.transformation.resolving.wizards;

import java.util.List;
import java.util.Optional;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.resolving.UserDecisionResolvingStrategy;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.extended.ContainerSelector;

/**
 * The dialog that is used by the {@link UserDecisionResolvingStrategy} to resolve
 * <em>JoiningSelectContainerInstance</em> ambiguities during the <em>joining</em> phase.
 *
 * @author mfreund
 */
public class JoiningSelectContainerInstanceAmbiguityDialog extends GenericSelectionDialog<EObjectWrapper> {

	/**
	 * The list of {@link EObjectWrapper elements} that need to be joined.
	 */
	protected List<EObjectWrapper> sectionInstances;

	/**
	 * The {@link MappingHintGroupType} based on which the {@link #sectionInstances} were created.
	 */
	protected MappingHintGroupType hintGroup;

	/**
	 * An optional {@link ContainerSelector} that was specified for the {@link #hintGroup}.
	 */
	protected Optional<ContainerSelector> containerSelector;

	/**
	 * A hint value determined for the {@link #containerSelector}.
	 */
	protected Optional<String> hintValue;

	/**
	 * This creates an instance.
	 *
	 * @param message
	 *            The message that shall be displayed in the dialog.
	 * @param options
	 *            The options that the user can choose from.
	 * @param sectionInstances
	 *            The list of {@link EObjectWrapper elements} that need to be joined.
	 * @param hintGroup
	 *            The {@link MappingHintGroupType} based on which the {@link #sectionInstances} were created.
	 * @param containerSelector
	 *            An {@link ContainerSelector} that was specified for the {@link #hintGroup}.
	 * @param hintValue
	 *            A hint value determined for the {@link #containerSelector}.
	 * @param enhanceMappingModelListener
	 *            An optional {@link SelectionListener2} that will be called when the <em>EnhanceMappingModelButton</em>
	 *            is clicked. If no listener is given, the button will be grayed out.
	 */
	public JoiningSelectContainerInstanceAmbiguityDialog(String message, List<EObjectWrapper> options,
			List<EObjectWrapper> sectionInstances, MappingHintGroupType hintGroup,
			Optional<ContainerSelector> containerSelector, Optional<String> hintValue,
			Optional<SelectionListener2> enhanceMappingModelListener) {

		super(message, options, false, enhanceMappingModelListener);

		this.sectionInstances = sectionInstances;
		this.hintGroup = hintGroup;
		this.containerSelector = containerSelector;
		this.hintValue = hintValue;
	}

	@Override
	protected void createInnerContents(Composite container) {

		StringBuilder message = new StringBuilder().append("The ambiguity occurred while joining ")
				.append(this.sectionInstances.size())
				.append(this.sectionInstances.size() == 1 ? " instance" : "instances").append(" of the TargetSection '")
				.append(this.hintGroup.getTargetSection().getName()).append("' created by the MappingHintGroup '")
				.append(this.hintGroup.getName()).append("'.\n\n");

		if (this.containerSelector.isPresent() && this.hintValue.isPresent()) {
			message.append("The ContainerSelector '").append(this.containerSelector.get().getName())
					.append("' produced the HintValue '").append(this.hintValue.get())
					.append("' which was satisfied by all potential container instances.");
		}

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