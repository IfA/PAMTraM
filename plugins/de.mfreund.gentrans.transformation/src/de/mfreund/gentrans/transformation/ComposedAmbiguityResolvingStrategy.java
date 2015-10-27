package de.mfreund.gentrans.transformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.ModelConnectionHint;
import pamtram.metamodel.TargetSection;
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
public class ComposedAmbiguityResolvingStrategy implements IAmbiguityResolvingStrategy {

	/**
	 * This keeps track of the strategies that this ComposedStrategy composes.
	 */
	private ArrayList<IAmbiguityResolvingStrategy> composedStrategies;

	/**
	 * This creates an instance.
	 * 
	 * @param composedStrategies The list of {@link IAmbiguityResolvingStrategy strategies} that this composes.
	 */
	public ComposedAmbiguityResolvingStrategy(ArrayList<IAmbiguityResolvingStrategy> composedStrategies) {
		this.composedStrategies = composedStrategies; 
	}

	@Override
	public List<Mapping> resolveMatchingAmbiguity(List<Mapping> choices, EObject element) throws Exception {

		List<Mapping> ret = new ArrayList<>();
		if(choices != null) {
			ret.addAll(choices);			
		}

		if(ret.size() <= 1) {
			return ret;
		}

		for (IAmbiguityResolvingStrategy strategy : composedStrategies) {
			ret = strategy.resolveMatchingAmbiguity(ret, element);
			if(ret == null) {
				return null;
			} else if(ret.size() <= 1) {
				break;
			}
		}

		return ret;
	}

	@Override
	public List<EObjectWrapper> resolveJoiningAmbiguity(List<EObjectWrapper> choices, List<EObjectWrapper> element,
			MappingHintGroupType hintGroup, ModelConnectionHint modelConnectionHint, String hintValue) throws Exception {

		List<EObjectWrapper> ret = new ArrayList<>();
		if(choices != null) {
			ret.addAll(choices);			
		}

		if(ret.size() <= 1) {
			return ret;
		}

		for (IAmbiguityResolvingStrategy strategy : composedStrategies) {
			ret = strategy.resolveJoiningAmbiguity(ret, element, hintGroup, modelConnectionHint, hintValue);
			if(ret == null) {
				return null;
			} else if(ret.size() <= 1) {
				break;
			}
		}

		return ret;
	}

	@Override
	public List<EObjectWrapper> resolveLinkingAmbiguity(List<EObjectWrapper> choices,
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
			ret = strategy.resolveLinkingAmbiguity(ret, reference, hintGroup, mappingInstanceSelector, sourceElement);
			if(ret == null) {
				return null;
			} else if(ret.size() <= 1) {
				break;
			}
		}

		return ret;
	}

	@Override
	public List<EClass> resolveRootElementAmbiguity(List<EClass> choices) throws Exception {

		List<EClass> ret = new ArrayList<>();
		if(choices != null) {
			ret.addAll(choices);			
		}

		if(ret.size() <= 1) {
			return ret;
		}

		for (IAmbiguityResolvingStrategy strategy : composedStrategies) {
			ret = strategy.resolveRootElementAmbiguity(ret);
			if(ret == null) {
				return null;
			} else if(ret.size() <= 1) {
				break;
			}
		}

		return ret;
	}

	@Override
	public List<ModelConnectionPath> resolveConnectionPathAmbiguity(List<ModelConnectionPath> choices,
			TargetSection section) throws Exception {

		List<ModelConnectionPath> ret = new ArrayList<>();
		if(choices != null) {
			ret.addAll(choices);			
		}

		if(ret.size() <= 1) {
			return ret;
		}

		for (IAmbiguityResolvingStrategy strategy : composedStrategies) {
			ret = strategy.resolveConnectionPathAmbiguity(ret, section);
			if(ret == null) {
				return null;
			} else if(ret.size() <= 1) {
				break;
			}
		}

		return ret;
	}

	@Override
	public HashMap<ModelConnectionPath, List<EObjectWrapper>> resolveConnectionPathAmbiguity(
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
			ret = strategy.resolveConnectionPathAmbiguity(ret, section, sectionInstances, hintGroup);
			if(ret == null) {
				return null;
			} else if(ret.entrySet().isEmpty() || (ret.entrySet().size() == 1 && ret.entrySet().iterator().next().getValue().size() <= 1)) {
				break;
			}
		}

		return ret;
	}

	@Override
	public HashMap<TargetSectionClass, List<EObjectWrapper>> resolveLinkingAmbiguity(
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
			ret = strategy.resolveLinkingAmbiguity(ret, reference, hintGroup);
			if(ret == null) {
				return null;
			} else if(ret.entrySet().isEmpty() || (ret.entrySet().size() == 1 && ret.entrySet().iterator().next().getValue().size() <= 1)) {
				break;
			}
		}

		return ret;
	}
}
