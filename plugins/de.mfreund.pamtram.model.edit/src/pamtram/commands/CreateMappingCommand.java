package pamtram.commands;

import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.mapping.impl.MappingPackageImpl;

public class CreateMappingCommand extends CreateChildCommand {

	public CreateMappingCommand(EditingDomain editingDomain, PAMTraM pamtram) {
		super(editingDomain, 
				pamtram.getMappingModels().get(0), //TODO choose mapping model to that the mapping shall be added
				PamtramPackage.Literals.MAPPING_MODEL__MAPPING, 
				MappingPackageImpl.eINSTANCE.getEFactoryInstance().create(MappingPackageImpl.Literals.MAPPING), 
				null);
	}
}
