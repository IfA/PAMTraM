/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 */
package pamtram.mapping.extended.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import pamtram.mapping.extended.ExpandableHint;
import pamtram.mapping.extended.ExtendedPackage;
import pamtram.mapping.extended.ExternalMappedAttributeValueExpander;
import pamtram.mapping.extended.HintImporterMappingHint;
import pamtram.mapping.extended.LocalMappedAttributeValueExpander;
import pamtram.mapping.extended.MappedAttributeValueExpander;
import pamtram.mapping.extended.MappingHintBaseType;
import pamtram.mapping.extended.MappingHintType;
import pamtram.structure.impl.ExternalDynamicSourceElementImpl;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Mapped Attribute Value Expander</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.extended.impl.ExternalMappedAttributeValueExpanderImpl#getHintsToExpand <em>Hints To Expand</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ExternalMappedAttributeValueExpanderImpl extends ExternalDynamicSourceElementImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> implements ExternalMappedAttributeValueExpander {
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
	protected ExternalMappedAttributeValueExpanderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExtendedPackage.Literals.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ExpandableHint> getHintsToExpand() {
	
		if (hintsToExpand == null) {
			hintsToExpand = new EObjectResolvingEList<ExpandableHint>(ExpandableHint.class, this, ExtendedPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND);
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
			case ExtendedPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND:
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
			case ExtendedPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND:
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
			case ExtendedPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND:
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
			case ExtendedPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND:
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == MappingHintBaseType.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == MappingHintType.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == HintImporterMappingHint.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == MappedAttributeValueExpander.class) {
			switch (derivedFeatureID) {
				case ExtendedPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND: return ExtendedPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == MappingHintBaseType.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == MappingHintType.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == HintImporterMappingHint.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == MappedAttributeValueExpander.class) {
			switch (baseFeatureID) {
				case ExtendedPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND: return ExtendedPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == MappingHintBaseType.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == MappingHintType.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == HintImporterMappingHint.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == MappedAttributeValueExpander.class) {
			switch (baseOperationID) {
				case ExtendedPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_SOURCE_ATTRIBUTE: return ExtendedPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_SOURCE_ATTRIBUTE;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ExtendedPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_SOURCE_ATTRIBUTE:
				return getSourceAttribute();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ExternalMappedAttributeValueExpanderImpl
