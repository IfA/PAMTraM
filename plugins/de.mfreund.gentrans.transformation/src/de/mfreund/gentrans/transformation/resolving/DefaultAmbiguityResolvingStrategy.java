package de.mfreund.gentrans.transformation.resolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.console.MessageConsoleStream;

import de.mfreund.gentrans.transformation.EObjectWrapper;
import de.mfreund.gentrans.transformation.ModelConnectionPath;
import pamtram.PAMTraM;
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
public class DefaultAmbiguityResolvingStrategy extends AbstractAmbiguityResolvingStrategy {

	@Override
	public void init(PAMTraM pamtramModel, ArrayList<EObject> sourceModels, MessageConsoleStream messageStream) {
		return;
	}

	@Override
	public List<Mapping> matchingSelectMapping(List<Mapping> choices, EObject element) {

		if(choices == null || choices.size() == 0) {
			return new ArrayList<>();
		} else {
			return new ArrayList<>(Arrays.asList(choices.get(0)));
		}
	}

	@Override
	public List<EObjectWrapper> joiningSelectContainerInstance(List<EObjectWrapper> choices, List<EObjectWrapper> element,
			MappingHintGroupType hintGroup, ModelConnectionHint modelConnectionHint, String hintValue) {

		if(choices == null || choices.size() == 0) {
			return new ArrayList<>();
		} else {
			return new ArrayList<>(Arrays.asList(choices.get(0)));
		}
	}

	@Override
	public List<EObjectWrapper> linkingSelectTargetInstance(List<EObjectWrapper> choices,
			TargetSectionNonContainmentReference reference, MappingHintGroupType hintGroup,
			MappingInstanceSelector mappingInstanceSelector, EObjectWrapper sourceElement) {

		if(choices == null || choices.size() == 0) {
			return new ArrayList<>();
		} else {
			return new ArrayList<>(Arrays.asList(choices.get(0)));
		}
	}

	@Override
	public List<EClass> joiningSelectRootElement(List<EClass> choices) {

		if(choices == null || choices.size() == 0) {
			return new ArrayList<>();
		} else {
			return new ArrayList<>(Arrays.asList(choices.get(0)));
		}
	}

	@Override
	public List<ModelConnectionPath> joiningSelectConnectionPath(List<ModelConnectionPath> choices,
			TargetSection section) throws Exception {

		if(choices == null || choices.size() == 0) {
			return new ArrayList<>();
		} else {
			return new ArrayList<>(Arrays.asList(choices.get(0)));
		}
	}

	@Override
	public HashMap<ModelConnectionPath, List<EObjectWrapper>> joiningSelectConnectionPathAndContainerInstance(
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
	public HashMap<TargetSectionClass, List<EObjectWrapper>> linkingSelectTargetSectionAndInstance(
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
