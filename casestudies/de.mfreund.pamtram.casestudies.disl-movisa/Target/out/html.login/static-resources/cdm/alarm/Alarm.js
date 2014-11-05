function Alarm() {

}
extend(Alarm, AlarmSubscriber);


Alarm.prototype.isActive = function(){
var active = fale;
if(this.getHHBehavior().getIsActive() || this.getHBehavior().getIsActive() || this.getLBehavior().getIsActive() || this.getLLBehavior().getIsActive())
	active = true;
return active;
}

//Class wich holds a Alarm State
//When created its active and not achnowleged, also a Timestamp is set.
function AlarmState(id,value,type) {
	this.Id = id;
	this.Value = value;
	this.Timestamp = new Date();
	this.Active = true;
	this.Acknowledged = false;
	this.Type = type;
}

/**
 * PUBLIC handles events send over AlarmBus
 * 
 * @param event
 * 			[AlarmBehaviorSignal] wich was send via braodcast
 */
Alarm.prototype.handleAlarmBehaviorEvent = function(event){
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

Alarm.prototype.handleAlarm = function(event,type){
	switch(type)
	{
		case "HH":
		  console.log("Handle HH Alarm");
		  break;
		case "H":
		  console.log("Handle H Alarm");
		  break;
		case "L":
		  console.log("Handle L Alarm");
		  break;
		case "LL":
		  console.log("Handle LL Alarm");
		  break;
		default:
		console.log("Alarm can not handle event!Not good!");
		  //Wahaa this is not good!!
	}
}