package de.mfreund.gentrans.transformation.resolving.wizards;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.swt.widgets.Dialog;

import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;

/**
 * A {@link GenericSelectionDialogRunner} that will spawn a {@link PathAndInstanceSelectorDialog} in order to enable
 * the user to select between a 'path' as well as an 'instance' to be used.
 *
 */
public class PathAndInstanceSelectorRunner extends GenericSelectionDialogRunner<String> {

	/**
	 * For each path in {@link GenericSelectionDialogRunner#options} this list keeps a list of
	 * instances represent by an identifier.
	 */
	private final List<List<String>> instances;

	/**
	 * The instances that have been selected by the user (this will be a subset of {@link #instances}).
	 */
	private Set<String> selectedInstances;

	/**
	 * This creates an instance without allowing for multi-selection.
	 * <p />
	 * Note: This is equal to calling '<em>PathAndInstanceSelectorRunner(message, paths, instances, <b>false</b>)</em>'.
	 *
	 * @param message
	 *            The message that shall be displayed in the {@link Dialog} that this runner will instantiate.
	 * @param paths
	 *            The paths to be presented to the user in the dialog.
	 * @param instances
	 *            The instances to be presented to the user (one list of instances for each path).
	 * @param enhanceMappingModelListener
	 *            A {@link SelectionListener2} that will be called when the
	 *            {@link AbstractDialog#enhanceMappingModelButton} is clicked.
	 */
	public PathAndInstanceSelectorRunner(final String message,
			final List<String> paths, final List<List<String>> instances,
			final SelectionListener2 enhanceMappingModelListener) {

		this(message, paths, instances, false, enhanceMappingModelListener);
	}

	/**
	 * This creates an instance.
	 *
	 * @param message
	 *            The message that shall be displayed in the {@link Dialog} that this runner will instantiate.
	 * @param paths
	 *            The paths to be presented to the user in the dialog.
	 * @param instances
	 *            The instances to be presented to the user (one list of instances for each path).
	 * @param multiSelectionAllowed
	 *            Whether multi-selection shall be allowed in the dialog.
	 * @param enhanceMappingModelListener
	 *            A {@link SelectionListener2} that will be called when the
	 *            {@link AbstractDialog#enhanceMappingModelButton} is clicked.
	 */
	public PathAndInstanceSelectorRunner(final String message,
			final List<String> paths, final List<List<String>> instances, boolean multiSelectionAllowed,
			final SelectionListener2 enhanceMappingModelListener) {

		super(message, 0, multiSelectionAllowed, paths, enhanceMappingModelListener);

		this.selectedInstances = new HashSet<>();
		this.instances = instances;
	}

	/**
	 * Get selected instance after run() was called.
	 * <p />
	 * Note: If multiple elements are selected by the user, this will return one (random!) element.
	 *
	 * @return selected Instance after run() was called
	 */
	public String getSingleInstance() {
		return this.selectedInstances == null || this.selectedInstances.isEmpty() ? null : this.selectedInstances.iterator().next();
	}

	/**
	 * Get selected instances after run() was called.
	 *
	 * @return selected Instances after run() was called
	 */
	public Set<String> getInstances() {
		return this.selectedInstances;
	}

	/**
	 * The single selected path after the dialog has finished.
	 * <p />
	 * Note: This convenience method just forwards to {@link GenericSelectionDialogRunner#getSingleSelection()}.
	 *
	 * @return The single selected path after the dialog has finished.
	 */
	public String getPath() {
		return this.getSingleSelection();
	}

	@Override
	protected void initializeDialog() {

		this.dialog = new PathAndInstanceSelectorDialog(this.message, this.options, this.instances,
				this.multiSelectionAllowed, this.enhanceMappingModelListener);
	}

	@Override
	protected void evaluateResults() {

		String path = ((PathAndInstanceSelectorDialog) this.dialog).getPath();
		this.selection = Arrays.asList(path);
		if(!this.multiSelectionAllowed) {
			this.selectedInstances = new HashSet<>(Arrays.asList(((PathAndInstanceSelectorDialog) this.dialog).getSingleInstance()));
		} else {
			this.selectedInstances = new HashSet<>();
			for (String instance : ((PathAndInstanceSelectorDialog) this.dialog).getInstances()) {
				this.selectedInstances.add(instance);
			}
		}
	}

}
