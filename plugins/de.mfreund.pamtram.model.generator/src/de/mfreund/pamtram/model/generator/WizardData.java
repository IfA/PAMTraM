package de.mfreund.pamtram.model.generator;

import java.util.LinkedList;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import pamtram.PAMTraM;
import pamtram.SectionModel;
import pamtram.metamodel.Section;
import pamtram.presentation.PamtramEditor;

public class WizardData {

	private Resource targetModelResource;
	private IPath sourceModelPath;
	private String bundleId = "de.mfreund.pamtram.model.generator";
	private SectionType sectionType;
	private EPackage ePackage;
	private EObject eObject;
	private LinkedList<Section<?, ?, ?, ?>> createdEObjects;

	/**
	 * The {@link PAMTraM} instance into that the generated section shall be stored.
	 */
	private PAMTraM pamtram;

	/**
	 * The {@link SectionModel} instance into that the generated sections shall be stored.
	 */
	private SectionModel<?, ?, ?, ?> sectionModel;

	/**
	 * The {@link PamtramEditor} used to edit the given {@link #pamtram}. If there is currently no editor used, this will be '<em>null</em>'.
	 */
	private PamtramEditor editor;

	/**
	 * The {@link MetaModelSectionGenerator} to be used to generate and merge sections.
	 */
	private MetaModelSectionGenerator generator;

	public Resource getTargetModelResource() {
		return targetModelResource;
	}

	public WizardData setTargetModelResource(Resource targetModelResource) {
		this.targetModelResource = targetModelResource;

		return this;
	}

	public String getBundleId() {
		return bundleId;
	}

	public SectionType getSectionType() {
		return sectionType;
	}

	public WizardData setSectionType(SectionType sectionType) {
		this.sectionType = sectionType;

		return this;
	}

	public EPackage getePackage() {
		return ePackage;
	}

	public WizardData setePackage(EPackage ePackage) {
		this.ePackage = ePackage;

		return this;
	}

	public EObject geteObject() {
		return eObject;
	}

	public WizardData seteObject(EObject eObject) {
		this.eObject = eObject;

		return this;
	}

	public IPath getSourceModelPath() {
		return sourceModelPath;
	}

	public WizardData setSourceModelPath(IPath sourceModelPath) {
		this.sourceModelPath = sourceModelPath;

		return this;
	}

	public LinkedList<Section<?, ?, ?, ?>> getCreatedEObjects() {
		return createdEObjects;
	}

	public void setCreatedEObjects(LinkedList<Section<?, ?, ?, ?>> created) {
		this.createdEObjects = created;
	}

	/**
	 * @return the pamtram
	 */
	public PAMTraM getPamtram() {
		return pamtram;
	}

	/**
	 * @param pamtram the pamtram to set
	 */
	public void setPamtram(PAMTraM pamtram) {
		this.pamtram = pamtram;
	}

	/**
	 * @return the editor
	 */
	public PamtramEditor getEditor() {
		return editor;
	}

	/**
	 * @param editor the editor to set
	 */
	public void setEditor(PamtramEditor editor) {
		this.editor = editor;
	}

	/**
	 * @return the generator
	 */
	public MetaModelSectionGenerator getGenerator() {
		return generator;
	}

	/**
	 * @param generator the generator to set
	 */
	public void setGenerator(MetaModelSectionGenerator generator) {
		this.generator = generator;
	}

	/**
	 * @return the sectionModel
	 */
	public SectionModel<?, ?, ?, ?> getSectionModel() {
		return sectionModel;
	}

	/**
	 * @param sectionModel the sectionModel to set
	 */
	public void setSectionModel(SectionModel<?, ?, ?, ?> sectionModel) {
		this.sectionModel = sectionModel;
	}

}
