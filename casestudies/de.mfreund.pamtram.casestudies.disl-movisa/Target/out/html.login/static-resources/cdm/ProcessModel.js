function ProcessModel(dataItemList){
	this.dataItemList = dataItemList;
}

/**
 * PUBLIC add a list of DataItem to the ProcessModel
 * (Doesn't check if DataItems are already added!)
 * 
 * @param [Array] of [DataItem] dataItemList
 */
ProcessModel.prototype.addDataItems = function(dataItemList){
	this.dataItemList.concat(dataItemList);
};

/**
 * PUBLIC set several DataItemValues at once and return the 
 * manipulated DataItems as list
 * 
 * @param pairList
 * 			[Array] of [Object]  each pair of the pairList must have:
 * 				[DataItem] 		pair["dataItem"]
 * 				[DataItemValue] pair["dataItemValue"]
 * @returns [Array} of [DataItem] which got manipulated
 */
ProcessModel.prototype.setDataItemValues = function(pairList){
	var dataItem, dataItemValue;
	var dataItemList = new Array();
	
	for(var i=0; i < pairList.length; i++){
		dataItem = pairList[i]["dataItem"];
		
		dataItem.setValue(pairList[i]["dataItemValue"]);
		
		dataItemList.push(dataItem);
	}
	
	return dataItemList;
};

/**
 * PUBLIC set several DataItemValues by their DataItem IDs at once  
 * and return the manipulated DataItems as list
 * 
 * @param pairList
 * 			[Array] of [Object]  each pair of the pairList must have:
 * 				[String] 		pair["dataItemId"]
 * 				[DataItemValue] pair["dataItemValue"]
 * @returns [Array} of [DataItem] which got manipulated
 */
ProcessModel.prototype.setDataItemValuesByIds = function(pairList){
	var dataItem, dataItemValue;
	var dataItemList = new Array();
	
	for(var i=0; i < pairList.length; i++){
		dataItem = this.getDataItemById(pairList[i]["dataItemId"]);
		
//		dataItem.setValue(pairList[i].dataItemValue);
//		
//		dataItemList.push(dataItem);
		
		
		if(dataItem.getCurrentValue() && pmInitializied == true) {

			if(cdmInitialRefresh == false) {
				cdmInitialRefresh = true;
				// TODO schieberegister
				dataItem.setValue(pairList[i].dataItemValue);
				
				dataItemList.push(dataItem);
			} else if(dataItem.getCurrentValue().value !== pairList[i].dataItemValue.value) {
				// TODO schieberegister
				dataItem.setValue(pairList[i].dataItemValue);
				
				dataItemList.push(dataItem);
			} else {
				// TODO schieberegister
				dataItem.setValue(pairList[i].dataItemValue);
			}
		} else {
			dataItem.setValue(pairList[i].dataItemValue);
			dataItemList.push(dataItem);
		}
	}
	
	return dataItemList;
};

/**
 * PUBLIC fetch a DataItem by its ID
 * 
 * @param id
 * 			[String]
 * @returns [DataItem] with the matching ID
 * @returns null if no DataItem with matching ID was found
 */
ProcessModel.prototype.getDataItemById = function(id){
	for(var i = 0; i<this.dataItemList.length; i++){
		if(this.dataItemList[i].id == id){
			return this.dataItemList[i];
		}
	}
	
	return null;
};

/**
 * PUBLIC get a list of DataItems by their IDs
 * 
 * @param [Array] of [String] idList
 * @returns [Array] of [DataItem]
 */
ProcessModel.prototype.getDataItemListByIds = function(idList){
	var dataItemList = new Array();
	var slicedList = this.dataItemList;
	
	//for every ID of the idList...
	for(var i = 0; i<idList.length; i++){
		//search in the whole slicedList...
		for(var n = 0; n<slicedList.length; n++){
			
			//if the current ID of the DataItem in the slicedList
			//equals the ID in the idList
			if(slicedList[n].id == idList[i]){
				//then save the found dataItem in the dataItemList,
				dataItemList.push(processedList[n]);
				
				//slice the found DataItem out of the slicedList, so
				//the loop won't have to iterate over a already found
				//DataItem again
				slicedList.slice[n];
				
				//and finish the search for the DataItem with the current ID
				break;
			}
		}
	}
	
	return dataItemList;
};

/**
 * Storage for variables of the process control system
 * 
 * @param id
 * 			[String] ID in the visualisation, used by VisComps
 * @param description
 * 			[String] description of the item
 * @param logging
 * 			[boolean] true, if historical values shall be saved, false if not
 * @param maxAge
 * 			[integer] maximal age of values 
 * @param source
 * 			[ServerDataItem] represents a process variable
 * 			empty: DataItem is local
 * @param type
 * 			[DataType] Optional Parameter; represents the variables Type
 */
function DataItem(id, description, logging, maxAge, source, factor, digits, unit, type){//Dimension here!!!
	this.id = id;
	this.description = description;
	this.logging = logging;
	this.maxAge = maxAge;	
	this.dataItemValueList = new Array();
	this.SignalsOnChange = new Array();
	this.OwnedAlarmBehaviors = new Array();
	if(factor == null)this.factor = 1.0
	else this.factor = factor
	this.digits = digits;
	if(typeof type != 'undefined') this.type=type;
	else this.type="";
	
	//if the DataItem doesn't lie on a online server it is a local
	//variable and is managed by a LocalServer. Therefore the DataItem
	//has to be added to this server
	if(source == null){
		var localServer = processController.getLocalServer();
		
		this.source = new ServerDataItem(this.id);
		localServer.addServerDataItem(this.source);
	}
	else{
		this.source = source;
	}
	
	this.addSignalOnChange = function(signal){ this.SignalsOnChange.push(signal); }
	this.addAlarmBehavior = function(alarmBehavior){ this.OwnedAlarmBehaviors.push(alarmBehavior); }
	this.getDataItemValueList = function(){return this.DataItemValueList;}
}



/**
 * PUBLIC convert DataItem to String for output etc.
 * 
 * @returns [String] ID of DataItem
 */
DataItem.prototype.toString = function(){
	return id;
};

/**
 * PUBLIC sends all SignalsOnChange to the EventBus with the specific value
 * 
 * @param value
 * 			[Object] the value that should be put in the NotificationSignal
 */
DataItem.prototype.fireEvents = function(value){
	var dataItem = this;
	$.each(this.SignalsOnChange, function(index,item) { 
		var signal =new item();
		signal.setActualNotifyingDataItem(dataItem.id,value);
		eventBus.fireEvent(signal,null);
	});
};
/**
 * PUBLIC sets a new value of a DataItem
 * 
 * @param dataItemValue
 * 			[DataItemValue] new value object
 */
DataItem.prototype.setValue = function(dataItemValue){//Dimension Here!!!
	var success=true;
	if(this.type === "") {
		/*
		 * The following action would fail if used by with Base 64 Integers 
		 * (or actually any Integer above Base 53).
		 * Because round parses Strings containing Integers to
		 * Floating Point Numbers (64Bit) we would lose accuracy. 
		 */
		if (!isNaN(dataItemValue.value)) {
			dataItemValue.value = round(dataItemValue.value * this.factor,this.digits); 
		}
	} else {
		try{
			dataItemValue.value=this.__mapValue(dataItemValue.value, dataTypeList[this.type]);
		} catch (e) {
			alert(e.name +"\n"+ e.description);
			success=false;
		}
	}
	if(success){
		if( this.logging == false ){
			this.dataItemValueList[0] = dataItemValue;
		}
		else{
			this.dataItemValueList.push(dataItemValue);
		}
		//Check for Alarm
		$.each(this.OwnedAlarmBehaviors, function(index,item) {		
			item.checkAndNotify(dataItemValue.value);
		});
	}
};

/**
 * PRIVATE maps value to typeObjects type
 * 
 * @param value
 * 			[] Object containing tha value to be mapped
 * @param typeObject
 * 			[DataType] Object to determine the type of Object
 * @returns value mapped to TypeOjects Type
 */
DataItem.prototype.__mapValue = function(value, typeObject){
	switch(typeObject.typeString)
	{
		case "String":
			return value.toString();
			break;
		case "Boolean":
			if(typeof(value) === "boolean") return value;
			else if(!isNaN(parseInt(value))) {
				return !(parseInt(value) === 0);
			} else return !(value.toString().toLowerCase() === "false");
			break;
		case "Integer":
			var val=parseInt(value);
			if (!isNaN(val)) {
				return val;
			}
			break;
		case "Rational":
			var val=parseFloat(value);
			if (!isNaN(val)) {
				return round(val * this.factor,this.digits);
			}
			break;
		case "Enumeration":
			if(value < typeObject.literalList.length) {
				return typeObject.literalList[value];
			} 
			break;
		case "Structure":
			var newValue={};
			var success=true;
			for(i in typeObject.memberList)
			{
				if(typeof value[i] === "undefined")
				{
					if(typeObject.memberList[i].minOccurs == 0)
					{
						newValue[i]=[];
					} else{ 
						success = false;
						break; 
					}
				} else if(typeObject.memberList[i].minOccurs <= value[i].length && typeObject.memberList[i].maxOccurs >= value[i].length){
					newValue[i]=[];
					for(j in value[i])
					{
						newValue[i][j]=this.__mapValue(value[i][j], typeObject.memberList[i].type);
					}
				} else {
					success=false;
					break;
				}
			}
			//return JSON.stringify(newValue); // this is just for test purposes TODO
			if(success) return newValue;
			break;
	}
	var errorMsg=new Error();
	errorMsg.name="Data Item Mapping failed";
	errorMsg.description="Couldn't Map value\"" + value + "\" to DataItem \"" + this.id + "\" with type \"" + typeObject.typeString + "\"";

	throw errorMsg;	
}

/**
 * PUBLIC returns last value of the DataItem
 * 
 * @returns [DataItemValue] last value object
 */
DataItem.prototype.getCurrentValue = function(){
	return this.dataItemValueList[ this.dataItemValueList.length - 1 ];
};

/**
 * PUBLIC returns all saved (historical) values
 * 
 * @returns [Array of DataItemValues] all saved values
 */
DataItem.prototype.getAllValues = function(){
	return this.dataItemValue;
};

/**
 * PUBLIC 
 * 
 * @returns String representation of the object (for debugging purposes)
 */ 
DataItem.prototype.toString = function(){
	return "DataItem with ID: " + this.id;
};

/**
 * A DataItemValue is the memory for concrete values of a DataItem
 * 
 * @param value
 * 			[String] or [integer] value
 * @param timestamp
 * 			[Date] timestamp of the value
 * @param type
 * 			[String] describing the data type of the value (e.g. boolean, float, ...)
 * @param quality
 * 			quality of value
 */
function DataItemValue(value, type, timestamp, quality){
	this.value = value;
	this.timestamp = timestamp;
	this.type = type;
	this.quality = quality;
}