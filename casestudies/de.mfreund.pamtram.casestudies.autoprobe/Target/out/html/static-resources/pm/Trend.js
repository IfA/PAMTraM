/**
 * 
 */
function Trend(properties, representation, interaction, animation){
	/*general properties*/
	this.name = 					properties["Name"];
	this.htmlElement = 				$("#"+ this.name);	
	this.htmlContainer = 			$("#"+ this.name +"-container");
	this.containedUIComponents = 	$.extend(true, {}, Trend.__super__.containedUIComponents);
	this.parentUIComponent = 		$.extend(true, {}, Trend.__super__.parentUIComponent);
	this.plot = undefined;

	/*Representation-properties*/
	//Note: use of jQuery.extend() to get a real clone of the superclass'
	//properties, not just a reference
	this.representation = 			$.extend(true, {}, Trend.__super__.representation);
	this.representationMapping = 	$.extend(true, {}, Trend.__super__.representationMapping);	
	this.currentText = 				"";
	this.currentLabeledText =		new Array();

	/*Interaction-properties*/
	this.interaction = 			interaction;
	this.interactionEffects = 	$.extend(true, {}, Trend.__super__.interactionEffects);
	
	/*Animation-properties*/
	this.animation = 				animation;
	this.animationTriggerSignals = 	$.extend(true, {}, Trend.__super__.animationTriggerSignals);
	this.dataSet = {};
	this.curData = {};
	this.timeRange = 0;

	/*initialize the UIComponent*/
	Trend.__super__.setRepresentationAttributes.apply(this,[representation]);
	Trend.__super__.intitializeInteraction.apply(this);

	this.initializePlot(representation['Trend Specifics']);
	this.initializeAnimation();
	
	eventBus.subscribe(this,LanguageChangedSignal);
}
extend(Trend, UIComponent);

Trend.prototype.initializePlot = function (trend) {
	// background color
	var bgColor = 'white';
	if (this.representation.Color) {
		bgColor = this.representation.Color.BackgroundColor;
	}
	// trend graph colors (the flot library only takes an array of color values,
	// I use the index for further reference.
	var colors = [];
	var initialData = [];
	
	for (var i=0; i<trend.TrendGraph.length; i++) {
		var label = trend.TrendGraph[i].Caption === undefined ? 
				trend.TrendGraph[i]['@Name'] : trend.TrendGraph[i].Caption; 
		colors[i] = trend.TrendGraph[i].Color;
		initialData[i] = {data:[], label: label}
	}
	
	// Y Axes (can be multiple)
	var yaxes = [];
	for (var i = 0; i < trend.YAxis.length; i++) {
		yaxes.push(this.configureYAxis(trend.YAxis[i]));
	}
	
	// general options
	var options = {
		series : {
			shadowSize : 0,
			lines: { 
				show: true ,
				lineWidth: 1
			}
		},
		crosshair: { mode: "x" },
		legend : {
			show : true
		},
		colors : colors,
		grid: {
			show: true,
		    color: 'grey',
		    backgroundColor: bgColor,
		    borderWidth: 1,
		    borderColor: null,
		    hoverable: true,
			autoHighlight: true,
			mouseActiveRadius: 5
		},
		xaxis : this.configureXAxis(trend.XAxis),
		yaxes : yaxes
	};
	// plot it without data
	this.plot = $.plot(this.htmlElement, initialData, options);
}

Trend.prototype.configureXAxis = function (axis) {
	var res = this.configureAxis(axis);
	res['position'] = (axis['Location'] === 'ABOVE')? 'top' : 'bottom';
	return res;
}
Trend.prototype.configureYAxis = function (axis) {
	var res = this.configureAxis(axis);
	res['position'] = (axis['Location'] === 'ABOVE')? 'right' : 'left';
	return res;
}
Trend.prototype.configureAxis = function (axis) {
	var ticks = [];
	for (var i = axis['ScaleStart']; i<axis['ScaleEnd']; i+=axis['ScaleStep']) {
		ticks.push([i, '']);
	}
	for (var i = axis['ScaleCaptionStart']; i<axis['ScaleCaptionEnd']; 
			i+=axis['ScaleCaptionStep']) {
		for (var k = 0, l = ticks.length; k<l; k++) {
			if (i === ticks[k][0]) {
				ticks[k][1] = i;
			}
		}
	}
	return {
		show : true,
		color : axis['Color'],
		tickColor : 'rgba(204,204,204,90)',
		min : axis['ScaleStart'],
		max : axis['ScaleEnd'],
		ticks : ticks
	};
}

Trend.prototype.initializeAnimation = function() {
	var start = this.representation['Trend Specifics']['XAxis']['ScaleStart'];
	var end = this.representation['Trend Specifics']['XAxis']['ScaleEnd'];
	this.timeRange = end - start;

	Trend.__super__.initializeAnimation.apply(this);
	
	// we need an equidistant sampling rate
	this.update();
}

// Note, I add each Trendgraph to the first YAxis; this has to be treatened in
// an future point in time.
Trend.prototype.update = function() {
	var trendgraphs = this.representation['Trend Specifics'].TrendGraph;
	var data = [];
	
	for (var i=0, l=trendgraphs.length; i<l; i++) {
		var _t = trendgraphs[i];
		var name = _t['@Name'];
		
		var tmp = this.dataSet[name] === undefined ? [] : this.dataSet[name];
		var end = (tmp.length < this.timeRange) ? tmp.length : this.timeRange;
		
		this.dataSet[name] = [[0, this.curData[name]]];

		for (var j=1;j<=end;j++) {
			this.dataSet[name].push([j, tmp[j-1][1]]);
		}
		
		data.push({data :this.dataSet[name]});
	}
	
	this.plot.setData(data);
	this.plot.draw();
	
	(function(_this) {
		setTimeout(function() {
			_this.update();
		}, 1000);
	})(this);
}

Trend.prototype.performIndicatorAnimation = function (record, value) {
	this.curData[record.Indicator] = value;
}