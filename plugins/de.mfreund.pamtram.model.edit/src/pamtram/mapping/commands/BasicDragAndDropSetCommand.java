package pamtram.mapping.commands;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.DragAndDropFeedback;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.dnd.DND;

/**
 * A SetCommand that provides DragAndDropFeedback and can thus be returned by
 * e.g. the 'createDragAndDropCommand' function in EMF item providers.
 *
 */
public class BasicDragAndDropSetCommand extends SetCommand implements
		DragAndDropFeedback {

	public BasicDragAndDropSetCommand(EditingDomain domain, EObject owner,
			EStructuralFeature feature, Object value, int index) {
		super(domain, owner, feature, value, index);
	}

	@Override
	public boolean validate(Object owner, float location, int operations,
			int operation, Collection<?> collection) {
		return isExecutable;
	}

	@Override
	public int getFeedback() {
		return DND.FEEDBACK_SELECT;
	}

	@Override
	public int getOperation() {
		return DND.DROP_LINK;
	}

}
