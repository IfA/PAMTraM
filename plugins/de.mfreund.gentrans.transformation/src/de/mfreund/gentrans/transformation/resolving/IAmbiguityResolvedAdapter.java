/**
 *
 */
package de.mfreund.gentrans.transformation.resolving;

import java.util.List;

import org.eclipse.emf.ecore.EClass;

import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.descriptors.ModelConnectionPath;
import pamtram.mapping.Mapping;
import pamtram.metamodel.TargetSectionClass;

/**
 * This interface my be implemented to indicate that one is interested in how {@link IAmbiguityResolvingStrategy
 * ambiguities} have been resolved.
 * <p />
 * Ambiguities may arise in different situations during the generic transformation (e.g. during the selection of a
 * mapping to be applied or during the selection of a concrete model connection path to be used to connect an element).
 * Each of these situations is represented by a single method that mimic the corresponding methods from the
 * {@link IAmbiguityResolvingStrategy} interface and that will be called when an ambiguity of the type has been
 * resolved. Thereby, every method has exactly two parameters that represent the (ambiguous) options and the chosen
 * option(s) (a sub-set of the options).
 * <p />
 * <b>Note:</b> The naming scheme of the methods always indicates in which of the four steps of the transformation the
 * ambiguity that was resolved occurred by starting with the step's name.
 *
 * @see IAmbiguityResolvingStrategy
 *
 * @author mfreund
 */
public interface IAmbiguityResolvedAdapter {

	/**
	 * This method is called when a
	 * {@link IAmbiguityResolvingStrategy#searchingSelectSection(List, org.eclipse.emf.ecore.EObject)
	 * searchingSelectSection} ambiguity has been resolved.
	 *
	 * @param choices
	 *            The list of {@link MatchedSectionDescriptor MatchedSectionDescriptors} between which could be chosen.
	 * @param resolved
	 *            The chosen {@link MatchedSectionDescriptor}.
	 */
	public void searchingSectionSelected(List<MatchedSectionDescriptor> choices,
			MatchedSectionDescriptor resolved);

	/**
	 * This method is called when a
	 * {@link IAmbiguityResolvingStrategy#searchingSelectMapping(List, org.eclipse.emf.ecore.EObject)
	 * searchingSelectMapping} ambiguity has been resolved.
	 *
	 * @param choices
	 *            The list of {@link Mapping Mappings} between which could be chosen.
	 * @param resolved
	 *            The chosen {@link Mapping}.
	 */
	public void searchingMappingSelected(List<Mapping> choices, Mapping resolved);

	/**
	 * This method is called when a
	 * {@link IAmbiguityResolvingStrategy#instantiatingSelectAttributeValue(List, pamtram.metamodel.TargetSectionAttribute, org.eclipse.emf.ecore.EObject)
	 * instantiatingSelectAttributeValue} ambiguity has been resolved.
	 *
	 * @param choices
	 *            The list of {@link String Strings} between which could be chosen.
	 * @param resolved
	 *            The chosen {@link String}.
	 */
	public void instantiatingAttributeValueSelected(List<String> choices, String resolved);

	/**
	 * This method is called when a
	 * {@link IAmbiguityResolvingStrategy#instantiatingSelectCardinality(List, pamtram.metamodel.TargetSectionClass, pamtram.mapping.InstantiableMappingHintGroup)
	 * instantiatingSelectCardinality} ambiguity has been resolved.
	 *
	 * @param choices
	 *            The list of {@link Integer Integers} between which could be chosen.
	 * @param resolved
	 *            The chosen {@link Integer}.
	 */
	public void instantiatingCardinalitySelected(List<Integer> choices, Integer resolved);

	/**
	 * This method is called when a
	 * {@link IAmbiguityResolvingStrategy#joiningSelectContainerInstance(List, List, pamtram.mapping.MappingHintGroupType, pamtram.mapping.ContainerSelector, String)
	 * joiningSelectContainerInstance} or
	 * {@link IAmbiguityResolvingStrategy#joiningSelectConnectionPathAndContainerInstance(java.util.Map, pamtram.metamodel.TargetSection, List, pamtram.mapping.MappingHintGroupType)
	 * joiningSelectConnectionPathAndContainerInstance} ambiguity has been resolved.
	 *
	 * @param choices
	 *            The list of {@link EObjectWrapper EObjectWrappers} between which could be chosen.
	 * @param resolved
	 *            The chosen {@link EObjectWrapper}.
	 */
	public void joiningContainerInstanceSelected(List<EObjectWrapper> choices, EObjectWrapper resolved);

	/**
	 * This method is called when a
	 * {@link IAmbiguityResolvingStrategy#joiningSelectConnectionPath(List, pamtram.metamodel.TargetSection)
	 * joiningSelectConnectionPath} or
	 * {@link IAmbiguityResolvingStrategy#joiningSelectConnectionPathAndContainerInstance(java.util.Map, pamtram.metamodel.TargetSection, List, pamtram.mapping.MappingHintGroupType)
	 * joiningSelectConnectionPathAndContainerInstance} ambiguity has been resolved.
	 *
	 * @param choices
	 *            The list of {@link ModelConnectionPath ModelConnectionPaths} between which could be chosen.
	 * @param resolved
	 *            The chosen {@link ModelConnectionPath}.
	 */
	public void joiningConnectionPathSelected(List<ModelConnectionPath> choices, ModelConnectionPath resolved);

	/**
	 * This method is called when a {@link IAmbiguityResolvingStrategy#joiningSelectRootElement(List)
	 * joiningSelectRootElement} ambiguity has been resolved.
	 *
	 * @param choices
	 *            The list of {@link EClass EClasses} between which could be chosen.
	 * @param resolved
	 *            The chosen {@link EClass}.
	 */
	public void joiningRootElementSelected(List<EClass> choices, EClass resolved);

	/**
	 * This method is called when a
	 * {@link IAmbiguityResolvingStrategy#linkingSelectTargetInstance(List, pamtram.metamodel.TargetSectionNonContainmentReference, pamtram.mapping.MappingHintGroupType, pamtram.mapping.ReferenceTargetSelector, EObjectWrapper)
	 * linkingSelectTargetInstance} or
	 * {@link IAmbiguityResolvingStrategy#linkingSelectTargetSectionAndInstance(java.util.Map, pamtram.metamodel.TargetSectionNonContainmentReference, pamtram.mapping.MappingHintGroupType)
	 * linkingSelectTargetSectionAndInstance} ambiguity has been resolved.
	 *
	 * @param choices
	 *            The list of {@link EObjectWrapper EObjectWrappers} between which could be chosen.
	 * @param resolved
	 *            The chosen {@link EObjectWrapper}.
	 */
	public void linkingTargetInstanceSelected(List<EObjectWrapper> choices, EObjectWrapper resolved);

	/**
	 * This method is called when a
	 * {@link IAmbiguityResolvingStrategy#linkingSelectTargetSectionAndInstance(java.util.Map, pamtram.metamodel.TargetSectionNonContainmentReference, pamtram.mapping.MappingHintGroupType)
	 * linkingSelectTargetSectionAndInstance} ambiguity has been resolved.
	 *
	 * @param choices
	 *            The list of {@link TargetSectionClass TargetSectionClasses} between which could be chosen.
	 * @param resolved
	 *            The chosen {@link TargetSectionClass}.
	 */
	public void linkingTargetSectionSelected(List<TargetSectionClass> choices, TargetSectionClass resolved);

}
