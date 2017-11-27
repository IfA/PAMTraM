/**
 *
 */
package de.mfreund.gentrans.transformation.descriptors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

import de.mfreund.gentrans.transformation.registries.AttributeValueRegistry;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;
import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import pamtram.structure.generic.ActualAttribute;
import pamtram.structure.generic.ActualReference;
import pamtram.structure.generic.VirtualAttribute;
import pamtram.structure.target.FileAttribute;
import pamtram.structure.target.FileType;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.target.TargetSectionReference;

/**
 * This class provides wrapper functionality for {@link EObject EObjects} that have been created during the
 * transformation and extends an EObject in a way that not only values of {@link ActualAttribute ActualAttributes} but
 * also of {@link VirtualAttribute VirtualAttributes} are stored.
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
	 * The {@link AttributeValueRegistry} that values to be {@link #setAttributeValue(TargetSectionAttribute, String)
	 * set} will be registered in.
	 */
	private final AttributeValueRegistry attrValRegistry;

	/**
	 * The {@link TargetSectionRegistry} that this is registered in and that will e.g. be used by
	 * {@link #getReferencedElements(List)}.
	 */
	private final TargetSectionRegistry targetSectionRegistry;

	/**
	 * As values of {@link VirtualAttribute VirtualAttributes} cannot bestored in the actual {@link #eObject}, they are
	 * stored in a separate map.
	 */
	private final LinkedHashMap<VirtualAttribute<?, ?, ?, ?>, String> virtualAttributeValues;

	/**
	 * This creates an instance that wraps the given 'eObject'.
	 *
	 * @param eObject
	 *            The {@link EObject} to be wrapped.
	 * @param targetSectionRegistry
	 *            The {@link TargetSectionRegistry} that this is registered in.
	 */
	public EObjectWrapper(EObject eObject, final TargetSectionRegistry targetSectionRegistry) {

		this.eObject = eObject;
		this.attrValRegistry = targetSectionRegistry.getAttrValRegistry();
		this.targetSectionRegistry = targetSectionRegistry;
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
	 *
	 * @param eObject
	 *            The actual {@link EObject} that this shall wrap.
	 */
	public void setEObject(EObject eObject) {

		this.eObject = eObject;
	}

	/**
	 * This returns a String representation of the value of a {@link TargetSectionAttribute}.
	 * <p />
	 * If the given 'attr' is an {@link ActualAttribute} the actual value of the wrapped {@link #eObject} is returned -
	 * if 'attr' is an {@link VirtualAttribute} the value that is stored in {@link #virtualAttributeValues} is returned.
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
	 * This checks if the given attribute 'value' has been already registered to the {@link #attrValRegistry} that is
	 * associated with this wrapper for the given 'attr'.
	 *
	 * @param attr
	 *            The {@link TargetSectionAttribute} for that the registry shall be consulted.
	 * @param value
	 *            The attribute value to be checked.
	 * @return '<em><b>true</b><em>' if the given 'value' has been registered before for the given 'attr',
	 *         '<em><b>false</b></em>' otherwise.
	 */
	public boolean attributeValueExists(final TargetSectionAttribute attr, final String value) {

		return this.attrValRegistry.attributeValueExists(attr, value, this.eObject.eClass());
	}

	/**
	 * This sets the value of a {@link TargetSectionAttribute} and registers it in the {@link #attrValRegistry}
	 * registered with this wrapper.
	 * <p />
	 * Based on the attribute type, this redirect to {@link #setAttributeValue(ActualAttribute, String)} or to
	 * {@link #setAttributeValue(VirtualAttribute, String)}.
	 *
	 * @param attr
	 *            The {@link TargetSectionAttribute} for that the given 'value' shall be set.
	 * @param value
	 *            A String representation of the value to be set.
	 * @throws IllegalArgumentException
	 */
	public void setAttributeValue(final TargetSectionAttribute attr, final String value) {

		if (attr instanceof ActualAttribute) {
			this.setAttributeValue((ActualAttribute<?, ?, ?, ?>) attr, value);
		} else if (attr instanceof VirtualAttribute) {
			this.setAttributeValue((VirtualAttribute<?, ?, ?, ?>) attr, value);
		}

	}

	/**
	 * This sets the values of a {@link TargetSectionAttribute} and registers it in the {@link #attrValRegistry}
	 * registered with this wrapper.
	 * <p />
	 * Based on the attribute type, this redirect to {@link #setAttributeValues(ActualAttribute, List)} or to
	 * {@link #setAttributeValue(VirtualAttribute, String)}.
	 * <p />
	 * Note: For {@link VirtualAttribute VirtualAttributes}, only a single value may be set!
	 *
	 * @param attr
	 *            The {@link TargetSectionAttribute} for that the given 'value' shall be set.
	 * @param values
	 *            A String representation of the values to be set.
	 * @throws IllegalArgumentException
	 */
	public void setAttributeValues(final TargetSectionAttribute attr, final List<String> values) {

		if (attr instanceof ActualAttribute) {
			this.setAttributeValues((ActualAttribute<?, ?, ?, ?>) attr, values);
		} else if (attr instanceof VirtualAttribute) {
			if (values.isEmpty()) {
				return;
			} else if (values.size() == 1) {
				this.setAttributeValue((VirtualAttribute<?, ?, ?, ?>) attr, values.get(0));
			} else {
				throw new IllegalArgumentException("Trying to set multiple values for a VirtualAttribute ('"
						+ attr.getName() + "'). This is currently not supported!");
			}
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
	 *            A String representation of the value to be set. This will be converted to the correct data type
	 *            defined by 'attr'.
	 * @throws IllegalArgumentException
	 *             If the given 'value' cannot be converted to the data type defined by 'attr'.
	 */
	void setAttributeValue(ActualAttribute<?, ?, ?, ?> attr, String value) throws IllegalArgumentException {

		this.setAttributeValues(attr, Arrays.asList(value));

	}

	/**
	 * This sets the values of an {@link ActualAttribute}.
	 * <p />
	 * <b>Note:</b> The given values will be set in the {@link #eObject} that is wrapped by this.
	 *
	 * @param attr
	 *            The {@link ActualAttribute} for that the given 'value' shall be set.
	 * @param values
	 *            A list of String representations of the values to be set. This will be converted to the correct data
	 *            type defined by 'attr'.
	 * @throws IllegalArgumentException
	 *             If the given 'value' cannot be converted to the data type defined by 'attr'.
	 */
	void setAttributeValues(ActualAttribute<?, ?, ?, ?> attr, List<String> values) throws IllegalArgumentException {

		List<Object> valueObjects = new ArrayList<>();

		for (String value : values) {
			valueObjects.add(this.getAttributeValueAsObject(attr.getAttribute(), value));

		}

		if (attr.getAttribute().isMany()) {
			this.eObject.eSet(attr.getAttribute(), valueObjects);
		} else if (values.size() == 1) {
			this.eObject.eSet(attr.getAttribute(), valueObjects.get(0));
		} else if (values.isEmpty()) {
			this.eObject.eUnset(attr.getAttribute());
		} else {
			throw new IllegalArgumentException("Trying to set multiple value for ActualAttribute '" + attr.getName()
					+ " that is based on an EAttribute with upper bound 1!");
		}

		this.attrValRegistry.registerValues(attr, this.eObject.eClass(), values);

	}

	/**
	 * Convert the string representation of the given <em>value</em> to the data type of the given {@link EAttribute}.
	 *
	 * @param attribute
	 *            The {@link EAttribute} defining the data type to use.
	 * @param value
	 *            The value to be converted.
	 * @return The converted value as instance of the data type of the given attribute.
	 * @throws IllegalArgumentException
	 */
	public Object getAttributeValueAsObject(EAttribute attribute, final String value) throws IllegalArgumentException {

		// convert the string representation of the value to the correct data
		// type
		Object valueObject = null;
		try {
			valueObject = attribute.getEType().getEPackage().getEFactoryInstance()
					.createFromString(attribute.getEAttributeType(), value);
		} catch (Exception e) {

			// if an integer-based value is represented as boolean (e.g. as it
			// was used by an 'expression'), try to set this instead
			//
			if (value.endsWith(".0")) {
				try {
					valueObject = attribute.getEType().getEPackage().getEFactoryInstance()
							.createFromString(attribute.getEAttributeType(), value.replaceFirst(".0$", ""));
				} catch (Exception e1) {
					throw e;
				}
			} else if (FeatureMapUtil.isFeatureMap(attribute)) {
				throw new IllegalArgumentException(
						"Setting values of Attributes of type EFeatureMapEntry is currently not supported!", e);
			} else {
				throw new IllegalArgumentException(e);
			}
		}
		return valueObject;
	}

	/**
	 * This sets the value of a {@link VirtualAttribute}.
	 *
	 * @param attr
	 *            The {@link VirtualAttribute} for that the given 'value' shall be set.
	 * @param value
	 *            The value to be set.
	 */
	void setAttributeValue(final VirtualAttribute<?, ?, ?, ?> attr, final String value) {

		this.virtualAttributeValues.put(attr, value);

		this.attrValRegistry.registerValue(attr, this.eObject.eClass(), value);
	}

	/**
	 * This returns the {@link EObjectWrapper element or elements} determined by iteratively evaluating the given list
	 * of {@link TargetSectionReference TargetSectionReferences}.
	 * <p />
	 * The referenced elements are determined by redirecting to {@link EStructuralFeature#eGet(EStructuralFeature)} and
	 * then determining the {@link EObjectWrapper EObjectWrappers} for the determined {@link EObject EObjects} based on
	 * the {@link #targetSectionRegistry}.
	 * <p />
	 * Note: As EReferences can be {@link EStructuralFeature#isMany() many-valued}, this will return either no value, a
	 * single value, or a list of values.
	 *
	 * @param references
	 *            The {@link TargetSectionReference references} that are iteratively applied to determine the elements
	 *            to return.
	 * @return The determined referenced elements (either an empty list, a list consisting of a single value, or
	 *         multiple values). If <em>eReferences</em> is empty, returns a list containing the given <em>eObject</em>.
	 */
	public List<EObjectWrapper> getReferencedElements(List<TargetSectionReference> references) {

		if (references.isEmpty()) {
			return Arrays.asList(this);
		}

		TargetSectionReference firstReference = references.remove(0);

		if (!(firstReference instanceof ActualReference<?, ?, ?, ?>)) {
			throw new RuntimeException(
					"Internal Error! Currently, only ActualReferences are supported by the EObjectWrapper...");
		}

		List<EObjectWrapper> referencedElements = AgteleEcoreUtil
				.getStructuralFeatureValueAsList(this.eObject,
						((ActualReference<?, ?, ?, ?>) firstReference).getEReference())
				.stream().filter(e -> e instanceof EObject).map(e -> (EObject) e)
				.map(this.targetSectionRegistry::getInstanceWrapper).filter(e -> e instanceof EObjectWrapper)
				.collect(Collectors.toList());

		return referencedElements.stream().flatMap(e -> e.getReferencedElements(new ArrayList<>(references)).stream())
				.collect(Collectors.toList());

	}

	/**
	 * This creates a String representation of an EObject that includes the values of all {@link ActualAttribute
	 * ActualAttributes}.
	 *
	 * @param eObject
	 *            The {@link EObject} for that the String representation shall be created.
	 * @return The String representation.
	 */
	public static String asString(final EObject eObject) {

		return EObjectWrapper.asStringBuilder(eObject).toString();
	}

	/**
	 * This creates a String representation of an EObject that includes the values of all {@link ActualAttribute
	 * ActualAttributes}.
	 *
	 * @param eObject
	 *            The {@link EObject} for that the String representation shall be created.
	 * @return The String representation as {@link StringBuilder}.
	 */
	protected static StringBuilder asStringBuilder(final EObject eObject) {

		StringBuilder returnString = new StringBuilder(eObject.eClass().getName()).append(" (");
		for (final EAttribute a : eObject.eClass().getEAllAttributes()) {
			final String val = EObjectWrapper.convertAttributeValue(eObject, a);
			if (val != null) {
				returnString.append("\n    ").append(a.getName()).append(": ").append(val);
			}
		}
		returnString.append("\n)");
		return returnString;
	}

	/**
	 * Static helper method for converting an attribute value of the given 'eObject' to a String representation.
	 *
	 * @param eObject
	 *            The {@link EObject} for that the attribute value shall be returned.
	 * @param attr
	 *            The {@link EAttribute} whose value shall be returned.
	 * @return A String representation of the attribute value.
	 */
	private static String convertAttributeValue(final EObject eObject, final EAttribute attr) {

		if (attr == null) {
			return null;
		}

		final Object srcAttr = eObject.eGet(attr);
		try {
			if (!attr.isMany()) {
				return attr.getEType().getEPackage().getEFactoryInstance().convertToString(attr.getEAttributeType(),
						srcAttr);
			} else {
				String ret = "";
				Iterator<?> it = ((EList<?>) srcAttr).iterator();
				while (it.hasNext()) {
					ret += attr.getEType().getEPackage().getEFactoryInstance().convertToString(attr.getEAttributeType(),
							it.next());
					if (it.hasNext()) {
						ret += "; ";
					}
				}
				return ret;
			}
		} catch (final Exception e) {
			e.printStackTrace(System.out);
			return srcAttr != null ? srcAttr.toString() : "";
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		StringBuilder returnString = EObjectWrapper.asStringBuilder(this.eObject);

		// Remove the '\n)' at the end of the String
		//
		returnString.delete(returnString.lastIndexOf("\n)"), returnString.length());

		for (final VirtualAttribute<?, ?, ?, ?> a : this.virtualAttributeValues.keySet()) {

			returnString.append("\n    ").append(a.getName()).append("(v): ")
					.append(this.virtualAttributeValues.get(a));
		}

		returnString.append("\n)");
		return returnString.toString();
	}

	/**
	 * If this represents a {@link TargetSection}, return the value of the {@link FileAttribute} associated with this
	 * via the {@link TargetSection#getFile() file} reference.
	 *
	 * @return The value of the {@link FileAttribute} or an empty String if this either does not represent a
	 *         {@link TargetSection} or if the {@link TargetSection#getFile() file} reference has not been set.
	 */
	public String getFile() {

		for (Entry<VirtualAttribute<?, ?, ?, ?>, String> entry : this.virtualAttributeValues.entrySet()) {
			if (entry.getKey() instanceof FileAttribute) {
				return entry.getValue() != null ? entry.getValue() : "";
			}
		}
		return "";
	}

	/**
	 * If this represents a {@link TargetSection}, return the {@link FileAttribute#getFileType() fileType} of the
	 * {@link FileAttribute} associated with this via the {@link TargetSection#getFile() file} reference.
	 *
	 * @return The value of the {@link FileAttribute#getFileType()} or the default value {@link FileType#XMI} if this
	 *         either does not represent a {@link TargetSection}, if the {@link TargetSection#getFile() file} reference
	 *         has not been set, or if no {@link FileAttribute#getFileType()} fileType has been set.
	 */
	public FileType getFileType() {

		for (Entry<VirtualAttribute<?, ?, ?, ?>, String> entry : this.virtualAttributeValues.entrySet()) {
			if (entry.getKey() instanceof FileAttribute) {
				return ((FileAttribute) entry.getKey()).getFileType() == null ? FileType.XMI
						: ((FileAttribute) entry.getKey()).getFileType();
			}
		}
		return FileType.XMI;
	}

}
