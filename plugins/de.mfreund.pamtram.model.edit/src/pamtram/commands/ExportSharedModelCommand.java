package pamtram.commands;

import java.io.IOException;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.ConditionModel;
import pamtram.MappingModel;
import pamtram.PAMTraM;
import pamtram.SourceSectionModel;
import pamtram.TargetSectionModel;

/**
 * This command can be used to export a <em>local</em> {@link SourceSectionModel}, {@link TargetSectionModel},
 * {@link MappingModel}, or {@link ConditionModel} to its own resource and reference it as <em>shared</em> SectionModel
 * instead.
 *
 * @author mfreund
 *
 */
public class ExportSharedModelCommand extends CompoundCommand {

	/**
	 * The {@link PAMTraM} model that contains the {@link #sharedModelRoot} before the export is executed.
	 */
	private PAMTraM owner;

	/**
	 * This is the {@link URI} that shall be used to store {@link #sharedModelRoot}.
	 */
	private URI sharedModelURI;

	/**
	 * The element to be exported into a shared model.
	 */
	private EObject sharedModelRoot;

	/**
	 * This creates an instance.
	 *
	 * @param domain
	 *            The {@link EditingDomain} on which to execute the command.
	 * @param owner
	 *            The {@link PAMTraM} model that currently contains the SectionModel.
	 * @param sharedModelRoot
	 *            The element to be exported into a shared model.
	 * @param sharedModelURI
	 *            The {@link URI} that shall be used to store shared model.
	 */
	public ExportSharedModelCommand(EditingDomain domain, PAMTraM owner, EObject sharedModelRoot, URI sharedModelURI) {
		super();
		this.owner = owner;
		this.sharedModelURI = sharedModelURI;
		this.sharedModelRoot = sharedModelRoot;

		EList<?> list = null;
		EList<?> sharedList = null;
		if (sharedModelRoot instanceof SourceSectionModel) {
			list = owner.getSourceSectionModels();
			sharedList = owner.getSharedSourceSectionModels();
		} else if (sharedModelRoot instanceof TargetSectionModel) {
			list = owner.getTargetSectionModels();
			sharedList = owner.getSharedTargetSectionModels();
		} else if (sharedModelRoot instanceof MappingModel) {
			list = owner.getMappingModels();
			sharedList = owner.getSharedMappingModels();
		} else if (sharedModelRoot instanceof ConditionModel) {
			list = owner.getConditionModels();
			sharedList = owner.getSharedConditionModels();
		}

		RemoveCommand removeLocalSectionModelCommand = new RemoveCommand(domain, list, sharedModelRoot);
		AddCommand addSharedSectionModelCommand = new AddCommand(domain, sharedList, sharedModelRoot);

		this.append(removeLocalSectionModelCommand);
		this.append(addSharedSectionModelCommand);
	}

	@Override
	public void execute() {

		super.execute();

		// Create the new resource and add the shared model
		//
		Resource sharedModelResource = this.owner.eResource().getResourceSet().createResource(this.sharedModelURI);
		sharedModelResource.getContents().add(this.sharedModelRoot);

		// Save the new SectionModel resource
		//
		try {
			sharedModelResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
			super.undo();
		}
	}

	@Override
	public void undo() {

		// First, default undo the command.
		super.undo();

		// The resource that contained the shared model before undoing the command
		//
		Resource sharedModelResource = this.owner.eResource().getResourceSet().getResource(this.sharedModelURI, false);

		if (sharedModelResource == null) {
			super.redo();
			return;
		}

		try {
			// Delete the resource (and thus remove it from the resource set). If we delete the resource directly, the
			// editor mysteriously crashes. This can be prevented by first adding the resource to a new resource set
			// (and therewith removing it from the original resource set).
			//
			new ResourceSetImpl().getResources().add(sharedModelResource);
			sharedModelResource.delete(null);
		} catch (IOException e) {
			e.printStackTrace();
			this.owner.eResource().getResourceSet().getResources().add(sharedModelResource);
			super.redo();
		}

	}

	@Override
	public void redo() {

		super.redo();

		// Create the new resource and add the section model
		//
		Resource sharedModelResource = this.owner.eResource().getResourceSet().createResource(this.sharedModelURI);
		if (sharedModelResource == null) {
			super.undo();
			return;
		}
		sharedModelResource.getContents().add(this.sharedModelRoot);

		// Save the new (SectionModel) as well as the original (PAMTraM) resource
		//
		try {
			sharedModelResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
			super.undo();
		}
	}
}