package de.mfreund.pamtram.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.DecoratingColumLabelProvider;
import org.eclipse.emf.edit.ui.provider.DelegatingStyledCellLabelProvider;
import org.eclipse.emf.edit.ui.provider.DiagnosticDecorator;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.List;

import de.mfreund.pamtram.util.BundleContentHelper;
import de.mfreund.pamtram.util.ResourceHelper;
import de.mfreund.pamtram.util.SelectionListener2;
import pamtram.util.EPackageHelper;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IDecorationContext;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.window.ToolTip;

/**
 * A wizard page that allows the specification of {@link EPackage EPackages}. These may be selected either from the 
 * global {@link org.eclipse.emf.ecore.EPackage.Registry} or from a specified meta-model file (Ecore or XSD).
 * 
 * @author mfreund
 */
public class EPackageSpecificationPage extends WizardPage {

	private static final String BUNDLE_ID = "de.mfreund.pamtram.ui";
	
	/**
	 * This keeps track of all registered {@link EPackage EPackages} that can be selected by the user.
	 */
	private EPackage.Registry registry;
	
	/**
	 * This keeps track of the namespace URIs that are contained in each of the specified meta-model files.
	 */
	private Map<String, Set<String>> metamodelFilesToNamespaceURIs;
	
	/**
	 * This keeps track of the meta-model files that specify namespace URIs.
	 */
	private Map<String, Set<String>> namespaceURIsToMetamodelFiles;
	
	/**
	 * This keeps track of the selected namespace URIs (those that are displayed in the {@link #ePackageViewer}).
	 */
	private Set<String> namespaceURIs;

	/**
	 * This combo allows the user to specify a namespace URI.
	 */
	private Combo combo;

	/**
	 * This keeps track of the selected meta-model files.
	 */
	private List fileList;
	/**
	 * This keeps track of the selected namespace URIs.
	 */
	private TableViewer ePackageViewer;
	
	public EPackageSpecificationPage(String pageName, String title, ImageDescriptor titleImage) {
		super(pageName, title, titleImage);
		
		// we create a copy of the global ePackage registry
		registry = new EPackageRegistryImpl();
		for (Entry<String, Object> entry : EPackage.Registry.INSTANCE.entrySet()) {
			registry.put(entry.getKey(), entry.getValue());
		}
		
		metamodelFilesToNamespaceURIs = new HashMap<>();
		namespaceURIsToMetamodelFiles = new HashMap<>();
		namespaceURIs = new HashSet<>();
		
	}
	
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		updateCombo();
	}

	@Override
	public void createControl(Composite parent) {
		
		Composite container = new Composite(parent, SWT.NULL);
		
		setControl(container);
		container.setLayout(new GridLayout(1, false));
		
		Group grpAddMetamodelFiles = new Group(container, SWT.NONE);
		grpAddMetamodelFiles.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		grpAddMetamodelFiles.setText("Add meta-model files");
		GridLayout gl_grpAddMetamodelFiles = new GridLayout(3, false);
		grpAddMetamodelFiles.setLayout(gl_grpAddMetamodelFiles);
		
		FileFieldEditor fileEditor = new FileFieldEditor("metamodelSelect", "Meta-model file:", grpAddMetamodelFiles);
		fileEditor.setFileExtensions(new String[]{"*.ecore", "*.xsd"});
		fileEditor.setPropertyChangeListener(new IPropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent event) {

				// update the list of available EPackages based on the specified meta-model
				String metamodelFile = fileEditor.getStringValue();
				
				if(!metamodelFilesToNamespaceURIs.containsKey(metamodelFile)) {
				
					HashMap<String, EPackage> packages = EPackageHelper.getEPackages(metamodelFile, true, false);
					
					if(packages == null || packages.isEmpty()) {
						return;
					}
					
					HashSet<String> namespaceURIs = new HashSet<>();
					
					for (Entry<String, EPackage> entry : packages.entrySet()) {
						registry.put(entry.getKey(), entry.getValue());
						namespaceURIs.add(entry.getKey());
						
						HashSet<String> metamodelFiles = new HashSet<>();
						if(namespaceURIsToMetamodelFiles.get(entry.getKey()) != null) {
							metamodelFiles.addAll(namespaceURIsToMetamodelFiles.get(entry.getKey()));
						}
						metamodelFiles.add(metamodelFile);
						namespaceURIsToMetamodelFiles.put(entry.getKey(), metamodelFiles);
					}
					
					metamodelFilesToNamespaceURIs.put(metamodelFile, namespaceURIs);
					
					fileList.add(metamodelFile);
				
					updateCombo();
					updateEPackageViewer();
					fileEditor.setStringValue("");
				}				
			}

		});
		
		fileList = new List(grpAddMetamodelFiles, SWT.BORDER | SWT.V_SCROLL);
		fileList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		fileList.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
				// delete the selected item from the file list and update the registry and the combo if necessary
				if(e.keyCode == SWT.DEL && fileList.getSelectionIndex() != -1 && fileList.getSelection().length == 1) {
					
					Collection<String> namespaceURIs = metamodelFilesToNamespaceURIs.get(fileList.getSelection()[0]);
					if(namespaceURIs != null && !namespaceURIs.isEmpty()) {
						for (String namespaceURI : namespaceURIs) {

							if(namespaceURIsToMetamodelFiles.get(namespaceURI) != null && namespaceURIsToMetamodelFiles.get(namespaceURI).size() == 1 &&
									namespaceURIsToMetamodelFiles.get(namespaceURI).iterator().next().equals(fileList.getSelection()[0])) {
								
								registry.remove(namespaceURI);
							}
						}
						updateEPackageViewer();
						updateCombo();
					}
					metamodelFilesToNamespaceURIs.remove(fileList.getSelection()[0]);
					fileList.remove(fileList.getSelectionIndex());
				}
			}
		});
		
		Group grpSpecifyEpackages = new Group(container, SWT.NONE);
		grpSpecifyEpackages.setLayout(new GridLayout(3, false));
		grpSpecifyEpackages.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		grpSpecifyEpackages.setText("Specify EPackages");
		
		combo = new Combo(grpSpecifyEpackages, SWT.NONE);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Button btnAdd = new Button(grpSpecifyEpackages, SWT.NONE);
		btnAdd.setText("Add...");
		btnAdd.addSelectionListener(new SelectionListener2() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				// add the specified nsURI to the list
				String nsURI = combo.getText();
				
				if(nsURI != null && !nsURI.isEmpty() && registry.containsKey(nsURI)) {
					namespaceURIs.add(nsURI);
					updateEPackageViewer();
					combo.setText("");
				}
			}
		});
		
		ePackageViewer = new TableViewer(grpSpecifyEpackages, SWT.BORDER | SWT.FULL_SELECTION);
		ePackageViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		ePackageViewer.setContentProvider(new ArrayContentProvider());
		ColumnViewerToolTipSupport.enableFor(ePackageViewer, ToolTip.NO_RECREATE); 
		ePackageViewer.setLabelProvider(new StyledCellLabelProvider() {
			@Override
			public void update(ViewerCell cell) {
				Object element= cell.getElement();

				if(element instanceof String) {
					cell.setText((String) element);
					
					if(!registry.containsKey(element)) {
						cell.setImage(BundleContentHelper.getBundleImage(BUNDLE_ID, "icons/warning.gif"));
					}
				}

				super.update(cell);
			}
			@Override
			public String getToolTipText(Object element) {
				if(element instanceof String && !registry.containsKey(element)) {
					return "This namespace URI is neither contained in the global EPackage registry nor specified by one "
							+ "of the selected meta-model files";					
				} else {
					return super.getToolTipText(element);
				}
			}
		});
				
		
	}
	

	/**
	 * Updates the list of namespace URIs displayed in the {@link #combo} based on the current set of
	 * entries in the {@link #registry}.
	 */
	private void updateCombo() {
		combo.removeAll();
		for (String nsUri : registry.keySet()) {
			combo.add(nsUri);
		}
		if(combo.getItemCount() == 1) {
			combo.select(0);
		}
	}
	
	/**
	 * Updates the list of namespace URIs displayed in the {@link #ePackageViewer} based on the value of the
	 * {@link #namespaceURIs}.
	 */
	private void updateEPackageViewer() {
		ePackageViewer.setInput(new ArrayList<>());
		ePackageViewer.setInput(namespaceURIs);		
	}
}
