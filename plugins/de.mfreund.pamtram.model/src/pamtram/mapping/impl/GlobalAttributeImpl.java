/**
 */
package pamtram.mapping.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import pamtram.impl.NamedElementImpl;
import pamtram.mapping.ValueModifierSet;
import pamtram.mapping.util.MappingValidator;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.MappingPackage;
import pamtram.metamodel.ActualSourceSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Global Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.impl.GlobalAttributeImpl#getSource <em>Source</em>}</li>
 *   <li>{@link pamtram.mapping.impl.GlobalAttributeImpl#getModifier <em>Modifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GlobalAttributeImpl extends NamedElementImpl implements GlobalAttribute {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected ActualSourceSectionAttribute source;
	/**
	 * The cached value of the '{@link #getModifier() <em>Modifier</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifier()
	 * @generated
	 * @ordered
	 */
	protected EList<ValueModifierSet> modifier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GlobalAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.GLOBAL_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ActualSourceSectionAttribute getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (ActualSourceSectionAttribute)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.GLOBAL_ATTRIBUTE__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActualSourceSectionAttribute basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceGen(ActualSourceSectionAttribute newSource) {
		ActualSourceSectionAttribute oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.GLOBAL_ATTRIBUTE__SOURCE, oldSource, source));
	}
	
	/**
	 * Before setting the {@link newSource}, update the name
	 */
	@Override
	public void setSource(ActualSourceSectionAttribute newSource) {
		setNameDerived(source, newSource, null, null);
		setSourceGen(newSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ValueModifierSet> getModifier() {
		if (modifier == null) {
			modifier = new EObjectResolvingEList<ValueModifierSet>(ValueModifierSet.class, this, MappingPackage.GLOBAL_ATTRIBUTE__MODIFIER);
		}
		return modifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSourceAttributeHasUpperBoundOne(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		boolean result = this.getSource() == null || this.getSource().getAttribute() == null ? true : this.getSource().getAttribute().getUpperBound() == 1;
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "Global attributes may only be defined for attributes that have an upper bound of 1!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					MappingValidator.DIAGNOSTIC_SOURCE,
							MappingValidator.GLOBAL_ATTRIBUTE__VALIDATE_SOURCE_ATTRIBUTE_HAS_UPPER_BOUND_ONE,
							errorMessage,
					new Object[] { this, MappingPackage.Literals.GLOBAL_ATTRIBUTE__SOURCE }));
		
		}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MappingPackage.GLOBAL_ATTRIBUTE__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case MappingPackage.GLOBAL_ATTRIBUTE__MODIFIER:
				return getModifier();
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
			case MappingPackage.GLOBAL_ATTRIBUTE__SOURCE:
				setSource((ActualSourceSectionAttribute)newValue);
				return;
			case MappingPackage.GLOBAL_ATTRIBUTE__MODIFIER:
				getModifier().clear();
				getModifier().addAll((Collection<? extends ValueModifierSet>)newValue);
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
			case MappingPackage.GLOBAL_ATTRIBUTE__SOURCE:
				setSource((ActualSourceSectionAttribute)null);
				return;
			case MappingPackage.GLOBAL_ATTRIBUTE__MODIFIER:
				getModifier().clear();
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
			case MappingPackage.GLOBAL_ATTRIBUTE__SOURCE:
				return source != null;
			case MappingPackage.GLOBAL_ATTRIBUTE__MODIFIER:
				return modifier != null && !modifier.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MappingPackage.GLOBAL_ATTRIBUTE___VALIDATE_SOURCE_ATTRIBUTE_HAS_UPPER_BOUND_ONE__DIAGNOSTICCHAIN_MAP:
				return validateSourceAttributeHasUpperBoundOne((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //GlobalAttributeImpl
