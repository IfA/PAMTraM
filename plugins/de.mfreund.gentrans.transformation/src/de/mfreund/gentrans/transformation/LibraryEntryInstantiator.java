package de.mfreund.gentrans.transformation;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintType;
import pamtram.mapping.ModelConnectionHint;
import pamtram.metamodel.LibraryEntry;

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
	 * @param targetModel The target model in which the {@link #libraryEntry} shall be instantiated.
	 */
	public void instantiate(EObject targetModel) {
		//TODO
	}
}
