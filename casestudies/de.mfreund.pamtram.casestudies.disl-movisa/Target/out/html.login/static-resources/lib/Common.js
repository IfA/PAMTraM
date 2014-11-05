
/**
 * Created by Baron on 21.05.2014.
 * @author Lukas Baron
 * @module MOVISA-UTILS providing JavaScript Utility
 */
(function () {
    "use strict";
    var root = window,
        //_ = root._ || require("underscore"),
        exports = {},
        regExps = {
            //regular expression from http://www.marketingtechblog.com/javascript-password-strength/
            passwordStrength : /"^(?=.{8,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$"/,
            //regular expression from http://stackoverflow.com/questions/9208814/validate-ipv4-ipv6-and-hostname
            host : /((^\s*((([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]))\s*$)|(^\s*((([0-9A-Fa-f]{1,4}:){7}([0-9A-Fa-f]{1,4}|:))|(([0-9A-Fa-f]{1,4}:){6}(:[0-9A-Fa-f]{1,4}|((25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)(\.(25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)){3})|:))|(([0-9A-Fa-f]{1,4}:){5}(((:[0-9A-Fa-f]{1,4}){1,2})|:((25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)(\.(25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)){3})|:))|(([0-9A-Fa-f]{1,4}:){4}(((:[0-9A-Fa-f]{1,4}){1,3})|((:[0-9A-Fa-f]{1,4})?:((25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)(\.(25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){3}(((:[0-9A-Fa-f]{1,4}){1,4})|((:[0-9A-Fa-f]{1,4}){0,2}:((25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)(\.(25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){2}(((:[0-9A-Fa-f]{1,4}){1,5})|((:[0-9A-Fa-f]{1,4}){0,3}:((25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)(\.(25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){1}(((:[0-9A-Fa-f]{1,4}){1,6})|((:[0-9A-Fa-f]{1,4}){0,4}:((25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)(\.(25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)){3}))|:))|(:(((:[0-9A-Fa-f]{1,4}){1,7})|((:[0-9A-Fa-f]{1,4}){0,5}:((25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)(\.(25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)){3}))|:)))(%.+)?\s*$))|(^\s*((?=.{1,255}$)(?=.*[A-Za-z].*)[0-9A-Za-z](?:(?:[0-9A-Za-z]|\b-){0,61}[0-9A-Za-z])?(?:\.[0-9A-Za-z](?:(?:[0-9A-Za-z]|\b-){0,61}[0-9A-Za-z])?)*)\s*$)/
        };
    
    /**
     * Transforms a function's arguments Object to Array
     * @param {Arguments} arg
     * @returns {Object[]}
     */
    function argumentsToArray(arg) {
        var result = [],
            i;
        if (exports.isArray(arg)) {
            return arg;
        }

        for (i = 0; i < arg.length; i += 1) {
            result.push(arg[i]);
        }
        return result;
    }
    exports.argumentsToArray = argumentsToArray;

    /**
     * Extends the first handed Object with properties of each following.
     * Pre-existing properties will be overwritten in sequence.
     * First Object will be changed. Provide {} if new Object shall be created.
     * @param {...Object} target First Object is the target. Subsequent objects provide properties to be copied over.
     * @returns {Object} The changed target Object
     */
    function extend(target) {/*, src1, src2*/
        var i, currentObj;

        function copyProperties(key) {
            target[key] = currentObj[key] !== undefined ? currentObj[key] : target[key];
        }

        if (arguments.length <= 0) {
            return null;
        }

        for (i = 1; i < arguments.length; i += 1) {
            currentObj = arguments[i];
            if (currentObj !== target) {
                Object.keys(currentObj).forEach(copyProperties);
            }
        }

        return target;
    }
    exports.extend = extend;

    /**
     * Assigns properties from default object to target object, if not already defined there.
     * Target Object will be changed.
     * @param {Object} target The target object.
     * @param {Object} defaults The defaults-defining object.
     * @returns {Object} Returns the target Object
     */
    function applyDefaults(target, defaults) {
        if (!defaults || !target) {
            return target;
        }

        Object.keys(defaults).forEach(function (property) {
            if (target[property] === null || target[property] === undefined) {
                target[property] = defaults[property];
            }
        });
        return target;
    }
    exports.applyDefaults = applyDefaults;

    /**
     * Checks a given String with a Regular Expression for occurrences of specific character set.
     * @param {String} pw The password to check.
     * @returns {boolean} If pw matches the RegEx
     */
    exports.checkPasswordStrength = function (pw) {
        return pw.match(regExps.passwordStrength);
    };

    /**
     * Checks if a given String is a valid hostname.
     * @param {String} host The hostname to check.
     * @returns {boolean} If pw matches the RegEx
     */
    exports.checkHostname = function (host) {
        return host.match(regExps.host);
    };

    function objectToString(o) {
        return Object.prototype.toString.call(o);
    }

    /**
     * Checks if the given Object is an original Array.
     * @param {Object} ar The object to check.
     * @returns {boolean} If it is an Array
     */
    function isArray(ar) {
        return Array.isArray(ar) ||
            (typeof ar === 'object' && objectToString(ar) === '[object Array]');
    }
    exports.isArray = isArray;

    /**
     * Checks if the given Object is an original Regex.
     * @param {Object} re The object to check.
     * @returns {boolean} If it is a Regex
     */
    function isRegExp(re) {
        return typeof re === 'object' && objectToString(re) === '[object RegExp]';
    }
    exports.isRegExp = isRegExp;

    /**
     * Checks if the given Object is an original Date.
     * @param {Object} d The object to check.
     * @returns {boolean} If it is a Date
     */
    function isDate(d) {
        return typeof d === 'object' && objectToString(d) === '[object Date]';
    }
    exports.isDate = isDate;

    /**
     * Checks if the given Object is an original Error.
     * @param {Object} e The object to check.
     * @returns {boolean} If it is an Error
     */
    function isError(e) {
        return typeof e === 'object' &&
            (objectToString(e) === '[object Error]' || e instanceof Error);
    }
    exports.isError = isError;

    /**
     * Escapes Regex characters in a String in order to be able to build a regex from String
     * @param {String} text The string to escape.
     * @returns {string} Escaped regular expression string.
     */
    exports.escapeRegexCharacters =  function (text) {
        //copied from http://stackoverflow.com/questions/3115150/how-to-escape-regular-expression-special-characters-using-javascript
        return text.replace(/[-[\]{}()*+?.,\\^$|#\s]/g, "\\$&");
    };

    /**
     * Clones an array.
     * @param {Array} a The array to clone
     * @returns {Array} The cloned array
     */
    exports.cloneArray = function (a) {
        var n = [];
        Array.prototype.push.apply(n, a);
        return n;
    };

    /**
     * Returns the current time stamp in UTC
     * @param {Date} date The date-object to get the UTC timestamp from
     * @returns {number} The UTC time stamp
     */
    function getUTCTime(date) {
        date = date || new Date();
        return new Date(
            date.getUTCFullYear(),
            date.getUTCMonth(),
            date.getUTCDate(),
            date.getUTCHours(),
            date.getUTCMinutes(),
            date.getUTCSeconds(),
            date.getUTCMilliseconds()
        ).getTime();
    }
    exports.getUTCTime = getUTCTime;

    /**
     * Uses Math.random to get a pseudo-random string
     * @param {number} [iterations=5] How many iterations takes place before
     * @returns {string} The 'random' string
     */
    exports.getRandomString = function (iterations) {
        var i, result = getUTCTime().toString();
        iterations = iterations <= 0 ? 5 : iterations;
        for (i = 1; i < iterations; i += 1) {
            result += Math.random();
        }
        return result.replace(/(0\.|\.)/g, "");
    };

    /**
     * Deep Object clone by intermediate JSON-representation (without functions).
     * Prevent circular references! Extends the cloned objects by subsequent objects.
     * @param {...Object} toClone First object to be cloned and to be extended by subsequent objects.
     * @returns {Object} The cloned and extended object.
     */
    exports.deepClone = function (toClone) {
        var args = argumentsToArray(arguments);
        return exports.extend(JSON.parse(JSON.stringify(toClone)), args.slice(1));
    };

    /**
     * Transforms an Arguments object to an Array
     * @param args
     * @returns {Array}
     */
    exports.argumentsToArray = function (args) {
        return Array.prototype.slice.call(args);
    };

    function checkInheritance(currentPrototype, superPrototype, className, packageName, checkedSuperPrototypes) {
        var i;
        checkedSuperPrototypes = checkedSuperPrototypes || [];

        if (superPrototype && currentPrototype && currentPrototype === superPrototype) {
            return true;
        }
        if (!superPrototype) {
            if (currentPrototype.CLASS_NAME && className && currentPrototype.CLASS_NAME === className) {
                if (!packageName) {
                    return true;
                }
                if (currentPrototype.PACKAGE_NAME && packageName && currentPrototype.PACKAGE_NAME === packageName) {
                    return true;
                }
            }
            if (!className && currentPrototype.PACKAGE_NAME && packageName && currentPrototype.PACKAGE_NAME === packageName) {
                return true;
            }
        }
        if (checkedSuperPrototypes.indexOf(currentPrototype) >= 0) {
            return false;
        }

        checkedSuperPrototypes.push(currentPrototype);

        if (exports.isArray(currentPrototype.__super)) {
            for (i = 0; i < currentPrototype.__super.length; i += 1) {
                if (checkInheritance(currentPrototype.__super[i], superPrototype, className, packageName, checkedSuperPrototypes)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks, if an Object or a Prototype, created by Class(), has certain prototype
     * @param {Object} [o] Prototype or Object. If no use of this parameter, apply function to the object or prototype.
     * @param {Object} [s] Superclass Provide the proto
     * @param {String} [className] The name of the class to check for
     * @param {String} [packageName] The package name to check for
     * @returns {Boolean} if it is of class or if no class name provided of package
     */
    exports.isTypeOf = function (o, s, className, packageName) {

        var object = (this === exports || !this) ? o : this,
            prototype,
            superPrototype = null,
            p;

        if (typeof object !== "object") {
            return false;
        }

        if (object === o) {
            //object handed as parameter
            if (typeof s === "string" || s === null) {
                //class name or only package name provided
                packageName = className;
                className = s;
                if (s === null && typeof packageName !== "string") {
                    return false;
                }
            } else if (s !== null) {
                //superclass provided
                superPrototype = s;
            }
        } else {
            //object handed as this
            if (typeof o === "string" || o === null) {
                //class name or only package name provided
                packageName = s;
                className = o;
                if (o === null && typeof s !== "string") {
                    return false;
                }
            } else if (o !== null) {
                //superclass provided
                superPrototype = o;
            }
        }

        try {
            p = Object.getPrototypeOf(object);
            if (p === Object.prototype) {
                prototype = object;
            } else {
                prototype = Object.getPrototypeOf(object);
            }
        } catch (er) {
            return false;
        }

        return checkInheritance(prototype, superPrototype, className, packageName);
    };

    /*
     * Adapted from OpenLayers.debug.js v2.13.1:205-217
     */
    /**
     * Inherits properties from superclasses to class.
     * @param {Function} C Class
     * @param {...Function} P Superclasses
     */
    exports.inherit = function (C, P) {
        var F = function () {},
            i,
            l,
            o,
            s = [];
        F.prototype = P.prototype;
        C.prototype = new F();
        s.push(P.prototype);

        for (i = 2, l = arguments.length; i < l; i += 1) {
            o = arguments[i];
            if (typeof o === "function") {
                o = o.prototype;
                s.push(o);
            }
            exports.extend(C.prototype, o);
        }
        C.prototype.__super = s;
    };
    /*
     * Adapted from OpenLayers.debug.js v2.13.1:176-192
     */
    /**
     * Creates a class and inherits from superclasses
     * @param {(...Object|...Function)} proto Last
     * @returns {Function} New Class constructor
     */
    exports.Class = function (proto) {
        var len = arguments.length,
            P = proto,
            F = arguments[len - 1],
            newArgs,

            C = typeof F.initialize === "function" ?
                F.initialize :
                    function () {
                        P.prototype.initialize.apply(this, arguments);
                    };

        if (len > 1) {
            newArgs = [C, P].concat(Array.prototype.slice.call(arguments).slice(1, len - 1), F);
            exports.inherit.apply(null, newArgs);
        } else {
            C.prototype = F;
            C.prototype.__super = [];
        }
        return C;
    };
    
    //Movisa specific utils
    
    /*
	 * for backward compatibility
	 */
    exports.getSignalName = function (signal) {
		var result = typeof signal === "string" ? signal : 
				(signal.CLASS_NAME || signal.constru);
		if (typeof signal === "string") {
			return signal;
		}
		if (typeof signal === "object") {
			if (typeof signal.CLASS_NAME === "string") {
				return signal.CLASS_NAME;
			}
			if (signal.constructor.name !== "Object") {
				return signal.constructor.name;
			}
			throw new Error("E_MISSING_SIGNAL_NAME - handed signal object has no class name.");
		}
		if (typeof signal === "function" && signal.name !== "") {
			return signal.name;
		}
		if (typeof signal === "number") {
			return signal;
		}
		throw new Error("E_MISSING_SIGNAL_NAME - handed signal object has no class name.");
	};   
    
    root.Movisa = root.Movisa || {};
    root.Movisa.utils = exports;
}());


/**
 * Created by Baron on 21.05.2014.
 * @author Lukas Baron
 * @module MOVISA-COMMON providing common Movisa classes
 * requires Movisa.utils
 */
(function () {
    "use strict";
    var root = window,
        //_ = root._ || require("underscore"),
        exports = {};

    //TODO enable event names to be regex
    exports.EventBus = Movisa.utils.Class(
    	/** @lends EventBus# */
    	{
    		/**
    		 * @type {object}
    		 */
	    	listeners : null,
	    		    	
	    	/**
	    	 * @constructs
	    	 * @version 0.1.0
	    	 */
	    	initialize : function () {
	    		this.listeners = {};
	    		this.onceListeners = {};
	    	},
	    	    	
	    	/**
	    	 * @deprecated use on()
	    	 */
	    	subscribe : function (subscriber, signal) {
	    		var handle = typeof subscriber === "function" ? subscriber : 
	    				(typeof subscriber === "object" && typeof subscriber.handleEvent === "function" ? 
	    						subscriber.handleEvent.bind(subscriber) : null),
	    			signalName = Movisa.utils.getSignalName(signal); 
	    		if (!handle) {
	    			throw new Error("E_ILLEGAL_ARGUMENT - Subscriber handle could not be found. Provide handleEvent() in object or function.");
	    		}   
	    		   
	    		return this.on(signalName, handle);
	    	},
	    	
	    	/**
	    	 * @param {function} [signal] The signal, the listener is subscribed to
	    	 * @param {function} listener The listener to unsubscribe
	    	 */
	    	unsubscribe : function (signal, listener) {
	    		throw new Error("E_NOT_IMPLEMENTED - The unsubscribe function is not possible to implement, use on() and off().");
	    	},
	    	
	    	/**
	    	 * @param {String} evt The event to listen on
	    	 * @param {Function} handle The handle to call in case of the event. Return true if called in order to stop event propagation.
	    	 */
	    	on : function (evt, handle) {
	    		if (typeof evt !== "string") {
	    			throw new Error("E_ILLEGAL_ARGUMENT - event name must be specified");
	    		}
	    		if (typeof handle !== "function") {
	    			throw new Error("E_ILLEGAL_ARGUMENT - handle must be of type function");
	    		}
	    		
	    		if (this.listeners[evt]) {
	    			if (this.listeners[evt].indexOf(handle) >= 0) {
	    				this.listeners[evt].splice(this.listeners[evt].indexOf(handle), 1);
	    			}    			
	    			this.listeners[evt].push(handle);
	    		} else {
	    			this.listeners[evt] = [handle];
	    		}
	    	},
	    	
	    	/**
	    	 * @see on()
	    	 * @param {String} evt The event to listen on
	    	 * @param {Function} handle The handle to call in case of the event. Return true if called in order to stop event propagation.
	    	 */
	    	once : function (evt, handle) {
	    		this.on(evt, handle);
	    		//TODO this is poor code, but quick
	    		handle.__once__ = true;
	    	},
	    	
	    	/**
	    	 * @param {String} [evt] the event name to search the listener for
	    	 * @param {function} handle the event listener
	    	 */
	    	removeListener : function (evt, handle) {
	    		var searchArrays = [], i;
	    		if (typeof evt === "string") {
	    			if (this.listeners[evt]) {
	    				searchArray.push(this.listeners[evt])
	    			}
	    		} else if (typeof evt === "function") {
	    			handle = evt;
	    			
	    			Object.keys(this.listeners).forEach(function (evt) {
	    				searchArrays.push(this.listeners[evt]);
	    			});
	    		}
	    		if (typeof handle !== "function") {
	    			throw new Error("E_ILLEGAL_ARGUMENT - handle must be of type function");
	    		}
	    		for (i in searchArrays) {
	    			if (searchArrays[i].indexOf(handle) >= 0) {
	    				searchArrays[i].splice(searchArrays[i].indexOf(handle), 1);
	    			}
	    		}
	    	},
	    	
	    	/**
	    	 * @param {String} [evt] the event name to search the listener for
	    	 * @param {function} handle the event listener
	    	 * @see removeListener()
	    	 */
	    	off : function (evt, handle) {
	    		this.removeListener(evt, handle);
	    	},
	    	
	    	/**
	    	 * @param {String} [evt] the event name to clear listeners for, all will be removed if not provided
	    	 */
	    	removeAllListeners : function (evt) {
	    		if (evt === undefined) {
	    			this.listeners = {};
	    			return;
	    		} 
	    		if (typeof evt === "string") {
	    			if (this.listeners[evt]) {
	    				this.listeners[evt] = [];
	    			}
	    			return;	    		
	    		}
	    		throw new Error("E_ILLEGAL_ARGUMENT - event name must be undefinec or of type string");
	    	},
	    	
	    	/**
	    	 * @deprecated use triggerEvent()
	    	 * @param {Signal} signal The signal to fire.
	    	 */
	    	fireEvent : function (signal) {
	    		return this.triggerEvent(Movisa.utils.getSignalName(signal), [signal]);
	    	},
	    	
	    	/**
	    	 * @param {String} evt The event name to trigger
	    	 * @param {Object[]} [data] An array of data to apply to the handle
	    	 */
	    	triggerEvent : function (evt, data) {
	    		var listeners, i;
	    		if (typeof evt !== "string") {
	    			throw new Error("E_ILLEGAL_ARGUMENT - event name must be specified");
	    		}
	    		if (data === undefined) {
	    			data = [];
	    		}
	    		if (!this.listeners[evt]) {
	    			return;
	    		}
	    		listeners = Movisa.utils.cloneArray(this.listeners[evt]);
	    		for (i in listeners) {
	    			if (listeners[i].__once__ === true) {
	    				this.removeListener(evt, listeners[i]);
	    			}
	    			try {
		    			if (listeners[i].apply({}, data) === true) {
		    				break;
		    			}
	    			} catch (e) {
	    				// in case of an error in an event handler do not kill the event triggering call stack
	    				window.setTimeout(function () {
	    					throw e;
	    				}, 1);
	    			}
	    		}
	    	},
	    	
	    	destroy : function () {
	    		delete this.listeners;
	    	},
	    	
	    	CLASS_NAME : "EventBus",
	    	PACKAGE_NAME : "Movisa.common"
    	}
    );
    
    
    root.Movisa.common = exports;   
}());


/**
 * @deprecated use Movisa.utils.inherit
 */
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

//for backwardCompatibility
window.EventBus = Movisa.common.EventBus;
window.getTypeName = Movisa.utils.getSignalName;

/**
 * @deprecated
 */
function EventSubscriber() {}

/**
 * @deprecated
 */
EventSubscriber.prototype.handleEvent = function(event){
	console.log("Event '" + getName(event) + "' received.");
};

EventSubscriber.prototype.toString = function(){
	return this.constructor.name;
};

// DEPRECATED: Not used anymore.
/**
 * @deprecated
 */
function Event() {
	// some functionality
}

Event.prototype.toString = function() {
	return this.constructor.name;
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

/*
function getTypeName(obj) { 
   var funcNameRegex = /^function (.{1,})\(/;
   var results = (funcNameRegex).exec((obj).constructor.toString());
   return (results && results.length > 1) ? results[1] : "";
};*/