package de.mfreund.gentrans.transformation.registries;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import pamtram.structure.target.ActualTargetSectionAttribute;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.target.VirtualTargetSectionAttribute;

/**
 * This class represents a registry for values of {@link TargetSectionAttribute TargetSectionAttributes}
 * ({@link ActualTargetSectionAttribute ActualAttributes} and {@link VirtualTargetSectionAttribute VirtualAttributes})
 * generated by the transformation.
 * <p />
 * It is only used, to check for duplicate values in case of {@link TargetSectionAttribute TargetSectionAttributes}
 * marked as {@link TargetSectionAttribute#isUnique() unique}.
 * <p />
 * Note: The map used internally to represent the registry as well as all relevant operations are
 * {@link Collections#synchronizedMap(Map) synchronized} (thread-safe). Consequently, it is safe to operate on this
 * registry e.g. by means of a parallel stream.
 *
 * @author mfreund
 */
public class AttributeValueRegistry {

	/**
	 * The map realizing the actual registry.
	 */
	protected Map<TargetSectionAttribute, LinkedHashSet<String>> internalRegistry;

	/**
	 * This constructs an instance.
	 */
	public AttributeValueRegistry() {

		this.internalRegistry = Collections.synchronizedMap(new LinkedHashMap<>());
	}

	/**
	 * Check if the provided <em>value</em> was already used for another instance of the given
	 * {@link TargetSectionAttribute} in the targetModel.
	 *
	 * @param attribute
	 *            The {@link TargetSectionAttribute} of the PAMTraM model to be checked.
	 * @param value
	 *            The attribute value to be checked.
	 * @return '<em>true</em>' if the value was used before; '<em>false</em>' otherwise.
	 */
	public synchronized boolean attributeValueExists(final TargetSectionAttribute attribute, final String value) {

		return this.internalRegistry.containsKey(attribute) && this.internalRegistry.get(attribute).contains(value);
	}

	/**
	 * Register the given <em>value</em> for the given {@link TargetSectionAttribute}.
	 *
	 * @param attribute
	 *            The {@link TargetSectionAttribute} for which the value shall be registered.
	 * @param value
	 *            The value to be registered.
	 */
	public synchronized void registerValue(TargetSectionAttribute attribute, final String value) {

		this.registerValues(attribute, Arrays.asList(value));
	}

	/**
	 * Register the given list of <em>values</em> for the given {@link TargetSectionAttribute}.
	 *
	 * @param attribute
	 *            The {@link TargetSectionAttribute} for which the values shall be registered.
	 * @param values
	 *            The values to be registered.
	 */
	public synchronized void registerValues(TargetSectionAttribute attribute, final List<String> values) {

		if (!this.internalRegistry.containsKey(attribute)) {
			this.internalRegistry.put(attribute, new LinkedHashSet<String>());
		}

		this.internalRegistry.get(attribute).addAll(values);
	}

}
