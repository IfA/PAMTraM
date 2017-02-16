/**
 */
package pamtram.structure.library.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerParameter;
import pamtram.structure.StructurePackage;
import pamtram.structure.library.ContainerParameter;
import pamtram.structure.target.TargetSection;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Container Parameter</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.structure.library.impl.ContainerParameterImpl#getClass_ <em>Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContainerParameterImpl extends LibraryParameterImpl<AbstractContainerParameter<?, ?>>
		implements ContainerParameter {

	/**
	 * The cached value of the '{@link #getClass_() <em>Class</em>}' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected TargetSection class_;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ContainerParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return StructurePackage.Literals.CONTAINER_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> This is specialized for the more specific type known in this
	 * context.
	 * 
	 * @generated
	 */
	@Override
	public void setOriginalParameter(AbstractContainerParameter<?, ?> newOriginalParameter) {

		super.setOriginalParameter(newOriginalParameter);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public TargetSection getClass_() {

		return this.class_;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetClass(TargetSection newClass, NotificationChain msgs) {

		TargetSection oldClass = this.class_;
		this.class_ = newClass;
		if (this.eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					StructurePackage.CONTAINER_PARAMETER__CLASS, oldClass, newClass);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setClass(TargetSection newClass) {

		if (newClass != this.class_) {
			NotificationChain msgs = null;
			if (this.class_ != null) {
				msgs = ((InternalEObject) this.class_).eInverseRemove(this,
						InternalEObject.EOPPOSITE_FEATURE_BASE - StructurePackage.CONTAINER_PARAMETER__CLASS, null,
						msgs);
			}
			if (newClass != null) {
				msgs = ((InternalEObject) newClass).eInverseAdd(this,
						InternalEObject.EOPPOSITE_FEATURE_BASE - StructurePackage.CONTAINER_PARAMETER__CLASS, null,
						msgs);
			}
			msgs = this.basicSetClass(newClass, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, StructurePackage.CONTAINER_PARAMETER__CLASS,
					newClass, newClass));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {

		switch (featureID) {
			case StructurePackage.CONTAINER_PARAMETER__CLASS:
				return this.basicSetClass(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {

		switch (featureID) {
			case StructurePackage.CONTAINER_PARAMETER__CLASS:
				return this.getClass_();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {

		switch (featureID) {
			case StructurePackage.CONTAINER_PARAMETER__CLASS:
				this.setClass((TargetSection) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {

		switch (featureID) {
			case StructurePackage.CONTAINER_PARAMETER__CLASS:
				this.setClass((TargetSection) null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {

		switch (featureID) {
			case StructurePackage.CONTAINER_PARAMETER__CLASS:
				return this.class_ != null;
		}
		return super.eIsSet(featureID);
	}

} // ContainerParameterImpl
