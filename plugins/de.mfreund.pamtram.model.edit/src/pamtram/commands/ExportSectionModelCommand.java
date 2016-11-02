package pamtram.commands;

import java.io.IOException;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.PAMTraM;
import pamtram.SectionModel;
import pamtram.SourceSectionModel;

/**
 * This command can be used to export a <em>local</em> Source/TargetSectionModel to its own resource and reference it as
 * <em>shared</em> SectionModel instead.
 *
 * @author mfreund
 *
 */
public class ExportSectionModelCommand extends CompoundCommand {

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
	 *            The {@link SectionModel} to be exported.
	 * @param sectionModelURI
	 *            The {@link URI} that shall be used to store {@link SectionModel}.
	 */
	public ExportSectionModelCommand(EditingDomain domain, PAMTraM owner,
			SectionModel<?, ?, ?, ?> sectionModel, URI sectionModelURI) {
		super();
		this.owner = owner;
		this.sectionModelURI = sectionModelURI;
		this.sectionModel = sectionModel;

		RemoveCommand removeLocalSectionModelCommand = new RemoveCommand(domain,
				sectionModel instanceof SourceSectionModel ? owner.getSourceSectionModel()
						: owner.getTargetSectionModel(),
						sectionModel);
		AddCommand addSharedSectionModelCommand = new AddCommand(domain, sectionModel instanceof SourceSectionModel
				? owner.getSharedSourceSectionModel() : owner.getSharedTargetSectionModel(), sectionModel);

		this.append(removeLocalSectionModelCommand);
		this.append(addSharedSectionModelCommand);
	}

	@Override
	public void execute() {

		super.execute();

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
		super.undo();

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

		super.redo();

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