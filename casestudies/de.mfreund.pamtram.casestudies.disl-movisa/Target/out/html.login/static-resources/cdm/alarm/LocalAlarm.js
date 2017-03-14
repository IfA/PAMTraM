function LocalAlarm(id,priority,description,helpText) {
	// Attribute: Priority
	//
	var priority;
	this.setPriority = function(newVal) {
		this.priority = newVal;
	}
	this.getPriority = function() {
		return this.priority;
	}
	
	// Attribute: Id = Name
	//
	var id;
	this.setId = function(newVal) {
		this.id = newVal;
	}
	this.getId = function() {
		return this.id;
	}
	
	// Attribute: Description
	//
	var description;
	this.setDescription = function(newVal) {
		this.description = newVal;
	}
	this.getDescription = function() {
		return this.description;
	}
	
	// Attribute: HelpText
	//
	var helpText;
	this.setHelpText = function(newVal) {
		this.helpText = newVal;
	}
	this.getHelpText = function() {
		return this.helpText;
	}
	
	// Attribute: HH AlarmBehavior
	//
	var hhBehavior = null;
	this.setHHBehavior = function(newVal) {
		this.hhBehavior = newVal;
		this.hhBehavior.setIsHighLimit(true);
	}
	this.getHHBehavior = function() {
		return this.hhBehavior;
	}
	
	// Attribute: H AlarmBehavior
	//
	var hBehavior = null;
	this.setHBehavior = function(newVal) {
		this.hBehavior = newVal;
		this.hBehavior.setIsHighLimit(true);
	}
	this.getHBehavior = function() {
		return this.hBehavior;
	}
	
	// Attribute: L AlarmBehavior
	//
	var lBehavior = null;
	this.setLBehavior = function(newVal) {
		this.lBehavior = newVal;
		this.lBehavior.setIsHighLimit(false);
	}
	this.getLBehavior = function() {
		return this.lBehavior;
	}
	
	// Attribute: LL AlarmBehavior
	//
	var llBehavior = null;
	this.setLLBehavior = function(newVal) {
		this.llBehavior = newVal;
		this.llBehavior.setIsHighLimit(false);
	}
	this.getLLBehavior = function() {
		return this.llBehavior;
	}
	
	eventBus.subscribe(this, AlarmAcknowledgeSignal);
	
	this.setId(id);
	this.setPriority(priority);
	this.setDescription(description);
	this.setHelpText(helpText);
	this.SignalsOnHHList = new Array();
	this.SignalsOnHList = new Array();
	this.SignalsOnLList = new Array();
	this.SignalsOnLLList = new Array();
	this.StateList = new Array();
	this.NotificationClassList = new Array();
}
$.extend(true,LocalAlarm, Alarm);
extend(LocalAlarm, EventSubscriber);//Checkme

LocalAlarm.prototype.addHHSignal = function(signal){
	this.SignalsOnHHList.push(signal);
};
LocalAlarm.prototype.addHSignal = function(signal){
	this.SignalsOnHList.push(signal);
};
LocalAlarm.prototype.addLSignal = function(signal){
	this.SignalsOnLList.push(signal);
};
LocalAlarm.prototype.addLLSignal = function(signal){
	this.SignalsOnLLList.push(signal);
};
LocalAlarm.prototype.addNotificationClass = function(clazz){
	this.NotificationClassList.push(clazz);
};

//event = AlarmBehaviorSignal
LocalAlarm.prototype.handleAlarm = function(event,type){
	console.log("Handle "+type+" LocalAlarm");
	var SignalsOnList;
	switch(type)
	{
		case "HH":
		  SignalsOnList = this.SignalsOnHHList;
		  break;
		case "H":
		  SignalsOnList = this.SignalsOnHList;
		  break;
		case "L":
		  SignalsOnList = this.SignalsOnLList;
		  break;
		case "LL":
		  SignalsOnList = this.SignalsOnLLList;
		  break;
		default:
		  //Wahaa this is not good!!
	}
	$.each(SignalsOnList, function(index,value) { 
		console.log("publishing Siganl '"+value.constructor.name+ "' on eventbus");
		eventBus.fireEvent(value,null);
	});
	var id = this.StateList.length;
	if(event.IsActive) {//If active, than add new State to list and set the "old" one to inactive
		this.StateList.push(new AlarmState(id,event.ValueOnAlarm,type));
		//send signal with StateList[id]
		this.sendSignal(new AlarmStateChangedSignal(this.getId(),this.StateList[id]));
		if(id >0 && this.StateList[id-1].Active) { // if there's an old state set inactive and sende signal
			this.StateList[id-1].Active = false;
			this.sendSignal(new AlarmStateChangedSignal(this.getId(),this.StateList[id-1]));
		}
	}
	else{
		if(id>0 && this.StateList[id-1].Type == type){
			this.StateList[id-1].Active = false;
			//send changed State over EventBus
			this.sendSignal(new AlarmStateChangedSignal(this.getId(),this.StateList[id-1]));
		}
	}
	

}

LocalAlarm.prototype.sendSignal = function(signal){
	$.each(this.NotificationClassList, function(index,value) { 
		value.fireEvents(signal);
	});
}

//event = AlarmAcknowledgeSignal
LocalAlarm.prototype.handleEvent = function(event){
	//do something with the acknowledge
	if(event.constructor.name == AlarmAcknowledgeSignal.name && this.getId() == event.getAlarmName())
	{
		var sid = event.getAlarmStateId();
		if(sid >= 0 && sid < this.StateList.length) {
			if(!this.StateList[sid].Acknowledged) {
				this.StateList[sid].Acknowledged = true;
				this.sendSignal(new AlarmStateChangedSignal(this.getId(),this.StateList[sid]));
			}
		}
	}
}

/**
 * PUBLIC handles events send over AlarmBus
 * 
 * @param event
 * 			[AlarmBehaviorSignal] wich was send via braodcast
 */
LocalAlarm.prototype.handleAlarmBehaviorEvent = function(event){
	console.log("Alarm "+this.getId()+ "received AlarmBehavior Event '" + event.AlarmBehaviorName + "'.");	
	if(this.getHHBehavior() != null)
	{
		if(event.AlarmBehaviorName ==  this.getHHBehavior().getName()){
			console.log("Alarm HH detected!");
			this.handleAlarm(event,"HH");
		}
	}
	if(this.getHBehavior() != null)
	{
		if(event.AlarmBehaviorName ==  this.getHBehavior().getName()){
			console.log("Alarm H detected!");
			this.handleAlarm(event,"H");
		}
	}
	if(this.getLBehavior() != null)
	{
		if(event.AlarmBehaviorName ==  this.getLBehavior().getName()){
			console.log("Alarm L detected!");
			this.handleAlarm(event,"L");
		}
	}
	
	if(this.getLLBehavior() != null)
	{
		if(event.AlarmBehaviorName ==  this.getLLBehavior().getName()){
			console.log("Alarm LL detected!");
			this.handleAlarm(event,"LL");
		}
	}
}
