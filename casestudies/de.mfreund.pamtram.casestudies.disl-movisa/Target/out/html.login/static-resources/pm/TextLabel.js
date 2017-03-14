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
	// fix for vertical centering in labels
	this.representationMapping.Alignment.VerticalAlignment.connectedToElement = false;	
	this.representationMapping.Alignment.VerticalAlignment.connectedToContainer = true;
	this.representationMapping.Border.BorderType.connectedToElement = false;
	this.representationMapping.Border.BorderType.connectedToContainer = true;
	this.representationMapping.Border.LineColor.connectedToElement = false;
	this.representationMapping.Border.LineColor.connectedToContainer = true;
	this.representationMapping.Border.Padding.connectedToElement = false;
	this.representationMapping.Border.Padding.connectedToContainer = true;
	this.representationMapping.Border.Width.connectedToElement = false;
	this.representationMapping.Border.Width.connectedToContainer = true;
	this.representationMapping.Size.Height.connectedToElement = false;
	this.representationMapping.Size.Height.connectedToContainer = true;
	this.representationMapping.Size.Width.connectedToElement = false;
	this.representationMapping.Size.Width.connectedToContainer = true;

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
	this.comparators = 				$.extend(true, {}, Image.__super__.comparators);
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
	if(repObj.Alignment != null && repObj.Alignment.VerticalAlignment == "MIDDLE") {
		this.htmlElement.css("position", "relative");
		this.htmlElement.css("top", "50%");
		this.htmlElement.css("-webkit-transform", "translateY(-50%)");
	}
	
	
	//use the UIComponent.js function to set Representation-attributes
	TextLabel.__super__.setRepresentationAttributes.apply(this,[repObj]);
};