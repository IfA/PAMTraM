/* protected region PreserveMatflow_MatflowBoundary on begin */
	// Put here globally required code for Matflow_MatflowBoundary
var Matflow_Products = null;
$.ajax("./ab/Matflow_MatflowBoundary/products.json", {
	accepts : "application/json",
	contentType : "application/json",
	success : function (data) {
		Matflow_Products = data;
	}
});



var StopperVisualizer = function (dataItemId, $matflow) {
	this.$popup = null;
	this.$matflow = $matflow;
	this.$panel = this.$matflow.parents(".movisaPanel").first();
	this.hidden = true;
	this.matflowName = "Matflow " + (/^MATFLOW_ControlElements_([\S]+)_0_SimpleContainer(_[0-9]+)?-container$/).exec(this.$matflow.attr("id"))[1].replace(/_/g," ")
	this.keepUpToDate = false; // whether to update the popup automatically or only via a manual refresh
	
	this.dataItemId = dataItemId;

	// the productId data item
	this.productIdItem = processController.processModel.dataItemList.
		filter(
			function(di) {
				if(di.id == ("DataItem_" + dataItemId + "_ProductID_LP")) {
					return di;
				}
			}
		)[0];

	// the signalOnChange of the product id item
	this.productIdSignal = this.productIdItem.SignalsOnChange[0];
	
	// the product id value
	this.productIdValue = "";
	if(this.productIdItem.dataItemValueList[0] != null) {
		this.productIdValue = this.productIdItem.dataItemValueList[0].value || "";
	}
	
	// the carrierId data item
	this.carrierIdItem = processController.processModel.dataItemList.
		filter(
			function(di) {
				if(di.id == ("DataItem_" + dataItemId + "_CarrierID_LP")) {
					return di;
				}
			}
		)[0];
	
	// the signalOnChange of the carrier id item
	this.carrierIdSignal = this.carrierIdItem.SignalsOnChange[0];

	// the carrier id value
	this.carrierIdValue = "";
	if(this.carrierIdItem.dataItemValueList[0] != null) {
		this.carrierIdValue = this.carrierIdItem.dataItemValueList[0].value || "";
	}
	
	
	this.show();		
	this.updateCarrierId(this.carrierIdValue);	
	this.updateProductId(this.productIdValue);
	
	eventBus.subscribe(this, this.productIdSignal);
	eventBus.subscribe(this, this.carrierIdSignal);
};
extend(StopperVisualizer, EventSubscriber);

StopperVisualizer.prototype.handleEvent = function(event){
	if(this.keepUpToDate) {
		if (event instanceof this.productIdSignal) {
			this.updateProductId(event.getActualNotifyingDataItem().Value);
		} else if (event instanceof this.carrierIdSignal) {
			this.updateCarrierId(event.getActualNotifyingDataItem().Value);
		}		
	} else {
		if (event instanceof this.productIdSignal) {
			this.productIdValue = event.getActualNotifyingDataItem().Value;
		} else if (event instanceof this.carrierIdSignal) {
			this.carrierIdValue = event.getActualNotifyingDataItem().Value;
		}		
	}
}

StopperVisualizer.prototype.updateProductId = function (productIdValue) {
	var $title = this.$popup.find(".ui-dialog-title"),
		$content = this.$popup.find(".ui-dialog-content"),
		product;
		
	if (!productIdValue || productIdValue.toString() === "0") {
		productIdValue = "";
	}
	this.productIdValue = productIdValue;		
	this.$popup.find(".productIdDisplay").find(".labelValue").html(productIdValue);

	$title.find(".matflow-occupied").remove();
	$content.find(".product-details").remove();
	
	if (productIdValue !== "") {
		$title.prepend('<img class="matflow-occupied" src="./ab/Matflow_MatflowBoundary/img/BufferPlace_occupied_product.png" style="display:block; position:absolute; width:16px; top:6px; left:5px;" />');
		if (Matflow_Products !== null && Matflow_Products.productList[productIdValue]) {
			product = Matflow_Products.productList[productIdValue];
			$content.append('<div class="product-details product-name" style="padding-left:10px;"><span class="labeltext">Product Name: </span><span class="labelValue">' 
				+ product.name + '</span></div>');
			$content.append('<div class="product-details product-description" style="padding-left:10px;><span class="labeltext">Product Description: </span><span class="labelValue">' 
				+ product.description + '</span></div>');
			$content.append('<img class="product-details product-image" src="' + product.img + '" style="position:absolute; height: 30px; width: 30px; top:5px; right:5px;" />');			
		}		
	}
};

StopperVisualizer.prototype.updateCarrierId = function (carrierIdValue) {
	var $titleBar;
	if (!carrierIdValue || carrierIdValue.toString() === "0") {
		carrierIdValue = "";
	}
	this.carrierIdValue = carrierIdValue;
	this.$popup.find(".carrierIdDisplay").find(".labelValue").html(carrierIdValue);
	$titleBar = this.$popup.find(".ui-dialog-titlebar");
	if (carrierIdValue !== "") {
		$titleBar.css({
				"background":"url('./ab/Matflow_MatflowBoundary/img/ui-bg_highlight-soft_75_darkgreen_1x100.png') repeat-x scroll 50% 50%"
			});
	} else {
		$titleBar.css({
			"background":""
		});			
	}
};

StopperVisualizer.prototype.hide = function (event) {
	this.hidden = true;
	
	this.$popup.hide();
	
	if (event) {
		event.preventDefault();
		event.stopPropagation();
	}
	return true;		
	//this.$popup.remove();
	//this.$popup = null;		
};

StopperVisualizer.prototype.handleClick = function (event) {		
	var counter = 3,
		duration = 100,
		that = this,
		animate;
	
	if (event) {
		event.preventDefault();
		event.stopPropagation();
	}
	
	animate = function () {
		if (counter <= 0) {
			return;
		}
		counter -= 1;
		that.$matflow
			.animate({"background-color":"#fdf5ce"}, duration)
			.animate({"background-color":"#ffffff"}, duration);
		that.$matflow.children()
			.animate({"opacity":"0.1"}, duration)
			.animate({"opacity":"1"}, duration, animate);
	};
	
	animate();
	
	//this.$popup.remove();
	//this.$popup = null;		
};
StopperVisualizer.prototype.show = function () {
	this.hidden = false;
	
	if (!this.$popup) {
		this.$popup = 
			$('<div class="matflowPopup">' +
				'<div class="carrierIdDisplay"><span class="labeltext">Carrier ID: </span><span class="labelValue"></span></div>' + 
				'<div class="productIdDisplay"><span class="labeltext">Product ID: </span><span class="labelValue"></span></div>' +
			'</div>');
		
		this.$popup.dialog({
			autoOpen : true,
			modal : false,
			appendTo : this.$panel,
			position: { my: "left top", at: "right top", of: this.$matflow },
			resizable : true,
			draggable : true,
			title : this.matflowName,
			beforeClose : this.hide.bind(this),
			minHeight : 20,
			minWidth : 50,
			width : 235
		});	
		if(!this.keepUpToDate) {
			this.$popup.dialog("option", "buttons", [
	            { 
	            	text: "Auto-Refresh",
	            	icons: { primary: "ui-icon-close"},
	            	id: this.dataItemId + "_upToDate-button",
	            	click: function() {
						if(this.keepUpToDate) {
							this.keepUpToDate = false;
							$('#' + this.dataItemId + '_upToDate-button').button(
									'option', 'icons', { primary: "ui-icon-close"});
							$('#' + this.dataItemId + '_refresh-button').button(
									'option', 'disabled', false);
						} else {
							this.keepUpToDate = true;
							$('#' + this.dataItemId + '_upToDate-button').button(
									'option', 'icons', { primary: "ui-icon-check"});
							$('#' + this.dataItemId + '_refresh-button').button(
									'option', 'disabled', true);
						}
					}.bind(this) 
				}, { 
					icons: { primary: "ui-icon-refresh"},
					text: "Refresh",
					id: this.dataItemId + "_refresh-button",
					click: function() {
						this.updateCarrierId(this.carrierIdValue);	
						this.updateProductId(this.productIdValue);
					}.bind(this) 
				}]);
		}
		this.$popup = this.$popup.parents(".ui-dialog");
		this.$popup.stopperVisualizer = this;
		this.$popup.find(".ui-dialog-titlebar")
				.add(this.$popup.find(".ui-dialog-content"))
			.on("dblclick", this.handleClick.bind(this));
		this.$popup.find(".ui-dialog-title").css({"padding-left":"15px"});
	} else {
		this.$popup.show();
	}
		
};
	
    /* protected region PreserveMatflow_MatflowBoundary end */

// Boundary: Matflow_MatflowBoundary
function Matflow_MatflowBoundary() {
	// Register Boundary to required signals.
	
	// Start initialize the code of the provided interface
	this.runProvidedInterface();
	
    /* protected region PreserveMatflow_MatflowBoundary_Init on begin */
	// Put here initialisation code for Matflow_MatflowBoundary
	var that = this;
	this.visualizers = {};
	this.foo="bar";
	
	$("div").filter(function() {return this.id.match(/^MATFLOW_ControlElements.*SimpleContainer(_[0-9]+)?-container/);}).click(
		function(event){
			event.stopPropagation();
			event.preventDefault();
						
			// the base id (without carrier or product id) 
			// of the data item associated with the selected div 
			var dataItemId = $(this).attr("id").replace(/_0_SimpleContainer(_[0-9]+)?-container/, "");
			
			if (that.visualizers[dataItemId]) {
				if (that.visualizers[dataItemId].hidden) {
					that.visualizers[dataItemId].show();
				} else {
					that.visualizers[dataItemId].hide();
				}
			} else {
				that.visualizers[dataItemId] = new StopperVisualizer(dataItemId, $(this));				
			}
		}
	);
    /* protected region PreserveMatflow_MatflowBoundary_Init end */
}
extend(Matflow_MatflowBoundary, EventSubscriber);

// Entry function for EventSubscriber
Matflow_MatflowBoundary.prototype.handleEvent = function (event) {
    /* protected region PreservePreSignalHandling on begin */
	// Put here required code before signal handling
			
    /* protected region PreservePreSignalHandling end */
	
    /* protected region PreservePostSignalHandling on begin */
	// Put here required code after signal handling
			
    /* protected region PreservePostSignalHandling end */
};

Matflow_MatflowBoundary.prototype.runProvidedInterface = function () {
	// Boundary Provided Interface
	
};

