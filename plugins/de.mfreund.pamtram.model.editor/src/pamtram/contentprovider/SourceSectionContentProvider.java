package pamtram.contentprovider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.SourceSectionModel;
import pamtram.metamodel.SourceSectionClass;

/**
 * A content provider for a viewer that displays the {@link SourceSectionModel SourceSectionModels} and the
 * contained {@link SourceSectionClass SourceSectionClasses}.
 * 
 * @author mfreund
 */
public class SourceSectionContentProvider extends AdapterFactoryContentProvider implements IFeatureValidator {
	public SourceSectionContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object[] getElements(Object object) {
		if(object instanceof PAMTraM) {
			return ((PAMTraM) object).getSourceSectionModel().toArray();
		}
		return super.getElements(object);
	}
	
	@Override
	public boolean isValidFeature(EStructuralFeature feature) {

		if(feature.equals(PamtramPackage.Literals.PAM_TRA_M__MAPPING_MODEL) ||
				feature.equals(PamtramPackage.Literals.PAM_TRA_M__TARGET_SECTION_MODEL) ||
				feature.equals(PamtramPackage.Literals.PAM_TRA_M__CONDITION_MODEL)) {
			return false;
		}
		
		return true;
	}
}