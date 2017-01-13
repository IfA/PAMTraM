package pamtram.commands;

import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.structure.impl.StructurePackageImpl;
import pamtram.structure.source.impl.SourcePackageImpl;

public class CreateSourceSectionCommand extends CreateChildCommand {

	public CreateSourceSectionCommand(EditingDomain editingDomain, PAMTraM pamtram) {
		super(editingDomain, pamtram.getSourceSectionModel().get(0), // TODO choose source section model to that the
																		// source section shall be added
				PamtramPackage.Literals.SECTION_MODEL__META_MODEL_SECTIONS, StructurePackageImpl.eINSTANCE
						.getEFactoryInstance().create(SourcePackageImpl.Literals.SOURCE_SECTION_CLASS),
				null);
	}
}
