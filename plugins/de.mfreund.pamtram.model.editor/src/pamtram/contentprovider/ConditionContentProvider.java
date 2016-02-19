package pamtram.contentprovider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

import pamtram.ConditionModel;
import pamtram.PAMTraM;
import pamtram.condition.ComplexCondition;

/**
 * A content provider for a viewer that displays the {@link ConditionModel ConditionModels} and the
 * contained {@link ComplexCondition conditions}.
 * 
 * @author mfreund
 */
public class ConditionContentProvider extends AdapterFactoryContentProvider {
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
}