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
 * @author Sascha Steffen
 * @version 0.8 
 */
public class EObjectTransformationHelper {
	
	/**
	 * The EObject of targetModel whose functionality this 
	 */
	private EObject eObject;
	
	private AttributeValueRegistry attrValRegistry;
	

	
	public EObject getEObject() {
		return eObject;
	}

	private LinkedHashMap<VirtualAttribute,String> virtualAttributes;
	
	public EObjectTransformationHelper(EObject eObject, AttributeValueRegistry attrValRegistry) {
		this.eObject=eObject;
		this.attrValRegistry=attrValRegistry;
		virtualAttributes=new LinkedHashMap<VirtualAttribute,String>();
		if(!attrValRegistry.getAttrValueRegistryActualAttributes().containsKey(eObject.eClass())){
			
			attrValRegistry.getAttrValueRegistryActualAttributes().put(eObject.eClass(), new LinkedHashMap<EAttribute,LinkedHashSet<String>>());
			attrValRegistry.getAttrValueRegistryVirtualAttributes().put(eObject.eClass(), new LinkedHashMap<VirtualAttribute,LinkedHashSet<String>>());
		}		
	}

	public boolean attributeValueExists(TargetSectionAttribute attr, String value){
		return attrValRegistry.attributeValueExists(attr, value, eObject);
	}
	
	public void setAttributeValue(TargetSectionAttribute attr, String value) throws IllegalArgumentException{
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
	

	
	public String getAttributeValue(TargetSectionAttribute attr){
		if(attr instanceof VirtualAttribute){
			return virtualAttributes.get(attr);
		} else if(attr instanceof ActualAttribute){
			return convertAttributeValue(eObject,((ActualAttribute) attr).getAttribute());
		}
		return null;
	}

	@Override
	public String toString(){
		String returnString= asString(eObject);
		
		for(VirtualAttribute a : virtualAttributes.keySet()){
			returnString+="\n   " + a.getName() + "(v): " + virtualAttributes.get(a);
		}
		
		return returnString;
	}
	
	public static String asString(EObject eObject) {
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
