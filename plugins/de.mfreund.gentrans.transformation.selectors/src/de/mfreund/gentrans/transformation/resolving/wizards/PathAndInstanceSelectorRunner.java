package de.mfreund.gentrans.transformation.resolving.wizards;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.swt.widgets.Dialog;

import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.resolving.enhancing.MappingModelEnhancer;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;

/**
 * A {@link GenericSelectionDialogRunner} that will spawn a {@link PathAndInstanceSelectorDialog} in order to enable the
 * user to select between a 'path' as well as an 'instance' to be used.
 *
 * @param <T>
 *            The concrete type of the <em>path</em> elements displayed in the {@link PathAndInstanceSelectorDialog}.
 *
 */
public class PathAndInstanceSelectorRunner<T> extends GenericSelectionDialogRunner<T> {

	/**
	 * For each path in {@link GenericSelectionDialogRunner#options} this list keeps a list of instances represent by an
	 * identifier.
	 */
	private final List<List<EObjectWrapper>> instances;

	/**
	 * The instances that have been selected by the user (this will be a subset of {@link #instances}).
	 */
	private Set<EObjectWrapper> selectedInstances;

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
	public PathAndInstanceSelectorRunner(final String message, final List<T> paths,
			final List<List<EObjectWrapper>> instances,
			final MappingModelEnhancer<GenericSelectionDialogRunner<T>> enhanceMappingModelListener) {

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
	public PathAndInstanceSelectorRunner(final String message, final List<T> paths,
			final List<List<EObjectWrapper>> instances, boolean multiSelectionAllowed,
			final MappingModelEnhancer<GenericSelectionDialogRunner<T>> enhanceMappingModelListener) {

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
	public EObjectWrapper getSingleInstance() {

		return this.selectedInstances == null || this.selectedInstances.isEmpty() ? null
				: this.selectedInstances.iterator().next();
	}

	/**
	 * Get selected instances after run() was called.
	 *
	 * @return selected Instances after run() was called
	 */
	public Set<EObjectWrapper> getInstances() {

		return this.selectedInstances;
	}

	/**
	 * The single selected path after the dialog has finished.
	 * <p />
	 * Note: This convenience method just forwards to {@link GenericSelectionDialogRunner#getSingleSelection()}.
	 *
	 * @return The single selected path after the dialog has finished.
	 */
	public T getPath() {

		return this.getSingleSelection();
	}

	@Override
	protected void initializeDialog() {

		this.dialog = new PathAndInstanceSelectorDialog(this.message, this.getStringRepresentations(),
				this.getInstanceStringRepresentations(), this.multiSelectionAllowed, this.enhanceMappingModelListener);
	}

	/**
	 * Returns a list of lists of String representations for the {@link #instances}.
	 *
	 * @return A list of lists of String representations for the list of {@link #instances}.
	 */
	protected List<List<String>> getInstanceStringRepresentations() {

		return this.instances.stream().map(l -> l.stream().map(EObjectWrapper::toString).collect(Collectors.toList()))
				.collect(Collectors.toList());
	}

	@Override
	protected void evaluateResults() {

		int pathIndex = ((PathAndInstanceSelectorDialog) this.dialog).getSingleSelection();

		this.selection = Arrays.asList(this.options.get(pathIndex));

		List<EObjectWrapper> wrappers = this.instances.get(pathIndex);

		if (!this.multiSelectionAllowed) {

			this.selectedInstances = new HashSet<>(Arrays.asList(wrappers.parallelStream()
					.filter(i -> i.toString().equals(((PathAndInstanceSelectorDialog) this.dialog).getSingleInstance()))
					.findAny().get()));

		} else {

			this.selectedInstances = new HashSet<>();
			for (String instance : ((PathAndInstanceSelectorDialog) this.dialog).getInstances()) {
				this.selectedInstances
				.add(wrappers.parallelStream().filter(i -> i.toString().equals(instance)).findAny().get());
			}
		}
	}

}
