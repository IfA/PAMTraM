/**
 *
 */
package de.mfreund.gentrans.transformation.resolving.wizards;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;

import de.mfreund.gentrans.transformation.UserAbortException;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy.AmbiguityResolvingException;
import de.mfreund.gentrans.transformation.resolving.UserDecisionResolvingStrategy;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import de.tud.et.ifa.agtele.ui.util.UIHelper;
import pamtram.mapping.Mapping;

/**
 * The dialog that is used by the {@link UserDecisionResolvingStrategy} to resolve ambiguities during the
 * <em>searching</em> phase.
 *
 * @author mfreund
 * @param <T>
 *            The type of elements that the user can choose from.
 */
public class SearchingAmbiguityDialog<T> extends GenericSelectionDialog<T> {

	/**
	 * The source {@link EObject element} for that the option shall be chosen.
	 */
	protected EObject element;

	/**
	 * This creates an instance.
	 *
	 * @param message
	 *            The message that shall be displayed in the dialog.
	 * @param options
	 *            The options that the user can choose from.
	 * @param element
	 *            The source {@link EObject element} for that the option shall be chosen.
	 * @param multiSelectionAllowed
	 *            Whether multi-selection shall be allowed in the dialog.
	 * @param enhanceMappingModelListener
	 *            An optional {@link SelectionListener2} that will be called when the <em>EnhanceMappingModelButton</em>
	 *            is clicked. If no listener is given, the button will be grayed out.
	 */
	public SearchingAmbiguityDialog(String message, List<T> options, EObject element, boolean multiSelectionAllowed,
			Optional<SelectionListener2> enhanceMappingModelListener) {

		super(message, options, multiSelectionAllowed, enhanceMappingModelListener);

		this.element = element;
	}

	@Override
	protected void createInnerContents(Composite container) {

		Group group = new Group(container, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).minSize(200, 200).applyTo(group);
		group.setText("The ambiguity occurred for the following element:");
		GridLayoutFactory.fillDefaults().margins(5, 5).applyTo(group);

		// A label providing information about the element
		//
		Label label = new Label(group, SWT.WRAP);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(label);
		label.setText(EObjectWrapper.asString(this.element));

		// A link that allows jumping to the source model and selecting the element
		//
		Link link = new Link(group, SWT.NONE);
		GridDataFactory.swtDefaults().applyTo(link);
		link.setText("<A>-> Show in Source Model...</A>");
		link.addSelectionListener((SelectionListener2) e -> {

			try {
				UIHelper.selectEObjectInEditor(this.element, Optional.empty());
			} catch (Exception e1) {
				UIHelper.log(e1);
				this.setErrorMessage("Unable to select element in the Editor!");
			}

		});

		super.createInnerContents(container);
	}

	/**
	 * Creates and executes a {@link SearchingAmbiguityDialog} in order to resolve a <em>SearchingSelectSection</em>
	 * ambiguity.
	 * <p />
	 * Note: This can be called from outside the UI thread as the dialog is executed via its own {@link Runnable}.
	 *
	 * @param choices
	 *            The list of {@link MatchedSectionDescriptor options} that the user can choose from.
	 * @param element
	 *            The source {@link EObject element} for that the option shall be chosen.
	 * @return The chosen {@link MatchedSectionDescriptor}.
	 * @throws AmbiguityResolvingException
	 *             If the user pressed the <em>Abort Transformation</em> button in the dialog.
	 */
	public static MatchedSectionDescriptor createAndExecuteSearchingSelectSectionDialog(
			List<MatchedSectionDescriptor> choices, EObject element) throws AmbiguityResolvingException {

		AtomicReference<GenericSelectionDialog<MatchedSectionDescriptor>> dialog = new AtomicReference<>(null);

		// As we are not in the UI thread, we have to use a runnable to show the dialog in order to prevent
		// 'InvalidThreadAccess' exceptions
		//
		Display.getDefault().syncExec(() -> {

			dialog.set(new SearchingAmbiguityDialog<MatchedSectionDescriptor>(
					"Multiple matching SourceSections found for an element of the source model!", choices, element,
					false, Optional.empty()) {

				@Override
				protected Optional<String> getGroupText() {

					return Optional.of("Applicable SourceSections:");
				}
			});
			dialog.get().create();
			dialog.get().open();
		});

		if (dialog.get().getReturnCode() == IDialogConstants.CANCEL_ID) {
			throw new AmbiguityResolvingException(new UserAbortException());
		}

		return dialog.get().getSingleSelection();
	}

	/**
	 * Creates and executes a {@link SearchingAmbiguityDialog} in order to resolve a <em>SearchingSelectMapping</em>
	 * ambiguity.
	 * <p />
	 * Note: This can be called from outside the UI thread as the dialog is executed via its own {@link Runnable}.
	 *
	 * @param choices
	 *            The list of {@link Mapping options} that the user can choose from.
	 * @param element
	 *            The source {@link EObject element} for that the option shall be chosen.
	 * @return The chosen {@link Mapping Mappings}.
	 * @throws AmbiguityResolvingException
	 *             If the user pressed the <em>Abort Transformation</em> button in the dialog.
	 */
	public static List<Mapping> createAndExecuteSearchingSelectMappingDialog(List<Mapping> choices, EObject element)
			throws AmbiguityResolvingException {

		AtomicReference<GenericSelectionDialog<Mapping>> dialog = new AtomicReference<>(null);

		// As we are not in the UI thread, we have to use a runnable to show the dialog in order to prevent
		// 'InvalidThreadAccess' exceptions
		//
		Display.getDefault().syncExec(() -> {

			dialog.set(new SearchingAmbiguityDialog<Mapping>(
					"Multiple applicable Mappings found for an element of the source model!", choices, element, true,
					Optional.empty()) {

				@Override
				protected Optional<String> getGroupText() {

					return Optional.of("Applicable Mappings:");
				}
			});
			dialog.get().create();
			dialog.get().open();
		});

		if (dialog.get().getReturnCode() == IDialogConstants.CANCEL_ID) {
			throw new AmbiguityResolvingException(new UserAbortException());
		}

		return dialog.get().getSelection();
	}

}