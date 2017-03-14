function AlarmControl(properties, representation, interaction, animation){
	/*general properties*/
	this.name = 					properties["Name"];
	this.htmlElement = 				$("#"+ this.name);	
	this.htmlContainer = 			$("#"+ this.name +"-container");
	this.containedUIComponents = 	$.extend(true, {}, AlarmControl.__super__.containedUIComponents);
	this.parentUIComponent = 		$.extend(true, {}, AlarmControl.__super__.parentUIComponent);
	
	/*Representation-properties*/
	//Note: use of jQuery.extend() to get a real clone of the superclass'
	//properties, not just a reference
	this.representation = 			$.extend(true, {}, AlarmControl.__super__.representation);
	this.representationMapping = 	$.extend(true, {}, AlarmControl.__super__.representationMapping);	
	this.currentFlashColor =		$.extend(true, {}, AlarmControl.__super__.currentFlashColor);
	this.flashIntervalReference = 	$.extend(true, {}, AlarmControl.__super__.flashIntervalReference);
	this.flashResetColor = 			$.extend(true, {}, AlarmControl.__super__.flashResetColor);

	/*Interaction-properties*/
	this.interaction = 			interaction;
	this.interactionEffects = 	$.extend(true, {}, AlarmControl.__super__.interactionEffects);
	this.latestWidgetValue = 	$.extend(true, {}, AlarmControl.__super__.latestWidgetValue);
	
	/*Animation-properties*/
	this.animation = 				animation;
	this.animationTriggerSignals = 	$.extend(true, {}, AlarmControl.__super__.animationTriggerSignals);
	this.propertyToAnimCont = 		$.extend(true, {}, AlarmControl.__super__.propertyToAnimCont);
	this.propertiesToAnimDiscr = 	$.extend(true, {}, AlarmControl.__super__.propertiesToAnimDiscr);
	this.comparators = 				$.extend(true, {}, Image.__super__.comparators);
	this.rangeComparators = 		$.extend(true, {}, AlarmControl.__super__.rangeComparators);
	this.simpleComparators = 		$.extend(true, {}, AlarmControl.__super__.simpleComparators);
	
	// Create the Alarm Table by adding the DataTable element to the HTML 
	// element. The HTML element is a div with a nested table what forms the
	// skeleton for the final table. 
	this.alarmTable = $(this.htmlElement).find("table").dataTable(
			{
				// configure the table columns
				"aoColumns" : 
					[
					 	null,	// Time 
				        null,	// Alarm name
				        null,	// Alarm type 
				        null,	// Alarm value
				        null, 	// Alarm active state
				        {"bVisible" : false, "bSearchable" : false}] // Alarm state Id (hidden column)
			});
	
	// Add selection handler to the AlarmControls Row. This is, however, 
	// realized by adding a click handler to each row. On a click event, this
	// function changes the style of the entire row. Therewith, one can also 
	// determine whether it has been selected...
	(function(_this) {
		$("#" + _this.name + " tbody").click(function(event) {
			$(_this.alarmTable.fnSettings().aoData).each(function (){
				$(this.nTr).removeClass('row_selected');
			});
			$(event.target.parentNode).addClass('row_selected');
		});
	})(this);
	
	// Add click handler to the ACK button.
	(function(_this) {
		$("#movisa__" + _this.name + "_Btn_Ack").click(function() {
			_this.ackSelected();
		});
	})(this);

	/*initialize the UIComponent*/
	this.initializeRepresentation(representation);
	AlarmControl.__super__.intitializeInteraction.apply(this);
	AlarmControl.__super__.initializeAnimation.apply(this);
	eventBus.subscribe(this, LanguageChangedSignal);
	eventBus.subscribe(this, AlarmStateChangedSignal)
}
extend(AlarmControl, UIComponent);
/* -------------------------------------------------------------------------- */

/**
 * Initialize the representation.
 */
AlarmControl.prototype.initializeRepresentation = function(repObj){
	var acSpec = repObj["Alarm Control Specifics"];

	//use the UIComponent.js function to set Representation-attributes
	AlarmControl.__super__.setRepresentationAttributes.apply(this, [repObj]);
}
/* -------------------------------------------------------------------------- */


/**
 * Callback function of Btn Ack click handler.
 */
AlarmControl.prototype.ackSelected = function() {
	var aTrs = this.alarmTable.fnGetNodes();
	for (var i=0, l=aTrs.length; i<l ; i++) {
		if ($(aTrs[i]).hasClass('row_selected')) {
			var dataSet = this.alarmTable.fnGetData(aTrs[i]);
			var signal = new AlarmAcknowledgeSignal();
			signal.setAlarmName(dataSet[1]);
			signal.setAlarmStateId(dataSet[5]);
			eventBus.fireEvent(signal, null);
		}
	}
}
/* -------------------------------------------------------------------------- */

/**
 * Adds an alarm to the table
 */
AlarmControl.prototype.addAlarm = function(stateItem) {
	this.alarmTable.fnAddData(
			[this.formatDate(stateItem.AlarmState.Timestamp), 
			 stateItem.Name, 
			 stateItem.AlarmState.Type, 
			 stateItem.AlarmState.Value,
			 stateItem.AlarmState.Active,
			 stateItem.AlarmState.Id]);
}
/* -------------------------------------------------------------------------- */

/**
 * Just in order to format the date.
 */
AlarmControl.prototype.formatDate = function(t) {
	return t.getDate() + "/" + t.getMonth() + "/" + (t.getYear() + 1900) + " " + 
			t.getHours() + ":" + t.getMinutes() + ":" + t.getSeconds();
}
/* -------------------------------------------------------------------------- */

/**
 * Handler function of AlarmStateItems. If one arrives, then this function 
 * manages to show them or not to show them or hide others.
 */
AlarmControl.prototype.handleAlarmStateItem = function(stateItem) {
	var alarmName = stateItem.Name;
	var alarmState = stateItem.AlarmState;

	// check if there is an alarm row
	var nodes = this.alarmTable.fnGetNodes();
	
	if (nodes.length > 0) {
		for (var i=0, l=nodes.length; i<l; i++) {
			var dataSet = this.alarmTable.fnGetData(nodes[i]);
			if (dataSet[1] === alarmName) {
				if (dataSet[5] == alarmState.Id) {
					this.alarmTable.fnDeleteRow(nodes[i]);
					if (alarmState.Acknowledged === false) {
						this.addAlarm(stateItem);
					}
					return;
				}
			}
		}
	}
	this.addAlarm(stateItem);
}
/* -------------------------------------------------------------------------- */

/**
 * Event handler. Catches all signals by overriding the event handler function
 * of the parent class. Filters out the AlarmStateChangedSignal, does some stuff
 * with it and forwards all other signals to the super class' methods.  
 */
AlarmControl.prototype.handleEvent = function(signal) {
	if (signal instanceof AlarmStateChangedSignal) {
		this.handleAlarmStateItem(signal.getActualAlarmStateItem())
	}
	else {
		AlarmControl.__super__.handleEvent(signal);
	}
}
/* -------------------------------------------------------------------------- */