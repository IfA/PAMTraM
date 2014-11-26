package pamtram.mapping.commands;

import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.metamodel.impl.MetamodelPackageImpl;

public class CreateSourceSectionCommand extends CreateChildCommand {

	public CreateSourceSectionCommand(EditingDomain editingDomain, PAMTraM pamtram) {
		super(editingDomain, 
				pamtram.getSourceSectionModel(), 
				PamtramPackage.Literals.SOURCE_SECTION_MODEL__META_MODEL_SECTIONS, 
				MetamodelPackageImpl.eINSTANCE.getEFactoryInstance().create(MetamodelPackageImpl.Literals.SOURCE_SECTION_CLASS), 
				null);
	}
}
