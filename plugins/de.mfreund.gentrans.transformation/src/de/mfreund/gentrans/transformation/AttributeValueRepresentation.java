package de.mfreund.gentrans.transformation;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EAttribute;

import pamtram.metamodel.SourceSectionAttribute;

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
	 * This is the {@link SourceSectionAttribute} that this represents.
	 */
	private SourceSectionAttribute attribute;
	
	/**
	 * This represents the values of the attribute. In case where
	 * {@link EAttribute#isMany()} returns '<em><b>false</em></b>', this lsit
	 * will only contain one value.
	 */
	private ArrayList<String> attributeValues = new ArrayList<>();
	
	/**
	 * This pointer is used by {@link #getNextValue()} to determine the 'next' value to return.
	 */
	private int pointer = 0;
	
	/**
	 * This constructs an instance for a single given value.
	 * 
	 * @param value The value to be stored. If '<em><b>null</em></b>' is passed as value,
	 * an empty string will be stored.
	 */
	public AttributeValueRepresentation(SourceSectionAttribute attribute, String value) {
		this.attribute = attribute;
		this.attributeValues.add(value != null ? value : "");
	}
	
	/**
	 * This adds a value to the list of values that the
	 * attribute represents.
	 * 
	 * @param value The value to be added. This must not be '<em><b>null</em></b>'.
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
	
	/**
	 * This adds a prefix to every value that this {@link AttributeValueRepresentation}
	 * currently represents.
	 * 
	 * @param prefix The prefix to add.
	 */
	public void addPrefix(String prefix) {
		for(int i=0; i<attributeValues.size(); i++) {
			attributeValues.set(i, prefix + attributeValues.get(i));
		}
	}
	
	/**
	 * This adds a suffix to every value that this {@link AttributeValueRepresentation}
	 * currently represents.
	 * 
	 * @param suffix The suffix to add.
	 */
	public void addSuffix(String suffix) {
		for(int i=0; i<attributeValues.size(); i++) {
			attributeValues.set(i, attributeValues.get(i) + suffix);
		}
	}
	
	/**
	 * This returns the 'next' value of the list of values. Which value is the 'next' one
	 * to return is determined by an internal counter that is incremented automatically.
	 */
	public String getNextValue() {
		String ret = attributeValues.get(pointer);
		
		// Reset the pointer if all values have already been retrieved.
		// TODO check if this may happen or if we should throw an exception
		if(++pointer == attributeValues.size()) {
			pointer = 0;
		}
		return ret;
	}
	
	@Override
	protected Object clone() {
		/*
		 * Create a new instance and copy every attribute value separately.
		 */
		AttributeValueRepresentation clone = 
				new AttributeValueRepresentation(attribute, getValues().get(0));
		for(int i=1; i < getValues().size(); i++) {
			clone.addValue(getValues().get(i));
		}
		return clone;
	}
}
