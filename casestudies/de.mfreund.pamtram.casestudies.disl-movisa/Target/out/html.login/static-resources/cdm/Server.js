function Server() {
	this.id;
	this.url = url;
	this.serverDataItemList = new Array();
	this.serverSubscriptionList;
}

Server.prototype.id;
Server.prototype.serverDataItemList;
Server.prototype.serverSubscriptionList;

Server.prototype.getServerSubscriptionList = function(){
	return this.serverSubscriptionList;
};

Server.prototype.read = function() {

};

Server.prototype.write = function() {

};

Server.prototype.subscribe = function() {

};

Server.prototype.getPolledRefresh =  function(){
	
};

Server.prototype.startPolledRefresh = function(){
	
};

/**
 * PUBLIC add a ServerDataItem to the Server
 * Function does NOT check if items are already included
 * 
 * @param serverDataItemList
 */
Server.prototype.addServerDataItem = function(serverDataItem){
	this.serverDataItemList.push(serverDataItem);
};

/**
 * PUBLIC add a Array of ServerDataItems to the Server
 * Function does NOT check if items are already included
 * 
 * @param serverDataItemList
 */
Server.prototype.addServerDataItemList = function(serverDataItemList){
	this.serverDataItemList.concat(serverDataItemList);
};

/**
 * PUBLIC Add a ServerSubscription to a Server
 * 
 * @param subscription
 * 			[ServerSubscription]
 */
Server.prototype.addServerSubscription = function(subscription){
	this.serverSubscriptionList.push(subscription);
};

/**
 * PUBLIC finds a ServerSubscription in the Server by its ID
 * 
 * @param subscribtionId
 * 			[String] ID of the subscription
 * @returns [Subscription]
 */
Server.prototype.getServerSubscriptionById = function(subscribtionId){
	var serverSubscriptionList = this.getServerSubscriptionList();
	
	for(var i = 0; i< serverSubscriptionList.length; i++){
		if(serverSubscriptionList[i].id == subscribtionId){
			return serverSubscriptionList[i];
		}
	}
};

/**
 * PUBLIC splits a Array of ServerDataItems by server allocation
 * 
 * @param itemList
 * @returns [Object] obj
 * 			[Array] of [ServerDataItem] obj.contained
 * 			[Array] of [ServerDataItem] obj.notContained
 * 			if a Server contains the ServerDataItem it gets sorted
 * 			in the Array contained, otherwise in notContained
 */
Server.prototype.splitItemListByServerAllocation = function(itemList) {
	var containedItems = new Array();
	var notContainedItems = new Array();

	for ( var i = 0; i < itemList.length; i++) {
		if (this.containsServerDataItem(itemList[i].getServerDataItem())) {
			containedItems.push(itemList[i]);
		} else {
			notContainedItems.push(itemList[i]);
		}
	}
	
	return {"contained": containedItems, "notContained": notContainedItems};
};

/**
 * PUBLIC check if Server contains a specific ServerDataItem. Decision is made
 * by ServerDataItem.Id equivalence
 * 
 * @param serverDataItem
 *            [ServerDataItem]
 * @returns true: server does contain the item
 * @returns false: server doesn't contain the item
 */
Server.prototype.containsServerDataItem = function(serverDataItem) {
	for ( var i = 0; i < this.serverDataItemList.length; i++) {
		if (this.serverDataItemList[i].id == serverDataItem.id) {
			return true;
		}
	}
	
	return false;
};

function ServerDataItem(id) {
	this.id = id;
}

ServerDataItem.prototype.id;

function ReadItem(dataItem, serverDataItem) {
	this.dataItem = dataItem;
	this.serverDataItem = serverDataItem;
	
	this.getServerDataItem = function(){
		return this.serverDataItem;
	};
}

function ResponseItem(type, dataItemId, dataItemValue) {
	this.type = type;
	this.dataItemId = dataItemId;
	this.dataItemValue = dataItemValue;
}

function WriteItem(dataItem, serverDataItem, dataItemValue) {
	this.dataItem = dataItem;
	this.serverDataItem = serverDataItem;
	this.dataItemValue = dataItemValue;
	
	this.getServerDataItem = function(){
		return this.serverDataItem;
	};
}

/**
 * A Subscription allows to subscribe to a list of MonitoredItems,
 * which may concern different servers
 * 
 * @param id
 * 			[String]
 * @param monitoredItemList
 * 			[Array] of [MonitoredItems]
 * @param publishingInterval
 * 			[String] or [integer]
 */
function Subscription(id, monitoredItemList, publishingInterval){
	this.id = id;
	this.monitoredItemList = monitoredItemList;
	this.publishingInterval = publishingInterval;
	this.relatedServerList = new Array();
	this.active = false;
	
	this.addRelatedServer = function(server){
		this.relatedServerList.push(server);
	};
}

Subscription.prototype.id;
Subscription.prototype.monitoredItemList;
Subscription.prototype.publishingInterval;

/**
 * A ServerSubscription holds the MonitoredItems of a Subscription
 * allocated to a Server
 * 
 * @param id
 * 			[String]
 * @param server
 * 			[Server]
 * @param monitoredItemList
 * 			[Array] of [MonitoredItems]
 * @param publishingInterval
 * 			[String] or [integer]
 */
function ServerSubscription(id, server, monitoredItemList, publishingInterval){
	this.id = id;
	this.server = server;
	this.monitoredItemList = monitoredItemList;
	this.publishingInterval = publishingInterval;
	this.active = false;
	this.serverHandle = null;
	this.waitTime = 5000;
	this.holdTimePeriod = 600;
	this.lastResponseTime = null;
}

extend(ServerSubscription, Subscription);

/**
 * A MonitoredItem is a container for subscription items
 * 
 * @param dataItem
 * 			[DataItem] to monitor
 * @param samplingRate
 * 			[String] or [integer]
 * @param deadBand
 * 			[String] or [integer]
 */
function MonitoredItem(dataItem, samplingRate, deadBand){
	this.dataItem = dataItem;
	this.samplingRate = samplingRate;
	this.deadBand = deadBand;
	this.enableBuffering = false;
	
	this.getServerDataItem = function(){
		return this.dataItem.source;
	};
}