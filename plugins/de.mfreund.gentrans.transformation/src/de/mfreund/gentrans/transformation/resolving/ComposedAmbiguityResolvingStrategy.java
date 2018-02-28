package de.mfreund.gentrans.transformation.resolving;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.connecting.MetaModelPath;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import pamtram.PAMTraM;
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
 * This provides support for composing several {@link IAmbiguityResolvingStrategy IAmbiguityResolvingStrategies}.
 * <p />
 * Any call to a method defined by the {@link IAmbiguityResolvingStrategy} interface iteratively forwards the call to
 * every of the {@link #composedStrategies} and returns the final result.
 *
 * @author mfreund
 */
public class ComposedAmbiguityResolvingStrategy extends AbstractAmbiguityResolvingStrategy
		implements IAmbiguityResolvedAdapter {

	/**
	 * This keeps track of the strategies that this ComposedStrategy composes.
	 */
	protected List<IAmbiguityResolvingStrategy> composedStrategies;

	/**
	 * This creates an instance.
	 *
	 * @param composedStrategies
	 *            The list of {@link IAmbiguityResolvingStrategy strategies} that this composes.
	 */
	public ComposedAmbiguityResolvingStrategy(List<IAmbiguityResolvingStrategy> composedStrategies) {

		this.composedStrategies = composedStrategies;
	}

	/**
	 * This is the getter for the {@link #composedStrategies}.
	 *
	 * @return The list of {@link IAmbiguityResolvingStrategy strategies} that this composes.
	 */
	public List<IAmbiguityResolvingStrategy> getComposedStrategies() {

		return this.composedStrategies;
	}

	/**
	 * This adds a new strategy to end of the list of {@link #composedStrategies}.
	 *
	 * @param strategyToAdd
	 *            The {@link IAmbiguityResolvingStrategy strategy} to add.
	 */
	public void addStrategy(IAmbiguityResolvingStrategy strategyToAdd) {

		this.composedStrategies.add(strategyToAdd);
	}

	/**
	 * Initialize each child strategy.
	 *
	 * @throws AmbiguityResolvingException
	 *             If an error occurs during the initialization.
	 */
	@Override
	public void init(List<PAMTraM> pamtramModels, List<EObject> sourceModels, Logger logger)
			throws AmbiguityResolvingException {

		super.init(pamtramModels, sourceModels, logger);

		this.printMessage("\t--> Init composed stragies:");

		for (IAmbiguityResolvingStrategy strategy : this.composedStrategies) {
			strategy.init(pamtramModels, sourceModels, logger);
		}
	}

	@Override
	public List<MatchedSectionDescriptor> searchingSelectSection(List<MatchedSectionDescriptor> choices,
			EObject element) throws AmbiguityResolvingException {

		List<MatchedSectionDescriptor> ret = new ArrayList<>();
		if (choices != null) {
			ret.addAll(choices);
		}

		if (ret.size() <= 1) {
			return ret;
		}

		for (IAmbiguityResolvingStrategy strategy : this.composedStrategies) {
			ret = strategy.searchingSelectSection(ret, element);
			if (ret == null) {
				return null;
			} else if (ret.size() <= 1) {
				break;
			}
		}

		return ret;
	}

	@Override
	public List<Mapping> searchingSelectMapping(List<Mapping> choices, EObject element)
			throws AmbiguityResolvingException {

		List<Mapping> ret = new ArrayList<>();
		if (choices != null) {
			ret.addAll(choices);
		}

		if (ret.size() <= 1) {
			return ret;
		}

		for (IAmbiguityResolvingStrategy strategy : this.composedStrategies) {
			ret = strategy.searchingSelectMapping(ret, element);
			if (ret == null) {
				return null;
			} else if (ret.size() <= 1) {
				break;
			}
		}

		return ret;
	}

	@Override
	public List<String> instantiatingSelectAttributeValue(List<String> choices, TargetSectionAttribute attribute,
			EObject element, InstantiableMappingHintGroup mappingHintGroup) throws AmbiguityResolvingException {

		List<String> ret = new ArrayList<>();
		if (choices != null) {
			ret.addAll(choices);
		}

		if (ret.isEmpty() || ret.size() == 1 && ret.get(0) != null) {
			return ret;
		}

		for (IAmbiguityResolvingStrategy strategy : this.composedStrategies) {
			ret = strategy.instantiatingSelectAttributeValue(ret, attribute, element, mappingHintGroup);
			if (ret == null) {
				return null;
			} else if (ret.size() <= 1) {
				break;
			}
		}

		return ret;
	}

	@Override
	public List<Integer> instantiatingSelectCardinality(List<Integer> choices, TargetSectionClass targetSectionClass,
			InstantiableMappingHintGroup mappingHintGroup) throws AmbiguityResolvingException {

		List<Integer> ret = new ArrayList<>();
		if (choices != null) {
			ret.addAll(choices);
		}

		if (ret.isEmpty() || ret.size() == 1 && ret.get(0) != null) {
			return ret;
		}

		for (IAmbiguityResolvingStrategy strategy : this.composedStrategies) {
			ret = strategy.instantiatingSelectCardinality(ret, targetSectionClass, mappingHintGroup);
			if (ret == null) {
				return null;
			} else if (ret.size() <= 1) {
				break;
			}
		}

		return ret;
	}

	@Override
	public List<EObjectWrapper> joiningSelectContainerInstance(List<EObjectWrapper> choices,
			List<EObjectWrapper> element, MappingHintGroupType hintGroup, ContainerSelector modelConnectionHint,
			String hintValue) throws AmbiguityResolvingException {

		List<EObjectWrapper> ret = new ArrayList<>();
		if (choices != null) {
			ret.addAll(choices);
		}

		if (ret.size() <= 1) {
			return ret;
		}

		for (IAmbiguityResolvingStrategy strategy : this.composedStrategies) {
			ret = strategy.joiningSelectContainerInstance(ret, element, hintGroup, modelConnectionHint, hintValue);
			if (ret == null) {
				return null;
			} else if (ret.size() <= 1) {
				break;
			}
		}

		return ret;
	}

	@Override
	public List<EObjectWrapper> linkingSelectTargetInstance(List<EObjectWrapper> choices,
			TargetSectionCrossReference reference, MappingHintGroupType hintGroup,
			ReferenceTargetSelector mappingInstanceSelector, List<EObjectWrapper> sourceElements)
			throws AmbiguityResolvingException {

		List<EObjectWrapper> ret = new ArrayList<>();
		if (choices != null) {
			ret.addAll(choices);
		}

		if (ret.size() <= 1 && sourceElements.isEmpty()) {
			return ret;
		}

		for (IAmbiguityResolvingStrategy strategy : this.composedStrategies) {
			ret = strategy.linkingSelectTargetInstance(ret, reference, hintGroup, mappingInstanceSelector,
					sourceElements);
			if (ret == null) {
				return null;
			} else if (ret.size() <= 1) {
				break;
			}
		}

		return ret;
	}

	@Override
	public List<EClass> joiningSelectRootElement(List<EClass> choices) throws AmbiguityResolvingException {

		List<EClass> ret = new ArrayList<>();
		if (choices != null) {
			ret.addAll(choices);
		}

		if (ret.size() <= 1) {
			return ret;
		}

		for (IAmbiguityResolvingStrategy strategy : this.composedStrategies) {
			ret = strategy.joiningSelectRootElement(ret);
			if (ret == null) {
				return null;
			} else if (ret.size() <= 1) {
				break;
			}
		}

		return ret;
	}

	@Override
	public List<MetaModelPath> joiningSelectConnectionPath(List<MetaModelPath> choices,
			TargetSection section) throws AmbiguityResolvingException {

		List<MetaModelPath> ret = new ArrayList<>();
		if (choices != null) {
			ret.addAll(choices);
		}

		if (ret.size() <= 1) {
			return ret;
		}

		for (IAmbiguityResolvingStrategy strategy : this.composedStrategies) {
			ret = strategy.joiningSelectConnectionPath(ret, section);
			if (ret == null) {
				return null;
			} else if (ret.size() <= 1) {
				break;
			}
		}

		return ret;
	}

	@Override
	public Map<MetaModelPath, List<EObjectWrapper>> joiningSelectConnectionPathAndContainerInstance(
			Map<MetaModelPath, List<EObjectWrapper>> choices, TargetSection section,
			List<EObjectWrapper> sectionInstances, MappingHintGroupType hintGroup) throws AmbiguityResolvingException {

		Map<MetaModelPath, List<EObjectWrapper>> ret = new LinkedHashMap<>();
		if (choices != null) {
			for (Entry<MetaModelPath, List<EObjectWrapper>> entry : choices.entrySet()) {
				ret.put(entry.getKey(), new ArrayList<>(entry.getValue()));
			}
		}

		if (ret.entrySet().isEmpty()
				|| ret.entrySet().size() == 1 && ret.entrySet().iterator().next().getValue().size() <= 1) {
			return ret;
		}

		for (IAmbiguityResolvingStrategy strategy : this.composedStrategies) {
			ret = strategy.joiningSelectConnectionPathAndContainerInstance(ret, section, sectionInstances, hintGroup);
			if (ret == null) {
				return null;
			} else if (ret.entrySet().isEmpty()
					|| ret.entrySet().size() == 1 && ret.entrySet().iterator().next().getValue().size() <= 1) {
				break;
			}
		}

		return ret;
	}

	@Override
	public Map<TargetSectionClass, List<EObjectWrapper>> linkingSelectTargetSectionAndInstance(
			Map<TargetSectionClass, List<EObjectWrapper>> choices, TargetSectionCrossReference reference,
			MappingHintGroupType hintGroup) throws AmbiguityResolvingException {

		Map<TargetSectionClass, List<EObjectWrapper>> ret = new LinkedHashMap<>();
		if (choices != null) {
			for (Entry<TargetSectionClass, List<EObjectWrapper>> entry : choices.entrySet()) {
				ret.put(entry.getKey(), new ArrayList<>(entry.getValue()));
			}
		}

		if (ret.entrySet().isEmpty()
				|| ret.entrySet().size() == 1 && ret.entrySet().iterator().next().getValue().size() <= 1) {
			return ret;
		}

		for (IAmbiguityResolvingStrategy strategy : this.composedStrategies) {
			ret = strategy.linkingSelectTargetSectionAndInstance(ret, reference, hintGroup);
			if (ret == null) {
				return null;
			} else if (ret.entrySet().isEmpty()
					|| ret.entrySet().size() == 1 && ret.entrySet().iterator().next().getValue().size() <= 1) {
				break;
			}
		}

		return ret;
	}

	@Override
	public void searchingSectionSelected(List<MatchedSectionDescriptor> choices, MatchedSectionDescriptor resolved) {

		for (IAmbiguityResolvingStrategy strategy : this.composedStrategies) {
			if (strategy instanceof IAmbiguityResolvedAdapter) {
				((IAmbiguityResolvedAdapter) strategy).searchingSectionSelected(choices, resolved);
			}
		}

	}

	@Override
	public void searchingMappingSelected(List<Mapping> choices, List<Mapping> resolved) {

		for (IAmbiguityResolvingStrategy strategy : this.composedStrategies) {
			if (strategy instanceof IAmbiguityResolvedAdapter) {
				((IAmbiguityResolvedAdapter) strategy).searchingMappingSelected(choices, resolved);
			}
		}

	}

	@Override
	public void instantiatingAttributeValueSelected(List<String> choices, String resolved) {

		for (IAmbiguityResolvingStrategy strategy : this.composedStrategies) {
			if (strategy instanceof IAmbiguityResolvedAdapter) {
				((IAmbiguityResolvedAdapter) strategy).instantiatingAttributeValueSelected(choices, resolved);
			}
		}

	}

	@Override
	public void instantiatingCardinalitySelected(List<Integer> choices, Integer resolved) {

		for (IAmbiguityResolvingStrategy strategy : this.composedStrategies) {
			if (strategy instanceof IAmbiguityResolvedAdapter) {
				((IAmbiguityResolvedAdapter) strategy).instantiatingCardinalitySelected(choices, resolved);
			}
		}

	}

	@Override
	public void joiningContainerInstanceSelected(List<EObjectWrapper> choices, EObjectWrapper resolved) {

		for (IAmbiguityResolvingStrategy strategy : this.composedStrategies) {
			if (strategy instanceof IAmbiguityResolvedAdapter) {
				((IAmbiguityResolvedAdapter) strategy).joiningContainerInstanceSelected(choices, resolved);
			}
		}

	}

	@Override
	public void joiningConnectionPathSelected(List<MetaModelPath> choices, MetaModelPath resolved) {

		for (IAmbiguityResolvingStrategy strategy : this.composedStrategies) {
			if (strategy instanceof IAmbiguityResolvedAdapter) {
				((IAmbiguityResolvedAdapter) strategy).joiningConnectionPathSelected(choices, resolved);
			}
		}

	}

	@Override
	public void joiningRootElementSelected(List<EClass> choices, EClass resolved) {

		for (IAmbiguityResolvingStrategy strategy : this.composedStrategies) {
			if (strategy instanceof IAmbiguityResolvedAdapter) {
				((IAmbiguityResolvedAdapter) strategy).joiningRootElementSelected(choices, resolved);
			}
		}

	}

	@Override
	public void linkingTargetInstanceSelected(List<EObjectWrapper> choices, EObjectWrapper resolved) {

		for (IAmbiguityResolvingStrategy strategy : this.composedStrategies) {
			if (strategy instanceof IAmbiguityResolvedAdapter) {
				((IAmbiguityResolvedAdapter) strategy).linkingTargetInstanceSelected(choices, resolved);
			}
		}

	}

	@Override
	public void linkingTargetSectionSelected(List<TargetSectionClass> choices, TargetSectionClass resolved) {

		for (IAmbiguityResolvingStrategy strategy : this.composedStrategies) {
			if (strategy instanceof IAmbiguityResolvedAdapter) {
				((IAmbiguityResolvedAdapter) strategy).linkingTargetSectionSelected(choices, resolved);
			}
		}

	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder(this.getClass().getSimpleName());
		builder.append(" (Sub-Strategies: ");
		builder.append(this.composedStrategies.stream().map(Object::toString).collect(Collectors.joining(", ")));
		builder.append(")");
		return builder.toString();
	}

}
