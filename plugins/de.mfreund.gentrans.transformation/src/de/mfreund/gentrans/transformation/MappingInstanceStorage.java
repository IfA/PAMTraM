/**
 * 
 */
package de.mfreund.gentrans.transformation;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
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
	private LinkedHashMap<pamtram.metamodel.Class, Set<EObject>> refs;
	private Mapping mapping;
	private EObject associatedSourceModelElement;
	private LinkedHashMap<MappingHintGroup, LinkedHashMap<pamtram.metamodel.Class, LinkedList<EObjectTransformationHelper>>> instancesBySection;

	private LinkedHashMap<pamtram.mapping.MappingHint, LinkedList<Object>> hintValues;

	private LinkedHashMap<ModelConnectionHint, LinkedList<String>> modelConnectionHintValues;

	/**
	 * 
	 */
	public MappingInstanceStorage() {
		refs = new LinkedHashMap<pamtram.metamodel.Class, Set<EObject>>();
		hintValues = new LinkedHashMap<pamtram.mapping.MappingHint, LinkedList<Object>>();
		mapping = null;
		associatedSourceModelElement = null;
		instancesBySection = new LinkedHashMap<MappingHintGroup, LinkedHashMap<pamtram.metamodel.Class, LinkedList<EObjectTransformationHelper>>>();
		modelConnectionHintValues = new LinkedHashMap<ModelConnectionHint, LinkedList<String>>();

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
			hintValues.put(hint, new LinkedList<Object>());
		}
		hintValues.get(hint).add(value);
	}

	public void addHintValues(
			LinkedHashMap<pamtram.mapping.MappingHint, LinkedList<Object>> newHintValues) {
		for (MappingHint h : newHintValues.keySet()) {
			if (!hintValues.containsKey(h)) {
				hintValues.put(h, new LinkedList<Object>());
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
			LinkedHashMap<ModelConnectionHint, LinkedList<String>> newHintValues) {
		for (ModelConnectionHint h : newHintValues.keySet()) {
			if (!modelConnectionHintValues.containsKey(h)) {
				modelConnectionHintValues.put(h, new LinkedList<String>());
			}
			modelConnectionHintValues.get(h).addAll(newHintValues.get(h));
		}
	}

	public void addRefs(LinkedHashMap<pamtram.metamodel.Class, Set<EObject>> refs) {
		for (pamtram.metamodel.Class key : refs.keySet()) {
			if (!this.refs.containsKey(key)) {
				this.refs.put(key, new LinkedHashSet<EObject>());
			}
			this.refs.get(key).addAll(refs.get(key));
		}
	}

	public void addRefValue(EObject srcModelElement,
			pamtram.metamodel.Class srcSectionClass) {
		if (!refs.containsKey(srcModelElement)) {
			refs.put(srcSectionClass, new LinkedHashSet<EObject>());
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
							new LinkedHashMap<pamtram.metamodel.Class, LinkedList<EObjectTransformationHelper>>());
		}

		if (!instancesBySection.get(grp).containsKey(section)) {
			instancesBySection.get(grp).put(section, new LinkedList<EObjectTransformationHelper>());
		}
	}

	public EObject getAssociatedSourceModelElement() {
		return associatedSourceModelElement;
	}

	public LinkedHashMap<MappingHint, LinkedList<Object>> getHintValues() {
		return hintValues;
	}

	
	public LinkedHashMap<pamtram.metamodel.Class, LinkedList<EObjectTransformationHelper>> getInstancesBySection(MappingHintGroup group) {
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

	// public LinkedHashMap<MappingHint, LinkedList<Object>> getClonedHintValues() {
	// LinkedHashMap<MappingHint, LinkedList<Object>> clone=new LinkedHashMap<MappingHint,
	// LinkedList<Object>>();
	// for(MappingHint h : hintValues.keySet()){
	// clone.put(h, new LinkedList<Object>());
	// clone.get(h).addAll(hintValues.get(h));
	// }
	//
	// return clone;
	// }

	public final LinkedHashMap<ModelConnectionHint, LinkedList<String>> getModelConnectionHintValues() {
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

	public final LinkedHashMap<pamtram.metamodel.Class, Set<EObject>> getRefs() {
		return refs;
	}

	public void setAssociatedSourceModelElement(
			EObject associatedSourceModelElement) {
		this.associatedSourceModelElement = associatedSourceModelElement;
	}

	public void setHintValueList(MappingHint hint,
			LinkedList<Object> newHintValues) {
		hintValues.put(hint, newHintValues);

	}
	
	public void setConnectionHintValueList(ModelConnectionHint hint,
			LinkedList<String> newHintValues) {
		modelConnectionHintValues.put(hint, newHintValues);

	}

	public void setHintValues(
			LinkedHashMap<pamtram.mapping.MappingHint, LinkedList<Object>> hintValues) {
		this.hintValues = hintValues;
	}

	public void setMapping(Mapping mapping) {
		this.mapping = mapping;
	}

	public void setRefs(LinkedHashMap<pamtram.metamodel.Class, Set<EObject>> refs) {
		this.refs = refs;
	}

}
