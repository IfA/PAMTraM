package pamtram.presentation.actions;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.StaticSelectionCommandAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;

import pamtram.mapping.SimpleAttributeMapping;
import pamtram.mapping.commands.SimpleToComplexAttributeMappingCommand;


public class SimpleToComplexAttributeMappingCommandAction extends
StaticSelectionCommandAction {

	public SimpleToComplexAttributeMappingCommandAction(
			IWorkbenchPart workbenchPart, String label,ISelection selection) {
		
		super(workbenchPart);		System.out.println("hello");
		setText(label);
		configureAction(selection);
	}

	@Override
	public Command createActionCommand(EditingDomain editingDomain, java.util.Collection<?> collection){
		if(collection.size() > 0){
			Object first=collection.iterator().next();
			if( first instanceof SimpleAttributeMapping){	

				SimpleToComplexAttributeMappingCommand cmd=new SimpleToComplexAttributeMappingCommand((SimpleAttributeMapping) first, editingDomain);
				Display display= Display.getDefault();
				Shell shell=new Shell(display);
				MessageBox msg=new MessageBox(shell,SWT.OK);
				msg.setMessage("run" + cmd.equals(UnexecutableCommand.INSTANCE)+isEnabled()+cmd.canExecute());
				msg.open();
				return cmd;
				//return domain.createCommand(SimpleToComplexAttributeMappingCommand.class, new CommandParameter()) 
			}
		}
		return UnexecutableCommand.INSTANCE;
	}
	

}
