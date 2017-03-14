/**
 * A LocalServer manages local variables of a process control system.
 * There is only one LocalServer for each ProcessController (hence 
 * it is a singleton).
 */
function LocalServer() {
	this.id = "LocalServer";
	this.serverDataItemList = new Array();
	this.serverSubscriptionList;
}
extend(LocalServer, Server);

LocalServer.prototype.serverDataItemList;
LocalServer.prototype.serverSubscriptionList;

/**
 * PUBLIC read local variables
 * Since there is no "online" Server to read from, read get's
 * executed by reading the variables from the ProcessModel
 * 
 * @param readItemList
 * 			[Array] of [ReadItems] which shall be read
 */
LocalServer.prototype.read = function(readItemList) {
	var responseItemList = new Array();
	var responseItem;
	
	//create dummy ResponseItems to use the propagateServerResponse
	//function of the ProcessController
	for(var i = 0; i<readItemList.length; i++){
		responseItem = new ResponseItem("read", readItemList[i].dataItem.id, null);
		
		responseItemList.push(responseItem);
	}
	
	//call ProcessController to handle the access to the ProcessModel
	processController.propagateServerResponse(this, responseItemList);
};

/**
 * PUBLIC write on a local variable
 * Since there is no "online" Server to write on, write get's
 * executed by writing the variables on the ProcessModel
 * 
 * @param writeItemList
 * 			[Array] of [WriteItem]
 */
LocalServer.prototype.write = function(writeItemList) {
	var responseItemList = new Array();
	var responseItem;
	
	//create dummy ResponseItems to use the propagateServerResponse
	//function of the ProcessController
	for(var i = 0; i<writeItemList.length; i++){
		responseItem = new ResponseItem("write", writeItemList[i].dataItem.id, writeItemList[i].dataItemValue);
		
		responseItemList.push(responseItem);
	}
	
	//call ProcessController to handle the access to the ProcessModel
	processController.propagateServerResponse(this, responseItemList);
};

LocalServer.prototype.subscribe = function() {

};

LocalServer.prototype.getPolledRefresh = function(){
	
};

LocalServer.prototype.startPolledRefresh = function(){
	
};

