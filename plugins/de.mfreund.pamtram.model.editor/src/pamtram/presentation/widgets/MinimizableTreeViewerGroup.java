package pamtram.presentation.widgets;

import java.util.List;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import de.tud.et.ifa.agtele.resources.BundleContentHelper;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import de.tud.et.ifa.agtele.ui.widgets.TreeViewerGroup;


/**
 * A {@link TreeViewerGroup} that can be minimized (and restored) when placed inside a {@link MinimizableSashForm}.
 *
 * @author mfreund
 *
 */
public class MinimizableTreeViewerGroup extends TreeViewerGroup implements IMinimizedHeightProvider, IMinimizable {

	private final String bundleID = "de.mfreund.pamtram.model.editor";

	/**
	 * The {@link Image} used for the icon of the 'minimize' button.
	 */
	private Image minimizeImage;

	/**
	 * The {@link Image} used for the icon of the 'restore' button.
	 */
	private Image restoreImage;

	/**
	 * This keeps track of the state of the control.
	 */
	private boolean isMinimized;

	/**
	 * The {@link ToolItem} that toggles the state of the tree viewer group between <em>minimized</em> and <em>normal</em>.
	 */
	private ToolItem minimizeItem;

	/**
	 * This stores the minimized height that is only calculate once.
	 */
	private int minimizedHeight;

	/**
	 * Use this constructor if you do not want to add a tool bar to the viewer.
	 *
	 * @param parent
	 *            The parent composite.
	 * @param adapterFactory
	 *            The adapter factory used to create label and content adapters.
	 * @param editingDomain
	 *            The editing domain that is used for the viewer.
	 * @param dialogSettings
	 *            The dialog settings belonging to the editor (e.g. XYZPlugin..getPlugin().getDialogSettings()).
	 * @param groupText
	 *            The label of the group widget that hold all other widgets. If this is null no surrounding group will
	 *            created.
	 */
	public MinimizableTreeViewerGroup(MinimizableSashForm parent, ComposedAdapterFactory adapterFactory,
			EditingDomain editingDomain, IDialogSettings dialogSettings, String groupText) {
		super(parent, adapterFactory, editingDomain, dialogSettings, groupText);
	}

	/**
	 * Use this constructor if you want to add a tool bar to the viewer.
	 *
	 * @param parent
	 *            The parent composite.
	 * @param adapterFactory
	 *            The adapter factory used to create label and content adapters.
	 * @param editingDomain
	 *            The editing domain that is used for the viewer.
	 * @param dialogSettings
	 *            The dialog settings belonging to the editor (e.g. XYZPlugin..getPlugin().getDialogSettings()).
	 * @param groupText
	 *            The label of the group widget that hold all other widgets. If this is null no surrounding group will
	 *            created.
	 * @param images
	 *            A list of images used as icons for the items of the tool bar.
	 * @param listeners
	 *            A list of SelectionListeners used for the items of the tool bar.
	 * @param displayCollapseAll
	 *            If to include a 'collapseAll' button in the tool bar.
	 * @param displayAdd
	 *            If to include an 'add' button in the tool bar.
	 */
	public MinimizableTreeViewerGroup(MinimizableSashForm parent, ComposedAdapterFactory adapterFactory,
			EditingDomain editingDomain, IDialogSettings dialogSettings, String groupText, List<Image> images,
			List<SelectionListener> listeners, boolean displayCollapseAll, boolean displayAdd) {
		super(parent, adapterFactory, editingDomain, dialogSettings, groupText, images, listeners, displayCollapseAll, displayAdd);
	}

	@Override
	protected void createAdditionalToolbarItems(ToolBar toolbar) {

		this.isMinimized = false;
		this.minimizedHeight = -1;
		this.minimizeImage = BundleContentHelper.getBundleImage(this.bundleID, "icons/minimize.gif");
		this.restoreImage = BundleContentHelper.getBundleImage(this.bundleID, "icons/restore.gif");

		this.minimizeItem = new ToolItem(toolbar, SWT.PUSH);
		this.minimizeItem.setImage(this.minimizeImage);
		this.minimizeItem.setToolTipText("Minimize");

		// either minimize or restore the control depending on the 'minimized' state
		this.minimizeItem.addSelectionListener((SelectionListener2) e -> {

			if(!MinimizableTreeViewerGroup.this.isMinimized) {
				((MinimizableSashForm) MinimizableTreeViewerGroup.this.parent).minimizeControl(MinimizableTreeViewerGroup.this);
			} else {
				((MinimizableSashForm) MinimizableTreeViewerGroup.this.parent).restoreLayout();
			}
		});

		super.createAdditionalToolbarItems(toolbar);
	}

	@Override
	public void dispose() {
		this.minimizeImage.dispose();
		this.restoreImage.dispose();
		super.dispose();
	}

	@Override
	public int getMinimizedHeight() {

		if(this.minimizedHeight == -1) {
			// in the 'minimized' state, we do not want to display the tree viewer
			this.minimizedHeight = this.group.getSize().y - this.treeViewer.getTree().getSize().y;
		}

		return this.minimizedHeight;
	}

	@Override
	public void minimize() {
		this.isMinimized = true;
		this.minimizeItem.setImage(this.restoreImage);
		this.minimizeItem.setToolTipText("Restore");
	}

	@Override
	public void restore() {
		this.isMinimized = false;
		this.minimizeItem.setImage(this.minimizeImage);
		this.minimizeItem.setToolTipText("Minimize");
	}

}
