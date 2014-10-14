/**
 * 
 */
function CheckBoxArray(properties, representation, interaction, animation){
	/*general properties*/
	this.name = 					properties["Name"];
	this.htmlElement = 				$("#"+ this.name);	
	this.htmlContainer = 			$("#"+ this.name +"-container");
	this.containedUIComponents = 	$.extend(true, {}, CheckBoxArray.__super__.containedUIComponents);
	this.parentUIComponent = 		$.extend(true, {}, CheckBoxArray.__super__.parentUIComponent);
	
	/*Representation-properties*/
	//Note: use of jQuery.extend() to get a real clone of the superclass'
	//properties, not just a reference
	this.representation = 			$.extend(true, {}, CheckBoxArray.__super__.representation);
	this.representationMapping = 	$.extend(true, {}, CheckBoxArray.__super__.representationMapping);	
	
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
	
	this.currentFlashColor =		$.extend(true, {}, CheckBoxArray.__super__.currentFlashColor);
	this.flashIntervalReference = 	$.extend(true, {}, CheckBoxArray.__super__.flashIntervalReference);
	this.flashResetColor = 			$.extend(true, {}, CheckBoxArray.__super__.flashResetColor);
	this.currentText = 				"";
	this.currentLabeledText =		new Array();
	this.currentImage = 			$.extend(true, {}, CheckBoxArray.__super__.currentImage);

	/*Interaction-properties*/
	this.interaction = 			interaction;
	this.interactionEffects = 	$.extend(true, {}, CheckBoxArray.__super__.interactionEffects);
	this.latestWidgetValue = 	$.extend(true, {}, CheckBoxArray.__super__.latestWidgetValue);
	
	/*Animation-properties*/
	this.animation = 				animation;
	this.animationTriggerSignals = 	$.extend(true, {}, CheckBoxArray.__super__.animationTriggerSignals);
	this.propertyToAnimCont = 		$.extend(true, {}, CheckBoxArray.__super__.propertyToAnimCont);
	this.propertiesToAnimDiscr = 	$.extend(true, {}, CheckBoxArray.__super__.propertiesToAnimDiscr);
	this.rangeComparators = 		$.extend(true, {}, CheckBoxArray.__super__.rangeComparators);
	this.simpleComparators = 		$.extend(true, {}, CheckBoxArray.__super__.simpleComparators);
	
	/*Check Box Array properties */
	this.selected =	properties["Selected"];
	this.relatedCheckValues = {};
	
	/*initialize the UIComponent*/
	this.initializeRepresentation(representation);
	
	CheckBoxArray.__super__.intitializeInteraction.apply(this);
	
	CheckBoxArray.__super__.initializeAnimation.apply(this);
	
	eventBus.subscribe(this,LanguageChangedSignal);
}
extend(CheckBoxArray, UIComponent);

/**
 * PUBLIC get the current value
 * 
 * @returns [String] null, if it is not checked; this.value if checked
 */
CheckBoxArray.prototype.getValue = function(){
	var value = new Array();
	
	//for every CheckBox in containedUIComponents
	for(var UIName in this.containedUIComponents){
		if(this.containedUIComponents[UIName].constructor.name == "CheckBox"){
			
			//save the current value if CheckBox is checked
			if(this.containedUIComponents[UIName].getValue() != null ){
				value.push(this.containedUIComponents[UIName].getValue());
			}
		}
	}
	
	return value;
}

/**
 * PUBLIC register a contained CheckBox
 * 
 * @param UIComp
 * 			[Object] of the UIComponent
 */
CheckBoxArray.prototype.addContainedUIComponent = function(UIComp){
	var UICompName = UIComp.getName();
	
	if(UIComp.constructor.name == "CheckBox"){
		this.containedUIComponents[UICompName] = UIComp;
		this.latestWidgetValue[UICompName] = null;
		this.relatedCheckValues[UIComp.getName()] = UIComp.getValueName();
		
		UIComp.htmlElement.attr('name', this.name);
		
		pmBus.subscribe(this, FormDataChangedSignal);
		
		if($.inArray(UICompName, this.selected) != -1){
			UIComp.setSelected(true);
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
CheckBoxArray.prototype.setLatestWidgetData = function(widgetName, data){
	var signal;
	
	if(this.latestWidgetValue[widgetName] != data){
		this.latestWidgetValue[widgetName] = data;	
		
		signal = new FormDataChangedSignal();
		
		signal.setWidget(this);
		signal.setDataItemValue(this.getValue());
		
		pmBus.fireEvent(signal);
	}
};

/**
 * PRIVATE show value(s) by handing the value(s) over to the contained 
 * CheckBoxes. If a value is matched by a CheckBox it will be checked, otherwise
 * it will be unchecked
 * 
 * @param value
 * 			[Array] 
 */
CheckBoxArray.prototype.showValue = function(value){
	var comp;
	
	//for every CheckBox in containedUIComponents
	for(var UIName in this.containedUIComponents ){
		comp = this.containedUIComponents[UIName];
		
		if(comp.constructor.name == "CheckBox"){
			//if the CheckBox-value of the current CheckBox is in the value Array
			if($.inArray( this.relatedCheckValues[UIName], value ) != -1){
				comp.showValue(true);
			}
			else{
				comp.showValue(false);
			}
		}
	}
};

/**
 * PRIVATE initialize the Representation by setting the content (image/text) and
 * styling attributes
 * 
 * @param repObj
 * 			[Object] RepresentationRecord in JSON
 */
CheckBoxArray.prototype.initializeRepresentation = function(repObj){
	var checkBoxArrSpec = repObj["Check Box Array Specifics"];
	var label = checkBoxArrSpec["Label"];
	var textCanWrap = checkBoxArrSpec["TextCanWrap"];
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
	CheckBoxArray.__super__.setRepresentationAttributes.apply(this,[repObj]);
};