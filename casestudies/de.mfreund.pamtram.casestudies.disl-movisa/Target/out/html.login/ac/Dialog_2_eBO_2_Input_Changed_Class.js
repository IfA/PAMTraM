// Clazz: Dialog_2_eBO_2_Input_Changed_Class
function Dialog_2_eBO_2_Input_Changed_Class() {
	// State: Initial
	//
	var initialState = new Dialog_2_eBO_2_Input_Changed_ClassInitialState(this);
	this.setInitialState = function(newVal) {
		initialState = newVal;
	}
	this.getInitialState = function() {
		return initialState;
	}

	// State: MainState
	//
	var mainStateState = new Dialog_2_eBO_2_Input_Changed_ClassMainStateState(this);
	this.setMainStateState = function(newVal) {
		mainStateState = newVal;
	}
	this.getMainStateState = function() {
		return mainStateState;
	}

	// State: MainStateeBO_2_Input_Changed_Action64
	//
	var mainStateeBO_2_Input_Changed_Action64State = new Dialog_2_eBO_2_Input_Changed_ClassMainStateeBO_2_Input_Changed_Action64State(this);
	this.setMainStateeBO_2_Input_Changed_Action64State = function(newVal) {
		mainStateeBO_2_Input_Changed_Action64State = newVal;
	}
	this.getMainStateeBO_2_Input_Changed_Action64State = function() {
		return mainStateeBO_2_Input_Changed_Action64State;
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
	eventBus.subscribe(this, Dialog_2_eBO_2_Input_Changed_signal);
	this.enterState(this.getInitialState(), null);
}
extend(Dialog_2_eBO_2_Input_Changed_Class, EventSubscriber);
Dialog_2_eBO_2_Input_Changed_Class.prototype.handleEvent = function(event) {
	
	// state 'Initial'
	if (this.getState() instanceof Dialog_2_eBO_2_Input_Changed_ClassInitialState) {
		// Do nothing on usual Signals, as there is no trigger defined.
	}
	// state 'MainState'
	if (this.getState() instanceof Dialog_2_eBO_2_Input_Changed_ClassMainStateState) {
		if (event instanceof Dialog_2_eBO_2_Input_Changed_signal) {
			this.enterState(this.getMainStateeBO_2_Input_Changed_Action64State(), event);
		}
	}
	// state 'MainStateeBO_2_Input_Changed_Action64'
	if (this.getState() instanceof Dialog_2_eBO_2_Input_Changed_ClassMainStateeBO_2_Input_Changed_Action64State) {
		// Do nothing on usual Signals, as there is no trigger defined.
	}
}

function Dialog_2_eBO_2_Input_Changed_ClassInitialState(obj) {
	this.obj = obj;
}
extend(Dialog_2_eBO_2_Input_Changed_ClassInitialState, State);

Dialog_2_eBO_2_Input_Changed_ClassInitialState.prototype.entry = function(event) {
	
	this.obj.enterState(this.obj.getMainStateState(), null);
}

function Dialog_2_eBO_2_Input_Changed_ClassMainStateState(obj) {
	this.obj = obj;
}
extend(Dialog_2_eBO_2_Input_Changed_ClassMainStateState, State);

Dialog_2_eBO_2_Input_Changed_ClassMainStateState.prototype.entry = function(event) {
	
}

function Dialog_2_eBO_2_Input_Changed_ClassMainStateeBO_2_Input_Changed_Action64State(obj) {
	this.obj = obj;
}
extend(Dialog_2_eBO_2_Input_Changed_ClassMainStateeBO_2_Input_Changed_Action64State, State);

Dialog_2_eBO_2_Input_Changed_ClassMainStateeBO_2_Input_Changed_Action64State.prototype.entry = function(event) {
	
	// AcceptEventAction: eBO_2_Input_Changed_Action64
	this.eBO_2_Input_Changed_Action64 = function() {
		return event;
	}
	// WriteDataItemAction: eBO_2_Input_Changed_Action65
	this.eBO_2_Input_Changed_Action65 = function(value) {
		var signal = new WriteDataItemSignal();
		signal.setDataItemName('V1_FL');
		signal.setDataItemValue(value);
		eventBus.fireEvent(signal, processController);
	}
	// ReadPresentationModelAction: eBO_2_Input_Changed_Action67
	this.eBO_2_Input_Changed_Action67 = function() {
		return pmUIComponent_Dialog_2_eBO_2_Input;
	}
this.eBO_2_Input_Changed_Action64();
var eBO_2_Input_Changed_ObjectFlow = this.eBO_2_Input_Changed_Action67().value;
this.eBO_2_Input_Changed_Action65(eBO_2_Input_Changed_ObjectFlow);
	this.obj.enterState(this.obj.getMainStateState(), null);
}
