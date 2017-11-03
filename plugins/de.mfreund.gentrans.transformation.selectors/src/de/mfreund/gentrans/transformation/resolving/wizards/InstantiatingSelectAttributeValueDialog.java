package de.mfreund.gentrans.transformation.resolving.wizards;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;

import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import de.tud.et.ifa.agtele.resources.ResourceHelper;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import de.tud.et.ifa.agtele.ui.util.UIHelper;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.presentation.PamtramEditor;
import pamtram.structure.target.ActualTargetSectionAttribute;
import pamtram.structure.target.TargetSectionAttribute;

/**
 * A {@link ValueSpecificationDialog} that allows the user to enter a single value for an attribute.
 *
 * @author mfreund
 */
public class InstantiatingSelectAttributeValueDialog extends ValueSpecificationDialog {

	/**
	 * The target {@link EObject element} for that the option shall be chosen.
	 */
	protected EObject element;

	/**
	 * The {@link TargetSectionAttribute} for that a value shall be entered.
	 */
	protected TargetSectionAttribute attribute;

	/**
	 * The {@link InstantiableMappingHintGroup mapping hint group} based on which the attribute was created.
	 */
	protected InstantiableMappingHintGroup mappingHintGroup;

	/**
	 * Create the dialog.
	 *
	 * @param message
	 *            The message that shall be displayed in the dialog.
	 * @param attribute
	 *            The {@link TargetSectionAttribute} for that a value shall be entered.
	 * @param element
	 *            The target {@link EObject element} for that the option shall be chosen.
	 * @param mappingHintGroup
	 *            The {@link InstantiableMappingHintGroup mapping hint group} based on which the attribute was created.
	 * @param enhanceMappingModelListener
	 *            An optional {@link SelectionListener2} that will be called when the <em>EnhanceMappingModelButton</em>
	 *            is clicked. If no listener is given, the button will be grayed out.
	 */
	public InstantiatingSelectAttributeValueDialog(String message, TargetSectionAttribute attribute, EObject element,
			InstantiableMappingHintGroup mappingHintGroup, Optional<SelectionListener2> enhanceMappingModelListener) {

		super(message,
				attribute instanceof ActualTargetSectionAttribute
						? ((ActualTargetSectionAttribute) attribute).getAttribute().getEAttributeType()
						: EcorePackage.Literals.ESTRING,
				enhanceMappingModelListener);

		this.attribute = attribute;
		this.element = element;
		this.mappingHintGroup = mappingHintGroup;
	}

	@Override
	protected void createInnerContents(Composite container) {

		Group group = new Group(container, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).minSize(200, 200).applyTo(group);
		group.setText("Source of the Ambiguity:");
		GridLayoutFactory.fillDefaults().margins(5, 5).applyTo(group);

		// A label providing information about the element
		//
		Label label = new Label(group, SWT.WRAP);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(label);
		label.setText("The ambiguity occurred while setting the value of the TargetSectionAttribute '"
				+ this.attribute.getOwningClass().getName() + "." + this.attribute.getName()
				+ "' for the following element of the target model:\n\n" + EObjectWrapper.asString(this.element));

		// A link that allows jumping to the pamtram model and selecting the attribute
		//
		Link link = new Link(group, SWT.NONE);
		GridDataFactory.swtDefaults().applyTo(link);
		link.setText("<A>-> Show TargetSectionAttribute in PAMTraM Model...</A>");
		link.addSelectionListener((SelectionListener2) e -> {

			try {
				PamtramEditor editor = (PamtramEditor) UIHelper.openEditor(
						ResourceHelper.getFileForResource(this.attribute.eResource()),
						"pamtram.presentation.PamtramEditorID");
				editor.setSelection(new StructuredSelection(AgteleEcoreUtil.getEquivalentElementFrom(this.attribute,
						editor.getEditingDomain().getResourceSet())));
			} catch (Exception e1) {
				UIHelper.log(e1);
				this.setErrorMessage("Unable to select element in the PAMTraM Editor!");
			}

		});

		// A link that allows jumping to the pamtram model and selecting the mappingHintGroup
		//
		Link link2 = new Link(group, SWT.NONE);
		GridDataFactory.swtDefaults().applyTo(link2);
		link2.setText("<A>-> Show MappingHintGroup in PAMTraM Model...</A>");
		link2.addSelectionListener((SelectionListener2) e -> {

			try {
				PamtramEditor editor = (PamtramEditor) UIHelper.openEditor(
						ResourceHelper.getFileForResource(this.mappingHintGroup.eResource()),
						"pamtram.presentation.PamtramEditorID");
				editor.setSelection(new StructuredSelection(AgteleEcoreUtil
						.getEquivalentElementFrom(this.mappingHintGroup, editor.getEditingDomain().getResourceSet())));
			} catch (Exception e1) {
				UIHelper.log(e1);
				this.setErrorMessage("Unable to select element in the PAMTraM Editor!");
			}

		});

		super.createInnerContents(container);

	}

	/**
	 * Get the value specified by the user after the dialog has finished.
	 *
	 * @return The specified value as String.
	 */
	@Override
	public String getValue() {

		return this.retValue;
	}

}
