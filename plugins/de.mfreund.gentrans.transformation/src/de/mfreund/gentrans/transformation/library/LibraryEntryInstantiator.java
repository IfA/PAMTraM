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
package de.mfreund.gentrans.transformation.library;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.IntStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.mfreund.gentrans.transformation.calculation.ValueCalculator;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.HintValueStorage;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;
import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerParameter;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ParameterDescription;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPlugin;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.extended.AttributeMapping;
import pamtram.mapping.extended.MappingHint;
import pamtram.mapping.extended.MappingHintType;
import pamtram.structure.library.AttributeParameter;
import pamtram.structure.library.ContainerParameter;
import pamtram.structure.library.ExternalReferenceParameter;
import pamtram.structure.library.LibraryEntry;
import pamtram.structure.library.LibraryParameter;
import pamtram.structure.library.ResourceParameter;
import pamtram.util.GenLibraryManager;

/**
 * This class is used to instantiate library entries. Therefore, instances are created and stored in the course of the
 * generic transformation. At the end, the corresponding library entries are instantiated.
 *
 * @author mfreund
 *
 */
public class LibraryEntryInstantiator {

	/**
	 * The {@link LibraryEntry} to be instantiated.
	 */
	private LibraryEntry libraryEntry;

	/**
	 * This is the {@link EObjectWrapper} that wraps the concrete root instance that has been created during the
	 * transformation for this {@link #libraryEntry}.
	 */
	private EObjectWrapper transformationHelper;

	/**
	 * This is the namespace URI identifying the {@link LibraryPlugin} that shall be used to instantiate the
	 * {@link #libraryEntry}.
	 */
	private String ePackageURI;

	/**
	 * The {@link InstantiableMappingHintGroup} associated with the library entry.
	 */
	private InstantiableMappingHintGroup mappingGroup;

	/**
	 * A list of {@link MappingHint}s that are part of the {@link #mappingGroup}.
	 */
	private List<MappingHint> mappingHints;

	/**
	 * A map of {@link MappingHintType}s and associated {@link Object}s that represent hint values to be used during the
	 * instantiation.
	 */
	private HintValueStorage hintValues;

	/**
	 * The {@link Logger} that is used to print messages.
	 */
	private Logger logger;

	/**
	 * This creates an instance.
	 *
	 * @param libraryEntry
	 *            The {@link LibraryEntry} to be instantiated.
	 * @param transformationHelper
	 *            The {@link EObjectWrapper} that wraps one root instance that has been created during the
	 *            transformation for this {@link #libraryEntry}.
	 * @param mappingGroup
	 *            The {@link InstantiableMappingHintGroup} associated with the library entry.
	 * @param mappingHints
	 *            A list of {@link MappingHint}s that are part of the {@link #mappingGroup}.
	 * @param hintValues
	 *            A map of {@link MappingHintType}s and associated {@link Object}s that represent hint values to be used
	 *            during the instantiation.
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages.
	 */
	public LibraryEntryInstantiator(LibraryEntry libraryEntry, EObjectWrapper transformationHelper,
			InstantiableMappingHintGroup mappingGroup, List<MappingHint> mappingHints, HintValueStorage hintValues,
			final Logger logger) {

		this.libraryEntry = libraryEntry;
		this.transformationHelper = transformationHelper;
		EPackage rootPackage = AgteleEcoreUtil.getRootEPackage(transformationHelper.getEObject().eClass());
		ePackageURI = rootPackage != null ? rootPackage.getNsURI() : null;
		this.mappingGroup = mappingGroup;
		this.mappingHints = mappingHints;
		this.hintValues = hintValues;
		this.logger = logger;
	}

	/**
	 * This is the public getter for the {@link #libraryEntry}.
	 *
	 * @return The {@link #libraryEntry}.
	 */
	public LibraryEntry getLibraryEntry() {

		return libraryEntry;
	}

	/**
	 * This instantiates the {@link #libraryEntry} in a given target model.
	 *
	 * @param manager
	 *            The {@link GenLibraryManager} that proxies calls to the {@link LibraryPlugin}.
	 * @param calculator
	 *            The calculator that can be used to calculate attribute values.
	 * @param targetSectionRegistry
	 *            The {@link TargetSectionRegistry} that has registered the target sections.
	 * @return <em>true</em> if everything went well, <em>false</em> otherwise.
	 */
	public boolean instantiate(GenLibraryManager manager, ValueCalculator calculator,
			TargetSectionRegistry targetSectionRegistry) {

		if (!manager.existsImplementationFor(ePackageURI)) {
			return false;
		}

		EObject targetModel = EcoreUtil.getRootContainer(transformationHelper.getEObject());

		/*
		 * Library entries always need to be instantiated in a target model.
		 */
		// TODO may, support for this should be added to the genlibrary
		if (targetModel.equals(transformationHelper.getEObject())) {
			logger.severe(() -> "Internal Error: Could not instantiate library entry for element '"
					+ transformationHelper.getEObject().toString() + "' as the element has no"
					+ "container. This is currently not supported by the 'genlibrary'.");
		}

		/*
		 * Now, we prepare the parameters.
		 */
		boolean prepareParametersResult = prepareParameters(targetSectionRegistry, calculator);

		if (!prepareParametersResult) {
			return false;
		}

		de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry libEntryToInsert = libraryEntry
				.getOriginalLibraryEntry();

		// As the user might have specified a more specific classpath via the virtual 'Classpath' attribute, we need to
		// check if there is a more specific library entry that we will use instead
		//
		de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry moreSpecificEntry = getMoreSpecificEntry(
				libraryEntry, libraryEntry.getClasspath().getValue(), libraryEntry.getClasspath().getValue(), manager);

		if (moreSpecificEntry != null) {
			libEntryToInsert = moreSpecificEntry;
		}

		/*
		 * Before inserting the library entry, we check if the user provided a custom 'id' that will among others affect
		 * the names of the elements to be created.
		 */
		String id = libraryEntry.getId().getValue();

		if (id != null && !id.isEmpty()) {
			libEntryToInsert.getParameterDescription().setID(id);
		}

		/*
		 * Finally, insert the library entry into the target model as all parameters have been filled out
		 */
		de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry insertedEntry = manager
				.insertIntoTargetModel(targetModel, libEntryToInsert, libraryEntry.getClasspath().getValue());

		if (insertedEntry == null) {
			logger.severe(
					() -> "Failed to instantiate library entry '" + getLibraryEntry().getClasspath().getValue() + "'!");
			return false;
		}

		/*
		 * Now, we update the eObject wrapped by the 'transformationHelper' so this will point to the right element if
		 * any further algorithms try to evaluate this.
		 */
		transformationHelper
				.setEObject(insertedEntry.getParameterDescription().getContainerParameters().get(0).getSource());

		return true;
	}

	/**
	 * This prepares the {@link LibraryParameter parameters} defined by the {@link #libraryEntry}.
	 * <p />
	 * This means that the new values for the parameters are set, e.g. the
	 * {@link AbstractContainerParameter#setContainer(Object) container} for a ContainerParameter.
	 *
	 * @param targetSectionRegistry
	 *            The {@link TargetSectionRegistry} keeping track of created elements. This is used to retrieve
	 *            containers for {@link ContainerParameter ContainerParameters} and targets for
	 *            {@link ExternalReferenceParameter ExternalReferenceParameters}.
	 * @param calculator
	 *            The {@link ValueCalculator} that shall be used to calculate attribute values.
	 * @return '<em><b>true</b></em>' if everything went well; '<em><b>false</b></em>' if an error occurred.
	 */
	@SuppressWarnings("unchecked")
	private boolean prepareParameters(TargetSectionRegistry targetSectionRegistry, ValueCalculator calculator) {

		for (LibraryParameter<?> param : libraryEntry.getParameters()) {

			if (param instanceof AttributeParameter) {

				AttributeParameter attParam = (AttributeParameter) param;

				/*
				 * we do not have to do anything as the new value for the parameters has already been set by the
				 * TargetSectionInstantiator; consequently, we just make sure that a new value has been set for every
				 * parameter
				 */
				if (attParam.getOriginalParameter().getNewValue() == null) {
					logger.severe(() -> "Internal Error: The new value for the AttributeParameter '"
							+ attParam.getName() + "' could not be determined!");
					return false;
				}

			} else if (param instanceof ContainerParameter) {

				ContainerParameter contParam = (ContainerParameter) param;

				/*
				 * As the root instance of the LibraryEntry has already been instantiated by the transformation
				 * algorithm, we do not have to determine the the container. Instead, we just delete the created root
				 * instance (represented by the 'transformationHelpder) and use its container as parameter for the
				 * library entry.
				 */
				List<EObjectWrapper> rootInstances = targetSectionRegistry
						.getPamtramClassInstances(((MappingHintGroup) mappingGroup).getTargetSection())
						.get(mappingGroup);

				((AbstractContainerParameter<EObject, EObject>) contParam.getOriginalParameter())
						.setContainer(transformationHelper.getEObject().eContainer());

				EcoreUtil.delete(transformationHelper.getEObject());

				targetSectionRegistry.getPamtramClassInstances(((MappingHintGroup) mappingGroup).getTargetSection())
						.put(mappingGroup, rootInstances);

			} else if (param instanceof ExternalReferenceParameter) {

				ExternalReferenceParameter extRefParam = (ExternalReferenceParameter) param;

				/*
				 * we do not have to do anything as the target for the parameters has already been set by the
				 * TargetSectionInstantiator; consequently, we just make sure that a target could be determined for
				 * every parameter
				 */
				if (extRefParam.getOriginalParameter().getTarget() == null) {
					logger.severe(() -> "Internal Error: The target for the ExternalReferenceParameter '"
							+ extRefParam.getName() + "' could not be determined!");
					return false;
				}
			}
		}

		for (ResourceParameter resParam : libraryEntry.getResourceParameters()) {

			// We need to compare the VirtualAttributes by their value instead
			// of directly comparing the instances
			// because
			// those will be two different instances because of the previous
			// cloning of the library entry
			//
			Optional<AttributeMapping> resParamMapping = mappingHints.parallelStream()
					.filter(mappingHint -> mappingHint instanceof AttributeMapping && resParam.getAttribute().getValue()
							.equals(((AttributeMapping) mappingHint).getTarget().getValue()))
					.map(mappingHint -> (AttributeMapping) mappingHint).findAny();

			if (resParamMapping.isPresent()) {
				resParam.getOriginalParameter().setNewPath(hintValues.getHintValues(resParamMapping.get()).get(0));
			} else if (resParam.getAttribute().getValue() != null && !resParam.getAttribute().getValue().isEmpty()) {
				resParam.getOriginalParameter().setNewPath(resParam.getAttribute().getValue());
			}

		}

		return true;
	}

	/**
	 * This retrieves an entry for the given 'newPath' from the library, checks if the parameters match those of the old
	 * library entry, copies the old parameters to the new entry and returns the new entry. If there is no match for the
	 * given 'newPath', this algorithm goes up in the classpath and tries to determine a more abstract entry. The
	 * resulting classpath for that an entry could be determined is stored in the {@link LibraryEntry#getClasspath()}
	 * variable of the 'oldEntry' and can be evaulated by clients.
	 *
	 * @param oldEntry
	 *            The existing {@link LibraryEntry} that shall be replaced.
	 * @param oldPath
	 *            The classpath of the '<em>oldEntry</em>'.
	 * @param newPath
	 *            The new (more specific) classpath for that an entry shall be retrieved.
	 * @param manager
	 *            The {@link GenLibraryManager} that shall be used to retrieve library entries.
	 * @return The new {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry} for the given
	 *         '<em>newPath</em>' with all parameter values extracted from the '<em>oldEntry</em>'. If there is specific
	 *         entry with matching parameters for the given '<em>newPath</em>', this returns '<em><b>null</b></em>'.
	 */
	private de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry getMoreSpecificEntry(LibraryEntry oldEntry,
			String oldPath, String newPath, GenLibraryManager manager) {

		de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry newEntry;

		/*
		 * Now, we move up in the classpath until we find a library entry that has matching parameters.
		 */
		String[] newPathSegments = newPath.replaceAll("^" + oldPath + ".", "").split("\\.");
		String resultPath = newPath;

		int i = newPathSegments.length - 1;
		do {

			newEntry = manager.getLibraryEntry(ePackageURI, resultPath, false);

			// An entry for the given path has been found. Now, we need to check
			// if the parameters
			// match.
			//
			if (newEntry != null) {

				ParameterDescription oldParams = oldEntry.getOriginalLibraryEntry().getParameterDescription();
				ParameterDescription newParams = newEntry.getParameterDescription();

				boolean parametersMatch = checkParameters(oldParams, newParams);

				if (parametersMatch) {

					updateParameters(oldParams, newParams);
					break;
				}

			}

			// Move upward in the inheritance hierarchy of the classpath
			//
			resultPath = resultPath.replaceAll("." + newPathSegments[i] + "$", "");

		} while (--i >= 0);

		if (newEntry == null) {
			return null;
		}

		// we update the resulting path
		oldEntry.getClasspath().setValue(resultPath);
		return newEntry;

	}

	/**
	 * Compare the two given {@link ParameterDescription ParameterDescriptions} and -- if they are <em>equal</em> --
	 * copy the values of the <em>oldParams</em> to the </em>newParams</em> so that they can be used to instantiate a
	 * library entry.
	 * <p />
	 * In order to determine if the two descriptions are <em>equal</em>, we currently compare the numbers and types of
	 * parameters.
	 *
	 * @param oldParams
	 *            The {@link ParameterDescription} representing the <em>old</em> entry.
	 * @param newParams
	 *            The {@link ParameterDescription} representing the <em>new</em> entry that shall replace the old entry
	 *            if possible.
	 * @return '<em><b>true</b></em>' if the new {@link ParameterDescription} is a valid replacement for the old one.
	 */
	private boolean checkParameters(ParameterDescription oldParams, ParameterDescription newParams) {

		// TODO up to now, we just compare the types of the existing parameters;
		// maybe there is a way to get a better
		// comparison result???
		// TODO check resource parameters

		// First, only check if the numbers of parameters match
		//
		if (oldParams.getContainerParameters().size() != newParams.getContainerParameters().size()
				|| oldParams.getAttributeParameters().size() != newParams.getAttributeParameters().size() || oldParams
						.getExternalReferenceParameters().size() != newParams.getExternalReferenceParameters().size()) {

			return false;
		}

		// Now, check if the types match
		//
		if (!IntStream.range(0, oldParams.getContainerParameters().size()).parallel().allMatch(i -> oldParams
				.getContainerParameters().get(i).eClass().equals(newParams.getContainerParameters().get(i).eClass()))) {
			return false;
		}

		if (!IntStream.range(0, oldParams.getAttributeParameters().size()).parallel().allMatch(i -> oldParams
				.getAttributeParameters().get(i).eClass().equals(newParams.getAttributeParameters().get(i).eClass()))) {
			return false;
		}

		if (!IntStream.range(0, oldParams.getExternalReferenceParameters().size()).parallel()
				.allMatch(i -> oldParams.getExternalReferenceParameters().get(i).eClass()
						.equals(newParams.getExternalReferenceParameters().get(i).eClass()))) {
			return false;
		}

		return true;
	}

	/**
	 * Copy the values of the <em>oldParams</em> to the </em>newParams</em> so that they can be used to instantiate a
	 * library entry.
	 * <p />
	 * Note: Before this is called, {@link #checkParameters(ParameterDescription, ParameterDescription)} should be
	 * called in order to ensure that both given {@link ParameterDescription ParameterDescriptions} <em>match</em>.
	 *
	 * @param oldParams
	 *            The {@link ParameterDescription} representing the <em>old</em> entry from that the parameter values
	 *            are copied to the <em>new</em> entry.
	 * @param newParams
	 *            The {@link ParameterDescription} representing the <em>new</em> entry that shall replace the old entry.
	 */
	private void updateParameters(ParameterDescription oldParams, ParameterDescription newParams) {

		// Parameters match -> now, we can replace the parameter values
		//
		IntStream.range(0, oldParams.getContainerParameters().size()).parallel()
				.forEach(i -> newParams.getContainerParameters().get(i)
						.setContainer(oldParams.getContainerParameters().get(i).getContainer()));

		IntStream.range(0, oldParams.getAttributeParameters().size()).parallel().forEach(i -> newParams
				.getAttributeParameters().get(i).setNewValue(oldParams.getAttributeParameters().get(i).getNewValue()));

		IntStream.range(0, oldParams.getExternalReferenceParameters().size()).parallel()
				.forEach(i -> newParams.getExternalReferenceParameters().get(i)
						.setTarget(oldParams.getExternalReferenceParameters().get(i).getTarget()));

	}
}
