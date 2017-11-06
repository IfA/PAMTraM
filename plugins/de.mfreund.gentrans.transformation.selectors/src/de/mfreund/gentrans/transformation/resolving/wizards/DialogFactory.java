/**
 *
 */
package de.mfreund.gentrans.transformation.resolving.wizards;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

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
import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionCrossReference;

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
			}
		};

		JoiningSelectContainerInstanceAmbiguityDialog dialog = DialogFactory.createAndExecuteDialog(dialogSupplier);

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
	 * @param hintGroup
	 *            The {@link MappingHintGroupType} that was responsible for instantiating the given 'sectionInstances'.
	 * @param sectionInstances
	 *            The list of {@link EObjectWrapper instances} of the given 'section' that need to be connected.
	 * @param enhanceMappingModelListener
	 *            An optional {@link SelectionListener2} that will be called when the <em>EnhanceMappingModelButton</em>
	 *            is clicked. If no listener is given, the button will be grayed out.
	 * @return The {@link HashMap} that contains the chosen {@link ModelConnectionPath} and {@link EObjectWrapper
	 *         container instance}.
	 * @throws AmbiguityResolvingException
	 *             If the user pressed the <em>Abort Transformation</em> button in the dialog.
	 */
	public static Map<ModelConnectionPath, List<EObjectWrapper>> createAndExecuteSelectConnectionPathAndContainerInstanceDialog(
			Map<ModelConnectionPath, List<EObjectWrapper>> choices, MappingHintGroupType hintGroup,
			List<EObjectWrapper> sectionInstances, Optional<SelectionListener2> enhanceMappingModelListener)
			throws AmbiguityResolvingException {

		Supplier<ClassAndInstanceSelectorDialog<ModelConnectionPath>> dialogSupplier = () -> new ClassAndInstanceSelectorDialog<ModelConnectionPath>(
				"Multiple possible paths and container instances found to join elements of the target model!", choices,
				false, enhanceMappingModelListener) {

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
						.append(sectionInstances.size())
						.append(sectionInstances.size() == 1 ? " instance" : "instances")
						.append(" of the TargetSection '").append(hintGroup.getTargetSection().getName())
						.append("' created by the MappingHintGroup '").append(hintGroup.getName()).append("'.\n\n");

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
				this.createLinkToPamtramModel(group, hintGroup.getTargetSection());

				// A link that allows jumping to the pamtram model and selecting the mappingHintGroup
				//
				this.createLinkToPamtramModel(group, hintGroup);

				super.createInnerContents(container);

			}

		};

		ClassAndInstanceSelectorDialog<ModelConnectionPath> dialog = DialogFactory
				.createAndExecuteDialog(dialogSupplier);

		Map<ModelConnectionPath, List<EObjectWrapper>> result = new HashMap<>();
		result.put(dialog.getSingleSelection(), Arrays.asList(dialog.getSingleInstance()));
		return result;
	}

	/**
	 * Creates and executes a {@link GenericSelectionDialog} in order to resolve a <em>SelectContainerInstance</em>
	 * ambiguity.
	 * <p />
	 * Note: This can be called from outside the UI thread as the dialog is executed via its own {@link Runnable}.
	 *
	 * @param choices
	 *            The list of {@link EObjectWrapper options} that the user can choose from.
	 * @param reference
	 *            The {@link TargetSectionCrossReference} whose target shall be set.
	 * @param hintGroup
	 *            The {@link MappingHintGroupType} based on which the <em>sourceElements</em> were created.
	 * @param referenceTargetSelector
	 *            An {@link ReferenceTargetSelector} that was specified for the <em>hintGroup</em>.
	 * @param sourceElements
	 *            The list of {@link EObjectWrapper elements} for that the given <em>reference</em> shall be set.
	 * @param enhanceMappingModelListener
	 *            An optional {@link SelectionListener2} that will be called when the <em>EnhanceMappingModelButton</em>
	 *            is clicked. If no listener is given, the button will be grayed out.
	 * @return The chosen {@link EObjectWrapper}.
	 * @throws AmbiguityResolvingException
	 *             If the user pressed the <em>Abort Transformation</em> button in the dialog.
	 */
	public static List<EObjectWrapper> createAndExecuteLinkingSelectTargetInstanceDialog(List<EObjectWrapper> choices,
			TargetSectionCrossReference reference, MappingHintGroupType hintGroup,
			Optional<ReferenceTargetSelector> referenceTargetSelector, List<EObjectWrapper> sourceElements,
			Optional<SelectionListener2> enhanceMappingModelListener) throws AmbiguityResolvingException {

		Supplier<LinkingSelectTargetInstanceAmbiguityDialog> dialogSupplier = () -> new LinkingSelectTargetInstanceAmbiguityDialog(
				"Multiple possible target elements found to link elements of the target model!", choices, reference,
				hintGroup, referenceTargetSelector, sourceElements, enhanceMappingModelListener) {

			@Override
			protected Optional<String> getGroupText() {

				return Optional.of("Possible Target Instances:");
			};
		};

		LinkingSelectTargetInstanceAmbiguityDialog dialog = DialogFactory.createAndExecuteDialog(dialogSupplier);

		return dialog.getSelection();
	}

	/**
	 * Creates and executes a {@link GenericSelectionDialog} in order to resolve a
	 * <em>LinkingSelectTargetSectionAndInstance</em> ambiguity.
	 * <p />
	 * Note: This can be called from outside the UI thread as the dialog is executed via its own {@link Runnable}.
	 *
	 * @param choices
	 *            A HashMap that contains the {@link TargetSection TargetSections} and associated lists of elements that
	 *            can be chosen as target.
	 * @param reference
	 *            The {@link TargetSectionCrossReference} whose target shall be set.
	 * @param hintGroup
	 *            The {@link MappingHintGroupType} that was responsible for instantiating the given 'sectionInstances'.
	 * @param enhanceMappingModelListener
	 *            An optional {@link SelectionListener2} that will be called when the <em>EnhanceMappingModelButton</em>
	 *            is clicked. If no listener is given, the button will be grayed out.
	 * @return The {@link HashMap} that contains the chosen {@link ModelConnectionPath} and {@link EObjectWrapper
	 *         container instance}.
	 * @throws AmbiguityResolvingException
	 *             If the user pressed the <em>Abort Transformation</em> button in the dialog.
	 */
	public static Map<TargetSectionClass, List<EObjectWrapper>> createAndExecuteLinkingSelectTargetSectionAndInstanceDialog(
			Map<TargetSectionClass, List<EObjectWrapper>> choices, TargetSectionCrossReference reference,
			MappingHintGroupType hintGroup, Optional<SelectionListener2> enhanceMappingModelListener)
			throws AmbiguityResolvingException {

		Supplier<ClassAndInstanceSelectorDialog<TargetSectionClass>> dialogSupplier = () -> new ClassAndInstanceSelectorDialog<TargetSectionClass>(
				"Multiple possible target sections and instances found to link elements of the target model!", choices,
				false, enhanceMappingModelListener) {

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
						.append(reference.getName()).append("' of the TargetSection '")
						.append(hintGroup.getTargetSection().getName()).append("' created by the MappingHintGroup '")
						.append(hintGroup.getName()).append("'.\n\n");

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
				this.createLinkToPamtramModel(group, hintGroup.getTargetSection());

				// A link that allows jumping to the pamtram model and selecting the mappingHintGroup
				//
				this.createLinkToPamtramModel(group, hintGroup);

				super.createInnerContents(container);

			}

		};

		ClassAndInstanceSelectorDialog<TargetSectionClass> dialog = DialogFactory
				.createAndExecuteDialog(dialogSupplier);

		Map<TargetSectionClass, List<EObjectWrapper>> result = new HashMap<>();
		result.put(dialog.getSingleSelection(), Arrays.asList(dialog.getSingleInstance()));
		return result;
	}

}
