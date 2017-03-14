// Clazz: Dialog_1_eBO_2_Select_Option_2_Changed_Class
function Dialog_1_eBO_2_Select_Option_2_Changed_Class() {
	// State: Initial
	//
	var initialState = new Dialog_1_eBO_2_Select_Option_2_Changed_ClassInitialState(this);
	this.setInitialState = function(newVal) {
		initialState = newVal;
	}
	this.getInitialState = function() {
		return initialState;
	}

	// State: MainState
	//
	var mainStateState = new Dialog_1_eBO_2_Select_Option_2_Changed_ClassMainStateState(this);
	this.setMainStateState = function(newVal) {
		mainStateState = newVal;
	}
	this.getMainStateState = function() {
		return mainStateState;
	}

	// State: MainStateeBO_2_Select_Option_2_Changed_Action49
	//
	var mainStateeBO_2_Select_Option_2_Changed_Action49State = new Dialog_1_eBO_2_Select_Option_2_Changed_ClassMainStateeBO_2_Select_Option_2_Changed_Action49State(this);
	this.setMainStateeBO_2_Select_Option_2_Changed_Action49State = function(newVal) {
		mainStateeBO_2_Select_Option_2_Changed_Action49State = newVal;
	}
	this.getMainStateeBO_2_Select_Option_2_Changed_Action49State = function() {
		return mainStateeBO_2_Select_Option_2_Changed_Action49State;
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
	eventBus.subscribe(this, Dialog_1_eBO_2_Select_Option_2_Changed_signal);
	this.enterState(this.getInitialState(), null);
}
extend(Dialog_1_eBO_2_Select_Option_2_Changed_Class, EventSubscriber);
Dialog_1_eBO_2_Select_Option_2_Changed_Class.prototype.handleEvent = function(event) {
	
	// state 'Initial'
	if (this.getState() instanceof Dialog_1_eBO_2_Select_Option_2_Changed_ClassInitialState) {
		// Do nothing on usual Signals, as there is no trigger defined.
	}
	// state 'MainState'
	if (this.getState() instanceof Dialog_1_eBO_2_Select_Option_2_Changed_ClassMainStateState) {
		if (event instanceof Dialog_1_eBO_2_Select_Option_2_Changed_signal) {
			this.enterState(this.getMainStateeBO_2_Select_Option_2_Changed_Action49State(), event);
		}
	}
	// state 'MainStateeBO_2_Select_Option_2_Changed_Action49'
	if (this.getState() instanceof Dialog_1_eBO_2_Select_Option_2_Changed_ClassMainStateeBO_2_Select_Option_2_Changed_Action49State) {
		// Do nothing on usual Signals, as there is no trigger defined.
	}
}

function Dialog_1_eBO_2_Select_Option_2_Changed_ClassInitialState(obj) {
	this.obj = obj;
}
extend(Dialog_1_eBO_2_Select_Option_2_Changed_ClassInitialState, State);

Dialog_1_eBO_2_Select_Option_2_Changed_ClassInitialState.prototype.entry = function(event) {
	
	this.obj.enterState(this.obj.getMainStateState(), null);
}

function Dialog_1_eBO_2_Select_Option_2_Changed_ClassMainStateState(obj) {
	this.obj = obj;
}
extend(Dialog_1_eBO_2_Select_Option_2_Changed_ClassMainStateState, State);

Dialog_1_eBO_2_Select_Option_2_Changed_ClassMainStateState.prototype.entry = function(event) {
	
}

function Dialog_1_eBO_2_Select_Option_2_Changed_ClassMainStateeBO_2_Select_Option_2_Changed_Action49State(obj) {
	this.obj = obj;
}
extend(Dialog_1_eBO_2_Select_Option_2_Changed_ClassMainStateeBO_2_Select_Option_2_Changed_Action49State, State);

Dialog_1_eBO_2_Select_Option_2_Changed_ClassMainStateeBO_2_Select_Option_2_Changed_Action49State.prototype.entry = function(event) {
	
	// AcceptEventAction: eBO_2_Select_Option_2_Changed_Action49
	this.eBO_2_Select_Option_2_Changed_Action49 = function() {
		return event;
	}
	// WriteDataItemAction: eBO_2_Select_Option_2_Changed_Action50
	this.eBO_2_Select_Option_2_Changed_Action50 = function(value) {
		var signal = new WriteDataItemSignal();
		signal.setDataItemName('Behaelter_A_FL');
		signal.setDataItemValue(value);
		eventBus.fireEvent(signal, processController);
	}
	// ValueSpecificationAction: eBO_2_Select_Option_2_Changed_Action51
	this.eBO_2_Select_Option_2_Changed_Action51 = function() {
		return 3;
	}
this.eBO_2_Select_Option_2_Changed_Action49();
var eBO_2_Select_Option_2_Changed_ObjectFlow = this.eBO_2_Select_Option_2_Changed_Action51();
this.eBO_2_Select_Option_2_Changed_Action50(eBO_2_Select_Option_2_Changed_ObjectFlow);
	this.obj.enterState(this.obj.getMainStateState(), null);
}
