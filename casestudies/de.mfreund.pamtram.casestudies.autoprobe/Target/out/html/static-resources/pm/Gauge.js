/**
 * 
 */
function Gauge(properties, representation, interaction, animation){
	/*general properties*/
	this.name = 					properties["Name"];
	this.htmlElement = 				$("#"+ this.name);	
	this.htmlContainer = 			$("#"+ this.name +"-container");
	this.containedUIComponents = 	$.extend(true, {}, Gauge.__super__.containedUIComponents);
	this.parentUIComponent = 		$.extend(true, {}, Gauge.__super__.parentUIComponent);
	this.gauge = undefined;
	this.options = undefined;

	/*Representation-properties*/
	//Note: use of jQuery.extend() to get a real clone of the superclass'
	//properties, not just a reference
	this.representation = 			$.extend(true, {}, Gauge.__super__.representation);
	this.representationMapping = 	$.extend(true, {}, Gauge.__super__.representationMapping);	
	this.currentText = 				"";
	this.currentLabeledText =		new Array();

	/*Interaction-properties*/
	this.interaction = 			interaction;
	this.interactionEffects = 	$.extend(true, {}, Gauge.__super__.interactionEffects);
	
	/*Animation-properties*/
	this.animation = 				animation;
	this.animationTriggerSignals = 	$.extend(true, {}, Gauge.__super__.animationTriggerSignals);
	this.data = {};
	
    
	/*initialize the UIComponent*/
	Gauge.__super__.setRepresentationAttributes.apply(this,[representation]);
	Gauge.__super__.intitializeInteraction.apply(this);

	this.initializeComponent(representation['Gauge Specifics']);
	this.initializeAnimation();
	
	eventBus.subscribe(this,LanguageChangedSignal);
}
extend(Gauge, UIComponent);

Gauge.prototype.initializeComponent = function (gauge) {
    this.data = new google.visualization.DataTable();
    this.data.addColumn('string', 'Label');
    this.data.addColumn('number', 'Value');
    this.data.addRows(1);
    this.data.setValue(0, 0, multiLingualTextDefinition.getTextValue(gauge['Needle'][0]['Caption']));
    
    var width = this.representation.Size.Width;
    width = width.substring(0, width.indexOf('.'));
    var height = this.representation.Size.Height;
    height = height.substring(0, height.indexOf('.'));
    
    this.gauge = new google.visualization.Gauge(document.getElementById(this.name));
    this.options = {
    		width: width, 
    		height: height, 
    		minorTicks: gauge.Scale[0].ScaleStep,
    		majorTicks: gauge.Scale[0].ScaleCaptionStep,
    		min : gauge.Scale[0].ScaleStart,
    		max : gauge.Scale[0].ScaleEnd
    };
    this.gauge.draw(this.data, this.options);
}

Gauge.prototype.performIndicatorAnimation = function (record, value) {
	// Consider only data of the first indicator
	if (this.representation['Gauge Specifics'].Needle[0]['@Name'] === record.Indicator) {
		this.data.setValue(0, 1, Math.round(value));
		this.gauge.draw(this.data, this.options);
	}
}