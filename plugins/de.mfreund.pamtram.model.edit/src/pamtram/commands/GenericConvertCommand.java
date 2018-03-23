/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package pamtram.commands;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * A generic command that converts an instance of a source type to an instance of the target type.
 *
 * Therefore, an implementation of the interface 'IConverter' has to be provided that does the conversion when the
 * command is invoked.
 *
 * @author mfreund
 *
 * @param <S>
 *            the type of the object to be converted (source type)
 * @param <T>
 *            the type of the object to be created during the conversion (target type)
 */
public class GenericConvertCommand<S extends EObject, T extends EObject> extends AbstractOverrideableCommand {

	/**
	 * This is the owner object upon which the command will act. It could be null, in the case that we are dealing with
	 * an {@link org.eclipse.emf.common.util.EList}.
	 */
	protected EObject owner;

	/**
	 * This is the feature of the owner object upon the command will act. It could be null, in the case that we are
	 * dealing with an {@link org.eclipse.emf.common.util.EList}.
	 */
	protected EStructuralFeature feature;

	/**
	 * This is the source type to be converted.
	 */
	protected S source;

	/**
	 * This is the target type to be created.
	 */
	protected T target;

	/**
	 * This is the converter used to convert the source to the target.
	 */
	protected IConverter<S, T> converter;

	/**
	 * This is the index at which to reinsert the replaced object during an undo so as to achieve the original list
	 * order.
	 */
	protected int index;

	/**
	 * The is the value returned by {@link Command#getAffectedObjects}. The affected objects are different after an
	 * execute than after an undo, so we record it.
	 */
	protected Collection<?> affectedObjects;

	/**
	 * This constructs an instance of the generic command to convert an instance of a source type to an instance of the
	 * target type.
	 *
	 * The actual conversion is performed by an instance of 'IConverter' that is called when the command is invoked.
	 *
	 * @param domain
	 *            the editing domain that the command operated on
	 * @param owner
	 *            the owner of the object to be converted (will probably be 'source.eContainer()')
	 * @param feature
	 *            the feature that holds the source object (and after the conversion the target object)
	 * @param source
	 *            the source object to be converted
	 * @param converter
	 *            the converter used to transform the source object during the execution of the command
	 */
	public GenericConvertCommand(EditingDomain domain, EObject owner, EStructuralFeature feature, S source,
			IConverter<S, T> converter) {
		super(domain, "ConvertCommand", "ConvertCommand");
		// Initialize all the fields from the command parameter.
		//
		this.owner = owner;
		this.feature = feature;
		this.source = source;
		this.converter = converter;
	}

	/**
	 * This returns the owner object upon which the command will act. It could be null, in the case that we are dealing
	 * with an {@link org.eclipse.emf.common.util.EList}.
	 *
	 * @return The owner object upon which the command will act.
	 */
	public EObject getOwner() {

		return this.owner;
	}

	/**
	 * This returns the feature of the owner object upon the command will act. It could be null, in the case that we are
	 * dealing with an {@link org.eclipse.emf.common.util.EList}.
	 *
	 * @return The feature of the owner object upon the command will act.
	 */
	public EStructuralFeature getFeature() {

		return this.feature;
	}

	/**
	 * This returns the source type to be converted.
	 *
	 * @return The source type to be converted.
	 */
	public S getSource() {

		return this.source;
	}

	/**
	 * This returns the target type to be created.
	 *
	 * @return The source type to be converted.
	 */
	public T getTarget() {

		return this.target;
	}

	/**
	 * This returns the index at which to reinsert the replaced objects during an undo so as to achieve the original
	 * list order.
	 *
	 * @return The index at which to reinsert the replaced objects.
	 */
	public int getIndex() {

		return this.index;
	}

	@Override
	protected boolean prepare() {

		return true;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void doExecute() {

		if (this.feature.isMany()) {
			this.index = ((EList) this.owner.eGet(this.feature)).indexOf(this.source);
		}

		this.target = this.converter.convert(this.source);

		if (this.feature.isMany()) {
			((EList) this.owner.eGet(this.feature)).remove(this.source);
			((EList) this.owner.eGet(this.feature)).add(this.index, this.target);
		} else {
			this.owner.eSet(this.feature, this.target);
		}

		this.affectedObjects = Collections.singleton(this.target);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void doUndo() {

		if (this.feature.isMany()) {
			((EList) this.owner.eGet(this.feature)).remove(this.target);
			((EList) this.owner.eGet(this.feature)).add(this.index, this.source);
		} else {
			this.owner.eSet(this.feature, this.source);
		}

		this.affectedObjects = Collections.singleton(this.source);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void doRedo() {

		if (this.feature.isMany()) {
			((EList) this.owner.eGet(this.feature)).remove(this.source);
			((EList) this.owner.eGet(this.feature)).add(this.index, this.target);
		} else {
			this.owner.eSet(this.feature, this.target);
		}

		this.affectedObjects = Collections.singleton(this.target);
	}

	@Override
	public Collection<?> doGetResult() {

		return this.affectedObjects;
	}

	@Override
	public Collection<?> doGetAffectedObjects() {

		return this.affectedObjects;
	}

	/**
	 * This gives an abbreviated name using this object's own class' name, without package qualification, followed by a
	 * space separated list of <tt>field:value</tt> pairs.
	 */
	@Override
	public String toString() {

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (owner: " + this.owner + ")");
		result.append(" (feature: " + this.feature + ")");
		result.append(" (source: " + this.source + ")");
		result.append(" (target: " + this.target + ")");
		result.append(" (affectedObjects:" + this.affectedObjects + ")");
		return result.toString();
	}

	/**
	 * Interface that needs to be implemented to convert a source element to a target element.
	 *
	 * @author mfreund
	 *
	 * @param <S>
	 *            the type of the object to be converted (source type)
	 * @param <T>
	 *            the type of the object to be created during the conversion (target type)
	 */
	@FunctionalInterface
	public interface IConverter<S extends EObject, T extends EObject> {

		/**
		 * Converts an instance of the SourceType to an instance of the TargetType.
		 *
		 * Attention: When implementing this interface, make sure that 'EcoreUtil.copyAll()' is used to copy child
		 * elements (referenced via a containment reference). Otherwise, 'undo()' does not work correctly (the child
		 * elements are lost).
		 *
		 * @param source
		 *            instance of the source type
		 * @return instance of the target type
		 */
		public T convert(S source);
	}

}
