/**
 */
package pamtram.mapping.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pamtram.mapping.ComplexAttributeMatcher;
import pamtram.mapping.ComplexAttributeMatcherSourceElement;
import pamtram.mapping.MappingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Attribute Matcher</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pamtram.mapping.impl.ComplexAttributeMatcherImpl#getSourceAttributes <em>Source Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComplexAttributeMatcherImpl extends AttributeMatcherImpl implements ComplexAttributeMatcher {
	/**
	 * The cached value of the '{@link #getSourceAttributes() <em>Source Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<ComplexAttributeMatcherSourceElement> sourceAttributes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComplexAttributeMatcherImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.COMPLEX_ATTRIBUTE_MATCHER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComplexAttributeMatcherSourceElement> getSourceAttributes() {
		if (sourceAttributes == null) {
			sourceAttributes = new EObjectContainmentEList<ComplexAttributeMatcherSourceElement>(ComplexAttributeMatcherSourceElement.class, this, MappingPackage.COMPLEX_ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTES);
		}
		return sourceAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.COMPLEX_ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTES:
				return ((InternalEList<?>)getSourceAttributes()).basicRemove(otherEnd, msgs);
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
			case MappingPackage.COMPLEX_ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTES:
				return getSourceAttributes();
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
			case MappingPackage.COMPLEX_ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTES:
				getSourceAttributes().clear();
				getSourceAttributes().addAll((Collection<? extends ComplexAttributeMatcherSourceElement>)newValue);
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
			case MappingPackage.COMPLEX_ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTES:
				getSourceAttributes().clear();
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
			case MappingPackage.COMPLEX_ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTES:
				return sourceAttributes != null && !sourceAttributes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ComplexAttributeMatcherImpl
