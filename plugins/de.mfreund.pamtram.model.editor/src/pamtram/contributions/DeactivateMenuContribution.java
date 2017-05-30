package pamtram.contributions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;
import org.eclipse.ui.menus.ExtensionContributionFactory;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.services.IServiceLocator;

import de.tud.et.ifa.agtele.ui.util.UIHelper;
import pamtram.DeactivatableElement;
import pamtram.MappingModel;
import pamtram.SourceSectionModel;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.extended.MappingHint;
import pamtram.structure.source.SourceSection;

/**
 * This represents a menu contribution that allows to (de-)activate elements of
 * type {@link DeactivatableElement}.
 */
public class DeactivateMenuContribution extends ExtensionContributionFactory {

	@Override
	public void createContributionItems(IServiceLocator serviceLocator, IContributionRoot additions) {

		ISelection s = UIHelper.getCurrentSelection();
		if (s == null || s.isEmpty() || !(s instanceof IStructuredSelection)) {
			return;
		}

		IStructuredSelection selection = (IStructuredSelection) s;

		/*
		 * Check if all selected elements are of type 'DeactivatableElement' and
		 * have the same activation status.
		 */
		List<Object> selectedElements = Arrays.asList(selection.toArray());
		if (!selectedElements.parallelStream().allMatch(el -> el instanceof DeactivatableElement) || selectedElements
				.parallelStream().map(el -> ((DeactivatableElement) el)).collect(Collectors.toSet()).size() > 1) {
			return;
		}

		boolean status = ((DeactivatableElement) selectedElements.get(0)).isDeactivated();

		boolean allElementsOfSameType = selectedElements.parallelStream()
				.map(el -> ((DeactivatableElement) el).eClass()).collect(Collectors.toSet()).size() == 1;

		/*
		 * Create the contribution
		 */
		CommandContributionItemParameter p = new CommandContributionItemParameter(serviceLocator, "",
				"de.mfreund.pamtram.commands.DeactivationCommand", SWT.PUSH);
		String label = "PAMTraM: " + (status ? "Activate" : "Deactivate");

		if (allElementsOfSameType) {
			EObject firstElement = (DeactivatableElement) selectedElements.get(0);
			if (firstElement instanceof SourceSection) {
				label += " SourceSection";
			} else if (firstElement instanceof SourceSectionModel) {
				label += " SourceSectionModel";
			} else if (firstElement instanceof MappingModel) {
				label += " MappingModel";
			} else if (firstElement instanceof Mapping) {
				label += " Mapping";
			} else if (firstElement instanceof MappingHintGroup) {
				label += " MappingHintGroup";
			} else if (firstElement instanceof MappingHint) {
				label += " MappingHint";
			}
		}

		p.label = label;

		CommandContributionItem item = new CommandContributionItem(p);
		item.setVisible(true);
		additions.addContributionItem(item, null);
	}

}
