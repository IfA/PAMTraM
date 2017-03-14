/**
 * Created by baron on 16.06.2014.
 */

/*jshint multistr:true*/

var DialogList = null;

/*global $:false, EventEmitter:false*/

(function () {
    "use strict";
    var applyDefaults = function (o, d, deep) {
            Object.keys(d).forEach(function (prop) {
                if (o[prop] === undefined || o[prop] === null) {
                    o[prop] = d[prop];
                } else if (typeof d[prop] === "object" && deep) {
                    o[prop] = applyDefaults(o[prop], d[prop]);
                }
            });
            return o;
        },
        deepClone = function (o) {
            return JSON.parse(JSON.stringify(o));

        };
    /*,
     now = function (obj, fn, args) {
     var a = [obj];
     if (args && typeof args.push === "function") {
     Array.prototype.push.apply(a, args);
     }
     fn.apply(obj, args || []);
     //window.setTimeout(Function.prototype.bind.apply(fn, a), 1);
     };*/

    //$("head").append('<style type="text/css">' + DialogListCSS + "</style>");

    /**
     *
     * @constructor
     */
    DialogList = function (options) {
        var that = this;

        if (!options.$element) {
            throw new Error("Option '$element' is needed in order to attach the list to the DOM.");
        }

        EventEmitter.apply(this);

        $.extend(this, applyDefaults(options, this._defaultOptions, true));
        DialogList.instanceCounter += 1;
        this._mainId = DialogList.instanceCounter;
        this._handles = {
            resize : function () {
                that.updateTableHead();
            },
            option : function () {
                that.handleOption($(this));
            },
            selectionSummaryOption : function () {
                that.handleSelectionToolsOption($(this));
            },
            checkBox : function () {
                that.handleCheckBox($(this));
            }
        };
        this._listData = [];
        this._idLookup = {};
        this._lockUpdate = false;
        this.$list = $(options.$element).addClass(this.cssClass);

        this._compileTemplates();
        this._buildTable();

        if (this.persist) {
            this.restoreData();
        }

        $(window).on("resize", this._handles.resize);
        this.$list.delegate(this._cssSelectors.checkBox, "change", this._handles.checkBox);
        this.$body.delegate(this._cssSelectors.optionButton, "click", this._handles.option);
        this.$head.delegate(this._cssSelectors.optionButton, "click", this._handles.selectionSummaryOption);
    };

    // static properties

    $.extend(DialogList,
        /**
         * @lends DialogList.
         */
        {
            htmlTemplates : {
                list : ' ' +
                    '   <div class="%MAIN_CLASS%-dimcheck"></div>' +
                    '   <table class="%MAIN_CLASS%-table">' +
                    '       <thead class="%MAIN_CLASS%-head">' +
                    '           <tr class="%MAIN_CLASS%-headings"></tr>' +
                    '       </thead>' +
                    '       <tbody class="%MAIN_CLASS%-body">' +
                    '       </tbody>' +
                    '   </table>',
                heading : '<th><span id="%MAIN_CLASS%-%MAIN_ID%-heading_%HEADING_OPTION_CLASS%" class="%MAIN_CLASS%-heading %HEADING_OPTION_CLASS%">%NAME%</span></th>',
                checkBox : '<t%TYPE% class="%MAIN_CLASS%-checkbox-container"><input class="%MAIN_CLASS%-checkbox" type="checkbox"></t%TYPE%>',
                entry : '<tr id="%MAIN_CLASS%-%MAIN_ID%-entry_%ENTRY_ID%" class="%MAIN_CLASS%-entry"></tr>',
                property : '<td><span class="%MAIN_CLASS%-%PROPERTY_CLASS%">%VALUE%</span></td>',
                button : '<button class="%MAIN_CLASS%-optionbutton"><span id="%MAIN_CLASS%-%MAIN_ID%-option_%ENTRY_ID%_%OPTION_ID%" class="%MAIN_CLASS%-option">%OPTION_TEXT%</span></button>',
                //entryOverlay : '<div class="%MAIN_CLASS%-entryoverlay"></div>',
                selectionTools : '<tr class="%MAIN_CLASS%-selection-tools">' +
                    '               <td colspan="%COLSPAN%"><span class="%MAIN_CLASS%-selection-summary">Selected 0 elements</span></td>' +
                    '           </tr>',
                emptyCell : '<td></td>',
                optionCounter : '<span class="%MAIN_CLASS%-optioncounter">%COUNT%</span>'

            },
            cssSelectors : {
                table : ".%MAIN_CLASS%-table",
                headings : ".%MAIN_CLASS%-headings",
                head : ".%MAIN_CLASS%-head",
                body : ".%MAIN_CLASS%-body",
                entry : ".%MAIN_CLASS%-entry",
                selectionSummary : ".%MAIN_CLASS%-selection-summary",
                dimensionCheck : ".%MAIN_CLASS%-dimcheck",
                checkBox : ".%MAIN_CLASS%-checkbox",
                options : ".%MAIN_CLASS%-options",
                optionButton : ".%MAIN_CLASS%-optionbutton",
                option : ".%MAIN_CLASS%-option"
            },
            regex : {
                optionId : "^%MAIN_CLASS%-%MAIN_ID%-option_([0-9]+)_([0-9]+)$"
            },
            instanceCounter : 0,
            entryIdCounter : 0,
            //entryIdPrefix : "xdee-",

            columnDefinitions : {
                options : {
                    name: "Options",
                    propertyName: "options",
                    cssClass: "options",
                    visible: true,
                    expand : false
                },
                index : {
                    name : "Index",
                    propertyName : "index",
                    cssClass : "index",
                    visible : true,
                    expand : false
                }
            },

            objectTemplates : {
                entry : {
                    $entry : null,
                    data : null,
                    index : -1,
                    locked : false,
                    id : null
                }
            },
            optionAggregationOnSelectionMode : {
                INTERSECTION : 0,
                UNION : 1
            },
            newEntryInsertionMode : {
                ATFIRST : 0,
                ATLAST : 1
            }
        });

    //prototypial properties
    $.extend(DialogList.prototype, window.EventEmitter.prototype,
        /** @lends DialogList# */
        {
            /**
             * @private
             */
            _defaultOptions : {
                persist : true,
                persistenceContainer : "webstorage",
                persistenceKey : "dialogList",
                entriesSelectable : true,
                lockEntryOnOption : true,
                //optionAggregationOnSelectionMode : DialogList.optionAggregationOnSelectionMode.INTERSECTION,
                optionAggregationOnSelectionMode : DialogList.optionAggregationOnSelectionMode.UNION,
                newEntryInsertionMode : DialogList.newEntryInsertionMode.ATFIRST,
                cssClass : "dialoglist",
                columns : [deepClone(DialogList.columnDefinitions.index), {
                    name : "Text",
                    propertyName : "text",
                    cssClass : "text",
                    visible : true,
                    expand : true,
                    propertyRequired : true
                }, deepClone(DialogList.columnDefinitions.options)]
            },
            /**
             * @private
             */
            _mainId : null,
            /**
             * @private
             */
            _handles : null,
            /**
             * @private
             */
            _htmlTemplates : null,
            /**
             * @private
             */
            _cssSelectors : null,

            /**
             * @private
             */
            _regex : null,

            $list : null,
            $table : null,
            $head : null,
            $body : null,
            $selectionTools : null,
            $selectionToolsText : null,
            $dimensionCheck : null,
            /**
             * @private
             */
            _listData : null,
            /**
             * @private
             */
            _lockUpdate : false,
            /**
             * @private
             */
            _idLookup : null,

            /**
             * @private
             */
            expandableColumnsCount : 0,

            _compileTemplates : function () {
                var that = this,
                    compileObjectProperties = function (o) {
                        var result = deepClone(o);
                        Object.keys(result).forEach(function (prop) {
                            if (typeof result[prop] === "string") {
                                result[prop] = result[prop]
                                    .replace(/%MAIN_CLASS%/g, that.cssClass)
                                    .replace(/%MAIN_ID%/g, that._mainId);
                            } else if (typeof result[prop] === "object") {
                                result[prop] = compileObjectProperties(result[prop]);
                            }
                        });
                        return result;
                    };

                this._htmlTemplates = compileObjectProperties(DialogList.htmlTemplates);
                this._cssSelectors = compileObjectProperties(DialogList.cssSelectors);
                this._regex = compileObjectProperties(DialogList.regex);
            },

            //in case of resizing
            updateTableHead : function () {
                var that = this,
                    $allCells = this.$table.find("th").add(this.$table.find("td")),
                    $cells = this.$body.find("tr").first().find("td")
                        //.add(this.$head.find("td"))
                        .add(this.$head.find("th")),
                    oversize = -1,
                    i,
                    j,
                    $expanded,
                    column,
                    scrollTop = this.$body.scrollTop;

                if (this._lockUpdate) {
                    return;
                }
                this._lockUpdate = true;
                this.emitEvent("updateLocked");

                this.$table.prepend(this.$head.detach()).removeClass("static-head");
                this.$body.css("padding-top", null);
                $allCells.css({
                    "width" : "",
                    "min-width" : "",
                    "max-width" : ""
                });

                oversize = this.$dimensionCheck.width() - this.$head.find("tr").first().width() - 1;
                if (oversize > 0) {
                    if (this.expandableColumnsCount === 0) {
                        $expanded = this.$head.find("th").last()
                            //.add(this.$head.find("td").last())
                            .add(this.$body.find("tr").first().find("td").last());
                    } else {
                        for (i = 0; i < this.columns.length; i += 1) {
                            j = this.entriesSelectable ? i + 1 : i;
                            column = this.columns[i];
                            if (column.expand) {
                                $expanded = $expanded ? $expanded.add($(this.$head.find("th")[j])) : $(this.$head.find("th")[j]);
                                //.add(this.$head.find("td").last())
                                //.add($(this.$body.find("tr").first().find("td")[j]));
                            }
                        }
                    }
                    $cells = $cells.not($expanded);
                    $expanded.each(function () {
                        $(this).css({
                            "min-width" : ($(this).width() + Math.floor((oversize / that.expandableColumnsCount))) + "px",
                            "max-width" : ($(this).width() + Math.floor((oversize / that.expandableColumnsCount))) + "px"
                        });
                    });
                }

                $cells.each(function () {
                    $(this).css({
                        "min-width" : Math.ceil($(this).width()) + "px",
                        "max-width" : Math.ceil($(this).width()) + "px"
                    });
                });

                this.$body.css("padding-top", this.$head.outerHeight() + "px");
                this.$table.add(this.$table.parent()).css("min-height", this.$head.outerHeight() + "px");
                this.$table.append(this.$head.detach()).addClass("static-head");
                this.$body.scrollTop(scrollTop);

                this._lockUpdate = false;
                this.emitEvent("updatedTableHead");
                this.emitEvent("updateUnlocked");
            },
            /**
             * @private
             */
            _buildTable : function () {
                this.$list.append($(this._htmlTemplates.list));
                this.$table = this.$list.find(this._cssSelectors.table);
                this.$head = this.$table.find(this._cssSelectors.head);
                this.$body = this.$table.find(this._cssSelectors.body);
                this.$headings = this.$table.find(this._cssSelectors.headings);
                this.$dimensionCheck = this.$list.find(this._cssSelectors.dimensionCheck);

                this._buildTableHead(this.$headings);
                this._buildSelectionTools(this.$head);

                this.emitEvent("builtTable");
                this.updateSelection();
            },
            /**
             * @private
             */
            _buildTableHead : function ($headings) {
                var i,
                    column = null,
                    $result = $headings;

                if (this.entriesSelectable) {
                    $result.append($(this._htmlTemplates.checkBox
                        .replace(/%TYPE%/g, "h")));
                }
                for (i = 0; i < this.columns.length; i += 1) {
                    column = this.columns[i];
                    if (column.expand) {
                        this.expandableColumnsCount += 1;
                    }
                    column.$heading = $(this._htmlTemplates.heading
                        .replace(/%HEADING_OPTION_CLASS%/g, column.cssClass)
                        .replace(/%NAME%/g, column.name));
                    $result.append(column.$heading);
                }
                return $result;
            },
            /**
             * @private
             */
            _buildSelectionTools : function ($head) {
                var i,
                    column = null,
                    colspan = 1,
                    $result;

                for (i = 0; i < this.columns.length; i += 1) {
                    column = this.columns[i];
                    if (column.propertyName === DialogList.columnDefinitions.options.propertyName) {
                        colspan = i;
                        break;
                    }
                }

                $result = $(this._htmlTemplates.selectionTools
                    .replace(/%COLSPAN%/g, colspan));
                if (this.entriesSelectable) {
                    $result.prepend(this._htmlTemplates.emptyCell);
                }
                $result.append(this._htmlTemplates.property
                    .replace(/%PROPERTY_CLASS%/g, "options")
                    .replace(/%VALUE%/g, ""));

                this.$selectionTools = $result;
                this.$selectionToolsText = $result.find(this._cssSelectors.selectionSummary);

                return $result.appendTo($head);
            },
            /**
             * @private
             */
            //TODO ???
            _buildEntry : function (entry) {
                var i,
                    j,
                    $result = $(this._htmlTemplates.entry
                        .replace(/%ENTRY_ID%/g, entry.id)),
                    $property,
                    column,
                    val;

                if (this.entriesSelectable) {
                    $result.append(this._htmlTemplates.checkBox
                        .replace(/%TYPE%/g, "d"));
                }

                for (i = 0; i < this.columns.length; i += 1) {
                    val = "";
                    column = this.columns[i];

                    if (column.propertyName === "options") {
                        if (entry.data.options && typeof entry.data.options.push === "function") {
                            for (j = 0; j < entry.data.options.length; j += 1) {
                                val += this._htmlTemplates.button
                                    .replace(/%ENTRY_ID%/g, entry.id)
                                    .replace(/%OPTION_ID%/g, j.toString())
                                    .replace(/%OPTION_TEXT%/g, entry.data.options[j]);
                            }
                        }
                    } else if (column.propertyName === "index") {
                        val = entry.index.toString();
                    } else if (entry.data[column.propertyName]) {
                        val = entry.data[column.propertyName];
                    } else if (column.propertyRequired) {
                        throw new Error("Property '" + column.propertyName + "' is required for column '" + column.name + "'");
                    }

                    $property = $(this._htmlTemplates.property
                        .replace(/%PROPERTY_CLASS%/g, this.columns[i].cssClass)
                        .replace(/%VALUE%/g, val));

                    $result.append($property);
                }
                //$result.append($(this._htmlTemplates.entryOverlay));
                return $result;
            },
            addEntry : function (data) {
                var entry = deepClone(DialogList.objectTemplates.entry),
                    scrollTop = this.$body.scrollTop();

                //first entry shall be 1
                DialogList.entryIdCounter += 1;
                entry.id = /*DialogList.entryIdPrefix +*/ DialogList.entryIdCounter;
                entry.data = data;
                this._idLookup[entry.id] = entry;

                if (this.newEntryInsertionMode === DialogList.newEntryInsertionMode.ATFIRST) {
                    entry.index = 0;
                    entry.$entry = this._buildEntry(entry);
                    this.$body.prepend(entry.$entry);
                    this._listData.splice(0, 0, entry);
                    this.updateIndices();
                } else {
                    entry.index = this._listData.length;
                    entry.$entry = this._buildEntry(entry);
                    this.$body.append(entry.$entry);
                    this._listData.push(entry);
                }

                this.updateSelection();
                this.updateTableHead();

                this.$body.scrollTop(scrollTop);

                this.emitEvent("addEntry", [entry]);
                this.emitEvent("change");

                return entry.id;
            },
            addEntries : function (data) {
                var i,
                    scrollTop = this.$body.scrollTop(),
                    result = [];
                this._lockUpdate = true;
                this.emitEvent("updateLocked");
                for (i = 0; i < data.length; i += 1) {
                    result.push(this.addEntry(data[i]));
                }
                this._lockUpdate = false;
                this.emitEvent("updateUnlocked");

                this.updateIndices();
                this.updateSelection();
                this.updateTableHead();

                this.$body.scrollTop(scrollTop);
                this.emitEvent("addedEntries");
                this.emitEvent("change");
                return result;
            },
            /*updateAllEntries : function (data) {

             },*/

            /**
             * @private
             */
            _updateEntry : function (entry) {
                var $new = this._buildEntry(entry);

                if (entry.$entry.hasClass("selected")) {
                    $new.addClass("selected");
                }

                entry.$entry.replaceWith($new);
                entry.$entry = $new;

                if (entry.locked) {
                    entry.locked = false;
                    this.lockEntry(entry.id);
                }
            },
            updateEntry : function (id, data) {
                var entry,
                    changed = false;

                if (!data || !id || typeof id !== "string" || !this._idLookup[id]) {
                    return;
                }

                entry = this._idLookup[id];

                Object.keys(data).forEach(function (prop) {
                    if (entry.data[prop] !== data[prop]) {
                        entry.data[prop] = data[prop];
                        changed = true;
                    }
                });

                if (changed) {
                    this._updateEntry(entry);
                }
                return changed;
            },
            updateIndices : function () {
                var i;

                if (this._lockUpdate) {
                    return;
                }
                this._lockUpdate = true;
                for (i = 0; i < this._listData.length; i += 1) {
                    if (this._listData[i].index !== i) {
                        this._listData[i].index = i;
                        this._updateEntry(this._listData[i]);
                    }
                }
                this._lockUpdate = false;
            },

            updateSelection : function () {
                var that = this,
                    $headCB = this.$head.find(this._cssSelectors.checkBox),
                    $allEntryCBs = this.$body.find(this._cssSelectors.checkBox).not(":disabled"),
                    allEntryCount = $allEntryCBs.size(),
                    $allCheckedCB = $allEntryCBs.filter(":checked").not(":disabled"),
                    checkedCount = $allCheckedCB.size(),
                    $allCheckedEntries = $allCheckedCB.parents(this._cssSelectors.entry),
                    allChecked = allEntryCount === checkedCount && allEntryCount !== 0,
                    $selectionOptions = this.$selectionTools.find(this._cssSelectors.options),
                    options = {},
                    optionCounter = 0,
                    selectionToolsHeight,
                    scrollTop,
                    $option;

                if (this._lockUpdate) {
                    return;
                }

                $headCB.prop("checked", allChecked);

                scrollTop = this.$body.scrollTop();
                selectionToolsHeight = this.$selectionTools.hasClass("hidden") ? 0 : this.$selectionTools.height();
                $selectionOptions.children().remove();

                if (checkedCount) {
                    this.$selectionTools.find(this._cssSelectors.selectionSummary)
                        .html("Selected " + checkedCount + " elements");

                    //update options
                    $allCheckedEntries.find(this._cssSelectors.option)
                        .each(function () {
                            var t = $(this).html();
                            if (typeof options[t] === "number") {
                                options[t] += 1;
                            } else {
                                options[t] = 1;
                            }
                        });

                    Object.keys(options).forEach(function (t) {
                        $option = $(that._htmlTemplates.button
                            .replace(/%ENTRY_ID%/g, "")
                            .replace(/%OPTION_ID%/g, optionCounter.toString())
                            .replace(/%OPTION_TEXT%/g, t));
                        optionCounter += 1;
                        if ((that.optionAggregationOnSelectionMode === DialogList.optionAggregationOnSelectionMode.INTERSECTION &&
                            options[t] === checkedCount)) {
                            $selectionOptions.append($option);
                        } else if (that.optionAggregationOnSelectionMode === DialogList.optionAggregationOnSelectionMode.UNION) {
                            $option.append(that._htmlTemplates.optionCounter
                                .replace(/%COUNT%/g, "(" + options[t] + ")")).appendTo($selectionOptions);
                        }
                    });

                    //update visibility of selection tools
                    if (this.$selectionTools.hasClass("hidden") ||
                        selectionToolsHeight !== this.$selectionTools.height()) {
                        this.$selectionTools.removeClass("hidden");
                        this.updateTableHead();
                        this.$body.scrollTop(scrollTop + this.$selectionTools.height() - selectionToolsHeight);
                    }
                } else if (!this.$selectionTools.hasClass("hidden")) {
                    this.$selectionTools.addClass("hidden");
                    this.updateTableHead();
                    this.$body.scrollTop(scrollTop - selectionToolsHeight);
                }
            },
            removeEntry : function (id) {
                var result;

                if (!id || typeof id !== "number" || !this._idLookup[id]) {
                    return null;
                }

                result = this._idLookup[id];

                this._listData.splice(result.index, 1);
                delete this._idLookup[id];
                result.$entry.remove();

                this.updateIndices();
                this.updateTableHead();

                this.emitEvent("entryRemoved", [id]);

                if (this._listData.length <= 0) {
                    this.emitEvent("empty");
                }

                return result.data;
            },
            lockEntry : function (id) {
                var allLocked = true, d;
                if (!id || !this._idLookup[id] || this._idLookup[id].locked) {
                    return;
                }
                this._idLookup[id].locked = true;
                this._idLookup[id].$entry
                    .addClass("locked");
                this._idLookup[id].$entry.find("input").prop("disabled", true);
                this._idLookup[id].$entry.find("button").prop("disabled", true);

                this.updateSelection();
                this.emitEvent("entryLocked", [id]);

                for (d in this._listData) {
                    if (!this._listData[d].locked) {
                        allLocked = false;
                        break;
                    }
                }

                if (allLocked) {
                    this.emitEvent("allEntriesLocked");
                }
            },
            unlockEntry : function (id) {
                if (!id || !this._idLookup[id] || !this._idLookup[id].locked) {
                    return;
                }
                this._idLookup[id].locked = false;
                this._idLookup[id].$entry.removeClass("locked");
                this._idLookup[id].$entry.find("input").prop("disabled", false);
                this._idLookup[id].$entry.find("button").prop("disabled", false);
                this.updateSelection();
                this.emitEvent("entryUnlocked", [id]);
            },
            restoreData : function () {

            },
            persistData : function () {


                this.emit("persistedData");
            },

            handleOption : function ($button) {
                var $option = $button.find(this._cssSelectors.option),
                    id = $option.attr("id"),
                    regexResult,
                    entryId,
                    optionId,
                    entry,
                    data;

                regexResult = (new RegExp(this._regex.optionId)).exec(id);

                if (!regexResult) {
                    return;
                }

                entryId = regexResult[1];
                optionId = regexResult[2];

                entry = this._idLookup[entryId];

                if (entry && !entry.locked) {
                    if (this.lockEntryOnOption) {
                        this.lockEntry(entryId);
                    }
                    data = entry.data;

                    this.emitEvent("option", [{
                        optionId : optionId,
                        entryId : entryId,
                        option : $option.html(),
                        data : data,
                        locked : entry.locked
                    }]);
                }
            },
            handleSelectionToolsOption : function ($button) {
                var that = this,
                    text = $button.find(this._cssSelectors.option).html(),
                    $allCheckedEntryCBs = this.$body
                        .find(this._cssSelectors.checkBox + ":checked").not(":disabled").parents(this._cssSelectors.entry),
                    $allOptions = $allCheckedEntryCBs.find(this._cssSelectors.option),
                    optionsToTrigger = [],
                    i;

                this._lockUpdate = true;

                $allOptions.each(function () {
                    if ($(this).html() === text) {
                        optionsToTrigger.push($(this).parents(that._cssSelectors.optionButton));
                    }
                });
                for (i = 0; i < optionsToTrigger.length; i += 1) {
                    this.handleOption(optionsToTrigger[i]);
                }

                this._lockUpdate = false;
                this.updateSelection();
            },
            handleCheckBox : function ($cb) { //event
                var isHeadCB = $cb.parents().is(this.$head),
                    $allEntryCBs = this.$body.find(this._cssSelectors.checkBox).not(":disabled"),
                    selected = $cb.prop("checked");

                if (isHeadCB) {
                    $allEntryCBs.prop("checked", selected).parents("tr")
                        .addClass(selected ? "selected" : "")
                        .removeClass(selected ? "" : "selected");
                } else {
                    $cb.parents("tr")
                        .addClass(selected ? "selected" : "")
                        .removeClass(selected ? "" : "selected");
                }
                this.updateSelection();
            },

            getEntryCount : function () {
                return this._listData.length;
            },

            destroy : function () {
                var i;
                $(window).off("resize", this._handles.resize);
                this.$list.unbind(this._handles.option);
                this.$list.unbind(this._handles.checkBox);
                this.$list.undelegate(this._cssSelectors.checkBox, "change", this._handles.checkBox);
                this.$body.undelegate(this._cssSelectors.button, "click", this._handles.option);
                this.$head.undelegate(this._cssSelectors.button, "click", this._handles.selectionSummaryOption);

                this.$table.remove();
                this.$list = this.$table =
                    this.$head = this.$body =
                        this.$selectionTools = this.$selectionToolsText =
                            this.$dimensionCheck = null;

                for (i = 0; i < this.columns.length; i += 1) {
                    this.columns[i].$heading = null;
                }

                this._handles = {};

                this.removeAllListeners();
            }
        });
}());