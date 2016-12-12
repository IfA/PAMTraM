/**
 *
 */
package de.mfreund.gentrans.transformation.resolving.statistics;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.dialogs.IDialogSettings;

import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.descriptors.ModelConnectionPath;
import de.mfreund.gentrans.transformation.resolving.AbstractAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvedAdapter;
import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import pamtram.PAMTraM;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupType;
import pamtram.structure.TargetSection;
import pamtram.structure.TargetSectionClass;
import pamtram.structure.TargetSectionNonContainmentReference;

/**
 * This class implements a concrete {@link AbstractAmbiguityResolvingStrategy} that performs statistical evaluations of
 * previous choices for resolving ambiguities.
 * <p />
 * This strategy will not sort out any choices during the resolving of strategies but will merely sort them so that the
 * most probable choices will be first in the list of choices.
 *
 * @author mfreund
 */
public class StatisticsResolvingStrategy extends AbstractAmbiguityResolvingStrategy
implements IAmbiguityResolvedAdapter {

	/**
	 * The weighting factor to be used when calculating
	 * {@link #getWeightedCount(IDialogSettings, IDialogSettings, double, String) weighted counts} for statistics that
	 * can be evaluated on mapping model or meta-model level.
	 * <p />
	 * This needs to be between <em>0</em> (statistics will only regard decisions on the meta-model level) and
	 * <em>1</em> (statistics will only regard decisions on the mapping model level).
	 */
	private double weightingFactor;

	/**
	 * The instance of {@link IDialogSettings} that is used to store and retrieve statistics on the mapping model level.
	 */
	private IDialogSettings mappingSection;

	/**
	 * The instances of {@link IDialogSettings} that are used to store and retrieve statistics on the meta-model level.
	 * <p />
	 * The key of this map represents the {@link EPackage#getNsURI()} of a meta-model and the value represents the
	 * associated {@link IDialogSettings}.
	 */
	private Map<String, IDialogSettings> metamodelSections;

	@Override
	public void init(PAMTraM pamtramModel, List<EObject> sourceModels, Logger logger)
			throws AmbiguityResolvingException {

		super.init(pamtramModel, sourceModels, logger);

		// Set the default weighting factor
		this.weightingFactor = 0.5;

		// Acquire the various IDialogSettings that are used to persist/evaluate stored choices
		//
		IDialogSettings settings = StatisticsResolvingStrategyPlugin.getPlugin().getDialogSettings();
		IDialogSettings section = DialogSettings.getOrCreateSection(settings, "STATISTICS");

		IDialogSettings mapping = DialogSettings.getOrCreateSection(section, "MAPPING");

		this.mappingSection = DialogSettings.getOrCreateSection(mapping,
				pamtramModel.eResource().getURI().toString());

		IDialogSettings metamodel = DialogSettings.getOrCreateSection(section, "METAMODEL");

		Set<String> nsURIs = Stream
				.concat(pamtramModel.getSourceSectionModel().stream(), pamtramModel.getTargetSectionModel().stream())
				.map(sm -> AgteleEcoreUtil.getRootEPackage(sm.getMetaModelPackage()).getNsURI())
				.collect(Collectors.toSet());

		this.metamodelSections = nsURIs.stream().collect(
				Collectors.toMap(nsURI -> nsURI, nsURI -> DialogSettings.getOrCreateSection(metamodel, nsURI)));

	}

	/**
	 * This is the setter for the {@link #weightingFactor}.
	 *
	 * @param weightingFactor
	 *            the {@link #weightingFactor} to set.
	 */
	public void setWeightingFactor(double weightingFactor) {

		this.weightingFactor = weightingFactor;
	}

	@Override
	public List<MatchedSectionDescriptor> searchingSelectSection(List<MatchedSectionDescriptor> choices,
			EObject element) throws AmbiguityResolvingException {

		// We use the concatenated names of all sections in the list of choices as key
		//
		String key = String.join(";", choices.parallelStream().map(m -> m.getAssociatedSourceSectionClass().getName())
				.sorted().collect(Collectors.toList()));

		IDialogSettings choicesSection = DialogSettings.getOrCreateSection(this.mappingSection, key);

		// Sort the choices in descending order based on the number of previous count
		//
		return choices.parallelStream()
				.sorted((o1, o2) -> StatisticsResolvingStrategy.this
						.getCount(choicesSection, o2.getAssociatedSourceSectionClass().getName())
						.compareTo(this.getCount(choicesSection, o1.getAssociatedSourceSectionClass().getName())))
				.collect(Collectors.toList());

	}

	@Override
	public void searchingSectionSelected(List<MatchedSectionDescriptor> choices,
			MatchedSectionDescriptor resolved) {

		// We use the concatenated names of all sections in the list of choices as key
		//
		String key = String.join(";", choices.parallelStream().map(m -> m.getAssociatedSourceSectionClass().getName())
				.sorted().collect(Collectors.toList()));

		IDialogSettings choicesSection = DialogSettings.getOrCreateSection(this.mappingSection, key);

		// The previous count for the given selected choice
		//
		int count = this.getCount(choicesSection, resolved.getAssociatedSourceSectionClass().getName());

		choicesSection.put(resolved.getAssociatedSourceSectionClass().getName(), ++count);

	}

	@Override
	public List<Mapping> searchingSelectMapping(List<Mapping> choices, EObject element)
			throws AmbiguityResolvingException {

		// We use the concatenated names of all mappings in the list of choices as key
		//
		String key = String.join(";",
				choices.parallelStream().map(m -> m.getName()).sorted().collect(Collectors.toList()));

		IDialogSettings choicesSection = DialogSettings.getOrCreateSection(this.mappingSection, key);

		// Sort the choices in descending order based on the number of previous count
		//
		return choices.parallelStream()
				.sorted((o1, o2) -> StatisticsResolvingStrategy.this
						.getCount(choicesSection, o2.getName()).compareTo(this.getCount(choicesSection, o1.getName())))
				.collect(Collectors.toList());
	}

	@Override
	public void searchingMappingSelected(List<Mapping> choices, Mapping resolved) {

		// We use the concatenated names of all mappings in the list of choices as key
		//
		String key = String.join(";", choices.parallelStream().map(m -> m.getName())
				.sorted().collect(Collectors.toList()));

		IDialogSettings choicesSection = DialogSettings.getOrCreateSection(this.mappingSection, key);

		// The previous count for the given selected choice
		//
		int count = this.getCount(choicesSection, resolved.getName());

		choicesSection.put(resolved.getName(), ++count);

	}

	@Override
	public void instantiatingAttributeValueSelected(List<String> choices, String resolved) {

		// up to now, we do not apply statistical analysis in the instantiating phase so nothing is to be done here

	}

	@Override
	public void instantiatingCardinalitySelected(List<Integer> choices, Integer resolved) {

		// up to now, we do not apply statistical analysis in the instantiating phase so nothing is to be done here

	}

	@Override
	public void joiningContainerInstanceSelected(List<EObjectWrapper> choices, EObjectWrapper resolved) {

		// up to now, we do not apply statistical analysis on selected instances so nothing is to be done here

	}

	@Override
	public Map<ModelConnectionPath, List<EObjectWrapper>> joiningSelectConnectionPathAndContainerInstance(
			Map<ModelConnectionPath, List<EObjectWrapper>> choices, TargetSection section,
			List<EObjectWrapper> sectionInstances, MappingHintGroupType hintGroup) throws AmbiguityResolvingException {

		// We use the concatenated string representations of all paths in the list of choices as key
		//
		String key = String.join(";",
				choices.keySet().parallelStream().map(m -> m.toString()).sorted().collect(Collectors.toList()));

		IDialogSettings mappingLayerSection = DialogSettings.getOrCreateSection(this.mappingSection, key);
		IDialogSettings metamodelLayerSection = DialogSettings.getOrCreateSection(this.metamodelSections
				.get(AgteleEcoreUtil.getRootEPackage(choices.keySet().iterator().next().getPathRootClass()).getNsURI()),
				key);

		// Sort the choices in descending order based on the number of previous count
		// (we only sort the keys as, up to now, we do not perform statistical analysis on instances)
		//
		List<ModelConnectionPath> sortedKeys = choices.keySet()
				.parallelStream().sorted((o1, o2) -> StatisticsResolvingStrategy.this
						.getWeightedCount(mappingLayerSection, metamodelLayerSection, this.weightingFactor, o2.toString()).compareTo(
								this.getWeightedCount(mappingLayerSection, metamodelLayerSection, this.weightingFactor, o1.toString())))
				.collect(Collectors.toList());

		// We create a new LinkedHashMap as this guarantees ordering of keys
		//
		LinkedHashMap<ModelConnectionPath, List<EObjectWrapper>> sortedMap = new LinkedHashMap<>();
		sortedKeys.stream().forEach(k -> sortedMap.put(k, choices.get(k)));

		return sortedMap;
	}

	@Override
	public List<ModelConnectionPath> joiningSelectConnectionPath(List<ModelConnectionPath> choices,
			TargetSection section) throws AmbiguityResolvingException {

		// We use the concatenated string representations of all paths in the list of choices as key
		//
		String key = String.join(";",
				choices.parallelStream().map(m -> m.toString()).sorted().collect(Collectors.toList()));

		IDialogSettings mappingLayerSection = DialogSettings.getOrCreateSection(this.mappingSection, key);
		IDialogSettings metamodelLayerSection = DialogSettings.getOrCreateSection(this.metamodelSections
				.get(AgteleEcoreUtil.getRootEPackage(choices.get(0).getPathRootClass()).getNsURI()), key);

		// Sort the choices in descending order based on the number of previous count
		//
		return choices.parallelStream().sorted((o1, o2) -> StatisticsResolvingStrategy.this
				.getWeightedCount(mappingLayerSection, metamodelLayerSection, this.weightingFactor, o2.toString())
				.compareTo(this.getWeightedCount(mappingLayerSection, metamodelLayerSection, this.weightingFactor, o1.toString())))
				.collect(Collectors.toList());
	}

	@Override
	public void joiningConnectionPathSelected(List<ModelConnectionPath> choices, ModelConnectionPath resolved) {

		// We use the concatenated string representations of all paths in the list of choices as key
		//
		String key = String.join(";",
				choices.parallelStream().map(m -> m.toString()).sorted().collect(Collectors.toList()));

		/*
		 * Store on the mapping layer
		 */
		IDialogSettings mappingLayerSection = DialogSettings.getOrCreateSection(this.mappingSection, key);

		// The previous count for the given selected choice
		//
		int mappingCount = this.getCount(mappingLayerSection, resolved.toString());

		mappingLayerSection.put(resolved.toString(), ++mappingCount);

		/*
		 * Store on the meta-model layer
		 */
		String nsURI = AgteleEcoreUtil.getRootEPackage(resolved.getPathRootClass()).getNsURI();
		IDialogSettings metamodelLayerSection = DialogSettings.getOrCreateSection(
				this.metamodelSections.get(nsURI),
				key);

		// The previous count for the given selected choice
		//
		int metamodelCount = this.getCount(metamodelLayerSection, resolved.toString());

		metamodelLayerSection.put(resolved.toString(), ++metamodelCount);

	}

	@Override
	public List<EClass> joiningSelectRootElement(List<EClass> choices) throws AmbiguityResolvingException {

		// We use the concatenated names of all classes in the list of choices as key
		//
		String key = String.join(";",
				choices.parallelStream().map(m -> m.getName()).sorted().collect(Collectors.toList()));

		IDialogSettings mappingLayerSection = DialogSettings.getOrCreateSection(this.mappingSection, key);
		IDialogSettings metamodelLayerSection = DialogSettings.getOrCreateSection(
				this.metamodelSections.get(AgteleEcoreUtil.getRootEPackage(choices.get(0)).getNsURI()), key);

		// Sort the choices in descending order based on the number of previous count
		//
		return choices.parallelStream()
				.sorted((o1, o2) -> StatisticsResolvingStrategy.this
						.getWeightedCount(mappingLayerSection, metamodelLayerSection, this.weightingFactor,
								o2.getName())
						.compareTo(this.getWeightedCount(mappingLayerSection, metamodelLayerSection,
								this.weightingFactor, o1.getName())))
				.collect(Collectors.toList());
	}

	@Override
	public void joiningRootElementSelected(List<EClass> choices, EClass resolved) {

		// We use the concatenated names of all classes in the list of choices as key
		//
		String key = String.join(";",
				choices.parallelStream().map(m -> m.getName()).sorted().collect(Collectors.toList()));

		/*
		 * Store on the mapping layer
		 */
		IDialogSettings mappingLayerSection = DialogSettings.getOrCreateSection(this.mappingSection, key);

		// The previous count for the given selected choice
		//
		int mappingCount = this.getCount(mappingLayerSection, resolved.getName());

		mappingLayerSection.put(resolved.getName(), ++mappingCount);

		/*
		 * Store on the meta-model layer
		 */
		String nsURI = AgteleEcoreUtil.getRootEPackage(resolved).getNsURI();
		IDialogSettings metamodelLayerSection = DialogSettings.getOrCreateSection(this.metamodelSections.get(nsURI),
				key);

		// The previous count for the given selected choice
		//
		int metamodelCount = this.getCount(metamodelLayerSection, resolved.getName());

		metamodelLayerSection.put(resolved.getName(), ++metamodelCount);

	}

	@Override
	public void linkingTargetInstanceSelected(List<EObjectWrapper> choices, EObjectWrapper resolved) {

		// up to now, we do not apply statistical analysis on selected instances so nothing is to be done here

	}

	@Override
	public Map<TargetSectionClass, List<EObjectWrapper>> linkingSelectTargetSectionAndInstance(
			Map<TargetSectionClass, List<EObjectWrapper>> choices, TargetSectionNonContainmentReference reference,
			MappingHintGroupType hintGroup) throws AmbiguityResolvingException {

		// We use the concatenated names of all classes in the list of choices as key
		//
		String key = String.join(";",
				choices.keySet().parallelStream().map(m -> m.getName()).sorted().collect(Collectors.toList()));

		IDialogSettings choicesSection = DialogSettings.getOrCreateSection(this.mappingSection, key);

		// Sort the choices in descending order based on the number of previous count
		// (we only sort the keys as, up to now, we do not perform statistical analysis on instances)
		//
		List<TargetSectionClass> sortedKeys = choices.keySet()
				.parallelStream().sorted((o1, o2) -> StatisticsResolvingStrategy.this
						.getCount(choicesSection, o2.getName()).compareTo(this.getCount(choicesSection, o1.getName())))
				.collect(Collectors.toList());

		// We create a new LinkedHashMap as this guarantees ordering of keys
		//
		LinkedHashMap<TargetSectionClass, List<EObjectWrapper>> sortedMap = new LinkedHashMap<>();
		sortedKeys.stream().forEach(k -> sortedMap.put(k, choices.get(k)));

		return sortedMap;
	}

	@Override
	public void linkingTargetSectionSelected(List<TargetSectionClass> choices, TargetSectionClass resolved) {

		// We use the concatenated names of all classes in the list of choices as key
		//
		String key = String.join(";",
				choices.parallelStream().map(m -> m.getName()).sorted().collect(Collectors.toList()));

		IDialogSettings choicesSection = DialogSettings.getOrCreateSection(this.mappingSection, key);

		// The previous count for the given selected choice
		//
		int count = this.getCount(choicesSection, resolved.getName());

		choicesSection.put(resolved.getName(), ++count);

	}

	/**
	 * A helper method to extract a count from an instance of {@link IDialogSettings}.
	 *
	 * @param settings
	 *            The instance of {@link IDialogSettings} from that the count is to be extracted.
	 * @param key
	 *            The key that shall be used to extract the count.
	 * @return The extracted count or '<em>0</em>' if no value could be extracted.
	 */
	private Integer getCount(IDialogSettings settings, String key) {

		try {
			return settings.getInt(key);
		} catch (NumberFormatException e) {
			return 0;
		}

	}

	/**
	 * A helper method to extract a weighted count from two instances of {@link IDialogSettings}.
	 *
	 * @param settings1
	 *            The first instance of {@link IDialogSettings} from that the Integer is to be extracted.
	 * @param settings2
	 *            The second instance of {@link IDialogSettings} from that the Integer is to be extracted.
	 * @param factor
	 *            The weighing factor (between <em>0</em> and <em>1</em>) to be used when calculating the weighted
	 *            count. <em>0</em> means that only <em>settings2</em> is weighted, <em>1</em> means that only
	 *            <em>settings1</em> is weighted.
	 * @param key
	 *            The key that shall be used to extract the count.
	 * @return The extracted weighted count or '<em>0</em>' if no count could be extracted.
	 */
	private Double getWeightedCount(IDialogSettings settings1, IDialogSettings settings2, double factor, String key) {

		int count1 = this.getCount(settings1, key);
		int count2 = this.getCount(settings2, key);

		return factor * count1 + (1 - factor) * count2;

	}
}
