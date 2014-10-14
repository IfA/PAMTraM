function RemoteAlarm(id,priority,description,helpText) {
	// Attribute: Priority
	//
	var priority;
	this.setPriority = function(newVal) {
		this.priority = newVal;
	}
	this.getPriority = function() {
		return this.priority;
	}
	
	// Attribute: Id = Name
	//
	var id;
	this.setId = function(newVal) {
		this.id = newVal;
	}
	this.getId = function() {
		return this.id;
	}
	
	// Attribute: Description
	//
	var description;
	this.setDescription = function(newVal) {
		this.description = newVal;
	}
	this.getDescription = function() {
		return this.description;
	}
	
	// Attribute: HelpText
	//
	var helpText;
	this.setHelpText = function(newVal) {
		this.helpText = newVal;
	}
	this.getHelpText = function() {
		return this.helpText;
	}
	
	// Attribute: HH AlarmBehavior
	//
	var hhBehavior = null;
	this.setHHBehavior = function(newVal) {
		this.hhBehavior = newVal;
		this.hhBehavior.setIsHighLimit(true);
	}
	this.getHHBehavior = function() {
		return this.hhBehavior;
	}
	
	// Attribute: H AlarmBehavior
	//
	var hBehavior = null;
	this.setHBehavior = function(newVal) {
		this.hBehavior = newVal;
		this.hBehavior.setIsHighLimit(true);
	}
	this.getHBehavior = function() {
		return this.hBehavior;
	}
	
	// Attribute: L AlarmBehavior
	//
	var lBehavior = null;
	this.setLBehavior = function(newVal) {
		this.lBehavior = newVal;
		this.lBehavior.setIsHighLimit(true);
	}
	this.getLBehavior = function() {
		return this.lBehavior;
	}
	
	// Attribute: LL AlarmBehavior
	//
	var llBehavior = null;
	this.setLLBehavior = function(newVal) {
		this.llBehavior = newVal;
		this.llBehavior.setIsHighLimit(true);
	}
	this.getLLBehavior = function() {
		return this.llBehavior;
	}
	
	this.setId(id);
	this.setPriority(priority);
	this.setDescription(description);
	this.setHelpText(helpText);
	this.ReceiversOnHHList = new Array();
	this.ReceiversOnHList = new Array();
	this.ReceiversOnLList = new Array();
	this.ReceiversOnLLList = new Array();
	this.StateList = new Array();
	this.NotificationClassList = new Array();
	var smsCounter = 0;
	var mailCounter = 0;
	var tweetCounter = 0;
	var callCounter = 0;

}
extend(RemoteAlarm, EventSubscriber);//Checkme

RemoteAlarm.prototype.addHHReceiver = function(signal){
	this.ReceiversOnHHList.push(signal);
};
RemoteAlarm.prototype.addHReceiver = function(signal){
	this.ReceiversOnHList.push(signal);
};
RemoteAlarm.prototype.addLReceiver = function(signal){
	this.ReceiversOnLList.push(signal);
};
RemoteAlarm.prototype.addLLReceiver = function(signal){
	this.ReceiversOnLLList.push(signal);
};


//event = AlarmBehaviorSignal
RemoteAlarm.prototype.handleAlarm = function(event,type){
	if(event.IsActive)
	{
		console.log("Handle "+type+" LocalAlarm");
		var ReceiversOnList;
		switch(type)
		{
			case "HH":
			  ReceiversOnList = this.ReceiversOnHHList;
			  break;
			case "H":
			  ReceiversOnList = this.ReceiversOnHList;
			  break;
			case "L":
			  ReceiversOnList = this.ReceiversOnLList;
			  break;
			case "LL":
			  ReceiversOnList = this.ReceiversOnLLList;
			  break;
			default:
			  //Wahaa this is not good!!
		}
		var thisAlarm = this;
		$.each(ReceiversOnList, function(index,value) { 
			console.log("sending RemoteAlarm '"+value.getNotificationMedia()+ "' to " + value.getAddress());
			eval("thisAlarm.send"+value.getNotificationMedia()+"('"+value.getAddress()+"','"+type+"Alarm;"+thisAlarm.getDescription()+"',event)");
		});
	}

}

RemoteAlarm.prototype.sendPHONE_CALL = function(address,msg,event){
var message = "Es wurde der Movisaalarm "+ this.getId() +" ausgeloest. Der Wert zu dem Alarm ist "+event.ValueOnAlarm.toString().replace('.',',')+". Es gibt folgenden Hinweis "+msg;
	console.log("Call Call Call Call");

	var soapy = new SoapMessenger();
	var soapMsg = '<?xml version="1.0" encoding="utf-8"?>'+
					'<soap:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">'+
					  '<soap:Header><TargetService xmlns="http://tu-dresden.de/ifa/">http://91.121.25.10/Service1.asmx</TargetService></soap:Header>'+
					  '<soap:Body>'+
						'<SendCall xmlns="http://91.121.25.10">'+						
							'<address>'+address+'</address>'+
							'<message>'+message+'</message>'+
						'</SendCall>'+
					  '</soap:Body>'+
					'</soap:Envelope>';			   
	soapy.sendMessage('http://'+ window.location.host +'/axis/services/OpcXmlDaProxy?method=myOpcXmlDaProxy',
					soapMsg,"http://91.121.25.10/SendCall", null, function(data){
					if($(data).find('SendCallResult').text() == "Done") {//on success
						console.log("Call sended");
					} else {
						if(this.callCounter < 3) {
							this.callCounter++;
							this.sendSOCIAL_NETWORK(adress,event);
						} else {
							console.log("Fehler beim Anruf: " + $(data).find('SendCallResult').text());
						}
					}
				}, 
				function(data){
				if(this.callCounter < 3) {
							this.callCounter++;
							this.sendSOCIAL_NETWORK(adress,event);
						} else {
							console.log("Fehler beim Anruf: " + $(data).find('SendCallResult').text());
						}
				});
}

RemoteAlarm.prototype.sendSMS = function(address,msg,event){
	var message = (this.getId() +";"+msg+";" + new Date()+";Value:"+event.ValueOnAlarm).slice(0,140);
	console.log("SMS SMS SMS SMS");

	var soapy = new SoapMessenger();
	var soapMsg = '<?xml version="1.0" encoding="utf-8"?>'+
					'<soap:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">'+
					  '<soap:Header><TargetService xmlns="http://tu-dresden.de/ifa/">http://91.121.25.10/Service1.asmx</TargetService></soap:Header>'+
					  '<soap:Body>'+
						'<SendSMS xmlns="http://91.121.25.10">'+
						  '<address>'+address+'</address>'+
						  '<message>'+message+'</message>'+
						'</SendSMS>'+
					  '</soap:Body>'+
					'</soap:Envelope>';			   
	soapy.sendMessage('http://'+ window.location.host +'/axis/services/OpcXmlDaProxy?method=myOpcXmlDaProxy',
					soapMsg,"http://91.121.25.10/SendSMS", null, function(data){
					if($(data).find('SendSMSResult').text() == "Done") {//on success
						console.log("SMS sended");
					} else {
						if(this.smsCounter < 3) {
							this.smsCounter++;
							this.sendSMS(adress,event);
						} else {
							console.log("Fehler beim SMS versand: " + $(data).find('SendSMSResult').text());
						}
					}
				}, 
				function(data){
				if(this.smsCounter < 3) {
							this.smsCounter++;
							this.sendSMS(adress,event);
						} else {
							console.log("Fehler beim SMS versand: " + $(data).find('SendSMSResult').text());
						}
				});
}

RemoteAlarm.prototype.sendEMAIL = function(address,msg,event){
var message = this.getId() +";"+msg+";" + new Date()+";Value:"+event.ValueOnAlarm;
	console.log("Mail Mail Mail Mail");

	var soapy = new SoapMessenger();
	var soapMsg = '<?xml version="1.0" encoding="utf-8"?>'+
					'<soap:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">'+
					  '<soap:Header><TargetService xmlns="http://tu-dresden.de/ifa/">http://91.121.25.10/Service1.asmx</TargetService></soap:Header>'+
					  '<soap:Body>'+
						'<SendMail xmlns="http://91.121.25.10">'+
							'<address>'+address+'</address>'+
							'<subject>Message from Movisa</subject>'+
							'<message>'+message+'</message>'+
						'</SendMail>'+
					  '</soap:Body>'+
					'</soap:Envelope>';			   
	soapy.sendMessage('http://'+ window.location.host +'/axis/services/OpcXmlDaProxy?method=myOpcXmlDaProxy',
					soapMsg,"http://91.121.25.10/SendMail", null, function(data){
					if($(data).find('SendMailResult').text() == "Done") {//on success
						console.log("Mail sended");
					} else {
						if(this.mailCounter < 3) {
							this.mailCounter++;
							this.sendEMAIL(adress,event);
						} else {
							console.log("Fehler beim Mail versand: " + $(data).find('SendMailResult').text());
						}
					}
				}, 
				function(data){
				if(this.mailCounter < 3) {
							this.mailCounter++;
							this.sendEMAIL(adress,event);
						} else {
							console.log("Fehler beim Mail versand: " + $(data).find('SendMailResult').text());
						}
				});
}

RemoteAlarm.prototype.sendSOCIAL_NETWORK = function(address,msg,event){
var message = (this.getId() +";"+msg+";" + new Date()+";Value:"+event.ValueOnAlarm).slice(0,140);
	console.log("Tweet Tweet Tweet Tweet");

	var soapy = new SoapMessenger();
	var soapMsg = '<?xml version="1.0" encoding="utf-8"?>'+
					'<soap:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">'+
					  '<soap:Header><TargetService xmlns="http://tu-dresden.de/ifa/">http://91.121.25.10/Service1.asmx</TargetService></soap:Header>'+
					  '<soap:Body>'+
						'<SendTweet xmlns="http://91.121.25.10">'+						
							'<accountName>'+address+'</accountName>'+
							'<message>'+message+'</message>'+
						'</SendTweet>'+
					  '</soap:Body>'+
					'</soap:Envelope>';			   
	soapy.sendMessage('http://'+ window.location.host +'/axis/services/OpcXmlDaProxy?method=myOpcXmlDaProxy',
					soapMsg,"http://91.121.25.10/SendTweet", null, function(data){
					if($(data).find('SendTweetResult').text() == "Done") {//on success
						console.log("Tweet sended");
					} else {
						if(this.tweetCounter < 3) {
							this.tweetCounter++;
							this.sendSOCIAL_NETWORK(adress,event);
						} else {
							console.log("Fehler beim Tweet versand: " + $(data).find('SendTweetResult').text());
						}
					}
				}, 
				function(data){
				if(this.tweetCounter < 3) {
							this.tweetCounter++;
							this.sendSOCIAL_NETWORK(adress,event);
						} else {
							console.log("Fehler beim Tweet versand: " + $(data).find('SendTweetResult').text());
						}
				});
}


/**
 * PUBLIC handles events send over AlarmBus
 * 
 * @param event
 * 			[AlarmBehaviorSignal] wich was send via braodcast
 */
RemoteAlarm.prototype.handleAlarmBehaviorEvent = function(event){
	console.log("Alarm "+this.getId()+ "received AlarmBehavior Event '" + event.AlarmBehaviorName + "'.");	
	if(this.getHHBehavior() != null)
	{
		if(event.AlarmBehaviorName ==  this.getHHBehavior().getName()){
			console.log("Alarm HH detected!");
			this.handleAlarm(event,"HH");
		}
	}
	if(this.getHBehavior() != null)
	{
		if(event.AlarmBehaviorName ==  this.getHBehavior().getName()){
			console.log("Alarm H detected!");
			this.handleAlarm(event,"H");
		}
	}
	if(this.getLBehavior() != null)
	{
		if(event.AlarmBehaviorName ==  this.getLBehavior().getName()){
			console.log("Alarm L detected!");
			this.handleAlarm(event,"L");
		}
	}
	
	if(this.getLLBehavior() != null)
	{
		if(event.AlarmBehaviorName ==  this.getLLBehavior().getName()){
			console.log("Alarm LL detected!");
			this.handleAlarm(event,"LL");
		}
	}
}
