package de.mfreund.gentrans.transformation;

import java.util.ArrayList;
import java.util.Arrays;
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
 * This represents a default implementation of the {@link IAmbiguityResolvingStrategy} interface.
 * <p />
 * Any call to a method defined by the {@link IAmbiguityResolvingStrategy} interface will simply return the first element
 * in the list of choices.
 * <p />
 * <b>Note:</b> Making use of this strategy guarantees that all ambiguities will be completely resolved so that only a single option
 * remains for any possible combination of choices.
 * 
 * @author mfreund
 */
public class DefaultAmbiguityResolvingStrategy implements IAmbiguityResolvingStrategy {

	@Override
	public List<Mapping> resolveMatchingAmbiguity(List<Mapping> choices, EObject element) {

		if(choices == null || choices.size() == 0) {
			return new ArrayList<>();
		} else {
			return new ArrayList<>(Arrays.asList(choices.get(0)));
		}
	}

	@Override
	public List<EObjectWrapper> resolveJoiningAmbiguity(List<EObjectWrapper> choices, List<EObjectWrapper> element,
			MappingHintGroupType hintGroup, ModelConnectionHint modelConnectionHint, String hintValue) {

		if(choices == null || choices.size() == 0) {
			return new ArrayList<>();
		} else {
			return new ArrayList<>(Arrays.asList(choices.get(0)));
		}
	}

	@Override
	public List<EObjectWrapper> resolveLinkingAmbiguity(List<EObjectWrapper> choices,
			TargetSectionNonContainmentReference reference, MappingHintGroupType hintGroup,
			MappingInstanceSelector mappingInstanceSelector, EObjectWrapper sourceElement) {

		if(choices == null || choices.size() == 0) {
			return new ArrayList<>();
		} else {
			return new ArrayList<>(Arrays.asList(choices.get(0)));
		}
	}

	@Override
	public List<EClass> resolveRootElementAmbiguity(List<EClass> choices) {

		if(choices == null || choices.size() == 0) {
			return new ArrayList<>();
		} else {
			return new ArrayList<>(Arrays.asList(choices.get(0)));
		}
	}

	@Override
	public List<ModelConnectionPath> resolveConnectionPathAmbiguity(List<ModelConnectionPath> choices,
			TargetSection section) throws Exception {

		if(choices == null || choices.size() == 0) {
			return new ArrayList<>();
		} else {
			return new ArrayList<>(Arrays.asList(choices.get(0)));
		}
	}

	@Override
	public HashMap<ModelConnectionPath, List<EObjectWrapper>> resolveConnectionPathAmbiguity(
			HashMap<ModelConnectionPath, List<EObjectWrapper>> choices, TargetSection section, List<EObjectWrapper> sectionInstances, MappingHintGroupType hintGroup) throws Exception {

		if(choices == null || choices.isEmpty()) {
			return new HashMap<>();
		} else {
			HashMap<ModelConnectionPath, List<EObjectWrapper>> ret = new HashMap<>();
			Entry<ModelConnectionPath, List<EObjectWrapper>> firstEntry = choices.entrySet().iterator().next();
			ArrayList<EObjectWrapper> eObjectList = new ArrayList<>();
			eObjectList.add(firstEntry.getValue().get(0));
			ret.put(firstEntry.getKey(), eObjectList);
			return ret;
		}
	}

	@Override
	public HashMap<TargetSectionClass, List<EObjectWrapper>> resolveLinkingAmbiguity(
			HashMap<TargetSectionClass, List<EObjectWrapper>> choices, TargetSectionNonContainmentReference reference,
			MappingHintGroupType hintGroup) throws Exception {

		if(choices == null || choices.isEmpty()) {
			return new HashMap<>();
		} else {
			HashMap<TargetSectionClass, List<EObjectWrapper>> ret = new HashMap<>();
			Entry<TargetSectionClass, List<EObjectWrapper>> firstEntry = choices.entrySet().iterator().next();
			ArrayList<EObjectWrapper> eObjectList = new ArrayList<>();
			eObjectList.add(firstEntry.getValue().get(0));
			ret.put(firstEntry.getKey(), eObjectList);
			return ret;
		}
	}

}
