/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.pamtram.ui.views;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import pamtram.PAMTraM;
import pamtram.PamtramPackage;

/**
 * Returns references to an element of a {@link PAMTraM} model and the
 * associated StructuralFeatures
 *
 */
public class PamtramReferencesContentProvider implements ITreeContentProvider {

	private EObject selectedEObject;

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	@Override
	public Object[] getChildren(Object element) {

		if (element instanceof EObject) {

			List<Object> result = new ArrayList<>();

			for (EStructuralFeature.Setting setting : EcoreUtil.UsageCrossReferencer.find(this.selectedEObject,
					(EObject) element)) {
				result.add("via reference '" + setting.getEStructuralFeature().getName() + "'");
			}
			return result.toArray();
		}
		return new Object[0];
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	@Override
	public Object getParent(Object element) {
		return null;
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	@Override
	public boolean hasChildren(Object element) {
		return element instanceof EObject;
	}

	/**
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	@Override
	public Object[] getElements(Object inputElement) {

		if (inputElement instanceof EObject && AgteleEcoreUtil.getRootEPackage(((EObject) inputElement).eClass())
				.equals(PamtramPackage.eINSTANCE)) {

			EObject eObject = (EObject) inputElement;

			// Find all non-containment references from elements of the PAMTraM
			// model to the
			// selected element
			//
			List<Setting> usages = EcoreUtil.UsageCrossReferencer.find(eObject, eObject.eResource().getResourceSet())
					.parallelStream()
					.filter(usage -> usage.getEStructuralFeature() instanceof EReference
							&& !((EReference) usage.getEStructuralFeature()).isContainment()
							&& !((EReference) usage.getEStructuralFeature()).isDerived())
					.collect(Collectors.toList());

			// Collect all origins of the found non-containment references
			//
			List<EObject> origins = usages.parallelStream().map(Setting::getEObject).collect(Collectors.toList());

			return origins.toArray();
		}

		return new Object[0];
	}

	/**
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	@Override
	public void dispose() {
		// Do nothing
	}

	/**
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer,
	 *      java.lang.Object, java.lang.Object)
	 */
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.selectedEObject = newInput instanceof EObject ? (EObject) newInput : null;
	}

}
