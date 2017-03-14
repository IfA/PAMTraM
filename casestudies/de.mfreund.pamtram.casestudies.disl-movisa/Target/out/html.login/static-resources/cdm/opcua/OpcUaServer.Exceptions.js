function appendExceptions()
{
	/*
	 * From here by Sascha Steffen
	 * The following exception types are only used in 
	 * the integration for Movisa's HTML-Transformation 
	 */
	 OPCExceptions.prototype.VariableNotFoundOnServerException = function(msg) {
		this.name ="VariableNotFoundOnServerException";
		this.message = typeof msg === "string" ? msg : "It appears like this Variable doesn't exist.";

		this.toString = function()
		{
			return this.name + ": " + this.message;
		};	
	}
	
	OPCExceptions.prototype.VariableNotWriteableException = function(msg)
	{
		this.name ="VariableNotWriteableException";
		this.message = typeof msg === "string" ? msg : "This value is read-only.";

		this.toString = function()
		{
			return this.name + ": " + this.message;
		};			
	}

	OPCExceptions.prototype.VariableNotReadableException = function(msg)
	{
		this.name ="VariableNotReadableException";
		this.message = typeof msg === "string" ? msg : "This value can't be read.";

		this.toString = function()
		{
			return this.name + ": " + this.message;
		};			
	}
	
	OPCExceptions.prototype.VariableNotAccessableException = function(msg)
	{
		this.name ="VariableNotAccessableException";
		this.message = typeof msg === "string" ? msg : "This value can't be read or written to.";

		this.toString = function()
		{
			return this.name + ": " + this.message;
		};			
	}
	
	
	OPCExceptions.prototype.WrongTypeDefinitionException = function(msg)
	{
		this.name ="WrongTypeDefinitionException";
		this.message = typeof msg === "string" ? msg : "The modeled TypeDefinition of this Variable doesn't match it's definition on the server.";

		this.toString = function()
		{
			return this.name + ": " + this.message;
		};	
	}
}