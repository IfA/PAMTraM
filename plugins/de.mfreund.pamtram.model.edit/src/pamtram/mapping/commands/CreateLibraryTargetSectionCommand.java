package pamtram.mapping.commands;

import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.metamodel.impl.MetamodelPackageImpl;

public class CreateLibraryTargetSectionCommand extends CreateChildCommand {

	public CreateLibraryTargetSectionCommand(EditingDomain editingDomain, PAMTraM pamtram) {
		super(editingDomain, 
				pamtram.getTargetSectionModel(),
				PamtramPackage.Literals.TARGET_SECTION_MODEL__LIBRARY_ELEMENTS, 
				MetamodelPackageImpl.eINSTANCE.getEFactoryInstance().create(MetamodelPackageImpl.Literals.LIBRARY_ENTRY), 
				null);
	}
}
