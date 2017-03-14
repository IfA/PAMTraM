// Clazz: Dialog_2_eBO_6_Input_Changed_Class
function Dialog_2_eBO_6_Input_Changed_Class() {
	// State: Initial
	//
	var initialState = new Dialog_2_eBO_6_Input_Changed_ClassInitialState(this);
	this.setInitialState = function(newVal) {
		initialState = newVal;
	}
	this.getInitialState = function() {
		return initialState;
	}

	// State: MainState
	//
	var mainStateState = new Dialog_2_eBO_6_Input_Changed_ClassMainStateState(this);
	this.setMainStateState = function(newVal) {
		mainStateState = newVal;
	}
	this.getMainStateState = function() {
		return mainStateState;
	}

	// State: MainStateeBO_6_Input_Changed_Action74
	//
	var mainStateeBO_6_Input_Changed_Action74State = new Dialog_2_eBO_6_Input_Changed_ClassMainStateeBO_6_Input_Changed_Action74State(this);
	this.setMainStateeBO_6_Input_Changed_Action74State = function(newVal) {
		mainStateeBO_6_Input_Changed_Action74State = newVal;
	}
	this.getMainStateeBO_6_Input_Changed_Action74State = function() {
		return mainStateeBO_6_Input_Changed_Action74State;
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
	eventBus.subscribe(this, Dialog_2_eBO_6_Input_Changed_signal);
	this.enterState(this.getInitialState(), null);
}
extend(Dialog_2_eBO_6_Input_Changed_Class, EventSubscriber);
Dialog_2_eBO_6_Input_Changed_Class.prototype.handleEvent = function(event) {
	
	// state 'Initial'
	if (this.getState() instanceof Dialog_2_eBO_6_Input_Changed_ClassInitialState) {
		// Do nothing on usual Signals, as there is no trigger defined.
	}
	// state 'MainState'
	if (this.getState() instanceof Dialog_2_eBO_6_Input_Changed_ClassMainStateState) {
		if (event instanceof Dialog_2_eBO_6_Input_Changed_signal) {
			this.enterState(this.getMainStateeBO_6_Input_Changed_Action74State(), event);
		}
	}
	// state 'MainStateeBO_6_Input_Changed_Action74'
	if (this.getState() instanceof Dialog_2_eBO_6_Input_Changed_ClassMainStateeBO_6_Input_Changed_Action74State) {
		// Do nothing on usual Signals, as there is no trigger defined.
	}
}

function Dialog_2_eBO_6_Input_Changed_ClassInitialState(obj) {
	this.obj = obj;
}
extend(Dialog_2_eBO_6_Input_Changed_ClassInitialState, State);

Dialog_2_eBO_6_Input_Changed_ClassInitialState.prototype.entry = function(event) {
	
	this.obj.enterState(this.obj.getMainStateState(), null);
}

function Dialog_2_eBO_6_Input_Changed_ClassMainStateState(obj) {
	this.obj = obj;
}
extend(Dialog_2_eBO_6_Input_Changed_ClassMainStateState, State);

Dialog_2_eBO_6_Input_Changed_ClassMainStateState.prototype.entry = function(event) {
	
}

function Dialog_2_eBO_6_Input_Changed_ClassMainStateeBO_6_Input_Changed_Action74State(obj) {
	this.obj = obj;
}
extend(Dialog_2_eBO_6_Input_Changed_ClassMainStateeBO_6_Input_Changed_Action74State, State);

Dialog_2_eBO_6_Input_Changed_ClassMainStateeBO_6_Input_Changed_Action74State.prototype.entry = function(event) {
	
	// AcceptEventAction: eBO_6_Input_Changed_Action74
	this.eBO_6_Input_Changed_Action74 = function() {
		return event;
	}
	// WriteDataItemAction: eBO_6_Input_Changed_Action75
	this.eBO_6_Input_Changed_Action75 = function(value) {
		var signal = new WriteDataItemSignal();
		signal.setDataItemName('P3_FL');
		signal.setDataItemValue(value);
		eventBus.fireEvent(signal, processController);
	}
	// ReadPresentationModelAction: eBO_6_Input_Changed_Action77
	this.eBO_6_Input_Changed_Action77 = function() {
		return pmUIComponent_Dialog_2_eBO_6_Input;
	}
this.eBO_6_Input_Changed_Action74();
var eBO_6_Input_Changed_ObjectFlow = this.eBO_6_Input_Changed_Action77().value;
this.eBO_6_Input_Changed_Action75(eBO_6_Input_Changed_ObjectFlow);
	this.obj.enterState(this.obj.getMainStateState(), null);
}
