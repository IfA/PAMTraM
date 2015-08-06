package de.mfreund.gentrans.transformation.library;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.console.MessageConsoleStream;

import de.mfreund.gentrans.transformation.AttributeValueCalculator;
import de.mfreund.gentrans.transformation.AttributeValueRepresentation;
import de.mfreund.gentrans.transformation.EObjectTransformationHelper;
import de.mfreund.gentrans.transformation.HintValueStorage;
import de.mfreund.gentrans.transformation.TargetSectionConnector;
import de.mfreund.gentrans.transformation.TargetSectionRegistry;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerParameter;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ParameterDescription;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPlugin;
import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintType;
import pamtram.metamodel.AttributeParameter;
import pamtram.metamodel.ContainerParameter;
import pamtram.metamodel.ExternalReferenceParameter;
import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.LibraryParameter;
import pamtram.util.GenLibraryManager;

/**
 * This class is used to instantiate library entries.
 * Therefore, instances are created and stored in the course of the generic transformation.
 * At the end, the corresponding library entries are instantiated.
 * 
 * @author mfreund
 *
 */
public class LibraryEntryInstantiator {

	/**
	 * The {@link LibraryEntry} to be instantiated.
	 */
	final private LibraryEntry libraryEntry;

	/**
	 * This is the public getter for the {@link #libraryEntry}.
	 * @return The {@link #libraryEntry}.
	 */
	public LibraryEntry getLibraryEntry() {
		return libraryEntry;
	}

	/**
	 * This is the {@link EObjectTransformationHelper} that wraps the concrete root instance
	 * that has been created during the transformation for this {@link #libraryEntry}.
	 */
	private EObjectTransformationHelper transformationHelper;

	/**
	 * The {@link InstantiableMappingHintGroup} associated with the library entry.
	 */
	final private InstantiableMappingHintGroup mappingGroup;

	/**
	 * A list of {@link MappingHint}s that are part of the {@link #mappingGroup}.
	 */
	final private List<MappingHint> mappingHints;

	/**
	 * A map of {@link MappingHintType}s and associated {@link Object}s that represent 
	 * hint values to be used during the instantiation.
	 */
	final private HintValueStorage hintValues;

	/**
	 * The {@link MessageConsoleStream} that is used to print messages.
	 */
	private MessageConsoleStream consoleStream;

	/**
	 * This creates an instance.
	 * 
	 * @param libraryEntry The {@link LibraryEntry} to be instantiated.
	 * @param transformationHelper The {@link EObjectTransformationHelper} that wraps one root instance
	 * 			that has been created during the transformation for this {@link #libraryEntry}.
	 * @param mappingGroup The {@link InstantiableMappingHintGroup} associated with the library entry.
	 * @param mappingHints A list of {@link MappingHint}s that are part of the {@link #mappingGroup}.
	 * @param hintValues  A map of {@link MappingHintType}s and associated {@link Object}s that represent 
	 * 			hint values to be used during the instantiation.
	 * @param consoleStream The {@link MessageConsoleStream} that shall be used to print messages. 
	 */
	public LibraryEntryInstantiator(
			LibraryEntry libraryEntry, 
			EObjectTransformationHelper transformationHelper, 
			InstantiableMappingHintGroup mappingGroup,
			List<MappingHint> mappingHints,
			HintValueStorage hintValues,
			final MessageConsoleStream consoleStream) {
		this.libraryEntry = libraryEntry;
		this.transformationHelper = transformationHelper;
		this.mappingGroup = mappingGroup;
		this.mappingHints = mappingHints;
		this.hintValues = hintValues;
		this.consoleStream = consoleStream;
	}

	/**
	 * This instantiates the {@link #libraryEntry} in a given target model.
	 * 
	 * @param manager The {@link GenLibraryManager} that proxies calls to the {@link LibraryPlugin}.  
	 * @param targetModel The target model in which the {@link #libraryEntry} shall be instantiated.
	 * @param calculator The calculator that can be used to calculate attribute values.
	 * @param targetSectionConnector The {@link TargetSectionConnector} that can be used to connect the library entries.
	 * @param targetSectionRegistry The {@link TargetSectionRegistry} that has registered the target sections.
	 * @return <em>true</em> if everything went well, <em>false</em> otherwise.
	 */
	@SuppressWarnings("unchecked")
	public boolean instantiate(GenLibraryManager manager, EObject targetModel, AttributeValueCalculator calculator, TargetSectionConnector targetSectionConnector,
			TargetSectionRegistry targetSectionRegistry) {

		/*
		 * Now, we prepare the parameters.
		 */
		for (LibraryParameter<?> param : libraryEntry.getParameters()) {
			if(param instanceof AttributeParameter) {
				AttributeParameter attParam = ((AttributeParameter) param);

				// find the AttributeMapping for this AttributeParameter
				Collection<Setting> refs = EcoreUtil.UsageCrossReferencer.find(attParam.getAttribute(), mappingHints);
				/*
				 * The number of relevant AttributeMappings should always be 1. Even if multiple instances of this library
				 * entry are to be instantiated, only AttributeMappings that are relevant for this concrete instance
				 * are passed to this LibraryEntryInstantiator.
				 */
				if(refs.size() != 1) {
					return false;
				}
				EObject ref = refs.iterator().next().getEObject();
				if(!(ref instanceof AttributeMapping)) {
					return false;
				}
				AttributeMapping attMapping = (AttributeMapping) ref;

				// calculate the attribute value using the given hint values and the AttributeMapping
				LinkedList<Map<AttributeMappingSourceInterface, AttributeValueRepresentation>> hints = hintValues.getHintValues(attMapping);
				//TODO this somehow fixes the problem when lib entries get inserted multiple times but needs to be checked in more detail
				Map copy = hints.get(0);
				String value = calculator.calculateAttributeValue(attParam.getAttribute(), attMapping, hints);
				hints.add(copy);

				// set the calculated value
				attParam.getOriginalParameter().setNewValue(value);
			} else if(param instanceof ContainerParameter) {

				ContainerParameter contParam = (ContainerParameter) param;

				if(!(mappingGroup instanceof MappingHintGroup)) {
					return false;
				}
				if(!((MappingHintGroup) mappingGroup).getTargetMMSection().equals(contParam.getClass_())) {
					return false;
				}

				/*
				 * As the root instance of the LibraryEntry has already been instantiated by the 
				 * transformation algorithm, we do not have to determine the the container. Instead, we just
				 * delete the created root instance (represented by the 'transformationHelpder) and use its 
				 * container as parameter for the library entry.
				 */
				LinkedList<EObjectTransformationHelper> rootInstances = targetSectionRegistry.getPamtramClassInstances(contParam.getClass_()).get(mappingGroup);
				rootInstances.remove(transformationHelper);
				((AbstractContainerParameter<EObject, EObject>) (contParam.getOriginalParameter())).setContainer(transformationHelper.getEObject().eContainer());
				EcoreUtil.delete(transformationHelper.getEObject());
				targetSectionRegistry.getPamtramClassInstances(contParam.getClass_()).put(mappingGroup, rootInstances);				

			} else if (param instanceof ExternalReferenceParameter) {

				ExternalReferenceParameter extRefParam = (ExternalReferenceParameter) param;

				/*
				 * we do not have to do anything as the target for the parameters has already been set by the TargetSectionInstantiator;
				 * consequently, we just make sure that a target could be determined for every parameter
				 */
				assert extRefParam.getOriginalParameter().getTarget() != null;
			}
		}

		/*
		 * Now, we check if a more specific library entry may be used. This is the case if there was an attribute
		 * mapping for the virtual 'Classpath' attribute that produced a more specific classpath.
		 */

		// This is the original classpath as denoted in the library entry imported into the pamtram model
		String newPath = this.libraryEntry.getPath().getValue();

		// Determine the attribute mapping responsible for the 'Path' attribute
		for (MappingHint mappingHint : mappingHints) {
			if(mappingHint instanceof AttributeMapping && ((AttributeMapping) mappingHint).getTarget().equals(this.libraryEntry.getPath())) {
				AttributeMapping pathMapping = (AttributeMapping) mappingHint;
				newPath = calculator.calculateAttributeValue(this.libraryEntry.getPath(), pathMapping, this.hintValues.getHintValues(pathMapping));
				break;
			}

		}

		de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry libEntryToInsert = this.libraryEntry.getOriginalLibraryEntry();

		// we may import a more specialized library entry
		if(!newPath.equals(this.libraryEntry.getPath().getValue())) {

			de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry moreSpecificEntry = 
					getMoreSpecificEntry(libraryEntry, this.libraryEntry.getPath().getValue(), newPath, manager);
			if(moreSpecificEntry != null) {
				libEntryToInsert = moreSpecificEntry;
			}

		}

		/*
		 * Before inserting the library entry, we check if the user provided a custom 'id' that will among others
		 * affect the names of the elements to be created.
		 */
		for (MappingHint mappingHint : mappingHints) {
			if(mappingHint instanceof AttributeMapping && ((AttributeMapping) mappingHint).getTarget().equals(this.libraryEntry.getId())) {
				AttributeMapping idMapping = (AttributeMapping) mappingHint;
				String id = calculator.calculateAttributeValue(this.libraryEntry.getId(), idMapping, this.hintValues.getHintValues(idMapping));
				if(id != null && !id.isEmpty()) {
					libEntryToInsert.getParameterDescription().setID(id);
				}
				break;
			}

		}

		/*
		 * Finally, insert the library entry into the target model as all parameters have been filled out
		 */
		manager.insertIntoTargetModel(targetModel, libEntryToInsert, newPath);

		return true;
	}

	/**
	 * This retrieves an entry for the given 'newPath' from the library, checks if the parameters match those
	 * of the old library entry, copies the old parameters to the new entry and returns the new entry.
	 * 
	 * @param oldEntry The existing {@link LibraryEntry} that shall be replaced.
	 * @param oldPath The classpath of the '<em>oldEntry</em>'.
	 * @param newPath The new (more specific) classpath for that an entry shall be retrieved.
	 * @param manager The {@link GenLibraryManager} that shall be used to retrieve library entries.
	 * @return The new {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry} for the given '<em>newPath</em>' 
	 * with all parameter values extracted from the '<em>oldEntry</em>'. If there is specific entry with matching parameters for 
	 * the given '<em>newPath</em>', this returns '<em><b>null</b></em>'.
	 */
	private de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry getMoreSpecificEntry(LibraryEntry oldEntry, String oldPath, String newPath, GenLibraryManager manager) {

		de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry newEntry = null;

		/*
		 * Now, we move up in the classpath until we find a library entry that has matching paramters.
		 */
		String[] newPathSegments = newPath.replace("^" + oldPath + "/", "").split("/");
		String resultPath = newPath;

		int i = newPathSegments.length - 1;
		do {
			newEntry = manager.getLibraryEntry(resultPath, false);
			if(newEntry != null) {

				ParameterDescription oldParams = oldEntry.getOriginalLibraryEntry().getParameterDescription();
				ParameterDescription newParams = newEntry.getParameterDescription();

				//TODO up to now, we just compare the types of the existing parameters; maybe there is a way to get a better comparison result???
				// check (and replace) container parameters
				if(oldParams.getContainerParameters().size() == newParams.getContainerParameters().size()) {
					boolean equal = true;
					for (int j = 0; j < oldParams.getContainerParameters().size(); j++) {
						if(!oldParams.getContainerParameters().get(j).eClass().equals(newParams.getContainerParameters().get(j).eClass())) {
							equal = false;
							break;
						} else {
							newParams.getContainerParameters().get(j).setContainer(oldParams.getContainerParameters().get(j).getContainer());
						}
					}
					if(!equal) {
						newEntry = null;
						continue;
					}
				}

				// check (and replace) attribute parameters
				if(oldParams.getAttributeParameters().size() == newParams.getAttributeParameters().size()) {
					boolean equal = true;
					for (int j = 0; j < oldParams.getAttributeParameters().size(); j++) {
						if(!oldParams.getAttributeParameters().get(j).eClass().equals(newParams.getAttributeParameters().get(j).eClass())) {
							equal = false;
							break;
						} else {
							newParams.getAttributeParameters().get(j).setNewValue(oldParams.getAttributeParameters().get(j).getNewValue());
						}
					}
					if(!equal) {
						newEntry = null;
						continue;
					}
				}

				// check (and replace) external reference parameters
				if(oldParams.getExternalReferenceParameters().size() == newParams.getExternalReferenceParameters().size()) {
					boolean equal = true;
					for (int j = 0; j < oldParams.getExternalReferenceParameters().size(); j++) {
						if(!oldParams.getExternalReferenceParameters().get(j).eClass().equals(newParams.getExternalReferenceParameters().get(j).eClass())) {
							equal = false;
							break;
						} else {
							newParams.getExternalReferenceParameters().get(j).setTarget(oldParams.getExternalReferenceParameters().get(j).getTarget());
						}
					}
					if(!equal) {
						newEntry = null;
						continue;
					}
				}

				//TODO check resource parameters

				break;
			} else {
				resultPath = resultPath.replace("/" + newPathSegments[i] + "$", "");
			}
		} while (--i >= 0);

		if(newEntry == null) {
			return null;
		}

		return newEntry;

	}
}
