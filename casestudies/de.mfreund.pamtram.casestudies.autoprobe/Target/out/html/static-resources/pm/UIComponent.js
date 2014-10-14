/**
* ABSTRCT UIComponent
*/
function UIComponent(properties, representation, interaction, animation){
	//general properties
	this.name = properties["Name"];
	this.htmlElement = $("#"+ this.name);
	this.htmlContainer = $("#"+ this.name +"-container");
	
	//Interaction-properties
	this.interaction = interaction;	
	
	//Animation-properties
	this.animation = animation;	
	
	//initialize the UIComponent
	this.setRepresentationAttributes(representation);
	
	this.intitializeInteraction();
	
	this.initializeAnimation();
}
extend(UIComponent, EventSubscriber);

/* general properties */
UIComponent.prototype.name;
UIComponent.prototype.htmlElement;
UIComponent.prototype.htmlContainer;
UIComponent.prototype.containedUIComponents = {};
UIComponent.prototype.parentUIComponent;
UIComponent.prototype.pmBusInitDelay = 300;

UIComponent.prototype.isAccessible = true;
UIComponent.prototype.isValid = true;

/* Representation-properties */
UIComponent.prototype.representation  = {"Position":{},"Alignment":{},"Size":{},
		"Rotation":{},"Color":{},"Shadow":{},"State":{}, "Border":{},
		"ToolTipText":{}};

UIComponent.prototype.representationMapping = {
	"Alignment" : {
		"HorizontalAlignment" : {
			"Equivalent" : "text-align",
			"connectedToElement" : false,
			"connectedToContainer" : true
		},
		"VerticalAlignment" : {
			"Equivalent" : "vertical-align",
			"connectedToElement" : false,
			"connectedToContainer" : true
		}
	},
	"Border":{
		"BorderType" : {
			"Equivalent" : "border-style",
			"connectedToElement" : true,
			"connectedToContainer" : false
		},
		"LineColor" : {
			"Equivalent" : "border-color",
			"connectedToElement" : true,
			"connectedToContainer" : false
		},
		"Padding" : {
			"Equivalent" : "padding",
			"connectedToElement" : true,
			"connectedToContainer" : false
		},
		"Width" : {
			"Equivalent" : "border-width",
			"connectedToElement" : true,
			"connectedToContainer" : false
		}
	},
	"Color" : {
		"Background" : {
			"Equivalent" : "background-color",
			"connectedToElement" : true,
			"connectedToContainer" : true
		},
		"Foreground" : {
			"Equivalent" : "color",
			"connectedToElement" : true,
			"connectedToContainer" : true
		}
	},
	"Format":{
		"FontDecoration" : {
			"Equivalent" : "text-decoration",
			"connectedToElement" : true,
			"connectedToContainer" : true
		},
		"FontFace" : {
			"Equivalent" : "font-family",
			"connectedToElement" : true,
			"connectedToContainer" : true
		},
		"FontSize" : {
			"Equivalent" : "font-size",
			"connectedToElement" : true,
			"connectedToContainer" : true
		},
		"FontStyle" : {
			"Equivalent" : "font-style",
			"connectedToElement" : true,
			"connectedToContainer" : true
		},
		"FontWeight" : {
			"Equivalent" : "font-weight",
			"connectedToElement" : true,
			"connectedToContainer" : true
		}
	},
	"Position":{
		"X" : {
			"Equivalent" : "left",
			"connectedToElement" : false,
			"connectedToContainer" : true
		},
		"Y" : {
			"Equivalent" : "top",
			"connectedToElement" : false,
			"connectedToContainer" : true
		},
		"Z" : {
			"Equivalent" : "z-index",
			"connectedToElement" : false,
			"connectedToContainer" : true
		}
	},
	"Shadow" : {
		"Background" : {
			"Equivalent" : "box-shadow",
			"connectedToElement" : false,
			"connectedToContainer" : true
		},
		"Foreground" : {
			"Equivalent" : "text-shadow",
			"connectedToElement" : true,
			"connectedToContainer" : false
		}
	},
	"Size" : {
		"Height" : {
			"Equivalent" : "height",
			"connectedToElement" : true,
			"connectedToContainer" : false
		},
		"Width" : {
			"Equivalent" : "width",
			"connectedToElement" : true,
			"connectedToContainer" : false
		}
	},
	"State" : {
		"Visible" : {
			"Equivalent" : "visibility",
			"connectedToElement" : false,
			"connectedToContainer" : true
		}
	},
	"ToolTipText" : {
		"Text" : {
			"Equivalent" : "title",
			"connectedToElement" : true,
			"connectedToContainer" : true
		}
	}
	
};
UIComponent.prototype.currentText = "";
UIComponent.prototype.currentLabeledText = new Array();
UIComponent.prototype.currentImage = {};
UIComponent.prototype.currentValue = null;

/* Interaction-properties */
UIComponent.prototype.interaction;
UIComponent.prototype.interactionEffects = new Object();
UIComponent.prototype.latestWidgetValue = {};

/* Animation-properties */
UIComponent.prototype.animationTriggerSignals = {};
UIComponent.prototype.animationRecords = [];
UIComponent.prototype.propertyToAnimCont = {};
UIComponent.prototype.propertiesToAnimDiscr = {};
UIComponent.prototype.rangeComparators = {};
UIComponent.prototype.simpleComparators = {};
UIComponent.prototype.valueOutputAnimObj = {};
UIComponent.prototype.comparators = new Object();

/**
 * PROTECTED get the name of the UIComponent
 * 
 * @returns [String] name
 */
UIComponent.prototype.getName = function(){
	return this.name;
};

/**
 * PUBLIC if a UIComponent contains other UIComponente (e.g. SimpleContainer
 * or RadioButtonGroup) the contained Components have to be registered with this 
 * function
 * 
 * @param UIComp
 * 			[Object] of the UIComponent
 */
UIComponent.prototype.addContainedUIComponent = function(UIComp){
	//add the UIComponent to the contained UIComponents
	this.containedUIComponents[UIComp.getName()] = UIComp;
	
	//and inform $UIComponent, that it is contained by another UIComponent and
	//therefore has a parent UIComponent
	UIComp.registerParentUIComponent(this);
};

/**
 * PUBLIC register the parent UIComponent $parentUI of another UIComponent 
 * ($this).
 * 
 * @param parentUI
 * 			[Object] of the parent UIComponent
 */
UIComponent.prototype.registerParentUIComponent = function(parentUI){
	this.parentUIComponent = parentUI;
};

/**
 * PROTECTED handle a incoming Event
 * 
 * @param signal
 * 			[Signal] or Subtype of Signal
 */
UIComponent.prototype.handleEvent = function(signal){
	if(signal.constructor.name == "FormDataChangedSignal"){
		this.handleFormChangeSignal(signal);
	}
	else if(signal.constructor.name == "LanguageChangedSignal"){
		this.updateLabeledText();
	}
	else{
		for (var type in this.animation) {
			if (!this.animation.hasOwnProperty(type)) continue;
			
			for (var record = 0; record < this.animation[type].length; record++) {
				var _record = this.animation[type][record];
				
				if (signal.constructor.name == 
						this.animation[type][record]['TriggeringSignal'].name) {
					
					var prop = 
						this.animation[type][record]['UsePropertyOfTrigger'];
					var _value = null;
					
					if (prop !== undefined && prop !== null) {
						_value = signal['get' + prop.charAt(0).toUpperCase() + prop.slice(1)]();
					}
					else {
						_value = signal.getActualNotifyingDataItem()['Value'];
					} 
					// this is the general animation function.
					this.animate(type, _record, _value);
				}
			}
		}
	}
};

/**
 * PROTECTED handle a FormDataChangedSignal by saving the required data
 * 
 * @param signal
 * 			[FormDataChangedSignal]
 */
UIComponent.prototype.handleFormChangeSignal = function(signal){
	var widget = signal.getWidget();
	//iterate over all initialized entries in $lastWidgetValue
	console.log("FormChangeSignal received.");
	for(var widgetName in this.latestWidgetValue){
		if(widgetName == widget.getName()){
			this.setLatestWidgetData(widgetName, signal.getDataItemValue());
			break;
		}
	}
};

/**
 * PROTECTED set the latest Widget data
 * 
 * @param widgetName
 * 			[String] name of the Widget
 * @param data
 * 			[Object] latest Data of the Widget
 */
UIComponent.prototype.setLatestWidgetData = function(widgetName,data){
	this.latestWidgetValue[widgetName] = data;
};

/**
 * PROTECTED set attributes like styling and tooltiptext for the HTML-Element
 * 
 * @param repObj
 * 			[Object] RepresentationRecord in JSON
 */
UIComponent.prototype.setRepresentationAttributes = function(repObj){
	var sizeSet = false;
	var accessible = false;
	var valid = false;

	//iterate over every entry in the Representation-object and convert the
	//contained movisa-data to CSS/HTML-data
	for(var key in repObj){
		switch(key){
			case "Alignment":
				this.setCssObjectProperty(repObj, key, "HorizontalAlignment");
				this.setCssObjectProperty(repObj, key, "VerticalAlignment");
				
				break;
			case "Border":
				this.setCssObjectProperty(repObj, key, "BorderType");
				this.setCssObjectProperty(repObj, key, "LineColor");
				this.setCssObjectProperty(repObj, key, "Width");
				this.setCssObjectProperty(repObj, key, "Padding");
				
				break;
			case "Color":
				this.setCssObjectProperty(repObj, key, "Foreground");
				this.setCssObjectProperty(repObj, key, "Background");
				
				break;			
			case "Format":
				this.setCssObjectProperty(repObj, key, "FontDecoration");
				this.setCssObjectProperty(repObj, key, "FontFace");
				this.setCssObjectProperty(repObj, key, "FontSize");
				this.setCssObjectProperty(repObj, key, "FontStyle");
				this.setCssObjectProperty(repObj, key, "FontWeight");
				
				break;
			case "Position":
				this.htmlContainer.css("position", "absolute");	
				
				this.setCssObjectProperty(repObj, key, "X");
				this.setCssObjectProperty(repObj, key, "Y");
				this.setCssObjectProperty(repObj, key, "Z");
				
				break;
			case "Rotation":
				if(repObj[key]["Direction"] != undefined 
						&& repObj[key]["Unit"] != undefined 
						&& repObj[key]["Value"] != undefined ){
					
					if(repObj[key]["Direction"] === "LEFT"){
						rotFactor = "-";
					}
					else{
						rotFactor = "";
					}
					
					rotCode = "rotate("+ rotFactor + repObj[key]["Value"] + 
							repObj[key]["Unit"] +")";
					
					// add an X-offset and Y-offset
					var tX = 0, tY = 0;
					var height = separateValueAndUnit(repObj['Size']['Height']);
					var width = separateValueAndUnit(repObj['Size']['Width']);
					
					tX = (width.Value/2 - height.Value/2) * -1;
					tY = (width.Value - height.Value)/2;
					
					if (repObj[key]['Direction'] === 'LEFT') {
						rotCode += ' translate(' + tY + 'px, ' + tX + 'px)';
					}
					else {
						rotCode += ' translate(' + tX + 'px, ' + tY + 'px)';
					}
					
					this.htmlContainer.css("-webkit-transform", rotCode);
					this.htmlContainer.css("-moz-transform", rotCode);
					this.htmlContainer.css("-ms-transform", rotCode);
				}
				break;
			case "Size":				
				this.setCssObjectProperty(repObj, key, "Width");
				this.setCssObjectProperty(repObj, key, "Height");
				
				sizeSet = true;
				
				break;
			case "Shadow":
				if(repObj[key]["Background"] != undefined){
					var boxShadowAttr = "5px 5px 5px " + 
							repObj[key]["Background"];
					
					this.htmlContainer.css("box-shadow", boxShadowAttr);
					this.htmlContainer.css("-moz-box-shadow", boxShadowAttr);
					this.htmlContainer.css("-webkit-box-shadow", boxShadowAttr);
				}
				
				if(repObj[key]["Foreground"] != undefined){
					var mapping = this.representationMapping;
					var textShadowAttr = repObj[key]["Foreground"] 
							+ " 3px 3px 3px";
					
					if(mapping[key]["Foreground"]["connectedToContainer"]){
						this.htmlContainer.css("text-shadow", textShadowAttr);
					}
					
					if(mapping[key]["Foreground"]["connectedToElement"]){
						this.htmlElement.css("text-shadow",	textShadowAttr);
					}
				}
			case "State":
				//set Visibility
				if(repObj[key]["Visible"] != undefined){
					if(repObj[key]["Visible"]){
						this.htmlContainer.css("visibility", "visible");
					}
					else{
						this.htmlContainer.css("visibility", "hidden");
					}
				}			
				
				//set Flash
				if(repObj[key]["Flash"] != undefined){
					//if a flash-animation is already set
					if(this.representation["State"]["Flash"] != undefined){
						this.stopFlashAndResetRepresentation();
					}
					// start flash for each defined flash object
					for (var i = 0, 
							l = repObj[key]["Flash"].length; i < l; i++) {
						//start Flash
						this.startFlash(repObj[key]["Flash"][i]);
					}
				}
				
				if(repObj[key]["Accessible"] != undefined){
					accessible = true;
				}
				if(repObj[key]["Valid"] != undefined){
					valid = true;
				}
				
				break;
			case "ToolTipText":
				var textName = repObj[key]["Text"];
				var text = multiLingualTextDefinition.getTextValue(textName);
				
				this.htmlElement.attr("title", text);
				this.htmlContainer.attr("title", text);
				break;
		}
	}
	
	//Override representation with new values from repObj
	$.extend(true, this.representation, repObj);
	
	/* Set accessibility and validity */
	if(sizeSet || accessible || valid){
		this.updateOverlays();
	}
};

/**
 * PROTECTED unset attributes like styling and ToolTipText for the HTML-Element
 * Attributes and CSS-Properties will be removed from HTML-element and set
 * undefined in this.representation
 * 
 * @param repObj
 * 			[Object] RepresentationRecord in JSON
 */
UIComponent.prototype.unsetRepresentationAttributes = function(repObj){
	//iterate over every entry in the Representation-object and convert the
	//contained movisa-data to CSS/HTML-data
	for(var key in repObj){
		switch(key){
			case "State":
				if(repObj[key]["Flash"] == '!delete'){
					//stop Flash
					this.stopFlashAndResetRepresentation();
					
					//and delete from representation
					this.representation["State"]["Flash"] = undefined;
				}
				break;
		}
	}
};

/**
 * PROTECTED set a CSS-Attribute to Container/Element according to the
 * representation-mapping and the CSS-equivalent to a movisa-property
 * 
 * @param repObj
 * 			[Object] RepresentationRecord in JSON
 * @param key
 * 			[String] current key in the repObj
 * @param movisaProperty
 * 			[String] of the movisa-property-name
 */
UIComponent.prototype.setCssObjectProperty = function(repObj, key, 
		movisaProperty){
	
	var mapping = this.representationMapping;
	var repValue = repObj[key][movisaProperty];
	var cssProperty;
	
	if(repValue != undefined){
		cssProperty = mapping[key][movisaProperty]["Equivalent"];
		
		//set the styling for the HTML-Element
		if(mapping[key][movisaProperty]["connectedToElement"]){
			this.htmlElement.css(cssProperty, repValue);
		}
		
		//set the styling for the HTML-Container
		if(mapping[key][movisaProperty]["connectedToContainer"]){
			this.htmlContainer.css(cssProperty, repValue);
		}
	}
};

/**
 * PROTECTED set Representation for Validity (using the blockUI-plugin of 
 * jQuery)
 */
UIComponent.prototype.setAccessibility = function(){
	var accessible = this.representation["State"]["Accessible"];
	var valid = this.representation["State"]["Valid"];
	
	if(accessible !== undefined){
		if(accessible === false){
			if (this.isAccessible) {
				this.htmlContainer.block(
						{
							message : null,
							overlayCSS : {
								opacity: 0.3
							}
						});
				this.isAccessible = false;
			}
		}
		else{
			if (valid === true) {
				this.htmlContainer.unblock();
				this.isValid = true;
			}
			else {
				this.isValid = false;
			}
			this.isAccessible = true;
		}
	}
};

/**
 * PROTECTED set Representation for Validity (using the blockUI-plugin of 
 * jQuery)
 */
UIComponent.prototype.setValidity = function(){
	var valid = this.representation["State"]["Valid"];
	var accessible = this.representation["State"]["Accessible"];
	
	if(valid !== undefined){
		if(valid === false){
			if (this.isValid) {
				this.htmlContainer.block(
						{
							message : "Invalid!", 
							overlayCSS : {
								opacity: 0.3
							},
							css : {
								border : "2px solid red",
								color : "red"
							}
						});
				this.isValid = false;
			}
		}
		else{
			if (accessible === true) {
				this.htmlContainer.unblock();
				this.isAccessible = true;
			}
			else {
				this.isAccessible = false;
			}
			this.isValid = true;
		}
	}
};

/**
 * PROTECTED reset the Representation for Accessibility and Validity to make
 * sure, the overlay-message is still centered, if the HTML-Container changed
 * its size
 */
UIComponent.prototype.updateOverlays = function(){
	var self = this;
	
	window.setTimeout(function(){
		self.setAccessibility();
		self.setValidity();
	},1);
};

/**
 * PROTECTED This is the default function for image-setting to UIComponents
 * Currently, it sets a background-image in the HTML-element for a 'FixedImage'
 * 
 * @param url
 * 			[String] URL to the image
 * @param resourceType
 * 			[String] 'FixedImage' or 'CameraImage'
 */
UIComponent.prototype.setImage = function(url,resourceType){
	if(resourceType == "FixedImage"){
		if(this.htmlElement.css('background-image') === url) {
			return;
		}
		this.htmlElement.css('background-image','url('+ url +')');
	}
	if(resourceType == "CameraImage"){
		//to implement
	}
	this.updateOverlays();
};

/**
 * PROTECTED This is the default function for image-unsetting to UIComponents
 */
UIComponent.prototype.unsetImage = function(){
	//to implement
};

/**
 * PROTECTED write a Text in the HTML-element. 
 * 
 * @param text
 * 			[String] text to write
 */
UIComponent.prototype.setText = function(text){
	this.htmlElement.text(text);
	this.currentText = text;
	this.updateOverlays();
};

/**
 * PROTECTED update all labeled text (e.g. as result of an 
 * LanguageChangedSignal)
 */
UIComponent.prototype.updateLabeledText = function(){
	//update ToolTipText
	var tooltip = this.representation["ToolTipText"];
	
	if(tooltip != undefined && !isEmpty(tooltip)){
		this.setRepresentationAttributes({"ToolTipText":tooltip});
	}
	
	//update text
	var text = this.currentText;
	var labeledText = this.currentLabeledText;
	var newText, oldText, label, regex;
	
	if(text != ""){
		for(var i = 0; i<labeledText.length; i++){
			label = labeledText[i]["Label"];
			oldText = labeledText[i]["Text"];
			newText = multiLingualTextDefinition.getTextValue(label);
			
			oldText = oldText.replace(/\./g,"\\.");
			oldText = oldText.replace(/\+/g,"\\+");
			oldText = oldText.replace(/\?/g,"\\?");
			oldText = oldText.replace(/\*/g,"\\*");
			oldText = oldText.replace(/\^/g,"\\^");
			oldText = oldText.replace(/\$/g,"\\$");
			oldText = oldText.replace(/\(/g,"\\(");
			oldText = oldText.replace(/\)/g,"\\)");
			oldText = oldText.replace(/\[/g,"\\[");
			oldText = oldText.replace(/\]/g,"\\]");
			oldText = oldText.replace(/\{/g,"\\{");
			oldText = oldText.replace(/\{/g,"\\}");
			oldText = oldText.replace(/\|/g,"\\|");
			//oldText = oldText.replace(/\\/g,"\\");
			
			regex = new RegExp(oldText, "g");
			
			text = text.replace(regex, newText);
			
			labeledText[i]["Text"] = newText;
		}
		
		this.setText(text);
	}
};

/**
 * PRIVATE set a text for by the name of a TextDefinition. 
 * 
 * @param textDefinitionName
 * 			[String] name of the TextDefinition
 */
UIComponent.prototype.setTextByDefinition = function(textDefinitionName){
	var text = multiLingualTextDefinition.getTextValue(textDefinitionName);
	
	this.setText(text);
	
	this.currentLabeledText = [{"Text":text, "Label": textDefinitionName}];
	
	this.currentText = text;
};

/**
 * PROTECTED write a Text in the HTML-element. If there is already some text, it
 * will be replaced, if $replace is true. Otherwise ($replace = false), the
 * $preText will be inserted before and $postText after the current current 
 * text-string
 * 
 *  @param value
 *  		[String] or [Number] to be shown
 *  @param replace
 *  		[boolean] true: current Text gets replaced
 *  @param preText
 *  		[String] will be inserted before the current text
 *  @param postText
 *  		[String] will be inserted after the current text
 */
UIComponent.prototype.showValue = function(value, replace, preText, postText){	
	if(replace){
		currentText = "";
	}
	else{
		currentText = this.htmlElement.text() +" ";
	}
	if(preText != ""){
		preText = preText + " ";
	}
	if(postText != ""){
		postText = " "+ postText;
	}
	this.setText(currentText + preText +" "+ value +" "+ postText);
};

/**
 * PROTECTED start the Representation Flash-animation
 * 
 *  @param flashObj
 *  		[Object] the Flash-object of the RepresentationRecord
 */
UIComponent.prototype.startFlash = function(flashObj){
	flashObj['ActualState'] = true;
	
	//set flash interval
	switch (flashObj['FlashRate']) {
		case "FAST":
			flashObj['FlashInterval'] = 300;
			break;
		case "MODERATE":
			flashObj['FlashInterval'] = 800;
			break;
		case "SLOW":
			flashObj['FlashInterval'] = 1400;
			break;
		default:
			return;
	}
	
	//set flash Representation Property
	switch (flashObj['FlashType']) {
		case 'BACKGROUND':
			flashObj['FlashRepresentationPropertyOn'] = { 
				"Color": { 
					"Background": flashObj['FlashColorOn']
					} 
			};
			flashObj['FlashRepresentationPropertyOff'] = { 
				"Color": { 
					"Background": flashObj['FlashColorOff'] 
					} 
			};
			flashObj['FlashResetColor'] = 
				this.representation["Color"]["Background"];
			break;
		case 'FOREGROUND':
			flashObj['FlashRepresentationPropertyOn'] = { 
				"Color": { 
					"Foreground": flashObj['FlashColorOn']
					} 
			};
			flashObj['FlashRepresentationPropertyOff'] = { 
				"Color": { 
					"Foreground": flashObj['FlashColorOff']  
					} 
			};
			flashObj['FlashResetColor'] = 
				this.representation["Color"]["Foreground"];
			break;
		case 'BORDER':
			flashObj['FlashRepresentationPropertyOn'] = { 
				"Border": { 
					"LineColor": flashObj['FlashColorOn']
					} 
			};
			flashObj['FlashRepresentationPropertyOff'] = { 
				"Border": { 
					"LineColor": flashObj['FlashColorOff']  
					} 
			};
			flashObj['FlashResetColor'] = 
				this.representation["Border"]["LineColor"];
			break;
		default:
			return;
	}
	
	//initialize currentFlashColor
	flashObj['currentFlashColor'] = flashObj['FlashColorOff'];
	
	// store object for further access
	if (this.representation['State']['Flash'] === undefined) {
		this.representation['State']['Flash'] = [];
	}
	this.representation['State']['Flash'].push(flashObj);

	// run flash
	this.doFlash(flashObj);
};

/**
 * PROTECTED stop the Representation Flash-animation and reset the animated
 * property (border-, background- or foreground-color)
 */
UIComponent.prototype.stopFlashAndResetRepresentation = function(){
	for (var i = 0, 
			l = this.representation["State"]["Flash"].length; i < l; i++){
		
		var flashObj = this.representation["State"]["Flash"][i];
		flashObj['ActualState'] = undefined;
		
		switch (flashObj["FlashType"]) {
			case 'BACKGROUND':
				this.setRepresentationAttributes({
					"Color":{
						"Background": flashObj['FlashResetColor'] 
					}
				});
				break;
			case 'FOREGROUND':
				this.setRepresentationAttributes({
					"Color":{
						"Foreground": flashObj['FlashResetColor'] 
					}
				});
				break;
			case 'BORDER':
				this.setRepresentationAttributes({
					"Border":{
						"LineColor": flashObj['FlashResetColor'] 
					}
				});
				break;
			default:
				return;
		}
	}
};

/**
 * PROTECTED realizes the flash-animation
 * 
 * @param flashObj
 * 			[Object] a single flash object.
 */
UIComponent.prototype.doFlash = function(flashObj){
	// In this case, someone has canceled the request.
	if (flashObj['ActualState'] === undefined) return;
	
	// If actual state is on (true), then shut of.
	if (flashObj['ActualState'] === true) {
		this.setRepresentationAttributes(
				flashObj['FlashRepresentationPropertyOff']);
	}
	// If actual state is off (false), then switch on.
	else if (flashObj['ActualState'] === false) {
		this.setRepresentationAttributes(
				flashObj['FlashRepresentationPropertyOn']);
	}
	// Set actual state.
	flashObj['ActualState'] = !flashObj['ActualState'];
	
	// and call this method again after a timer has elapsed.
	(function(_this) {
		flashObj['Timer'] = setTimeout(
			function() {
				_this.doFlash(flashObj);
			}, flashObj['FlashInterval']);
	})(this);
}

/**
 * PUBLIC intitialize the Interaction by saving the the InteractionEffects and
 * assigning them to event-handlers
 */
UIComponent.prototype.intitializeInteraction = function(){
	this.setInteractionEffects(this.interaction);	
	this.setEventHandlers(this.interaction);
};

/**
 * PUBLIC save the InteractionEffects to use them in event-handlers
 * 
 * @param intObj
 * 			[Object] movisa InteractionEffects modeled in JSON
 */
UIComponent.prototype.setInteractionEffects = function(intObj){
	for(var key in intObj){
		for (i=0, l=intObj[key].length; i<l; i++) {
			var effectName = intObj[key][i]["@Name"];
			switch(key){	
				case "SendSignalEffect":
					var signalType = new intObj[key][i]["sends"]();
					
					//create effect-function
					var effectFunction = this.sendSignalEffectFactory(signalType);
					
					//save effect-name:effect-function pair for calls
					this.setEffect(effectName, effectFunction);
					
					break;			
				case "WriteEnteredDataEffect":
					var dataItemName = intObj[key][i]["DataItem"];
					var valueContainingWidgetName = 
						intObj[key][i]["ValueContainingWidgetName"];
					
					//Subscribe to FormDataChangedSignal to be informed of the
					//latest form/selection values
					pmBus.subscribe(this,FormDataChangedSignal);
					
					//initialize entry for latest data
					this.latestWidgetValue[valueContainingWidgetName] = null;
					
					//create effect-function
					var effectFunction = this.writeEnteredDataFactory(dataItemName,
							valueContainingWidgetName);
					
					//save effect-name:effect-function pair for calls
					this.setEffect(effectName, effectFunction);
					
					break;
				case "WriteFixedBooleanDataEffect":
				case "WriteFixedIntegerDataEffect":
				case "WriteFixedRationalDataEffect":
				case "WriteFixedStringDataEffect":
					var dataItemName = intObj[key][i]["DataItem"];
					var value = intObj[key][i]["Value"];
					
					//create effect-function
					var effectFunction = this.writeFixedDataFactory(dataItemName,
							value);
					
					//save effect-name:effect-function pair for calls
					this.setEffect(effectName, effectFunction);
					
					break;
				case "ReadDataItemEffect":
					var dataItemName = intObj[key][i]["DataItem"];
					
					//create effect-function
					var effectFunction = this.readDataFactory(dataItemName);
					
					//save effect-name:effect-function pair for calls
					this.setEffect(effectName, effectFunction);
					
					break;
				case "StartSubscriptionEffect":
					var subscriptionName = intObj[key][i]["Subscription"];
					
					//create effect-function
					var effectFunction = 
						this.startSubscriptionEffectFactory(subscriptionName);
					
					//save effect-name:effect-function pair for calls
					this.setEffect(effectName, effectFunction);
					
					break;
				case "StopSubscriptionEffect":
					var subscriptionName = intObj[key][i]["Subscription"];
					
					//create effect-function
					var effectFunction = 
						this.stopSubscriptionEffectFactory(subscriptionName);
					
					//save effect-name:effect-function pair for calls
					this.setEffect(effectName, effectFunction);
					
					break;
				//PrintEffect
				case 'PrintEffect':
					var effectFunction = this.printEffectFactory();
					this.setEffect(effectName, effectFunction);
					break;
				//NavigationEffect
				case 'NavigationEffect':
					var effectFunction = this.navigationEffectFactory(effectName);
					this.setEffect(effectName, effectFunction);
					break;
			}
		}
	}
}

/**
 * PUBLIC assign event-handler to HTML-Element. To every event-handler function
 * the correct InteractionEffects get assigned.
 * 
 * @param intObj
 * 			[Object] movisa InteractionEffects modeled in JSON
 */
UIComponent.prototype.setEventHandlers = function(intObj){
	//for every entry in the interaction-object do...
	for(var key in intObj){
		if ($.inArray(key,
				['Click', 'DoubleClick', 'Touch', 'KeySequence']) < 0) continue;
		
		// navigate through each single trigger item
		for (var k=0; k<intObj[key].length; k++) {
			effectFunctionChain = new Array(); //contains the related 
			//JavaScript-functions for every movisa InteractionEffect
			
			//buffer the required effect Functions
			for(var i=0; i<intObj[key][k]["Effects"].length; i++){
				effectFunctionChain.push(
						this.interactionEffects[intObj[key][k]["Effects"][i]]
				);
			}
		
			switch(key){
				case "Click":
					//assign the concrete event-handler with jQuery to the HTML-
					//element
					(function(e, _this) {
						_this.htmlElement.click(function(){
							//call every Function in the effect-chain to execute 
							// every effect
							for(var i = 0; i<e.length; i++){ e[i].call(_this); }
						});
					})(effectFunctionChain, this);
					break;
				case "DoubleClick":
					//assign the concrete event-handler with jQuery to the HTML-
					//element
					(function (e, _this) {
						_this.htmlElement.dblclick(function(){
							//call every Function in the effect-chain to execute 
							//every effect
							for(var i = 0; i<e.length; i++){ e[i].call(_this); }
						});
					})(effectFunctionChain, this);
					break;
					//Touch
				case "Touch":
					//assign the concrete event-handler with jQuery to the HTML-
					//element
					(function (e, _this) {
						_this.htmlElement.mouseover(function(){
							//call every Function in the effect-chain to execute e
							// very effect
							for(var i = 0; i<e.length; i++){ e[i].call(_this); }
						});
					})(effectFunctionChain, this);
					break;
				case "KeySequence":
					//assign the concrete event-handler with jQuery to the HTML-
					//element
					// We need an anonymous wrapper function in order to create a
					// copy of effectFunctionChain. Otherwise, we get only a 
					// reference to this variable what causes strange behavior.
					(function(e, _this) {
						keyEffectMap.push({
							'Panel' : _this.htmlElement.parents('div.movisaPanel')[0].id,
							'Keys' : intObj[key][k]['Keys'],
							'Effects' : function(event){
								//call every Function in the effect-chain to 
								//execute every effect
								for(var i = 0; i<e.length; i++){ e[i].call(_this); }
							}
						});
					})(effectFunctionChain, this);
					break;
			}
		}
	}
}

/**
 * PUBLIC add an InteractionEffect to use it in event-handlers
 * 
 * @param effectName
 * 			[String] name of the Effect
 * @param effectFunction
 * 			[Function] that realizes the Effect-functionality
 */
UIComponent.prototype.setEffect = function(effectName, effectFunction){
	this.interactionEffects[effectName] = effectFunction;
};

UIComponent.prototype.navigationEffectFactory = function(navigationEffect) {
	return function() {
		var signal = new NavigationSignal();
		signal.setEffect(navigationEffect);
		eventBus.fireEvent(signal, navigationManager);
	}
}

UIComponent.prototype.printEffectFactory = function() {
	return function() {
		window.print();
	}
}

/**
 * PROTECTED creates a parameterless Function for a SendSignalEffect that
 * uses the handed over parameters
 * 
 * @param signalType
 * 			[Signal] that shall be broadcasted
 */
UIComponent.prototype.sendSignalEffectFactory = function(signalType){
	return function(){	
		var signal = signalType;
		if (signal.prototype === 'undefined') {
			signal = new signalType();
		}
		//Send Signal broadcast
		eventBus.fireEvent(signal);
	}
};

/**
 * PROTECTED creates a parameterless Function for a StartSubscriptionEffect that
 * uses the handed over parameters
 * 
 * @param subscribtionName
 * 			[String] name of the subscription that shall be started
 */
UIComponent.prototype.startSubscriptionEffectFactory = function(subscriptionName){
	return function(){	
		var signal = new StartSubscriptionSignal();
		signal.setSubscriptionName(subscriptionName);
		//Send Signal broadcast
		eventBus.fireEvent(signal);
	}
};

/**
 * PROTECTED creates a parameterless Function for a StopSubscriptionEffect that
 * uses the handed over parameters
 * 
 * @param subscribtionName
 * 			[String] name of the subscription that shall be stopped
 */
UIComponent.prototype.stopSubscriptionEffectFactory = function(subscriptionName){
	return function(){	
		var signal = new StopSubscriptionSignal();
		signal.setSubscriptionName(subscriptionName);
		//Send Signal broadcast
		eventBus.fireEvent(signal);
	}
};

/**
 * PROTECTED creates a parameterless Function for a WriteEnteredDataEffect that
 * uses the handed over parameters
 * 
 * @param dataItemName
 * 			[String] name of the related DataItem
 * @param valueContainingWidgetName
 * 			[String] name of the UIComponent that contains the required data
 */
UIComponent.prototype.writeEnteredDataFactory = function(dataItemName, 
		valueContainingWidgetName){
	return function(){
		var signal = new WriteDataItemSignal();
		var value = this.latestWidgetValue[valueContainingWidgetName];
		//Set Signal-properties
		signal.setDataItemName(dataItemName);
		signal.setDataItemValue(value);
		//Send Signal to ProcessController
		eventBus.fireEvent(signal,processController);
	}
};

/**
 * PROTECTED creates a parameterless Function for a WriteFixedDataEffect that
 * uses the handed over parameters
 * 
 * @param dataItemName
 * 			[String] name of the related DataItem
 * @param value
 * 			[String] or [Number] value that shall be written
 */
UIComponent.prototype.writeFixedDataFactory = function(dataItemName, value){
	return function(){
		var signal = new WriteDataItemSignal();
		//Set Signal-properties
		signal.setDataItemName(dataItemName);
		signal.setDataItemValue(value);
		//Send Signal to ProcessController
		eventBus.fireEvent(signal,processController);
	};
};

/**
 * PROTECTED creates a parameterless Function for a ReadDataEffect that
 * uses the handed over parameters
 * 
 * @param dataItemName
 * 			[String] name of the related DataItem
 */
UIComponent.prototype.readDataFactory = function(dataItemName){
	return function(){
		var signal = new ReadDataItemSignal();
		//Set Signal-properties
		signal.setDataItemName(dataItemName);
		//Send Signal to ProcessController
		eventBus.fireEvent(signal,processController);
	};
};

/**
 * PROTECTED initialize all animations by subscribing to their particular signal
 */
UIComponent.prototype.initializeAnimation = function(){
	var animObj = this.animation;
	for(var anim in animObj){
		if (!animObj.hasOwnProperty(anim)) continue;
		for (i=0; i<animObj[anim].length; i++) {
			eventBus.subscribe(this, animObj[anim][i]['TriggeringSignal']);
		}
	}
};

/**
 * PROTECTED create the function for a Comparator according to the handed over
 * parameters
 * 
 * @param comparator
 * 			[Object] the comparator object
 * @returns [Function] that realizes the desired comparison
 */
UIComponent.prototype.comparatorFactory = function(comparator){
	var referenceValue = comparator['ReferenceValue'];
	switch(comparator['CompareType']){
		case "EQUAL":
			return function(value){
				return value == referenceValue;
			};
			break;
		case "GREATER_THAN":
			return function(value){
				return value > referenceValue;
			};
			break;
		case "GREATER_THAN_EQUAL":
			return function(value){
				return value >= referenceValue;
			};
			break;
		case "LESS_THAN":
			return function(value){
				return value < referenceValue;
			};
			break;
		case "LESS_THAN_EQUAL":
			return function(value){
				return value <= referenceValue;
			};
			break;
		case "NOT_EQUAL":
			return function(value){
				return value != referenceValue;
			};
			break;
	}
};

/**
 * PROTECTED create the function for a RangeComparator (e.g. 1 <= value < 5) 
 * according to the handed over parameters. The RangeComparator retrieves the
 * comparison-resluts of both SimpleComparators and calls a EvalFunction of a
 * SimpleComparator according to the comparison-results
 * 
 * @param leftTerm
 * 			[Object]
 * @param rightTerm
 * 			[Object]
 * @throws [Error] leftTerm and rightTerm are both false
 */
UIComponent.prototype.rangeComparatorFactory = function(leftTerm, rightTerm){
	return function(value){
		var leftComp = leftTerm['c'];
		var rightComp = rightTerm['c'];
		
		//get the comparison-result of the SimpleComparators with $value
		var leftEval = leftComp.call(this, value);
		var rightEval = rightComp.call(this, value);
		
		// Check if the actual evaluation is equal to the previous one
		if (this.comparators[leftTerm['@']] === leftEval && 
				this.comparators[rightTerm['@']] === rightEval) {
			return;
		}	
		this.comparators[leftTerm['@']] = leftEval;
		this.comparators[rightTerm['@']] = rightEval;
		
		// Call the TrueEvaluation only if the value is really within
		// the given range.
		if (leftEval && rightEval) {
			leftTerm['t'].call(this);
			rightTerm['t'].call(this);
		}
		// maybe there is an opportunity to call one or two of the 
		// FalseEvaluation
		else {
			if (leftTerm === false) {
				leftTerm['f'].call(this);
			}
			if (rightTerm === false) {
				rightTerm['f'].call(this);
			}
		}
	};
};

/**
 * PROTECTED creates a Function that realizes the RepresentationAnimation by
 * setting the Representation Attributes according to the related
 * PropertyToAnimate
 * 
 * @param propertyToAnimateName
 * 			[String] name of the PropertyToAnimate
 * @returns [Function] that realizes the desired RepresentationAnimation
 */
UIComponent.prototype.representationAnimationFactory = function(propertyToAnimateName, record){
	if(propertyToAnimateName !== undefined){
		return function(){
				// clone representation
				var repObj = $.extend(true, {}, this.representation);
				var ar = record[propertyToAnimateName];
				for (var key in ar) {
					if (!ar.hasOwnProperty(key)) continue;
					repObj[key] = ar[key];
				}
				this.setRepresentationAttributes(repObj);
			};
	}
	else {
		return undefined;
	}
};

/**
 * PROTECTED creates a Function that realizes the TextAnimation by
 * calling the setTextByDefinition-Fucntion
 * 
 * @param propertyToAnimateName
 * 			[String] name of the PropertyToAnimate
 * @returns [Function] that realizes the desired RepresentationAnimation
 */
UIComponent.prototype.textAnimationFactory = function(textToAnimateName){
	if(textToAnimateName !== undefined){
		return function(){			
				this.setTextByDefinition(textToAnimateName);
			};
	}
	else {
		return undefined;
	}
};

/**
 * PROTECTED creates a Function that realizes the ImageAnimation by
 * calling the setImage-Fucntion
 * 
 * @param imageToAnimateName
 * 			[String] name of the image-resource
 * @returns [Function] that realizes the desired ImageAnimation
 */
UIComponent.prototype.imageAnimationFactory = function(imageToAnimateName){
	if(imageToAnimateName !== undefined){
		return function(){				
				this.setImage(imageToAnimateName);
			};
	}
	else {
		return undefined;
	}
};

/**
 * PROTECTED animate the UIComponent depending on the signal and the value
 * 
 * @param signalName
 * 			[String] name of the signal
 * @param value
 * 			[String] or [Number] used for the animation
 */
UIComponent.prototype.animate = function(type, record, value){
	switch(type) {
		case 'ContinuousAnimationRecord':
			this.performContinuousAnimation(record, value);
			break;
		case 'ImageAnimationRecord':
			this.performImageAnimation(record, value);
			break;
		case 'IndicatorAnimationRecord':
			this.performIndicatorAnimation(record, value);
			break;
		case 'RepresentationAnimationRecord':
			this.performRepresentationAnimation(record, value);
			break;
		case 'TextAnimationRecord':
			this.performTextAnimation(record, value);
			break;
		case 'ValueOutputAnimationRecord':
			this.performValueOutputAnimation(record, value);
			break;
	}
};

/**
 * PROTECTED perform a ContinuousAnimation
 */
UIComponent.prototype.performContinuousAnimation = function(record, value){
	// can only proceed if we actually have a number available. 
	if (isNaN(value)) return;

	// cannot handle floating values 
	value = Math.round(value);
	// determine the property
	var ar = record['PropertyToAnimate'].split('->');
	// clone representation
	var repObj = $.extend(true, {}, this.representation);
	// fetch old height:
	var oldProp = separateValueAndUnit(repObj[ar[0]][ar[1]]); 
	// assign the new value (with appended unit)
	repObj[ar[0]][ar[1]] = value + oldProp.Unit;
	
	// if we animate the height property, we have also to change the top prop
	if (record['PropertyToAnimate'] === 'Size->Height') {
		var y = separateValueAndUnit(repObj['Position']['Y']); 
		var bottom = y.Value + oldProp.Value;
		var newY = bottom - value;
		repObj['Position']['Y'] = newY + y.Unit; 
	}
	// and set the new representation
	this.setRepresentationAttributes(repObj);
};

UIComponent.prototype.performImageAnimation = function(record, value) {
	// try to decorate the animation record with the specialized function that
	// will be invoked 
	(function(_this) {
		record['func'] = function(imageToAnimate) {
			return _this.imageAnimationFactory(imageToAnimate);
		}
	})(this);
	// And now, run the general descrete animation
	this.performDiscreteAnimation(record, value);
}

UIComponent.prototype.performIndicatorAnimation = function(record, value) {
	// to be overridden by dedicated indicator containing widget
}

UIComponent.prototype.performRepresentationAnimation = function(record, value) {
	// try to decorate the animation record with the specialized function that
	// will be invoked 
	(function(_this, _record) {
		record['func'] = function(propertyToAnimateName) {
			return _this.representationAnimationFactory(
						propertyToAnimateName, _record['PropertyToAnimate']);
		}
	})(this, record);
	// And now, run the general descrete animation
	this.performDiscreteAnimation(record, value);
}

UIComponent.prototype.performTextAnimation = function(record, value) {
	// try to decorate the animation record with the specialized function that
	// will be invoked 
	(function(_this) {
		record['func'] = function(textToAnimate) {
			return _this.textAnimationFactory(textToAnimate);
		}
	})(this);
	// And now, run the general descrete animation
	this.performDiscreteAnimation(record, value);
}

UIComponent.prototype.performValueOutputAnimation = function (record, value) {
	//perform ValueOutputAnimation if related to this TriggeringSignal
	var replace = record["ReplaceValue"];
	var preTextName = record["PreText"];
	var postTextName = record["PostText"];
	var preText = "";
	var postText = "";
	
	if(replace == true){
		this.currentLabeledText = [];
	}
	if(preTextName !== undefined){
		preText = multiLingualTextDefinition.getTextValue(preTextName);
		this.currentLabeledText.push({"Text":preText, "Label": preTextName});
	}
	if(postTextName !== undefined){
		postText = multiLingualTextDefinition.getTextValue(postTextName);
		this.currentLabeledText.push({"Text":postText, "Label": postTextName});
	}
	this.showValue(value, replace, preText, postText);
};

/**
 * Perform Discrete Animations
 * 
 * @param record
 * 			[Object] that carries the animation record
 * @param value
 * 			[Number] that represents the value to be value to be animated.
 */
UIComponent.prototype.performDiscreteAnimation = function(record, value){
	// get the comparators in a dedicated object
	var comparators = new Object();
	for (var i=0, l=record['Comparator'].length; i<l; i++) {
		comparators[record['Comparator'][i]['@Name']] = record['Comparator'][i];
	}
	// get the range comparators
	var rangeComparators = record['RangeComparator'];
	
	// if there are range comaparators, we do ignore the single comparators.
	if (rangeComparators !== undefined && rangeComparators.length > 0) {
		// Treat each range comparator and fetch all necessary information
		for (var i=0, k=rangeComparators.length; i<k; i++) {
			var l = comparators[rangeComparators[i]['LeftTerm']];
			var r = comparators[rangeComparators[i]['RightTerm']];
			
			var leftTerm = {
				'@' : l['@Name'],
				'c' : this.comparatorFactory(l),
				// the decorated functions are following; at this place we do 
				// not care about what kind of function this is. 
				't' : record.func(l['TrueEvaluation']),
				'f' : record.func(l['FalseEvaluation'])
			};
			
			var rightTerm = {
				'@' : r['@Name'],
				'c' : this.comparatorFactory(r),
				// the decorated functions are following; at this place we do 
				// not care about what kind of function this is. 
				't' : record.func(r['TrueEvaluation']),
				'f' : record.func(r['FalseEvaluation'])
			};
			// invoke the range comparator with both the right and the left
			// term as well as with the value.
			try {
				this.rangeComparatorFactory(leftTerm, rightTerm).call(this, value);
			} catch(e) {}
		}
	}
	else {
		// we got single comparators
		for (var i in comparators) {
			if (!comparators.hasOwnProperty(i)) continue;
			// fetch the comparator function.
			var e = this.comparatorFactory(comparators[i]).call(this, value);
			
			// Check if the actual evaluation is equal to the previous one. 
			if (this.comparators[comparators[i]['@Name']] == e) {
				continue;
			}
			else {
				this.comparators[comparators[i]['@Name']] = e;
			}

			// perform it according to its return value.
			if (e) {
				try {
					record.func(comparators[i]['TrueEvaluation']).call(this);
				} catch(ex) {}
			}
			else {
				try {
					record.func(comparators[i]['FalseEvaluation']).call(this);
				} catch(ex) {}
			}
		}
	}
};
