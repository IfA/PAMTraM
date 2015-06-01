/**
 */
package pamtram.metamodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import pamtram.impl.NamedElementImpl;
import pamtram.metamodel.LibraryParameter;
import pamtram.metamodel.MetamodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Library Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.LibraryParameterImpl#getSource <em>Source</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.LibraryParameterImpl#getOriginalParameter <em>Original Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LibraryParameterImpl<ParameterType> extends NamedElementImpl implements LibraryParameter<ParameterType> {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected EObject source;

	/**
	 * The cached value of the '{@link #getOriginalParameter() <em>Original Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalParameter()
	 * @generated
	 * @ordered
	 */
	protected ParameterType originalParameter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LibraryParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.LIBRARY_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EObject getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.LIBRARY_PARAMETER__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(EObject newSource) {
		EObject oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.LIBRARY_PARAMETER__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public ParameterType getOriginalParameter() {
		if (originalParameter != null && ((EObject)originalParameter).eIsProxy()) {
			InternalEObject oldOriginalParameter = (InternalEObject)originalParameter;
			originalParameter = (ParameterType)eResolveProxy(oldOriginalParameter);
			if (originalParameter != oldOriginalParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.LIBRARY_PARAMETER__ORIGINAL_PARAMETER, oldOriginalParameter, originalParameter));
			}
		}
		return originalParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterType basicGetOriginalParameter() {
		return originalParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalParameter(ParameterType newOriginalParameter) {
		ParameterType oldOriginalParameter = originalParameter;
		originalParameter = newOriginalParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.LIBRARY_PARAMETER__ORIGINAL_PARAMETER, oldOriginalParameter, originalParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.LIBRARY_PARAMETER__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case MetamodelPackage.LIBRARY_PARAMETER__ORIGINAL_PARAMETER:
				if (resolve) return getOriginalParameter();
				return basicGetOriginalParameter();
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
			case MetamodelPackage.LIBRARY_PARAMETER__SOURCE:
				setSource((EObject)newValue);
				return;
			case MetamodelPackage.LIBRARY_PARAMETER__ORIGINAL_PARAMETER:
				setOriginalParameter((ParameterType)newValue);
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
			case MetamodelPackage.LIBRARY_PARAMETER__SOURCE:
				setSource((EObject)null);
				return;
			case MetamodelPackage.LIBRARY_PARAMETER__ORIGINAL_PARAMETER:
				setOriginalParameter((ParameterType)null);
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
			case MetamodelPackage.LIBRARY_PARAMETER__SOURCE:
				return source != null;
			case MetamodelPackage.LIBRARY_PARAMETER__ORIGINAL_PARAMETER:
				return originalParameter != null;
		}
		return super.eIsSet(featureID);
	}

} //LibraryParameterImpl
