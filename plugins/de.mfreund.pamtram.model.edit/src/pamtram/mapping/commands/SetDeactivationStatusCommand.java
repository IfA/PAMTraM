package pamtram.mapping.commands;

import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.DeactivatableElement;
import pamtram.PamtramPackage;

/**
 * This command allows to change set the '<em><b>deactivated</b></em>' status of a
 * {@link DeactivatableElement}.
 * 
 * @author mfreund
 */
public class SetDeactivationStatusCommand extends SetCommand {

	/**
	 * This constructs an instance.
	 * 
	 * @param domain The editing domain on which the command shall be executed.
	 * @param owner The instance of {@link DeactivatableElement} for which to set
	 * the '<b><em>deactivated</em></b>' status.
	 * @param status The deactivation status to be set.
	 */
	public SetDeactivationStatusCommand(EditingDomain domain, DeactivatableElement owner,
			boolean status) {
		super(domain, owner, PamtramPackage.Literals.DEACTIVATABLE_ELEMENT__DEACTIVATED, status);
	}
	
}
