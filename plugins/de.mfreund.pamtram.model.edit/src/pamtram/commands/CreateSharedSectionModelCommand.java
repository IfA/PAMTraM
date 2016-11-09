package pamtram.commands;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.SectionModel;
import pamtram.SourceSectionModel;

/**
 * This command can be used to create a <em>shared</em> Source/TargetSectionModel and persist it in its own resource.
 *
 * @author mfreund
 *
 */
public class CreateSharedSectionModelCommand extends CreateChildCommand {

	/**
	 * The {@link PAMTraM} model that contains the SectionModel before the export is executed.
	 */
	private PAMTraM owner;

	/**
	 * This is the {@link URI} that shall be used to store {@link SectionModel}.
	 */
	private URI sectionModelURI;

	/**
	 * The {@link SectionModel} to be exported.
	 */
	private SectionModel<?, ?, ?, ?> sectionModel;

	/**
	 * The {@link AddCommand} that we use internally to add the {@link #sectionModel} as <em>shared section model</em>.
	 * <p />
	 * We do not execute the {@link CreateChildCommand} directly as undoing it (and deleting the created resource as
	 * part of this process) leads to errors in the editor that I have no idea how to solve.
	 */
	private AddCommand addSharedSectionModelCommand;

	/**
	 * This creates an instance.
	 *
	 * @param domain
	 *            The {@link EditingDomain} on which to execute the command.
	 * @param owner
	 *            The {@link PAMTraM} model that currently contains the SectionModel.
	 * @param sectionModel
	 *            The {@link SectionModel} to be exported.
	 * @param selection
	 *            The list of selected objects.
	 * @param helper
	 *            The {@link org.eclipse.emf.edit.command.CreateChildCommand.Helper} to be used.
	 */
	public CreateSharedSectionModelCommand(EditingDomain domain, PAMTraM owner,
			SectionModel<?, ?, ?, ?> sectionModel, Collection<?> selection,
			CreateChildCommand.Helper helper) {
		super(domain, owner,
				sectionModel instanceof SourceSectionModel
				? PamtramPackage.Literals.PAM_TRA_M__SHARED_SOURCE_SECTION_MODEL
						: PamtramPackage.Literals.PAM_TRA_M__SHARED_TARGET_SECTION_MODEL,
						sectionModel, selection, helper);
		this.owner = owner;
		this.sectionModel = sectionModel;

		this.addSharedSectionModelCommand = new AddCommand(domain, sectionModel instanceof SourceSectionModel
				? owner.getSharedSourceSectionModel() : owner.getSharedTargetSectionModel(), sectionModel);

	}

	/**
	 * Set the {@link URI} that shall be used to store the {@link SectionModel}.
	 * <p />
	 * Note: This needs to be called once with a valid URI before the command is executed.
	 *
	 * @param sectionModelURI
	 *            The {@link URI} that shall be used to store {@link SectionModel}.
	 */
	public void setSectionModelURI(URI sectionModelURI) {

		this.sectionModelURI = sectionModelURI;
	}

	@Override
	public void execute() {

		if (this.sectionModelURI == null) {
			return;
		}

		this.addSharedSectionModelCommand.execute();

		// Create the new resource and add the section model
		//
		Resource sectionModelResource = this.owner.eResource().getResourceSet().createResource(this.sectionModelURI);
		sectionModelResource.getContents().add(this.sectionModel);

		// Save the new SectionModel resource
		//
		try {
			sectionModelResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
			super.undo();
		}
	}

	@Override
	public void undo() {

		// First, default undo the command.
		this.addSharedSectionModelCommand.undo();

		// The resource that contained the SectionModel before undoing the command
		//
		Resource sectionModelResource = this.owner.eResource().getResourceSet().getResource(this.sectionModelURI,
				false);

		if (sectionModelResource == null) {
			super.redo();
			return;
		}

		try {
			// Delete the resource (and thus remove it from the resource set). If we delete the resource directly, the
			// editor mysteriously crashes. This can be prevented by first adding the resource to a new resource set
			// (and therewith removing it from the original resource set).
			//
			new ResourceSetImpl().getResources().add(sectionModelResource);
			sectionModelResource.delete(null);
		} catch (IOException e) {
			e.printStackTrace();
			this.owner.eResource().getResourceSet().getResources().add(sectionModelResource);
			super.redo();
		}

	}

	@Override
	public void redo() {

		if (this.sectionModelURI == null) {
			return;
		}

		this.addSharedSectionModelCommand.redo();

		// Create the new resource and add the section model
		//
		Resource sectionModelResource = this.owner.eResource().getResourceSet().createResource(this.sectionModelURI);
		if (sectionModelResource == null) {
			super.undo();
			return;
		}
		sectionModelResource.getContents().add(this.sectionModel);

		// Save the new (SectionModel) as well as the original (PAMTraM) resource
		//
		try {
			sectionModelResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
			super.undo();
		}
	}
}