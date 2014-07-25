package pamtram.presentation.listeners;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.dnd.TransferData;

import pamtram.SourceSectionModel;
import pamtram.mapping.AttributeMapping;
import pamtram.mapping.CardinalityMapping;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.SimpleAttributeMapping;
import pamtram.mapping.provider.CardinalityMappingItemProvider;
import pamtram.mapping.provider.MappingItemProvider;
import pamtram.mapping.provider.MappingItemProviderAdapterFactory;
import pamtram.mapping.provider.SimpleAttributeMappingItemProvider;
import pamtram.metamodel.MetaModelElement;

public class MappingDropListener extends ViewerDropAdapter {

	private final MappingItemProviderAdapterFactory mappingItemProviderFactory = 
				new MappingItemProviderAdapterFactory();
	
	public MappingDropListener(Viewer viewer) {
		super(viewer);
	}

	@Override
	public boolean performDrop(Object data) {
		
		// only instances of 'MetaModelElement' are covered by this listener
		if(!(data instanceof MetaModelElement)) {
			return false;
		}
		
		MetaModelElement mmElement = (MetaModelElement) data;
		
		DragSource dragSource;
		// determine if the drag started from the source or the target viewer
		if(mmElement.getContainingSection().eContainer() 
				instanceof SourceSectionModel) {
			dragSource = DragSource.SourceSectionViewer;
		} else {
			dragSource = DragSource.TargetSectionViewer;
		}
		
		ItemProviderAdapter itemProviderAdapter = null;
		EStructuralFeature feature = null;
		
		// initialize the item provider adapter and the feature 
		// based on the type of the drop target
		if(this.getCurrentTarget() instanceof Mapping) {
			itemProviderAdapter = new MappingItemProvider(mappingItemProviderFactory);
			feature = (dragSource == DragSource.SourceSectionViewer) ?
				 	MappingPackage.Literals.MAPPING_TYPE__SOURCE_MM_SECTION :
				 	MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__TARGET_MM_SECTION;
		} else if(this.getCurrentTarget() instanceof SimpleAttributeMapping) {
			itemProviderAdapter = new SimpleAttributeMappingItemProvider(mappingItemProviderFactory);
			feature = (dragSource == DragSource.SourceSectionViewer) ?
				 	MappingPackage.Literals.ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__SOURCE:
				 	MappingPackage.Literals.ATTRIBUTE_MAPPING__TARGET;
		} else if(this.getCurrentTarget() instanceof CardinalityMapping) {//TODO add ComplexAttributeMapping
			itemProviderAdapter = new CardinalityMappingItemProvider(mappingItemProviderFactory);
			feature = (dragSource == DragSource.SourceSectionViewer) ?
					MappingPackage.Literals.CARDINALITY_MAPPING__SOURCE:
				 	MappingPackage.Literals.CARDINALITY_MAPPING__TARGET;
		}
		
		if(itemProviderAdapter == null) {
			// the drop cannot be performed
			return false;
		}
		
		
		// try to drop the object onto the specified features
		return dropIfValidChoice(
					mmElement, 
					(EObject) this.getCurrentTarget(), 
					feature,	
					itemProviderAdapter);
			
	}

	@Override
	public boolean validateDrop(Object target, int operation,
			TransferData transferType) {
		if(target instanceof Mapping || target instanceof AttributeMapping ||
				target instanceof CardinalityMapping) {
			return true;
		} else {
			return false;
		}
	}
	
	/** tries to set an object to be dropped as value for a certain structural feature of a drop target;
	 * evaluates the 'getChoiceOfValues' function of the target's item property descriptor to
	 * check if the object to be dropped is a valid option
	 * 
	 * @param data the object to be dropped
	 * @param target the object that data has been dropped onto
	 * @param feature the target's structural feature that shall be used 
	 * 				to perform the drop
	 * @param itemProviderAdapter an item provider adapter for the target that can be used
	 * 				to get the property descriptor for the structural feature
	 * @return true if the drop was successful, false otherwise 
	 */
	@SuppressWarnings("unchecked")
	private boolean dropIfValidChoice(EObject data, EObject target, 
			EStructuralFeature feature, ItemProviderAdapter itemProviderAdapter) {
		
		// get the property descriptor for the feature
		IItemPropertyDescriptor itemPropertyDescriptor = itemProviderAdapter.getPropertyDescriptor(
				target, feature);
		
		// check if the dropped object is a valid choice for the feature
		if(itemPropertyDescriptor.getChoiceOfValues(target).contains(data)) {
			
			// if the feature has a multiplicity greater than 1, add the object to the values
			// if it is not already contained
			if(feature.isMany()) {
				if(!((EList<EObject>) target.eGet(feature)).contains(data)) {
					((EList<EObject>) target.eGet(feature)).add(data);
					return true;
				} else {
					return false;
				}
			// if the feature has a multiplicity of 1, set the new object as value
			// if not other value has been set before
			} else {
				if(target.eGet(feature) == null) {
					target.eSet(feature, data);
					return true;
				} else {
					return false;
				}
			}
		}
		
		return false;
	}

	private static enum DragSource {
		SourceSectionViewer, TargetSectionViewer
	};
}
