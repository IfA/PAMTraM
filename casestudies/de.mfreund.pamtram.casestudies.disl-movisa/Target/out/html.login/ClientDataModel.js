
$.chainclude(
	[
		"static-resources/cdm/atomicFunctions.js",
		"static-resources/cdm/Hashtable.js",
		"static-resources/cdm/SoapMessenger.js",
		"static-resources/cdm/Server.js",
		"static-resources/cdm/LocalServer.js",
		"static-resources/cdm/ProcessModel.js",
		"static-resources/cdm/ProcessController.js",
		"static-resources/cdm/alarm/AlarmBehavior.js",
		"static-resources/cdm/alarm/AlarmController.js",
		"static-resources/cdm/alarm/Alarm.js",
		"static-resources/cdm/alarm/AlarmAcknowledgeSignal.js",
		"static-resources/cdm/alarm/LocalAlarm.js",
		"static-resources/cdm/alarm/AlarmBehaviorSignal.js",
		"static-resources/cdm/alarm/AlarmStateChangedSignal.js",
		"static-resources/cdm/alarm/NotificationClass.js",		
		"static-resources/cdm/alarm/RemoteAlarm.js",
		"static-resources/cdm/alarm/RemoteAlarmReceiver.js",
//<generated includes>
		"static-resources/cdm/opcxmlda/OpcXmlDaSoapMessenger.js",
		"static-resources/cdm/opcxmlda/OpcXmlDaServer.js",
//</generated includes>
	],
	function() {
		cdmReady = true;
		go();
	}
);

var processController; 
var alarmBus;

function initCDM(){
alarmBus = new AlarmBus();
processController = new ProcessController();
//<generated Code>	
var TP_Behaelter_A_FL = new OpcXmlDaItem("TP_Behaelter_A_FL","int","","Schneider/Behaelter_A_FL");
var TP_Behaelter_B_FL = new OpcXmlDaItem("TP_Behaelter_B_FL","int","","Schneider/Behaelter_B_FL");
var TP_Start_Umpumpen_FL = new OpcXmlDaItem("TP_Start_Umpumpen_FL","boolean","","Schneider/Start_Umpumpen_FL");
var TP_Ventil1_Soll = new OpcXmlDaItem("TP_Ventil1_Soll","int","","Schneider/V1_FL");
var TP_Ventil2_Soll = new OpcXmlDaItem("TP_Ventil2_Soll","int","","Schneider/V2_FL");
var TP_Pumpe3_Soll = new OpcXmlDaItem("TP_Pumpe3_Soll","int","","Schneider/P3_FL");
var ifaXmlDa = new OpcXmlDaServer("de-DE","http://141.30.154.211:8087/OPC/DA",'http://'+ window.location.host +'/axis/services/OpcXmlDaProxy?method=myOpcXmlDaProxy',new Array(TP_Pumpe3_Soll, TP_Behaelter_A_FL, TP_Ventil2_Soll, TP_Ventil1_Soll, TP_Start_Umpumpen_FL, TP_Behaelter_B_FL));
processController.addServer(ifaXmlDa);
//DataItems
var Behaelter_A_FL = new DataItem("Behaelter_A_FL", "" ,false,0, TP_Behaelter_A_FL, 1.0, 0, "Integer", "Integer");
Behaelter_A_FL.addSignalOnChange(Behaelter_A_FL_Changed);
var Behaelter_B_FL = new DataItem("Behaelter_B_FL", "" ,false,0, TP_Behaelter_B_FL, 1.0, 0, "Integer", "Integer");
Behaelter_B_FL.addSignalOnChange(Behaelter_B_FL_Changed);
var V1_FL = new DataItem("V1_FL", "" ,false,0, TP_Ventil1_Soll, 1.0, 0, "Integer", "Integer");
V1_FL.addSignalOnChange(V1_FL_Changed);
var V2_FL = new DataItem("V2_FL", "" ,false,0, TP_Ventil2_Soll, 1.0, 0, "Integer", "Integer");
V2_FL.addSignalOnChange(V2_FL_Changed);
var P3_FL = new DataItem("P3_FL", "" ,false,0, TP_Pumpe3_Soll, 1.0, 0, "Integer", "Integer");
P3_FL.addSignalOnChange(P3_FL_Changed);
var Start_Umpumpen_FL = new DataItem("Start_Umpumpen_FL", "" ,false,0, TP_Start_Umpumpen_FL, 1.0, 0, "Integer", "Boolean");
Start_Umpumpen_FL.addSignalOnChange(Start_Umpumpen_FL_Changed);
var processModell = new ProcessModel(new Array(V1_FL, Start_Umpumpen_FL, V2_FL, P3_FL, Behaelter_A_FL, Behaelter_B_FL));
processController.setProcessModel(processModell);
processController.addServerList( new Array(ifaXmlDa));
//</generated Code>	
}
function exit(){
	processController.cancelAllSubscriptions();
}

