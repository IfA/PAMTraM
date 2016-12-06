package de.mfreund.pamtram.properties;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;

/**
 * This class is responsible for the definition of properties for the PAMTraM plug-ins and default values for these
 * properties.
 *
 * @author mfreund
 */
public abstract class PropertySupplier {

	/**
	 * This property is used to specify the path to the folder that contains the target library to be used for this
	 * project.
	 */
	public static final String PROP_LIBRARY_TARGET_PATH = "LIBRARY-TARGET-PATH";

	/**
	 * This represents the default value for the {@link #PROP_LIBRARY_TARGET_PATH} property.
	 */
	public static final String DEFAULT_LIBRARY_TARGET_PATH = "";

	/*
	 * More properties can be defined here...
	 */
	// public static final ...
	// public static final ...

	/**
	 * This is the id of the bundle that identifies the properties.
	 */
	public static final String PROPERTY_QUALIFIER = "de.mfreund.pamtram";

	/**
	 * Create an instance. This should not be necessary as we only declare static fields and methods.
	 */
	private PropertySupplier() {
	}

	/**
	 * This returns the value of the persistent property identified by the given <b>propertyName</b> for a given
	 * <b>resource</b>. If the property has not set for the resource previously, the default value for the property is
	 * returned.
	 *
	 * @param propertyName
	 *            The identifier of the property to be retrieved (one of the static final fields of this class starting
	 *            with <em>PROP_</em>).
	 * @param resource
	 *            The resource for which the property shall be retrieved (must not be <em>null</em>).
	 * @return The value of the property, the default property value if the value has not been set before or
	 *         <em>null</em> if an unknown propertyName has been passed as argument.
	 * @throws CoreException
	 *             if this method fails
	 */
	public static String getResourceProperty(String propertyName, IResource resource) throws CoreException {

		String propertyValue = resource
				.getPersistentProperty(new QualifiedName(PropertySupplier.PROPERTY_QUALIFIER, propertyName));

		if (propertyValue != null) {
			return propertyValue;
		}

		// return the default value if necessary
		switch (propertyName) {
			case PROP_LIBRARY_TARGET_PATH:
				propertyValue = PropertySupplier.DEFAULT_LIBRARY_TARGET_PATH;
				break;
			default:
				break;
		}
		return propertyValue;
	}

}
