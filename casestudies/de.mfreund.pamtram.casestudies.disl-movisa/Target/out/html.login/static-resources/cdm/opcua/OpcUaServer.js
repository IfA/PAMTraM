function ErrorPropagator(context)
{
	this.context=context;
	this.log = function(){
		console.log.apply(console,arguments);
		return this;
	}
	this.error= function(text){
		var errorMsg=new Error();
		errorMsg.name="JSUA Error";
		errorMsg.description=text.toString();
		console.error.apply(console,arguments);
		processController.propagateServerError(this.context, errorMsg);	
		return this;
	}
};

/**
 * PUBLIC
 * @throws ResourceNotFoundException
 */
function OpcUaServer(url, serverDataItemList) {
	this.url = url; // target service url for the messages
	this.serverDataItemList = serverDataItemList;
	this.serverSubscriptionList = new Array();
	this.initiated=false;
	this._subscripitionsAtInitiation=[];

	/*
	 * Check if all JSUA Ressources are loaded
	 */
	var error;
	try 
	{	
		this.opcres = new OPCResources(new ErrorPropagator(this)); //throws ResourceNotFoundException
		error=false;
	} catch (e) {
		this.propagateError(e);
	}

	/*
	 * retrieve Endpoints
	 * (based on OPCPerformanceTestDriver.js)
	 */
	if (!error) 
	{
		appendExceptions();
		this.opcres.connectionManager.retrieveEndpoints(function(){
			var endpoint = null;
			var endpoints = this.opcres.connectionManager.endpoints;
			for(var i=0; i<endpoints.length; i++){
				if(endpoints[i].endpointUrl.indexOf(window.location.protocol) == 0) { 
					endpoint = endpoints[i];
					break;
				}
			}

			if(endpoint == null){
				error=new Error();
				error.description="No matching endpoint found!";
				error.name="EndpointNotFoundException";
				processController.propagateServerError(this, error);
				return;
			}
			console.log("Connecting to " + endpoint.endpointUrl);
			this.opcres.connectionManager.connectToEndpoint(i, function(){
				this.opcres.adressSpaceManager.buildRootNode(function()
						{							
					this.__findNodes.apply(this,[this.__doNodeCheck,this]);
						}, this);
			}, this);			
		},this);

	}	
};
extend(OpcUaServer, Server)

	/**
	 * PRIVATE
	 * @param 
	 * @throws VariableNotFoundOnServerException
	 */
	OpcUaServer.prototype.__findNodesOld=function(callback, context){
		function findNode(depth, item, node, callback, context){			
			function searchInNode(depth, item, node, callback, context){
				if(node.childNodes.length < 1)
				{
					//findNode(depth,item,node,callback,context); //this is either an error, or the final node
					findNode.apply(this,[depth, item,node,callback,context]);
					return;
				} else {
					var searchName=item.path[depth];
					var found=false;
					var foundNode;
					for( i in node.childNodes)
					{
						if(node.childNodes[i].browseName.name === searchName){
							if(found){//ambiguous path TODO untested
								this.propagateError(
										new this.opcres.exceptions.VariableNotFoundOnServerException("It appears like this Variable's BrowsePath is ambiguous at\"" + node.browseName.name +"\": " + item.path.join("/")));
								callback.apply(context);
								return;
							} else {
								found=true;
								foundNode=node.childNodes[i];
							}
						}
					}
					if(found){
						findNode.apply(this,[++depth, item, foundNode, callback, context]); //move further down the tree
						return;
					}
					// this is an error, we should never get here
					this.propagateError(new this.opcres.exceptions.VariableNotFoundOnServerException("It appears like this Variable doesn't exist: " + item.path.join("/")));
					callback.apply(context);
					return;
				}
			}
		
			if(depth === item.path.length){
				if(node.browseName.name === item.path[depth-1]) //TODO could this in any way be dangerous? What happens if path has length 1
				{
					nodesFound=nodesFound+1;
					console.log("Node found for " + item.id);
					item.type.node=node;
				} else { 
					// this is an error, we should never get here
					this.propagateError(new this.opcres.exceptions.VariableNotFoundOnServerException("It appears like this Variable doesn't exist: " + item.path.join("/")));
				}
				callback.apply(context);
				return;
			} else if(node.childNodes.length < 1) //note, that we will not rebrowse if a level has already been browsed
			{
				browseRequests=browseRequests+1;
				node.browse(function(){
					
					searchInNode.apply(this,[depth, item, node, callback, context]);
				},this, false); 
			}else {
				searchInNode.apply(this,[depth, item, node, callback, context]);
			}
		}
		function browseNextItem(index, callback, context){
				var maxIndex=this.serverDataItemList.length;
				if(index === maxIndex)
				{
					var endTime=new Date()-startTime;
					console.log("############\nFound " + nodesFound + " unique Nodes using " + browseRequests + " \"Browse\"-Requests in " + endTime.toString() + "ms.")
					
					//all items scanned
					if(callback) callback.apply(context);
					return;
				} else {
					this.opcres.terminal.log(context.serverDataItemList[index].id);
					findNode.apply(this,[0, context.serverDataItemList[index], this.opcres.adressSpaceManager.opctree, function(){
						browseNextItem.apply(this,[++index, callback, context]);
					}, this]);
				}
			}
		var nodesFound=0;
		var browseRequests=0;
		var startTime=new Date();
			browseNextItem.apply(this,[0, callback, context]);
};
	

/**
 * PRIVATE
 * @param 
 * @throws VariableNotFoundOnServerException
 */
OpcUaServer.prototype.__findNodes=function(callback, context)
{
	//for Statistics message
	var startTime=new Date();
	var nodesFound=0;
	var browseRequests=1; //1 for Root BRowse Requests
	function browseNextFolders(callback, context)
	{   		
		var idsToBrowse=[];
		newCurrentFolders=[];
		for(k in currentFolders)
		{
			//find nodes			
			var currentFolder=currentFolders[k].folder;
			var currentNode=currentFolders[k].node;
			for(i in currentFolder.nodes)
			{
				for(var j=0; j< currentNode.childNodes.length; j++){
					if(currentNode.childNodes[j].browseName.name === i)
					{
						if(typeof(currentFolder.nodes[i][0].type.node) !== "undefined"){ //ambiguous path
							for(l in currentFolder.nodes[i]){
								this.propagateError(
										new this.opcres.exceptions.VariableNotFoundOnServerException(
												"It appears like this Variable's BrowsePath is ambiguous at \"" 
												+ currentNode.childNodes[j].browseName.name +"\": " 
												+ currentFolder.nodes[i][l].path.join("/")));
								delete currentFolder.nodes[i][l].type.node;
							}
							delete currentFolder.nodes[i];
						} else {
							nodesFound++;
							for(l in currentFolder.nodes[i]){
								currentFolder.nodes[i][l].type.node=currentNode.childNodes[j];
							}
						}
					}
				}
			}
			//prepare next request			
			for(l in currentFolders[k].folder.folders)
			{
				var found=false;
				var num;
				for(var j=0; j< currentNode.childNodes.length; j++){
					if(currentNode.childNodes[j].browseName.name === l){
						idsToBrowse.push(currentNode.childNodes[j].nodeId);
						newCurrentFolders.push(
								{"folder": currentFolder.folders[l],
									"node": currentNode.childNodes[j]
								});
					}			
				}
			}
		}
		//now check if we are done
		currentFolders=newCurrentFolders;
		if(currentFolders.length === 0)//browse done
		{
			var endTime=new Date()-startTime;
			//Staticstics
			console.log("############\nFound " + nodesFound + " unique Nodes using " + browseRequests + " \"Browse\"-Requests in " + endTime.toString() + "ms.")
			
			for(i in this.serverDataItemList){
				if(typeof(this.serverDataItemList[i].type.node) === "undefined"){
					this.propagateError(new this.opcres.exceptions.VariableNotFoundOnServerException("It appears like this Variable doesn't exist: " + this.serverDataItemList[i].path.join("/")));
				}
			}
			if (callback)
			{
				if (context) {
					callback.apply(context);
				}
				else {
					callback();
				}
			}
		} else {//browse next level
			browseRequests++;
			browseFolders.apply(this, [idsToBrowse, callback, context]);
		}
	}

	function browseFolders(idsToBrowse, callback, context)
	{
		this.opcres.clientInterface.browseNodeIds(
				idsToBrowse, 
				this.opcres.adressSpaceManager.opctree.view, 
				false, 
				function(results){
					for(var i=0; i< results.length; i++){
						var node=newCurrentFolders[i].node;
						var childnodes=results[i].references;
						//copied from TreeNode.browse
						node.isBrowsed = true;
						node.childNodes = [];
						for (var j in childnodes)
						{
							if (j == "has") 
								continue;
							node.childNodes.push(
									new __opctn.TreeNode(childnodes[j].nodeId.nodeId,node.view,
											{
										browseName:childnodes[j].browseName,
										displayName:childnodes[j].displayName,
										nodeClass:childnodes[j].nodeClass,
										referenceTypeId:childnodes[j].referenceTypeId,
										typeDefinition:childnodes[j].typeDefinition
											})
							);
							node.childNodes[node.childNodes.length-1].parentNode = node;
						}
						//copy end
					}
					browseNextFolders.apply(this, [callback, context]);
				},
				this);
	};
	/*
	 * root
	 * |-nodes
	 * |  |-node1
	 * |-folders
	 * 		|-parentNode
	 * 		|-folder1
	 * 			|-parentNode
	 * 			|-nodes
	 * 			|-folder1
	 */
	var searchStructure={"nodes" : [], "folders": {}};
	for(i in this.serverDataItemList){
		var item=this.serverDataItemList[i];
		var currentFolder=searchStructure;
		for(var j=0; j< item.path.length-1; j++){
			if(typeof(currentFolder.folders[item.path[j]]) === "undefined"){
				currentFolder.folders[item.path[j]]={"nodes" : [], "folders" : {}};
			}
			currentFolder=currentFolder.folders[item.path[j]];
		}
		if(typeof(currentFolder.nodes[item.path[item.path.length-1]]) === "undefined"){
			currentFolder.nodes[item.path[item.path.length-1]]=[]; //there could be more than one item defined for the same server variable
		}
		currentFolder.nodes[item.path[item.path.length-1]].push(item);
	}
	/*
	 * alright we built our structure
	 * Now we start browsing level by level
	 */
	var currentFolders=[{"folder":  searchStructure  , "node" :  this.opcres.adressSpaceManager.opctree}];
	var newCurrentFolders=[];
	this.opcres.adressSpaceManager.opctree.browse(function(){	
		browseNextFolders.apply(this, [callback, context]);
	},this);
};

/***
 * PRIVATE
 */
OpcUaServer.prototype.__doNodeCheck=function(){
	var nodesToRead= {};
	nodesToRead.items=new Array()
	nodesToRead.nodeIds=new Array();
	nodesToRead.attrIds= new Array();

	for( item in this.serverDataItemList){
		if("node" in this.serverDataItemList[item].type)
		{
			nodesToRead.nodeIds.push(this.serverDataItemList[item].type.node.nodeId);
			nodesToRead.nodeIds.push(this.serverDataItemList[item].type.node.nodeId);

			nodesToRead.items.push(this.serverDataItemList[item]);

			nodesToRead.attrIds.push(13); //13 == Value
			nodesToRead.attrIds.push(18);//18 == User Access Level	
		}
	}

	this.opcres.clientInterface.readNodes(
			nodesToRead.nodeIds, 
			nodesToRead.attrIds, 
			function(results, task){
				function checkNodeCheckDone(){
					nodesToRead.remainingNodesToRead--;
					if(nodesToRead.remainingNodesToRead === 0)
					{
						var endTime=new Date().getTime();
						var duration=endTime - startCheckTime;
						console.log("NodeType-Check took: " + duration+"ms.\n############");
						this.__activateSubscriptions();
					}
				}

				nodesToRead.readResult=results;
				nodesToRead.remainingNodesToRead=nodesToRead.items.length;
				var startCheckTime = new Date().getTime();
				for(var i=0; i < nodesToRead.items.length; i++)
				{
					var type=nodesToRead.items[i].type;
					var value=nodesToRead.readResult[2*i].value;
					var writeableVal=nodesToRead.readResult[2*i+1];
					var mask=writeableVal.value.value;
					try{
						if(mask & 3) //val writeable  and/or readable ?
						{
							if(mask & 2) type.isWriteable=true;
							if(mask & 1) type.isReadable=true;
							type.checkNodeType(value,checkNodeCheckDone,this);
						} else {//not readable or writeable
							delete type.node;
							nodesToRead.remainingNodesToRead--;
							throw new this.opcres.exceptions.VariableNotAccessableException();
						}
						type.node.updateData(value.value);
					} catch (e) {
						if(e instanceof  __opcres.exceptions.VariableNotAccessableException){
							e.message="This value can't be read or written to: " + nodesToRead.items[i].path.join("/");
						} else if(e instanceof  __opcres.exceptions.WrongTypeDefinitionException) {
							e.message=e.message + " " + nodesToRead.items[i].path.join("/");
						}
						this.propagateError(e);
					}
				}
			}, 
			this);		
};

/**
 * PRIVATE
 */
OpcUaServer.prototype.__activateSubscriptions=function()
{
	this.initiated=true; //finally
	//all types checked, now try to activate any subscriptions we might have at this point (and for which a 
	//subscribe action possibly failed earlier)
	for ( i in this._subscripitionsAtInitiation )
	{
		this.subscribe(this._subscripitionsAtInitiation[i]);
	}	
	delete this._subscripitionsAtInitiation;//we don't need this anymore
};


/**
 * PRIVATE Error Handler
 * @param exception Object [as defined in ProcessController.js]
 */
OpcUaServer.prototype.propagateError = function(exception) {
	var errorMsg=new Error();
	errorMsg.name=exception.name;
	errorMsg.description=exception.toString();

	processController.propagateServerError(this, errorMsg);	
};

/**
 * PUBLIC Executes a read-operation on an OPC UA-Server
 * @param readItemList
 *            [Array] of [ReadItem]
 */
OpcUaServer.prototype.read = function(readItemList) {
	var nodesToRead={};
	nodesToRead.readItems=[];
	nodesToRead.nodeIds=[];
	nodesToRead.attrIds=[];
	for(var i=0; i< readItemList.length; i++)
	{
		if(typeof(readItemList[i].serverDataItem.type.node) === "undefined"){
			this.propagateError(new this.opcres.exceptions.VariableNotFoundOnServerException(
					"Read Failed. It appears like the Server node for this Variable doesn't exist: " 
					+  readItemList[i].dataItem.id));
		} else if(readItemList[i].serverDataItem.type.isReadable){
			nodesToRead.nodeIds.push(readItemList[i].serverDataItem.type.node.nodeId);
			nodesToRead.attrIds.push(13); //Value
			nodesToRead.readItems.push(readItemList[i]);
		} else {
			this.propagateError(
					new this.opcres.exceptions.VariableNotReadableException("You may not read this value: : "
							+  readItemList[i].dataItem.id));			
		}
	}
	if(nodesToRead.readItems.length === 0) return; //Nothing more to do here

	this.opcres.clientInterface.readNodes(
			nodesToRead.nodeIds,
			nodesToRead.attrIds,function(results, task){
				var responseItemList=new Array();
				for(var i=0; i < nodesToRead.readItems.length; i++)
				{
					var dataItem=nodesToRead.readItems[i].dataItem;
					dataItem.source.type.node.updateData(results[i].value.value);
					var value=new DataItemValue(dataItem.source.type.getValue(dataTypeList[dataItem.type]), 
							dataItem.source.type.typeStr , 
							this.opcres.utils.dateTime2Date(results[i].serverTimestamp), 100);
					responseItemList.push(new ResponseItem("read",dataItem.id, value));		
				}
				processController.propagateServerResponse(this,responseItemList);
			}, this);
};

/**
 * PUBLIC Executes a write-operation on an OPC UA-Server
 * 
 * @param writeItemList
 * 			[Array] of [WriteItem]
 */
OpcUaServer.prototype.write = function(writeItemList){
	var jsuaWriteItems={};
	jsuaWriteItems.nodeIds=new Array();
	jsuaWriteItems.attributeIds=new Array();
	jsuaWriteItems.values=new Array();

	for(i in writeItemList)
	{
		var writeItem=writeItemList[i];
		if(typeof(writeItem.getServerDataItem().type.node) === "undefined")
		{
			this.propagateError(new this.opcres.exceptions.VariableNotFoundOnServerException(
					"Write Failed. It appears like the Server node for this Variable doesn't exist: " 
					+  writeItem.dataItem.id));
		} else {
			try{
				var value=writeItem.getServerDataItem().type.getWriteValue(writeItem.dataItemValue.value,dataTypeList[writeItem.dataItem.type]);
				value=new __opcres.builtInTypes.Variant(__opcdef.idByDef(writeItem.getServerDataItem().type.typeStr), 0, value);
				jsuaWriteItems.nodeIds.push(writeItem.getServerDataItem().type.node.nodeId);
				jsuaWriteItems.attributeIds.push(13);
				jsuaWriteItems.values.push(new this.opcres.builtInTypes.DataValue(1, value));

			} catch (e) {
				e.message = e.message + " " + writeItem.dataItem.id;
				this.propagateError(e);
			}
		}
	}
	if(jsuaWriteItems.nodeIds.length > 0){
		this.opcres.clientInterface.writeNodes(
				jsuaWriteItems.nodeIds,jsuaWriteItems.attributeIds,jsuaWriteItems.values,
				/*
				function(results,task){
				  console.log("write callback: ");
				  console.log(results);
				  console.log(task);

				},this*/
				null
		);
	}
};

/**
 * PUBLIC Executes a subscribe-operation on an OPC UA-Server
 * 
 * @param subscription
 * 			[ServerSubscription] or [String] of the subscription ID
 */
OpcUaServer.prototype.subscribe = function(subscription) {
	if(!this.initiated){
		this._subscripitionsAtInitiation.push(subscription);
		return; //Subscription will be started after initiation, when all nodes were retrieved
	}
	//get the subscription if the argument is the subscription ID as String
	if(typeof subscription == "string"){
		subscription = this.getServerSubscriptionById(subscription);
	}
	/*
	 * Start monitoring
	 */
	var monitoredItems=subscription.monitoredItemList;
	//first check if a node Object exists for all items to be subscribed
	for(i in monitoredItems)
	{
		var item=monitoredItems[i].dataItem.source.type;
		if(typeof(item.node) === "undefined")
		{
			this.propagateError(new this.opcres.exceptions.VariableNotFoundOnServerException("UA subscribe: No server node defined this one: " + monitoredItems[i].dataItem.id));	    	
			return;
		}
		if(!item.isReadable){
			this.propagateError(new this.opcres.exceptions.VariableNotReadableException("Can't start Subscription, because Variable is not readable: " + monitoredItems[i].dataItem.id));
			return;
		}
	}
	//var numItems=monitoredItems.length;
	
	var nodeIdArray = new Array();
	var idArray = new Array();
	for(i in monitoredItems) {
		var item=monitoredItems[i].dataItem.source.type;
		nodeIdArray.push(item.node.nodeId);
		idArray.push(item.node.id);
	}
	//start monitoring
	__opcclism.startMonitoring(
		nodeIdArray,
		idArray,
		function(results, task){
			if(task.status !== "recieved"){//error
				processController.handlePolledRefresh(this, subscription.id, "error");
			} else {
				subscription.active=true;
				processController.handlePolledRefresh(this, subscription.id, "success");
			}
		},
		this
	);
};

/**
 * PUBLIC Requests a polled refresh from an OPC UA-Server
 * 
 * @param subscription
 * 			[ServerSubscription] or [String] of the subscription ID
 */
OpcUaServer.prototype.getPolledRefresh = function(subscription){	
	//get the subscription if the argument is the subscription ID as String
	if(typeof subscription == "string"){
		subscription = this.getServerSubscriptionById(subscription);
	}
	if(subscription.active == true){
		var responseItemList=new Array();
		var monitoredItems=subscription.monitoredItemList;

		for(i in monitoredItems)
		{
			var dataItem=monitoredItems[i].dataItem;
			if(dataItem.source.type.node.isMonitored){//check if Monitoring failed
				try{
					var value=new DataItemValue(dataItem.source.type.getValue(dataTypeList[dataItem.type]),
							dataItem.source.type.typeStr , 
							new Date(), 
							100);//TODO Zeit aus node auslesen, falls das mal gehen sollte
					responseItemList.push(new ResponseItem("subscribe",dataItem.id, value));
				} catch(e) {
					this.propagateError(e);
				}
			}
		}	
		if(responseItemList.length === monitoredItems.length){
			processController.propagateServerResponse(this, responseItemList);
			processController.handlePolledRefresh(this, subscription.id, "success");
		} else {
			processController.handlePolledRefresh(this, subscription.id, "error");
		}
	}
};

OpcUaServer.prototype.cancelSubscription = function(subscription){
	//get the subscription if the argument is the subscription ID as String
	if(typeof subscription == "string"){
		subscription = this.getServerSubscriptionById(subscription);
	}
	if(subscription.active){
		//set the ServerSubscription inactive
		subscription.active = false;
		/*
		 * Stop monitoring
		 */
		var monitoredItems=subscription.monitoredItemList;

		for(i in monitoredItems)
		{
			var item=monitoredItems[i].dataItem.source.type;
			if(item.node.isMonitored){
				//stop monitoring
				__opcclism.stopMonitoring(
						item.node.monitoredItemId,
						item.node.id,
						null);
			}
		}
	}
};