package de.mfreund.gentrans.transformation.resolving;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.ModelConnectionPath;
import pamtram.PAMTraM;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.ModelConnectionHint;
import pamtram.metamodel.TargetSection;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionNonContainmentReference;

/**
 * This provides support for composing several {@link IAmbiguityResolvingStrategy IAmbiguityResolvingStrategies}.
 * <p />
 * Any call to a method defined by the {@link IAmbiguityResolvingStrategy} interface iteratively forwards the call to
 * every of the {@link #composedStrategies} and returns the final result. 
 * 
 * @author mfreund
 */
public class ComposedAmbiguityResolvingStrategy extends AbstractAmbiguityResolvingStrategy {

	/**
	 * This keeps track of the strategies that this ComposedStrategy composes.
	 */
	protected ArrayList<IAmbiguityResolvingStrategy> composedStrategies;

	/**
	 * This is the getter for the {@link #composedStrategies}.
	 * @return The list of {@link IAmbiguityResolvingStrategy strategies} that this composes.
	 */
	public ArrayList<IAmbiguityResolvingStrategy> getComposedStrategies() {
		return composedStrategies;
	}

	/**
	 * This adds a new strategy to end of the list of {@link #composedStrategies}. 
	 * @param strategyToAdd The {@link IAmbiguityResolvingStrategy strategy} to add.
	 */
	public void addStrategy(IAmbiguityResolvingStrategy strategyToAdd) {
		composedStrategies.add(strategyToAdd);
	}

	/**
	 * This creates an instance.
	 * 
	 * @param composedStrategies The list of {@link IAmbiguityResolvingStrategy strategies} that this composes.
	 */
	public ComposedAmbiguityResolvingStrategy(ArrayList<IAmbiguityResolvingStrategy> composedStrategies) {
		this.composedStrategies = composedStrategies; 
	}

	/**
	 * Initialize each child strategy.
	 * @throws Exception 
	 */
	@Override
	public void init(PAMTraM pamtramModel, List<EObject> sourceModels, Logger logger)
			throws Exception {

		super.init(pamtramModel, sourceModels, logger);

		printMessage("\t--> Init composed stragies:");

		for (IAmbiguityResolvingStrategy strategy : composedStrategies) {
			strategy.init(pamtramModel, sourceModels, logger);
		}
	}

	@Override
	public List<Mapping> matchingSelectMapping(List<Mapping> choices, EObject element) throws Exception {

		List<Mapping> ret = new ArrayList<>();
		if(choices != null) {
			ret.addAll(choices);			
		}

		if(ret.size() <= 1) {
			return ret;
		}

		for (IAmbiguityResolvingStrategy strategy : composedStrategies) {
			ret = strategy.matchingSelectMapping(ret, element);
			if(ret == null) {
				return null;
			} else if(ret.size() <= 1) {
				break;
			}
		}

		return ret;
	}

	@Override
	public List<String> expandingSelectAttributeValue(List<String> choices, TargetSectionAttribute attribute,
			EObject element) throws Exception {

		List<String> ret = new ArrayList<>();
		if(choices != null) {
			ret.addAll(choices);			
		}

		if(ret.isEmpty() || (ret.size() == 1 && ret.get(0) != null)) {
			return ret;
		}

		for (IAmbiguityResolvingStrategy strategy : composedStrategies) {
			ret = strategy.expandingSelectAttributeValue(ret, attribute, element);
			if(ret == null) {
				return null;
			} else if(ret.size() <= 1) {
				break;
			}
		}

		return ret;
	}

	@Override
	public List<Integer> expandingSelectCardinality(List<Integer> choices, TargetSectionClass targetSectionClass,
			InstantiableMappingHintGroup mappingHintGroup) throws Exception {

		List<Integer> ret = new ArrayList<>();
		if(choices != null) {
			ret.addAll(choices);			
		}

		if(ret.isEmpty() || (ret.size() == 1 && ret.get(0) != null)) {
			return ret;
		}

		for (IAmbiguityResolvingStrategy strategy : composedStrategies) {
			ret = strategy.expandingSelectCardinality(ret, targetSectionClass, mappingHintGroup);
			if(ret == null) {
				return null;
			} else if(ret.size() <= 1) {
				break;
			}
		}

		return ret;
	}

	@Override
	public List<EObjectWrapper> joiningSelectContainerInstance(List<EObjectWrapper> choices, List<EObjectWrapper> element,
			MappingHintGroupType hintGroup, ModelConnectionHint modelConnectionHint, String hintValue) throws Exception {

		List<EObjectWrapper> ret = new ArrayList<>();
		if(choices != null) {
			ret.addAll(choices);			
		}

		if(ret.size() <= 1) {
			return ret;
		}

		for (IAmbiguityResolvingStrategy strategy : composedStrategies) {
			ret = strategy.joiningSelectContainerInstance(ret, element, hintGroup, modelConnectionHint, hintValue);
			if(ret == null) {
				return null;
			} else if(ret.size() <= 1) {
				break;
			}
		}

		return ret;
	}

	@Override
	public List<EObjectWrapper> linkingSelectTargetInstance(List<EObjectWrapper> choices,
			TargetSectionNonContainmentReference reference, MappingHintGroupType hintGroup,
			MappingInstanceSelector mappingInstanceSelector, EObjectWrapper sourceElement) throws Exception {

		List<EObjectWrapper> ret = new ArrayList<>();
		if(choices != null) {
			ret.addAll(choices);			
		}

		if(ret.size() <= 1) {
			return ret;
		}

		for (IAmbiguityResolvingStrategy strategy : composedStrategies) {
			ret = strategy.linkingSelectTargetInstance(ret, reference, hintGroup, mappingInstanceSelector, sourceElement);
			if(ret == null) {
				return null;
			} else if(ret.size() <= 1) {
				break;
			}
		}

		return ret;
	}

	@Override
	public List<EClass> joiningSelectRootElement(List<EClass> choices) throws Exception {

		List<EClass> ret = new ArrayList<>();
		if(choices != null) {
			ret.addAll(choices);			
		}

		if(ret.size() <= 1) {
			return ret;
		}

		for (IAmbiguityResolvingStrategy strategy : composedStrategies) {
			ret = strategy.joiningSelectRootElement(ret);
			if(ret == null) {
				return null;
			} else if(ret.size() <= 1) {
				break;
			}
		}

		return ret;
	}

	@Override
	public List<ModelConnectionPath> joiningSelectConnectionPath(List<ModelConnectionPath> choices,
			TargetSection section) throws Exception {

		List<ModelConnectionPath> ret = new ArrayList<>();
		if(choices != null) {
			ret.addAll(choices);			
		}

		if(ret.size() <= 1) {
			return ret;
		}

		for (IAmbiguityResolvingStrategy strategy : composedStrategies) {
			ret = strategy.joiningSelectConnectionPath(ret, section);
			if(ret == null) {
				return null;
			} else if(ret.size() <= 1) {
				break;
			}
		}

		return ret;
	}

	@Override
	public HashMap<ModelConnectionPath, List<EObjectWrapper>> joiningSelectConnectionPathAndContainerInstance(
			HashMap<ModelConnectionPath, List<EObjectWrapper>> choices, TargetSection section, List<EObjectWrapper> sectionInstances, MappingHintGroupType hintGroup) throws Exception {

		HashMap<ModelConnectionPath, List<EObjectWrapper>> ret = new HashMap<>();
		if(choices != null) {
			for (Entry<ModelConnectionPath, List<EObjectWrapper>> entry : choices.entrySet()) {
				ret.put(entry.getKey(), new ArrayList<>(entry.getValue()));
			}
		}

		if(ret.entrySet().isEmpty() || (ret.entrySet().size() == 1 && ret.entrySet().iterator().next().getValue().size() <= 1)) {
			return ret;
		}

		for (IAmbiguityResolvingStrategy strategy : composedStrategies) {
			ret = strategy.joiningSelectConnectionPathAndContainerInstance(ret, section, sectionInstances, hintGroup);
			if(ret == null) {
				return null;
			} else if(ret.entrySet().isEmpty() || (ret.entrySet().size() == 1 && ret.entrySet().iterator().next().getValue().size() <= 1)) {
				break;
			}
		}

		return ret;
	}

	@Override
	public HashMap<TargetSectionClass, List<EObjectWrapper>> linkingSelectTargetSectionAndInstance(
			HashMap<TargetSectionClass, List<EObjectWrapper>> choices, TargetSectionNonContainmentReference reference,
			MappingHintGroupType hintGroup) throws Exception {

		HashMap<TargetSectionClass, List<EObjectWrapper>> ret = new HashMap<>();
		if(choices != null) {
			for (Entry<TargetSectionClass, List<EObjectWrapper>> entry : choices.entrySet()) {
				ret.put(entry.getKey(), new ArrayList<>(entry.getValue()));
			}
		}

		if(ret.entrySet().isEmpty() || (ret.entrySet().size() == 1 && ret.entrySet().iterator().next().getValue().size() <= 1)) {
			return ret;
		}

		for (IAmbiguityResolvingStrategy strategy : composedStrategies) {
			ret = strategy.linkingSelectTargetSectionAndInstance(ret, reference, hintGroup);
			if(ret == null) {
				return null;
			} else if(ret.entrySet().isEmpty() || (ret.entrySet().size() == 1 && ret.entrySet().iterator().next().getValue().size() <= 1)) {
				break;
			}
		}

		return ret;
	}
}
