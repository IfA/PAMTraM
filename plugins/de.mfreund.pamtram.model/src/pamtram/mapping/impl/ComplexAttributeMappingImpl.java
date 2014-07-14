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
import pamtram.mapping.ComplexAttribueMappingSourceElement;
import pamtram.mapping.ComplexAttributeMapping;
import pamtram.mapping.MappingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Attribute Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pamtram.mapping.impl.ComplexAttributeMappingImpl#getSourceAttributeMappings <em>Source Attribute Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComplexAttributeMappingImpl extends AttributeMappingImpl implements ComplexAttributeMapping {
	/**
	 * The cached value of the '{@link #getSourceAttributeMappings() <em>Source Attribute Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceAttributeMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<ComplexAttribueMappingSourceElement> sourceAttributeMappings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComplexAttributeMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.COMPLEX_ATTRIBUTE_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComplexAttribueMappingSourceElement> getSourceAttributeMappings() {
		if (sourceAttributeMappings == null) {
			sourceAttributeMappings = new EObjectContainmentEList<ComplexAttribueMappingSourceElement>(ComplexAttribueMappingSourceElement.class, this, MappingPackage.COMPLEX_ATTRIBUTE_MAPPING__SOURCE_ATTRIBUTE_MAPPINGS);
		}
		return sourceAttributeMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.COMPLEX_ATTRIBUTE_MAPPING__SOURCE_ATTRIBUTE_MAPPINGS:
				return ((InternalEList<?>)getSourceAttributeMappings()).basicRemove(otherEnd, msgs);
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
			case MappingPackage.COMPLEX_ATTRIBUTE_MAPPING__SOURCE_ATTRIBUTE_MAPPINGS:
				return getSourceAttributeMappings();
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
			case MappingPackage.COMPLEX_ATTRIBUTE_MAPPING__SOURCE_ATTRIBUTE_MAPPINGS:
				getSourceAttributeMappings().clear();
				getSourceAttributeMappings().addAll((Collection<? extends ComplexAttribueMappingSourceElement>)newValue);
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
			case MappingPackage.COMPLEX_ATTRIBUTE_MAPPING__SOURCE_ATTRIBUTE_MAPPINGS:
				getSourceAttributeMappings().clear();
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
			case MappingPackage.COMPLEX_ATTRIBUTE_MAPPING__SOURCE_ATTRIBUTE_MAPPINGS:
				return sourceAttributeMappings != null && !sourceAttributeMappings.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ComplexAttributeMappingImpl
