/**
 * 
 */
package de.mfreund.gentrans.transformation;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

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
		if(!attrValRegistry.getAttrValueRegistryActualAttributes().containsKey(eObject.eClass())){
			
			attrValRegistry.getAttrValueRegistryActualAttributes().put(eObject.eClass(), new LinkedHashMap<EAttribute,LinkedHashSet<String>>());
			attrValRegistry.getAttrValueRegistryVirtualAttributes().put(eObject.eClass(), new LinkedHashMap<VirtualAttribute,LinkedHashSet<String>>());
		}		
	}

	
	/**
	 * Checks if attribute value exists in AttributeValueRegistry
	 * 
	 * @param attr TargetSectionAttribute to be set
	 * @param value value to be checked
	 * @return true if Value exists in AttributeValueRegistry
	 */
	boolean attributeValueExists(TargetSectionAttribute attr, String value){
		return attrValRegistry.attributeValueExists(attr, value, eObject);
	}
	
	/**
	 * Sets virtual or actual values of e TargetSectionAttribute
	 * @param attr Attribute to be set
	 * @param value Value to be set
	 * @throws IllegalArgumentException
	 */
	void setAttributeValue(TargetSectionAttribute attr, String value) throws IllegalArgumentException{
		if(attr instanceof VirtualAttribute){
			virtualAttributes.put((VirtualAttribute) attr, value);
			
			//add value to registry
			if(!attrValRegistry.getAttrValueRegistryVirtualAttributes().get(eObject.eClass()).containsKey(attr)){
				attrValRegistry.getAttrValueRegistryVirtualAttributes().get(eObject.eClass()).put((VirtualAttribute) attr, new LinkedHashSet<String>());
			}
			attrValRegistry.getAttrValueRegistryVirtualAttributes().get(eObject.eClass()).get(attr).add(value);
		} else if(attr instanceof ActualAttribute){
				eObject.eSet(((ActualAttribute) attr).getAttribute(),
						((ActualAttribute) attr).getAttribute().getEType()
						.getEPackage().getEFactoryInstance()
						.createFromString(((ActualAttribute) attr).getAttribute().getEAttributeType(), value));

			
			if(!attrValRegistry.getAttrValueRegistryActualAttributes().get(eObject.eClass()).containsKey(((ActualAttribute) attr).getAttribute())){
				attrValRegistry.getAttrValueRegistryActualAttributes().get(eObject.eClass()).put(((ActualAttribute) attr).getAttribute(), new LinkedHashSet<String>());
			}
			attrValRegistry.getAttrValueRegistryActualAttributes().get(eObject.eClass()).get(((ActualAttribute) attr).getAttribute()).add(value);
		}
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
	
	

}
