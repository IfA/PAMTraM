// Signal: AlarmAcknowledge
function AlarmAcknowledgeSignal(aName,stateId) {

	var alarmName = null;
	this.getAlarmName = function() {
		return alarmName;
	}
	this.setAlarmName = function(name) {
		alarmName = name;
	};
	
		var alarmStateId = null;
	this.getAlarmStateId = function() {
		return alarmStateId;
	}
	this.setAlarmStateId = function(id) {
		alarmStateId = id;
	};
	this.setAlarmName(aName);
	this.setAlarmStateId(stateId);
}
extend(AlarmAcknowledgeSignal, Signal);