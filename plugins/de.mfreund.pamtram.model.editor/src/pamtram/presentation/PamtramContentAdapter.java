package pamtram.presentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.EcorePackage;
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
import pamtram.NamedElement;
import pamtram.PamtramPackage;
import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingSourceElementType;
import pamtram.mapping.AttributeValueModifier;
import pamtram.mapping.AttributeValueModifierSet;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.StringAppender;
import pamtram.mapping.StringPrepender;
import pamtram.mapping.SubstringReplacer;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.AttributeValueConstraint;
import pamtram.metamodel.Class;
import pamtram.metamodel.ContainmentReference;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.Reference;

/**
 * A singleton content adapter that listens for changes in a pamtram instance
 * and tries to automatically determine attribute values or reference
 * targets based on the changed object.
 * 
 * @author mfreund
 */
public class PamtramContentAdapter extends EContentAdapter {
	
	// The single instance.
	private static PamtramContentAdapter INSTANCE = null;
	
	// The editor that this content adapter works on.
	private PamtramEditor editor = null;
	
	public PamtramEditor getEditor() {
		return editor;
	}
	
	/**
	 * This initializes the content adapter by setting the
	 * editor that it is associated with.
	 * 
	 * @param editor The editor that this adapter works on.
	 * @return true if the content adapter was initialized correctly, false 
	 * if it was already initialized
	 */
	public boolean init(PamtramEditor editor) {
		if(PamtramContentAdapter.getInstance().editor != null) {
			return false;
		}
		PamtramContentAdapter.getInstance().editor = editor;
		return true;
	}
	
	public static PamtramContentAdapter getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new PamtramContentAdapter();
		}
		return INSTANCE;
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

	/**
	 * A list of EContentAdapters that act as children of this adapter
	 * and will be notified of any changes when this adapter is notified. 
	 * With this structure, a better separation should be possible but we can
	 * still manage to work with one single content adapter for everything.
	 */
	ArrayList<EContentAdapter> subAdapters =
			new ArrayList<>();
	
	private PamtramContentAdapter() {

		// populate the list of child content adapters
		subAdapters.add(nameSettingAdapter);
		subAdapters.add(attValModifierSetHandlerAdapter);
		
	}
	
	@Override
	public void notifyChanged(Notification notification) {
		
		// notify every child adapter
		for (EContentAdapter eContentAdapter : subAdapters) {
			eContentAdapter.notifyChanged(notification);
		}
	}
	
	/**
	 * A content adapter that will automatically set/change names of 
	 * elements when an important structural feature changes.
	 */
	final EContentAdapter nameSettingAdapter = 
			new EContentAdapter() {
		
		@Override
		public void notifyChanged(Notification n) {
			super.notifyChanged(n);
			
			if(n.getEventType() == Notification.RESOLVE) {
				return;
			}
			
			// find out the type of the notifier
			Object notifier = n.getNotifier();
			
			// handle notifications by notifier type
			if(notifier instanceof Reference) {
				handleReferenceNotification(n);
			} else if(notifier instanceof pamtram.metamodel.Class) {
				handleClassNotification(n);
			} else if(notifier instanceof Attribute) {
				handleAttributeNotification(n);
			} else if(notifier instanceof AttributeValueConstraint) {
				handleAttributeValueConstraintNotification(n);
			} else if(notifier instanceof Mapping) {
				handleMappingNotification(n);
			} else if(notifier instanceof MappingHintGroupType) {
				handleMappingHintGroupTypeNotification(n);
			} else if(notifier instanceof AttributeMapping) {
				handleAttributeMappingNotification(n);
			} else if(notifier instanceof AttributeMappingSourceElementType) {
				handleAttributeMappingSourceElementTypeNotification(n);
			} else if(notifier instanceof AttributeValueModifier) {
				handleAttributeValueModifierNotification(n);
			} else if(notifier instanceof GlobalAttribute) {
				handleGlobalAttributeNotification(n);
			} else if(notifier instanceof MappingInstanceSelector) {
				handleMappingInstanceSelectorNotification(n);
			}
			
		}
	};
	
	/**
	 * A content adapter that will present a dialog to the user when
	 * he changes a set of AttributeValueModifierSets referenced by an
	 * element. The user will be asked if other elements referencing
	 * a similar set should also be updated automatically.
	 */
	final EContentAdapter attValModifierSetHandlerAdapter = 
			new EContentAdapter() {
		
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
	};


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
				PamtramContentAdapter.INSTANCE.subAdapters.remove(
						PamtramContentAdapter.INSTANCE.attValModifierSetHandlerAdapter);
			}
			// re-add the child content adapter after executing/undoing/redoing the command
			private void addContentAdapter() {
				PamtramContentAdapter.INSTANCE.subAdapters.add(
						PamtramContentAdapter.INSTANCE.attValModifierSetHandlerAdapter);
			}
		};
		for (EObject item : dialog.getSelectedItems()) {
			Command command = null;
			switch (n.getEventType()) {
				case Notification.ADD:
					command = new AddCommand(
							PamtramContentAdapter.INSTANCE.editor.getEditingDomain(), (EList<?>) item.eGet(matches.get(item)), n.getNewValue());
					break;
				case Notification.REMOVE:
					command = new RemoveCommand(
							PamtramContentAdapter.INSTANCE.editor.getEditingDomain(), (EList<?>) item.eGet(matches.get(item)), n.getOldValue());
					break;
				default:
					continue;
			}
			compoundCommand.append(command);
		}
		
		// execute the command in another thread so that the command will be
		// executed only after the current command has finished (this results
		// in the correct undo/redo order)
		editor.getSite().getShell().getDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				editor.getEditingDomain().getCommandStack().execute(compoundCommand);
			}
		});
		
	}

	// A ContainmentReference has issued a notification.
	private void handleReferenceNotification(Notification n) {
		
		// the notifying reference
		Reference ref = (Reference) n.getNotifier();
		
	    if (n.getFeature() == MetamodelPackage.Literals.SOURCE_SECTION_CONTAINMENT_REFERENCE__VALUE ||
	    		n.getFeature() == MetamodelPackage.Literals.TARGET_SECTION_CONTAINMENT_REFERENCE__VALUE ||
	    		n.getFeature() == MetamodelPackage.Literals.META_MODEL_SECTION_REFERENCE__VALUE ||
	    		n.getFeature() == MetamodelPackage.Literals.TARGET_SECTION_NON_CONTAINMENT_REFERENCE__VALUE){
	    	
			if(n.getEventType() == Notification.ADD) {
				
				if(ref.getEReference() != null) {
					// set the type of the reference as default value for the eClass reference
					((pamtram.metamodel.Class) n.getNewValue()).
							setEClass(ref.getEReference().getEReferenceType());
				}
			}
	    } else if (n.getFeature() == MetamodelPackage.Literals.REFERENCE__EREFERENCE) {
	    	// if the name of the reference has not been changed by the user, set it based on its eReference
	    	setNameDerived(ref, n);
	    }
	}
	
	// A Class has issued a notification.
	private void handleClassNotification(Notification n) {
		
		if(n.getEventType() == Notification.ADD) {
		
		    if (n.getFeature() == MetamodelPackage.Literals.SOURCE_SECTION_CLASS__REFERENCES ||
		    		n.getFeature() == MetamodelPackage.Literals.TARGET_SECTION_CLASS__REFERENCES){
	    		if(n.getNewValue() instanceof ContainmentReference) {
	    			// the notifying class
	    			pamtram.metamodel.Class c = (Class) n.getNotifier();
	    			
	    			// the created containment reference
	    			ContainmentReference ref = (ContainmentReference) n.getNewValue();
	    			
	    			if(! c.getEClass().getEAllContainments().isEmpty()) {
	    				// set the first containment reference type of the class as default value for 
	    				// the eReference reference
	    				ref.setEReference(c.getEClass().getEAllContainments().get(0));
	    			}
	    		}
	    	}
		} else if(n.getEventType() == Notification.SET) {
			
		    if (n.getFeature() == MetamodelPackage.Literals.CLASS__ECLASS) {
		    	setNameDerived((pamtram.metamodel.Class) n.getNotifier(), n);
		    }
		}
	}
	
	// An Attribute has issued a notification.
	private void handleAttributeNotification(Notification n) {
		
		if(n.getEventType() == Notification.SET) {
		
			if (n.getFeature() == MetamodelPackage.Literals.SOURCE_SECTION_ATTRIBUTE__ATTRIBUTE ||
					n.getFeature() == MetamodelPackage.Literals.ACTUAL_ATTRIBUTE__ATTRIBUTE) {
				setNameDerived((Attribute) n.getNotifier(), n);
		    }
		}
	}
	
	// An Attribute Value Constraint has issued a notification.
	private void handleAttributeValueConstraintNotification(Notification n) {
	
		if(n.getEventType() == Notification.SET) {
			
			if(n.getFeature() == MetamodelPackage.Literals.ATTRIBUTE_VALUE_CONSTRAINT__VALUE) {
				setNameDerived((AttributeValueConstraint) n.getNotifier(), n);
			}
		}
	}
	
	// A Mapping has issued a notification.
	private void handleMappingNotification(Notification n) {
		
		if(n.getEventType() == Notification.SET) {
			
			if(n.getFeature() == MappingPackage.Literals.MAPPING_TYPE__SOURCE_MM_SECTION) {
				setNameDerived((Mapping) n.getNotifier(), n, "", "Mapping");
			}
		}
	}
	
	// A Mapping Hint Group or an Exported Mapping Hint Group has issued a notification.
	private void handleMappingHintGroupTypeNotification(Notification n) {
		
		if(n.getEventType() == Notification.SET) {
			
			if(n.getFeature() == MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__TARGET_MM_SECTION) {
				setNameDerived((MappingHintGroupType) n.getNotifier(), n);
			}
		}
	}
	
	// An Attribute Mapping has issued a notification.
	private void handleAttributeMappingNotification(Notification n) {
		
		if(n.getEventType() == Notification.SET) {
			
			if(n.getFeature() == MappingPackage.Literals.ATTRIBUTE_MAPPING__TARGET) {
				setNameDerived((AttributeMapping) n.getNotifier(), n, "", "Mapping");
			}
		}
	}
	
	// An Attribute Mapping Source Element Type has issued a notification.
	private void handleAttributeMappingSourceElementTypeNotification(
			Notification n) {
		
		if(n.getEventType() == Notification.SET) {
			
			if(n.getFeature() == MappingPackage.Literals.ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__SOURCE) {
				setNameDerived((AttributeMappingSourceElementType) n.getNotifier(), n);
			}
		}
	}
	
	// An Attribute Value Modifier has issued a notification.
	private void handleAttributeValueModifierNotification(Notification n) {
	
		// the notifying attribute value modifier
		AttributeValueModifier mod = (AttributeValueModifier) n.getNotifier();
		
		// the parent attribute value modifier set
		AttributeValueModifierSet set = (AttributeValueModifierSet) mod.eContainer();
		
		if(n.getEventType() == Notification.SET) {
			
			if(mod instanceof SubstringReplacer) {
				SubstringReplacer rep = (SubstringReplacer) mod;
				if(n.getFeature() == MappingPackage.Literals.SUBSTRING_REPLACER__REGEX) {
					String appendString = "_to_" + (rep.getReplacement() != null ? rep.getReplacement() : "");
					setNameDerived(mod, n, "", appendString);
					if(set.getModifier().size() == 1) {
						setNameDerived(set, n, "replace \"", "\"");
					}
				} else if(n.getFeature() == MappingPackage.Literals.SUBSTRING_REPLACER__REPLACEMENT) {
					String preprendString = (rep.getRegex() != null ? rep.getRegex() : "") + "_to_";
					setNameDerived(rep, n, preprendString, "");
				}
			} else if(mod instanceof StringPrepender && n.getFeature() == MappingPackage.Literals.STRING_PREPENDER__STRING) {
				setNameDerived(mod, n);
				if(set.getModifier().size() == 1) {
					setNameDerived(set, n, "prepend \"", "\"");
				}
			} else if(mod instanceof StringAppender && n.getFeature() == MappingPackage.Literals.STRING_APPENDER__STRING) {
				setNameDerived(mod, n);
				if(set.getModifier().size() == 1) {
					setNameDerived(set, n, "append \"", "\"");
				}
			}
		}
	
	}
	
	// A Global Attribute has issued a notification.
	private void handleGlobalAttributeNotification(Notification n) {
	
		if(n.getEventType() == Notification.SET) {
	
			if(n.getFeature() == MappingPackage.Literals.GLOBAL_ATTRIBUTE__SOURCE) {
				setNameDerived((GlobalAttribute) n.getNotifier(), n);
			}
		}
	}
	
	// A Mapping Instance Selector has issued a notification.
	private void handleMappingInstanceSelectorNotification(Notification n) {

		if(n.getEventType() == Notification.SET) {
			
			if(n.getFeature() == MappingPackage.Literals.MAPPING_INSTANCE_SELECTOR__AFFECTED_REFERENCE) {
				setNameDerived((MappingInstanceSelector) n.getNotifier(), n);
			}
		}
		
	}
	
	/**
	 * Set a (derived) string-based feature of an element based on another (original) feature that has changed.
	 * 
	 * The new value of the feature is composed of a prepended string, the new value of the original feature that
	 * is represented in the notification and an appended string.
	 * 
	 * The feature is only set, if the existing value of the feature is either 'null', empty, or matches the value
	 * that would have been set if this method would be called with a notification for the old value of the
	 * original feature.
	 * 
	 * @param object the element for which the feature shall be set
	 * @param derivedFeature the feature to set
	 * @param n the notification that shall be used to calculate the new value
	 * @param prependString a string that shall be prepended to the new value
	 * @param appendString a string that shall be appended to the new value
	 */
	private void setFeatureDerived(EObject object, EStructuralFeature derivedFeature, Notification n, String prependString, String appendString) {
	
//		EStructuralFeature derivedFeature = object.eClass().getEStructuralFeature(derivedFeatureId);
		
		// The derived feature must be of type EString...
		if(derivedFeature == null || !(derivedFeature.getEType().getName().equals("EString"))) {
			throw new RuntimeException("'derivedFeature' is not of type 'EString'...");
		}
		
		EStructuralFeature originalFeature = (EStructuralFeature) n.getFeature();
		
		// The original feature must either be of type EString or NamedElement...
		if(!(originalFeature.getEType().getName().equals("EString") || 
				PamtramPackage.eINSTANCE.getNamedElement().isSuperTypeOf((EClass) originalFeature.getEType()) ||
				EcorePackage.eINSTANCE.getENamedElement().isSuperTypeOf((EClass) originalFeature.getEType()))) {
			throw new RuntimeException("'originalFeature' is neither of type 'EString' nor of type 'NamedElement' or 'ENamedElement'...");
		}
		
		String currentDerivedFeatureValue = (String) object.eGet(derivedFeature);
		
		Object oldOriginalFeatureValue, newOriginalFeatureValue;
		// determine the old value of the original feature based on its type
		if((oldOriginalFeatureValue = n.getOldValue()) != null) {
			if(oldOriginalFeatureValue instanceof NamedElement) {
				oldOriginalFeatureValue = ((NamedElement) oldOriginalFeatureValue).getName();
			} else if(oldOriginalFeatureValue instanceof ENamedElement) {
				oldOriginalFeatureValue = ((ENamedElement) oldOriginalFeatureValue).getName();
			}
		} else {
			oldOriginalFeatureValue = "";
		}
		// determine the new value of the original feature based on its type
		if((newOriginalFeatureValue = n.getNewValue()) != null) {
			if(newOriginalFeatureValue instanceof NamedElement) {
				newOriginalFeatureValue = ((NamedElement) newOriginalFeatureValue).getName();
			} else if(newOriginalFeatureValue instanceof ENamedElement) {
				newOriginalFeatureValue = ((ENamedElement) newOriginalFeatureValue).getName();
			}
		} else {
			newOriginalFeatureValue = "";
		}
		
		// if the current value of the derived feature is empty or matches the old value
		// of the original feature, set it to the new value of the original feature
		if(isEmptyOrValue(currentDerivedFeatureValue, prependString + (String) oldOriginalFeatureValue + appendString)) {
			object.eSet(derivedFeature, prependString + newOriginalFeatureValue + appendString);
		}
	}
	
	/**
	 * Convenience method to set a string-based feature of an element based on another feature that has changed. 
	 * Equal to calling 'setFeatureDerived(object, derivedFeatureId, n, "", "")'.
	 * 
	 * @param object
	 * @param derivedFeature
	 * @param n
	 */
	@SuppressWarnings("unused")
	private void setFeatureDerived(EObject object, EStructuralFeature derivedFeature, Notification n) {
		setFeatureDerived(object, derivedFeature, n, "", "");
	}
	
	/**
	 * Convenience method to set the name of a named element based on another feature that has changed. 
	 * Equal to calling 'setFeatureDerived(object, PamtramPackage.NAMED_ELEMENT__NAME, n, "", "")'.
	 * 
	 * @param object the element for which the feature shall be set
	 * @param n the notification that shall be used to calculate the new value
	 */
	private void setNameDerived(EObject object, Notification n) {
		setFeatureDerived(object, PamtramPackage.Literals.NAMED_ELEMENT__NAME, n, "", "");
	}
	
	/**
	 * Convenience method to set the name of a named element based on another feature that has changed. 
	 * Equal to calling 'setFeatureDerived(object, PamtramPackage.NAMED_ELEMENT__NAME, 
	 * n, preprendString, appendString)'.
	 * 
	 * @param object the element for which the feature shall be set
	 * @param n the notification that shall be used to calculate the new value
	 * @param prependString a string that shall be prepended to the new value
	 * @param appendString a string that shall be appended to the new value
	 */
	private void setNameDerived(EObject object, Notification n, String prependString, String appendString) {
		setFeatureDerived(object, PamtramPackage.Literals.NAMED_ELEMENT__NAME, n, prependString, appendString);
	}
	
	/**
	 * Returns true, if 'stringToTest' is either 'null', empty or matches the
	 * given value.
	 * 
	 * @param stringToTest the string that shall be checked
	 * @param value the string that 'stringToTest' shall be checked against;
	 * if 'value' is 'null', no check is performed
	 * 
	 * @return true if 'stringToTest' is 'null', empty or matches 'value'; false otherwise
	 */
	private boolean isEmptyOrValue(String stringToTest, String value) {
		return (stringToTest == null || stringToTest.isEmpty() || (value != null && stringToTest.equals(value)));
	}
}
