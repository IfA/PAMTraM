package de.mfreund.pamtram.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;

import de.mfreund.pamtram.pages.SharedSectionModelSelectionPage;
import de.tud.et.ifa.agtele.ui.util.UIHelper;
import pamtram.PAMTraM;
import pamtram.SectionModel;
import pamtram.SourceSectionModel;
import pamtram.TargetSectionModel;

/**
 * This wizard allows to import one or multiple library elements from a
 * library (represented by a Zip file) into a pamtram model.
 *
 * @author mfreund
 */
public class ImportSharedSectionModelWizard extends Wizard {

	private final SharedSectionModelSelectionPage one;

	/**
	 * This is the pamtram instance into that the library elements shall be
	 * imported.
	 */
	private final PAMTraM pamtram;

	/**
	 * This is the editing domain to be used to perform model changes.
	 */
	private final EditingDomain editingDomain;

	/**
	 * The {@link SectionModelType} of SectionModel(s) to be imported.
	 */
	private SectionModelType type;

	/**
	 * This constructs an instance of the wizard.
	 *
	 * @param pamtram
	 *            The {@link PAMTraM} instance into that the library elements shall be imported.
	 * @param editingDomain
	 *            The editing domain to be used to perform model changes.
	 * @param type
	 *            The {@link SectionModelType} of SectionModel(s) to be imported.
	 */
	public ImportSharedSectionModelWizard(PAMTraM pamtram, EditingDomain editingDomain, SectionModelType type) {
		super();
		this.setNeedsProgressMonitor(true);
		this.pamtram = pamtram;
		this.editingDomain = editingDomain;
		this.type = type;
		this.one = new SharedSectionModelSelectionPage("Select Shared SectionModel",
				"Select a shared SectionModel to be imported",
				type.equals(SectionModelType.SOURCE) ? ".pamtram.source" : ".pamtram.target", false);
	}

	@Override
	public void addPages() {
		this.addPage(this.one);
	}

	@Override
	public boolean performFinish() {

		IFile sectionModelFile = this.one.getSingleSelection();

		// Load the resource containing the SectionModel to be imported
		//
		SectionModel<?, ?, ?, ?> sectionModel;
		try {

			URI sectionModelURI = URI.createPlatformResourceURI(sectionModelFile.getFullPath().toString(), true);
			Resource sectionModelResource = this.pamtram.eResource().getResourceSet().getResource(sectionModelURI,
					true);

			EObject content = sectionModelResource.getContents().get(0);

			if (this.type.equals(SectionModelType.SOURCE) && !(content instanceof SourceSectionModel)
					|| this.type.equals(SectionModelType.TARGET) && !(content instanceof TargetSectionModel)) {
				this.showError("The selected file does not contain a "
						+ (this.type.equals(SectionModelType.SOURCE) ? "SourceSectionModel" : "TargetSectionModel")
						+ "!");
				return false;
			}

			sectionModel = (SectionModel<?, ?, ?, ?>) content;

		} catch (Exception e) {
			this.showError("Error while loading the resource containing the SharedSection model!");
			return false;
		}

		if (this.type.equals(SectionModelType.SOURCE)
				&& this.pamtram.getSharedSourceSectionModel().contains(sectionModel)
				|| this.type.equals(SectionModelType.TARGET)
				&& this.pamtram.getSharedTargetSectionModel().contains(sectionModel)) {
			this.showError("The PAMTraM model already contains this shared SectionModel!");
			return false;
		}

		AddCommand addCommand = new AddCommand(
				this.editingDomain, this.type.equals(SectionModelType.SOURCE)
				? this.pamtram.getSharedSourceSectionModel() : this.pamtram.getSharedTargetSectionModel(),
						sectionModel);

		// Execute the command to import the section model
		//
		this.editingDomain.getCommandStack().execute(addCommand);

		return true;
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

	/**
	 * An enum representing the types of SectionModels that can be imported.
	 *
	 * @author mfreund
	 */
	public enum SectionModelType {
		SOURCE, TARGET;
	}
}
