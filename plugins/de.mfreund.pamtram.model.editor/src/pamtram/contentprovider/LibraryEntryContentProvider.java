package pamtram.contentprovider;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.TargetSectionModel;
import pamtram.structure.library.LibraryEntry;

/**
 * A content provider for a viewer that displays the {@link TargetSectionModel
 * TargetSectionModels} and the contained {@link LibraryEntry LibraryEntries}.
 *
 * @author mfreund
 */
public class LibraryEntryContentProvider extends AdapterFactoryContentProvider implements IFeatureValidator {

	/**
	 * This creates an instance.
	 *
	 * @param adapterFactory
	 */
	public LibraryEntryContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object[] getElements(Object object) {

		if (object instanceof PAMTraM) {
			return Stream
					.concat(((PAMTraM) object).getTargetSectionModels().stream(),
							((PAMTraM) object).getSharedTargetSectionModels().stream())
					.collect(Collectors.toList()).toArray();
		}
		return super.getElements(object);
	}

	/*
	 * extend the content provider in a way that only library elements but no
	 * classic target section are returned as children of a mapping model
	 */
	@Override
	public Object[] getChildren(Object object) {

		if (object instanceof TargetSectionModel) {
			return ((TargetSectionModel) object).getLibraryElements().toArray();
		}
		return super.getElements(object);
	}

	@Override
	public boolean isValidFeature(EStructuralFeature feature) {

		if (feature.equals(PamtramPackage.Literals.SECTION_MODEL__SECTIONS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTION_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__CONDITION_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__MAPPING_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_SOURCE_SECTION_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_MAPPING_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_CONDITION_MODELS)) {
			return false;
		}

		return true;
	}
}