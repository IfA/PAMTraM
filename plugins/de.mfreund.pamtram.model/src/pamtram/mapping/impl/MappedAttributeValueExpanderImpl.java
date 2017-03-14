/**
 */
package pamtram.mapping.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import pamtram.mapping.ExpandableHint;
import pamtram.mapping.ExternalMappedAttributeValueExpander;
import pamtram.mapping.LocalMappedAttributeValueExpander;
import pamtram.mapping.MappedAttributeValueExpander;
import pamtram.mapping.MappingPackage;
import pamtram.structure.source.SourceSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapped Attribute Value Expander</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.impl.MappedAttributeValueExpanderImpl#getHintsToExpand <em>Hints To Expand</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MappedAttributeValueExpanderImpl extends HintImporterMappingHintImpl implements MappedAttributeValueExpander {
	/**
	 * The cached value of the '{@link #getHintsToExpand() <em>Hints To Expand</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHintsToExpand()
	 * @generated
	 * @ordered
	 */
	protected EList<ExpandableHint> hintsToExpand;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappedAttributeValueExpanderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.MAPPED_ATTRIBUTE_VALUE_EXPANDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ExpandableHint> getHintsToExpand() {
		if (hintsToExpand == null) {
			hintsToExpand = new EObjectResolvingEList<ExpandableHint>(ExpandableHint.class, this, MappingPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND);
		}
		return hintsToExpand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SourceSectionAttribute getSourceAttribute() {
		if(this instanceof LocalMappedAttributeValueExpander) {
			return ((LocalMappedAttributeValueExpander) this).getSource();
		} else if(this instanceof ExternalMappedAttributeValueExpander) {
			return ((ExternalMappedAttributeValueExpander) this).getSource();
		} else {
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND:
				return getHintsToExpand();
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
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND:
				getHintsToExpand().clear();
				getHintsToExpand().addAll((Collection<? extends ExpandableHint>)newValue);
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
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND:
				getHintsToExpand().clear();
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
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND:
				return hintsToExpand != null && !hintsToExpand.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_SOURCE_ATTRIBUTE:
				return getSourceAttribute();
		}
		return super.eInvoke(operationID, arguments);
	}

} //MappedAttributeValueExpanderImpl
