/* protected region PreserveMisc_LoginButton_boundary on begin */
// Put here globally required code for Misc_LoginButton_boundary
		
/* protected region PreserveMisc_LoginButton_boundary end */

// Boundary: Misc_LoginButton_boundary
function Misc_LoginButton_boundary() {
	// Register Boundary to required signals.
    eventBus.subscribe(this, Login_LoginClicked);
	
	// Start initialize the code of the provided interface
	this.runProvidedInterface();
	
    /* protected region PreserveMisc_LoginButton_boundary_Init on begin */
	// Put here initialisation code for Misc_LoginButton_boundary
			
    /* protected region PreserveMisc_LoginButton_boundary_Init end */
}
extend(Misc_LoginButton_boundary, EventSubscriber);

// Entry function for EventSubscriber
Misc_LoginButton_boundary.prototype.handleEvent = function (event) {
    /* protected region PreservePreSignalHandling on begin */
	// Put here required code before signal handling
			
    /* protected region PreservePreSignalHandling end */
	
	if (event instanceof Login_LoginClicked) {
    /* protected region PreserveLogin_LoginClicked on begin */
	// Put here the code for 'Login_LoginClicked'
		var targetUrl = window.location.origin;
		var pathArray = window.location.pathname.split("/");
		for(var i=1; i< (pathArray.length -1); i++) {
			targetUrl += ("/" + pathArray[i]);
		}
		targetUrl += ("/destroySession.jsp");
		__opcres.terminal = null;
		window.location.replace(targetUrl);
    /* protected region PreserveLogin_LoginClicked end */
	}
	
    /* protected region PreservePostSignalHandling on begin */
	// Put here required code after signal handling
			
    /* protected region PreservePostSignalHandling end */
};

Misc_LoginButton_boundary.prototype.runProvidedInterface = function () {
	// Boundary Provided Interface
	
};

