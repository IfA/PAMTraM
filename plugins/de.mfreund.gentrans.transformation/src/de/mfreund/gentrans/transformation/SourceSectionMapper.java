package de.mfreund.gentrans.transformation;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import pamtram.mapping.AttributeMatcher;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.ModelConnectionHint;
import pamtram.mapping.SimpleAttributeMapping;
import pamtram.metamodel.ActualAttribute;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.Class;
import pamtram.metamodel.ContainmentReference;
import pamtram.metamodel.NonContainmentReference;
import pamtram.metamodel.Reference;
import de.mfreund.gentrans.transformation.selectors.ItemSelectorDialog;

/**
 * @author Sascha Steffen
 * 
 * 
 */
public class SourceSectionMapper {
	
	private LinkedHashMap<Class,Set<EObject>> mappedSections;
	private LinkedHashMap<Mapping, LinkedList<ModelConnectionHint>> modelConnectionHints;
	private LinkedHashMap<Mapping,LinkedList<MappingHint>> mappingHints;
	
	public SourceSectionMapper() {
		mappedSections=new LinkedHashMap<Class,Set<EObject>> ();
		mappingHints=new  LinkedHashMap<Mapping,LinkedList<MappingHint>>();
		modelConnectionHints=new  LinkedHashMap<Mapping,LinkedList<ModelConnectionHint>>();
		
	
	}
	
	private List<MappingHint> getHints(Mapping m){
		if(!mappingHints.containsKey(m)){
			mappingHints.put(m, new LinkedList<MappingHint>());
			for(MappingHintGroup g : m.getMappingHintGroups()){
				if(g.getMappingHints() != null){
					mappingHints.get(m).addAll(g.getMappingHints());					
				}
			}
		}
		
		return mappingHints.get(m);
		
	}
	
	
	
	private List<ModelConnectionHint> getModelConnectionHints(Mapping m){
		if(!modelConnectionHints.containsKey(m)){
			modelConnectionHints.put(m, new LinkedList<ModelConnectionHint>());
			for(MappingHintGroup g : m.getMappingHintGroups()){
				if(g.getModelConnectionMatcher() != null){
					modelConnectionHints.get(m).add(g.getModelConnectionMatcher());					
				}
			}
		}
		
		return modelConnectionHints.get(m);
		
	}	

	/**
	 * @param EObject
	 *            from srcModel
	 * @return list of the srcModels elements in hierarchical order
	 */
	public static List<EObject> buildContainmentTree(EObject object) {

		List<EObject> list = new LinkedList<EObject>();
		return buildContainmentTree(object, list);
	}

	/**
	 * @param EObject
	 *            from srcModel
	 * @param list
	 *            to expand
	 * @return list of the srcModels elements in hierarchical order
	 */
	@SuppressWarnings("unchecked")
	private static List<EObject> buildContainmentTree(EObject object,
			List<EObject> list) {

		list.add(object);

		for (EReference feature : object.eClass().getEAllContainments()) {
			Object childElements = object.eGet(feature);
			if (childElements != null) {
				if (childElements instanceof Iterable) {
					for (EObject child : (Iterable<EObject>) childElements) {
						buildContainmentTree(child, list);
					}

				} else {
					buildContainmentTree((EObject) childElements, list);
				}
			}
		}

		return list;
	}

	/**
	 * Method for finding a suitable Mapping for a srcModelObject (internal,
	 * recursive version)
	 * 
	 * @param srcModelObject
	 *            Element of the srcModel to be transformed
	 * @param usedOkay
	 *            specify whether elements already contained in newRefsAndHints can be mapped (needed for non-cont refs)
	 * @param hints
	 * @param connectionHints
	 * @param srcSection
	 * @param newRefsAndHints
	 * @param srcInstanceMap
	 */
	@SuppressWarnings("unchecked")
	private static MappingInstanceStorage findMappingIterate(
			EObject srcModelObject, boolean usedOkay,
			Iterable<MappingHint> hints,
			Iterable<ModelConnectionHint> connectionHints,
			Class srcSection,
			MappingInstanceStorage newRefsAndHints,
			LinkedHashMap<pamtram.metamodel.Class, EObject> srcInstanceMap) {

		// first of all: check if usedRefs contains this item and if type fits
		// (we do not check any of the used elements of other mappings, since
		// WILL be in a different section of the containment tree )
		if ((!usedOkay && newRefsAndHints.containsRefValue(srcModelObject))
				|| !srcModelObject.eClass().equals( srcSection.getEClass())) {
			return null;
		}
		// we will return this in Case we find the mapping to be applicable
		// else we return null
		MappingInstanceStorage changedRefsAndHints = new MappingInstanceStorage();

		// init hintValues --TODO this is absolutely neccessary as of now, maybe
		// find out why?-> naccessary f.i. in targetSectionMApper for determination of cardinality
		for (MappingHint hint : hints) {

			changedRefsAndHints
					.setHintValueList(hint, new LinkedList<String>());
		}
		
		for (ModelConnectionHint hint : connectionHints) {

			changedRefsAndHints
					.setConnectionHintValueList(hint, new LinkedList<String>());
		}

		// set refs
		changedRefsAndHints.addRefs(newRefsAndHints.getRefs());

		// add self to new Refs
		changedRefsAndHints.addRefValue(srcModelObject, srcSection);

		// set self in sourceInstanceMAp
		srcInstanceMap.put(srcSection, srcModelObject);

		// check attributes
		for (pamtram.metamodel.Attribute at : srcSection.getAttributes()) {// look
																			// for
																			// attributes
																			// in
																			// srcSection
			
			if(at instanceof ActualAttribute){
				ActualAttribute a = (ActualAttribute) at;
			// does it exist in src model?

			Object srcAttr = srcModelObject.eGet(a.getAttribute());
			if (srcAttr != null) {
				// convert Attribute value to String
				String srcAttrAsString = a
						.getAttribute()
						.getEType()
						.getEPackage()
						.getEFactoryInstance()
						.convertToString(a.getAttribute().getEAttributeType(),
								srcAttr);
				// check AttributeValueSpecifications
				for (pamtram.metamodel.AttributeValueSpecification constraint : a
						.getValueSpecification()) {
					if (!constraint.check(srcAttrAsString)) {
						return null;
					}
				}
				// handle possible attribute mappings
				for (MappingHint hint : hints) {
					if (hint instanceof SimpleAttributeMapping) {
						SimpleAttributeMapping hintA = (SimpleAttributeMapping) hint;
						if (hintA.getSource().equals(a)) {
							String valCopy = srcAttrAsString;
							// handle attribute modifiers
							valCopy = AttributeValueRegistry.applyAttributeValueModifiers(valCopy,
									hintA.getModifier());
							changedRefsAndHints.addHintValue(hintA, valCopy);
							// System.out.println("Attr-Mapping " +
							// hintA.getName() + " " + valCopy + " " +
							// srcAttrAsString);

						}//TODO ComplexAttributeMapping
					} else if (hint instanceof MappingInstanceSelector) {// handle
																			// MappingInstanceSelector
																			// with
																			// AttributeMatcher
						if (((MappingInstanceSelector) hint).getMatcher() instanceof AttributeMatcher) {
							// handle attribute modifiers
							AttributeMatcher matcher = (AttributeMatcher) ((MappingInstanceSelector) hint)
									.getMatcher();
							if (matcher.getSourceAttribute().equals(a)) {
								String valCopy = srcAttrAsString;
								valCopy = AttributeValueRegistry.applyAttributeValueModifiers(valCopy,
										matcher.getModifier());
								changedRefsAndHints.addHintValue(hint, valCopy);
							}
						}
					}
				}

				// ModelConnectionHint (is being handled in the same way as
				// MI-Selector with AttrMatcher)
				for (ModelConnectionHint hint : connectionHints) {
					if (hint.getSourceAttribute().equals(a)) {
						changedRefsAndHints.addModelConnectionHintValue(hint,
								srcAttrAsString);

					}

				}

			} else {// attribute not set / null
				System.out.println("Unset attribute");
				return null;
			}
		}
		}

		// now go through all the srcMmSection refs
		for (pamtram.metamodel.Reference reference : srcSection.getReferences()) {
			// reference.name.println;
			// check if reference is allowed by src metamodel
			// check if reference in srcMMSection points anywhere
			if (reference.getValue().size() < 1)
				break;
			Object refTarget = srcModelObject.eGet(reference.getEReference());// get
																				// refTarget(s)
																				// in
																				// srcModel
			// behave, depending on cardinality
			if (reference.getEReference().getUpperBound() == 1
					&& reference.getValue().size() == 1) {
				EObject refTargetObj = (EObject) refTarget;
				if (refTargetObj == null)
					return null;
				MappingInstanceStorage res = findMappingIterate(
						refTargetObj,
						reference instanceof NonContainmentReference
						, hints,
						connectionHints, reference.getValue().get(0),
						changedRefsAndHints, srcInstanceMap);
				if (res != null) {

					// success: combine refs and hints
					if (reference instanceof ContainmentReference) {
						changedRefsAndHints.add(res);
					} else {
						changedRefsAndHints.addHintValues(res.getHintValues());
						changedRefsAndHints.addModelConnectionHintValues(res.getModelConnectionHintValues());
					}
					// check for a cardinality hint (it doesn't really make
					// sense to model this for a class connected to a reference
					// with cardinality == 1 but it can be tolerated ) TODO
				} else {
					return null;
				}

			} else if (reference.getValue().size() <= reference.getEReference()
					.getUpperBound()
					|| reference.getEReference().getUpperBound() == -1 // unbounded
					|| reference.getEReference().getUpperBound() == -2)// unspecified
			{
				// cast refTarget to EList
				LinkedList<EObject> refTargetL = new LinkedList<EObject>();
				refTargetL.addAll(((EList<EObject>) refTarget));
				/*
				 * this is a little more complicated: now we need to find ONE
				 * possible way to map our referenceTargets to the source
				 * sections
				 * 
				 * To do this we need to find out first which MMSections are
				 * applicable to which srcModel sections.
				 * 
				 * Then we try to find a way to map one srcModelSection to each
				 * MMSection
				 */

				// Map to store possible srcModelSections to MMSections
				// (non-vc))
				SrcSectionMappingResultsMap possibleSrcModelElementsNoVC = new SrcSectionMappingResultsMap();
				for (pamtram.metamodel.Class val : reference.getValue()) {
					if (val.getCardinality().equals(CardinalityType.ONE)) {
						possibleSrcModelElementsNoVC
								.put(val,
										new LinkedList<MappingInstanceStorage>());
					}
				}

				// Map to store possible srcModelSections to MMSections (vc))
				SrcSectionMappingResultsMap possibleSrcModelElementsVC = new SrcSectionMappingResultsMap();
				for (pamtram.metamodel.Class val : reference.getValue()) {
					if (!val.getCardinality().equals(CardinalityType.ONE)) {
						possibleSrcModelElementsVC
								.put(val,
										new LinkedList<MappingInstanceStorage>());
					}
				}

				LinkedHashSet<EObject> elementsUsableForVC = new LinkedHashSet<EObject>();
				// find possible srcElements for mmsections
				for (EObject rt : refTargetL) {
					boolean foundMapping = false;
					for (pamtram.metamodel.Class val : reference.getValue()) {
						MappingInstanceStorage res = findMappingIterate(
								rt,
								reference instanceof NonContainmentReference,
								hints, connectionHints, val,
								changedRefsAndHints, srcInstanceMap);
						if (res != null) {// mapping possible
							foundMapping = true;
							res.setAssociatedSourceModelElement(rt);
							if (!val.getCardinality().equals(
									CardinalityType.ONE)) {
								possibleSrcModelElementsVC.get(val).add(res);
								elementsUsableForVC.add(rt);

							} else {
								possibleSrcModelElementsNoVC.get(val).add(res);
							}
						}
					}
					if (!foundMapping) {
						System.out
								.println("we need to find a mapping for every srcModelElement "
										+ rt);
						return null; // we need to find a mapping for every
										// srcModelElement if the reference Type
										// was modeled in the srcMMSection
					}
				}
				LinkedList<EObject> allElementsMapped = new LinkedList<EObject>();

				while (possibleSrcModelElementsNoVC.keySet().size() > 0) {
					pamtram.metamodel.Class smallestKey = possibleSrcModelElementsNoVC
							.getKeyForValueWithSmallestCollectionSize();
					if (possibleSrcModelElementsNoVC.get(smallestKey).size() > 0) {
						MappingInstanceStorage srcSectionResult;
						// we need to filter a little more
						if (possibleSrcModelElementsNoVC.get(smallestKey)
								.size() > 1) {
							LinkedList<MappingInstanceStorage> possibleElements = new LinkedList<MappingInstanceStorage>();
							possibleElements
									.addAll(possibleSrcModelElementsNoVC
											.get(smallestKey));

							// filter elements that can be used for a vc-section
							LinkedList<MappingInstanceStorage> allVCIncompatible = new LinkedList<MappingInstanceStorage>();
							for (MappingInstanceStorage s : possibleElements) {
								if (!elementsUsableForVC.contains(s
										.getAssociatedSourceModelElement())) {
									allVCIncompatible.add(s);
								}
							}
							if (allVCIncompatible.size() >= 1) {
								possibleElements = allVCIncompatible;
							}

							srcSectionResult = getResultForLeastUsedSrcModelElement(possibleElements);

						} else {
							srcSectionResult = possibleSrcModelElementsNoVC
									.get(smallestKey).getFirst();
						}

						// remember mapping
						if (reference instanceof ContainmentReference) {
							changedRefsAndHints.add(srcSectionResult);

						} else {
							changedRefsAndHints.addHintValues(srcSectionResult
									.getHintValues());
							changedRefsAndHints.addModelConnectionHintValues(srcSectionResult.getModelConnectionHintValues());
						}
						allElementsMapped.add(srcSectionResult
								.getAssociatedSourceModelElement());
						// remove srcModel element from possibility lists of
						// MMSections
						possibleSrcModelElementsNoVC
								.removeResultsForElement(srcSectionResult);
						possibleSrcModelElementsVC
								.removeResultsForElement(srcSectionResult);
						possibleSrcModelElementsNoVC.remove(smallestKey);// remove
																			// successfully
																			// mapped
																			// mmSection
																			// from
																			// list
					} else {
						// System.out.println("no-vc mapping failed");
						return null;// all non-vc-elements need to be mapped
									// exactly once
					}
				}

				// try to map all vc-elements
				LinkedHashSet<pamtram.metamodel.Class> usedKeys = new LinkedHashSet<pamtram.metamodel.Class>(); // for
																														// counting
																														// cardinality

				while (possibleSrcModelElementsVC.keySet().size() != 0) {

					pamtram.metamodel.Class smallestKey = possibleSrcModelElementsVC
							.getKeyForValueWithSmallestCollectionSize();
					if (possibleSrcModelElementsVC.get(smallestKey).size() > 0) {

						usedKeys.add(smallestKey);
						MappingInstanceStorage srcSectionResult;
						// we need to filter a little more
						if (possibleSrcModelElementsVC.get(smallestKey).size() > 1) {

							srcSectionResult = getResultForLeastUsedSrcModelElement(possibleSrcModelElementsVC
									.get(smallestKey));

						} else {
							srcSectionResult = possibleSrcModelElementsVC.get(
									smallestKey).getFirst();
						}
						// remember mapping
						if (reference instanceof ContainmentReference) {
							changedRefsAndHints.add(srcSectionResult);

						} else {

							changedRefsAndHints.addHintValues(srcSectionResult
									.getHintValues());
							changedRefsAndHints.addModelConnectionHintValues(srcSectionResult.getModelConnectionHintValues());
						}
						allElementsMapped.add(srcSectionResult
								.getAssociatedSourceModelElement());

						// remove srcModel element from possibility lists of
						// MMSections
						possibleSrcModelElementsVC
								.removeResultsForElement(srcSectionResult);
					} else if (usedKeys.contains(smallestKey)
							|| smallestKey.getCardinality().equals(
									CardinalityType.ZERO_INFINITY)) {
						possibleSrcModelElementsVC.remove(smallestKey);// remove
																		// mmSection
																		// from
																		// list
					} else {
						// System.out.println("vc mapping failed");
						return null; // the fact that samllestKey is not in the
										// collection means that no mapping was
										// found at all
					}
				}

				// check if all refTargets where mapped
				refTargetL.removeAll(allElementsMapped);
				if (refTargetL.size() > 0) {
					System.out.println("Not everything could be mapped");
					return null;
				}

				//TODO (?) cardinality mapping

			} else {// cardinality doesn't match ==> rule not applicable
				return null;
			}
		}
		// TODO Rest ;-)
		return changedRefsAndHints;

	}

	/**
	 * @param possibleElements
	 * @return
	 */
	private static MappingInstanceStorage getResultForLeastUsedSrcModelElement(
			final LinkedList<MappingInstanceStorage> possibleElements) {
		MappingInstanceStorage srcSectionResult;
		// count how often a sourceModel Element is mapped
		LinkedHashMap<EObject, Integer> usages = new LinkedHashMap<EObject, Integer>();
		for (MappingInstanceStorage e : possibleElements) {
			EObject element = e.getAssociatedSourceModelElement();
			if (!usages.containsKey(element)) {
				usages.put(element, 0);
			}
			usages.put(element, usages.get(element) + 1);
		}
		// use one of the mappings for one of the elements with the least
		// possible mappings
		EObject leastUsed = possibleElements.getFirst()
				.getAssociatedSourceModelElement();
		int numberUsed = usages.get(leastUsed);
		for (EObject o : usages.keySet()) {// find the first element least used
											// and return the first possible
											// result
			if (usages.get(o) < numberUsed) {
				leastUsed = o;
				numberUsed = usages.get(o);
			}
		}

		srcSectionResult = possibleElements.getFirst();// initialize this
														// variable so we dont
														// get compile errors
		for (MappingInstanceStorage e : possibleElements) {
			if (e.getAssociatedSourceModelElement().equals(leastUsed)) {
				srcSectionResult = e;
				break;
			}
		}
		return srcSectionResult;
	}
	
	 
	
	
//	-* find a mapping for a source meta-model element 
//	 *or a source meta-model section that starts with this element
//	 * @param EObject				the source meta-model element
//	 * @return Mapping				the mapping
//	 *-
	public MappingInstanceStorage findMapping(List<Mapping> mappingsToChooseFrom,List<EObject> contRefsToMap){		
		long start;//for statistics
		long time;
		
		EObject element=contRefsToMap.remove(0);//source model element which we will now try to map
		
		start = System.nanoTime();
		LinkedHashMap<MappingInstanceStorage,String> usedInMapping=new LinkedHashMap<MappingInstanceStorage,String>();
		LinkedHashMap<String, MappingInstanceStorage> mappingData=new LinkedHashMap<String, MappingInstanceStorage>();
			//find mapping rules that are applicable to a srcMM element 
			for(Mapping m : mappingsToChooseFrom){
				//create  result map
				MappingInstanceStorage res ;
				
				if(doContainerCheck(element,m.getSourceMMSection()) ){
					//("====== " + m.name + " ======").println;					
					
					res= findMappingIterate(element, false, getHints(m), getModelConnectionHints(m),
							m.getSourceMMSection(),
							new MappingInstanceStorage(),
							new LinkedHashMap<pamtram.metamodel.Class, EObject>());
					
					if(res != null){//if mapping possible add to list
						res.setMapping(m);
						mappingData.put(m.getName()+  (m.hashCode()), res);
						
						int used=0;
						for(Class c : res.getRefs().keySet()){
							if(!mappedSections.containsKey(c)){
								mappedSections.put(c,new LinkedHashSet<EObject>());
							}
							used+=res.getRefs().get(c).size();
							mappedSections.get(c).addAll(res.getRefs().get(c));
							
							contRefsToMap.removeAll(res.getRefs().get(c));//remove mapped elements from list of elements to be mapped
						}
						usedInMapping.put(res, String.valueOf(used));
					}		
				}
			}
			time=System.nanoTime()-start;
			
			//last step: let user decide	
			MappingInstanceStorage returnVal=null;
			switch(mappingData.keySet().size()){
				case 0:
					//System.out.println("No suitable mappping found for element\n'" + element.eClass().getName() + "'.");
					break;
				case 1:
					returnVal= mappingData.values().iterator().next();
					break;
				default:
					String selection= ItemSelectorDialog.run("Please select a Mapping for the source element\n'" 
					+  EObjectTransformationHelper.asString(element) + "'" , 
								mappingData.keySet(), mappingData.keySet().iterator().next());
					returnVal= mappingData.get(selection);
			}	
			
			if(returnVal != null){
				System.out.println(','  + returnVal.getMapping().getName() + ", " + usedInMapping.get(returnVal) + " ,  "+ time );

			}
			
			return returnVal;
	}

	
	@SuppressWarnings("unchecked")
	private boolean doContainerCheck(EObject element, Class sourceMMSectionRoot){
		if(sourceMMSectionRoot.getContainer() != null){
			if(mappedSections.containsKey(sourceMMSectionRoot.getContainer())){//was the container section instantiated
				for(EReference ref : sourceMMSectionRoot.getContainer().getEClass().getEAllContainments()){
					
					//exclude references that are modeled in the srcSection, since they cannot, by definition, reference the element
					boolean refExistsInContainerSection=false;
					for(Reference containerRef : sourceMMSectionRoot.getContainer().getReferences()){
						if(ref.equals(containerRef.getEReference())){
							refExistsInContainerSection=true;
							break;
						}	
					}
					
					if(!refExistsInContainerSection){
						for(EObject instance : mappedSections.get(sourceMMSectionRoot.getContainer())){//check for each instance
							Object refTargets=instance.eGet(ref);
							if(ref != null){
								if(ref.getUpperBound() == 1){
									if(refTargets.equals(element)){
										return true;
									}
								} else {
									EList<EObject> refTargetsList=(EList<EObject>) refTargets;
									for(EObject t : refTargetsList){
										if(t.equals(element)){
											return true;
										}
									}
								}
							}
						}						
						
					}
				}
				return false; //if we reach this point, then no fitting container instance could be found   
			} else {
				return false;//no instances of the container exist => mapping must fail
			}
		} else {
			return true; //no container == srcModelSection will not be excluded
		}
	}

}
