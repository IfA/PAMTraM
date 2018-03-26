/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 *
 */
package de.mfreund.gentrans.transformation.registries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import de.mfreund.gentrans.transformation.descriptors.MappingInstanceDescriptor;
import pamtram.mapping.Mapping;

/**
 * This class represents a registry for the various selected mappings. Thereby, each selected
 * {@link MappingInstanceDescriptor Mapping instance} is associated with the corresponding {@link Mapping} that it
 * represents.
 * <p />
 * Note: The map used internally to represent the registry as well as all relevant operations are
 * {@link Collections#synchronizedMap(Map) synchronized} (thread-safe). Consequently, it is safe to operate on this
 * registry e.g. by means of a parallel stream.
 *
 * @author mfreund
 */
public class SelectedMappingRegistry {

	/**
	 * The map realizing the actual registry.
	 */
	private Map<Mapping, List<MappingInstanceDescriptor>> internalRegistry;

	/**
	 * This creates an instance.
	 *
	 */
	public SelectedMappingRegistry() {

		this.internalRegistry = Collections.synchronizedMap(new LinkedHashMap<>());
	}

	/**
	 * Register a new list of {@link MappingInstanceDescriptor instances} for the given {@link Mapping mapping} by
	 * replacing eventual previously registered instances.
	 *
	 * @see #add(Mapping, List)
	 *
	 * @param mapping
	 *            The {@link Mapping} for that new instances shall be registered.
	 * @param instances
	 *            The list of {@link MappingInstanceDescriptor instances} to register.
	 */
	public synchronized void put(Mapping mapping, List<MappingInstanceDescriptor> instances) {

		this.internalRegistry.put(mapping, instances);
	}

	/**
	 * Register a new list of {@link MappingInstanceDescriptor instances}.
	 * <p />
	 * Note: Each of the instances is registered according to its associated
	 * {@link MappingInstanceDescriptor#getMapping() mapping}.
	 *
	 * @see #add(Mapping, List)
	 * @see #addAll(SelectedMappingRegistry)
	 *
	 * @param instances
	 *            The list of {@link MappingInstanceDescriptor instances} to register.
	 */
	public synchronized void add(List<MappingInstanceDescriptor> instances) {

		instances.stream().forEach(instance -> this.add(instance.getMapping(), Arrays.asList(instance)));
	}

	/**
	 * Register a new list of {@link MappingInstanceDescriptor instances} for the given {@link Mapping mapping} by
	 * adding to eventual previously registered instances.
	 *
	 * @see #put(Mapping, List)
	 * @see #addAll(SelectedMappingRegistry)
	 *
	 * @param mapping
	 *            The {@link Mapping} for that new instances shall be registered.
	 * @param instances
	 *            The list of {@link MappingInstanceDescriptor instances} to register.
	 */
	public synchronized void add(Mapping mapping, List<MappingInstanceDescriptor> instances) {

		List<MappingInstanceDescriptor> newInstances = new ArrayList<>(this.get(mapping));
		newInstances.addAll(instances);
		this.put(mapping, newInstances);
	}

	/**
	 * Register all contents of the given {@link SelectedMappingRegistry}.
	 *
	 * @see #add(Mapping, List)
	 *
	 * @param registry
	 *            The {@link SelectedMappingRegistry} the contents of which shall be registered in this registry.
	 */
	public synchronized void addAll(SelectedMappingRegistry registry) {

		registry.getMappings().stream().forEach(mapping -> this.add(mapping, registry.get(mapping)));
	}

	/**
	 * Check if the {@link #internalRegistry} already contains the given {@link Mapping}.
	 * <p />
	 * Note: This just redirects to the {@link #internalRegistry}.
	 *
	 * @param mapping
	 *            The {@link Mapping} to check.
	 * @return '<em>true</em>' if the {@link #internalRegistry} already contains the given {@link Mapping};
	 *         '<em>false</em>' otherwise.
	 */
	public synchronized boolean containsMapping(Mapping mapping) {

		return this.internalRegistry.containsKey(mapping);
	}

	/**
	 * Returns the list of {@link MappingInstanceDescriptor instances} registered for the given {@link Mapping mapping}.
	 * <p />
	 * Note: This redirects to the {@link #internalRegistry}. However, if there is nothing registered for the given
	 * mapping, an empty list will be returned instead of <em>null</em>.
	 *
	 * @param mapping
	 *            The {@link Mapping} for which the registered instances shall be returned.
	 * @return The list of registered {@link MappingInstanceDescriptor instances} or an empty list if there are no
	 *         registered instances.
	 */
	public synchronized List<MappingInstanceDescriptor> get(Mapping mapping) {

		return this.internalRegistry.containsKey(mapping) ? new ArrayList<>(this.internalRegistry.get(mapping))
				: Collections.emptyList();
	}

	/**
	 * Returns the set of {@link Mapping Mappings} currently managed by this registry.
	 *
	 * @return The set of {@link Mapping Mappings} currently managed by this registry.
	 */
	public synchronized Set<Mapping> getMappings() {

		return new LinkedHashSet<>(this.internalRegistry.keySet());
	}

	/**
	 * Returns the list of {@link MappingInstanceDescriptor Mapping instances} currently managed by this registry.
	 *
	 * @return The set of {@link MappingInstanceDescriptor Mapping instances} currently managed by this registry.
	 */
	public synchronized List<MappingInstanceDescriptor> getMappingInstaces() {

		return this.internalRegistry.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
	}
}
