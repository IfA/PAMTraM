function ModbusTcpServer(localID, url, proxyAddress, serverDataItemList) {
	this.localID = localID;
	this.url = url; // target service url for the SOAP messages
	this.proxyAddress = proxyAddress;
	this.serverDataItemList = serverDataItemList;
	this.serverSubscriptionList = new Array();
}
extend(ModbusTcpServer, Server);

/**
 * PUBLIC Executes a read-operation on an OPC XML DA-Server
 * 
 * @param readItemList
 *            [Array] of [ReadItem]
 */
ModbusTcpServer.prototype.read = function(readItemList) {
	modbusTcpSoapMessenger.sendRead(readItemList, this.proxyAddress, 
			this.url, undefined, this.processSuccessfulResponse, this.processFaultyResponse);
};

/**
 * PUBLIC Executes a write-operation on an OPC XML DA-Server
 * 
 * @param writeItemList
 * 			[Array] of [WriteItem]
 */
ModbusTcpServer.prototype.write = function(writeItemList){
	modbusTcpSoapMessenger.sendWrite(writeItemList, this.proxyAddress, 
			this.url, undefined, this.processSuccessfulResponse, this.processFaultyResponse);
};

/**
 * PUBLIC Executes a subscribe-operation on an OPC XML DA-Server
 * 
 * @param subscription
 * 			[ServerSubscription] or [String] of the subscription ID
 */
ModbusTcpServer.prototype.subscribe = function(subscription) {
	//get the subscription if the argument is the subscription ID as String
	if(typeof subscription == "string"){
		subscription = this.getServerSubscriptionById(subscription);
	}
	
	//set the ServerSubscription active
	subscription.active = true;
	
	modbusTcpSoapMessenger.sendSubscribe(subscription, this.proxyAddress, 
			this.url, subscription, this.processSuccessfulSubscriptionResponse, this.processFaultyResponse);
};

/**
 * PUBLIC Executes a subscribe-operation on an OPC XML DA-Server
 * 
 * @param subscription
 * 			[ServerSubscription] or [String] of the subscription ID
 */
ModbusTcpServer.prototype.reSubscribe = function(subscription) {
	modbusTcpSoapMessenger.sendSubscribe(subscription, this.proxyAddress, 
			this.url, subscription, this.processSuccessfulSubscriptionResponse, this.processFaultyResponse);
};

ModbusTcpServer.prototype.cancelSubscription = function(subscription){
	//get the subscription if the argument is the subscription ID as String
	if(typeof subscription == "string"){
		subscription = this.getServerSubscriptionById(subscription);
	}
	
	//set the ServerSubscription inactive
	subscription.active = false;
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
ModbusTcpServer.prototype.processSuccessfulSubscriptionResponse = function(data, textStatus, XMLHttpRequest){
	var responseItemList;
	
	//get the xml response in JSON
	var responseInJson = ModbusTcpSoapMessenger.__super__.xml2json(data,"");
	var responseObjectInJson =  jQuery.parseJSON(responseInJson);
	
	if(textStatus == "success"){		
		try{
			//get all items listed in the response as array of ResponseItems
			responseItemList = modbusTcpSoapMessenger.getResponseItemList(responseObjectInJson);
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
			}
			if(this.active)
			{
				var obj = this;
				var messenger = this.server;
				window.setTimeout(function(){messenger.reSubscribe(obj)},this.holdTimePeriod);
			}
			
		}
	}
	
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
ModbusTcpServer.prototype.processSuccessfulResponse = function(data, textStatus, XMLHttpRequest){
	var responseItemList;
	
	//get the xml response in JSON
	var responseInJson = ModbusTcpSoapMessenger.__super__.xml2json(data,"");
	var responseObjectInJson =  jQuery.parseJSON(responseInJson);
	
	if(textStatus == "success"){		
		try{
			//get all items listed in the response as array of ResponseItems
			responseItemList = modbusTcpSoapMessenger.getResponseItemList(responseObjectInJson);
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
ModbusTcpServer.prototype.processFaultyResponse = function(XMLHttpRequest, textStatus, errorThrown){
	var error;
	
	if(textStatus == "error"){
		try{
			//try to extract the error out of the response
			error = ModbusTcpSoapMessenger.__super__.extractError(XMLHttpRequest);
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
function ModbusTcpItem(id, referenceAddress, type, baseType) {
	this.id = id;
	this.referenceAddress = referenceAddress;
	this.type = type;
	this.baseType = baseType;
}

extend(ModbusTcpItem, ServerDataItem);

//if the OpcXmlDaServer package is included, a 
//OpcXmlDaSopaMessenger is needed
modbusTcpSoapMessenger = new ModbusTcpSoapMessenger();