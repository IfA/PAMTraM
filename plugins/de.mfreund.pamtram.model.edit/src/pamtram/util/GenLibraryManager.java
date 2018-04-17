/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package pamtram.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.tud.et.ifa.agtele.genlibrary.LibraryImplementationRegistry;
import de.tud.et.ifa.agtele.genlibrary.processor.impl.LibraryPluginImpl;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryContext;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPlugin;
import pamtram.structure.library.LibraryEntry;

/**
 * This class is responsible for creating, initializing, and (if necessary) updating an instance of the genlibrary
 * {@link LibraryPluginImpl} to be used during the generic transformation. Furthermore, other necessary elements like a
 * {@link LibraryContext} is managed as well.
 *
 * @author mfreund
 */
public class GenLibraryManager {

	/**
	 * The {@link Logger} that shall be used to print messages to the user.
	 */
	private Logger logger;

	/**
	 * This holds the instances of {@link LibraryPlugin} that are used for retrieving and instantiating library entries
	 * sorted by their associated ePackage URIs.
	 * <p />
	 * <b>This should only be accessed via the {@link #getLibraryPlugin()} method!</b>
	 */
	private Map<String, LibraryPlugin> libraryPlugins;

	/**
	 * This holds the list of namespaceURIs for which no {@link LibraryPlugin} could be determined.
	 */
	private List<String> missingLibraryPlugins;

	/**
	 * This creates an instance.
	 *
	 * @see #GenLibraryManager(List, Logger)
	 *
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages to the user or '<em>null</em>' if no messages
	 *            shall be printed.
	 */
	public GenLibraryManager(Logger logger) {

		this.logger = logger;
		this.libraryPlugins = new HashMap<>();
		this.missingLibraryPlugins = new ArrayList<>();
	}

	/**
	 * This creates an instance.
	 *
	 * @see #GenLibraryManager(Logger)
	 *
	 * @param libPaths
	 *            A list of paths to the libraries that can be used to retrieve {@link LibraryEntry LibraryEntries}.
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages to the user or '<em>null</em>' if no messages
	 *            shall be printed.
	 */
	public GenLibraryManager(List<String> libPaths, Logger logger) {

		this(logger);

		libPaths.stream().forEach(this::addLibPath);
	}

	/**
	 * This returns the instance of {@link LibraryPlugin} that is used for retrieving and instantiating library entries
	 * for the given <em>ePackageURI</em>.
	 *
	 * @param ePackageURI
	 *            The namespace URI of the {@link EPackage} for which the associated {@link LibraryPlugin} shall be
	 *            returned.
	 * @return The instance.
	 */
	private LibraryPlugin getLibraryPlugin(String ePackageURI) {

		if (!this.libraryPlugins.containsKey(ePackageURI) && !this.missingLibraryPlugins.contains(ePackageURI)) {

			LibraryPlugin libraryPlugin = LibraryImplementationRegistry.getInstance().createLibraryPlugin(ePackageURI);

			if (libraryPlugin == null) {
				if (this.logger != null) {
					this.logger.severe(
							() -> "Unable to find GenLibrary implementation for namespace URI '" + ePackageURI + "'!");
				}
				this.missingLibraryPlugins.add(ePackageURI);
			} else {
				if (this.logger != null) {
					this.logger.info(() -> "Found GenLibrary implementation for namespace URI '" + ePackageURI + "'");
				}
				this.libraryPlugins.put(ePackageURI, libraryPlugin);
			}
		}

		return this.libraryPlugins.get(ePackageURI);
	}

	/**
	 * This can be used to check if a concrete implementation of {@link LibraryPlugin} exists for the given
	 * <em>ePackageURI</em>.
	 *
	 * @param ePackageURI
	 *            The namespace URI of an {@link EPackage}.
	 * @return '<em>true</em>' if an implementation of {@link LibraryPlugin} exists for the given URI; <em>false</em>
	 *         otherwise.
	 */
	public boolean existsImplementationFor(String ePackageURI) {

		return this.getLibraryPlugin(ePackageURI) != null;
	}

	/**
	 * Register a new library to be managed.
	 * <p />
	 * Note: This will automatically determine the namespace URI of the EPackage that the library located at the given
	 * <em>libPath</em> defines entries for and register the new library for the correct {@link #libraryPlugins
	 * libraryPlugin}.
	 *
	 * @param libPath
	 *            The path to the library to be used to retrieve the LibraryEntry.
	 * @return <em>true</em> if the library was registered successfully for the given ePackage; <em>false</em>
	 *         otherwise.
	 */
	public boolean addLibPath(String libPath) {

		this.logger.info(() -> "Registering library location '" + libPath + "'...");

		String ePackageURI = LibraryImplementationRegistry.getInstance().getNamespaceForLibrary(libPath);

		LibraryPlugin plugin = this.getLibraryPlugin(ePackageURI);

		if (plugin == null) {
			return false;
		}

		plugin.addLibPath(libPath);

		return true;
	}

	/**
	 * This returns the {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry} for a given classpath. If
	 * <em>useHigher</em> is set to '<em><b>true</b></em>', a more abstract library entry will be returned if no entry
	 * can be determined for the given path.
	 *
	 * @param ePackageURI
	 *            The namespace URI of the {@link EPackage} for that a LibraryEntry shall be returned.
	 * @param classPath
	 *            The classPath that is used to retrieve the LibraryEntry.
	 * @param useHigher
	 *            Whether a more abstract LibraryEntry may be used.
	 * @return The retrieved LibraryEntry.
	 */
	public de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry getLibraryEntry(String ePackageURI,
			String classPath, boolean useHigher) {

		LibraryPlugin plugin = this.getLibraryPlugin(ePackageURI);
		return plugin != null ? this.getLibraryPlugin(ePackageURI).getElement(classPath, useHigher) : null;
	}

	/**
	 * This inserts the given library item into the given target model while taking the given Parameters into account.
	 * This is done by calling the function
	 * {@link LibraryPlugin#insertIntoTargetModel(EObject, de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry, String)}.
	 *
	 * @param targetModel
	 *            The target model into that the given library item shall be inserted.
	 * @param libraryEntry
	 *            The {@link LibraryEntry} to be inserted into the target model.
	 * @return The {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry} that has been inserted in the
	 *         target model.
	 */
	public de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry insertIntoTargetModel(EObject targetModel,
			LibraryEntry libraryEntry) {

		/*
		 * We need to create a self-contained copy of the library entry and pass it to the LibraryPlugin. Otherwise, the
		 * same instance (just with new parameters values) might be inserted multiple times in case of cardinalities > 1
		 * if the caller would not handle this by himself. This would lead to strange behavior.
		 */
		de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry originalLibraryEntry = EcoreUtil
				.copy(libraryEntry.getOriginalLibraryEntry());

		EObject rootPackage = EcoreUtil.getRootContainer(targetModel.eClass());

		if (!(rootPackage instanceof EPackage)) {
			return null;
		}

		LibraryPlugin plugin = this.getLibraryPlugin(((EPackage) rootPackage).getNsURI());

		if (plugin == null) {
			return null;
		}

		plugin.insertIntoTargetModel(targetModel, originalLibraryEntry, libraryEntry.getClasspath().getValue());

		return originalLibraryEntry;
	}

	/**
	 * This inserts the given library item into the given target model while taking the given Parameters into account.
	 * This is done by calling the function
	 * {@link LibraryPlugin#insertIntoTargetModel(EObject, de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry, String)}.
	 *
	 * @param targetModel
	 *            The target model into that the given library item shall be inserted.
	 * @param libraryEntry
	 *            The {@link LibraryEntry} to be inserted into the target model.
	 * @param path
	 *            The classpath of the '<em>libraryEntry</em>' to be inserted.
	 * @return The {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry} that has been inserted in the
	 *         target model.
	 */
	public de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry insertIntoTargetModel(EObject targetModel,
			de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry libraryEntry, String path) {

		/*
		 * We need to create a self-contained copy of the library entry and pass it to the LibraryPlugin. Otherwise, the
		 * same instance (just with new parameters values) might be inserted multiple times in case of cardinalities > 1
		 * if the caller would not handle this by himself. This would lead to strange behavior.
		 */
		de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry originalLibraryEntry = EcoreUtil
				.copy(libraryEntry);

		EObject rootPackage = EcoreUtil.getRootContainer(targetModel.eClass());

		if (!(rootPackage instanceof EPackage)) {
			return null;
		}

		LibraryPlugin plugin = this.getLibraryPlugin(((EPackage) rootPackage).getNsURI());

		if (plugin == null) {
			return null;
		}

		plugin.insertIntoTargetModel(targetModel, originalLibraryEntry, path);

		return originalLibraryEntry;
	}

}
