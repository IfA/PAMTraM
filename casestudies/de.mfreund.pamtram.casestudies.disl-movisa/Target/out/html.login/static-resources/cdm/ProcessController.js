function ProcessController(){
	this.serverList = new Array();
	this.subscriptionList = new Array();
	this.processModel;
	
	this.serverList.push(new LocalServer());
	
	//Subscribe the ProcessController to the signals we want to recive
	eventBus.subscribe(this, StartSubscriptionSignal);
	eventBus.subscribe(this, StopSubscriptionSignal);
	eventBus.subscribe(this, ReadDataItemSignal);
	eventBus.subscribe(this, WriteDataItemSignal);
	
	/**
	 * PRIVATE groups a list of ServerDataItems by their allocation 
	 * to a server
	 * 
	 * @param itemList
	 * 			[Array] of item, which shall be grouped. Items must have
	 * 					a function getServerDataItem()!
	 * @returns [Array] of [Objects] obj
	 * 			[ServerItem] obj.server
	 * 			[Array] of [ServerDataItems] obj.itemList
	 * 
	 * 			The sever in obj.server contains the ServerItems in obj.itemList
	 */
	this.__groupItemsByServer = function(itemList){
		var groupedServerDataItems = new Array();
		var splitItems;
		
		//iterate of a servers and let them split the list the itemList
		//in ServerDataItems which the current server contains and which he
		//doesn't contain
		for(var i = 0; i < this.serverList.length; i++){
			//split the itemList list in contained and notContained
			splitItems = this.serverList[i].splitItemListByServerAllocation(itemList);
			
			//if the current server contains some of the ServerDataItems
			//save the pair of server and contained items in an object
			//and push it on an array
			if(splitItems["contained"].length != 0){
				groupedServerDataItems.push(
							{	"server": this.serverList[i], 
								"itemList": splitItems["contained"]
							}
						);
			}
			
			//save the not contained items in the itemList and continue
			//the iteration over another server
			if(splitItems["notContained"].length != 0){
				itemList = splitItems["notContained"];
			}
			
			//if the itemList is empty (no more items to group)
			//stop the iteration
			if(itemList.length == 0){
				break;
			}
		}
		
		return groupedServerDataItems;
	};
}
extend(ProcessController, EventSubscriber);


/**
 * PUBLIC handles events send to ProcessControler 
 * 
 * @param event
 * 			[Signal] which was send via broadcast or especially to ProcessController
 */
ProcessController.prototype.handleEvent = function(event){
	console.log("ProcessController Event '" + getTypeName(event) + "' received.");	
	
	if(getTypeName(event) == getTypeName(new StopSubscriptionSignal)){
		console.log("ProcessController StopEvent Subscription detected!");	
		this.cancelSubscription(event.getSubscriptionName());

	}
	
	if(getTypeName(event) == getTypeName(new StartSubscriptionSignal)){
		console.log("ProcessController StartEvent Subscription detected!");	
		this.subscribe(event.getSubscriptionName());		
	}
	
	if(getTypeName(event) == getTypeName(new ReadDataItemSignal)){
		console.log("ProcessController ReadDataItemSignal "+event.getDataItemName()+" detected!");	
		var dataItem = this.processModel.getDataItemById(event.getDataItemName());
		var readDataItem = new ReadItem(dataItem,dataItem.source);
		this.readFromServers(new Array(readDataItem));		
	}
	
	if(getTypeName(event) == getTypeName(new WriteDataItemSignal)){
		console.log("ProcessController WriteDataItemSignal "+event.getDataItemName()+" detected!");	
		var dataItem = this.processModel.getDataItemById(event.getDataItemName());
		var dataItemValue = new DataItemValue(event.getDataItemValue(),dataItem.source.itemType,new Date(),100);
		var writeItem = new WriteItem(dataItem,dataItem.source,dataItemValue);
		this.writeOnServers(new Array(writeItem));		
	}
};

/**
 * PUBLIC get a Server from the server list by its ID
 * 
 * @param serverId
 * 			[String]
 * @returns [Server] requested server if contained in server list
 * @returns null, if server is not contained
 */
ProcessController.prototype.getServerById = function(serverId){
	var serverList = this.serverList;
	
	for(var i = 0; i < serverList.length; i++){
		if(serverList[i].id == serverId){
			return serverList[i];
		}
	}
	
	return null;
};

/**
 * PUBLIC returns the Server which holds local variables
 * 
 * @returns [LocalServer]
 */
ProcessController.prototype.getLocalServer = function(){
	return this.getServerById("LocalServer");
};

/**
 * PUBLIC adds a servers to the process controller.
 * Does NOT check if the server is already added!
 * 
 * @param server
 * 			[ServerItems]
 */
ProcessController.prototype.addServer = function(server){
	this.serverList.push(server);
};

/**
 * PUBLIC adds a list of servers to the process controller.
 * Does NOT check if a server is already added!
 * 
 * @param serverList
 * 			[Array] of [ServerItems]
 */
ProcessController.prototype.addServerList = function(serverList){
	this.serverList.concat(this.serverList);
};

/**
 * PUBLIC set ProcessModel to the ProcessController during the
 * initialization of the PCS
 * 
 * @param processModel
 * 			[ProcessModel]
 */
ProcessController.prototype.setProcessModel = function(processModel){
	this.processModel = processModel;
};

/**
 * PUBLIC Add a subscription to the process controller a split MonitoredItems
 * by their server allocation. Each related Server gets a specific 
 * ServerSubscription
 * 
 * @param subscription
 * 			[Subscription]
 */
ProcessController.prototype.addSubscription = function(subscription){
	//group MonitoredItems by their server allocation
	var groupedMonitedItemList = this.__groupItemsByServer(subscription.monitoredItemList);
	
	//create a new ServerSubscription on every with the subscription related server
	for(var i = 0; i<groupedMonitedItemList.length; i++){
		
		//create the new ServerSubscription
		var sub = new ServerSubscription(subscription.id, groupedMonitedItemList[i]["server"], 
				groupedMonitedItemList[i]["itemList"], subscription.publishingInterval);
		
		//add the ServerSubscription to a server
		groupedMonitedItemList[i]["server"].addServerSubscription(sub );
		
		//save the related server as property of the Subscription
		subscription.addRelatedServer(groupedMonitedItemList[i]["server"]);
	}
	
	//save the Subscription in the process controller
	this.subscriptionList.push(subscription);
	
	//subscribe on the servers
	this.subscribe(subscription);
};

/**
 * PUBLIC Send a Subscription to its related servers
 * 
 * @param subscription
 * 			[Subscription] or [String] of the subscription ID
 */
ProcessController.prototype.subscribe = function(subscription){
	//get the subscription if the argument is the subscription ID as String
	if(typeof subscription == "string"){
		subscription = this.getSubscriptionById(subscription);
	}
	if (subscription != null)// && !subscription.active)
	{
		var serverList = subscription.relatedServerList;
		subscription.active = true;
		//call the related server to subscribe
		for(var i = 0; i<serverList.length; i++){
			serverList[i].subscribe(subscription.id);
		}
	}
};

/** DEPRECATED currently the polled refresh starts automatically after
 * a successful subscribe-operation, see OpcXmlDaServer.processSuccessfulResponse()
 * 
 * PUBLIC starts the polled refreshing of a subscription.
 * After calling this function, the process controller performs
 * polled refreshes until a subscription is canceled or an error
 * occurs
 * 
 * @param subscription
 * 			[Subscription]
 */
ProcessController.prototype.startPolledRefresh = function(subscription){
	//get the subscription if the argument is the subscription ID as String
	if(typeof subscription == "string"){
		subscription = this.getSubscriptionById(subscription);
	}
	
	if (subscription != null)
	{
		//set the subscription active
		subscription.active = true;
		
		var serverList = subscription.relatedServerList;
		
		//initiate the polled refresh on every related server
		for(var i = 0; i<serverList.length; i++){
			serverList[i].getPolledRefresh(subscription.id);
		}
	}
};

/**
 * PUBLIC reads process variables from servers
 * 
 * @param readItemList
 * 			[Array] of [ReadItems], which shall be read
 */
ProcessController.prototype.readFromServers = function(readItemList){
	//group the readItems by their server allocation
	var groupedServerDataItems = this.__groupItemsByServer(readItemList);
	
	var pair;
	
	//iterate over each pair of Server and readItemList and
	//perform read-operation on the server
	for(var i = 0; i < groupedServerDataItems.length; i++){
		pair = groupedServerDataItems[i];
		
		pair["server"].read(pair["itemList"]);
	}
};

/**
 * PUBLIC writes process variables on servers
 * 
 * @param writeItemList
 * 			[Array] of [WriteItem], which shall be written
 */
ProcessController.prototype.writeOnServers = function(writeItemList){
	//group the writeItems by their server allocation
	var groupedWriteItems = this.__groupItemsByServer(writeItemList);
	
	var pair;
	
	//iterate over each pair of Server and writeItemList and
	//perform write-operation on the server
	for(var i = 0; i < groupedWriteItems.length; i++){
		pair = groupedWriteItems[i];
		
		pair["server"].write(pair["itemList"]);
	}
};

ProcessController.prototype.onClientDataChange = function(dataItemList, dataItemValueList){
	var writeItemList = new Array();
	
	//create WriteItems out of the given parameters
	for(var i=0; i<dataItemList.length; i++){
		writeItemList.push(new WriteItem(dataItemList[i], dataItemList[i].source, 
				dataItemValueList[i]));		
	}
	
	this.writeOnServers(writeItemList);
};

/**
 * PUBLIC finds a Subscription in the process controller by its ID
 * 
 * @param subscribtionId
 * 			[String] ID of the subscription
 * @returns [Subscription]
 */
ProcessController.prototype.getSubscriptionById = function(subscribtionId){
	for(var i = 0; i< this.subscriptionList.length; i++){
		if(this.subscriptionList[i].id == subscribtionId){
			return this.subscriptionList[i];
		}
	}
	return null;
};

/**
 * PUBLIC handles whether a new polled refresh gets started or not
 * 
 * @param server
 * 			[Server] on which the subscription is all registered
 * @param subscriptionId
 * 			[String] ID of the related subscription
 * @param textStatus
 * 			[String] either "success" or "error", describes status of 
 * 					the last polled refresh
 */
ProcessController.prototype.handlePolledRefresh = function(server, subscriptionId, textStatus){
	//define the callback function
	var callback = function(){
		server.getPolledRefresh(subscriptionId);
	};

	if(textStatus == "success"){
		//a call via setTimeout makes it possible to shorten 
		//the function call chain
		setTimeout(callback,this.getSubscriptionById(subscriptionId).publishingInterval);
	}
	else{
		//handle error e.g. test server status, perform read-operation,...
	}
};

/**
 * PUBLIC stops all subscriptions
 * 
 * @param subscription
 * 			[Subscription]
 */
ProcessController.prototype.cancelAllSubscriptions = function(){
	//iterate over all subscriptions registered at the process controller
	//and cancel them
	for(var i = 0; i<this.subscriptionList.length; i++){
		this.cancelSubscription(this.subscriptionList[i]);
	}
};

/**
 * PUBLIC stops a subscription
 * 
 * @param subscription
 * 			[Subscription] or [String] with the subscription ID
 */
ProcessController.prototype.cancelSubscription = function(subscription){
	//get the subscription if the argument is the subscription ID as String
	if(typeof subscription == "string"){
		subscription = this.getSubscriptionById(subscription);
	}
	if(subscription != null)
	{
		//set the subscription inactive, so no more polled refreshes 
		//will be performed
		subscription.active = false;
		
		var serverList = subscription.relatedServerList;
		
		//cancel the ServerSubscriptions on every related server of the subscription
		for(var i = 0; i<serverList.length; i++){
			serverList[i].cancelSubscription(subscription.id);
		}
	}
};

/**
 * PUBLIC gets called by servers, which delivered new data; 
 * propagates data via events
 * 
 * @param server
 * 			[Server] from which the response comes
 * @param responsItemList
 * 			[Array] of [ResponseItems]
 */
ProcessController.prototype.propagateServerResponse = function(server, responseItemList){
	//neues ServerDataChanged Event erstellen
	//document.form1.bla.value = responsItemList;
	if(responseItemList == null){
		//error handling
		console.log("no items in responseItemList; no propagation possible");
	}else{
		var dataItemList = new Array();
		
		//if the response comes from a LocalServer which holds the local variables
		//special propagtion is needed
		if(server instanceof LocalServer){
			if(responseItemList[0].type == "write"){
				dataItemList = this.processModel.setDataItemValuesByIds(responseItemList);
			}
			else{
				var idList = new Array();
				
				for(var i=0; i<responseItemList; i++){
					idList.push(responseItemList[i].dataItemId);
				}
				
				dataItemList = this.processModel.getDataItemListByIds(idList);
			}
		}
		//in every other case (Server is a online/non-local server)
		//save the server response to the ProcessModel and fetch the dataItems
		//for the event propagation
		else{
			dataItemList = this.processModel.setDataItemValuesByIds(responseItemList);
		}
		//Send Change signals for every DataItem
		$.each(dataItemList, function(index,value) { 
			console.log("publishing on eventbus");
			value.fireEvents(value.getCurrentValue().value);
		});
	}
	
};

/**
 * PUBLIC gets called by servers, if an error occurred;
 * propagates error via events
 * 
 * @param error
 * 			[Error]
 */
ProcessController.prototype.propagateServerError = function(server, error){
	//neues Server-Fehler Event erstelln
	alert(error.name +"\n"+ error.description);
};