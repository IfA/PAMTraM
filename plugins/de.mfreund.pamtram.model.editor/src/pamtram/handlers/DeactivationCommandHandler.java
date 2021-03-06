/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package pamtram.handlers;

import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;

import pamtram.DeactivatableElement;
import pamtram.commands.SetDeactivationStatusCommand;
import pamtram.presentation.PamtramEditor;

/**
 * This handlers is used when the '<em><b>Deactivate</b></em>' menu entry is
 * selected.
 * 
 * @author mfreund
 *
 */
public class DeactivationCommandHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ISelectionService s = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
	    if (!(s.getSelection() instanceof IStructuredSelection)) {
	    	return null;
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
        		return null;
        	}
        	boolean deactivated = ((DeactivatableElement) el).isDeactivated();
        	if(deactivated != status) {
        		if(selection.getFirstElement().equals(el)) {
        			status = deactivated;
        		} else {
        			return null;	        			
        		}
        	}
        	
        }
        
        // A compound command to host all other commands
        CompoundCommand compoundCommand = new CompoundCommand();
        
        /*
         * Determine the editing domain on which to execute the command
         */
        IEditorPart editorPart = 
        		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        if(!(editorPart instanceof PamtramEditor)) {
        	return null;
        }
        EditingDomain domain = ((PamtramEditor) editorPart).getEditingDomain();
        
        /*
         * Now, iterate again and create a command for every selected item.
         */
        Iterator<?> it2 = selection.iterator();
        while(it2.hasNext()) {
        	Object el = it2.next();
        	
        	compoundCommand.append(
        			new SetDeactivationStatusCommand(domain, (DeactivatableElement) el, !status));
        }
        
        // Finally, execute the command.
        domain.getCommandStack().execute(compoundCommand);
		return null;
	}

}
