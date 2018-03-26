/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package pamtram.presentation;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import pamtram.DeactivatableElement;

/**
 * This is a special LabelProvider that takes {@link DeactivatableElement}s into account
 * and adjusts the foreground color if {@link DeactivatableElement#isDeactivated()}
 * returns '<b><em>true</em></b>'.
 *
 * @author mfreund
 *
 */
public class MappingViewerLabelProvider extends AdapterFactoryLabelProvider
implements IColorProvider {

	/**
	 * This creates an instance.
	 *
	 * @param adapterFactory
	 *            An adapter factory that yield adapters that implement the various item label provider interfaces.
	 */
	public MappingViewerLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This implementation checks if the element itself or one of its parents is of type {@link DeactivatableElement}
	 * and {@link DeactivatableElement#isDeactivated()} returns '<b><em>true</em></b>'. If this is the case, a color
	 * that represents a 'grayed out' status is returned. Otherwise, the default color is returned.
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

}
