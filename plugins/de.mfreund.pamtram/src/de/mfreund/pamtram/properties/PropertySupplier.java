package de.mfreund.pamtram.properties;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;

import de.tud.et.ifa.agtele.resources.ResourceHelper;

/**
 * This class is responsible for the definition of properties for the PAMTraM
 * plug-ins and default values for these properties.
 *
 * @author mfreund
 */
public abstract class PropertySupplier {

	/**
	 * This property is used to specify that the project is equipped with the
	 * 'PAMTraM Library Nature' ('true' or 'false').
	 */
	public static final String PROP_HAS_LIBRARY_NATURE = "HAS-LIBRARY-NATURE";

	/**
	 * This property is used to specify the paths to the folders that contain
	 * the libraries to be used for this project. If multiple paths are
	 * specified, these are separated by a ';'.
	 */
	public static final String PROP_LIBRARY_PATHS = "LIBRARY-PATHS";

	/**
	 * This represents the default value for the {@link #PROP_LIBRARY_PATHS}
	 * property.
	 */
	public static final String DEFAULT_LIBRARY_PATHS = "";

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
	 * Create an instance. This should not be necessary as we only declare
	 * static fields and methods.
	 */
	private PropertySupplier() {
	}

	/**
	 * This returns the value of the persistent property identified by the given
	 * <b>propertyName</b> for a given <b>resource</b>. If the property has not
	 * set for the resource previously, the default value for the property is
	 * returned.
	 *
	 * @param propertyName
	 *            The identifier of the property to be retrieved (one of the
	 *            static final fields of this class starting with
	 *            <em>PROP_</em>).
	 * @param project
	 *            The project for which the property shall be retrieved (must
	 *            not be <em>null</em>).
	 * @return The value of the property, the default property value if the
	 *         value has not been set before or <em>null</em> if an unknown
	 *         propertyName has been passed as argument.
	 * @throws CoreException
	 *             if this method fails
	 */
	public static String getResourceProperty(String propertyName, IProject project) throws CoreException {

		String propertyValue = project
				.getPersistentProperty(new QualifiedName(PropertySupplier.PROPERTY_QUALIFIER, propertyName));

		switch (propertyName) {
		case PROP_HAS_LIBRARY_NATURE:
			// check if the nature is set on the project
			propertyValue = String.valueOf(Arrays.asList(project.getDescription().getNatureIds())
					.contains("de.mfreund.pamtram.pamtramLibraryNature"));
			break;
		case PROP_LIBRARY_PATHS:
			// return the default value if necessary
			if (propertyValue == null) {
				propertyValue = PropertySupplier.DEFAULT_LIBRARY_PATHS;
			}
			break;
		default:
			break;
		}

		return propertyValue;
	}

	/**
	 * This returns the value of the persistent property identified by the given
	 * <b>propertyName</b> for a given <b>resource</b>. If the property has not
	 * set for the resource previously, the default value for the property is
	 * returned.
	 *
	 * @param propertyName
	 *            The identifier of the property to be retrieved (one of the
	 *            static final fields of this class starting with
	 *            <em>PROP_</em>).
	 * @param propertyValue
	 *            The value of the property, the default property value if the
	 *            value has not been set before or <em>null</em> if an unknown
	 *            propertyName has been passed as argument.
	 * @param project
	 *            The project for which the property shall be retrieved (must
	 *            not be <em>null</em>).
	 * @throws CoreException
	 *             if this method fails
	 */
	public static void setResourceProperty(String propertyName, String propertyValue, IProject project)
			throws CoreException {

		if (propertyValue == null || project == null) {
			return;
		}

		switch (propertyName) {
		case PROP_HAS_LIBRARY_NATURE:
			IProjectDescription projectDescription = project.getDescription();

			// Add/Remove the nature to/from the project
			//
			String[] natures = projectDescription.getNatureIds();
			java.util.List<String> newNatures = new ArrayList<>(Arrays.asList(natures));
			if (Boolean.parseBoolean(propertyValue)) {
				newNatures.add("de.mfreund.pamtram.pamtramLibraryNature");
			} else {
				newNatures.remove("de.mfreund.pamtram.pamtramLibraryNature");
			}

			projectDescription.setNatureIds(newNatures.toArray(new String[] {}));
			project.setDescription(projectDescription, null);

			ResourceHelper.refresh(project);

			break;
		case PROP_LIBRARY_PATHS:
			// Set the library paths
			//
			project.setPersistentProperty(
					new QualifiedName(PropertySupplier.PROPERTY_QUALIFIER, PropertySupplier.PROP_LIBRARY_PATHS),
					propertyValue);
			break;
		default:
			break;
		}

	}

}
