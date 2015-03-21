package de.mfreund.gentrans.transformation.library;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;

import pamtram.mapping.AttributeMapping;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintType;
import pamtram.mapping.ModelConnectionHint;
import pamtram.metamodel.AttributeParameter;
import pamtram.metamodel.ContainerParameter;
import pamtram.metamodel.ExternalReferenceParameter;
import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.LibraryParameter;
import pamtram.util.GenLibraryManager;
import de.mfreund.gentrans.transformation.AttributeValueCalculator;
import de.mfreund.gentrans.transformation.EObjectTransformationHelper;
import de.mfreund.gentrans.transformation.TargetSectionConnector;
import de.mfreund.gentrans.transformation.TargetSectionRegistry;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerParameter;
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
	final private Map<MappingHintType, LinkedList<Object>> hintValues;
	
	/**
	 * A map of {@link ModelConnectionHint}s and associated {@link Object}s that represent
	 * hint values to be used during the instantiation.
	 */
	final private Map<ModelConnectionHint, LinkedList<Object>> conHintValues;
	
	/**
	 * This creates an instance.
	 * 
	 * @param libraryEntry The {@link LibraryEntry} to be instantiated.
	 * @param mappingGroupThe {@link InstantiableMappingHintGroup} associated with the library entry.
	 * @param mappingHints A list of {@link MappingHint}s that are part of the {@link #mappingGroup}.
	 * @param hintValues  A map of {@link MappingHintType}s and associated {@link Object}s that represent 
	 * 			hint values to be used during the instantiation.
	 * @param conHintValues A map of {@link ModelConnectionHint}s and associated {@link Object}s that represent
	 * 			hint values to be used during the instantiation.
	 */
	public LibraryEntryInstantiator(
			LibraryEntry libraryEntry, 
			InstantiableMappingHintGroup mappingGroup,
			List<MappingHint> mappingHints,
			Map<MappingHintType, LinkedList<Object>> hintValues,
			Map<ModelConnectionHint, LinkedList<Object>> conHintValues) {
		this.libraryEntry = libraryEntry;
		this.mappingGroup = mappingGroup;
		this.mappingHints = mappingHints;
		this.hintValues = hintValues;
		this.conHintValues = conHintValues;
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
				if(refs.size() != 1) {
					return false;
				}
				EObject ref = refs.iterator().next().getEObject();
				if(!(ref instanceof AttributeMapping)) {
					return false;
				}
				AttributeMapping attMapping = (AttributeMapping) ref;
				
				// calculate the attribute value using the given hint values and the AttributeMapping
				LinkedList<Object> hints = hintValues.get(attMapping);
				String value = calculator.calculateAttributeValue(attParam.getAttribute(), attMapping, hints);
				
				// set the calculated value
				attParam.getOriginalParameter().setNewValue(value);
			} else if(param instanceof ContainerParameter) {
				
				ContainerParameter contParam = (ContainerParameter) param;
				
				// find the ModelConnectionHint for this ContainerParameter
				if(!(mappingGroup instanceof MappingHintGroup)) {
					return false;
				}
				if(!((MappingHintGroup) mappingGroup).getTargetMMSection().equals(contParam.getClass_())) {
					return false;
				}
				
				ModelConnectionHint connHint = ((MappingHintGroup) mappingGroup).getModelConnectionMatcher();
				
				LinkedList<EObjectTransformationHelper> rootInstances = targetSectionRegistry.getPamtramClassInstances(contParam.getClass_()).get(mappingGroup);
				
				EObjectTransformationHelper section = rootInstances.removeFirst();
				((AbstractContainerParameter<EObject, EObject>) (contParam.getOriginalParameter())).setContainer(section.getEObject().eContainer());
				EcoreUtil.delete(section.getEObject());
				targetSectionRegistry.getPamtramClassInstances(contParam.getClass_()).put(mappingGroup, rootInstances);
//				
//				if(connHint == null) {
//					LinkedList<EObjectTransformationHelper> containerInstances = targetSectionRegistry.getFlattenedPamtramClassInstances(contParam.getClass_().getContainer());
//					containerInstances.removeAll(rootInstances);
//					final Set<EClass> containerClasses = new HashSet<EClass>();
//					if (contParam.getClass_().getContainer() != null) {
//						containerClasses.add(contParam.getClass_().getContainer()
//								.getEClass());
//					}
//					//TODO we do not need to link but only get the container instance
//					targetSectionConnector.linkToTargetModelNoConnectionHint(
//							rootInstances, 
//							contParam.getClass_(), 
//							((Mapping) mappingGroup.eContainer()).getName(), 
//							mappingGroup.getName(), 
//							contParam.getClass_().getContainer() != null, 
//							containerClasses, 
//							containerInstances);
//				} else {
//					targetSectionConnector.linkToTargetModelUsingModelConnectionHint(
//							contParam.getClass_().eClass(), 
//							rootInstances, 
//							contParam.getClass_(), 
//							((Mapping) mappingGroup.eContainer()).getName(), 
//							mappingGroup.getName(), 
//							connHint, 
//							conHintValues.get(connHint), 
//							0); //TODO this can be determined by the target section connector
//				}
				
				
			} else if (param instanceof ExternalReferenceParameter) {
				// TODO support this
				return false;
			}
		}
		
		manager.insertIntoTargetModel(targetModel, libraryEntry);

		return true;
	}
}
