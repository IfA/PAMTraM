package de.mfreund.pamtram.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Shell;

import de.mfreund.pamtram.pages.SharedSectionModelSelectionPage;
import de.tud.et.ifa.agtele.ui.util.UIHelper;
import pamtram.PAMTraM;
import pamtram.SectionModel;
import pamtram.util.SharedModelUtil;
import pamtram.util.SharedModelUtil.SharedModelType;

/**
 * This {@link AbstractImportElementWizard} allows to a shared
 * {@link SectionModel} into a pamtram model.
 *
 * @author mfreund
 */
public class ImportSharedModelWizard extends AbstractImportElementWizard {

	private final SharedSectionModelSelectionPage one;

	/**
	 * The {@link SharedModelType} of SectionModel(s) to be imported.
	 */
	private SharedModelType type;

	/**
	 * This constructs an instance of the wizard.
	 *
	 * @param pamtram
	 *            The {@link PAMTraM} instance into that the library elements
	 *            shall be imported.
	 * @param editingDomain
	 *            The editing domain to be used to perform model changes.
	 * @param viewer
	 *            The {@link Viewer} where the imported elements will be shown
	 *            and selected.
	 * @param type
	 *            The {@link SharedModelType} of SectionModel(s) to be imported.
	 */
	public ImportSharedModelWizard(PAMTraM pamtram, EditingDomain editingDomain, Viewer viewer, SharedModelType type) {
		super(pamtram, editingDomain, viewer);

		this.type = type;
		this.one = new SharedSectionModelSelectionPage("Select Shared Model", "Select a shared model to be imported",
				SharedModelUtil.getFileEndingBySharedModelType(type), false);
	}

	@Override
	public void addPages() {

		this.addPage(this.one);
	}

	/**
	 * Show an error to the user by opening a {@link MessageDialog}.
	 *
	 * @param errorMessage
	 *            The message to display to the user.
	 */
	protected void showError(String errorMessage) {

		Shell shell = UIHelper.getShell();
		MessageDialog.openError(shell, "ERROR", errorMessage);
	}

	@Override
	protected void createImportElementsCommand() {

		IFile sharedModelFile = this.one.getSingleSelection();

		// Load the resource containing the SectionModel to be imported
		//
		EObject sharedModel;
		try {

			URI sharedModelURI = URI.createPlatformResourceURI(sharedModelFile.getFullPath().toString(), true);
			Resource sharednModelResource = this.pamtram.eResource().getResourceSet().getResource(sharedModelURI, true);

			EObject content = sharednModelResource.getContents().get(0);

			if (!SharedModelUtil.isValidSubModelContent(this.type, content)) {
				this.showError("The selected file does not contain a valid shared model!");
				return;
			}

			sharedModel = content;

		} catch (Exception e) {
			this.showError("Error while loading the resource containing the shared model!");
			return;
		}

		EList<?> list = null;
		if (this.type.equals(SharedModelType.SOURCE)) {
			list = this.pamtram.getSharedSourceSectionModels();
		} else if (this.type.equals(SharedModelType.TARGET)) {
			list = this.pamtram.getSharedTargetSectionModels();
		} else if (this.type.equals(SharedModelType.MAPPING)) {
			list = this.pamtram.getSharedMappingModels();
		} else if (this.type.equals(SharedModelType.CONDITION)) {
			list = this.pamtram.getSharedConditionModels();
		}

		this.importCommand = new AddCommand(this.editingDomain, list, sharedModel);
	}

}
