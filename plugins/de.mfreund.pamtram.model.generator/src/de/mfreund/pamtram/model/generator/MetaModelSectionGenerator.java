package de.mfreund.pamtram.model.generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.mfreund.pamtram.util.NullComparator;
import pamtram.PAMTraM;
import pamtram.metamodel.ActualAttribute;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.AttributeValueConstraintType;
import pamtram.metamodel.Class;
import pamtram.metamodel.ContainmentReference;
import pamtram.metamodel.EqualityMatcher;
import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.MetamodelFactory;
import pamtram.metamodel.Reference;
import pamtram.metamodel.Section;
import pamtram.metamodel.SourceSection;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.TargetSection;
import pamtram.metamodel.TargetSectionNonContainmentReference;

/**
 * This class is responsible for the generation of {@link Section MetaModelSections} from
 * excerpts of a model.
 * 
 * @author mfreund
 */
public class MetaModelSectionGenerator {

	/**
	 * The PAMTraM instance where the generated Section will be be stored.
	 */
	private PAMTraM pamtram;

	/**
	 * The source eObject from which the section will be generated.
	 */
	private EObject source;

	/**
	 * The SectionType specifying whether to generate a Source or a TargetSection.
	 */
	private SectionType sectionType;

	/**
	 * This contains a map of metamodel section that have been created so far
	 */
	private HashMap<EObject, Section<?, ?, ?>> created; 

	/**
	 * This contains a list of metamodel (sub-)sections that are not yet contained by the pamtram or by another class
	 */
	private ArrayList<Section<?, ?, ?>> dangling;

	/**
	 * This creates an instance.
	 * 
	 * @param pamtram The PAMTraM instance where the generated Section shall be stored.
	 * @param source The source eObject from which the section shall be generated.
	 * @param sectionType The SectionType specifying whether to generate a Source or a TargetSection.
	 */
	public MetaModelSectionGenerator(PAMTraM pamtram, EObject source, SectionType sectionType) {
		this.pamtram = pamtram;
		this.source = source;
		this.sectionType = sectionType;
		this.created = new HashMap<>();
		this.dangling = new ArrayList<>();
	}

	/**
	 * This generates the Section(s) and returns it/them.
	 * <br />
	 * Note: The generated sections are not yet added to the PAMTraM model as some might represent duplicates of
	 * existing sections (cf. {@link #mergeDuplicates(LinkedList)}). Consequently, clients need to add the 
	 * sections to the PAMTraM model on their own.
	 * 
	 * @return The generated Section(s).
	 */
	public LinkedList<Section<?, ?, ?>> generate() {

		Section<?, ?, ?> metaModelSection = createMetaModelSection(source);

		LinkedList<Section<?, ?, ?>> ret = new LinkedList<>();
		ret.add(metaModelSection);
		ret.addAll(dangling);

		return ret;
	}

	/**
	 * This method recursively generates the containment structure of the Section.
	 * 
	 * @param source The {@link EObject source object} for which the structure shall be created.
	 * @return The created {@link Section section}.
	 */
	@SuppressWarnings("unchecked")
	private Section<?, ?, ?> createMetaModelSection(EObject source) {
		EClass eClass = source.eClass();

		// the class as the root element of the section
		Section<?, ?, ?> section;
		if(sectionType == SectionType.SOURCE) {
			section = MetamodelFactory.eINSTANCE.createSourceSection();
		} else {
			section = MetamodelFactory.eINSTANCE.createTargetSection();
		}
		section.setEClass(eClass);;
		section.setName(eClass.getName());

		// add the attributes to the class
		createAttributes(source, section);

		// add the class to the map of created elements
		created.put(source, section);

		ArrayList<EReference> eAllContainments = new ArrayList<>();
		ArrayList<EReference> eAllNonContainments = new ArrayList<>();

		for (EReference eReference : eClass.getEAllReferences()) {
			if(eReference.isContainment()) {
				eAllContainments.add(eReference);
			} else {
				eAllNonContainments.add(eReference);
			}
		}

		// plunge deeper by evaluating the containment references
		for(EReference eContainment : eAllContainments) {
			// create a 'containment reference' object
			ContainmentReference<?, ?, ?> containmentReference;
			if(sectionType == SectionType.SOURCE) {
				containmentReference = MetamodelFactory.eINSTANCE.createSourceSectionContainmentReference();
			} else {
				containmentReference = MetamodelFactory.eINSTANCE.createTargetSectionContainmentReference(); 
			}
			containmentReference.setEReference(eContainment);
			containmentReference.setName(eContainment.getName());

			// get the objects contained via the containment reference
			if(source.eGet(eContainment) == null) {
				continue;
			} 
			ArrayList<EObject> contained = new ArrayList<>();
			if(eContainment.isMany()) {
				contained.addAll((Collection<? extends EObject>) source.eGet(eContainment));
			} else {
				contained.add((EObject) source.eGet(eContainment));
			}
			for(EObject eObject : contained) {

				// check if an uncontained section representing the eObject already exists
				// (this might be the case if it has been created by a non-containment reference)
				Class<?, ?, ?> existing = created.get(eObject);
				if(existing != null && dangling.contains(existing)) {
					// link the existing class
					((EList<Class<?, ?, ?>>) containmentReference.getValue()).add(existing);
					dangling.remove(existing);
				} else {
					// create a new (part) metamodel section beginning at the object and link it to the current section
					((EList<Class<?, ?, ?>>) containmentReference.getValue()).add(createMetaModelSection(eObject));
				}
			}

			// add the created reference to the list of references of the current class
			// and thus complete the metamodel section
			if(containmentReference.getValue().size() > 0) {
				((EList<Reference<?, ?, ?>>) section.getReferences()).add(containmentReference);
			} else {
				EcoreUtil.remove(containmentReference);;
			}
		}

		// handle the non-containment references
		for(EReference eNonContainment : eAllNonContainments) {

			// create a 'non containment reference' object
			Reference<?, ?, ?> nonContainmentReference;
			if(sectionType == SectionType.SOURCE) {
				nonContainmentReference = 
						MetamodelFactory.eINSTANCE.createMetaModelSectionReference();
			} else {
				nonContainmentReference = 
						MetamodelFactory.eINSTANCE.createTargetSectionNonContainmentReference();
			}
			nonContainmentReference.setEReference(eNonContainment);
			nonContainmentReference.setName(eNonContainment.getName());

			if(source.eGet(eNonContainment) == null) { // no referenced object
				continue;
			}
			ArrayList<EObject> referenced = new ArrayList<>();
			if(eNonContainment.isMany()) {
				referenced.addAll((Collection<? extends EObject>) source.eGet(eNonContainment));
			} else {
				referenced.add((EObject) source.eGet(eNonContainment));
			}
			// get the objects referenced by the non-containment reference
			for(EObject eObject : referenced) {

				// check if a section representing the eObject already exists
				Section<?, ?, ?> existing = created.get(eObject);
				if(existing != null) {
					// link the existing class
					if(sectionType == SectionType.SOURCE) {
						((MetaModelSectionReference) nonContainmentReference).getValue().add((SourceSection) existing); 
					} else {
						((TargetSectionNonContainmentReference) nonContainmentReference).getValue().add((TargetSection) existing); 
					}
				} else {
					// create a new metamodel section beginning at the object and link it to the mapping model
					Section<?, ?, ?> metaModelSection = createMetaModelSection(eObject);
					dangling.add(metaModelSection);
					if(sectionType == SectionType.SOURCE) {
						((MetaModelSectionReference) nonContainmentReference).getValue().add((SourceSection) metaModelSection); 
					} else {
						((TargetSectionNonContainmentReference) nonContainmentReference).getValue().add((TargetSection) metaModelSection); 
					}
				}
			}

			// link the created metamodel section to the current section
			if(sectionType == SectionType.SOURCE) {
				if(((MetaModelSectionReference) nonContainmentReference).getValue().size() > 0) {
					((EList<Reference<?, ?, ?>>) section.getReferences()).add(nonContainmentReference);
				} else {
					EcoreUtil.delete(nonContainmentReference);;
				}
			} else {
				if(((TargetSectionNonContainmentReference) nonContainmentReference).getValue().size() > 0) {
					((EList<Reference<?, ?, ?>>) section.getReferences()).add(nonContainmentReference);
				} else {
					EcoreUtil.delete(nonContainmentReference);
				}
			}

		}

		return section;
	}

	/**
	 * This method is responsible for the creation of the attributes inside a {@link Class section}.
	 * @param source The {@link EObject source element} for which the {@link Attribute attributes} shall be created.
	 * @param clazz The {@link Class} to which the created attributes shall be added. 
	 */
	@SuppressWarnings("unchecked")
	private void createAttributes(EObject source, Class<?, ?, ?> clazz) {

		EClass eClass = clazz.getEClass();

		EList<EAttribute> eAttributes = eClass.getEAllAttributes();
		for(EAttribute eAttribute : eAttributes) {
			Attribute<?, ?, ?> attribute;
			if(sectionType == SectionType.SOURCE) {
				attribute = MetamodelFactory.eINSTANCE.createSourceSectionAttribute();
				((SourceSectionAttribute) attribute).setAttribute(eAttribute);
			} else {
				attribute = MetamodelFactory.eINSTANCE.createActualAttribute();
				((ActualAttribute) attribute).setAttribute(eAttribute);
			}
			attribute.setName(eAttribute.getName());
			Object attributeValue = source.eGet(eAttribute);
			if(attributeValue != null) {
				if(sectionType == SectionType.SOURCE) {
					EqualityMatcher attValConstraint = MetamodelFactory.eINSTANCE.createEqualityMatcher();
					attValConstraint.setCaseSensitive(true);
					attValConstraint.setName(eAttribute.getName() + "_Constraint");
					attValConstraint.setType(AttributeValueConstraintType.INCLUSION);
					attValConstraint.setValue(attributeValue.toString());
					((SourceSectionAttribute) attribute).getValueConstraint().add(attValConstraint);
				} else {
					((ActualAttribute) attribute).setValue(attributeValue.toString());
				}

			}
			((EList<Attribute<?, ?, ?>>) clazz.getAttributes()).add(attribute);
		}
	}

	/**
	 * This method can be called to check if one or more of the generated {@link Section sections} represent duplicates
	 * of sections that are already present in the {@link PAMTraM} model. If duplicates exists, these are not added to
	 * the PAMTraM model but deleted instead. Additionally, all cross-references to the duplicate sections are redirected
	 * to the original sections in the PAMTraM model.
	 * 
	 * @param created The list of sections (usually created by {@link #generate()} that shall be checked and, if necessary,
	 * merged with sections from the PAMTraM model.
	 * @return The list of '<em>unique</em>' sections (after deleting duplicates).
	 */
	public LinkedList<Section<?, ?, ?>> mergeDuplicates(LinkedList<Section<?, ?, ?>> created) {

		LinkedList<Section<?, ?, ?>> createdSections = new LinkedList<>(created);

		@SuppressWarnings("unchecked")
		EList<Section<?, ? , ?>> sections = 
		(EList<Section<?, ?, ?>>) (sectionType == SectionType.SOURCE ? pamtram.getSourceSections() : pamtram.getTargetSections());

		ArrayList<Class<?, ?, ?>> duplicateSections = new ArrayList<>();

		for (Section<?, ?, ?> createdSection : createdSections) {
			if(compare(createdSection, sections)) {
				duplicateSections.add(createdSection);
			}
		}

		createdSections.removeAll(duplicateSections);
		return createdSections;
	}

	/**
	 * This compares to {@link Section sections} and, if the sections are equivalent, deletes the '<em>createdSection</em>' and
	 * redirects all cross-references to it to the existing '<em>pamtramSections</em>'.
	 * 
	 * @param createdSection The {@link Section section} that shall be compared to the sections from the PAMTraM model.
	 * @param pamtramSections The list of {@link Class sections} from the PAMTraM model that the '<em>createdSection</em> shall
	 * be compared to.
	 * @return '<em><b>true<b/></em>' if the createdSection matches one (or more) of the pamtramSections, '<em><b>false</b></em>'
	 * otherwise
	 */
	private boolean compare(Section<?, ?, ?> createdSection, EList<Section<?, ?, ?>> pamtramSections) {

		ArrayList<Class<?, ?, ?>> potentialMatches = new ArrayList<>();
		for (Class<?, ?, ?> section : pamtramSections) {
			if(!createdSection.equals(section) && createdSection.eClass().equals(section.eClass()) &&
					NullComparator.compare(createdSection.getName(), section.getName())) {
				potentialMatches.add(section);
			}
		}

		String selfHash = hash(createdSection);

		ArrayList<Class<?, ?, ?>> matchesToRemove = new ArrayList<>();

		for(Class<?, ?, ?> match : potentialMatches) {	
			String hash = hash(match);
			if(!hash.equals(selfHash)) {
				matchesToRemove.add(match);
			}
		}
		potentialMatches.removeAll(matchesToRemove);

		// TODO: iterate further to calculate the match based on the references
		// and not only on the attributes	

		if(!potentialMatches.isEmpty()) {

			// merge with the first match
			Class<?, ?, ?> match = potentialMatches.get(0);

			Collection<Setting> crossReferences = EcoreUtil.UsageCrossReferencer.find(createdSection, created.values());

			for (Setting setting : crossReferences) {
				if(setting.getEStructuralFeature().isMany()) {
					@SuppressWarnings("unchecked")
					EList<EObject> values = (EList<EObject>) setting.getEObject().eGet(setting.getEStructuralFeature());
					values.add(match);
					setting.getEObject().eSet(setting.getEStructuralFeature(), values);
				} else {
					setting.set(match);
				}
			}

			return true;
		}
		return false;
	}

	/**
	 * This calculates a '<em>hash</em>' value for a given {@link Class section} that can be used to compare to sections.
	 * To calculate the hash, the names and values of all attributes are taken into account.
	 * <br />
	 * Note: Currently, this does not take referenced sub-sections into account which might lead to situations where
	 * hashes of differing sections match. This problem has to be solved in the future.
	 *  
	 * @param createdSection The {@link Class section} for which the hash value shall be calculated.
	 * @return The calculated hash value.
	 */
	private String hash(Class<?, ?, ?> createdSection) {
		String hash = "";
		for(Attribute<?, ?, ?> att : createdSection.getAttributes()) {
			if(sectionType == SectionType.SOURCE) {
				hash = hash + ((SourceSectionAttribute) att).getAttribute().getName();
				if( ((SourceSectionAttribute) att).getValueConstraint().size() > 0){
					hash = hash +  ((SourceSectionAttribute) att).getValueConstraint().get(0).getValue();
				} else {
					hash = hash + "noValue";
				}
			} else {
				hash = hash + ((ActualAttribute) att).getAttribute().getName();
				hash = hash + ((ActualAttribute) att).getValue();
			}
		}
		return hash;
	}
}
