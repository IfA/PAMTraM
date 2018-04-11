/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.pamtram.model.generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.DeleteCommand;

import de.tud.et.ifa.agtele.emf.compare.EMFCompareUtil;
import de.tud.et.ifa.agtele.emf.connecting.AllowedReferenceType;
import pamtram.PAMTraM;
import pamtram.PamtramFactory;
import pamtram.SectionModel;
import pamtram.SourceSectionModel;
import pamtram.TargetSectionModel;
import pamtram.structure.constraint.ConstraintFactory;
import pamtram.structure.constraint.EqualityConstraint;
import pamtram.structure.constraint.ValueConstraintType;
import pamtram.structure.generic.ActualReference;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.Class;
import pamtram.structure.generic.CompositeReference;
import pamtram.structure.generic.CrossReference;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;
import pamtram.structure.source.ActualSourceSectionAttribute;
import pamtram.structure.source.SourceFactory;
import pamtram.structure.source.SourceSection;
import pamtram.structure.target.ActualTargetSectionAttribute;
import pamtram.structure.target.TargetFactory;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionCrossReference;
import pamtram.util.XSDAnyContentUtil;

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
	 * Whether contained elements shall be regarded in the creation process.
	 */
	private boolean includeContainedElements;

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
	 * @param includeContainedElements
	 *            Whether contained elements shall be regarded in the creation process.
	 * @param includeCrossReferences
	 *            Whether cross-references should be followed during the generation process (if this is set to
	 *            <em>true</em>, multiple sections may be generated for a single selected element).
	 */
	public MetaModelSectionGenerator(PAMTraM pamtram, List<EObject> sources, SectionType sectionType,
			boolean includeContainedElements, boolean includeCrossReferences) {

		this.pamtram = pamtram;
		this.sources = includeContainedElements ? EcoreUtil.filterDescendants(sources) : sources;
		this.sectionType = sectionType;
		this.includeContainedElements = includeContainedElements;
		this.includeCrossReferences = includeCrossReferences;
		created = new HashMap<>();
		dangling = new ArrayList<>();
	}

	/**
	 * This generates the Section(s) and returns it/them. <br />
	 * Note: The generated sections are not yet added to the PAMTraM model as some might represent duplicates of
	 * existing sections (cf. {@link #mergeDuplicates(List)}). Consequently, clients need to add the sections to the
	 * PAMTraM model on their own. Note: The generated sections are returned in a temporary SectionModel as this
	 * facilitates excluding/deleting some of the generated sections via commands like a {@link DeleteCommand}.
	 *
	 * @return The generated Section(s) in a temporary SectionModel.
	 */
	@SuppressWarnings("unchecked")
	public SectionModel<?, ?, ?, ?> generate() {

		List<Section<?, ?, ?, ?>> ret = new ArrayList<>();

		for (EObject source : sources) {
			Class<?, ?, ?, ?> metaModelSection = createMetaModelClass(source);
			if (metaModelSection instanceof Section<?, ?, ?, ?>) {

				ret.add((Section<?, ?, ?, ?>) metaModelSection);
			}
		}

		ret.addAll(dangling);

		SectionModel<?, ?, ?, ?> sectionModel;
		if (ret.get(0) instanceof SourceSection) {
			sectionModel = PamtramFactory.eINSTANCE.createSourceSectionModel();
			((SourceSectionModel) sectionModel).getSections().addAll((Collection<? extends SourceSection>) ret);
		} else {
			sectionModel = PamtramFactory.eINSTANCE.createTargetSectionModel();
			((TargetSectionModel) sectionModel).getSections().addAll((Collection<? extends TargetSection>) ret);
		}

		return sectionModel;
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
	protected Class<?, ?, ?, ?> createMetaModelClass(EObject source) {

		if (created.containsKey(source)) {
			return created.get(source);
		}

		// the class as the root element of the section
		Class<?, ?, ?, ?> clazz;
		boolean isSection = !sources.parallelStream().anyMatch(s -> EcoreUtil.isAncestor(s, source) && s != source);
		if (sectionType == SectionType.SOURCE) {
			clazz = isSection ? SourceFactory.eINSTANCE.createSourceSection()
					: SourceFactory.eINSTANCE.createSourceSectionClass();
		} else {
			clazz = isSection ? TargetFactory.eINSTANCE.createTargetSection()
					: TargetFactory.eINSTANCE.createTargetSectionClass();
		}
		clazz.setEClass(source.eClass());
		clazz.setName(source.eClass().getName());

		// add the attributes to the class
		createAttributes(source, clazz);

		// add the class to the map of created elements
		created.put(source, clazz);

		// add the references to the class (this will iterate downward in the
		// containment hierarchy and also create new
		// sections for elements referenced via non-containment references if
		// 'includeCrossReferences' is set to 'true')
		//
		if (includeContainedElements) {
			createReferences(source, clazz);
		}

		return clazz;
	}

	/**
	 * This method is responsible for the creation of the attributes inside a {@link Class}.
	 *
	 * @param source
	 *            The {@link EObject source element} for which the {@link Attribute attributes} shall be created.
	 * @param clazz
	 *            The {@link Class} to which the created attributes shall be added.
	 */
	@SuppressWarnings("unchecked")
	protected void createAttributes(EObject source, Class<?, ?, ?, ?> clazz) {

		EClass eClass = clazz.getEClass();

		EList<EAttribute> eAttributes = eClass.getEAllAttributes();
		for (EAttribute eAttribute : eAttributes) {
			Attribute<?, ?, ?, ?> attribute;
			if (sectionType == SectionType.SOURCE) {
				attribute = SourceFactory.eINSTANCE.createActualSourceSectionAttribute();
				((ActualSourceSectionAttribute) attribute).setAttribute(eAttribute);
			} else {
				attribute = TargetFactory.eINSTANCE.createActualTargetSectionAttribute();
				((ActualTargetSectionAttribute) attribute).setAttribute(eAttribute);
			}
			attribute.setName(eAttribute.getName());
			Object attributeValue = source.eGet(eAttribute);
			if (attributeValue != null) {
				if (sectionType == SectionType.SOURCE) {
					EqualityConstraint attValConstraint = ConstraintFactory.eINSTANCE.createEqualityConstraint();
					attValConstraint.setName(eAttribute.getName() + "_Constraint");
					attValConstraint.setType(ValueConstraintType.REQUIRED);
					attValConstraint.setExpression(attributeValue.toString());
					((ActualSourceSectionAttribute) attribute).getValueConstraints().add(attValConstraint);
				} else {
					((ActualTargetSectionAttribute) attribute).setValue(attributeValue.toString());
				}

			}
			((EList<Attribute<?, ?, ?, ?>>) clazz.getAttributes()).add(attribute);
		}
	}

	/**
	 * This method is responsible for the creation of the references inside a {@link Class}.
	 *
	 * @param source
	 *            The source {@link EObject} for which the references shall be created.
	 * @param parentClass
	 *            The parent {@link Class} for the references to be created.
	 */
	protected void createReferences(EObject source, Class<?, ?, ?, ?> parent) {

		// plunge deeper by evaluating the containment references
		//
		XSDAnyContentUtil
				.getEAllReferencesIncludingVirtualAnyContentReference(source.eClass(), AllowedReferenceType.CONTAINMENT)
				.stream().forEach(ref -> createContainmentReference(source, parent, ref));

		// handle the non-containment references
		//
		XSDAnyContentUtil
				.getEAllReferencesIncludingVirtualAnyContentReference(source.eClass(),
						AllowedReferenceType.NONCONTAINMENT)
				.stream().forEach(ref -> createNonContainmentReference(source, parent, ref));
	}

	/**
	 * Creates a {@link CompositeReference} element for the given source {@link EObject}.
	 *
	 * @param source
	 *            The source {@link EObject} for which the reference shall be created.
	 * @param parentClass
	 *            The parent {@link Class} for the reference to be created.
	 * @param reference
	 *            The containment {@link EReference} for which the {@link CompositeReference} shall be created.
	 */
	@SuppressWarnings("unchecked")
	protected void createContainmentReference(EObject source, Class<?, ?, ?, ?> parentClass, EReference reference) {

		// create a 'containment reference' object
		//
		CompositeReference<?, ?, ?, ?> containmentReference;
		if (sectionType == SectionType.SOURCE) {
			containmentReference = SourceFactory.eINSTANCE.createSourceSectionCompositeReference();
		} else {
			containmentReference = TargetFactory.eINSTANCE.createTargetSectionCompositeReference();
		}
		((ActualReference<?, ?, ?, ?>) containmentReference).setEReference(reference);
		containmentReference.setName(reference.getName());

		// get the objects contained via the containment reference
		//
		if (source.eGet(reference) == null) {
			return;
		}
		ArrayList<EObject> contained = new ArrayList<>();
		if (reference.isMany()) {
			contained.addAll((Collection<? extends EObject>) source.eGet(reference));
		} else {
			contained.add((EObject) source.eGet(reference));
		}
		for (EObject eObject : contained) {

			// check if an uncontained section representing the eObject already
			// exists
			// (this might be the case if it has been created by a
			// non-containment reference)
			Class<?, ?, ?, ?> existing = created.get(eObject);
			if (existing != null && dangling.contains(existing)) {
				// link the existing class
				((EList<Class<?, ?, ?, ?>>) containmentReference.getValue()).add(existing);
				dangling.remove(existing);
			} else {
				// create a new (part) metamodel section beginning at the object
				// and link it to the current section
				((EList<Class<?, ?, ?, ?>>) containmentReference.getValue()).add(createMetaModelClass(eObject));
			}
		}

		// add the created reference to the list of references of the current
		// class
		// and thus complete the metamodel section
		if (!containmentReference.getValue().isEmpty()) {
			((EList<Reference<?, ?, ?, ?>>) parentClass.getReferences()).add(containmentReference);
		} else {
			EcoreUtil.remove(containmentReference);
		}
	}

	/**
	 * Creates a {@link CrossReference} element for the given source {@link EObject}.
	 *
	 * @param source
	 *            The source {@link EObject} for which the reference shall be created.
	 * @param parentClass
	 *            The parent {@link Class} for the reference to be created.
	 * @param reference
	 *            The non-containment {@link EReference} for which the {@link CrossReference} shall be created.
	 */
	@SuppressWarnings("unchecked")
	protected void createNonContainmentReference(EObject source, Class<?, ?, ?, ?> parent, EReference reference) {

		// create a 'non containment reference' object
		Reference<?, ?, ?, ?> nonContainmentReference;
		if (sectionType == SectionType.SOURCE) {
			nonContainmentReference = SourceFactory.eINSTANCE.createSourceSectionCrossReference();
		} else {
			nonContainmentReference = TargetFactory.eINSTANCE.createTargetSectionCrossReference();
		}
		((ActualReference<?, ?, ?, ?>) nonContainmentReference).setEReference(reference);
		nonContainmentReference.setName(reference.getName());

		if (source.eGet(reference) == null) { // no referenced object
			return;
		}

		List<EObject> referenced = new ArrayList<>();
		if (reference.isMany()) {
			referenced.addAll((Collection<? extends EObject>) source.eGet(reference));
		} else {
			referenced.add((EObject) source.eGet(reference));
		}

		// If 'includeCrossReferences' is set to 'false', we do not create any
		// new Sections. Consequently, we filter
		// all elements, that are not part of the current section
		//
		if (!includeCrossReferences
				&& sources.parallelStream().filter(s -> EcoreUtil.isAncestor(s, source)).findAny().isPresent()) {

			Optional<EObject> rootElement = sources.parallelStream().filter(s -> EcoreUtil.isAncestor(s, source))
					.findAny();

			if (rootElement.isPresent()) {

				referenced = referenced.parallelStream().filter(r -> EcoreUtil.isAncestor(rootElement.get(), r))
						.collect(Collectors.toList());
			}
		}

		// get the objects referenced by the non-containment reference
		for (EObject eObject : referenced) {

			// check if a section representing the eObject already exists
			Class<?, ?, ?, ?> existing = created.get(eObject);
			if (existing != null) {
				// link the existing class
				((EList<Class<?, ?, ?, ?>>) ((CrossReference<?, ?, ?, ?>) nonContainmentReference).getValue())
						.add(existing);
			} else {
				// create a new metamodel section beginning at the object and
				// link it to the mapping model
				Class<?, ?, ?, ?> metaModelSection = createMetaModelClass(eObject);
				if (metaModelSection instanceof Section<?, ?, ?, ?>) {
					dangling.add((Section<?, ?, ?, ?>) metaModelSection);
				}
				if (sectionType == SectionType.SOURCE) {
					((EList<Class<?, ?, ?, ?>>) ((CrossReference<?, ?, ?, ?>) nonContainmentReference).getValue())
							.add(metaModelSection);
				} else {
					((TargetSectionCrossReference) nonContainmentReference).getValue()
							.add((TargetSectionClass) metaModelSection);
				}
			}
		}

		// link the created metamodel section to the current section
		//
		((EList<Reference<?, ?, ?, ?>>) parent.getReferences()).add(nonContainmentReference);
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
		List<Section<?, ?, ?, ?>> sections = (List<Section<?, ?, ?, ?>>) (sectionType == SectionType.SOURCE
				? pamtram.getSourceSections()
				: pamtram.getTargetSections());

		List<Class<?, ?, ?, ?>> internalDuplicateSections = new ArrayList<>();

		// Filter duplicates in the created sections
		//
		for (Section<?, ?, ?, ?> createdSection : createdSections) {
			List<Section<?, ?, ?, ?>> sectionsWithoutSelf = createdSections.stream()
					.filter(s -> !s.equals(createdSection) && !internalDuplicateSections.contains(s))
					.collect(Collectors.toList());
			if (compare(createdSection, sectionsWithoutSelf, sectionsWithoutSelf)) {
				internalDuplicateSections.add(createdSection);
			}
		}

		createdSections.removeAll(internalDuplicateSections);
		internalDuplicateSections.stream().forEach(d -> EcoreUtil.delete(d, true));

		List<Class<?, ?, ?, ?>> duplicateSections = new ArrayList<>();

		// Filter duplicates in the PAMTraM model
		//
		for (Section<?, ?, ?, ?> createdSection : createdSections) {
			if (compare(createdSection, sections,
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

		if (potentialMatches.isEmpty()) {
			return false;
		}

		// merge with the first match by replacing all cross-references
		//
		Class<?, ?, ?, ?> match = potentialMatches.get(0);

		Collection<Setting> crossReferences = EcoreUtil.UsageCrossReferencer.find(createdSection, referencingSections);

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
					values.add(index,
							relativeFragmentPath.isEmpty() ? match : EcoreUtil.getEObject(match, relativeFragmentPath));
				}

				setting.set(values);
			} else {

				EObject value = (EObject) setting.get(true);

				String relativeFragmentPath = EcoreUtil.getRelativeURIFragmentPath(createdSection, value);

				setting.set(relativeFragmentPath.isEmpty() ? match : EcoreUtil.getEObject(match, relativeFragmentPath));
			}
		}

		return true;
	}

}
