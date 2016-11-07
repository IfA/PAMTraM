package pamtram.contentprovider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

import pamtram.ConditionModel;
import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.condition.ComplexCondition;

/**
 * A content provider for a viewer that displays the {@link ConditionModel ConditionModels} and the
 * contained {@link ComplexCondition conditions}.
 *
 * @author mfreund
 */
public class ConditionContentProvider extends AdapterFactoryContentProvider implements IFeatureValidator {
	public ConditionContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object[] getElements(Object object) {
		if(object instanceof PAMTraM) {
			return ((PAMTraM) object).getConditionModel().toArray();
		}
		return super.getElements(object);
	}

	@Override
	public boolean isValidFeature(EStructuralFeature feature) {

		if(feature.equals(PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTION_MODEL) ||
				feature.equals(PamtramPackage.Literals.PAM_TRA_M__MAPPING_MODEL) ||
				feature.equals(PamtramPackage.Literals.PAM_TRA_M__TARGET_SECTION_MODEL)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_SOURCE_SECTION_MODEL)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_TARGET_SECTION_MODEL)) {
			return false;
		}

		return true;
	}
}