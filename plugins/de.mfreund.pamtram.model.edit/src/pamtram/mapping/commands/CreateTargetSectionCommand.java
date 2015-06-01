package pamtram.mapping.commands;

import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.metamodel.impl.MetamodelPackageImpl;

public class CreateTargetSectionCommand extends CreateChildCommand {

	public CreateTargetSectionCommand(EditingDomain editingDomain, PAMTraM pamtram) {
		super(editingDomain, 
				pamtram.getTargetSectionModel(),
				PamtramPackage.Literals.SECTION_MODEL__META_MODEL_SECTIONS, 
				MetamodelPackageImpl.eINSTANCE.getEFactoryInstance().create(MetamodelPackageImpl.Literals.TARGET_SECTION_CLASS), 
				null);
	}
}
