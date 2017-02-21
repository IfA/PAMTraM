/**
 *
 */
package de.mfreund.gentrans.transformation.descriptors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.registries.AttributeValueRegistry;
import pamtram.structure.generic.ActualAttribute;
import pamtram.structure.generic.VirtualAttribute;
import pamtram.structure.target.FileAttribute;
import pamtram.structure.target.FileType;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAttribute;

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
	private EObject eObject;

	/**
	 * The {@link AttributeValueRegistry} that values to be {@link #setAttributeValue(TargetSectionAttribute, String) set}
	 * will be registered in.
	 */
	private final AttributeValueRegistry attrValRegistry;

	/**
	 * As values of {@link VirtualAttribute VirtualAttributes} cannot bestored in the actual {@link #eObject}, they are stored
	 * in a separate map.
	 */
	private final LinkedHashMap<VirtualAttribute<?, ?, ?, ?>, String> virtualAttributeValues;

	/**
	 * This creates an instance that wraps the given 'eObject'.
	 *
	 * @param eObject
	 *            The {@link EObject} to be wrapped.
	 * @param attrValRegistry
	 *           The {@link AttributeValueRegistry} that values to be {@link #setAttributeValue(TargetSectionAttribute, String) set}
	 * will be registered in.
	 */
	public EObjectWrapper(EObject eObject,
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
		return this.eObject;
	}

	/**
	 * This is the setter for the {@link #eObject}.
	 * @param eObject The actual {@link EObject} that this shall wrap.
	 */
	public void setEObject(EObject eObject) {
		this.eObject = eObject;
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
			return this.virtualAttributeValues.get(attr);
		} else if (attr instanceof ActualAttribute) {
			return EObjectWrapper.convertAttributeValue(this.eObject,
					((ActualAttribute<?, ?, ?, ?>) attr).getAttribute());
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
	public boolean attributeValueExists(final TargetSectionAttribute attr,
			final String value) {

		return this.attrValRegistry.attributeValueExists(attr, value,this.eObject.eClass());
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
	public void setAttributeValue(final TargetSectionAttribute attr,
			final String value) {
		if (attr instanceof ActualAttribute) {
			this.setAttributeValue((ActualAttribute<?, ?, ?, ?>) attr, value);
		} else if (attr instanceof VirtualAttribute) {
			this.setAttributeValue((VirtualAttribute<?, ?, ?, ?>) attr, value);
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
	void setAttributeValue(final ActualAttribute<?, ?, ?, ?> attr, final String value)
			throws IllegalArgumentException {

		// convert the string representation of the value to the correct data type
		Object valueObject = null;
		try {
			valueObject = attr.getAttribute().getEType().getEPackage().getEFactoryInstance().createFromString(attr.getAttribute().getEAttributeType(), value);
		} catch (Exception e) {

			// if an integer-based value is represented as boolean (e.g. as it was used by an 'expression'), try to set this instead
			//
			if(value.endsWith(".0")) {
				try {
					valueObject = attr.getAttribute().getEType().getEPackage().getEFactoryInstance().createFromString(attr.getAttribute().getEAttributeType(), value.replaceFirst(".0$", ""));
				} catch (Exception e1) {
					throw e;
				}
			} else {
				throw e;
			}
		}

		if(attr.getAttribute().isMany()) {
			ArrayList<Object> valueObjectList = new ArrayList<>();
			valueObjectList.add(valueObject);
			this.eObject.eSet(attr.getAttribute(), valueObjectList);
		} else {
			this.eObject.eSet(attr.getAttribute(), valueObject);
		}

		this.attrValRegistry.registerValue(attr, this.eObject.eClass(), value);

	}

	/**
	 * This sets the value of a {@link VirtualAttribute}.
	 *
	 * @param attr
	 *           The {@link VirtualAttribute} for that the given 'value' shall be set.
	 * @param value
	 *           The value to be set.
	 */
	void setAttributeValue(final VirtualAttribute<?, ?, ?, ?> attr, final String value) {
		this.virtualAttributeValues.put(attr, value);

		this.attrValRegistry.registerValue(attr, this.eObject.eClass(), value);
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
			final String val = EObjectWrapper.convertAttributeValue(eObject, a);
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
			if(!attr.isMany()) {
				return attr.getEType().getEPackage().getEFactoryInstance().convertToString(attr.getEAttributeType(), srcAttr);
			} else {
				String ret = "";
				Iterator<?> it = ((EList<?>) srcAttr).iterator();
				while(it.hasNext()) {
					ret += attr.getEType().getEPackage().getEFactoryInstance().convertToString(attr.getEAttributeType(), it.next());
					if(it.hasNext()) {
						ret += "; ";
					}
				}
				return ret;
			}
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
		String returnString = EObjectWrapper.asString(this.eObject);

		for (final VirtualAttribute<?, ?, ?, ?> a : this.virtualAttributeValues.keySet()) {
			returnString += "\n   " + a.getName() + "(v): "
					+ this.virtualAttributeValues.get(a);
		}

		return returnString;
	}

	/**
	 * If this represents a {@link TargetSection}, return the value of the {@link FileAttribute} associated
	 * with this via the {@link TargetSection#getFile() file} reference.
	 *
	 * @return The value of the {@link FileAttribute} or an empty String if this either does not represent
	 * a {@link TargetSection} or if the {@link TargetSection#getFile() file} reference has not been set.
	 */
	public String getFile() {

		for (Entry<VirtualAttribute<?, ?, ?, ?>, String> entry : this.virtualAttributeValues.entrySet()) {
			if(entry.getKey() instanceof FileAttribute) {
				return entry.getValue() != null ? entry.getValue() : "";
			}
		}
		return "";
	}

	/**
	 * If this represents a {@link TargetSection}, return the {@link FileAttribute#getFileType() fileType} of the
	 * {@link FileAttribute} associated with this via the {@link TargetSection#getFile() file} reference.
	 *
	 * @return The value of the {@link FileAttribute#getFileType()} or the default value {@link FileType#XMI}
	 * if this either does not represent a {@link TargetSection}, if the {@link TargetSection#getFile() file}
	 * reference has not been set, or if no {@link FileAttribute#getFileType()} fileType has been set.
	 */
	public FileType getFileType() {

		for (Entry<VirtualAttribute<?, ?, ?, ?>, String> entry : this.virtualAttributeValues.entrySet()) {
			if(entry.getKey() instanceof FileAttribute) {
				return ((FileAttribute) entry.getKey()).getFileType() == null ? FileType.XMI : ((FileAttribute) entry.getKey()).getFileType();
			}
		}
		return FileType.XMI;
	}

}
