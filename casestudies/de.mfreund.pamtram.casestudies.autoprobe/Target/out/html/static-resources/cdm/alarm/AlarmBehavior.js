function AlarmBehavior(name,limit,threshold,isHighLimit) {
	this.isActive;
	this.setIsActive = function(newVal) {
		this.isActive = newVal;
	}
	this.getIsActive = function() {
		return this.isActive;
	}
	this.ValueOnAlarm;
	// Attribute: LimtValue
	//
	var limitValue;
	this.setLimitValue = function(newVal) {
		this.limitValue = newVal;
	}
	this.getLimitValue = function() {
		return this.limitValue;
	}
	
	// Attribute: Threshold
	//
	var threshold;
	this.setThreshold = function(newVal) {
		this.threshold = newVal;
	}
	this.getThreshold = function() {
		return this.threshold;
	}
	
	// Attribute:  Name
	//
	var name;
	this.setName = function(newVal) {
		this.name = newVal;
	}
	this.getName = function() {
		return this.name;
	}
	
	// Attribute: IsHighLimit = to idetify how to work with LimitValue
	//
	var isHighLimit;
	this.setIsHighLimit = function(newVal) {
		this.isHighLimit = newVal;
	}
	this.getIsHighLimit = function() {
		return this.isHighLimit;
	}
	
	this.setName(name);
	this.setLimitValue(limit);
	this.setThreshold(threshold);
	this.setIsHighLimit(isHighLimit);
	this.setIsActive(false);
}


AlarmBehavior.prototype.check = function(value){
	if(this.getIsHighLimit()) {
		//If active care about threshold
		if(this.getIsActive()) value = parseFloat(value) + this.getThreshold();
		if(parseFloat(value) >= this.getLimitValue())
			return true;
		return false;
	}
	else {
	//If active care about threshold
		if(this.getIsActive()) value = parseFloat(value) - this.getThreshold();
		if(parseFloat(value) <= this.getLimitValue())
			return true;
		return false;
	}
	
};

AlarmBehavior.prototype.checkAndNotify = function(value){
	if(this.check(value) && !this.getIsActive() ){
		this.setIsActive(true);
		console.log(this.getName() + " Fire AlarmBehaviorSignal(active).");
		alarmBus.fireEvent(new AlarmBehaviorSignal(this.getName(),true,value));
	}
	else if(!this.check(value) && this.getIsActive()) {
		this.setIsActive(false);
		console.log(this.getName() + " Fire AlarmBehaviorSignal(inactive).");
		alarmBus.fireEvent(new AlarmBehaviorSignal(this.getName(),false,value));
	}
	
};