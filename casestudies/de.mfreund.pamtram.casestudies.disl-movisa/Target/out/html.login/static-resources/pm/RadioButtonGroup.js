/**
 * 
 */
function RadioButtonGroup(properties, representation, interaction, animation){
	/*general properties*/
	this.name = 					properties["Name"];
	this.htmlElement = 				$("#"+ this.name);	
	this.htmlContainer = 			$("#"+ this.name +"-container");
	this.containedUIComponents = 	$.extend(true, {}, RadioButtonGroup.__super__.containedUIComponents);
	this.parentUIComponent = 		$.extend(true, {}, RadioButtonGroup.__super__.parentUIComponent);

	/*Representation-properties*/
	//Note: use of jQuery.extend() to get a real clone of the superclass'
	//properties, not just a reference
	this.representation = 			$.extend(true, {}, RadioButtonGroup.__super__.representation);
	this.representationMapping = 	$.extend(true, {}, RadioButtonGroup.__super__.representationMapping);	
	
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
	
	this.currentFlashColor =		$.extend(true, {}, RadioButtonGroup.__super__.currentFlashColor);
	this.flashIntervalReference = 	$.extend(true, {}, RadioButtonGroup.__super__.flashIntervalReference);
	this.flashResetColor = 			$.extend(true, {}, RadioButtonGroup.__super__.flashResetColor);
	this.currentText = 				"";
	this.currentLabeledText =		new Array();
	this.currentImage = 			$.extend(true, {}, RadioButtonGroup.__super__.currentImage);

	/*Interaction-properties*/
	this.interaction = 			interaction;
	this.interactionEffects = 	$.extend(true, {}, RadioButtonGroup.__super__.interactionEffects);
	this.latestWidgetValue = 	$.extend(true, {}, RadioButtonGroup.__super__.latestWidgetValue);
	
	/*Animation-properties*/
	this.animation = 				animation;
	this.animationTriggerSignals = 	$.extend(true, {}, RadioButtonGroup.__super__.animationTriggerSignals);
	this.propertyToAnimCont = 		$.extend(true, {}, RadioButtonGroup.__super__.propertyToAnimCont);
	this.propertiesToAnimDiscr = 	$.extend(true, {}, RadioButtonGroup.__super__.propertiesToAnimDiscr);
	this.comparators = 				$.extend(true, {}, Image.__super__.comparators);
	this.rangeComparators = 		$.extend(true, {}, RadioButtonGroup.__super__.rangeComparators);
	this.simpleComparators = 		$.extend(true, {}, RadioButtonGroup.__super__.simpleComparators);
	
	/*Radio Button Group properties */
	this.selected =	properties["Selected"];
	this.value;
	
	/*initialize the UIComponent*/	
	this.initializeRepresentation(representation);
	
	RadioButtonGroup.__super__.intitializeInteraction.apply(this);
	
	RadioButtonGroup.__super__.initializeAnimation.apply(this);
	
	eventBus.subscribe(this,LanguageChangedSignal);
}
extend(RadioButtonGroup, UIComponent);

/**
 * PUBLIC register a contained RadioButton
 * 
 * @param UIComp
 * 			[Object] of the UIComponent
 */
RadioButtonGroup.prototype.addContainedUIComponent = function(UIComp){
	RadioButtonGroup.__super__.addContainedUIComponent.call(this,UIComp);
	
	var UICompName = UIComp.getName();
	
	if(UIComp.constructor.name == "RadioButton"){		
		UIComp.htmlElement.attr('name', this.name);
		
		this.latestWidgetValue[UIComp.getName()] = null;
		pmBus.subscribe(this, FormDataChangedSignal);
		
		if(UICompName == this.selected){
			UIComp.setSelected(true);
			this.value = UIComp.getValue();
		}
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
RadioButtonGroup.prototype.setLatestWidgetData = function(widgetName, data){
	var signal;
	
	if(this.latestWidgetValue[widgetName] != data){
		this.latestWidgetValue[widgetName] = data;	
		this.selected = widgetName;
		this.value = data;
		
		signal = new FormDataChangedSignal();
		
		signal.setWidget(this);
		signal.setDataItemValue(data);
		
		pmBus.fireEvent(signal);
	}
};

/**
 * PRIVATE 
 * 
 * @param value
 * 			[Array] 
 */
RadioButtonGroup.prototype.showValue = function(value){
	var currentSelected = $('#'+ this.name +' > input[name="'+ this.name +'"]:selected');
	var radioWithValue = $('#'+ this.name +' > input[value="'+ value +'"]:first');
	
	if(radioWithValue.length > 0){
		if(currentSelected.attr('value') != value){
			currentSelected.attr('checked', false);
			currentSelected.trigger('change');
			
			radioWithValue.attr('checked', true);
			radioWithValue.trigger('change');
		}
	}
}

/**
 * PRIVATE initialize the Representation by setting the content (image/text) and
 * styling attributes
 * 
 * @param repObj
 * 			[Object] RepresentationRecord in JSON
 */
RadioButtonGroup.prototype.initializeRepresentation = function(repObj){
	var radioButtonGrpSpec = repObj["Radio Button Group Specifics"];
	var label = radioButtonGrpSpec["Label"];
	var textCanWrap = radioButtonGrpSpec["TextCanWrap"];
	var textWrapProperty = 'normal';
	
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
	RadioButtonGroup.__super__.setRepresentationAttributes.apply(this,[repObj]);
};