function ModbusTcpSoapMessenger(){
	/**
	 * PRIVATE calculate the HoldTime for a polled refresh
	 * 
	 * @param subsciption
	 * 			[ServerSubscription]
	 * @returns [Date] holtTime
	 */
	this.__getHoldTime = function(subscription){
		var holdTime = subscription.lastResponseTime;
		var holdTimePeriod = subscription.holdTimePeriod;
		var holdTimePeriodString = holdTimePeriod +"";
		var holdTimePeriodStringLength = holdTimePeriodString.length;
		var addSeconds = 0;
		var addMilliseconds = 0;
		
		//if holdTimePeriod is greater than 999ms, split it into 
		//seconds an milliseconds
		if(holdTimePeriodStringLength > 3){
			addSeconds = holdTimePeriod%1000;
			addMilliseconds = holdTimePeriodString.slice(holdTimePeriodStringLength-4,
					holdTimePeriodStringLength-1);
		}
		else{
			addMilliseconds = holdTimePeriod;
		}
		
		//set the hold time by adding the calculated seconds and ms
		holdTime.setSeconds( holdTime.getSeconds() + addSeconds );
		holdTime.setMilliseconds( holdTime.getMilliseconds() + addMilliseconds );
		
		return holdTime;
	};
	
	/**
	 * PRIVATE Builds the the SOAP Body Object in JSON for reading from server
	 * 
	 * @param readItemList
	 *            [Array] of [ReadItems]
	 * @returns [Object] Body Object for the SOAP message in JSON
	 */
	this.__getSoapBodyReadObjectInJson = function(readItemList) {
		var itemObject;
		var soapBodyObject;
		var soapReadItemsInJson = new Array();
		
		for ( var i = 0; i < readItemList.length; i++) {
			//collect the relevant information, which shall be sent via SOAP, 
			//from the serverDataItem and dataItem and save it in JSON-Object
			
			itemObject = {
				"@xsi:type" : "ns2:DataItem",
				"clientItemHandle" : {
				"@xsi:type" : "xsd:string",
				"#text" : readItemList[i].dataItem.id},
				"itemReferenceAddress" :  {
				"@xsi:type" : "xsd:string",
				"#text" : readItemList[i].serverDataItem.referenceAddress},
				"modbusTcpBaseType" : {
				"@xsi:type" : "xsd:string",
				"#text" : readItemList[i].serverDataItem.type}
				};
			soapReadItemsInJson.push(itemObject);
		}
		
		//SOAP-Body template for reading
		soapBodyObject = {
							"@xmlns:m" : "urn:http://localhost:8080/axis/services/MasterWS",
							"ns1:getValueList" : {
							"@SOAP-ENV:encodingStyle" : "http://schemas.xmlsoap.org/soap/encoding",
							"@xmlns:ns1" : "urn:http://localhost:8080/axis/services/MasterWS" ,
								"ItemList" : {
								 "@soapenc:arrayType" : "ns2:DataItem["+readItemList.length+"]",
								 "@xsi:type" : "soapenc:Array",
								 "@xmlns:ns2" : "http://pMasterWS",
								 "@xmlns:soapenc" :"http://schemas.xmlsoap.org/soap/encoding/",
									"ItemList" : soapReadItemsInJson
								}
							}
						};
		
		return soapBodyObject;
	};
	
	/**
	 * PRIVATE Builds the the SOAP Body Object in JSON for subscribing
	 * 
	 * @param subscription
	 * 			[ServerSubscription]
	 * @returns [Object] Body Object for the SOAP message in JSON
	 */
	this.__getSoapBodySubscripeObjectInJson = function(subscription){
		var monitoredItemList = subscription.monitoredItemList;
		
		var itemObject;
		var soapBodyObject;
		var soapReadItemsInJson = new Array();
		
		for ( var i = 0; i < monitoredItemList.length; i++) {
			//collect the relevant information, which shall be sent via SOAP, 
			//from the serverDataItem and dataItem and save it in JSON-Object
			
			itemObject = {
				"@xsi:type" : "ns2:DataItem",
				"clientItemHandle" : {
				"@xsi:type" : "xsd:string",
				"#text" : monitoredItemList[i].dataItem.id},
				"itemReferenceAddress" :  {
				"@xsi:type" : "xsd:string",
				"#text" : monitoredItemList[i].dataItem.source.referenceAddress},
				"modbusTcpBaseType" : {
				"@xsi:type" : "xsd:string",
				"#text" : monitoredItemList[i].dataItem.source.type}
				};
			soapReadItemsInJson.push(itemObject);
		}
		
		//SOAP-Body template for reading
		soapBodyObject = {
							"@xmlns:m" : "urn:http://localhost:8080/axis/services/MasterWS",
							"ns1:getValueList" : {
							"@SOAP-ENV:encodingStyle" : "http://schemas.xmlsoap.org/soap/encoding",
							"@xmlns:ns1" : "urn:http://localhost:8080/axis/services/MasterWS" ,
								"ItemList" : {
								 "@soapenc:arrayType" : "ns2:DataItem["+monitoredItemList.length+"]",
								 "@xsi:type" : "soapenc:Array",
								 "@xmlns:ns2" : "http://pMasterWS",
								 "@xmlns:soapenc" :"http://schemas.xmlsoap.org/soap/encoding/",
									"ItemList" : soapReadItemsInJson
								}
							}
						};
		
		return soapBodyObject;
	};
	
	/**
	 * PRIVATE Builds the the SOAP Body Object in JSON for writing on server
	 * 
	 * @param writeItemList
	 *            [Array] of [WriteItem] which shall be written
	 * @returns [Object] Body Object for the SOAP message in JSON
	 */
	this.__getSoapBodyWriteObjectInJson = function(writeItemList) {
		var itemObject;
		var soapBodyObject;
		var soapReadItemsInJson = new Array();
		
		for ( var i = 0; i < writeItemList.length; i++) {
			//collect the relevant information, which shall be sent via SOAP, 
			//from the serverDataItem and dataItem and save it in JSON-Object
			
			itemObject = {
				"@xsi:type" : "ns2:DataItem",
				"clientItemHandle" : {
				"@xsi:type" : "xsd:string",
				"#text" : writeItemList[i].dataItem.id},
				"itemReferenceAddress" :  {
				"@xsi:type" : "xsd:string",
				"#text" : writeItemList[i].serverDataItem.referenceAddress},
				"modbusTcpBaseType" : {
				"@xsi:type" : "xsd:string",
				"#text" : writeItemList[i].serverDataItem.type},
				"setValue" : {
				"@xsi:type" : "xsd:string",
				"#text" : writeItemList[i].dataItemValue.value}
				};
			soapReadItemsInJson.push(itemObject);
		}
		
		//SOAP-Body template for reading
		soapBodyObject = {
							"@xmlns:m" : "urn:http://localhost:8080/axis/services/MasterWS",
							"ns1:setValueList" : {
							"@SOAP-ENV:encodingStyle" : "http://schemas.xmlsoap.org/soap/encoding",
							"@xmlns:ns1" : "urn:http://localhost:8080/axis/services/MasterWS" ,
								"ItemList" : {
								 "@soapenc:arrayType" : "ns2:DataItem["+writeItemList.length+"]",
								 "@xsi:type" : "soapenc:Array",
								 "@xmlns:ns2" : "http://pMasterWS",
								 "@xmlns:soapenc" :"http://schemas.xmlsoap.org/soap/encoding/",
									"ItemList" : soapReadItemsInJson
								}
							}
						};
		
		return soapBodyObject;
	};
	
	/**
	 * PRIVATE extract the responseItemList out of a response object
	 * no matter if the response type is ReadResponse, SusbscripeResponse,...
	 * Also creates DataItemValue-objects, which will get appended to a DataItem 
	 * 
	 * @param responseObject
	 * 			[Object] response in JSON
	 * @return [Array] of [ResponseItems]
	 * @throws [Error] if the response contains an error
	 */
	this.__extractResponseItemList = function(responseType, responseObject){
		var error;
		var responseItemList = new Array();
		if(responseObject["getValueListReturn"])
			var itemList = responseObject["getValueListReturn"]["getValueListReturn"];
		else
			var itemList = responseObject["setValueListReturn"]["setValueListReturn"];
		var item;
		var dataItemValue;
		var timestamp;
		
		//if responseObject is a single item save it in an Array
		//to use the algorithm in the for-loop
		if(itemList.constructor != Array){
			itemList = new Array(itemList);
		}
		
		//
		for(var i = 0; i < itemList.length; i++){
			//in case of a SubscribeResponse
			if(itemList[i]["ItemValue"] != undefined){
				item = itemList[i]["ItemValue"];
			}
			//every other Response type
			else{
				item = itemList[i];
			}
			
			
			//create Error/attach error message if Item has a attribute ResultId
			if(item["@ResultID"] != undefined){
				if(error == undefined){
					 error = new Error();
				}
				if(item["@ResultID"] == "E_UNKNOWNITEMNAME"){
					error.message = error.message +";\n Unknown Item "+ item["@ItemName"] +" on server requested";
				}
				else if(item["@ResultID"] == "E_BADTYPE"){
					error.message = error.message +";\n Item "+ item["@ItemName"] +" with wrong type requested";
				}
			}
			else{
				//create timestamp
				if(item["@Timestamp"] != undefined ){
					timestamp = this.server2jsTimestamp(item["@Timestamp"]);
				}
				else{
					timestamp = new Date();
				}
				
				//create DataItemValue
				dataItemValue = new DataItemValue(item["itemValue"]["#text"], item["itemValue"]["@xsi:type"], timestamp, 100);
				
				//save new ReadResponseItem in responseItemList
				responseItemList.push(new ResponseItem(responseType, item["itemName"]["#text"], dataItemValue));
			}
		}
		
		//throw error if server sent errors
		if(responseObject["Errors"] != undefined){
			var errorResponse = responseObject["Errors"];
			
			error.message =  error.message +";\n "+ errorResponse["Text"];
			error.name = errorResponse["@ID"];
			error.notAffectedData = responseItemList;
			
			throw error;
		}
		
		return responseItemList;
	};
}

extend(ModbusTcpSoapMessenger, SoapMessenger);

/**
 * PUBLIC converts a timestamp sent from a server into a Javascript timestamp
 * 
 * @param serverTimestamp
 * 			[String] Timestamp sent from server e.g. 2010-09-13T16:58:08.625+02:00
 * @returns [Date] timestamp
 */
ModbusTcpSoapMessenger.prototype.server2jsTimestamp = function(serverTimestamp){
	var jsTimestamp = new Date();
	
	var timestampArray =  serverTimestamp.split("T"); //[ "2010-09-13", "16:58:08.625+02:00"]
	var date = timestampArray[0]; //"2010-09-13"
	var dateArray = date.split("-"); //["2010","09","13"]
	var time = timestampArray[1].split("+"); //["16:58:08.625","02:00"]
	var timeArray = time[0].split(":"); //["16","58","08.625"]
	var secondsArray = timeArray[2].split("."); //["08","625"]

	var month = parseInt(dateArray[1],10)-1; //JavaScripts starts month counting with 0

	jsTimestamp.setFullYear(parseInt(dateArray[0],10));
	jsTimestamp.setMonth(month);
	jsTimestamp.setDate(parseInt(dateArray[2],10));
	jsTimestamp.setHours(parseInt(timeArray[0],10));
	jsTimestamp.setMinutes(parseInt(timeArray[1],10));
	jsTimestamp.setSeconds(parseInt(secondsArray[0],10), parseInt(secondsArray[1],10));
	
	return jsTimestamp;
};

/**
 * PUBLIC converts a JavaScript timestamp into an OPC XML DA timestamp
 * 
 * @param timestamp
 * 			[Date] Javascript timestamp
 * @returns [String] timestamp for an OPC XML DA server 
 * 					e.g. 2010-09-13T16:58:08.625+02:00
 */
ModbusTcpSoapMessenger.prototype.js2serverTimestamp = function(timestamp){
	//calculate timezone offset (given in minutes difference from GMT)
	//in usual offset in hours
	var timezoneOffset = timestamp.getTimezoneOffset()/-60;
	var month = timestamp.getMonth() + 1; //JS starts with the 0. month
	
	var serverTimestamp = timestamp.getFullYear() +"-"+ //2010-
							addLeadingZeros(month,2) +"-"+ //2010-09-
							addLeadingZeros(timestamp.getDate(),2) +"T"+ //2010-09-13T
							addLeadingZeros(timestamp.getHours(),2) +":"+ //2010-09-13T16:
							addLeadingZeros(timestamp.getMinutes(),2) +":"+ //2010-09-13T16:58:
							addLeadingZeros(timestamp.getSeconds(),2) +"."+ //2010-09-13T16:58:08.
							timestamp.getMilliseconds() +"+"+ //2010-09-13T16:58:08.625+
							addLeadingZeros(timezoneOffset,2) +":00"; //2010-09-13T16:58:08.625+02:00
	
	return serverTimestamp;
};

/**
 * PUBLIC Sends a SOAP message to an OPC XML DA server
 * 
 * @param proxyAddress
 * 			[String] address of the proxy for the messaging
 * @param targetUrl
 * 			[String] URL of the OPC XML DA server's webservice
 * @param soapAction
 * 			[String] SOAP-Action Header
 * @param soapBodyObject
 * 			[Object] SOAP-Body in JSON
 * @param callbackContext
 * 			[Object] context in which the onSuccessFunction or onErrorFunction get called
 * 			or undefined if no callbackContext shall be set
 * @param onSuccessFunction
 * 			[Function] called if sending was successful
 * @param onErrorFunction
 * 			[Function] called if error occurs
 */
ModbusTcpSoapMessenger.prototype.sendMessage = function(proxyAddress, targetUrl,
		soapAction, soapBodyObject, callbackContext, onSuccessFunction, onErrorFunction){
	
	var soapMessageInJson = null;
	var soapMessage = "";

	//SOAP-Envelope template
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
	
	//transform the SOAP message object to a XML string
	soapMessage = ModbusTcpSoapMessenger.__super__.json2xml(soapMessageInJson, "");
	
	//send the SOAP message via AJAX
	ModbusTcpSoapMessenger.__super__.sendMessage(proxyAddress, soapMessage, 
			soapAction, callbackContext, onSuccessFunction, onErrorFunction);
};

/**
 * PUBLIC Sends a SOAP-Read message to an OPC XML DA server
 * 
 * @param readItemList
 * 			  [Array] of [ReadItems]
 * @param proxyAddress
 * 			  [String] address of the proxy for the messaging
 * @param targetUrl
 * 			  [String] URL of the OPC XML DA server's webservice
 * @param callbackContext
 * 			[Object] context in which the onSuccessFunction or onErrorFunction get called
 * 			or undefined if no callbackContext shall be set
 * @param onSuccessFunction
 * 			  [Function] called if sending was successful
 * @param onErrorFunction
 * 			[Function] called if error occurs
 */
ModbusTcpSoapMessenger.prototype.sendRead = function(readItemList, proxyAddress, 
		targetUrl, callbackContext, onSuccessFunction, onErrorFunction){
	
	var soapAction = "getValue";
	var soapBodyObject = this.__getSoapBodyReadObjectInJson(readItemList);
	
	this.sendMessage(proxyAddress, targetUrl, soapAction, soapBodyObject, 
			callbackContext, onSuccessFunction, onErrorFunction);
};

/**
 * PUBLIC Sends a SOAP-Write message to an OPC XML DA server
 * 
 * @param writeItemList
 * 			  [Array] of [ReadItems]
 * @param proxyAddress
 * 			  [String] address of the proxy for the messaging
 * @param targetUrl
 * 			  [String] URL of the OPC XML DA server's webservice
 * @param callbackContext
 * 			[Object] context in which the onSuccessFunction or onErrorFunction get called
 * 			or undefined if no callbackContext shall be set
 * @param onSuccessFunction
 * 			  [Function] called if sending was successful
 * @param onErrorFunction
 * 			[Function] called if error occurs
 */
ModbusTcpSoapMessenger.prototype.sendWrite = function(writeItemList, proxyAddress, 
		targetUrl, callbackContext, onSuccessFunction, onErrorFunction){
	
	var soapAction = "http://opcfoundation.org/webservices/XMLDA/1.0/Write";
	var soapBodyObject = this.__getSoapBodyWriteObjectInJson(writeItemList);
	
	this.sendMessage(proxyAddress, targetUrl, soapAction, soapBodyObject, 
			callbackContext, onSuccessFunction, onErrorFunction);
};

/**
 * PUBLIC Sends a SOAP-Subscribe message to an OPC XML DA server
 * 
 * @param subscription
 * 			  [ServerSubscription]
 * @param proxyAddress
 * 			  [String] address of the proxy for the messaging
 * @param targetUrl
 * 			  [String] URL of the OPC XML DA server's webservice
 * @param callbackContext
 * 			[Object] context in which the onSuccessFunction or onErrorFunction get called
 * 			or undefined if no callbackContext shall be set
 * @param onSuccessFunction
 * 			  [Function] called if sending was successful
 * @param onErrorFunction
 * 			[Function] called if error occurs
 */
ModbusTcpSoapMessenger.prototype.sendSubscribe = function(subscription, proxyAddress, 
		targetUrl, callbackContext, onSuccessFunction, onErrorFunction){
	
	var soapAction = "http://opcfoundation.org/webservices/XMLDA/1.0/Subscribe";
	var soapBodyObject = this.__getSoapBodySubscripeObjectInJson(subscription);
	
	this.sendMessage(proxyAddress, targetUrl, soapAction, soapBodyObject, 
			callbackContext, onSuccessFunction, onErrorFunction);
};

/**
 * PUBLIC Sends a SOAP-SubscriptionPolledRefresh message to an 
 * OPC XML DA server
 * 
 * @param subscription
 * 			  [ServerSubscription]
 * @param proxyAddress
 * 			  [String] address of the proxy for the messaging
 * @param targetUrl
 * 			  [String] URL of the OPC XML DA server's webservice
 * @param callbackContext
 * 			[Object] context in which the onSuccessFunction or onErrorFunction get called
 * 			or undefined if no callbackContext shall be set
 * @param onSuccessFunction
 * 			  [Function] called if sending was successful
 * @param onErrorFunction
 * 			[Function] called if error occurs
 */
ModbusTcpSoapMessenger.prototype.sendSubscriptionPolledRefresh = function(subscription, proxyAddress, 
		targetUrl, callbackContext, onSuccessFunction, onErrorFunction){
	
	var soapAction = "http://opcfoundation.org/webservices/XMLDA/1.0/SubscriptionPolledRefresh";
	var soapBodyObject = this.__getSoapBodySubscriptionPolledRefreshObjectInJson(subscription);
	
	this.sendMessage(proxyAddress, targetUrl, soapAction, soapBodyObject, 
			callbackContext, onSuccessFunction, onErrorFunction);
};

/**
 * PUBLIC Sends a SOAP-SubscriptionCancel message to an 
 * OPC XML DA server
 * 
 * @param subscription
 * 			  [ServerSubscription]
 * @param proxyAddress
 * 			  [String] address of the proxy for the messaging
 * @param targetUrl
 * 			  [String] URL of the OPC XML DA server's webservice
 * @param callbackContext
 * 			[Object] context in which the onSuccessFunction or onErrorFunction get called
 * 			or undefined if no callbackContext shall be set
 * @param onSuccessFunction
 * 			  [Function] called if sending was successful
 * @param onErrorFunction
 * 			[Function] called if error occurs
 */
ModbusTcpSoapMessenger.prototype.sendSubscriptionCancel = function(subscription, proxyAddress, 
		targetUrl, callbackContext, onSuccessFunction, onErrorFunction){
	
	var soapAction = "http://opcfoundation.org/webservices/XMLDA/1.0/SubscriptionCancel";
	var soapBodyObject = this.__getSoapBodySubscriptionCancelObjectInJson(subscription);
	
	this.sendMessage(proxyAddress, targetUrl, soapAction, soapBodyObject, 
			callbackContext, onSuccessFunction, onErrorFunction);
};

/**
 * PUBLIC processes server response and creates a Array of ResponseItems
 * 
 * @param data
 * 			parsed XML response as DOM-object 
 * 			(automatically generated by jQuery as success-function arg)
 * @throws Error.name: E_UNKNOWNITEMNAME
 * 						if requested item is not available on server
 * @returns Array of ResponseItems
 */
ModbusTcpSoapMessenger.prototype.getResponseItemList = function(responseObjectInJson){
	/* SOAP Response example: 
		<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
			xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
			<soap:Body>
				<ReadResponse xmlns="http://opcfoundation.org/webservices/XMLDA/1.0/">
					<ReadResult RcvTime="2010-09-13T16:58:08.625+02:00"
						ReplyTime="2010-09-13T16:58:08.625+02:00" RevisedLocaleID="de-DE"
						ServerState="running" />
					<RItemList>
						<Items ItemName="Schneider/Fuellstand1_Ist" ClientItemHandle="my_fuellstand1"
							Timestamp="2010-09-13T16:58:08.625+02:00">
							<Value xsi:type="xsd:float">152.99</Value>
						</Items>
						<Items ItemName="Schneider/Fuellstand1_Ist" ClientItemHandle="my_fuellstand2"
							Timestamp="2010-09-13T16:58:08.625+02:00">
							<Value xsi:type="xsd:float">152.99</Value>
						</Items>
					</RItemList>
				</ReadResponse>
			</soap:Body>
		</soap:Envelope>
	 */
	
	/* SOAP Response in JSON example:
		{"soap:Envelope":{
				"@xmlns:soap":"http://schemas.xmlsoap.org/soap/envelope/",
				"@xmlns:xsi":"http://www.w3.org/2001/XMLSchema-instance",
				"@xmlns:xsd":"http://www.w3.org/2001/XMLSchema",
				"soap:Body":{
					"ReadResponse":{
						"@xmlns":"http://opcfoundation.org/webservices/XMLDA/1.0/",
						"ReadResult":{
							"@RcvTime":"2010-09-14T12:59:08.671+02:00",
							"@ReplyTime":"2010-09-14T12:59:08.703+02:00",
							"@RevisedLocaleID":"de-DE","@ServerState":"running"
						},
						"RItemList":{
							"Items":[{
										"@ItemName":"Schneider/Fuellstand1_Ist",
										"@ClientItemHandle":"my_fuellstand1",
										"@Timestamp":"2010-09-14T12:59:08.703+02:00",
										"Value":{
											"@xsi:type":"xsd:float",
											"#text":"152.914"
										}
									},
									{
										"@ItemName":"Schneider/Fuellstand2_Ist",
										"@ClientItemHandle":"my_fuellstand2",
										"@Timestamp":"2010-09-14T12:59:08.687+02:00",
										"Value":{
											"@xsi:type":"xsd:float",
											"#text":"81.3087"
										}
									}]
						}
					}
				}
			}
		}
	 */	

	var response;
	
	if(responseObjectInJson["soapenv:Envelope"]["soapenv:Body"]["ns1:getValueListResponse"] != undefined){
		return this.__extractResponseItemList("read", responseObjectInJson["soapenv:Envelope"]["soapenv:Body"]["ns1:getValueListResponse"]);
	}
	else if(responseObjectInJson["soapenv:Envelope"]["soapenv:Body"]["ns1:setValueListResponse"] != undefined){
		return this.__extractResponseItemList("write", responseObjectInJson["soapenv:Envelope"]["soapenv:Body"]["ns1:setValueListResponse"]);
	}
};