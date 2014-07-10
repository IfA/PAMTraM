/**
 * 
 */
package de.mfreund.gentrans.transformation;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.ModelConnectionHint;

/**
 * @author Sascha Steffen
 * 
 */
public class MappingInstanceStorage {// TODO rename this
	private HashMap<pamtram.metamodel.Class, Set<EObject>> refs;
	private Mapping mapping;
	private EObject associatedSourceModelElement;
	private HashMap<MappingHintGroup, HashMap<pamtram.metamodel.Class, LinkedList<EObjectTransformationHelper>>> instancesBySection;

	private HashMap<pamtram.mapping.MappingHint, LinkedList<String>> hintValues;

	private HashMap<ModelConnectionHint, LinkedList<String>> modelConnectionHintValues;

	/**
	 * 
	 */
	public MappingInstanceStorage() {
		refs = new HashMap<pamtram.metamodel.Class, Set<EObject>>();
		hintValues = new HashMap<pamtram.mapping.MappingHint, LinkedList<String>>();
		mapping = null;
		associatedSourceModelElement = null;
		instancesBySection = new HashMap<MappingHintGroup, HashMap<pamtram.metamodel.Class, LinkedList<EObjectTransformationHelper>>>();
		modelConnectionHintValues = new HashMap<ModelConnectionHint, LinkedList<String>>();

	}

	public void add(Iterable<MappingInstanceStorage> newRefsAndHints) {
		for (MappingInstanceStorage storage : newRefsAndHints) {
			this.add(storage);
		}
	}

	public void add(MappingInstanceStorage newRefsAndHints) {
		// combine refs
		this.addRefs(newRefsAndHints.getRefs());

		// combine hints
		this.addHintValues(newRefsAndHints.getHintValues());

		// combine connectionHints
		this.addModelConnectionHintValues(newRefsAndHints
				.getModelConnectionHintValues());

	}

	public void addHintValue(MappingHint hint, String value) {
		if (!hintValues.containsKey(hint)) {
			hintValues.put(hint, new LinkedList<String>());
		}
		hintValues.get(hint).add(value);
	}

	public void addHintValues(
			HashMap<pamtram.mapping.MappingHint, LinkedList<String>> newHintValues) {
		for (MappingHint h : newHintValues.keySet()) {
			if (!hintValues.containsKey(h)) {
				hintValues.put(h, new LinkedList<String>());
			}
			hintValues.get(h).addAll(newHintValues.get(h));
		}
	}

	public void addInstance(MappingHintGroup grp,
			pamtram.metamodel.Class section, EObjectTransformationHelper inst) {
		generateInstancesCollectionsIfNeeded(grp, section);
		instancesBySection.get(grp).get(section).add(inst);
	}

	public void addInstances(MappingHintGroup grp,
			pamtram.metamodel.Class section, Collection<EObjectTransformationHelper> insts) {
		generateInstancesCollectionsIfNeeded(grp, section);
		instancesBySection.get(grp).get(section).addAll(insts);
	}

	public void addModelConnectionHintValue(ModelConnectionHint hint,
			String value) {
		if (!modelConnectionHintValues.containsKey(hint)) {
			modelConnectionHintValues.put(hint, new LinkedList<String>());
		}
		modelConnectionHintValues.get(hint).add(value);
	}

	public void addModelConnectionHintValues(
			HashMap<ModelConnectionHint, LinkedList<String>> newHintValues) {
		for (ModelConnectionHint h : newHintValues.keySet()) {
			if (!modelConnectionHintValues.containsKey(h)) {
				modelConnectionHintValues.put(h, new LinkedList<String>());
			}
			modelConnectionHintValues.get(h).addAll(newHintValues.get(h));
		}
	}

	public void addRefs(HashMap<pamtram.metamodel.Class, Set<EObject>> refs) {
		for (pamtram.metamodel.Class key : refs.keySet()) {
			if (!this.refs.containsKey(key)) {
				this.refs.put(key, new HashSet<EObject>());
			}
			this.refs.get(key).addAll(refs.get(key));
		}
	}

	public void addRefValue(EObject srcModelElement,
			pamtram.metamodel.Class srcSectionClass) {
		if (!refs.containsKey(srcModelElement)) {
			refs.put(srcSectionClass, new HashSet<EObject>());
		}
		refs.get(srcSectionClass).add(srcModelElement);

	}

	public boolean containsRefValue(EObject object) {
		return refs.values().contains(object);
	}

	/**
	 * @param grp
	 * @param section
	 */
	private void generateInstancesCollectionsIfNeeded(MappingHintGroup grp,
			pamtram.metamodel.Class section) {
		if (!instancesBySection.containsKey(grp)) {
			instancesBySection
					.put(grp,
							new HashMap<pamtram.metamodel.Class, LinkedList<EObjectTransformationHelper>>());
		}

		if (!instancesBySection.get(grp).containsKey(section)) {
			instancesBySection.get(grp).put(section, new LinkedList<EObjectTransformationHelper>());
		}
	}

	public EObject getAssociatedSourceModelElement() {
		return associatedSourceModelElement;
	}

	public HashMap<MappingHint, LinkedList<String>> getHintValues() {
		return hintValues;
	}

	
	public HashMap<pamtram.metamodel.Class, LinkedList<EObjectTransformationHelper>> getInstancesBySection(MappingHintGroup group) {
			return instancesBySection.get(group);
	}
	
	public LinkedList<EObjectTransformationHelper> getInstances(MappingHintGroup group, pamtram.metamodel.Class section) {
		if(instancesBySection.containsKey(group)){
				return instancesBySection.get(group).get(section);

		} else return null;
	}

	public Mapping getMapping() {
		return mapping;
	}

	// public HashMap<MappingHint, LinkedList<Object>> getClonedHintValues() {
	// HashMap<MappingHint, LinkedList<Object>> clone=new HashMap<MappingHint,
	// LinkedList<Object>>();
	// for(MappingHint h : hintValues.keySet()){
	// clone.put(h, new LinkedList<Object>());
	// clone.get(h).addAll(hintValues.get(h));
	// }
	//
	// return clone;
	// }

	public final HashMap<ModelConnectionHint, LinkedList<String>> getModelConnectionHintValues() {
		return modelConnectionHintValues;
	}

	public LinkedList<String> getModelConnectionHintValues(
			ModelConnectionHint hint) {

		if (modelConnectionHintValues.containsKey(hint)) {
			return modelConnectionHintValues.get(hint);
		} else {
			return new LinkedList<String>();
		}
	}

	public final HashMap<pamtram.metamodel.Class, Set<EObject>> getRefs() {
		return refs;
	}

	public void setAssociatedSourceModelElement(
			EObject associatedSourceModelElement) {
		this.associatedSourceModelElement = associatedSourceModelElement;
	}

	public void setHintValueList(MappingHint hint,
			LinkedList<String> newHintValues) {
		hintValues.put(hint, newHintValues);

	}
	
	public void setConnectionHintValueList(ModelConnectionHint hint,
			LinkedList<String> newHintValues) {
		modelConnectionHintValues.put(hint, newHintValues);

	}

	public void setHintValues(
			HashMap<pamtram.mapping.MappingHint, LinkedList<String>> hintValues) {
		this.hintValues = hintValues;
	}

	public void setMapping(Mapping mapping) {
		this.mapping = mapping;
	}

	public void setRefs(HashMap<pamtram.metamodel.Class, Set<EObject>> refs) {
		this.refs = refs;
	}

}
