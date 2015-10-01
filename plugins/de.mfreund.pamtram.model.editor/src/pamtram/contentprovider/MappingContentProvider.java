package pamtram.contentprovider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

import pamtram.MappingModel;
import pamtram.mapping.Mapping;

/**
 * A content provider for a viewer that displays the {@link MappingModel MappingModels} and the
 * contained {@link Mapping Mappings}.
 * 
 * @author mfreund
 */
public class MappingContentProvider extends AdapterFactoryContentProvider {
	public MappingContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object[] getElements(Object object) {
		if(object instanceof EList<?> && ((EList<?>) object).toArray() instanceof MappingModel[]) {
			return ((EList<?>) object).toArray();
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
}