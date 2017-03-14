function CheckBox(properties, representation, interaction, animation){
	/*general properties*/
	this.name = 					properties["Name"];
	this.htmlElement = 				$("#"+ this.name);
	this.htmlContainer = 			$("#"+ this.name +"-container");
	this.containedUIComponents = 	$.extend(true, {}, CheckBox.__super__.containedUIComponents);
	this.parentUIComponent = 		$.extend(true, {}, CheckBox.__super__.parentUIComponent);
	
	/*Representation-properties*/
	//Note: use of jQuery.extend() to get a real clone of the superclass'
	//properties, not just a reference
	this.representation = 			$.extend(true, {}, CheckBox.__super__.representation);
	this.representationMapping = 	$.extend(true, {}, CheckBox.__super__.representationMapping);	
	
	this.representationMapping["Border"]["BorderType"]["connectedToContainer"] = true;
	this.representationMapping["Border"]["LineColor"]["connectedToContainer"] = true;	
	this.representationMapping["Border"]["Padding"]["connectedToContainer"] = true;
	this.representationMapping["Border"]["Padding"]["connectedToElement"] = false;	
	this.representationMapping["Border"]["Width"]["connectedToContainer"] = true;
	this.representationMapping["Border"]["Width"]["connectedToElement"] = false;	
	this.representationMapping["Size"]["Height"]["connectedToContainer"] = true;
	this.representationMapping["Size"]["Height"]["connectedToElement"] 	= false;
	this.representationMapping["Size"]["Width"]["connectedToContainer"] = true;
	this.representationMapping["Size"]["Width"]["connectedToElement"] = false;
	
	this.currentFlashColor =		$.extend(true, {}, CheckBox.__super__.currentFlashColor);
	this.flashIntervalReference = 	$.extend(true, {}, CheckBox.__super__.flashIntervalReference);
	this.flashResetColor = 			$.extend(true, {}, CheckBox.__super__.flashResetColor);
	this.currentText = 				"";
	this.currentLabeledText =		new Array();
	this.currentImage = 			$.extend(true, {}, CheckBox.__super__.currentImage);

	/*Interaction-properties*/
	this.interaction = 			interaction;
	this.interactionEffects = 	$.extend(true, {}, CheckBox.__super__.interactionEffects);
	this.latestWidgetValue = 	$.extend(true, {}, CheckBox.__super__.latestWidgetValue);
	
	/*Animation-properties*/
	this.animation = animation;
	
	/*CheckBox specific properties*/
	this.value;
	this.selected = false;
	
	/*initialize the UIComponent*/
	this.initializeRepresentation(representation);
	
	this.intitializeInteraction();
	
	CheckBox.__super__.initializeAnimation.apply(this);
	
	eventBus.subscribe(this,LanguageChangedSignal);
}
extend(CheckBox, UIComponent);

/**
 * PUBLIC get the current value
 * 
 * @returns [String] null, if it is not checked; this.value if checked
 */
CheckBox.prototype.getValue = function(){
	if(this.selected){
		return this.value;
	}
	else{
		return null;
	}
};

/**
 * PUBLIC get value name
 * 
 * @returns [String] the value of the CheckBox
 */
CheckBox.prototype.getValueName = function(){
	return this.value;
};

/**
 * PRIVATE set a text for the CheckBox.
 * 
 * @param text
 * 			[String] to be set
 */
CheckBox.prototype.setText = function(text){
	//get the text-node
	var textNode = this.htmlContainer.contents().filter(function(){
		return this.nodeType == 3 && this.previousSibling; //text-node within INPUT element
	});
	//if there is already some text
	if(textNode.text().length !== 0){
		textNode.replaceWith(text);
	}
	else{ //if there is no text yet...
		//append the new text without a break
		this.htmlContainer.append(text);
	}
	this.updateOverlays();
};

/**
 * PUBLIC show a value by checking the CheckBox.
 * If $value is of the Type Boolean, then the Box will be marked if that value 
 * is true, otherwise it will be unmarked. If $value is of the Type String 
 * or Number, then the Box will be marked if $value matches the 
 * Value of the Box. Otherwise the Box will be unmarked.
 * 
 * (this method overwrites UIComponent.showValue)
 * 
 *  @param value
 *  		[String] or [Number] to be shown
 */
CheckBox.prototype.showValue = function(value){	
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
 * PUBLIC set the selection (check) of the CheckBox
 * 
 * @param value
 * 			[Boolean] true -> checked; false -> not checked
 */
CheckBox.prototype.setSelected = function(value){
	this.htmlElement.attr('checked',value);
	
	this.selected = value;
	
	this.htmlElement.trigger('change');
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
CheckBox.prototype.onSelectionChangeFactory = function(_this){
	return function(){
		var value = "false";
		//assign CheckBox-value to value if CheckBox is checked
		if(_this.htmlElement.prop('checked') == true){
			value = "true";
			_this.selected = true;
		}
		else{
			_this.selected = false;
		}
		
		var signal = new FormDataChangedSignal();
		
		signal.setWidget(_this);
		signal.setDataItemValue(value);
		
		pmBus.fireEvent(signal);
	};	
};

/**
 * PRIVATE initialize the Representation by setting the content (image/text) and
 * styling attributes
 * 
 * @param repObj
 * 			[Object] RepresentationRecord in JSON
 */
CheckBox.prototype.initializeRepresentation = function(repObj){
	var checkBoxSpec = repObj["Check Box Specifics"];
	var label = checkBoxSpec["Label"];
	var value = checkBoxSpec["Value"];
	var textCanWrap = checkBoxSpec["TextCanWrap"];
	
	this.value = value;
	
	this.htmlElement.attr('value', value);
	
	if(textCanWrap != undefined){
		if(textCanWrap){
			this.htmlContainer.css('word-wrap', 'break-word');
		}
		else {
			this.htmlContainer.css('overflow', 'hidden');
		}
	}
	
	if(label != undefined){
		this.setTextByDefinition(label);
	}
	
	//use the UIComponent.js function to set Representation-attributes
	CheckBox.__super__.setRepresentationAttributes.apply(this,[repObj]);
};

/**
 * PRIVATE initialize the Interaction by saving the the InteractionEffects and
 * assigning them to event-handlers
 */
CheckBox.prototype.intitializeInteraction = function(){		
	CheckBox.__super__.intitializeInteraction.apply(this);
	
	//bind onChange event-handler to HTML-Element
	var _this = this;	
	var onSelectionChangeFunction = this.onSelectionChangeFactory(this);
	
	this.htmlElement.change(onSelectionChangeFunction);
	
	//Spread initial selection value after a delay
	setTimeout(function(){
		_this.htmlElement.trigger('change');
	}, this.pmBusInitDelay);
};