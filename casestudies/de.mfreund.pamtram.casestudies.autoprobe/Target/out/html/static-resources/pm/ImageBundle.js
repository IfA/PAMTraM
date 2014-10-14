/**
 * Implementation of the ImageBundle
 */
function ImageBundle(){
	this.bundle = {};
}

/**
 * PUBLIC add an image to the ImageBundle
 * 
 * @param imageName
 * 			[String] name of the Image
 * @param imageType
 * 			[String] "FixedImage" or "CameraImage"
 * @param Url
 * 			[String] URL to the image resource
 */
ImageBundle.prototype.addImage = function(imageName, imageType, Url){
	this.bundle[imageName] = {"Name": imageName, "Type": imageType, "Url": Url};
};

/**
 * PUBLIC get an image from the ImageBundle by it's name
 * 
 * @param imageName
 * 			[String] name of the Image
 * @returns [Object] of the image with the properties "Name", "Type" and "Url"
 */
ImageBundle.prototype.getImageByName = function(imageName){
	return this.bundle[imageName];
}