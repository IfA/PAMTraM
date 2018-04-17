/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.pamtram.ui.views;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.ui.views.AnalysisView;
import org.eclipse.emf.ecoretools.ui.views.EReferencesView;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.WorkbenchJob;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.provider.GenLibraryItemProviderAdapterFactory;
import pamtram.PAMTraM;
import pamtram.condition.provider.ConditionItemProviderAdapterFactory;
import pamtram.mapping.provider.MappingItemProviderAdapterFactory;
import pamtram.provider.PamtramItemProviderAdapterFactory;
import pamtram.structure.provider.StructureItemProviderAdapterFactory;

/**
 * This class displays all references to an element of a {@link PAMTraM} model.
 *
 * Its behavior is similar to the standard {@link EReferencesView}.
 */
public class PamtramReferencesView extends AnalysisView {

	/**
	 * The ID of the view
	 */
	public static final String VIEW_ID = "de.mfreund.pamtram.ui.views.PamtramReferencesView";

	private TreeViewer referencesTree;

	/**
	 * The job used to refresh the tree.
	 */
	private Job refreshJob;

	/**
	 * The {@link AdapterFactory} used to provide labels.
	 */
	private ComposedAdapterFactory adapterFactory;

	/**
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		this.referencesTree = new TreeViewer(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL);

		this.referencesTree.setContentProvider(new PamtramReferencesContentProvider());

		// Create an adapter factory that yields item providers.
		//
		this.adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		this.adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		this.adapterFactory.addAdapterFactory(new PamtramItemProviderAdapterFactory());
		this.adapterFactory.addAdapterFactory(new StructureItemProviderAdapterFactory());
		this.adapterFactory.addAdapterFactory(new ConditionItemProviderAdapterFactory());
		this.adapterFactory.addAdapterFactory(new MappingItemProviderAdapterFactory());
		this.adapterFactory.addAdapterFactory(new GenLibraryItemProviderAdapterFactory());
		this.adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		this.referencesTree.setLabelProvider(
				new AdapterFactoryLabelProvider.StyledLabelProvider(this.adapterFactory, this.referencesTree));

		this.referencesTree.addDoubleClickListener(new ReferenceViewDoubleClickListener());

		this.referencesTree.getControl().addDisposeListener(e -> {
			if (this.refreshJob != null) {
				this.refreshJob.cancel();
			}
		});

	}

	/**
	 * @see org.eclipse.emf.ecoretools.ui.views.AnalysisView#refresh(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected void refresh(EObject object) {
		// cancel currently running job first, to prevent unnecessary redraw
		if (this.refreshJob != null) {
			this.refreshJob.cancel();
		}

		this.refreshJob = this.createRefreshJob(object);
		this.refreshJob.schedule(200);
	}

	private Job createRefreshJob(final EObject selection) {
		Job job = new WorkbenchJob("Refresh PAMTram References View") {

			/**
			 * @see org.eclipse.ui.progress.UIJob#runInUIThread(org.eclipse.core.runtime.IProgressMonitor)
			 */
			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				if (PamtramReferencesView.this.referencesTree.getControl().isDisposed()) {
					return Status.CANCEL_STATUS;
				}
				try {
					PamtramReferencesView.this.referencesTree.getControl().setRedraw(false);

					// TODO Calling setInput() and then refresh() causes a
					// refreshment of the view twice : setInput() should be
					// performed elsewhere.
					PamtramReferencesView.this.referencesTree.setInput(selection);
					PamtramReferencesView.this.referencesTree.refresh();
					PamtramReferencesView.this.referencesTree.expandAll();
				} finally {
					// done updating the tree - set redraw back to true
					PamtramReferencesView.this.referencesTree.getControl().setRedraw(true);
				}
				return Status.OK_STATUS;
			}

		};
		job.setSystem(true);

		return job;
	}

	/**
	 * An {@link IDoubleClickListener} that sets the selection of the active
	 * editor to the element that the user double-clicked on.
	 *
	 * @author mfreund
	 */
	private class ReferenceViewDoubleClickListener implements IDoubleClickListener {

		@Override
		public void doubleClick(DoubleClickEvent event) {

			ISelection selection = event.getSelection();

			if (!(selection instanceof StructuredSelection)
					|| !(((StructuredSelection) selection).getFirstElement() instanceof EObject)) {
				return;
			}

			EObject selectedElement = (EObject) ((StructuredSelection) selection).getFirstElement();

			IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
					.getActiveEditor();

			if (editorPart instanceof IViewerProvider) {
				((IViewerProvider) editorPart).getViewer().setSelection(new StructuredSelection(selectedElement), true);
			}
		}

	}
}
