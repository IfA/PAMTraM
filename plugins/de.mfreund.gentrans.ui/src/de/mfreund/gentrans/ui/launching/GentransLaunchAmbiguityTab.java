package de.mfreund.gentrans.ui.launching;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.bindings.Binding;
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
import org.eclipse.swt.widgets.Scale;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wb.swt.SWTResourceManager;

import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;

public class GentransLaunchAmbiguityTab extends AbstractLaunchConfigurationTab {


	private Button btnUseSpecificTransformation;
	private Combo comboSelectTransformation;
	private Button btnUseLatestTransformation;
	private Button btnEnableHistory;

	private Button btnEnableStatistics;
	private Button btnHandleExpandingCardinalities;
	private Composite historyComposite;

	private Composite statisticsComposite;

	private Scale scaleStatisticsFactor;
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
		this.setControl(comp);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(this.getControl(), this.getHelpContextId());
		comp.setLayout(new GridLayout(2, true));
		comp.setFont(parent.getFont());

		// a group to contain all settings for ambiguity resolving strategies
		Group ambiguityStrategyGroup = new Group(comp, SWT.NONE);
		ambiguityStrategyGroup.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		ambiguityStrategyGroup.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		ambiguityStrategyGroup.setText("Strategies");
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).span(2, 1).applyTo(ambiguityStrategyGroup);
		GridLayoutFactory.swtDefaults().numColumns(2).applyTo(ambiguityStrategyGroup);
		ambiguityStrategyGroup.setLayout(new GridLayout(2, false));

		this.btnEnableHistory = new Button(ambiguityStrategyGroup, SWT.CHECK);
		this.btnEnableHistory.setToolTipText("Enable to use a strategy that resolves ambiguities based on previous decisions stored in a transformation model...");
		this.btnEnableHistory.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 3, 1));
		this.btnEnableHistory.setAlignment(SWT.CENTER);
		this.btnEnableHistory.setText("History Strategy");
		this.btnEnableHistory.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				GentransLaunchAmbiguityTab.this.updateLaunchConfigurationDialog();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		this.historyComposite = new Composite(ambiguityStrategyGroup, SWT.NONE);
		GridLayout gl_historyComposite = new GridLayout(2, false);
		gl_historyComposite.marginLeft = 10;
		this.historyComposite.setLayout(gl_historyComposite);
		this.historyComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		this.btnUseLatestTransformation = new Button(this.historyComposite, SWT.RADIO);
		this.btnUseLatestTransformation.setSelection(true);
		this.btnUseLatestTransformation.setToolTipText("Always use the latest stored transformation model to resolve ambiguities");
		this.btnUseLatestTransformation.setText("Use latest transformation model");
		this.btnUseLatestTransformation.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				GentransLaunchAmbiguityTab.this.updateLaunchConfigurationDialog();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		new Label(this.historyComposite, SWT.NONE);

		this.btnUseSpecificTransformation = new Button(this.historyComposite, SWT.RADIO);
		this.btnUseSpecificTransformation.setToolTipText("Use a specific transformation model to resolve ambiguities");
		this.btnUseSpecificTransformation.setText("Use specific transformation model");
		this.btnUseSpecificTransformation.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				GentransLaunchAmbiguityTab.this.updateLaunchConfigurationDialog();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		this.comboSelectTransformation = new Combo(this.historyComposite, SWT.NONE);
		this.comboSelectTransformation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		this.comboSelectTransformation.setEnabled(false);
		this.comboSelectTransformation.setItems(new String[] {"a", "b"});
		this.comboSelectTransformation.addSelectionListener((SelectionListener2) e -> GentransLaunchAmbiguityTab.this.updateLaunchConfigurationDialog());

		Label label = new Label(ambiguityStrategyGroup, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));

		this.btnEnableStatistics = new Button(ambiguityStrategyGroup, SWT.CHECK);
		this.btnEnableStatistics.setSelection(true);
		this.btnEnableStatistics.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		this.btnEnableStatistics.setToolTipText(
				"Enable to use a strategy that resolves ambiguities based on statistical evaluations of previous selections...");
		this.btnEnableStatistics.setText("Statistics Strategy");
		this.btnEnableStatistics.setAlignment(SWT.CENTER);
		this.btnEnableStatistics.addSelectionListener((SelectionListener2) e -> GentransLaunchAmbiguityTab.this.updateLaunchConfigurationDialog());

		this.statisticsComposite = new Composite(ambiguityStrategyGroup, SWT.NONE);
		GridLayout gl_statisticsComposite = new GridLayout(4, false);
		gl_statisticsComposite.marginLeft = 10;
		this.statisticsComposite.setLayout(gl_statisticsComposite);
		this.statisticsComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		Label labelWeightingFactor = new Label(this.statisticsComposite, SWT.HORIZONTAL);
		labelWeightingFactor.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		labelWeightingFactor.setText("Auswertungsebene (Wichtungsfaktor): ");

		Label labelMetaModelLevel = new Label(this.statisticsComposite, SWT.HORIZONTAL);
		labelMetaModelLevel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		labelMetaModelLevel.setText("Metamodell");

		this.scaleStatisticsFactor = new Scale(this.statisticsComposite, SWT.HORIZONTAL);
		this.scaleStatisticsFactor.setMinimum(0);
		this.scaleStatisticsFactor.setMaximum(100);
		this.scaleStatisticsFactor.setSelection(50);
		this.scaleStatisticsFactor.setEnabled(false);
		this.scaleStatisticsFactor.setToolTipText(
				"The weighting factor to be used for statistics that can be evaluated on mapping model or meta-model level (0: statistics "
						+ "will only be evaluated on the meta-model level; 100: statistics will only be evaluated on the mapping level)");
		this.scaleStatisticsFactor.addSelectionListener(
				(SelectionListener2) e -> GentransLaunchAmbiguityTab.this.updateLaunchConfigurationDialog());

		Label labelMappingModelLevel = new Label(this.statisticsComposite, SWT.HORIZONTAL);
		labelMappingModelLevel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		labelMappingModelLevel.setText("Mapping-Modell");

		this.btnEnableUser = new Button(ambiguityStrategyGroup, SWT.CHECK);
		this.btnEnableUser.setSelection(true);
		this.btnEnableUser.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		this.btnEnableUser.setToolTipText("Enable to use a strategy that resolves ambiguities based on user decisions...");
		this.btnEnableUser.setText("User Decision Strategy");
		this.btnEnableUser.setAlignment(SWT.CENTER);
		this.btnEnableUser.addSelectionListener((SelectionListener2) e -> GentransLaunchAmbiguityTab.this.updateLaunchConfigurationDialog());

		this.userComposite = new Composite(ambiguityStrategyGroup, SWT.NONE);
		GridLayout gl_userComposite = new GridLayout(2, false);
		gl_userComposite.marginLeft = 10;
		this.userComposite.setLayout(gl_userComposite);
		this.userComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		this.btnHandleExpandingCardinalities = new Button(this.userComposite, SWT.CHECK);
		this.btnHandleExpandingCardinalities.setSelection(true);
		this.btnHandleExpandingCardinalities.setEnabled(false);
		this.btnHandleExpandingCardinalities.setToolTipText("Also handle ambiguities that occur during the expanding step "
				+ "(Warning: This might lead to many user dialogs!)...");
		this.btnHandleExpandingCardinalities.setText("Handle expanding ambiguities");
		new Label(this.userComposite, SWT.NONE);
		this.btnHandleExpandingCardinalities.addSelectionListener((SelectionListener2) e -> GentransLaunchAmbiguityTab.this.updateLaunchConfigurationDialog());

		this.initDataBindings();

	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// set the enableHistory attribute
		configuration.setAttribute("enableHistory", false);

		// set the transformationModel attribute
		configuration.setAttribute("transformationModel", "");

		// set the enableStatistics attribute
		configuration.setAttribute("enableStatistics", false);

		// set the weightingFactor attribute
		configuration.setAttribute("weightingFactor", 50);

		// set the enableUser attribute
		configuration.setAttribute("enableUser", false);

		// set the handleExpanding attribute
		configuration.setAttribute("handleExpanding", false);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			// set the enableHistory/User fields in the context
			this.btnEnableHistory.setSelection(configuration.getAttribute("enableHistory", false));

			this.btnEnableStatistics.setSelection(configuration.getAttribute("enableStatistics", false));
			this.scaleStatisticsFactor.setEnabled(configuration.getAttribute("enableStatistics", false));
			this.scaleStatisticsFactor.setSelection(configuration.getAttribute("weightingFactor", 50));

			this.btnEnableUser.setSelection(configuration.getAttribute("enableUser", true));
			this.btnHandleExpandingCardinalities.setSelection(configuration.getAttribute("handleExpanding", false));

			// udpate the selection of the selectTransformation combo
			String transformationToUse = configuration.getAttribute("transformationModel", "");
			this.btnUseLatestTransformation.setSelection(transformationToUse.isEmpty());
			this.btnUseLatestTransformation.setEnabled(configuration.getAttribute("enableHistory", false));
			this.btnUseSpecificTransformation.setSelection(!transformationToUse.isEmpty());
			this.btnUseSpecificTransformation.setEnabled(configuration.getAttribute("enableHistory", false));
			String[] transformationsToChooseFrom = this.comboSelectTransformation.getItems();
			int index = Arrays.asList(transformationsToChooseFrom).indexOf(transformationToUse);
			if(index == -1 ) {
				this.comboSelectTransformation.deselectAll();
			} else {
				this.comboSelectTransformation.select(index);
			}
			this.comboSelectTransformation.setEnabled(configuration.getAttribute("enableHistory", false));
		} catch (CoreException e) {
			this.setErrorMessage(e.getMessage());
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		// set the enableHistory attribute
		configuration.setAttribute("enableHistory", this.btnEnableHistory.getSelection());

		// set the transformationModel attribute
		configuration.setAttribute("transformationModel", this.btnEnableHistory.getSelection() && this.btnUseSpecificTransformation.getSelection() ? this.comboSelectTransformation.getText() : "");

		// set the enableStatistics attribute
		configuration.setAttribute("enableStatistics", this.btnEnableStatistics.getSelection());

		// set the weightingFactor attribute
		configuration.setAttribute("weightingFactor", this.scaleStatisticsFactor.getSelection());

		// set the enableUser attribute
		configuration.setAttribute("enableUser", this.btnEnableUser.getSelection());

		// set the handleExpanding attribute
		configuration.setAttribute("handleExpanding", this.btnHandleExpandingCardinalities.getSelection());

	}

	@Override
	public String getName() {
		return "Ambiguity resolving";
	}

	/**
	 * Initialize all {@link Binding data bindings} between the various widgets displayed on this tab and the
	 * {@link #context} as well as among widgets.
	 *
	 */
	@SuppressWarnings("unchecked")
	protected void initDataBindings() {

		// The context where all bindings will be registered
		//
		DataBindingContext bindingContext = new DataBindingContext();

		// The various observable values for widget properties
		//
		IObservableValue<Boolean> observeSelectionBtnEnableHistoryObserveWidget = WidgetProperties.selection()
				.observe(this.btnEnableHistory);
		IObservableValue<Boolean> observeEnabledBtnUseLatestTransformationObserveWidget = WidgetProperties.enabled()
				.observe(this.btnUseLatestTransformation);
		IObservableValue<Boolean> observeEnabledBtnUseSpecificTransformationObserveWidget = WidgetProperties.enabled()
				.observe(this.btnUseSpecificTransformation);
		IObservableValue<Boolean> observeSelectionBtnUseSpecificTransformationObserveWidget = WidgetProperties
				.selection().observe(this.btnUseSpecificTransformation);
		IObservableValue<Boolean> observeEnabledComboSelectTransformationObserveWidget = WidgetProperties.enabled()
				.observe(this.comboSelectTransformation);
		IObservableValue<Boolean> observeSelectionComboSelectTransformationObserveWidget = WidgetProperties.selection()
				.observe(this.comboSelectTransformation);
		IObservableList<List<?>> itemsComboSelectTransformationObserveWidget = WidgetProperties.items()
				.observe(this.comboSelectTransformation);

		IObservableValue<Boolean> observeSelectionBtnEnableStatisticsObserveWidget = WidgetProperties.selection()
				.observe(this.btnEnableStatistics);
		IObservableValue<Boolean> observeEnabledScaleStatisticsObserveWidget = WidgetProperties.enabled()
				.observe(this.scaleStatisticsFactor);
		IObservableValue<Integer> observeSelectionScaleStatisticsFactorObserveWidget = WidgetProperties.selection()
				.observe(this.scaleStatisticsFactor);

		IObservableValue<Boolean> observeSelectionBtnEnableUserObserveWidget = WidgetProperties.selection()
				.observe(this.btnEnableUser);
		IObservableValue<Boolean> observeEnabledBtnHandleExpandingCardinalitiesObserveWidget = WidgetProperties
				.enabled().observe(this.btnHandleExpandingCardinalities);
		IObservableValue<Boolean> observeSelectionBtnHandleExpandingCardinalitiesObserveWidget = WidgetProperties
				.selection().observe(this.btnHandleExpandingCardinalities);

		// The various observable values for bean properties
		//
		IObservableValue<Boolean> enableHistoryAmbiguityResolvingContextObserveValue = BeanProperties
				.value("enableHistory").observe(this.context);
		IObservableValue<Boolean> useSpecificTransformationModelAmbiguityResolvingContextObserveValue = BeanProperties
				.value("useSpecificTransformationModel").observe(this.context);
		IObservableValue<Boolean> transformationModelToUseContextObserveValue = BeanProperties
				.value("transformationModelToUse").observe(this.context);
		IObservableList<List<?>> modelsToChooseFromContextObserveList = BeanProperties.list("modelsToChooseFrom")
				.observe(this.context);

		IObservableValue<Boolean> enableStatisticsAmbiguityResolvingContextObserveValue = BeanProperties
				.value("enableStatistics").observe(this.context);
		IObservableValue<Integer> scaleStatisticsFactorContextObserveValue = BeanProperties.value("weightingFactor")
				.observe(this.context);

		IObservableValue<Boolean> enableUserAmbiguityResolvingContextObserveValue = BeanProperties.value("enableUser")
				.observe(this.context);
		IObservableValue<Boolean> handleExpandingAmbiguitiesContextObserveValue = BeanProperties
				.value("handleExpandingAmbiguities").observe(this.context);

		// Enable the bindings among widgets
		//
		bindingContext.bindValue(observeEnabledComboSelectTransformationObserveWidget,
				observeSelectionBtnEnableHistoryObserveWidget,
				new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		bindingContext.bindValue(observeEnabledBtnUseLatestTransformationObserveWidget,
				observeSelectionBtnEnableHistoryObserveWidget,
				new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		bindingContext.bindValue(observeEnabledBtnUseSpecificTransformationObserveWidget,
				observeSelectionBtnEnableHistoryObserveWidget,
				new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		bindingContext.bindValue(observeEnabledScaleStatisticsObserveWidget,
				observeSelectionBtnEnableStatisticsObserveWidget,
				new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		bindingContext.bindValue(observeEnabledBtnHandleExpandingCardinalitiesObserveWidget,
				observeSelectionBtnEnableUserObserveWidget, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER),
				null);

		// Enable the bindings between widgets and the context
		//
		bindingContext.bindValue(observeSelectionBtnEnableHistoryObserveWidget,
				enableHistoryAmbiguityResolvingContextObserveValue, null, null);
		bindingContext.bindValue(observeSelectionBtnEnableStatisticsObserveWidget,
				enableStatisticsAmbiguityResolvingContextObserveValue, null, null);
		bindingContext.bindValue(observeSelectionScaleStatisticsFactorObserveWidget,
				scaleStatisticsFactorContextObserveValue, null, null);
		bindingContext.bindValue(observeSelectionBtnEnableUserObserveWidget, enableUserAmbiguityResolvingContextObserveValue, null, null);
		bindingContext.bindValue(observeSelectionBtnUseSpecificTransformationObserveWidget, useSpecificTransformationModelAmbiguityResolvingContextObserveValue, null, null);
		bindingContext.bindList(itemsComboSelectTransformationObserveWidget, modelsToChooseFromContextObserveList, null, null);
		bindingContext.bindValue(observeSelectionComboSelectTransformationObserveWidget, transformationModelToUseContextObserveValue, null, null);
		bindingContext.bindValue(observeSelectionBtnHandleExpandingCardinalitiesObserveWidget, handleExpandingAmbiguitiesContextObserveValue, null, null);
	}
}
