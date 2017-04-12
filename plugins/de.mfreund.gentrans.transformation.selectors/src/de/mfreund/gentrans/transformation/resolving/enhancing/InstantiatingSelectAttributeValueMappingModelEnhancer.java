/**
 *
 */
package de.mfreund.gentrans.transformation.resolving.enhancing;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;

import de.mfreund.gentrans.transformation.resolving.UserDecisionResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.wizards.ValueSpecificationDialogRunner;
import de.tud.et.ifa.agtele.emf.compare.EMFCompareUtil;
import pamtram.PAMTraM;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.extended.AttributeMapping;
import pamtram.mapping.extended.ExtendedFactory;
import pamtram.mapping.extended.ExtendedPackage;
import pamtram.presentation.PamtramEditor;
import pamtram.structure.target.TargetSectionAttribute;

/**
 * A concrete {@link MappingModelEnhancer} that can be used during
 * {@link UserDecisionResolvingStrategy#instantiatingSelectAttributeValue(List, pamtram.structure.target.TargetSectionAttribute, org.eclipse.emf.ecore.EObject, InstantiableMappingHintGroup)
 * instantiatingSelectAttributeValue} ambiguities.
 *
 * @author mfreund
 */
public class InstantiatingSelectAttributeValueMappingModelEnhancer
		extends MappingModelEnhancer<ValueSpecificationDialogRunner> {

	/**
	 * The {@link TargetSectionAttribute} to be enhanced.
	 */
	private TargetSectionAttribute attributeToEnhance;

	/**
	 * The {@link InstantiableMappingHintGroup} based on which the attribute is
	 * created.
	 */
	private InstantiableMappingHintGroup mappingHintGroup;

	/**
	 * This creates an instance.
	 *
	 * @param pamtramModel
	 * @param attributeToEnhance
	 *            The {@link TargetSectionAttribute} to be enhanced.
	 * @param mappingHintGroup
	 *            The {@link InstantiableMappingHintGroup} based on which the
	 *            attribute is created.
	 */
	public InstantiatingSelectAttributeValueMappingModelEnhancer(PAMTraM pamtramModel,
			TargetSectionAttribute attributeToEnhance, InstantiableMappingHintGroup mappingHintGroup) {
		super(pamtramModel);
		this.attributeToEnhance = attributeToEnhance;
		this.mappingHintGroup = mappingHintGroup;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		PamtramEditor editor = this.getEditor();

		PAMTraM pamtramToEnhance = editor == null ? this.pamtramModel : editor.getPamtram();

		AttributeMapping attributeMapping = ExtendedFactory.eINSTANCE.createAttributeMappingWithSource();

		if (editor == null) {

			// Use the 'classic' way to add the new elements as we can not use
			// any command stack
			//
			attributeMapping.setTarget(this.attributeToEnhance);
			if (this.mappingHintGroup instanceof MappingHintGroup) {
				((MappingHintGroup) this.mappingHintGroup).getMappingHints().add(attributeMapping);
			} else if (this.mappingHintGroup instanceof MappingHintGroupImporter) {
				((MappingHintGroupImporter) this.mappingHintGroup).getMappingHints().add(attributeMapping);
			}

			// finally, we save the model
			try {
				this.pamtramModel.eResource().save(null);
			} catch (IOException e1) {
				MessageDialog.openError(new Shell(), "Error", "Error while trying to save the PAMTraM model!");
				e1.printStackTrace();
			}
		} else {

			TargetSectionAttribute attributeToEnhanceMatch = EMFCompareUtil.getMatchOfSameType(this.pamtramModel,
					pamtramToEnhance, this.attributeToEnhance);

			if (attributeToEnhanceMatch == null) {
				return;
			}

			// Use a command to add the new elements
			//
			CompoundCommand addCommand = new CompoundCommand();

			// Add the 'AttributeMapping'
			//
			InstantiableMappingHintGroup mappingHintGroupMatch = EMFCompareUtil.getMatchOfSameType(this.pamtramModel,
					pamtramToEnhance, this.mappingHintGroup);
			if (this.mappingHintGroup instanceof MappingHintGroup) {
				addCommand.append(new AddCommand(editor.getEditingDomain(),
						((MappingHintGroup) mappingHintGroupMatch).getMappingHints(), attributeMapping));
			} else if (this.mappingHintGroup instanceof MappingHintGroupImporter) {
				addCommand.append(new AddCommand(editor.getEditingDomain(),
						((MappingHintGroupImporter) mappingHintGroupMatch).getMappingHints(), attributeMapping));
			}

			// Set the 'target' reference of the AttributeMapping
			//
			addCommand.append(new SetCommand(editor.getEditingDomain(), attributeMapping,
					ExtendedPackage.Literals.ATTRIBUTE_MAPPING__TARGET, attributeToEnhanceMatch));

			editor.getEditingDomain().getCommandStack().execute(addCommand);

		}

	}

}
