package de.mfreund.gentrans.transformation.handler;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import de.mfreund.gentrans.transformation.selectors.PamtramFileSelectorDialog;

/**
 * @author Sascha Steffen
 * @version 1.0
 *
 *          Runs the GenTrans using an XMI source
 */
public class GenTransFromXMISourceHandler extends AbstractHandler {

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		// get the active selection
		final ISelection sel = HandlerUtil.getActiveMenuSelection(event);
		final IStructuredSelection selection = (IStructuredSelection) sel;

		// get the first element of the active selection
		final Object firstElement = selection.getFirstElement();

		if (!(firstElement instanceof IFile)) {
			throw new ExecutionException("Selected element is not a resource!");
		}
		final IFile file = (IFile) firstElement;

		// Create a resource set.
		final ResourceSet resourceSet = new ResourceSetImpl();

		final String pamtramFilePath = PamtramFileSelectorDialog.run(file
				.getLocation().removeLastSegments(1).toOSString());

		// the selected resource (IMPORTANT: needs to be represented as absolute
		// URI with "file://" scheme;
		// if other schemes are used, the relative paths to the wprops and other
		// model files are not set correct!)
		final URI resourceUri = URI.createFileURI(new java.io.File(file
				.getLocation().toString()).toString());
		// the source resource (xmi)

		Resource xmiResource = null;
		try {
			xmiResource = resourceSet.getResource(resourceUri, true);
			xmiResource.load(Collections.EMPTY_MAP);
		} catch (final IOException e) {
			e.printStackTrace(System.out);
			return null;
		}

		// get the root object of the xml resource
		final EObject root = xmiResource.getContents().get(0);
		final Job job = new GenericTransformationJob("GenTrans", root,
				pamtramFilePath, PamtramFileSelectorDialog.getTargetFile());

		job.setUser(true);
		job.schedule();

		return null;
	}

}
