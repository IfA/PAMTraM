/*******************************************************************************
 * Copyright (C) 2015-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.gentrans.ui.launching;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.debug.ui.ILaunchConfigurationTab2;
import org.eclipse.jface.bindings.Binding;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wb.swt.SWTResourceManager;

import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import pamtram.provider.PamtramEditPlugin;

/**
 * An {@link ILaunchConfigurationTab2} that allows to customize the ambiguity
 * resolving strategies to be applied during a GenTrans transformation.
 *
 * @author mfreund
 */
public class GentransLaunchAmbiguityTab extends AbstractLaunchConfigurationTab {

	/**
	 * The name of the folder in the PAMTraM project where the PAMTraM files are
	 * located.
	 */
	private static final String PAMTRAM_FOLDER = PamtramEditPlugin.INSTANCE.getString("PAMTRAM_FOLDER_NAME");

	/**
	 * The name of the folder in the PAMTraM folder where transformation models
	 * are stored.
	 */
	private static final String TRANSFORMATION_MODEL_FOLDER = "transformation";

	private Button btnEnableHistory;

	private Button btnUseLatestTransformation;

	private Button btnUseSpecificTransformation;

	private Combo comboSelectTransformation;

	private Button btnEnableStatistics;

	private Scale scaleStatisticsFactor;

	private Button btnEnableUser;

	private Button btnHandleExpandingAmbiguities;

	/**
	 * The domain model that this tab operates on.
	 */
	private GentransLaunchContext context;

	/**
	 * The {@link DataBindingContext} that is used to realize all data bindings
	 * among widgets and between widgets and the {@link #context}.
	 */
	private DataBindingContext bindingContext;

	/**
	 * This creates an instance.
	 *
	 * @param context
	 *            The {@link GentransLaunchContext} that shall be used for data
	 *            bindings to the various widgets.
	 */
	public GentransLaunchAmbiguityTab(GentransLaunchContext context) {
		this.context = context;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void createControl(Composite parent) {

		// a composite to host all other controls
		//
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setFont(parent.getFont());
		this.setControl(comp);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(this.getControl(), this.getHelpContextId());
		GridLayoutFactory.swtDefaults().numColumns(2).equalWidth(true).applyTo(comp);

		// a group to contain all settings for ambiguity resolving strategies
		//
		Group ambiguityStrategyGroup = new Group(comp, SWT.NONE);
		ambiguityStrategyGroup.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		ambiguityStrategyGroup.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		ambiguityStrategyGroup.setText("Strategies");
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).span(2, 1)
				.applyTo(ambiguityStrategyGroup);
		GridLayoutFactory.swtDefaults().numColumns(2).applyTo(ambiguityStrategyGroup);

		// a button to enable/disable the HistoryStrategy
		//
		this.btnEnableHistory = new Button(ambiguityStrategyGroup, SWT.CHECK);
		this.btnEnableHistory.setToolTipText(
				"Enable to use a strategy that resolves ambiguities based on previous decisions stored in a transformation model...");
		this.btnEnableHistory.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 3, 1));
		this.btnEnableHistory.setText("TraceabilityLink Strategy");
		this.btnEnableHistory.addSelectionListener(
				(SelectionListener2) e -> GentransLaunchAmbiguityTab.this.updateLaunchConfigurationDialog());

		// a composite for additional setting to customize the HistoryStrategy
		//
		Composite historyComposite = new Composite(ambiguityStrategyGroup, SWT.NONE);
		GridLayoutFactory.swtDefaults().numColumns(2).extendedMargins(10, 0, 0, 0).applyTo(historyComposite);
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).span(2, 1)
				.applyTo(historyComposite);

		// a button to control the use of the latest transformation model in the
		// HistoryStrategy
		//
		this.btnUseLatestTransformation = new Button(historyComposite, SWT.RADIO);
		this.btnUseLatestTransformation.setSelection(true);
		this.btnUseLatestTransformation
				.setToolTipText("Always use the latest stored transformation model to resolve ambiguities");
		this.btnUseLatestTransformation.setText("Use latest transformation model");
		this.btnUseLatestTransformation.addSelectionListener(
				(SelectionListener2) e -> GentransLaunchAmbiguityTab.this.updateLaunchConfigurationDialog());

		// just to fill the grid
		//
		new Label(historyComposite, SWT.NONE);

		// a button to control the use of a specific transformation model in the
		// HistoryStrategy
		//
		this.btnUseSpecificTransformation = new Button(historyComposite, SWT.RADIO);
		this.btnUseSpecificTransformation.setToolTipText("Use a specific transformation model to resolve ambiguities");
		this.btnUseSpecificTransformation.setText("Use specific transformation model");
		this.btnUseSpecificTransformation.addSelectionListener(
				(SelectionListener2) e -> GentransLaunchAmbiguityTab.this.updateLaunchConfigurationDialog());

		// a combo to select the transformation model to be used in the
		// HistoryStrategy
		//
		this.comboSelectTransformation = new Combo(historyComposite, SWT.NONE);
		this.comboSelectTransformation.setEnabled(false);
		this.comboSelectTransformation.addSelectionListener(
				(SelectionListener2) e -> GentransLaunchAmbiguityTab.this.updateLaunchConfigurationDialog());
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false)
				.applyTo(this.comboSelectTransformation);

		// just a separator
		//
		Label separator1 = new Label(ambiguityStrategyGroup, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).span(3, 1).applyTo(separator1);

		// a button to enable/disable the StatisticsStrategy
		//
		this.btnEnableStatistics = new Button(ambiguityStrategyGroup, SWT.CHECK);
		this.btnEnableStatistics.setSelection(true);
		this.btnEnableStatistics.setToolTipText(
				"Enable to use a strategy that resolves ambiguities based on statistical evaluations of previous selections...");
		this.btnEnableStatistics.setText("Statistics Strategy");
		this.btnEnableStatistics.addSelectionListener(
				(SelectionListener2) e -> GentransLaunchAmbiguityTab.this.updateLaunchConfigurationDialog());
		GridDataFactory.swtDefaults().span(3, 1).applyTo(this.btnEnableStatistics);

		// a composite for additional setting to customize the
		// StatisticsStrategy
		//
		Composite statisticsComposite = new Composite(ambiguityStrategyGroup, SWT.NONE);
		GridLayoutFactory.swtDefaults().numColumns(4).extendedMargins(10, 0, 0, 0).applyTo(statisticsComposite);
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).span(2, 1)
				.applyTo(statisticsComposite);

		// a simple label
		//
		Label labelWeightingFactor = new Label(statisticsComposite, SWT.HORIZONTAL);
		labelWeightingFactor.setText("Auswertungsebene (Wichtungsfaktor): ");
		labelWeightingFactor.setToolTipText(
				"Manche Arten von Mehrdeutigkeiten können statistisch entweder auf Metamodell- und/oder auf Mapping- (bzw. Projekt-)Ebene ausgewertet werden. Hiermit kann der Wichtungsfaktor zwischen diesen beiden Arten konfiguriert werden.");

		// a simple label
		//
		Label labelMetaModelLevel = new Label(statisticsComposite, SWT.HORIZONTAL);
		labelMetaModelLevel.setText("Metamodell");

		// a scale to control the weighting factor to be used in the
		// StatisticsStrategy
		//
		this.scaleStatisticsFactor = new Scale(statisticsComposite, SWT.HORIZONTAL);
		this.scaleStatisticsFactor.setMinimum(0);
		this.scaleStatisticsFactor.setMaximum(100);
		this.scaleStatisticsFactor.setSelection(50);
		this.scaleStatisticsFactor.setEnabled(false);
		this.scaleStatisticsFactor.setToolTipText(
				"The weighting factor to be used for statistics that can be evaluated on mapping model or meta-model level (0: statistics "
						+ "will only be evaluated on the meta-model level; 100: statistics will only be evaluated on the mapping level)");
		this.scaleStatisticsFactor.addSelectionListener(
				(SelectionListener2) e -> GentransLaunchAmbiguityTab.this.updateLaunchConfigurationDialog());

		// a simple label
		//
		Label labelMappingModelLevel = new Label(statisticsComposite, SWT.HORIZONTAL);
		labelMappingModelLevel.setText("Mapping-Modell");

		// just a separator
		//
		Label separator2 = new Label(ambiguityStrategyGroup, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).span(3, 1).applyTo(separator2);

		// a button to enable/disable the UserDecisionStrategy
		//
		this.btnEnableUser = new Button(ambiguityStrategyGroup, SWT.CHECK);
		this.btnEnableUser.setSelection(true);
		this.btnEnableUser
				.setToolTipText("Enable to use a strategy that resolves ambiguities based on user decisions...");
		this.btnEnableUser.setText("User Decision Strategy");
		this.btnEnableUser.addSelectionListener(
				(SelectionListener2) e -> GentransLaunchAmbiguityTab.this.updateLaunchConfigurationDialog());
		GridDataFactory.swtDefaults().span(3, 1).applyTo(this.btnEnableUser);

		// a composite for additional setting to customize the
		// UserDecisionStrategy
		//
		Composite userComposite = new Composite(ambiguityStrategyGroup, SWT.NONE);
		GridLayoutFactory.swtDefaults().extendedMargins(10, 0, 0, 0).applyTo(userComposite);
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).span(2, 1).applyTo(userComposite);

		// a button to enable the handling of expanding ambiguities in the
		// UserDecisionStrategy
		//
		this.btnHandleExpandingAmbiguities = new Button(userComposite, SWT.CHECK);
		this.btnHandleExpandingAmbiguities.setSelection(true);
		this.btnHandleExpandingAmbiguities.setEnabled(false);
		this.btnHandleExpandingAmbiguities
				.setToolTipText("Also handle ambiguities that occur during the expanding step "
						+ "(Warning: This might lead to many user dialogs!)...");
		this.btnHandleExpandingAmbiguities.setText("Handle expanding ambiguities");
		this.btnHandleExpandingAmbiguities.addSelectionListener(
				(SelectionListener2) e -> GentransLaunchAmbiguityTab.this.updateLaunchConfigurationDialog());

		// After we have created all widgets, we can initialize the data
		// bindings among the widgets and between widgets
		// and the context
		//
		this.initDataBindings();

	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {

		// set the enableHistory attribute
		configuration.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_ENABLE_HISTORY, false);

		// set the transformationModel attribute
		configuration.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_TRANSFORMATION_MODEL, "");

		// set the enableStatistics attribute
		configuration.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_ENABLE_STATISTICS, false);

		// set the weightingFactor attribute
		configuration.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_WEIGHTING_FACTOR, 50);

		// set the enableUser attribute
		configuration.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_ENABLE_USER, false);

		// set the handleExpanding attribute
		configuration.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_HANDLE_EXPANDING, false);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {

		try {

			// initialize the HistoryStrategy-related settings
			//
			this.btnEnableHistory.setSelection(
					configuration.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_ENABLE_HISTORY, false));
			String transformationToUse = configuration
					.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_TRANSFORMATION_MODEL, "");
			this.btnUseLatestTransformation.setSelection(transformationToUse.isEmpty());
			this.btnUseLatestTransformation.setEnabled(
					configuration.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_ENABLE_HISTORY, false));
			this.btnUseSpecificTransformation.setSelection(!transformationToUse.isEmpty());
			this.btnUseSpecificTransformation.setEnabled(
					configuration.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_ENABLE_HISTORY, false));

			try {

				List<IResource> transformationModels = Arrays.asList(ResourcesPlugin.getWorkspace().getRoot()
						.getProject(this.context.getProject()).getFolder(GentransLaunchAmbiguityTab.PAMTRAM_FOLDER)
						.getFolder(GentransLaunchAmbiguityTab.TRANSFORMATION_MODEL_FOLDER).members());
				transformationModels = transformationModels.stream().filter(r -> r instanceof IFolder)
						.collect(Collectors.toList());
				String[] transformationModelNames = transformationModels.stream().map(r -> ((IFolder) r).getName())
						.collect(Collectors.toList()).toArray(new String[] {});
				this.comboSelectTransformation.setItems(transformationModelNames);
			} catch (Exception e1) {
				// error while determining the list of stored transformation
				// models
			}

			String[] transformationsToChooseFrom = this.comboSelectTransformation.getItems();
			int index = Arrays.asList(transformationsToChooseFrom).indexOf(transformationToUse);
			if (index == -1) {
				this.comboSelectTransformation.deselectAll();
			} else {
				this.comboSelectTransformation.select(index);
			}
			this.comboSelectTransformation.setEnabled(
					configuration.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_ENABLE_HISTORY, false));

			// initialize the StatisticsStrategy-related settings
			//
			this.btnEnableStatistics.setSelection(
					configuration.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_ENABLE_STATISTICS, false));
			this.scaleStatisticsFactor.setEnabled(
					configuration.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_ENABLE_STATISTICS, false));
			this.scaleStatisticsFactor.setSelection(
					configuration.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_WEIGHTING_FACTOR, 50));

			// initialize the UserDecisionStrategy-related settings
			//
			this.btnEnableUser.setSelection(
					configuration.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_ENABLE_USER, true));
			this.btnHandleExpandingAmbiguities.setSelection(
					configuration.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_HANDLE_EXPANDING, false));

		} catch (CoreException e) {
			this.setErrorMessage(e.getMessage());
		}

		this.bindingContext.updateModels();
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {

		// set the enableHistory attribute
		configuration.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_ENABLE_HISTORY,
				this.btnEnableHistory.getSelection());

		// set the transformationModel attribute
		configuration.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_TRANSFORMATION_MODEL,
				this.btnEnableHistory.getSelection() && this.btnUseSpecificTransformation.getSelection()
						? this.comboSelectTransformation.getText() : "");

		// set the enableStatistics attribute
		configuration.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_ENABLE_STATISTICS,
				this.btnEnableStatistics.getSelection());

		// set the weightingFactor attribute
		configuration.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_WEIGHTING_FACTOR,
				this.scaleStatisticsFactor.getSelection());

		// set the enableUser attribute
		configuration.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_ENABLE_USER,
				this.btnEnableUser.getSelection());

		// set the handleExpanding attribute
		configuration.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_HANDLE_EXPANDING,
				this.btnHandleExpandingAmbiguities.getSelection());

	}

	@Override
	public String getName() {

		return "Ambiguity resolving";
	}

	/**
	 * Initialize all {@link Binding data bindings} between the various widgets
	 * displayed on this tab and the {@link #context} as well as among widgets.
	 *
	 */
	@SuppressWarnings("unchecked")
	protected void initDataBindings() {

		// The context where all bindings will be registered
		//
		this.bindingContext = new DataBindingContext();

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
				.enabled().observe(this.btnHandleExpandingAmbiguities);
		IObservableValue<Boolean> observeSelectionBtnHandleExpandingCardinalitiesObserveWidget = WidgetProperties
				.selection().observe(this.btnHandleExpandingAmbiguities);

		// The various observable values for bean properties
		//
		IObservableValue<Boolean> enableHistoryAmbiguityResolvingContextObserveValue = BeanProperties
				.value(GentransLaunchContext.PROPERTY_NAME_ENABLE_HISTORY).observe(this.context);
		IObservableValue<Boolean> useSpecificTransformationModelAmbiguityResolvingContextObserveValue = BeanProperties
				.value(GentransLaunchContext.PROPERTY_NAME_USE_SPECIFIC_TRANSFORMATION_MODEL).observe(this.context);
		IObservableValue<Boolean> transformationModelToUseContextObserveValue = BeanProperties
				.value(GentransLaunchContext.PROPERTY_NAME_TRANSFORMATION_MODEL_TO_USE).observe(this.context);
		IObservableList<List<?>> modelsToChooseFromContextObserveList = BeanProperties
				.list(GentransLaunchContext.PROPERTY_NAME_MODELS_TO_CHOOSE_FROM).observe(this.context);

		IObservableValue<Boolean> enableStatisticsAmbiguityResolvingContextObserveValue = BeanProperties
				.value(GentransLaunchContext.PROPERTY_NAME_ENABLE_STATISTICS).observe(this.context);
		IObservableValue<Integer> scaleStatisticsFactorContextObserveValue = BeanProperties
				.value(GentransLaunchContext.PROPERTY_NAME_WEIGHTING_FACTOR).observe(this.context);

		IObservableValue<Boolean> enableUserAmbiguityResolvingContextObserveValue = BeanProperties
				.value(GentransLaunchContext.PROPERTY_NAME_ENABLE_USER).observe(this.context);
		IObservableValue<Boolean> handleExpandingAmbiguitiesContextObserveValue = BeanProperties
				.value(GentransLaunchContext.PROPERTY_NAME_HANDLE_EXPANDING_AMBIGUITIES).observe(this.context);

		// Enable the bindings among widgets
		//
		this.bindingContext.bindValue(observeEnabledComboSelectTransformationObserveWidget,
				observeSelectionBtnEnableHistoryObserveWidget,
				new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		this.bindingContext.bindValue(observeEnabledBtnUseLatestTransformationObserveWidget,
				observeSelectionBtnEnableHistoryObserveWidget,
				new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		this.bindingContext.bindValue(observeEnabledBtnUseSpecificTransformationObserveWidget,
				observeSelectionBtnEnableHistoryObserveWidget,
				new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		this.bindingContext.bindValue(observeEnabledScaleStatisticsObserveWidget,
				observeSelectionBtnEnableStatisticsObserveWidget,
				new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		this.bindingContext.bindValue(observeEnabledBtnHandleExpandingCardinalitiesObserveWidget,
				observeSelectionBtnEnableUserObserveWidget, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER),
				null);

		// Enable the bindings between widgets and the context
		//
		this.bindingContext.bindValue(observeSelectionBtnEnableHistoryObserveWidget,
				enableHistoryAmbiguityResolvingContextObserveValue, null, null);
		this.bindingContext.bindValue(observeSelectionBtnEnableStatisticsObserveWidget,
				enableStatisticsAmbiguityResolvingContextObserveValue, null, null);
		this.bindingContext.bindValue(observeSelectionScaleStatisticsFactorObserveWidget,
				scaleStatisticsFactorContextObserveValue, null, null);
		this.bindingContext.bindValue(observeSelectionBtnEnableUserObserveWidget,
				enableUserAmbiguityResolvingContextObserveValue, null, null);
		this.bindingContext.bindValue(observeSelectionBtnUseSpecificTransformationObserveWidget,
				useSpecificTransformationModelAmbiguityResolvingContextObserveValue, null, null);
		this.bindingContext.bindList(itemsComboSelectTransformationObserveWidget, modelsToChooseFromContextObserveList,
				null, null);
		this.bindingContext.bindValue(observeSelectionComboSelectTransformationObserveWidget,
				transformationModelToUseContextObserveValue, null, null);
		this.bindingContext.bindValue(observeSelectionBtnHandleExpandingCardinalitiesObserveWidget,
				handleExpandingAmbiguitiesContextObserveValue, null, null);
	}
}
