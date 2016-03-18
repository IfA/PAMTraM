package de.mfreund.gentrans.ui.launching;

import java.util.Arrays;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
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
	private Button btnHandleExpandingCardinalities;
	private Composite historyComposite;
	private Composite userComposite;

	/**
	 * The domain model that this tab operates on.
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
		btnEnableHistory.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		historyComposite = new Composite(ambiguityStrategyGroup, SWT.NONE);
		GridLayout gl_historyComposite = new GridLayout(2, false);
		gl_historyComposite.marginLeft = 10;
		historyComposite.setLayout(gl_historyComposite);
		historyComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		btnUseLatestTransformation = new Button(historyComposite, SWT.RADIO);
		btnUseLatestTransformation.setSelection(true);
		btnUseLatestTransformation.setToolTipText("Always use the latest stored transformation model to resolve ambiguities");
		btnUseLatestTransformation.setText("Use latest transformation model");
		btnUseLatestTransformation.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		new Label(historyComposite, SWT.NONE);

		btnUseSpecificTransformation = new Button(historyComposite, SWT.RADIO);
		btnUseSpecificTransformation.setToolTipText("Use a specific transformation model to resolve ambiguities");
		btnUseSpecificTransformation.setText("Use specific transformation model");
		btnUseSpecificTransformation.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		comboSelectTransformation = new Combo(historyComposite, SWT.NONE);
		comboSelectTransformation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		comboSelectTransformation.setEnabled(false);
		comboSelectTransformation.setItems(new String[] {"a", "b"});
		comboSelectTransformation.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		Label label = new Label(ambiguityStrategyGroup, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));

		btnEnableUser = new Button(ambiguityStrategyGroup, SWT.CHECK);
		btnEnableUser.setSelection(true);
		btnEnableUser.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		btnEnableUser.setToolTipText("Enable to use a strategy that resolves ambiguities based on user decisions...");
		btnEnableUser.setText("User Decision Strategy");
		btnEnableUser.setAlignment(SWT.CENTER);
		btnEnableUser.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		userComposite = new Composite(ambiguityStrategyGroup, SWT.NONE);
		GridLayout gl_userComposite = new GridLayout(2, false);
		gl_userComposite.marginLeft = 10;
		userComposite.setLayout(gl_userComposite);
		userComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		btnHandleExpandingCardinalities = new Button(userComposite, SWT.CHECK);
		btnHandleExpandingCardinalities.setSelection(true);
		btnHandleExpandingCardinalities.setEnabled(false);
		btnHandleExpandingCardinalities.setToolTipText("Also handle ambiguities that occur during the expanding step "
				+ "(Warning: This might lead to many user dialogs!)...");
		btnHandleExpandingCardinalities.setText("Handle expanding ambiguities");
		new Label(userComposite, SWT.NONE);
		btnHandleExpandingCardinalities.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		m_bindingContext = initDataBindings();

	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// set the enableHistory attribute
		configuration.setAttribute("enableHistory", false);

		// set the transformationModel attribute
		configuration.setAttribute("transformationModel", "");

		// set the enableUser attribute
		configuration.setAttribute("enableUser", false);
		
		// set the handleExpanding attribute
		configuration.setAttribute("handleExpanding", false);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			// set the enableHistory/User fields in the context
			//			context.setEnableHistory(configuration.getAttribute("enableHistory", false));
			btnEnableHistory.setSelection(configuration.getAttribute("enableHistory", false));
			//			context.setEnableUser(configuration.getAttribute("enableUser", true));
			btnEnableUser.setSelection(configuration.getAttribute("enableUser", true));
			btnHandleExpandingCardinalities.setSelection(configuration.getAttribute("handleExpanding", false));

			// udpate the selection of the selectTransformation combo
			String transformationToUse = configuration.getAttribute("transformationModel", "");
			btnUseLatestTransformation.setSelection(transformationToUse.isEmpty());
			btnUseLatestTransformation.setEnabled(configuration.getAttribute("enableHistory", false));
			btnUseSpecificTransformation.setSelection(!transformationToUse.isEmpty());
			btnUseSpecificTransformation.setEnabled(configuration.getAttribute("enableHistory", false));
			String[] transformationsToChooseFrom = comboSelectTransformation.getItems();
			int index = Arrays.asList(transformationsToChooseFrom).indexOf(transformationToUse);
			if(index == -1 ) {
				comboSelectTransformation.deselectAll();
			} else {
				comboSelectTransformation.select(index);
			}
			comboSelectTransformation.setEnabled(configuration.getAttribute("enableHistory", false));
		} catch (CoreException e) {
			setErrorMessage(e.getMessage());
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		// set the enableHistory attribute
		configuration.setAttribute("enableHistory", btnEnableHistory.getSelection());

		// set the transformationModel attribute
		configuration.setAttribute("transformationModel", btnEnableHistory.getSelection() && btnUseSpecificTransformation.getSelection() ? comboSelectTransformation.getText() : "");

		// set the enableUser attribute
		configuration.setAttribute("enableUser", btnEnableUser.getSelection());
		
		// set the handleExpanding attribute
		configuration.setAttribute("handleExpanding", btnHandleExpandingCardinalities.getSelection());

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
		IObservableValue observeEnabledBtnHandleExpandingCardinalitiesObserveWidget = WidgetProperties.enabled().observe(btnHandleExpandingCardinalities);
		IObservableValue observeSelectionBtnEnableUserObserveWidget_1 = WidgetProperties.selection().observe(btnEnableUser);
		bindingContext.bindValue(observeEnabledBtnHandleExpandingCardinalitiesObserveWidget, observeSelectionBtnEnableUserObserveWidget_1, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeSelectionBtnHandleExpandingCardinalitiesObserveWidget = WidgetProperties.selection().observe(btnHandleExpandingCardinalities);
		IObservableValue handleExpandingAmbiguitiesContextObserveValue = BeanProperties.value("handleExpandingAmbiguities").observe(context);
		bindingContext.bindValue(observeSelectionBtnHandleExpandingCardinalitiesObserveWidget, handleExpandingAmbiguitiesContextObserveValue, null, null);
		//
		return bindingContext;
	}
}
