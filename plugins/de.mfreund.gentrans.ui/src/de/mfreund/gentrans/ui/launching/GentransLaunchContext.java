package de.mfreund.gentrans.ui.launching;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

/**
 * A POJO to describe all settings necessary to launch a new generic transformation.
 * 
 * @author mfreund
 */
class GentransLaunchContext {

	// the workspace root
	private final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();

	private final PropertyChangeSupport changeSupport = 
			new PropertyChangeSupport(this);

	public void addPropertyChangeListener(PropertyChangeListener 
			listener) {
		changeSupport.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener 
			listener) {
		changeSupport.removePropertyChangeListener(listener);
	}

	protected void firePropertyChange(String propertyName, Object oldValue,
			Object newValue) {
		changeSupport.firePropertyChange(propertyName, oldValue, newValue);
	}

	/**
	 * The name of the project that this generic transformation works on.
	 */
	private String project = "";

	/**
	 * Whether the '<em>HistoryResolvingStrategy</em>' shall be applied to resolve ambiguites.
	 */
	private boolean enableHistory = false;

	/**
	 * Whether the '<em>UserDecisionResolvingStrategy</em>' shall be applied to resolve ambiguities.
	 */
	private boolean enableUser = true;

	/**
	 * Whether a specific transformation model shall be used.
	 */
	private boolean useSpecificTransformationModel = false;

	/**
	 * The name of the transformation to use.
	 */
	private String transformationModelToUse = "";

	private ArrayList<String> modelsToChooseFrom = new ArrayList<>();

	/**
	 * @return the project
	 */
	public String getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(String project) {
		firePropertyChange("project", this.project, project);
		ArrayList<String> transformationModels = new ArrayList<>();
		try {
			IResource[] transformationFolders = workspaceRoot.getProject(project).getFolder("Pamtram").getFolder("transformation").members();
			for (IResource iResource : transformationFolders) {
				if(iResource instanceof IFolder && ((IFolder) iResource).getFile(iResource.getName() + ".transformation").exists()) {
					transformationModels.add(iResource.getName());
				}
			}
		} catch (CoreException e) {
		}
		this.setModelsToChooseFrom(transformationModels);
		this.project = project;
	}

	/**
	 * @return the enableHistory
	 */
	public boolean isEnableHistory() {
		return enableHistory;
	}

	/**
	 * @param enableHistory the enableHistory to set
	 */
	public void setEnableHistory(boolean enableHistory) {
		firePropertyChange("enableHistory", this.enableHistory, enableHistory);
		this.enableHistory = enableHistory;
	}

	/**
	 * @return the enableUser
	 */
	public boolean isEnableUser() {
		return enableUser;
	}

	/**
	 * @param enableUser the enableUser to set
	 */
	public void setEnableUser(boolean enableUser) {
		firePropertyChange("enableUser", this.enableUser, enableUser);
		this.enableUser = enableUser;
	}

	/**
	 * @return the useSpecificTransformationModel
	 */
	public boolean isUseSpecificTransformationModel() {
		return useSpecificTransformationModel;
	}

	/**
	 * @param useSpecificTransformationModel the useSpecificTransformationModel to set
	 */
	public void setUseSpecificTransformationModel(boolean useSpecificTransformationModel) {
		firePropertyChange("useSpecificTransformationModel", this.useSpecificTransformationModel, useSpecificTransformationModel);
		if(!useSpecificTransformationModel) {
			// reset the selection of the transformation model to use
			setTransformationModelToUse("");
		}
		this.useSpecificTransformationModel = useSpecificTransformationModel;
	}

	/**
	 * @return the transformationModelToUse
	 */
	public String getTransformationModelToUse() {
		return transformationModelToUse;
	}

	/**
	 * @param transformationModelToUse the transformationModelToUse to set
	 */
	public void setTransformationModelToUse(String transformationModelToUse) {
		firePropertyChange("transformationModelToUse", this.transformationModelToUse, transformationModelToUse);
		this.transformationModelToUse = transformationModelToUse;
	}

	/**
	 * @return the modelsToChooseFrom
	 */
	public ArrayList<String> getModelsToChooseFrom() {
		return modelsToChooseFrom;
	}

	/**
	 * @param modelsToChooseFrom the modelsToChooseFrom to set
	 */
	public void setModelsToChooseFrom(ArrayList<String> modelsToChooseFrom) {
		firePropertyChange("modelsToChooseFrom", this.modelsToChooseFrom, modelsToChooseFrom);
		this.modelsToChooseFrom = modelsToChooseFrom;
	}
}