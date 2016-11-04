package pamtram.commands;

import java.io.IOException;
import java.util.Arrays;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.PAMTraM;
import pamtram.SectionModel;
import pamtram.SourceSectionModel;

/**
 * This command can be used to delete a <em>shared</em> Source/TargetSectionModel and its resource.
 *
 * @author mfreund
 *
 */
public class DeleteSharedSectionModelCommand extends CompoundCommand {

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
	 * This creates an instance.
	 *
	 * @param domain
	 *            The {@link EditingDomain} on which to execute the command.
	 * @param owner
	 *            The {@link PAMTraM} model that currently contains the SectionModel.
	 * @param sectionModel
	 *            The {@link SectionModel} to be removed.
	 */
	public DeleteSharedSectionModelCommand(EditingDomain domain, PAMTraM owner, SectionModel<?, ?, ?, ?> sectionModel) {

		super();

		this.sectionModelURI = sectionModel.eResource().getURI();
		this.owner = owner;
		this.sectionModel = sectionModel;

		// As root elements (elements that are directly contained in a resource) cannot be deleted with standard EMF
		// methods. We first convert the element to a local SectionModel and than delete it afterwards. Therefore, we
		// make used of a compound command.
		RemoveCommand removeSharedSectionModelCommand = new RemoveCommand(domain,
				sectionModel instanceof SourceSectionModel ? owner.getSharedSourceSectionModel()
						: owner.getSharedTargetSectionModel(),
						sectionModel);
		AddCommand addLocalSectionModelCommand = new AddCommand(domain, sectionModel instanceof SourceSectionModel
				? owner.getSourceSectionModel() : owner.getTargetSectionModel(), sectionModel);

		DeleteCommand deleteSectionModelCommand = new DeleteCommand(domain, Arrays.asList(sectionModel)) {


			@Override
			public void execute() {

				// As an UnexecutableCommand is returned when preparing the delete command (due to the reasons given
				// above), we need to 're-prepare' the command after the Remove- and AddCommand has been executed and
				// before executing this command. Thus, we clear and refill the list of commands to be executed.
				//
				this.commandList.clear();
				this.commandList.add(RemoveCommand.create(this.domain, this.collection));
				super.execute();
			}
		};

		this.append(removeSharedSectionModelCommand);
		this.append(addLocalSectionModelCommand);
		this.append(deleteSectionModelCommand);
	}

	@Override
	public void execute() {

		super.execute();

		// The resource that contained the SectionModel before undoing the command
		//
		Resource sectionModelResource = this.owner.eResource().getResourceSet().getResource(this.sectionModelURI,
				false);

		if (sectionModelResource == null) {
			super.redo();
			return;
		}

		try {
			// Delete the resource (and thus remove it from the resource set)
			sectionModelResource.delete(null);
		} catch (IOException e) {
			e.printStackTrace();
			this.owner.eResource().getResourceSet().getResources().add(sectionModelResource);
			super.redo();
		}
	}

	@Override
	public void undo() {

		super.undo();

		// Create the new resource and add the section model
		//
		Resource sectionModelResource = this.owner.eResource().getResourceSet().createResource(this.sectionModelURI);
		if (sectionModelResource == null) {
			super.redo();
			return;
		}
		sectionModelResource.getContents().add(this.sectionModel);

		// Save the new (SectionModel) as well as the original (PAMTraM) resource
		//
		try {
			sectionModelResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
			super.redo();
		}

	}

	@Override
	public void redo() {

		super.redo();

		// The resource that contained the SectionModel before undoing the command
		//
		Resource sectionModelResource = this.owner.eResource().getResourceSet().getResource(this.sectionModelURI,
				false);

		if (sectionModelResource == null) {
			super.undo();
			return;
		}

		try {
			// Delete the resource (and thus remove it from the resource set).
			//
			sectionModelResource.delete(null);
		} catch (IOException e) {
			e.printStackTrace();
			this.owner.eResource().getResourceSet().getResources().add(sectionModelResource);
			super.undo();
		}
	}

	@Override
	protected boolean prepare() {

		super.prepare();
		// super.prepare will return false because the created DeleteCommand is unexecutable (see the explanation in the
		// constructor). Thus, we manually return true as we know the command will be executable.
		//
		return true;
	}
}