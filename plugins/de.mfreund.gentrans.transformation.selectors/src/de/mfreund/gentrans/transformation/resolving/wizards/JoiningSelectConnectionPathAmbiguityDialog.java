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

import de.mfreund.gentrans.transformation.connecting.MetaModelPath;
import de.mfreund.gentrans.transformation.resolving.UserDecisionResolvingStrategy;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import pamtram.structure.target.TargetSection;

/**
 * The dialog that is used by the {@link UserDecisionResolvingStrategy} to resolve <em>JoiningSelectConnectionPath</em>
 * ambiguities during the <em>joining</em> phase.
 *
 * @author mfreund
 */
public class JoiningSelectConnectionPathAmbiguityDialog extends GenericSelectionDialog<MetaModelPath> {

	/**
	 * The {@link TargetSection} for that the option shall be chosen.
	 */
	protected TargetSection element;

	/**
	 * This creates an instance.
	 *
	 * @param options
	 *            The options that the user can choose from.
	 * @param element
	 *            The {@link TargetSection} for that the option shall be chosen.
	 * @param enhanceMappingModelListener
	 *            An optional {@link SelectionListener2} that will be called when the <em>EnhanceMappingModelButton</em>
	 *            is clicked. If no listener is given, the button will be grayed out.
	 */
	public JoiningSelectConnectionPathAmbiguityDialog(List<MetaModelPath> options, TargetSection element,
			Optional<SelectionListener2> enhanceMappingModelListener) {

		super("Multiple possible paths found to join elements of the target model!", options, false,
				enhanceMappingModelListener);

		this.element = element;
	}

	@Override
	protected Optional<String> getGroupText() {

		return Optional.of("Possible Connection Paths:");
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
		label.setText("Instances of the following TargetSection need to be joined:\n\n" + this.element.getName());

		// A link that allows jumping to the source model and selecting the element
		//
		this.createLinkToPamtramModel(group, this.element);

		super.createInnerContents(container);
	}

}