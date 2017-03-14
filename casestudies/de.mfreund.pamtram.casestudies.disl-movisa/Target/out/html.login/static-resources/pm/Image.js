/**
 * 
 */
function Image(properties, representation, interaction, animation){
	/*general properties*/
	this.name = 					properties["Name"];
	this.htmlElement = 				$("#"+ this.name);
	this.htmlContainer = 			$("#"+ this.name +"-container");
	this.containedUIComponents = 	$.extend(true, {}, Image.__super__.containedUIComponents);
	this.parentUIComponent = 		$.extend(true, {}, Image.__super__.parentUIComponent);
	this.isAccessible = 			$.extend(true, {}, Image.__super__.isAccessible);
	this.isValid =	 				$.extend(true, {}, Image.__super__.isValid);

	/*Representation-properties*/
	//Note: use of jQuery.extend() to get a real clone of the superclass'
	//properties, not just a reference
	this.representation = 			$.extend(true, {}, Image.__super__.representation);
	this.representationMapping = 	$.extend(true, {}, Image.__super__.representationMapping);	
	this.currentFlashColor =		$.extend(true, {}, Image.__super__.currentFlashColor);
	this.flashIntervalReference = 	$.extend(true, {}, Image.__super__.flashIntervalReference);
	this.flashResetColor = 			$.extend(true, {}, Image.__super__.flashResetColor);
	this.currentText = 				"";
	this.currentLabeledText =		new Array();
	this.currentImage = 			$.extend(true, {}, Image.__super__.currentImage);

	/*Interaction-properties*/
	this.interaction = 			interaction;
	this.interactionEffects = 	$.extend(true, {}, Image.__super__.interactionEffects);
	this.latestWidgetValue = 	$.extend(true, {}, Image.__super__.latestWidgetValue);
	
	/*Animation-properties*/
	this.animation = animation;
	this.comparators = 				$.extend(true, {}, Image.__super__.comparators);
	
	/*initialize the UIComponent*/
	this.initializeRepresentation(representation);
	
	Image.__super__.intitializeInteraction.apply(this);
	
	Image.__super__.initializeAnimation.apply(this);
	
	eventBus.subscribe(this,LanguageChangedSignal);
}
extend(Image, UIComponent);

/**
 * PRIVATE set attributes like styling and tooltiptext for the HTML-Element
 * 
 * @param repObj
 * 			[Object] RepresentationRecord in JSON
 */
Image.prototype.setRepresentationAttributes = function(repObj){
	var currentImageType = this.currentImage["Type"];
	
	//make sure, that the image has the same Width and Height as the div-
	//container
	if(currentImageType == "FixedImage" && repObj["Size"] != undefined){
		
		//set or delete the width-attribute
		if(repObj["Size"]["Width"] != undefined){
			if(repObj["Size"]["Width"] == null ){
				this.htmlElement.removeAttr('width');
			}
			else{
				this.htmlElement.attr('width', repObj["Size"]["Width"]);
			}
		}
		
		//set or delete the height-attribute
		if(repObj["Size"]["Height"] != undefined){
			if(repObj["Size"]["Height"] == null ){
				this.htmlElement.removeAttr('height');
			}
			else{
				this.htmlElement.attr('height', repObj["Size"]["Height"]);
			}
		}
	}
	
	Image.__super__.setRepresentationAttributes.apply(this, [repObj]);
};

/**
 * PRIVATE set the Image by its name in the ImageBundle with respect to the 
 * ImageType (FixedImage, CameraImage)
 * 
 * @param imageName
 * 			[String] name of the image in the ImageBundle
 */
Image.prototype.setImage = function(imageName){
	var imageResObj = imageBundle.getImageByName(imageName);
	var imageUrl = imageResObj["Url"];
	var imageType = imageResObj["Type"];
	
	if(imageType == "FixedImage"){
		if (this.htmlElement.attr('src') === imageUrl) {
			return;
		}
		this.htmlElement.attr({ alt : imageName, src : imageUrl })
	}
	else if(imageType == "CameraImage"){
		//to implement
	}
	
	this.currentImage = imageResObj;
	
	this.updateOverlays();
};

/**
 * PRIVATE initialize the Representation by converting the movisa-data to CSS-
 * data and setting the image
 * 
 * @param repObj
 * 			[Object] RepresentationRecord in JSON
 */
Image.prototype.initializeRepresentation = function(repObj){
	var imageSpec = repObj["Image Specifics"];
	var imageName = imageSpec["Image"];
	
	this.setImage(imageName);
	
	this.setRepresentationAttributes(repObj);
};