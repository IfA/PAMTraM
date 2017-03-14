function State() {
	// A state
}

State.prototype.entry = function() {
	console.log("Entered State...");
}

function Signal() {
	// A signal
}

function StartSubscriptionSignal(){
	var subscriptionName = null;
	this.getSubscriptionName = function(){return this.subscriptionName;}
	this.setSubscriptionName = function(name){this.subscriptionName = name;}
}
extend(StartSubscriptionSignal,Signal);

function StopSubscriptionSignal(){
	var subscriptionName = null;
	this.getSubscriptionName = function(){return this.subscriptionName;}
	this.setSubscriptionName = function(name){this.subscriptionName = name;}
}
extend(StopSubscriptionSignal,Signal);

function ReadDataItemSignal(){
	var dataItemName = null;
	this.getDataItemName = function(){return this.dataItemName;}
	this.setDataItemName = function(name){this.dataItemName = name;}
}
extend(ReadDataItemSignal,Signal);

function WriteDataItemSignal(){
	var dataItemName = null;
	this.getDataItemName = function(){return this.dataItemName;}
	this.setDataItemName = function(name){this.dataItemName = name;}
	var dataItemValue = null;
	this.getDataItemValue = function(){return this.dataItemValue;}
	this.setDataItemValue = function(value){this.dataItemValue = value;}
}
extend(WriteDataItemSignal,Signal);


function AlgorithmModelEvent(target, signal) {
	// sends signal to target
	this.target = target;
	this.signal = signal; 
};

extend(AlgorithmModelEvent, Event);

// Include all other files.
$.chainclude(
	[
		'ac/Navigation.js',
'ac/Dialog_1_eBO_5_Confirm_Changed_Class.js',
'ac/Dialog_1_eBO_6_Confirm_Changed_Class.js',
'ac/Dialog_1_eBO_2_Select_Option_0_Changed_Class.js',
'ac/Dialog_1_eBO_2_Select_Option_1_Changed_Class.js',
'ac/Dialog_1_eBO_2_Select_Option_2_Changed_Class.js',
'ac/Dialog_1_eBO_4_Select_Option_0_Changed_Class.js',
'ac/Dialog_1_eBO_4_Select_Option_1_Changed_Class.js',
'ac/Dialog_1_eBO_4_Select_Option_2_Changed_Class.js',
'ac/Dialog_2_eBO_2_Input_Changed_Class.js',
'ac/Dialog_2_eBO_4_Input_Changed_Class.js',
'ac/Dialog_2_eBO_6_Input_Changed_Class.js',
'static-resources/am/DataType.js',
'as/Signals.js'
	],
	function() {
		amReady = true;
		go();
	}
);

function initAM() {
//Enumerated Types
//Structured Types
window.setTimeout(function(){new Navigation();}, 1);

window.setTimeout(function(){new Dialog_1_eBO_5_Confirm_Changed_Class();}, 1);

window.setTimeout(function(){new Dialog_1_eBO_6_Confirm_Changed_Class();}, 1);

window.setTimeout(function(){new Dialog_1_eBO_2_Select_Option_0_Changed_Class();}, 1);

window.setTimeout(function(){new Dialog_1_eBO_2_Select_Option_1_Changed_Class();}, 1);

window.setTimeout(function(){new Dialog_1_eBO_2_Select_Option_2_Changed_Class();}, 1);

window.setTimeout(function(){new Dialog_1_eBO_4_Select_Option_0_Changed_Class();}, 1);

window.setTimeout(function(){new Dialog_1_eBO_4_Select_Option_1_Changed_Class();}, 1);

window.setTimeout(function(){new Dialog_1_eBO_4_Select_Option_2_Changed_Class();}, 1);

window.setTimeout(function(){new Dialog_2_eBO_2_Input_Changed_Class();}, 1);

window.setTimeout(function(){new Dialog_2_eBO_4_Input_Changed_Class();}, 1);

window.setTimeout(function(){new Dialog_2_eBO_6_Input_Changed_Class();}, 1);

}
