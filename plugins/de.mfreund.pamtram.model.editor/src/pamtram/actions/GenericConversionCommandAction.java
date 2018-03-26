/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package pamtram.actions;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.StaticSelectionCommandAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;

import pamtram.commands.GenericConvertCommand;
import pamtram.commands.GenericConvertCommand.IConverter;

/**
 * A generic action that uses the GenericConversionCommand to convert an instance of a source type to an instance of the
 * target type.
 *
 * @author mfreund
 *
 * @param <S>
 *            the (source) type of the object to be converted
 * @param <T>
 *            the (target) type of the object to be created during the conversion
 */
public class GenericConversionCommandAction<S extends EObject, T extends EObject>  extends
StaticSelectionCommandAction {

	/**
	 * This describes the source type to be converted.
	 */
	protected S descriptor;

	/**
	 * This is the feature of the owner object upon the command will act.
	 * It could be null, in the case that we are dealing with an {@link org.eclipse.emf.common.util.EList}.
	 */
	protected EStructuralFeature feature;

	/**
	 * This is the converter used to convert the source to the target.
	 */
	protected IConverter<S, T> converter;

	/**
	 * This constructs an instance of the generic command action to convert an instance of a source type to an
	 * instance of the target type.
	 *
	 * @param workbenchPart the active workbench part
	 * @param selection the current editor selection
	 * @param label the label of the action
	 * @param feature the feature that holds the source object (and after the conversion the target object)
	 * @param descriptor the source object to be converted
	 * @param converter the converter used to transform the source object during the execution of the command
	 */
	public GenericConversionCommandAction(
			IWorkbenchPart workbenchPart,
			ISelection selection,
			String label,
			EStructuralFeature feature,
			S descriptor,
			IConverter<S, T> converter) {

		super(workbenchPart);
		this.setText(label);
		this.feature = feature;
		this.descriptor = descriptor;
		this.converter = converter;
		this.configureAction(selection);
	}

	@Override
	protected Command createActionCommand(EditingDomain editingDomain,
			Collection<?> collection) {

		return new GenericConvertCommand<>(
				editingDomain,
				this.descriptor.eContainer(),
				this.feature,
				this.descriptor,
				this.converter);
	}

}
