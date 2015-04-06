package pamtram.presentation;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import pamtram.DeactivatableElement;

public class MappingViewerLabelProvider extends AdapterFactoryLabelProvider
		implements IColorProvider {

	public MappingViewerLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Color getForeground(Object object) {
		
		EObject element = (EObject) object;

		/*
		 * If the object itself or any object higher in the containment hierarchy
		 * is deactivated, gray out the object.
		 */
		do {
			if(element instanceof DeactivatableElement &&
					((DeactivatableElement) element).isDeactivated()) {
				return Display.getCurrent().getSystemColor(SWT.COLOR_GRAY);
			} else {
				element = element.eContainer();
			}
			
		} while (element != null);
		
		return super.getBackground(object);
	}
	
}
