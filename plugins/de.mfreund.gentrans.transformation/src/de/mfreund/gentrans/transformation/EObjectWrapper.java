/**
 *
 */
package de.mfreund.gentrans.transformation;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import pamtram.metamodel.ActualAttribute;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.VirtualAttribute;

/**
 * This class provides wrapper functionality for {@link EObject EObjects} that have been created during the transformation and
 * extends an EObject in a way that not only values of {@link ActualAttribute ActualAttributes} but also of
 * {@link VirtualAttribute VirtualAttributes} are stored.
 * <p />
 * The class provides a common interface to set and retrieve values of {@link TargetSectionAttribute} (<em>virtual</em>
 * as well as <em>actual</em> ones) via the methods {@link #setAttributeValue(TargetSectionAttribute, String)} and
 * {@link #getAttributeValue(TargetSectionAttribute)}.
 * <p />
 * <b>Note:</b>The wrapped EObject is available via the {@link #eObject} field. 
 * 
 * @author mfreund
 */
public class EObjectWrapper {

	/**
	 * The actual {@link EObject} that is wrapped by this.
	 */
	private final EObject eObject;

	/**
	 * The {@link AttributeValueRegistry} that values to be {@link #setAttributeValue(TargetSectionAttribute, String) set} 
	 * will be registered in.
	 */
	private final AttributeValueRegistry attrValRegistry;

	/**
	 * As values of {@link VirtualAttribute VirtualAttributes} cannot bestored in the actual {@link #eObject}, they are stored 
	 * in a separate map.
	 */
	private final LinkedHashMap<VirtualAttribute, String> virtualAttributeValues;

	/**
	 * This creates an instance that wraps the given 'eObject'.
	 *
	 * @param eObject
	 *            The {@link EObject} to be wrapped.
	 * @param attrValRegistry
	 *           The {@link AttributeValueRegistry} that values to be {@link #setAttributeValue(TargetSectionAttribute, String) set} 
	 * will be registered in.
	 */
	public EObjectWrapper(final EObject eObject,
			final AttributeValueRegistry attrValRegistry) {

		this.eObject = eObject;
		this.attrValRegistry = attrValRegistry;
		this.virtualAttributeValues = new LinkedHashMap<>();
	}

	/**
	 * This is the getter for the {@link #eObject}.
	 *
	 * @return The actual {@link EObject} that is wrapped by this.
	 */
	public EObject getEObject() {
		return eObject;
	}

	/**
	 * This returns a String representation of the value of a {@link TargetSectionAttribute}.
	 * <p />
	 * If the given 'attr' is an {@link ActualAttribute} the actual value of the wrapped {@link #eObject} is
	 * returned - if 'attr' is an {@link VirtualAttribute} the value that is stored in {@link #virtualAttributeValues}
	 * is returned.
	 *
	 * @param attr
	 * @return Attribute value as String
	 */
	public String getAttributeValue(final TargetSectionAttribute attr) {
		if (attr instanceof VirtualAttribute) {
			return virtualAttributeValues.get(attr);
		} else if (attr instanceof ActualAttribute) {
			return convertAttributeValue(eObject,
					((ActualAttribute) attr).getAttribute());
		}
		return null;
	}

	/**
	 * This checks if the given attribute 'value' has been already registered to the {@link #attrValRegistry} that
	 * is associated with this wrapper for the given 'attr'.
	 *
	 * @param attr
	 *            The {@link TargetSectionAttribute} for that the registry shall be consulted.
	 * @param value
	 *            The attribute value to be checked.
	 * @return '<em><b>true</b><em>' if the given 'value' has been registered before for the given 'attr', '<em><b>false</b></em>'
	 * otherwise.
	 */
	boolean attributeValueExists(final TargetSectionAttribute attr,
			final String value) {

		return attrValRegistry.attributeValueExists(attr, value,eObject.eClass());
	}

	/**
	 * This sets the value of a {@link TargetSectionAttribute} and registers it in the {@link #attrValRegistry}
	 * registered with this wrapper.
	 * <p />
	 * Based on the attribute type, this redirect to {@link #setAttributeValue(ActualAttribute, String)}
	 * or to {@link #setAttributeValue(VirtualAttribute, String)}.
	 *
	 * @param attr The {@link TargetSectionAttribute} for that the given 'value' shall be set.
	 * @param value A String representation of the value to be set.
	 * @throws IllegalArgumentException
	 */
	void setAttributeValue(final TargetSectionAttribute attr,
			final String value) {
		if (attr instanceof ActualAttribute) {
			setAttributeValue((ActualAttribute) attr, value);
		} else if (attr instanceof VirtualAttribute) {
			setAttributeValue((VirtualAttribute) attr, value);
		}

	}

	/**
	 * This sets the value of an {@link ActualAttribute}.
	 * <p />
	 * <b>Note:</b> The given value will be set in the {@link #eObject} that is wrapped by this.
	 *
	 * @param attr
	 *            The {@link ActualAttribute} for that the given 'value' shall be set.
	 * @param value
	 *             A String representation of the value to be set. This will be converted to the correct data type
	 *             defined by 'attr'.
	 * @throws IllegalArgumentException If the given 'value' cannot be converted to the data type defined by 'attr'.
	 */
	void setAttributeValue(final ActualAttribute attr, final String value)
			throws IllegalArgumentException {

		// convert the string representation of the value to the correct data type
		Object valueObject = attr.getAttribute().getEType().getEPackage()
				.getEFactoryInstance().createFromString(attr.getAttribute().getEAttributeType(), value);

		if(attr.getAttribute().isMany()) {
			ArrayList<Object> valueObjectList = new ArrayList<>();
			valueObjectList.add(valueObject);
			eObject.eSet(attr.getAttribute(), valueObjectList);
		} else {
			eObject.eSet(attr.getAttribute(), valueObject);
		}

		attrValRegistry.registerValue(attr, eObject.eClass(), value);

	}

	/**
	 * This sets the value of a {@link VirtualAttribute}.
	 *
	 * @param attr
	 *           The {@link VirtualAttribute} for that the given 'value' shall be set.
	 * @param value
	 *           The value to be set.
	 */
	void setAttributeValue(final VirtualAttribute attr, final String value) {
		virtualAttributeValues.put(attr, value);

		attrValRegistry.registerValue(attr, eObject.eClass(), value);
	}

	/**
	 * This creates a String representation of an EObject that includes the values of
	 * all {@link ActualAttribute ActualAttributes}.
	 *
	 * @param eObject The {@link EObject} for that the String representation shall be created.
	 * @return The String representation.
	 */
	public static String asString(final EObject eObject) {
		String returnString = eObject.eClass().getName() + " (HashCode: "
				+ eObject.hashCode() + ")";
		for (final EAttribute a : eObject.eClass().getEAllAttributes()) {
			final String val = convertAttributeValue(eObject, a);
			if (val != null) {
				returnString += "\n   " + a.getName() + ": " + val;
			}
		}
		returnString += "\n";

		return returnString;
	}

	/**
	 * Static helper method for converting an attribute value of the given 'eObject' to a String 
	 * representation.
	 *
	 * @param eObject
	 *            The {@link EObject} for that the attribute value shall be returned.
	 * @param attr
	 *            The {@link EAttribute} whose value shall be returned.
	 * @return A String representation of the attribute value.
	 */
	private static String convertAttributeValue(final EObject eObject,
			final EAttribute attr) {

		if (attr == null) {
			return null;
		}

		final Object srcAttr = eObject.eGet(attr);
		try {
			return attr.getEType().getEPackage().getEFactoryInstance().convertToString(attr.getEAttributeType(), srcAttr);
		} catch (final Exception e) {
			e.printStackTrace(System.out);
			return srcAttr.toString();
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String returnString = asString(eObject);

		for (final VirtualAttribute a : virtualAttributeValues.keySet()) {
			returnString += "\n   " + a.getName() + "(v): "
					+ virtualAttributeValues.get(a);
		}

		return returnString;
	}

}
