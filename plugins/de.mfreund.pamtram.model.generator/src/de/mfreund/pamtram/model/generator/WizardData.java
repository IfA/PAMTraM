package de.mfreund.pamtram.model.generator;

import java.util.LinkedList;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import de.mfreund.epsilon.EolExecutor;
import pamtram.PAMTraM;
import pamtram.metamodel.Class;

public class WizardData {

	private Resource targetModelResource;
	private IPath sourceModelPath;
	private EolExecutor eolExecutor;
	private String bundleId = "de.mfreund.pamtram.model.generator";
	private SectionType sectionType;
	private EPackage ePackage;
	private EObject eObject;
	private LinkedList<Class<?, ?, ?>> createdEObjects;

	/**
	 * The {@link PAMTraM} instance into that the generated section shall be stored.
	 */
	private PAMTraM pamtram;

	public Resource getTargetModelResource() {
		return targetModelResource;
	}

	public WizardData setTargetModelResource(Resource targetModelResource) {
		this.targetModelResource = targetModelResource;

		return this;
	}

	public EolExecutor getEolExecutor() {
		if(eolExecutor == null) {
			eolExecutor = new EolExecutor();
		}
		return eolExecutor;
	}

	public WizardData setEolExecutor(EolExecutor eolExecutor) {
		this.eolExecutor = eolExecutor;

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

	public LinkedList<Class<?, ?, ?>> getCreatedEObjects() {
		return createdEObjects;
	}

	public void setCreatedEObjects(LinkedList<Class<?, ?, ?>> created) {
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

}
