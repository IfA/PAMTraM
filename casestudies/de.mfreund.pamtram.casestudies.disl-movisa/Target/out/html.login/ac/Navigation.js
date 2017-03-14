// Clazz: Navigation
function Navigation() {
	// State: idle
	//
	var idleState = new NavigationIdleState(this);
	this.setIdleState = function(newVal) {
		idleState = newVal;
	}
	this.getIdleState = function() {
		return idleState;
	}

	// State: Dialog_1_state
	//
	var dialog_1_stateState = new NavigationDialog_1_stateState(this);
	this.setDialog_1_stateState = function(newVal) {
		dialog_1_stateState = newVal;
	}
	this.getDialog_1_stateState = function() {
		return dialog_1_stateState;
	}

	// State: Dialog_2_state
	//
	var dialog_2_stateState = new NavigationDialog_2_stateState(this);
	this.setDialog_2_stateState = function(newVal) {
		dialog_2_stateState = newVal;
	}
	this.getDialog_2_stateState = function() {
		return dialog_2_stateState;
	}

	// Variable to hold the currently active state
	var state;
	this.setState = function(newState) {
		state = newState;
	}
	this.getState = function() {
		return state;
	}
	// Enter a particular state
	this.enterState = function(newState, event) {
		
		this.setState(newState);
		this.getState().entry(event);
	}
	// subscribe to the EventBus
	//
	eventBus.subscribe(this, Dialog_2_signal);
	eventBus.subscribe(this, Dialog_1_signal);
	this.enterState(this.getIdleState(), null);
}
extend(Navigation, EventSubscriber);
Navigation.prototype.handleEvent = function(event) {
	
	// state 'idle'
	if (this.getState() instanceof NavigationIdleState) {
	}
	// state 'Dialog_1_state'
	if (this.getState() instanceof NavigationDialog_1_stateState) {
		// Do nothing on usual Signals, as there is no trigger defined.
		if (event instanceof Dialog_2_signal) {
			this.enterState(this.getDialog_2_stateState(), event);
		}
	}
	// state 'Dialog_2_state'
	if (this.getState() instanceof NavigationDialog_2_stateState) {
		// Do nothing on usual Signals, as there is no trigger defined.
		if (event instanceof Dialog_1_signal) {
			this.enterState(this.getDialog_1_stateState(), event);
		}
	}
}

function NavigationIdleState(obj) {
	this.obj = obj;
}
extend(NavigationIdleState, State);

NavigationIdleState.prototype.entry = function(event) {
	
}

function NavigationDialog_1_stateState(obj) {
	this.obj = obj;
}
extend(NavigationDialog_1_stateState, State);

NavigationDialog_1_stateState.prototype.entry = function(event) {
	
	this.obj.enterState(this.obj.getDialog_1_stateState(), null);
}

function NavigationDialog_2_stateState(obj) {
	this.obj = obj;
}
extend(NavigationDialog_2_stateState, State);

NavigationDialog_2_stateState.prototype.entry = function(event) {
	
	this.obj.enterState(this.obj.getDialog_2_stateState(), null);
}
