package pamtram.contributions;

import java.util.Iterator;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;
import org.eclipse.ui.menus.ExtensionContributionFactory;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.services.IServiceLocator;

import pamtram.DeactivatableElement;

/**
 * This represents a menu contribution that allows to (de-)activate elements of type
 * {@link DeactivatableElement}. 
 */
public class DeactivateMenuContribution extends ExtensionContributionFactory {

	public DeactivateMenuContribution() {
	}

	@Override
	public void createContributionItems(IServiceLocator serviceLocator,
			IContributionRoot additions) {
		
		ISelectionService s = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
	    if (!(s.getSelection() instanceof IStructuredSelection)) {
	    	return;
	    }
	    
        IStructuredSelection selection = (IStructuredSelection)s.getSelection();
        
        /*
         * Check if all selected elements are of type 'DeactivatableElement' and have
         * the same activation status.
         */
        Iterator<?> it = selection.iterator();
        boolean status = false;
        while(it.hasNext()) {
        	Object el = it.next();
        	if(!(el instanceof DeactivatableElement)) {
        		return;
        	}
        	boolean deactivated = ((DeactivatableElement) el).isDeactivated();
        	if(deactivated != status) {
        		if(selection.getFirstElement().equals(el)) {
        			status = deactivated;
        		} else {
        			return;	        			
        		}
        	}
        	
        }
		
        /*
         * Create the contribution
         */
		CommandContributionItemParameter p = new CommandContributionItemParameter(
                serviceLocator, "",
                "de.mfreund.pamtram.commands.DeactivationCommand",
                SWT.PUSH);
        p.label = (status ? "Activate" : "Deactivate");
//        p.icon = Implementation.imageDescriptorFromPlugin("de.mfreund.pamtram.model.editor", "icons/)
//        p.icon = Activator.getImageDescriptor("icons/alt_window_16.gif");
 
        CommandContributionItem item = new CommandContributionItem(p);
        item.setVisible(true);
        additions.addContributionItem(item, null);
	}

	
}
