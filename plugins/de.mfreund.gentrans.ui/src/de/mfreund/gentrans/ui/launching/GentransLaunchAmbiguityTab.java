package de.mfreund.gentrans.ui.launching;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;

public class GentransLaunchAmbiguityTab extends AbstractLaunchConfigurationTab {


	private DataBindingContext m_bindingContext;
	private Button btnUseSpecificTransformation;
	private Combo comboSelectTransformation;
	private Button btnUseLatestTransformation;
	private Button btnEnableHistory;
	private Composite historyComposite;

	/**
	 * This keeps track of the various settings to be changed in this tab.
	 */
	private GentransLaunchContext context = new GentransLaunchContext();
	private Button btnEnableUser;

	public GentransLaunchAmbiguityTab(GentransLaunchContext context) {
		this.context = context;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void createControl(Composite parent) {

		// a composite to host all other controls
		Composite comp = new Composite(parent, SWT.NONE);
		setControl(comp);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(getControl(), getHelpContextId());
		comp.setLayout(new GridLayout(2, true));
		comp.setFont(parent.getFont());

		// a group to contain all settings for ambiguity resolving strategies
		Group ambiguityStrategyGroup = new Group(comp, SWT.NONE);
		ambiguityStrategyGroup.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		ambiguityStrategyGroup.setText("Strategies");
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).span(2, 1).applyTo(ambiguityStrategyGroup);
		GridLayoutFactory.swtDefaults().numColumns(2).applyTo(ambiguityStrategyGroup);
		ambiguityStrategyGroup.setLayout(new GridLayout(2, false));

		btnEnableHistory = new Button(ambiguityStrategyGroup, SWT.CHECK);
		btnEnableHistory.setToolTipText("Enable to use a strategy that resolves ambiguities based on previous decisions stored in a transformation model...");
		btnEnableHistory.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 3, 1));
		btnEnableHistory.setAlignment(SWT.CENTER);
		btnEnableHistory.setText("History Strategy");

		historyComposite = new Composite(ambiguityStrategyGroup, SWT.NONE);
		GridLayout gl_historyComposite = new GridLayout(2, false);
		gl_historyComposite.marginLeft = 10;
		historyComposite.setLayout(gl_historyComposite);
		historyComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		btnUseLatestTransformation = new Button(historyComposite, SWT.RADIO);
		btnUseLatestTransformation.setSelection(true);
		btnUseLatestTransformation.setToolTipText("Always use the latest stored transformation model to resolve ambiguities");
		btnUseLatestTransformation.setText("Use latest transformation model");
		new Label(historyComposite, SWT.NONE);

		btnUseSpecificTransformation = new Button(historyComposite, SWT.RADIO);
		btnUseSpecificTransformation.setToolTipText("Use a specific transformation model to resolve ambiguities");
		btnUseSpecificTransformation.setText("Use specific transformation model");

		comboSelectTransformation = new Combo(historyComposite, SWT.NONE);
		comboSelectTransformation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		comboSelectTransformation.setEnabled(false);
		comboSelectTransformation.setItems(new String[] {"a", "b"});

		Label label = new Label(ambiguityStrategyGroup, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));

		btnEnableUser = new Button(ambiguityStrategyGroup, SWT.CHECK);
		btnEnableUser.setSelection(true);
		btnEnableUser.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		btnEnableUser.setToolTipText("Enable to use a strategy that resolves ambiguities based on user decisions...");
		btnEnableUser.setText("User Decision Strategy");
		btnEnableUser.setAlignment(SWT.CENTER);
		m_bindingContext = initDataBindings();


	}



	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
	}

	@Override
	public String getName() {
		return "Ambiguity resolving";
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeEnabledComboSelectTransformationObserveWidget_1 = WidgetProperties.enabled().observe(comboSelectTransformation);
		IObservableValue observeSelectionBtnEnableHistoryObserveWidget_2 = WidgetProperties.selection().observe(btnEnableHistory);
		bindingContext.bindValue(observeEnabledComboSelectTransformationObserveWidget_1, observeSelectionBtnEnableHistoryObserveWidget_2, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledBtnUseLatestTransformationObserveWidget = WidgetProperties.enabled().observe(btnUseLatestTransformation);
		IObservableValue observeSelectionBtnEnableHistoryObserveWidget = WidgetProperties.selection().observe(btnEnableHistory);
		bindingContext.bindValue(observeEnabledBtnUseLatestTransformationObserveWidget, observeSelectionBtnEnableHistoryObserveWidget, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledBtnUseSpecificTransformationObserveWidget = WidgetProperties.enabled().observe(btnUseSpecificTransformation);
		IObservableValue observeSelectionBtnEnableHistoryObserveWidget_1 = WidgetProperties.selection().observe(btnEnableHistory);
		bindingContext.bindValue(observeEnabledBtnUseSpecificTransformationObserveWidget, observeSelectionBtnEnableHistoryObserveWidget_1, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeSelectionBtnEnableHistoryObserveWidget_3 = WidgetProperties.selection().observe(btnEnableHistory);
		IObservableValue enableHistoryAmbiguityResolvingContextObserveValue = BeanProperties.value("enableHistory").observe(context);
		bindingContext.bindValue(observeSelectionBtnEnableHistoryObserveWidget_3, enableHistoryAmbiguityResolvingContextObserveValue, null, null);
		//
		IObservableValue observeSelectionBtnEnableUserObserveWidget = WidgetProperties.selection().observe(btnEnableUser);
		IObservableValue enableUserAmbiguityResolvingContextObserveValue = BeanProperties.value("enableUser").observe(context);
		bindingContext.bindValue(observeSelectionBtnEnableUserObserveWidget, enableUserAmbiguityResolvingContextObserveValue, null, null);
		//
		IObservableValue observeSelectionBtnUseSpecificTransformationObserveWidget = WidgetProperties.selection().observe(btnUseSpecificTransformation);
		IObservableValue useSpecificTransformationModelAmbiguityResolvingContextObserveValue = BeanProperties.value("useSpecificTransformationModel").observe(context);
		bindingContext.bindValue(observeSelectionBtnUseSpecificTransformationObserveWidget, useSpecificTransformationModelAmbiguityResolvingContextObserveValue, null, null);
		//
		IObservableList itemsComboSelectTransformationObserveWidget = WidgetProperties.items().observe(comboSelectTransformation);
		IObservableList modelsToChooseFromContextObserveList = BeanProperties.list("modelsToChooseFrom").observe(context);
		bindingContext.bindList(itemsComboSelectTransformationObserveWidget, modelsToChooseFromContextObserveList, null, null);
		//
		IObservableValue observeSelectionComboSelectTransformationObserveWidget = WidgetProperties.selection().observe(comboSelectTransformation);
		IObservableValue transformationModelToUseContextObserveValue = BeanProperties.value("transformationModelToUse").observe(context);
		bindingContext.bindValue(observeSelectionComboSelectTransformationObserveWidget, transformationModelToUseContextObserveValue, null, null);
		//
		return bindingContext;
	}
}
