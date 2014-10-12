/**
 * 
 */
package de.mfreund.gentrans.transformation;

import java.util.LinkedHashMap;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import pamtram.metamodel.ActualAttribute;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.VirtualAttribute;

/**
 * This Class isused for setting Attribute values of an EObject. VirtualAttribute values are stored here.
 * 
 * @author Sascha Steffen
 * @version 0.8 
 */
/**
 * @author sascha
 *
 */
class EObjectTransformationHelper {
	
	/**
	 * The EObject of targetModel whose functionality this Class extends
	 */
	private EObject eObject;
	
	/**
	 * The Registry used for saving Attribute values
	 */
	private AttributeValueRegistry attrValRegistry;
	

	
	/**
	 * Get the associated EObject
	 * 
	 * @return The targetSection EObject
	 */
	public EObject getEObject() {
		return eObject;
	}

	/**
	 * Value storage for the virtual Attributes of this Object
	 */
	private LinkedHashMap<VirtualAttribute,String> virtualAttributes;
	
	/**
	 * Constructor
	 *  
	 * @param eObject associated EObject
	 * @param attrValRegistry AttributeValueRegistry
	 */
	EObjectTransformationHelper(EObject eObject, AttributeValueRegistry attrValRegistry) {
		this.eObject=eObject;
		this.attrValRegistry=attrValRegistry;
		virtualAttributes=new LinkedHashMap<VirtualAttribute,String>();	
	}

	
	/**
	 * Checks if attribute value exists in AttributeValueRegistry
	 * 
	 * @param attr TargetSectionAttribute to be set
	 * @param value value to be checked
	 * @return true if Value exists in AttributeValueRegistry
	 */
	boolean attributeValueExists(TargetSectionAttribute attr, String value){
		return attrValRegistry.attributeValueExists(attr, value, eObject.eClass());
	}
	
	/**
	 * Sets virtual  values of e TargetSectionAttribute
	 * @param attr Attribute to be set
	 * @param value Value to be set
	 * @throws IllegalArgumentException
	 */
	void setAttributeValue(VirtualAttribute attr, String value) {
		virtualAttributes.put(attr, value);

		attrValRegistry.registerValue(attr, eObject.eClass(),value);
	}

	/**
	 * Sets actual values of e TargetSectionAttribute
	 * @param attr Attribute to be set
	 * @param value Value to be set
	 * @throws IllegalArgumentException
	 */
	void setAttributeValue(ActualAttribute attr, String value) throws IllegalArgumentException{
		eObject.eSet(attr.getAttribute(),
				attr.getAttribute().getEType()
				.getEPackage().getEFactoryInstance()
				.createFromString(attr.getAttribute().getEAttributeType(), value));


		attrValRegistry.registerValue(attr, eObject.eClass(),value);

	}	
	
	/**
	 * Static helper method for  converting an Attribute value to a String
	 * @param eObject Target section object
	 * @param attr Attribute
	 * @return Attribute value converted String
	 */
	private static String convertAttributeValue(EObject eObject, EAttribute attr){
		Object srcAttr=eObject.eGet(attr);
		if(attr != null){
			try{
				return attr.getEType().getEPackage().getEFactoryInstance()
					.convertToString(attr.getEAttributeType(),srcAttr);
			} catch(IllegalArgumentException e){//TODO
				e.printStackTrace(System.out);
				return null;
			}
		} else return null;	
		
	}
	

	
	/**
	 * Get Value of an Attribute of the Object
	 * @param attr
	 * @return Attribute value as String
	 */
	String getAttributeValue(TargetSectionAttribute attr){
		if(attr instanceof VirtualAttribute){
			return virtualAttributes.get(attr);
		} else if(attr instanceof ActualAttribute){
			return convertAttributeValue(eObject,((ActualAttribute) attr).getAttribute());
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		String returnString= asString(eObject);
		
		for(VirtualAttribute a : virtualAttributes.keySet()){
			returnString+="\n   " + a.getName() + "(v): " + virtualAttributes.get(a);
		}
		
		return returnString;
	}
	
	/**
	 * Same as toString but without virtual Attributes of course
	 * @param eObject
	 * @return EObjet as String
	 */
	 static String asString(EObject eObject) {
		String returnString=eObject.eClass().getName()  + " (HashCode: " +  eObject.hashCode()+")" ;
		for(EAttribute a : eObject.eClass().getEAllAttributes()){
			String val=convertAttributeValue(eObject,a);
			if(val != null){
				returnString+="\n   " + a.getName() + ": " + val;
			}
		}
		returnString+="\n";

		return returnString;
	}


	/**
	 * Sets values of a TargetSectionAttribute
	 * @param attr
	 * @param setValue
	 * @throws IllegalArgumentException
	 */
	public void setAttributeValue(TargetSectionAttribute attr, String setValue) {
		if(attr instanceof ActualAttribute){
			setAttributeValue((ActualAttribute)attr, setValue);
		} else if(attr instanceof VirtualAttribute){
			setAttributeValue((VirtualAttribute)attr, setValue);
		}
		
	}
	
	

}
