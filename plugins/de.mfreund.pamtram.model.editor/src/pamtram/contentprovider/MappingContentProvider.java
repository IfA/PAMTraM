package pamtram.contentprovider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

import pamtram.MappingModel;
import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.mapping.Mapping;

/**
 * A content provider for a viewer that displays the {@link MappingModel MappingModels} and the
 * contained {@link Mapping Mappings}.
 * 
 * @author mfreund
 */
public class MappingContentProvider extends AdapterFactoryContentProvider implements IFeatureValidator {
	public MappingContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object[] getElements(Object object) {
		if(object instanceof PAMTraM) {
			return ((PAMTraM) object).getMappingModel().toArray();
		}
		return super.getElements(object);
	}

	/* extend the content provider in a way that no attribute value modifier sets 
	 * but only mappings are returned as children of a mapping model
	 */
	@Override
	public Object[] getChildren(Object object) {
		if(object instanceof MappingModel) {
			return ((MappingModel) object).getMapping().toArray();
		}
		return super.getChildren(object);
	}
	
	@Override
	public boolean isValidFeature(EStructuralFeature feature) {

		if(feature.equals(PamtramPackage.Literals.MAPPING_MODEL__MODIFIER_SETS) ||
				feature.equals(PamtramPackage.Literals.MAPPING_MODEL__GLOBAL_VALUES) ||
				feature.equals(PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTION_MODEL) ||
				feature.equals(PamtramPackage.Literals.PAM_TRA_M__CONDITION_MODEL) ||
				feature.equals(PamtramPackage.Literals.PAM_TRA_M__TARGET_SECTION_MODEL)) {
			return false;
		}
		
		return true;
	}
}