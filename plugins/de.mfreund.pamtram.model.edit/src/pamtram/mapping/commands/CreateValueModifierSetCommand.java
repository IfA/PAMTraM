package pamtram.mapping.commands;

import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.impl.MappingPackageImpl;

public class CreateValueModifierSetCommand extends CreateChildCommand {

	public CreateValueModifierSetCommand(EditingDomain editingDomain, PAMTraM pamtram) {
		super(editingDomain,
				pamtram.getMappingModel().get(0), //TODO choose mapping model to that the modifier set shall be added
				PamtramPackage.Literals.MAPPING_MODEL__MODIFIER_SETS,
				MappingPackage.eINSTANCE.getEFactoryInstance().create(MappingPackageImpl.Literals.VALUE_MODIFIER_SET),
				null);
	}
}
