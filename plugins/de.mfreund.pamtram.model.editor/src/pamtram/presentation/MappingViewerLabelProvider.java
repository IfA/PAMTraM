package pamtram.presentation;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import pamtram.DeactivatableElement;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupType;

/**
 * This is a special LabelProvider that takes {@link DeactivatableElement}s into account
 * and adjusts the icon and the foreground color if {@link DeactivatableElement#isDeactivated()}
 * returns '<b><em>true</em></b>'.
 * 
 * @author mfreund
 *
 */
public class MappingViewerLabelProvider extends AdapterFactoryLabelProvider
		implements IColorProvider {

	public MappingViewerLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 *  This implementation checks if the element itself or one of its parents
	 *  is of type {@link DeactivatableElement} and {@link DeactivatableElement#isDeactivated()}
	 *  returns '<b><em>true</em></b>'. If this is the case, a color that represents a
	 *  'grayed out' status is returned. Otherwise, the default color is returned.
	 */
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
		
		return super.getForeground(object);
	}
	
	/**
	 * This returns a decorated image for {@link Mapping}s that contain at least
	 * one {@link InstantiableMappingHintGroup} for that {@link InstantiableMappingHintGroup#isDeactivated()}
	 * returns '<em><b>true</b></em>'. Thus, the user is notified that there are 
	 * deactivated child elements.
	 * 
	 * In all other cases, this returns 'super.getImage(Object)'.
	 */
	@Override
	public Image getImage(Object object) {
		Image image = super.getImage(object);
		
		boolean deactivated = false;
		if(object instanceof Mapping) {
			/*
			 * If at least one of the hint groups in a mapping is deactivated,
			 * show an overlay icon to illustrate this to the user.
			 */
			for (MappingHintGroupType hintGroup : ((Mapping) object).getMappingHintGroups()) {
				if(hintGroup instanceof InstantiableMappingHintGroup &&
						((InstantiableMappingHintGroup) hintGroup).isDeactivated()) {
					deactivated = true;
					break;
				}
			}
		}
		if(deactivated) {
			ImageDescriptor warningOverlay = 
					PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_DEC_FIELD_WARNING);
			DecorationOverlayIcon decoratedImage =
					new DecorationOverlayIcon(image, warningOverlay, IDecoration.TOP_LEFT);
			return decoratedImage.createImage();
		} else {
			return image;
		}
	}
	
}
