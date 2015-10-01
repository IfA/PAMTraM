package pamtram.contentprovider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

import pamtram.SourceSectionModel;
import pamtram.metamodel.SourceSectionClass;

/**
 * A content provider for a viewer that displays the {@link SourceSectionModel SourceSectionModels} and the
 * contained {@link SourceSectionClass SourceSectionClasses}.
 * 
 * @author mfreund
 */
public class SourceSectionContentProvider extends AdapterFactoryContentProvider {
	public SourceSectionContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object[] getElements(Object object) {
		if(object instanceof EList<?> && ((EList<?>) object).toArray() instanceof SourceSectionModel[]) {
			return ((EList<?>) object).toArray();
		}
		return super.getElements(object);
	}
}