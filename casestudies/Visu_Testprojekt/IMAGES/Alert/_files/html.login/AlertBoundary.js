
/*global DialogList:false, $:false, eventBus:false, processController:false, console:false,
 Alert_ListNewEntry:false,Alert_ListEmpty:false, Alert_Acknowledge:false, Alert_React:false, EventSubscriber:false, extend:false,
 Alert_AS_Variables_Proj_Vis_Visualization_Mailbox_Log_MsgId_changed:false,
 Alert_AS_Variables_Proj_Vis_Visualization_Mailbox_React_AckId_changed:false */


/* protected region PreserveAlert_AlertBoundary on begin */

if (typeof DialogList !== "function") {
    /*$.chainclude([
        "ab/Alert_AlertBoundary/js/EventEmitter.js",
        "ab/Alert_AlertBoundary/js/DialogList.js"
    ]);*/
	(function(){function f(){}function l(b,c){for(var d=b.length;d--;)if(b[d].listener===c)return d;return-1}function k(b){return function(){return this[b].apply(this,arguments)}}var a=f.prototype,m=this,n=m.EventEmitter;a.getListeners=function(b){var c=this._getEvents(),d,e;if(b instanceof RegExp)for(e in d={},c)c.hasOwnProperty(e)&&b.test(e)&&(d[e]=c[e]);else d=c[b]||(c[b]=[]);return d};a.flattenListeners=function(b){var c=[],d;for(d=0;d<b.length;d+=1)c.push(b[d].listener);return c};a.getListenersAsObject=
		function(b){var c=this.getListeners(b),d;c instanceof Array&&(d={},d[b]=c);return d||c};a.addListener=function(b,c){var d=this.getListenersAsObject(b),e="object"===typeof c,a;for(a in d)d.hasOwnProperty(a)&&-1===l(d[a],c)&&d[a].push(e?c:{listener:c,once:!1});return this};a.on=k("addListener");a.addOnceListener=function(b,c){return this.addListener(b,{listener:c,once:!0})};a.once=k("addOnceListener");a.defineEvent=function(b){this.getListeners(b);return this};a.defineEvents=function(b){for(var c=0;c<
		b.length;c+=1)this.defineEvent(b[c]);return this};a.removeListener=function(b,c){var d=this.getListenersAsObject(b),e,a;for(a in d)d.hasOwnProperty(a)&&(e=l(d[a],c),-1!==e&&d[a].splice(e,1));return this};a.off=k("removeListener");a.addListeners=function(b,c){return this.manipulateListeners(!1,b,c)};a.removeListeners=function(b,c){return this.manipulateListeners(!0,b,c)};a.manipulateListeners=function(b,c,d){var a,g,h=b?this.removeListener:this.addListener;b=b?this.removeListeners:this.addListeners;
		if("object"!==typeof c||c instanceof RegExp)for(a=d.length;a--;)h.call(this,c,d[a]);else for(a in c)c.hasOwnProperty(a)&&(g=c[a])&&("function"===typeof g?h.call(this,a,g):b.call(this,a,g));return this};a.removeEvent=function(b){var c=typeof b,a=this._getEvents(),e;if("string"===c)delete a[b];else if(b instanceof RegExp)for(e in a)a.hasOwnProperty(e)&&b.test(e)&&delete a[e];else delete this._events;return this};a.removeAllListeners=k("removeEvent");a.emitEvent=function(b,a){var d=this.getListenersAsObject(b),
		e,g,h,f;for(h in d)if(d.hasOwnProperty(h))for(g=d[h].length;g--;)e=d[h][g],!0===e.once&&this.removeListener(b,e.listener),f=e.listener.apply(this,a||[]),f===this._getOnceReturnValue()&&this.removeListener(b,e.listener);return this};a.trigger=k("emitEvent");a.emit=function(a){var c=Array.prototype.slice.call(arguments,1);return this.emitEvent(a,c)};a.setOnceReturnValue=function(a){this._onceReturnValue=a;return this};a._getOnceReturnValue=function(){return this.hasOwnProperty("_onceReturnValue")?this._onceReturnValue:
		!0};a._getEvents=function(){return this._events||(this._events={})};f.noConflict=function(){m.EventEmitter=n;return f};"function"===typeof define&&define.amd?define(function(){return f}):"object"===typeof module&&module.exports?module.exports=f:this.EventEmitter=f}).call(this);
	var DialogList=null;
	(function(){var l=function(a,b,c){Object.keys(b).forEach(function(d){void 0===a[d]||null===a[d]?a[d]=b[d]:"object"===typeof b[d]&&c&&(a[d]=l(a[d],b[d]))});return a};DialogList=function(a){var b=this;if(!a.$element)throw Error("Option '$element' is needed in order to attach the list to the DOM.");EventEmitter.apply(this);$.extend(this,l(a,this._defaultOptions,!0));DialogList.instanceCounter+=1;this._mainId=DialogList.instanceCounter;this._handles={resize:function(){b.updateTableHead()},option:function(){b.handleOption($(this))},
	selectionSummaryOption:function(){b.handleSelectionToolsOption($(this))},checkBox:function(){b.handleCheckBox($(this))}};this._listData=[];this._idLookup={};this._lockUpdate=!1;this.$list=$(a.$element).addClass(this.cssClass);this._compileTemplates();this._buildTable();this.persist&&this.restoreData();$(window).on("resize",this._handles.resize);this.$list.delegate(this._cssSelectors.checkBox,"change",this._handles.checkBox);this.$body.delegate(this._cssSelectors.optionButton,"click",this._handles.option);
	this.$head.delegate(this._cssSelectors.optionButton,"click",this._handles.selectionSummaryOption)};$.extend(DialogList,{htmlTemplates:{list:'    <div class="%MAIN_CLASS%-dimcheck"></div>   <table class="%MAIN_CLASS%-table">       <thead class="%MAIN_CLASS%-head">           <tr class="%MAIN_CLASS%-headings"></tr>       </thead>       <tbody class="%MAIN_CLASS%-body">       </tbody>   </table>',heading:'<th><span id="%MAIN_CLASS%-%MAIN_ID%-heading_%HEADING_OPTION_CLASS%" class="%MAIN_CLASS%-heading %HEADING_OPTION_CLASS%">%NAME%</span></th>',
	checkBox:'<t%TYPE% class="%MAIN_CLASS%-checkbox-container"><input class="%MAIN_CLASS%-checkbox" type="checkbox"></t%TYPE%>',entry:'<tr id="%MAIN_CLASS%-%MAIN_ID%-entry_%ENTRY_ID%" class="%MAIN_CLASS%-entry"></tr>',property:'<td><span class="%MAIN_CLASS%-%PROPERTY_CLASS%">%VALUE%</span></td>',button:'<button class="%MAIN_CLASS%-optionbutton"><span id="%MAIN_CLASS%-%MAIN_ID%-option_%ENTRY_ID%_%OPTION_ID%" class="%MAIN_CLASS%-option">%OPTION_TEXT%</span></button>',selectionTools:'<tr class="%MAIN_CLASS%-selection-tools">               <td colspan="%COLSPAN%"><span class="%MAIN_CLASS%-selection-summary">Selected 0 elements</span></td>           </tr>',
	emptyCell:"<td></td>",optionCounter:'<span class="%MAIN_CLASS%-optioncounter">%COUNT%</span>'},cssSelectors:{table:".%MAIN_CLASS%-table",headings:".%MAIN_CLASS%-headings",head:".%MAIN_CLASS%-head",body:".%MAIN_CLASS%-body",entry:".%MAIN_CLASS%-entry",selectionSummary:".%MAIN_CLASS%-selection-summary",dimensionCheck:".%MAIN_CLASS%-dimcheck",checkBox:".%MAIN_CLASS%-checkbox",options:".%MAIN_CLASS%-options",optionButton:".%MAIN_CLASS%-optionbutton",option:".%MAIN_CLASS%-option"},regex:{optionId:"^%MAIN_CLASS%-%MAIN_ID%-option_([0-9]+)_([0-9]+)$"},
	instanceCounter:0,entryIdCounter:0,columnDefinitions:{options:{name:"Options",propertyName:"options",cssClass:"options",visible:!0,expand:!1},index:{name:"Index",propertyName:"index",cssClass:"index",visible:!0,expand:!1}},objectTemplates:{entry:{$entry:null,data:null,index:-1,locked:!1,id:null}},optionAggregationOnSelectionMode:{INTERSECTION:0,UNION:1},newEntryInsertionMode:{ATFIRST:0,ATLAST:1}});$.extend(DialogList.prototype,window.EventEmitter.prototype,{_defaultOptions:{persist:!0,persistenceContainer:"webstorage",
	persistenceKey:"dialogList",entriesSelectable:!0,lockEntryOnOption:!0,optionAggregationOnSelectionMode:DialogList.optionAggregationOnSelectionMode.UNION,newEntryInsertionMode:DialogList.newEntryInsertionMode.ATFIRST,cssClass:"dialoglist",columns:[JSON.parse(JSON.stringify(DialogList.columnDefinitions.index)),{name:"Text",propertyName:"text",cssClass:"text",visible:!0,expand:!0,propertyRequired:!0},JSON.parse(JSON.stringify(DialogList.columnDefinitions.options))]},_mainId:null,_handles:null,_htmlTemplates:null,
	_cssSelectors:null,_regex:null,$list:null,$table:null,$head:null,$body:null,$selectionTools:null,$selectionToolsText:null,$dimensionCheck:null,_listData:null,_lockUpdate:!1,_idLookup:null,expandableColumnsCount:0,_compileTemplates:function(){var a=this,b=function(c){var d=JSON.parse(JSON.stringify(c));Object.keys(d).forEach(function(c){"string"===typeof d[c]?d[c]=d[c].replace(/%MAIN_CLASS%/g,a.cssClass).replace(/%MAIN_ID%/g,a._mainId):"object"===typeof d[c]&&(d[c]=b(d[c]))});return d};this._htmlTemplates=
	b(DialogList.htmlTemplates);this._cssSelectors=b(DialogList.cssSelectors);this._regex=b(DialogList.regex)},updateTableHead:function(){var a=this,b=this.$table.find("th").add(this.$table.find("td")),c=this.$body.find("tr").first().find("td").add(this.$head.find("th")),d=-1,e,f,g,h=this.$body.scrollTop;if(!this._lockUpdate){this._lockUpdate=!0;this.emitEvent("updateLocked");this.$table.prepend(this.$head.detach()).removeClass("static-head");this.$body.css("padding-top",null);b.css({width:"","min-width":"",
	"max-width":""});d=this.$dimensionCheck.width()-this.$head.find("tr").first().width()-1;if(0<d){if(0===this.expandableColumnsCount)f=this.$head.find("th").last().add(this.$body.find("tr").first().find("td").last());else for(b=0;b<this.columns.length;b+=1)e=this.entriesSelectable?b+1:b,g=this.columns[b],g.expand&&(f=f?f.add($(this.$head.find("th")[e])):$(this.$head.find("th")[e]));c=c.not(f);f.each(function(){$(this).css({"min-width":$(this).width()+Math.floor(d/a.expandableColumnsCount)+"px","max-width":$(this).width()+
	Math.floor(d/a.expandableColumnsCount)+"px"})})}c.each(function(){$(this).css({"min-width":Math.ceil($(this).width())+"px","max-width":Math.ceil($(this).width())+"px"})});this.$body.css("padding-top",this.$head.outerHeight()+"px");this.$table.add(this.$table.parent()).css("min-height",this.$head.outerHeight()+"px");this.$table.append(this.$head.detach()).addClass("static-head");this.$body.scrollTop(h);this._lockUpdate=!1;this.emitEvent("updatedTableHead");this.emitEvent("updateUnlocked")}},_buildTable:function(){this.$list.append($(this._htmlTemplates.list));
	this.$table=this.$list.find(this._cssSelectors.table);this.$head=this.$table.find(this._cssSelectors.head);this.$body=this.$table.find(this._cssSelectors.body);this.$headings=this.$table.find(this._cssSelectors.headings);this.$dimensionCheck=this.$list.find(this._cssSelectors.dimensionCheck);this._buildTableHead(this.$headings);this._buildSelectionTools(this.$head);this.emitEvent("builtTable");this.updateSelection()},_buildTableHead:function(a){var b,c=null;this.entriesSelectable&&a.append($(this._htmlTemplates.checkBox.replace(/%TYPE%/g,
	"h")));for(b=0;b<this.columns.length;b+=1)c=this.columns[b],c.expand&&(this.expandableColumnsCount+=1),c.$heading=$(this._htmlTemplates.heading.replace(/%HEADING_OPTION_CLASS%/g,c.cssClass).replace(/%NAME%/g,c.name)),a.append(c.$heading);return a},_buildSelectionTools:function(a){var b,c=null,d=1;for(b=0;b<this.columns.length;b+=1)if(c=this.columns[b],c.propertyName===DialogList.columnDefinitions.options.propertyName){d=b;break}b=$(this._htmlTemplates.selectionTools.replace(/%COLSPAN%/g,d));this.entriesSelectable&&
	b.prepend(this._htmlTemplates.emptyCell);b.append(this._htmlTemplates.property.replace(/%PROPERTY_CLASS%/g,"options").replace(/%VALUE%/g,""));this.$selectionTools=b;this.$selectionToolsText=b.find(this._cssSelectors.selectionSummary);return b.appendTo(a)},_buildEntry:function(a){var b,c,d=$(this._htmlTemplates.entry.replace(/%ENTRY_ID%/g,a.id)),e;this.entriesSelectable&&d.append(this._htmlTemplates.checkBox.replace(/%TYPE%/g,"d"));for(b=0;b<this.columns.length;b+=1){e="";c=this.columns[b];if("options"===
	c.propertyName){if(a.data.options&&"function"===typeof a.data.options.push)for(c=0;c<a.data.options.length;c+=1)e+=this._htmlTemplates.button.replace(/%ENTRY_ID%/g,a.id).replace(/%OPTION_ID%/g,c.toString()).replace(/%OPTION_TEXT%/g,a.data.options[c])}else if("index"===c.propertyName)e=a.index.toString();else if(a.data[c.propertyName])e=a.data[c.propertyName];else if(c.propertyRequired)throw Error("Property '"+c.propertyName+"' is required for column '"+c.name+"'");e=$(this._htmlTemplates.property.replace(/%PROPERTY_CLASS%/g,
	this.columns[b].cssClass).replace(/%VALUE%/g,e));d.append(e)}return d},addEntry:function(a){var b=JSON.parse(JSON.stringify(DialogList.objectTemplates.entry)),c=this.$body.scrollTop();DialogList.entryIdCounter+=1;b.id=DialogList.entryIdCounter;b.data=a;this._idLookup[b.id]=b;this.newEntryInsertionMode===DialogList.newEntryInsertionMode.ATFIRST?(b.index=0,b.$entry=this._buildEntry(b),this.$body.prepend(b.$entry),this._listData.splice(0,0,b),this.updateIndices()):(b.index=this._listData.length,b.$entry=
	this._buildEntry(b),this.$body.append(b.$entry),this._listData.push(b));this.updateSelection();this.updateTableHead();this.$body.scrollTop(c);this.emitEvent("addEntry",[b]);this.emitEvent("change");return b.id},addEntries:function(a){var b,c=this.$body.scrollTop(),d=[];this._lockUpdate=!0;this.emitEvent("updateLocked");for(b=0;b<a.length;b+=1)d.push(this.addEntry(a[b]));this._lockUpdate=!1;this.emitEvent("updateUnlocked");this.updateIndices();this.updateSelection();this.updateTableHead();this.$body.scrollTop(c);
	this.emitEvent("addedEntries");this.emitEvent("change");return d},_updateEntry:function(a){var b=this._buildEntry(a);a.$entry.hasClass("selected")&&b.addClass("selected");a.$entry.replaceWith(b);a.$entry=b;a.locked&&(a.locked=!1,this.lockEntry(a.id))},updateEntry:function(a,b){var c,d=!1;if(b&&a&&"string"===typeof a&&this._idLookup[a])return c=this._idLookup[a],Object.keys(b).forEach(function(a){c.data[a]!==b[a]&&(c.data[a]=b[a],d=!0)}),d&&this._updateEntry(c),d},updateIndices:function(){var a;if(!this._lockUpdate){this._lockUpdate=
	!0;for(a=0;a<this._listData.length;a+=1)this._listData[a].index!==a&&(this._listData[a].index=a,this._updateEntry(this._listData[a]));this._lockUpdate=!1}},updateSelection:function(){var a=this,b=this.$head.find(this._cssSelectors.checkBox),c=this.$body.find(this._cssSelectors.checkBox).not(":disabled"),d=c.size(),c=c.filter(":checked").not(":disabled"),e=c.size(),c=c.parents(this._cssSelectors.entry),d=d===e&&0!==d,f=this.$selectionTools.find(this._cssSelectors.options),g={},h=0,k;if(!this._lockUpdate)if(b.prop("checked",
	d),d=this.$body.scrollTop(),b=this.$selectionTools.hasClass("hidden")?0:this.$selectionTools.height(),f.children().remove(),e){if(this.$selectionTools.find(this._cssSelectors.selectionSummary).html("Selected "+e+" elements"),c.find(this._cssSelectors.option).each(function(){var a=$(this).html();g[a]="number"===typeof g[a]?g[a]+1:1}),Object.keys(g).forEach(function(b){k=$(a._htmlTemplates.button.replace(/%ENTRY_ID%/g,"").replace(/%OPTION_ID%/g,h.toString()).replace(/%OPTION_TEXT%/g,b));h+=1;a.optionAggregationOnSelectionMode===
	DialogList.optionAggregationOnSelectionMode.INTERSECTION&&g[b]===e?f.append(k):a.optionAggregationOnSelectionMode===DialogList.optionAggregationOnSelectionMode.UNION&&k.append(a._htmlTemplates.optionCounter.replace(/%COUNT%/g,"("+g[b]+")")).appendTo(f)}),this.$selectionTools.hasClass("hidden")||b!==this.$selectionTools.height())this.$selectionTools.removeClass("hidden"),this.updateTableHead(),this.$body.scrollTop(d+this.$selectionTools.height()-b)}else this.$selectionTools.hasClass("hidden")||(this.$selectionTools.addClass("hidden"),
	this.updateTableHead(),this.$body.scrollTop(d-b))},removeEntry:function(a){var b;if(!a||"number"!==typeof a||!this._idLookup[a])return null;b=this._idLookup[a];this._listData.splice(b.index,1);delete this._idLookup[a];b.$entry.remove();this.updateIndices();this.updateTableHead();this.emitEvent("entryRemoved",[a]);0>=this._listData.length&&this.emitEvent("empty");return b.data},lockEntry:function(a){var b=!0,c;if(a&&this._idLookup[a]&&!this._idLookup[a].locked){this._idLookup[a].locked=!0;this._idLookup[a].$entry.addClass("locked");
	this._idLookup[a].$entry.find("input").prop("disabled",!0);this._idLookup[a].$entry.find("button").prop("disabled",!0);this.updateSelection();this.emitEvent("entryLocked",[a]);for(c in this._listData)if(!this._listData[c].locked){b=!1;break}b&&this.emitEvent("allEntriesLocked")}},unlockEntry:function(a){a&&this._idLookup[a]&&this._idLookup[a].locked&&(this._idLookup[a].locked=!1,this._idLookup[a].$entry.removeClass("locked"),this._idLookup[a].$entry.find("input").prop("disabled",!1),this._idLookup[a].$entry.find("button").prop("disabled",
	!1),this.updateSelection(),this.emitEvent("entryUnlocked",[a]))},restoreData:function(){},persistData:function(){this.emit("persistedData")},handleOption:function(a){a=a.find(this._cssSelectors.option);var b=a.attr("id"),c,d,e;if(c=(new RegExp(this._regex.optionId)).exec(b))b=c[1],c=c[2],(d=this._idLookup[b])&&!d.locked&&(this.lockEntryOnOption&&this.lockEntry(b),e=d.data,this.emitEvent("option",[{optionId:c,entryId:b,option:a.html(),data:e,locked:d.locked}]))},handleSelectionToolsOption:function(a){var b=
	this,c=a.find(this._cssSelectors.option).html();a=this.$body.find(this._cssSelectors.checkBox+":checked").not(":disabled").parents(this._cssSelectors.entry).find(this._cssSelectors.option);var d=[];this._lockUpdate=!0;a.each(function(){$(this).html()===c&&d.push($(this).parents(b._cssSelectors.optionButton))});for(a=0;a<d.length;a+=1)this.handleOption(d[a]);this._lockUpdate=!1;this.updateSelection()},handleCheckBox:function(a){var b=a.parents().is(this.$head),c=this.$body.find(this._cssSelectors.checkBox).not(":disabled"),
	d=a.prop("checked");b?c.prop("checked",d).parents("tr").addClass(d?"selected":"").removeClass(d?"":"selected"):a.parents("tr").addClass(d?"selected":"").removeClass(d?"":"selected");this.updateSelection()},getEntryCount:function(){return this._listData.length},destroy:function(){var a;$(window).off("resize",this._handles.resize);this.$list.unbind(this._handles.option);this.$list.unbind(this._handles.checkBox);this.$list.undelegate(this._cssSelectors.checkBox,"change",this._handles.checkBox);this.$body.undelegate(this._cssSelectors.button,
	"click",this._handles.option);this.$head.undelegate(this._cssSelectors.button,"click",this._handles.selectionSummaryOption);this.$table.remove();this.$list=this.$table=this.$head=this.$body=this.$selectionTools=this.$selectionToolsText=this.$dimensionCheck=null;for(a=0;a<this.columns.length;a+=1)this.columns[a].$heading=null;this._handles={};this.removeAllListeners()}})})();
    //TODO check
    $("head").append('<link rel="stylesheet" href="ab/Alert_AlertBoundary/css/dialoglist.css" />');
}
/* protected region PreserveAlert_AlertBoundary end */

// Boundary: Alert_AlertBoundary
function Alert_AlertBoundary() {
    // Register Boundary to required signals.
    eventBus.subscribe(this, AS_Variables_Proj_Vis_Visualization_Mailbox_Log_MsgId_changed);
    eventBus.subscribe(this, AS_Variables_Proj_Vis_Visualization_Mailbox_React_AckId_changed);

    // Start initialize the code of the provided interface
    this.runProvidedInterface();

    /* protected region PreserveAlert_AlertBoundary_Init on begin */
    // Put here globally required code for Alert_AlertBoundary

    var that = this;
    //TODO check
    this.$listContainer = $("div[id^='Alert'][id*='_AlertContainer'][id$='-container']");
    this.$panel = this.$listContainer.parents('div.movisaPanel');

    this.alertList = new DialogList({
        $element : this.$listContainer,
        optionAggregationOnSelectionMode : DialogList.optionAggregationOnSelectionMode.INTERSECTION,
        columns : [
        	{
                name : "Id",
                propertyName : "msgId",
                cssClass : "msgId",
                visible : true,
                expand : false,
                propertyRequired : true
            }, {
                name : "Message",
                propertyName : "text",
                cssClass : "text",
                visible : true,
                expand : true,
                propertyRequired : true
            }, {
                name: "Options",
                propertyName: "options",
                cssClass: "options",
                visible: true,
                expand : false
            }
        ]
    });

    //find and store needed signals
    this.dataItems = {
        "DataItem_AS_Variables_Proj_Vis_Visualization_Mailbox_Log_MsgId_LP" : null,
        "DataItem_AS_Variables_Proj_Vis_Visualization_Mailbox_Log_Msg_LP" : null,
        "DataItem_AS_Variables_Proj_Vis_Visualization_Mailbox_React_AckId_LP" : null,

        "DataItem_AS_Variables_Proj_Vis_Visualization_Mailbox_Log_Option1_LP" : null,
        "DataItem_AS_Variables_Proj_Vis_Visualization_Mailbox_Log_Option2_LP" : null,
        "DataItem_AS_Variables_Proj_Vis_Visualization_Mailbox_Log_Option3_LP" : null,
        "DataItem_AS_Variables_Proj_Vis_Visualization_Mailbox_Log_Option4_LP" : null,
        "DataItem_AS_Variables_Proj_Vis_Visualization_Mailbox_Log_Option5_LP" : null,
        "DataItem_AS_Variables_Proj_Vis_Visualization_Mailbox_Log_Option6_LP" : null,
        "DataItem_AS_Variables_Proj_Vis_Visualization_Mailbox_Log_Option7_LP" : null
    };

    processController.processModel.dataItemList.forEach(function (di) {
        if (Object.keys(that.dataItems).indexOf(di.id) >= 0) {
            that.dataItems[di.id] = di;
        }
    });

    Object.keys(this.dataItems).forEach(function (id) {
        if (that.dataItems[id] === null) {
            throw new Error("Alert Boundary did not find needed data item with id '" + id + "'!");
        }
    });

    //key === msgId, value === {entryId of alert list, timoutId for timer reset after locking entry}
    this._handledIds = {};

    this.createEntry = function () {
        var data = {
                msgId : null,
                text : null,
                options : []
            },
            getDataItemValue,
            success = true,
            ackSignal,
            entryId;

        getDataItemValue = function (id, property) {
            var di = that.dataItems[id];
            if (!di.dataItemValueList || !di.dataItemValueList.length) {
                console.error("Cannot create alert entry, because value list of data item with id '" + id + "' not found.");
                success = false;
                return;
            }
            if (data[property] && typeof data[property] === "object" && typeof data[property].push === "function") {
                data[property].push(di.dataItemValueList[0].value);
            } else {
                data[property] = di.dataItemValueList[0].value;
            }
        };

        getDataItemValue("DataItem_AS_Variables_Proj_Vis_Visualization_Mailbox_Log_MsgId_LP", "msgId");
        getDataItemValue("DataItem_AS_Variables_Proj_Vis_Visualization_Mailbox_Log_Msg_LP", "text");
        getDataItemValue("DataItem_AS_Variables_Proj_Vis_Visualization_Mailbox_Log_Option1_LP", "options");
        getDataItemValue("DataItem_AS_Variables_Proj_Vis_Visualization_Mailbox_Log_Option2_LP", "options");
        getDataItemValue("DataItem_AS_Variables_Proj_Vis_Visualization_Mailbox_Log_Option3_LP", "options");
        getDataItemValue("DataItem_AS_Variables_Proj_Vis_Visualization_Mailbox_Log_Option4_LP", "options");
        getDataItemValue("DataItem_AS_Variables_Proj_Vis_Visualization_Mailbox_Log_Option5_LP", "options");
        getDataItemValue("DataItem_AS_Variables_Proj_Vis_Visualization_Mailbox_Log_Option6_LP", "options");
        getDataItemValue("DataItem_AS_Variables_Proj_Vis_Visualization_Mailbox_Log_Option7_LP", "options");

        if (!success || !data.text || data.text === "" || data.msgId.toString() === "0" || typeof this._handledIds[data.msgId] === "object") {
            return;
        }

        data.options = data.options.filter(function (val, index) {
            return val !== null && val !== "" && data.options.indexOf(val === index);
        });

        entryId = this.alertList.addEntry(data);
        if (typeof entryId === "number") {
            this._handledIds[data.msgId] = {
                entryId : entryId,
                timeoutId : null
            };

            eventBus.fireEvent(new Alert_ListNewEntry(), null);
            ackSignal = new Alert_Acknowledge();
            ackSignal.setAckId(data.msgId);
            eventBus.fireEvent(ackSignal, null);
        }
    };

    this.alertList.on("option", function (evt) {
        var reactSignal = new Alert_React();

        reactSignal.setMsgId(evt.data.msgId);
        reactSignal.setMsg(evt.option);
        eventBus.fireEvent(reactSignal, null);

        if (that._handledIds[evt.data.msgId].timeoutId !== null) {
            window.clearTimeout(that._handledIds[evt.data.msgId].timeoutId);
        }

        /*that._handledIds[evt.data.msgId].timeoutId = window.setTimeout(function () {
         that.alertList.unlockEntry(that._handledIds[evt.data.msgId].entryId);
         that._handledIds[evt.data.msgId].timeoutId = null;
         }, 2000);*/
    });

    this.handleReactAcknowledge = function (msgId) {
        /*if (!msgId || !this._handledIds[msgId]) {
            return;
        }
        this.alertList.removeEntry(that._handledIds[msgId].entryId);

        if (this._handledIds[msgId].timeoutId !== null) {
            window.clearTimeout(that._handledIds[msgId].timeoutId);
            that._handledIds[msgId].timeoutId = null;
        }*/
    };

    this.alertList.on("empty", function () {
        eventBus.fireEvent(new Alert_ListEmpty(), null);
    });
    this.alertList.on("allEntriesLocked", function () {
        eventBus.fireEvent(new Alert_ListEmpty(), null);
    });
    this.alertList.on("entryUnlocked", function () {
        eventBus.fireEvent(new Alert_ListNewEntry(), null);
    });

    this.$panel.on("panelentry", function () {
        that.alertList.updateTableHead();
    });

    /* protected region PreserveAlert_AlertBoundary_Init end */
}
extend(Alert_AlertBoundary, EventSubscriber);

// Entry function for EventSubscriber
Alert_AlertBoundary.prototype.handleEvent = function (event) {
    /* protected region PreservePreSignalHandling on begin */
    // Put here required code before signal handling
    "use strict";
    /* protected region PreservePreSignalHandling end */

    if (event instanceof AS_Variables_Proj_Vis_Visualization_Mailbox_Log_MsgId_changed) {
        /* protected region PreserveAS_Variables_Proj_Vis_Visualization_Mailbox_Log_MsgId_changed on begin */
        // Put here the code for 'AS_Variables_Proj_Vis_Visualization_Mailbox_Log_MsgId_changed'

        this.createEntry();

        return;

        /* protected region PreserveAS_Variables_Proj_Vis_Visualization_Mailbox_Log_MsgId_changed end */
    }

    if (event instanceof AS_Variables_Proj_Vis_Visualization_Mailbox_React_AckId_changed) {
        /* protected region PreserveAS_Variables_Proj_Vis_Visualization_Mailbox_React_AckId_changed on begin */
        // Put here the code for 'AS_Variables_Proj_Vis_Visualization_Mailbox_React_AckId_changed'
        this.handleReactAcknowledge(event.getActualNotifyingDataItem().Value);
        /* protected region PreserveAS_Variables_Proj_Vis_Visualization_Mailbox_React_AckId_changed end */
    }

    /* protected region PreservePostSignalHandling on begin */
    // Put here required code after signal handling

    /* protected region PreservePostSignalHandling end */
};

Alert_AlertBoundary.prototype.runProvidedInterface = function () {
    // Boundary Provided Interface

    /* protected region PreserveAlert_React on begin */
    // Put here the code for 'Alert_React'

    /* protected region PreserveAlert_React end */
    /* protected region PreserveAlert_ListEmpty on begin */
    // Put here the code for 'Alert_ListEmpty'

    /* protected region PreserveAlert_ListEmpty end */
    /* protected region PreserveAlert_ListNewEntry on begin */
    // Put here the code for 'Alert_ListNewEntry'

    /* protected region PreserveAlert_ListNewEntry end */
    /* protected region PreserveAlert_Acknowledge on begin */
    // Put here the code for 'Alert_Acknowledge'

    /* protected region PreserveAlert_Acknowledge end */
};

