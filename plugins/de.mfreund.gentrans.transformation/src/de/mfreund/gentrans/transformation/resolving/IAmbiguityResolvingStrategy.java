package de.mfreund.gentrans.transformation.resolving;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.descriptors.ModelConnectionPath;
import pamtram.PAMTraM;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.extended.AttributeMapping;
import pamtram.mapping.extended.CardinalityMapping;
import pamtram.mapping.extended.ContainerSelector;
import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.structure.generic.CrossReference;
import pamtram.structure.source.SourceSection;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionCrossReference;

/**
 * This interface may be implemented to expose a concrete strategy to resolve ambiguities that arise during the
 * execution of a generic transformation. Instead of directly implementing this interface, clients should consider
 * extending {@link AbstractAmbiguityResolvingStrategy}.
 * <p />
 * Ambiguities may arise in different situations during the generic transformation (e.g. during the selection of a
 * mapping to be applied or during the selection of a concrete model connection path to be used to connect an element).
 * Each of these situations is represented by a single method that should be overriden by a concrete strategy. Thereby,
 * every method has (at least) one parameter that represents the (ambiguous) options and requires to return a sub-set of
 * these options. If the strategy was able to completely resolve the ambiguities (the choices could be narrowed down to
 * a single one), this sub-set will only contain one single element.
 * <p />
 * <b>Note:</b> The naming scheme of the methods always indicates in which of the four steps of the transformation the
 * ambiguity that needs to be resolved occurs by starting with the step's name. For example, ambiguities that need to be
 * resolved in the method {@link #searchingSelectMapping(List, EObject)} occur in the '<em>matching</em>' step of the
 * transformation. <br />
 * <b>Note:</b> A default implementation exists for every method that does not resolve any ambiguities but simply
 * returns a copy of the possible options. This allows for concrete strategies to only implement a strategy for some
 * situations.
 *
 * @author mfreund
 */
public interface IAmbiguityResolvingStrategy {

	/**
	 * Initialize the strategy.
	 *
	 * @param pamtramModels
	 *            The {@link PAMTraM} instances that the current transformation operate on.
	 * @param sourceModels
	 *            The list of {@link EObject sourceModels} that serve as input to the current transformation.
	 * @param logger
	 *            A {@link Logger} that can be used to print messages.
	 * @throws AmbiguityResolvingException
	 *             If an error occurs during the initialization of the strategy.
	 */
	public default void init(List<PAMTraM> pamtramModels, List<EObject> sourceModels, Logger logger)
			throws AmbiguityResolvingException {

		return;
	}

	/**
	 * Resolve ambiguities that arise when selecting a {@link SourceSection} for a given 'element' in the
	 * '<em>searching</em>' step of the transformation. This method is called when multiple {@link SourceSection
	 * SourceSections} could be matched and cover the same number of elements from the source model.
	 *
	 * @param choices
	 *            The list of {@link MatchedSectionDescriptor MatchedSectionDescriptors} representing the various
	 *            {@link SourceSection SourceSections} that were matched.
	 * @param element
	 *            The source {@link EObject element} for that the SourceSection shall be selected.
	 * @return The list of choices after applying the resolving strategy (this should be a sub-set of
	 *         '<em>choices</em>').
	 * @throws AmbiguityResolvingException
	 *             If an error occurred while applying the resolving strategy.
	 */
	public default List<MatchedSectionDescriptor> searchingSelectSection(List<MatchedSectionDescriptor> choices,
			EObject element) throws AmbiguityResolvingException {

		List<MatchedSectionDescriptor> ret = new ArrayList<>();
		if (choices != null) {
			ret.addAll(choices);
		}
		return ret;
	}

	/**
	 * Resolve ambiguities that arise when selecting a {@link Mapping} for a given 'element' in the '<em>searching</em>'
	 * step of the transformation. This method is called when multiple Mappings point to the same
	 * {@link Mapping#getSourceSection() source section}.
	 *
	 * @param choices
	 *            The list of applicable {@link Mapping Mappings} for the given 'element'.
	 * @param element
	 *            The source {@link EObject element} for that a Mapping shall be selected.
	 * @return The list of choices after applying the resolving strategy (this should be a sub-set of
	 *         '<em>choices</em>').
	 * @throws AmbiguityResolvingException
	 *             If an error occurred while applying the resolving strategy.
	 */
	public default List<Mapping> searchingSelectMapping(List<Mapping> choices, EObject element)
			throws AmbiguityResolvingException {

		List<Mapping> ret = new ArrayList<>();
		if (choices != null) {
			ret.addAll(choices);
		}
		return ret;
	}

	/**
	 * Resolve ambiguities that arise when specifying an attribute value for a given 'element' in the
	 * '<em>instantiating</em>' step of the transformation. This method is called when no {@link AttributeMapping} was
	 * specified (resp. the specified mapping did not return any hint values).
	 *
	 * @param choices
	 *            The list of possible values for the given 'element'. If the list only contains one entry that is
	 *            'null', it means that all values as specified by the attribte's {@link EAttribute#getEAttributeType()
	 *            DataType} are possible.
	 * @param attribute
	 *            The {@link TargetSectionAttribute} for that the value shall be selected.
	 * @param element
	 *            The source {@link EObject element} for that the attribute value shall be determined.
	 * @param mappingHintGroup
	 *            The {@link InstantiableMappingHintGroup mapping hint group} based on which the attribute was created.
	 * @return The list of choices after applying the resolving strategy (this should be a sub-set of
	 *         '<em>choices</em>').
	 * @throws AmbiguityResolvingException
	 *             If an error occurred while applying the resolving strategy.
	 */
	public default List<String> instantiatingSelectAttributeValue(List<String> choices,
			TargetSectionAttribute attribute, EObject element, InstantiableMappingHintGroup mappingHintGroup)
			throws AmbiguityResolvingException {

		List<String> ret = new ArrayList<>();
		if (choices != null) {
			ret.addAll(choices);
		}
		return ret;
	}

	/**
	 * Resolve ambiguities that arise when specifying the cardinality for a given 'targetSectionClass' in the
	 * '<em>instantiating</em>' step of the transformation. This method is called when no hint values from an
	 * {@link AttributeMapping} or {@link CardinalityMapping} could be used to determine the cardinality.
	 *
	 * @param choices
	 *            The list of possible values for the given 'targetSectionClass'. If the list only contains one entry
	 *            that is 'null', it means the default cardinality as specified by the lower bound of the
	 *            {@link TargetSectionClass#getCardinality()} shall be used.
	 * @param targetSectionClass
	 *            The {@link TargetSectionClass} for that the cardinality shall be selected.
	 * @param mappingHintGroup
	 *            The {@link InstantiableMappingHintGroup} that is responsible for the instantiation of the target
	 *            section.
	 * @return The list of choices after applying the resolving strategy (this should be a sub-set of
	 *         '<em>choices</em>').
	 * @throws AmbiguityResolvingException
	 *             If an error occurred while applying the resolving strategy.
	 */
	public default List<Integer> instantiatingSelectCardinality(List<Integer> choices,
			TargetSectionClass targetSectionClass, InstantiableMappingHintGroup mappingHintGroup)
			throws AmbiguityResolvingException {

		List<Integer> ret = new ArrayList<>();
		if (choices != null) {
			ret.addAll(choices);
		}
		return ret;
	}

	/**
	 * Resolve ambiguities that arise when selecting the {@link EObjectWrapper container} for a given 'element' during
	 * the '<em>joining</em>' step of the transformation. This method is either called if no {@link ContainerSelector}
	 * has been defined for the given 'element' or if the evaluation of the defined ModelConnectionHint delivered
	 * multiple possible container elements.
	 *
	 * @param choices
	 *            The list of {@link EObjectWrapper elements} that can be chosen as container element.
	 * @param sectionInstances
	 *            The list of {@link EObjectWrapper instances} that shall be connected to a container element.
	 * @param hintGroup
	 *            The {@link MappingHintGroupType} that was responsible for instantiating the given 'sectionInstances'.
	 * @param modelConnectionHint
	 *            The {@link ContainerSelector} that produced the ambiguous choices. This is '<em><b>null</b></em>' if
	 *            no ModelConnectionHint was defined for the given '<em>element</em>'.
	 * @param hintValue
	 *            The target attribute value that has been calculated by the given 'modelConnectionHint' and that is
	 *            ambiguous (present in multiple instances). This is '<em><b>null</b></em>' if the given
	 *            'modelConnectionHint' is <em>null</em>.
	 * @return The list of choices after applying the resolving strategy (this should be a sub-set of
	 *         '<em>choices</em>').
	 * @throws AmbiguityResolvingException
	 *             If an error occurred while applying the resolving strategy.
	 */
	public default List<EObjectWrapper> joiningSelectContainerInstance(List<EObjectWrapper> choices,
			List<EObjectWrapper> sectionInstances, MappingHintGroupType hintGroup,
			ContainerSelector modelConnectionHint, String hintValue) throws AmbiguityResolvingException {

		List<EObjectWrapper> ret = new ArrayList<>();
		if (choices != null) {
			ret.addAll(choices);
		}
		return ret;
	}

	/**
	 * Resolve ambiguities that arise when selecting a {@link ModelConnectionPath} to connect a {@link TargetSection} to
	 * a certain container {@link EClass} This method is called when multiple possible ModelConnectionPaths have been
	 * determined for the given 'section' during the '<em>joining</em>' step of the transformation.
	 *
	 * @param choices
	 *            The list of {@link ModelConnectionPath ModelConnectionPaths} that can be chosen to connect the given
	 *            'section'.
	 * @param section
	 *            The {@link TargetSection} that shall be connected to a certain {@link EClass} (represented by the
	 *            {@link ModelConnectionPath#getPathRootClass() root class} of every of the given ModelConnectionPaths).
	 * @return The list of choices after applying the resolving strategy (this should be a sub-set of
	 *         '<em>choices</em>').
	 * @throws AmbiguityResolvingException
	 *             If an error occurred while applying the resolving strategy.
	 */
	public default List<ModelConnectionPath> joiningSelectConnectionPath(List<ModelConnectionPath> choices,
			TargetSection section) throws AmbiguityResolvingException {

		List<ModelConnectionPath> ret = new ArrayList<>();
		if (choices != null) {
			ret.addAll(choices);
		}
		return ret;
	}

	/**
	 * Resolve ambiguities that arise when selecting a {@link ModelConnectionPath} to connect a {@link TargetSection} to
	 * a certain container {@link EClass} This method is called when multiple possible ModelConnectionPaths have been
	 * determined for the given 'section' during the '<em>joining</em>' step of the transformation and multiple possible
	 * instances of this EClass exist in the target model. Consequently, ambiguities have to be resolve both for the
	 * ModelConnectionPath to use as well as for the concrete instance (the concrete model element) to connect to.
	 *
	 * @param choices
	 *            A {@link HashMap} that contains the {@link ModelConnectionPath ModelConnectionPaths} and the
	 *            associated lists of {@link EObjectWrapper EObjectWrappers} that can be chosen to connect the given
	 *            'section'.
	 * @param section
	 *            The {@link TargetSection} that shall be connected to a certain {@link EClass} (represented by the
	 *            {@link ModelConnectionPath#getPathRootClass() root class} of every of the given ModelConnectionPaths).
	 * @param sectionInstances
	 *            The list of {@link EObjectWrapper instances} of the given 'section' that need to be connected.
	 * @param hintGroup
	 *            The {@link MappingHintGroupType} that was responsible for instantiating the given 'sectionInstances'.
	 * @return The {@link HashMap} that contains the choices after applying the resolving strategy.
	 * @throws AmbiguityResolvingException
	 *             If an error occurred while applying the resolving strategy.
	 */
	public default Map<ModelConnectionPath, List<EObjectWrapper>> joiningSelectConnectionPathAndContainerInstance(
			Map<ModelConnectionPath, List<EObjectWrapper>> choices, TargetSection section,
			List<EObjectWrapper> sectionInstances, MappingHintGroupType hintGroup) throws AmbiguityResolvingException {

		Map<ModelConnectionPath, List<EObjectWrapper>> ret = new LinkedHashMap<>();
		if (choices != null) {
			for (Entry<ModelConnectionPath, List<EObjectWrapper>> entry : choices.entrySet()) {
				ret.put(entry.getKey(), new ArrayList<>(entry.getValue()));
			}
		}
		return ret;
	}

	/**
	 * Resolve ambiguities that arise when selecting a common root element for the target model. This method is called
	 * when multiple root elements remain after the '<em>joining</em>' step of the transformation and a common root
	 * element needs to be created.
	 *
	 * @param choices
	 *            The list of {@link EClass EClasses} that can be chosen as root element for the target model.
	 * @return The list of choices after applying the resolving strategy (this should be a sub-set of
	 *         '<em>choices</em>').
	 * @throws AmbiguityResolvingException
	 *             If an error occurred while applying the resolving strategy.
	 */
	public default List<EClass> joiningSelectRootElement(List<EClass> choices) throws AmbiguityResolvingException {

		List<EClass> ret = new ArrayList<>();
		if (choices != null) {
			ret.addAll(choices);
		}
		return ret;
	}

	/**
	 * Resolve ambiguities that arise when selecting the target {@link EObjectWrapper element} for a
	 * {@link CrossReference} during the '<em>linking</em>' step of the transformation. This method is either called if
	 * no {@link ReferenceTargetSelector} has been defined for the affected reference or if the evaluation of the
	 * MappingInstanceSelector's {@link ReferenceTargetSelector#getMatcher() matcher} delivered multiple possible target
	 * elements.
	 *
	 * @param choices
	 *            The list of {@link EObjectWrapper elements} that can be chosen as target.
	 * @param reference
	 *            The {@link TargetSectionCrossReference} whose target shall be set.
	 * @param hintGroup
	 *            The {@link MappingHintGroupType} that was responsible for instantiating the given 'sectionInstances'.
	 * @param mappingInstanceSelector
	 *            The {@link ReferenceTargetSelector} that produced the ambiguous choices. This is
	 *            '<em><b>null</b></em>' if no MappingInstanceSelector was defined for the given '<em>reference</em>'.
	 * @param sourceElements
	 *            The list of {@link EObjectWrapper elements} for that the target of the given 'reference' shall be
	 *            chosen.
	 * @return The list of choices after applying the resolving strategy (this should be a sub-set of
	 *         '<em>choices</em>').
	 * @throws AmbiguityResolvingException
	 *             If an error occurred while applying the resolving strategy.
	 */
	public default List<EObjectWrapper> linkingSelectTargetInstance(List<EObjectWrapper> choices,
			TargetSectionCrossReference reference, MappingHintGroupType hintGroup,
			ReferenceTargetSelector mappingInstanceSelector, List<EObjectWrapper> sourceElements)
			throws AmbiguityResolvingException {

		List<EObjectWrapper> ret = new ArrayList<>();
		if (choices != null) {
			ret.addAll(choices);
		}
		return ret;
	}

	/**
	 * Resolve ambiguities that arise when selecting the target {@link EObjectWrapper element} for a
	 * {@link CrossReference} during the '<em>linking</em>' step of the transformation. This method is only called if no
	 * {@link ReferenceTargetSelector} has been defined and there are multiple possible {@link TargetSection
	 * TargetSections} and associated {@link EObjectWrapper instances}.
	 *
	 * @param choices
	 *            A {@link HashMap} that contains the @ {@link TargetSectionClass TargetSections} and associated lists
	 *            of {@link EObjectWrapper elements} that can be chosen as target.
	 * @param reference
	 *            The {@link TargetSectionCrossReference} whose target shall be set.
	 * @param hintGroup
	 *            The {@link MappingHintGroupType} that was responsible for instantiating the given 'sectionInstances'.
	 * @return The list of choices after applying the resolving strategy (this should be a sub-set of
	 *         '<em>choices</em>').
	 * @throws AmbiguityResolvingException
	 *             If an error occurred while applying the resolving strategy.
	 */
	public default Map<TargetSectionClass, List<EObjectWrapper>> linkingSelectTargetSectionAndInstance(
			Map<TargetSectionClass, List<EObjectWrapper>> choices, TargetSectionCrossReference reference,
			MappingHintGroupType hintGroup) throws AmbiguityResolvingException {

		Map<TargetSectionClass, List<EObjectWrapper>> ret = new LinkedHashMap<>();
		if (choices != null) {
			for (Entry<TargetSectionClass, List<EObjectWrapper>> entry : choices.entrySet()) {
				ret.put(entry.getKey(), new ArrayList<>(entry.getValue()));
			}
		}
		return ret;
	}

	/**
	 * Thrown to indicate that an error occurred while trying to resolve an ambiguity.
	 *
	 * @author mfreund
	 */
	public class AmbiguityResolvingException extends Exception {

		/**
		 *
		 */
		private static final long serialVersionUID = -8603040781677025923L;

		/**
		 * Constructs a new exception.
		 */
		public AmbiguityResolvingException() {

			super();
		}

		/**
		 * Constructs a new exception with the specified detail message.
		 *
		 * @param message
		 *            The detail message.
		 */
		public AmbiguityResolvingException(String message) {

			super(message);
		}

		/**
		 * Constructs a new exception with the specified cause and a detail message of (cause==null ? null :
		 * cause.toString()) (which typically contains the class and detail message of cause).
		 *
		 * @param cause
		 *            The {@link Throwable} that caused the exception.
		 */
		public AmbiguityResolvingException(Throwable cause) {

			super(cause);
		}

		/**
		 * Constructs a new exception with the specified detail message and cause.
		 *
		 * @param message
		 *            The detail message.
		 * @param cause
		 *            The {@link Throwable} that caused the exception.
		 */
		public AmbiguityResolvingException(String message, Throwable cause) {

			super(message, cause);
		}

	}
}
