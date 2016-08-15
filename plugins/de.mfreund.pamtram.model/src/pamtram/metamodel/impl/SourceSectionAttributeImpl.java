/**
 */
package pamtram.metamodel.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import pamtram.metamodel.AttributeValueConstraint;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.SourceSection;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source Section Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.SourceSectionAttributeImpl#getValueConstraint <em>Value Constraint</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SourceSectionAttributeImpl extends AttributeImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> implements SourceSectionAttribute {
	/**
	 * The cached value of the '{@link #getValueConstraint() <em>Value Constraint</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueConstraint()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeValueConstraint> valueConstraint;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceSectionAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.SOURCE_SECTION_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeValueConstraint> getValueConstraint() {
		if (valueConstraint == null) {
			valueConstraint = new EObjectContainmentEList<AttributeValueConstraint>(AttributeValueConstraint.class, this, MetamodelPackage.SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINT);
		}
		return valueConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINT:
				return ((InternalEList<?>)getValueConstraint()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINT:
				return getValueConstraint();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MetamodelPackage.SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINT:
				getValueConstraint().clear();
				getValueConstraint().addAll((Collection<? extends AttributeValueConstraint>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MetamodelPackage.SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINT:
				getValueConstraint().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MetamodelPackage.SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINT:
				return valueConstraint != null && !valueConstraint.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SourceSectionAttributeImpl
