package de.mfreund.gentrans.transformation;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;

import pamtram.metamodel.ActualAttribute;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.VirtualAttribute;

/**
 * Storage class for values of {@link TargetSectionAttribute TargetSectionAttributes} ({@link ActualAttribute
 * ActualAttributes} and {@link VirtualAttribute VirtualAttributes}) generated by the transformation.
 *
 * @author Sascha Steffen
 * @version 1.0
 */
public class AttributeValueRegistry {

	/**
	 * Storage of all generated values for {@link ActualAttribute ActualAttributes}.
	 */
	private final LinkedHashMap<EClass, LinkedHashMap<EAttribute, LinkedHashSet<String>>> actualAttributes;

	/**
	 * Storage of all generated values for {@link VirtualAttribute VirtualAttributes}.
	 */
	private final LinkedHashMap<EClass, LinkedHashMap<VirtualAttribute, LinkedHashSet<String>>> virtualAttributes;

	/**
	 * This constructs an instance.
	 */
	public AttributeValueRegistry() {
		actualAttributes = new LinkedHashMap<>();
		virtualAttributes = new LinkedHashMap<>();
	}

	/**
	 * Check if the value provided was already written as the attribute value of
	 * a class of the (exact) same type in the targetModel.
	 * <p>
	 * VirtualAttributes have no actual reference to the target metamodel and
	 * therefore values can only be unique for instances of VirtualAttributes as
	 * modeled in the PAMTraM Model. In case of ActualAttributes the EAttribute
	 * type is relevant for determining if an Attribute is unique.
	 *
	 * @param attr
	 *            The {@link TargetSectionAttribute} of the PAMTraM model to be checked.
	 * @param value
	 *            The attribute value to be checked.
	 * @param eClass
	 *            Attribute val is to be checked
	 * @return true if Value was registered before
	 */
	public boolean attributeValueExists(final TargetSectionAttribute attr,
			final String value, final EClass eClass) {

		if (attr instanceof ActualAttribute) {
			return attributeValueExists((ActualAttribute) attr, value, eClass);
		} else if (attr instanceof VirtualAttribute) {
			return attributeValueExists((VirtualAttribute) attr, value, eClass);
		} else {
			return false;
		}
	}

	/**
	 * Check if the value provided was already written as the Attribute value of
	 * class of the (exact) same type in the targetModel
	 * <p>
	 * In case of ActualAttributes the EAttribute type is relevant for
	 * determining if an Attribute is unique.
	 *
	 * @param attr
	 *            Attribute of the PAMTraM Model,
	 * @param value
	 *            Val to be set
	 * @param eClass
	 *            Attribute val is to be checked
	 * @return true if Value was registered before
	 */
	public boolean attributeValueExists(final ActualAttribute attr, final String value, final EClass eClass) {

		if (actualAttributes.containsKey(eClass)) {
			if (actualAttributes.get(eClass).containsKey(attr.getAttribute())) {
				return actualAttributes.get(eClass).get(attr.getAttribute())
						.contains(value);
			}
		}

		return false;
	}

	/**
	 * Check if the value provided was already written as the Attribute value of
	 * class of the (exact) same type in the targetModel
	 * <p>
	 * VirtualAttributes have no actual reference to the target metamodel and
	 * therefore values can only be unique for instances of VirtualAttributes as
	 * modeled in the PAMTraM Model.
	 *
	 * @param attr
	 *            Attribute of the PAMTraM Model,
	 * @param value
	 *            Val to be set
	 * @param eClass
	 *            Attribute val is to be checked
	 * @return true if Value was registered before
	 */
	public boolean attributeValueExists(final VirtualAttribute attr,
			final String value, final EClass eClass) {
		if (virtualAttributes.containsKey(eClass)) {
			if (virtualAttributes.get(eClass).containsKey(attr)) {
				return virtualAttributes.get(eClass).get(attr).contains(value);
			}
		}
		return false;
	}

	/**
	 * Registers the value of an {@link ActualAttribute}.
	 *
	 * @param attr The attribute for which the value shall be registered.
	 * @param eClass The {@link EClass} for which the value shall be registered.
	 * @param value The value to be registered.
	 */
	public void registerValue(final ActualAttribute attr, final EClass eClass,
			final String value) {
		if (!actualAttributes.containsKey(eClass)) {
			actualAttributes.put(eClass,
					new LinkedHashMap<EAttribute, LinkedHashSet<String>>());
			actualAttributes.put(eClass,
					new LinkedHashMap<EAttribute, LinkedHashSet<String>>());
		}
		if (!actualAttributes.get(eClass).containsKey(attr.getAttribute())) {
			actualAttributes.get(eClass).put(attr.getAttribute(),
					new LinkedHashSet<String>());
		}
		actualAttributes.get(eClass).get(attr.getAttribute()).add(value);
	}

	/**
	 * Registers the value of a {@link VirtualAttribute}.
	 *
	 * @param attr The attribute for which the value shall be registered.
	 * @param eClass The {@link EClass} for which the the value shall be registered.
	 * @param value The value to be registered.
	 */
	public void registerValue(final VirtualAttribute attr, final EClass eClass,
			final String value) {
		if (!virtualAttributes.containsKey(eClass)) {
			virtualAttributes.put(eClass,
					new LinkedHashMap<VirtualAttribute, LinkedHashSet<String>>());
			virtualAttributes.put(eClass,
					new LinkedHashMap<VirtualAttribute, LinkedHashSet<String>>());
		}
		// add value to registry
		if (!virtualAttributes.get(eClass).containsKey(attr)) {
			virtualAttributes.get(eClass).put(attr, new LinkedHashSet<String>());
		}
		virtualAttributes.get(eClass).get(attr).add(value);
	}

}
