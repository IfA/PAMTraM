/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
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

	protected InstantiableMappingHintGroup currentHintGroup;

	public TargetSectionExpander(TransformationAssetManager assetManager) {

		super(assetManager);

		targetSectionRegistry = assetManager.getTargetSectionRegistry();
		ambiguityResolvingStrategy = assetManager.getTransformationConfig().getAmbiguityResolvingStrategy();
	}

	/**
	 * Expand all {@link MappingInstanceDescriptor MappingInstanceDescriptors} stored in the given
	 * {@link SelectedMappingRegistry}.
	 *
	 * @param selectedMappingRegistry
	 */
	public void expandMappingInstances(SelectedMappingRegistry selectedMappingRegistry) {

		List<MappingInstanceDescriptor> mappingInstanceDescriptors = selectedMappingRegistry.getMappingInstaces();

		expandMappingInstances(mappingInstanceDescriptors);
	}

	protected void expandMappingInstances(List<MappingInstanceDescriptor> mappingInstanceDescriptors) {

		mappingInstanceDescriptors.stream().forEach(this::expandMappingInstance);
	}

	protected void expandMappingInstance(MappingInstanceDescriptor mappingInstanceDescriptor) {

		currentMappingInstanceDescriptor = mappingInstanceDescriptor;

		List<InstantiableMappingHintGroup> activeInstantiableHintGroups = getInstantiableHintGroupsOfCurrentMappingInstance();

		activeInstantiableHintGroups.forEach(this::expandInstantiableHintGroup);

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

	protected void expandInstantiableHintGroup(InstantiableMappingHintGroup hintGroup) {

		currentHintGroup = hintGroup;
		checkCanceled();
		doExpandCurrentHintGroup();
	}

	/**
	 * This performs the actual work necessary to <em>expand</em> the {@link #currentHintGroup} for the
	 * {@link #currentMappingInstanceDescriptor} depending on the concrete aspect of the <em>expanding</em> phase that
	 * is handled by the concrete sub-class.
	 */
	protected abstract void doExpandCurrentHintGroup();

}
