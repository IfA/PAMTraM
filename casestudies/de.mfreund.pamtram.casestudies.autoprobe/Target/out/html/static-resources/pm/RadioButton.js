
function RadioButton(properties, representation, interaction, animation){
	/*general properties*/
	this.name = 					properties["Name"];
	this.htmlElement = 				$("#"+ this.name);
	this.htmlContainer = 			$("#"+ this.name +"-container");
	this.containedUIComponents = 	$.extend(true, {}, RadioButton.__super__.containedUIComponents);
	this.parentUIComponent = 		$.extend(true, {}, RadioButton.__super__.parentUIComponent);

	/*Representation-properties*/
	//Note: use of jQuery.extend() to get a real clone of the superclass'
	//properties, not just a reference
	this.representation = 			$.extend(true, {}, RadioButton.__super__.representation);
	this.representationMapping = 	$.extend(true, {}, RadioButton.__super__.representationMapping);	
	
	this.representationMapping["Border"]["BorderType"]["connectedToContainer"] = true;
	this.representationMapping["Border"]["BorderType"]["connectedToElement"] = false;
	this.representationMapping["Border"]["LineColor"]["connectedToContainer"] = true;
	this.representationMapping["Border"]["LineColor"]["connectedToElement"] = false;
	this.representationMapping["Border"]["Padding"]["connectedToContainer"] = true;
	this.representationMapping["Border"]["Padding"]["connectedToElement"] = false;	
	this.representationMapping["Border"]["Width"]["connectedToContainer"] = true;
	this.representationMapping["Border"]["Width"]["connectedToElement"] = false;	
	this.representationMapping["Size"]["Height"]["connectedToContainer"] = true;
	this.representationMapping["Size"]["Height"]["connectedToElement"] 	= false;
	this.representationMapping["Size"]["Width"]["connectedToContainer"] = true;
	this.representationMapping["Size"]["Width"]["connectedToElement"] = false;
	
	this.currentFlashColor =		$.extend(true, {}, RadioButton.__super__.currentFlashColor);
	this.flashIntervalReference = 	$.extend(true, {}, RadioButton.__super__.flashIntervalReference);
	this.flashResetColor = 			$.extend(true, {}, RadioButton.__super__.flashResetColor);
	this.currentText = 				"";
	this.currentLabeledText =		new Array();
	this.currentImage = 			$.extend(true, {}, RadioButton.__super__.currentImage);

	/*Interaction-properties*/
	this.interaction = 			interaction;
	this.interactionEffects = 	$.extend(true, {}, RadioButton.__super__.interactionEffects);
	this.latestWidgetValue = 	$.extend(true, {}, RadioButton.__super__.latestWidgetValue);
	
	/*Animation-properties*/
	this.animation = 				animation;
	this.animationTriggerSignals = 	$.extend(true, {}, RadioButton.__super__.animationTriggerSignals);
	this.propertyToAnimCont = 		$.extend(true, {}, RadioButton.__super__.propertyToAnimCont);
	this.propertiesToAnimDiscr = 	$.extend(true, {}, RadioButton.__super__.propertiesToAnimDiscr);
	this.rangeComparators = 		$.extend(true, {}, RadioButton.__super__.rangeComparators);
	this.simpleComparators = 		$.extend(true, {}, RadioButton.__super__.simpleComparators);
	
	/*RadioButton specific properties*/
	this.value;
	this.selected;
	
	/*initialize the UIComponent*/
	this.initializeRepresentation(representation);
	
	this.intitializeInteraction();
	
	RadioButton.__super__.initializeAnimation.apply(this);
	
	eventBus.subscribe(this,LanguageChangedSignal);
}
extend(RadioButton, UIComponent);

/**
 * PUBLIC get the current value
 * 
 * @returns [String] null, if it is not selected; this.value if selected
 */
RadioButton.prototype.getValue = function(){
	if(this.selected){
		return this.value;
	}
	else{
		return null;
	}
};

/**
 * PUBLIC register the parent UIComponent $parentUI of another UIComponent 
 * ($this).
 * 
 * @param parentUI
 * 			[Object] of the parent UIComponent
 */
RadioButton.prototype.registerParentUIComponent = function(parentUI){
	RadioButton.__super__.registerParentUIComponent.apply(this, [parentUI]);
	
	if(parentUI.constructor.name == "RadioButtonGroup"){
		this.latestWidgetValue[parentUI.getName()] = null;
		
		pmBus.subscribe(this, FormDataChangedSignal);
	}
};

/**
 * PRIVATE set the latest Widget data and check the data concerns the selection
 * of this RadioButton
 * 
 * @param widgetName
 * 			[String] name of the Widget
 * @param data
 * 			[Object] latest Data of the Widget
 */
RadioButton.prototype.setLatestWidgetData = function(widgetName, data){
	RadioButton.__super__.setLatestWidgetData.apply(this, [widgetName, data]);
	
	//if the informing Widget is the parent RadioButtonGroup
	if(this.parentUIComponent.getName() == widgetName 
			&& this.parentUIComponent.constructor.name == "RadioButtonGroup"){
		
		//check if the selection has changed
		if(data != this.value && this.selected == true){
			this.setSelected(false);
		}
	}
};

/**
 * PRIVATE onChange event-handler. Creates a DataItemValue and spreads it as
 * broadcast over the pmBus
 * 
 * @param _this
 * 			[CheckBox] alternative for this, because of changed function-
 * 				scope in jQuery event-handler .change();
 * @returns [Function] that realizes the desired onChange-functionality
 */
RadioButton.prototype.onSelectionChangeFactory = function(_this){
	return function(){
		var value = null;
		
		//assign CheckBox-value to value if CheckBox is checked
		if(_this.htmlElement.attr('checked') == true){
			value = _this.value;
		}
		
		var signal = new FormDataChangedSignal();
		
		signal.setWidget(_this);
		signal.setDataItemValue(value);
		
		pmBus.fireEvent(signal);
	};	
};


/**
 * PRIVATE set a text for the RadioButton.
 * 
 * @param text
 * 			[String] to be set
 */
RadioButton.prototype.setText = function(text){
	//get the text-node
	var textNode = this.htmlContainer.contents().filter(function(){
		return this.nodeType == 3; //text-node
	});
	
	//if there is already some text
	if(textNode.length != 0){
		textNode.replaceWith(text);
	}
	else{ //if there is no text yet...
		//append the new text without a break
		this.htmlContainer.append(text);
	}
	
	this.updateOverlays();
};

/**
 * PUBLIC show a value by checking the RadioButton.
 * If $value is of the Type Boolean, then the Button will be marked if that  
 * value is true, otherwise it will be unmarked. If $value is of the Type String 
 * or Number, then the Button will be marked if $value matches the 
 * Value of the Button. Otherwise the Button will be unmarked.
 * 
 * (this method overwrites UIComponent.showValue)
 * 
 *  @param value
 *  		[String] or [Number] to be shown
 */
RadioButton.prototype.showValue = function(value){	
	if(typeof value == "boolean"){
		if(value == true){
			this.setSelected(true);
		}
		else{
			this.setSelected(false);
		}
	}
	else if(typeof value == "string" && (value == "true" || value == "false") ){
		if(value == "true"){
			this.setSelected(true);
		}
		else{
			this.setSelected(false);
		}
	}
	else if(typeof value == "number" && (value == 0 || value == 1) ){
		if(value == 1){
			this.setSelected(true);
		}
		else{
			this.setSelected(false);
		}
	}
	else{
		if(value == this.value){
			this.setSelected(true);
		}
		else{
			this.setSelected(false);
		}
	}
};

/**
 * PUBLIC set the selection of the RadioButton
 * 
 * @param selected
 * 			[Boolean] true -> checked; false -> not checked
 */
RadioButton.prototype.setSelected = function(selected){
	var htmlSelected = this.htmlElement.attr('checked');
	
	this.selected = selected;
	
	this.htmlElement.attr('checked',selected);
	this.htmlElement.trigger('change');
};

/**
 * PRIVATE initialize the Representation by setting the content (image/text) and
 * styling attributes
 * 
 * @param repObj
 * 			[Object] RepresentationRecord in JSON
 */
RadioButton.prototype.initializeRepresentation = function(repObj){
	var radioButtonSpec = repObj["Radio Button Specifics"];
	var label = radioButtonSpec["Label"];
	var value = radioButtonSpec["Value"];
	var textCanWrap = radioButtonSpec["TextCanWrap"];
	var textWrapProperty = 'normal';
	
	this.value = value;
	
	this.htmlElement.attr('value', value);
	
	if(textCanWrap != undefined){
		if(textCanWrap){
			textWrapProperty = 'break-word';
		}
		
		this.htmlContainer.css('word-wrap', textWrapProperty);
	}
	
	if(label != undefined){
		this.setTextByDefinition(label);
	}
	
	//use the UIComponent.js function to set Representation-attributes
	RadioButton.__super__.setRepresentationAttributes.apply(this,[repObj]);
};

/**
 * PRIVATE intitialize the Interaction by saving the the InteractionEffects and
 * assigning them to event-handlers
 */
RadioButton.prototype.intitializeInteraction = function(){		
	RadioButton.__super__.intitializeInteraction.apply(this);
	
	//bind onChange event-handler to HTML-Element
	var _this = this;	
	var onSelectionChangeFunction = this.onSelectionChangeFactory(this);
	
	this.htmlElement.change(onSelectionChangeFunction);
	
	//Spread initial selection value after a delay
	setTimeout(function(){
		_this.htmlElement.trigger('change');
	}, this.pmBusInitDelay);
};