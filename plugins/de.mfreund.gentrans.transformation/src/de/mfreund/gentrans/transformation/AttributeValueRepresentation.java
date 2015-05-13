package de.mfreund.gentrans.transformation;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EAttribute;

/**
 * This represents the (possibly multi-valued) value of an {@link EAttribute}.
 * This class should be used to represent the value(s) of an attribute independent
 * of the cardinality of the attribute.
 * 
 * @author mfreund
 *
 */
public class AttributeValueRepresentation {
	
	/**
	 * This represents the values of the attribute. In case where
	 * {@link EAttribute#isMany()} returns '<em><b>false</em></b>', this lsit
	 * will only contain one value.
	 */
	private ArrayList<String> attributeValues;
	
	/**
	 * This constructs an instance for a single given value.
	 * 
	 * @param value The value to be stored.
	 */
	public AttributeValueRepresentation(String value) {
		attributeValues.add(value);
	}
	
	/**
	 * This adds a value to the list of values that the
	 * attribute represents.
	 * 
	 * @param value The value to be added.
	 */
	public void addValue(String value) {
		attributeValues.add(value);
	}
	
	/**
	 * This method can be used to check if this {@link AttributeValueRepresentation}
	 * currently represents more than one value.
	 * 
	 * @return '<em><b>true</b></em>' if this currently represents more than one value,
	 * '<em><b>false</b></em>' otherwise. 
	 */
	public boolean isMany() {
		return (attributeValues.size() > 1);
	}

	/**
	 * If this attribute currently represents only one value (cf. {@link #isMany()}), this
	 * returns this single value.
	 * 
	 * @return The single value that this {@link AttributeValueRepresentation} currenlty,
	 * represents or '<em><b>null</b></em>' if {@link #isMany()} returns '<em><b>true</b></em>'.
	 */
	public String getValue() {
		if(attributeValues.size() == 1) {
			return attributeValues.get(0);
		} else {
			return null;
		}
	}
	
	/**
	 * This returns the list of values that this {@link AttributeValueRepresentation} 
	 * currently represents.
	 * 
	 * @return The list of values.
	 */
	public ArrayList<String> getValues() {
		return attributeValues;
	}
}
