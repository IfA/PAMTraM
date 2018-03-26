/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.pamtram.model.generator;

import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.provider.GenLibraryItemProviderAdapterFactory;
import pamtram.PAMTraM;
import pamtram.SectionModel;
import pamtram.condition.provider.ConditionItemProviderAdapterFactory;
import pamtram.mapping.provider.MappingItemProviderAdapterFactory;
import pamtram.presentation.PamtramEditor;
import pamtram.provider.PamtramItemProviderAdapterFactory;
import pamtram.structure.generic.Section;
import pamtram.structure.provider.StructureItemProviderAdapterFactory;

/**
 * This POJO incorporates all necessary data that is collected in the course of the {@link GeneratorWizard}.
 *
 * @author mfreund
 */
public class WizardData implements IEditingDomainProvider {

	/**
	 * The {@link Resource} containing the target {@link #pamtram} model into which the generated Sections shall be
	 * added.
	 */
	private Resource targetModelResource;

	/**
	 * The {@link SectionType type} of the Sections to be created (<em>source</em> or <em>target</em>).
	 */
	private SectionType sectionType;

	/**
	 * The {@link EPackage} describing the {@link #sourceElements}.
	 */
	private EPackage ePackage;

	/**
	 * The list of source {@link EObject EObjects} based on which the Sections are created.
	 */
	private List<EObject> sourceElements;

	/**
	 * The {@link Section Sections} that have been created based on the {@link #sourceElements}.
	 */
	private List<Section<?, ?, ?, ?>> createdSections;

	/**
	 * Whether contained elements shall be regarded in the creation process
	 */
	private boolean includeContainedElements;

	/**
	 * Whether cross references shall be regarded in the creation process
	 */
	private boolean includeCrossReferences;

	/**
	 * The {@link PAMTraM} instance into that the generated section shall be stored.
	 */
	private PAMTraM pamtram;

	/**
	 * The {@link SectionModel} instance into that the generated sections shall be stored.
	 */
	private SectionModel<?, ?, ?, ?> sectionModel;

	/**
	 * The {@link PamtramEditor} used to edit the given {@link #pamtram}. If there is currently no editor used, this
	 * will be '<em>null</em>'.
	 */
	private PamtramEditor editor;

	/**
	 * The {@link MetaModelSectionGenerator} to be used to generate and merge sections.
	 */
	private MetaModelSectionGenerator generator;

	/**
	 * An {@link EditingDomain} that can be used to apply changes to the {@link #createdSections} via its
	 * {@link CommandStack}.
	 */
	private AdapterFactoryEditingDomain editingDomain;

	/**
	 * This creates an instance.
	 *
	 */
	public WizardData() {

		// Create an adapter factory that yields item providers and that is used for the editing domain.
		//
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new PamtramItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new StructureItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ConditionItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new MappingItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new GenLibraryItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		// Initialize the editing domain
		//
		this.editingDomain = new AdapterFactoryEditingDomain(adapterFactory, new BasicCommandStack(),
				new HashMap<Resource, Boolean>());
	}

	/**
	 *
	 * @return the {@link #targetModelResource}
	 */
	public Resource getTargetModelResource() {

		return this.targetModelResource;
	}

	/**
	 *
	 * @param targetModelResource
	 *            the {@link #targetModelResource}
	 * @return The {@link WizardData} element.
	 */
	public WizardData setTargetModelResource(Resource targetModelResource) {

		this.targetModelResource = targetModelResource;

		return this;
	}

	/**
	 *
	 * @return the {@link #sectionType}
	 */
	public SectionType getSectionType() {

		return this.sectionType;
	}

	/**
	 *
	 * @param sectionType
	 *            the {@link #sectionType}
	 * @return The {@link WizardData} element.
	 */
	public WizardData setSectionType(SectionType sectionType) {

		this.sectionType = sectionType;

		return this;
	}

	/**
	 * @return the {@link #ePackage}
	 */
	public EPackage getEPackage() {

		return this.ePackage;
	}

	/**
	 * This is the setter for the {@link #ePackage}.
	 *
	 * @param ePackage
	 *            the {@link #ePackage} to set.
	 * @return The {@link WizardData}.
	 */
	public WizardData setEPackage(EPackage ePackage) {

		this.ePackage = ePackage;

		return this;
	}

	/**
	 * @return the {@link #sourceElements}
	 */
	public List<EObject> getSourceElements() {

		return this.sourceElements;
	}

	/**
	 * This is the setter for the {@link #sourceElements}.
	 *
	 * @param sourceElements
	 *            the {@link #sourceElements} to set.
	 * @return The {@link WizardData}.
	 */
	public WizardData setSourceElements(List<EObject> sourceElements) {

		this.sourceElements = sourceElements;

		return this;
	}

	/**
	 * @return the {@link #createdSections}
	 */
	public List<Section<?, ?, ?, ?>> getCreatedSections() {

		return this.createdSections;
	}

	/**
	 * This is the setter for the {@link #createdSections}.
	 *
	 * @param createdEObjects
	 *            the {@link #createdSections} to set.
	 * @return The {@link WizardData}.
	 */
	public WizardData setCreatedSections(List<Section<?, ?, ?, ?>> createdEObjects) {

		this.createdSections = createdEObjects;
		return this;
	}

	/**
	 * @return the {@link #includeContainedElements}
	 */
	public boolean isIncludeContainedElements() {

		return this.includeContainedElements;
	}

	/**
	 * This is the setter for the {@link #includeContainedElements}.
	 *
	 * @param includeContainedElements
	 *            the {@link #includeContainedElements} to set.
	 * @return The {@link WizardData}.
	 */
	public WizardData setIncludeContainedElements(boolean includeContainedElements) {

		this.includeContainedElements = includeContainedElements;
		return this;
	}

	/**
	 * @return the {@link #includeCrossReferences}
	 */
	public boolean isIncludeCrossReferences() {

		return this.includeCrossReferences;
	}

	/**
	 * This is the setter for the {@link #includeCrossReferences}.
	 *
	 * @param includeCrossReferences
	 *            the {@link #includeCrossReferences} to set.
	 * @return The {@link WizardData}.
	 */
	public WizardData setIncludeCrossReferences(boolean includeCrossReferences) {

		this.includeCrossReferences = includeCrossReferences;
		return this;
	}

	/**
	 * @return the pamtram
	 */
	public PAMTraM getPamtram() {

		return this.pamtram;
	}

	/**
	 * @param pamtram
	 *            the pamtram to set
	 */
	public void setPamtram(PAMTraM pamtram) {

		this.pamtram = pamtram;
	}

	/**
	 * @return the editor
	 */
	public PamtramEditor getEditor() {

		return this.editor;
	}

	/**
	 * @param editor
	 *            the editor to set
	 */
	public void setEditor(PamtramEditor editor) {

		this.editor = editor;
	}

	/**
	 * @return the generator
	 */
	public MetaModelSectionGenerator getGenerator() {

		return this.generator;
	}

	/**
	 * @param generator
	 *            the generator to set
	 */
	public void setGenerator(MetaModelSectionGenerator generator) {

		this.generator = generator;
	}

	/**
	 * @return the sectionModel
	 */
	public SectionModel<?, ?, ?, ?> getSectionModel() {

		return this.sectionModel;
	}

	/**
	 * @param sectionModel
	 *            the sectionModel to set
	 */
	public void setSectionModel(SectionModel<?, ?, ?, ?> sectionModel) {

		this.sectionModel = sectionModel;
	}

	@Override
	public EditingDomain getEditingDomain() {

		return this.editingDomain;
	}

}
