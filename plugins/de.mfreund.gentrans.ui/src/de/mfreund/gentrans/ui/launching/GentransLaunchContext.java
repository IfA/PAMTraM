/*******************************************************************************
 * Copyright (C) 2015-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.gentrans.ui.launching;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

import pamtram.provider.PamtramEditPlugin;

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
	 * Add basic 'Bean' behavior (cf.
	 * http://www.vogella.com/tutorials/EclipseDataBinding/article.html#databinding_pojovsbean).
	 */
	private final PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

	/**
	 * The name of the project that this generic transformation works on.
	 */
	private String project = "";

	/**
	 * Whether the '<em>HistoryResolvingStrategy</em>' shall be applied to resolve ambiguities.
	 */
	private boolean enableHistory = false;

	/**
	 * The name of the {@link #enableHistory} property.
	 */
	public static final String PROPERTY_NAME_ENABLE_HISTORY = "enableHistory";

	/**
	 * Whether the '<em>StatisticsResolvingStrategy</em>' shall be applied to resolve ambiguities.
	 */
	private boolean enableStatistics = false;

	/**
	 * The name of the {@link #enableStatistics} property.
	 */
	public static final String PROPERTY_NAME_ENABLE_STATISTICS = "enableStatistics";

	/**
	 * The weighting factor (in percent) to be used by the '<em>StatisticsResolvingStrategy</em>' (for statistics that
	 * can applied on the meta-model and on the mapping level).
	 */
	private int weightingFactor = 50;

	/**
	 * The name of the {@link #weightingFactor} property.
	 */
	public static final String PROPERTY_NAME_WEIGHTING_FACTOR = "weightingFactor";

	/**
	 * Whether the '<em>UserDecisionResolvingStrategy</em>' shall be applied to resolve ambiguities.
	 */
	private boolean enableUser = false;

	/**
	 * The name of the {@link #enableUser} property.
	 */
	public static final String PROPERTY_NAME_ENABLE_USER = "enableUser";

	/**
	 * Whether a specific transformation model shall be used.
	 */
	private boolean useSpecificTransformationModel = false;

	/**
	 * The name of the {@link #useSpecificTransformationModel} property.
	 */
	public static final String PROPERTY_NAME_USE_SPECIFIC_TRANSFORMATION_MODEL = "useSpecificTransformationModel";

	/**
	 * The name of the transformation to use.
	 */
	private String transformationModelToUse = "";

	/**
	 * The name of the {@link #transformationModelToUse} property.
	 */
	public static final String PROPERTY_NAME_TRANSFORMATION_MODEL_TO_USE = "transformationModelToUse";

	/**
	 * Whether the UserDecisionResolvingStratety shall also handle expanding ambiguities.
	 */
	private boolean handleExpandingAmbiguities = false;

	/**
	 * The name of the {@link #handleExpandingAmbiguities} property.
	 */
	public static final String PROPERTY_NAME_HANDLE_EXPANDING_AMBIGUITIES = "handleExpandingAmbiguities";

	/**
	 * The list of transformation models that the user can choose from.
	 */
	private List<String> modelsToChooseFrom = new ArrayList<>();

	/**
	 * The name of the {@link #modelsToChooseFrom} property.
	 */
	public static final String PROPERTY_NAME_MODELS_TO_CHOOSE_FROM = "modelsToChooseFrom";

	/**
	 * The list of paths to the libraries to be used in the transformation.
	 */
	private List<String> libraryPaths;

	/**
	 * The name of the {@link #libraryPaths} property.
	 */
	public static final String PROPERTY_NAME_LIBRARY_PATHS = "libraryPaths";

	public void addPropertyChangeListener(PropertyChangeListener listener) {

		this.changeSupport.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {

		this.changeSupport.removePropertyChangeListener(listener);
	}

	protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {

		this.changeSupport.firePropertyChange(propertyName, oldValue, newValue);
	}

	/**
	 * @return the project
	 */
	public String getProject() {

		return this.project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(String project) {

		this.firePropertyChange("project", this.project, project);

		// update the list of possible transformation models to choose from based on the changed selection
		ArrayList<String> transformationModels = new ArrayList<>();
		try {
			IResource[] transformationFolders = this.workspaceRoot.getProject(project)
					.getFolder(PamtramEditPlugin.INSTANCE.getString("PAMTRAM_FOLDER_NAME")).getFolder("transformation")
					.members();
			for (IResource iResource : transformationFolders) {
				if (iResource instanceof IFolder
						&& ((IFolder) iResource).getFile(iResource.getName() + ".transformation").exists()) {
					transformationModels.add(iResource.getName());
				}
			}
		} catch (CoreException e) {
			// we simply do nothing
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
	 * @param enableHistory
	 *            the enableHistory to set
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
	 * @param enableUser
	 *            the enableUser to set
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
	 * @param useSpecificTransformationModel
	 *            the useSpecificTransformationModel to set
	 */
	public void setUseSpecificTransformationModel(boolean useSpecificTransformationModel) {

		this.firePropertyChange("useSpecificTransformationModel", this.useSpecificTransformationModel,
				useSpecificTransformationModel);
		if (!useSpecificTransformationModel) {
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
	 * @param transformationModelToUse
	 *            the transformationModelToUse to set
	 */
	public void setTransformationModelToUse(String transformationModelToUse) {

		this.firePropertyChange("transformationModelToUse", this.transformationModelToUse, transformationModelToUse);
		this.transformationModelToUse = transformationModelToUse;
	}

	/**
	 * @return the modelsToChooseFrom
	 */
	public List<String> getModelsToChooseFrom() {

		return this.modelsToChooseFrom;
	}

	/**
	 * @param modelsToChooseFrom
	 *            the modelsToChooseFrom to set
	 */
	public void setModelsToChooseFrom(List<String> modelsToChooseFrom) {

		this.firePropertyChange("modelsToChooseFrom", this.modelsToChooseFrom, modelsToChooseFrom);
		this.modelsToChooseFrom = modelsToChooseFrom;
	}

	/**
	 * This is the getter for the {@link #handleExpandingAmbiguities}.
	 *
	 * @return the {@link #handleExpandingAmbiguities}.
	 */
	public boolean isHandleExpandingAmbiguities() {

		return this.handleExpandingAmbiguities;
	}

	/**
	 * This is the setter for the {@link #handleExpandingAmbiguities}.
	 *
	 * @param handleExpandingAmbiguities
	 *            the {@link #handleExpandingAmbiguities} to set.
	 */
	public void setHandleExpandingAmbiguities(boolean handleExpandingAmbiguities) {

		this.handleExpandingAmbiguities = handleExpandingAmbiguities;
	}

	/**
	 * This is the getter for the {@link #libraryPaths}.
	 *
	 * @return the {@link #libraryPaths}.
	 */
	public List<String> getLibraryPaths() {

		return this.libraryPaths;
	}

	/**
	 * This is the setter for the {@link #libraryPaths}.
	 *
	 * @param libraryPaths
	 *            the {@link #libraryPaths} to set.
	 */
	public void setLibraryPaths(List<String> libraryPaths) {

		this.libraryPaths = libraryPaths;
	}

}
