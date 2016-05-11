/* protected region PreserveMisc_FunctionButton_FunctionButtonClickedBoundary on begin */
// Put here globally required code for Misc_FunctionButton_FunctionButtonClickedBoundary
if (typeof String.prototype.endsWith !== 'function') {
    String.prototype.endsWith = function(suffix) {
        return this.indexOf(suffix, this.length - suffix.length) !== -1;
    };
}

var FunctionButtonReturnVisualizer = function() {
	this.$popup = null;
	this.lastValues = {};
	this.hidden = true;
	
	// get all 'return' data items
	var returnDataItems = processController.processModel.dataItemList.filter(function(e) {
		return e.id.endsWith("_return_LP");
	});
	
	// subscribe to the 'signal on change' of the 'return' data items
	for (i in returnDataItems) {
		var returnDataItem = returnDataItems[i];
		
		if(returnDataItem.SignalsOnChange.length > 0) {
			eventBus.subscribe(this, returnDataItem.SignalsOnChange[0]);
		}
	}
}
extend(FunctionButtonReturnVisualizer, EventSubscriber);

FunctionButtonReturnVisualizer.prototype.handleEvent = function(event) {
	
	var notifyingDataItem = event.getActualNotifyingDataItem();
	
	if(typeof this.lastValues[notifyingDataItem.Name] === "undefined"){
		// this only happens during the initialization phase when a 'signal on change'
		// for each data item is triggered once
		this.lastValues[notifyingDataItem.Name] = notifyingDataItem.Value;
		return;
	}

	this.show(
		notifyingDataItem.Name.replace(/.*Functions_/,"").replace("_return_LP",""), 
		event.getActualNotifyingDataItem().Value
	);
}

FunctionButtonReturnVisualizer.prototype.hide = function (event) {
	this.hidden = true;
	
	this.$popup.hide();
	
	if (event) {
		event.preventDefault();
		event.stopPropagation();
	}
	return true;		
	//this.$popup.remove();
	//this.$popup = null;		
};

FunctionButtonReturnVisualizer.prototype.show = function(functionName, returnCode) {
	this.hidden = false;
	
	if(!this.$popup) {
		this.$popup = 
			$('<div class="functionButtonReturnPopup">' +
					'<div class="functionNameDisplay"><span class="labeltext">Function: </span><span class="labelValue"></span></div>' + 
					'<div class="returnCodeDisplay"><span class="labeltext">Return Code: </span><span class="labelValue"></span></div>' +
			'</div>');
		this.$popup.dialog({
			autoOpen : true,
			modal : false,
			//appendTo : this.$panel,
			//position: { my: "left top", at: "right top", of: this.$matflow },
			resizable : true,
			draggable : true,
			title : "Function Returned",
			beforeClose : this.hide.bind(this),
			minHeight : 20,
			minWidth : 50,
			width : 200,
			height : 100
		});	
		this.$popup = this.$popup.parents(".ui-dialog");
		this.$popup.find(".ui-dialog-titlebar")
				.add(this.$popup.find(".ui-dialog-content"));
		this.$popup.find(".ui-dialog-title").css({"padding-left":"15px"});
	}
	
	this.$popup.find(".functionNameDisplay").find(".labelValue").html(functionName);
	this.$popup.find(".returnCodeDisplay").find(".labelValue").html(returnCode);
	this.$popup.show();
}

/* protected region PreserveMisc_FunctionButton_FunctionButtonClickedBoundary end */

// Boundary: Misc_FunctionButton_FunctionButtonClickedBoundary
function Misc_FunctionButton_FunctionButtonClickedBoundary() {
	// Register Boundary to required signals.
	
	// Start initialize the code of the provided interface
	this.runProvidedInterface();
	
    /* protected region PreserveMisc_FunctionButton_FunctionButtonClickedBoundary_Init on begin */
	// Put here initialisation code for Misc_FunctionButton_FunctionButtonClickedBoundary
	var that = this;
	this.functionButtonReturnVisualizer = new FunctionButtonReturnVisualizer();
	
    /* protected region PreserveMisc_FunctionButton_FunctionButtonClickedBoundary_Init end */
}
extend(Misc_FunctionButton_FunctionButtonClickedBoundary, EventSubscriber);

// Entry function for EventSubscriber
Misc_FunctionButton_FunctionButtonClickedBoundary.prototype.handleEvent = function (event) {
    /* protected region PreservePreSignalHandling on begin */
	// Put here required code before signal handling
			
    /* protected region PreservePreSignalHandling end */
	
    /* protected region PreservePostSignalHandling on begin */
	// Put here required code after signal handling
			
    /* protected region PreservePostSignalHandling end */
};

Misc_FunctionButton_FunctionButtonClickedBoundary.prototype.runProvidedInterface = function () {
	// Boundary Provided Interface
	
};

