package de.mfreund.gentrans.transformation;

import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import pamtram.mapping.AttributeValueModifier;
import pamtram.mapping.AttributeValueModifierSet;
import pamtram.metamodel.ActualAttribute;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.VirtualAttribute;

public class AttributeValueRegistry {
	/*
	Maps to help handling unique attribute values of pamtram!Attribute
	*/
	private  HashMap<EClass,HashMap<EAttribute,HashSet<String>>> actualAttributes;
	public HashMap<EClass, HashMap<EAttribute, HashSet<String>>> getAttrValueRegistryActualAttributes() {
		return actualAttributes;
	}


	public HashMap<EClass, HashMap<String, HashSet<String>>> getAttrValueRegistryVirtualAttributes() {
		return virtualAttributes;
	}




	private  HashMap<EClass,HashMap<String, HashSet<String>>> virtualAttributes;
	
	
	
	public AttributeValueRegistry() {
		actualAttributes=new HashMap<EClass,HashMap<EAttribute,HashSet<String>>>();
		virtualAttributes=new HashMap<EClass,HashMap<String, HashSet<String>>>();
	}
	
	
	public boolean attributeValueExists(Attribute attr, String value, EObject eObject){
		if(attr instanceof ActualAttribute){
			if(actualAttributes.get(eObject.eClass()).containsKey(((ActualAttribute) attr).getAttribute())){
				return actualAttributes.get(eObject.eClass()).get(((ActualAttribute) attr).getAttribute()).contains(value);
			}
		} else if(attr instanceof VirtualAttribute){
			if(virtualAttributes.get(eObject.eClass()).containsKey(attr.getName())){
				return virtualAttributes.get(eObject.eClass()).get(attr.getName()).contains(value);
			}
		}
		
		return false;
	}
	
	/**
	 * @param value
	 * @param modifierSets
	 * @return
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
