
function DropDown(properties, representation, interaction, animation){
	/*general properties*/
	this.name = 					properties["Name"];
	this.htmlElement = 				$("#"+ this.name);
	this.htmlContainer = 			$("#"+ this.name +"-container");
	this.containedUIComponents = 	$.extend(true, {}, DropDown.__super__.containedUIComponents);
	this.parentUIComponent = 		$.extend(true, {}, DropDown.__super__.parentUIComponent);

	/*Representation-properties*/
	//Note: use of jQuery.extend() to get a real clone of the superclass'
	//properties, not just a reference
	this.representation = 			$.extend(true, {}, DropDown.__super__.representation);
	this.representationMapping = 	$.extend(true, {}, DropDown.__super__.representationMapping);	
	this.currentFlashColor =		$.extend(true, {}, DropDown.__super__.currentFlashColor);
	this.flashIntervalReference = 	$.extend(true, {}, DropDown.__super__.flashIntervalReference);
	this.flashResetColor = 			$.extend(true, {}, DropDown.__super__.flashResetColor);
	this.currentText = 				"";
	this.currentLabeledText =		new Array();
	this.currentDropDown = 			$.extend(true, {}, DropDown.__super__.currentDropDown);

	/*Interaction-properties*/
	this.interaction = 			interaction;
	this.interactionEffects = 	$.extend(true, {}, DropDown.__super__.interactionEffects);
	this.latestWidgetValue = 	$.extend(true, {}, DropDown.__super__.latestWidgetValue);
	
	/*Animation-properties*/
	this.animation = 				animation;
	this.animationTriggerSignals = 	$.extend(true, {}, DropDown.__super__.animationTriggerSignals);
	this.propertyToAnimCont = 		$.extend(true, {}, DropDown.__super__.propertyToAnimCont);
	this.propertiesToAnimDiscr = 	$.extend(true, {}, DropDown.__super__.propertiesToAnimDiscr);
	this.rangeComparators = 		$.extend(true, {}, DropDown.__super__.rangeComparators);
	this.simpleComparators = 		$.extend(true, {}, DropDown.__super__.simpleComparators);
	
	/* DropDown properties */
	this.value;
	this.selected;
	
	/*initialize the UIComponent*/
	this.initializeRepresentation(representation);
	
	this.intitializeInteraction();
	
	DropDown.__super__.initializeAnimation.apply(this);
	
	eventBus.subscribe(this,LanguageChangedSignal);
}
extend(DropDown, UIComponent);

/**
 * PRIVATE onChange event-handler. Creates a DataItemValue and spreads it as
 * broadcast over the pmBus
 * 
 * @param _this
 * 			[DropDown] alternative for this, because of changed function-
 * 				scope in jQuery event-handler .change();
 * @returns [Function] that realizes the desired onChange-functionality
 */
DropDown.prototype.onSelectionChangeFactory = function(_this){
	return function(){
		var value = null;
		var selected = $("#"+_this.name +" option:selected");
		
		if(selected.length == 1){
			value = selected[0].value;
		}
		else{
			// I don't know whether this code works... Usually, here should
			// be determined whether there is NO option selected or MANY 
			// options selected. I think this code works only in case there
			// has been NO option selected. 
			value = $("#"+_this.name +" > option:first").attr('val');
		}
		
		_this.value = value;
		
		var signal = new FormDataChangedSignal();
		
		signal.setWidget(_this);
		signal.setDataItemValue(value);
		
		pmBus.fireEvent(signal);
	};	
};

/**
 * PRIVATE change the text of the currently selected option
 * 
 * @param text
 * 			[String] text to write
 */
DropDown.prototype.setText = function(text){
	var selectedOption = $("#"+ this.name +" option:selected");
	
	//if no option, choose the first option to change text
	if(selectedOption.length == 0){
		selectedOption = $("#"+ this.name +" option:first");
	}
	
	//set the text
	selectedOption.text(text);
	
	this.updateOverlays();
};

/**
 * PRIVATE update all labeled text (e.g. as result of an 
 * LanguageChangedSignal)
 */
DropDown.prototype.updateLabeledText = function(){
	var dropDownOptions = this.representation["Drop Down Specifics"]["DropDownOption"];
	var option, value, label, text;
	
	for(var i = 0; i<dropDownOptions.length; i++){
		value = dropDownOptions[i]["Value"];
		label = dropDownOptions[i]["Label"];
		
		text = multiLingualTextDefinition.getTextValue(label);
		option = $("#"+ this.name +" > option[value='"+ value +"']" );
		
		option.text(text);
	}
};

/**
 * PRIVATE select the option whose value-attribute corresponds to $value
 * 
 *  @param value
 *  		[String] or [Number] to be selected
 */
DropDown.prototype.showValue = function(value){	
	this.setSelected(value);
};

/**
 * PUBLIC set the selected option of the DropDown
 * 
 * @param value
 * 			[String] or [Number] of the value-attribute of the option that shall
 * 				be selected
 */
DropDown.prototype.setSelected = function(value){
	var option = $('#'+ this.name +' > option[value="'+ value +'"]:first');
	var currentlySelected = $('#'+ this.name +' > option:selected');
	
	//if there is an option with the value-attribute $value
	if(option.length > 0){
		//delete all current selections
		if(currentlySelected.length > 0){
			currentlySelected.attr('selected', false);
		}
		
		//set new selection
		option.attr('selected', true);
	}
	
	this.selected = value;
	
	this.htmlElement.trigger('change');
};
/**
 * PRIVATE initialize the Representation by converting the movisa-data to CSS-
 * data and setting the selection of DropDown-options
 * 
 * @param repObj
 * 			[Object] RepresentationRecord in JSON
 */
DropDown.prototype.initializeRepresentation = function(repObj){
	var dropDownSpec = repObj["Drop Down Specifics"];
	var selectedValue = dropDownSpec["Selected"];
	var textCanWrap = dropDownSpec["TextCanWrap"];
	var showItemsSimult = dropDownSpec["ShowItemsSimultaneously"];
	var dropDownOptions = dropDownSpec["DropDownOption"];
	var textWrapProperty = 'normal';
	
	if(textCanWrap != undefined){
		if(textCanWrap){
			textWrapProperty = 'break-word';
		}
		
		this.htmlContainer.css('word-wrap', textWrapProperty);
	}
	
	DropDown.__super__.setRepresentationAttributes.apply(this, [repObj]);
	
	//set the size (ShowItemsSimulatniously) of the DropDown
	this.htmlElement.attr('size', showItemsSimult);
	
	//set the selectedValue as selected DropDown value
	this.setSelected(selectedValue);
//	$('#'+ this.name ).val(selectedValue);
};

/**
 * PRIVATE initialize the Interaction by saving the the InteractionEffects and
 * assigning them to event-handlers
 */
DropDown.prototype.intitializeInteraction = function(){		
	DropDown.__super__.intitializeInteraction.apply(this);
	
	//bind onChange event-handler to HTML-Element
	var _this = this;
	var onSelectionChangeFunction = this.onSelectionChangeFactory(this);
	
	this.htmlElement.change(onSelectionChangeFunction);
	
	//Spread initial selection value
	this.htmlElement.trigger('change');
};