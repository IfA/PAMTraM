
function Input(properties, representation, interaction, animation){
	/*general properties*/
	this.name = 					properties["Name"];
	this.htmlElement = 				undefined;
	this.htmlContainer = 			$("#"+ this.name +"-container");
	this.containedUIComponents = 	$.extend(true, {}, Input.__super__.containedUIComponents);
	this.parentUIComponent = 		$.extend(true, {}, Input.__super__.parentUIComponent);
	
	/*Representation-properties*/
	//Note: use of jQuery.extend() to get a real clone of the superclass'
	//properties, not just a reference
	this.representation = 			$.extend(true, {}, Input.__super__.representation);
	this.representationMapping = 	$.extend(true, {}, Input.__super__.representationMapping);	
	
	this.currentFlashColor =		$.extend(true, {}, Input.__super__.currentFlashColor);
	this.flashIntervalReference = 	$.extend(true, {}, Input.__super__.flashIntervalReference);
	this.flashResetColor = 			$.extend(true, {}, Input.__super__.flashResetColor);
	this.currentLabeledText =		new Array();
	this.currentImage = 			$.extend(true, {}, Input.__super__.currentImage);

	/*Interaction-properties*/
	this.interaction = 			interaction;
	this.interactionEffects = 	$.extend(true, {}, Input.__super__.interactionEffects);
	this.latestWidgetValue = 	$.extend(true, {}, Input.__super__.latestWidgetValue);
	
	/*Animation-properties*/
	this.animation = 				animation;
	this.animationTriggerSignals = 	$.extend(true, {}, Input.__super__.animationTriggerSignals);
	this.propertyToAnimCont = 		$.extend(true, {}, Input.__super__.propertyToAnimCont);
	this.propertiesToAnimDiscr = 	$.extend(true, {}, Input.__super__.propertiesToAnimDiscr);
	this.rangeComparators = 		$.extend(true, {}, Input.__super__.rangeComparators);
	this.simpleComparators = 		$.extend(true, {}, Input.__super__.simpleComparators);
	
	/*Input specific properties*/
	this.value = 0;
	this.multiRow;
	this.maxLength;
	
	/*initialize the UIComponent*/
	this.initializeRepresentation(properties, representation);
	
	this.intitializeInteraction();
	
	Input.__super__.initializeAnimation.apply(this);
	
	eventBus.subscribe(this,LanguageChangedSignal);
}
extend(Input, UIComponent);

/**
 * PRIVATE write a Text in the HTML-element. 
 * 
 * @param text
 * 			[String] text to write
 */
Input.prototype.setText = function(text){
	if(this.multiRow == true){
		this.htmlElement.text(text);
	}
	else{
		this.htmlElement.attr("value", text);
	}
	
	this.htmlElement.trigger('change');
};

/**
 * PRIVATE creates a Function that ensures, that the text-area does not contain
 * more characters than defined by maxLength
 * 
 * @param this
 * 			[Object] the UIComponent
 */
Input.prototype.ensureMaxLengthFactory = function(_this){
	return function(){
		var text = _this.htmlElement.val();
		var new_text;
		var chars = text.length;
		
		if(chars > _this.maxLength){
			new_text = text.substr(0, _this.maxLength);
			_this.htmlElement.val(new_text);
		}
	}
};

/**
 * PRIVATE creates a Function that controls the behavior when the input changes
 * 
 * @param this
 * 			[Object] the UIComponent
 */
Input.prototype.onChangeFactory = function(_this){
	return function(){
		if(_this.multiRow == true){
			_this.htmlElement.trigger('keyup');
			_this.value = _this.htmlElement.text();
		}
		else{
			_this.value = _this.htmlElement.val();
		}
		
		signal = new FormDataChangedSignal();
		
		signal.setWidget(_this);
		signal.setDataItemValue(_this.value);
		
		pmBus.fireEvent(signal);
	}
};

/**
 * PRIVATE initialize the Representation by setting the content (image/text) and
 * styling attributes
 * 
 * @param repObj
 * 			[Object] RepresentationRecord in JSON
 */
Input.prototype.initializeRepresentation = function(propObj, repObj){
	var inputSpec = repObj["Input Specifics"];
	var label = inputSpec["Label"];
	var textCanWrap = inputSpec["TextCanWrap"];
	var multiRow = inputSpec["MultiRow"];
	var maxLength = inputSpec["MaxLength"];
	var showCharsSimult = inputSpec["ShowCharactersSimultaneously"];
	var secretInput = inputSpec["SecretInput"];
	
	this.multiRow = multiRow;
	this.maxLength = maxLength;
	
	var type = 'text';
	
	//insert <textarea> or <input> depending on $multiRow
	if(multiRow == true){
		this.htmlContainer.append('<textarea id="'+ this.name +'" name="'+ 
				this.name +'" cols="'+ 
				showCharsSimult +'" rows="5"></textarea>');
	}
	else{
		if(secretInput != undefined){
			if(secretInput == true){
				type = 'password';
			}
		}
		this.htmlContainer.append('<input id="'+ this.name +'" type="'+ type 
				+'">');
	}
	
	this.htmlElement = $("#"+ this.name);
	
	//ensure max length
	if(maxLength != undefined){
		if(multiRow == true){
			
		}
		else{
			this.htmlElement.attr('maxlength', maxLength);
		}
	}
	
	if(label != undefined){
		this.setTextByDefinition(label);
	}
	
	//use the UIComponent.js function to set Representation-attributes
	Input.__super__.setRepresentationAttributes.apply(this,[repObj]);
};

/**
 * PRIVATE initialize the Interaction by saving the the InteractionEffects and
 * assigning them to event-handlers
 */
Input.prototype.intitializeInteraction = function(){		
	Input.__super__.intitializeInteraction.apply(this);
	
	this.htmlElement.change(this.onChangeFactory(this));
	
	if(this.multiRow == true){
		this.htmlElement.keyup(this.ensureMaxLengthFactory(this));
	}
	
	var _this = this;
	
	//Spread initial selection value after a delay
	setTimeout(function(){
		_this.htmlElement.trigger('change');
	}, this.pmBusInitDelay);
};