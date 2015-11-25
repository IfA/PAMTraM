package de.mfreund.gentrans.ui.launching;

/**
 * A POJO to describe all settings necessary to launch a new generic transformation.
 * 
 * @author mfreund
 */
class GentransLaunchContext {

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
		System.out.println(useSpecificTransformationModel);
		if(!useSpecificTransformationModel) {
			// reset the selection of the transformation model to use
			setTransformationModelToUse("test");
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
		System.out.println(transformationModelToUse);
		this.transformationModelToUse = transformationModelToUse;
	}
}