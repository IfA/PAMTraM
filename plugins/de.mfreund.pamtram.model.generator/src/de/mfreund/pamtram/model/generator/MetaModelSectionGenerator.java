package de.mfreund.pamtram.model.generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.tud.et.ifa.agtele.emf.compare.EMFCompareUtil;
import pamtram.PAMTraM;
import pamtram.metamodel.ActualSourceSectionAttribute;
import pamtram.metamodel.ActualTargetSectionAttribute;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.Class;
import pamtram.metamodel.ContainmentReference;
import pamtram.metamodel.EqualityMatcher;
import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.MetamodelFactory;
import pamtram.metamodel.Reference;
import pamtram.metamodel.Section;
import pamtram.metamodel.SourceSection;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.TargetSection;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionNonContainmentReference;
import pamtram.metamodel.ValueConstraintType;

/**
 * This class is responsible for the generation of {@link Section MetaModelSections} from excerpts of a model.
 *
 * @author mfreund
 */
public class MetaModelSectionGenerator {

	/**
	 * The PAMTraM instance where the generated Section will be be stored.
	 */
	private PAMTraM pamtram;

	/**
	 * The list of source eObjects from which the sections will be generated.
	 */
	private List<EObject> sources;

	/**
	 * The SectionType specifying whether to generate a Source or a TargetSection.
	 */
	private SectionType sectionType;

	/**
	 * Whether cross-references should be followed during the generation process.
	 */
	private boolean includeCrossReferences;

	/**
	 * This contains a map of metamodel section that have been created so far
	 */
	private HashMap<EObject, Class<?, ?, ?, ?>> created;

	/**
	 * This contains a list of metamodel (sub-)sections that are not yet contained by the pamtram or by another class
	 */
	private ArrayList<Section<?, ?, ?, ?>> dangling;

	/**
	 * This creates an instance.
	 *
	 * @param pamtram
	 *            The PAMTraM instance where the generated Section shall be stored.
	 * @param sources
	 *            The source eObjects from which the sections shall be generated.
	 * @param sectionType
	 *            The SectionType specifying whether to generate a Source or a TargetSection.
	 * @param includeCrossReferences
	 *            Whether cross-references should be followed during the generation process (if this is set to
	 *            <em>true</em>, multiple sections may be generated for a single selected element).
	 */
	public MetaModelSectionGenerator(PAMTraM pamtram, List<EObject> sources, SectionType sectionType,
			boolean includeCrossReferences) {
		this.pamtram = pamtram;
		this.sources = EcoreUtil.filterDescendants(sources);
		this.sectionType = sectionType;
		this.includeCrossReferences = includeCrossReferences;
		this.created = new HashMap<>();
		this.dangling = new ArrayList<>();
	}

	/**
	 * This generates the Section(s) and returns it/them. <br />
	 * Note: The generated sections are not yet added to the PAMTraM model as some might represent duplicates of
	 * existing sections (cf. {@link #mergeDuplicates(List)}). Consequently, clients need to add the sections to the
	 * PAMTraM model on their own.
	 *
	 * @return The generated Section(s).
	 */
	public List<Section<?, ?, ?, ?>> generate() {

		List<Section<?, ?, ?, ?>> ret = new ArrayList<>();

		for (EObject source : this.sources) {
			Class<?, ?, ?, ?> metaModelSection = this.createMetaModelClass(source);
			if (metaModelSection instanceof Section<?, ?, ?, ?>) {

				ret.add((Section<?, ?, ?, ?>) metaModelSection);
			}
		}

		ret.addAll(this.dangling);

		return ret;
	}

	/**
	 * This method recursively generates the containment structure of the {@link Section} and - if
	 * {@link #includeCrossReferences} is set to <em>true</em> - possible other sections for elements that are
	 * referenced via non-containment references.
	 *
	 * @param source
	 *            The {@link EObject source object} for which the structure shall be created.
	 * @return The created {@link Section section}.
	 */
	@SuppressWarnings("unchecked")
	private Class<?, ?, ?, ?> createMetaModelClass(EObject source) {

		if (this.created.containsKey(source)) {
			return this.created.get(source);
		}

		EClass eClass = source.eClass();

		// the class as the root element of the section
		Class<?, ?, ?, ?> clazz;
		boolean isSection = !this.sources.parallelStream()
				.anyMatch(s -> EcoreUtil.isAncestor(s, source) && s != source);
		if (this.sectionType == SectionType.SOURCE) {
			clazz = isSection ? MetamodelFactory.eINSTANCE.createSourceSection()
					: MetamodelFactory.eINSTANCE.createSourceSectionClass();
		} else {
			clazz = isSection ? MetamodelFactory.eINSTANCE.createTargetSection()
					: MetamodelFactory.eINSTANCE.createTargetSectionClass();
		}
		clazz.setEClass(eClass);
		clazz.setName(eClass.getName());

		// add the attributes to the class
		this.createAttributes(source, clazz);

		// add the class to the map of created elements
		this.created.put(source, clazz);

		ArrayList<EReference> eAllContainments = new ArrayList<>();
		ArrayList<EReference> eAllNonContainments = new ArrayList<>();

		for (EReference eReference : eClass.getEAllReferences()) {
			if (eReference.isContainment()) {
				eAllContainments.add(eReference);
			} else {
				eAllNonContainments.add(eReference);
			}
		}

		// plunge deeper by evaluating the containment references
		for (EReference eContainment : eAllContainments) {
			// create a 'containment reference' object
			ContainmentReference<?, ?, ?, ?> containmentReference;
			if (this.sectionType == SectionType.SOURCE) {
				containmentReference = MetamodelFactory.eINSTANCE.createSourceSectionContainmentReference();
			} else {
				containmentReference = MetamodelFactory.eINSTANCE.createTargetSectionContainmentReference();
			}
			containmentReference.setEReference(eContainment);
			containmentReference.setName(eContainment.getName());

			// get the objects contained via the containment reference
			if (source.eGet(eContainment) == null) {
				continue;
			}
			ArrayList<EObject> contained = new ArrayList<>();
			if (eContainment.isMany()) {
				contained.addAll((Collection<? extends EObject>) source.eGet(eContainment));
			} else {
				contained.add((EObject) source.eGet(eContainment));
			}
			for (EObject eObject : contained) {

				// check if an uncontained section representing the eObject already exists
				// (this might be the case if it has been created by a non-containment reference)
				Class<?, ?, ?, ?> existing = this.created.get(eObject);
				if (existing != null && this.dangling.contains(existing)) {
					// link the existing class
					((EList<Class<?, ?, ?, ?>>) containmentReference.getValue()).add(existing);
					this.dangling.remove(existing);
				} else {
					// create a new (part) metamodel section beginning at the object and link it to the current section
					((EList<Class<?, ?, ?, ?>>) containmentReference.getValue())
					.add(this.createMetaModelClass(eObject));
				}
			}

			// add the created reference to the list of references of the current class
			// and thus complete the metamodel section
			if (!containmentReference.getValue().isEmpty()) {
				((EList<Reference<?, ?, ?, ?>>) clazz.getReferences()).add(containmentReference);
			} else {
				EcoreUtil.remove(containmentReference);
			}
		}

		// handle the non-containment references
		for (EReference eNonContainment : eAllNonContainments) {

			// create a 'non containment reference' object
			Reference<?, ?, ?, ?> nonContainmentReference;
			if (this.sectionType == SectionType.SOURCE) {
				nonContainmentReference = MetamodelFactory.eINSTANCE.createMetaModelSectionReference();
			} else {
				nonContainmentReference = MetamodelFactory.eINSTANCE.createTargetSectionNonContainmentReference();
			}
			nonContainmentReference.setEReference(eNonContainment);
			nonContainmentReference.setName(eNonContainment.getName());

			if (source.eGet(eNonContainment) == null) { // no referenced object
				continue;
			}

			List<EObject> referenced = new ArrayList<>();
			if (eNonContainment.isMany()) {
				referenced.addAll((Collection<? extends EObject>) source.eGet(eNonContainment));
			} else {
				referenced.add((EObject) source.eGet(eNonContainment));
			}

			// If 'includeCrossReferences' is set to 'false', we do not create any new Sections. Consequently, we filter
			// all elements, that are not part of the current section
			//
			if (!this.includeCrossReferences && this.sources.parallelStream()
					.filter(s -> EcoreUtil.isAncestor(s, source)).findAny().isPresent()) {

				EObject rootElement = this.sources.parallelStream().filter(s -> EcoreUtil.isAncestor(s, source))
						.findAny().get();
				referenced = referenced.parallelStream().filter(r -> EcoreUtil.isAncestor(rootElement, r))
						.collect(Collectors.toList());
			}

			// get the objects referenced by the non-containment reference
			for (EObject eObject : referenced) {

				// check if a section representing the eObject already exists
				Class<?, ?, ?, ?> existing = this.created.get(eObject);
				if (existing != null) {
					// link the existing class
					if (this.sectionType == SectionType.SOURCE) {
						((MetaModelSectionReference) nonContainmentReference).getValue().add((SourceSection) existing);
					} else {
						((TargetSectionNonContainmentReference) nonContainmentReference).getValue()
						.add((TargetSection) existing);
					}
				} else {
					// create a new metamodel section beginning at the object and link it to the mapping model
					Class<?, ?, ?, ?> metaModelSection = this.createMetaModelClass(eObject);
					if (metaModelSection instanceof Section<?, ?, ?, ?>) {
						this.dangling.add((Section<?, ?, ?, ?>) metaModelSection);
					}
					if (this.sectionType == SectionType.SOURCE) {
						((MetaModelSectionReference) nonContainmentReference).getValue()
						.add((SourceSectionClass) metaModelSection);
					} else {
						((TargetSectionNonContainmentReference) nonContainmentReference).getValue()
						.add((TargetSectionClass) metaModelSection);
					}
				}
			}

			// link the created metamodel section to the current section
			((EList<Reference<?, ?, ?, ?>>) clazz.getReferences()).add(nonContainmentReference);

		}

		return clazz;
	}

	/**
	 * This method is responsible for the creation of the attributes inside a {@link Class section}.
	 *
	 * @param source
	 *            The {@link EObject source element} for which the {@link Attribute attributes} shall be created.
	 * @param clazz
	 *            The {@link Class} to which the created attributes shall be added.
	 */
	@SuppressWarnings("unchecked")
	private void createAttributes(EObject source, Class<?, ?, ?, ?> clazz) {

		EClass eClass = clazz.getEClass();

		EList<EAttribute> eAttributes = eClass.getEAllAttributes();
		for (EAttribute eAttribute : eAttributes) {
			Attribute<?, ?, ?, ?> attribute;
			if (this.sectionType == SectionType.SOURCE) {
				attribute = MetamodelFactory.eINSTANCE.createActualSourceSectionAttribute();
				((ActualSourceSectionAttribute) attribute).setAttribute(eAttribute);
			} else {
				attribute = MetamodelFactory.eINSTANCE.createActualTargetSectionAttribute();
				((ActualTargetSectionAttribute) attribute).setAttribute(eAttribute);
			}
			attribute.setName(eAttribute.getName());
			Object attributeValue = source.eGet(eAttribute);
			if (attributeValue != null) {
				if (this.sectionType == SectionType.SOURCE) {
					EqualityMatcher attValConstraint = MetamodelFactory.eINSTANCE.createEqualityMatcher();
					attValConstraint.setCaseSensitive(true);
					attValConstraint.setName(eAttribute.getName() + "_Constraint");
					attValConstraint.setType(ValueConstraintType.INCLUSION);
					attValConstraint.setExpression(attributeValue.toString());
					((ActualSourceSectionAttribute) attribute).getValueConstraint().add(attValConstraint);
				} else {
					((ActualTargetSectionAttribute) attribute).setValue(attributeValue.toString());
				}

			}
			((EList<Attribute<?, ?, ?, ?>>) clazz.getAttributes()).add(attribute);
		}
	}

	/**
	 * This method can be called to check if one or more of the generated {@link Section sections} represent duplicates
	 * of sections that are already present in the {@link PAMTraM} model. If duplicates exists, these are not added to
	 * the PAMTraM model but deleted instead. Additionally, all cross-references to the duplicate sections are
	 * redirected to the original sections in the PAMTraM model.
	 *
	 * @param created
	 *            The list of sections (usually created by {@link #generate()} that shall be checked and, if necessary,
	 *            merged with sections from the PAMTraM model.
	 * @return The list of '<em>unique</em>' sections (after deleting duplicates).
	 */
	public List<Section<?, ?, ?, ?>> mergeDuplicates(List<Section<?, ?, ?, ?>> created) {

		LinkedList<Section<?, ?, ?, ?>> createdSections = new LinkedList<>(created);

		@SuppressWarnings("unchecked")
		List<Section<?, ?, ?, ?>> sections = (List<Section<?, ?, ?, ?>>) (this.sectionType == SectionType.SOURCE
		? this.pamtram.getSourceSections() : this.pamtram.getTargetSections());

		List<Class<?, ?, ?, ?>> internalDuplicateSections = new ArrayList<>();

		// Filter duplicates in the created sections
		//
		for (Section<?, ?, ?, ?> createdSection : createdSections) {
			List<Section<?, ?, ?, ?>> sectionsWithoutSelf = createdSections.stream()
					.filter(s -> !s.equals(createdSection) && !internalDuplicateSections.contains(s))
					.collect(Collectors.toList());
			if (this.compare(createdSection, sectionsWithoutSelf, sectionsWithoutSelf)) {
				internalDuplicateSections.add(createdSection);
			}
		}

		createdSections.removeAll(internalDuplicateSections);
		internalDuplicateSections.stream().forEach(d -> EcoreUtil.delete(d, true));

		List<Class<?, ?, ?, ?>> duplicateSections = new ArrayList<>();

		// Filter duplicates in the PAMTraM model
		//
		for (Section<?, ?, ?, ?> createdSection : createdSections) {
			if (this.compare(createdSection, sections,
					createdSections.stream().filter(s -> !s.equals(createdSection) && !duplicateSections.contains(s))
					.collect(Collectors.toList()))) {
				duplicateSections.add(createdSection);
			}
		}

		createdSections.removeAll(duplicateSections);
		return createdSections;
	}

	/**
	 * This compares two {@link Section sections} and, if the sections are equivalent, deletes the
	 * '<em>createdSection</em>' and redirects all cross-references to it to the existing '<em>pamtramSections</em>'.
	 *
	 * @param createdSection
	 *            The {@link Section section} that shall be compared to the sections from the PAMTraM model.
	 * @param sectionsToCompare
	 *            The list of {@link Section sections} that the '<em>createdSection</em> shall be compared to.
	 * @param referencingSections
	 *            The list of {@link Section sections} that might contain cross-references to the
	 *            <em>createdSection</em> which need to be redirected to a potential match.
	 * @return '<em><b>true</b></em>' if the createdSection matches one (or more) of the pamtramSections,
	 *         '<em><b>false</b></em>' otherwise
	 */
	private boolean compare(Section<?, ?, ?, ?> createdSection, List<Section<?, ?, ?, ?>> sectionsToCompare,
			List<Section<?, ?, ?, ?>> referencingSections) {

		List<Section<?, ?, ?, ?>> potentialMatches = sectionsToCompare.stream()
				.filter(s -> EMFCompareUtil.isMatch(s, createdSection)).collect(Collectors.toList());

		if (!potentialMatches.isEmpty()) {

			// merge with the first match by replacing all cross-references
			//
			Class<?, ?, ?, ?> match = potentialMatches.get(0);

			Collection<Setting> crossReferences = EcoreUtil.UsageCrossReferencer.find(createdSection,
					referencingSections);

			for (Setting setting : crossReferences) {

				if (setting.getEStructuralFeature().isMany()) {

					@SuppressWarnings("unchecked")
					List<EObject> values = new ArrayList<>((EList<EObject>) setting.get(true));

					List<EObject> descendants = values.stream().filter(v -> EcoreUtil.isAncestor(createdSection, v))
							.collect(Collectors.toList());

					for (EObject descendant : descendants) {
						String relativeFragmentPath = EcoreUtil.getRelativeURIFragmentPath(createdSection, descendant);
						int index = values.indexOf(descendant);
						values.remove(descendant);
						values.add(index, relativeFragmentPath.isEmpty() ? match
								: EcoreUtil.getEObject(match, relativeFragmentPath));
					}

					setting.set(values);
				} else {

					EObject value = (EObject) setting.get(true);

					String relativeFragmentPath = EcoreUtil.getRelativeURIFragmentPath(createdSection, value);

					setting.set(
							relativeFragmentPath.isEmpty() ? match : EcoreUtil.getEObject(match, relativeFragmentPath));
				}
			}

			return true;
		}

		return false;
	}

}
