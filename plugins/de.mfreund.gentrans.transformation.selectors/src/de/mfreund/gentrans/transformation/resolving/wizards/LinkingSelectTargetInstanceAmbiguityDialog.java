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
import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.structure.target.TargetSectionCrossReference;

/**
 * The dialog that is used by the {@link UserDecisionResolvingStrategy} to resolve <em>LinkingSelectTargetInstance</em>
 * ambiguities during the <em>joining</em> phase.
 *
 * @author mfreund
 */
public class LinkingSelectTargetInstanceAmbiguityDialog extends GenericSelectionDialog<EObjectWrapper> {

	/**
	 * The {@link TargetSectionCrossReference} whose target shall be set.
	 */
	protected TargetSectionCrossReference reference;

	/**
	 * The list of {@link EObjectWrapper elements} for that the given <em>reference</em> shall be set.
	 */
	protected List<EObjectWrapper> sourceElements;

	/**
	 * The {@link MappingHintGroupType} based on which the {@link #sectionInstances} were created.
	 */
	protected MappingHintGroupType hintGroup;

	/**
	 * An optional {@link ReferenceTargetSelector} that was specified for the {@link #hintGroup}.
	 */
	protected Optional<ReferenceTargetSelector> referenceTargetSelector;

	/**
	 * A hint value determined for the {@link #referenceTargetSelector}.
	 */
	protected Optional<String> hintValue;

	/**
	 * This creates an instance.
	 *
	 * @param message
	 *            The message that shall be displayed in the dialog.
	 * @param options
	 *            The options that the user can choose from.
	 * @param reference
	 *            The {@link TargetSectionCrossReference} whose target shall be set.
	 * @param hintGroup
	 *            The {@link MappingHintGroupType} based on which the {@link #sourceElements} were created.
	 * @param referenceTargetSelector
	 *            An {@link ReferenceTargetSelector} that was specified for the {@link #hintGroup}.
	 * @param sourceElements
	 *            The list of {@link EObjectWrapper elements} for that the given <em>reference</em> shall be set.
	 * @param enhanceMappingModelListener
	 *            An optional {@link SelectionListener2} that will be called when the <em>EnhanceMappingModelButton</em>
	 *            is clicked. If no listener is given, the button will be grayed out.
	 */
	public LinkingSelectTargetInstanceAmbiguityDialog(String message, List<EObjectWrapper> options,
			TargetSectionCrossReference reference, MappingHintGroupType hintGroup,
			Optional<ReferenceTargetSelector> referenceTargetSelector, List<EObjectWrapper> sourceElements,
			Optional<SelectionListener2> enhanceMappingModelListener) {

		super(message, options, reference.getEReference().isMany(), enhanceMappingModelListener);

		this.reference = reference;
		this.sourceElements = sourceElements;
		this.hintGroup = hintGroup;
		this.referenceTargetSelector = referenceTargetSelector;
	}

	@Override
	protected void createInnerContents(Composite container) {

		StringBuilder message = new StringBuilder().append(
				"The ambiguity occurred while setting the target element(s) for the TargetSectionCrossReference '")
				.append(this.reference.getName()).append("' for ").append(this.sourceElements.size())
				.append(this.sourceElements.size() == 1 ? " instance" : "instances").append(" of the TargetSection '")
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