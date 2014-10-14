function extend(subClass, superClass) {
    // Create a new class that has an empty constructor
    // with the members of the superClass
    function inheritance() {};
    inheritance.prototype = superClass.prototype;
    // set prototype to new instance of superClass
    // _without_ the constructor
    subClass.prototype = new inheritance();
    subClass.prototype.constructor = subClass;
    subClass.baseConstructor = superClass;
    // enable multiple inheritance
    if (superClass.__super__) {
        superClass.prototype.__super__ = superClass.__super__;
    }
    subClass.__super__ = superClass.prototype;
}

/**
 * Check if an Object is empty
 * 
 * @param obj
 * @returns {Boolean}
 */
function isEmpty(obj) {
    for(var prop in obj) {
        if(obj.hasOwnProperty(prop))
            return false;
    }

    return true;
}

function EventSubscriber() {}

EventSubscriber.prototype.handleEvent = function(event){
	console.log("Event '" + getName(event) + "' received.");
};

EventSubscriber.prototype.toString = function(){
	return this.constructor.name;
};

// DEPRECATED: Not used anymore.
function Event() {
	// some functionality
}

Event.prototype.toString = function() {
	return this.constructor.name;
}

function EventBus() {
	this.subscribers = [];
	
	/**
	 * PUBLIC add a object as subscriber of a specific signal
	 * 
	 * @param obj
	 * 			[Object] that subscribes, like processController or a 
	 * 				UIComponent
	 * @param signal
	 * 			[Signal] that is subscribed 
	 */
	this.subscribe = function(obj, signal) { 
		var found = false;
		
		//iterate over all listed subscribers to search obj
		$.each(this.subscribers, function(index, value) { 
		
			//check if obj already subscribed to the type of signal
			if (getTypeName(new value.Signal) == getTypeName(new signal)) {
				if (value.Subscriber == obj) {
					found = true;
				}
			}
		});
		
		//save obj as subscriber of signal                  
		if (!found) {
			this.subscribers.push({
				"Subscriber" : obj,
				"Signal" : signal
			});
		}
	} 
	
	this.printSubscribers = function() {
		$.each(this.subscribers, function(i, v){
			console.log(i + "> " + getTypeName(v.Subscriber) + " on " + getTypeName(v.Signal));
		});
	}       
	
	/**
	 * PUBLIC fire Event on EventBus to send it to its targets
	 * 
	 * @param signal
	 * 			[Signal] that shall be spread
	 * @param target
	 * 			[Object] like processController oder specific UIComponent
	 * 			[null] for broadcast
	 */
	this.fireEvent = function(signal, target) {
	
		//iterate over all subscribers
		$.each(this.subscribers, function(i, v) {   
		
			//if subscriber subscribed the sent signal
			if (getTypeName(new v.Signal) == getTypeName(signal)) {
				var handleEvent = true;
				
				//and subscriber is not the sender of the signal
				if (target != null) {
					if (getTypeName(v.Subscriber) != getTypeName(target)) {
						handleEvent = false;
					}
				}
				
				//inform subscriber about Signal
				if (handleEvent) {
					v.Subscriber.handleEvent(signal);
				}
			}
		});
	}
}

function separateValueAndUnit(str) {
	/(-?\d*(\.\d*)?)(\D+)/.exec(str);
	return {
		Value : eval(RegExp.$1),
		Unit : RegExp.$3
	};
}
function round(zahl,n_stelle){
	if(typeof(n_stelle) == 'undefined' ||n_stelle == null) 
		return zahl;

   if(n_stelle == "" || n_stelle == 0) n_stelle =  1 
   else n_stelle =  Math.pow(10,n_stelle);
   
   zahl = Math.round(zahl * n_stelle) / n_stelle;
   
   return zahl;
}

function getTypeName(obj) { 
   var funcNameRegex = /function (.{1,})\(/;
   var results = (funcNameRegex).exec((obj).constructor.toString());
   return (results && results.length > 1) ? results[1] : "";
};