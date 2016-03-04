package pamtram.mapping.commands;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DragAndDropFeedback;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.dnd.DND;

/**
 * An AddCommand that provides DragAndDropFeedback and can thus be returned by
 * e.g. the 'createDragAndDropCommand' function in EMF item providers.
 * This will replace all objects in the <em>originalCollection</em> by those in the
 * <em>newCollection</em> when the drop is executed. Thereby, shared features
 * (that are provided by both source and target eClasses) are copied and
 * references to elements from the <em>originalCollection</em> are redirected
 * to the <em>newCollection</em>.
 */
public class ReplacingDragAndDropAddCommand extends AddCommand implements
		DragAndDropFeedback {
	
	private ArrayList<EObject> originalCollection;
	
	private ArrayList<EObject> newCollection;
	
	private EObject oldOwner;
	
	private EStructuralFeature oldFeature;

	public ReplacingDragAndDropAddCommand(EditingDomain domain, EObject owner,
			EStructuralFeature feature, Collection<EObject> originalCollection, Collection<EObject> newCollection) {
		super(domain, owner, feature, newCollection);

		this.originalCollection = new ArrayList<EObject>(originalCollection);
		this.newCollection = new ArrayList<EObject>(newCollection);
	}
	
	@Override
	public void doExecute() {
		
		for (int i = 0; i < originalCollection.size(); i++) {
			
			if(oldOwner == null) {
				oldOwner = originalCollection.get(i).eContainer();
				oldFeature = originalCollection.get(i).eContainingFeature();
			}
			
			if(!(originalCollection.get(i).equals(newCollection.get(i)))) {
				
				// copy all features
				for (EStructuralFeature eStructuralFeature : originalCollection.get(i).eClass().getEAllStructuralFeatures()) {
					if(newCollection.get(i).eClass().getEAllStructuralFeatures().contains(eStructuralFeature)) {
						newCollection.get(i).eSet(eStructuralFeature, originalCollection.get(i).eGet(eStructuralFeature));						
					}
				}
				// replace references to the object
				Collection<Setting> refs = EcoreUtil.UsageCrossReferencer.find(originalCollection.get(i), originalCollection.get(i).eResource().getResourceSet());
				for (Setting ref : refs) {
					if(ref.getEObject() != null && ref.getEStructuralFeature().getEType().isInstance(newCollection.get(i))) {
						EcoreUtil.replace(ref, originalCollection.get(i), newCollection.get(i));						
					}
				}
				// delete the old object
				EcoreUtil.delete(originalCollection.get(i));
			}
		}
		
		collection = newCollection;
		
		super.doExecute();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void doUndo() {
		
		for (int i = 0; i < originalCollection.size(); i++) {
			if(!(originalCollection.get(i).equals(newCollection.get(i)))) {
				
				// copy all features
				for (EStructuralFeature eStructuralFeature : newCollection.get(i).eClass().getEAllStructuralFeatures()) {
					if(originalCollection.get(i).eClass().getEAllStructuralFeatures().contains(eStructuralFeature)) {
						originalCollection.get(i).eSet(eStructuralFeature, newCollection.get(i).eGet(eStructuralFeature));
					}
				}
				// replace references to the object
				Collection<Setting> refs = EcoreUtil.UsageCrossReferencer.find(newCollection.get(i), newCollection.get(i).eResource().getResourceSet());
				for (Setting ref : refs) {
					if(ref.getEObject() != null && ref.getEStructuralFeature().getEType().isInstance(originalCollection.get(i))) {
						EcoreUtil.replace(ref, newCollection.get(i), originalCollection.get(i));						
					}
				}
				// delete the old object
				EcoreUtil.delete(newCollection.get(i));
				
			}
		}
		
		ArrayList<Object> currentValues = new ArrayList<>();
		currentValues.addAll((Collection<? extends Object>) oldOwner.eGet(oldFeature));
		currentValues.addAll(originalCollection);
		oldOwner.eSet(oldFeature, currentValues);
		
	}
	
	@Override
	public void doRedo() {

		for (int i = 0; i < originalCollection.size(); i++) {
			if(!(originalCollection.get(i).equals(newCollection.get(i)))) {
				
				// copy all features
				for (EStructuralFeature eStructuralFeature : originalCollection.get(i).eClass().getEAllStructuralFeatures()) {
					if(newCollection.get(i).eClass().getEAllStructuralFeatures().contains(eStructuralFeature)) {
						newCollection.get(i).eSet(eStructuralFeature, originalCollection.get(i).eGet(eStructuralFeature));						
					}
				}
				// replace references to the object
				Collection<Setting> refs = EcoreUtil.UsageCrossReferencer.find(originalCollection.get(i), originalCollection.get(i).eResource().getResourceSet());
				for (Setting ref : refs) {
					if(ref.getEObject() != null && ref.getEStructuralFeature().getEType().isInstance(newCollection.get(i))) {
						EcoreUtil.replace(ref, originalCollection.get(i), newCollection.get(i));						
					}
				}
				// delete the old object
				EcoreUtil.delete(originalCollection.get(i));
				
			}
		}

		super.doRedo();
	}

	@Override
	public boolean validate(Object owner, float location, int operations,
			int operation, Collection<?> collection) {
		return isExecutable;
	}

	@Override
	public int getFeedback() {
		return DND.FEEDBACK_SELECT;
	}

	@Override
	public int getOperation() {
		return DND.DROP_LINK;
	}

}
