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
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.descriptors.ModelConnectionPath;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy.AmbiguityResolvingException;
import de.mfreund.gentrans.transformation.resolving.UserDecisionResolvingStrategy;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.extended.ContainerSelector;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.target.TargetSectionClass;

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
	 * Creates and executes a {@link InstantiatingSelectAttributeValueDialog} in order to resolve a
	 * <em>InstantiatingSelectAttributeValue</em> ambiguity.
	 * <p />
	 * Note: This can be called from outside the UI thread as the dialog is executed via its own {@link Runnable}.
	 *
	 * @param attribute
	 *            The {@link TargetSectionAttribute} for that a value shall be entered.
	 * @param element
	 *            The target {@link EObject element} for that the option shall be chosen.
	 * @param mappingHintGroup
	 *            The {@link InstantiableMappingHintGroup mapping hint group} based on which the attribute was created.
	 * @param enhanceMappingModelListener
	 *            An optional {@link SelectionListener2} that will be called when the <em>EnhanceMappingModelButton</em>
	 *            is clicked. If no listener is given, the button will be grayed out.
	 * @return The chosen {@link Mapping Mappings}.
	 * @throws AmbiguityResolvingException
	 *             If the user pressed the <em>Abort Transformation</em> button in the dialog.
	 */
	public static String createAndExecuteInstantiatingSelectAttributeValueDialog(TargetSectionAttribute attribute,
			EObject element, InstantiableMappingHintGroup mappingHintGroup,
			Optional<SelectionListener2> enhanceMappingModelListener) throws AmbiguityResolvingException {

		Supplier<InstantiatingSelectAttributeValueDialog> dialogSupplier = () -> new InstantiatingSelectAttributeValueDialog(
				"Unspecified attribute value found for an element of the target model!", attribute, element,
				mappingHintGroup, enhanceMappingModelListener);

		ValueSpecificationDialog dialog = DialogFactory.createAndExecuteDialog(dialogSupplier);

		return dialog.getValue();
	}

	/**
	 * Creates and executes a {@link InstantiatingSelectCardinalityDialog} in order to resolve a
	 * <em>InstantiatingSelectCardinality</em> ambiguity.
	 * <p />
	 * Note: This can be called from outside the UI thread as the dialog is executed via its own {@link Runnable}.
	 *
	 * @param targetSectionClass
	 *            The {@link TargetSectionClass} for that a cardinality shall be entered.
	 * @param mappingHintGroup
	 *            The {@link InstantiableMappingHintGroup} that is responsible for the instantiation of the target
	 *            section.
	 * @param enhanceMappingModelListener
	 *            An optional {@link SelectionListener2} that will be called when the <em>EnhanceMappingModelButton</em>
	 *            is clicked. If no listener is given, the button will be grayed out.
	 * @return The chosen {@link Mapping Mappings}.
	 * @throws AmbiguityResolvingException
	 *             If the user pressed the <em>Abort Transformation</em> button in the dialog.
	 */
	public static String createAndExecuteInstantiatingSelectCardinalityDialog(TargetSectionClass targetSectionClass,
			InstantiableMappingHintGroup mappingHintGroup, Optional<SelectionListener2> enhanceMappingModelListener)
			throws AmbiguityResolvingException {

		Supplier<InstantiatingSelectCardinalityDialog> dialogSupplier = () -> new InstantiatingSelectCardinalityDialog(
				"Unspecified cardinality found for a TargetSectionClass!", targetSectionClass, mappingHintGroup,
				enhanceMappingModelListener);

		ValueSpecificationDialog dialog = DialogFactory.createAndExecuteDialog(dialogSupplier);

		return dialog.getValue();
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

	/**
	 * Creates and executes a {@link GenericSelectionDialog} in order to resolve a <em>SelectConnectionPath</em>
	 * ambiguity.
	 * <p />
	 * Note: This can be called from outside the UI thread as the dialog is executed via its own {@link Runnable}.
	 *
	 * @param choices
	 *            The list of {@link ModelConnectionPath options} that the user can choose from.
	 * @param element
	 *            The {@link TargetSectionClass} for that the option shall be chosen.
	 * @param enhanceMappingModelListener
	 *            An optional {@link SelectionListener2} that will be called when the <em>EnhanceMappingModelButton</em>
	 *            is clicked. If no listener is given, the button will be grayed out.
	 * @return The chosen {@link ModelConnectionPath}.
	 * @throws AmbiguityResolvingException
	 *             If the user pressed the <em>Abort Transformation</em> button in the dialog.
	 */
	public static ModelConnectionPath createAndExecuteSelectConnectionPathDialog(List<ModelConnectionPath> choices,
			TargetSectionClass element, Optional<SelectionListener2> enhanceMappingModelListener)
			throws AmbiguityResolvingException {

		Supplier<JoiningSelectConnectionPathAmbiguityDialog> dialogSupplier = () -> new JoiningSelectConnectionPathAmbiguityDialog(
				"Multiple possible paths found to join elements of the target model!", choices, element,
				enhanceMappingModelListener) {

			@Override
			protected Optional<String> getGroupText() {

				return Optional.of("Possible Connection Paths:");
			}
		};

		JoiningSelectConnectionPathAmbiguityDialog dialog = DialogFactory.createAndExecuteDialog(dialogSupplier);

		return dialog.getSingleSelection();
	}

	/**
	 * Creates and executes a {@link GenericSelectionDialog} in order to resolve a <em>SelectContainerInstance</em>
	 * ambiguity.
	 * <p />
	 * Note: This can be called from outside the UI thread as the dialog is executed via its own {@link Runnable}.
	 *
	 * @param choices
	 *            The list of {@link EObjectWrapper options} that the user can choose from.
	 * @param sectionInstances
	 *            The list of {@link EObjectWrapper elements} that need to be joined.
	 * @param hintGroup
	 *            The {@link MappingHintGroupType} based on which the <em>sectionInstances</em> were created.
	 * @param containerSelector
	 *            An {@link ContainerSelector} that was specified for the <em>hintGroup</em>.
	 * @param hintValue
	 *            A hint value determined for the <em>containerSelector</em>.
	 * @param enhanceMappingModelListener
	 *            An optional {@link SelectionListener2} that will be called when the <em>EnhanceMappingModelButton</em>
	 *            is clicked. If no listener is given, the button will be grayed out.
	 * @return The chosen {@link EObjectWrapper}.
	 * @throws AmbiguityResolvingException
	 *             If the user pressed the <em>Abort Transformation</em> button in the dialog.
	 */
	public static EObjectWrapper createAndExecuteJoiningSelectContainerInstanceDialog(List<EObjectWrapper> choices,
			List<EObjectWrapper> sectionInstances, MappingHintGroupType hintGroup,
			Optional<ContainerSelector> containerSelector, Optional<String> hintValue,
			Optional<SelectionListener2> enhanceMappingModelListener) throws AmbiguityResolvingException {

		Supplier<JoiningSelectContainerInstanceAmbiguityDialog> dialogSupplier = () -> new JoiningSelectContainerInstanceAmbiguityDialog(
				"Multiple possible container instances found to join elements of the target model!", choices,
				sectionInstances, hintGroup, containerSelector, hintValue, enhanceMappingModelListener) {

			@Override
			protected Optional<String> getGroupText() {

				return Optional.of("Possible Container Instances:");
			};
		};

		JoiningSelectContainerInstanceAmbiguityDialog dialog = DialogFactory.createAndExecuteDialog(dialogSupplier);

		return dialog.getSingleSelection();
	}

}
