/**
 * 
 */
function SimpleContainer(properties, representation, interaction, animation){
	/*general properties*/
	this.name = 					properties["Name"];
	this.htmlElement = 				$("#"+ this.name +"-container");	
	this.htmlContainer = 			$("#"+ this.name +"-container");
	this.containedUIComponents = 	$.extend(true, {}, SimpleContainer.__super__.containedUIComponents);
	this.parentUIComponent = 		$.extend(true, {}, SimpleContainer.__super__.parentUIComponent);

	/*Representation-properties*/
	//Note: use of jQuery.extend() to get a real clone of the superclass'
	//properties, not just a reference
	this.representation = 			$.extend(true, {}, SimpleContainer.__super__.representation);
	this.representationMapping = 	$.extend(true, {}, SimpleContainer.__super__.representationMapping);	
	this.currentFlashColor =		$.extend(true, {}, SimpleContainer.__super__.currentFlashColor);
	this.flashIntervalReference = 	$.extend(true, {}, SimpleContainer.__super__.flashIntervalReference);
	this.flashResetColor = 			$.extend(true, {}, SimpleContainer.__super__.flashResetColor);
	this.currentText = 				"";
	this.currentLabeledText =		new Array();
	this.currentImage = 			$.extend(true, {}, SimpleContainer.__super__.currentImage);

	/*Interaction-properties*/
	this.interaction = 			interaction;
	this.interactionEffects = 	$.extend(true, {}, SimpleContainer.__super__.interactionEffects);
	this.latestWidgetValue = 	$.extend(true, {}, SimpleContainer.__super__.latestWidgetValue);
	
	/*Animation-properties*/
	this.animation = 				animation;
	this.animationTriggerSignals = 	$.extend(true, {}, SimpleContainer.__super__.animationTriggerSignals);
	this.propertyToAnimCont = 		$.extend(true, {}, SimpleContainer.__super__.propertyToAnimCont);
	this.propertiesToAnimDiscr = 	$.extend(true, {}, SimpleContainer.__super__.propertiesToAnimDiscr);
	this.rangeComparators = 		$.extend(true, {}, SimpleContainer.__super__.rangeComparators);
	this.simpleComparators = 		$.extend(true, {}, SimpleContainer.__super__.simpleComparators);
	
	/*initialize the UIComponent*/
	SimpleContainer.__super__.setRepresentationAttributes.apply(this,[representation]);
	
	SimpleContainer.__super__.intitializeInteraction.apply(this);
	
	SimpleContainer.__super__.initializeAnimation.apply(this);
	
	eventBus.subscribe(this,LanguageChangedSignal);
}
extend(SimpleContainer, UIComponent);