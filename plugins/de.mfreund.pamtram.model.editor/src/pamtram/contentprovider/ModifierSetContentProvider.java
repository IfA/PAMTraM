package pamtram.contentprovider;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

import pamtram.FixedValue;
import pamtram.MappingModel;
import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.mapping.modifier.ValueModifierSet;

/**
 * A content provider for a viewer that displays the {@link MappingModel MappingModels} and the contained
 * {@link ValueModifierSet ValueModifierSets} as well as the {@link FixedValue GlobalValues}.
 *
 * @author mfreund
 */
public class ModifierSetContentProvider extends AdapterFactoryContentProvider implements IFeatureValidator {

	public ModifierSetContentProvider(AdapterFactory adapterFactory) {
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
	 * extend the content provider in a way that no mappings but only attribute value modifier sets are returned as
	 * children of a mapping model
	 */
	@Override
	public Object[] getChildren(Object object) {

		if (object instanceof MappingModel) {
			List<Object> elements = new ArrayList<>();
			elements.addAll(((MappingModel) object).getModifierSets());
			elements.addAll(((MappingModel) object).getGlobalValues());
			elements.addAll(((MappingModel) object).getGlobalAttributes());
			return elements.toArray();
		}
		return super.getElements(object);
	}

	@Override
	public boolean isValidFeature(EStructuralFeature feature) {

		if (feature.equals(PamtramPackage.Literals.MAPPING_MODEL__MAPPINGS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTION_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__CONDITION_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__TARGET_SECTION_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_SOURCE_SECTION_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_TARGET_SECTION_MODELS)) {
			return false;
		}

		return true;
	}
}