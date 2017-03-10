package pamtram.commands;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.ConditionModel;
import pamtram.MappingModel;
import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.SourceSectionModel;
import pamtram.TargetSectionModel;

/**
 * This command can be used to create a <em>shared</em> {@link SourceSectionModel}, {@link TargetSectionModel},
 * {@link MappingModel}, or {@link ConditionModel} and persist it in its own resource.
 *
 * @author mfreund
 *
 */
public class CreateSharedModelCommand extends CreateChildCommand {

	/**
	 * This is the {@link URI} that shall be used to store the {@link #sharedModelRoot}.
	 */
	private URI modelURI;

	/**
	 * The element to be exported into a shared model. This needs to be one of {@link SourceSectionModel},
	 * {@link TargetSectionModel}, {@link MappingModel}, or {@link ConditionModel}.
	 */
	private EObject sharedModelRoot;

	/**
	 * The {@link AddCommand} that we use internally to add the {@link #sharedModelRoot} as <em>shared model</em> in the
	 * {@link PAMTraM} instance.
	 * <p />
	 * We do not execute the {@link CreateChildCommand} directly as undoing it (and deleting the created resource as
	 * part of this process) leads to errors in the editor that I have no idea how to solve.
	 */
	private AddCommand addSharedModelCommand;

	private CreateSharedModelCommand(EditingDomain domain, PAMTraM owner, EStructuralFeature feature,
			EObject sharedModelRoot, Collection<?> selection, CreateChildCommand.Helper helper) {

		super(domain, owner, feature, sharedModelRoot, selection, helper);

		this.sharedModelRoot = sharedModelRoot;

		this.addSharedModelCommand = new AddCommand(domain, (EList<?>) owner.eGet(feature), sharedModelRoot);
	}

	/**
	 * This creates an instance.
	 *
	 * @param domain
	 *            The {@link EditingDomain} on which to execute the command.
	 * @param owner
	 *            The {@link PAMTraM} model that currently contains the SectionModel.
	 * @param sharedModelRoot
	 *            The element to be exported into a shared model. This needs to be one of {@link SourceSectionModel},
	 *            {@link TargetSectionModel}, {@link MappingModel}, or {@link ConditionModel}.
	 * @param selection
	 *            The list of selected objects.
	 * @param helper
	 *            The {@link org.eclipse.emf.edit.command.CreateChildCommand.Helper} to be used.
	 * @return The created {@link CreateSharedModelCommand} or an {@link UnexecutableCommand} if the given
	 *         '<em>sharedModelRoot</em>' was none of {@link SourceSectionModel}, {@link TargetSectionModel},
	 *         {@link MappingModel}, or {@link ConditionModel}.
	 */
	public static AbstractCommand createCreateSharedModelCommand(EditingDomain domain, PAMTraM owner,
			EObject sharedModelRoot, Collection<?> selection, CreateChildCommand.Helper helper) {

		EStructuralFeature feature;
		if (sharedModelRoot instanceof SourceSectionModel) {
			feature = PamtramPackage.Literals.PAM_TRA_M__SHARED_SOURCE_SECTION_MODELS;
		} else if (sharedModelRoot instanceof TargetSectionModel) {
			feature = PamtramPackage.Literals.PAM_TRA_M__SHARED_TARGET_SECTION_MODELS;
		} else if (sharedModelRoot instanceof MappingModel) {
			feature = PamtramPackage.Literals.PAM_TRA_M__SHARED_MAPPING_MODELS;
		} else if (sharedModelRoot instanceof ConditionModel) {
			feature = PamtramPackage.Literals.PAM_TRA_M__SHARED_CONDITION_MODELS;
		} else {
			return UnexecutableCommand.INSTANCE;
		}

		return new CreateSharedModelCommand(domain, owner, feature, sharedModelRoot, selection, helper);
	}

	/**
	 * Set the {@link URI} that shall be used to store the {@link #sharedModelRoot}.
	 * <p />
	 * Note: This needs to be called once with a valid URI before the command is executed.
	 *
	 * @param modelURI
	 *            The {@link URI} that shall be used to store the {@link #sharedModelRoot}.
	 */
	public void setModelURI(URI modelURI) {

		this.modelURI = modelURI;
	}

	@Override
	public void execute() {

		if (this.modelURI == null) {
			return;
		}

		this.addSharedModelCommand.execute();

		// Create the new resource and add the shared model
		//
		Resource sharedModelResource = this.owner.eResource().getResourceSet().createResource(this.modelURI);
		sharedModelResource.getContents().add(this.sharedModelRoot);

		// Save the new resource
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
		this.addSharedModelCommand.undo();

		// The resource that contained the shared model before undoing the command
		//
		Resource sharedModelResource = this.owner.eResource().getResourceSet().getResource(this.modelURI, false);

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

		if (this.modelURI == null) {
			return;
		}

		this.addSharedModelCommand.redo();

		// Create the new resource and add the shared model
		//
		Resource sharedModelResource = this.owner.eResource().getResourceSet().createResource(this.modelURI);
		if (sharedModelResource == null) {
			super.undo();
			return;
		}
		sharedModelResource.getContents().add(this.sharedModelRoot);

		// Save the new (shared model) as well as the original (PAMTraM) resource
		//
		try {
			sharedModelResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
			super.undo();
		}
	}
}