package de.mfreund.gentrans.transformation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import pamtram.mapping.Mapping;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.ModelConnectionHint;
import pamtram.metamodel.TargetSection;
import pamtram.metamodel.TargetSectionNonContainmentReference;

/**
 * This represents a default implementation of the {@link IAmbiguityResolvingStrategy} interface.
 * <p />
 * Any call to a method defined by the {@link IAmbiguityResolvingStrategy} interface will simply return the first element
 * in the list of choices.
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
	public List<EObjectWrapper> resolveJoiningAmbiguity(List<EObjectWrapper> choices, EObjectWrapper element,
			ModelConnectionHint modelConnectionHint, String hintValue) {

		if(choices == null || choices.size() == 0) {
			return new ArrayList<>();
		} else {
			return new ArrayList<>(Arrays.asList(choices.get(0)));
		}
	}

	@Override
	public List<EObjectWrapper> resolveLinkingAmbiguity(List<EObjectWrapper> choices,
			TargetSectionNonContainmentReference reference, MappingInstanceSelector mappingInstanceSelector,
			EObjectWrapper sourceElement) {

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
}
