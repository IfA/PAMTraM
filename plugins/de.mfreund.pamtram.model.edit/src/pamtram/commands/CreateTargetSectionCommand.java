package pamtram.commands;

import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.structure.impl.MetamodelPackageImpl;

public class CreateTargetSectionCommand extends CreateChildCommand {

	public CreateTargetSectionCommand(EditingDomain editingDomain, PAMTraM pamtram) {
		super(editingDomain, 
				pamtram.getTargetSectionModel().get(0), //TODO choose target section model to that the target section shall be added
				PamtramPackage.Literals.SECTION_MODEL__META_MODEL_SECTIONS, 
				MetamodelPackageImpl.eINSTANCE.getEFactoryInstance().create(MetamodelPackageImpl.Literals.TARGET_SECTION_CLASS), 
				null);
	}
}
