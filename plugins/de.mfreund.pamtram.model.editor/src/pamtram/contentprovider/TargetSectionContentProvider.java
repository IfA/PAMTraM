package pamtram.contentprovider;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.TargetSectionModel;
import pamtram.structure.target.TargetSectionClass;

/**
 * A content provider for a viewer that displays the {@link TargetSectionModel TargetSectionModels} and the contained
 * {@link TargetSectionClass TargetSectionClasses}.
 *
 * @author mfreund
 */
public class TargetSectionContentProvider extends AdapterFactoryContentProvider implements IFeatureValidator {

	public TargetSectionContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object[] getElements(Object object) {

		if (object instanceof PAMTraM) {
			return Stream
					.concat(((PAMTraM) object).getTargetSectionModel().stream(),
							((PAMTraM) object).getSharedTargetSectionModel().stream())
					.collect(Collectors.toList()).toArray();
		}
		return super.getElements(object);
	}

	/*
	 * extend the content provider in a way that no library elements but only classic target section are returned as
	 * children of a mapping model
	 */
	@Override
	public Object[] getChildren(Object object) {

		if (object instanceof TargetSectionModel) {
			return ((TargetSectionModel) object).getMetaModelSections().toArray();
		}
		return super.getElements(object);
	}

	@Override
	public boolean isValidFeature(EStructuralFeature feature) {

		if (feature.equals(PamtramPackage.Literals.TARGET_SECTION_MODEL__LIBRARY_ELEMENTS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTION_MODEL)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_SOURCE_SECTION_MODEL)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__CONDITION_MODEL)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__MAPPING_MODEL)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_CONDITION_MODEL)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_MAPPING_MODEL)) {
			return false;
		}

		return true;
	}
}