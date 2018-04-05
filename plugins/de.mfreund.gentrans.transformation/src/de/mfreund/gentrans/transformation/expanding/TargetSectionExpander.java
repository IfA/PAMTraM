/**
 *
 */
package de.mfreund.gentrans.transformation.expanding;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import de.mfreund.gentrans.transformation.core.CancelableTransformationAsset;
import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceDescriptor;
import de.mfreund.gentrans.transformation.registries.SelectedMappingRegistry;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.structure.target.TargetSection;

/**
 * An abstract base implementation for workers that are able to perform some aspects of the <em>expanding</em> step of
 * the transformation.
 *
 * @author mfreund
 */
@SuppressWarnings("javadoc")
public abstract class TargetSectionExpander extends CancelableTransformationAsset {

	protected TargetSectionRegistry targetSectionRegistry;

	protected IAmbiguityResolvingStrategy ambiguityResolvingStrategy;

	protected MappingInstanceDescriptor currentMappingInstanceDescriptor;

	public TargetSectionExpander(TransformationAssetManager assetManager) {

		super(assetManager);

		targetSectionRegistry = assetManager.getTargetSectionRegistry();
		ambiguityResolvingStrategy = assetManager.getTransformationConfig().getAmbiguityResolvingStrategy();
	}

	/**
	 * Join the instantiated {@link TargetSection TargetSections}.
	 *
	 * @param selectedMappingRegistry
	 *            The {@link SelectedMappingRegistry} providing all the {@link MappingInstanceDescriptor Mapping
	 *            instances} whose {@link TargetSection TargetSections} shall be joined.
	 */
	public void expandTargetSections(SelectedMappingRegistry selectedMappingRegistry) {

		List<MappingInstanceDescriptor> mappingInstanceDescriptors = selectedMappingRegistry.getMappingInstaces();

		expandTargetSectionsCreatedByMappingInstances(mappingInstanceDescriptors);
	}

	protected void expandTargetSectionsCreatedByMappingInstances(
			List<MappingInstanceDescriptor> mappingInstanceDescriptors) {

		mappingInstanceDescriptors.stream().forEach(this::expandTargetSectionsCreatedByMappingInstance);
	}

	protected void expandTargetSectionsCreatedByMappingInstance(MappingInstanceDescriptor mappingInstanceDescriptor) {

		currentMappingInstanceDescriptor = mappingInstanceDescriptor;

		List<InstantiableMappingHintGroup> activeInstantiableHintGroups = getInstantiableHintGroupsOfCurrentMappingInstance();

		activeInstantiableHintGroups.forEach(this::doExpandTargetSectionsCreatedByInstantiableHintGroup);

	}

	protected List<InstantiableMappingHintGroup> getInstantiableHintGroupsOfCurrentMappingInstance() {

		Stream<MappingHintGroup> activeMappingHintGroups = currentMappingInstanceDescriptor.getMappingHintGroups()
				.stream().filter(g -> g.getTargetSection() != null && g instanceof MappingHintGroup)
				.map(g -> (MappingHintGroup) g);

		Stream<MappingHintGroupImporter> activeMappingHintGroupImporters = currentMappingInstanceDescriptor
				.getMappingHintGroupImporters().stream()
				.filter(i -> i.getHintGroup() != null && i.getHintGroup().getTargetSection() != null);

		return Stream.concat(activeMappingHintGroups, activeMappingHintGroupImporters).collect(Collectors.toList());

	}

	protected void expandTargetSectionsCreatedByInstantiableHintGroup(InstantiableMappingHintGroup hintGroup) {

		checkCanceled();
		doExpandTargetSectionsCreatedByInstantiableHintGroup(hintGroup);
	}

	/**
	 * The actual work needs to be implemented here depending on the concrete aspect of the <em>expanding</em> phase
	 * that is handled by a concrete sub-class.
	 *
	 * @param hintGroup
	 *            The {@link InstantiableMappingHintGroup} to be expanded for the
	 *            {@link #currentMappingInstanceDescriptor}.
	 */
	protected abstract void doExpandTargetSectionsCreatedByInstantiableHintGroup(
			InstantiableMappingHintGroup hintGroup);

}
