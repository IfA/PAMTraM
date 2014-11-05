// Clazz: Dialog_1_eBO_4_Select_Option_2_Changed_Class
function Dialog_1_eBO_4_Select_Option_2_Changed_Class() {
	// State: Initial
	//
	var initialState = new Dialog_1_eBO_4_Select_Option_2_Changed_ClassInitialState(this);
	this.setInitialState = function(newVal) {
		initialState = newVal;
	}
	this.getInitialState = function() {
		return initialState;
	}

	// State: MainState
	//
	var mainStateState = new Dialog_1_eBO_4_Select_Option_2_Changed_ClassMainStateState(this);
	this.setMainStateState = function(newVal) {
		mainStateState = newVal;
	}
	this.getMainStateState = function() {
		return mainStateState;
	}

	// State: MainStateeBO_4_Select_Option_2_Changed_Action61
	//
	var mainStateeBO_4_Select_Option_2_Changed_Action61State = new Dialog_1_eBO_4_Select_Option_2_Changed_ClassMainStateeBO_4_Select_Option_2_Changed_Action61State(this);
	this.setMainStateeBO_4_Select_Option_2_Changed_Action61State = function(newVal) {
		mainStateeBO_4_Select_Option_2_Changed_Action61State = newVal;
	}
	this.getMainStateeBO_4_Select_Option_2_Changed_Action61State = function() {
		return mainStateeBO_4_Select_Option_2_Changed_Action61State;
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
	eventBus.subscribe(this, Dialog_1_eBO_4_Select_Option_2_Changed_signal);
	this.enterState(this.getInitialState(), null);
}
extend(Dialog_1_eBO_4_Select_Option_2_Changed_Class, EventSubscriber);
Dialog_1_eBO_4_Select_Option_2_Changed_Class.prototype.handleEvent = function(event) {
	
	// state 'Initial'
	if (this.getState() instanceof Dialog_1_eBO_4_Select_Option_2_Changed_ClassInitialState) {
		// Do nothing on usual Signals, as there is no trigger defined.
	}
	// state 'MainState'
	if (this.getState() instanceof Dialog_1_eBO_4_Select_Option_2_Changed_ClassMainStateState) {
		if (event instanceof Dialog_1_eBO_4_Select_Option_2_Changed_signal) {
			this.enterState(this.getMainStateeBO_4_Select_Option_2_Changed_Action61State(), event);
		}
	}
	// state 'MainStateeBO_4_Select_Option_2_Changed_Action61'
	if (this.getState() instanceof Dialog_1_eBO_4_Select_Option_2_Changed_ClassMainStateeBO_4_Select_Option_2_Changed_Action61State) {
		// Do nothing on usual Signals, as there is no trigger defined.
	}
}

function Dialog_1_eBO_4_Select_Option_2_Changed_ClassInitialState(obj) {
	this.obj = obj;
}
extend(Dialog_1_eBO_4_Select_Option_2_Changed_ClassInitialState, State);

Dialog_1_eBO_4_Select_Option_2_Changed_ClassInitialState.prototype.entry = function(event) {
	
	this.obj.enterState(this.obj.getMainStateState(), null);
}

function Dialog_1_eBO_4_Select_Option_2_Changed_ClassMainStateState(obj) {
	this.obj = obj;
}
extend(Dialog_1_eBO_4_Select_Option_2_Changed_ClassMainStateState, State);

Dialog_1_eBO_4_Select_Option_2_Changed_ClassMainStateState.prototype.entry = function(event) {
	
}

function Dialog_1_eBO_4_Select_Option_2_Changed_ClassMainStateeBO_4_Select_Option_2_Changed_Action61State(obj) {
	this.obj = obj;
}
extend(Dialog_1_eBO_4_Select_Option_2_Changed_ClassMainStateeBO_4_Select_Option_2_Changed_Action61State, State);

Dialog_1_eBO_4_Select_Option_2_Changed_ClassMainStateeBO_4_Select_Option_2_Changed_Action61State.prototype.entry = function(event) {
	
	// AcceptEventAction: eBO_4_Select_Option_2_Changed_Action61
	this.eBO_4_Select_Option_2_Changed_Action61 = function() {
		return event;
	}
	// WriteDataItemAction: eBO_4_Select_Option_2_Changed_Action62
	this.eBO_4_Select_Option_2_Changed_Action62 = function(value) {
		var signal = new WriteDataItemSignal();
		signal.setDataItemName('Behaelter_B_FL');
		signal.setDataItemValue(value);
		eventBus.fireEvent(signal, processController);
	}
	// ValueSpecificationAction: eBO_4_Select_Option_2_Changed_Action63
	this.eBO_4_Select_Option_2_Changed_Action63 = function() {
		return 3;
	}
this.eBO_4_Select_Option_2_Changed_Action61();
var eBO_4_Select_Option_2_Changed_ObjectFlow = this.eBO_4_Select_Option_2_Changed_Action63();
this.eBO_4_Select_Option_2_Changed_Action62(eBO_4_Select_Option_2_Changed_ObjectFlow);
	this.obj.enterState(this.obj.getMainStateState(), null);
}
