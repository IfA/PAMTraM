package pamtram.contentprovider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

import pamtram.PAMTraM;
import pamtram.TargetSectionModel;
import pamtram.metamodel.LibraryEntry;

/**
 * A content provider for a viewer that displays the {@link TargetSectionModel TargetSectionModels} and the
 * contained {@link LibraryEntry LibraryEntries}.
 * 
 * @author mfreund
 */
public class LibraryEntryContentProvider extends AdapterFactoryContentProvider {
	public LibraryEntryContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object[] getElements(Object object) {
		if(object instanceof PAMTraM) {
			return ((PAMTraM) object).getTargetSectionModel().toArray();
		}
		return super.getElements(object);
	}

	/* extend the content provider in a way that only library elements 
	 * but no classic target section are returned as children of a mapping model
	 */
	@Override
	public Object[] getChildren(Object object) {
		if(object instanceof TargetSectionModel) {
			return ((TargetSectionModel) object).getLibraryElements().toArray();
		}
		return super.getElements(object);
	}
}