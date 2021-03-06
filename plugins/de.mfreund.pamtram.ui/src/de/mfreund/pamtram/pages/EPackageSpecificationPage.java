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
package de.mfreund.pamtram.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.jface.fieldassist.AutoCompleteField;
import org.eclipse.jface.fieldassist.ComboContentAdapter;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;

import de.tud.et.ifa.agtele.emf.EPackageHelper;
import de.tud.et.ifa.agtele.resources.BundleContentHelper;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;

/**
 * A wizard page that allows the specification of {@link EPackage EPackages}.
 * These may be selected either from the global
 * {@link org.eclipse.emf.ecore.EPackage.Registry} or from a specified
 * meta-model file (Ecore or XSD).
 *
 * @author mfreund
 */
public class EPackageSpecificationPage extends WizardPage {

	private static final String BUNDLE_ID = "de.mfreund.pamtram.ui";

	/**
	 * This keeps track of all registered {@link EPackage EPackages} that can be
	 * selected by the user.
	 */
	private EPackage.Registry registry;

	/**
	 * This keeps track of the namespace URIs that are contained in each of the
	 * specified meta-model files.
	 */
	private Map<String, Set<String>> metamodelFilesToNamespaceURIs;

	/**
	 * This keeps track of the meta-model files that specify namespace URIs.
	 */
	private Map<String, Set<String>> namespaceURIsToMetamodelFiles;

	/**
	 * This keeps track of the selected namespace URIs (those that are displayed
	 * in the {@link #ePackageViewer}).
	 */
	private Set<String> namespaceURIs;

	/**
	 * This combo allows the user to specify a namespace URI.
	 */
	private Combo combo;

	/**
	 * This is responsible for the auto-completion in the {@link #combo}.
	 */
	private AutoCompleteField comboAutocompleteField;

	/**
	 * This keeps track of the selected meta-model files.
	 */
	private List fileList;

	/**
	 * This keeps track of the selected namespace URIs.
	 */
	private TableViewer ePackageViewer;

	/**
	 * Creates a new wizard page with the given name, title, message, and image.
	 *
	 * @param pageName
	 *            the name of the page
	 * @param title
	 *            the title for this wizard page, or <code>null</code> if none
	 * @param message
	 *            the message for this wizard page, or <code>null</code> if none
	 * @param titleImage
	 *            the image descriptor for the title of this wizard page, or
	 *            <code>null</code> if none
	 */
	public EPackageSpecificationPage(String pageName, String title, String message, ImageDescriptor titleImage) {
		super(pageName, title, titleImage);
		this.setMessage(message);

		this.init();
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		this.updateCombo();
		this.updateEPackageViewer();
	}

	@Override
	public void createControl(Composite parent) {

		Composite container = new Composite(parent, SWT.NULL);

		this.setControl(container);
		container.setLayout(new GridLayout(1, false));

		Group grpAddMetamodelFiles = new Group(container, SWT.NONE);
		grpAddMetamodelFiles.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		grpAddMetamodelFiles.setText("Add meta-model files");
		GridLayout gl_grpAddMetamodelFiles = new GridLayout(3, false);
		grpAddMetamodelFiles.setLayout(gl_grpAddMetamodelFiles);

		FileFieldEditor fileEditor = new FileFieldEditor("metamodelSelect", "Meta-model file:", grpAddMetamodelFiles);
		fileEditor.setFileExtensions(new String[] { "*.ecore", "*.xsd" });
		fileEditor.setPropertyChangeListener(event -> {

			// update the list of available EPackages based on the specified
			// meta-model
			String metamodelFile = fileEditor.getStringValue();

			if (!EPackageSpecificationPage.this.metamodelFilesToNamespaceURIs.containsKey(metamodelFile)) {

				Map<String, EPackage> packages = EPackageHelper.getEPackages(metamodelFile, true, false);

				if (packages == null || packages.isEmpty()) {
					return;
				}

				HashSet<String> namespaceURIs = new HashSet<>();

				for (Entry<String, EPackage> entry : packages.entrySet()) {
					EPackageSpecificationPage.this.registry.put(entry.getKey(), entry.getValue());
					namespaceURIs.add(entry.getKey());

					HashSet<String> metamodelFiles = new HashSet<>();
					if (EPackageSpecificationPage.this.namespaceURIsToMetamodelFiles.get(entry.getKey()) != null) {
						metamodelFiles.addAll(
								EPackageSpecificationPage.this.namespaceURIsToMetamodelFiles.get(entry.getKey()));
					}
					metamodelFiles.add(metamodelFile);
					EPackageSpecificationPage.this.namespaceURIsToMetamodelFiles.put(entry.getKey(), metamodelFiles);
				}

				EPackageSpecificationPage.this.fileList.add(metamodelFile);
				EPackageSpecificationPage.this.namespaceURIs.addAll(namespaceURIs);
				EPackageSpecificationPage.this.metamodelFilesToNamespaceURIs.put(metamodelFile, namespaceURIs);

				EPackageSpecificationPage.this.updateCombo();
				EPackageSpecificationPage.this.updateEPackageViewer();
				fileEditor.setStringValue("");
			}
		});

		this.fileList = new List(grpAddMetamodelFiles, SWT.BORDER | SWT.V_SCROLL);
		this.fileList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		this.fileList.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {

				// delete the selected item from the file list and update the
				// registry and the combo if necessary
				if (e.keyCode == SWT.DEL && EPackageSpecificationPage.this.fileList.getSelectionIndex() != -1
						&& EPackageSpecificationPage.this.fileList.getSelection().length == 1) {

					Collection<String> namespaceURIs = EPackageSpecificationPage.this.metamodelFilesToNamespaceURIs
							.get(EPackageSpecificationPage.this.fileList.getSelection()[0]);
					if (namespaceURIs != null && !namespaceURIs.isEmpty()) {
						for (String namespaceURI : namespaceURIs) {

							if (EPackageSpecificationPage.this.namespaceURIsToMetamodelFiles.get(namespaceURI) != null
									&& EPackageSpecificationPage.this.namespaceURIsToMetamodelFiles.get(namespaceURI)
											.size() == 1
									&& EPackageSpecificationPage.this.namespaceURIsToMetamodelFiles.get(namespaceURI)
											.iterator().next()
											.equals(EPackageSpecificationPage.this.fileList.getSelection()[0])) {

								EPackageSpecificationPage.this.registry.remove(namespaceURI);
							}
						}
						EPackageSpecificationPage.this.updateEPackageViewer();
						EPackageSpecificationPage.this.updateCombo();
					}
					EPackageSpecificationPage.this.metamodelFilesToNamespaceURIs
							.remove(EPackageSpecificationPage.this.fileList.getSelection()[0]);
					EPackageSpecificationPage.this.fileList
							.remove(EPackageSpecificationPage.this.fileList.getSelectionIndex());
				}
			}
		});

		Group grpSpecifyEpackages = new Group(container, SWT.NONE);
		grpSpecifyEpackages.setLayout(new GridLayout(3, false));
		grpSpecifyEpackages.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		grpSpecifyEpackages.setText("Specify EPackages");

		this.combo = new Combo(grpSpecifyEpackages, SWT.NONE);
		this.combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		// realize auto-completion for the combo viewer
		this.comboAutocompleteField = new AutoCompleteField(this.combo, new ComboContentAdapter(),
				this.combo.getItems());

		Button btnAdd = new Button(grpSpecifyEpackages, SWT.NONE);
		btnAdd.setText("Add...");
		btnAdd.addSelectionListener((SelectionListener2) e -> {

			// add the specified nsURI to the list
			String nsURI = EPackageSpecificationPage.this.combo.getText();

			if (nsURI != null && !nsURI.isEmpty() && EPackageSpecificationPage.this.registry.containsKey(nsURI)) {
				EPackageSpecificationPage.this.namespaceURIs.add(nsURI);
				EPackageSpecificationPage.this.updateEPackageViewer();
				EPackageSpecificationPage.this.combo.setText("");
			}
		});

		this.ePackageViewer = new TableViewer(grpSpecifyEpackages, SWT.BORDER | SWT.FULL_SELECTION);
		this.ePackageViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		this.ePackageViewer.setContentProvider(new ArrayContentProvider());
		ColumnViewerToolTipSupport.enableFor(this.ePackageViewer, ToolTip.NO_RECREATE);
		this.ePackageViewer.setLabelProvider(new StyledCellLabelProvider() {
			@Override
			public void update(ViewerCell cell) {
				Object element = cell.getElement();

				if (element instanceof String) {
					cell.setText((String) element);

					if (!EPackageSpecificationPage.this.registry.containsKey(element)) {
						cell.setImage(BundleContentHelper.getBundleImage(EPackageSpecificationPage.BUNDLE_ID,
								"icons/warning.gif"));
					}
				}

				super.update(cell);
			}

			@Override
			public String getToolTipText(Object element) {
				if (element instanceof String && !EPackageSpecificationPage.this.registry.containsKey(element)) {
					return "This namespace URI is neither contained in the global EPackage registry nor specified by one "
							+ "of the selected meta-model files";
				} else {
					return super.getToolTipText(element);
				}
			}
		});
		this.ePackageViewer.getTable().addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {

				// delete the selected item from the file list and update the
				// registry and the combo if necessary
				if (e.keyCode == SWT.DEL
						&& EPackageSpecificationPage.this.ePackageViewer.getTable().getSelectionIndex() != -1
						&& EPackageSpecificationPage.this.ePackageViewer.getTable().getSelection().length == 1) {

					String namespaceURI = EPackageSpecificationPage.this.ePackageViewer.getTable().getSelection()[0]
							.getText();
					EPackageSpecificationPage.this.namespaceURIs.remove(namespaceURI);
					EPackageSpecificationPage.this.updateEPackageViewer();
				}
			}
		});

	}

	/**
	 * Updates the list of namespace URIs displayed in the {@link #combo} based
	 * on the current set of entries in the {@link #registry}.
	 */
	private void updateCombo() {
		this.combo.removeAll();

		String[] entries = new String[this.registry.size()];
		this.registry.keySet().toArray(entries);
		Arrays.sort(entries);
		this.combo.setItems(entries);

		if (this.combo.getItemCount() == 1) {
			this.combo.select(0);
		}
		this.comboAutocompleteField.setProposals(this.combo.getItems());

		this.getWizard().getContainer().updateButtons();
	}

	/**
	 * Updates the list of namespace URIs displayed in the
	 * {@link #ePackageViewer} based on the value of the {@link #namespaceURIs}.
	 */
	private void updateEPackageViewer() {
		this.ePackageViewer.setInput(new ArrayList<>());
		this.ePackageViewer.setInput(this.namespaceURIs);
		this.getWizard().getContainer().updateButtons();
	}

	@Override
	public boolean isPageComplete() {

		// check if all specified namespace URIs are registered
		for (String namespaceURI : this.namespaceURIs) {
			if (!this.registry.containsKey(namespaceURI)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Initialize the page. This initializes the {@link #registry} and clears
	 * both the {@link #fileList} and the {@link #ePackageViewer}.
	 */
	private void init() {

		// we create a copy of the global ePackage registry
		this.registry = new EPackageRegistryImpl();
		for (Entry<String, Object> entry : EPackage.Registry.INSTANCE.entrySet()) {
			this.registry.put(entry.getKey(), entry.getValue());
		}

		this.metamodelFilesToNamespaceURIs = new HashMap<>();
		this.namespaceURIsToMetamodelFiles = new HashMap<>();
		this.namespaceURIs = new HashSet<>();
	}

	/**
	 * {@link #init() Initialize} the page and afterwards set the given list of
	 * '<em>namspaceURIs</em>' as initial content of the
	 * {@link #ePackageViewer}.
	 *
	 * @param namespaceURIs
	 *            The set of namespace URIs to initially display in the
	 *            {@link #ePackageViewer} or '<em>null</em>' if nothing is to be
	 *            displayed.
	 */
	public void setNamespaceURIs(HashSet<String> namespaceURIs) {
		this.init();
		this.namespaceURIs = namespaceURIs == null ? new HashSet<>() : namespaceURIs;
		this.updateEPackageViewer();
	}

	/**
	 * This returns an {@link org.eclipse.emf.ecore.EPackage.Registry} for all
	 * namespace URIs specified by the user.
	 *
	 * @return The {@link org.eclipse.emf.ecore.EPackage.Registry} for all
	 *         namespace URIs specified by the user.
	 */
	public Registry getRegistry() {

		EPackage.Registry specifiedNamespaceURIs = new EPackageRegistryImpl();
		for (String nsURI : this.namespaceURIs) {
			specifiedNamespaceURIs.put(nsURI, this.registry.getEPackage(nsURI));
		}
		return specifiedNamespaceURIs;
	}

	/**
	 * This returns a map that links all namespace URIs to the files that
	 * contain their meta-model. This map does only contain those of the
	 * specified {@link #namespaceURIs} that are file-based (not present in the
	 * global EPackage registry).
	 *
	 * @return The map that links namespace URIs and meta-model files
	 *         (Ecore/XSD).
	 */
	public HashMap<String, String> getNamespaceURIsToMetamodelFiles() {
		HashMap<String, String> specifiedNamespaceURIsToMetamodelFiles = new HashMap<>();
		for (String nsURI : this.namespaceURIs) {
			if (this.namespaceURIsToMetamodelFiles.containsKey(nsURI)) {
				specifiedNamespaceURIsToMetamodelFiles.put(nsURI,
						this.namespaceURIsToMetamodelFiles.get(nsURI).iterator().next());
			}
		}
		return specifiedNamespaceURIsToMetamodelFiles;
	}
}
