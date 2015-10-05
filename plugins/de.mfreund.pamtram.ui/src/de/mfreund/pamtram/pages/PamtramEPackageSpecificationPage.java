package de.mfreund.pamtram.pages;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.jface.fieldassist.AutoCompleteField;
import org.eclipse.jface.fieldassist.ComboContentAdapter;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;

import de.mfreund.pamtram.util.SelectionListener2;
import de.mfreund.pamtram.wizards.PamtramModelWizard;
import pamtram.util.EPackageHelper;

/**
 * This is the page where the ePackage of the source and target
 * sections can be selected.
 */
public class PamtramEPackageSpecificationPage extends WizardPage {

	private static final String BUNDLE_ID = "de.mfreund.pamtram.ui";
	private final int numColumns = 3;
	private final int marginWidth = 5;
	private final int marginHeight = 5;

	private EPackage targetEPackage;
	private Button sourceIsFileBasedButton, targetIsFileBasedButton;
	private FileFieldEditor sourceFileFieldEditor, targetFileFieldEditor;
	private Combo sourceCombo, targetCombo;
	private Composite sourceFileComposite, targetFileComposite;

	// this holds the nsUris of all packages in the ePackage registry
	private EPackage.Registry registeredEPackages;

	// this holds the nsUris of all packages defined in the source ecore model (if specified)
	private HashMap<String, EPackage> sourceEcoreEPackages = new HashMap<>();
	// this specifies the ecore models for all source packages that are not present in the global registry
	private HashMap<String, String> sourceEcoreModels = new HashMap<>();
	// this holds the nsUris of all packages defined in the target ecore model (if specified)
	private HashMap<String, EPackage> targetEcoreEPackages = new HashMap<>();

	private ModifyListener targetComboModifyListener;
	private SelectionListener sourceIsFileBasedButtonSelectionListener, targetIsFileBasedButtonSelectionListener;
	private Label separator;
	private List sourceEPackageList;

	/**
	 * This keeps track of the namespace URIs of the source EPackages to be imported.
	 */
	private HashSet<String> sourceEPackages = new HashSet<>();


	public PamtramEPackageSpecificationPage(String pageName) {

		super(pageName);

		// we create a copy of the global ePackage registry
		registeredEPackages = new EPackageRegistryImpl();
		for (Entry<String, Object> entry : EPackage.Registry.INSTANCE.entrySet()) {
			registeredEPackages.put(entry.getKey(), entry.getValue());
		}
	}

	@Override
	public void createControl(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		{
			GridLayout layout = new GridLayout();
			layout.numColumns = 1;
			layout.verticalSpacing = 12;
			composite.setLayout(layout);

			GridData data = new GridData();
			data.verticalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			data.horizontalAlignment = GridData.FILL;
			composite.setLayoutData(data);
		}

		Group sourceGroup = new Group(composite, SWT.NONE);
		sourceGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		{
			sourceGroup.setText("Source Sections ePackage(s)");

			GridLayout layout = new GridLayout();
			layout.marginWidth = marginWidth;
			layout.marginHeight = marginHeight;
			sourceGroup.setLayout(layout);
		}
		sourceIsFileBasedButtonSelectionListener = new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {		
				setSourceIsFileBased(sourceIsFileBasedButton.getSelection());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		};

		Group sourceAddEPackageGroup = new Group(sourceGroup, SWT.NONE);
		sourceAddEPackageGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		sourceAddEPackageGroup.setText("Add one or more EPackages...");
		sourceAddEPackageGroup.setLayout(new GridLayout(1, false));

		final Composite sourceComposite = new Composite(sourceAddEPackageGroup, SWT.NONE);
		sourceComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		{
			GridLayout layout = new GridLayout();
			layout.numColumns = 4;
			layout.verticalSpacing = 8;
			sourceComposite.setLayout(layout);
		}

		// a checkbox to specify if the source ePackage shall be specified by an ecore model
		sourceIsFileBasedButton = new Button(sourceComposite, SWT.CHECK);
		{

			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.horizontalSpan = 4;
			sourceIsFileBasedButton.setLayoutData(data);
		}

		sourceIsFileBasedButton.setText("Source ePackage is ecore-based");

		// This is necessary to allow indent for the file field editor
		sourceFileComposite = new Composite(sourceComposite, SWT.NONE);
		{			
			GridLayout layout = new GridLayout();
			layout.numColumns = 3;
			layout.verticalSpacing = 12;
			sourceFileComposite.setLayout(layout);

			GridData data = new GridData();
			data.horizontalSpan = 4;
			data.horizontalIndent = 10;
			data.horizontalAlignment = GridData.FILL;
			sourceFileComposite.setLayoutData(data);
		}

		// a file field editor to specify the source ecore model
		sourceFileFieldEditor = new FileFieldEditor("srcEcoreSelect", "", sourceFileComposite);
		sourceFileFieldEditor.setEnabled(false, sourceFileComposite);
		sourceFileFieldEditor.setLabelText("Ecore Model:");
		sourceFileFieldEditor.setFileExtensions(new String[]{"*.ecore"});
		sourceFileFieldEditor.setPropertyChangeListener(new IPropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent event) {

				HashMap<String, EPackage> packages = EPackageHelper.getEPackages(sourceFileFieldEditor.getStringValue(), true, true);
				sourceEcoreEPackages = (packages == null ? new HashMap<>() : packages);
				if(packages == null) {
					setErrorMessage("Error while analyzing ePackages in the source ecore model.");
					sourceCombo.removeAll();
				} else {
					setErrorMessage(null);
					updateSourceCombo(sourceEcoreEPackages.keySet());
				}
			}
		});

		// a combo box to select the source ePackage
		sourceCombo = new Combo(sourceComposite, SWT.BORDER);
		{
			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.horizontalSpan = 3;
			data.grabExcessHorizontalSpace = true;
			sourceCombo.setLayoutData(data);
		}

		// create a button that allows specifying another source model
		Button addButton = new Button(sourceComposite, SWT.NONE);
		addButton.setLayoutData(
				new GridData(SWT.FILL, SWT.TOP, false, false, 1, 1)
				);
		addButton.setToolTipText("Add the source EPackage...");
		//		addButton.setImage(BundleContentHelper.getBundleImage(BUNDLE_ID, "icons/add_obj.gif"));
		addButton.setText("Add...");
		addButton.addSelectionListener(new SelectionListener2() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// make sure that the specified ePackage has not been added before and marks a valid ePackage
				if(!sourceEPackages.contains(sourceCombo.getText())) {
					if(Arrays.asList(sourceCombo.getItems()).contains(sourceCombo.getText())) {

						// add the item to the list
						sourceEPackageList.add(sourceCombo.getText());
						sourceEPackages.add(sourceCombo.getText());
					}

					if(sourceIsFileBasedButton.getSelection()) {
						// set/update the path to the ecore model
						sourceEcoreModels.put(sourceCombo.getText(), sourceFileFieldEditor.getStringValue());
					}
				}
			}
		});

		// realize auto-completion for both combo viewers
		new AutoCompleteField(sourceCombo, new ComboContentAdapter(), sourceCombo.getItems());

		separator = new Label(sourceGroup, SWT.SEPARATOR | SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		sourceEPackageList = new List(sourceGroup, SWT.BORDER);
		sourceEPackageList.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		sourceEPackageList.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.keyCode == SWT.DEL && sourceEPackageList.getSelectionIndex() != -1) {
					sourceEPackages.remove(sourceEPackageList.getSelectionIndex());
					sourceEcoreModels.remove(sourceEPackageList.getSelectionIndex());
					sourceEPackageList.remove(sourceEPackageList.getSelectionIndex());
				}
			}
		});

		Group targetGroup = new Group(composite, SWT.NONE);
		targetGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		{
			targetGroup.setText("Target Sections ePackage");

			GridLayout layout = new GridLayout();
			layout.numColumns = 1;
			layout.marginWidth = marginWidth;
			layout.marginHeight = marginHeight;
			targetGroup.setLayout(layout);
		}

		final Composite targetComposite = new Composite(targetGroup, SWT.NONE);
		targetComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		{
			GridLayout layout = new GridLayout();
			layout.numColumns = numColumns;
			layout.verticalSpacing = 8;
			targetComposite.setLayout(layout);
		}

		// a checkbox to specify if the target ePackage shall be specified by an ecore model
		targetIsFileBasedButton = new Button(targetComposite, SWT.CHECK);
		{

			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.horizontalSpan = numColumns;
			targetIsFileBasedButton.setLayoutData(data);
		}

		targetIsFileBasedButton.setText("Target ePackage is ecore-based");
		targetIsFileBasedButtonSelectionListener = new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				setTargetIsFileBased(targetIsFileBasedButton.getSelection());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		};

		// This is necessary to allow indent for the file field editor
		targetFileComposite = new Composite(targetComposite, SWT.NONE);
		{			
			GridLayout layout = new GridLayout();
			layout.numColumns = 3;
			layout.verticalSpacing = 12;
			targetFileComposite.setLayout(layout);

			GridData data = new GridData();
			data.horizontalSpan = 3;
			data.horizontalIndent = 10;
			data.horizontalAlignment = GridData.FILL;
			targetFileComposite.setLayoutData(data);
		}

		// a file field editor to specify the target ecore model
		targetFileFieldEditor = new FileFieldEditor("tgtEcoreSelect", "", targetFileComposite);
		targetFileFieldEditor.setLabelText("Ecore Model:");
		targetFileFieldEditor.setFileExtensions(new String[]{"*.ecore"});
		targetFileFieldEditor.setEnabled(false, targetFileComposite);
		targetFileFieldEditor.setPropertyChangeListener(new IPropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent event) {

				HashMap<String, EPackage> packages = EPackageHelper.getEPackages(targetFileFieldEditor.getStringValue(), true, true);
				targetEcoreEPackages = (packages == null ? new HashMap<>() : packages);
				if(targetEcoreEPackages == null) {
					setErrorMessage("Error while analyzing ePackages in the target ecore model.");
					targetCombo.removeAll();
				} else {
					setErrorMessage(null);
					updateTargetCombo(targetEcoreEPackages.keySet());
				}
			}
		});

		// a combo box to select the target ePackage
		targetCombo = new Combo(targetComposite, SWT.BORDER);
		{
			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.horizontalSpan = 3;
			data.grabExcessHorizontalSpace = true;
			targetCombo.setLayoutData(data);
		}

		// create a modify listener that sets the ePackage
		targetComboModifyListener = new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				targetEPackage = (targetIsFileBasedButton.getSelection() ?
						targetEcoreEPackages.get(targetCombo.getText()) :
							registeredEPackages.getEPackage(targetCombo.getText()));
				getWizard().getContainer().updateButtons();
			}
		};

		// get all ePackages from the ePackage registry and add them
		// to both combo boxes
		updateSourceCombo(registeredEPackages.keySet());
		updateTargetCombo(registeredEPackages.keySet());
		new AutoCompleteField(targetCombo, new ComboContentAdapter(), targetCombo.getItems());

		setPageComplete(true);
		setControl(composite);
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);

		if(visible) {
			targetCombo.addModifyListener(targetComboModifyListener);
			sourceIsFileBasedButton.addSelectionListener(sourceIsFileBasedButtonSelectionListener);
			targetIsFileBasedButton.addSelectionListener(targetIsFileBasedButtonSelectionListener);
		} else {
			targetCombo.removeModifyListener(targetComboModifyListener);
			sourceIsFileBasedButton.removeSelectionListener(sourceIsFileBasedButtonSelectionListener);
			targetIsFileBasedButton.removeSelectionListener(targetIsFileBasedButtonSelectionListener);
		}
	}

	/**
	 * 
	 * @return the ePackages that shall be used for the source sections
	 */
	public HashSet<EPackage> getSourceEPackages() {
		HashSet<EPackage> ret = new HashSet<>();
		for (String nsUri : sourceEPackages) {
			if(nsUri == null) {
				continue;
			}
			EPackage ePackage = sourceEcoreEPackages.get(nsUri); 
			if(ePackage == null) {
				ePackage = EPackage.Registry.INSTANCE.getEPackage(nsUri);
			}
			ret.add(ePackage);
		}
		return ret;
	}

	/**
	 * 
	 * @return the path(s) to the ecore model(s) that define(s) the source ePackage(s)
	 */
	public Collection<String> getSourceEcorePaths() {
		return sourceEcoreModels.values();
	}

	private boolean setSourceEPackage(EPackage sourceEPackage) {

		for(int i=0; i<this.sourceCombo.getItemCount(); i++) {
			if(this.sourceCombo.getItem(i).equals(sourceEPackage.getNsURI())) {
				this.sourceCombo.select(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * Try to set the ePackage in the source combo based on a namespace URI. If the URI is not found
	 * in the global package registry, the user will have to specify an ecore model that defines the
	 * ePackage.
	 * 
	 * @param sourceEPackageString the namespace URI of the ePackage to set
	 * @return true if the ePackage has been found in the global package registry, false otherwise
	 */
	public boolean setSourceEPackage(String sourceEPackageString) {
		EPackage sourceEPackage = (EPackage) EPackage.Registry.INSTANCE.get(sourceEPackageString);
		if(sourceEPackage != null) {
			((PamtramModelWizard) getWizard()).getePackageSpecificationPage().setSourceIsFileBased(false);
			return setSourceEPackage(sourceEPackage);
		} else {
			((PamtramModelWizard) getWizard()).getePackageSpecificationPage().setSourceIsFileBased(true);
			return false;
		}
	}

	/**
	 * 
	 * @return the ePackage that shall be used for the target sections
	 */
	public EPackage getTargetEPackage() {
		return targetEPackage;
	}

	/**
	 * 
	 * @return the path to the ecore model that defines the target ePackage
	 */
	public String getTargetEcorePath() {
		return targetFileFieldEditor.getStringValue();
	}

	private void updateSourceCombo(Set<String> nsUris) {
		sourceCombo.removeAll();
		for (String nsUri : nsUris) {
			sourceCombo.add(nsUri);
		}
		if(sourceCombo.getItemCount() == 1) {
			sourceCombo.select(0);
		}
	}

	private void updateTargetCombo(Set<String> nsUris) {
		targetCombo.removeAll();
		for (String nsUri : nsUris) {
			targetCombo.add(nsUri);
		}
		if(targetCombo.getItemCount() == 1) {
			targetCombo.select(0);
		}
	}

	private void setSourceIsFileBased(boolean isFileBased) {
		// if necessary activate/deactivate the checkbox
		if(sourceIsFileBasedButton.getSelection() != isFileBased) {
			sourceIsFileBasedButton.removeSelectionListener(sourceIsFileBasedButtonSelectionListener);
			sourceIsFileBasedButton.setSelection(isFileBased);
			sourceIsFileBasedButton.addSelectionListener(sourceIsFileBasedButtonSelectionListener);
		}
		// enable/disable the source ecore file editor depending on the selection
		sourceFileFieldEditor.setEnabled(isFileBased, sourceFileComposite);
		// update the list of ePackages depending on the selection
		updateSourceCombo(isFileBased ?
				sourceEcoreEPackages.keySet():
					registeredEPackages.keySet()
				);
	}

	/**
	 * 
	 * @return true if the specified source ePackage comes from an ecore model file, false otherwise
	 */
	public boolean isSourceFileBased() {
		return sourceIsFileBasedButton.getSelection();
	}

	/**
	 * 
	 * @return true if the specified target ePackage comes from an ecore model file, false otherwise
	 */
	public boolean isTargetFileBased() {
		return targetIsFileBasedButton.getSelection();
	}

	private void setTargetIsFileBased(boolean isFileBased) {
		// if necessary activate/deactivate the checkbox
		if(targetIsFileBasedButton.getSelection() != isFileBased) {
			targetIsFileBasedButton.removeSelectionListener(targetIsFileBasedButtonSelectionListener);
			targetIsFileBasedButton.setSelection(isFileBased);
			targetIsFileBasedButton.addSelectionListener(targetIsFileBasedButtonSelectionListener);
		}
		// enable/disable the target ecore file editor depending on the selection
		targetFileFieldEditor.setEnabled(isFileBased, targetFileComposite);
		// update the list of ePackages depending on the selection
		updateTargetCombo(isFileBased ?
				targetEcoreEPackages.keySet():
					registeredEPackages.keySet()
				);
	}

	@Override
	public boolean isPageComplete() {
		return (sourceEPackageList.getItemCount() > 0 && targetEPackage != null);
	}

	/**
	 * Add a collection of namespace URIs to the list of source EPackages.
	 * 
	 * @param nsUris
	 */
	public void addSourceEPackages(Collection<String> nsUris) {
		for (String nsUri : nsUris) {
			sourceEPackages.add(nsUri);
			sourceEPackageList.add(nsUri);
			if(!registeredEPackages.containsKey(nsUri)) {
				sourceEcoreEPackages.put(nsUri, null);
			}
			sourceCombo.getText();
		}
	}


}
