package pamtram.contentadapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import pamtram.MappingModel;
import pamtram.mapping.AttributeValueModifierSet;

final class AttValModifierSetHandlerAdapter extends EContentAdapter {
	@Override
	public void notifyChanged(Notification n) {
		super.notifyChanged(n);
		
		if(n.getEventType() == Notification.RESOLVE) {
			return;
		}
		
		// handle notifications by type of feature that changed
		if(n.getFeature() instanceof EReference) {
			EReference ref = (EReference) n.getFeature();
			if(ref.getEReferenceType().getInstanceClass().equals(AttributeValueModifierSet.class)) {
				handleAttributeValueModifierSetFeatureChangedNotification(n);
			}
		}
	}
	
	// An AttributeValueModifierSet has been added/changed/deleted
	private void handleAttributeValueModifierSetFeatureChangedNotification(Notification n) {
		EReference ref = (EReference) n.getFeature();
		
		// the cast to EList should always be safe because multiple AttValModifierSets can always 
		// be specified
		@SuppressWarnings("unchecked")
		BasicEList<AttributeValueModifierSet> newSets = 
				(BasicEList<AttributeValueModifierSet>) ((EObject) n.getNotifier()).eGet(ref);
		
		// compute the old list of AttValModifierSets by the new list and the notification event type
		BasicEList<AttributeValueModifierSet> oldSets = 
				new BasicEList<>(newSets);
		if(n.getEventType() == Notification.ADD) {
			oldSets.remove(n.getNewValue());
			// do nothing if this was the first thing to be added
			if(oldSets.isEmpty()) {
				return;
			}
		} else if(n.getEventType() == Notification.REMOVE) {
			oldSets.add(n.getPosition(), (AttributeValueModifierSet) n.getOldValue());
		} else {
			//TODO handle other event types like 'add_many', 'remove_many' or 'move'
			return;
		}
		
		// find all other objects referencing the same set of of AttValModifierSets
		// and store them in a map
		Collection<Setting> crossReferences = EcoreUtil.UsageCrossReferencer.find(
					oldSets.get(0), ((EObject) n.getNotifier()).eResource());
		final Map<EObject, EReference> matches = new HashMap<>();
		for (Setting setting : crossReferences) {
			EObject object = setting.getEObject();
			EReference feature = (EReference) setting.getEStructuralFeature();
			if(object.equals(n.getNotifier())) {
				continue;
			}
			// again, this should be safe (see above)
			@SuppressWarnings("unchecked")
			BasicEList<AttributeValueModifierSet> possibleMatch = 
					(BasicEList<AttributeValueModifierSet>) object.eGet(feature);
			
			if(possibleMatch.equals(oldSets)) {
				matches.put(object, feature);
			}
		}
		
		// nothing to be done
		if(matches.isEmpty()) {
			return;
		}
		
		// let the user decide what should be updated automatically
		final AttributeValueModifierSetAdaptionDialog dialog = 
				new AttributeValueModifierSetAdaptionDialog(new Shell(), "AttributeValueModifierSet changed", null,
				"The following items contain the same list of AttributeValueModifierSets than"
						+ " the item you just changed. Please select the ones you want to change as well.", MessageDialog.QUESTION, new String[]{"OK", "Cancel"}, 0, matches);
		dialog.open();
		if(dialog.getReturnCode() != Dialog.OK || dialog.getSelectedItems().isEmpty()) {
			return;
		}
		
		// create a command that will be used to update the items chosen by the user
		final CompoundCommand compoundCommand = new CompoundCommand() {
			@Override
			public void execute() {
				removeContentAdapter();
				super.execute();
				addContentAdapter();
			}
			@Override
			public void redo() {
				removeContentAdapter();
				super.redo();
				addContentAdapter();
			}
			@Override
			public void undo() {
				removeContentAdapter();
				super.undo();
				addContentAdapter();
				
			}
			// remove the child content adapter before executing/undoing/redoing
			// the command so that it will not be triggered again endlessly
			private void removeContentAdapter() {
				PamtramContentAdapter.getInstance().subAdapters.remove(
						PamtramContentAdapter.getInstance().attValModifierSetHandlerAdapter);
			}
			// re-add the child content adapter after executing/undoing/redoing the command
			private void addContentAdapter() {
				PamtramContentAdapter.getInstance().subAdapters.add(
						PamtramContentAdapter.getInstance().attValModifierSetHandlerAdapter);
			}
		};
		for (EObject item : dialog.getSelectedItems()) {
			Command command = null;
			switch (n.getEventType()) {
				case Notification.ADD:
					command = new AddCommand(
							PamtramContentAdapter.getInstance().getEditor().getEditingDomain(), (EList<?>) item.eGet(matches.get(item)), n.getNewValue());
					break;
				case Notification.REMOVE:
					command = new RemoveCommand(
							PamtramContentAdapter.getInstance().getEditor().getEditingDomain(), (EList<?>) item.eGet(matches.get(item)), n.getOldValue());
					break;
				default:
					continue;
			}
			compoundCommand.append(command);
		}
		
		// execute the command in another thread so that the command will be
		// executed only after the current command has finished (this results
		// in the correct undo/redo order)
		PamtramContentAdapter.getInstance().getEditor().getSite().getShell().getDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				PamtramContentAdapter.getInstance().getEditor().getEditingDomain().getCommandStack().execute(compoundCommand);
			}
		});
		
	}
	
	/**
	 * This dialog is presented to the user when he has changed a set of
	 * AttributeValueModifierSets. The user shall select one or more of
	 * other existing AttributeValueModifierSets that should be changed
	 * as well automatically.
	 * 
	 * @author mfreund
	 */
	private final class AttributeValueModifierSetAdaptionDialog extends
			MessageDialog {
		
		private ArrayList<EObject> selectedItems = new ArrayList<>();
		private final Map<EObject, EReference> matches;
		private Table table;

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
		public AttributeValueModifierSetAdaptionDialog(Shell parentShell,
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
			return selectedItems;
		}

		@Override
		protected Control createCustomArea(Composite parent) {
				
			// create a table that holds the paths to the AttributeValueModifierSets that
			// can be selected
			table = new Table(parent, SWT.MULTI | SWT.CHECK);
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
			table.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					TableItem item = (TableItem) e.item;
					if(item.getChecked()) {
						selectedItems.add((EObject) item.getData());
					} else {
						selectedItems.remove(item.getData());
					}
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
				}
			});
			
			objectColumn.pack();
			table.pack();
			
			return table;
		}
	}
}
