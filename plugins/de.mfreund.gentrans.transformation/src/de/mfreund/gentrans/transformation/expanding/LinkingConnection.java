/**
 *
 */
package de.mfreund.gentrans.transformation.expanding;

import java.util.Collection;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPath;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceParameter;
import pamtram.structure.library.ExternalReferenceParameter;
import pamtram.structure.library.LibraryEntry;
import pamtram.structure.target.TargetSectionCrossReference;

/**
 * An {@link Connection} that is able to either wrap an {@link EClassConnectionPathBasedConnection} or describe
 * a connection towards a {@link LibraryEntry}.
 *
 * @author mfreund
 */
public class LinkingConnection extends Connection {

	private EClassConnectionPathBasedConnection wrappedConnection;

	private TargetSectionCrossReference reference;

	private LibraryEntry libraryEntry;

	/**
	 * Creates an instance that wraps an {@link EClassConnectionPathBasedConnection}.
	 *
	 * @param startingElement
	 * @param targetElements
	 * @param connectionPath
	 *            The {@link EClassConnectionPath} used to construct the wrapped
	 *            {@link EClassConnectionPathBasedConnection}.
	 * @param targetSectionRegistry
	 * @param logger
	 *
	 */
	public LinkingConnection(EObjectWrapper startingElement, Collection<EObjectWrapper> targetElements,
			EClassConnectionPath connectionPath, TargetSectionRegistry targetSectionRegistry, Logger logger) {

		super(startingElement, targetElements, targetSectionRegistry, logger);

		wrappedConnection = connectionPath != null
				? new EClassConnectionPathBasedConnection(startingElement, connectionPath, targetElements,
						targetSectionRegistry, logger)
				: null;
	}

	/**
	 * Creates an instance that describe a connection towards a {@link LibraryEntry}.
	 * <p />
	 * Note: When {@link #instantiate() instantiated}, this will add all of the {@link #getTargetElements()
	 * targetElements} to the root of a target model.
	 *
	 * @param startingElement
	 * @param reference
	 * @param libraryEntry
	 * @param targetElements
	 * @param targetSectionRegistry
	 * @param logger
	 *
	 */
	public LinkingConnection(EObjectWrapper startingElement, TargetSectionCrossReference reference,
			LibraryEntry libraryEntry, Collection<EObjectWrapper> targetElements,
			TargetSectionRegistry targetSectionRegistry, Logger logger) {

		super(startingElement, targetElements, targetSectionRegistry, logger);

		this.reference = reference;
		this.libraryEntry = libraryEntry;
	}

	@Override
	protected void doInstantiate() {

		if (wrappedConnection != null) {
			instantiateWrappedConnection();
		} else if (libraryEntry != null) {
			instantiateConnectionTowardsLibraryEntry();
		}
	}

	private void instantiateWrappedConnection() {

		wrappedConnection.doInstantiate();
		unconnectedElements = wrappedConnection.unconnectedElements;
	}

	/*
	 * for library entries, we cannot simply add the value as the reference we are handling is not part of the
	 * targetSectionClass; instead we want to specify the value as 'target' for the affected ExternalReferenceParameter
	 */
	private void instantiateConnectionTowardsLibraryEntry() {

		if (targetElements.size() > 1) {
			logger.severe(
					() -> "'ExternalReferenceParameters' of LibraryEntries currently only support setting a single target instance! Using the first of the selected instances for LibraryEntry '"
							+ libraryEntry.toString() + "'!");
		}

		LibraryEntry specificLibEntry = targetSectionRegistry.getLibraryEntryRegistry().get(startingElement)
				.getLibraryEntry();

		ExternalReferenceParameter extRefParam = (ExternalReferenceParameter) specificLibEntry.getParameters()
				.get(libraryEntry.getParameters().indexOf(reference.eContainer()));
		@SuppressWarnings("unchecked")
		AbstractExternalReferenceParameter<EObject, EObject> originalParam = (AbstractExternalReferenceParameter<EObject, EObject>) extRefParam
				.getOriginalParameter();
		originalParam.setTarget(targetElements.iterator().next().getEObject());

	}

}
