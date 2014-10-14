function RemoteAlarmReceiver(id,notificationMedia,address) {
	// Attribute: NotificationMedia
	//
	var notificationMedia;
	this.setNotificationMedia = function(newVal) {
		this.notificationMedia = newVal;
	}
	this.getNotificationMedia = function() {
		return this.notificationMedia;
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
	
	// Attribute: Address
	//
	var address;
	this.setAddress = function(newVal) {
		this.address = newVal;
	}
	this.getAddress = function() {
		return this.address;
	}

	this.setId(id);
	this.setNotificationMedia(notificationMedia);
	this.setAddress(address);
}