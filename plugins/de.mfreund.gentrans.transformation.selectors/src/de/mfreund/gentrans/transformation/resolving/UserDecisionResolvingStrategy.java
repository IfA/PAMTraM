package de.mfreund.gentrans.transformation.resolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Display;

import de.mfreund.gentrans.transformation.UserAbortException;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.descriptors.ModelConnectionPath;
import de.mfreund.gentrans.transformation.resolving.enhancing.InstantiatingSelectAttributeValueMappingModelEnhancer;
import de.mfreund.gentrans.transformation.resolving.enhancing.JoiningSelectConnectionPathAndContainerInstanceMappingModelEnhancer;
import de.mfreund.gentrans.transformation.resolving.enhancing.JoiningSelectConnectionPathMappingModelEnhancer;
import de.mfreund.gentrans.transformation.resolving.enhancing.JoiningSelectContainerInstanceMappingModelEnhancer;
import de.mfreund.gentrans.transformation.resolving.enhancing.JoiningSelectRootElementMappingModelEnhancer;
import de.mfreund.gentrans.transformation.resolving.wizards.ClassAndInstanceSelectorDialog;
import de.mfreund.gentrans.transformation.resolving.wizards.GenericSelectionDialog;
import de.mfreund.gentrans.transformation.resolving.wizards.SearchingAmbiguityDialog;
import de.mfreund.gentrans.transformation.resolving.wizards.ValueSpecificationDialog;
import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import pamtram.PAMTraM;
import pamtram.TargetSectionModel;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.extended.ContainerSelector;
import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.presentation.PamtramEditor;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionCrossReference;

/**
 * This class implements a concrete {@link IAmbiguityResolvingStrategy} that allows a user to resolve ambiguities by
 * presenting selection dialogues to him.
 * <p />
 * Note: This strategy can only be used when running inside Eclipse because it integrates with the
 * {@link PamtramEditor}!
 *
 * @author mfreund
 */
public class UserDecisionResolvingStrategy extends AbstractAmbiguityResolvingStrategy {

	/**
	 * This prefix will be added to {@link #printMessage(String, String) messages} printed after user selections.
	 */
	private static final String userDecisionPrefix = "User";

	/**
	 * If this is set to '<em>false</em>' this strategy will also try to resolve ambiguities during the
	 * <em>expanding<em> step as this might lead to a ton of questions.
	 * <p />
	 * The default value is '<em>true</em>'.
	 */
	private boolean skipExpandingAmbiguities = true;

	/**
	 * This allows to change the {@link #skipExpandingAmbiguities} behavior.
	 *
	 * @param skipExpandingAmbiguities
	 *            If this is set to '<em>false</em>' this strategy will also try to resolve ambiguities during the
	 *            <em>expanding<em> step
	 */
	public void setSkipExpandingAmbiguities(boolean skipExpandingAmbiguities) {

		this.skipExpandingAmbiguities = skipExpandingAmbiguities;
	}

	@Override
	public List<MatchedSectionDescriptor> searchingSelectSection(List<MatchedSectionDescriptor> choices,
			EObject element) throws AmbiguityResolvingException {

		MatchedSectionDescriptor result = SearchingAmbiguityDialog.createAndExecuteSearchingSelectSectionDialog(choices,
				element);

		this.printMessage(result.getAssociatedSourceSectionClass().getName(),
				UserDecisionResolvingStrategy.userDecisionPrefix);

		return Arrays.asList(result);
	}

	@Override
	public List<Mapping> searchingSelectMapping(List<Mapping> choices, EObject element)
			throws AmbiguityResolvingException {

		List<Mapping> result = SearchingAmbiguityDialog.createAndExecuteSearchingSelectMappingDialog(choices, element);

		this.printMessage(String.join(", ", result.stream().map(Mapping::getName).collect(Collectors.toList())),
				UserDecisionResolvingStrategy.userDecisionPrefix);

		return result;
	}

	@Override
	public List<String> instantiatingSelectAttributeValue(List<String> choices, TargetSectionAttribute attribute,
			EObject element, InstantiableMappingHintGroup mappingHintGroup) throws AmbiguityResolvingException {

		if (choices == null || choices.isEmpty()) {
			return new ArrayList<>();
		} else if (choices.size() > 1 || choices.get(0) != null || this.skipExpandingAmbiguities) {
			return choices;
		}

		Optional<PAMTraM> pamtramModel = this.pamtramModels.stream()
				.filter(p -> EcoreUtil.isAncestor(p.getTargetSections(), attribute)).findAny();

		String dialogMessage = "Please specify a value for the TargetSectionAttribute '"
				+ attribute.getOwningClass().getName() + "." + attribute.getName() + "':";

		InstantiatingSelectAttributeValueMappingModelEnhancer enhancer = new InstantiatingSelectAttributeValueMappingModelEnhancer(
				pamtramModel.orElseThrow(
						() -> new RuntimeException("Internal error while determining PAMTraM instance to enhance...")),
				attribute, mappingHintGroup);

		AtomicReference<ValueSpecificationDialog> dialog = new AtomicReference<>(null);

		// As we are not in the UI thread, we have to use a runnable to show the dialog in order to prevent
		// 'InvalidThreadAccess' exceptions
		//
		Display.getDefault().syncExec(() -> {

			dialog.set(new ValueSpecificationDialog(dialogMessage, Optional.of(enhancer)));
			dialog.get().create();
			dialog.get().open();
		});

		if (dialog.get().getReturnCode() == IDialogConstants.CANCEL_ID) {
			throw new AmbiguityResolvingException(new UserAbortException().getMessage(), new UserAbortException());
		}

		this.printMessage(dialog.get().getValue(), UserDecisionResolvingStrategy.userDecisionPrefix);
		return Arrays.asList(dialog.get().getValue());
	}

	@Override
	public List<Integer> instantiatingSelectCardinality(List<Integer> choices, TargetSectionClass targetSectionClass,
			InstantiableMappingHintGroup mappingHintGroup) throws AmbiguityResolvingException {

		if (choices == null || choices.isEmpty()) {
			return new ArrayList<>();
		} else if (choices.size() > 1 || choices.get(0) != null || this.skipExpandingAmbiguities) {
			return choices;
		}

		String dialogMessage = "Please specify a cardinality for the target section class '"
				+ targetSectionClass.getName() + "' that is instantiated by the mapping hint group '"
				+ mappingHintGroup.getName() + "'...";

		AtomicReference<ValueSpecificationDialog> dialog = new AtomicReference<>(null);

		// As we are not in the UI thread, we have to use a runnable to show the dialog in order to prevent
		// 'InvalidThreadAccess' exceptions
		//
		Display.getDefault().syncExec(() -> {

			dialog.set(new ValueSpecificationDialog(dialogMessage, Optional.empty()));
			dialog.get().create();
			dialog.get().open();
		});

		if (dialog.get().getReturnCode() == IDialogConstants.CANCEL_ID) {
			throw new AmbiguityResolvingException(new UserAbortException().getMessage(), new UserAbortException());
		}

		int cardinality = -1;
		if (dialog.get().getValue() != null && !dialog.get().getValue().isEmpty()) {
			try {
				cardinality = Integer.parseInt(dialog.get().getValue());

			} catch (NumberFormatException e) {
				throw new AmbiguityResolvingException(
						"Could not parse a valid cardinality (positive integer) from the string '"
								+ dialog.get().getValue() + "'!",
						e);
			}
		}
		if (cardinality == -1) {
			return choices;
		}
		this.printMessage("Cardinality: " + cardinality, UserDecisionResolvingStrategy.userDecisionPrefix);
		return Arrays.asList(cardinality);

	}

	@Override
	public List<EClass> joiningSelectRootElement(List<EClass> choices) throws AmbiguityResolvingException {

		List<String> classNames = new ArrayList<>();

		for (EClass eClass : choices) {
			classNames.add(eClass.getName());
		}

		Set<EPackage> ePackages = choices.stream().map(AgteleEcoreUtil::getRootEPackage).collect(Collectors.toSet());

		Optional<PAMTraM> pamtramModel = this.pamtramModels.stream().filter(p -> p.getTargetSectionModels().stream()
				.map(TargetSectionModel::getMetaModelPackage).collect(Collectors.toSet()).containsAll(ePackages))
				.findAny();

		JoiningSelectRootElementMappingModelEnhancer enhancer = new JoiningSelectRootElementMappingModelEnhancer(
				pamtramModel.orElseThrow(
						() -> new RuntimeException("Internal error while determining PAMTraM instance to enhance...")));

		AtomicReference<GenericSelectionDialog<EClass>> dialog = new AtomicReference<>(null);

		// As we are not in the UI thread, we have to use a runnable to show the dialog in order to prevent
		// 'InvalidThreadAccess' exceptions
		//
		Display.getDefault().syncExec(() -> {

			dialog.set(new GenericSelectionDialog<>(
					"There was more than one target model element that could not be connected to a root element. Therefore "
							+ "a model root element needs to be created. Please select a fitting class:",
					choices, false, Optional.of(enhancer)));
			dialog.get().create();
			dialog.get().open();
		});

		if (dialog.get().getReturnCode() == IDialogConstants.CANCEL_ID) {
			throw new AmbiguityResolvingException(new UserAbortException().getMessage(), new UserAbortException());
		}
		this.printMessage(dialog.get().getSingleSelection().getName(),
				UserDecisionResolvingStrategy.userDecisionPrefix);
		return new ArrayList<>(Arrays.asList(dialog.get().getSingleSelection()));
	}

	@Override
	public List<ModelConnectionPath> joiningSelectConnectionPath(List<ModelConnectionPath> choices,
			TargetSection section) throws AmbiguityResolvingException {

		Optional<PAMTraM> pamtramModel = this.pamtramModels.stream()
				.filter(p -> p.getTargetSections().contains(section)).findAny();

		JoiningSelectConnectionPathMappingModelEnhancer enhancer = new JoiningSelectConnectionPathMappingModelEnhancer(
				pamtramModel.orElseThrow(
						() -> new RuntimeException("Internal error while determining PAMTraM instance to enhance...")),
				section);

		AtomicReference<GenericSelectionDialog<ModelConnectionPath>> dialog = new AtomicReference<>(null);

		// As we are not in the UI thread, we have to use a runnable to show the dialog in order to prevent
		// 'InvalidThreadAccess' exceptions
		//
		Display.getDefault().syncExec(() -> {

			dialog.set(new GenericSelectionDialog<>(
					"Please choose one of the possible connections for connecting the "
							+ "instances of the target section '" + section.getName() + "' (EClass: '"
							+ section.getEClass().getName() + "') to the model root element of the type '"
							+ choices.get(0).getPathRootClass().getName() + "'.",
					choices, false, Optional.of(enhancer)));
			dialog.get().create();
			dialog.get().open();
		});

		if (dialog.get().getReturnCode() == IDialogConstants.CANCEL_ID) {
			throw new AmbiguityResolvingException(new UserAbortException().getMessage(), new UserAbortException());
		}
		this.printMessage(dialog.get().getSelection().toString(), UserDecisionResolvingStrategy.userDecisionPrefix);
		return new ArrayList<>(Arrays.asList(dialog.get().getSingleSelection()));
	}

	@Override
	public Map<ModelConnectionPath, List<EObjectWrapper>> joiningSelectConnectionPathAndContainerInstance(
			Map<ModelConnectionPath, List<EObjectWrapper>> choices, TargetSection section,
			List<EObjectWrapper> sectionInstances, MappingHintGroupType hintGroup) throws AmbiguityResolvingException {

		Optional<PAMTraM> pamtramModel = this.pamtramModels.stream()
				.filter(p -> p.getTargetSections().contains(section) || EcoreUtil.isAncestor(p.getTargetSectionModels()
						.stream().flatMap(t -> t.getLibraryElements().stream()).collect(Collectors.toList()), section))
				.findAny();

		JoiningSelectConnectionPathAndContainerInstanceMappingModelEnhancer enhancer = new JoiningSelectConnectionPathAndContainerInstanceMappingModelEnhancer(
				pamtramModel.orElseThrow(
						() -> new RuntimeException("Internal error while determining PAMTraM instance to enhance...")),
				section);

		AtomicReference<ClassAndInstanceSelectorDialog<ModelConnectionPath>> dialog = new AtomicReference<>(null);

		// As we are not in the UI thread, we have to use a runnable to show the dialog in order to prevent
		// 'InvalidThreadAccess' exceptions
		//
		Display.getDefault().syncExec(() -> {

			dialog.set(new ClassAndInstanceSelectorDialog<>(sectionInstances.size() + " Instance"
					+ (sectionInstances.size() > 1 ? "s" : "") + " of the TargetSection '" + section.getName()
					+ "', created by the mapping '" + ((Mapping) hintGroup.eContainer()).getName() + " (Group: "
					+ hintGroup.getName() + ")', " + (sectionInstances.size() > 1 ? "have" : "has a") + " root element"
					+ (sectionInstances.size() > 1 ? "s" : "") + " of the type '" + section.getEClass().getName()
					+ "'. " + (sectionInstances.size() > 1 ? "Theese need" : "It needs")
					+ " to be put at a sensible position in the target model. "
					+ "Please choose one of the possible connections to other existing target model elements"
					+ " below.", choices, false, Optional.of(enhancer)));
			dialog.get().create();
			dialog.get().open();
		});

		if (dialog.get().getReturnCode() == IDialogConstants.CANCEL_ID) {
			throw new AmbiguityResolvingException(new UserAbortException().getMessage(), new UserAbortException());
		}

		ModelConnectionPath retPath = dialog.get().getSingleSelection();
		EObjectWrapper retWrapper = dialog.get().getSingleInstance();

		HashMap<ModelConnectionPath, List<EObjectWrapper>> ret = new HashMap<>();
		ret.put(retPath, Arrays.asList(dialog.get().getSingleInstance()));
		this.printMessage(retPath + "-->" + retWrapper.toString(), UserDecisionResolvingStrategy.userDecisionPrefix);

		return ret;

	}

	@Override
	public List<EObjectWrapper> joiningSelectContainerInstance(List<EObjectWrapper> choices,
			List<EObjectWrapper> sectionInstances, MappingHintGroupType hintGroup,
			ContainerSelector modelConnectionHint, String hintValue) throws AmbiguityResolvingException {

		String message;
		if (modelConnectionHint == null) {
			message = "Instances created by the group '" + hintGroup.getName() + " (Mapping :"
					+ ((Mapping) hintGroup.eContainer()).getName()
					+ ")' can be connected to multiple container instances. Please choose under which elements "
					+ (sectionInstances.size() > 1 ? "these " + sectionInstances.size() + " elements"
							: "this " + sectionInstances.size() + "element")
					+ " should be inserted.";
		} else {
			message = "The ModelConnectionHint '" + modelConnectionHint.getName() + " (Mapping :"
					+ ((Mapping) hintGroup.eContainer()).getName() + ", Group: " + hintGroup.getName()
					+ ")' points to a non-unique Attribute. Please choose under which elements "
					+ (sectionInstances.size() > 1 ? "these " + sectionInstances.size() + " elements"
							: "this " + sectionInstances.size() + "element")
					+ " should be inserted.\n\n" + "Attribute value: " + hintValue;
		}

		Optional<PAMTraM> pamtramModel = modelConnectionHint != null
				? this.pamtramModels.stream()
						.filter(p -> p.getTargetSections()
								.contains(modelConnectionHint.getTargetClass().getContainingSection()))
						.findAny()
				: Optional.ofNullable(this.pamtramModels.get(0));

		JoiningSelectContainerInstanceMappingModelEnhancer enhancer = hintGroup instanceof MappingHintGroup
				? new JoiningSelectContainerInstanceMappingModelEnhancer(pamtramModel.orElseThrow(
						() -> new RuntimeException("Internal error while determining PAMTraM instance to enhance...")),
						(MappingHintGroup) hintGroup)
				: null;

		AtomicReference<GenericSelectionDialog<EObjectWrapper>> dialog = new AtomicReference<>(null);

		// As we are not in the UI thread, we have to use a runnable to show the dialog in order to prevent
		// 'InvalidThreadAccess' exceptions
		//
		Display.getDefault().syncExec(() -> {

			dialog.set(new GenericSelectionDialog<>(message, choices, false, Optional.of(enhancer)));
			dialog.get().create();
			dialog.get().open();
		});

		if (dialog.get().getReturnCode() == IDialogConstants.CANCEL_ID) {
			throw new AmbiguityResolvingException(new UserAbortException().getMessage(), new UserAbortException());
		}

		this.printMessage(dialog.get().getSelection().toString(), UserDecisionResolvingStrategy.userDecisionPrefix);
		return Arrays.asList(dialog.get().getSingleSelection());
	}

	@Override
	public List<EObjectWrapper> linkingSelectTargetInstance(List<EObjectWrapper> choices,
			TargetSectionCrossReference reference, MappingHintGroupType hintGroup,
			ReferenceTargetSelector referenceTargetSelector, List<EObjectWrapper> sourceElements)
			throws AmbiguityResolvingException {

		if (sourceElements.isEmpty()) {
			return sourceElements;
		}

		String dialogMessage;
		if (referenceTargetSelector != null) {
			dialogMessage = "The ReferenceTargetSelector '" + referenceTargetSelector.getName() + " of Mapping"
					+ ((Mapping) hintGroup.eContainer()).getName() + "(Group: " + hintGroup.getName()
					+ ")' has a Matcher that points to a target element with more than one instance. "
					+ "Please choose to which element the Reference '" + reference.getName() + "' of the "
					+ (sourceElements.size() == 1
							? "following element should point to:\n\n" + sourceElements.get(0).toString()
							: "affected elements should point to.");
		} else {
			dialogMessage = "There was more than one target element found for the CrossReference '"
					+ reference.getName() + "' of TargetSection "
					+ (hintGroup.getTargetSection().getName().isEmpty() ? hintGroup.getTargetSection().getName()
							: hintGroup.getTargetSection().getEClass().getName())
					+ " in Mapping " + ((Mapping) hintGroup.eContainer()).getName() + " (HintGroup: "
					+ hintGroup.getName() + ") . Please select a target element"
					+ (sourceElements.size() == 1 ? " for the following source:\n" + sourceElements.get(0).toString()
							: ".");
		}

		AtomicReference<GenericSelectionDialog<EObjectWrapper>> dialog = new AtomicReference<>(null);

		// As we are not in the UI thread, we have to use a runnable to show the dialog in order to prevent
		// 'InvalidThreadAccess' exceptions
		//
		Display.getDefault().syncExec(() -> {

			dialog.set(new GenericSelectionDialog<>(dialogMessage, choices, reference.getEReference().isMany(),
					Optional.empty()));
			dialog.get().create();
			dialog.get().open();
		});

		if (dialog.get().getReturnCode() == IDialogConstants.CANCEL_ID) {
			throw new AmbiguityResolvingException(new UserAbortException().getMessage(), new UserAbortException());
		}

		this.printMessage(Arrays.toString(dialog.get().getSelection().toArray()),
				UserDecisionResolvingStrategy.userDecisionPrefix);
		if (reference.getEReference().isMany()) {
			return new ArrayList<>(dialog.get().getSelection());
		} else {
			return Arrays.asList(dialog.get().getSingleSelection());
		}
	}

	@Override
	public Map<TargetSectionClass, List<EObjectWrapper>> linkingSelectTargetSectionAndInstance(
			Map<TargetSectionClass, List<EObjectWrapper>> choices, TargetSectionCrossReference reference,
			MappingHintGroupType hintGroup) throws AmbiguityResolvingException {

		AtomicReference<ClassAndInstanceSelectorDialog<TargetSectionClass>> dialog = new AtomicReference<>(null);

		// As we are not in the UI thread, we have to use a runnable to show the dialog in order to prevent
		// 'InvalidThreadAccess' exceptions
		//
		Display.getDefault().syncExec(() -> {

			dialog.set(new ClassAndInstanceSelectorDialog<TargetSectionClass>(
					"There was more than one target element found for the NonContainmmentReference '"
							+ reference.getName() + "' of TargetMMSection " + hintGroup.getTargetSection().getName()
							+ "(Section: " + hintGroup.getTargetSection().getEClass().getName() + ") in Mapping "
							+ ((Mapping) hintGroup.eContainer()).getName() + "(Group: " + hintGroup.getName() + ") ."
							+ "Please select a target Class and element.",
					choices, reference.getEReference().isMany(), Optional.empty()) {

				@Override
				protected String getStringRepresentation(TargetSectionClass option) {

					return option.getName() + " (Section: " + option.getContainingSection().getName() + ")";
				}
			});
			dialog.get().create();
			dialog.get().open();
		});

		if (dialog.get().getReturnCode() == IDialogConstants.CANCEL_ID) {
			throw new AmbiguityResolvingException(new UserAbortException().getMessage(), new UserAbortException());
		}

		TargetSectionClass retSection = dialog.get().getSingleSelection();

		HashMap<TargetSectionClass, List<EObjectWrapper>> ret = new HashMap<>();
		ret.put(retSection, new ArrayList<>(dialog.get().getInstances()));

		this.printMessage(retSection.getName() + "-->" + Arrays.toString(ret.get(retSection).toArray()),
				UserDecisionResolvingStrategy.userDecisionPrefix);
		return ret;
	}
}
