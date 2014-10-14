/**
 * 
 */
function Button(properties, representation, interaction, animation){
	/*general properties*/
	this.name = 					properties["Name"];
	this.htmlElement = 				$("#"+ this.name);	
	this.htmlContainer = 			$("#"+ this.name +"-container");
	this.containedUIComponents = 	$.extend(true, {}, Button.__super__.containedUIComponents);
	this.parentUIComponent = 		$.extend(true, {}, Button.__super__.parentUIComponent);
	
	/*Representation-properties*/
	//Note: use of jQuery.extend() to get a real clone of the superclass'
	//properties, not just a reference
	this.representation = 			$.extend(true, {}, Button.__super__.representation);
	this.representationMapping = 	$.extend(true, {}, Button.__super__.representationMapping);	
	this.currentFlashColor =		$.extend(true, {}, Button.__super__.currentFlashColor);
	this.flashIntervalReference = 	$.extend(true, {}, Button.__super__.flashIntervalReference);
	this.flashResetColor = 			$.extend(true, {}, Button.__super__.flashResetColor);
	this.currentText = 				"";
	this.currentLabeledText =		new Array();
	this.currentImage = 			$.extend(true, {}, Button.__super__.currentImage);

	/*Interaction-properties*/
	this.interaction = 			interaction;
	this.interactionEffects = 	$.extend(true, {}, Button.__super__.interactionEffects);
	this.latestWidgetValue = 	$.extend(true, {}, Button.__super__.latestWidgetValue);
	
	/*Animation-properties*/
	this.animation = 				animation;
	this.animationTriggerSignals = 	$.extend(true, {}, Button.__super__.animationTriggerSignals);
	this.propertyToAnimCont = 		$.extend(true, {}, Button.__super__.propertyToAnimCont);
	this.propertiesToAnimDiscr = 	$.extend(true, {}, Button.__super__.propertiesToAnimDiscr);
	this.rangeComparators = 		$.extend(true, {}, Button.__super__.rangeComparators);
	this.simpleComparators = 		$.extend(true, {}, Button.__super__.simpleComparators);
	
	/*initialize the UIComponent*/
	this.initializeRepresentation(representation);
	
	Button.__super__.intitializeInteraction.apply(this);
	
	Button.__super__.initializeAnimation.apply(this);
	
	eventBus.subscribe(this,LanguageChangedSignal);
}
extend(Button, UIComponent);

/**
 * PRIVATE set a new image in the Button. Image gets prepended with a leading
 * break-tag, if there is already an image.
 * 
 * @param imageResource
 * 			[String] URL of the image-resource
 */
Button.prototype.setImage = function(imageName){
	var oldImage = this.htmlElement.find('img');
	var imageResObj = imageBundle.getImageByName(imageName);
	var imageUrl = imageResObj["Url"];
	var imageType = imageResObj["Type"];
	var imageCode = '<img alt="'+ imageName +'" src="'+ imageUrl +'">';
	
	//get the text-node
	var textNode = this.htmlElement.contents().filter(function(){
		return this.nodeType == 3; //text-node
	});
	
	//if there is already an image
	if(oldImage.length > 0){
		//replace it without break
		oldImage.replaceWith(imageCode);
	}
	else{
		//insert it with a break, if there is also text
		if(textNode.length > 0){
			this.htmlElement.prepend(imageCode +'<br>');
		}
		else{ //or without break, if there is no text
			this.htmlElement.prepend(imageCode);
		}
	}
	
	this.currentImage = imageResObj;
	
	this.updateOverlays();
};

/**
 * PRIVATE delete an image from a button. Text remains untouched. Break between
 * image and text will be removed.
 */
Button.prototype.unsetImage = function(){
	this.htmlElement.find("img").remove();
	this.htmlElement.find("br").remove();
	this.currentImage = "";
	
	this.updateOverlays();
};

/**
 * PRIVATE set a text for the Button. Text gets appended with a leading break-
 * tag, if there is already an image
 * 
 * @param text
 * 			[String] to be set
 */
Button.prototype.setText = function(text){
	var image = this.htmlElement.find("img");
	
	if(text == ""){
		this.unsetText();
	}
	else{
		//get the text-node
		var textNode = this.htmlElement.contents().filter(function(){
			return this.nodeType == 3; //text-node
		});
		
		//if there is already some text
		if(textNode.length != 0){
			textNode.replaceWith(text);
		}
		else{ //if there is no text yet...
			//...but an image
			if(image.length > 0){
				//append the new text with a break
				this.htmlElement.append("<br>"+ text);
			}
			else{
				//append the new text without a break
				this.htmlElement.append(text);
			}
		}
		
		this.currentText = text;
		
		this.updateOverlays();
	}
};

/**
 * PRIVATE delete text from Button. Images remain untouched. Break between image
 * and text will be removed.
 */
Button.prototype.unsetText = function(){
	var image = this.htmlElement.find('img');
	
	if(image.length > 0){
		this.htmlElement.contents().replaceWith(image);
	}
	
	this.currentText = "";
	
	this.updateOverlays();
};

/**
 * PRIVATE initialize the Representation by setting the content (image/text) and
 * styling attributes
 * 
 * @param repObj
 * 			[Object] RepresentationRecord in JSON
 */
Button.prototype.initializeRepresentation = function(repObj){
	var buttonSpec = repObj["Button Specifics"];
	var label = buttonSpec["Label"];
	var image = buttonSpec["ImageResource"];
	var textCanWrap = buttonSpec["TextCanWrap"];
	var toggle = buttonSpec["Toggle"];
	var textWrapProperty = 'normal';
	
	if(textCanWrap != undefined){
		if(textCanWrap){
			textWrapProperty = 'break-word';
		}
		
		this.htmlContainer.css('word-wrap', textWrapProperty);
	}
	
	if(image != undefined){
		this.setImage(image);
	}
	
	if(label != undefined){
		this.setTextByDefinition(label);
	}
	
	//use the UIComponent.js function to set Representation-attributes
	Button.__super__.setRepresentationAttributes.apply(this, [repObj]);
};