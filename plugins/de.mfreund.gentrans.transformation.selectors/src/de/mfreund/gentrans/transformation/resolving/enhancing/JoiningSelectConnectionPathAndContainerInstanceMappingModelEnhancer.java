/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 *
 */
package de.mfreund.gentrans.transformation.resolving.enhancing;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;

import de.mfreund.gentrans.transformation.resolving.UserDecisionResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.wizards.GenericSelectionDialog;
import de.tud.et.ifa.agtele.emf.compare.EMFCompareUtil;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPath;
import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.presentation.PamtramEditor;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.target.TargetFactory;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionCompositeReference;

/**
 * A concrete {@link MappingModelEnhancer} that can be used during
 * {@link UserDecisionResolvingStrategy#joiningSelectConnectionPathAndContainerInstance(java.util.Map, pamtram.structure.target.TargetSection, List, pamtram.mapping.MappingHintGroupType)
 * joiningSelectConnectionPathAndContainerInstance} ambiguities.
 *
 * @author mfreund
 */
public class JoiningSelectConnectionPathAndContainerInstanceMappingModelEnhancer
		extends MappingModelEnhancer<GenericSelectionDialog<EClassConnectionPath>> {

	/**
	 * The {@link TargetSection} that shall be connected via the selected path to the selected instance.
	 */
	private TargetSection sectionToConnect;

	/**
	 * The first reference create as part of
	 * {@link #instantiateIntermediatePathElements(EClassConnectionPath, TargetSectionCompositeReference, TargetSectionClass)}
	 * to be connected to the 'rootSection' in the end). After the execution of this method, this will hold the
	 * {@link TargetSectionCompositeReference} that represents the first reference of the path.
	 */
	private TargetSectionCompositeReference firstReference = null;

	/**
	 * The final class created as part of
	 * {@link #instantiateIntermediatePathElements(EClassConnectionPath, TargetSectionCompositeReference, TargetSectionClass)}
	 * to be set as 'container' for the 'sectionToConnect'). After the execution of this method, this will hold the
	 * {@link TargetSectionClass} that represents the final class of the path (Note that the final class is the second
	 * but last class because the last class already exists in the mapping model).
	 */
	private TargetSectionClass finalClass = null;

	/**
	 * This creates an instance.
	 *
	 * @param pamtramModel
	 * @param sectionToConnect
	 *            The {@link TargetSection} that shall be connected via the selected path to the selected instance.
	 */
	public JoiningSelectConnectionPathAndContainerInstanceMappingModelEnhancer(PAMTraM pamtramModel,
			TargetSection sectionToConnect) {

		super(pamtramModel);
		this.sectionToConnect = sectionToConnect;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		PamtramEditor editor = this.getEditor();

		PAMTraM pamtramToEnhance = editor == null ? this.pamtramModel : editor.getPamtram();

		EClassConnectionPath selectedPath = this.dialog.getSingleSelection();

		Optional<TargetSection> rootSectionOptional = pamtramToEnhance.getTargetSections().parallelStream()
				.filter(t -> selectedPath.getStartingClass().equals(t.getEClass())).findAny();

		// The root element of the path (either an already existing element from the pamtram model or a newly created).
		//
		TargetSection rootSection;
		if (rootSectionOptional.isPresent()) {
			rootSection = rootSectionOptional.get();
		} else {
			rootSection = TargetFactory.eINSTANCE.createTargetSection();
			rootSection.setEClass(selectedPath.getStartingClass());
		}

		// Instantiate the intermediate elements
		//
		this.instantiateIntermediatePathElements(selectedPath);

		if (editor == null) {

			// Use the 'classic' way to add the new elements as we can not use any command stack
			//
			if (this.firstReference != null) {
				rootSection.getReferences().add(this.firstReference);
			}
			if (!rootSectionOptional.isPresent()) {
				this.pamtramModel.getTargetSectionModels().get(0).getSections().add(rootSection);
			}
			this.sectionToConnect.setContainer(this.finalClass == null ? rootSection : this.finalClass);

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
			if (this.firstReference != null) {
				if (!rootSectionOptional.isPresent()) {
					rootSection.getReferences().add(this.firstReference);
				} else {
					addCommand.append(new AddCommand(editor.getEditingDomain(), rootSection,
							GenericPackage.Literals.CLASS__REFERENCES, this.firstReference));
				}
			}
			if (!rootSectionOptional.isPresent()) {
				addCommand.append(
						new AddCommand(editor.getEditingDomain(), editor.getPamtram().getTargetSectionModels().get(0),
								PamtramPackage.Literals.SECTION_MODEL__SECTIONS, rootSection));
			}
			addCommand.append(new SetCommand(editor.getEditingDomain(), sectionToConnectMatch,
					GenericPackage.Literals.CLASS__CONTAINER, this.finalClass == null ? rootSection : this.finalClass));
			editor.getEditingDomain().getCommandStack().execute(addCommand);

		}

	}

	/**
	 * This instantiates the intermediate elements of a selected path (from the first reference to the final class) by
	 * creating the required {@link TargetSectionClass TargetSectionClasses} and
	 * {@link TargetSectionContainmentReference TargetSectionContainmentReferences}.
	 *
	 */
	private void instantiateIntermediatePathElements(EClassConnectionPath path) {

		TargetSectionClass currentClass = null;

		// Iterate through the path elements and instantiate the intermediate
		// TargetSectionClasses/-ContainmentReferences
		//
		ListIterator<EClass> classIterator = path.getAllClasses().listIterator();
		ListIterator<EReference> referenceIterator = path.getAllReferences().listIterator();
		while (referenceIterator.hasPrevious()) {

			EReference eReference = referenceIterator.previous();
			EClass eClass = classIterator.previous();

			TargetSectionCompositeReference ref = TargetFactory.eINSTANCE.createTargetSectionCompositeReference();
			ref.setEReference(eReference);

			// we are at the beginning
			//
			if (referenceIterator.nextIndex() == path.getAllReferences().size()) {
				this.firstReference = ref;
			} else {
				currentClass.getReferences().add(ref);
			}

			TargetSectionClass clazz = TargetFactory.eINSTANCE.createTargetSectionClass();
			clazz.setEClass(eClass);
			ref.getValue().add(clazz);
			currentClass = clazz;

			// we have reached the end
			if (classIterator.previousIndex() == 1) {
				this.finalClass = currentClass;
			}
		}

	}

}
