package pamtram.commands;

import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.structure.impl.StructurePackageImpl;
import pamtram.structure.target.impl.TargetPackageImpl;

public class CreateTargetSectionCommand extends CreateChildCommand {

	public CreateTargetSectionCommand(EditingDomain editingDomain, PAMTraM pamtram) {
		super(editingDomain, pamtram.getTargetSectionModels().get(0), // TODO choose target section model to that the
																		// target section shall be added
				PamtramPackage.Literals.SECTION_MODEL__SECTIONS, StructurePackageImpl.eINSTANCE
						.getEFactoryInstance().create(TargetPackageImpl.Literals.TARGET_SECTION_CLASS),
				null);
	}
}
