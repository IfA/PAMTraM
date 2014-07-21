package de.mfreund.gentrans.transformation;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import pamtram.mapping.AttributeValueModifier;
import pamtram.mapping.AttributeValueModifierSet;
import pamtram.metamodel.ActualAttribute;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.VirtualAttribute;

/**
 * Storage class for values of targetSection attributes used in the transformation
 * @author Sascha Steffen
 * @version 0.8
 */
public class AttributeValueRegistry {
	/**
	Storage of all generated Actual Attribute Values, to be used when handling the unique Attribute of pamtram.metamodel.TargetSectionClass
	*/
	private  LinkedHashMap<EClass,LinkedHashMap<EAttribute,LinkedHashSet<String>>> actualAttributes;
	
	
	/**
	 * @return actualAttributes Map
	 */
	public LinkedHashMap<EClass, LinkedHashMap<EAttribute, LinkedHashSet<String>>> getAttrValueRegistryActualAttributes() {
		return actualAttributes;
	}


	/**
	 * @return  virtualAttributes Map
	 */
	public LinkedHashMap<EClass, LinkedHashMap<VirtualAttribute, LinkedHashSet<String>>> getAttrValueRegistryVirtualAttributes() {
		return virtualAttributes;
	}




	/**
	Storage of all generated Virtual Attribute Values
	*/
	private  LinkedHashMap<EClass,LinkedHashMap<VirtualAttribute, LinkedHashSet<String>>> virtualAttributes;
	
	
	
	/**
	 * Constructor
	 */
	public AttributeValueRegistry() {
		actualAttributes=new LinkedHashMap<EClass,LinkedHashMap<EAttribute,LinkedHashSet<String>>>();
		virtualAttributes=new LinkedHashMap<EClass,LinkedHashMap<VirtualAttribute, LinkedHashSet<String>>>();
	}
	
	
	/**
	 * Check if the value provided was already written as the Attribute value of class of the (exact) same type in the targetModel
	 * <p>
	 * In case of ActualAttributes the EAttribute type is relevant for determining if an Attribute is unique.
	 * VirtualAttributes have no actual reference to the target metamodel and therefore values can only be unique for instances of VirtualAttributes as
	 * modeled in the PAMTraM Model.
	 * 
	 * @param attr Attribute of the PAMTraM Model, 
	 * @param value Val to be set
	 * @param eObject Object whose Attribute val is to be checked
	 * @return true if Value was registered before
	 */
	public boolean attributeValueExists(TargetSectionAttribute attr, String value, EObject eObject){
		if(attr instanceof ActualAttribute){
			if(actualAttributes.get(eObject.eClass()).containsKey(((ActualAttribute) attr).getAttribute())){
				return actualAttributes.get(eObject.eClass()).get(((ActualAttribute) attr).getAttribute()).contains(value);
			}
		} else if(attr instanceof VirtualAttribute){
			if(virtualAttributes.get(eObject.eClass()).containsKey(attr)){
				return virtualAttributes.get(eObject.eClass()).get(attr).contains(value);
			}
		}
		
		return false;
	}
	
	/**
	 * Static method for applying attribute value modifiers to 
	 * @param value 
	 * @param modifierSets
	 * @return modified String
	 */
	public static String applyAttributeValueModifiers(final String value,
			EList<AttributeValueModifierSet> modifierSets) {
		String retVal = value;
		for (AttributeValueModifierSet set : modifierSets) {
			for (AttributeValueModifier m : set.getModifier()) {
				retVal = m.modify(retVal);
			}
		}
		return retVal;
	}

}
