package de.mfreund.gentrans.transformation.resolving.wizards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.ModelConnectionPath;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import pamtram.structure.target.TargetSection;

/**
 * A {@link GenericSelectionDialog} that enables the user to select a 'class' (of type <em>T</em>) as well as an
 * '{@link EObjectWrapper instance}' to be used.
 * <p />
 * This is used during step 3 and 4 of the generic transformation when multiple possible {@link ModelConnectionPath
 * ModelConnectionPaths}/{@link TargetSection TargetSections} and corresponding instances exist.
 *
 * @param <T>
 *            The 'class' of the elements that will be returned by the dialog after the user's selection.
 */
public class ClassAndInstanceSelectorDialog<T> extends GenericSelectionDialog<T> {

	/**
	 * This keeps track of the instances the can be selected for each of the possible {@link #options}.
	 */
	protected final Map<T, Map<String, EObjectWrapper>> instanceOptions;

	/**
	 * The instances that have been selected by the user.
	 */
	protected List<EObjectWrapper> selectedInstances;

	/**
	 * Create the dialog without allowing for multi-selection.
	 * <p />
	 * Note: This is equal to calling '<em>PathAndInstanceSelectorDialog(message, paths, instances, <b>false</b>,
	 * standardSelectionIndex)</em>'.
	 *
	 * @param title
	 *            The title for the dialog.
	 * @param message
	 *            The message that shall be displayed in the dialog.
	 * @param options
	 *            A map that describes the options that can be chosen by the user.
	 * @param enhanceMappingModelListener
	 *            A {@link SelectionListener2} that will be called when the
	 *            {@link AbstractDialog#enhanceMappingModelButton} is clicked.
	 */
	public ClassAndInstanceSelectorDialog(String title, String message, Map<T, List<EObjectWrapper>> options,
			final SelectionListener2 enhanceMappingModelListener) {

		this(title, message, options, false, enhanceMappingModelListener);

	}

	/**
	 * Create the dialog.
	 *
	 * @param title
	 *            The title for the dialog.
	 * @param message
	 *            The message that shall be displayed in the dialog.
	 * @param options
	 *            A map that describes the options that can be chosen by the user.
	 * @param multiSelectionAllowed
	 *            Whether multi-selection shall be allowed in the dialog.
	 * @param enhanceMappingModelListener
	 *            A {@link SelectionListener2} that will be called when the
	 *            {@link AbstractDialog#enhanceMappingModelButton} is clicked.
	 */
	public ClassAndInstanceSelectorDialog(String title, String message, Map<T, List<EObjectWrapper>> options,
			boolean multiSelectionAllowed, final SelectionListener2 enhanceMappingModelListener) {

		super(title, message, new ArrayList<>(options.keySet()), multiSelectionAllowed, 0, enhanceMappingModelListener);

		this.instanceOptions = options.entrySet().stream().collect(LinkedHashMap::new,
				(outerMap, entry) -> outerMap.put(entry.getKey(), entry.getValue().stream().collect(LinkedHashMap::new,
						(innerMap, value) -> innerMap.put(value.toString(), value), (map1, map2) -> map1.putAll(map2))),
				(map1, map2) -> map1.putAll(map2));

		this.selectedInstances = Arrays.asList(options.get(0).get(0));
	}

	@Override
	protected void createInnerContents(Composite container) {

		// Create the sash form that will contain the two lists for paths and instances
		//
		SashForm sashForm = new SashForm(container, SWT.NONE);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).minSize(200, 200).applyTo(sashForm);

		// Create the group that will display the list of paths to the user
		//
		Group grpPossiblePaths = new Group(sashForm, SWT.NONE);
		grpPossiblePaths.setText("Possible Paths");
		grpPossiblePaths.setLayout(new FillLayout(SWT.HORIZONTAL));

		// Create the list viewer for the list of types
		//
		ListViewer pathListViewer = this.createListViewer(grpPossiblePaths, false, this.options.keySet(),
				this.standardSelectionIndex);

		// Create the group that will display the list of instances to the user
		//
		final Group grpPossibleInstances = new Group(sashForm, SWT.NONE);
		grpPossibleInstances.setText("Possible Instances");
		grpPossibleInstances.setLayout(new FillLayout(SWT.HORIZONTAL));

		// Create the list viewer for the list of instances
		//
		ListViewer instanceListViewer = this.createListViewer(grpPossibleInstances, this.multiSelectionAllowed,
				new ArrayList<>(this.instanceOptions.entrySet()).get(this.standardSelectionIndex).getValue().keySet(),
				this.standardSelectionIndex);

		pathListViewer.addSelectionChangedListener(event -> {
			T selectedType = this.options
					.get(pathListViewer.getList().getItem(pathListViewer.getList().getSelectionIndex()));
			this.selectedItems = Arrays.asList(selectedType);
			EObjectWrapper instanceToSelect = new ArrayList<>(this.instanceOptions.get(selectedType).values())
					.get(this.standardSelectionIndex);
			instanceListViewer.setSelection(new StructuredSelection(instanceToSelect));
		});

		instanceListViewer
				.addDoubleClickListener((IDoubleClickListener) e -> ClassAndInstanceSelectorDialog.this.close());

		sashForm.setWeights(new int[] { 50, 50 });

		instanceListViewer.addSelectionChangedListener(event -> {
			T selectedType = this.options
					.get(pathListViewer.getList().getItem(pathListViewer.getList().getSelectionIndex()));
			this.selectedInstances = Arrays.asList(instanceListViewer.getList().getSelection()).stream()
					.map(s -> this.instanceOptions.get(selectedType).get(s)).collect(Collectors.toList());
		});
	}

	/**
	 * Get the single selected instance after the dialog has been closed.
	 * <p />
	 * Note: This will return the first selected instance in case {@link GenericSelectionDialog#multiSelectionAllowed
	 * multi-selection} was allowed and the user selected multiple instances.
	 *
	 * @return selected instance
	 */
	public EObjectWrapper getSingleInstance() {

		return this.selectedInstances == null || this.selectedInstances.isEmpty() ? null
				: this.selectedInstances.iterator().next();

	}

	/**
	 * Get the selected instances after the dialog has been closed.
	 *
	 * @return The instances that have been selected by the user.
	 */
	public List<EObjectWrapper> getInstances() {

		return this.selectedInstances;
	}

}
