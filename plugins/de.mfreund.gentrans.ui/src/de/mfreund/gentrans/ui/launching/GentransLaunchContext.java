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
 * A bean to describe all settings necessary to launch a new generic transformation.
 *
 * @author mfreund
 */
class GentransLaunchContext {

	/**
	 * The workspace root that will be used to retrieve possible transformation models.
	 */
	private final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();

	/**
	 * Add basic 'Bean' behavior (cf. http://www.vogella.com/tutorials/EclipseDataBinding/article.html#databinding_pojovsbean).
	 */
	private final PropertyChangeSupport changeSupport =
			new PropertyChangeSupport(this);

	/**
	 * The name of the project that this generic transformation works on.
	 */
	private String project = "";

	/**
	 * Whether the '<em>HistoryResolvingStrategy</em>' shall be applied to resolve ambiguities.
	 */
	private boolean enableHistory = false;

	/**
	 * Whether the '<em>StatisticsResolvingStrategy</em>' shall be applied to resolve ambiguities.
	 */
	private boolean enableStatistics = false;

	/**
	 * The weighting factor (in percent) to be used by the '<em>StatisticsResolvingStrategy</em>' (for statistics that
	 * can applied on the meta-model and on the mapping level).
	 */
	private int weightingFactor = 50;

	/**
	 * Whether the '<em>UserDecisionResolvingStrategy</em>' shall be applied to resolve ambiguities.
	 */
	private boolean enableUser = false;

	/**
	 * Whether a specific transformation model shall be used.
	 */
	private boolean useSpecificTransformationModel = false;

	/**
	 * The name of the transformation to use.
	 */
	private String transformationModelToUse = "";

	/**
	 * Whether the UserDecisionResolvingStratety shall also handle expanding ambiguities.
	 */
	private boolean handleExpandingAmbiguities = false;

	private ArrayList<String> modelsToChooseFrom = new ArrayList<>();

	public void addPropertyChangeListener(PropertyChangeListener
			listener) {
		this.changeSupport.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener
			listener) {
		this.changeSupport.removePropertyChangeListener(listener);
	}

	protected void firePropertyChange(String propertyName, Object oldValue,
			Object newValue) {
		this.changeSupport.firePropertyChange(propertyName, oldValue, newValue);
	}

	/**
	 * @return the project
	 */
	public String getProject() {
		return this.project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(String project) {
		this.firePropertyChange("project", this.project, project);

		// update the list of possible transformation models to choose from based on the changed selection
		ArrayList<String> transformationModels = new ArrayList<>();
		try {
			IResource[] transformationFolders = this.workspaceRoot.getProject(project).getFolder("Pamtram").getFolder("transformation").members();
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
		return this.enableHistory;
	}

	/**
	 * @param enableHistory the enableHistory to set
	 */
	public void setEnableHistory(boolean enableHistory) {
		this.firePropertyChange("enableHistory", this.enableHistory, enableHistory);
		this.enableHistory = enableHistory;
	}

	/**
	 * @return the enableStatistics
	 */
	public boolean isEnableStatistics() {

		return this.enableStatistics;
	}

	/**
	 * @param enableStatistics
	 *            the enableHistory to set
	 */
	public void setEnableStatistics(boolean enableStatistics) {

		this.firePropertyChange("enableStatistics", this.enableStatistics, enableStatistics);
		this.enableStatistics = enableStatistics;
	}

	/**
	 * This is the getter for the {@link #weightingFactor}.
	 *
	 * @return the {@link #weightingFactor}.
	 */
	public int getWeightingFactor() {

		return this.weightingFactor;
	}

	/**
	 * This is the setter for the {@link #weightingFactor}.
	 *
	 * @param weightingFactor
	 *            the {@link #weightingFactor} to set.
	 */
	public void setWeightingFactor(int weightingFactor) {

		this.weightingFactor = weightingFactor;
	}

	/**
	 * @return the enableUser
	 */
	public boolean isEnableUser() {
		return this.enableUser;
	}

	/**
	 * @param enableUser the enableUser to set
	 */
	public void setEnableUser(boolean enableUser) {
		this.firePropertyChange("enableUser", this.enableUser, enableUser);
		this.enableUser = enableUser;
	}

	/**
	 * @return the useSpecificTransformationModel
	 */
	public boolean isUseSpecificTransformationModel() {
		return this.useSpecificTransformationModel;
	}

	/**
	 * @param useSpecificTransformationModel the useSpecificTransformationModel to set
	 */
	public void setUseSpecificTransformationModel(boolean useSpecificTransformationModel) {
		this.firePropertyChange("useSpecificTransformationModel", this.useSpecificTransformationModel, useSpecificTransformationModel);
		if(!useSpecificTransformationModel) {
			// reset the selection of the transformation model to use
			this.setTransformationModelToUse("");
		}
		this.useSpecificTransformationModel = useSpecificTransformationModel;
	}

	/**
	 * @return the transformationModelToUse
	 */
	public String getTransformationModelToUse() {
		return this.transformationModelToUse;
	}

	/**
	 * @param transformationModelToUse the transformationModelToUse to set
	 */
	public void setTransformationModelToUse(String transformationModelToUse) {
		this.firePropertyChange("transformationModelToUse", this.transformationModelToUse, transformationModelToUse);
		this.transformationModelToUse = transformationModelToUse;
	}

	/**
	 * @return the modelsToChooseFrom
	 */
	public ArrayList<String> getModelsToChooseFrom() {
		return this.modelsToChooseFrom;
	}

	/**
	 * @param modelsToChooseFrom the modelsToChooseFrom to set
	 */
	public void setModelsToChooseFrom(ArrayList<String> modelsToChooseFrom) {
		this.firePropertyChange("modelsToChooseFrom", this.modelsToChooseFrom, modelsToChooseFrom);
		this.modelsToChooseFrom = modelsToChooseFrom;
	}

	public boolean isHandleExpandingAmbiguities() {
		return this.handleExpandingAmbiguities;
	}

	public void setHandleExpandingAmbiguities(boolean handleExpandingAmbiguities) {
		this.handleExpandingAmbiguities = handleExpandingAmbiguities;
	}
}