package pamtram.mapping.commands;

import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.mapping.impl.MappingPackageImpl;

public class CreateAttValModifierSetCommand extends CreateChildCommand {

	public CreateAttValModifierSetCommand(EditingDomain editingDomain, PAMTraM pamtram) {
		super(editingDomain, 
				pamtram.getMappingModel(),
				PamtramPackage.Literals.MAPPING_MODEL__MODIFIER_SETS, 
				MappingPackageImpl.eINSTANCE.getEFactoryInstance().create(MappingPackageImpl.Literals.ATTRIBUTE_VALUE_MODIFIER_SET), 
				null);
	}
}
