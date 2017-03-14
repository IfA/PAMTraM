function OpcUaItem(id, path) {
	this.id = id;
	this.path=path;
}
extend(OpcUaItem, ServerDataItem);

function DataVariable(id, path, type ) {
	this.id = id;
	this.path= path;
	this.type=type;
}
extend(DataVariable, OpcUaItem)

function Property(id, path, type) {
	this.id = id;
	this.path=path;
	this.type=type;
}
extend(Property, OpcUaItem)

function UaBaseDataType(typeStr) {
	this.typeStr=typeStr;
	this.isWriteable=false;
	this.isReadable=false;	
}

/**
 * PUBLIC checks if the node-Object's type (== Type defined on the OPC UA Server) 
 * fits the type that is defined for this Object
 * This function should be considered to be abstract.
 * @throws Error
 * @param data
 * 			Result returned by JSUA ReadNodes 
 * @param callback
 * 			[function] Function to be called when checkNodeType succeeds, if it fails an appropriate
 * 					   error will be thrown (at least in the functions that overwrite this one) 
 * @param context
 * 			[Object] Context to apply this function to
 */
UaBaseDataType.prototype.checkNodeType=function(data, callback, context){};

/**
 * PUBLIC
 * Returns the Variable's Value
 * This definition of getValue should be considered abstract. It will be overwritten by derived Objects' own definitions of this function.
 * 
 * @param type
 * 			[DataType] The type this Variable's Value should be mapped to
 * 
 * @returns Value in a format, that the ProcessModel's DataItem can map in a more general way.
 */
UaBaseDataType.prototype.getValue=function(type){};

/**
 * PUBLIC
 * Checks if the Node is Writable and if the Value is valid. Will thorw an Error otherwise.
 * This definition of getValue should be considered abstract. It will be overwritten by derived Objects own definitions of this function.
 * 
 * @throws Error 
 * @param value
 * 			[] The Value to be written
 * @param type
 * 			[DataType] The type the value should be mapped to
 * @returns [__opcres.builtInTypes.Variant] Value in a format that JSUA's ClientInterface can deal with
 */
UaBaseDataType.prototype.getWriteValue=function(value, type){};

/**
 *PUBLIC
 *Observer for monitoring value changes of a node
 *this was defined for debugging purposes only
 */
UaBaseDataType.prototype.ValueObserver=function()
{
	this.notify=function(node){
		console.log(node.browseName.name + ": " + node.value);
	}
}

function SimpleType(typeStr) {
	this.typeStr=typeStr;
	this.isWriteable=false;
	this.isReadable=false;	}
extend(SimpleType, UaBaseDataType)

/**
 * PUBLIC
 * See UaBaseDataType's definition of this function for a description.
 * @throws WrongTypeDefinitionException
 */
SimpleType.prototype.checkNodeType=function(data, callback, context)
{
	if("node" in  this )
	{ if(data.encodingMask !== __opcdef.idByDef(this.typeStr))
	{
		console.log("Node deleted")
		delete this.node;
	} else {
		//Everything is in order
		if (callback)
		{
			if (context) {
				callback.apply(context);
			}
			else {
				callback();
			}
		}
		return;
	}
	} else {
		console.log("No Node defined");
	}
	throw new __opcres.exceptions.WrongTypeDefinitionException("The modeled TypeDefinition ("  
			+ this.typeStr
			+") of this Variable doesn't match it's definition on the server("
			+ __opcdef.defById(data.encodingMask,true)
			+"): ");
}

function StringBased(typeStr) {
	this.typeStr=typeStr;
	this.isWriteable=false;
	this.isReadable=false;	
}
extend(StringBased, SimpleType)

/**
 * PUBLIC
 * See UaBaseDataType's definition of this function for a description.
 * @throws VariableNotReadableException
 * @throws WrongTypeDefinitionException
 */
StringBased.prototype.getValue=function(type)
{
	if(this.isReadable){
		if(type.typeString === "String") return this.node.value.toString();
		else throw new __opcres.exceptions.WrongTypeDefinitionException();
	} else throw new __opcres.exceptions.VariableNotReadableException();
}

/**
 * PUBLIC
 * See UaBaseDataType's definition of this function for a description.
 * @throws VariableNotWriteableException
 */
StringBased.prototype.getWriteValue=function(value, type)
{
	if(this.isWriteable) return value;
	else throw new __opcres.exceptions.VariableNotWriteableException();
}

function U_Int64(typeStr) {
	this.typeStr=typeStr;
	this.isWriteable=false;
	this.isReadable=false;	
}
extend(U_Int64, SimpleType)

/**
 * PUBLIC
 * See UaBaseDataType's definition of this function for a description.
 * @throws VariableNotReadableException
 * @throws WrongTypeDefinitionException
 */
U_Int64.prototype.getValue=function(type)
{
	if(this.isReadable){
		if(type.typeString === "String") return this.node.value.toString();
		else if(type.typeString === "Boolean"){
			return !(parseInt(this.node.value.toString()) === 0);
		} else throw new __opcres.exceptions.WrongTypeDefinitionException();
	} else throw new __opcres.exceptions.VariableNotReadableException();
}

/**
 * PUBLIC
 * See UaBaseDataType's definition of this function for a description.
 * @throws VariableNotWriteableException
 */
U_Int64.prototype.getWriteValue=function(value, type)
{
	if(this.isWriteable)
	{
		if(type.typeString === "Boolean"){
			return !(parseInt(value) == 0 || value.toLowerCase() === "false");
		} else return value;
	} else {
		throw new __opcres.exceptions.VariableNotWriteableException();
	}
}

function Enumeration(literals) {
	this.typeStr="Int32";
	this.literals=literals;
	this.isWriteable=false;
	this.isReadable=false;	
}
extend(Enumeration, SimpleType)

/**
 * PUBLIC
 * See UaBaseDataType's definition of this function for a description.
 *  @throws WrongTypeDefinitionException
 *  @throws VariableNotReadableException
 */
Enumeration.prototype.getValue=function(type)
{
	if(this.isReadable){
		if(this.node.value < this.literals.length)
		{
			switch(type.typeString)
			{
			case "String":
				return this.literals[this.node.value];
			case "Integer":
			case "Rational":
			case "Enumeration":
				return this.node.value;
			default: //this should've been prevented during transformation. Still, just to be safe..
				throw new __opcres.exceptions.WrongTypeDefinitionException();
			return;
			}	
		} else {
			throw new __opcres.exceptions.WrongTypeDefinitionException(
					"The Value of this Enum doesn't match it's definition:\nVal=" + this.node.value + "  Max. Length: " + this.literals.length);
		}
	} else throw new __opcres.exceptions.VariableNotReadableException();	
}

/**
 * TODO this Function is untested
 * PUBLIC
 * See UaBaseDataType's definition of this function for a description.
 * @throws VariableNotWriteableException
 * @throws CodomainException
 * @throws WrongInputTypeException
 */
Enumeration.prototype.getWriteValue=function(value, type){
	if(this.isWriteable)
	{
		var valueAsInt=parseInt(value);
		if(isNaN(valueAsInt)){
			var index;
			if(type.typeString === "String"){ //Map from TDP definition
				index=this.literals.indexOf(value);
			} else if(type.typeString === "Enumeration"){ //Map from AM Definition
				index=type.literalList.indexOf(value);	
			} else {
				throw new __opcres.exceptions.WrongInputTypeException('Entered string is not a valid literal for this enum.');  					
			}
			if(index > -1)
			{
				return index;
			} else {
				throw new __opcres.exceptions.CodomainException("Value is larger than max. allowed value for this enum.");
			}
		} else {
			if(valueAsInt < this.literals.length && valueAsInt >= 0){
				return valueAsInt;
			} else {
				throw new __opcres.exceptions.WrongInputTypeException('Entered string is not a valid literal for this enum.');   	 
			}	
		} 
	} else {
		throw new __opcres.exceptions.VariableNotWriteableException();
	}
}

/**
 * PUBLIC
 * See UaBaseDataType's definition of this function for a description.
 * @throws WrongTypeDefinitionException
 */
Enumeration.prototype.checkNodeType=function(data, callback, context)
{//TODO Das funktioniert nur, wenn die Enum-Werte "zusammen hängen", d.h. wenn sie bei 0 anfangen und dazwischen keine Lücken sind
//	anders wurde es nicht getestet
	var errorMessage="";

	if("node" in  this )
	{
		if(data.encodingMask === __opcdef.idByDef(this.typeStr))
		{
			__opcres.clientInterface.readNodes(//get DataType
					[this.node.nodeId],
					[14],function(results, task){ 
						__opcres.clientInterface.browseNodeId(results[0].value.value,
								this.node.view,
								false,
								function(results){
							for(i in results) //find EnumStrings
							{
								if(results[i].browseName.name === "EnumStrings") //get Value of EnumStrings
								{
									__opcres.clientInterface.readNodes([results[i].nodeId.nodeId], [13], function(results, task){
										var serverLiterals=results[0].value.value;
										if(serverLiterals.length === this.literals.length) //check if size of Literals Array matches
										{
											for(var i = 0; i < serverLiterals.length; i++)
											{
												if(serverLiterals[i].text !== this.literals[i])
												{
													delete this.node;
													throw new __opcres.exceptions.WrongTypeDefinitionException(
															"Enum Literals don't match: " + serverLiterals[i] + " (server) vs." + this.literals[i] + "(defined)");
													return;
												}
											}
											//Literals Matched
											if (callback)
											{
												if (context) {
													callback.apply(context);
												}
												else {
													callback();
												}
											}
										} else { 
											delete this.node;
											throw new __opcres.exceptions.WrongTypeDefinitionException("Enum Literals don't match.");
										}
									},this);
									return;
								}
							}
							delete this.node;
							throw new __opcres.exceptions.WrongTypeDefinitionException("The node found on the Server is not an Enum.");
						}, this);
					}, this);
			return;
		} else {
			errorMessage="Enum Value should be encoded as \"Int32\" but defined as \"" + __opcdef.defById(data.encodingMask, true) + "\" on the Server.";	
		}
	} else errorMessage="No Node defined";

	delete this.node;
	throw new __opcres.exceptions.WrongTypeDefinitionException(errorMessage);
}

function Structure(members) {
	this.typeStr="Structure";
	this.members=members;
	for(i in this.members){//these aren't important for submembers, but for writing to work, they need to be true
		this,members[i].isWriteable=true;
		this.members[i].isReadable=true;
	}
	this.isWriteable=false;
	this.isReadable=false;	
}
extend(Structure, UaBaseDataType)

/**
 * PUBLIC
 * See UaBaseDataType's definition of this function for a description.
 *  @throws WrongTypeDefinitionException
 */
Structure.prototype.checkNodeType= function(data, callback, context){
	if("node" in  this )
	{ 
		if(data.encodingMask === __opcdef.idByDef(this.typeStr))
		{ 
			if(typeof(data.value.body !== "undefined"))
			{
				if(this.checkMemberNames(data.value.body)){
					//Everything is in order
					if (callback)
					{
						if (context) {
							callback.apply(context);
						}
						else {
							callback();
						}
					}
					return;
				}
			}
		}
	} else console.log("No Node defined");
	console.log("Node deleted")
	delete this.node;
	throw new __opcres.exceptions.WrongTypeDefinitionException();
}
/**
 * PUBLIC
 * Checks Names of Strutcue's Members
 * 
 * This Function is used by checkNodeType.
 */
Structure.prototype.checkMemberNames=function(body)
{
	var success=true;
	for(i in this.members){
		if(typeof body[i] === "undefined" ) //only checks member's names, not member types
		{
			console.log("Node deleted");
			success=false;
			break;
		} else if(this.members[i].typeStr === "Structure"){
			if(!this.members[i].checkMemberNames(body[i])){
				success=false;
				break;
			}
		}
	}	
	return success;
}

/**
 * PUBLIC
 * See UaBaseDataType's definition of this function for a description.
 * @throws VariableNotReadableException
 * @throws WrongTypeDefinitionException
 */
Structure.prototype.getValue=function(type){
	if(this.isReadable){	
		switch(type.typeString)
		{
		case "Structure":
			var returnObject={};
			var val=this.node.value.body;
			for(i in this.members){
				if(typeof(type.memberList[i]) !== "undefined") returnObject[i]=[val[i]]; //only include val if it is defined in LDP structure
			}
			return returnObject;
			break;
		case "String":
			return JSON.stringify(this.node.value.body);
		default: //this should've been prevented during transformation. Still, just to be safe..
			throw new __opcres.exceptions.WrongTypeDefinitionException();
		return;
		break;
		}
	} else throw new __opcres.exceptions.VariableNotReadableException();
}

/**
 * TODO this Function is untested
 * PUBLIC
 * See UaBaseDataType's definition of this function for a description.
 * @throws VariableNotWriteableException
 * @throws SyntaxError (from JSON.parse)
 * @throws WrongInputTypeException
 */
Structure.prototype.getWriteValue=function(value, type){
	if(this.isWriteable)
	{	
		var val;
		var isString=false;
		if(type.typeString === "String" || type.typeString === "Structure"){
			if(type.typeString === "String"){
				val=JSON.parse(value.toString());
				isString=true;
			} else{ //SDP type is Structure
				//check if TDP type has any  members that aren't in LDP type
				for(i in this.members){
					if(typeof(type.memberList[i]) === "undefined")
						throw new __opcres.exceptions.VariableNotWriteableException("The Logical Datatype's definition doesn't contain all members needed to write to the TechnicalDataItem.");
				}		
				val=value;
			}		
			//create Write Object from identifier
			var typeIdentifierString=__opcdef.defById(this.node.value.typeId.nodeId.identifier, true).replace("_Encoding_DefaultBinary", "");
			var writeObject= new __opcct[typeIdentifierString];
			for(i in val)
			{
				if(typeof(this.members[i]) === "undefined" )//member exists in LDP value but not in TDP type
				{
					if(val[i].length !== 0){//member is not an empty List
							throw new __opcres.exceptions.WrongInputTypeException('The Value provided to be written to this Structure could not be mapped.');  	
					}
				} else if(typeof(val[i].length) === "undefined" && isString){
					writeObject[i]=this.members[i].getWriteValue(JSON.stringify(val[i]), type);						
				} else if(!isString && val[i].length === 1){
					writeObject[i]=this.members[i].getWriteValue(val[i][0], type.memberList[i]);
				} else {
					throw new __opcres.exceptions.WrongInputTypeException('The Value provided to be written to this Structure could not be mapped.');  						
				}
			}
			return new __opcbit.ExtensionObject(this.node.value.typeId, this.node.value.encoding,0 , writeObject);
		} else{
			throw new __opcres.exceptions.WrongInputTypeException('The Value provided to be written to this Structure could not be mapped.');  	
		}
	} else {
		throw new __opcres.exceptions.VariableNotWriteableException();
	}
}

function Boolean(){
	this.typeStr="Boolean";
	this.isWriteable=false;
	this.isReadable=false;	
}
extend(Boolean, SimpleType)

/**
 * PUBLIC
 * See UaBaseDataType's definition of this function for a description.
 * @throws VariableNotWriteableException
 */
Boolean.prototype.getWriteValue=function(value, type){
	if(this.isWriteable)
	{
		return !(parseInt(value) == 0 || value.toString().toLowerCase() === "false");
	} else {
		throw new __opcres.exceptions.VariableNotWriteableException();
	}
}

/**
 * PUBLIC
 * See UaBaseDataType's definition of this function for a description. 
 * @throws VariableNotReadableException
 * @throws WrongTypeDefinitionException
 */
Boolean.prototype.getValue=function(type)
{
	if(this.isReadable) {
		var value=!(this.node.value == 0);
		switch(type.typeString)
		{
			case "Boolean":
				return value;
			case "Integer":
			case "Rational":
				return value ? 1 : 0;
			case "String":
				return value ? "True" : "False";
			default: //this should've been prevented during transformation. Still, just to be safe..
				throw new __opcres.exceptions.WrongTypeDefinitionException();
			return;
		}
	} else throw new __opcres.exceptions.VariableNotReadableException();	
}

function XmlElement(){
	this.typeStr="XmlElement";
	this.isWriteable=false;
	this.isReadable=false;	
}
extend(XmlElement, StringBased)

/**
 * PUBLIC
 * See UaBaseDataType's definition of this function for a description.
 * @throws VariableNotWriteableException
 * @throws WrongTypeDefinitionException
 * @throws Error
 */
XmlElement.prototype.getWriteValue=function(value, type){
	if(this.isWriteable)
	{
		if(type.typeString === "String"){
			/*
			 * jQuery will throw an Error if the XML value isn't well-formed
			 */
			$.parseXML(value);
			return value;
		} else throw new __opcres.exceptions.WrongTypeDefinitionException();
	} else {
		throw new __opcres.exceptions.VariableNotWriteableException();
	}
}

function Integer(typeStr)
{
	this.typeStr=typeStr;
	this.isWriteable=false;
	this.isReadable=false;	
}
extend(Integer, SimpleType)

/**
 *PUBLIC
 * See UaBaseDataType's definition of this function for a description.
 * @throws WrongTypeDefinitionException
 * @throws VariableNotReadableException
 * 
 */
Integer.prototype.getValue= function(type){
	if(this.isReadable)	{
		switch(type.typeString)
		{
		case "Integer":
		case "Rational":			
			return parseInt(this.node.value);
		case "String":
			return this.node.value.toString();
		case "Boolean":
			return !(parseInt(this.node.value) === 0);
		default: //this should've been prevented during transformation. Still, just to be safe..
			throw new __opcres.exceptions.WrongTypeDefinitionException();
		return;
		}
	} else throw new __opcres.exceptions.VariableNotReadableException();
}

/**
 * PUBLIC
 * See UaBaseDataType's definition of this function for a description.
 * @throws VariableNotWriteableException
 */
Integer.prototype.getWriteValue=function(value, type)
{
	var returnVal;
	if(this.isWriteable)
	{
		if(type.typeString === "Boolean") return !(parseInt(value) == 0 || value.toLowerCase() === "false");
		else return value;
	} else {
		throw new __opcres.exceptions.VariableNotWriteableException();
	}
}

function Rational(typeStr)
{
	this.typeStr=typeStr;
	this.isWriteable=false;
	this.isReadable=false;	
}
extend(Rational, SimpleType)

/**
 * PUBLIC
 * See UaBaseDataType's definition of this function for a description.
 * @throws WrongTypeDefinitionException
 * @throws VariableNotReadableException
 */
Rational.prototype.getValue= function(type){
	if(this.isReadable)
	{
		switch(type.typeString)
		{
		case "Integer":
			return parseInt(this.node.value);			
		case "Rational":			
			return parseFloat(this.node.value);
		case "String":
			return this.node.value.toString();
		case "Boolean":
			return !(parseFloat(this.node.value) === 0);
		default: //this should've been prevented during transformation. Still, just to be safe..
			throw new __opcres.exceptions.WrongTypeDefinitionException();
		return;
		}
	} else throw new __opcres.exceptions.VariableNotReadableException();
}

/**
 * PUBLIC
 * See UaBaseDataType's definition of this function for a description.
 * @throws VariableNotWriteableException
 * @throws VariableNotReadableException 
 */
Rational.prototype.getWriteValue=function(value, type)
{
	var returnVal;
	if(this.isWriteable)
	{
		switch(type.typeString){
			case "Boolean":
				return !(parseInt(value) == 0 || value.toLowerCase() === "false");
			case "Integer":
				return parseInt(value);
			case "Rational":
				return parseFloat(value);
			default: //this should've been prevented during transformation. Still, just to be safe..
				throw new __opcres.exceptions.WrongTypeDefinitionException();
			return;
		}
	} else {
		throw new __opcres.exceptions.VariableNotWriteableException();
	}
}