package pamtram;

import org.eclipse.emf.ecore.ENamedElement;

/**
 * An interface that allows the setting of the {@link NamedElement#Name} feature based on
 * an {@link ENamedElement}, on an {@link NamedElement}, or on another {@link String}.
 *  
 * @author mfreund
 */
public interface IDerivedNameSetter {
	
	/**
	 * This sets the {@link NamedElement#Name} feature of the element based on
	 * the '<em><b>name</b></em>' of an {@link ENamedElement} while prepending/appending a prefix and a suffix.
	 * 
	 * @param oldNamedElement The old value of the named element to be used to check if the name needs to be changed.
	 * @param newNamedElement The new value of the named element to be used to set the {@link NamedElement#Name}. 
	 * @param prefix This string will be prepended.
	 * @param suffix This string will be appended.
	 */
	public void setNameDerived(ENamedElement oldNamedElement,
			ENamedElement newNamedElement, String prefix, String suffix);
	
	/**
	 * This sets the {@link NamedElement#Name} feature of the element based on
	 * the '<em><b>name</b></em>' of an {@link NamedElement} while prepending/appending a prefix and a suffix.
	 * 
	 * @param oldNamedElement The old value of the named element to be used to check if the name needs to be changed.
	 * @param newNamedElement The new value of the named element to be used to set the {@link NamedElement#Name}. 
	 * @param prefix This string will be prepended.
	 * @param suffix This string will be appended.
	 */
	public void setNameDerived(NamedElement oldNamedElement,
			NamedElement newNamedElement, String prefix, String suffix);

	/**
	 * This sets the {@link NamedElement#Name} feature of the element based on
	 * another {@link String} while prepending/appending a prefix and a suffix.
	 * 
	 * @param oldString The old string to be used to check if the name needs to be changed.
	 * @param newString The new string to be used to set the {@link NamedElement#Name}. 
	 * @param prefix This string will be prepended.
	 * @param suffix This string will be appended.
	 */
	public void setNameDerived(String oldString,
			String newString, String prefix, String suffix);

}
