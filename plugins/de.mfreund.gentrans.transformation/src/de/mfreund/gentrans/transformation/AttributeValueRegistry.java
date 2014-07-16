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

public class AttributeValueRegistry {
	/*
	Maps to help handling unique attribute values of pamtram!Attribute
	*/
	private  LinkedHashMap<EClass,LinkedHashMap<EAttribute,LinkedHashSet<String>>> actualAttributes;
	public LinkedHashMap<EClass, LinkedHashMap<EAttribute, LinkedHashSet<String>>> getAttrValueRegistryActualAttributes() {
		return actualAttributes;
	}


	public LinkedHashMap<EClass, LinkedHashMap<String, LinkedHashSet<String>>> getAttrValueRegistryVirtualAttributes() {
		return virtualAttributes;
	}




	private  LinkedHashMap<EClass,LinkedHashMap<String, LinkedHashSet<String>>> virtualAttributes;
	
	
	
	public AttributeValueRegistry() {
		actualAttributes=new LinkedHashMap<EClass,LinkedHashMap<EAttribute,LinkedHashSet<String>>>();
		virtualAttributes=new LinkedHashMap<EClass,LinkedHashMap<String, LinkedHashSet<String>>>();
	}
	
	
	public boolean attributeValueExists(TargetSectionAttribute attr, String value, EObject eObject){
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
