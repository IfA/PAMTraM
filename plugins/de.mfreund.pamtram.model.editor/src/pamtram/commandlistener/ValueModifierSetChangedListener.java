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
package pamtram.commandlistener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EventObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import pamtram.MappingModel;
import pamtram.mapping.modifier.ValueModifierSet;

/**
 * A listener that will present a dialog to the user when
 * he changes a set of AttributeValueModifierSets referenced by an
 * element. The user will be asked if other elements referencing
 * a similar set should also be updated automatically.
 */
public class ValueModifierSetChangedListener extends
PamtramChildCommandStackListener {

	/**
	 * This creates an instance.
	 *
	 * @param parentListener
	 *            The parent {@link PamtramCommandStackListener} for this listener.
	 */
	public ValueModifierSetChangedListener(
			PamtramCommandStackListener parentListener) {
		super(parentListener);
	}

	@Override
	public void commandStackChanged(EventObject event) {

		new ValueModifierSetFeatureCommandHandler(this.getMostRecentCommand());
	}

	private class ValueModifierSetFeatureCommandHandler {

		final class ValueModifierSetChangedCloneCommand extends CompoundCommand {
		}

		private final Command command;
		EObject owner = null;
		EStructuralFeature feature = null;

		public ValueModifierSetFeatureCommandHandler(Command command) {

			this.command = command;

			// do not react on undo commands (-> the command equals the redo command of the command stack)
			Command redoCommand =
					ValueModifierSetChangedListener.this.parentListener.getEditor().getEditingDomain().getCommandStack().getRedoCommand();
			if(redoCommand != null && redoCommand.equals(command)) {
				return;
			}
			// do not react on commands that have been issued by this listener
			if(command instanceof ValueModifierSetChangedCloneCommand) {
				return;
			}
			// check if the command should be handled by this listener
			if(!this.isAttValModifierSetChangedCommand()) {
				return;
			}

			this.handleAttributeValueModifierSetFeatureCommand();
		}

		/**
		 * This method check if an issued command should be handled by this listener
		 * because it performs changes on a set of AttributeValueModifierSets.
		 *
		 * @param command The command to be checked.
		 * @return true if the command should be handled by this listener, false otherwise.
		 */
		private boolean isAttValModifierSetChangedCommand() {

			// the command needs to be a compound command
			if(!(this.command instanceof CompoundCommand)) {
				return false;
			}

			// the child commands of the compound command
			List<Command> children = ((CompoundCommand) this.command).getCommandList();

			// check if all child commands are Add/Remove/Move commands and if they all operate on
			// the same owner and structural feature
			for (Command child : children) {
				Object childOwner;
				EStructuralFeature childFeature;
				if(child instanceof AddCommand) {
					childOwner = ((AddCommand) child).getOwner();
					childFeature = ((AddCommand) child).getFeature();
				} else if(child instanceof RemoveCommand) {
					childOwner = ((RemoveCommand) child).getOwner();
					childFeature = ((RemoveCommand) child).getFeature();
				} else if(child instanceof MoveCommand) {
					childOwner = ((MoveCommand) child).getOwner();
					childFeature = ((MoveCommand) child).getFeature();
				} else {
					return false;
				}
				if(this.owner == null) {
					this.owner = (EObject) childOwner;
				} else if (this.owner != childOwner) {
					return false;
				}
				if(this.feature == null) {
					this.feature = childFeature;
				} else if (this.feature != childFeature) {
					return false;
				}
			}

			return this.feature != null && this.feature.getEType().getInstanceClass() == ValueModifierSet.class ? true
					: false;
		}

		private void handleAttributeValueModifierSetFeatureCommand() {

			// the child commands of the compound command
			List<Command> children = ((CompoundCommand) this.command).getCommandList();

			// the cast to EList should always be safe because multiple AttValModifierSets can always
			// be specified
			@SuppressWarnings("unchecked")
			BasicEList<ValueModifierSet> newSets =
			(BasicEList<ValueModifierSet>) this.owner.eGet(this.feature);

			// compute the old list of AttValModifierSets by the new list and child commands
			BasicEList<ValueModifierSet> oldSets =
					new BasicEList<>(newSets);
			for (Command child : children) {
				if(child instanceof AddCommand) {
					for (Object added : child.getAffectedObjects()) {
						oldSets.remove(added);
					}
				} else if(child instanceof RemoveCommand) {
					RemoveCommand rem = (RemoveCommand) child;
					for(int i=0; i<rem.getCollection().size(); i++) {
						oldSets.add(rem.getIndices()[i], (ValueModifierSet) rem.getCollection().toArray()[i]);
					}
				} else if(child instanceof MoveCommand) {
					MoveCommand move = (MoveCommand) child;
					oldSets.move(move.getOldIndex(), move.getIndex());
				} else {
					return;
				}
			}

			if(oldSets.isEmpty()) {
				// we do nothing if this was the first thing that was added to the list of modifier sets
				return;
			}

			// find all other objects referencing the same set of of AttValModifierSets
			// and store them in a map
			Collection<Setting> crossReferences = EcoreUtil.UsageCrossReferencer.find(
					oldSets.get(0), this.owner.eResource());
			final Map<EObject, EReference> matches = new HashMap<>();
			for (Setting setting : crossReferences) {
				EObject object = setting.getEObject();
				EReference feature = (EReference) setting.getEStructuralFeature();
				if (object == null || object.equals(this.owner)) {
					continue;
				}
				// again, this should be safe (see above)
				@SuppressWarnings("unchecked")
				BasicEList<ValueModifierSet> possibleMatch =
				(BasicEList<ValueModifierSet>) object.eGet(feature);

				if(possibleMatch.equals(oldSets)) {
					matches.put(object, feature);
				}
			}

			// nothing to be done
			if(matches.isEmpty()) {
				return;
			}

			// let the user decide what should be updated automatically
			final ValueModifierSetAdaptionDialog dialog =
					new ValueModifierSetAdaptionDialog(ValueModifierSetChangedListener.this.parentListener.getEditor().getSite().getShell(), "AttributeValueModifierSet changed", null,
							"The following items contain the same list of AttributeValueModifierSets than"
									+ " the item you just changed. Please select the ones you want to change as well.", MessageDialog.QUESTION, new String[]{"OK", "Cancel"}, 0, matches);
			dialog.open();
			if(dialog.getReturnCode() != Window.OK || dialog.getSelectedItems().isEmpty()) {
				return;
			}

			// create a command that will be used to update the items chosen by the user
			final CompoundCommand compoundCommand = new ValueModifierSetChangedCloneCommand();
			for (EObject item : dialog.getSelectedItems()) {
				for (Command c : children) {
					Command childCommand;
					if(c instanceof AddCommand) {
						childCommand = new AddCommand(
								ValueModifierSetChangedListener.this.parentListener.getEditor().getEditingDomain(), (EList<?>) item.eGet(matches.get(item)), ((AddCommand) c).getAffectedObjects());
					} else if(c instanceof RemoveCommand) {
						childCommand = new RemoveCommand(
								ValueModifierSetChangedListener.this.parentListener.getEditor().getEditingDomain(), (EList<?>) item.eGet(matches.get(item)), ((RemoveCommand) c).getCollection());
					} else if(c instanceof MoveCommand) {
						childCommand = new MoveCommand(
								ValueModifierSetChangedListener.this.parentListener.getEditor().getEditingDomain(), (EList<?>) item.eGet(matches.get(item)),
								((MoveCommand) c).getOldIndex(), ((MoveCommand) c).getIndex());
					} else {
						continue;
					}
					compoundCommand.append(childCommand);
				}
			}

			// execute the command in another thread so that the command will be
			// executed only after the current command has finished (this results
			// in the correct undo/redo order)
			ValueModifierSetChangedListener.this.parentListener.getEditor().getSite().getShell().getDisplay().asyncExec(() -> ValueModifierSetChangedListener.this.parentListener.getEditor().getEditingDomain().getCommandStack().execute(compoundCommand));

		}
	}

	/**
	 * This dialog is presented to the user when he has changed a set of
	 * AttributeValueModifierSets. The user shall select one or more of
	 * other existing AttributeValueModifierSets that should be changed
	 * as well automatically.
	 *
	 * @author mfreund
	 */
	private final class ValueModifierSetAdaptionDialog extends
	MessageDialog {

		private ArrayList<EObject> selectedItems = new ArrayList<>();
		private final Map<EObject, EReference> matches;

		/**
		 * The constructor.
		 *
		 * @param parentShell
		 * @param dialogTitle
		 * @param dialogTitleImage
		 * @param dialogMessage
		 * @param dialogImageType
		 * @param dialogButtonLabels
		 * @param defaultIndex
		 * @param matches a map<EObject, EReference> that contains the eObjects
		 * that point to a similar list of AttributeValueModifierSets (via the
		 * respective eReference from the map)
		 */
		public ValueModifierSetAdaptionDialog(Shell parentShell,
				String dialogTitle, Image dialogTitleImage,
				String dialogMessage, int dialogImageType,
				String[] dialogButtonLabels, int defaultIndex,
				Map<EObject, EReference> matches) {
			super(parentShell, dialogTitle, dialogTitleImage, dialogMessage,
					dialogImageType, dialogButtonLabels, defaultIndex);
			this.matches = matches;
		}

		/**
		 * This returns the elements that have been selected by the user
		 * (a subset of the list of EObjects passed as key set of the 'matches'
		 * map in the constructor).
		 *
		 * @return the selected items
		 */
		public ArrayList<EObject> getSelectedItems() {
			return this.selectedItems;
		}

		@Override
		protected Control createCustomArea(Composite parent) {

			// create a table that holds the paths to the AttributeValueModifierSets that
			// can be selected
			Table table = new Table(parent, SWT.MULTI | SWT.CHECK);
			table.setHeaderVisible(true);
			table.setLinesVisible(true);
			GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
			data.heightHint = 200;
			table.setLayoutData(data);

			TableColumn objectColumn = new TableColumn(table, SWT.NONE);
			objectColumn.setText ("Path");

			// the adapter factory is used to get the labels for diverse elements on the paths
			// to the AttributeValueModifierSets
			ComposedAdapterFactory composedAdapterFactory =
					new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			AdapterFactoryLabelProvider labelProvider =
					new AdapterFactoryLabelProvider(composedAdapterFactory);

			// for each path, create a line in the table
			for (EObject object : this.matches.keySet()) {
				TableItem item = new TableItem(table, SWT.NONE);
				item.setData(object);
				String text = labelProvider.getText(object) + "..." + this.matches.get(object).getName();
				EObject cont = object.eContainer();
				while(!(cont instanceof MappingModel)) {
					text = labelProvider.getText(cont) + "..." + text;
					cont = cont.eContainer();
				}
				item.setText(0, text);
			}

			// the adapter factory is not needed any more
			composedAdapterFactory.dispose();

			// when the user (de)selects an entry, the list of selected entries is updated
			table.addSelectionListener((SelectionListener2) e -> {
				TableItem item = (TableItem) e.item;
				if(item.getChecked()) {
					ValueModifierSetAdaptionDialog.this.selectedItems.add((EObject) item.getData());
				} else {
					ValueModifierSetAdaptionDialog.this.selectedItems.remove(item.getData());
				}
			});

			objectColumn.pack();
			table.pack();

			return table;
		}
	}

}
