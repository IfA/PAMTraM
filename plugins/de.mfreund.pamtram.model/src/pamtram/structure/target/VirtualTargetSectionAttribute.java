/**
 */
package pamtram.structure.target;

import pamtram.structure.generic.VirtualAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Virtual Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This represents an attribute of a target model element structure. In contrast to 'actual' Attributes, 'virtual' Attributes do not represent an actual metamodel element (EAttribtue) an will thus not actually be persisted in the target model.
 * <br /><br />
 * VirtualTargetSectionAttributes are usually used as temporary variables (to store values calculated by means of an AttributeMapping). The stored values can then e.g. be used as reference value for Container- or ReferenceTargetSelectors.
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.structure.target.TargetPackage#getVirtualTargetSectionAttribute()
 * @model
 * @generated
 */
public interface VirtualTargetSectionAttribute extends TargetSectionAttribute, VirtualAttribute<TargetSection, TargetSectionClass, TargetSectionReference, TargetSectionAttribute> {
} // VirtualAttribute
