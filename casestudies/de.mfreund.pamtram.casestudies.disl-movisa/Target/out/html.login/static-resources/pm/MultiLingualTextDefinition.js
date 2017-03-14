function MultiLingualTextDefinition(){
	this.languages = {};
	this.textDefinitions = {};
	this.usedLanguage = null;
	this.defaultLanguage = null;
}

/**
 * PUBLIC add a language
 * 
 * @param language
 * 			[String] name of the language
 * @param locale
 * 			[String]
 */
MultiLingualTextDefinition.prototype.addLanguage = function(language, locale){
	this.languages[language] = {"locale": locale};
	
	//set the first added language as default language
	if(this.defaultLanguage == null){
		this.setDefaultLanguage(language);
	}
};

/**
 * PUBLIC add a TextDefinition with its TextItems
 * 
 * @param name
 * 			[String] name of the TextDefinition
 * @param textItems
 * 			[Array] with the TextItems
 */
MultiLingualTextDefinition.prototype.addTextDefinition = function(name, 
		textItems){
	
	var itemLanguage;
	var itemValue;
	
	this.textDefinitions[name] = {};
	
	//add every TextItem to the TextDefinition
	for(var i = 0; i<textItems.length; i++){
		itemLanguage = textItems[i]["Language"];
		itemValue = textItems[i]["Value"];
		
		//use the language of the TextItem as Key
		this.textDefinitions[name][itemLanguage] = itemValue;
	}
};

/**
 * PUBLIC set the used language
 * 
 * @param language
 * 			[String] of the used language
 */
MultiLingualTextDefinition.prototype.setUsedLanguage = function(language){
	this.usedLanguage = language;
};

/**
 * PUBLIC set the default language
 * 
 * @param language
 * 			[String] of the default language
 */
MultiLingualTextDefinition.prototype.setDefaultLanguage = function(language){
	this.defaultLanguage = language;
};

/**
 * PUBLIC get a Text Value in the used language.
 * 
 * @param name
 * 			[String] name of the TextDefinition
 * @returns [String] of the TextDefinition in the used language, if one is set
 * @returns [String] of the TextDefinition in the default language, if
 * 				usedLanguage is not set or no TextItem in usedLanguage
 * 				available
 * @returns [String] an Error-String, if whether the TextDefinition is not given
 * 				in the used and the default language or there is no 
 * 				TextDefinition with $name
 */
MultiLingualTextDefinition.prototype.getTextValue = function(name){
	var defaultLanguage = this.defaultLanguage;
	var language;
	
	if(this.usedLanguage != null){
		language = this.usedLanguage;
	}
	else{
		language = defaultLanguage;
	}
	
	//check if there is a TextDefinition with $name
	if(this.textDefinitions[name] !== undefined){
		//check if the TextItem is available in $language
		if(this.textDefinitions[name][language] != undefined){
			return this.textDefinitions[name][language];
		}
		else{
			//try to retrieve the TextDefintion in the default language
			if(this.textDefinitions[name][defaultLanguage] != undefined){
				return this.textDefinitions[name][defaultLanguage];
			}
		}
	}
	return "";
};