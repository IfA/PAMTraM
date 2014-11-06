
function FormDataChangedSignal(){
	var widget = null;
	var dataItemValue = null;
	
	this.getWidget = function(){return this.widget;}
	this.setWidget = function(widget){this.widget = widget;}
	
	this.getDataItemValue = function(){return this.dataItemValue;}
	this.setDataItemValue = function(value){this.dataItemValue = value;}
}
extend(FormDataChangedSignal,Signal);

function LanguageChangedSignal(){};
extend(FormDataChangedSignal,Signal);

function NavigationSignal() {
	var effect = null;
	this.getEffect = function() {
		return effect;
	}
	this.setEffect = function(e) {
		effect = e;
	}
}
extend(NavigationSignal, Signal);

// Include all other files.
$.chainclude(
	[
	 	'static-resources/pm/MultiLingualTextDefinition.js',
	 	'static-resources/pm/ImageBundle.js',
		'static-resources/pm/UIComponent.js',
	 	'static-resources/pm/AlarmControl.js',
		'static-resources/pm/Button.js',
		'static-resources/pm/CheckBox.js',
		'static-resources/pm/CheckBoxArray.js',
		'static-resources/pm/DropDown.js',
		'static-resources/pm/Gauge.js',
		'static-resources/pm/Image.js',
		'static-resources/pm/Input.js',
		'static-resources/pm/RadioButton.js',
		'static-resources/pm/RadioButtonGroup.js',
		'static-resources/pm/Slider.js',
		'static-resources/pm/TextLabel.js',
		'static-resources/pm/Trend.js',
		'static-resources/pm/SimpleContainer.js'
	],
	function() {
		pmReady = true;
		go();
	}
);

var pmUIComponent_Dialog_1_eBO_5_Confirm = null;
var pmUIComponent_Dialog_1_eBO_2_Select_Option_0 = null;
var pmUIComponent_Dialog_1_eBO_2_Select_Option_1 = null;
var pmUIComponent_Dialog_1_eBO_2_Select_Option_2 = null;
var pmUIComponent_Dialog_1_eBO_4_Select_Option_0 = null;
var pmUIComponent_Dialog_1_eBO_4_Select_Option_1 = null;
var pmUIComponent_Dialog_1_eBO_4_Select_Option_2 = null;
var pmUIComponent_Dialog_1_eBO_6_Confirm = null;
var pmUIComponent_Dialog_1_eBO_7_Confirm = null;
var pmUIComponent_Dialog_1_eBO_1 = null;
var pmUIComponent_Dialog_1_eBO_3 = null;
var pmUIComponent_Dialog_1_eBO_2_Select = null;
var pmUIComponent_Dialog_1_eBO_4_Select = null;
var pmUIComponent_Dialog_2_eBO_7_Confirm = null;
var pmUIComponent_Dialog_2_eBO_1 = null;
var pmUIComponent_Dialog_2_eBO_3 = null;
var pmUIComponent_Dialog_2_eBO_5 = null;
var pmUIComponent_Dialog_2_eBO_2_Input = null;
var pmUIComponent_Dialog_2_eBO_4_Input = null;
var pmUIComponent_Dialog_2_eBO_6_Input = null;

function initPM() {
	// initialize presentation model bus
	pmBus = new EventBus();
	// initialize key effect map
	keyEffectMap = [];
	// initialize the navigation manager;	
	navigationManager = new NavigationManager();
		
	imageBundle = new ImageBundle();
	
	
	multiLingualTextDefinition = new MultiLingualTextDefinition();
	multiLingualTextDefinition.addLanguage('German', 'de-DE');
	multiLingualTextDefinition.setUsedLanguage('German');
	multiLingualTextDefinition.setDefaultLanguage('German');
	multiLingualTextDefinition.addTextDefinition('Bestaetigung_dass_die_Information_wahrgenommen_wurde',
			[{
				'Language' : 'German',
				'Value' : 'Bestaetigung_dass_die_Information_wahrgenommen_wurde'
			}]);
	multiLingualTextDefinition.addTextDefinition('DummyInputValueTextItem',
			[{
				'Language' : 'German',
				'Value' : '100'
			}]);
	multiLingualTextDefinition.addTextDefinition('Dialog_1_eBO_5_Confirm_textDef',
			[{
				'Language' : 'German',
				'Value' : 'Start Umpumpen'
			}]);
	multiLingualTextDefinition.addTextDefinition('Dialog_1_eBO_6_Confirm_textDef',
			[{
				'Language' : 'German',
				'Value' : 'Stop Umpumpen'
			}]);
	multiLingualTextDefinition.addTextDefinition('Dialog_1_eBO_7_Confirm_textDef',
			[{
				'Language' : 'German',
				'Value' : 'Konfiguration'
			}]);
	multiLingualTextDefinition.addTextDefinition('Dialog_2_eBO_7_Confirm_textDef',
			[{
				'Language' : 'German',
				'Value' : 'OK'
			}]);
	multiLingualTextDefinition.addTextDefinition('Dialog_1_eBO_1_textDef',
			[{
				'Language' : 'German',
				'Value' : 'Quell-Behälter'
			}]);
	multiLingualTextDefinition.addTextDefinition('Dialog_1_eBO_3_textDef',
			[{
				'Language' : 'German',
				'Value' : 'Ziel-Behälter'
			}]);
	multiLingualTextDefinition.addTextDefinition('Dialog_2_eBO_1_textDef',
			[{
				'Language' : 'German',
				'Value' : 'V1'
			}]);
	multiLingualTextDefinition.addTextDefinition('Dialog_2_eBO_3_textDef',
			[{
				'Language' : 'German',
				'Value' : 'V2'
			}]);
	multiLingualTextDefinition.addTextDefinition('Dialog_2_eBO_5_textDef',
			[{
				'Language' : 'German',
				'Value' : 'P3'
			}]);
	multiLingualTextDefinition.addTextDefinition('Dialog_1_eBO_2_Select_Option_0_textDef',
			[{
				'Language' : 'German',
				'Value' : 'Behaelter_1 '
			}]);
	multiLingualTextDefinition.addTextDefinition('Dialog_1_eBO_2_Select_Option_1_textDef',
			[{
				'Language' : 'German',
				'Value' : 'Behaelter_2 '
			}]);
	multiLingualTextDefinition.addTextDefinition('Dialog_1_eBO_2_Select_Option_2_textDef',
			[{
				'Language' : 'German',
				'Value' : 'Behaelter_3 '
			}]);
	multiLingualTextDefinition.addTextDefinition('Dialog_1_eBO_4_Select_Option_0_textDef',
			[{
				'Language' : 'German',
				'Value' : 'Pumpe_1 '
			}]);
	multiLingualTextDefinition.addTextDefinition('Dialog_1_eBO_4_Select_Option_1_textDef',
			[{
				'Language' : 'German',
				'Value' : 'Pumpe_2 '
			}]);
	multiLingualTextDefinition.addTextDefinition('Dialog_1_eBO_4_Select_Option_2_textDef',
			[{
				'Language' : 'German',
				'Value' : 'Pumpe_3 '
			}]);
	pmUIComponent_Dialog_1_eBO_5_Confirm = new Button(
		{
			'Name' : 'Dialog_1_eBO_5_Confirm'
		}, {
			'Button Specifics' : {
				'Label' : 'Dialog_1_eBO_5_Confirm_textDef',
				'TextCanWrap' : false,
				'Toggle' : false,
				'ImageResource' : null
			},
			'Position' : {
				'X' : '530.0px',
				'Y' : '10.0px',
				'Z' : '0'
			}, 
			'Size' : {
				'Height' : '40.0px',
				'Width' : '100.0px'
			}, 
			'ToolTipText' : {
				'Text' : 'Bestaetigung_dass_die_Information_wahrgenommen_wurde'
			}

		}, {
			'Click' : [{
				'@Name' : 'Dialog_1_eBO_5_Confirm_SignalTrigger',
				'Effects' : ['triggering_Dialog_1_eBO_5_Confirm_signal']
			}], 
			'SendSignalEffect' : [{
				'@Name' : 'triggering_Dialog_1_eBO_5_Confirm_signal',
				'sends' : Dialog_1_eBO_5_Confirm_Changed_signal
			}]
		}, {
		});
	pmUIComponent_Dialog_1_eBO_6_Confirm = new Button(
		{
			'Name' : 'Dialog_1_eBO_6_Confirm'
		}, {
			'Button Specifics' : {
				'Label' : 'Dialog_1_eBO_6_Confirm_textDef',
				'TextCanWrap' : false,
				'Toggle' : false,
				'ImageResource' : null
			},
			'Position' : {
				'X' : '660.0px',
				'Y' : '10.0px',
				'Z' : '0'
			}, 
			'Size' : {
				'Height' : '40.0px',
				'Width' : '100.0px'
			}, 
			'ToolTipText' : {
				'Text' : 'Bestaetigung_dass_die_Information_wahrgenommen_wurde'
			}

		}, {
			'Click' : [{
				'@Name' : 'Dialog_1_eBO_6_Confirm_SignalTrigger',
				'Effects' : ['triggering_Dialog_1_eBO_6_Confirm_signal']
			}], 
			'SendSignalEffect' : [{
				'@Name' : 'triggering_Dialog_1_eBO_6_Confirm_signal',
				'sends' : Dialog_1_eBO_6_Confirm_Changed_signal
			}]
		}, {
		});
	pmUIComponent_Dialog_1_eBO_7_Confirm = new Button(
		{
			'Name' : 'Dialog_1_eBO_7_Confirm'
		}, {
			'Button Specifics' : {
				'Label' : 'Dialog_1_eBO_7_Confirm_textDef',
				'TextCanWrap' : false,
				'Toggle' : false,
				'ImageResource' : null
			},
			'Position' : {
				'X' : '790.0px',
				'Y' : '10.0px',
				'Z' : '0'
			}, 
			'Size' : {
				'Height' : '40.0px',
				'Width' : '100.0px'
			}, 
			'ToolTipText' : {
				'Text' : 'Bestaetigung_dass_die_Information_wahrgenommen_wurde'
			}

		}, {
			'Click' : [{
				'@Name' : 'Dialog_1_eBO_7_Confirm_SignalTrigger',
				'Effects' : ['triggering_Dialog_1_eBO_7_Confirm_signal']
			}], 
			'SendSignalEffect' : [{
				'@Name' : 'triggering_Dialog_1_eBO_7_Confirm_signal',
				'sends' : Dialog_1_eBO_7_Confirm_Changed_signal
			}]
		}, {
		});
	pmUIComponent_Dialog_1_eBO_1 = new TextLabel(
		{
			'Name' : 'Dialog_1_eBO_1'
		}, {
			'Text Label Specifics' : {
				'Label' : 'Dialog_1_eBO_1_textDef',
				'TextCanWrap' : false,
				'MultiLine' : false
			},
			'Format' : {
				'FontDecoration' : 'NONE',
				'FontFace' : 'VERDANA',
				'FontSize' : '10.0pt',
				'FontStyle' : 'NORMAL',
				'FontWeight' : 'MEDIUM'
			}, 
			'Position' : {
				'X' : '10.0px',
				'Y' : '10.0px',
				'Z' : '0'
			}, 
			'Size' : {
				'Height' : '40.0px',
				'Width' : '100.0px'
			}
		}, {
		}, {
		});
	pmUIComponent_Dialog_1_eBO_3 = new TextLabel(
		{
			'Name' : 'Dialog_1_eBO_3'
		}, {
			'Text Label Specifics' : {
				'Label' : 'Dialog_1_eBO_3_textDef',
				'TextCanWrap' : false,
				'MultiLine' : false
			},
			'Format' : {
				'FontDecoration' : 'NONE',
				'FontFace' : 'VERDANA',
				'FontSize' : '10.0pt',
				'FontStyle' : 'NORMAL',
				'FontWeight' : 'MEDIUM'
			}, 
			'Position' : {
				'X' : '270.0px',
				'Y' : '10.0px',
				'Z' : '0'
			}, 
			'Size' : {
				'Height' : '40.0px',
				'Width' : '100.0px'
			}
		}, {
		}, {
		});
	pmUIComponent_Dialog_1_eBO_2_Select = new RadioButtonGroup(
		{
			'Name' : 'Dialog_1_eBO_2_Select'
		}, {
			'Radio Button Group Specifics' : {
				'Label' : null,
				'TextCanWrap' : false
			},
			'Position' : {
				'X' : '140.0px',
				'Y' : '10.0px',
				'Z' : '0'
			}, 
			'Size' : {
				'Height' : '40.0px',
				'Width' : '100.0px'
			}
		}, {
		}, {
		});
	pmUIComponent_Dialog_1_eBO_2_Select_Option_0 = new RadioButton(
		{
			'Name' : 'Dialog_1_eBO_2_Select_Option_0'
		}, {
			'Radio Button Specifics' : {
				'Label' : 'Dialog_1_eBO_2_Select_Option_0_textDef',
				'TextCanWrap' : false,
				'Value' : 'Vorgabewert 0'
			},
		}, {
			'Click' : [{
				'@Name' : 'Dialog_1_eBO_2_Select_Option_0_SignalTrigger',
				'Effects' : ['triggering_Dialog_1_eBO_2_Select_Option_0_signal']
			}], 
			'SendSignalEffect' : [{
				'@Name' : 'triggering_Dialog_1_eBO_2_Select_Option_0_signal',
				'sends' : Dialog_1_eBO_2_Select_Option_0_Changed_signal
			}]
		}, {
		});
	pmUIComponent_Dialog_1_eBO_2_Select.addContainedUIComponent(pmUIComponent_Dialog_1_eBO_2_Select_Option_0);
	pmUIComponent_Dialog_1_eBO_2_Select_Option_1 = new RadioButton(
		{
			'Name' : 'Dialog_1_eBO_2_Select_Option_1'
		}, {
			'Radio Button Specifics' : {
				'Label' : 'Dialog_1_eBO_2_Select_Option_1_textDef',
				'TextCanWrap' : false,
				'Value' : 'Vorgabewert 1'
			},
		}, {
			'Click' : [{
				'@Name' : 'Dialog_1_eBO_2_Select_Option_1_SignalTrigger',
				'Effects' : ['triggering_Dialog_1_eBO_2_Select_Option_1_signal']
			}], 
			'SendSignalEffect' : [{
				'@Name' : 'triggering_Dialog_1_eBO_2_Select_Option_1_signal',
				'sends' : Dialog_1_eBO_2_Select_Option_1_Changed_signal
			}]
		}, {
		});
	pmUIComponent_Dialog_1_eBO_2_Select.addContainedUIComponent(pmUIComponent_Dialog_1_eBO_2_Select_Option_1);
	pmUIComponent_Dialog_1_eBO_2_Select_Option_2 = new RadioButton(
		{
			'Name' : 'Dialog_1_eBO_2_Select_Option_2'
		}, {
			'Radio Button Specifics' : {
				'Label' : 'Dialog_1_eBO_2_Select_Option_2_textDef',
				'TextCanWrap' : false,
				'Value' : 'Vorgabewert 2'
			},
		}, {
			'Click' : [{
				'@Name' : 'Dialog_1_eBO_2_Select_Option_2_SignalTrigger',
				'Effects' : ['triggering_Dialog_1_eBO_2_Select_Option_2_signal']
			}], 
			'SendSignalEffect' : [{
				'@Name' : 'triggering_Dialog_1_eBO_2_Select_Option_2_signal',
				'sends' : Dialog_1_eBO_2_Select_Option_2_Changed_signal
			}]
		}, {
		});
	pmUIComponent_Dialog_1_eBO_2_Select.addContainedUIComponent(pmUIComponent_Dialog_1_eBO_2_Select_Option_2);
	pmUIComponent_Dialog_1_eBO_4_Select = new RadioButtonGroup(
		{
			'Name' : 'Dialog_1_eBO_4_Select'
		}, {
			'Radio Button Group Specifics' : {
				'Label' : null,
				'TextCanWrap' : false
			},
			'Position' : {
				'X' : '400.0px',
				'Y' : '10.0px',
				'Z' : '0'
			}, 
			'Size' : {
				'Height' : '40.0px',
				'Width' : '100.0px'
			}
		}, {
		}, {
		});
	pmUIComponent_Dialog_1_eBO_4_Select_Option_0 = new RadioButton(
		{
			'Name' : 'Dialog_1_eBO_4_Select_Option_0'
		}, {
			'Radio Button Specifics' : {
				'Label' : 'Dialog_1_eBO_4_Select_Option_0_textDef',
				'TextCanWrap' : false,
				'Value' : 'Vorgabewert 0'
			},
		}, {
			'Click' : [{
				'@Name' : 'Dialog_1_eBO_4_Select_Option_0_SignalTrigger',
				'Effects' : ['triggering_Dialog_1_eBO_4_Select_Option_0_signal']
			}], 
			'SendSignalEffect' : [{
				'@Name' : 'triggering_Dialog_1_eBO_4_Select_Option_0_signal',
				'sends' : Dialog_1_eBO_4_Select_Option_0_Changed_signal
			}]
		}, {
		});
	pmUIComponent_Dialog_1_eBO_4_Select.addContainedUIComponent(pmUIComponent_Dialog_1_eBO_4_Select_Option_0);
	pmUIComponent_Dialog_1_eBO_4_Select_Option_1 = new RadioButton(
		{
			'Name' : 'Dialog_1_eBO_4_Select_Option_1'
		}, {
			'Radio Button Specifics' : {
				'Label' : 'Dialog_1_eBO_4_Select_Option_1_textDef',
				'TextCanWrap' : false,
				'Value' : 'Vorgabewert 1'
			},
		}, {
			'Click' : [{
				'@Name' : 'Dialog_1_eBO_4_Select_Option_1_SignalTrigger',
				'Effects' : ['triggering_Dialog_1_eBO_4_Select_Option_1_signal']
			}], 
			'SendSignalEffect' : [{
				'@Name' : 'triggering_Dialog_1_eBO_4_Select_Option_1_signal',
				'sends' : Dialog_1_eBO_4_Select_Option_1_Changed_signal
			}]
		}, {
		});
	pmUIComponent_Dialog_1_eBO_4_Select.addContainedUIComponent(pmUIComponent_Dialog_1_eBO_4_Select_Option_1);
	pmUIComponent_Dialog_1_eBO_4_Select_Option_2 = new RadioButton(
		{
			'Name' : 'Dialog_1_eBO_4_Select_Option_2'
		}, {
			'Radio Button Specifics' : {
				'Label' : 'Dialog_1_eBO_4_Select_Option_2_textDef',
				'TextCanWrap' : false,
				'Value' : 'Vorgabewert 2'
			},
		}, {
			'Click' : [{
				'@Name' : 'Dialog_1_eBO_4_Select_Option_2_SignalTrigger',
				'Effects' : ['triggering_Dialog_1_eBO_4_Select_Option_2_signal']
			}], 
			'SendSignalEffect' : [{
				'@Name' : 'triggering_Dialog_1_eBO_4_Select_Option_2_signal',
				'sends' : Dialog_1_eBO_4_Select_Option_2_Changed_signal
			}]
		}, {
		});
	pmUIComponent_Dialog_1_eBO_4_Select.addContainedUIComponent(pmUIComponent_Dialog_1_eBO_4_Select_Option_2);
	pmUIComponent_Dialog_2_eBO_7_Confirm = new Button(
		{
			'Name' : 'Dialog_2_eBO_7_Confirm'
		}, {
			'Button Specifics' : {
				'Label' : 'Dialog_2_eBO_7_Confirm_textDef',
				'TextCanWrap' : false,
				'Toggle' : false,
				'ImageResource' : null
			},
			'Position' : {
				'X' : '790.0px',
				'Y' : '10.0px',
				'Z' : '0'
			}, 
			'Size' : {
				'Height' : '40.0px',
				'Width' : '100.0px'
			}, 
			'ToolTipText' : {
				'Text' : 'Bestaetigung_dass_die_Information_wahrgenommen_wurde'
			}

		}, {
			'Click' : [{
				'@Name' : 'Dialog_2_eBO_7_Confirm_SignalTrigger',
				'Effects' : ['triggering_Dialog_2_eBO_7_Confirm_signal']
			}], 
			'SendSignalEffect' : [{
				'@Name' : 'triggering_Dialog_2_eBO_7_Confirm_signal',
				'sends' : Dialog_2_eBO_7_Confirm_Changed_signal
			}]
		}, {
		});
	pmUIComponent_Dialog_2_eBO_1 = new TextLabel(
		{
			'Name' : 'Dialog_2_eBO_1'
		}, {
			'Text Label Specifics' : {
				'Label' : 'Dialog_2_eBO_1_textDef',
				'TextCanWrap' : false,
				'MultiLine' : false
			},
			'Format' : {
				'FontDecoration' : 'NONE',
				'FontFace' : 'VERDANA',
				'FontSize' : '10.0pt',
				'FontStyle' : 'NORMAL',
				'FontWeight' : 'MEDIUM'
			}, 
			'Position' : {
				'X' : '10.0px',
				'Y' : '10.0px',
				'Z' : '0'
			}, 
			'Size' : {
				'Height' : '40.0px',
				'Width' : '100.0px'
			}
		}, {
		}, {
		});
	pmUIComponent_Dialog_2_eBO_3 = new TextLabel(
		{
			'Name' : 'Dialog_2_eBO_3'
		}, {
			'Text Label Specifics' : {
				'Label' : 'Dialog_2_eBO_3_textDef',
				'TextCanWrap' : false,
				'MultiLine' : false
			},
			'Format' : {
				'FontDecoration' : 'NONE',
				'FontFace' : 'VERDANA',
				'FontSize' : '10.0pt',
				'FontStyle' : 'NORMAL',
				'FontWeight' : 'MEDIUM'
			}, 
			'Position' : {
				'X' : '270.0px',
				'Y' : '10.0px',
				'Z' : '0'
			}, 
			'Size' : {
				'Height' : '40.0px',
				'Width' : '100.0px'
			}
		}, {
		}, {
		});
	pmUIComponent_Dialog_2_eBO_5 = new TextLabel(
		{
			'Name' : 'Dialog_2_eBO_5'
		}, {
			'Text Label Specifics' : {
				'Label' : 'Dialog_2_eBO_5_textDef',
				'TextCanWrap' : false,
				'MultiLine' : false
			},
			'Format' : {
				'FontDecoration' : 'NONE',
				'FontFace' : 'VERDANA',
				'FontSize' : '10.0pt',
				'FontStyle' : 'NORMAL',
				'FontWeight' : 'MEDIUM'
			}, 
			'Position' : {
				'X' : '530.0px',
				'Y' : '10.0px',
				'Z' : '0'
			}, 
			'Size' : {
				'Height' : '40.0px',
				'Width' : '100.0px'
			}
		}, {
		}, {
		});
	pmUIComponent_Dialog_2_eBO_2_Input = new Input(
		{
			'Name' : 'Dialog_2_eBO_2_Input'
		}, {
			'Input Specifics' : {
				'Label' : 'DummyInputValueTextItem',
				'TextCanWrap' : false,
				'MaxLength' : 10,
				'ShowCharactersSimultaneously' : 0,
				'MultiRow' : false
			},
			'Position' : {
				'X' : '140.0px',
				'Y' : '10.0px',
				'Z' : '0'
			}, 
			'Size' : {
				'Height' : '40.0px',
				'Width' : '100.0px'
			}
		}, {
			'Click' : [{
				'@Name' : 'Dialog_2_eBO_2_Input_SignalTrigger',
				'Effects' : ['triggering_Dialog_2_eBO_2_Input_signal']
			}], 
			'SendSignalEffect' : [{
				'@Name' : 'triggering_Dialog_2_eBO_2_Input_signal',
				'sends' : Dialog_2_eBO_2_Input_Changed_signal
			}]
		}, {
		});
	pmUIComponent_Dialog_2_eBO_4_Input = new Input(
		{
			'Name' : 'Dialog_2_eBO_4_Input'
		}, {
			'Input Specifics' : {
				'Label' : 'DummyInputValueTextItem',
				'TextCanWrap' : false,
				'MaxLength' : 10,
				'ShowCharactersSimultaneously' : 0,
				'MultiRow' : false
			},
			'Position' : {
				'X' : '400.0px',
				'Y' : '10.0px',
				'Z' : '0'
			}, 
			'Size' : {
				'Height' : '40.0px',
				'Width' : '100.0px'
			}
		}, {
			'Click' : [{
				'@Name' : 'Dialog_2_eBO_4_Input_SignalTrigger',
				'Effects' : ['triggering_Dialog_2_eBO_4_Input_signal']
			}], 
			'SendSignalEffect' : [{
				'@Name' : 'triggering_Dialog_2_eBO_4_Input_signal',
				'sends' : Dialog_2_eBO_4_Input_Changed_signal
			}]
		}, {
		});
	pmUIComponent_Dialog_2_eBO_6_Input = new Input(
		{
			'Name' : 'Dialog_2_eBO_6_Input'
		}, {
			'Input Specifics' : {
				'Label' : 'DummyInputValueTextItem',
				'TextCanWrap' : false,
				'MaxLength' : 10,
				'ShowCharactersSimultaneously' : 0,
				'MultiRow' : false
			},
			'Position' : {
				'X' : '660.0px',
				'Y' : '10.0px',
				'Z' : '0'
			}, 
			'Size' : {
				'Height' : '40.0px',
				'Width' : '100.0px'
			}
		}, {
			'Click' : [{
				'@Name' : 'Dialog_2_eBO_6_Input_SignalTrigger',
				'Effects' : ['triggering_Dialog_2_eBO_6_Input_signal']
			}], 
			'SendSignalEffect' : [{
				'@Name' : 'triggering_Dialog_2_eBO_6_Input_signal',
				'sends' : Dialog_2_eBO_6_Input_Changed_signal
			}]
		}, {
		});

	// ===============================================
	// = activate default language in all components =
	// ===============================================
	eventBus.fireEvent(new LanguageChangedSignal(), null);

	// ========================
	// = handling key strokes =
	// ========================

	// define a helper variable
	var pressedKeys = [];
	
	// only add particular keycodes on keydown to the variable.
	$('body').keydown(function(event){
		event = event || window.event;
		pressedKeys.push(event.keyCode);
	});
	
	// perform actions on keyup:
	$('body').keyup(function(event) {
		event = event || window.event;
		// determine the currently active panel since we might define equal
		// keycodes but on different panels. (only one panel can be shown at
		// the same time.)
		var panel = $('div.movisaPanel:visible')[0].id;

		// iterate over the key effect map
		for (i=0, l=keyEffectMap.length; i<l; i++) {
			var o = keyEffectMap[i];
			// determine whether the currently active panel is the panel a
			// particular keycode has been bound to.
			if (o['Panel'] === panel) {
				// just check if the same number of keys is used.
				if (o['Keys'].length === pressedKeys.length) {
					var match = true;
					// walk through each key and check whether it is also 
					// defined
					for (j=0, k=pressedKeys.length; j<k; j++) {
						match = match && 
							($.inArray(pressedKeys[j], o['Keys']) >= 0);
					}
					// if a keystroke has been matched, then perform the actions
					if (match) {
						o['Effects'].call();
					}
				}
			}
		}
		// empty the helper variable.
		pressedKeys = [];
	});
	
/*	
	var endSig = new NavigationSignal();
	endSig.setEffect('quit_app_effect');
	
	window.setTimeout(function() {
		eventBus.fireEvent(endSig, navigationManager);
	}, 5000);
*/	

	pmInitializied = true;
}

// This class ensures the correct navigation flow through the applications.
function NavigationManager() {	
	// Variable to hold the currently active panel
	var panel;
	// Variable to hold the previously active panel
	var lastPanel;
	this.setPanel = function(newPanel) {
		lastPanel = panel;
		panel = newPanel;
	}
	this.getPanel = function() {
		return panel;
	}
	this.getLastPanel = function() {
		return lastPanel;
	}
	// return to the last panel
	this.enterLastPanel = function() {
		this.enterPanel(this.getLastPanel());
	}
	// Activate a particular panel
	this.enterPanel = function(newPanel) {
		var $currentPanel = $('div.movisaPanel:visible'),
			$newPanel = $('#' + newPanel);
		
		this.setPanel(newPanel);
		$currentPanel.hide();
		$newPanel.show();
		window.setTimeout(function () {
			$currentPanel.trigger("panelexit");
			$newPanel.trigger("panelentry");
		}, 10);
	}
	// subscribe to the EventBus
	//
	eventBus.subscribe(this, NavigationSignal);
	eventBus.subscribe(this, Dialog_1_eBO_7_Confirm_Changed_signal);
	eventBus.subscribe(this, Dialog_2_eBO_7_Confirm_Changed_signal);
	this.enterPanel('_Toe3OZo1');
}
extend(NavigationManager, EventSubscriber);

// NavigationManager method to handle events	
NavigationManager.prototype.handleEvent = function(event) {
	
	if (typeof(BACK) != 'undefined' && event instanceof BACK) {
		this.enterLastPanel();
		return;
	}
	if (this.getPanel() === '_Toe3OZo1') {
		if (event instanceof Dialog_1_eBO_7_Confirm_Changed_signal) {
			this.enterPanel('_hABm6BzH');
		}
		return;
	}
	if (this.getPanel() === '_hABm6BzH') {
		if (event instanceof Dialog_2_eBO_7_Confirm_Changed_signal) {
			this.enterPanel('_Toe3OZo1');
		}
		return;
	}
}
