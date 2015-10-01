package pamtram.contentprovider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

import pamtram.PAMTraM;
import pamtram.TargetSectionModel;
import pamtram.metamodel.TargetSectionClass;

/**
 * A content provider for a viewer that displays the {@link TargetSectionModel TargetSectionModels} and the
 * contained {@link TargetSectionClass TargetSectionClasses}.
 * 
 * @author mfreund
 */
public class TargetSectionContentProvider extends AdapterFactoryContentProvider {
	public TargetSectionContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object[] getElements(Object object) {
		if(object instanceof PAMTraM) {
			return ((PAMTraM) object).getTargetSectionModel().toArray();
		}
		return super.getElements(object);
	}

	/* extend the content provider in a way that no library elements 
	 * but only classic target section are returned as children of a mapping model
	 */
	@Override
	public Object[] getChildren(Object object) {
		if(object instanceof TargetSectionModel) {
			return ((TargetSectionModel) object).getMetaModelSections().toArray();
		}
		return super.getElements(object);
	}
}