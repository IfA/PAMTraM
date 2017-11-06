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

import de.mfreund.gentrans.transformation.descriptors.ModelConnectionPath;
import de.mfreund.gentrans.transformation.resolving.UserDecisionResolvingStrategy;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import pamtram.structure.target.TargetSectionClass;

/**
 * The dialog that is used by the {@link UserDecisionResolvingStrategy} to resolve <em>JoiningSelectConnectionPath</em>
 * ambiguities during the <em>joining</em> phase.
 *
 * @author mfreund
 */
public class JoiningSelectConnectionPathAmbiguityDialog extends GenericSelectionDialog<ModelConnectionPath> {

	/**
	 * The {@link TargetSectionClass} for that the option shall be chosen.
	 */
	protected TargetSectionClass element;

	/**
	 * This creates an instance.
	 *
	 * @param message
	 *            The message that shall be displayed in the dialog.
	 * @param options
	 *            The options that the user can choose from.
	 * @param element
	 *            The {@link TargetSectionClass} for that the option shall be chosen.
	 * @param enhanceMappingModelListener
	 *            An optional {@link SelectionListener2} that will be called when the <em>EnhanceMappingModelButton</em>
	 *            is clicked. If no listener is given, the button will be grayed out.
	 */
	public JoiningSelectConnectionPathAmbiguityDialog(String message, List<ModelConnectionPath> options,
			TargetSectionClass element, Optional<SelectionListener2> enhanceMappingModelListener) {

		super(message, options, false, enhanceMappingModelListener);

		this.element = element;
	}

	@Override
	protected void createInnerContents(Composite container) {

		Group group = new Group(container, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).minSize(300, 200).applyTo(group);
		group.setText("Source of the Ambiguity:");
		GridLayoutFactory.fillDefaults().margins(5, 5).applyTo(group);

		// A label providing information about the element
		//
		Label label = new Label(group, SWT.WRAP);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(label);
		label.setText("Instances of the following TargetSectionClass need to be joined:\n\n" + this.element.getName());

		// A link that allows jumping to the source model and selecting the element
		//
		this.createLinkToPamtramModel(group, this.element);

		super.createInnerContents(container);
	}

}