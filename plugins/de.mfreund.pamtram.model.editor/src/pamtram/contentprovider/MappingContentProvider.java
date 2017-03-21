package pamtram.contentprovider;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

import pamtram.MappingModel;
import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.mapping.Mapping;

/**
 * A content provider for a viewer that displays the {@link MappingModel MappingModels} and the contained {@link Mapping
 * Mappings}.
 *
 * @author mfreund
 */
public class MappingContentProvider extends AdapterFactoryContentProvider implements IFeatureValidator {

	public MappingContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object[] getElements(Object object) {

		if (object instanceof PAMTraM) {
			return Stream
					.concat(((PAMTraM) object).getMappingModels().stream(),
							((PAMTraM) object).getSharedMappingModels().stream())
					.collect(Collectors.toList()).toArray();
		}
		return super.getElements(object);
	}

	/*
	 * extend the content provider in a way that no attribute value modifier sets but only mappings are returned as
	 * children of a mapping model
	 */
	@Override
	public Object[] getChildren(Object object) {

		if (object instanceof MappingModel) {
			List<Object> children = new ArrayList<>();
			if (((MappingModel) object).getLocalCondition() != null) {
				children.add(((MappingModel) object).getLocalCondition());
			}
			children.addAll(((MappingModel) object).getMappings());
			return children.toArray();
		}
		return super.getChildren(object);
	}

	@Override
	public boolean isValidFeature(EStructuralFeature feature) {

		if (feature.equals(PamtramPackage.Literals.MAPPING_MODEL__MODIFIER_SETS)
				|| feature.equals(PamtramPackage.Literals.MAPPING_MODEL__GLOBAL_VALUES)
				|| feature.equals(PamtramPackage.Literals.MAPPING_MODEL__GLOBAL_ATTRIBUTES)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTION_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__CONDITION_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__TARGET_SECTION_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_SOURCE_SECTION_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_TARGET_SECTION_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_CONDITION_MODELS)) {
			return false;
		}

		return true;
	}
}