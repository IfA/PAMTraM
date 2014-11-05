function OpcXmlDaServer(localID, url, proxyAddress, serverDataItemList) {
	this.localID = localID;
	this.url = url; // target service url for the SOAP messages
	this.proxyAddress = proxyAddress;
	this.serverDataItemList = serverDataItemList;
	this.serverSubscriptionList = new Array();
}
extend(OpcXmlDaServer, Server);

/**
 * PUBLIC Executes a read-operation on an OPC XML DA-Server
 * 
 * @param readItemList
 *            [Array] of [ReadItem]
 */
OpcXmlDaServer.prototype.read = function(readItemList) {
	opcXmlDaSoapMessenger.sendRead(readItemList, this.proxyAddress, 
			this.url, undefined, this.processSuccessfulResponse, this.processFaultyResponse);
};

/**
 * PUBLIC Executes a write-operation on an OPC XML DA-Server
 * 
 * @param writeItemList
 * 			[Array] of [WriteItem]
 */
OpcXmlDaServer.prototype.write = function(writeItemList){
	opcXmlDaSoapMessenger.sendWrite(writeItemList, this.proxyAddress, 
			this.url, undefined, this.processSuccessfulResponse, this.processFaultyResponse);
};

/**
 * PUBLIC Executes a subscribe-operation on an OPC XML DA-Server
 * 
 * @param subscription
 * 			[ServerSubscription] or [String] of the subscription ID
 */
OpcXmlDaServer.prototype.subscribe = function(subscription) {
	//get the subscription if the argument is the subscription ID as String
	if(typeof subscription == "string"){
		subscription = this.getServerSubscriptionById(subscription);
	}
	
	//set the ServerSubscription active
	subscription.active = true;
	
	opcXmlDaSoapMessenger.sendSubscribe(subscription, this.proxyAddress, 
			this.url, this, this.processSuccessfulResponse, this.processFaultyResponse);
};

/**
 * PUBLIC Requests a polled refresh from an OPC XML DA-Server
 * 
 * @param subscription
 * 			[ServerSubscription] or [String] of the subscription ID
 */
OpcXmlDaServer.prototype.getPolledRefresh = function(subscription){
	//get the subscription if the argument is the subscription ID as String
	if(typeof subscription == "string"){
		subscription = this.getServerSubscriptionById(subscription);
	}
	
	if(subscription.active == true){
		opcXmlDaSoapMessenger.sendSubscriptionPolledRefresh(subscription, this.proxyAddress, 
				this.url, this, this.processSuccessfulResponse, this.processFaultyResponse);
	}
};

OpcXmlDaServer.prototype.cancelSubscription = function(subscription){
	//get the subscription if the argument is the subscription ID as String
	if(typeof subscription == "string"){
		subscription = this.getServerSubscriptionById(subscription);
	}
	
	//set the ServerSubscription inactive
	subscription.active = false;
	
	/* SOAP-Message not working properly
	 opcXmlDaSoapMessenger.sendSubscriptionCancel(subscription, this.proxyAddress, 
			this.url, undefined, this.processSuccessfulResponse, this.processFaultyResponse);
	*/
};

/**
 * PUBLIC callback function for all successful AJAX-requests
 * 
 * @param data
 * 			returned from the server, formatted according to the 'dataType' parameter
 * @param textStatus
 * 			[String] describing the status
 * @param XMLHttpRequest
 * 			[Object]
 */
OpcXmlDaServer.prototype.processSuccessfulResponse = function(data, textStatus, XMLHttpRequest){
	var responseItemList;
	
	//get the xml response in JSON
	var responseInJson = OpcXmlDaSoapMessenger.__super__.xml2json(data,"");
	var responseObjectInJson =  jQuery.parseJSON(responseInJson);
	
	if(textStatus == "success"){		
		try{
			//get all items listed in the response as array of ResponseItems
			responseItemList = opcXmlDaSoapMessenger.getResponseItemList(responseObjectInJson);
		}
		catch(e){
			//extract the response items which are not affected by the error 
			responseItemList = e.notAffectedData;
			
			//inform the process controller about the error
			processController.propagateServerError(this, e);
		}
		finally{
			//if response items are available inform the process controller about them
			//and set some more thing according to the response-type
			if(responseItemList instanceof Array && responseItemList.length > 0){
				processController.propagateServerResponse(this, responseItemList);
				
				//start polled refresh, if subscribe was successful
				if( responseObjectInJson["soap:Envelope"]["soap:Body"]["SubscribeResponse"] != undefined ){
					var subscribeResponse = responseObjectInJson["soap:Envelope"]["soap:Body"]["SubscribeResponse"];
					var subscriptionID = subscribeResponse["SubscribeResult"]["@ClientRequestHandle"];
					var serverResponseTime = subscribeResponse["SubscribeResult"]["@ReplyTime"];
					var lastResponseTime = OpcXmlDaSoapMessenger.prototype.server2jsTimestamp(serverResponseTime);
					
					var subscription = this.getServerSubscriptionById(subscriptionID);
					subscription.serverHandle = subscribeResponse["@ServerSubHandle"];
					subscription.lastResponseTime = lastResponseTime;
					
					processController.handlePolledRefresh(this, subscriptionID, textStatus);
				}
				//initiate another polled refresh and save the last response time of a subscription
				else if(responseObjectInJson["soap:Envelope"]["soap:Body"]["SubscriptionPolledRefreshResponse"] != undefined){
					var subscribeResponse = responseObjectInJson["soap:Envelope"]["soap:Body"]["SubscriptionPolledRefreshResponse"];
					var subscriptionID = subscribeResponse["SubscriptionPolledRefreshResult"]["@ClientRequestHandle"];
					var serverResponseTime = subscribeResponse["SubscriptionPolledRefreshResult"]["@ReplyTime"];
					var lastResponseTime = OpcXmlDaSoapMessenger.prototype.server2jsTimestamp(serverResponseTime);
					
					var subscription = this.getServerSubscriptionById(subscriptionID);
					subscription.lastResponseTime = lastResponseTime;
					
					processController.handlePolledRefresh(this, subscriptionID, textStatus);
				}
			}
		}
	}
	
};

/**
 * PUBLIC callback function for all faulty AJAX-requests
 * 
 * @param XMLHttpRequest
 * 			[Object]
 * @param textStatus
 * 			[String] describing the status
 * @param errorThrown
 * 			optional exception object, if one occurred
 */
OpcXmlDaServer.prototype.processFaultyResponse = function(XMLHttpRequest, textStatus, errorThrown){
	var error;
	
	if(textStatus == "error"){
		try{
			//try to extract the error out of the response
			error = OpcXmlDaSoapMessenger.__super__.extractError(XMLHttpRequest);
		}
		catch(e){
			
		}
		finally{
			if(errorThrown != undefined){
				error.name += "; "+ errorThrown;
			}
			
			//inform the process controller about the error
			processController.propagateServerError(this, error);
		}
	}
	else if(textStatus == "parsererror"){
		error = new Error();
		error.name = errorThrown.type;
		error.description = errorThrown;
		
		//inform the process controller about the error
		processController.propagateServerError(this, error);
	}
};

/**
 * A <code>OpcXmlDaItem</code>-Object contains all relevant information of a
 * ServerDataItem for an OPC XML DA Server
 * 
 * @param itemType
 *            data-type (boolean, decimal,...)
 * @param itemPath
 * @param itemName
 */
function OpcXmlDaItem(id, itemType, itemPath, itemName) {
	this.id = id;
	this.itemType = itemType;
	this.itemPath = itemPath;
	this.itemName = itemName;
}

extend(OpcXmlDaItem, ServerDataItem);

//if the OpcXmlDaServer oackage is included, a 
//OpcXmlDaSopaMessenger is needed
opcXmlDaSoapMessenger = new OpcXmlDaSoapMessenger();