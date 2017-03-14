package pamtram.commands;

import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.structure.impl.StructurePackageImpl;
import pamtram.structure.library.impl.LibraryPackageImpl;

public class CreateLibraryTargetSectionCommand extends CreateChildCommand {

	public CreateLibraryTargetSectionCommand(EditingDomain editingDomain, PAMTraM pamtram) {
		super(editingDomain, pamtram.getTargetSectionModels().get(0), // TODO choose target section model to that the
																		// library section shall be added
				PamtramPackage.Literals.TARGET_SECTION_MODEL__LIBRARY_ELEMENTS,
				StructurePackageImpl.eINSTANCE.getEFactoryInstance().create(LibraryPackageImpl.Literals.LIBRARY_ENTRY),
				null);
	}
}
