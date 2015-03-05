package pamtram.contentadapter;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.Resource;

import pamtram.PAMTraM;
import pamtram.metamodel.LibraryEntry;
import de.mfreund.pamtram.util.ResourceHelper;

/**
 * This adapter gets handles notifications that occur when a {@link LibraryEntry} is deleted
 * from the {@link PAMTraM} instance. In this case, it deletes the associated resource from 
 * the '<em>lib</em>' folder of the project.
 * 
 * @author mfreund
 *
 */
final class LibraryEntryRemovalHandlerAdapter extends PamtramChildContentAdapter {
	
	public LibraryEntryRemovalHandlerAdapter(PamtramContentAdapter parentAdapter) {
		super(parentAdapter);
	}

	@Override
	public void notifyChanged(Notification n) {
		super.notifyChanged(n);
		
		if(n.getEventType() == Notification.REMOVE && n.getOldValue() instanceof LibraryEntry) {
			
			LibraryEntry libraryEntry = (LibraryEntry) n.getOldValue();
			if(libraryEntry.getOriginalLibraryEntry() == null) {
				// something seems to be wrong
				System.err.println("The LibraryEntry is not associated with an 'original' library entry!");
				return;
			}
			
			// the resource that belongs to the original library entry to be deleted
			Resource resource = libraryEntry.getOriginalLibraryEntry().eResource();
			// get the absolute path of the resource
			IPath resourcePath = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(resource.getURI().toPlatformString(true))).getLocation();
			// this is the parent file of the resource (this should be a directory)
			File parent = resourcePath.toFile().getParentFile();
			try {
				// delete the resource (and thus remove it from the resource set)
				resource.delete(null);
				// now check if we need to delete an empty directory
				if(parent.isDirectory() && parent.listFiles().length == 0) {
					parent.delete();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			// refresh the workspace to see the results
			ResourceHelper.refresh(ResourcesPlugin.getWorkspace().getRoot());
		}
	}
}
