package de.mfreund.pamtram.model.generator;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import de.mfreund.epsilon.EolExecutor;

public class WizardData {

	private Resource targetModelResource;
	private IPath sourceModelPath;
	private EolExecutor eolExecutor;
	private String bundleId = "de.mfreund.pamtram.model.generator";
	private SectionType sectionType;
	private EPackage ePackage;
	private EObject eObject;
	private pamtram.metamodel.Class[] createdEObjects;

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

	public pamtram.metamodel.Class[] getCreatedEObjects() {
		return createdEObjects;
	}

	public void setCreatedEObjects(pamtram.metamodel.Class[] created) {
		this.createdEObjects = created;
	}

}
