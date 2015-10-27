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
import pamtram.metamodel.NonContainmentReference;
import pamtram.metamodel.TargetSection;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionNonContainmentReference;

/**
 * This interface may be implemented to expose a concrete strategy to resolve ambiguities that
 * arise during the execution of a generic transformation.
 * <p />
 * Ambiguities may arise in different situations during the generic transformation (e.g. during the selection
 * of a mapping to be applied or during the selection of a concrete model connection path to be used to connect
 * an element). Each of these situations is represented by a single method that should be overriden by a concrete
 * strategy. Thereby, every method has (at least) one parameter that represents the (ambiguous) options and requires
 * to return a sub-set of these options. If the strategy was able to completely resolve the ambiguities (the choices
 * could be narrowed down to a single one), this sub-set will only contain one single element.
 * <p />
 * <b>Note:</b> A default implementation exists for every method that does not resolve any ambiguities but simply
 * returns a copy of the possible options. This allows for concrete strategies to only implement a strategy for
 * some situations.
 * 
 * @author mfreund
 */
public interface IAmbiguityResolvingStrategy {


	/**
	 * Resolve ambiguities that arise when selecting a {@link Mapping} for a given 'element' in the '<em>matching</em>' step
	 * of the transformation. This method is called when multiple Mappings point to the same {@link Mapping#getSourceMMSection() 
	 * source section}.
	 * 
	 * @param choices The list of applicable {@link Mapping Mappings} for the given 'element'.
	 * @param element The source {@link EObject element} for that a Mapping shall be selected.
	 * @return The list of choices after applying the resolving strategy (this should be a sub-set of '<em>choices</em>').
	 * @throws Exception If an error occured while applying the resolving strategy. 
	 */
	public default List<Mapping> resolveMatchingAmbiguity(
			List<Mapping> choices,
			EObject element) throws Exception {

		List<Mapping> ret = new ArrayList<>();
		if(choices != null) {
			ret.addAll(choices);			
		}
		return ret;
	}

	/**
	 * Resolve ambiguities that arise when selecting the {@link EObjectWrapper container} for a given 'element' during the '<em>joining</em>'
	 * step of the transformation. This method is either called if no {@link ModelConnectionHint} has been defined for the given
	 * 'element' or if the evaluation of the defined ModelConnectionHint delivered multiple possible container elements. 
	 * 
	 * @param choices The list of {@link EObjectWrapper elements} that can be chosen as container element.
	 * @param sectionInstances The list of {@link EObjectWrapper instances} that shall be connected to a container element.
	 * @param hintGroup  The {@link MappingHintGroupType} that was responsible for instantiating the given 'sectionInstances'.
	 * @param modelConnectionHint The {@link ModelConnectionHint} that produced the ambiguous choices. This is '<em><b>null</b></em>' if
	 * no ModelConnectionHint was defined for the given '<em>element</em>'.
	 * @param hintValue The target attribute value that has been calculated by the given 'modelConnectionHint' and that is ambiguous (present in multiple
	 * instances). This is '<em><b>null</b></em>' if the given 'modelConnectionHint' is <em>null</em>.
	 * @return The list of choices after applying the resolving strategy (this should be a sub-set of '<em>choices</em>').
	 * @throws Exception If an error occured while applying the resolving strategy. 
	 */
	public default List<EObjectWrapper> resolveJoiningAmbiguity(
			List<EObjectWrapper> choices, 
			List<EObjectWrapper> sectionInstances,
			MappingHintGroupType hintGroup,
			ModelConnectionHint modelConnectionHint, 
			String hintValue) throws Exception {

		List<EObjectWrapper> ret = new ArrayList<>();
		if(choices != null) {
			ret.addAll(choices);			
		}
		return ret;
	}

	/**
	 * Resolve ambiguities that arise when selecting a common root element for the target model. This method is called when
	 * multiple root elements remain after the '<em>joining</em>' step of the transformation and a common root element
	 * needs to be created.
	 * 
	 * @param choices The list of {@link EClass EClasses} that can be chosen as root element for the target model.
	 * @return The list of choices after applying the resolving strategy (this should be a sub-set of '<em>choices</em>').
	 * @throws Exception If an error occured while applying the resolving strategy.  
	 */
	public default List<EClass> resolveRootElementAmbiguity(
			List<EClass> choices) throws Exception {

		List<EClass> ret = new ArrayList<>();
		if(choices != null) {
			ret.addAll(choices);			
		}
		return ret;
	}

	/**
	 * Resolve ambiguities that arise when selecting a {@link ModelConnectionPath} to connect a {@link TargetSection} to
	 * a certain container {@link EClass} This method is called when multiple possible ModelConnectionPaths have been determined for the given 
	 * 'section' during the '<em>joining</em>' step of the transformation.
	 * 
	 * @param choices The list of {@link ModelConnectionPath ModelConnectionPaths} that can be chosen to connect the given 'section'.
	 * @param section The {@link TargetSection} that shall be connected to a certain {@link EClass} (represented by the 
	 * {@link ModelConnectionPath#getPathRootClass() root class} of every of the given ModelConnectionPaths).
	 * @return The list of choices after applying the resolving strategy (this should be a sub-set of '<em>choices</em>').
	 * @throws Exception If an error occured while applying the resolving strategy.  
	 */
	public default List<ModelConnectionPath> resolveConnectionPathAmbiguity(
			List<ModelConnectionPath> choices, TargetSection section) throws Exception {

		List<ModelConnectionPath> ret = new ArrayList<>();
		if(choices != null) {
			ret.addAll(choices);			
		}
		return ret;
	}

	/**
	 * Resolve ambiguities that arise when selecting a {@link ModelConnectionPath} to connect a {@link TargetSection} to
	 * a certain container {@link EClass} This method is called when multiple possible ModelConnectionPaths have been determined for the given 
	 * 'section' during the '<em>joining</em>' step of the transformation and multiple possible instances of this EClass exist in 
	 * the target model. Consequently, ambiguities have to be resolve both for the ModelConnectionPath to use as well as for the concrete
	 * instance (the concrete model element) to connect to.
	 * 
	 * @param choices A {@link HashMap} that contains the {@link ModelConnectionPath ModelConnectionPaths} and the associated lists of
	 * {@link EObjectWrapper EObjectWrappers} that can be chosen to connect the given 'section'.
	 * @param section The {@link TargetSection} that shall be connected to a certain {@link EClass} (represented by the 
	 * {@link ModelConnectionPath#getPathRootClass() root class} of every of the given ModelConnectionPaths).
	 * @param sectionInstances The list of {@link EObjectWrapper instances} of the given 'section' that need to be connected.
	 * @param hintGroup The {@link MappingHintGroupType} that was responsible for instantiating the given 'sectionInstances'.
	 * @return The {@link HashMap} that contains the choices after applying the resolving strategy.
	 * @throws Exception If an error occured while applying the resolving strategy.  
	 */
	public default HashMap<ModelConnectionPath, List<EObjectWrapper>> resolveConnectionPathAmbiguity(
			HashMap<ModelConnectionPath, List<EObjectWrapper>> choices, TargetSection section, List<EObjectWrapper> sectionInstances, MappingHintGroupType hintGroup) throws Exception {

		HashMap<ModelConnectionPath, List<EObjectWrapper>> ret = new HashMap<>();
		if(choices != null) {
			for (Entry<ModelConnectionPath, List<EObjectWrapper>> entry : choices.entrySet()) {
				ret.put(entry.getKey(), new ArrayList<>(entry.getValue()));
			}
		}
		return ret;
	}

	/**
	 * Resolve ambiguities that arise when selecting the target {@link EObjectWrapper element} for a {@link NonContainmentReference}
	 * during the '<em>linking</em>' step of the transformation. This method is either called if no {@link MappingInstanceSelector} 
	 * has been defined for the the affected reference or if the evaluation of the MappingInstanceSelector's 
	 * {@link MappingInstanceSelector#getMatcher() matcher} delivered multiple possible target elements.
	 * 
	 * @param choices The list of {@link EObjectWrapper elements} that can be chosen as target. 
	 * @param reference The {@link TargetSectionNonContainmentReference} whose target shall be set.
	 * @param hintGroup The {@link MappingHintGroupType} that was responsible for instantiating the given 'sectionInstances'.
	 * @param mappingInstanceSelector The {@link MappingInstanceSelector} that produced the ambiguous choices. This is '<em><b>null</b></em>' if
	 * no MappingInstanceSelector was defined for the given '<em>reference</em>'.
	 * @param sourceElement The {@link EObjectWrapper element} for that the target of the given 'reference' shall be chosen or '<em><b>null</b></em>'
	 * if a target shall be determined for every possible instance.
	 * @return The list of choices after applying the resolving strategy (this should be a sub-set of '<em>choices</em>').
	 * @throws Exception If an error occured while applying the resolving strategy. 
	 */
	public default List<EObjectWrapper> resolveLinkingAmbiguity(
			List<EObjectWrapper> choices,
			TargetSectionNonContainmentReference reference,
			MappingHintGroupType hintGroup,
			MappingInstanceSelector mappingInstanceSelector, EObjectWrapper sourceElement) throws Exception {

		List<EObjectWrapper> ret = new ArrayList<>();
		if(choices != null) {
			ret.addAll(choices);			
		}
		return ret;
	}

	/**
	 * Resolve ambiguities that arise when selecting the target {@link EObjectWrapper element} for a {@link NonContainmentReference}
	 * during the '<em>linking</em>' step of the transformation. This method is only called if no {@link MappingInstanceSelector} 
	 * has been defined and there are multiple possible {@link TargetSection TargetSections} and associated {@link EObjectWrapper instances}. 
	 * 
	 * @param choices  A {@link HashMap} that contains the @ {@link TargetSectionClass TargetSections} and associated lists of 
	 * {@link EObjectWrapper elements} that can be chosen as target. 
	 * @param reference The {@link TargetSectionNonContainmentReference} whose target shall be set.
	 * @param hintGroup The {@link MappingHintGroupType} that was responsible for instantiating the given 'sectionInstances'.
	 * @return The list of choices after applying the resolving strategy (this should be a sub-set of '<em>choices</em>').
	 * @throws Exception If an error occured while applying the resolving strategy. 
	 */
	public default HashMap<TargetSectionClass, List<EObjectWrapper>> resolveLinkingAmbiguity(
			HashMap<TargetSectionClass, List<EObjectWrapper>> choices,
			TargetSectionNonContainmentReference reference,
			MappingHintGroupType hintGroup) throws Exception {

		HashMap<TargetSectionClass, List<EObjectWrapper>> ret = new HashMap<>();
		if(choices != null) {
			for (Entry<TargetSectionClass, List<EObjectWrapper>> entry : choices.entrySet()) {
				ret.put(entry.getKey(), new ArrayList<>(entry.getValue()));
			}
		}
		return ret;
	}
}
