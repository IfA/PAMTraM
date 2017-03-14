function IfaNxtControlWsSoapMessenger(){
	this.__getSoapCommand = function(nxtCommand, nxtAddress, value, itemHandle) {
		return {
			"command" : {
				"@xsi:type" : "xsd:string",
				"#text" : nxtCommand
			},
			"nameNxt" : {
				"@xsi:type" : "xsd:string",
				"#text" : nxtAddress
			},
			"value" : {
				"@xsi:type" : "xsd:string",
				"#text" : value
			},
			"itemHandle" : {
				"@xsi:type" : "xsd:string",
				"#text" : itemHandle
			}
		};
	}
	this.__getSoapBodyCommandObjectInJson = function(nxtCommand, nxtAddress, value, itemHandle) {
		return {
			"processCommand" : {
				"command" : this.__getSoapCommand(nxtCommand, nxtAddress, value, itemHandle),
				"itemHandle" : identifier
			}
		};
	}
	this.__getSoapBodyCommandListObjectInJson = function(commandList, requestHandle) {
		return {
			"processCommandList" : {
				"commandList" : {
					"commandList" : {
						"@xsi:type" : "SOAP-ENC:array",
						"@SOAP-ENC:arrayType" : "ns1:Command[" + commandList.length + "]",
						"commandList" : commandList
					},
					"requestHandle" : requestHandle
				}
			}
		};
	}

	this.__getSoapBodyConnectToObjectInJson = function(nxtAddress){
		soapBodyObject = {
			"connectTo" : {
				"nameNXT" : {
					"@xsi:type" : "xsd:string",
					"#text" : nxtAddress
				}
			}
		};
        return soapBodyObject; 
	}
	this.__extractResponseItemList = function(responseType, responseObject) {
		var error, itemList;
		var responseItemList = new Array();
		
		if (responseObject["processCommandListReturn"]) {
			itemList = responseObject["processCommandListReturn"]["commandList"]["commandList"];
		}
		else if (responseObject["processCommandReturn"]) {
			itemList = responseObject["processCommandReturn"]["command"];
		}
		else return;
		
		//if responseObject is a single item save it in an Array
		//to use the algorithm in the for-loop
		if(itemList.constructor != Array){
			itemList = new Array(itemList);
		}
		
		//
		for(var i = 0; i < itemList.length; i++){
			var item = itemList[i];

			var value = item["value"]["#text"];
			var type = item["value"]["@xsi:type"];
			var itemHandle = item["itemHandle"]["#text"];
			
			//create DataItemValue
			var dataItemValue = new DataItemValue(value, type, new Date(), 100);
			
			//save new ReadResponseItem in responseItemList
			responseItemList.push(new ResponseItem(responseType, itemHandle, dataItemValue));
		}
		return responseItemList;
	}
}
extend(IfaNxtControlWsSoapMessenger, SoapMessenger);

IfaNxtControlWsSoapMessenger.prototype.sendMessage = function(proxyAddress, targetUrl,
		soapAction, soapBodyObject, callbackContext, onSuccessFunction, onErrorFunction){
	
	var soapMessageInJson = null;
	var soapMessage = "";

	// SOAP-Envelope template
	soapMessageInJson = {
		"SOAP-ENV:Envelope" : {
			"@xmlns:SOAP-ENV" : "http://schemas.xmlsoap.org/soap/envelope/",
			"@xmlns:SOAP-ENC" : "http://schemas.xmlsoap.org/soap/encoding/",
			"@xmlns:xsi" : "http://www.w3.org/2001/XMLSchema-instance",
			"@xmlns:xsd" : "http://www.w3.org/2001/XMLSchema",
			"SOAP-ENV:Header" : {
				"TargetService" : {
					"@xmlns" : "http://tu-dresden.de/ifa/",
					"#text" : targetUrl
				}
			},
			"SOAP-ENV:Body" : soapBodyObject
		}
	};
	
	// transform the SOAP message object to a XML string
	soapMessage = IfaNxtControlWsSoapMessenger.__super__.json2xml(soapMessageInJson, "");
	
	// send the SOAP message via AJAX
	IfaNxtControlWsSoapMessenger.__super__.sendMessage(proxyAddress, soapMessage, 
			soapAction, callbackContext, onSuccessFunction, onErrorFunction);
};

IfaNxtControlWsSoapMessenger.prototype.sendConnectTo = function(nxtAddress, proxyAddress, 
		targetUrl, callbackContext, onSuccessFunction, onErrorFunction){
	
	var soapAction = "''";
	var soapBodyObject = this.__getSoapBodyConnectToObjectInJson(nxtAddress);
	
	this.sendMessage(proxyAddress, targetUrl, soapAction, soapBodyObject, 
			callbackContext, onSuccessFunction, onErrorFunction);
};

IfaNxtControlWsSoapMessenger.prototype.sendRead = function(readItemList, identifier, 
		proxyAddress, targetUrl, callbackContext, onSuccessFunction, onErrorFunction){
	var soapAction = "''";
	var commandList = [];
	for (var i=0, l=readItemList.length; i<l; i++) {
		var ri = readItemList[i];
		var di = ri.getServerDataItem();
		commandList.push(this.__getSoapCommand(di.NxtCommand, di.NxtAddress, "null", ri.dataItem.id));
	}
	var soapBodyObject = this.__getSoapBodyCommandListObjectInJson(commandList, null);
	this.sendMessage(proxyAddress, targetUrl, soapAction, soapBodyObject, 
			callbackContext, onSuccessFunction, onErrorFunction);
};

IfaNxtControlWsSoapMessenger.prototype.sendSubscribe = function(subscription, proxyAddress, 
		targetUrl, callbackContext, onSuccessFunction, onErrorFunction){
	var soapAction = "''";
	var commandList = [];
	for (var i=0,l=subscription.monitoredItemList.length; i<l; i++) {
		var mi = subscription.monitoredItemList[i];
		var di = mi.getServerDataItem();
		commandList.push(this.__getSoapCommand(di.NxtCommand, di.NxtAddress, "null", mi.dataItem.id));
	}
	var soapBodyObject = this.__getSoapBodyCommandListObjectInJson(commandList, subscription.id);
	this.sendMessage(proxyAddress, targetUrl, soapAction, soapBodyObject, 
			callbackContext, onSuccessFunction, onErrorFunction);
};

IfaNxtControlWsSoapMessenger.prototype.sendSubscriptionPolledRefresh = function(subscription, proxyAddress, 
		targetUrl, callbackContext, onSuccessFunction, onErrorFunction){
	this.sendSubscribe(subscription, proxyAddress, targetUrl, callbackContext, onSuccessFunction, onErrorFunction);
};

IfaNxtControlWsSoapMessenger.prototype.sendWrite = function(writeItemList, proxyAddress, 
		targetUrl, callbackContext, onSuccessFunction, onErrorFunction){
	var soapAction = "''";
	var commandList = [];
	for (var i=0, l=writeItemList.length; i<l; i++) {
		var wi = writeItemList[i];
		var di = wi.getServerDataItem();
		commandList.push(this.__getSoapCommand(di.NxtCommand, di.NxtAddress, wi.dataItemValue.value, wi.dataItem.id));
	}
	var soapBodyObject = this.__getSoapBodyCommandListObjectInJson(commandList, null);
	this.sendMessage(proxyAddress, targetUrl, soapAction, soapBodyObject, 
			callbackContext, onSuccessFunction, onErrorFunction);
};


/**
 * PUBLIC Sends a SOAP-SubscriptionCancel message to an OPC XML DA server
 * 
 * @param subscription
 *            [ServerSubscription]
 * @param proxyAddress
 *            [String] address of the proxy for the messaging
 * @param targetUrl
 *            [String] URL of the OPC XML DA server's webservice
 * @param callbackContext
 *            [Object] context in which the onSuccessFunction or onErrorFunction
 *            get called or undefined if no callbackContext shall be set
 * @param onSuccessFunction
 *            [Function] called if sending was successful
 * @param onErrorFunction
 *            [Function] called if error occurs
 */
IfaNxtControlWsSoapMessenger.prototype.sendSubscriptionCancel = function(subscription, proxyAddress, 
		targetUrl, callbackContext, onSuccessFunction, onErrorFunction){
	
	var soapAction = "http://opcfoundation.org/webservices/XMLDA/1.0/SubscriptionCancel";
	var soapBodyObject = this.__getSoapBodySubscriptionCancelObjectInJson(subscription);
	
	this.sendMessage(proxyAddress, targetUrl, soapAction, soapBodyObject, 
			callbackContext, onSuccessFunction, onErrorFunction);
};

IfaNxtControlWsSoapMessenger.prototype.getResponseItemList = function(responseObjectInJson){
	var response;
	
	if(responseObjectInJson["soapenv:Envelope"]["soapenv:Body"]["processCommandListResponse"] != undefined){
		return this.__extractResponseItemList("processCommandList", responseObjectInJson["soapenv:Envelope"]["soapenv:Body"]["processCommandListResponse"]);
	}
};