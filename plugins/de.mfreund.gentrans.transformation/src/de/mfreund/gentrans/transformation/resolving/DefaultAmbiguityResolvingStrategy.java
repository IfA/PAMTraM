package de.mfreund.gentrans.transformation.resolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.descriptors.ModelConnectionPath;
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
 * This represents a default implementation of the {@link IAmbiguityResolvingStrategy} interface.
 * <p />
 * Any call to a method defined by the {@link IAmbiguityResolvingStrategy} interface will simply return the first
 * element in the list of choices.
 * <p />
 * <b>Note:</b> Making use of this strategy guarantees that all ambiguities will be completely resolved so that only a
 * single option remains for any possible combination of choices.
 *
 * @author mfreund
 */
public class DefaultAmbiguityResolvingStrategy extends AbstractAmbiguityResolvingStrategy {

	@Override
	public List<MatchedSectionDescriptor> searchingSelectSection(List<MatchedSectionDescriptor> choices,
			EObject element) throws AmbiguityResolvingException {

		if (choices == null || choices.isEmpty()) {
			return new ArrayList<>();
		} else {
			return new ArrayList<>(Arrays.asList(choices.get(0)));
		}
	}

	@Override
	public List<Mapping> searchingSelectMapping(List<Mapping> choices, EObject element) {

		if (choices == null || choices.isEmpty()) {
			return new ArrayList<>();
		} else {
			return new ArrayList<>(choices);
		}
	}

	@Override
	public List<String> instantiatingSelectAttributeValue(List<String> choices, TargetSectionAttribute attribute,
			EObject element, InstantiableMappingHintGroup mappingHintGroup) {

		if (choices == null || choices.isEmpty()) {
			return new ArrayList<>();
		} else {
			return new ArrayList<>(Arrays.asList(choices.get(0)));
		}
	}

	@Override
	public List<Integer> instantiatingSelectCardinality(List<Integer> choices, TargetSectionClass targetSectionClass,
			InstantiableMappingHintGroup mappingHintGroup) throws AmbiguityResolvingException {

		if (choices == null || choices.isEmpty()) {
			return new ArrayList<>();
		} else {
			return new ArrayList<>(Arrays.asList(choices.get(0)));
		}
	}

	@Override
	public List<EObjectWrapper> joiningSelectContainerInstance(List<EObjectWrapper> choices,
			List<EObjectWrapper> element, MappingHintGroupType hintGroup, ContainerSelector modelConnectionHint,
			String hintValue) {

		if (choices == null || choices.isEmpty()) {
			return new ArrayList<>();
		} else {
			return new ArrayList<>(Arrays.asList(choices.get(0)));
		}
	}

	@Override
	public List<EClass> joiningSelectRootElement(List<EClass> choices) {

		if (choices == null || choices.isEmpty()) {
			return new ArrayList<>();
		} else {
			return new ArrayList<>(Arrays.asList(choices.get(0)));
		}
	}

	@Override
	public List<ModelConnectionPath> joiningSelectConnectionPath(List<ModelConnectionPath> choices,
			TargetSection section) throws AmbiguityResolvingException {

		if (choices == null || choices.isEmpty()) {
			return new ArrayList<>();
		} else {
			return new ArrayList<>(Arrays.asList(choices.get(0)));
		}
	}

	@Override
	public Map<ModelConnectionPath, List<EObjectWrapper>> joiningSelectConnectionPathAndContainerInstance(
			Map<ModelConnectionPath, List<EObjectWrapper>> choices, TargetSection section,
			List<EObjectWrapper> sectionInstances, MappingHintGroupType hintGroup) throws AmbiguityResolvingException {

		if (choices == null || choices.isEmpty()) {
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
	public List<EObjectWrapper> linkingSelectTargetInstance(List<EObjectWrapper> choices,
			TargetSectionCrossReference reference, MappingHintGroupType hintGroup,
			ReferenceTargetSelector mappingInstanceSelector, EObjectWrapper sourceElement) {

		if (choices == null || choices.isEmpty()) {
			return new ArrayList<>();
		} else {
			if (reference.getEReference().isMany()) {
				return choices;
			} else {
				return new ArrayList<>(Arrays.asList(choices.get(0)));
			}
		}
	}

	@Override
	public Map<TargetSectionClass, List<EObjectWrapper>> linkingSelectTargetSectionAndInstance(
			Map<TargetSectionClass, List<EObjectWrapper>> choices, TargetSectionCrossReference reference,
			MappingHintGroupType hintGroup) throws AmbiguityResolvingException {

		if (choices == null || choices.isEmpty()) {
			return new HashMap<>();
		} else {
			HashMap<TargetSectionClass, List<EObjectWrapper>> ret = new HashMap<>();
			Entry<TargetSectionClass, List<EObjectWrapper>> firstEntry = choices.entrySet().iterator().next();
			if (reference.getEReference().isMany()) {
				ret.put(firstEntry.getKey(), firstEntry.getValue());
			} else {
				ArrayList<EObjectWrapper> eObjectList = new ArrayList<>();
				eObjectList.add(firstEntry.getValue().get(0));
				ret.put(firstEntry.getKey(), eObjectList);
			}
			return ret;
		}
	}

}
