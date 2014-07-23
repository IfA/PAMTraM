package pamtram.presentation.pages;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.fieldassist.AutoCompleteField;
import org.eclipse.jface.fieldassist.ComboContentAdapter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * This is the page where the ePackage of the source and target
 * sections can be selected.
 */
public class PamtramEPackageSpecificationPage extends WizardPage {

	public PamtramEPackageSpecificationPage(String pageName) {
		super(pageName);
	}
	
	private EPackage sourceEPackage, targetEPackage;

	@Override
	public void createControl(Composite parent) {
		
		Composite composite = new Composite(parent, SWT.NONE); {
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
		
		// a label for the source combo box
		Label sourceLabel = new Label(composite, SWT.LEFT);
		{
			sourceLabel.setText("Source Sections ePackage:");

			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			sourceLabel.setLayoutData(data);
		}

		// a combo box to select the source ePackage
		final Combo sourceCombo = new Combo(composite, SWT.BORDER);
		{
			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			sourceCombo.setLayoutData(data);
		}
		
		// add a modify listener that sets the ePackage
		sourceCombo.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				sourceEPackage = 
						EPackage.Registry.INSTANCE.getEPackage(sourceCombo.getText());					
			}
		});

		// a label for the target combo box
		Label targetLabel = new Label(composite, SWT.LEFT);
		{
			targetLabel.setText("Target Sections ePackage:");

			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			targetLabel.setLayoutData(data);
		}

		// a combo box to select the target ePackage
		final Combo targetCombo = new Combo(composite, SWT.BORDER);
		{
			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			targetCombo.setLayoutData(data);
		}
		
		// add a modify listener that sets the ePackage
		targetCombo.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				targetEPackage = 
						EPackage.Registry.INSTANCE.getEPackage(targetCombo.getText());					
			}
		});

		// get all ePackages from the ePackage registry and add them
		// to both combo boxes
		for (String nsUri : EPackage.Registry.INSTANCE.keySet()) {
			sourceCombo.add(nsUri);
			targetCombo.add(nsUri);
		}
		
		// realize auto-completion for both combo viewers
		new AutoCompleteField(sourceCombo, new ComboContentAdapter(), sourceCombo.getItems());
		new AutoCompleteField(targetCombo, new ComboContentAdapter(), targetCombo.getItems());
		
		setPageComplete(true);
		setControl(composite);
	}
	
	public EPackage getSourceEPackage() {
		return sourceEPackage;
	}
	
	public EPackage getTargetEPackage() {
		return targetEPackage;
	}
	
}
