package de.mfreund.gentrans.transformation.library;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.console.MessageConsoleStream;

import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.AttributeMatcher;
import pamtram.mapping.AttributeMatcherSourceInterface;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintType;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.metamodel.AttributeParameter;
import pamtram.metamodel.ContainerParameter;
import pamtram.metamodel.ExternalReferenceParameter;
import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.LibraryParameter;
import pamtram.util.GenLibraryManager;
import de.mfreund.gentrans.transformation.AttributeValueCalculator;
import de.mfreund.gentrans.transformation.AttributeValueRepresentation;
import de.mfreund.gentrans.transformation.EObjectTransformationHelper;
import de.mfreund.gentrans.transformation.HintValueStorage;
import de.mfreund.gentrans.transformation.TargetSectionConnector;
import de.mfreund.gentrans.transformation.TargetSectionRegistry;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerParameter;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceParameter;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPlugin;

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
	 * that has been created during the transformation for this {@link #libraryEntry.
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
	 * @param mappingGroupThe {@link InstantiableMappingHintGroup} associated with the library entry.
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
				String value = calculator.calculateAttributeValue(attParam.getAttribute(), attMapping, hints);
				
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
				
				// find the MappingInstanceSelector for this ExternalReferenceParameter
				Collection<Setting> refs = EcoreUtil.UsageCrossReferencer.find(extRefParam.getReference(), mappingHints);
				if(refs.size() != 1) {
					return false;
				}
				EObject ref = refs.iterator().next().getEObject();
				if(!(ref instanceof MappingInstanceSelector)) {
					return false;
				}
				MappingInstanceSelector selector = (MappingInstanceSelector) ref;

				/*
				 * handle AttributeMatcher
				 */
				if (selector.getMatcher() instanceof AttributeMatcher) {
					final AttributeMatcher matcher = (AttributeMatcher) selector
							.getMatcher();
					
					/*
					 * The following has been copied and adapted from the 
					 * 'TargetSectionInstantiator.instantiateTargetSectionSecondPass()'
					 * method. Maybe, this could be improved/reused in a better way.
					 */
					
					// now search for target attributes
					final LinkedList<EObjectTransformationHelper> targetInstances = targetSectionRegistry
							.getFlattenedPamtramClassInstances(matcher
									.getTargetAttribute()
									.getOwningClass());

					for (final Object attrVal : hintValues.getHintValues(selector)) {
						String attrValStr = null;

						attrValStr = "";
						final Map<AttributeMatcherSourceInterface, AttributeValueRepresentation> hVal = 
								(Map<AttributeMatcherSourceInterface, AttributeValueRepresentation>) attrVal;
						for (final AttributeMatcherSourceInterface srcElement : ((AttributeMatcher) selector
								.getMatcher())
								.getSourceAttributes()) {
							if (hVal.containsKey(srcElement)) {
								attrValStr += hVal
										.get(srcElement).getNextValue();
							} else {
									consoleStream.println("HintSourceValue not found "
										+ srcElement
										.getName()
										+ " in hint "
										+ selector.getName()
										+ ".");
							}
						}
						
						boolean found = false;
						for (final EObjectTransformationHelper targetInst : targetInstances) {
							// get Attribute value
							final String targetValStr = targetInst
									.getAttributeValue(matcher
											.getTargetAttribute());
							if (targetValStr != null) {
								if (targetValStr.equals(attrValStr)) {
									// set the target eObject of the parameter
									((AbstractExternalReferenceParameter<EObject, EObject>) extRefParam.getOriginalParameter()).setTarget(targetInst.getEObject());
									found = true;
									break;
								}
							} else {
								return false;
							}
						}
						if(!found) {
							return false;
						}
					}

				} else {
					consoleStream.println("Unsupported matcher type '" + selector.getMatcher().getClass().getName() + "'!");
					return false;
				}
				
			}
		}
		
		/*
		 * Finally, insert the library entry into the target model as all parameters have been filled out
		 */
		manager.insertIntoTargetModel(targetModel, libraryEntry);

		return true;
	}
}
