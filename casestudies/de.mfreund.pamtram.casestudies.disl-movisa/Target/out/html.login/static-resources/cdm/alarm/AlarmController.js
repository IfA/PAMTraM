function AlarmController() {

}

function AlarmBus() {
	this.subscribers = [];
	
	this.subscribe = function(obj, alarmBehavior) { 
		var found = false;
		
		$.each(this.subscribers, function(index, value) { 
			if (value.AlarmBehavior.getName() == alarmBehavior.getName()) {
				if (value.Subscriber == obj) {
					found = true;
				}
			}
		});                  
		if (!found) {
			this.subscribers.push({
				"Subscriber" : obj,
				"AlarmBehavior" : alarmBehavior
			});
			this.subscribers.sort(AlarmPrioritySort);
		}
	} 
	
	this.printSubscribers = function() {
		$.each(this.subscribers, function(i, v){
			console.log(i + "> " + v.Subscriber.constructor.name + " on " + v.AlarmBehavior.name);
		});
	}       
	
	this.fireEvent = function(alarmBehaviorSignal) {
		console.log("AlarmSignal fired.");
		$.each(this.subscribers, function(i, v) {   
			if (v.AlarmBehavior.getName() == alarmBehaviorSignal.AlarmBehaviorName) {
				v.Subscriber.handleAlarmBehaviorEvent(alarmBehaviorSignal);
			}
		});
	}
}

function AlarmPrioritySort(a,b) {
	return a.Subscriber.getPriority()-b.Subscriber.getPriority();
}

function AlarmSubscriber() {}

AlarmSubscriber.prototype.handleAlarmBehaviorEvent = function(alarmBehavior){
	console.log("Alarm '" + event.constructor.name + "' received.");
};

AlarmSubscriber.prototype.toString = function(){
	return this.constructor.name;
};
