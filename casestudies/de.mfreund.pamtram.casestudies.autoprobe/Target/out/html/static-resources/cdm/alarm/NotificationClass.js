function NotificationClass() {
	this.widgetList = new Array();
}

/**
 * PUBLIC sends all SignalsOnChange to the EventBus with the specific value
 * 
 * @param value
 * 			[Object] the value that should be put in the NotificationSignal
 */
NotificationClass.prototype.fireEvents = function(signal){
	console.log("NotificationClass "+signal+" fireEvents");
	var dataItem = this;
	$.each(this.widgetList, function(index,item) { 
		eventBus.fireEvent(signal,item);
	});
};

NotificationClass.prototype.addWidget = function(widget){

	this.widgetList.push(widget);
};