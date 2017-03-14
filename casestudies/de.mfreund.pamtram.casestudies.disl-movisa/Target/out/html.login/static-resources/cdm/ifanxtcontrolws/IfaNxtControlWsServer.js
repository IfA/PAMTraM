function IfaNxtControlWsServer(url, proxyAddress, serverDataItemList) {
	this.url = url; // target service url for the SOAP messages
	this.proxyAddress = proxyAddress;
	this.serverDataItemList = serverDataItemList;
	this.serverSubscriptionList = new Array();
	this.managedDevices = new Array();
	
	for (var i=0, l=this.serverDataItemList.length; i<l; i++) {
		var nxtAddress = this.serverDataItemList[i].NxtAddress;
		if ($.inArray(nxtAddress, this.managedDevices) < 0) {
			this.managedDevices.push(nxtAddress);
			this.connectTo(nxtAddress);
		}
	}
}
extend(IfaNxtControlWsServer, Server);

IfaNxtControlWsServer.prototype.read = function(readItemList) {
	ifaNxtControlWsSoapMessenger.sendRead(readItemList, this.proxyAddress, 
			this.url, undefined, this.processSuccessfulResponse, this.processFaultyResponse);
};

IfaNxtControlWsServer.prototype.connectTo = function(nxtAddress) {
	ifaNxtControlWsSoapMessenger.sendConnectTo(nxtAddress, this.proxyAddress, 
			this.url, undefined, this.processSuccessfulResponse, this.processFaultyResponse);
}

IfaNxtControlWsServer.prototype.write = function(writeItemList){
	ifaNxtControlWsSoapMessenger.sendWrite(writeItemList, this.proxyAddress, 
			this.url, undefined, this.processSuccessfulResponse, this.processFaultyResponse);
};

IfaNxtControlWsServer.prototype.subscribe = function(subscription) {
	//get the subscription if the argument is the subscription ID as String
	if(typeof subscription == "string"){
		subscription = this.getServerSubscriptionById(subscription);
	}
	
	//set the ServerSubscription active
	subscription.active = true;
	
	ifaNxtControlWsSoapMessenger.sendSubscribe(subscription, this.proxyAddress, 
			this.url, this, this.processSuccessfulResponse, this.processFaultyResponse);
};

/**
 * PUBLIC Requests a polled refresh from an OPC XML DA-Server
 * 
 * @param subscription
 * 			[ServerSubscription] or [String] of the subscription ID
 */
IfaNxtControlWsServer.prototype.getPolledRefresh = function(subscription){
	//get the subscription if the argument is the subscription ID as String
	if(typeof subscription == "string"){
		subscription = this.getServerSubscriptionById(subscription);
	}
	
	if(subscription.active == true){
		ifaNxtControlWsSoapMessenger.sendSubscriptionPolledRefresh(subscription, this.proxyAddress, 
				this.url, this, this.processSuccessfulResponse, this.processFaultyResponse);
	}
};

IfaNxtControlWsServer.prototype.cancelSubscription = function(subscription){
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
IfaNxtControlWsServer.prototype.processSuccessfulResponse = function(data, textStatus, XMLHttpRequest){
	var responseItemList;
	
	//get the xml response in JSON
	var responseInJson = IfaNxtControlWsSoapMessenger.__super__.xml2json(data,"");
	var responseObjectInJson =  jQuery.parseJSON(responseInJson);
	
	if(textStatus == "success"){		
		try{
			//get all items listed in the response as array of ResponseItems
			responseItemList = ifaNxtControlWsSoapMessenger.getResponseItemList(responseObjectInJson);
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
				var _1 = responseObjectInJson["soapenv:Envelope"]["soapenv:Body"]["processCommandListResponse"];
				
				if (_1 !== undefined) {
					var _2 = _1["processCommandListReturn"]["requestHandle"]["#text"];
					
					if (_2 !== undefined) {
						var _3 = this.getServerSubscriptionById(_2);
						_3.serverHandle = _2;
						_3.lastResponseTime = new Date();
						
						(function(_this, _s) {
							_p = processController;
							setTimeout(function(){
								_p.handlePolledRefresh(_this, _2, textStatus);
							}, _s.publishingInterval);
						})(this, _3);
					}					
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
IfaNxtControlWsServer.prototype.processFaultyResponse = function(XMLHttpRequest, textStatus, errorThrown){
	var error;
	
	if(textStatus == "error"){
		try{
			//try to extract the error out of the response
			error = IfaNxtControlWsSoapMessenger.__super__.extractError(XMLHttpRequest);
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

function IfaNxtControlWsItem(id, nxtAddress, nxtCommand) {
	this.id = id;
	this.NxtAddress = nxtAddress;
	this.NxtCommand = nxtCommand;
}

extend(IfaNxtControlWsItem, ServerDataItem);

ifaNxtControlWsSoapMessenger = new IfaNxtControlWsSoapMessenger();