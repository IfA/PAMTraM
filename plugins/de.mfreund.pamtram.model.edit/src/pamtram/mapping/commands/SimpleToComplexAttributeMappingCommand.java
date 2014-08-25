package pamtram.mapping.commands;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.StrictCompoundCommand;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.mapping.ComplexAttributeMapping;
import pamtram.mapping.ComplexAttributeMatcherSourceElement;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.SimpleAttributeMapping;

public class SimpleToComplexAttributeMappingCommand extends StrictCompoundCommand {
	private SimpleAttributeMapping object;
	private EditingDomain domain;
	public SimpleToComplexAttributeMappingCommand(SimpleAttributeMapping object, EditingDomain domain) {
		this.object=object;
		this.domain=domain;
	}

	@Override
	public void execute() {
//		/*
//		 * create new Mapping and set Name
//		 */
//		Command createComplexElement=CreateChildCommand.create(domain, object.eContainer(), MappingPackage.COMPLEX_ATTRIBUTE_MAPPING, Collections.EMPTY_LIST);
//		appendAndExecute(createComplexElement);
//		ComplexAttributeMapping newMapping=(ComplexAttributeMapping) createComplexElement.getResult().iterator().next();
//		if(object.getName() != null){
//			appendAndExecute(SetCommand.create(domain, newMapping, MappingPackage.COMPLEX_ATTRIBUTE_MAPPING__NAME, object.getName()));			
//		}
		appendAndExecute(SetCommand.create(domain, object, MappingPackage.SIMPLE_ATTRIBUTE_MAPPING__NAME, "tets"));
		
//		/*
//		 * Set target feature
//		 */
//		if(object.getTarget() != null){
//			appendAndExecute(SetCommand.create(domain, object, MappingPackage.COMPLEX_ATTRIBUTE_MAPPING__TARGET, object.getTarget()));
//		}
//			
//		/*
//		 * Create Source Element
//		 */
//		if(object.getSource() != null){
//			Command createSource=CreateChildCommand.create(domain, newMapping, MappingPackage.COMPLEX_ATTRIBUTE_MAPPING_SOURCE_ELEMENT, Collections.EMPTY_LIST);
//			appendAndExecute(createComplexElement);
//			ComplexAttributeMatcherSourceElement sourceElement=(ComplexAttributeMatcherSourceElement) createSource.getResult().iterator().next();
//			/*
//			 * Set features source and name to Source Element
//			 */
//			appendAndExecute(SetCommand.create(domain, newMapping, MappingPackage.COMPLEX_ATTRIBUTE_MAPPING_SOURCE_ELEMENT__SOURCE, object.getSource()));
//			
//			String sourceName= object.getSource().getName() == null ? "src" : object.getSource().getName();
//			
//			appendAndExecute(SetCommand.create(domain, sourceElement, MappingPackage.COMPLEX_ATTRIBUTE_MAPPING_SOURCE_ELEMENT__NAME, sourceName));
//		}
//		//TODO add modifier to source
		/*
		 * remove old element
		 */
//		List<SimpleAttributeMapping> list=new LinkedList<SimpleAttributeMapping>();
//		list.add(object);
//		appendAndExecute(RemoveCommand.create(domain, list));
		

	}
	
	
}
