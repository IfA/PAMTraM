/**
 *
 */
package de.mfreund.gentrans.transformation.resolving.enhancing;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;

import de.mfreund.gentrans.transformation.descriptors.ModelConnectionPath;
import de.mfreund.gentrans.transformation.resolving.UserDecisionResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.wizards.GenericSelectionDialogRunner;
import de.tud.et.ifa.agtele.emf.compare.EMFCompareUtil;
import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.metamodel.MetamodelFactory;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.TargetSection;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionContainmentReference;
import pamtram.presentation.PamtramEditor;

/**
 * A concrete {@link MappingModelEnhancer} that can be used during
 * {@link UserDecisionResolvingStrategy#joiningSelectConnectionPath(List, pamtram.metamodel.TargetSection)
 * joiningSelectConnectionPath} ambiguities.
 *
 * @author mfreund
 */
public class JoiningSelectConnectionPathMappingModelEnhancer
extends MappingModelEnhancer<GenericSelectionDialogRunner<ModelConnectionPath>> {

	/**
	 * The {@link TargetSection} that shall be connected via the selected path.
	 */
	private TargetSection sectionToConnect;

	/**
	 * This creates an instance.
	 *
	 * @param pamtramModel
	 * @param sectionToConnect
	 *            The {@link TargetSection} that shall be connected via the selected path.
	 */
	public JoiningSelectConnectionPathMappingModelEnhancer(PAMTraM pamtramModel, TargetSection sectionToConnect) {
		super(pamtramModel);
		this.sectionToConnect = sectionToConnect;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		PamtramEditor editor = this.getEditor();

		PAMTraM pamtramToEnhance = editor == null ? this.pamtramModel : editor.getPamtram();

		ModelConnectionPath selectedPath = this.dialogRunner.getSingleSelection();

		Optional<TargetSection> rootSectionOptional = pamtramToEnhance.getTargetSections().parallelStream().filter(t -> selectedPath.getPathRootClass().equals(t.getEClass())).findAny();

		// The root element of the path (either an already existing element from the pamtram model or a newly created).
		//
		TargetSection rootSection;
		if (rootSectionOptional.isPresent()) {
			rootSection = rootSectionOptional.get();
		} else {
			rootSection = MetamodelFactory.eINSTANCE.createTargetSection();
			rootSection.setEClass(selectedPath.getPathRootClass());
		}

		// The first created reference (this needs to be connected to the 'rootSection' in the end
		//
		TargetSectionContainmentReference firstReference = null;

		// The final created class (this needs to be set as 'container' for the 'sectionToConnect'
		//
		TargetSectionClass finalClass = null;

		// Instantiate the intermediate elements
		//
		this.instantiateIntermediatePathElements(selectedPath, firstReference, finalClass);

		if (editor == null) {

			// Use the 'classic' way to add the new elements as we can not use any command stack
			//
			if (!rootSectionOptional.isPresent()) {
				rootSection.getReferences().add(firstReference);
				this.pamtramModel.getTargetSectionModel().get(0).getMetaModelSections().add(rootSection);
			} else {
				rootSection.getReferences().add(firstReference);
			}
			this.sectionToConnect.setContainer(finalClass);

			// finally, we save the model
			try {
				this.pamtramModel.eResource().save(null);
			} catch (IOException e1) {
				MessageDialog.openError(new Shell(), "Error", "Error while trying to save the PAMTraM model!");
				e1.printStackTrace();
			}
		} else {

			TargetSection sectionToConnectMatch = EMFCompareUtil.getMatchOfSameType(this.pamtramModel, pamtramToEnhance,
					this.sectionToConnect);

			if (sectionToConnectMatch == null) {
				return;
			}

			// Use a command to add the new elements
			//
			CompoundCommand addCommand = new CompoundCommand();
			if (!rootSectionOptional.isPresent()) {
				rootSection.getReferences().add(firstReference);
				addCommand.append(
						new AddCommand(editor.getEditingDomain(), editor.getPamtram().getTargetSectionModel().get(0),
								PamtramPackage.Literals.SECTION_MODEL__META_MODEL_SECTIONS, rootSection));
			} else {
				addCommand.append(new AddCommand(editor.getEditingDomain(), rootSection,
						MetamodelPackage.Literals.CLASS__REFERENCES, firstReference));
			}
			addCommand.append(new SetCommand(editor.getEditingDomain(), sectionToConnectMatch,
					MetamodelPackage.Literals.CLASS__CONTAINER, finalClass));
			editor.getEditingDomain().getCommandStack().execute(addCommand);

		}

	}

	/**
	 * This instantiates the intermediate elements of a selected path (from the first reference to the final class) by
	 * creating the required {@link TargetSectionClass TargetSectionClasses} and
	 * {@link TargetSectionContainmentReference TargetSectionContainmentReferences}.
	 *
	 * @param firstReference
	 *            After the execution of this method, this will hold the {@link TargetSectionContainmentReference} that
	 *            represents the first reference of the path.
	 * @param finalClass
	 *            After the execution of this method, this will hold the {@link TargetSectionClass} that represents the
	 *            final class of the path (Note that the final class is the second but last class because the last class
	 *            already exists in the mapping model).
	 */
	private void instantiateIntermediatePathElements(ModelConnectionPath path,
			TargetSectionContainmentReference firstReference, TargetSectionClass finalClass) {

		TargetSectionClass currentClass = null;

		// Iterate through the path elements and instantiate the intermediate
		// TargetSectionClasses/-ContainmentReferences
		//
		for (int i = path.getPathElements().size() - 2; i > 1; i -= 2) {

			EReference eReference = (EReference) path.getPathElements().get(i);
			EClass eClass = (EClass) path.getPathElements().get(i - 1);

			TargetSectionContainmentReference ref = MetamodelFactory.eINSTANCE
					.createTargetSectionContainmentReference();
			ref.setEReference(eReference);

			// we are at the beginning
			//
			if (i == path.getPathElements().size() - 2) {
				firstReference = ref;
			} else {
				currentClass.getReferences().add(ref);
			}

			TargetSectionClass clazz = MetamodelFactory.eINSTANCE.createTargetSectionClass();
			clazz.setEClass(eClass);
			ref.getValue().add(clazz);
			currentClass = clazz;

			// we have reached the end
			if (i - 2 == 1) {
				finalClass = currentClass;
			}
		}

	}

}

