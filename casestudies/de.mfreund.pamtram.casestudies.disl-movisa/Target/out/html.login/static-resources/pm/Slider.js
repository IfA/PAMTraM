/**
 * Using jQueryUI slider widget (see API for further reference, particularly for
 * improvement or realization of additional functionality)
 */
function Slider(properties, representation, interaction, animation){
	/*general properties*/
	this.name = 					properties["Name"];
	this.htmlElement = 				$("#"+ this.name);	
	this.htmlContainer = 			$("#"+ this.name +"-container");
	this.containedUIComponents = 	$.extend(true, {}, Slider.__super__.containedUIComponents);
	this.parentUIComponent = 		$.extend(true, {}, Slider.__super__.parentUIComponent);

	/*Representation-properties*/
	//Note: use of jQuery.extend() to get a real clone of the superclass'
	//properties, not just a reference
	this.representation = 			$.extend(true, {}, Slider.__super__.representation);
	this.representationMapping = 	$.extend(true, {}, Slider.__super__.representationMapping);	
	this.currentFlashColor =		$.extend(true, {}, Slider.__super__.currentFlashColor);
	this.flashIntervalReference = 	$.extend(true, {}, Slider.__super__.flashIntervalReference);
	this.flashResetColor = 			$.extend(true, {}, Slider.__super__.flashResetColor);
	this.currentText = 				"";
	this.currentLabeledText =		new Array();
	this.currentImage = 			$.extend(true, {}, Slider.__super__.currentImage);

	/*Interaction-properties*/
	this.interaction = 			interaction;
	this.interactionEffects = 	$.extend(true, {}, Slider.__super__.interactionEffects);
	this.latestWidgetValue = 	$.extend(true, {}, Slider.__super__.latestWidgetValue);
	
	/*Animation-properties*/
	this.animation = 				animation;
	this.animationTriggerSignals = 	$.extend(true, {}, Slider.__super__.animationTriggerSignals);
	this.propertyToAnimCont = 		$.extend(true, {}, Slider.__super__.propertyToAnimCont);
	this.propertiesToAnimDiscr = 	$.extend(true, {}, Slider.__super__.propertiesToAnimDiscr);
	this.comparators = 				$.extend(true, {}, Image.__super__.comparators);
	this.rangeComparators = 		$.extend(true, {}, Slider.__super__.rangeComparators);
	this.simpleComparators = 		$.extend(true, {}, Slider.__super__.simpleComparators);
	
	/*initialize the UIComponent*/
	this.initializeRepresentation(representation);
	Slider.__super__.intitializeInteraction.apply(this);
	
	Slider.__super__.initializeAnimation.apply(this);
	
	eventBus.subscribe(this,LanguageChangedSignal);
}
extend(Slider, UIComponent);

Slider.prototype.initializeRepresentation = function(representation) {
	Slider.__super__.setRepresentationAttributes.apply(this,[representation]);
	
	// we only support one scale and one slidebar:
	var scale = representation['Slider Specifics']['Scale'][0];
	
	// This is the slider element that will be bound to the html element.
	this.htmlElement.slider({
		range : 'min',
		min : scale['ScaleStart'],
		max : scale['ScaleEnd'],
		step : scale['ScaleStep'],
		animate : true
	});
	
	// the scale caption
	var scaleCaptionContainer = $('<div/>').css({
		'width' : '100%',
		'height' : '15px'
	});
	
	// the scale
	var scaleContainer = $('<div/>').css({
		'width' : '100%',
		'height' : '5px'
	});
	
	// create ticks for scale and append them to the scale container
	for (var i=scale['ScaleStart']; i<=scale['ScaleEnd']; i+=scale['ScaleStep']) {
		var tick = $('<div/>').css({
			'height' : '5px',
			'width' : '1px',
			'float' : 'left',
			'margin-left' : (scale['ScaleStep']-1) + 'px',
			'background-color' : 'grey'}).appendTo(scaleContainer);
	}
	
	// create ticks for scale caption and append them to the scale caption container
	for (var i=scale['ScaleCaptionStart']; i<=scale['ScaleCaptionEnd']; i+=scale['ScaleCaptionStep']) {
		var tick = $('<div/>', {text : i}).css({
			'height' : '15px',
			'width' : '20px',
			'float' : 'left',
			'margin-right' : (scale['ScaleCaptionStep']-21) + 'px',
			'border-left' : '1px solid grey'}).appendTo(scaleCaptionContainer);
	}
	
	// handle location of the scale
	if (scale['Location'].indexOf('ABOVE') > -1) {
		this.htmlElement.before(scaleCaptionContainer.clone());
		this.htmlElement.before(scaleContainer.clone());
	}
	if (scale['Location'].indexOf('BELOW') > -1) {
		this.htmlElement.after(scaleCaptionContainer.clone());
		this.htmlElement.after(scaleContainer.clone());
	}
}

Slider.prototype.performIndicatorAnimation = function (record, value) {
	this.htmlElement.slider({value : value});
}