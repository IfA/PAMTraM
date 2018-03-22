/**
 *
 */
package de.mfreund.gentrans.transformation.connecting.impl;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EPackage;

import de.mfreund.gentrans.transformation.connecting.EClassConnectionPath;
import de.mfreund.gentrans.transformation.connecting.EClassConnectionPathProvider;
import de.mfreund.gentrans.transformation.connecting.EClassConnectionPathRequirement;

/**
 * A concrete implementation of {@link EClassConnectionPathProvider} that is able to create {@link EClassConnectionPath
 * EClassConnectionPaths} based on {@link EClassConnectionPathRequirement EClassConnectionPathRequirements}. The actual
 * work is delegated to instances of {@link EClassConnectionPathBuilder}.
 *
 * @author mfreund
 */
public class EClassConnectionPathFactory implements EClassConnectionPathProvider {

	private final EClassConnectionInformationRegistry eClassConnectionInformationRegistry;

	/**
	 * This creates an instance without an attached logger.
	 *
	 * @param ePackages
	 *            The collection of {@link EPackage EPackages} that shall be considered when determining potential
	 *            connection paths.
	 */
	public EClassConnectionPathFactory(Collection<EPackage> ePackages) {

		this(ePackages, null);
	}

	/**
	 * This creates an instance with an attached logger.
	 *
	 * @param ePackages
	 *            The collection of {@link EPackage EPackages} that shall be considered when determining potential
	 *            connection paths.
	 * @param logger
	 */
	public EClassConnectionPathFactory(Collection<EPackage> ePackages, Logger logger) {

		eClassConnectionInformationRegistry = logger == null ? new EClassConnectionInformationRegistry()
				: new EClassConnectionInformationRegistry(logger);
		eClassConnectionInformationRegistry.register(ePackages);
	}

	@Override
	public List<EClassConnectionPath> getConnections(EClassConnectionPathRequirement connectionRequirement) {

		EClassConnectionPathBuilder pathBuilder = new EClassConnectionPathBuilder(connectionRequirement,
				eClassConnectionInformationRegistry);

		return pathBuilder.buildConnectionPaths();

	}

}
