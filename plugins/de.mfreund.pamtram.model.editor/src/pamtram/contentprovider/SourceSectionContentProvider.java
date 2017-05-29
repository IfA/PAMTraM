package pamtram.contentprovider;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.SourceSectionModel;
import pamtram.structure.source.SourceSectionClass;

/**
 * A content provider for a viewer that displays the {@link SourceSectionModel
 * SourceSectionModels} and the contained {@link SourceSectionClass
 * SourceSectionClasses}.
 *
 * @author mfreund
 */
public class SourceSectionContentProvider extends AdapterFactoryContentProvider implements IFeatureValidator {

	/**
	 * This creates an instance.
	 *
	 * @param adapterFactory
	 */
	public SourceSectionContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object[] getElements(Object object) {

		if (object instanceof PAMTraM) {
			return Stream
					.concat(((PAMTraM) object).getSourceSectionModels().stream(),
							((PAMTraM) object).getSharedSourceSectionModels().stream())
					.collect(Collectors.toList()).toArray();
		}
		return super.getElements(object);
	}

	@Override
	public boolean isValidFeature(EStructuralFeature feature) {

		if (feature.equals(PamtramPackage.Literals.PAM_TRA_M__MAPPING_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_MAPPING_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__TARGET_SECTION_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_TARGET_SECTION_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__CONDITION_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_CONDITION_MODELS)) {
			return false;
		}

		return true;
	}
}