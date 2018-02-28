package de.mfreund.gentrans.transformation.resolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.mfreund.gentrans.transformation.connecting.ModelConnectionPath;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.resolving.enhancing.InstantiatingSelectAttributeValueMappingModelEnhancer;
import de.mfreund.gentrans.transformation.resolving.enhancing.JoiningSelectConnectionPathAndContainerInstanceMappingModelEnhancer;
import de.mfreund.gentrans.transformation.resolving.enhancing.JoiningSelectConnectionPathMappingModelEnhancer;
import de.mfreund.gentrans.transformation.resolving.enhancing.JoiningSelectContainerInstanceMappingModelEnhancer;
import de.mfreund.gentrans.transformation.resolving.enhancing.JoiningSelectRootElementMappingModelEnhancer;
import de.mfreund.gentrans.transformation.resolving.wizards.DialogFactory;
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

		if (choices == null || choices.isEmpty()) {
			return new ArrayList<>();
		}

		MatchedSectionDescriptor result = DialogFactory.createAndExecuteSearchingSelectSectionDialog(choices, element);

		this.printMessage(result.getAssociatedSourceSection().getName(),
				UserDecisionResolvingStrategy.userDecisionPrefix);

		return Arrays.asList(result);
	}

	@Override
	public List<Mapping> searchingSelectMapping(List<Mapping> choices, EObject element)
			throws AmbiguityResolvingException {

		if (choices == null || choices.isEmpty()) {
			return new ArrayList<>();
		}

		List<Mapping> result = DialogFactory.createAndExecuteSearchingSelectMappingDialog(choices, element);

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

		InstantiatingSelectAttributeValueMappingModelEnhancer enhancer = new InstantiatingSelectAttributeValueMappingModelEnhancer(
				pamtramModel.orElseThrow(
						() -> new RuntimeException("Internal error while determining PAMTraM instance to enhance...")),
				attribute, mappingHintGroup);

		String result = DialogFactory.createAndExecuteInstantiatingSelectAttributeValueDialog(attribute, element,
				mappingHintGroup, Optional.of(enhancer));

		this.printMessage(result, UserDecisionResolvingStrategy.userDecisionPrefix);
		return Arrays.asList(result);
	}

	@Override
	public List<Integer> instantiatingSelectCardinality(List<Integer> choices, TargetSectionClass targetSectionClass,
			InstantiableMappingHintGroup mappingHintGroup) throws AmbiguityResolvingException {

		if (choices == null || choices.isEmpty()) {
			return new ArrayList<>();
		} else if (choices.size() > 1 || choices.get(0) != null || this.skipExpandingAmbiguities) {
			return choices;
		}

		String result = DialogFactory.createAndExecuteInstantiatingSelectCardinalityDialog(targetSectionClass,
				mappingHintGroup, Optional.empty());

		int cardinality = -1;
		if (result != null && !result.isEmpty()) {
			try {
				cardinality = Integer.parseInt(result);

			} catch (NumberFormatException e) {
				throw new AmbiguityResolvingException(
						"Could not parse a valid cardinality (positive integer) from the string '" + result + "'!", e);
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

		EClass result = DialogFactory.createAndExecuteJoiningSelectRootElementDialog(choices, Optional.of(enhancer));

		this.printMessage(result.getName(), UserDecisionResolvingStrategy.userDecisionPrefix);

		return Arrays.asList(result);
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

		ModelConnectionPath result = DialogFactory.createAndExecuteJoiningSelectConnectionPathDialog(choices, section,
				Optional.of(enhancer));

		this.printMessage(result.toString(), UserDecisionResolvingStrategy.userDecisionPrefix);

		return Arrays.asList(result);
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

		Map<ModelConnectionPath, List<EObjectWrapper>> result = DialogFactory
				.createAndExecuteJoiningSelectConnectionPathAndContainerInstanceDialog(choices, hintGroup, sectionInstances,
						Optional.of(enhancer));

		this.printMessage(
				result.keySet().iterator().next() + "-->" + result.values().iterator().next().get(0).toString(),
				UserDecisionResolvingStrategy.userDecisionPrefix);

		return result;

	}

	@Override
	public List<EObjectWrapper> joiningSelectContainerInstance(List<EObjectWrapper> choices,
			List<EObjectWrapper> sectionInstances, MappingHintGroupType hintGroup,
			ContainerSelector modelConnectionHint, String hintValue) throws AmbiguityResolvingException {

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

		EObjectWrapper result = DialogFactory.createAndExecuteJoiningSelectContainerInstanceDialog(choices,
				sectionInstances, hintGroup, Optional.ofNullable(modelConnectionHint), Optional.ofNullable(hintValue),
				Optional.of(enhancer));

		this.printMessage(result.toString(), UserDecisionResolvingStrategy.userDecisionPrefix);
		return Arrays.asList(result);
	}

	@Override
	public List<EObjectWrapper> linkingSelectTargetInstance(List<EObjectWrapper> choices,
			TargetSectionCrossReference reference, MappingHintGroupType hintGroup,
			ReferenceTargetSelector referenceTargetSelector, List<EObjectWrapper> sourceElements)
			throws AmbiguityResolvingException {

		if (sourceElements.isEmpty()) {
			return sourceElements;
		}

		List<EObjectWrapper> result = DialogFactory.createAndExecuteLinkingSelectTargetInstanceDialog(choices,
				reference, hintGroup, Optional.ofNullable(referenceTargetSelector), sourceElements, Optional.empty());

		this.printMessage(Arrays.toString(result.toArray()), UserDecisionResolvingStrategy.userDecisionPrefix);
		return new ArrayList<>(result);
	}

	@Override
	public Map<TargetSectionClass, List<EObjectWrapper>> linkingSelectTargetSectionAndInstance(
			Map<TargetSectionClass, List<EObjectWrapper>> choices, TargetSectionCrossReference reference,
			MappingHintGroupType hintGroup) throws AmbiguityResolvingException {

		Map<TargetSectionClass, List<EObjectWrapper>> result = DialogFactory
				.createAndExecuteLinkingSelectTargetSectionAndInstanceDialog(choices, reference, hintGroup,
						Optional.empty());

		this.printMessage(
				result.keySet().iterator().next().getName() + "-->"
						+ Arrays.toString(result.values().iterator().next().toArray()),
				UserDecisionResolvingStrategy.userDecisionPrefix);
		return result;
	}
}
