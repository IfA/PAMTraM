// Clazz: Dialog_1_eBO_6_Confirm_Changed_Class
function Dialog_1_eBO_6_Confirm_Changed_Class() {
	// State: Initial
	//
	var initialState = new Dialog_1_eBO_6_Confirm_Changed_ClassInitialState(this);
	this.setInitialState = function(newVal) {
		initialState = newVal;
	}
	this.getInitialState = function() {
		return initialState;
	}

	// State: MainState
	//
	var mainStateState = new Dialog_1_eBO_6_Confirm_Changed_ClassMainStateState(this);
	this.setMainStateState = function(newVal) {
		mainStateState = newVal;
	}
	this.getMainStateState = function() {
		return mainStateState;
	}

	// State: MainStateeBO_6_Confirm_Changed_Action52
	//
	var mainStateeBO_6_Confirm_Changed_Action52State = new Dialog_1_eBO_6_Confirm_Changed_ClassMainStateeBO_6_Confirm_Changed_Action52State(this);
	this.setMainStateeBO_6_Confirm_Changed_Action52State = function(newVal) {
		mainStateeBO_6_Confirm_Changed_Action52State = newVal;
	}
	this.getMainStateeBO_6_Confirm_Changed_Action52State = function() {
		return mainStateeBO_6_Confirm_Changed_Action52State;
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
	eventBus.subscribe(this, Dialog_1_eBO_6_Confirm_Changed_signal);
	this.enterState(this.getInitialState(), null);
}
extend(Dialog_1_eBO_6_Confirm_Changed_Class, EventSubscriber);
Dialog_1_eBO_6_Confirm_Changed_Class.prototype.handleEvent = function(event) {
	
	// state 'Initial'
	if (this.getState() instanceof Dialog_1_eBO_6_Confirm_Changed_ClassInitialState) {
		// Do nothing on usual Signals, as there is no trigger defined.
	}
	// state 'MainState'
	if (this.getState() instanceof Dialog_1_eBO_6_Confirm_Changed_ClassMainStateState) {
		if (event instanceof Dialog_1_eBO_6_Confirm_Changed_signal) {
			this.enterState(this.getMainStateeBO_6_Confirm_Changed_Action52State(), event);
		}
	}
	// state 'MainStateeBO_6_Confirm_Changed_Action52'
	if (this.getState() instanceof Dialog_1_eBO_6_Confirm_Changed_ClassMainStateeBO_6_Confirm_Changed_Action52State) {
		// Do nothing on usual Signals, as there is no trigger defined.
	}
}

function Dialog_1_eBO_6_Confirm_Changed_ClassInitialState(obj) {
	this.obj = obj;
}
extend(Dialog_1_eBO_6_Confirm_Changed_ClassInitialState, State);

Dialog_1_eBO_6_Confirm_Changed_ClassInitialState.prototype.entry = function(event) {
	
	this.obj.enterState(this.obj.getMainStateState(), null);
}

function Dialog_1_eBO_6_Confirm_Changed_ClassMainStateState(obj) {
	this.obj = obj;
}
extend(Dialog_1_eBO_6_Confirm_Changed_ClassMainStateState, State);

Dialog_1_eBO_6_Confirm_Changed_ClassMainStateState.prototype.entry = function(event) {
	
}

function Dialog_1_eBO_6_Confirm_Changed_ClassMainStateeBO_6_Confirm_Changed_Action52State(obj) {
	this.obj = obj;
}
extend(Dialog_1_eBO_6_Confirm_Changed_ClassMainStateeBO_6_Confirm_Changed_Action52State, State);

Dialog_1_eBO_6_Confirm_Changed_ClassMainStateeBO_6_Confirm_Changed_Action52State.prototype.entry = function(event) {
	
	// AcceptEventAction: eBO_6_Confirm_Changed_Action52
	this.eBO_6_Confirm_Changed_Action52 = function() {
		return event;
	}
	// WriteDataItemAction: eBO_6_Confirm_Changed_Action53
	this.eBO_6_Confirm_Changed_Action53 = function(value) {
		var signal = new WriteDataItemSignal();
		signal.setDataItemName('Start_Umpumpen_FL');
		signal.setDataItemValue(value);
		eventBus.fireEvent(signal, processController);
	}
	// ValueSpecificationAction: eBO_6_Confirm_Changed_Action54
	this.eBO_6_Confirm_Changed_Action54 = function() {
		return false;
	}
this.eBO_6_Confirm_Changed_Action52();
var eBO_6_Confirm_Changed_ObjectFlow = this.eBO_6_Confirm_Changed_Action54();
this.eBO_6_Confirm_Changed_Action53(eBO_6_Confirm_Changed_ObjectFlow);
	this.obj.enterState(this.obj.getMainStateState(), null);
}
