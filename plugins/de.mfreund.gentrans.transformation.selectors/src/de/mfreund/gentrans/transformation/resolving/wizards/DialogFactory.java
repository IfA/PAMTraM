/**
 *
 */
package de.mfreund.gentrans.transformation.resolving.wizards;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Display;

import de.mfreund.gentrans.transformation.UserAbortException;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy.AmbiguityResolvingException;
import de.mfreund.gentrans.transformation.resolving.UserDecisionResolvingStrategy;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import pamtram.mapping.Mapping;

/**
 * A factory that simplifies the creation of the various {@link AbstractDialog AbstractDialogs} used by the
 * {@link UserDecisionResolvingStrategy}.
 *
 * @author mfreund
 */
public class DialogFactory {

	private DialogFactory() {

		// Just to prevent instantiation
		//
	}

	/**
	 * Creates and executes an {@link AbstractDialog}.
	 * <p />
	 * Note: This can be called from outside the UI thread as the dialog is executed via its own {@link Runnable}.
	 *
	 * @param <D>
	 *            The type of the {@link AbstractDialog} to be created.
	 *
	 * @param dialogSupplier
	 *            A supplier that will create the {@link AbstractDialog} to be executed.
	 * @return The created {@link AbstractDialog} after its execution.
	 * @throws AmbiguityResolvingException
	 *             If the user pressed the <em>Abort Transformation</em> button in the dialog.
	 */
	protected static <D extends AbstractDialog> D createAndExecuteDialog(Supplier<D> dialogSupplier)
			throws AmbiguityResolvingException {

		AtomicReference<D> dialogReference = new AtomicReference<>(null);

		// As we are not in the UI thread, we have to use a runnable to show the dialog in order to prevent
		// 'InvalidThreadAccess' exceptions
		//
		Display.getDefault().syncExec(() -> {

			D dialog = dialogSupplier.get();
			dialogReference.set(dialog);
			dialogReference.get().create();
			dialogReference.get().open();

		});

		if (dialogReference.get().getReturnCode() == IDialogConstants.CANCEL_ID) {
			throw new AmbiguityResolvingException(new UserAbortException());
		}

		return dialogReference.get();
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

		Supplier<SearchingAmbiguityDialog<MatchedSectionDescriptor>> dialogSupplier = () -> new SearchingAmbiguityDialog<MatchedSectionDescriptor>(
				"Multiple matching SourceSections found for an element of the source model!", choices, element, false,
				Optional.empty()) {

			@Override
			protected Optional<String> getGroupText() {

				return Optional.of("Applicable SourceSections:");
			}
		};

		SearchingAmbiguityDialog<MatchedSectionDescriptor> dialog = DialogFactory
				.createAndExecuteDialog(dialogSupplier);

		return dialog.getSingleSelection();
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

		Supplier<SearchingAmbiguityDialog<Mapping>> dialogSupplier = () -> new SearchingAmbiguityDialog<Mapping>(
				"Multiple applicable Mappings found for an element of the source model!", choices, element, true,
				Optional.empty()) {

			@Override
			protected Optional<String> getGroupText() {

				return Optional.of("Applicable Mappings:");
			}
		};

		SearchingAmbiguityDialog<Mapping> dialog = DialogFactory.createAndExecuteDialog(dialogSupplier);

		return dialog.getSelection();
	}

	/**
	 * Creates and executes a {@link GenericSelectionDialog} in order to resolve a <em>JoiningSelectRootElement</em>
	 * ambiguity.
	 * <p />
	 * Note: This can be called from outside the UI thread as the dialog is executed via its own {@link Runnable}.
	 *
	 * @param choices
	 *            The list of {@link EClass options} that the user can choose from.
	 * @param enhanceMappingModelListener
	 *            An optional {@link SelectionListener2} that will be called when the <em>EnhanceMappingModelButton</em>
	 *            is clicked. If no listener is given, the button will be grayed out.
	 * @return The chosen {@link EClass}.
	 * @throws AmbiguityResolvingException
	 *             If the user pressed the <em>Abort Transformation</em> button in the dialog.
	 */
	public static EClass createAndExecuteJoiningSelectRootElementDialog(List<EClass> choices,
			Optional<SelectionListener2> enhanceMappingModelListener) throws AmbiguityResolvingException {

		Supplier<GenericSelectionDialog<EClass>> dialogSupplier = () -> new GenericSelectionDialog<EClass>(
				"A root element needs to be created!", choices, false, enhanceMappingModelListener) {

			@Override
			protected Optional<String> getGroupText() {

				return Optional.of("Possible Root Element Types:");
			}
		};

		GenericSelectionDialog<EClass> dialog = DialogFactory.createAndExecuteDialog(dialogSupplier);

		return dialog.getSingleSelection();
	}

}
