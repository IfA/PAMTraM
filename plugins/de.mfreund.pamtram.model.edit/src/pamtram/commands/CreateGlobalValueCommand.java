package pamtram.commands;

import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.mapping.impl.MappingPackageImpl;

public class CreateGlobalValueCommand extends CreateChildCommand {

	public CreateGlobalValueCommand(EditingDomain editingDomain, PAMTraM pamtram) {
		super(editingDomain, 
				pamtram.getMappingModels().get(0), //TODO choose mapping model to that the global value shall be added
				PamtramPackage.Literals.MAPPING_MODEL__GLOBAL_VALUES, 
				MappingPackageImpl.eINSTANCE.getEFactoryInstance().create(MappingPackageImpl.Literals.FIXED_VALUE), 
				null);
	}
}
