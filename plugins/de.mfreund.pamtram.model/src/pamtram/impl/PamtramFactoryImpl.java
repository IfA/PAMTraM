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
package pamtram.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import pamtram.*;
import pamtram.MappingModel;
import pamtram.PAMTraM;
import pamtram.PamtramFactory;
import pamtram.PamtramPackage;
import pamtram.SourceSectionModel;
import pamtram.TargetSectionModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PamtramFactoryImpl extends EFactoryImpl implements PamtramFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PamtramFactory init() {
		try {
			PamtramFactory thePamtramFactory = (PamtramFactory)EPackage.Registry.INSTANCE.getEFactory(PamtramPackage.eNS_URI);
			if (thePamtramFactory != null) {
				return thePamtramFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PamtramFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PamtramFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case PamtramPackage.PAM_TRA_M: return createPAMTraM();
			case PamtramPackage.SOURCE_SECTION_MODEL: return createSourceSectionModel();
			case PamtramPackage.TARGET_SECTION_MODEL: return createTargetSectionModel();
			case PamtramPackage.MAPPING_MODEL: return createMappingModel();
			case PamtramPackage.CONDITION_MODEL: return createConditionModel();
			case PamtramPackage.FIXED_VALUE: return createFixedValue();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PAMTraM createPAMTraM() {
		PAMTraMImpl pamTraM = new PAMTraMImpl();
		return pamTraM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionModel createSourceSectionModel() {
		SourceSectionModelImpl sourceSectionModel = new SourceSectionModelImpl();
		return sourceSectionModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionModel createTargetSectionModel() {
		TargetSectionModelImpl targetSectionModel = new TargetSectionModelImpl();
		return targetSectionModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingModel createMappingModel() {
		MappingModelImpl mappingModel = new MappingModelImpl();
		return mappingModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionModel createConditionModel() {
		ConditionModelImpl conditionModel = new ConditionModelImpl();
		return conditionModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FixedValue createFixedValue() {
		FixedValueImpl fixedValue = new FixedValueImpl();
		return fixedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PamtramPackage getPamtramPackage() {
		return (PamtramPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PamtramPackage getPackage() {
		return PamtramPackage.eINSTANCE;
	}

} //PamtramFactoryImpl
