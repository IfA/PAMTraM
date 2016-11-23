package de.mfreund.pamtram.model.generator;

import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import pamtram.PAMTraM;
import pamtram.SectionModel;
import pamtram.metamodel.Section;
import pamtram.presentation.PamtramEditor;

/**
 * This POJO incorporates all necessary data that is collected in the course of the {@link GeneratorWizard}.
 *
 * @author mfreund
 */
public class WizardData {

	private Resource targetModelResource;
	private IPath sourceModelPath;
	private String bundleId = "de.mfreund.pamtram.model.generator";
	private SectionType sectionType;
	private EPackage ePackage;

	private List<EObject> eObjects;

	private List<Section<?, ?, ?, ?>> createdEObjects;

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
	 * The {@link PamtramEditor} used to edit the given {@link #pamtram}. If there is currently no editor used, this will be '<em>null</em>'.
	 */
	private PamtramEditor editor;

	/**
	 * The {@link MetaModelSectionGenerator} to be used to generate and merge sections.
	 */
	private MetaModelSectionGenerator generator;

	public Resource getTargetModelResource() {
		return this.targetModelResource;
	}

	public WizardData setTargetModelResource(Resource targetModelResource) {
		this.targetModelResource = targetModelResource;

		return this;
	}

	public String getBundleId() {
		return this.bundleId;
	}

	public SectionType getSectionType() {
		return this.sectionType;
	}

	public WizardData setSectionType(SectionType sectionType) {
		this.sectionType = sectionType;

		return this;
	}

	public EPackage getePackage() {
		return this.ePackage;
	}

	public WizardData setePackage(EPackage ePackage) {
		this.ePackage = ePackage;

		return this;
	}

	public List<EObject> getEObjects() {

		return this.eObjects;
	}

	public WizardData setEObjects(List<EObject> eObjects) {

		this.eObjects = eObjects;

		return this;
	}

	public IPath getSourceModelPath() {
		return this.sourceModelPath;
	}

	public WizardData setSourceModelPath(IPath sourceModelPath) {
		this.sourceModelPath = sourceModelPath;

		return this;
	}

	public List<Section<?, ?, ?, ?>> getCreatedEObjects() {
		return this.createdEObjects;
	}

	public WizardData setCreatedEObjects(List<Section<?, ?, ?, ?>> created) {
		this.createdEObjects = created;
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
	 * @param pamtram the pamtram to set
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
	 * @param editor the editor to set
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
	 * @param generator the generator to set
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
	 * @param sectionModel the sectionModel to set
	 */
	public void setSectionModel(SectionModel<?, ?, ?, ?> sectionModel) {
		this.sectionModel = sectionModel;
	}

}
