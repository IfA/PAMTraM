// Signal: AlarmStateChangedSignal
function AlarmStateChangedSignal(alarmName,alarmState) {

	var actualAlarmStateItem = null;
	this.getActualAlarmStateItem = function() {
		return actualAlarmStateItem;
	}
	this.setActualAlarmStateItem = function(alarmName,alarmState) {
		actualAlarmStateItem = {
				'Name' : alarmName,
				'AlarmState' : alarmState
		};
	};
	this.setActualAlarmStateItem(alarmName,alarmState);
}
extend(AlarmStateChangedSignal, Signal);
