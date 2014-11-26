package pamtram.mapping.commands;

import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.mapping.impl.MappingPackageImpl;

public class CreateGlobalValueCommand extends CreateChildCommand {

	public CreateGlobalValueCommand(EditingDomain editingDomain, PAMTraM pamtram) {
		super(editingDomain, 
				pamtram.getMappingModel(),
				PamtramPackage.Literals.MAPPING_MODEL__GLOBAL_VALUES, 
				MappingPackageImpl.eINSTANCE.getEFactoryInstance().create(MappingPackageImpl.Literals.GLOBAL_VALUE), 
				null);
	}
}
