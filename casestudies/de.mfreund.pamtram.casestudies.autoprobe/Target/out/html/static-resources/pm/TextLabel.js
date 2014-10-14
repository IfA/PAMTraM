/**
 * 
 */
function TextLabel(properties, representation, interaction, animation){
	/*general properties*/
	this.name = 					properties["Name"];
	this.htmlElement = 				$("#"+ this.name);	
	this.htmlContainer = 			$("#"+ this.name +"-container");
	this.containedUIComponents = 	$.extend(true, {}, TextLabel.__super__.containedUIComponents);
	this.parentUIComponent = 		$.extend(true, {}, TextLabel.__super__.parentUIComponent);

	/*Representation-properties*/
	//Note: use of jQuery.extend() to get a real clone of the superclass'
	//properties, not just a reference
	this.representation = 			$.extend(true, {}, TextLabel.__super__.representation);
	this.representationMapping = 	$.extend(true, {}, TextLabel.__super__.representationMapping);	
	this.currentFlashColor =		$.extend(true, {}, TextLabel.__super__.currentFlashColor);
	this.flashIntervalReference = 	$.extend(true, {}, TextLabel.__super__.flashIntervalReference);
	this.flashResetColor = 			$.extend(true, {}, TextLabel.__super__.flashResetColor);
	this.currentText = 				"";
	this.currentLabeledText =		new Array();
	this.currentImage = 			$.extend(true, {}, TextLabel.__super__.currentImage);

	/*Interaction-properties*/
	this.interaction = 			interaction;
	this.interactionEffects = 	$.extend(true, {}, TextLabel.__super__.interactionEffects);
	this.latestWidgetValue = 	$.extend(true, {}, TextLabel.__super__.latestWidgetValue);
	
	/*Animation-properties*/
	this.animation = 				animation;
	this.animationTriggerSignals = 	$.extend(true, {}, TextLabel.__super__.animationTriggerSignals);
	this.propertyToAnimCont = 		$.extend(true, {}, TextLabel.__super__.propertyToAnimCont);
	this.propertiesToAnimDiscr = 	$.extend(true, {}, TextLabel.__super__.propertiesToAnimDiscr);
	this.rangeComparators = 		$.extend(true, {}, TextLabel.__super__.rangeComparators);
	this.simpleComparators = 		$.extend(true, {}, TextLabel.__super__.simpleComparators);
	
	/*initialize the UIComponent*/
	this.initializeRepresentation(representation);
	
	TextLabel.__super__.intitializeInteraction.apply(this);
	
	TextLabel.__super__.initializeAnimation.apply(this);
	
	eventBus.subscribe(this,LanguageChangedSignal);
}
extend(TextLabel, UIComponent);

/**
 * PRIVATE initialize the Representation by setting the text and styling
 * attributes
 * 
 * @param repObj
 * 			[Object] RepresentationRecord in JSON
 */
TextLabel.prototype.initializeRepresentation = function(repObj){
	var textLabelSpec = repObj["Text Label Specifics"];
	var label = textLabelSpec["Label"];
	var textCanWrap = textLabelSpec["TextCanWrap"];
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
	TextLabel.__super__.setRepresentationAttributes.apply(this,[repObj]);
};