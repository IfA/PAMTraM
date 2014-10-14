function AlarmBehaviorSignal(alarmBehaviorName,isActive,valueOnAlarm,timeStamp) {
this.AlarmBehaviorName = alarmBehaviorName;
this.IsActive = isActive;
this.ValueOnAlarm = valueOnAlarm;
}
extend(AlarmBehaviorSignal, Signal);